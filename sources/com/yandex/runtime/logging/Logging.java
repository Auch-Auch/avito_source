package com.yandex.runtime.logging;

import androidx.annotation.NonNull;
public interface Logging {
    boolean isValid();

    void subscribe(@NonNull LogListener logListener);

    void unsubscribe(@NonNull LogListener logListener);
}
