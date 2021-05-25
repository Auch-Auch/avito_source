package com.bumptech.glide.util.pool;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;
public final class FactoryPools {
    public static final Resetter<Object> a = new a();

    public interface Factory<T> {
        T create();
    }

    public interface Poolable {
        @NonNull
        StateVerifier getVerifier();
    }

    public interface Resetter<T> {
        void reset(@NonNull T t);
    }

    public class a implements Resetter<Object> {
        @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
        public void reset(@NonNull Object obj) {
        }
    }

    public class b implements Factory<List<T>> {
        @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
        @NonNull
        public Object create() {
            return new ArrayList();
        }
    }

    public class c implements Resetter<List<T>> {
        @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
        public void reset(@NonNull Object obj) {
            ((List) obj).clear();
        }
    }

    public static final class d<T> implements Pools.Pool<T> {
        public final Factory<T> a;
        public final Resetter<T> b;
        public final Pools.Pool<T> c;

        public d(@NonNull Pools.Pool<T> pool, @NonNull Factory<T> factory, @NonNull Resetter<T> resetter) {
            this.c = pool;
            this.a = factory;
            this.b = resetter;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            T acquire = this.c.acquire();
            if (acquire == null) {
                acquire = this.a.create();
                if (Log.isLoggable("FactoryPools", 2)) {
                    StringBuilder L = a2.b.a.a.a.L("Created new ");
                    L.append(acquire.getClass());
                    L.toString();
                }
            }
            if (acquire instanceof Poolable) {
                acquire.getVerifier().a(false);
            }
            return acquire;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t) {
            if (t instanceof Poolable) {
                t.getVerifier().a(true);
            }
            this.b.reset(t);
            return this.c.release(t);
        }
    }

    @NonNull
    public static <T extends Poolable> Pools.Pool<T> simple(int i, @NonNull Factory<T> factory) {
        return new d(new Pools.SimplePool(i), factory, a);
    }

    @NonNull
    public static <T extends Poolable> Pools.Pool<T> threadSafe(int i, @NonNull Factory<T> factory) {
        return new d(new Pools.SynchronizedPool(i), factory, a);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> threadSafeList() {
        return threadSafeList(20);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> threadSafeList(int i) {
        return new d(new Pools.SynchronizedPool(i), new b(), new c());
    }
}
