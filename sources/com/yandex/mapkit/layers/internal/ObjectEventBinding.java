package com.yandex.mapkit.layers.internal;

import com.yandex.mapkit.layers.ObjectEvent;
import com.yandex.runtime.NativeObject;
public class ObjectEventBinding implements ObjectEvent {
    private final NativeObject nativeObject;

    public ObjectEventBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.mapkit.layers.ObjectEvent
    public native boolean isValid();
}
