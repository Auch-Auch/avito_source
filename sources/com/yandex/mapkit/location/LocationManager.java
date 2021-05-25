package com.yandex.mapkit.location;

import androidx.annotation.NonNull;
public interface LocationManager {
    void requestSingleUpdate(@NonNull LocationListener locationListener);

    void resume();

    void subscribeForLocationUpdates(double d, long j, double d2, boolean z, @NonNull FilteringMode filteringMode, @NonNull LocationListener locationListener);

    void suspend();

    void unsubscribe(@NonNull LocationListener locationListener);
}
