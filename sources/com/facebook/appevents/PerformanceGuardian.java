package com.facebook.appevents;

import android.content.SharedPreferences;
import androidx.annotation.RestrictTo;
import com.avito.android.util.preferences.Preference;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@AutoHandleExceptions
public class PerformanceGuardian {
    public static boolean a = false;
    public static SharedPreferences b;
    public static final Integer c = 40;
    public static final Integer d = 3;
    public static final Set<String> e = new HashSet();
    public static final Set<String> f = new HashSet();
    public static final Map<String, Integer> g = new HashMap();
    public static final Map<String, Integer> h = new HashMap();

    public enum UseCase {
        CODELESS,
        SUGGESTED_EVENT
    }

    public static synchronized void a() {
        synchronized (PerformanceGuardian.class) {
            if (!a) {
                boolean z = false;
                SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.BANNED_ACTIVITY", 0);
                b = sharedPreferences;
                String string = sharedPreferences.getString(Preference.APP_VERSION, "");
                String appVersion = Utility.getAppVersion();
                if (appVersion != null && !string.isEmpty()) {
                    z = string.equals(appVersion);
                }
                if (!z) {
                    b.edit().clear().apply();
                } else {
                    f.addAll(b.getStringSet(UseCase.CODELESS.toString(), new HashSet()));
                    e.addAll(b.getStringSet(UseCase.SUGGESTED_EVENT.toString(), new HashSet()));
                }
                a = true;
            }
        }
    }

    public static void b(UseCase useCase, String str, Map<String, Integer> map, Set<String> set) {
        int intValue = (map.containsKey(str) ? map.get(str).intValue() : 0) + 1;
        map.put(str, Integer.valueOf(intValue));
        if (intValue >= d.intValue()) {
            set.add(str);
            b.edit().putStringSet(useCase.toString(), set).putString(Preference.APP_VERSION, Utility.getAppVersion()).apply();
        }
    }

    public static boolean isBannedActivity(String str, UseCase useCase) {
        a();
        int ordinal = useCase.ordinal();
        if (ordinal == 0) {
            return f.contains(str);
        }
        if (ordinal != 1) {
            return false;
        }
        return e.contains(str);
    }

    public static void limitProcessTime(String str, UseCase useCase, long j, long j2) {
        a();
        long j3 = j2 - j;
        if (str != null && j3 >= ((long) c.intValue())) {
            int ordinal = useCase.ordinal();
            if (ordinal == 0) {
                b(useCase, str, g, f);
            } else if (ordinal == 1) {
                b(useCase, str, h, e);
            }
        }
    }
}
