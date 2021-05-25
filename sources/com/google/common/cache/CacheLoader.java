package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
@GwtCompatible(emulated = true)
public abstract class CacheLoader<K, V> {

    public static final class InvalidCacheLoadException extends RuntimeException {
        public InvalidCacheLoadException(String str) {
            super(str);
        }
    }

    public static final class UnsupportedLoadingOperationException extends UnsupportedOperationException {
    }

    public static class a extends CacheLoader<K, V> {
        public final /* synthetic */ CacheLoader a;
        public final /* synthetic */ Executor b;

        /* renamed from: com.google.common.cache.CacheLoader$a$a  reason: collision with other inner class name */
        public class CallableC0277a implements Callable<V> {
            public final /* synthetic */ Object a;
            public final /* synthetic */ Object b;

            public CallableC0277a(Object obj, Object obj2) {
                this.a = obj;
                this.b = obj2;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.google.common.cache.CacheLoader */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public V call() throws Exception {
                return (V) a.this.a.reload(this.a, this.b).get();
            }
        }

        public a(CacheLoader cacheLoader, Executor executor) {
            this.a = cacheLoader;
            this.b = executor;
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(K k) throws Exception {
            return (V) this.a.load(k);
        }

        @Override // com.google.common.cache.CacheLoader
        public Map<K, V> loadAll(Iterable<? extends K> iterable) throws Exception {
            return this.a.loadAll(iterable);
        }

        @Override // com.google.common.cache.CacheLoader
        public ListenableFuture<V> reload(K k, V v) throws Exception {
            ListenableFutureTask create = ListenableFutureTask.create(new CallableC0277a(k, v));
            this.b.execute(create);
            return create;
        }
    }

    public static final class b<K, V> extends CacheLoader<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        public final Function<K, V> a;

        public b(Function<K, V> function) {
            this.a = (Function) Preconditions.checkNotNull(function);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.base.Function<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.cache.CacheLoader
        public V load(K k) {
            return (V) this.a.apply(Preconditions.checkNotNull(k));
        }
    }

    public static final class c<V> extends CacheLoader<Object, V> implements Serializable {
        private static final long serialVersionUID = 0;
        public final Supplier<V> a;

        public c(Supplier<V> supplier) {
            this.a = (Supplier) Preconditions.checkNotNull(supplier);
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(Object obj) {
            Preconditions.checkNotNull(obj);
            return this.a.get();
        }
    }

    @GwtIncompatible
    public static <K, V> CacheLoader<K, V> asyncReloading(CacheLoader<K, V> cacheLoader, Executor executor) {
        Preconditions.checkNotNull(cacheLoader);
        Preconditions.checkNotNull(executor);
        return new a(cacheLoader, executor);
    }

    public static <K, V> CacheLoader<K, V> from(Function<K, V> function) {
        return new b(function);
    }

    public abstract V load(K k) throws Exception;

    public Map<K, V> loadAll(Iterable<? extends K> iterable) throws Exception {
        throw new UnsupportedLoadingOperationException();
    }

    @GwtIncompatible
    public ListenableFuture<V> reload(K k, V v) throws Exception {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v);
        return Futures.immediateFuture(load(k));
    }

    public static <V> CacheLoader<Object, V> from(Supplier<V> supplier) {
        return new c(supplier);
    }
}
