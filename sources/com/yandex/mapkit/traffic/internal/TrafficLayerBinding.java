package com.yandex.mapkit.traffic.internal;

import androidx.annotation.NonNull;
import com.yandex.mapkit.road_events.EventType;
import com.yandex.mapkit.traffic.TrafficLayer;
import com.yandex.mapkit.traffic.TrafficListener;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.subscription.Subscription;
public class TrafficLayerBinding implements TrafficLayer {
    private final NativeObject nativeObject;
    private Subscription<TrafficListener> trafficListenerSubscription = new Subscription<TrafficListener>() { // from class: com.yandex.mapkit.traffic.internal.TrafficLayerBinding.1
        public NativeObject createNativeListener(TrafficListener trafficListener) {
            return TrafficLayerBinding.createTrafficListener(trafficListener);
        }
    };

    public TrafficLayerBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    /* access modifiers changed from: private */
    public static native NativeObject createTrafficListener(TrafficListener trafficListener);

    @Override // com.yandex.mapkit.traffic.TrafficLayer
    public native void addTrafficListener(@NonNull TrafficListener trafficListener);

    @Override // com.yandex.mapkit.traffic.TrafficLayer
    public native boolean isRoadEventVisible(@NonNull EventType eventType);

    @Override // com.yandex.mapkit.traffic.TrafficLayer
    public native boolean isTrafficVisible();

    @Override // com.yandex.mapkit.traffic.TrafficLayer
    public native boolean isValid();

    @Override // com.yandex.mapkit.traffic.TrafficLayer
    public native void removeTrafficListener(@NonNull TrafficListener trafficListener);

    @Override // com.yandex.mapkit.traffic.TrafficLayer
    public native void resetRoadEventsStyles();

    @Override // com.yandex.mapkit.traffic.TrafficLayer
    public native void resetTrafficStyles();

    @Override // com.yandex.mapkit.traffic.TrafficLayer
    public native void setRoadEventVisible(@NonNull EventType eventType, boolean z);

    @Override // com.yandex.mapkit.traffic.TrafficLayer
    public native boolean setRoadEventsStyle(int i, @NonNull String str);

    @Override // com.yandex.mapkit.traffic.TrafficLayer
    public native boolean setRoadEventsStyle(@NonNull String str);

    @Override // com.yandex.mapkit.traffic.TrafficLayer
    public native boolean setTrafficStyle(int i, @NonNull String str);

    @Override // com.yandex.mapkit.traffic.TrafficLayer
    public native boolean setTrafficStyle(@NonNull String str);

    @Override // com.yandex.mapkit.traffic.TrafficLayer
    public native void setTrafficVisible(boolean z);
}
