package com.avito.android.util;

import androidx.annotation.Nullable;
public class UnauthorizedException extends Exception {
    private static final long serialVersionUID = 1;

    public UnauthorizedException() {
    }

    public UnauthorizedException(@Nullable Throwable th) {
        super(th);
    }
}
