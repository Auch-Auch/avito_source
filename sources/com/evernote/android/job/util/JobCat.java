package com.evernote.android.job.util;

import a2.b.a.a.a;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.Arrays;
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class JobCat implements JobLogger {
    public static volatile JobLogger[] a = new JobLogger[0];
    public static volatile boolean b = true;
    public final boolean mEnabled;
    public final String mTag;

    public JobCat(Class<?> cls) {
        this(cls.getSimpleName());
    }

    public static synchronized boolean addLogger(@NonNull JobLogger jobLogger) {
        synchronized (JobCat.class) {
            for (JobLogger jobLogger2 : a) {
                if (jobLogger.equals(jobLogger2)) {
                    return false;
                }
            }
            for (int i = 0; i < a.length; i++) {
                if (a[i] == null) {
                    a[i] = jobLogger;
                    return true;
                }
            }
            int length = a.length;
            a = (JobLogger[]) Arrays.copyOf(a, a.length + 2);
            a[length] = jobLogger;
            return true;
        }
    }

    public static synchronized void clearLogger() {
        synchronized (JobCat.class) {
            Arrays.fill(a, (Object) null);
        }
    }

    public static boolean isLogcatEnabled() {
        return b;
    }

    public static synchronized void removeLogger(@NonNull JobLogger jobLogger) {
        synchronized (JobCat.class) {
            for (int i = 0; i < a.length; i++) {
                if (jobLogger.equals(a[i])) {
                    a[i] = null;
                }
            }
        }
    }

    public static void setLogcatEnabled(boolean z) {
        b = z;
    }

    public void d(@NonNull String str) {
        log(3, this.mTag, str, null);
    }

    public void e(@NonNull Throwable th) {
        String message = th.getMessage();
        String str = this.mTag;
        if (message == null) {
            message = "empty message";
        }
        log(6, str, message, th);
    }

    public void i(@NonNull String str) {
        log(4, this.mTag, str, null);
    }

    @Override // com.evernote.android.job.util.JobLogger
    public void log(int i, @NonNull String str, @NonNull String str2, @Nullable Throwable th) {
        String str3;
        if (this.mEnabled) {
            if (b) {
                if (th == null) {
                    str3 = "";
                } else {
                    StringBuilder I = a.I('\n');
                    I.append(Log.getStackTraceString(th));
                    str3 = I.toString();
                }
                Log.println(i, str, str2 + str3);
            }
            JobLogger[] jobLoggerArr = a;
            if (jobLoggerArr.length > 0) {
                for (JobLogger jobLogger : jobLoggerArr) {
                    if (jobLogger != null) {
                        jobLogger.log(i, str, str2, th);
                    }
                }
            }
        }
    }

    public void w(@NonNull String str) {
        log(5, this.mTag, str, null);
    }

    public JobCat(String str) {
        this(str, true);
    }

    public void d(@NonNull String str, Object... objArr) {
        log(3, this.mTag, String.format(str, objArr), null);
    }

    public void i(@NonNull String str, Object... objArr) {
        log(4, this.mTag, String.format(str, objArr), null);
    }

    public void w(@NonNull String str, Object... objArr) {
        log(5, this.mTag, String.format(str, objArr), null);
    }

    public JobCat(String str, boolean z) {
        this.mTag = str;
        this.mEnabled = z;
    }

    public void d(@NonNull Throwable th, String str, Object... objArr) {
        log(3, this.mTag, String.format(str, objArr), th);
    }

    public void e(@NonNull String str) {
        log(6, this.mTag, str, null);
    }

    public void w(@NonNull Throwable th, @NonNull String str, Object... objArr) {
        log(5, this.mTag, String.format(str, objArr), th);
    }

    public void e(@NonNull String str, Object... objArr) {
        log(6, this.mTag, String.format(str, objArr), null);
    }

    public void e(@NonNull Throwable th, @NonNull String str, Object... objArr) {
        log(6, this.mTag, String.format(str, objArr), th);
    }
}
