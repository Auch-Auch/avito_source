package com.avito.security;

import java.io.Closeable;
public final class w0 {
    public static final void a(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                k.a(th, th2);
            }
        }
    }
}
