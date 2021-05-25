package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
public abstract class mp {
    public static final String u = "mp";
    private final lx a;
    private final String b;

    public mp(lx lxVar) {
        this(lxVar, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.yandex.metrica.impl.ob.mp */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends mp> T a(String str, long j) {
        synchronized (this) {
            this.a.b(str, j);
        }
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.yandex.metrica.impl.ob.mp */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends mp> T b(String str, String str2) {
        synchronized (this) {
            this.a.b(str, str2);
        }
        return this;
    }

    @Nullable
    public String c(@NonNull String str, @Nullable String str2) {
        return this.a.a(str, str2);
    }

    public String p() {
        return this.b;
    }

    public th q(String str) {
        return new th(str, p());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.yandex.metrica.impl.ob.mp */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends mp> T r(String str) {
        synchronized (this) {
            this.a.a(str);
        }
        return this;
    }

    @Nullable
    public String s(@NonNull String str) {
        return this.a.a(str, (String) null);
    }

    public boolean t(@NonNull String str) {
        return this.a.b(str);
    }

    public mp(lx lxVar, String str) {
        this.a = lxVar;
        this.b = str;
    }

    public void q() {
        synchronized (this) {
            this.a.b();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.yandex.metrica.impl.ob.mp */
    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public <T extends mp> T a(String str, int i) {
        synchronized (this) {
            this.a.b(str, i);
        }
        return this;
    }

    public long b(String str, long j) {
        return this.a.a(str, j);
    }

    public int b(String str, int i) {
        return this.a.a(str, i);
    }

    public boolean b(String str, boolean z) {
        return this.a.a(str, z);
    }

    public String[] b(String str, String[] strArr) {
        String a3 = this.a.a(str, (String) null);
        if (!TextUtils.isEmpty(a3)) {
            try {
                JSONArray jSONArray = new JSONArray(a3);
                strArr = new String[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    strArr[i] = jSONArray.optString(i);
                }
            } catch (Throwable unused) {
            }
        }
        return strArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.yandex.metrica.impl.ob.mp */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends mp> T a(String str, boolean z) {
        synchronized (this) {
            this.a.b(str, z);
        }
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.yandex.metrica.impl.ob.mp */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends mp> T a(String str, String[] strArr) {
        String str2;
        try {
            JSONArray jSONArray = new JSONArray();
            for (String str3 : strArr) {
                jSONArray.put(str3);
            }
            str2 = jSONArray.toString();
        } catch (Throwable unused) {
            str2 = null;
        }
        this.a.b(str, str2);
        return this;
    }

    @Nullable
    public List<String> b(@NonNull String str, @Nullable List<String> list) {
        String[] b2 = b(str, list == null ? null : (String[]) list.toArray(new String[list.size()]));
        if (b2 == null) {
            return null;
        }
        return Arrays.asList(b2);
    }

    public <T extends mp> T a(String str, List<String> list) {
        return (T) a(str, (String[]) list.toArray(new String[list.size()]));
    }
}
