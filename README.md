# NyTask
NT times is a simple news app that presents news in a friendly list that leads you to details screen by one click, just connect to internet and be in the eye of the hurricane.


# Features
App Built with :
* MVVM Design Architecture
* Kotlin language
* Object oriented programming
* Simple clean Code

The android app lets you:
* View updated news
* read full articles
*	Dark and Light Mode based on System Mode (Eye Comforte)

# Screenshots
Main Activity            |  Detailed Activity
:-------------------------:|:-------------------------:
![](https://github.com/ahmedhassan2017/NyTimes/blob/master/app/src/main/res/drawable/screen1.jpeg)  |  ![](https://github.com/ahmedhassan2017/NyTimes/blob/master/app/src/main/res/drawable/screen2.jpeg)

# Permissions
* Network Access state.
* internet permission.

# Code Example
 Code snippet checks the internet connection
 ```
 fun InternetConnected(): Boolean {
    val connectivityManager =
        getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)!!.state == NetworkInfo.State.CONNECTED ||
        connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)!!.state == NetworkInfo.State.CONNECTED
    ) {
        //we are connected to a network
        true
    } else {
        false
    }
}

```
For security Api key is stored in gradle.properties
```
defaultConfig {
    applicationId "com.example.nytimes"
    minSdkVersion 21
    targetSdkVersion 30
    versionCode 1
    versionName "1.0"
    buildConfigField("String", "API_KEY", API_KEY)
    testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
}
```
libiraries and dependancies that used
```
// Retrofit
implementation "com.squareup.retrofit2:retrofit:2.6.2"
implementation 'com.squareup.retrofit2:converter-gson:2.4.0'
// ViewModel
implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
// LiveData
implementation "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"
//recyclerview
implementation 'com.android.support:recyclerview-v7:30.0.0'
//cardview
implementation 'com.android.support:cardview-v7:30.0.0'
implementation 'de.hdodenhof:circleimageview:3.1.0'
// picasso
implementation 'com.squareup.picasso:picasso:2.71828'
// truth
testImplementation "com.google.truth:truth:1.0.1"
androidTestImplementation "com.google.truth:truth:1.0.1"
//Mockk
testImplementation "io.mockk:mockk:1.9.3"
androidTestImplementation 'android.arch.core:core-testing:1.1.1'

```
## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.


