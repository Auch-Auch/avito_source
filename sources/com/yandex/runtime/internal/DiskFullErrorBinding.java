package com.yandex.runtime.internal;

import com.yandex.runtime.DiskFullError;
import com.yandex.runtime.NativeObject;
public class DiskFullErrorBinding extends LocalErrorBinding implements DiskFullError {
    public DiskFullErrorBinding(NativeObject nativeObject) {
        super(nativeObject);
    }
}
