package a2.j.d.b;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheStats;
import com.google.common.cache.ForwardingCache;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalCause;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.google.common.cache.Weigher;
import com.google.common.collect.AbstractSequentialIterator;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true)
public class a<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {
    public static final Logger w = Logger.getLogger(a.class.getName());
    public static final a0<Object, Object> x = new C0051a();
    public static final Queue<?> y = new b();
    public final int a;
    public final int b;
    public final r<K, V>[] c;
    public final int d;
    public final Equivalence<Object> e;
    public final Equivalence<Object> f;
    public final t g;
    public final t h;
    public final long i;
    public final Weigher<K, V> j;
    public final long k;
    public final long l;
    public final long m;
    public final Queue<RemovalNotification<K, V>> n;
    public final RemovalListener<K, V> o;
    public final Ticker p;
    public final f q;
    public final AbstractCache.StatsCounter r;
    @NullableDecl
    public final CacheLoader<? super K, V> s;
    @MonotonicNonNullDecl
    public Set<K> t;
    @MonotonicNonNullDecl
    public Collection<V> u;
    @MonotonicNonNullDecl
    public Set<Map.Entry<K, V>> v;

    /* renamed from: a2.j.d.b.a$a  reason: collision with other inner class name */
    public static class C0051a implements a0<Object, Object> {
        @Override // a2.j.d.b.a.a0
        public f<Object, Object> a() {
            return null;
        }

        @Override // a2.j.d.b.a.a0
        public void b(Object obj) {
        }

        @Override // a2.j.d.b.a.a0
        public int c() {
            return 0;
        }

        @Override // a2.j.d.b.a.a0
        public Object d() {
            return null;
        }

        @Override // a2.j.d.b.a.a0
        public a0<Object, Object> e(ReferenceQueue<Object> referenceQueue, @NullableDecl Object obj, f<Object, Object> fVar) {
            return this;
        }

        @Override // a2.j.d.b.a.a0
        public Object get() {
            return null;
        }

        @Override // a2.j.d.b.a.a0
        public boolean isActive() {
            return false;
        }

        @Override // a2.j.d.b.a.a0
        public boolean isLoading() {
            return false;
        }
    }

    public interface a0<K, V> {
        @NullableDecl
        f<K, V> a();

        void b(@NullableDecl V v);

        int c();

        V d() throws ExecutionException;

        a0<K, V> e(ReferenceQueue<V> referenceQueue, @NullableDecl V v, f<K, V> fVar);

        @NullableDecl
        V get();

        boolean isActive();

        boolean isLoading();
    }

    public static class b extends AbstractQueue<Object> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Object> iterator() {
            return ImmutableSet.of().mo99iterator();
        }

        @Override // java.util.Queue
        public boolean offer(Object obj) {
            return true;
        }

        @Override // java.util.Queue
        public Object peek() {
            return null;
        }

        @Override // java.util.Queue
        public Object poll() {
            return null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return 0;
        }
    }

    public final class b0 extends AbstractCollection<V> {
        public final ConcurrentMap<?, ?> a;

        public b0(ConcurrentMap<?, ?> concurrentMap) {
            this.a = concurrentMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.a.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new z(a.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.a.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return a.a(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <E> E[] toArray(E[] eArr) {
            return (E[]) a.a(this).toArray(eArr);
        }
    }

    public abstract class c<T> extends AbstractSet<T> {
        @Weak
        public final ConcurrentMap<?, ?> a;

        public c(a aVar, ConcurrentMap<?, ?> concurrentMap) {
            this.a = concurrentMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.a.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return a.a(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <E> E[] toArray(E[] eArr) {
            return (E[]) a.a(this).toArray(eArr);
        }
    }

    public static final class c0<K, V> extends e0<K, V> {
        public volatile long d = Long.MAX_VALUE;
        public f<K, V> e;
        public f<K, V> f;

        public c0(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl f<K, V> fVar) {
            super(referenceQueue, k, i, fVar);
            Logger logger = a.w;
            q qVar = q.INSTANCE;
            this.e = qVar;
            this.f = qVar;
        }

        @Override // a2.j.d.b.a.e0, a2.j.d.b.f
        public void c(f<K, V> fVar) {
            this.f = fVar;
        }

        @Override // a2.j.d.b.a.e0, a2.j.d.b.f
        public void h(long j) {
            this.d = j;
        }

        @Override // a2.j.d.b.a.e0, a2.j.d.b.f
        public f<K, V> j() {
            return this.f;
        }

        @Override // a2.j.d.b.a.e0, a2.j.d.b.f
        public f<K, V> m() {
            return this.e;
        }

        @Override // a2.j.d.b.a.e0, a2.j.d.b.f
        public long n() {
            return this.d;
        }

        @Override // a2.j.d.b.a.e0, a2.j.d.b.f
        public void o(f<K, V> fVar) {
            this.e = fVar;
        }
    }

    public static abstract class d<K, V> implements f<K, V> {
        @Override // a2.j.d.b.f
        public a0<K, V> a() {
            throw new UnsupportedOperationException();
        }

        @Override // a2.j.d.b.f
        public f<K, V> b() {
            throw new UnsupportedOperationException();
        }

        @Override // a2.j.d.b.f
        public void c(f<K, V> fVar) {
            throw new UnsupportedOperationException();
        }

        @Override // a2.j.d.b.f
        public f<K, V> d() {
            throw new UnsupportedOperationException();
        }

        @Override // a2.j.d.b.f
        public void e(a0<K, V> a0Var) {
            throw new UnsupportedOperationException();
        }

        @Override // a2.j.d.b.f
        public long f() {
            throw new UnsupportedOperationException();
        }

        @Override // a2.j.d.b.f
        public int getHash() {
            throw new UnsupportedOperationException();
        }

        @Override // a2.j.d.b.f
        public K getKey() {
            throw new UnsupportedOperationException();
        }

        @Override // a2.j.d.b.f
        public void h(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // a2.j.d.b.f
        public void i(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // a2.j.d.b.f
        public f<K, V> j() {
            throw new UnsupportedOperationException();
        }

        @Override // a2.j.d.b.f
        public f<K, V> l() {
            throw new UnsupportedOperationException();
        }

        @Override // a2.j.d.b.f
        public f<K, V> m() {
            throw new UnsupportedOperationException();
        }

        @Override // a2.j.d.b.f
        public long n() {
            throw new UnsupportedOperationException();
        }

        @Override // a2.j.d.b.f
        public void o(f<K, V> fVar) {
            throw new UnsupportedOperationException();
        }

        @Override // a2.j.d.b.f
        public void p(f<K, V> fVar) {
            throw new UnsupportedOperationException();
        }

        @Override // a2.j.d.b.f
        public void q(f<K, V> fVar) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class d0<K, V> extends e0<K, V> {
        public volatile long d = Long.MAX_VALUE;
        public f<K, V> e;
        public f<K, V> f;
        public volatile long g;
        public f<K, V> h;
        public f<K, V> i;

        public d0(ReferenceQueue<K> referenceQueue, K k, int i2, @NullableDecl f<K, V> fVar) {
            super(referenceQueue, k, i2, fVar);
            Logger logger = a.w;
            q qVar = q.INSTANCE;
            this.e = qVar;
            this.f = qVar;
            this.g = Long.MAX_VALUE;
            this.h = qVar;
            this.i = qVar;
        }

        @Override // a2.j.d.b.a.e0, a2.j.d.b.f
        public void c(f<K, V> fVar) {
            this.f = fVar;
        }

        @Override // a2.j.d.b.a.e0, a2.j.d.b.f
        public f<K, V> d() {
            return this.i;
        }

        @Override // a2.j.d.b.a.e0, a2.j.d.b.f
        public long f() {
            return this.g;
        }

        @Override // a2.j.d.b.a.e0, a2.j.d.b.f
        public void h(long j) {
            this.d = j;
        }

        @Override // a2.j.d.b.a.e0, a2.j.d.b.f
        public void i(long j) {
            this.g = j;
        }

        @Override // a2.j.d.b.a.e0, a2.j.d.b.f
        public f<K, V> j() {
            return this.f;
        }

        @Override // a2.j.d.b.a.e0, a2.j.d.b.f
        public f<K, V> l() {
            return this.h;
        }

        @Override // a2.j.d.b.a.e0, a2.j.d.b.f
        public f<K, V> m() {
            return this.e;
        }

        @Override // a2.j.d.b.a.e0, a2.j.d.b.f
        public long n() {
            return this.d;
        }

        @Override // a2.j.d.b.a.e0, a2.j.d.b.f
        public void o(f<K, V> fVar) {
            this.e = fVar;
        }

        @Override // a2.j.d.b.a.e0, a2.j.d.b.f
        public void p(f<K, V> fVar) {
            this.h = fVar;
        }

        @Override // a2.j.d.b.a.e0, a2.j.d.b.f
        public void q(f<K, V> fVar) {
            this.i = fVar;
        }
    }

    public static final class e<K, V> extends AbstractQueue<f<K, V>> {
        public final f<K, V> a = new C0052a(this);

        /* renamed from: a2.j.d.b.a$e$a  reason: collision with other inner class name */
        public class C0052a extends d<K, V> {
            public f<K, V> a = this;
            public f<K, V> b = this;

            public C0052a(e eVar) {
            }

            @Override // a2.j.d.b.a.d, a2.j.d.b.f
            public void c(f<K, V> fVar) {
                this.b = fVar;
            }

            @Override // a2.j.d.b.a.d, a2.j.d.b.f
            public void h(long j) {
            }

            @Override // a2.j.d.b.a.d, a2.j.d.b.f
            public f<K, V> j() {
                return this.b;
            }

            @Override // a2.j.d.b.a.d, a2.j.d.b.f
            public f<K, V> m() {
                return this.a;
            }

            @Override // a2.j.d.b.a.d, a2.j.d.b.f
            public long n() {
                return Long.MAX_VALUE;
            }

            @Override // a2.j.d.b.a.d, a2.j.d.b.f
            public void o(f<K, V> fVar) {
                this.a = fVar;
            }
        }

        public class b extends AbstractSequentialIterator<f<K, V>> {
            public b(f fVar) {
                super(fVar);
            }

            @Override // com.google.common.collect.AbstractSequentialIterator
            public Object computeNext(Object obj) {
                f<K, V> m = ((f) obj).m();
                if (m == e.this.a) {
                    return null;
                }
                return m;
            }
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            f<K, V> m = this.a.m();
            while (true) {
                f<K, V> fVar = this.a;
                if (m != fVar) {
                    f<K, V> m2 = m.m();
                    Logger logger = a.w;
                    q qVar = q.INSTANCE;
                    m.o(qVar);
                    m.c(qVar);
                    m = m2;
                } else {
                    fVar.o(fVar);
                    f<K, V> fVar2 = this.a;
                    fVar2.c(fVar2);
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((f) obj).m() != q.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.a.m() == this.a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<f<K, V>> iterator() {
            f<K, V> m = this.a.m();
            if (m == this.a) {
                m = null;
            }
            return new b(m);
        }

        @Override // java.util.Queue
        public boolean offer(Object obj) {
            f<K, V> fVar = (f) obj;
            f<K, V> j = fVar.j();
            f<K, V> m = fVar.m();
            Logger logger = a.w;
            j.o(m);
            m.c(j);
            f<K, V> j2 = this.a.j();
            j2.o(fVar);
            fVar.c(j2);
            f<K, V> fVar2 = this.a;
            fVar.o(fVar2);
            fVar2.c(fVar);
            return true;
        }

        @Override // java.util.Queue
        public Object peek() {
            f<K, V> m = this.a.m();
            if (m == this.a) {
                return null;
            }
            return m;
        }

        @Override // java.util.Queue
        public Object poll() {
            f<K, V> m = this.a.m();
            if (m == this.a) {
                return null;
            }
            remove(m);
            return m;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            f fVar = (f) obj;
            f<K, V> j = fVar.j();
            f<K, V> m = fVar.m();
            Logger logger = a.w;
            j.o(m);
            m.c(j);
            q qVar = q.INSTANCE;
            fVar.o(qVar);
            fVar.c(qVar);
            return m != qVar;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i = 0;
            for (f<K, V> m = this.a.m(); m != this.a; m = m.m()) {
                i++;
            }
            return i;
        }
    }

    public static class e0<K, V> extends WeakReference<K> implements f<K, V> {
        public final int a;
        @NullableDecl
        public final f<K, V> b;
        public volatile a0<K, V> c = ((a0<K, V>) a.x);

        public e0(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl f<K, V> fVar) {
            super(k, referenceQueue);
            this.a = i;
            this.b = fVar;
        }

        @Override // a2.j.d.b.f
        public a0<K, V> a() {
            return this.c;
        }

        @Override // a2.j.d.b.f
        public f<K, V> b() {
            return this.b;
        }

        @Override // a2.j.d.b.f
        public void c(f<K, V> fVar) {
            throw new UnsupportedOperationException();
        }

        @Override // a2.j.d.b.f
        public f<K, V> d() {
            throw new UnsupportedOperationException();
        }

        @Override // a2.j.d.b.f
        public void e(a0<K, V> a0Var) {
            this.c = a0Var;
        }

        @Override // a2.j.d.b.f
        public long f() {
            throw new UnsupportedOperationException();
        }

        @Override // a2.j.d.b.f
        public int getHash() {
            return this.a;
        }

        @Override // a2.j.d.b.f
        public K getKey() {
            return (K) get();
        }

        @Override // a2.j.d.b.f
        public void h(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // a2.j.d.b.f
        public void i(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // a2.j.d.b.f
        public f<K, V> j() {
            throw new UnsupportedOperationException();
        }

        @Override // a2.j.d.b.f
        public f<K, V> l() {
            throw new UnsupportedOperationException();
        }

        @Override // a2.j.d.b.f
        public f<K, V> m() {
            throw new UnsupportedOperationException();
        }

        @Override // a2.j.d.b.f
        public long n() {
            throw new UnsupportedOperationException();
        }

        @Override // a2.j.d.b.f
        public void o(f<K, V> fVar) {
            throw new UnsupportedOperationException();
        }

        @Override // a2.j.d.b.f
        public void p(f<K, V> fVar) {
            throw new UnsupportedOperationException();
        }

        @Override // a2.j.d.b.f
        public void q(f<K, V> fVar) {
            throw new UnsupportedOperationException();
        }
    }

    public enum f {
        STRONG {
            @Override // a2.j.d.b.a.f
            public <K, V> f<K, V> d(r<K, V> rVar, K k, int i, @NullableDecl f<K, V> fVar) {
                return new w(k, i, fVar);
            }
        },
        STRONG_ACCESS {
            @Override // a2.j.d.b.a.f
            public <K, V> f<K, V> b(r<K, V> rVar, f<K, V> fVar, f<K, V> fVar2) {
                u uVar = new u(fVar.getKey(), fVar.getHash(), fVar2);
                a(fVar, uVar);
                return uVar;
            }

            @Override // a2.j.d.b.a.f
            public <K, V> f<K, V> d(r<K, V> rVar, K k, int i, @NullableDecl f<K, V> fVar) {
                return new u(k, i, fVar);
            }
        },
        STRONG_WRITE {
            @Override // a2.j.d.b.a.f
            public <K, V> f<K, V> b(r<K, V> rVar, f<K, V> fVar, f<K, V> fVar2) {
                y yVar = new y(fVar.getKey(), fVar.getHash(), fVar2);
                c(fVar, yVar);
                return yVar;
            }

            @Override // a2.j.d.b.a.f
            public <K, V> f<K, V> d(r<K, V> rVar, K k, int i, @NullableDecl f<K, V> fVar) {
                return new y(k, i, fVar);
            }
        },
        STRONG_ACCESS_WRITE {
            @Override // a2.j.d.b.a.f
            public <K, V> f<K, V> b(r<K, V> rVar, f<K, V> fVar, f<K, V> fVar2) {
                v vVar = new v(fVar.getKey(), fVar.getHash(), fVar2);
                a(fVar, vVar);
                c(fVar, vVar);
                return vVar;
            }

            @Override // a2.j.d.b.a.f
            public <K, V> f<K, V> d(r<K, V> rVar, K k, int i, @NullableDecl f<K, V> fVar) {
                return new v(k, i, fVar);
            }
        },
        WEAK {
            @Override // a2.j.d.b.a.f
            public <K, V> f<K, V> d(r<K, V> rVar, K k, int i, @NullableDecl f<K, V> fVar) {
                return new e0(rVar.h, k, i, fVar);
            }
        },
        WEAK_ACCESS {
            @Override // a2.j.d.b.a.f
            public <K, V> f<K, V> b(r<K, V> rVar, f<K, V> fVar, f<K, V> fVar2) {
                f<K, V> d = d(rVar, fVar.getKey(), fVar.getHash(), fVar2);
                a(fVar, d);
                return d;
            }

            @Override // a2.j.d.b.a.f
            public <K, V> f<K, V> d(r<K, V> rVar, K k, int i, @NullableDecl f<K, V> fVar) {
                return new c0(rVar.h, k, i, fVar);
            }
        },
        WEAK_WRITE {
            @Override // a2.j.d.b.a.f
            public <K, V> f<K, V> b(r<K, V> rVar, f<K, V> fVar, f<K, V> fVar2) {
                f<K, V> d = d(rVar, fVar.getKey(), fVar.getHash(), fVar2);
                c(fVar, d);
                return d;
            }

            @Override // a2.j.d.b.a.f
            public <K, V> f<K, V> d(r<K, V> rVar, K k, int i, @NullableDecl f<K, V> fVar) {
                return new g0(rVar.h, k, i, fVar);
            }
        },
        WEAK_ACCESS_WRITE {
            @Override // a2.j.d.b.a.f
            public <K, V> f<K, V> b(r<K, V> rVar, f<K, V> fVar, f<K, V> fVar2) {
                f<K, V> d = d(rVar, fVar.getKey(), fVar.getHash(), fVar2);
                a(fVar, d);
                c(fVar, d);
                return d;
            }

            @Override // a2.j.d.b.a.f
            public <K, V> f<K, V> d(r<K, V> rVar, K k, int i, @NullableDecl f<K, V> fVar) {
                return new d0(rVar.h, k, i, fVar);
            }
        };
        
        public static final f[] i;

        /* access modifiers changed from: public */
        static {
            C0053a aVar;
            b bVar;
            c cVar;
            d dVar;
            e eVar;
            C0054f fVar;
            g gVar;
            h hVar;
            i = new f[]{aVar, bVar, cVar, dVar, eVar, fVar, gVar, hVar};
        }

        /* access modifiers changed from: public */
        f(C0051a aVar) {
        }

        public <K, V> void a(f<K, V> fVar, f<K, V> fVar2) {
            fVar2.h(fVar.n());
            f<K, V> j2 = fVar.j();
            Logger logger = a.w;
            j2.o(fVar2);
            fVar2.c(j2);
            f<K, V> m = fVar.m();
            fVar2.o(m);
            m.c(fVar2);
            q qVar = q.INSTANCE;
            fVar.o(qVar);
            fVar.c(qVar);
        }

        public <K, V> f<K, V> b(r<K, V> rVar, f<K, V> fVar, f<K, V> fVar2) {
            return d(rVar, fVar.getKey(), fVar.getHash(), fVar2);
        }

        public <K, V> void c(f<K, V> fVar, f<K, V> fVar2) {
            fVar2.i(fVar.f());
            f<K, V> d2 = fVar.d();
            Logger logger = a.w;
            d2.p(fVar2);
            fVar2.q(d2);
            f<K, V> l = fVar.l();
            fVar2.p(l);
            l.q(fVar2);
            q qVar = q.INSTANCE;
            fVar.p(qVar);
            fVar.q(qVar);
        }

        public abstract <K, V> f<K, V> d(r<K, V> rVar, K k, int i2, @NullableDecl f<K, V> fVar);
    }

    public static class f0<K, V> extends WeakReference<V> implements a0<K, V> {
        public final f<K, V> a;

        public f0(ReferenceQueue<V> referenceQueue, V v, f<K, V> fVar) {
            super(v, referenceQueue);
            this.a = fVar;
        }

        @Override // a2.j.d.b.a.a0
        public f<K, V> a() {
            return this.a;
        }

        @Override // a2.j.d.b.a.a0
        public void b(V v) {
        }

        @Override // a2.j.d.b.a.a0
        public int c() {
            return 1;
        }

        @Override // a2.j.d.b.a.a0
        public V d() {
            return (V) get();
        }

        @Override // a2.j.d.b.a.a0
        public a0<K, V> e(ReferenceQueue<V> referenceQueue, V v, f<K, V> fVar) {
            return new f0(referenceQueue, v, fVar);
        }

        @Override // a2.j.d.b.a.a0
        public boolean isActive() {
            return true;
        }

        @Override // a2.j.d.b.a.a0
        public boolean isLoading() {
            return false;
        }
    }

    public final class g extends a<K, V>.i {
        public g(a aVar) {
            super();
        }

        @Override // java.util.Iterator
        public Object next() {
            return c();
        }
    }

    public static final class g0<K, V> extends e0<K, V> {
        public volatile long d = Long.MAX_VALUE;
        public f<K, V> e;
        public f<K, V> f;

        public g0(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl f<K, V> fVar) {
            super(referenceQueue, k, i, fVar);
            Logger logger = a.w;
            q qVar = q.INSTANCE;
            this.e = qVar;
            this.f = qVar;
        }

        @Override // a2.j.d.b.a.e0, a2.j.d.b.f
        public f<K, V> d() {
            return this.f;
        }

        @Override // a2.j.d.b.a.e0, a2.j.d.b.f
        public long f() {
            return this.d;
        }

        @Override // a2.j.d.b.a.e0, a2.j.d.b.f
        public void i(long j) {
            this.d = j;
        }

        @Override // a2.j.d.b.a.e0, a2.j.d.b.f
        public f<K, V> l() {
            return this.e;
        }

        @Override // a2.j.d.b.a.e0, a2.j.d.b.f
        public void p(f<K, V> fVar) {
            this.e = fVar;
        }

        @Override // a2.j.d.b.a.e0, a2.j.d.b.f
        public void q(f<K, V> fVar) {
            this.f = fVar;
        }
    }

    public final class h extends a<K, V>.c {
        public h(ConcurrentMap<?, ?> concurrentMap) {
            super(a.this, concurrentMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            if ((obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = a.this.get(key)) != null && a.this.f.equivalent(entry.getValue(), obj2)) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new g(a.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            if ((obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && a.this.remove(key, entry.getValue())) {
                return true;
            }
            return false;
        }
    }

    public static final class h0<K, V> extends s<K, V> {
        public final int b;

        public h0(ReferenceQueue<V> referenceQueue, V v, f<K, V> fVar, int i) {
            super(referenceQueue, v, fVar);
            this.b = i;
        }

        @Override // a2.j.d.b.a.s, a2.j.d.b.a.a0
        public int c() {
            return this.b;
        }

        @Override // a2.j.d.b.a.s, a2.j.d.b.a.a0
        public a0<K, V> e(ReferenceQueue<V> referenceQueue, V v, f<K, V> fVar) {
            return new h0(referenceQueue, v, fVar, this.b);
        }
    }

    public abstract class i<T> implements Iterator<T> {
        public int a;
        public int b = -1;
        @MonotonicNonNullDecl
        public r<K, V> c;
        @MonotonicNonNullDecl
        public AtomicReferenceArray<f<K, V>> d;
        @NullableDecl
        public f<K, V> e;
        @NullableDecl
        public a<K, V>.l0 f;
        @NullableDecl
        public a<K, V>.l0 g;

        public i() {
            this.a = a.this.c.length - 1;
            a();
        }

        public final void a() {
            this.f = null;
            if (!d() && !e()) {
                while (true) {
                    int i = this.a;
                    if (i >= 0) {
                        r<K, V>[] rVarArr = a.this.c;
                        this.a = i - 1;
                        r<K, V> rVar = rVarArr[i];
                        this.c = rVar;
                        if (rVar.b != 0) {
                            AtomicReferenceArray<f<K, V>> atomicReferenceArray = this.c.f;
                            this.d = atomicReferenceArray;
                            this.b = atomicReferenceArray.length() - 1;
                            if (e()) {
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public boolean b(f<K, V> fVar) {
            boolean z;
            try {
                long read = a.this.p.read();
                K key = fVar.getKey();
                a aVar = a.this;
                Objects.requireNonNull(aVar);
                V v = null;
                if (fVar.getKey() != null) {
                    V v2 = fVar.a().get();
                    if (v2 != null) {
                        if (!aVar.h(fVar, read)) {
                            v = v2;
                        }
                    }
                }
                if (v != null) {
                    this.f = new l0(key, v);
                    z = true;
                } else {
                    z = false;
                }
                return z;
            } finally {
                this.c.p();
            }
        }

        public a<K, V>.l0 c() {
            a<K, V>.l0 l0Var = this.f;
            if (l0Var != null) {
                this.g = l0Var;
                a();
                return this.g;
            }
            throw new NoSuchElementException();
        }

        public boolean d() {
            f<K, V> fVar = this.e;
            if (fVar == null) {
                return false;
            }
            while (true) {
                this.e = fVar.b();
                f<K, V> fVar2 = this.e;
                if (fVar2 == null) {
                    return false;
                }
                if (b(fVar2)) {
                    return true;
                }
                fVar = this.e;
            }
        }

        public boolean e() {
            while (true) {
                int i = this.b;
                if (i < 0) {
                    return false;
                }
                AtomicReferenceArray<f<K, V>> atomicReferenceArray = this.d;
                this.b = i - 1;
                f<K, V> fVar = atomicReferenceArray.get(i);
                this.e = fVar;
                if (fVar != null && (b(fVar) || d())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            Preconditions.checkState(this.g != null);
            a.this.remove(this.g.a);
            this.g = null;
        }
    }

    public static final class i0<K, V> extends x<K, V> {
        public final int b;

        public i0(V v, int i) {
            super(v);
            this.b = i;
        }

        @Override // a2.j.d.b.a.x, a2.j.d.b.a.a0
        public int c() {
            return this.b;
        }
    }

    public final class j extends a<K, V>.i {
        public j(a aVar) {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return c().a;
        }
    }

    public static final class j0<K, V> extends f0<K, V> {
        public final int b;

        public j0(ReferenceQueue<V> referenceQueue, V v, f<K, V> fVar, int i) {
            super(referenceQueue, v, fVar);
            this.b = i;
        }

        @Override // a2.j.d.b.a.f0, a2.j.d.b.a.a0
        public int c() {
            return this.b;
        }

        @Override // a2.j.d.b.a.f0, a2.j.d.b.a.a0
        public a0<K, V> e(ReferenceQueue<V> referenceQueue, V v, f<K, V> fVar) {
            return new j0(referenceQueue, v, fVar, this.b);
        }
    }

    public final class k extends a<K, V>.c {
        public k(ConcurrentMap<?, ?> concurrentMap) {
            super(a.this, concurrentMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.a.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<K> iterator() {
            return new j(a.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return this.a.remove(obj) != null;
        }
    }

    public static final class k0<K, V> extends AbstractQueue<f<K, V>> {
        public final f<K, V> a = new C0055a(this);

        /* renamed from: a2.j.d.b.a$k0$a  reason: collision with other inner class name */
        public class C0055a extends d<K, V> {
            public f<K, V> a = this;
            public f<K, V> b = this;

            public C0055a(k0 k0Var) {
            }

            @Override // a2.j.d.b.a.d, a2.j.d.b.f
            public f<K, V> d() {
                return this.b;
            }

            @Override // a2.j.d.b.a.d, a2.j.d.b.f
            public long f() {
                return Long.MAX_VALUE;
            }

            @Override // a2.j.d.b.a.d, a2.j.d.b.f
            public void i(long j) {
            }

            @Override // a2.j.d.b.a.d, a2.j.d.b.f
            public f<K, V> l() {
                return this.a;
            }

            @Override // a2.j.d.b.a.d, a2.j.d.b.f
            public void p(f<K, V> fVar) {
                this.a = fVar;
            }

            @Override // a2.j.d.b.a.d, a2.j.d.b.f
            public void q(f<K, V> fVar) {
                this.b = fVar;
            }
        }

        public class b extends AbstractSequentialIterator<f<K, V>> {
            public b(f fVar) {
                super(fVar);
            }

            @Override // com.google.common.collect.AbstractSequentialIterator
            public Object computeNext(Object obj) {
                f<K, V> l = ((f) obj).l();
                if (l == k0.this.a) {
                    return null;
                }
                return l;
            }
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            f<K, V> l = this.a.l();
            while (true) {
                f<K, V> fVar = this.a;
                if (l != fVar) {
                    f<K, V> l2 = l.l();
                    Logger logger = a.w;
                    q qVar = q.INSTANCE;
                    l.p(qVar);
                    l.q(qVar);
                    l = l2;
                } else {
                    fVar.p(fVar);
                    f<K, V> fVar2 = this.a;
                    fVar2.q(fVar2);
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((f) obj).l() != q.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.a.l() == this.a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<f<K, V>> iterator() {
            f<K, V> l = this.a.l();
            if (l == this.a) {
                l = null;
            }
            return new b(l);
        }

        @Override // java.util.Queue
        public boolean offer(Object obj) {
            f<K, V> fVar = (f) obj;
            f<K, V> d = fVar.d();
            f<K, V> l = fVar.l();
            Logger logger = a.w;
            d.p(l);
            l.q(d);
            f<K, V> d2 = this.a.d();
            d2.p(fVar);
            fVar.q(d2);
            f<K, V> fVar2 = this.a;
            fVar.p(fVar2);
            fVar2.q(fVar);
            return true;
        }

        @Override // java.util.Queue
        public Object peek() {
            f<K, V> l = this.a.l();
            if (l == this.a) {
                return null;
            }
            return l;
        }

        @Override // java.util.Queue
        public Object poll() {
            f<K, V> l = this.a.l();
            if (l == this.a) {
                return null;
            }
            remove(l);
            return l;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            f fVar = (f) obj;
            f<K, V> d = fVar.d();
            f<K, V> l = fVar.l();
            Logger logger = a.w;
            d.p(l);
            l.q(d);
            q qVar = q.INSTANCE;
            fVar.p(qVar);
            fVar.q(qVar);
            return l != qVar;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i = 0;
            for (f<K, V> l = this.a.l(); l != this.a; l = l.l()) {
                i++;
            }
            return i;
        }
    }

    public static final class l<K, V> extends p<K, V> implements LoadingCache<K, V>, Serializable {
        private static final long serialVersionUID = 1;
        @MonotonicNonNullDecl
        public transient LoadingCache<K, V> n;

        public l(a<K, V> aVar) {
            super(aVar);
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: com.google.common.cache.CacheLoader<? super K, V>, com.google.common.cache.CacheLoader<? super K1 extends K, V1 extends V> */
        /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: com.google.common.cache.LoadingCache<K1 extends K, V1 extends V>, com.google.common.cache.LoadingCache<K, V> */
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.n = (LoadingCache<K1, V1>) d().build((CacheLoader<? super K, V>) this.l);
        }

        private Object readResolve() {
            return this.n;
        }

        @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
        public final V apply(K k) {
            return this.n.apply(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public V get(K k) throws ExecutionException {
            return this.n.get(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
            return this.n.getAll(iterable);
        }

        @Override // com.google.common.cache.LoadingCache
        public V getUnchecked(K k) {
            return this.n.getUnchecked(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public void refresh(K k) {
            this.n.refresh(k);
        }
    }

    public final class l0 implements Map.Entry<K, V> {
        public final K a;
        public V b;

        public l0(K k, V v) {
            this.a = k;
            this.b = v;
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!this.a.equals(entry.getKey()) || !this.b.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.b;
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return this.a.hashCode() ^ this.b.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = (V) a.this.put(this.a, v);
            this.b = v;
            return v2;
        }

        @Override // java.lang.Object
        public String toString() {
            return ((Object) this.a) + "=" + ((Object) this.b);
        }
    }

    public static class n<K, V> extends o<K, V> implements LoadingCache<K, V> {
        private static final long serialVersionUID = 1;

        public n(CacheBuilder<? super K, ? super V> cacheBuilder, CacheLoader<? super K, V> cacheLoader) {
            super(new a(cacheBuilder, (CacheLoader) Preconditions.checkNotNull(cacheLoader)), null);
        }

        @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
        public final V apply(K k) {
            return getUnchecked(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public V get(K k) throws ExecutionException {
            a<K, V> aVar = this.a;
            return aVar.f(k, aVar.s);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: a2.j.d.b.a<K, V> */
        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.LinkedHashMap */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.cache.LoadingCache
        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
            a<K, V> aVar = this.a;
            Objects.requireNonNull(aVar);
            LinkedHashMap newLinkedHashMap = Maps.newLinkedHashMap();
            LinkedHashSet newLinkedHashSet = Sets.newLinkedHashSet();
            int i = 0;
            int i2 = 0;
            for (Object obj : iterable) {
                Object obj2 = aVar.get(obj);
                if (!newLinkedHashMap.containsKey(obj)) {
                    newLinkedHashMap.put(obj, obj2);
                    if (obj2 == null) {
                        i2++;
                        newLinkedHashSet.add(obj);
                    } else {
                        i++;
                    }
                }
            }
            try {
                if (!newLinkedHashSet.isEmpty()) {
                    try {
                        Map i3 = aVar.i(newLinkedHashSet, aVar.s);
                        for (Object obj3 : newLinkedHashSet) {
                            Object obj4 = i3.get(obj3);
                            if (obj4 != null) {
                                newLinkedHashMap.put(obj3, obj4);
                            } else {
                                throw new CacheLoader.InvalidCacheLoadException("loadAll failed to return a value for " + obj3);
                            }
                        }
                    } catch (CacheLoader.UnsupportedLoadingOperationException unused) {
                        for (Object obj5 : newLinkedHashSet) {
                            i2--;
                            newLinkedHashMap.put(obj5, aVar.f(obj5, aVar.s));
                        }
                    }
                }
                ImmutableMap<K, V> copyOf = ImmutableMap.copyOf(newLinkedHashMap);
                return copyOf;
            } finally {
                aVar.r.recordHits(i);
                aVar.r.recordMisses(i2);
            }
        }

        @Override // com.google.common.cache.LoadingCache
        public V getUnchecked(K k) {
            try {
                return get(k);
            } catch (ExecutionException e) {
                throw new UncheckedExecutionException(e.getCause());
            }
        }

        @Override // com.google.common.cache.LoadingCache
        public void refresh(K k) {
            a<K, V> aVar = this.a;
            Objects.requireNonNull(aVar);
            int g = aVar.g(Preconditions.checkNotNull(k));
            aVar.l(g).t(k, g, aVar.s, false);
        }

        @Override // a2.j.d.b.a.o
        public Object writeReplace() {
            return new l(this.a);
        }
    }

    public static class p<K, V> extends ForwardingCache<K, V> implements Serializable {
        private static final long serialVersionUID = 1;
        public final t a;
        public final t b;
        public final Equivalence<Object> c;
        public final Equivalence<Object> d;
        public final long e;
        public final long f;
        public final long g;
        public final Weigher<K, V> h;
        public final int i;
        public final RemovalListener<? super K, ? super V> j;
        @NullableDecl
        public final Ticker k;
        public final CacheLoader<? super K, V> l;
        @MonotonicNonNullDecl
        public transient Cache<K, V> m;

        public p(a<K, V> aVar) {
            t tVar = aVar.g;
            t tVar2 = aVar.h;
            Equivalence<Object> equivalence = aVar.e;
            Equivalence<Object> equivalence2 = aVar.f;
            long j2 = aVar.l;
            long j3 = aVar.k;
            long j4 = aVar.i;
            Weigher<K, V> weigher = aVar.j;
            int i2 = aVar.d;
            RemovalListener<K, V> removalListener = aVar.o;
            Ticker ticker = aVar.p;
            CacheLoader<? super K, V> cacheLoader = aVar.s;
            this.a = tVar;
            this.b = tVar2;
            this.c = equivalence;
            this.d = equivalence2;
            this.e = j2;
            this.f = j3;
            this.g = j4;
            this.h = weigher;
            this.i = i2;
            this.j = removalListener;
            this.k = (ticker == Ticker.systemTicker() || ticker == CacheBuilder.t) ? null : ticker;
            this.l = cacheLoader;
        }

        /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: com.google.common.cache.Cache<K1 extends K, V1 extends V>, com.google.common.cache.Cache<K, V> */
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.m = (Cache<K1, V1>) d().build();
        }

        private Object readResolve() {
            return this.m;
        }

        /* JADX DEBUG: Type inference failed for r1v9. Raw type applied. Possible types: com.google.common.cache.RemovalListener<? super K, ? super V>, com.google.common.cache.RemovalListener<? super K1 extends K, ? super V1 extends V> */
        public CacheBuilder<K, V> d() {
            CacheBuilder<Object, Object> newBuilder = CacheBuilder.newBuilder();
            newBuilder.b(this.a);
            newBuilder.c(this.b);
            Equivalence<Object> equivalence = this.c;
            Equivalence<Object> equivalence2 = newBuilder.l;
            boolean z = true;
            Preconditions.checkState(equivalence2 == null, "key equivalence was already set to %s", equivalence2);
            newBuilder.l = (Equivalence) Preconditions.checkNotNull(equivalence);
            Equivalence<Object> equivalence3 = this.d;
            Equivalence<Object> equivalence4 = newBuilder.m;
            if (equivalence4 != null) {
                z = false;
            }
            Preconditions.checkState(z, "value equivalence was already set to %s", equivalence4);
            newBuilder.m = (Equivalence) Preconditions.checkNotNull(equivalence3);
            CacheBuilder cacheBuilder = (CacheBuilder<K1, V1>) newBuilder.concurrencyLevel(this.i).removalListener((RemovalListener<? super K, ? super V>) this.j);
            cacheBuilder.a = false;
            long j2 = this.e;
            if (j2 > 0) {
                cacheBuilder.expireAfterWrite(j2, TimeUnit.NANOSECONDS);
            }
            long j3 = this.f;
            if (j3 > 0) {
                cacheBuilder.expireAfterAccess(j3, TimeUnit.NANOSECONDS);
            }
            Weigher<K, V> weigher = this.h;
            if (weigher != CacheBuilder.e.INSTANCE) {
                cacheBuilder.weigher(weigher);
                long j4 = this.g;
                if (j4 != -1) {
                    cacheBuilder.maximumWeight(j4);
                }
            } else {
                long j5 = this.g;
                if (j5 != -1) {
                    cacheBuilder.maximumSize(j5);
                }
            }
            Ticker ticker = this.k;
            if (ticker != null) {
                cacheBuilder.ticker(ticker);
            }
            return cacheBuilder;
        }

        @Override // com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public Cache<K, V> mo147delegate() {
            return this.m;
        }
    }

    public enum q implements f<Object, Object> {
        INSTANCE;

        @Override // a2.j.d.b.f
        public a0<Object, Object> a() {
            return null;
        }

        @Override // a2.j.d.b.f
        public f<Object, Object> b() {
            return null;
        }

        @Override // a2.j.d.b.f
        public void c(f<Object, Object> fVar) {
        }

        @Override // a2.j.d.b.f
        public f<Object, Object> d() {
            return this;
        }

        @Override // a2.j.d.b.f
        public void e(a0<Object, Object> a0Var) {
        }

        @Override // a2.j.d.b.f
        public long f() {
            return 0;
        }

        @Override // a2.j.d.b.f
        public int getHash() {
            return 0;
        }

        @Override // a2.j.d.b.f
        public Object getKey() {
            return null;
        }

        @Override // a2.j.d.b.f
        public void h(long j) {
        }

        @Override // a2.j.d.b.f
        public void i(long j) {
        }

        @Override // a2.j.d.b.f
        public f<Object, Object> j() {
            return this;
        }

        @Override // a2.j.d.b.f
        public f<Object, Object> l() {
            return this;
        }

        @Override // a2.j.d.b.f
        public f<Object, Object> m() {
            return this;
        }

        @Override // a2.j.d.b.f
        public long n() {
            return 0;
        }

        @Override // a2.j.d.b.f
        public void o(f<Object, Object> fVar) {
        }

        @Override // a2.j.d.b.f
        public void p(f<Object, Object> fVar) {
        }

        @Override // a2.j.d.b.f
        public void q(f<Object, Object> fVar) {
        }
    }

    public static class r<K, V> extends ReentrantLock {
        @Weak
        public final a<K, V> a;
        public volatile int b;
        @GuardedBy("this")
        public long c;
        public int d;
        public int e;
        @MonotonicNonNullDecl
        public volatile AtomicReferenceArray<f<K, V>> f;
        public final long g;
        @NullableDecl
        public final ReferenceQueue<K> h;
        @NullableDecl
        public final ReferenceQueue<V> i;
        public final Queue<f<K, V>> j;
        public final AtomicInteger k = new AtomicInteger();
        @GuardedBy("this")
        public final Queue<f<K, V>> l;
        @GuardedBy("this")
        public final Queue<f<K, V>> m;
        public final AbstractCache.StatsCounter n;

        public r(a<K, V> aVar, int i2, long j2, AbstractCache.StatsCounter statsCounter) {
            this.a = aVar;
            this.g = j2;
            this.n = (AbstractCache.StatsCounter) Preconditions.checkNotNull(statsCounter);
            AtomicReferenceArray<f<K, V>> atomicReferenceArray = new AtomicReferenceArray<>(i2);
            int length = (atomicReferenceArray.length() * 3) / 4;
            this.e = length;
            if (!(aVar.j != CacheBuilder.e.INSTANCE) && ((long) length) == j2) {
                this.e = length + 1;
            }
            this.f = atomicReferenceArray;
            ReferenceQueue<V> referenceQueue = null;
            this.h = aVar.n() ? new ReferenceQueue<>() : null;
            this.i = aVar.o() ? new ReferenceQueue<>() : referenceQueue;
            this.j = aVar.m() ? new ConcurrentLinkedQueue() : (Queue<f<K, V>>) a.y;
            this.l = aVar.e() ? new k0() : (Queue<f<K, V>>) a.y;
            this.m = aVar.m() ? new e() : (Queue<f<K, V>>) a.y;
        }

        public void A() {
            if (!isHeldByCurrentThread()) {
                a<K, V> aVar = this.a;
                while (true) {
                    RemovalNotification<K, V> poll = aVar.n.poll();
                    if (poll != null) {
                        try {
                            aVar.o.onRemoval(poll);
                        } catch (Throwable th) {
                            a.w.log(Level.WARNING, "Exception thrown by removal listener", th);
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public V B(f<K, V> fVar, K k2, int i2, V v, long j2, CacheLoader<? super K, V> cacheLoader) {
            V t;
            return (!((this.a.m > 0 ? 1 : (this.a.m == 0 ? 0 : -1)) > 0) || j2 - fVar.f() <= this.a.m || fVar.a().isLoading() || (t = t(k2, i2, cacheLoader, true)) == null) ? v : t;
        }

        @GuardedBy("this")
        public void C(f<K, V> fVar, K k2, V v, long j2) {
            a0<K, V> a3 = fVar.a();
            int weigh = this.a.j.weigh(k2, v);
            Preconditions.checkState(weigh >= 0, "Weights must be non-negative");
            fVar.e(this.a.h.b(this, fVar, v, weigh));
            b();
            this.c += (long) weigh;
            if (this.a.d()) {
                fVar.h(j2);
            }
            if (this.a.k()) {
                fVar.i(j2);
            }
            this.m.add(fVar);
            this.l.add(fVar);
            a3.b(v);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r14v4, resolved type: a2.j.d.b.a$f */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean D(K k2, int i2, m<K, V> mVar, V v) {
            lock();
            try {
                long read = this.a.p.read();
                z(read);
                int i3 = this.b + 1;
                if (i3 > this.e) {
                    f();
                    i3 = this.b + 1;
                }
                AtomicReferenceArray<f<K, V>> atomicReferenceArray = this.f;
                int length = i2 & (atomicReferenceArray.length() - 1);
                f<K, V> fVar = atomicReferenceArray.get(length);
                f<K, V> fVar2 = fVar;
                while (true) {
                    if (fVar2 == null) {
                        this.d++;
                        f<K, V> d2 = this.a.q.d(this, Preconditions.checkNotNull(k2), i2, fVar);
                        C(d2, k2, v, read);
                        atomicReferenceArray.set(length, d2);
                        this.b = i3;
                        e(d2);
                        break;
                    }
                    K key = fVar2.getKey();
                    if (fVar2.getHash() != i2 || key == null || !this.a.e.equivalent(k2, key)) {
                        fVar2 = fVar2.b();
                    } else {
                        a0<K, V> a3 = fVar2.a();
                        V v2 = a3.get();
                        if (mVar != a3) {
                            if (v2 != null || a3 == a.x) {
                                d(k2, v, 0, RemovalCause.REPLACED);
                                unlock();
                                A();
                                return false;
                            }
                        }
                        this.d++;
                        if (mVar.isActive()) {
                            d(k2, v2, mVar.c(), v2 == null ? RemovalCause.COLLECTED : RemovalCause.REPLACED);
                            i3--;
                        }
                        C(fVar2, k2, v, read);
                        this.b = i3;
                        e(fVar2);
                    }
                }
                return true;
            } finally {
                unlock();
                A();
            }
        }

        public void E() {
            if (tryLock()) {
                try {
                    c();
                } finally {
                    unlock();
                }
            }
        }

        public V F(f<K, V> fVar, K k2, a0<K, V> a0Var) throws ExecutionException {
            if (a0Var.isLoading()) {
                int i2 = 1;
                Preconditions.checkState(!Thread.holdsLock(fVar), "Recursive load of: %s", k2);
                try {
                    V d2 = a0Var.d();
                    if (d2 != null) {
                        s(fVar, this.a.p.read());
                        return d2;
                    }
                    throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + ((Object) k2) + ".");
                } finally {
                    this.n.recordMisses(i2);
                }
            } else {
                throw new AssertionError();
            }
        }

        @GuardedBy("this")
        public f<K, V> a(f<K, V> fVar, f<K, V> fVar2) {
            if (fVar.getKey() == null) {
                return null;
            }
            a0<K, V> a3 = fVar.a();
            V v = a3.get();
            if (v == null && a3.isActive()) {
                return null;
            }
            f<K, V> b2 = this.a.q.b(this, fVar, fVar2);
            b2.e(a3.e(this.i, v, b2));
            return b2;
        }

        @GuardedBy("this")
        public void b() {
            while (true) {
                f<K, V> poll = this.j.poll();
                if (poll == null) {
                    return;
                }
                if (this.m.contains(poll)) {
                    this.m.add(poll);
                }
            }
        }

        /* JADX INFO: finally extract failed */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00f6, code lost:
            if (r0.isHeldByCurrentThread() == false) goto L_0x0111;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0100, code lost:
            if (r0.isHeldByCurrentThread() == false) goto L_0x0111;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0114, code lost:
            r2 = r2 + 1;
         */
        @com.google.errorprone.annotations.concurrent.GuardedBy("this")
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c() {
            /*
            // Method dump skipped, instructions count: 296
            */
            throw new UnsupportedOperationException("Method not decompiled: a2.j.d.b.a.r.c():void");
        }

        /* JADX WARN: Incorrect args count in method signature: (TK;ITV;ILcom/google/common/cache/RemovalCause;)V */
        @GuardedBy("this")
        public void d(@NullableDecl Object obj, @NullableDecl Object obj2, int i2, RemovalCause removalCause) {
            this.c -= (long) i2;
            if (removalCause.a()) {
                this.n.recordEviction();
            }
            if (this.a.n != a.y) {
                this.a.n.offer(RemovalNotification.create(obj, obj2, removalCause));
            }
        }

        @GuardedBy("this")
        public void e(f<K, V> fVar) {
            if (this.a.c()) {
                b();
                if (((long) fVar.a().c()) <= this.g || v(fVar, fVar.getHash(), RemovalCause.SIZE)) {
                    while (this.c > this.g) {
                        for (f<K, V> fVar2 : this.m) {
                            if (fVar2.a().c() > 0) {
                                if (!v(fVar2, fVar2.getHash(), RemovalCause.SIZE)) {
                                    throw new AssertionError();
                                }
                            }
                        }
                        throw new AssertionError();
                    }
                    return;
                }
                throw new AssertionError();
            }
        }

        @GuardedBy("this")
        public void f() {
            AtomicReferenceArray<f<K, V>> atomicReferenceArray = this.f;
            int length = atomicReferenceArray.length();
            if (length < 1073741824) {
                int i2 = this.b;
                AtomicReferenceArray<f<K, V>> atomicReferenceArray2 = new AtomicReferenceArray<>(length << 1);
                this.e = (atomicReferenceArray2.length() * 3) / 4;
                int length2 = atomicReferenceArray2.length() - 1;
                for (int i3 = 0; i3 < length; i3++) {
                    f<K, V> fVar = atomicReferenceArray.get(i3);
                    if (fVar != null) {
                        f<K, V> b2 = fVar.b();
                        int hash = fVar.getHash() & length2;
                        if (b2 == null) {
                            atomicReferenceArray2.set(hash, fVar);
                        } else {
                            f<K, V> fVar2 = fVar;
                            while (b2 != null) {
                                int hash2 = b2.getHash() & length2;
                                if (hash2 != hash) {
                                    fVar2 = b2;
                                    hash = hash2;
                                }
                                b2 = b2.b();
                            }
                            atomicReferenceArray2.set(hash, fVar2);
                            while (fVar != fVar2) {
                                int hash3 = fVar.getHash() & length2;
                                f<K, V> a3 = a(fVar, atomicReferenceArray2.get(hash3));
                                if (a3 != null) {
                                    atomicReferenceArray2.set(hash3, a3);
                                } else {
                                    u(fVar);
                                    i2--;
                                }
                                fVar = fVar.b();
                            }
                        }
                    }
                }
                this.f = atomicReferenceArray2;
                this.b = i2;
            }
        }

        @GuardedBy("this")
        public void h(long j2) {
            f<K, V> peek;
            f<K, V> peek2;
            b();
            do {
                peek = this.l.peek();
                if (peek == null || !this.a.h(peek, j2)) {
                    do {
                        peek2 = this.m.peek();
                        if (peek2 == null || !this.a.h(peek2, j2)) {
                            return;
                        }
                    } while (v(peek2, peek2.getHash(), RemovalCause.EXPIRED));
                    throw new AssertionError();
                }
            } while (v(peek, peek.getHash(), RemovalCause.EXPIRED));
            throw new AssertionError();
        }

        @NullableDecl
        public V i(Object obj, int i2) {
            try {
                if (this.b != 0) {
                    long read = this.a.p.read();
                    f<K, V> m2 = m(obj, i2, read);
                    if (m2 == null) {
                        return null;
                    }
                    V v = m2.a().get();
                    if (v != null) {
                        s(m2, read);
                        V B = B(m2, m2.getKey(), i2, v, read, this.a.s);
                        p();
                        return B;
                    }
                    E();
                }
                p();
                return null;
            } finally {
                p();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0035  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public V j(K r4, int r5, a2.j.d.b.a.m<K, V> r6, com.google.common.util.concurrent.ListenableFuture<V> r7) throws java.util.concurrent.ExecutionException {
            /*
                r3 = this;
                java.lang.Object r7 = com.google.common.util.concurrent.Uninterruptibles.getUninterruptibly(r7)     // Catch:{ all -> 0x0031 }
                if (r7 == 0) goto L_0x0015
                com.google.common.cache.AbstractCache$StatsCounter r0 = r3.n     // Catch:{ all -> 0x0013 }
                long r1 = r6.f()     // Catch:{ all -> 0x0013 }
                r0.recordLoadSuccess(r1)     // Catch:{ all -> 0x0013 }
                r3.D(r4, r5, r6, r7)     // Catch:{ all -> 0x0013 }
                return r7
            L_0x0013:
                r0 = move-exception
                goto L_0x0033
            L_0x0015:
                com.google.common.cache.CacheLoader$InvalidCacheLoadException r0 = new com.google.common.cache.CacheLoader$InvalidCacheLoadException     // Catch:{ all -> 0x0013 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0013 }
                r1.<init>()     // Catch:{ all -> 0x0013 }
                java.lang.String r2 = "CacheLoader returned null for key "
                r1.append(r2)     // Catch:{ all -> 0x0013 }
                r1.append(r4)     // Catch:{ all -> 0x0013 }
                java.lang.String r2 = "."
                r1.append(r2)     // Catch:{ all -> 0x0013 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0013 }
                r0.<init>(r1)     // Catch:{ all -> 0x0013 }
                throw r0     // Catch:{ all -> 0x0013 }
            L_0x0031:
                r0 = move-exception
                r7 = 0
            L_0x0033:
                if (r7 != 0) goto L_0x0041
                com.google.common.cache.AbstractCache$StatsCounter r7 = r3.n
                long r1 = r6.f()
                r7.recordLoadException(r1)
                r3.x(r4, r5, r6)
            L_0x0041:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: a2.j.d.b.a.r.j(java.lang.Object, int, a2.j.d.b.a$m, com.google.common.util.concurrent.ListenableFuture):java.lang.Object");
        }

        @NullableDecl
        public f<K, V> l(Object obj, int i2) {
            AtomicReferenceArray<f<K, V>> atomicReferenceArray = this.f;
            for (f<K, V> fVar = atomicReferenceArray.get((atomicReferenceArray.length() - 1) & i2); fVar != null; fVar = fVar.b()) {
                if (fVar.getHash() == i2) {
                    K key = fVar.getKey();
                    if (key == null) {
                        E();
                    } else if (this.a.e.equivalent(obj, key)) {
                        return fVar;
                    }
                }
            }
            return null;
        }

        @NullableDecl
        public f<K, V> m(Object obj, int i2, long j2) {
            f<K, V> l2 = l(obj, i2);
            if (l2 == null) {
                return null;
            }
            if (!this.a.h(l2, j2)) {
                return l2;
            }
            if (tryLock()) {
                try {
                    h(j2);
                } finally {
                    unlock();
                }
            }
            return null;
        }

        public V n(f<K, V> fVar, long j2) {
            if (fVar.getKey() == null) {
                E();
                return null;
            }
            V v = fVar.a().get();
            if (v == null) {
                E();
                return null;
            } else if (!this.a.h(fVar, j2)) {
                return v;
            } else {
                if (tryLock()) {
                    try {
                        h(j2);
                    } finally {
                        unlock();
                    }
                }
                return null;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: a2.j.d.b.a$f */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x008f, code lost:
            r3 = true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public V o(K r17, int r18, com.google.common.cache.CacheLoader<? super K, V> r19) throws java.util.concurrent.ExecutionException {
            /*
                r16 = this;
                r1 = r16
                r0 = r17
                r2 = r18
                r16.lock()
                a2.j.d.b.a<K, V> r3 = r1.a     // Catch:{ all -> 0x00d8 }
                com.google.common.base.Ticker r3 = r3.p     // Catch:{ all -> 0x00d8 }
                long r3 = r3.read()     // Catch:{ all -> 0x00d8 }
                r1.z(r3)     // Catch:{ all -> 0x00d8 }
                int r5 = r1.b     // Catch:{ all -> 0x00d8 }
                r6 = 1
                int r5 = r5 - r6
                java.util.concurrent.atomic.AtomicReferenceArray<a2.j.d.b.f<K, V>> r7 = r1.f     // Catch:{ all -> 0x00d8 }
                int r8 = r7.length()     // Catch:{ all -> 0x00d8 }
                int r8 = r8 - r6
                r8 = r8 & r2
                java.lang.Object r9 = r7.get(r8)     // Catch:{ all -> 0x00d8 }
                a2.j.d.b.f r9 = (a2.j.d.b.f) r9     // Catch:{ all -> 0x00d8 }
                r10 = r9
            L_0x0027:
                r11 = 0
                if (r10 == 0) goto L_0x008e
                java.lang.Object r12 = r10.getKey()     // Catch:{ all -> 0x00d8 }
                int r13 = r10.getHash()     // Catch:{ all -> 0x00d8 }
                if (r13 != r2) goto L_0x0089
                if (r12 == 0) goto L_0x0089
                a2.j.d.b.a<K, V> r13 = r1.a     // Catch:{ all -> 0x00d8 }
                com.google.common.base.Equivalence<java.lang.Object> r13 = r13.e     // Catch:{ all -> 0x00d8 }
                boolean r13 = r13.equivalent(r0, r12)     // Catch:{ all -> 0x00d8 }
                if (r13 == 0) goto L_0x0089
                a2.j.d.b.a$a0 r13 = r10.a()     // Catch:{ all -> 0x00d8 }
                boolean r14 = r13.isLoading()     // Catch:{ all -> 0x00d8 }
                if (r14 == 0) goto L_0x004c
                r3 = 0
                goto L_0x0090
            L_0x004c:
                java.lang.Object r14 = r13.get()     // Catch:{ all -> 0x00d8 }
                if (r14 != 0) goto L_0x005c
                int r3 = r13.c()     // Catch:{ all -> 0x00d8 }
                com.google.common.cache.RemovalCause r4 = com.google.common.cache.RemovalCause.COLLECTED     // Catch:{ all -> 0x00d8 }
                r1.d(r12, r14, r3, r4)     // Catch:{ all -> 0x00d8 }
                goto L_0x006d
            L_0x005c:
                a2.j.d.b.a<K, V> r15 = r1.a     // Catch:{ all -> 0x00d8 }
                boolean r15 = r15.h(r10, r3)     // Catch:{ all -> 0x00d8 }
                if (r15 == 0) goto L_0x007a
                int r3 = r13.c()     // Catch:{ all -> 0x00d8 }
                com.google.common.cache.RemovalCause r4 = com.google.common.cache.RemovalCause.EXPIRED     // Catch:{ all -> 0x00d8 }
                r1.d(r12, r14, r3, r4)     // Catch:{ all -> 0x00d8 }
            L_0x006d:
                java.util.Queue<a2.j.d.b.f<K, V>> r3 = r1.l     // Catch:{ all -> 0x00d8 }
                r3.remove(r10)     // Catch:{ all -> 0x00d8 }
                java.util.Queue<a2.j.d.b.f<K, V>> r3 = r1.m     // Catch:{ all -> 0x00d8 }
                r3.remove(r10)     // Catch:{ all -> 0x00d8 }
                r1.b = r5     // Catch:{ all -> 0x00d8 }
                goto L_0x008f
            L_0x007a:
                r1.r(r10, r3)     // Catch:{ all -> 0x00d8 }
                com.google.common.cache.AbstractCache$StatsCounter r0 = r1.n     // Catch:{ all -> 0x00d8 }
                r0.recordHits(r6)     // Catch:{ all -> 0x00d8 }
                r16.unlock()
                r16.A()
                return r14
            L_0x0089:
                a2.j.d.b.f r10 = r10.b()
                goto L_0x0027
            L_0x008e:
                r13 = r11
            L_0x008f:
                r3 = 1
            L_0x0090:
                if (r3 == 0) goto L_0x00af
                a2.j.d.b.a$m r11 = new a2.j.d.b.a$m
                r11.<init>()
                if (r10 != 0) goto L_0x00ac
                a2.j.d.b.a<K, V> r4 = r1.a
                a2.j.d.b.a$f r4 = r4.q
                java.lang.Object r5 = com.google.common.base.Preconditions.checkNotNull(r17)
                a2.j.d.b.f r10 = r4.d(r1, r5, r2, r9)
                r10.e(r11)
                r7.set(r8, r10)
                goto L_0x00af
            L_0x00ac:
                r10.e(r11)
            L_0x00af:
                r16.unlock()
                r16.A()
                if (r3 == 0) goto L_0x00d3
                monitor-enter(r10)     // Catch:{ all -> 0x00cc }
                r3 = r19
                com.google.common.util.concurrent.ListenableFuture r3 = r11.g(r0, r3)     // Catch:{ all -> 0x00c9 }
                java.lang.Object r0 = r1.j(r0, r2, r11, r3)     // Catch:{ all -> 0x00c9 }
                monitor-exit(r10)     // Catch:{ all -> 0x00c9 }
                com.google.common.cache.AbstractCache$StatsCounter r2 = r1.n
                r2.recordMisses(r6)
                return r0
            L_0x00c9:
                r0 = move-exception
                monitor-exit(r10)
                throw r0
            L_0x00cc:
                r0 = move-exception
                com.google.common.cache.AbstractCache$StatsCounter r2 = r1.n
                r2.recordMisses(r6)
                throw r0
            L_0x00d3:
                java.lang.Object r0 = r1.F(r10, r0, r13)
                return r0
            L_0x00d8:
                r0 = move-exception
                r16.unlock()
                r16.A()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: a2.j.d.b.a.r.o(java.lang.Object, int, com.google.common.cache.CacheLoader):java.lang.Object");
        }

        public void p() {
            if ((this.k.incrementAndGet() & 63) == 0) {
                z(this.a.p.read());
                A();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r14v4, resolved type: a2.j.d.b.a$f */
        /* JADX WARN: Multi-variable type inference failed */
        @NullableDecl
        public V q(K k2, int i2, V v, boolean z) {
            int i3;
            lock();
            try {
                long read = this.a.p.read();
                z(read);
                if (this.b + 1 > this.e) {
                    f();
                }
                AtomicReferenceArray<f<K, V>> atomicReferenceArray = this.f;
                int length = i2 & (atomicReferenceArray.length() - 1);
                f<K, V> fVar = atomicReferenceArray.get(length);
                for (f<K, V> fVar2 = fVar; fVar2 != null; fVar2 = fVar2.b()) {
                    K key = fVar2.getKey();
                    if (fVar2.getHash() == i2 && key != null && this.a.e.equivalent(k2, key)) {
                        a0<K, V> a3 = fVar2.a();
                        V v2 = a3.get();
                        if (v2 == null) {
                            this.d++;
                            if (a3.isActive()) {
                                d(k2, v2, a3.c(), RemovalCause.COLLECTED);
                                C(fVar2, k2, v, read);
                                i3 = this.b;
                            } else {
                                C(fVar2, k2, v, read);
                                i3 = this.b + 1;
                            }
                            this.b = i3;
                            e(fVar2);
                            return null;
                        } else if (z) {
                            r(fVar2, read);
                            unlock();
                            A();
                            return v2;
                        } else {
                            this.d++;
                            d(k2, v2, a3.c(), RemovalCause.REPLACED);
                            C(fVar2, k2, v, read);
                            e(fVar2);
                            unlock();
                            A();
                            return v2;
                        }
                    }
                }
                this.d++;
                f<K, V> d2 = this.a.q.d(this, Preconditions.checkNotNull(k2), i2, fVar);
                C(d2, k2, v, read);
                atomicReferenceArray.set(length, d2);
                this.b++;
                e(d2);
                unlock();
                A();
                return null;
            } finally {
                unlock();
                A();
            }
        }

        @GuardedBy("this")
        public void r(f<K, V> fVar, long j2) {
            if (this.a.d()) {
                fVar.h(j2);
            }
            this.m.add(fVar);
        }

        public void s(f<K, V> fVar, long j2) {
            if (this.a.d()) {
                fVar.h(j2);
            }
            this.j.add(fVar);
        }

        /* JADX INFO: finally extract failed */
        /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: a2.j.d.b.a$f */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x008d, code lost:
            unlock();
            A();
            r5 = r1;
         */
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public V t(K r13, int r14, com.google.common.cache.CacheLoader<? super K, V> r15, boolean r16) {
            /*
                r12 = this;
                r7 = r12
                r0 = r13
                r4 = r14
                r12.lock()
                a2.j.d.b.a<K, V> r1 = r7.a     // Catch:{ all -> 0x00b9 }
                com.google.common.base.Ticker r1 = r1.p     // Catch:{ all -> 0x00b9 }
                long r1 = r1.read()     // Catch:{ all -> 0x00b9 }
                r12.z(r1)     // Catch:{ all -> 0x00b9 }
                java.util.concurrent.atomic.AtomicReferenceArray<a2.j.d.b.f<K, V>> r3 = r7.f     // Catch:{ all -> 0x00b9 }
                int r5 = r3.length()     // Catch:{ all -> 0x00b9 }
                int r5 = r5 + -1
                r5 = r5 & r4
                java.lang.Object r6 = r3.get(r5)     // Catch:{ all -> 0x00b9 }
                a2.j.d.b.f r6 = (a2.j.d.b.f) r6     // Catch:{ all -> 0x00b9 }
                r8 = r6
            L_0x0021:
                r9 = 0
                if (r8 == 0) goto L_0x0070
                java.lang.Object r10 = r8.getKey()     // Catch:{ all -> 0x00b9 }
                int r11 = r8.getHash()     // Catch:{ all -> 0x00b9 }
                if (r11 != r4) goto L_0x006b
                if (r10 == 0) goto L_0x006b
                a2.j.d.b.a<K, V> r11 = r7.a     // Catch:{ all -> 0x00b9 }
                com.google.common.base.Equivalence<java.lang.Object> r11 = r11.e     // Catch:{ all -> 0x00b9 }
                boolean r10 = r11.equivalent(r13, r10)     // Catch:{ all -> 0x00b9 }
                if (r10 == 0) goto L_0x006b
                a2.j.d.b.a$a0 r3 = r8.a()     // Catch:{ all -> 0x00b9 }
                boolean r5 = r3.isLoading()     // Catch:{ all -> 0x00b9 }
                if (r5 != 0) goto L_0x0063
                if (r16 == 0) goto L_0x0054
                long r5 = r8.f()     // Catch:{ all -> 0x00b9 }
                long r1 = r1 - r5
                a2.j.d.b.a<K, V> r5 = r7.a     // Catch:{ all -> 0x00b9 }
                long r5 = r5.m     // Catch:{ all -> 0x00b9 }
                int r10 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
                if (r10 >= 0) goto L_0x0054
                goto L_0x0063
            L_0x0054:
                int r1 = r7.d     // Catch:{ all -> 0x00b9 }
                int r1 = r1 + 1
                r7.d = r1     // Catch:{ all -> 0x00b9 }
                a2.j.d.b.a$m r1 = new a2.j.d.b.a$m     // Catch:{ all -> 0x00b9 }
                r1.<init>(r3)     // Catch:{ all -> 0x00b9 }
                r8.e(r1)     // Catch:{ all -> 0x00b9 }
                goto L_0x008d
            L_0x0063:
                r12.unlock()
                r12.A()
                r5 = r9
                goto L_0x0094
            L_0x006b:
                a2.j.d.b.f r8 = r8.b()
                goto L_0x0021
            L_0x0070:
                int r1 = r7.d
                int r1 = r1 + 1
                r7.d = r1
                a2.j.d.b.a$m r1 = new a2.j.d.b.a$m
                r1.<init>()
                a2.j.d.b.a<K, V> r2 = r7.a
                a2.j.d.b.a$f r2 = r2.q
                java.lang.Object r8 = com.google.common.base.Preconditions.checkNotNull(r13)
                a2.j.d.b.f r2 = r2.d(r12, r8, r14, r6)
                r2.e(r1)
                r3.set(r5, r2)
            L_0x008d:
                r12.unlock()
                r12.A()
                r5 = r1
            L_0x0094:
                if (r5 != 0) goto L_0x0097
                return r9
            L_0x0097:
                r1 = r15
                com.google.common.util.concurrent.ListenableFuture r8 = r5.g(r13, r15)
                a2.j.d.b.b r10 = new a2.j.d.b.b
                r1 = r10
                r2 = r12
                r3 = r13
                r4 = r14
                r6 = r8
                r1.<init>(r2, r3, r4, r5, r6)
                java.util.concurrent.Executor r0 = com.google.common.util.concurrent.MoreExecutors.directExecutor()
                r8.addListener(r10, r0)
                boolean r0 = r8.isDone()
                if (r0 == 0) goto L_0x00b8
                java.lang.Object r0 = com.google.common.util.concurrent.Uninterruptibles.getUninterruptibly(r8)     // Catch:{ all -> 0x00b8 }
                return r0
            L_0x00b8:
                return r9
            L_0x00b9:
                r0 = move-exception
                r12.unlock()
                r12.A()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: a2.j.d.b.a.r.t(java.lang.Object, int, com.google.common.cache.CacheLoader, boolean):java.lang.Object");
        }

        @GuardedBy("this")
        public void u(f<K, V> fVar) {
            K key = fVar.getKey();
            fVar.getHash();
            d(key, fVar.a().get(), fVar.a().c(), RemovalCause.COLLECTED);
            this.l.remove(fVar);
            this.m.remove(fVar);
        }

        @VisibleForTesting
        @GuardedBy("this")
        public boolean v(f<K, V> fVar, int i2, RemovalCause removalCause) {
            AtomicReferenceArray<f<K, V>> atomicReferenceArray = this.f;
            int length = (atomicReferenceArray.length() - 1) & i2;
            f<K, V> fVar2 = atomicReferenceArray.get(length);
            for (f<K, V> fVar3 = fVar2; fVar3 != null; fVar3 = fVar3.b()) {
                if (fVar3 == fVar) {
                    this.d++;
                    atomicReferenceArray.set(length, y(fVar2, fVar3, fVar3.getKey(), i2, fVar3.a().get(), fVar3.a(), removalCause));
                    this.b--;
                    return true;
                }
            }
            return false;
        }

        @NullableDecl
        @GuardedBy("this")
        public f<K, V> w(f<K, V> fVar, f<K, V> fVar2) {
            int i2 = this.b;
            f<K, V> b2 = fVar2.b();
            while (fVar != fVar2) {
                f<K, V> a3 = a(fVar, b2);
                if (a3 != null) {
                    b2 = a3;
                } else {
                    u(fVar);
                    i2--;
                }
                fVar = fVar.b();
            }
            this.b = i2;
            return b2;
        }

        public boolean x(K k2, int i2, m<K, V> mVar) {
            lock();
            try {
                AtomicReferenceArray<f<K, V>> atomicReferenceArray = this.f;
                int length = (atomicReferenceArray.length() - 1) & i2;
                f<K, V> fVar = atomicReferenceArray.get(length);
                f<K, V> fVar2 = fVar;
                while (true) {
                    if (fVar2 == null) {
                        break;
                    }
                    K key = fVar2.getKey();
                    if (fVar2.getHash() != i2 || key == null || !this.a.e.equivalent(k2, key)) {
                        fVar2 = fVar2.b();
                    } else if (fVar2.a() == mVar) {
                        if (mVar.isActive()) {
                            fVar2.e(mVar.a);
                        } else {
                            atomicReferenceArray.set(length, w(fVar, fVar2));
                        }
                        return true;
                    }
                }
                unlock();
                A();
                return false;
            } finally {
                unlock();
                A();
            }
        }

        @NullableDecl
        @GuardedBy("this")
        public f<K, V> y(f<K, V> fVar, f<K, V> fVar2, @NullableDecl K k2, int i2, V v, a0<K, V> a0Var, RemovalCause removalCause) {
            d(k2, v, a0Var.c(), removalCause);
            this.l.remove(fVar2);
            this.m.remove(fVar2);
            if (!a0Var.isLoading()) {
                return w(fVar, fVar2);
            }
            a0Var.b(null);
            return fVar;
        }

        public void z(long j2) {
            if (tryLock()) {
                try {
                    c();
                    h(j2);
                    this.k.set(0);
                } finally {
                    unlock();
                }
            }
        }
    }

    public static class s<K, V> extends SoftReference<V> implements a0<K, V> {
        public final f<K, V> a;

        public s(ReferenceQueue<V> referenceQueue, V v, f<K, V> fVar) {
            super(v, referenceQueue);
            this.a = fVar;
        }

        @Override // a2.j.d.b.a.a0
        public f<K, V> a() {
            return this.a;
        }

        @Override // a2.j.d.b.a.a0
        public void b(V v) {
        }

        @Override // a2.j.d.b.a.a0
        public int c() {
            return 1;
        }

        @Override // a2.j.d.b.a.a0
        public V d() {
            return (V) get();
        }

        @Override // a2.j.d.b.a.a0
        public a0<K, V> e(ReferenceQueue<V> referenceQueue, V v, f<K, V> fVar) {
            return new s(referenceQueue, v, fVar);
        }

        @Override // a2.j.d.b.a.a0
        public boolean isActive() {
            return true;
        }

        @Override // a2.j.d.b.a.a0
        public boolean isLoading() {
            return false;
        }
    }

    public enum t {
        STRONG {
            @Override // a2.j.d.b.a.t
            public Equivalence<Object> a() {
                return Equivalence.equals();
            }

            @Override // a2.j.d.b.a.t
            public <K, V> a0<K, V> b(r<K, V> rVar, f<K, V> fVar, V v, int i) {
                return i == 1 ? new x(v) : new i0(v, i);
            }
        },
        SOFT {
            @Override // a2.j.d.b.a.t
            public Equivalence<Object> a() {
                return Equivalence.identity();
            }

            @Override // a2.j.d.b.a.t
            public <K, V> a0<K, V> b(r<K, V> rVar, f<K, V> fVar, V v, int i) {
                return i == 1 ? new s(rVar.i, v, fVar) : new h0(rVar.i, v, fVar, i);
            }
        },
        WEAK {
            @Override // a2.j.d.b.a.t
            public Equivalence<Object> a() {
                return Equivalence.identity();
            }

            @Override // a2.j.d.b.a.t
            public <K, V> a0<K, V> b(r<K, V> rVar, f<K, V> fVar, V v, int i) {
                return i == 1 ? new f0(rVar.i, v, fVar) : new j0(rVar.i, v, fVar, i);
            }
        };

        /* access modifiers changed from: public */
        t(C0051a aVar) {
        }

        public abstract Equivalence<Object> a();

        public abstract <K, V> a0<K, V> b(r<K, V> rVar, f<K, V> fVar, V v, int i);
    }

    public static final class u<K, V> extends w<K, V> {
        public volatile long e = Long.MAX_VALUE;
        public f<K, V> f;
        public f<K, V> g;

        public u(K k, int i, @NullableDecl f<K, V> fVar) {
            super(k, i, fVar);
            Logger logger = a.w;
            q qVar = q.INSTANCE;
            this.f = qVar;
            this.g = qVar;
        }

        @Override // a2.j.d.b.a.d, a2.j.d.b.f
        public void c(f<K, V> fVar) {
            this.g = fVar;
        }

        @Override // a2.j.d.b.a.d, a2.j.d.b.f
        public void h(long j) {
            this.e = j;
        }

        @Override // a2.j.d.b.a.d, a2.j.d.b.f
        public f<K, V> j() {
            return this.g;
        }

        @Override // a2.j.d.b.a.d, a2.j.d.b.f
        public f<K, V> m() {
            return this.f;
        }

        @Override // a2.j.d.b.a.d, a2.j.d.b.f
        public long n() {
            return this.e;
        }

        @Override // a2.j.d.b.a.d, a2.j.d.b.f
        public void o(f<K, V> fVar) {
            this.f = fVar;
        }
    }

    public static final class v<K, V> extends w<K, V> {
        public volatile long e = Long.MAX_VALUE;
        public f<K, V> f;
        public f<K, V> g;
        public volatile long h;
        public f<K, V> i;
        public f<K, V> j;

        public v(K k, int i2, @NullableDecl f<K, V> fVar) {
            super(k, i2, fVar);
            Logger logger = a.w;
            q qVar = q.INSTANCE;
            this.f = qVar;
            this.g = qVar;
            this.h = Long.MAX_VALUE;
            this.i = qVar;
            this.j = qVar;
        }

        @Override // a2.j.d.b.a.d, a2.j.d.b.f
        public void c(f<K, V> fVar) {
            this.g = fVar;
        }

        @Override // a2.j.d.b.a.d, a2.j.d.b.f
        public f<K, V> d() {
            return this.j;
        }

        @Override // a2.j.d.b.a.d, a2.j.d.b.f
        public long f() {
            return this.h;
        }

        @Override // a2.j.d.b.a.d, a2.j.d.b.f
        public void h(long j2) {
            this.e = j2;
        }

        @Override // a2.j.d.b.a.d, a2.j.d.b.f
        public void i(long j2) {
            this.h = j2;
        }

        @Override // a2.j.d.b.a.d, a2.j.d.b.f
        public f<K, V> j() {
            return this.g;
        }

        @Override // a2.j.d.b.a.d, a2.j.d.b.f
        public f<K, V> l() {
            return this.i;
        }

        @Override // a2.j.d.b.a.d, a2.j.d.b.f
        public f<K, V> m() {
            return this.f;
        }

        @Override // a2.j.d.b.a.d, a2.j.d.b.f
        public long n() {
            return this.e;
        }

        @Override // a2.j.d.b.a.d, a2.j.d.b.f
        public void o(f<K, V> fVar) {
            this.f = fVar;
        }

        @Override // a2.j.d.b.a.d, a2.j.d.b.f
        public void p(f<K, V> fVar) {
            this.i = fVar;
        }

        @Override // a2.j.d.b.a.d, a2.j.d.b.f
        public void q(f<K, V> fVar) {
            this.j = fVar;
        }
    }

    public static class w<K, V> extends d<K, V> {
        public final K a;
        public final int b;
        @NullableDecl
        public final f<K, V> c;
        public volatile a0<K, V> d = ((a0<K, V>) a.x);

        public w(K k, int i, @NullableDecl f<K, V> fVar) {
            this.a = k;
            this.b = i;
            this.c = fVar;
        }

        @Override // a2.j.d.b.a.d, a2.j.d.b.f
        public a0<K, V> a() {
            return this.d;
        }

        @Override // a2.j.d.b.a.d, a2.j.d.b.f
        public f<K, V> b() {
            return this.c;
        }

        @Override // a2.j.d.b.a.d, a2.j.d.b.f
        public void e(a0<K, V> a0Var) {
            this.d = a0Var;
        }

        @Override // a2.j.d.b.a.d, a2.j.d.b.f
        public int getHash() {
            return this.b;
        }

        @Override // a2.j.d.b.a.d, a2.j.d.b.f
        public K getKey() {
            return this.a;
        }
    }

    public static class x<K, V> implements a0<K, V> {
        public final V a;

        public x(V v) {
            this.a = v;
        }

        @Override // a2.j.d.b.a.a0
        public f<K, V> a() {
            return null;
        }

        @Override // a2.j.d.b.a.a0
        public void b(V v) {
        }

        @Override // a2.j.d.b.a.a0
        public int c() {
            return 1;
        }

        @Override // a2.j.d.b.a.a0
        public V d() {
            return this.a;
        }

        @Override // a2.j.d.b.a.a0
        public a0<K, V> e(ReferenceQueue<V> referenceQueue, V v, f<K, V> fVar) {
            return this;
        }

        @Override // a2.j.d.b.a.a0
        public V get() {
            return this.a;
        }

        @Override // a2.j.d.b.a.a0
        public boolean isActive() {
            return true;
        }

        @Override // a2.j.d.b.a.a0
        public boolean isLoading() {
            return false;
        }
    }

    public static final class y<K, V> extends w<K, V> {
        public volatile long e = Long.MAX_VALUE;
        public f<K, V> f;
        public f<K, V> g;

        public y(K k, int i, @NullableDecl f<K, V> fVar) {
            super(k, i, fVar);
            Logger logger = a.w;
            q qVar = q.INSTANCE;
            this.f = qVar;
            this.g = qVar;
        }

        @Override // a2.j.d.b.a.d, a2.j.d.b.f
        public f<K, V> d() {
            return this.g;
        }

        @Override // a2.j.d.b.a.d, a2.j.d.b.f
        public long f() {
            return this.e;
        }

        @Override // a2.j.d.b.a.d, a2.j.d.b.f
        public void i(long j) {
            this.e = j;
        }

        @Override // a2.j.d.b.a.d, a2.j.d.b.f
        public f<K, V> l() {
            return this.f;
        }

        @Override // a2.j.d.b.a.d, a2.j.d.b.f
        public void p(f<K, V> fVar) {
            this.f = fVar;
        }

        @Override // a2.j.d.b.a.d, a2.j.d.b.f
        public void q(f<K, V> fVar) {
            this.g = fVar;
        }
    }

    public final class z extends a<K, V>.i {
        public z(a aVar) {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return c().b;
        }
    }

    public a(CacheBuilder<? super K, ? super V> cacheBuilder, @NullableDecl CacheLoader<? super K, V> cacheLoader) {
        int i2 = cacheBuilder.c;
        char c2 = 4;
        this.d = Math.min(i2 == -1 ? 4 : i2, 65536);
        t tVar = cacheBuilder.g;
        t tVar2 = t.STRONG;
        t tVar3 = (t) MoreObjects.firstNonNull(tVar, tVar2);
        this.g = tVar3;
        this.h = (t) MoreObjects.firstNonNull(cacheBuilder.h, tVar2);
        this.e = (Equivalence) MoreObjects.firstNonNull(cacheBuilder.l, ((t) MoreObjects.firstNonNull(cacheBuilder.g, tVar2)).a());
        this.f = (Equivalence) MoreObjects.firstNonNull(cacheBuilder.m, ((t) MoreObjects.firstNonNull(cacheBuilder.h, tVar2)).a());
        long j2 = 0;
        long j3 = (cacheBuilder.i == 0 || cacheBuilder.j == 0) ? 0 : cacheBuilder.f == null ? cacheBuilder.d : cacheBuilder.e;
        this.i = j3;
        Weigher<? super K, ? super V> weigher = cacheBuilder.f;
        CacheBuilder.e eVar = CacheBuilder.e.INSTANCE;
        Weigher<K, V> weigher2 = (Weigher) MoreObjects.firstNonNull(weigher, eVar);
        this.j = weigher2;
        long j4 = cacheBuilder.j;
        this.k = j4 == -1 ? 0 : j4;
        long j5 = cacheBuilder.i;
        this.l = j5 == -1 ? 0 : j5;
        long j6 = cacheBuilder.k;
        this.m = j6 != -1 ? j6 : j2;
        RemovalListener<? super K, ? super V> removalListener = cacheBuilder.n;
        CacheBuilder.d dVar = CacheBuilder.d.INSTANCE;
        RemovalListener<K, V> removalListener2 = (RemovalListener) MoreObjects.firstNonNull(removalListener, dVar);
        this.o = removalListener2;
        this.n = removalListener2 == dVar ? (Queue<RemovalNotification<K, V>>) y : new ConcurrentLinkedQueue();
        int i3 = 0;
        int i4 = 1;
        boolean z2 = k() || d();
        Ticker ticker = cacheBuilder.o;
        if (ticker == null) {
            ticker = z2 ? Ticker.systemTicker() : CacheBuilder.t;
        }
        this.p = ticker;
        this.q = f.i[(tVar3 != t.WEAK ? 0 : c2) | ((m() || d()) ? (char) 1 : 0) | (e() || k() ? 2 : 0)];
        this.r = (AbstractCache.StatsCounter) cacheBuilder.p.get();
        this.s = cacheLoader;
        int i5 = cacheBuilder.b;
        int min = Math.min(i5 == -1 ? 16 : i5, 1073741824);
        if (c()) {
            if (!(weigher2 != eVar)) {
                min = (int) Math.min((long) min, j3);
            }
        }
        int i6 = 1;
        int i7 = 0;
        while (i6 < this.d && (!c() || ((long) (i6 * 20)) <= this.i)) {
            i7++;
            i6 <<= 1;
        }
        this.b = 32 - i7;
        this.a = i6 - 1;
        this.c = new r[i6];
        int i8 = min / i6;
        while (i4 < (i8 * i6 < min ? i8 + 1 : i8)) {
            i4 <<= 1;
        }
        if (c()) {
            long j7 = this.i;
            long j8 = (long) i6;
            long j9 = (j7 / j8) + 1;
            long j10 = j7 % j8;
            while (true) {
                r<K, V>[] rVarArr = this.c;
                if (i3 < rVarArr.length) {
                    if (((long) i3) == j10) {
                        j9--;
                    }
                    rVarArr[i3] = new r<>(this, i4, j9, (AbstractCache.StatsCounter) cacheBuilder.p.get());
                    i3++;
                    j9 = j9;
                } else {
                    return;
                }
            }
        } else {
            while (true) {
                r<K, V>[] rVarArr2 = this.c;
                if (i3 < rVarArr2.length) {
                    rVarArr2[i3] = new r<>(this, i4, -1, (AbstractCache.StatsCounter) cacheBuilder.p.get());
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    public static ArrayList a(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterators.addAll(arrayList, collection.iterator());
        return arrayList;
    }

    public boolean c() {
        return this.i >= 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        RemovalCause removalCause;
        r<K, V>[] rVarArr = this.c;
        int length = rVarArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            r<K, V> rVar = rVarArr[i2];
            if (rVar.b != 0) {
                rVar.lock();
                try {
                    rVar.z(rVar.a.p.read());
                    AtomicReferenceArray<f<K, V>> atomicReferenceArray = rVar.f;
                    for (int i3 = 0; i3 < atomicReferenceArray.length(); i3++) {
                        for (f<K, V> fVar = atomicReferenceArray.get(i3); fVar != null; fVar = fVar.b()) {
                            if (fVar.a().isActive()) {
                                K key = fVar.getKey();
                                V v2 = fVar.a().get();
                                if (key != null) {
                                    if (v2 != null) {
                                        removalCause = RemovalCause.EXPLICIT;
                                        fVar.getHash();
                                        rVar.d(key, v2, fVar.a().c(), removalCause);
                                    }
                                }
                                removalCause = RemovalCause.COLLECTED;
                                fVar.getHash();
                                rVar.d(key, v2, fVar.a().c(), removalCause);
                            }
                        }
                    }
                    for (int i4 = 0; i4 < atomicReferenceArray.length(); i4++) {
                        atomicReferenceArray.set(i4, null);
                    }
                    if (rVar.a.n()) {
                        while (rVar.h.poll() != null) {
                        }
                    }
                    if (rVar.a.o()) {
                        while (rVar.i.poll() != null) {
                        }
                    }
                    rVar.l.clear();
                    rVar.m.clear();
                    rVar.k.set(0);
                    rVar.d++;
                    rVar.b = 0;
                } finally {
                    rVar.unlock();
                    rVar.A();
                }
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        boolean z2 = false;
        if (obj == null) {
            return false;
        }
        int g2 = g(obj);
        r<K, V> l2 = l(g2);
        Objects.requireNonNull(l2);
        try {
            if (l2.b != 0) {
                f<K, V> m2 = l2.m(obj, g2, l2.a.p.read());
                if (m2 != null) {
                    if (m2.a().get() != null) {
                        z2 = true;
                    }
                }
            }
            return z2;
        } finally {
            l2.p();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        if (obj == null) {
            return false;
        }
        long read = this.p.read();
        r<K, V>[] rVarArr = this.c;
        long j2 = -1;
        int i2 = 0;
        while (i2 < 3) {
            long j3 = 0;
            int length = rVarArr.length;
            int i3 = 0;
            while (i3 < length) {
                r<K, V> rVar = rVarArr[i3];
                int i4 = rVar.b;
                AtomicReferenceArray<f<K, V>> atomicReferenceArray = rVar.f;
                for (int i5 = 0; i5 < atomicReferenceArray.length(); i5++) {
                    f<K, V> fVar = atomicReferenceArray.get(i5);
                    while (fVar != null) {
                        V n2 = rVar.n(fVar, read);
                        if (n2 != null && this.f.equivalent(obj, n2)) {
                            return true;
                        }
                        fVar = fVar.b();
                        rVarArr = rVarArr;
                        read = read;
                    }
                }
                j3 += (long) rVar.d;
                i3++;
                read = read;
            }
            if (j3 == j2) {
                return false;
            }
            i2++;
            j2 = j3;
            rVarArr = rVarArr;
            read = read;
        }
        return false;
    }

    public boolean d() {
        return this.k > 0;
    }

    public boolean e() {
        return this.l > 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @GwtIncompatible
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.v;
        if (set != null) {
            return set;
        }
        h hVar = new h(this);
        this.v = hVar;
        return hVar;
    }

    public V f(K k2, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
        V v2;
        f<K, V> l2;
        int g2 = g(Preconditions.checkNotNull(k2));
        r<K, V> l3 = l(g2);
        Objects.requireNonNull(l3);
        Preconditions.checkNotNull(k2);
        Preconditions.checkNotNull(cacheLoader);
        try {
            if (!(l3.b == 0 || (l2 = l3.l(k2, g2)) == null)) {
                long read = l3.a.p.read();
                V n2 = l3.n(l2, read);
                if (n2 != null) {
                    l3.s(l2, read);
                    l3.n.recordHits(1);
                    v2 = l3.B(l2, k2, g2, n2, read, cacheLoader);
                } else {
                    a0<K, V> a3 = l2.a();
                    if (a3.isLoading()) {
                        v2 = l3.F(l2, k2, a3);
                    }
                }
                l3.p();
                return v2;
            }
            v2 = l3.o(k2, g2, cacheLoader);
            l3.p();
            return v2;
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof Error) {
                throw new ExecutionError((Error) cause);
            } else if (cause instanceof RuntimeException) {
                throw new UncheckedExecutionException(cause);
            } else {
                throw e2;
            }
        } catch (Throwable th) {
            l3.p();
            throw th;
        }
    }

    public int g(@NullableDecl Object obj) {
        int hash = this.e.hash(obj);
        int i2 = hash + ((hash << 15) ^ -12931);
        int i3 = i2 ^ (i2 >>> 10);
        int i4 = i3 + (i3 << 3);
        int i5 = i4 ^ (i4 >>> 6);
        int i6 = (i5 << 2) + (i5 << 14) + i5;
        return (i6 >>> 16) ^ i6;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public V get(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int g2 = g(obj);
        return l(g2).i(obj, g2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @NullableDecl
    public V getOrDefault(@NullableDecl Object obj, @NullableDecl V v2) {
        V v3 = get(obj);
        return v3 != null ? v3 : v2;
    }

    public boolean h(f<K, V> fVar, long j2) {
        Preconditions.checkNotNull(fVar);
        if (d() && j2 - fVar.n() >= this.k) {
            return true;
        }
        if (!e() || j2 - fVar.f() < this.l) {
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: a2.j.d.b.a<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @NullableDecl
    public Map<K, V> i(Set<? extends K> set, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
        Throwable th;
        Preconditions.checkNotNull(cacheLoader);
        Preconditions.checkNotNull(set);
        Stopwatch createStarted = Stopwatch.createStarted();
        boolean z2 = false;
        try {
            Map map = (Map<? super K, V>) cacheLoader.loadAll(set);
            if (map != null) {
                createStarted.stop();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    K key = entry.getKey();
                    V value = entry.getValue();
                    if (key == null || value == null) {
                        z2 = true;
                    } else {
                        put(key, value);
                    }
                }
                if (!z2) {
                    this.r.recordLoadSuccess(createStarted.elapsed(TimeUnit.NANOSECONDS));
                    return map;
                }
                this.r.recordLoadException(createStarted.elapsed(TimeUnit.NANOSECONDS));
                throw new CacheLoader.InvalidCacheLoadException(cacheLoader + " returned null keys or values from loadAll");
            }
            this.r.recordLoadException(createStarted.elapsed(TimeUnit.NANOSECONDS));
            throw new CacheLoader.InvalidCacheLoadException(cacheLoader + " returned null map from loadAll");
        } catch (CacheLoader.UnsupportedLoadingOperationException e2) {
            throw e2;
        } catch (InterruptedException e3) {
            Thread.currentThread().interrupt();
            throw new ExecutionException(e3);
        } catch (RuntimeException e4) {
            throw new UncheckedExecutionException(e4);
        } catch (Exception e5) {
            throw new ExecutionException(e5);
        } catch (Error e6) {
            throw new ExecutionError(e6);
        } catch (Throwable th2) {
            th = th2;
            z2 = true;
        }
        if (!z2) {
            this.r.recordLoadException(createStarted.elapsed(TimeUnit.NANOSECONDS));
        }
        throw th;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        r<K, V>[] rVarArr = this.c;
        long j2 = 0;
        for (int i2 = 0; i2 < rVarArr.length; i2++) {
            if (rVarArr[i2].b != 0) {
                return false;
            }
            j2 += (long) rVarArr[i2].d;
        }
        if (j2 == 0) {
            return true;
        }
        for (int i3 = 0; i3 < rVarArr.length; i3++) {
            if (rVarArr[i3].b != 0) {
                return false;
            }
            j2 -= (long) rVarArr[i3].d;
        }
        if (j2 != 0) {
            return false;
        }
        return true;
    }

    public long j() {
        r<K, V>[] rVarArr;
        long j2 = 0;
        for (r<K, V> rVar : this.c) {
            j2 += (long) Math.max(0, rVar.b);
        }
        return j2;
    }

    public boolean k() {
        if (e()) {
            return true;
        }
        if (this.m > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.t;
        if (set != null) {
            return set;
        }
        k kVar = new k(this);
        this.t = kVar;
        return kVar;
    }

    public r<K, V> l(int i2) {
        return this.c[(i2 >>> this.b) & this.a];
    }

    public boolean m() {
        return d() || c();
    }

    public boolean n() {
        return this.g != t.STRONG;
    }

    public boolean o() {
        return this.h != t.STRONG;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k2, V v2) {
        Preconditions.checkNotNull(k2);
        Preconditions.checkNotNull(v2);
        int g2 = g(k2);
        return l(g2).q(k2, g2, v2, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: a2.j.d.b.a<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k2, V v2) {
        Preconditions.checkNotNull(k2);
        Preconditions.checkNotNull(v2);
        int g2 = g(k2);
        return l(g2).q(k2, g2, v2, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(@NullableDecl Object obj) {
        RemovalCause removalCause;
        if (obj == null) {
            return null;
        }
        int g2 = g(obj);
        r<K, V> l2 = l(g2);
        l2.lock();
        try {
            l2.z(l2.a.p.read());
            AtomicReferenceArray<f<K, V>> atomicReferenceArray = l2.f;
            int length = (atomicReferenceArray.length() - 1) & g2;
            f<K, V> fVar = atomicReferenceArray.get(length);
            f<K, V> fVar2 = fVar;
            while (true) {
                if (fVar2 == null) {
                    break;
                }
                K key = fVar2.getKey();
                if (fVar2.getHash() != g2 || key == null || !l2.a.e.equivalent(obj, key)) {
                    fVar2 = fVar2.b();
                } else {
                    a0<K, V> a3 = fVar2.a();
                    V v2 = a3.get();
                    if (v2 != null) {
                        removalCause = RemovalCause.EXPLICIT;
                    } else if (a3.isActive()) {
                        removalCause = RemovalCause.COLLECTED;
                    }
                    l2.d++;
                    atomicReferenceArray.set(length, l2.y(fVar, fVar2, key, g2, v2, a3, removalCause));
                    l2.b--;
                    return v2;
                }
            }
            l2.unlock();
            l2.A();
            return null;
        } finally {
            l2.unlock();
            l2.A();
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k2, @NullableDecl V v2, V v3) {
        Preconditions.checkNotNull(k2);
        Preconditions.checkNotNull(v3);
        if (v2 == null) {
            return false;
        }
        int g2 = g(k2);
        r<K, V> l2 = l(g2);
        l2.lock();
        try {
            long read = l2.a.p.read();
            l2.z(read);
            AtomicReferenceArray<f<K, V>> atomicReferenceArray = l2.f;
            int length = g2 & (atomicReferenceArray.length() - 1);
            f<K, V> fVar = atomicReferenceArray.get(length);
            f<K, V> fVar2 = fVar;
            while (true) {
                if (fVar2 == null) {
                    break;
                }
                K key = fVar2.getKey();
                if (fVar2.getHash() != g2 || key == null || !l2.a.e.equivalent(k2, key)) {
                    fVar2 = fVar2.b();
                } else {
                    a0<K, V> a3 = fVar2.a();
                    V v4 = a3.get();
                    if (v4 == null) {
                        if (a3.isActive()) {
                            l2.d++;
                            atomicReferenceArray.set(length, l2.y(fVar, fVar2, key, g2, v4, a3, RemovalCause.COLLECTED));
                            l2.b--;
                        }
                    } else if (l2.a.f.equivalent(v2, v4)) {
                        l2.d++;
                        l2.d(k2, v4, a3.c(), RemovalCause.REPLACED);
                        l2.C(fVar2, k2, v3, read);
                        l2.e(fVar2);
                        l2.unlock();
                        l2.A();
                        return true;
                    } else {
                        l2.r(fVar2, read);
                    }
                }
            }
            return false;
        } finally {
            l2.unlock();
            l2.A();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return Ints.saturatedCast(j());
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.u;
        if (collection != null) {
            return collection;
        }
        b0 b0Var = new b0(this);
        this.u = b0Var;
        return b0Var;
    }

    public static class o<K, V> implements Cache<K, V>, Serializable {
        private static final long serialVersionUID = 1;
        public final a<K, V> a;

        /* renamed from: a2.j.d.b.a$o$a  reason: collision with other inner class name */
        public class C0057a extends CacheLoader<Object, V> {
            public final /* synthetic */ Callable a;

            public C0057a(o oVar, Callable callable) {
                this.a = callable;
            }

            @Override // com.google.common.cache.CacheLoader
            public V load(Object obj) throws Exception {
                return (V) this.a.call();
            }
        }

        public o(CacheBuilder<? super K, ? super V> cacheBuilder) {
            this.a = new a<>(cacheBuilder, null);
        }

        @Override // com.google.common.cache.Cache
        public ConcurrentMap<K, V> asMap() {
            return this.a;
        }

        @Override // com.google.common.cache.Cache
        public void cleanUp() {
            r<K, V>[] rVarArr = this.a.c;
            for (r<K, V> rVar : rVarArr) {
                rVar.z(rVar.a.p.read());
                rVar.A();
            }
        }

        @Override // com.google.common.cache.Cache
        public V get(K k, Callable<? extends V> callable) throws ExecutionException {
            Preconditions.checkNotNull(callable);
            return this.a.f(k, new C0057a(this, callable));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.LinkedHashMap */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.cache.Cache
        public ImmutableMap<K, V> getAllPresent(Iterable<?> iterable) {
            a<K, V> aVar = this.a;
            Objects.requireNonNull(aVar);
            LinkedHashMap newLinkedHashMap = Maps.newLinkedHashMap();
            int i = 0;
            int i2 = 0;
            for (Object obj : iterable) {
                V v = aVar.get(obj);
                if (v == null) {
                    i2++;
                } else {
                    newLinkedHashMap.put(obj, v);
                    i++;
                }
            }
            aVar.r.recordHits(i);
            aVar.r.recordMisses(i2);
            return ImmutableMap.copyOf(newLinkedHashMap);
        }

        @Override // com.google.common.cache.Cache
        @NullableDecl
        public V getIfPresent(Object obj) {
            a<K, V> aVar = this.a;
            Objects.requireNonNull(aVar);
            int g = aVar.g(Preconditions.checkNotNull(obj));
            V i = aVar.l(g).i(obj, g);
            if (i == null) {
                aVar.r.recordMisses(1);
            } else {
                aVar.r.recordHits(1);
            }
            return i;
        }

        @Override // com.google.common.cache.Cache
        public void invalidate(Object obj) {
            Preconditions.checkNotNull(obj);
            this.a.remove(obj);
        }

        @Override // com.google.common.cache.Cache
        public void invalidateAll(Iterable<?> iterable) {
            a<K, V> aVar = this.a;
            Objects.requireNonNull(aVar);
            Iterator<?> it = iterable.iterator();
            while (it.hasNext()) {
                aVar.remove(it.next());
            }
        }

        @Override // com.google.common.cache.Cache
        public void put(K k, V v) {
            this.a.put(k, v);
        }

        @Override // com.google.common.cache.Cache
        public void putAll(Map<? extends K, ? extends V> map) {
            this.a.putAll(map);
        }

        @Override // com.google.common.cache.Cache
        public long size() {
            return this.a.j();
        }

        @Override // com.google.common.cache.Cache
        public CacheStats stats() {
            AbstractCache.SimpleStatsCounter simpleStatsCounter = new AbstractCache.SimpleStatsCounter();
            simpleStatsCounter.incrementBy(this.a.r);
            for (r<K, V> rVar : this.a.c) {
                simpleStatsCounter.incrementBy(rVar.n);
            }
            return simpleStatsCounter.snapshot();
        }

        public Object writeReplace() {
            return new p(this.a);
        }

        public o(a aVar, C0051a aVar2) {
            this.a = aVar;
        }

        @Override // com.google.common.cache.Cache
        public void invalidateAll() {
            this.a.clear();
        }
    }

    public static class m<K, V> implements a0<K, V> {
        public volatile a0<K, V> a;
        public final SettableFuture<V> b;
        public final Stopwatch c;

        /* renamed from: a2.j.d.b.a$m$a  reason: collision with other inner class name */
        public class C0056a implements Function<V, V> {
            public C0056a() {
            }

            @Override // com.google.common.base.Function
            public V apply(V v) {
                m.this.b.set(v);
                return v;
            }
        }

        public m() {
            this.b = SettableFuture.create();
            this.c = Stopwatch.createUnstarted();
            this.a = (a0<K, V>) a.x;
        }

        @Override // a2.j.d.b.a.a0
        public f<K, V> a() {
            return null;
        }

        @Override // a2.j.d.b.a.a0
        public void b(@NullableDecl V v) {
            if (v != null) {
                this.b.set(v);
            } else {
                this.a = (a0<K, V>) a.x;
            }
        }

        @Override // a2.j.d.b.a.a0
        public int c() {
            return this.a.c();
        }

        @Override // a2.j.d.b.a.a0
        public V d() throws ExecutionException {
            return (V) Uninterruptibles.getUninterruptibly(this.b);
        }

        @Override // a2.j.d.b.a.a0
        public a0<K, V> e(ReferenceQueue<V> referenceQueue, @NullableDecl V v, f<K, V> fVar) {
            return this;
        }

        public long f() {
            return this.c.elapsed(TimeUnit.NANOSECONDS);
        }

        public ListenableFuture<V> g(K k, CacheLoader<? super K, V> cacheLoader) {
            ListenableFuture<V> listenableFuture;
            try {
                this.c.start();
                V v = this.a.get();
                if (v == null) {
                    V load = cacheLoader.load(k);
                    return h(load) ? this.b : Futures.immediateFuture(load);
                }
                ListenableFuture<V> reload = cacheLoader.reload(k, v);
                if (reload == null) {
                    return Futures.immediateFuture(null);
                }
                return Futures.transform(reload, new C0056a(), MoreExecutors.directExecutor());
            } catch (Throwable th) {
                if (this.b.setException(th)) {
                    listenableFuture = this.b;
                } else {
                    listenableFuture = Futures.immediateFailedFuture(th);
                }
                if (th instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                return listenableFuture;
            }
        }

        @Override // a2.j.d.b.a.a0
        public V get() {
            return this.a.get();
        }

        public boolean h(@NullableDecl V v) {
            return this.b.set(v);
        }

        @Override // a2.j.d.b.a.a0
        public boolean isActive() {
            return this.a.isActive();
        }

        @Override // a2.j.d.b.a.a0
        public boolean isLoading() {
            return true;
        }

        public m(a0<K, V> a0Var) {
            this.b = SettableFuture.create();
            this.c = Stopwatch.createUnstarted();
            this.a = a0Var;
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        RemovalCause removalCause;
        boolean z2 = false;
        if (obj == null || obj2 == null) {
            return false;
        }
        int g2 = g(obj);
        r<K, V> l2 = l(g2);
        l2.lock();
        try {
            l2.z(l2.a.p.read());
            AtomicReferenceArray<f<K, V>> atomicReferenceArray = l2.f;
            int length = (atomicReferenceArray.length() - 1) & g2;
            f<K, V> fVar = atomicReferenceArray.get(length);
            f<K, V> fVar2 = fVar;
            while (true) {
                if (fVar2 == null) {
                    break;
                }
                K key = fVar2.getKey();
                if (fVar2.getHash() != g2 || key == null || !l2.a.e.equivalent(obj, key)) {
                    fVar2 = fVar2.b();
                } else {
                    a0<K, V> a3 = fVar2.a();
                    V v2 = a3.get();
                    if (l2.a.f.equivalent(obj2, v2)) {
                        removalCause = RemovalCause.EXPLICIT;
                    } else if (v2 == null && a3.isActive()) {
                        removalCause = RemovalCause.COLLECTED;
                    }
                    l2.d++;
                    atomicReferenceArray.set(length, l2.y(fVar, fVar2, key, g2, v2, a3, removalCause));
                    l2.b--;
                    if (removalCause == RemovalCause.EXPLICIT) {
                        z2 = true;
                    }
                }
            }
            return z2;
        } finally {
            l2.unlock();
            l2.A();
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k2, V v2) {
        Preconditions.checkNotNull(k2);
        Preconditions.checkNotNull(v2);
        int g2 = g(k2);
        r<K, V> l2 = l(g2);
        l2.lock();
        try {
            long read = l2.a.p.read();
            l2.z(read);
            AtomicReferenceArray<f<K, V>> atomicReferenceArray = l2.f;
            int length = g2 & (atomicReferenceArray.length() - 1);
            f<K, V> fVar = atomicReferenceArray.get(length);
            f<K, V> fVar2 = fVar;
            while (true) {
                if (fVar2 == null) {
                    break;
                }
                K key = fVar2.getKey();
                if (fVar2.getHash() != g2 || key == null || !l2.a.e.equivalent(k2, key)) {
                    fVar2 = fVar2.b();
                } else {
                    a0<K, V> a3 = fVar2.a();
                    V v3 = a3.get();
                    if (v3 != null) {
                        l2.d++;
                        l2.d(k2, v3, a3.c(), RemovalCause.REPLACED);
                        l2.C(fVar2, k2, v2, read);
                        l2.e(fVar2);
                        l2.unlock();
                        l2.A();
                        return v3;
                    } else if (a3.isActive()) {
                        l2.d++;
                        atomicReferenceArray.set(length, l2.y(fVar, fVar2, key, g2, v3, a3, RemovalCause.COLLECTED));
                        l2.b--;
                    }
                }
            }
            return null;
        } finally {
            l2.unlock();
            l2.A();
        }
    }
}
