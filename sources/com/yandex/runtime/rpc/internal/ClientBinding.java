package com.yandex.runtime.rpc.internal;

import androidx.annotation.NonNull;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.rpc.Client;
public class ClientBinding implements Client {
    private final NativeObject nativeObject;

    public ClientBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.runtime.rpc.Client
    public native void handle(@NonNull byte[] bArr);
}
