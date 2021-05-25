package com.yandex.runtime.internal;

import com.yandex.runtime.DiskCorruptError;
import com.yandex.runtime.NativeObject;
public class DiskCorruptErrorBinding extends LocalErrorBinding implements DiskCorruptError {
    public DiskCorruptErrorBinding(NativeObject nativeObject) {
        super(nativeObject);
    }
}
