package com.yandex.mapkit.location.internal;

import com.yandex.mapkit.location.LocationViewSource;
import com.yandex.runtime.NativeObject;
public class LocationViewSourceBinding implements LocationViewSource {
    private final NativeObject nativeObject;

    public LocationViewSourceBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }
}
