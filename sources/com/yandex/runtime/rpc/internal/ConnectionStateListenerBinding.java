package com.yandex.runtime.rpc.internal;

import com.yandex.runtime.NativeObject;
import com.yandex.runtime.rpc.ConnectionStateListener;
public class ConnectionStateListenerBinding implements ConnectionStateListener {
    private final NativeObject nativeObject;

    public ConnectionStateListenerBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.runtime.rpc.ConnectionStateListener
    public native boolean isValid();

    @Override // com.yandex.runtime.rpc.ConnectionStateListener
    public native void onConnectionStateChanged(boolean z);
}
