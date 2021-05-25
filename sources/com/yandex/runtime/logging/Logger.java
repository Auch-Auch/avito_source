package com.yandex.runtime.logging;

import androidx.annotation.NonNull;
public class Logger {
    public static native void debug(@NonNull String str);

    public static native void error(@NonNull String str);

    public static native void info(@NonNull String str);

    public static native void warn(@NonNull String str);
}
