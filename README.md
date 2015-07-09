Tournament SDK for Android
============================
Tournament SDK enables your users to track and compare their game scores on a leaderboard within their social network.

Installation
------------

### Using Android Studio or Gradle
   Add `sdk` to the `dependencies` section in your `build.gradle`:

   ```gradle
   compile 'com.gamepop.tournament.sdk.android:sdk:1.1.1'
   ```
   Note: Requires Android API 9.


Configuring Your Pair Of GAME_KEY and AndroidManifest
-----------------------------------------------------
-   In order to generate a pair of GAME_KEY, you need to provide us a hash of your release key and your package name. Run the following on Mac or Windows substituting your release key alias and the path to your keystore. On OS X, run:

    ```sh
    keytool -exportcert -alias <RELEASE_KEY_ALIAS> -keystore <RELEASE_KEY_PATH> | openssl sha1 -binary | openssl base64	
    ``` 
    On Windows, use:
    ```
    keytool -exportcert -alias <RELEASE_KEY_ALIAS> -keystore <RELEASE_KEY_PATH> | openssl sha1 -binary | openssl base64
    ```

    This command should generate a 28 characher string. We would need this string along with your package name to produce a pair of GAME_KEY

    We will be generating a pair of GAME_KEY. For e.g.
    * live:6153c00f34ad43b9d2e0215add83bdfe10e2c8e8
    * sandbox:62df741f6236c3209f08d9b2102edd981c907b95

    The live GAME_KEY should be used _only_ when you are about to release your game in production. For internal testing always use sandbox GAME_KEY

-   Configure your GAME_KEY as `meta-data` in your manifest's `<application>` tag:
    ```xml
    <application ...>
    	<meta-data android:name="com.gamepop.tournament.sdk.GAME_KEY" android:value="your-game-key-here"/>
    </application>
    ```
    Note: You need to provide either the live or the sandbox GAME_KEY in your manifest. If you have provided a sandbox GAME_KEY, all the in game leaderboards will be watermarked to indicate that you are running a sanboxed version of the tournament.

-   Enable the `INTERNET` and `SYSTEM_ALERT_WINDOW` permissions:

    ```xml
    <!-- Required: Used to deliver score data -->
    <uses-permission android:name="android.permission.INTERNET"/>
    <!-- Optional: Used to show UI to user -->
    <uses-permission android:name="android.permission.SYSTEM_ALERT_WINDOW" />
    ```

Initializing Tournament SDK
---------------------------

-   Import the `TSDK` java class in your subclass:

    ```java
    import com.gamepop.tournament.sdk.android.TSDK;
    ```

-   In your application's `onCreate` function, initialize Tournament SDK:

    ```java
    TSDK.init(this);
    ```


Posting scores to Tournament cloud
----------------------------------

### With user score only
- Post it to the Tournament cloud:

   ```java
   TSDK.postScore(200);
   ```

### With user score and game (or score) meta data
-  Place all the game (or score) related meta data into a HashMap:

   ```java
   HashMap<String, Object> gameData = new HashMap<String, Object>();
   gameData.put("name", "Gamepop Dev");
   gameData.put("duration_secs", 20);
   gameData.put("premium", false);
   ```

-  Post it to the Tournament cloud:

   ```java
   TSDK.postScore(200, gameData);
   ```
