package com.yandex.mapkit.user_location;

import androidx.annotation.NonNull;
import com.yandex.mapkit.geometry.Point;
public interface UserLocationTapListener {
    void onUserLocationObjectTap(@NonNull Point point);
}
