package com.yandex.runtime.internal;

import com.yandex.runtime.Error;
import com.yandex.runtime.NativeObject;
public class ErrorBinding implements Error {
    private final NativeObject nativeObject;

    public ErrorBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.runtime.Error
    public native boolean isValid();
}
