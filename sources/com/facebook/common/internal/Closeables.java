package com.facebook.common.internal;

import com.facebook.infer.annotation.Nullsafe;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
@Nullsafe(Nullsafe.Mode.STRICT)
public final class Closeables {
    @VisibleForTesting
    public static final Logger a = Logger.getLogger(Closeables.class.getName());

    public static void close(@Nullable Closeable closeable, boolean z) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                if (z) {
                    a.log(Level.WARNING, "IOException thrown while closing Closeable.", (Throwable) e);
                    return;
                }
                throw e;
            }
        }
    }

    public static void closeQuietly(@Nullable InputStream inputStream) {
        try {
            close(inputStream, true);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public static void closeQuietly(@Nullable Reader reader) {
        try {
            close(reader, true);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
