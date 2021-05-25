package com.facebook.appevents;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.appevents.internal.Constants;
import com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class AppEvent implements Serializable {
    public static final HashSet<String> f = new HashSet<>();
    private static final long serialVersionUID = 1;
    public final JSONObject a;
    public final boolean b;
    public final boolean c;
    public final String d;
    public final String e;

    public static class b implements Serializable {
        private static final long serialVersionUID = -2488473066578201069L;

        private Object readResolve() throws JSONException {
            return new AppEvent(null, false, false, null, null);
        }
    }

    public static class c implements Serializable {
        private static final long serialVersionUID = 20160803001L;
        public final String a;
        public final boolean b;
        public final boolean c;
        public final String d;

        public c(String str, boolean z, boolean z2, String str2, a aVar) {
            this.a = str;
            this.b = z;
            this.c = z2;
            this.d = str2;
        }

        private Object readResolve() throws JSONException {
            return new AppEvent(this.a, this.b, this.c, this.d, null);
        }
    }

    public AppEvent(String str, @NonNull String str2, Double d2, Bundle bundle, boolean z, boolean z2, @Nullable UUID uuid) throws JSONException, FacebookException {
        this.b = z;
        this.c = z2;
        this.d = str2;
        b(str2);
        JSONObject jSONObject = new JSONObject();
        String processEvent = RestrictiveDataManager.processEvent(str2);
        jSONObject.put(Constants.EVENT_NAME_EVENT_KEY, processEvent);
        jSONObject.put(Constants.EVENT_NAME_MD5_EVENT_KEY, a(processEvent));
        jSONObject.put(Constants.LOG_TIME_APP_EVENT_KEY, System.currentTimeMillis() / 1000);
        jSONObject.put("_ui", str);
        if (uuid != null) {
            jSONObject.put("_session_id", uuid);
        }
        if (bundle != null) {
            HashMap hashMap = new HashMap();
            for (String str3 : bundle.keySet()) {
                b(str3);
                Object obj = bundle.get(str3);
                if ((obj instanceof String) || (obj instanceof Number)) {
                    hashMap.put(str3, obj.toString());
                } else {
                    throw new FacebookException(String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", obj, str3));
                }
            }
            IntegrityManager.processParameters(hashMap);
            RestrictiveDataManager.processParameters(hashMap, this.d);
            EventDeactivationManager.processDeprecatedParameters(hashMap, this.d);
            for (String str4 : hashMap.keySet()) {
                jSONObject.put(str4, hashMap.get(str4));
            }
        }
        if (d2 != null) {
            jSONObject.put(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM, d2.doubleValue());
        }
        if (this.c) {
            jSONObject.put("_inBackground", "1");
        }
        if (this.b) {
            jSONObject.put("_implicitlyLogged", "1");
        } else {
            Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Created app event '%s'", jSONObject.toString());
        }
        this.a = jSONObject;
        this.e = a(jSONObject.toString());
    }

    public static String a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(com.adjust.sdk.Constants.MD5);
            byte[] bytes = str.getBytes("UTF-8");
            instance.update(bytes, 0, bytes.length);
            return AppEventUtility.bytesToHex(instance.digest());
        } catch (NoSuchAlgorithmException e2) {
            Utility.logd("Failed to generate checksum: ", e2);
            return "0";
        } catch (UnsupportedEncodingException e3) {
            Utility.logd("Failed to generate checksum: ", e3);
            return "1";
        }
    }

    public static void b(String str) throws FacebookException {
        boolean contains;
        if (str == null || str.length() == 0 || str.length() > 40) {
            if (str == null) {
                str = "<None Provided>";
            }
            throw new FacebookException(String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", str, 40));
        }
        HashSet<String> hashSet = f;
        synchronized (hashSet) {
            contains = hashSet.contains(str);
        }
        if (contains) {
            return;
        }
        if (str.matches("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$")) {
            synchronized (hashSet) {
                hashSet.add(str);
            }
            return;
        }
        throw new FacebookException(String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", str));
    }

    private Object writeReplace() {
        return new c(this.a.toString(), this.b, this.c, this.e, null);
    }

    public boolean getIsImplicit() {
        return this.b;
    }

    public JSONObject getJSONObject() {
        return this.a;
    }

    public String getName() {
        return this.d;
    }

    public boolean isChecksumValid() {
        if (this.e == null) {
            return true;
        }
        return a(this.a.toString()).equals(this.e);
    }

    @Override // java.lang.Object
    public String toString() {
        return String.format("\"%s\", implicit: %b, json: %s", this.a.optString(Constants.EVENT_NAME_EVENT_KEY), Boolean.valueOf(this.b), this.a.toString());
    }

    public AppEvent(String str, boolean z, boolean z2, String str2, a aVar) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        this.a = jSONObject;
        this.b = z;
        this.d = jSONObject.optString(Constants.EVENT_NAME_EVENT_KEY);
        this.e = str2;
        this.c = z2;
    }
}
