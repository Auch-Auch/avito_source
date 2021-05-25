package com.yandex.runtime.rpc;

import androidx.annotation.NonNull;
public interface Client {
    void handle(@NonNull byte[] bArr);
}
