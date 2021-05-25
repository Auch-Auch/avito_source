package com.bumptech.glide.load.engine;

import a2.d.a.d.b.a;
import a2.d.a.d.b.h;
import a2.d.a.d.b.i;
import a2.d.a.d.b.j;
import a2.d.a.d.b.k;
import a2.d.a.d.b.l;
import a2.d.a.d.b.m;
import a2.d.a.d.b.n;
import a2.d.a.d.b.r;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskCacheAdapter;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
public class Engine implements j, MemoryCache.ResourceRemovedListener, m.a {
    public static final boolean i = Log.isLoggable("Engine", 2);
    public final n a;
    public final l b;
    public final MemoryCache c;
    public final b d;
    public final r e;
    public final c f;
    public final a g;
    public final a2.d.a.d.b.a h;

    public class LoadStatus {
        public final i<?> a;
        public final ResourceCallback b;

        public LoadStatus(ResourceCallback resourceCallback, i<?> iVar) {
            this.b = resourceCallback;
            this.a = iVar;
        }

        public void cancel() {
            synchronized (Engine.this) {
                this.a.f(this.b);
            }
        }
    }

    @VisibleForTesting
    public static class a {
        public final h.d a;
        public final Pools.Pool<h<?>> b = FactoryPools.threadSafe(150, new C0174a());
        public int c;

        /* renamed from: com.bumptech.glide.load.engine.Engine$a$a  reason: collision with other inner class name */
        public class C0174a implements FactoryPools.Factory<h<?>> {
            public C0174a() {
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            public h<?> create() {
                a aVar = a.this;
                return new h<>(aVar.a, aVar.b);
            }
        }

        public a(h.d dVar) {
            this.a = dVar;
        }
    }

    @VisibleForTesting
    public static class b {
        public final GlideExecutor a;
        public final GlideExecutor b;
        public final GlideExecutor c;
        public final GlideExecutor d;
        public final j e;
        public final m.a f;
        public final Pools.Pool<i<?>> g = FactoryPools.threadSafe(150, new a());

        public class a implements FactoryPools.Factory<i<?>> {
            public a() {
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            public i<?> create() {
                b bVar = b.this;
                return new i<>(bVar.a, bVar.b, bVar.c, bVar.d, bVar.e, bVar.f, bVar.g);
            }
        }

        public b(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, j jVar, m.a aVar) {
            this.a = glideExecutor;
            this.b = glideExecutor2;
            this.c = glideExecutor3;
            this.d = glideExecutor4;
            this.e = jVar;
            this.f = aVar;
        }
    }

    public static class c implements h.d {
        public final DiskCache.Factory a;
        public volatile DiskCache b;

        public c(DiskCache.Factory factory) {
            this.a = factory;
        }

        public DiskCache a() {
            if (this.b == null) {
                synchronized (this) {
                    if (this.b == null) {
                        this.b = this.a.build();
                    }
                    if (this.b == null) {
                        this.b = new DiskCacheAdapter();
                    }
                }
            }
            return this.b;
        }
    }

    public Engine(MemoryCache memoryCache, DiskCache.Factory factory, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, boolean z) {
        this.c = memoryCache;
        c cVar = new c(factory);
        this.f = cVar;
        a2.d.a.d.b.a aVar = new a2.d.a.d.b.a(z);
        this.h = aVar;
        synchronized (this) {
            synchronized (aVar) {
                aVar.e = this;
            }
        }
        this.b = new l();
        this.a = new n();
        this.d = new b(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, this, this);
        this.g = new a(cVar);
        this.e = new r();
        memoryCache.setResourceRemovedListener(this);
    }

    public static void b(String str, long j, Key key) {
        StringBuilder Q = a2.b.a.a.a.Q(str, " in ");
        Q.append(LogTime.getElapsedMillis(j));
        Q.append("ms, key: ");
        Q.append(key);
        Q.toString();
    }

    @Nullable
    public final m<?> a(k kVar, boolean z, long j) {
        m<?> mVar;
        m<?> mVar2;
        if (!z) {
            return null;
        }
        a2.d.a.d.b.a aVar = this.h;
        synchronized (aVar) {
            a.b bVar = aVar.c.get(kVar);
            if (bVar == null) {
                mVar = null;
            } else {
                mVar = (m) bVar.get();
                if (mVar == null) {
                    aVar.b(bVar);
                }
            }
        }
        if (mVar != null) {
            mVar.a();
        }
        if (mVar != null) {
            if (i) {
                b("Loaded resource from active resources", j, kVar);
            }
            return mVar;
        }
        Resource<?> remove = this.c.remove(kVar);
        if (remove == null) {
            mVar2 = null;
        } else if (remove instanceof m) {
            mVar2 = (m) remove;
        } else {
            mVar2 = new m<>(remove, true, true, kVar, this);
        }
        if (mVar2 != null) {
            mVar2.a();
            this.h.a(kVar, mVar2);
        }
        if (mVar2 == null) {
            return null;
        }
        if (i) {
            b("Loaded resource from cache", j, kVar);
        }
        return mVar2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r23v0, resolved type: java.lang.Class<R> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ee  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <R> com.bumptech.glide.load.engine.Engine.LoadStatus c(com.bumptech.glide.GlideContext r17, java.lang.Object r18, com.bumptech.glide.load.Key r19, int r20, int r21, java.lang.Class<?> r22, java.lang.Class<R> r23, com.bumptech.glide.Priority r24, com.bumptech.glide.load.engine.DiskCacheStrategy r25, java.util.Map<java.lang.Class<?>, com.bumptech.glide.load.Transformation<?>> r26, boolean r27, boolean r28, com.bumptech.glide.load.Options r29, boolean r30, boolean r31, boolean r32, boolean r33, com.bumptech.glide.request.ResourceCallback r34, java.util.concurrent.Executor r35, a2.d.a.d.b.k r36, long r37) {
        /*
        // Method dump skipped, instructions count: 281
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.Engine.c(com.bumptech.glide.GlideContext, java.lang.Object, com.bumptech.glide.load.Key, int, int, java.lang.Class, java.lang.Class, com.bumptech.glide.Priority, com.bumptech.glide.load.engine.DiskCacheStrategy, java.util.Map, boolean, boolean, com.bumptech.glide.load.Options, boolean, boolean, boolean, boolean, com.bumptech.glide.request.ResourceCallback, java.util.concurrent.Executor, a2.d.a.d.b.k, long):com.bumptech.glide.load.engine.Engine$LoadStatus");
    }

    public void clearDiskCache() {
        this.f.a().clear();
    }

    public <R> LoadStatus load(GlideContext glideContext, Object obj, Key key, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, Options options, boolean z3, boolean z4, boolean z5, boolean z7, ResourceCallback resourceCallback, Executor executor) {
        long logTime = i ? LogTime.getLogTime() : 0;
        Objects.requireNonNull(this.b);
        k kVar = new k(obj, key, i2, i3, map, cls, cls2, options);
        synchronized (this) {
            m<?> a3 = a(kVar, z3, logTime);
            if (a3 == null) {
                return c(glideContext, obj, key, i2, i3, cls, cls2, priority, diskCacheStrategy, map, z, z2, options, z3, z4, z5, z7, resourceCallback, executor, kVar, logTime);
            }
            resourceCallback.onResourceReady(a3, DataSource.MEMORY_CACHE);
            return null;
        }
    }

    @Override // a2.d.a.d.b.j
    public synchronized void onEngineJobCancelled(i<?> iVar, Key key) {
        n nVar = this.a;
        Objects.requireNonNull(nVar);
        Map<Key, i<?>> a3 = nVar.a(iVar.p);
        if (iVar.equals(a3.get(key))) {
            a3.remove(key);
        }
    }

    @Override // a2.d.a.d.b.j
    public synchronized void onEngineJobComplete(i<?> iVar, Key key, m<?> mVar) {
        if (mVar != null) {
            if (mVar.a) {
                this.h.a(key, mVar);
            }
        }
        n nVar = this.a;
        Objects.requireNonNull(nVar);
        Map<Key, i<?>> a3 = nVar.a(iVar.p);
        if (iVar.equals(a3.get(key))) {
            a3.remove(key);
        }
    }

    @Override // a2.d.a.d.b.m.a
    public void onResourceReleased(Key key, m<?> mVar) {
        a2.d.a.d.b.a aVar = this.h;
        synchronized (aVar) {
            a.b remove = aVar.c.remove(key);
            if (remove != null) {
                remove.c = null;
                remove.clear();
            }
        }
        if (mVar.a) {
            this.c.put(key, mVar);
        } else {
            this.e.a(mVar, false);
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache.ResourceRemovedListener
    public void onResourceRemoved(@NonNull Resource<?> resource) {
        this.e.a(resource, true);
    }

    public void release(Resource<?> resource) {
        if (resource instanceof m) {
            ((m) resource).b();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    @VisibleForTesting
    public void shutdown() {
        b bVar = this.d;
        Executors.shutdownAndAwaitTermination(bVar.a);
        Executors.shutdownAndAwaitTermination(bVar.b);
        Executors.shutdownAndAwaitTermination(bVar.c);
        Executors.shutdownAndAwaitTermination(bVar.d);
        c cVar = this.f;
        synchronized (cVar) {
            if (cVar.b != null) {
                cVar.b.clear();
            }
        }
        a2.d.a.d.b.a aVar = this.h;
        aVar.f = true;
        Executor executor = aVar.b;
        if (executor instanceof ExecutorService) {
            Executors.shutdownAndAwaitTermination((ExecutorService) executor);
        }
    }
}
