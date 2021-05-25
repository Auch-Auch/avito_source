package com.yandex.mapkit.user_location;

import androidx.annotation.NonNull;
import com.yandex.mapkit.layers.ObjectEvent;
public interface UserLocationObjectListener {
    void onObjectAdded(@NonNull UserLocationView userLocationView);

    void onObjectRemoved(@NonNull UserLocationView userLocationView);

    void onObjectUpdated(@NonNull UserLocationView userLocationView, @NonNull ObjectEvent objectEvent);
}
