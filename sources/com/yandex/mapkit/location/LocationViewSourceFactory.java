package com.yandex.mapkit.location;

import androidx.annotation.NonNull;
public class LocationViewSourceFactory {
    @NonNull
    public static native LocationViewSource createLocationViewSource(@NonNull LocationManager locationManager);
}
