package com.yandex.runtime.recording;

import androidx.annotation.NonNull;
public class EventLoggingFactory {
    @NonNull
    public static native EventLogging getEventLogging();
}
