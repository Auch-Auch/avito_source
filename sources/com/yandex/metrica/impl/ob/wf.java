package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.impl.ob.vy;
import com.yandex.metrica.impl.ob.wb;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
public class wf extends wb {
    @Nullable
    private List<String> a;
    @Nullable
    private List<String> b;
    @Nullable
    private String c;
    @Nullable
    private String d;
    @Nullable
    private Map<String, String> e;
    @Nullable
    private List<String> f;
    private boolean g;
    private boolean h;
    private String i;
    private long j;

    public static class a extends vy.a<a, a> implements vx<a, a> {
        @Nullable
        public final String a;
        @Nullable
        public final String b;
        @Nullable
        public final Map<String, String> f;
        public final boolean g;
        @Nullable
        public final List<String> h;

        public a(@NonNull et etVar) {
            this(etVar.h().d(), etVar.h().g(), etVar.h().h(), etVar.g().d(), etVar.g().e(), etVar.g().c(), etVar.g().a(), etVar.g().b());
        }

        @NonNull
        /* renamed from: c */
        public a b(@NonNull a aVar) {
            return new a((String) abw.a(this.c, aVar.c), (String) abw.a(this.d, aVar.d), (String) abw.a(this.e, aVar.e), (String) abw.a(this.a, aVar.a), (String) abw.a(this.b, aVar.b), (Map) abw.a(this.f, aVar.f), a(aVar), b(aVar));
        }

        /* renamed from: d */
        public boolean a(@NonNull a aVar) {
            return false;
        }

        public boolean a(@NonNull a aVar) {
            boolean z = aVar.g;
            return z ? z : this.g;
        }

        public List<String> b(@NonNull a aVar) {
            return aVar.g ? aVar.h : this.h;
        }

        public a(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Map<String, String> map, boolean z, @Nullable List<String> list) {
            super(str, str2, str3);
            this.a = str4;
            this.b = str5;
            this.f = map;
            this.g = z;
            this.h = list;
        }

        public a() {
            this(null, null, null, null, null, null, false, null);
        }
    }

    public static class b extends wb.a<wf, a> {
        public b(@NonNull Context context, @NonNull String str) {
            this(context, str, new ado());
        }

        @Override // com.yandex.metrica.impl.ob.wb.a, com.yandex.metrica.impl.ob.vy.b
        public /* synthetic */ vy c(@NonNull vy.c cVar) {
            return b((vy.c<a>) cVar);
        }

        public b(@NonNull Context context, @NonNull String str, @NonNull ado ado) {
            super(context, str, ado);
        }

        @NonNull
        /* renamed from: a */
        public wf b() {
            return new wf();
        }

        /* renamed from: a */
        public wf b(@NonNull vy.c<a> cVar) {
            wf wfVar = (wf) super.c(cVar);
            a(wfVar, cVar.a);
            wfVar.n((String) abw.a(cVar.b.a, cVar.a.s));
            wfVar.o((String) abw.a(cVar.b.b, cVar.a.t));
            wfVar.b(cVar.b.f);
            wfVar.b(cVar.b.g);
            wfVar.c(cVar.b.h);
            wfVar.a(cVar.a.v);
            wfVar.a(cVar.a.y);
            wfVar.a(cVar.a.G);
            return wfVar;
        }

        public void a(@NonNull wf wfVar, @NonNull yb ybVar) {
            wfVar.b(ybVar.j);
            wfVar.a(ybVar.k);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void n(@Nullable String str) {
        this.c = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void o(@Nullable String str) {
        this.d = str;
    }

    public List<String> I() {
        return this.b;
    }

    @Nullable
    public Map<String, String> J() {
        return this.e;
    }

    @Nullable
    public String K() {
        return this.c;
    }

    @Nullable
    public String L() {
        return this.d;
    }

    @Nullable
    public List<String> M() {
        return this.f;
    }

    @Nullable
    public boolean N() {
        return this.g;
    }

    public String O() {
        return this.i;
    }

    public long c() {
        return this.j;
    }

    @Override // com.yandex.metrica.impl.ob.wb
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("StartupRequestConfig{mStartupHostsFromStartup=");
        L.append(this.a);
        L.append(", mStartupHostsFromClient=");
        L.append(this.b);
        L.append(", mDistributionReferrer='");
        a2.b.a.a.a.k1(L, this.c, '\'', ", mClidsFromClient=");
        L.append(this.e);
        L.append(", mNewCustomHosts=");
        L.append(this.f);
        L.append(", mHasNewCustomHosts=");
        L.append(this.g);
        L.append(", mSuccessfulStartup=");
        L.append(this.h);
        L.append(", mCountryInit='");
        a2.b.a.a.a.k1(L, this.i, '\'', ", mFirstStartupTime='");
        L.append(this.j);
        L.append('\'');
        L.append('}');
        return L.toString();
    }

    private wf() {
        this.j = 0;
    }

    public List<String> a() {
        ArrayList arrayList = new ArrayList();
        if (!dl.a((Collection) this.a)) {
            arrayList.addAll(this.a);
        }
        if (!dl.a((Collection) this.b)) {
            arrayList.addAll(this.b);
        }
        arrayList.add("https://startup.mobile.yandex.net/");
        return arrayList;
    }

    public boolean b() {
        return this.h;
    }

    public void c(@Nullable List<String> list) {
        this.f = list;
    }

    public long b(long j2) {
        a(j2);
        return c();
    }

    public void b(@Nullable Map<String, String> map) {
        this.e = map;
    }

    public void b(@Nullable List<String> list) {
        this.a = list;
    }

    public void b(boolean z) {
        this.g = z;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public void a(long j2) {
        if (this.j == 0) {
            this.j = j2;
        }
    }

    public void a(@Nullable List<String> list) {
        this.b = list;
    }

    public void a(String str) {
        this.i = str;
    }
}
