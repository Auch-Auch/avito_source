package com.facebook.appevents;

import a2.g.k.u;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Patterns;
import androidx.annotation.RestrictTo;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.FacebookSdk;
import com.facebook.appevents.aam.MetadataRule;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@AutoHandleExceptions
public class UserDataStore {
    public static final String CITY = "ct";
    public static final String COUNTRY = "country";
    public static final String DATE_OF_BIRTH = "db";
    public static final String EMAIL = "em";
    public static final String FIRST_NAME = "fn";
    public static final String GENDER = "ge";
    public static final String LAST_NAME = "ln";
    public static final String PHONE = "ph";
    public static final String STATE = "st";
    public static final String ZIP = "zp";
    public static SharedPreferences a;
    public static AtomicBoolean b = new AtomicBoolean(false);
    public static final ConcurrentHashMap<String, String> c = new ConcurrentHashMap<>();
    public static final ConcurrentHashMap<String, String> d = new ConcurrentHashMap<>();

    public static class a implements Runnable {
        public final /* synthetic */ Bundle a;

        public a(Bundle bundle) {
            this.a = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!UserDataStore.b.get()) {
                SharedPreferences sharedPreferences = UserDataStore.a;
                UserDataStore.a();
            }
            Bundle bundle = this.a;
            if (bundle != null) {
                for (String str : bundle.keySet()) {
                    Object obj = bundle.get(str);
                    if (obj != null) {
                        String obj2 = obj.toString();
                        if (obj2.matches("[A-Fa-f0-9]{64}")) {
                            UserDataStore.c.put(str, obj2.toLowerCase());
                        } else {
                            String sha256hash = Utility.sha256hash(UserDataStore.b(str, obj2));
                            if (sha256hash != null) {
                                UserDataStore.c.put(str, sha256hash);
                            }
                        }
                    }
                }
            }
            FacebookSdk.getExecutor().execute(new u("com.facebook.appevents.UserDataStore.userData", Utility.mapToJsonStr(UserDataStore.c)));
            FacebookSdk.getExecutor().execute(new u("com.facebook.appevents.UserDataStore.internalUserData", Utility.mapToJsonStr(UserDataStore.d)));
        }
    }

    public static synchronized void a() {
        synchronized (UserDataStore.class) {
            if (!b.get()) {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
                a = defaultSharedPreferences;
                String string = defaultSharedPreferences.getString("com.facebook.appevents.UserDataStore.userData", "");
                String string2 = a.getString("com.facebook.appevents.UserDataStore.internalUserData", "");
                c.putAll(Utility.JsonStrToMap(string));
                d.putAll(Utility.JsonStrToMap(string2));
                b.set(true);
            }
        }
    }

    public static String b(String str, String str2) {
        String str3;
        String lowerCase = str2.trim().toLowerCase();
        if (EMAIL.equals(str)) {
            if (Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
                return lowerCase;
            }
            return "";
        } else if (PHONE.equals(str)) {
            return lowerCase.replaceAll("[^0-9]", "");
        } else {
            if (!GENDER.equals(str)) {
                return lowerCase;
            }
            if (lowerCase.length() > 0) {
                str3 = lowerCase.substring(0, 1);
            } else {
                str3 = "";
            }
            if ("f".equals(str3) || AuthSource.OPEN_CHANNEL_LIST.equals(str3)) {
                return str3;
            }
            return "";
        }
    }

    public static void c(Bundle bundle) {
        InternalAppEventsLogger.a().execute(new a(bundle));
    }

    public static String getAllHashedUserData() {
        if (!b.get()) {
            a();
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(c);
        HashMap hashMap2 = new HashMap();
        Set<String> enabledRuleNames = MetadataRule.getEnabledRuleNames();
        for (String str : d.keySet()) {
            if (enabledRuleNames.contains(str)) {
                hashMap2.put(str, d.get(str));
            }
        }
        hashMap.putAll(hashMap2);
        return Utility.mapToJsonStr(hashMap);
    }
}
