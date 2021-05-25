package com.yandex.mapkit.location.internal;

import androidx.annotation.NonNull;
import com.yandex.mapkit.location.FilteringMode;
import com.yandex.mapkit.location.LocationListener;
import com.yandex.mapkit.location.LocationManager;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.subscription.Subscription;
public class LocationManagerBinding implements LocationManager {
    private Subscription<LocationListener> locationListenerSubscription = new Subscription<LocationListener>() { // from class: com.yandex.mapkit.location.internal.LocationManagerBinding.1
        public NativeObject createNativeListener(LocationListener locationListener) {
            return LocationManagerBinding.createLocationListener(locationListener);
        }
    };
    private final NativeObject nativeObject;

    public LocationManagerBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    /* access modifiers changed from: private */
    public static native NativeObject createLocationListener(LocationListener locationListener);

    @Override // com.yandex.mapkit.location.LocationManager
    public native void requestSingleUpdate(@NonNull LocationListener locationListener);

    @Override // com.yandex.mapkit.location.LocationManager
    public native void resume();

    @Override // com.yandex.mapkit.location.LocationManager
    public native void subscribeForLocationUpdates(double d, long j, double d2, boolean z, @NonNull FilteringMode filteringMode, @NonNull LocationListener locationListener);

    @Override // com.yandex.mapkit.location.LocationManager
    public native void suspend();

    @Override // com.yandex.mapkit.location.LocationManager
    public native void unsubscribe(@NonNull LocationListener locationListener);
}
