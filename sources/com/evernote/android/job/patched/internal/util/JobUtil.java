package com.evernote.android.job.patched.internal.util;

import a2.b.a.a.a;
import android.content.Context;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
public final class JobUtil {
    public static final ThreadLocal<SimpleDateFormat> a = new ThreadLocal<>();
    public static final long b = TimeUnit.DAYS.toMillis(1);
    public static final JobCat c = new JobCat("JobUtil");

    public static boolean a(Context context, String str, int i) {
        try {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            c.e(e);
            if (i >= 1 || !a(context.getApplicationContext(), str, i + 1)) {
                return false;
            }
            return true;
        }
    }

    public static boolean hasBootPermission(Context context) {
        return a(context, "android.permission.RECEIVE_BOOT_COMPLETED", 0);
    }

    public static boolean hasWakeLockPermission(Context context) {
        return a(context, "android.permission.WAKE_LOCK", 0);
    }

    public static String timeToString(long j) {
        ThreadLocal<SimpleDateFormat> threadLocal = a;
        SimpleDateFormat simpleDateFormat = threadLocal.get();
        if (simpleDateFormat == null) {
            simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.US);
            threadLocal.set(simpleDateFormat);
        }
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        String format = simpleDateFormat.format(new Date(j));
        long j2 = j / b;
        int i = (j2 > 1 ? 1 : (j2 == 1 ? 0 : -1));
        if (i == 0) {
            return a.c3(format, " (+1 day)");
        }
        if (i <= 0) {
            return format;
        }
        return format + " (+" + j2 + " days)";
    }
}
