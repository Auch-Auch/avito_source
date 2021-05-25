package com.yandex.mapkit.location;

import androidx.annotation.NonNull;
import com.yandex.mapkit.geometry.Polyline;
import com.yandex.mapkit.geometry.PolylinePosition;
public interface LocationSimulator extends LocationManager {
    @NonNull
    Polyline getGeometry();

    @NonNull
    PolylinePosition getPolylinePosition();

    double getSpeed();

    boolean isActive();

    void setGeometry(@NonNull Polyline polyline);

    void setSpeed(double d);

    void subscribeForSimulatorEvents(@NonNull LocationSimulatorListener locationSimulatorListener);

    void unsubscribeFromSimulatorEvents(@NonNull LocationSimulatorListener locationSimulatorListener);
}
