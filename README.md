# Hướng dẫn triển khai Google Maps trong Android Studio

Step 1: Nhận một khóa API Google Maps từ Google Cloud Console. (https://console.cloud.google.com)
Step 2: Thêm API Key vào project.

```xml
<application
        ...
        >
        <meta-data
            android:name="com.google.android.geo.API_KEY"
            android:value="@string/google_map_api_key" />
</application>
```
Step 3: Thêm dependency của Google Play services trong tệp build.gradle của ứng dụng:
```xml
implementation 'com.google.android.gms:play-services-maps:18.1.0'
```
3. Thêm các quyền cần thiết vào tệp AndroidManifest.xml:
```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
```
4. Thêm một 'fragment' vào file layout.mxl của ứng dụng:
```xml
<fragment
        android:id="@+id/store_map_fragment"
        android:name="com.google.android.gms.maps.SupportMapFragment"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        />
```

