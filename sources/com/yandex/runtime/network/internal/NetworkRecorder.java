package com.yandex.runtime.network.internal;

import androidx.annotation.NonNull;
public interface NetworkRecorder {
    void dump(@NonNull String str, @NonNull FileOperationsListener fileOperationsListener);

    boolean isValid();

    void start();

    void stop();
}
