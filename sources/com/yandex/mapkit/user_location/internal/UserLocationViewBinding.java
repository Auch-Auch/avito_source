package com.yandex.mapkit.user_location.internal;

import androidx.annotation.NonNull;
import com.yandex.mapkit.map.CircleMapObject;
import com.yandex.mapkit.map.PlacemarkMapObject;
import com.yandex.mapkit.user_location.UserLocationView;
import com.yandex.runtime.NativeObject;
public class UserLocationViewBinding implements UserLocationView {
    private final NativeObject nativeObject;

    public UserLocationViewBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.mapkit.user_location.UserLocationView
    @NonNull
    public native CircleMapObject getAccuracyCircle();

    @Override // com.yandex.mapkit.user_location.UserLocationView
    @NonNull
    public native PlacemarkMapObject getArrow();

    @Override // com.yandex.mapkit.user_location.UserLocationView
    @NonNull
    public native PlacemarkMapObject getPin();

    @Override // com.yandex.mapkit.user_location.UserLocationView
    public native boolean isValid();
}
