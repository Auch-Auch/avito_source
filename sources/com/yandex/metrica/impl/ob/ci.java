package com.yandex.metrica.impl.ob;

import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import com.avito.android.db.SearchSubscriptionsContract;
import com.yandex.metrica.impl.ob.al;
import com.yandex.metrica.impl.ob.p;
import com.yandex.metrica.impl.ob.qm;
import com.yandex.metrica.impl.ob.uu;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
public final class ci {
    private static Map<jy, Integer> a;
    private static SparseArray<jy> b;
    private static final Map<al.a, Integer> c;
    private static final Map<al.a, tp> d;

    /* renamed from: com.yandex.metrica.impl.ob.ci$4  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            qm.a.values();
            int[] iArr = new int[4];
            c = iArr;
            try {
                qm.a aVar = qm.a.VISIBLE;
                iArr[3] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = c;
                qm.a aVar2 = qm.a.FOREGROUND;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = c;
                qm.a aVar3 = qm.a.BACKGROUND;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            p.a.EnumC0340a.values();
            int[] iArr4 = new int[5];
            b = iArr4;
            try {
                p.a.EnumC0340a aVar4 = p.a.EnumC0340a.NONE;
                iArr4[1] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = b;
                p.a.EnumC0340a aVar5 = p.a.EnumC0340a.USB;
                iArr5[2] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                int[] iArr6 = b;
                p.a.EnumC0340a aVar6 = p.a.EnumC0340a.AC;
                iArr6[4] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                int[] iArr7 = b;
                p.a.EnumC0340a aVar7 = p.a.EnumC0340a.WIRELESS;
                iArr7[3] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            al.a.values();
            int[] iArr8 = new int[43];
            a = iArr8;
            try {
                al.a aVar8 = al.a.EVENT_TYPE_INIT;
                iArr8[1] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                int[] iArr9 = a;
                al.a aVar9 = al.a.EVENT_TYPE_FIRST_ACTIVATION;
                iArr9[33] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                int[] iArr10 = a;
                al.a aVar10 = al.a.EVENT_TYPE_APP_UPDATE;
                iArr10[37] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        jy jyVar = jy.FOREGROUND;
        hashMap.put(jyVar, 0);
        jy jyVar2 = jy.BACKGROUND;
        hashMap.put(jyVar2, 1);
        a = Collections.unmodifiableMap(hashMap);
        SparseArray<jy> sparseArray = new SparseArray<>();
        sparseArray.put(0, jyVar);
        sparseArray.put(1, jyVar2);
        b = sparseArray;
        HashMap hashMap2 = new HashMap();
        hashMap2.put(al.a.EVENT_TYPE_INIT, 1);
        al.a aVar = al.a.EVENT_TYPE_REGULAR;
        hashMap2.put(aVar, 4);
        al.a aVar2 = al.a.EVENT_TYPE_SEND_REFERRER;
        hashMap2.put(aVar2, 5);
        al.a aVar3 = al.a.EVENT_TYPE_ALIVE;
        hashMap2.put(aVar3, 7);
        al.a aVar4 = al.a.EVENT_TYPE_EXCEPTION_UNHANDLED;
        hashMap2.put(aVar4, 3);
        al.a aVar5 = al.a.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF;
        hashMap2.put(aVar5, 26);
        al.a aVar6 = al.a.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_INTENT;
        hashMap2.put(aVar6, 26);
        al.a aVar7 = al.a.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE;
        hashMap2.put(aVar7, 26);
        al.a aVar8 = al.a.EVENT_TYPE_ANR;
        hashMap2.put(aVar8, 25);
        al.a aVar9 = al.a.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH;
        hashMap2.put(aVar9, 3);
        al.a aVar10 = al.a.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH;
        hashMap2.put(aVar10, 3);
        al.a aVar11 = al.a.EVENT_TYPE_EXCEPTION_USER;
        hashMap2.put(aVar11, 6);
        al.a aVar12 = al.a.EVENT_TYPE_EXCEPTION_USER_PROTOBUF;
        hashMap2.put(aVar12, 27);
        al.a aVar13 = al.a.EVENT_TYPE_IDENTITY;
        hashMap2.put(aVar13, 8);
        hashMap2.put(al.a.EVENT_TYPE_IDENTITY_LIGHT, 28);
        al.a aVar14 = al.a.EVENT_TYPE_STATBOX;
        hashMap2.put(aVar14, 11);
        al.a aVar15 = al.a.EVENT_TYPE_SET_USER_INFO;
        hashMap2.put(aVar15, 12);
        al.a aVar16 = al.a.EVENT_TYPE_REPORT_USER_INFO;
        hashMap2.put(aVar16, 12);
        hashMap2.put(al.a.EVENT_TYPE_FIRST_ACTIVATION, 13);
        al.a aVar17 = al.a.EVENT_TYPE_START;
        hashMap2.put(aVar17, 2);
        al.a aVar18 = al.a.EVENT_TYPE_APP_OPEN;
        hashMap2.put(aVar18, 16);
        hashMap2.put(al.a.EVENT_TYPE_APP_UPDATE, 17);
        al.a aVar19 = al.a.EVENT_TYPE_PERMISSIONS;
        hashMap2.put(aVar19, 18);
        al.a aVar20 = al.a.EVENT_TYPE_APP_FEATURES;
        hashMap2.put(aVar20, 19);
        al.a aVar21 = al.a.EVENT_TYPE_SEND_USER_PROFILE;
        hashMap2.put(aVar21, 20);
        al.a aVar22 = al.a.EVENT_TYPE_SEND_REVENUE_EVENT;
        hashMap2.put(aVar22, 21);
        hashMap2.put(al.a.EVENT_TYPE_CLEANUP, 29);
        al.a aVar23 = al.a.EVENT_TYPE_VIEW_TREE;
        hashMap2.put(aVar23, 30);
        c = Collections.unmodifiableMap(hashMap2);
        HashMap hashMap3 = new HashMap();
        tk tkVar = new tk();
        tm tmVar = new tm();
        tl tlVar = new tl();
        tj tjVar = new tj();
        tp tpVar = new tp(new tx() { // from class: com.yandex.metrica.impl.ob.ci.1
            @Override // com.yandex.metrica.impl.ob.tx
            @NonNull
            public byte[] a(@NonNull to toVar) {
                if (TextUtils.isEmpty(toVar.b)) {
                    return new byte[0];
                }
                return dh.c(ax.c(toVar.b));
            }
        });
        tp tpVar2 = new tp(tmVar);
        tp tpVar3 = new tp(tjVar);
        tp tpVar4 = new tp(tkVar);
        hashMap3.put(aVar, tpVar2);
        hashMap3.put(aVar2, new tp(new tx() { // from class: com.yandex.metrica.impl.ob.ci.2
            @Override // com.yandex.metrica.impl.ob.tx
            @NonNull
            public byte[] a(@NonNull to toVar) {
                byte[] bArr;
                if (!TextUtils.isEmpty(toVar.b)) {
                    try {
                        vu a3 = vu.a(Base64.decode(toVar.b, 0));
                        uv uvVar = new uv();
                        String str = a3.a;
                        if (str == null) {
                            bArr = new byte[0];
                        } else {
                            bArr = str.getBytes();
                        }
                        uvVar.b = bArr;
                        uvVar.d = a3.b;
                        uvVar.c = a3.c;
                        return e.a(uvVar);
                    } catch (Throwable unused) {
                    }
                }
                return new byte[0];
            }
        }));
        hashMap3.put(aVar3, new tp(tkVar, tlVar));
        hashMap3.put(aVar9, tpVar);
        hashMap3.put(aVar10, tpVar);
        hashMap3.put(aVar11, tpVar2);
        hashMap3.put(aVar12, tpVar3);
        hashMap3.put(aVar13, new tp(new tv(), tmVar, new tr(), new tu()));
        hashMap3.put(aVar14, tpVar2);
        hashMap3.put(aVar15, tpVar2);
        hashMap3.put(aVar16, tpVar2);
        hashMap3.put(aVar4, tpVar2);
        hashMap3.put(aVar5, tpVar3);
        hashMap3.put(aVar6, tpVar3);
        hashMap3.put(aVar7, tpVar3);
        hashMap3.put(aVar8, tpVar3);
        hashMap3.put(aVar17, new tp(new tk(), tjVar));
        hashMap3.put(al.a.EVENT_TYPE_CUSTOM_EVENT, new tp(new tq() { // from class: com.yandex.metrica.impl.ob.ci.3
            @Override // com.yandex.metrica.impl.ob.tq
            @Nullable
            public Integer a(@NonNull to toVar) {
                return toVar.k;
            }
        }));
        hashMap3.put(aVar18, tpVar2);
        hashMap3.put(aVar19, tpVar4);
        hashMap3.put(aVar20, tpVar4);
        hashMap3.put(aVar21, tpVar3);
        hashMap3.put(aVar22, tpVar3);
        hashMap3.put(aVar23, tpVar2);
        d = Collections.unmodifiableMap(hashMap3);
    }

    @NonNull
    public static uu.c.g a(ContentValues contentValues) {
        return a(contentValues.getAsLong("start_time"), contentValues.getAsLong("server_time_offset"), contentValues.getAsBoolean("obtained_before_first_sync"));
    }

    public static void a(uu.c.e eVar) {
    }

    @NonNull
    private static uu.d b(JSONObject jSONObject) {
        try {
            uu.d dVar = new uu.d();
            dVar.b = jSONObject.getString("mac");
            dVar.c = jSONObject.getInt("signal_strength");
            dVar.d = jSONObject.getString(SearchSubscriptionsContract.Columns.SSID);
            dVar.e = jSONObject.optBoolean("is_connected");
            dVar.f = jSONObject.optLong("last_visible_offset_seconds", 0);
            return dVar;
        } catch (Throwable unused) {
            uu.d dVar2 = new uu.d();
            dVar2.b = jSONObject.optString("mac");
            return dVar2;
        }
    }

    public static uu.c.f a(zi ziVar) {
        uu.c.f fVar = new uu.c.f();
        if (ziVar.a() != null) {
            fVar.b = ziVar.a().intValue();
        }
        if (ziVar.b() != null) {
            fVar.c = ziVar.b().intValue();
        }
        if (!TextUtils.isEmpty(ziVar.d())) {
            fVar.d = ziVar.d();
        }
        fVar.e = ziVar.c();
        if (!TextUtils.isEmpty(ziVar.e())) {
            fVar.f = ziVar.e();
        }
        return fVar;
    }

    @Nullable
    public static uu.a[] b(@NonNull JSONArray jSONArray) {
        uu.a[] aVarArr = null;
        try {
            aVarArr = new uu.a[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    aVarArr[i] = a(optJSONObject);
                }
            }
        } catch (Throwable unused) {
        }
        return aVarArr;
    }

    @NonNull
    public static jy a(int i) {
        jy jyVar = b.get(i);
        return jyVar == null ? jy.FOREGROUND : jyVar;
    }

    public static uu.d[] a(JSONArray jSONArray) {
        uu.d[] dVarArr = null;
        try {
            dVarArr = new uu.d[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                dVarArr[i] = b(jSONArray.getJSONObject(i));
            }
        } catch (Throwable unused) {
        }
        return dVarArr;
    }

    private static uu.c.g a(@Nullable Long l) {
        uu.c.g gVar = new uu.c.g();
        if (l != null) {
            gVar.b = l.longValue();
            gVar.c = abu.a(l.longValue());
        }
        return gVar;
    }

    @NonNull
    private static uu.c.g a(@Nullable Long l, @Nullable Long l2, @Nullable Boolean bool) {
        uu.c.g a3 = a(l);
        if (l2 != null) {
            a3.d = l2.longValue();
        }
        if (bool != null) {
            a3.e = bool.booleanValue();
        }
        return a3;
    }

    @NonNull
    public static uu.c.e.b a(@NonNull String str, int i, @NonNull uu.c.g gVar) {
        uu.c.e.b bVar = new uu.c.e.b();
        bVar.b = gVar;
        bVar.c = str;
        bVar.d = i;
        return bVar;
    }

    public static int a(@NonNull jy jyVar) {
        Integer num = a.get(jyVar);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Nullable
    public static uu.c.C0343c[] a(Context context) {
        List<bx> c2 = dn.a(context).c();
        if (dl.a((Collection) c2)) {
            return null;
        }
        uu.c.C0343c[] cVarArr = new uu.c.C0343c[c2.size()];
        for (int i = 0; i < c2.size(); i++) {
            uu.c.C0343c cVar = new uu.c.C0343c();
            bx bxVar = c2.get(i);
            cVar.b = bxVar.a;
            cVar.c = bxVar.b;
            cVarArr[i] = cVar;
        }
        return cVarArr;
    }

    @NonNull
    public static tp a(@Nullable al.a aVar, boolean z) {
        tp tpVar;
        if (aVar != null) {
            int i = AnonymousClass4.a[aVar.ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                tpVar = z ? new tp(new tm()) : new tp(new tl());
            } else {
                tpVar = d.get(aVar);
            }
        } else {
            tpVar = null;
        }
        return tpVar == null ? new tp() : tpVar;
    }

    @NonNull
    public static uu.a a(JSONObject jSONObject) {
        uu.a aVar = new uu.a();
        int optInt = jSONObject.optInt("signal_strength", aVar.c);
        if (optInt != -1) {
            aVar.c = optInt;
        }
        aVar.b = jSONObject.optInt("cell_id", aVar.b);
        aVar.d = jSONObject.optInt("lac", aVar.d);
        aVar.e = jSONObject.optInt("country_code", aVar.e);
        aVar.f = jSONObject.optInt("operator_id", aVar.f);
        aVar.g = jSONObject.optString("operator_name", aVar.g);
        aVar.h = jSONObject.optBoolean("is_connected", aVar.h);
        aVar.i = jSONObject.optInt("cell_type", 0);
        aVar.j = jSONObject.optInt("pci", aVar.j);
        aVar.k = jSONObject.optLong("last_visible_time_offset", aVar.k);
        return aVar;
    }

    @Nullable
    public static Integer a(@Nullable al.a aVar) {
        if (aVar == null) {
            return null;
        }
        return c.get(aVar);
    }

    public static int a(@NonNull p.a.EnumC0340a aVar) {
        int i = AnonymousClass4.b[aVar.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 4;
                if (i != 3) {
                    return i != 4 ? 0 : 3;
                }
            }
        }
        return i2;
    }

    public static int a(@NonNull qm.a aVar) {
        int i = AnonymousClass4.c[aVar.ordinal()];
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return i != 3 ? 3 : 1;
        }
        return 0;
    }
}
