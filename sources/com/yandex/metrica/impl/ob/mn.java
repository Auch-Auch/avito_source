package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
public class mn extends mp {
    public static final th a = new th("UUID");
    public static final th b = new th("DEVICE_ID_POSSIBLE");
    public static final th c = new th("DEVICE_ID");
    public static final th d = new th("DEVICE_ID_HASH");
    public static final th e = new th("AD_URL_GET");
    public static final th f = new th("AD_URL_REPORT");
    public static final th g = new th("CUSTOM_HOSTS");
    public static final th h = new th("SERVER_TIME_OFFSET");
    public static final th i = new th("STARTUP_REQUEST_TIME");
    public static final th j = new th("CLIDS");
    public static final th k = new th("CLIENT_CLIDS");
    public static final th l = new th("REFERRER");
    public static final th m = new th("DEFERRED_DEEP_LINK_WAS_CHECKED");
    public static final th n = new th("REFERRER_FROM_PLAY_SERVICES_WAS_CHECKED");
    public static final th o = new th("DEPRECATED_NATIVE_CRASHES_CHECKED");
    public static final th p = new th("API_LEVEL");
    public static final th q = new th("ADS_REQUESTED_CONTEXT");
    public static final th r = new th("CONTEXT_HISTORY");
    public static final th s = new th("ACCESS_CONFIG");
    public static final th t = new th("LAST_UI_CONTEXT_ID");

    public mn(lx lxVar) {
        super(lxVar);
    }

    public String a(String str) {
        return c(a.b(), str);
    }

    public String b(String str) {
        return c(c.b(), str);
    }

    public String c(String str) {
        return c(d.b(), str);
    }

    public String d(String str) {
        return c(e.b(), str);
    }

    public String e(String str) {
        return c(f.b(), str);
    }

    public String f(String str) {
        return c(j.b(), str);
    }

    public mn g(String str) {
        return (mn) b(a.b(), str);
    }

    public mn h(String str) {
        return (mn) b(c.b(), str);
    }

    public mn i(String str) {
        return (mn) b(d.b(), str);
    }

    public mn j(String str) {
        return (mn) b(e.b(), str);
    }

    public mn k(String str) {
        return (mn) b(f.b(), str);
    }

    public mn l(String str) {
        return (mn) b(j.b(), str);
    }

    public mn m(String str) {
        return (mn) b(b.b(), str);
    }

    public mn n(String str) {
        return (mn) b(l.b(), str);
    }

    public mn o(@Nullable String str) {
        return (mn) b(k.b(), str);
    }

    @Nullable
    public String p(@Nullable String str) {
        return c(k.b(), str);
    }

    public String a() {
        return c(b.b(), "");
    }

    public List<String> b() {
        String c2 = c(g.b(), null);
        if (TextUtils.isEmpty(c2)) {
            return null;
        }
        return abc.c(c2);
    }

    public long c(long j2) {
        return b(p.b(), j2);
    }

    public boolean d() {
        return b(m.b(), false);
    }

    public boolean e() {
        return b(n.b(), false);
    }

    public mn f(long j2) {
        return (mn) a(p.b(), j2);
    }

    public mn g() {
        return (mn) a(n.b(), true);
    }

    @NonNull
    public List<String> h() {
        LinkedList linkedList = new LinkedList();
        List<String> b2 = b(r.b(), linkedList);
        return b2 == null ? linkedList : b2;
    }

    @Nullable
    public aag i() {
        try {
            String c2 = c(s.b(), null);
            if (c2 != null) {
                return abc.b(new JSONObject(c2));
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public long a(long j2) {
        return b(h.a(), j2);
    }

    public String c() {
        return c(l.b(), null);
    }

    public mn d(long j2) {
        return (mn) a(h.b(), j2);
    }

    public mn e(long j2) {
        return (mn) a(i.b(), j2);
    }

    public mn f() {
        return (mn) a(m.b(), true);
    }

    public long g(long j2) {
        return b(t.b(), j2);
    }

    public mn a(List<String> list) {
        return (mn) b(g.b(), abc.a(list));
    }

    public long b(long j2) {
        return b(i.b(), j2);
    }

    public mn h(long j2) {
        return (mn) a(t.b(), j2);
    }

    public mn b(boolean z) {
        return (mn) a(q.b(), z);
    }

    public boolean a(boolean z) {
        return b(q.b(), z);
    }

    public mn b(@NonNull List<String> list) {
        return (mn) a(r.b(), list);
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x000e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.yandex.metrica.impl.ob.mn a(@android.support.annotation.Nullable com.yandex.metrica.impl.ob.aag r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x000b
            org.json.JSONObject r2 = com.yandex.metrica.impl.ob.abc.a(r2)     // Catch:{ all -> 0x000b }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x000b }
            goto L_0x000c
        L_0x000b:
            r2 = 0
        L_0x000c:
            if (r2 == 0) goto L_0x0017
            com.yandex.metrica.impl.ob.th r0 = com.yandex.metrica.impl.ob.mn.s
            java.lang.String r0 = r0.b()
            r1.b(r0, r2)
        L_0x0017:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.mn.a(com.yandex.metrica.impl.ob.aag):com.yandex.metrica.impl.ob.mn");
    }
}
