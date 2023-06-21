# Hướng dẫn triển khai Google Maps trong Android Studio

1. Nhận một khóa API Google Maps từ Google Cloud Console. (https://console.cloud.google.com)
2. Thêm phụ thuộc vào Google Play services trong tệp build.gradle của ứng dụng:
('implementation 'com.google.android.gms:play-services-maps:18.1.0''')
3. Thêm các quyền cần thiết vào tệp AndroidManifest.xml:

```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
5. Thêm một 'fragment' vào file layout.mxl của ứng dụng
<fragment
        android:id="@+id/store_map_fragment"
        android:name="com.google.android.gms.maps.SupportMapFragment"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        />

