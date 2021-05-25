package a2.d.a.d.b;

import a2.d.a.d.b.h;
import a2.d.a.d.b.m;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
public class i<R> implements h.a<R>, FactoryPools.Poolable {
    public static final c y = new c();
    public final e a = new e();
    public final StateVerifier b = StateVerifier.newInstance();
    public final m.a c;
    public final Pools.Pool<i<?>> d;
    public final c e;
    public final j f;
    public final GlideExecutor g;
    public final GlideExecutor h;
    public final GlideExecutor i;
    public final GlideExecutor j;
    public final AtomicInteger k = new AtomicInteger();
    public Key l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public Resource<?> q;
    public DataSource r;
    public boolean s;
    public GlideException t;
    public boolean u;
    public m<?> v;
    public h<R> w;
    public volatile boolean x;

    public class a implements Runnable {
        public final ResourceCallback a;

        public a(ResourceCallback resourceCallback) {
            this.a = resourceCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.a.getLock()) {
                synchronized (i.this) {
                    if (i.this.a.a.contains(new d(this.a, Executors.directExecutor()))) {
                        i iVar = i.this;
                        ResourceCallback resourceCallback = this.a;
                        Objects.requireNonNull(iVar);
                        try {
                            resourceCallback.onLoadFailed(iVar.t);
                        } catch (Throwable th) {
                            throw new c(th);
                        }
                    }
                    i.this.b();
                }
            }
        }
    }

    public class b implements Runnable {
        public final ResourceCallback a;

        public b(ResourceCallback resourceCallback) {
            this.a = resourceCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.a.getLock()) {
                synchronized (i.this) {
                    if (i.this.a.a.contains(new d(this.a, Executors.directExecutor()))) {
                        i.this.v.a();
                        i iVar = i.this;
                        ResourceCallback resourceCallback = this.a;
                        Objects.requireNonNull(iVar);
                        try {
                            resourceCallback.onResourceReady(iVar.v, iVar.r);
                            i.this.f(this.a);
                        } catch (Throwable th) {
                            throw new c(th);
                        }
                    }
                    i.this.b();
                }
            }
        }
    }

    @VisibleForTesting
    public static class c {
    }

    public static final class d {
        public final ResourceCallback a;
        public final Executor b;

        public d(ResourceCallback resourceCallback, Executor executor) {
            this.a = resourceCallback;
            this.b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.a.equals(((d) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    public static final class e implements Iterable<d> {
        public final List<d> a = new ArrayList(2);

        public boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override // java.lang.Iterable
        @NonNull
        public Iterator<d> iterator() {
            return this.a.iterator();
        }
    }

    public i(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, j jVar, m.a aVar, Pools.Pool<i<?>> pool) {
        c cVar = y;
        this.g = glideExecutor;
        this.h = glideExecutor2;
        this.i = glideExecutor3;
        this.j = glideExecutor4;
        this.f = jVar;
        this.c = aVar;
        this.d = pool;
        this.e = cVar;
    }

    public synchronized void a(ResourceCallback resourceCallback, Executor executor) {
        this.b.throwIfRecycled();
        this.a.a.add(new d(resourceCallback, executor));
        boolean z = true;
        if (this.s) {
            c(1);
            executor.execute(new b(resourceCallback));
        } else if (this.u) {
            c(1);
            executor.execute(new a(resourceCallback));
        } else {
            if (this.x) {
                z = false;
            }
            Preconditions.checkArgument(z, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    public void b() {
        m<?> mVar;
        synchronized (this) {
            this.b.throwIfRecycled();
            Preconditions.checkArgument(d(), "Not yet complete!");
            int decrementAndGet = this.k.decrementAndGet();
            Preconditions.checkArgument(decrementAndGet >= 0, "Can't decrement below 0");
            if (decrementAndGet == 0) {
                mVar = this.v;
                e();
            } else {
                mVar = null;
            }
        }
        if (mVar != null) {
            mVar.b();
        }
    }

    public synchronized void c(int i2) {
        m<?> mVar;
        Preconditions.checkArgument(d(), "Not yet complete!");
        if (this.k.getAndAdd(i2) == 0 && (mVar = this.v) != null) {
            mVar.a();
        }
    }

    public final boolean d() {
        return this.u || this.s || this.x;
    }

    public final synchronized void e() {
        boolean a3;
        if (this.l != null) {
            this.a.a.clear();
            this.l = null;
            this.v = null;
            this.q = null;
            this.u = false;
            this.x = false;
            this.s = false;
            h<R> hVar = this.w;
            h.e eVar = hVar.g;
            synchronized (eVar) {
                eVar.a = true;
                a3 = eVar.a(false);
            }
            if (a3) {
                hVar.h();
            }
            this.w = null;
            this.t = null;
            this.r = null;
            this.d.release(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public synchronized void f(ResourceCallback resourceCallback) {
        this.b.throwIfRecycled();
        this.a.a.remove(new d(resourceCallback, Executors.directExecutor()));
        if (this.a.isEmpty()) {
            boolean z = true;
            if (!d()) {
                this.x = true;
                h<R> hVar = this.w;
                hVar.E = true;
                DataFetcherGenerator dataFetcherGenerator = hVar.C;
                if (dataFetcherGenerator != null) {
                    dataFetcherGenerator.cancel();
                }
                this.f.onEngineJobCancelled(this, this.l);
            }
            if (!this.s) {
                if (!this.u) {
                    z = false;
                }
            }
            if (z && this.k.get() == 0) {
                e();
            }
        }
    }

    public void g(h<?> hVar) {
        GlideExecutor glideExecutor;
        if (this.n) {
            glideExecutor = this.i;
        } else {
            glideExecutor = this.o ? this.j : this.h;
        }
        glideExecutor.execute(hVar);
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    @NonNull
    public StateVerifier getVerifier() {
        return this.b;
    }
}
