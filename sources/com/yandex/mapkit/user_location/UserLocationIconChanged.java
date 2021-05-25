package com.yandex.mapkit.user_location;

import androidx.annotation.NonNull;
import com.yandex.mapkit.layers.ObjectEvent;
public interface UserLocationIconChanged extends ObjectEvent {
    @NonNull
    UserLocationIconType getIconType();
}
