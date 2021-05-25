package com.yandex.mapkit.location.internal;

import androidx.annotation.NonNull;
import com.yandex.mapkit.geometry.Polyline;
import com.yandex.mapkit.geometry.PolylinePosition;
import com.yandex.mapkit.location.LocationSimulator;
import com.yandex.mapkit.location.LocationSimulatorListener;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.subscription.Subscription;
public class LocationSimulatorBinding extends LocationManagerBinding implements LocationSimulator {
    private Subscription<LocationSimulatorListener> locationSimulatorListenerSubscription = new Subscription<LocationSimulatorListener>() { // from class: com.yandex.mapkit.location.internal.LocationSimulatorBinding.1
        public NativeObject createNativeListener(LocationSimulatorListener locationSimulatorListener) {
            return LocationSimulatorBinding.createLocationSimulatorListener(locationSimulatorListener);
        }
    };

    public LocationSimulatorBinding(NativeObject nativeObject) {
        super(nativeObject);
    }

    /* access modifiers changed from: private */
    public static native NativeObject createLocationSimulatorListener(LocationSimulatorListener locationSimulatorListener);

    @Override // com.yandex.mapkit.location.LocationSimulator
    @NonNull
    public native Polyline getGeometry();

    @Override // com.yandex.mapkit.location.LocationSimulator
    @NonNull
    public native PolylinePosition getPolylinePosition();

    @Override // com.yandex.mapkit.location.LocationSimulator
    public native double getSpeed();

    @Override // com.yandex.mapkit.location.LocationSimulator
    public native boolean isActive();

    @Override // com.yandex.mapkit.location.LocationSimulator
    public native void setGeometry(@NonNull Polyline polyline);

    @Override // com.yandex.mapkit.location.LocationSimulator
    public native void setSpeed(double d);

    @Override // com.yandex.mapkit.location.LocationSimulator
    public native void subscribeForSimulatorEvents(@NonNull LocationSimulatorListener locationSimulatorListener);

    @Override // com.yandex.mapkit.location.LocationSimulator
    public native void unsubscribeFromSimulatorEvents(@NonNull LocationSimulatorListener locationSimulatorListener);
}
