package com.facebook.internal.instrument.threadcheck;

import android.os.Looper;
import androidx.annotation.RestrictTo;
import com.facebook.internal.instrument.InstrumentData;
import java.util.Locale;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ThreadCheckHandler {
    public static boolean a = false;

    public static void a(String str, Class<?> cls, String str2, String str3) {
        if (a) {
            String.format(Locale.US, "%s annotation violation detected in %s.%s%s. Current looper is %s and main looper is %s.", str, cls.getName(), str2, str3, Looper.myLooper(), Looper.getMainLooper());
            InstrumentData.Builder.build(new Exception(), InstrumentData.Type.ThreadCheck).save();
        }
    }

    public static void enable() {
        a = true;
    }

    public static void uiThreadViolationDetected(Class<?> cls, String str, String str2) {
        a("@UiThread", cls, str, str2);
    }

    public static void workerThreadViolationDetected(Class<?> cls, String str, String str2) {
        a("@WorkerThread", cls, str, str2);
    }
}
