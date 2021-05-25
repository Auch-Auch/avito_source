package com.yandex.metrica.impl.ob;

import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;
public class jo {
    private final fe a;
    private final jw b;
    private final jq c;
    private long d;
    private long e;
    private AtomicLong f;
    private boolean g;
    private volatile a h;
    private long i;
    private long j;
    private abs k;

    public static class a {
        private final String a;
        private final String b;
        private final String c;
        private final String d;
        private final String e;
        private final int f;
        private final int g;

        public a(JSONObject jSONObject) {
            this.a = jSONObject.optString("analyticsSdkVersionName", null);
            this.b = jSONObject.optString("kitBuildNumber", null);
            this.c = jSONObject.optString("appVer", null);
            this.d = jSONObject.optString("appBuild", null);
            this.e = jSONObject.optString("osVer", null);
            this.f = jSONObject.optInt("osApiLev", -1);
            this.g = jSONObject.optInt("attribution_id", 0);
        }

        public boolean a(we weVar) {
            return TextUtils.equals(weVar.j(), this.a) && TextUtils.equals(weVar.k(), this.b) && TextUtils.equals(weVar.r(), this.c) && TextUtils.equals(weVar.q(), this.d) && TextUtils.equals(weVar.o(), this.e) && this.f == weVar.p() && this.g == weVar.Y();
        }

        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("SessionRequestParams{mKitVersionName='");
            a2.b.a.a.a.k1(L, this.a, '\'', ", mKitBuildNumber='");
            a2.b.a.a.a.k1(L, this.b, '\'', ", mAppVersion='");
            a2.b.a.a.a.k1(L, this.c, '\'', ", mAppBuild='");
            a2.b.a.a.a.k1(L, this.d, '\'', ", mOsVersion='");
            a2.b.a.a.a.k1(L, this.e, '\'', ", mApiLevel=");
            return a2.b.a.a.a.i(L, this.f, '}');
        }
    }

    public jo(fe feVar, jw jwVar, jq jqVar) {
        this(feVar, jwVar, jqVar, new abs());
    }

    private void i() {
        this.e = this.c.b(this.k.c());
        this.d = this.c.a(-1L);
        this.f = new AtomicLong(this.c.c(0));
        this.g = this.c.a(true);
        long d2 = this.c.d(0);
        this.i = d2;
        this.j = this.c.e(d2 - this.e);
    }

    private boolean j() {
        a k2 = k();
        if (k2 != null) {
            return k2.a(this.a.i());
        }
        return false;
    }

    private a k() {
        if (this.h == null) {
            synchronized (this) {
                if (this.h == null) {
                    try {
                        String asString = this.a.j().b(c(), a()).getAsString("report_request_parameters");
                        if (!TextUtils.isEmpty(asString)) {
                            this.h = new a(new JSONObject(asString));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        return this.h;
    }

    public jy a() {
        return this.c.a();
    }

    public int b() {
        return this.c.a(this.a.i().V());
    }

    public long c() {
        return this.d;
    }

    public long d() {
        return Math.max(this.i - TimeUnit.MILLISECONDS.toSeconds(this.e), this.j);
    }

    public synchronized void e() {
        this.b.a();
        this.h = null;
    }

    public long f() {
        return this.j;
    }

    public long g() {
        long andIncrement = this.f.getAndIncrement();
        this.b.a(this.f.get()).h();
        return andIncrement;
    }

    public boolean h() {
        return this.g && c() > 0;
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("Session{mId=");
        L.append(this.d);
        L.append(", mInitTime=");
        L.append(this.e);
        L.append(", mCurrentReportId=");
        L.append(this.f);
        L.append(", mSessionRequestParams=");
        L.append(this.h);
        L.append(", mSleepStartSeconds=");
        return a2.b.a.a.a.k(L, this.i, '}');
    }

    public jo(fe feVar, jw jwVar, jq jqVar, abs abs) {
        this.a = feVar;
        this.b = jwVar;
        this.c = jqVar;
        this.k = abs;
        i();
    }

    private long d(long j2) {
        return TimeUnit.MILLISECONDS.toSeconds(j2 - this.e);
    }

    public boolean a(long j2) {
        boolean z = this.d >= 0;
        boolean j3 = j();
        boolean z2 = !a(j2, this.k.c());
        if (!z || !j3 || !z2) {
            return false;
        }
        return true;
    }

    public void b(long j2) {
        jw jwVar = this.b;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j2);
        this.i = seconds;
        jwVar.b(seconds).h();
    }

    public long c(long j2) {
        jw jwVar = this.b;
        long d2 = d(j2);
        this.j = d2;
        jwVar.c(d2);
        return this.j;
    }

    @VisibleForTesting
    public boolean a(long j2, long j3) {
        long j4 = this.i;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        boolean z = timeUnit.toSeconds(j3) < j4;
        long seconds = timeUnit.toSeconds(j2) - j4;
        long d2 = d(j2);
        if (z || seconds >= ((long) b()) || d2 >= jr.c) {
            return true;
        }
        return false;
    }

    public void a(boolean z) {
        if (this.g != z) {
            this.g = z;
            this.b.a(z).h();
        }
    }
}
