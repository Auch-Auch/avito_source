package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import android.util.Pair;
import com.yandex.metrica.impl.ob.cg;
import com.yandex.metrica.impl.ob.sg;
import com.yandex.metrica.impl.ob.xp;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
public class vf {
    private static final Map<xp.a, cg.a> a = Collections.unmodifiableMap(new HashMap<xp.a, cg.a>() { // from class: com.yandex.metrica.impl.ob.vf.1
        {
            put(xp.a.CELL, cg.a.CELL);
            put(xp.a.WIFI, cg.a.WIFI);
        }
    });
    @NonNull
    private final Context b;
    @NonNull
    private final mx<a> c;
    @NonNull
    private final act d;
    @NonNull
    private final wx e;
    @NonNull
    private final df f;
    @NonNull
    private final aaz g;
    private a h;
    private boolean i;

    public static class a {
        @NonNull
        private final List<C0361a> a;
        @NonNull
        private final LinkedHashMap<String, Object> b = new LinkedHashMap<>();

        /* renamed from: com.yandex.metrica.impl.ob.vf$a$a  reason: collision with other inner class name */
        public static class C0361a {
            @NonNull
            public final String a;
            @NonNull
            public final String b;
            @NonNull
            public final String c;
            @NonNull
            public final acb<String, String> d;
            public final long e;
            @NonNull
            public final List<cg.a> f;

            public C0361a(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull acb<String, String> acb, long j, @NonNull List<cg.a> list) {
                this.a = str;
                this.b = str2;
                this.c = str3;
                this.e = j;
                this.f = list;
                this.d = acb;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                return this.a.equals(((C0361a) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode();
            }
        }

        public static class b {
            @Nullable
            public byte[] a;
            @Nullable
            public byte[] b;
            @NonNull
            private final C0361a c;
            @Nullable
            private EnumC0362a d;
            @Nullable
            private cg.a e;
            @Nullable
            private Integer f;
            @Nullable
            private Map<String, List<String>> g;
            @Nullable
            private Throwable h;

            /* renamed from: com.yandex.metrica.impl.ob.vf$a$b$a  reason: collision with other inner class name */
            public enum EnumC0362a {
                OFFLINE,
                INCOMPATIBLE_NETWORK_TYPE,
                COMPLETE,
                ERROR
            }

            public b(@NonNull C0361a aVar) {
                this.c = aVar;
            }

            @Nullable
            public EnumC0362a b() {
                return this.d;
            }

            @Nullable
            public cg.a c() {
                return this.e;
            }

            @Nullable
            public Integer d() {
                return this.f;
            }

            @Nullable
            public byte[] e() {
                return this.a;
            }

            @Nullable
            public Map<String, List<String>> f() {
                return this.g;
            }

            @Nullable
            public Throwable g() {
                return this.h;
            }

            @Nullable
            public byte[] h() {
                return this.b;
            }

            @NonNull
            public C0361a a() {
                return this.c;
            }

            public void b(@Nullable byte[] bArr) {
                this.b = bArr;
            }

            public void a(@NonNull EnumC0362a aVar) {
                this.d = aVar;
            }

            public void a(@Nullable cg.a aVar) {
                this.e = aVar;
            }

            public void a(@Nullable Integer num) {
                this.f = num;
            }

            public void a(@Nullable byte[] bArr) {
                this.a = bArr;
            }

            public void a(@Nullable Map<String, List<String>> map) {
                this.g = map;
            }

            public void a(@Nullable Throwable th) {
                this.h = th;
            }
        }

        public a(@NonNull List<C0361a> list, @NonNull List<String> list2) {
            this.a = list;
            if (!dl.a((Collection) list2)) {
                for (String str : list2) {
                    this.b.put(str, new Object());
                }
            }
        }

        public boolean a(@NonNull C0361a aVar) {
            if (this.b.get(aVar.a) != null || this.a.contains(aVar)) {
                return false;
            }
            this.a.add(aVar);
            return true;
        }

        @NonNull
        public List<C0361a> b() {
            return this.a;
        }

        public void b(@NonNull C0361a aVar) {
            this.b.put(aVar.a, new Object());
            this.a.remove(aVar);
        }

        @NonNull
        public Set<String> a() {
            HashSet hashSet = new HashSet();
            int i = 0;
            for (String str : this.b.keySet()) {
                hashSet.add(str);
                i++;
                if (i > 1000) {
                    break;
                }
            }
            return hashSet;
        }
    }

    public vf(@NonNull Context context, @NonNull mx<a> mxVar, @NonNull df dfVar, @NonNull wx wxVar, @NonNull act act) {
        this(context, mxVar, dfVar, wxVar, act, new aaw());
    }

    @VisibleForTesting
    public vf(@NonNull Context context, @NonNull mx<a> mxVar, @NonNull df dfVar, @NonNull wx wxVar, @NonNull act act, @NonNull aaz aaz) {
        this.i = false;
        this.b = context;
        this.c = mxVar;
        this.f = dfVar;
        this.e = wxVar;
        this.h = mxVar.a();
        this.d = act;
        this.g = aaz;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b() {
        if (!this.i) {
            this.h = this.c.a();
            c();
            this.i = true;
        }
    }

    private void c() {
        for (a.C0361a aVar : this.h.b()) {
            b(aVar);
        }
    }

    private void d() {
        this.c.a(this.h);
    }

    public synchronized void a() {
        this.d.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vf.2
            @Override // java.lang.Runnable
            public void run() {
                vf.this.b();
            }
        });
    }

    private void b(@NonNull final a.C0361a aVar) {
        this.d.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vf.4
            @Override // java.lang.Runnable
            public void run() {
                if (!vf.this.f.c()) {
                    vf.this.e.b(aVar);
                    a.b bVar = new a.b(aVar);
                    cg.a a3 = vf.this.g.a(vf.this.b);
                    bVar.a(a3);
                    if (a3 == cg.a.OFFLINE) {
                        bVar.a(a.b.EnumC0362a.OFFLINE);
                    } else if (!aVar.f.contains(a3)) {
                        bVar.a(a.b.EnumC0362a.INCOMPATIBLE_NETWORK_TYPE);
                    } else {
                        bVar.a(a.b.EnumC0362a.ERROR);
                        try {
                            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(aVar.b).openConnection();
                            Iterator<? extends Map.Entry<String, ? extends Collection<String>>> it = aVar.d.b().iterator();
                            while (it.hasNext()) {
                                Map.Entry entry = (Map.Entry) it.next();
                                httpURLConnection.setRequestProperty((String) entry.getKey(), TextUtils.join(",", (Iterable) entry.getValue()));
                            }
                            httpURLConnection.setInstanceFollowRedirects(true);
                            httpURLConnection.setRequestMethod(aVar.c);
                            int i2 = sg.a.a;
                            httpURLConnection.setConnectTimeout(i2);
                            httpURLConnection.setReadTimeout(i2);
                            httpURLConnection.connect();
                            int responseCode = httpURLConnection.getResponseCode();
                            bVar.a(a.b.EnumC0362a.COMPLETE);
                            bVar.a(Integer.valueOf(responseCode));
                            ax.a(httpURLConnection, bVar, "[ProvidedRequestService]", 102400);
                            bVar.a(httpURLConnection.getHeaderFields());
                        } catch (Throwable th) {
                            bVar.a(th);
                        }
                    }
                    vf.this.a(bVar);
                }
            }
        }, Math.max(h.a, Math.max(aVar.e - System.currentTimeMillis(), 0L)));
    }

    public synchronized void a(@NonNull final yb ybVar) {
        final List<xp> list = ybVar.x;
        this.d.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vf.3
            @Override // java.lang.Runnable
            public void run() {
                vf.this.a(list, ybVar.u);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(@Nullable List<xp> list, long j) {
        Long l;
        if (!dl.a((Collection) list)) {
            for (xp xpVar : list) {
                if (!(xpVar.a == null || xpVar.b == null || xpVar.c == null || (l = xpVar.e) == null || l.longValue() < 0 || dl.a((Collection) xpVar.f))) {
                    a(new a.C0361a(xpVar.a, xpVar.b, xpVar.c, a(xpVar.d), TimeUnit.SECONDS.toMillis(xpVar.e.longValue() + j), b(xpVar.f)));
                }
            }
        }
    }

    @NonNull
    private List<cg.a> b(@NonNull List<xp.a> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (xp.a aVar : list) {
            arrayList.add(a.get(aVar));
        }
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.yandex.metrica.impl.ob.acb<java.lang.String, java.lang.String> */
    /* JADX WARN: Multi-variable type inference failed */
    private acb<String, String> a(List<Pair<String, String>> list) {
        acb<String, String> acb = new acb<>();
        for (Pair<String, String> pair : list) {
            acb.a(pair.first, pair.second);
        }
        return acb;
    }

    private boolean a(@NonNull a.C0361a aVar) {
        boolean a3 = this.h.a(aVar);
        if (a3) {
            b(aVar);
            this.e.a(aVar);
        }
        d();
        return a3;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void a(@NonNull a.b bVar) {
        this.h.b(bVar.c);
        d();
        this.e.a(bVar);
    }
}
