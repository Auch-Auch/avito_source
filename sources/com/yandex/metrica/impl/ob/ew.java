package com.yandex.metrica.impl.ob;

import android.location.Location;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.impl.ob.wf;
import java.util.Map;
public class ew {
    public final wf.a a;
    public final a b;
    @Nullable
    public final ResultReceiver c;

    public static class a implements vx<a, a> {
        @Nullable
        public final String a;
        @Nullable
        public final String b;
        @Nullable
        public final String c;
        @Nullable
        public final String d;
        @Nullable
        public final Boolean e;
        @Nullable
        public final Location f;
        @Nullable
        public final Boolean g;
        @Nullable
        public final Boolean h;
        @Nullable
        public final Integer i;
        @Nullable
        public final Integer j;
        @Nullable
        public final Integer k;
        @Nullable
        public final Boolean l;
        @Nullable
        public final Boolean m;
        @Nullable
        public final Boolean n;
        @Nullable
        public final Map<String, String> o;
        @Nullable
        public final Integer p;
        @Nullable
        public final Boolean q;
        @Nullable
        public final Boolean r;

        public a(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Boolean bool, @Nullable Location location, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Boolean bool5, @Nullable Boolean bool6, @Nullable Map<String, String> map, @Nullable Integer num4, @Nullable Boolean bool7, @Nullable Boolean bool8) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = bool;
            this.f = location;
            this.g = bool2;
            this.h = bool3;
            this.n = bool4;
            this.i = num;
            this.j = num2;
            this.k = num3;
            this.l = bool5;
            this.m = bool6;
            this.o = map;
            this.p = num4;
            this.q = bool7;
            this.r = bool8;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            String str = this.a;
            if (str == null ? aVar.a != null : !str.equals(aVar.a)) {
                return false;
            }
            String str2 = this.b;
            if (str2 == null ? aVar.b != null : !str2.equals(aVar.b)) {
                return false;
            }
            String str3 = this.c;
            if (str3 == null ? aVar.c != null : !str3.equals(aVar.c)) {
                return false;
            }
            String str4 = this.d;
            if (str4 == null ? aVar.d != null : !str4.equals(aVar.d)) {
                return false;
            }
            Boolean bool = this.e;
            if (bool == null ? aVar.e != null : !bool.equals(aVar.e)) {
                return false;
            }
            Location location = this.f;
            if (location == null ? aVar.f != null : !location.equals(aVar.f)) {
                return false;
            }
            Boolean bool2 = this.g;
            if (bool2 == null ? aVar.g != null : !bool2.equals(aVar.g)) {
                return false;
            }
            Boolean bool3 = this.h;
            if (bool3 == null ? aVar.h != null : !bool3.equals(aVar.h)) {
                return false;
            }
            Integer num = this.i;
            if (num == null ? aVar.i != null : !num.equals(aVar.i)) {
                return false;
            }
            Integer num2 = this.j;
            if (num2 == null ? aVar.j != null : !num2.equals(aVar.j)) {
                return false;
            }
            Integer num3 = this.k;
            if (num3 == null ? aVar.k != null : !num3.equals(aVar.k)) {
                return false;
            }
            Boolean bool4 = this.l;
            if (bool4 == null ? aVar.l != null : !bool4.equals(aVar.l)) {
                return false;
            }
            Boolean bool5 = this.m;
            if (bool5 == null ? aVar.m != null : !bool5.equals(aVar.m)) {
                return false;
            }
            Boolean bool6 = this.n;
            if (bool6 == null ? aVar.n != null : !bool6.equals(aVar.n)) {
                return false;
            }
            Map<String, String> map = this.o;
            if (map == null ? aVar.o != null : !map.equals(aVar.o)) {
                return false;
            }
            Integer num4 = this.p;
            if (num4 == null ? aVar.p != null : !num4.equals(aVar.p)) {
                return false;
            }
            Boolean bool7 = this.q;
            Boolean bool8 = aVar.q;
            if (bool7 != null) {
                return bool7.equals(bool8);
            }
            if (bool8 == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            String str = this.a;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.c;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.d;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            Boolean bool = this.e;
            int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
            Location location = this.f;
            int hashCode6 = (hashCode5 + (location != null ? location.hashCode() : 0)) * 31;
            Boolean bool2 = this.g;
            int hashCode7 = (hashCode6 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
            Boolean bool3 = this.h;
            int hashCode8 = (hashCode7 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
            Integer num = this.i;
            int hashCode9 = (hashCode8 + (num != null ? num.hashCode() : 0)) * 31;
            Integer num2 = this.j;
            int hashCode10 = (hashCode9 + (num2 != null ? num2.hashCode() : 0)) * 31;
            Integer num3 = this.k;
            int hashCode11 = (hashCode10 + (num3 != null ? num3.hashCode() : 0)) * 31;
            Boolean bool4 = this.l;
            int hashCode12 = (hashCode11 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
            Boolean bool5 = this.m;
            int hashCode13 = (hashCode12 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
            Boolean bool6 = this.n;
            int hashCode14 = (hashCode13 + (bool6 != null ? bool6.hashCode() : 0)) * 31;
            Map<String, String> map = this.o;
            int hashCode15 = (hashCode14 + (map != null ? map.hashCode() : 0)) * 31;
            Integer num4 = this.p;
            int hashCode16 = (hashCode15 + (num4 != null ? num4.hashCode() : 0)) * 31;
            Boolean bool7 = this.q;
            if (bool7 != null) {
                i2 = bool7.hashCode();
            }
            return hashCode16 + i2;
        }

        @NonNull
        /* renamed from: a */
        public a b(@NonNull a aVar) {
            return new a((String) abw.a(this.a, aVar.a), (String) abw.a(this.b, aVar.b), (String) abw.a(this.c, aVar.c), (String) abw.a(this.d, aVar.d), (Boolean) abw.a(this.e, aVar.e), (Location) abw.a(this.f, aVar.f), (Boolean) abw.a(this.g, aVar.g), (Boolean) abw.a(this.h, aVar.h), (Boolean) abw.a(this.n, aVar.n), (Integer) abw.a(this.i, aVar.i), (Integer) abw.a(this.j, aVar.j), (Integer) abw.a(this.k, aVar.k), (Boolean) abw.a(this.l, aVar.l), (Boolean) abw.a(this.m, aVar.m), (Map) abw.a(this.o, aVar.o), (Integer) abw.a(this.p, aVar.p), (Boolean) abw.a(this.q, aVar.q), (Boolean) abw.a(this.r, aVar.r));
        }

        /* renamed from: b */
        public boolean a(@NonNull a aVar) {
            return equals(aVar);
        }

        public a(@NonNull CounterConfiguration counterConfiguration, @Nullable Map<String, String> map) {
            this(counterConfiguration.d(), counterConfiguration.g(), counterConfiguration.h(), counterConfiguration.e(), counterConfiguration.f(), counterConfiguration.k(), counterConfiguration.o(), counterConfiguration.l(), counterConfiguration.i(), counterConfiguration.c(), counterConfiguration.b(), counterConfiguration.a(), counterConfiguration.j(), counterConfiguration.q(), map, counterConfiguration.p(), counterConfiguration.m(), counterConfiguration.n());
        }

        public a() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        }
    }

    public ew(@NonNull et etVar) {
        this(new wf.a(etVar), new a(etVar.h(), etVar.g().c()), etVar.g().j());
    }

    public ew(@NonNull wf.a aVar, @NonNull a aVar2, @Nullable ResultReceiver resultReceiver) {
        this.a = aVar;
        this.b = aVar2;
        this.c = resultReceiver;
    }
}
