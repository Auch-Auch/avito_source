package com.yandex.runtime.network.internal;

import com.yandex.runtime.NativeObject;
import com.yandex.runtime.network.RequestEntityTooLargeError;
public class RequestEntityTooLargeErrorBinding extends RemoteErrorBinding implements RequestEntityTooLargeError {
    public RequestEntityTooLargeErrorBinding(NativeObject nativeObject) {
        super(nativeObject);
    }
}
