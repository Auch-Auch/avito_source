package com.avito.android.util;

import androidx.annotation.Nullable;
public class EntityTooLargeException extends Exception {
    private static final long serialVersionUID = 1;

    public EntityTooLargeException() {
    }

    public EntityTooLargeException(@Nullable Throwable th) {
        super(th);
    }
}
