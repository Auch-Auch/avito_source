package com.yandex.runtime.rpc.internal;

import androidx.annotation.NonNull;
import com.yandex.runtime.rpc.Client;
import com.yandex.runtime.rpc.ConnectionStateListener;
import com.yandex.runtime.rpc.SendDataResult;
public interface Connection {
    boolean connect(@NonNull Client client, @NonNull ConnectionStateListener connectionStateListener);

    void disconnect();

    @NonNull
    SendDataResult sendData(@NonNull byte[] bArr);
}
