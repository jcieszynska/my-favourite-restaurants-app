# My favourite restaurants 
#### Application which serves you to explore the nearest restaurants and save the ones you liked the most. 
#### Table of content
- [About](#about)
- [Visuals](#visuals)
- [Technologies](#technologies)
- [Status](#status)
- [Contact](#contact)
## About
This application was designed for a student project in Android. The target group of this app are foodies, who have a passion of exploring every restaurant in the nearby. 
## Visuals
A lot of effort was put to the visual side of the application. First, it was deisgned in the Adobe XD, which was very hepful, when it comes to designing in Android Studio. A custom font was implemented as well as custom buttons and Edit Texts. Backgrounds, every one of them is different for every activity, were also designed in Adobe XD and implemented in Android Studio. 

<img src="/screenshots/alert.png" width="200px" /> <img src="/screenshots/logowanie.png" width="200px" /> <img src="/screenshots/hello.png" width="200px" /> <img src="/screenshots/mapa.png" width="200px" /> <img src="/screenshots/lista.png" width="200px" /> <img src="/screenshots/list.png" width="200px" />
## Technologies
* Adobe XD
* Adobe Fonts
* Android Studio 
* Android SDK
* Firebase Authentication
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
The biggest challenge I faced was the list functionality. I used the geocodet enabling to resolve the location from latitude and longitude. Next, I made an address list using the geocoder with the latitude and longitude, in which the address is stored. Then, add the latitude and the longitude to the locations list from the ListMapsActivity, add the address to the places list from the ListMapsActivity and notify to the array adapter that the list has been changed. Finally, add the marker to the map.
```java
      mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
                List<Address> addressList = null;
                try {
                    addressList = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ListActivity.locations.add(latLng);
                ListActivity.places.add(addressList.get(0).getAddressLine(0));
                ListActivity.arrayAdapter.notifyDataSetChanged();
                mMap.addMarker(new MarkerOptions().position(latLng).title(addressList.get(0).getAddressLine(0)).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
            }
    

 ```
 
## Status 
Although, I am aware of a lot of shortcomings (such as the font of the list view, no registry for new users or the list could be saved in the cloud database) I decided to leave it as it is for the sake of the project. I am quite proud with the result that I have achieved. I'm happy with the knowledge that I gained during this project and it was also very interesting to mix it with UI designing. 
 
## Contact 
 Made by @jcieszynska
