package com.yandex.mapkit.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yandex.mapkit.MapKit;
import com.yandex.mapkit.StyleType;
import com.yandex.mapkit.coverage.Coverage;
import com.yandex.mapkit.experiments.UiExperimentsManager;
import com.yandex.mapkit.geometry.Polyline;
import com.yandex.mapkit.location.DummyLocationManager;
import com.yandex.mapkit.location.LocationManager;
import com.yandex.mapkit.location.LocationSimulator;
import com.yandex.mapkit.map.MapWindow;
import com.yandex.mapkit.offline_cache.OfflineCacheManager;
import com.yandex.mapkit.personalized_poi.PersonalizedPoiLayer;
import com.yandex.mapkit.road_events.RoadEventsManager;
import com.yandex.mapkit.storage.StorageManager;
import com.yandex.mapkit.traffic.TrafficLayer;
import com.yandex.mapkit.user_location.UserLocationLayer;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.auth.Account;
import com.yandex.runtime.init.MiidManager;
import com.yandex.runtime.view.PlatformGLView;
public class MapKitBinding implements MapKit {
    private final NativeObject nativeObject;

    public MapKitBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.mapkit.MapKit
    @NonNull
    public native Coverage createCoverage(@NonNull String str);

    @Override // com.yandex.mapkit.MapKit
    @NonNull
    public native DummyLocationManager createDummyLocationManager();

    @Override // com.yandex.mapkit.MapKit
    @NonNull
    public native LocationManager createLbsLocationManager();

    @Override // com.yandex.mapkit.MapKit
    @NonNull
    public native LocationManager createLocationManager();

    @Override // com.yandex.mapkit.MapKit
    @NonNull
    public native LocationSimulator createLocationSimulator(@NonNull Polyline polyline);

    @Override // com.yandex.mapkit.MapKit
    @NonNull
    public native MapWindow createMapWindow(@NonNull PlatformGLView platformGLView);

    @Override // com.yandex.mapkit.MapKit
    @NonNull
    public native MapWindow createMapWindow(@NonNull PlatformGLView platformGLView, float f);

    @Override // com.yandex.mapkit.MapKit
    @NonNull
    public native PersonalizedPoiLayer createPersonalizedPoiLayer(@NonNull MapWindow mapWindow);

    @Override // com.yandex.mapkit.MapKit
    @NonNull
    public native RoadEventsManager createRoadEventsManager();

    @Override // com.yandex.mapkit.MapKit
    @NonNull
    public native TrafficLayer createTrafficLayer(@NonNull MapWindow mapWindow);

    @Override // com.yandex.mapkit.MapKit
    @NonNull
    public native UserLocationLayer createUserLocationLayer(@NonNull MapWindow mapWindow);

    @Override // com.yandex.mapkit.MapKit
    @NonNull
    public native MiidManager getMiidManager();

    @Override // com.yandex.mapkit.MapKit
    @NonNull
    public native OfflineCacheManager getOfflineCacheManager();

    @Override // com.yandex.mapkit.MapKit
    @NonNull
    public native StorageManager getStorageManager();

    @Override // com.yandex.mapkit.MapKit
    @NonNull
    public native UiExperimentsManager getUiExperimentsManager();

    @Override // com.yandex.mapkit.MapKit
    @NonNull
    public native String getVersion();

    @Override // com.yandex.mapkit.MapKit
    public native boolean isValid();

    @Override // com.yandex.mapkit.MapKit
    public native void onStart();

    @Override // com.yandex.mapkit.MapKit
    public native void onStop();

    @Override // com.yandex.mapkit.MapKit
    public native void setAccount(@Nullable Account account);

    @Override // com.yandex.mapkit.MapKit
    public native void setAdvertisingId(@NonNull String str);

    @Override // com.yandex.mapkit.MapKit
    public native void setApiKey(@NonNull String str);

    @Override // com.yandex.mapkit.MapKit
    public native void setMetricaIds(@NonNull String str, @NonNull String str2);

    @Override // com.yandex.mapkit.MapKit
    public native void setScaleFactor(float f);

    @Override // com.yandex.mapkit.MapKit
    public native void setStyleType(@NonNull StyleType styleType);
}
