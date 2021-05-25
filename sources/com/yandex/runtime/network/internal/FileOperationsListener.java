package com.yandex.runtime.network.internal;

import androidx.annotation.NonNull;
import com.yandex.runtime.Error;
public interface FileOperationsListener {
    void onError(@NonNull Error error);

    void onSuccess();
}
