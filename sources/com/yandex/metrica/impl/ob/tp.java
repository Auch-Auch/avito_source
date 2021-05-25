package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.avito.android.db.SearchSubscriptionsContract;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.preferences.GeoContract;
import com.yandex.metrica.i;
import com.yandex.metrica.impl.ob.abc;
import com.yandex.metrica.impl.ob.p;
import com.yandex.metrica.impl.ob.qm;
import com.yandex.metrica.impl.ob.uu;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
public class tp {
    private static final ts a = new tv();
    private static final tx b = new tw();
    private static final tq c = new tu();
    private static final tn d = new tt();
    private static Map<ap, Integer> e;
    @NonNull
    private final ts f;
    @NonNull
    private final tx g;
    @NonNull
    private final tn h;
    @NonNull
    private final tq i;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(ap.FIRST_OCCURRENCE, 1);
        hashMap.put(ap.NON_FIRST_OCCURENCE, 0);
        hashMap.put(ap.UNKNOWN, -1);
        e = Collections.unmodifiableMap(hashMap);
    }

    public tp() {
        this(a, b, d, c);
    }

    @NonNull
    public uu.c.e.a a(@NonNull to toVar) {
        uu.c.e.a aVar = new uu.c.e.a();
        uu.c.e.a.b a3 = a(toVar.o, toVar.p, toVar.i, toVar.h, toVar.q);
        uu.c.b b2 = b(toVar.g);
        uu.c.e.a.C0344a a4 = a(toVar.m);
        if (a3 != null) {
            aVar.h = a3;
        }
        if (b2 != null) {
            aVar.g = b2;
        }
        String a5 = this.f.a(toVar.a);
        if (a5 != null) {
            aVar.e = a5;
        }
        aVar.f = this.g.a(toVar);
        String str = toVar.l;
        if (str != null) {
            aVar.i = str;
        }
        if (a4 != null) {
            aVar.j = a4;
        }
        Integer a6 = this.i.a(toVar);
        if (a6 != null) {
            aVar.d = a6.intValue();
        }
        Integer num = toVar.c;
        if (num != null) {
            aVar.b = (long) num.intValue();
        }
        Integer num2 = toVar.d;
        if (num2 != null) {
            aVar.p = (long) num2.intValue();
        }
        Integer num3 = toVar.e;
        if (num3 != null) {
            aVar.q = (long) num3.intValue();
        }
        Long l = toVar.f;
        if (l != null) {
            aVar.c = l.longValue();
        }
        Integer num4 = toVar.n;
        if (num4 != null) {
            aVar.k = num4.intValue();
        }
        aVar.l = this.h.a(toVar.s);
        aVar.m = f(toVar.g);
        String str2 = toVar.r;
        if (str2 != null) {
            aVar.n = str2.getBytes();
        }
        Integer num5 = null;
        ap apVar = toVar.t;
        if (apVar != null) {
            num5 = e.get(apVar);
        }
        if (num5 != null) {
            aVar.o = num5.intValue();
        }
        p.a.EnumC0340a aVar2 = toVar.u;
        if (aVar2 != null) {
            aVar.r = ci.a(aVar2);
        }
        int i2 = 3;
        qm.a aVar3 = toVar.v;
        if (aVar3 != null) {
            i2 = ci.a(aVar3);
        }
        aVar.s = i2;
        return aVar;
    }

    @VisibleForTesting
    public uu.c.b b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            abc.a aVar = new abc.a(str);
            if (!aVar.c(MessageBody.Location.LONGITUDE) || !aVar.c("lat")) {
                return null;
            }
            uu.c.b bVar = new uu.c.b();
            try {
                bVar.c = aVar.getDouble(MessageBody.Location.LONGITUDE);
                bVar.b = aVar.getDouble("lat");
                bVar.h = aVar.optInt("altitude");
                bVar.f = aVar.optInt("direction");
                bVar.e = aVar.optInt("precision");
                bVar.g = aVar.optInt("speed");
                bVar.d = TimeUnit.MILLISECONDS.toSeconds(aVar.optLong("timestamp"));
                if (aVar.c(GeoContract.PROVIDER)) {
                    String a3 = aVar.a(GeoContract.PROVIDER);
                    if ("gps".equals(a3)) {
                        bVar.i = 1;
                    } else if ("network".equals(a3)) {
                        bVar.i = 2;
                    }
                }
                if (aVar.c("original_provider")) {
                    bVar.j = aVar.a("original_provider");
                }
            } catch (Throwable unused) {
            }
            return bVar;
        } catch (Throwable unused2) {
            return null;
        }
    }

    @VisibleForTesting
    @NonNull
    public uu.d[] c(@NonNull String str) {
        uu.d[] dVarArr = new uu.d[0];
        try {
            return ci.a(new JSONArray(str));
        } catch (Throwable unused) {
            return dVarArr;
        }
    }

    @VisibleForTesting
    @Nullable
    public uu.a[] d(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return ci.b(new JSONArray(str));
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @VisibleForTesting
    @Nullable
    public uu.c.e.a.b.C0345a e(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            uu.c.e.a.b.C0345a aVar = new uu.c.e.a.b.C0345a();
            aVar.b = jSONObject.optString(SearchSubscriptionsContract.Columns.SSID);
            int optInt = jSONObject.optInt("state", -1);
            if (!(optInt == 0 || optInt == 1 || optInt == 2)) {
                if (optInt == 3) {
                    aVar.c = 2;
                } else if (optInt != 4) {
                }
                return aVar;
            }
            aVar.c = 1;
            return aVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    @VisibleForTesting
    public int f(@Nullable String str) {
        if (str == null) {
            return -1;
        }
        try {
            return new lg().a(Boolean.valueOf(new abc.a(str).getBoolean("enabled"))).intValue();
        } catch (Throwable unused) {
            return -1;
        }
    }

    public tp(@NonNull ts tsVar) {
        this(tsVar, b, d, c);
    }

    public tp(@NonNull tx txVar) {
        this(a, txVar, d, c);
    }

    public tp(@NonNull tq tqVar) {
        this(a, b, d, tqVar);
    }

    public tp(@NonNull ts tsVar, @NonNull tx txVar) {
        this(tsVar, txVar, d, c);
    }

    public tp(@NonNull ts tsVar, @NonNull tx txVar, @NonNull tn tnVar, @NonNull tq tqVar) {
        this.f = tsVar;
        this.g = txVar;
        this.h = tnVar;
        this.i = tqVar;
    }

    @VisibleForTesting
    public uu.c.e.a.b a(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        uu.c.e.a.b bVar = new uu.c.e.a.b();
        if (num != null) {
            bVar.d = num.intValue();
        }
        if (str != null) {
            bVar.e = str;
        }
        uu.a[] d2 = d(str3);
        if (d2 != null) {
            bVar.b = d2;
        }
        if (!TextUtils.isEmpty(str2)) {
            bVar.c = c(str2);
        }
        if (!TextUtils.isEmpty(str4)) {
            bVar.f = e(str4);
        }
        return bVar;
    }

    @VisibleForTesting
    @Nullable
    public uu.c.e.a.C0344a a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            i a3 = abv.a(str);
            uu.c.e.a.C0344a aVar = new uu.c.e.a.C0344a();
            if (!TextUtils.isEmpty(a3.a())) {
                aVar.b = a3.a();
            }
            if (!TextUtils.isEmpty(a3.b())) {
                aVar.c = a3.b();
            }
            if (!dl.a((Map) a3.c())) {
                aVar.d = abc.b(a3.c());
            }
            return aVar;
        } catch (Throwable unused) {
            return null;
        }
    }
}
