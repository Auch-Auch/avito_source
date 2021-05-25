package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.impl.ob.pc;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
public class pe {
    private static final List<? extends pd> a = Arrays.asList(new com.yandex.metrica.impl.ac.a(), new pf());
    private final Object b;
    private yb c;
    private volatile FutureTask<Map<pc.a, pc>> d;
    @NonNull
    private final c e;
    @NonNull
    private final Collection<? extends pd> f;
    @Nullable
    private Context g;
    @NonNull
    private act h;
    private volatile Map<pc.a, pc> i;

    public static class a {
        @SuppressLint({"StaticFieldLeak"})
        public static final pe a = new pe(new b(), dr.k().b(), pe.a);
    }

    public static class b implements c {
        @Override // com.yandex.metrica.impl.ob.pe.c
        public boolean a(@Nullable yb ybVar) {
            return true;
        }
    }

    public interface c {
        boolean a(@Nullable yb ybVar);
    }

    public static class d {
        @SuppressLint({"StaticFieldLeak"})
        public static final pe a = new pe(new e(), as.a().k().i(), pe.a);
    }

    public static class e implements c {
        @Override // com.yandex.metrica.impl.ob.pe.c
        public boolean a(@Nullable yb ybVar) {
            return ybVar != null && (ybVar.o.p || !ybVar.v);
        }
    }

    public interface f<T> {
        T b(Future<Map<pc.a, pc>> future) throws InterruptedException, ExecutionException;
    }

    private void g() {
        if (this.g != null && !c()) {
            c(this.g);
        }
    }

    @Deprecated
    public String d() {
        g();
        if (this.i == null) {
            return null;
        }
        Map<pc.a, pc> map = this.i;
        pc.a aVar = pc.a.GOOGLE;
        if (map.containsKey(aVar)) {
            return this.i.get(aVar).b;
        }
        return null;
    }

    @Deprecated
    public Boolean e() {
        g();
        if (this.i == null) {
            return null;
        }
        Map<pc.a, pc> map = this.i;
        pc.a aVar = pc.a.GOOGLE;
        if (map.containsKey(aVar)) {
            return this.i.get(aVar).c;
        }
        return null;
    }

    private pe(@NonNull c cVar, @NonNull act act, @NonNull Collection<? extends pd> collection) {
        this.b = new Object();
        this.i = null;
        this.e = cVar;
        this.f = collection;
        this.h = act;
        eh.a().a(this, er.class, el.a(new ek<er>() { // from class: com.yandex.metrica.impl.ob.pe.1
            public void a(er erVar) {
                synchronized (pe.this.b) {
                    pe.this.c = erVar.b;
                }
            }
        }).a());
    }

    public static pe b() {
        return a.a;
    }

    @NonNull
    public Map<pc.a, pc> c(@NonNull Context context) {
        if (!this.e.a(this.c)) {
            return Collections.emptyMap();
        }
        Map<pc.a, pc> map = (Map) a(context, new f<Map<pc.a, pc>>() { // from class: com.yandex.metrica.impl.ob.pe.3
            /* renamed from: a */
            public Map<pc.a, pc> b(Future<Map<pc.a, pc>> future) throws InterruptedException, ExecutionException {
                return future.get();
            }
        });
        return map == null ? Collections.emptyMap() : map;
    }

    public void b(@NonNull final Context context) {
        this.g = context.getApplicationContext();
        if (this.d == null) {
            synchronized (this.b) {
                if (this.d == null && this.e.a(this.c)) {
                    this.d = new FutureTask<>(new Callable<Map<pc.a, pc>>() { // from class: com.yandex.metrica.impl.ob.pe.2
                        /* renamed from: a */
                        public Map<pc.a, pc> call() {
                            EnumMap enumMap = new EnumMap(pc.a.class);
                            for (pd pdVar : pe.this.f) {
                                pc a3 = pdVar.a(context);
                                if (a3 != null) {
                                    enumMap.put((EnumMap) a3.a, (pc.a) a3);
                                }
                            }
                            pe.this.i = enumMap.isEmpty() ? null : Collections.unmodifiableMap(enumMap);
                            return pe.this.i;
                        }
                    });
                    this.h.a(this.d);
                }
            }
        }
    }

    public static pe a() {
        return d.a;
    }

    public void a(@NonNull Context context) {
        this.g = context.getApplicationContext();
    }

    public void a(@NonNull Context context, @NonNull yb ybVar) {
        this.c = ybVar;
        b(context);
    }

    public synchronized boolean c() {
        return this.i != null;
    }

    private <T> T a(Context context, f<T> fVar) {
        b(context);
        try {
            return fVar.b(this.d);
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }
}
