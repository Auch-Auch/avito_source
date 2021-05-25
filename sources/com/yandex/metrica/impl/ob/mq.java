package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Base64;
import com.yandex.metrica.impl.ob.ca;
public class mq extends mp {
    public static final th A = new th("LAST_STARTUP_SEND_ATTEMPT_TIME");
    private static final th B = new th("LAST_MIGRATION_VERSION");
    private static final th C = new th("LAST_WIFI_SCANNING_ATTEMPT_TIME");
    private static final th D = new th("LAST_LBS_SCANNING_ATTEMPT_TIME");
    private static final th E = new th("LAST_GPS_SCANNING_ATTEMPT_TIME");
    private static final th F = new th("LAST_FUSED_SCANNING_ATTEMPT_TIME");
    public static final th a = new th("LOCATION_TRACKING_ENABLED");
    @Deprecated
    public static final th b = new th("COLLECT_INSTALLED_APPS");
    public static final th c = new th("INSTALLED_APP_COLLECTING");
    public static final th d = new th("REFERRER");
    public static final th e = new th("REFERRER_FROM_PLAY_SERVICES");
    public static final th f = new th("REFERRER_HANDLED");
    public static final th g = new th("REFERRER_HOLDER_STATE");
    public static final th h = new th("PREF_KEY_OFFSET");
    public static final th i = new th("UNCHECKED_TIME");
    public static final th j = new th("L_REQ_NUM");
    public static final th k = new th("L_ID");
    public static final th l = new th("LBS_ID");
    public static final th m = new th("STATISTICS_RESTRICTED_IN_MAIN");
    public static final th n = new th("SDKFCE");
    public static final th o = new th("FST");
    public static final th p = new th("LSST");
    public static final th q = new th("FSDKFCO");
    public static final th r = new th("SRSDKFC");
    public static final th s = new th("LSDKFCAT");
    public static final th t = new th("LAST_IDENTITY_LIGHT_SEND_TIME");
    public static final th v = new th("NEXT_REPORT_SEND_ATTEMPT_NUMBER");
    public static final th w = new th("NEXT_LOCATION_SEND_ATTEMPT_NUMBER");
    public static final th x = new th("NEXT_STARTUP_SEND_ATTEMPT_NUMBER");
    public static final th y = new th("LAST_REPORT_SEND_ATTEMPT_TIME");
    public static final th z = new th("LAST_LOCATION_SEND_ATTEMPT_TIME");

    /* renamed from: com.yandex.metrica.impl.ob.mq$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            ca.a.values();
            int[] iArr = new int[4];
            a = iArr;
            try {
                ca.a aVar = ca.a.REPORT;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = a;
                ca.a aVar2 = ca.a.STARTUP;
                iArr2[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = a;
                ca.a aVar3 = ca.a.LOCATION;
                iArr3[1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public mq(lx lxVar) {
        super(lxVar);
    }

    public boolean a() {
        return b(c.b(), false);
    }

    public String b() {
        return c(d.b(), null);
    }

    public vu c() {
        return b(c(e.b(), null));
    }

    public boolean d() {
        return b(f.b(), false);
    }

    public mq e() {
        return (mq) a(f.b(), true);
    }

    public mq f() {
        return (mq) r(d.b()).r(e.b());
    }

    public boolean g() {
        return b(a.b(), false);
    }

    @Nullable
    public Boolean h() {
        th thVar = m;
        if (t(thVar.b())) {
            return Boolean.valueOf(b(thVar.b(), true));
        }
        return null;
    }

    public mq i(long j2) {
        return (mq) a(t.b(), j2);
    }

    public long j(long j2) {
        return b(C.b(), j2);
    }

    public mq k(long j2) {
        return (mq) a(C.b(), j2);
    }

    public long l(long j2) {
        return b(D.b(), j2);
    }

    public mq m(long j2) {
        return (mq) a(D.b(), j2);
    }

    public long n(long j2) {
        return b(E.b(), j2);
    }

    public mq o(long j2) {
        return (mq) a(E.b(), j2);
    }

    public long p(long j2) {
        return b(F.b(), j2);
    }

    public mq q(long j2) {
        return (mq) a(F.b(), j2);
    }

    private vu b(String str) {
        if (str == null) {
            return null;
        }
        try {
            return vu.a(Base64.encode(str.getBytes(), 0));
        } catch (d unused) {
            return null;
        }
    }

    public mq a(boolean z2) {
        return (mq) a(c.b(), z2);
    }

    public long c(int i2) {
        return b(h.b(), (long) i2);
    }

    public long d(long j2) {
        return b(k.b(), j2);
    }

    public mq e(long j2) {
        return (mq) a(k.b(), j2);
    }

    public long f(long j2) {
        return b(l.b(), j2);
    }

    public mq g(long j2) {
        return (mq) a(l.b(), j2);
    }

    private String b(@Nullable vu vuVar) {
        if (vuVar == null) {
            return null;
        }
        return new String(Base64.encode(vuVar.a(), 0));
    }

    public mq a(String str) {
        return (mq) b(d.b(), str);
    }

    public mq c(long j2) {
        return (mq) a(j.b(), j2);
    }

    public mq d(boolean z2) {
        return (mq) a(i.b(), z2);
    }

    public mq e(int i2) {
        return (mq) a(g.b(), i2);
    }

    public long h(long j2) {
        return b(t.b(), j2);
    }

    public mq a(vu vuVar) {
        return (mq) b(e.b(), b(vuVar));
    }

    public mq b(int i2) {
        return (mq) a(B.b(), i2);
    }

    public boolean c(boolean z2) {
        return b(i.b(), z2);
    }

    public int d(int i2) {
        return b(g.b(), i2);
    }

    public mq e(boolean z2) {
        return (mq) a(m.b(), z2);
    }

    public int a(int i2) {
        return b(B.b(), i2);
    }

    public void b(boolean z2) {
        a(a.b(), z2).q();
    }

    public mq a(long j2) {
        return (mq) a(h.b(), j2);
    }

    public long b(long j2) {
        return b(j.b(), j2);
    }

    public int a(@NonNull ca.a aVar, int i2) {
        th a3 = a(aVar);
        return a3 == null ? i2 : b(a3.b(), i2);
    }

    public mq b(@NonNull ca.a aVar, int i2) {
        th a3 = a(aVar);
        return a3 != null ? (mq) a(a3.b(), i2) : this;
    }

    public long a(@NonNull ca.a aVar, long j2) {
        th b2 = b(aVar);
        return b2 == null ? j2 : b(b2.b(), j2);
    }

    public mq b(@NonNull ca.a aVar, long j2) {
        th b2 = b(aVar);
        return b2 != null ? (mq) a(b2.b(), j2) : this;
    }

    private th a(@NonNull ca.a aVar) {
        int i2 = AnonymousClass1.a[aVar.ordinal()];
        if (i2 == 1) {
            return v;
        }
        if (i2 == 2) {
            return x;
        }
        if (i2 != 3) {
            return null;
        }
        return w;
    }

    private th b(@NonNull ca.a aVar) {
        int i2 = AnonymousClass1.a[aVar.ordinal()];
        if (i2 == 1) {
            return y;
        }
        if (i2 == 2) {
            return A;
        }
        if (i2 != 3) {
            return null;
        }
        return z;
    }
}
