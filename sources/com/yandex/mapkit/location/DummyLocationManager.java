package com.yandex.mapkit.location;

import androidx.annotation.NonNull;
public interface DummyLocationManager extends LocationManager {
    void setLocation(@NonNull Location location);
}
