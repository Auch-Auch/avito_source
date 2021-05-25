package com.yandex.mapkit.road_events;

import androidx.annotation.NonNull;
import com.yandex.mapkit.GeoObject;
import com.yandex.runtime.Error;
public interface RoadEventSession {

    public interface RoadEventListener {
        void onRoadEventError(@NonNull Error error);

        void onRoadEventReceived(@NonNull GeoObject geoObject);
    }

    void cancel();

    void retry(@NonNull RoadEventListener roadEventListener);
}
