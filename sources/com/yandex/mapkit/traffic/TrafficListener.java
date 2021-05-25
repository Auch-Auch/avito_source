package com.yandex.mapkit.traffic;

import androidx.annotation.Nullable;
public interface TrafficListener {
    void onTrafficChanged(@Nullable TrafficLevel trafficLevel);

    void onTrafficExpired();

    void onTrafficLoading();
}
