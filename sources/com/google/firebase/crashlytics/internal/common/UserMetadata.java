package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
public class UserMetadata {
    public String a = null;
    public final ConcurrentHashMap<String, String> b = new ConcurrentHashMap<>();

    public static String a(String str) {
        if (str == null) {
            return str;
        }
        String trim = str.trim();
        return trim.length() > 1024 ? trim.substring(0, 1024) : trim;
    }

    @NonNull
    public Map<String, String> getCustomKeys() {
        return Collections.unmodifiableMap(this.b);
    }

    @Nullable
    public String getUserId() {
        return this.a;
    }

    public void setCustomKey(String str, String str2) {
        String str3;
        if (str != null) {
            String a3 = a(str);
            if (this.b.size() < 64 || this.b.containsKey(a3)) {
                if (str2 == null) {
                    str3 = "";
                } else {
                    str3 = a(str2);
                }
                this.b.put(a3, str3);
                return;
            }
            Logger.getLogger().d("Exceeded maximum number of custom attributes (64)");
            return;
        }
        throw new IllegalArgumentException("Custom attribute key must not be null.");
    }

    public void setUserId(String str) {
        this.a = a(str);
    }
}
