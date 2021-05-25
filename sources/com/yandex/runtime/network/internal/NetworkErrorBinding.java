package com.yandex.runtime.network.internal;

import com.yandex.runtime.NativeObject;
import com.yandex.runtime.internal.ErrorBinding;
import com.yandex.runtime.network.NetworkError;
public class NetworkErrorBinding extends ErrorBinding implements NetworkError {
    public NetworkErrorBinding(NativeObject nativeObject) {
        super(nativeObject);
    }
}
