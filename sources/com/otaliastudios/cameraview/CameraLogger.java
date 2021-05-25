package com.otaliastudios.cameraview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
public final class CameraLogger {
    public static final int LEVEL_ERROR = 3;
    public static final int LEVEL_INFO = 1;
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_WARNING = 2;
    public static int b;
    public static Set<Logger> c = new CopyOnWriteArraySet();
    @VisibleForTesting
    public static Logger d = new a();
    @NonNull
    public String a;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LogLevel {
    }

    public interface Logger {
        void log(int i, @NonNull String str, @NonNull String str2, @Nullable Throwable th);
    }

    public static class a implements Logger {
        @Override // com.otaliastudios.cameraview.CameraLogger.Logger
        public void log(int i, @NonNull String str, @NonNull String str2, @Nullable Throwable th) {
        }
    }

    static {
        setLogLevel(3);
        c.add(d);
    }

    public CameraLogger(@NonNull String str) {
        this.a = str;
    }

    public static CameraLogger create(@NonNull String str) {
        return new CameraLogger(str);
    }

    public static void registerLogger(@NonNull Logger logger) {
        c.add(logger);
    }

    public static void setLogLevel(int i) {
        b = i;
    }

    public static void unregisterLogger(@NonNull Logger logger) {
        c.remove(logger);
    }

    @Nullable
    public final String a(int i, @NonNull Object... objArr) {
        Throwable th = null;
        if (!(b <= i && c.size() > 0)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj instanceof Throwable) {
                th = (Throwable) obj;
            }
            sb.append(String.valueOf(obj));
            sb.append(" ");
        }
        String trim = sb.toString().trim();
        for (Logger logger : c) {
            logger.log(i, this.a, trim, th);
        }
        return trim;
    }

    @Nullable
    public String e(@NonNull Object... objArr) {
        return a(3, objArr);
    }

    @Nullable
    public String i(@NonNull Object... objArr) {
        return a(1, objArr);
    }

    @Nullable
    public String v(@NonNull Object... objArr) {
        return a(0, objArr);
    }

    @Nullable
    public String w(@NonNull Object... objArr) {
        return a(2, objArr);
    }
}
