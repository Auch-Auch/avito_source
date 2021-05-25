package com.yandex.runtime.rpc;

import androidx.annotation.NonNull;
public interface ServiceClient {
    @NonNull
    String clientId();

    boolean handle(@NonNull byte[] bArr);
}
