package com.yandex.runtime.rpc.internal.internal;

import androidx.annotation.NonNull;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.rpc.ServiceClient;
import com.yandex.runtime.rpc.internal.ServiceManager;
public class ServiceManagerBinding implements ServiceManager {
    private final NativeObject nativeObject;

    public ServiceManagerBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.runtime.rpc.internal.ServiceManager
    public native void addClientToService(@NonNull ServiceClient serviceClient, @NonNull String str);

    @Override // com.yandex.runtime.rpc.internal.ServiceManager
    public native boolean isValid();

    @Override // com.yandex.runtime.rpc.internal.ServiceManager
    public native void sendDataToService(@NonNull byte[] bArr, @NonNull String str, @NonNull String str2);
}
