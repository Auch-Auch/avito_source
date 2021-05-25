package com.yandex.runtime.network.internal;

import androidx.annotation.NonNull;
public interface NetworkPlayer {
    boolean isValid();

    void play(@NonNull String str, @NonNull FileOperationsListener fileOperationsListener);

    void stop();
}
