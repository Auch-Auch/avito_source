package com.yandex.mapkit.user_location.internal;

import androidx.annotation.NonNull;
import com.yandex.mapkit.layers.internal.ObjectEventBinding;
import com.yandex.mapkit.user_location.UserLocationIconChanged;
import com.yandex.mapkit.user_location.UserLocationIconType;
import com.yandex.runtime.NativeObject;
public class UserLocationIconChangedBinding extends ObjectEventBinding implements UserLocationIconChanged {
    public UserLocationIconChangedBinding(NativeObject nativeObject) {
        super(nativeObject);
    }

    @Override // com.yandex.mapkit.user_location.UserLocationIconChanged
    @NonNull
    public native UserLocationIconType getIconType();
}
