# My favourite restaurants 
#### Application which serves you to explore the nearest restaurants and save the ones you liked the most. 
#### Table of content
- [About](#about)
- [Visuals](#visuals)
- [Technologies](#technologies)
- [Contact](#contact)
## About
This application was designed for a student project in Android. The target group of this app are foodies, who have a passion of exploring every restaurant in the nearby. 
## Visuals
A lot of effort was put to the visual side of the application. First, it was deisgned in the Adobe XD, which was very hepful, when it comes to designing in Android Studio. A custom font was implemented as well as custom buttons and Edit Texts. Backgrounds, every one of them is different for every activity, were also designed in Adobe XD and implemented in Android Studio. 

<img src="/screenshots/alert.png" width="200px" /> <img src="/screenshots/logowanie.png" width="200px" /> <img src="/screenshots/hello.png" width="200px" /> <img src="/screenshots/map.png" width="200px" />
## Technologies
* Adobe XD
* Adobe Fonts
* Android Studio 
* Android SDK
* Firebase Authentication
* Firebase Databse
* Google Maps
* Google Services
## Code examples 
When it comes to custom buttons and input fields, new xml files were created with code, which you can see below. 
```xml
<shape android:shape="rectangle" xmlns:android="http://schemas.android.com/apk/res/android">
    <corners android:radius="50sp"/>
    <solid android:color="@color/lightBeige"/>
</shape>
```
So that later in the layout xml file it could be reffered to as:
```xml 
        android:background="@drawable/input"
```
Same thing goes for the custom font. A new folder was created in the res folder called 'font', where I put the Hobo font, so I could refer to it. 
```xml 
        android:fontFamily="@font/hobo"
```
The biggest challenge I faced was the list functionality. 
```java

    

 ```
 
 ## Contact 
 Made by @jcieszynska
