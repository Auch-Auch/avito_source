package com.evernote.android.job.patched.internal.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public interface JobLogger {
    void log(int i, @NonNull String str, @NonNull String str2, @Nullable Throwable th);
}
