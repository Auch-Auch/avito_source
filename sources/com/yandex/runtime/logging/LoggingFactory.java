package com.yandex.runtime.logging;

import androidx.annotation.NonNull;
public class LoggingFactory {
    @NonNull
    public static native Logging getLogging();
}
