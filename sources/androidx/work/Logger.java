package androidx.work;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class Logger {
    public static Logger a;

    public static class LogcatLogger extends Logger {
        public int b;

        public LogcatLogger(int i) {
            super(i);
            this.b = i;
        }

        @Override // androidx.work.Logger
        public void debug(String str, String str2, Throwable... thArr) {
            if (this.b <= 3 && thArr != null && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }

        @Override // androidx.work.Logger
        public void error(String str, String str2, Throwable... thArr) {
            if (this.b <= 6 && thArr != null && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }

        @Override // androidx.work.Logger
        public void info(String str, String str2, Throwable... thArr) {
            if (this.b <= 4 && thArr != null && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }

        @Override // androidx.work.Logger
        public void verbose(String str, String str2, Throwable... thArr) {
            if (this.b <= 2 && thArr != null && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }

        @Override // androidx.work.Logger
        public void warning(String str, String str2, Throwable... thArr) {
            if (this.b <= 5 && thArr != null && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }
    }

    public Logger(int i) {
    }

    public static synchronized Logger get() {
        Logger logger;
        synchronized (Logger.class) {
            if (a == null) {
                a = new LogcatLogger(3);
            }
            logger = a;
        }
        return logger;
    }

    public static synchronized void setLogger(Logger logger) {
        synchronized (Logger.class) {
            a = logger;
        }
    }

    public static String tagWithPrefix(@NonNull String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append("WM-");
        if (length >= 20) {
            sb.append(str.substring(0, 20));
        } else {
            sb.append(str);
        }
        return sb.toString();
    }

    public abstract void debug(String str, String str2, Throwable... thArr);

    public abstract void error(String str, String str2, Throwable... thArr);

    public abstract void info(String str, String str2, Throwable... thArr);

    public abstract void verbose(String str, String str2, Throwable... thArr);

    public abstract void warning(String str, String str2, Throwable... thArr);
}
