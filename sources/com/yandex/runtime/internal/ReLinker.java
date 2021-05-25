package com.yandex.runtime.internal;

import android.content.Context;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
public class ReLinker {
    private static final int COPY_BUFFER_SIZE = 4096;
    private static final String LIB_DIR = "lib";
    private static final int MAX_TRIES = 5;

    public static class MissingLibraryException extends RuntimeException {
        public MissingLibraryException(String str) {
            super(str);
        }
    }

    private ReLinker() {
    }

    private static void closeSilently(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private static File getWorkaroundLibDir(Context context) {
        return context.getDir(LIB_DIR, 0);
    }

    private static File getWorkaroundLibFile(Context context, String str) {
        return new File(getWorkaroundLibDir(context), System.mapLibraryName(str));
    }

    public static void loadLibrary(Context context, String str) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        } else if (!TextUtils.isEmpty(str)) {
            try {
                System.loadLibrary(str);
            } catch (UnsatisfiedLinkError unused) {
                File workaroundLibFile = getWorkaroundLibFile(context, str);
                if (!workaroundLibFile.exists()) {
                    unpackLibrary(context, str);
                }
                System.load(workaroundLibFile.getAbsolutePath());
            }
        } else {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e6 A[SYNTHETIC, Splitter:B:76:0x00e6] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void unpackLibrary(android.content.Context r13, java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 234
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.runtime.internal.ReLinker.unpackLibrary(android.content.Context, java.lang.String):void");
    }
}
