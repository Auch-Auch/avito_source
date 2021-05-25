package com.yandex.runtime.rpc.internal;

import androidx.annotation.NonNull;
import com.yandex.runtime.rpc.ServiceClient;
public interface ServiceManager {
    void addClientToService(@NonNull ServiceClient serviceClient, @NonNull String str);

    boolean isValid();

    void sendDataToService(@NonNull byte[] bArr, @NonNull String str, @NonNull String str2);
}
