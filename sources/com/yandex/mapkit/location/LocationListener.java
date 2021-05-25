package com.yandex.mapkit.location;

import androidx.annotation.NonNull;
public interface LocationListener {
    void onLocationStatusUpdated(@NonNull LocationStatus locationStatus);

    void onLocationUpdated(@NonNull Location location);
}
