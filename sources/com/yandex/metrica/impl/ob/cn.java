package com.yandex.metrica.impl.ob;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.abc;
import com.yandex.metrica.impl.ob.ca;
import com.yandex.metrica.impl.ob.i;
import com.yandex.metrica.impl.ob.uu;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
public class cn extends cb<wm> {
    public uu.c j;
    public lr k;
    public List<Long> l;
    public int m;
    public int n;
    @NonNull
    private final fe o;
    private final Map<String, String> p;
    private wc q;
    private c r;
    private final adn<byte[]> s;
    private final abl t;
    @Nullable
    private we u;
    @NonNull
    private final mo v;
    private int w;

    public static class a {
        public cn a(fe feVar) {
            return new cn(feVar);
        }
    }

    public static final class b {
        public final uu.c.e a;
        public final i.a b;
        public final boolean c;

        public b(uu.c.e eVar, i.a aVar, boolean z) {
            this.a = eVar;
            this.b = aVar;
            this.c = z;
        }
    }

    public static final class c {
        public final List<uu.c.e> a;
        public final List<Long> b;
        public final JSONObject c;

        public c(List<uu.c.e> list, List<Long> list2, JSONObject jSONObject) {
            this.a = list;
            this.b = list2;
            this.c = jSONObject;
        }
    }

    public cn(fe feVar) {
        this(feVar, feVar.j(), feVar.l(), new mo(lv.a(feVar.k()).b(feVar.c())));
    }

    public static a J() {
        return new a();
    }

    private void K() {
        wc wcVar = new wc();
        this.q = wcVar;
        ((wm) this.i).a(wcVar);
    }

    private void L() {
        this.v.e(this.w);
    }

    private void M() {
        if (this.t.c()) {
            for (int i = 0; i < this.r.a.size(); i++) {
                this.t.a(this.r.a.get(i), "Event sent");
            }
        }
    }

    @Nullable
    private Cursor N() {
        return this.k.a(this.p);
    }

    private void b(boolean z) {
        L();
        uu.c.e[] eVarArr = this.j.b;
        for (int i = 0; i < eVarArr.length; i++) {
            uu.c.e eVar = eVarArr[i];
            this.k.a(this.l.get(i).longValue(), ci.a(eVar.c.d).a(), eVar.d.length, z);
            ci.a(eVar);
        }
        this.k.a(this.o.d().a());
    }

    private int d(@Nullable byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    @Override // com.yandex.metrica.impl.ob.ca
    public void C() {
        this.o.C().c();
    }

    @Override // com.yandex.metrica.impl.ob.ca
    public void D() {
        this.o.j().c();
        this.o.C().b();
        if (x()) {
            this.o.C().a();
        }
    }

    @Override // com.yandex.metrica.impl.ob.ca
    @Nullable
    public ca.a E() {
        return ca.a.REPORT;
    }

    @Override // com.yandex.metrica.impl.ob.ca
    @Nullable
    public xq F() {
        return this.o.i().f();
    }

    @Override // com.yandex.metrica.impl.ob.cb
    public void G() {
        b(false);
    }

    @Override // com.yandex.metrica.impl.ob.cb
    public void H() {
        b(true);
    }

    @VisibleForTesting
    public uu.c.C0343c[] I() {
        uu.c.C0343c[] a3 = ci.a(this.o.k());
        if (a3 != null) {
            for (uu.c.C0343c cVar : a3) {
                this.m = b.b(cVar) + this.m;
            }
        }
        return a3;
    }

    @Override // com.yandex.metrica.impl.ob.ca
    public void a(@NonNull Uri.Builder builder) {
        ((wm) this.i).a(builder, this.u);
    }

    @Override // com.yandex.metrica.impl.ob.ca
    public void f() {
        if (x()) {
            M();
        }
        this.r = null;
    }

    @Override // com.yandex.metrica.impl.ob.ca
    @NonNull
    public String n() {
        return super.n() + "_" + this.o.c().a();
    }

    @Override // com.yandex.metrica.impl.ob.ca
    public boolean t() {
        return super.t() & (400 != k());
    }

    public void a(@NonNull ContentValues contentValues) {
        this.p.clear();
        for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
            this.p.put(entry.getKey(), entry.getValue().toString());
        }
        String asString = contentValues.getAsString("report_request_parameters");
        if (!TextUtils.isEmpty(asString)) {
            try {
                wc wcVar = new wc(new abc.a(asString));
                this.q = wcVar;
                ((wm) this.i).a(wcVar);
            } catch (Throwable unused) {
                K();
            }
        } else {
            K();
        }
    }

    private cn(@NonNull fe feVar, @NonNull lr lrVar, @NonNull abl abl, @NonNull mo moVar) {
        this(feVar, abl, lrVar, new wm(), moVar, new add(245760, "event value in ReportTask", abl));
    }

    @VisibleForTesting
    public cn(@NonNull fe feVar, @NonNull abl abl, @NonNull lr lrVar, @NonNull wm wmVar, @NonNull mo moVar, @NonNull add add) {
        super(wmVar);
        this.p = new LinkedHashMap();
        this.m = 0;
        this.n = -1;
        this.o = feVar;
        this.k = lrVar;
        this.t = abl;
        this.s = add;
        this.v = moVar;
    }

    @NonNull
    private i.a b(@NonNull ContentValues contentValues) {
        return new i.a((String) abw.b(contentValues.getAsString("app_environment"), ""), ((Long) abw.b(contentValues.getAsLong("app_environment_revision"), 0L)).longValue());
    }

    @VisibleForTesting
    public uu.c a(c cVar, uu.c.C0343c[] cVarArr, @NonNull List<String> list) {
        uu.c cVar2 = new uu.c();
        uu.c.d dVar = new uu.c.d();
        dVar.b = abw.a(this.q.b, this.u.u());
        dVar.c = abw.a(this.q.a, this.u.s());
        this.m = b.b(4, dVar) + this.m;
        cVar2.c = dVar;
        a(cVar2);
        List<uu.c.e> list2 = cVar.a;
        cVar2.b = (uu.c.e[]) list2.toArray(new uu.c.e[list2.size()]);
        cVar2.d = a(cVar.c);
        cVar2.e = cVarArr;
        cVar2.h = (String[]) list.toArray(new String[list.size()]);
        this.m = b.h(8) + this.m;
        return cVar2;
    }

    public void a(final uu.c cVar) {
        as.a().l().a(new zn() { // from class: com.yandex.metrica.impl.ob.cn.1
            private void b(zm zmVar, uu.c cVar2) {
                List<String> c2 = zmVar.c();
                if (!dl.a((Collection) c2)) {
                    cVar2.f = new String[c2.size()];
                    for (int i = 0; i < c2.size(); i++) {
                        String str = c2.get(i);
                        if (!TextUtils.isEmpty(str)) {
                            String[] strArr = cVar2.f;
                            strArr[i] = str;
                            cn cnVar = cn.this;
                            cnVar.m = b.b(strArr[i]) + cnVar.m;
                            cn cnVar2 = cn.this;
                            cnVar2.m = b.h(9) + cnVar2.m;
                        }
                    }
                }
            }

            @Override // com.yandex.metrica.impl.ob.zn
            public void a(zm zmVar) {
                b(zmVar, cVar);
                a(zmVar, cVar);
            }

            private void a(zm zmVar, uu.c cVar2) {
                List<zi> a3 = zmVar.a();
                if (!dl.a((Collection) a3)) {
                    cVar2.g = new uu.c.f[a3.size()];
                    for (int i = 0; i < a3.size(); i++) {
                        cVar2.g[i] = ci.a(a3.get(i));
                        cn cnVar = cn.this;
                        cnVar.m = b.b(cVar2.g[i]) + cnVar.m;
                        cn cnVar2 = cn.this;
                        cnVar2.m = b.h(10) + cnVar2.m;
                    }
                }
            }
        });
    }

    @Override // com.yandex.metrica.impl.ob.ca
    public boolean a() {
        List<ContentValues> d = this.o.j().d();
        if (d.isEmpty()) {
            return false;
        }
        a(d.get(0));
        we i = this.o.i();
        this.u = i;
        List<String> ab = i.ab();
        if (dl.a((Collection) ab)) {
            return false;
        }
        a(this.u.b());
        if (!this.u.O() || dl.a((Collection) s())) {
            return false;
        }
        this.l = null;
        uu.c.C0343c[] I = I();
        c a3 = a(this.u);
        this.r = a3;
        if (a3.a.isEmpty()) {
            return false;
        }
        int l2 = this.v.l() + 1;
        this.w = l2;
        ((wm) this.i).a(l2);
        uu.c a4 = a(this.r, I, ab);
        this.j = a4;
        this.l = this.r.b;
        c(e.a(a4));
        return true;
    }

    private uu.c.a[] a(JSONObject jSONObject) {
        int length = jSONObject.length();
        if (length <= 0) {
            return null;
        }
        uu.c.a[] aVarArr = new uu.c.a[length];
        Iterator<String> keys = jSONObject.keys();
        int i = 0;
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                uu.c.a aVar = new uu.c.a();
                aVar.b = next;
                aVar.c = jSONObject.getString(next);
                aVarArr[i] = aVar;
            } catch (Throwable unused) {
            }
            i++;
        }
        return aVarArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e5 A[LOOP:1: B:38:0x00df->B:40:0x00e5, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.yandex.metrica.impl.ob.cn.c a(@android.support.annotation.NonNull com.yandex.metrica.impl.ob.we r15) {
        /*
        // Method dump skipped, instructions count: 254
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.cn.a(com.yandex.metrica.impl.ob.we):com.yandex.metrica.impl.ob.cn$c");
    }

    private int a(@NonNull i.a aVar) {
        try {
            uu.c.a[] a3 = a(new JSONObject(aVar.a));
            if (a3 == null) {
                return 0;
            }
            int i = 0;
            for (uu.c.a aVar2 : a3) {
                i += b.b(7, aVar2);
            }
            return i;
        } catch (Throwable unused) {
            return 0;
        }
    }

    @VisibleForTesting
    @Nullable
    public b a(long j2, uu.c.e.b bVar, @NonNull we weVar, @NonNull List<Throwable> list) {
        Cursor cursor;
        Throwable th;
        boolean z;
        uu.c.e eVar = new uu.c.e();
        eVar.b = j2;
        eVar.c = bVar;
        b bVar2 = null;
        try {
            cursor = a(j2, ci.a(bVar.d));
            if (cursor != null) {
                try {
                    ArrayList arrayList = new ArrayList();
                    i.a aVar = null;
                    while (true) {
                        z = false;
                        if (!cursor.moveToNext()) {
                            break;
                        }
                        ContentValues contentValues = new ContentValues();
                        aax.a(cursor, contentValues);
                        uu.c.e.a a3 = a(contentValues, weVar, list);
                        if (a3 != null) {
                            i.a b2 = b(contentValues);
                            if (aVar != null) {
                                if (!aVar.equals(b2)) {
                                    z = true;
                                    break;
                                }
                            } else {
                                if (this.n < 0) {
                                    int a4 = a(b2);
                                    this.n = a4;
                                    this.m += a4;
                                }
                                aVar = b2;
                            }
                            a(a3);
                            int b3 = this.m + b.b(3, a3);
                            this.m = b3;
                            if (b3 >= 250880) {
                                break;
                            }
                            arrayList.add(a3);
                        }
                    }
                    if (arrayList.size() > 0) {
                        eVar.d = (uu.c.e.a[]) arrayList.toArray(new uu.c.e.a[arrayList.size()]);
                        bVar2 = new b(eVar, aVar, z);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        list.add(th);
                        dl.a(cursor);
                        return bVar2;
                    } catch (Throwable th3) {
                        dl.a(cursor);
                        throw th3;
                    }
                }
            } else {
                xa.a().b("protobuf_serialization_error", "no reports cursor for session: " + eVar);
            }
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
            list.add(th);
            dl.a(cursor);
            return bVar2;
        }
        dl.a(cursor);
        return bVar2;
    }

    private void a(@NonNull uu.c.e.a aVar) {
        byte[] a3 = this.s.a(aVar.f);
        byte[] bArr = aVar.f;
        if (bArr != a3) {
            aVar.k = (d(bArr) - d(a3)) + aVar.k;
            aVar.f = a3;
        }
    }

    @VisibleForTesting
    @Nullable
    public uu.c.e.a a(ContentValues contentValues, @NonNull we weVar, @NonNull List<Throwable> list) {
        try {
            to toVar = new to(contentValues);
            return ci.a(toVar.j, weVar.P()).a(toVar);
        } catch (Throwable th) {
            list.add(th);
            return null;
        }
    }

    @Nullable
    private Cursor a(long j2, @NonNull jy jyVar) {
        return this.k.a(j2, jyVar);
    }
}
