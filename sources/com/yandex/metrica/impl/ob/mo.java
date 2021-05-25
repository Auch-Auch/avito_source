package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.impl.ob.i;
import java.util.Collections;
import java.util.List;
public class mo extends mp {
    public static final String a = null;
    @Deprecated
    public static final th b = new th("COLLECT_INSTALLED_APPS");
    public static final th c = new th("DEPRECATED_NATIVE_CRASHES_CHECKED");
    private static final th d = new th("IDENTITY_SEND_TIME");
    private static final th e = new th("PERMISSIONS_CHECK_TIME");
    private static final th f = new th("USER_INFO");
    private static final th g = new th("PROFILE_ID");
    private static final th h = new th("APP_ENVIRONMENT");
    private static final th i = new th("APP_ENVIRONMENT_REVISION");
    private static final th j = new th("LAST_MIGRATION_VERSION");
    private static final th k = new th("LAST_APP_VERSION_WITH_FEATURES");
    private static final th l = new th("APPLICATION_FEATURES");
    private static final th m = new th("CURRENT_SESSION_ID");
    private static final th n = new th("ATTRIBUTION_ID");
    private static final th o = new th("LAST_STAT_SENDING_DISABLED_REPORTING_TIMESTAMP");
    private static final th p = new th("NEXT_EVENT_GLOBAL_NUMBER");
    private static final th q = new th("LAST_REQUEST_ID");
    private static final th r = new th("CERTIFICATES_SHA1_FINGERPRINTS");
    private static final ml s = new ml();

    public mo(lx lxVar) {
        super(lxVar);
    }

    public int a() {
        return b(p.b(), 0);
    }

    public long b() {
        return b(e.b(), 0L);
    }

    public int c() {
        return b(k.b(), -1);
    }

    public i.a d() {
        i.a aVar;
        synchronized (this) {
            aVar = new i.a(c(h.b(), "{}"), b(i.b(), 0L));
        }
        return aVar;
    }

    public String e() {
        return c(l.b(), "");
    }

    public String f() {
        return c(f.b(), a);
    }

    public long g() {
        return b(j.b(), 0L);
    }

    @Nullable
    public String h() {
        return s(g.b());
    }

    public int i() {
        return b(n.b(), 1);
    }

    public long j() {
        return b(m.b(), -1L);
    }

    public long k() {
        return b(o.b(), 0L);
    }

    public int l() {
        return b(q.b(), -1);
    }

    public boolean m() {
        return b(c.b(), false);
    }

    public mo n() {
        return (mo) a(c.b(), true);
    }

    @NonNull
    public List<String> o() {
        return b(r.b(), Collections.emptyList());
    }

    public int a(int i2) {
        return b(s.a(i2), 0);
    }

    public mo b(int i2) {
        return (mo) a(p.b(), i2);
    }

    public mo c(long j2) {
        return (mo) a(e.b(), j2);
    }

    @NonNull
    public mo e(long j2) {
        return (mo) a(m.b(), j2);
    }

    public mo f(long j2) {
        return (mo) a(o.b(), j2);
    }

    public long a(long j2) {
        return b(d.b(), j2);
    }

    public mo b(long j2) {
        return (mo) a(d.b(), j2);
    }

    public mo c(int i2) {
        return (mo) a(k.b(), i2);
    }

    public mo e(int i2) {
        return (mo) a(q.b(), i2);
    }

    public mo a(int i2, int i3) {
        return (mo) a(s.a(i2), i3);
    }

    public mo b(String str) {
        return (mo) b(l.b(), str);
    }

    public String c(String str) {
        return c(new th("SESSION_", str).b(), "");
    }

    public mo a(i.a aVar) {
        synchronized (this) {
            b(h.b(), aVar.a);
            a(i.b(), aVar.b);
        }
        return this;
    }

    public mo d(long j2) {
        return (mo) a(j.b(), j2);
    }

    public mo d(@Nullable String str) {
        return (mo) b(g.b(), str);
    }

    @NonNull
    public mo d(int i2) {
        return (mo) a(n.b(), i2);
    }

    public mo a(String str) {
        return (mo) b(f.b(), str);
    }

    public mo a(String str, String str2) {
        return (mo) b(new th("SESSION_", str).b(), str2);
    }

    public mo a(List<String> list) {
        return (mo) a(r.b(), list);
    }
}
