package com.yandex.metrica.impl.ob;

import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.ew;
import com.yandex.metrica.impl.ob.vy;
import com.yandex.metrica.impl.ob.wb;
import java.util.List;
import java.util.Map;
public class we extends wb {
    private boolean a;
    private Location b;
    private boolean c;
    private boolean d;
    private boolean e;
    private int f;
    private int g;
    private boolean h;
    private int i;
    private Boolean j;
    private d k;
    private String l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private String q;
    private List<String> r;
    private boolean s;
    private int t;
    private long u;
    private long v;
    private boolean w;
    private long x;
    @Nullable
    private List<String> y;

    public static final class a extends vy.a<ew.a, a> {
        @Nullable
        public final String a;
        @Nullable
        public final Location b;
        public final boolean f;
        public final boolean g;
        public final boolean h;
        public final int i;
        public final int j;
        public final int k;
        public final boolean l;
        public final boolean m;
        public final boolean n;
        @Nullable
        public final Map<String, String> o;
        public final int p;

        public a(@NonNull ew.a aVar) {
            this(aVar.a, aVar.b, aVar.c, aVar.d, aVar.e, aVar.f, aVar.g, aVar.h, aVar.n, aVar.i, aVar.j, aVar.k, aVar.l, aVar.m, aVar.o, aVar.p);
        }

        public a(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Boolean bool, @Nullable Location location, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Boolean bool5, @Nullable Boolean bool6, @Nullable Map<String, String> map, @Nullable Integer num4) {
            super(str, str2, str3);
            this.a = str4;
            Boolean bool7 = Boolean.TRUE;
            this.f = ((Boolean) abw.b(bool, bool7)).booleanValue();
            this.b = location;
            Boolean bool8 = Boolean.FALSE;
            this.g = ((Boolean) abw.b(bool2, bool8)).booleanValue();
            this.h = ((Boolean) abw.b(bool3, bool8)).booleanValue();
            this.n = ((Boolean) abw.b(bool4, bool8)).booleanValue();
            this.i = Math.max(10, ((Integer) abw.b(num, 10)).intValue());
            this.j = ((Integer) abw.b(num2, 7)).intValue();
            this.k = ((Integer) abw.b(num3, 90)).intValue();
            this.l = ((Boolean) abw.b(bool5, bool8)).booleanValue();
            this.m = ((Boolean) abw.b(bool6, bool7)).booleanValue();
            this.o = map;
            this.p = ((Integer) abw.b(num4, 1000)).intValue();
        }

        public boolean a(@Nullable Location location, @Nullable Location location2) {
            if (location == location2) {
                return true;
            }
            if (location == null || location2 == null || location.getTime() != location2.getTime()) {
                return false;
            }
            if ((dl.a(17) && location.getElapsedRealtimeNanos() != location2.getElapsedRealtimeNanos()) || Double.compare(location2.getLatitude(), location.getLatitude()) != 0 || Double.compare(location2.getLongitude(), location.getLongitude()) != 0 || Double.compare(location2.getAltitude(), location.getAltitude()) != 0 || Float.compare(location2.getSpeed(), location.getSpeed()) != 0 || Float.compare(location2.getBearing(), location.getBearing()) != 0 || Float.compare(location2.getAccuracy(), location.getAccuracy()) != 0) {
                return false;
            }
            if (dl.a(26) && (Float.compare(location2.getVerticalAccuracyMeters(), location.getVerticalAccuracyMeters()) != 0 || Float.compare(location2.getSpeedAccuracyMetersPerSecond(), location.getSpeedAccuracyMetersPerSecond()) != 0 || Float.compare(location2.getBearingAccuracyDegrees(), location.getBearingAccuracyDegrees()) != 0)) {
                return false;
            }
            if (location.getProvider() == null ? location2.getProvider() != null : !location.getProvider().equals(location2.getProvider())) {
                return false;
            }
            if (location.getExtras() != null) {
                return location.getExtras().equals(location2.getExtras());
            }
            if (location2.getExtras() == null) {
                return true;
            }
            return false;
        }

        /* renamed from: b */
        public boolean a(@NonNull ew.a aVar) {
            Map<String, String> map;
            String str;
            String str2 = aVar.a;
            if (str2 != null && !str2.equals(this.c)) {
                return false;
            }
            String str3 = aVar.b;
            if (str3 != null && !str3.equals(this.d)) {
                return false;
            }
            String str4 = aVar.c;
            if (str4 != null && !str4.equals(this.e)) {
                return false;
            }
            Boolean bool = aVar.e;
            if (bool != null && this.f != bool.booleanValue()) {
                return false;
            }
            Boolean bool2 = aVar.g;
            if (bool2 != null && this.g != bool2.booleanValue()) {
                return false;
            }
            Boolean bool3 = aVar.h;
            if (bool3 != null && this.h != bool3.booleanValue()) {
                return false;
            }
            Integer num = aVar.i;
            if (num != null && this.i != num.intValue()) {
                return false;
            }
            Integer num2 = aVar.j;
            if (num2 != null && this.j != num2.intValue()) {
                return false;
            }
            Integer num3 = aVar.k;
            if (num3 != null && this.k != num3.intValue()) {
                return false;
            }
            Boolean bool4 = aVar.l;
            if (bool4 != null && this.l != bool4.booleanValue()) {
                return false;
            }
            Boolean bool5 = aVar.m;
            if (bool5 != null && this.m != bool5.booleanValue()) {
                return false;
            }
            Boolean bool6 = aVar.n;
            if (bool6 != null && this.n != bool6.booleanValue()) {
                return false;
            }
            String str5 = aVar.d;
            if (str5 != null && ((str = this.a) == null || !str.equals(str5))) {
                return false;
            }
            Map<String, String> map2 = aVar.o;
            if (map2 != null && ((map = this.o) == null || !map.equals(map2))) {
                return false;
            }
            Integer num4 = aVar.p;
            if (num4 != null && this.p != num4.intValue()) {
                return false;
            }
            Location location = aVar.f;
            if (location == null || a(this.b, location)) {
                return true;
            }
            return false;
        }

        @NonNull
        /* renamed from: a */
        public a b(@NonNull ew.a aVar) {
            return new a((String) abw.a(aVar.a, this.c), (String) abw.a(aVar.b, this.d), (String) abw.a(aVar.c, this.e), (String) abw.a(aVar.d, this.a), (Boolean) abw.a(aVar.e, Boolean.valueOf(this.f)), (Location) abw.a(aVar.f, this.b), (Boolean) abw.a(aVar.g, Boolean.valueOf(this.g)), (Boolean) abw.a(aVar.h, Boolean.valueOf(this.h)), aVar.n, (Integer) abw.a(aVar.i, Integer.valueOf(this.i)), (Integer) abw.a(aVar.j, Integer.valueOf(this.j)), (Integer) abw.a(aVar.k, Integer.valueOf(this.k)), (Boolean) abw.a(aVar.l, Boolean.valueOf(this.l)), (Boolean) abw.a(aVar.m, Boolean.valueOf(this.m)), (Map) abw.a(aVar.o, this.o), (Integer) abw.a(aVar.p, Integer.valueOf(this.p)));
        }
    }

    public static abstract class b implements d {
        @NonNull
        public final df a;

        public b(@NonNull df dfVar) {
            this.a = dfVar;
        }

        @Override // com.yandex.metrica.impl.ob.we.d
        public boolean a(@Nullable Boolean bool) {
            return ((Boolean) abw.b(bool, Boolean.TRUE)).booleanValue();
        }
    }

    public static class c extends wb.a<we, a> {
        @NonNull
        private final fe c;
        @NonNull
        private final d d;

        public c(@NonNull fe feVar, @NonNull d dVar) {
            super(feVar.k(), feVar.c().b());
            this.c = feVar;
            this.d = dVar;
        }

        @Override // com.yandex.metrica.impl.ob.wb.a, com.yandex.metrica.impl.ob.vy.b
        @NonNull
        public /* synthetic */ vy c(@NonNull vy.c cVar) {
            return b((vy.c<a>) cVar);
        }

        @NonNull
        /* renamed from: a */
        public we b() {
            return new we();
        }

        @NonNull
        /* renamed from: a */
        public we b(@NonNull vy.c<a> cVar) {
            we weVar = (we) super.c(cVar);
            weVar.n(cVar.b.a);
            weVar.k(this.c.x());
            weVar.d(this.c.p());
            weVar.b(this.c.A().a());
            weVar.e(cVar.b.f);
            weVar.a(cVar.b.b);
            weVar.f(cVar.b.g);
            weVar.g(cVar.b.h);
            weVar.a(cVar.b.i);
            weVar.c(cVar.b.j);
            weVar.b(cVar.b.k);
            weVar.i(cVar.b.l);
            weVar.h(cVar.b.n);
            weVar.a(Boolean.valueOf(cVar.b.m), this.d);
            weVar.c((long) cVar.b.p);
            a(weVar, cVar.a, cVar.b.o);
            return weVar;
        }

        public void b(we weVar, yb ybVar) {
            weVar.a(ybVar.o.a);
            weVar.b(ybVar.o.b);
            weVar.c(ybVar.o.c);
            xo xoVar = ybVar.A;
            if (xoVar != null) {
                weVar.a(xoVar.a);
                weVar.b(ybVar.A.b);
            }
            weVar.d(ybVar.o.d);
        }

        @VisibleForTesting
        public void a(@NonNull we weVar, @NonNull yb ybVar, @Nullable Map<String, String> map) {
            a(weVar, ybVar);
            b(weVar, ybVar);
            weVar.a(ybVar.m);
            weVar.j(a(map, abq.a(ybVar.n)));
        }

        public boolean a(@Nullable Map<String, String> map, @Nullable Map<String, String> map2) {
            return map == null || map.isEmpty() || map.equals(map2);
        }

        public void a(we weVar, yb ybVar) {
            weVar.a(ybVar.e);
        }
    }

    public interface d {
        boolean a(@Nullable Boolean bool);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void k(boolean z) {
        this.s = z;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void n(String str) {
        this.l = str;
    }

    public boolean I() {
        return this.m;
    }

    public boolean J() {
        return this.n;
    }

    public boolean K() {
        return this.o;
    }

    public boolean L() {
        return this.p;
    }

    public long M() {
        return this.u;
    }

    public long N() {
        return this.v;
    }

    public boolean O() {
        return g() && !dl.a(b()) && ac();
    }

    public boolean P() {
        return this.s;
    }

    public boolean Q() {
        return this.a;
    }

    public Location R() {
        return this.b;
    }

    public boolean S() {
        return this.c;
    }

    public boolean T() {
        return this.d;
    }

    public boolean U() {
        return this.e;
    }

    public int V() {
        return this.f;
    }

    public int W() {
        return this.g;
    }

    public int X() {
        return this.i;
    }

    public int Y() {
        return this.t;
    }

    public long Z() {
        return this.x;
    }

    public boolean aa() {
        return this.k.a(this.j);
    }

    @Nullable
    public List<String> ab() {
        return this.y;
    }

    public boolean ac() {
        return this.w;
    }

    public List<String> b() {
        return this.r;
    }

    public String c() {
        return this.l;
    }

    public void d(boolean z) {
        this.p = z;
    }

    public void e(boolean z) {
        this.a = z;
    }

    public void f(boolean z) {
        this.c = z;
    }

    public void g(boolean z) {
        this.d = z;
    }

    public void h(boolean z) {
        this.e = z;
    }

    public void i(boolean z) {
        this.h = z;
    }

    public void j(boolean z) {
        this.w = z;
    }

    public void b(long j2) {
        this.v = j2;
    }

    public void c(boolean z) {
        this.o = z;
    }

    public void d(int i2) {
        this.t = i2;
    }

    @NonNull
    public String a() {
        return (String) abw.b(this.q, "");
    }

    public void b(boolean z) {
        this.n = z;
    }

    public void c(int i2) {
        this.i = i2;
    }

    public void a(String str) {
        this.q = str;
    }

    public void b(int i2) {
        this.g = i2;
    }

    public void c(long j2) {
        this.x = j2;
    }

    public void a(List<String> list) {
        this.r = list;
    }

    public void b(@NonNull List<String> list) {
        this.y = list;
    }

    public void a(boolean z) {
        this.m = z;
    }

    public void a(long j2) {
        this.u = j2;
    }

    public void a(Location location) {
        this.b = location;
    }

    public void a(int i2) {
        this.f = i2;
    }

    public void a(@Nullable Boolean bool, @NonNull d dVar) {
        this.j = bool;
        this.k = dVar;
    }
}
