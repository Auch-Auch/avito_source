package com.yandex.runtime;

import androidx.annotation.NonNull;
public class RuntimeBase {
    @NonNull
    public static native String getVersion();

    public static native void setFailedAssertionListener(@NonNull FailedAssertionListener failedAssertionListener);
}
