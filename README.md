[![mm_header.jpg](https://s16.postimg.org/674mqlohx/mm_header.jpg)](https://postimg.org/image/dzvaikugx/)

# android-admob
Android app example integration with mobile app monetization with [Admob](https://www.google.com/admob/) using simple banner and interstitial (full-screen ads that cover the interface of their host app).

[![Simple banner](https://s25.postimg.org/x09heoanz/simple_Banner.jpg)](https://firebase.google.com/docs/admob/android/banner)  [![Interstitial](https://s25.postimg.org/49cnom4u7/interstitial.jpg)](https://firebase.google.com/docs/admob/android/interstitial)

## Dependencies
[Firebase ads](https://codelabs.developers.google.com/codelabs/firebase-android/#13)  is a mobile platform that helps you quickly develop high-quality apps, grow an engaged user base, and earn more money.

[Butter Knife](http://jakewharton.github.io/butterknife/) Field and method binding for Android views which uses annotation processing to generate boilerplate code for you.
```swift
Gradle
//Butterknife Field and method binding for Android views which uses annotation processing to generate boilerplate code for you. (Not necessary)
compile 'com.jakewharton:butterknife:8.5.1'
annotationProcessor 'com.jakewharton:butterknife-compiler:8.5.1'

// For Firebase
compile 'com.google.firebase:firebase-ads:10.2.0'
```

### Plugins
This example use extended with the following plugins. Instructions on how to use them in your own application are linked below.

| Plugin | README | DESCRIPTION
| ------ | ------ | ------ |
| ButterKnifeZelezny |[butterknife-zelezny/]( https://github.com/avast/android-butterknife-zelezny/)  | Simple plug-in for Android Studio/IDEA that allows one-click creation of Butterknife view injections.


## Installation and configuration
- Clone the project
- Add unit_id for the banner and the interstitial  in your string.xml file
```swift
    <string name="banner_ad_unit_id">ca-app-pub-XXXXXXXXXXXXXXXX/XXXXXXXXXX</string>
    <string name="interstitial_ad_unit_id">ca-app-pub-XXXXXXXXXXXXXXXX/XXXXXXXXXX</string>
```

## License

This project is is available under the MIT License, Version 2.0 e. See the LICENSE file for more info. Attribution by linking to the [project page](https://github.com/RomeRock/ios-calculator) is appreciated.


<div>
<a href="http://romerock.com"> <img style="max-width: 100%; margin:7" src="https://avatars3.githubusercontent.com/u/23345883?v=3&s=200=true" alt="Google Play" height="50px" /> </a>
<a href="https://www.facebook.com/romerockapps/?ref=page_internal"> <img style="max-width: 100%; margin:7" src="https://s18.postimg.org/6sjokzpd5/facebook_icon.png=true" alt="Google Play" height="50px" /> </a>
<a href="https://twitter.com/romerock_apps"> <img style="max-width: 100%; margin:7" src="https://s18.postimg.org/w2eg82w4p/twitter_icon.png=true" alt="Google Play" height="50px" /></a>
<a href="https://play.google.com/store/apps/dev?id=5841338539930209563"> <img style="max-width: 100%; margin:7" src="https://s18.postimg.org/n29unw015/android_icon.png=true" alt="Google Play" height="50px" /></a>
<a href="https://itunes.apple.com/us/developer/rome-rock-llc/id1190244007"> <img style="max-width: 100%; margin:7" src="https://s18.postimg.org/leap98m5l/ios_icon.png=true" alt="Google Play" height="50px" /></a>
<a href="https://github.com/RomeRock"> <img style="max-width: 100%; margin:7" src="https://s18.postimg.org/wpdcxlt0p/github_icon.png=true" alt="Google Play" height="50px" /></a>
<a href="https://www.youtube.com/channel/UCcSLNuTYC7qJhOKQ4CpseRA"> <img style="max-width: 100%; margin:7" src="https://s18.postimg.org/w4ybuwzs9/youtube_icon.png=true" alt="Google Play" height="50px" /></a>
</div>
