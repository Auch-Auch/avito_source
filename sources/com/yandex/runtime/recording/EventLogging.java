package com.yandex.runtime.recording;

import androidx.annotation.NonNull;
public interface EventLogging {
    boolean isValid();

    void subscribe(@NonNull EventListener eventListener);

    void subscribe(@NonNull EventListener eventListener, @NonNull LoggingLevel loggingLevel);

    void unsubscribe(@NonNull EventListener eventListener);
}
