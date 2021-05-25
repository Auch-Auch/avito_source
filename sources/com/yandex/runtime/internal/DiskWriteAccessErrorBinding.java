package com.yandex.runtime.internal;

import com.yandex.runtime.DiskWriteAccessError;
import com.yandex.runtime.NativeObject;
public class DiskWriteAccessErrorBinding extends DiskCorruptErrorBinding implements DiskWriteAccessError {
    public DiskWriteAccessErrorBinding(NativeObject nativeObject) {
        super(nativeObject);
    }
}
