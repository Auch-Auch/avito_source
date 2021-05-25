package com.yandex.runtime.subscription;

import com.yandex.runtime.NativeObject;
import java.util.Map;
import java.util.WeakHashMap;
public abstract class Subscription<Listener> {
    private Map<Listener, NativeObject> storage = new WeakHashMap();

    public abstract NativeObject createNativeListener(Listener listener);

    public NativeObject get(Listener listener) {
        NativeObject nativeObject = this.storage.get(listener);
        if (nativeObject == null && listener != null) {
            nativeObject = createNativeListener(listener);
        }
        this.storage.put(listener, nativeObject);
        return nativeObject;
    }
}
