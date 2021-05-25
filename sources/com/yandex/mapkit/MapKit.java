package com.yandex.mapkit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.yandex.runtime.auth.Account;
import com.yandex.runtime.init.MiidManager;
import com.yandex.runtime.view.PlatformGLView;
public interface MapKit {
    @NonNull
    Coverage createCoverage(@NonNull String str);

    @NonNull
    DummyLocationManager createDummyLocationManager();

    @NonNull
    LocationManager createLbsLocationManager();

    @NonNull
    LocationManager createLocationManager();

    @NonNull
    LocationSimulator createLocationSimulator(@NonNull Polyline polyline);

    @NonNull
    MapWindow createMapWindow(@NonNull PlatformGLView platformGLView);

    @NonNull
    MapWindow createMapWindow(@NonNull PlatformGLView platformGLView, float f);

    @NonNull
    PersonalizedPoiLayer createPersonalizedPoiLayer(@NonNull MapWindow mapWindow);

    @NonNull
    RoadEventsManager createRoadEventsManager();

    @NonNull
    TrafficLayer createTrafficLayer(@NonNull MapWindow mapWindow);

    @NonNull
    UserLocationLayer createUserLocationLayer(@NonNull MapWindow mapWindow);

    @NonNull
    MiidManager getMiidManager();

    @NonNull
    OfflineCacheManager getOfflineCacheManager();

    @NonNull
    StorageManager getStorageManager();

    @NonNull
    UiExperimentsManager getUiExperimentsManager();

    @NonNull
    String getVersion();

    boolean isValid();

    void onStart();

    void onStop();

    void setAccount(@Nullable Account account);

    void setAdvertisingId(@NonNull String str);

    void setApiKey(@NonNull String str);

    void setMetricaIds(@NonNull String str, @NonNull String str2);

    void setScaleFactor(float f);

    void setStyleType(@NonNull StyleType styleType);
}
