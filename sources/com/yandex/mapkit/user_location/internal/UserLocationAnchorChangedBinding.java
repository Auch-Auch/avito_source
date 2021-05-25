package com.yandex.mapkit.user_location.internal;

import androidx.annotation.NonNull;
import com.yandex.mapkit.layers.internal.ObjectEventBinding;
import com.yandex.mapkit.user_location.UserLocationAnchorChanged;
import com.yandex.mapkit.user_location.UserLocationAnchorType;
import com.yandex.runtime.NativeObject;
public class UserLocationAnchorChangedBinding extends ObjectEventBinding implements UserLocationAnchorChanged {
    public UserLocationAnchorChangedBinding(NativeObject nativeObject) {
        super(nativeObject);
    }

    @Override // com.yandex.mapkit.user_location.UserLocationAnchorChanged
    @NonNull
    public native UserLocationAnchorType getAnchorType();
}
