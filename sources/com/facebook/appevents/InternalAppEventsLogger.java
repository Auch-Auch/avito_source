package com.facebook.appevents;

import a2.b.a.a.a;
import a2.g.k.o;
import a2.g.k.u;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.internal.Utility;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Currency;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class InternalAppEventsLogger {
    public o a;

    public InternalAppEventsLogger(Context context) {
        this.a = new o(context, (String) null, (AccessToken) null);
    }

    public static Executor a() {
        if (o.d == null) {
            o.d();
        }
        return o.d;
    }

    public static AppEventsLogger.FlushBehavior getFlushBehavior() {
        return o.c();
    }

    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    public static void setInternalUserData(Map<String, String> map) {
        if (!UserDataStore.b.get()) {
            UserDataStore.a();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String sha256hash = Utility.sha256hash(UserDataStore.b(key, map.get(key).trim()));
            ConcurrentHashMap<String, String> concurrentHashMap = UserDataStore.d;
            if (concurrentHashMap.containsKey(key)) {
                String str = concurrentHashMap.get(key);
                String[] split = str != null ? str.split(",") : new String[0];
                HashSet hashSet = new HashSet(Arrays.asList(split));
                if (!hashSet.contains(sha256hash)) {
                    StringBuilder sb = new StringBuilder();
                    if (split.length == 0) {
                        sb.append(sha256hash);
                    } else if (split.length < 5) {
                        a.m1(sb, str, ",", sha256hash);
                    } else {
                        for (int i = 1; i < 5; i++) {
                            sb.append(split[i]);
                            sb.append(",");
                        }
                        sb.append(sha256hash);
                        hashSet.remove(split[0]);
                    }
                    UserDataStore.d.put(key, sb.toString());
                } else {
                    return;
                }
            } else {
                concurrentHashMap.put(key, sha256hash);
            }
        }
        FacebookSdk.getExecutor().execute(new u("com.facebook.appevents.UserDataStore.internalUserData", Utility.mapToJsonStr(UserDataStore.d)));
    }

    public static void setUserData(Bundle bundle) {
        UserDataStore.c(bundle);
    }

    public void flush() {
        this.a.b();
    }

    public void logEvent(String str, Bundle bundle) {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.a.g(str, bundle);
        }
    }

    public void logEventFromSE(String str, String str2) {
        o oVar = this.a;
        Objects.requireNonNull(oVar);
        Bundle bundle = new Bundle();
        bundle.putString("_is_suggested_event", "1");
        bundle.putString("_button_text", str2);
        oVar.g(str, bundle);
    }

    public void logEventImplicitly(String str, BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            o oVar = this.a;
            Objects.requireNonNull(oVar);
            if (bigDecimal == null || currency == null) {
                Utility.logd(o.c, "purchaseAmount and currency cannot be null");
                return;
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString(AppEventsConstants.EVENT_PARAM_CURRENCY, currency.getCurrencyCode());
            oVar.h(str, Double.valueOf(bigDecimal.doubleValue()), bundle, true, ActivityLifecycleTracker.getCurrentSessionGuid());
        }
    }

    public void logPurchaseImplicitly(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.a.j(bigDecimal, currency, bundle, true);
        }
    }

    public void logEvent(String str, double d, Bundle bundle) {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.a.f(str, d, bundle);
        }
    }

    public InternalAppEventsLogger(Context context, String str) {
        this.a = new o(context, str, (AccessToken) null);
    }

    public InternalAppEventsLogger(String str, String str2, AccessToken accessToken) {
        this.a = new o(str, str2, accessToken);
    }

    public void logEventImplicitly(String str) {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.a.i(str, null, null);
        }
    }

    public void logEventImplicitly(String str, Double d, Bundle bundle) {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.a.i(str, d, bundle);
        }
    }

    public void logEventImplicitly(String str, Bundle bundle) {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.a.i(str, null, bundle);
        }
    }
}
