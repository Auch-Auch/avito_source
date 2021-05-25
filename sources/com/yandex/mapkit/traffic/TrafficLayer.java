package com.yandex.mapkit.traffic;

import androidx.annotation.NonNull;
import com.yandex.mapkit.road_events.EventType;
public interface TrafficLayer {
    void addTrafficListener(@NonNull TrafficListener trafficListener);

    boolean isRoadEventVisible(@NonNull EventType eventType);

    boolean isTrafficVisible();

    boolean isValid();

    void removeTrafficListener(@NonNull TrafficListener trafficListener);

    void resetRoadEventsStyles();

    void resetTrafficStyles();

    void setRoadEventVisible(@NonNull EventType eventType, boolean z);

    boolean setRoadEventsStyle(int i, @NonNull String str);

    boolean setRoadEventsStyle(@NonNull String str);

    boolean setTrafficStyle(int i, @NonNull String str);

    boolean setTrafficStyle(@NonNull String str);

    void setTrafficVisible(boolean z);
}
