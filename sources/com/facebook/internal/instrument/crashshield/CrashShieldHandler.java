package com.facebook.internal.instrument.crashshield;

import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.ExceptionAnalyzer;
import com.facebook.internal.instrument.InstrumentData;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
public class CrashShieldHandler {
    public static final Set<Object> a = Collections.newSetFromMap(new WeakHashMap());
    public static boolean b = false;

    public static void enable() {
        b = true;
    }

    public static void handleThrowable(Throwable th, Object obj) {
        if (b) {
            a.add(obj);
            if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                ExceptionAnalyzer.execute(th);
                InstrumentData.Builder.build(th, InstrumentData.Type.CrashShield).save();
            }
        }
    }

    public static boolean isObjectCrashing(Object obj) {
        return a.contains(obj);
    }

    public static void methodFinished(Object obj) {
    }

    public static void reset() {
        resetCrashingObjects();
    }

    public static void resetCrashingObjects() {
        a.clear();
    }
}
