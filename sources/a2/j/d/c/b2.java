package a2.j.d.c;

import a2.j.d.c.b2.i;
import a2.j.d.c.b2.n;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingConcurrentMap;
import com.google.common.collect.Iterators;
import com.google.common.collect.MapMaker;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtIncompatible
public class b2<K, V, E extends i<K, V, E>, S extends n<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    public static final f0<Object, Object, e> j = new a();
    private static final long serialVersionUID = 5;
    public final transient int a;
    public final transient int b;
    public final transient n<K, V, E, S>[] c;
    public final int d;
    public final Equivalence<Object> e;
    public final transient j<K, V, E, S> f;
    @MonotonicNonNullDecl
    public transient Set<K> g;
    @MonotonicNonNullDecl
    public transient Collection<V> h;
    @MonotonicNonNullDecl
    public transient Set<Map.Entry<K, V>> i;

    public static class a implements f0<Object, Object, e> {
        /* Return type fixed from 'a2.j.d.c.b2$i' to match base method */
        @Override // a2.j.d.c.b2.f0
        public /* bridge */ /* synthetic */ e a() {
            return null;
        }

        /* Return type fixed from 'a2.j.d.c.b2$f0' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.ref.ReferenceQueue, a2.j.d.c.b2$i] */
        @Override // a2.j.d.c.b2.f0
        public f0<Object, Object, e> b(ReferenceQueue<Object> referenceQueue, e eVar) {
            return this;
        }

        @Override // a2.j.d.c.b2.f0
        public void clear() {
        }

        @Override // a2.j.d.c.b2.f0
        public Object get() {
            return null;
        }
    }

    public static final class a0<K, V> extends d<K, V, a0<K, V>> implements Object<K, V, a0<K, V>> {
        @NullableDecl
        public volatile V c = null;

        public static final class a<K, V> implements j<K, V, a0<K, V>, b0<K, V>> {
            public static final a<?, ?> a = new a<>();

            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // a2.j.d.c.b2.j
            public void a(n nVar, i iVar, Object obj) {
                b0 b0Var = (b0) nVar;
                ((a0) iVar).c = obj;
            }

            @Override // a2.j.d.c.b2.j
            public p b() {
                return p.WEAK;
            }

            @Override // a2.j.d.c.b2.j
            public i c(n nVar, i iVar, @NullableDecl i iVar2) {
                b0 b0Var = (b0) nVar;
                a0 a0Var = (a0) iVar;
                a0 a0Var2 = (a0) iVar2;
                if (a0Var.get() == null) {
                    return null;
                }
                a0 a0Var3 = new a0(b0Var.i, a0Var.get(), a0Var.a, a0Var2);
                a0Var3.c = a0Var.c;
                return a0Var3;
            }

            @Override // a2.j.d.c.b2.j
            public p d() {
                return p.STRONG;
            }

            @Override // a2.j.d.c.b2.j
            public i e(n nVar, Object obj, int i, @NullableDecl i iVar) {
                return new a0(((b0) nVar).i, obj, i, (a0) iVar);
            }

            @Override // a2.j.d.c.b2.j
            public n f(b2 b2Var, int i, int i2) {
                return new b0(b2Var, i, i2);
            }
        }

        public a0(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl a0<K, V> a0Var) {
            super(referenceQueue, k, i, a0Var);
        }

        @Override // a2.j.d.c.b2.i
        @NullableDecl
        public V getValue() {
            return this.c;
        }
    }

    public static final class b0<K, V> extends n<K, V, a0<K, V>, b0<K, V>> {
        public final ReferenceQueue<K> i = new ReferenceQueue<>();

        public b0(b2<K, V, a0<K, V>, b0<K, V>> b2Var, int i2, int i3) {
            super(b2Var, i2, i3);
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.lang.ref.ReferenceQueue<K>, java.lang.ref.ReferenceQueue<T> */
        @Override // a2.j.d.c.b2.n
        public void f() {
            a((ReferenceQueue<K>) this.i);
        }

        @Override // a2.j.d.c.b2.n
        public void h() {
            b(this.i);
        }

        @Override // a2.j.d.c.b2.n
        public n n() {
            return this;
        }
    }

    public static abstract class c<K, V, E extends i<K, V, E>> implements i<K, V, E> {
        public final K a;
        public final int b;
        @NullableDecl
        public final E c;

        public c(K k, int i, @NullableDecl E e) {
            this.a = k;
            this.b = i;
            this.c = e;
        }

        @Override // a2.j.d.c.b2.i
        public E b() {
            return this.c;
        }

        @Override // a2.j.d.c.b2.i
        public int getHash() {
            return this.b;
        }

        @Override // a2.j.d.c.b2.i
        public K getKey() {
            return this.a;
        }
    }

    public static final class c0<K, V> extends d<K, V, c0<K, V>> implements e0<K, V, c0<K, V>> {
        public volatile f0<K, V, c0<K, V>> c = ((f0<K, V, c0<K, V>>) b2.j);

        public static final class a<K, V> implements j<K, V, c0<K, V>, d0<K, V>> {
            public static final a<?, ?> a = new a<>();

            @Override // a2.j.d.c.b2.j
            public void a(n nVar, i iVar, Object obj) {
                c0 c0Var = (c0) iVar;
                ReferenceQueue<V> referenceQueue = ((d0) nVar).j;
                f0<K, V, c0<K, V>> f0Var = c0Var.c;
                c0Var.c = new g0(referenceQueue, obj, c0Var);
                f0Var.clear();
            }

            @Override // a2.j.d.c.b2.j
            public p b() {
                return p.WEAK;
            }

            @Override // a2.j.d.c.b2.j
            public i c(n nVar, i iVar, @NullableDecl i iVar2) {
                d0 d0Var = (d0) nVar;
                c0 c0Var = (c0) iVar;
                c0 c0Var2 = (c0) iVar2;
                if (c0Var.get() == null) {
                    return null;
                }
                int i = n.h;
                if (c0Var.getValue() == null) {
                    return null;
                }
                ReferenceQueue<K> referenceQueue = d0Var.i;
                ReferenceQueue<V> referenceQueue2 = d0Var.j;
                c0<K, V> c0Var3 = new c0<>(referenceQueue, c0Var.get(), c0Var.a, c0Var2);
                c0Var3.c = c0Var.c.b(referenceQueue2, c0Var3);
                return c0Var3;
            }

            @Override // a2.j.d.c.b2.j
            public p d() {
                return p.WEAK;
            }

            @Override // a2.j.d.c.b2.j
            public i e(n nVar, Object obj, int i, @NullableDecl i iVar) {
                return new c0(((d0) nVar).i, obj, i, (c0) iVar);
            }

            @Override // a2.j.d.c.b2.j
            public n f(b2 b2Var, int i, int i2) {
                return new d0(b2Var, i, i2);
            }
        }

        public c0(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl c0<K, V> c0Var) {
            super(referenceQueue, k, i, c0Var);
            f0<Object, Object, e> f0Var = b2.j;
        }

        @Override // a2.j.d.c.b2.e0
        public f0<K, V, c0<K, V>> a() {
            return this.c;
        }

        @Override // a2.j.d.c.b2.i
        public V getValue() {
            return this.c.get();
        }
    }

    public static abstract class d<K, V, E extends i<K, V, E>> extends WeakReference<K> implements i<K, V, E> {
        public final int a;
        @NullableDecl
        public final E b;

        public d(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl E e) {
            super(k, referenceQueue);
            this.a = i;
            this.b = e;
        }

        @Override // a2.j.d.c.b2.i
        public E b() {
            return this.b;
        }

        @Override // a2.j.d.c.b2.i
        public int getHash() {
            return this.a;
        }

        @Override // a2.j.d.c.b2.i
        public K getKey() {
            return (K) get();
        }
    }

    public static final class d0<K, V> extends n<K, V, c0<K, V>, d0<K, V>> {
        public final ReferenceQueue<K> i = new ReferenceQueue<>();
        public final ReferenceQueue<V> j = new ReferenceQueue<>();

        public d0(b2<K, V, c0<K, V>, d0<K, V>> b2Var, int i2, int i3) {
            super(b2Var, i2, i3);
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.lang.ref.ReferenceQueue<K>, java.lang.ref.ReferenceQueue<T> */
        @Override // a2.j.d.c.b2.n
        public void f() {
            a((ReferenceQueue<K>) this.i);
        }

        @Override // a2.j.d.c.b2.n
        public void h() {
            b(this.i);
            c(this.j);
        }

        @Override // a2.j.d.c.b2.n
        public n n() {
            return this;
        }
    }

    public static final class e implements i<Object, Object, e> {
        public e() {
            throw new AssertionError();
        }

        /* Return type fixed from 'a2.j.d.c.b2$i' to match base method */
        @Override // a2.j.d.c.b2.i
        public e b() {
            throw new AssertionError();
        }

        @Override // a2.j.d.c.b2.i
        public int getHash() {
            throw new AssertionError();
        }

        @Override // a2.j.d.c.b2.i
        public Object getKey() {
            throw new AssertionError();
        }

        @Override // a2.j.d.c.b2.i
        public Object getValue() {
            throw new AssertionError();
        }
    }

    public interface e0<K, V, E extends i<K, V, E>> extends i<K, V, E> {
        f0<K, V, E> a();
    }

    public final class f extends b2<K, V, E, S>.h {
        public f(b2 b2Var) {
            super();
        }

        @Override // java.util.Iterator
        public Object next() {
            return c();
        }
    }

    public interface f0<K, V, E extends i<K, V, E>> {
        E a();

        f0<K, V, E> b(ReferenceQueue<V> referenceQueue, E e);

        void clear();

        @NullableDecl
        V get();
    }

    public final class g extends m<Map.Entry<K, V>> {
        public g() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            b2.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            if ((obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = b2.this.get(key)) != null && b2.this.e().equivalent(entry.getValue(), obj2)) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return b2.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new f(b2.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            if ((obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && b2.this.remove(key, entry.getValue())) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return b2.this.size();
        }
    }

    public static final class g0<K, V, E extends i<K, V, E>> extends WeakReference<V> implements f0<K, V, E> {
        @Weak
        public final E a;

        public g0(ReferenceQueue<V> referenceQueue, V v, E e) {
            super(v, referenceQueue);
            this.a = e;
        }

        @Override // a2.j.d.c.b2.f0
        public E a() {
            return this.a;
        }

        @Override // a2.j.d.c.b2.f0
        public f0<K, V, E> b(ReferenceQueue<V> referenceQueue, E e) {
            return new g0(referenceQueue, get(), e);
        }
    }

    public abstract class h<T> implements Iterator<T> {
        public int a;
        public int b = -1;
        @MonotonicNonNullDecl
        public n<K, V, E, S> c;
        @MonotonicNonNullDecl
        public AtomicReferenceArray<E> d;
        @NullableDecl
        public E e;
        @NullableDecl
        public b2<K, V, E, S>.h0 f;
        @NullableDecl
        public b2<K, V, E, S>.h0 g;

        public h() {
            this.a = b2.this.c.length - 1;
            a();
        }

        public final void a() {
            this.f = null;
            if (!d() && !e()) {
                while (true) {
                    int i = this.a;
                    if (i >= 0) {
                        n<K, V, E, S>[] nVarArr = b2.this.c;
                        this.a = i - 1;
                        n<K, V, E, S> nVar = nVarArr[i];
                        this.c = nVar;
                        if (nVar.b != 0) {
                            AtomicReferenceArray<E> atomicReferenceArray = this.c.e;
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

        public boolean b(E e2) {
            Object obj;
            boolean z;
            try {
                Object key = e2.getKey();
                Objects.requireNonNull(b2.this);
                if (e2.getKey() == null) {
                    obj = null;
                } else {
                    obj = e2.getValue();
                }
                if (obj != null) {
                    this.f = new h0(key, obj);
                    z = true;
                } else {
                    z = false;
                }
                return z;
            } finally {
                this.c.i();
            }
        }

        public b2<K, V, E, S>.h0 c() {
            b2<K, V, E, S>.h0 h0Var = this.f;
            if (h0Var != null) {
                this.g = h0Var;
                a();
                return this.g;
            }
            throw new NoSuchElementException();
        }

        public boolean d() {
            E e2 = this.e;
            if (e2 == null) {
                return false;
            }
            while (true) {
                this.e = (E) e2.b();
                E e3 = this.e;
                if (e3 == null) {
                    return false;
                }
                if (b(e3)) {
                    return true;
                }
                e2 = this.e;
            }
        }

        public boolean e() {
            while (true) {
                int i = this.b;
                if (i < 0) {
                    return false;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.d;
                this.b = i - 1;
                E e2 = atomicReferenceArray.get(i);
                this.e = e2;
                if (e2 != null && (b(e2) || d())) {
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
            Preconditions.checkState(this.g != null, "no calls to next() since the last call to remove()");
            b2.this.remove(this.g.a);
            this.g = null;
        }
    }

    public final class h0 extends g<K, V> {
        public final K a;
        public V b;

        public h0(K k, V v) {
            this.a = k;
            this.b = v;
        }

        @Override // a2.j.d.c.g, java.util.Map.Entry, java.lang.Object
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

        @Override // a2.j.d.c.g, java.util.Map.Entry
        public K getKey() {
            return this.a;
        }

        @Override // a2.j.d.c.g, java.util.Map.Entry
        public V getValue() {
            return this.b;
        }

        @Override // a2.j.d.c.g, java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return this.a.hashCode() ^ this.b.hashCode();
        }

        @Override // a2.j.d.c.g, java.util.Map.Entry
        public V setValue(V v) {
            V v2 = (V) b2.this.put(this.a, v);
            this.b = v;
            return v2;
        }
    }

    public interface i<K, V, E extends i<K, V, E>> {
        E b();

        int getHash();

        K getKey();

        V getValue();
    }

    public interface j<K, V, E extends i<K, V, E>, S extends n<K, V, E, S>> {
        void a(S s, E e, V v);

        p b();

        E c(S s, E e, @NullableDecl E e2);

        p d();

        E e(S s, K k, int i, @NullableDecl E e);

        S f(b2<K, V, E, S> b2Var, int i, int i2);
    }

    public final class k extends b2<K, V, E, S>.h {
        public k(b2 b2Var) {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return c().a;
        }
    }

    public final class l extends m<K> {
        public l() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            b2.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return b2.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return b2.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<K> iterator() {
            return new k(b2.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return b2.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return b2.this.size();
        }
    }

    public static abstract class m<E> extends AbstractSet<E> {
        public m(a aVar) {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return b2.a(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) b2.a(this).toArray(tArr);
        }
    }

    public static abstract class n<K, V, E extends i<K, V, E>, S extends n<K, V, E, S>> extends ReentrantLock {
        public static final /* synthetic */ int h = 0;
        @Weak
        public final b2<K, V, E, S> a;
        public volatile int b;
        public int c;
        public int d;
        @MonotonicNonNullDecl
        public volatile AtomicReferenceArray<E> e;
        public final int f;
        public final AtomicInteger g = new AtomicInteger();

        public n(b2<K, V, E, S> b2Var, int i, int i2) {
            this.a = b2Var;
            this.f = i2;
            AtomicReferenceArray<E> atomicReferenceArray = new AtomicReferenceArray<>(i);
            int length = (atomicReferenceArray.length() * 3) / 4;
            this.d = length;
            if (length == i2) {
                this.d = length + 1;
            }
            this.e = atomicReferenceArray;
        }

        public <T> void a(ReferenceQueue<T> referenceQueue) {
            do {
            } while (referenceQueue.poll() != null);
        }

        /* JADX INFO: finally extract failed */
        @GuardedBy("this")
        public void b(ReferenceQueue<K> referenceQueue) {
            int i = 0;
            do {
                Reference<? extends K> poll = referenceQueue.poll();
                if (poll != null) {
                    i iVar = (i) poll;
                    b2<K, V, E, S> b2Var = this.a;
                    Objects.requireNonNull(b2Var);
                    int hash = iVar.getHash();
                    n<K, V, E, S> d2 = b2Var.d(hash);
                    d2.lock();
                    try {
                        AtomicReferenceArray<E> atomicReferenceArray = d2.e;
                        int length = hash & (atomicReferenceArray.length() - 1);
                        E e2 = atomicReferenceArray.get(length);
                        i iVar2 = e2;
                        while (true) {
                            if (iVar2 == null) {
                                break;
                            } else if (iVar2 == iVar) {
                                d2.c++;
                                atomicReferenceArray.set(length, d2.l(e2, iVar2));
                                d2.b--;
                                break;
                            } else {
                                iVar2 = iVar2.b();
                            }
                        }
                        d2.unlock();
                        i++;
                    } catch (Throwable th) {
                        d2.unlock();
                        throw th;
                    }
                } else {
                    return;
                }
            } while (i != 16);
        }

        /* JADX INFO: finally extract failed */
        @GuardedBy("this")
        public void c(ReferenceQueue<V> referenceQueue) {
            int i = 0;
            do {
                Reference<? extends V> poll = referenceQueue.poll();
                if (poll != null) {
                    f0<K, V, E> f0Var = (f0) poll;
                    b2<K, V, E, S> b2Var = this.a;
                    Objects.requireNonNull(b2Var);
                    E a3 = f0Var.a();
                    int hash = a3.getHash();
                    n<K, V, E, S> d2 = b2Var.d(hash);
                    Object key = a3.getKey();
                    d2.lock();
                    try {
                        AtomicReferenceArray<E> atomicReferenceArray = d2.e;
                        int length = (atomicReferenceArray.length() - 1) & hash;
                        E e2 = atomicReferenceArray.get(length);
                        E e3 = e2;
                        while (true) {
                            if (e3 == null) {
                                break;
                            }
                            Object key2 = e3.getKey();
                            if (e3.getHash() != hash || key2 == null || !d2.a.e.equivalent(key, key2)) {
                                e3 = (E) e3.b();
                            } else if (((e0) e3).a() == f0Var) {
                                d2.c++;
                                atomicReferenceArray.set(length, d2.l(e2, e3));
                                d2.b--;
                            }
                        }
                        d2.unlock();
                        i++;
                    } catch (Throwable th) {
                        d2.unlock();
                        throw th;
                    }
                } else {
                    return;
                }
            } while (i != 16);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.concurrent.atomic.AtomicReferenceArray<E extends a2.j.d.c.b2$i<K, V, E>> */
        /* JADX DEBUG: Multi-variable search result rejected for r10v1, resolved type: a2.j.d.c.b2$j<K, V, E extends a2.j.d.c.b2$i<K, V, E>, S extends a2.j.d.c.b2$n<K, V, E, S>> */
        /* JADX WARN: Multi-variable type inference failed */
        @GuardedBy("this")
        public void d() {
            AtomicReferenceArray<E> atomicReferenceArray = this.e;
            int length = atomicReferenceArray.length();
            if (length < 1073741824) {
                int i = this.b;
                AtomicReferenceArray<E> atomicReferenceArray2 = (AtomicReferenceArray<E>) new AtomicReferenceArray(length << 1);
                this.d = (atomicReferenceArray2.length() * 3) / 4;
                int length2 = atomicReferenceArray2.length() - 1;
                for (int i2 = 0; i2 < length; i2++) {
                    E e2 = atomicReferenceArray.get(i2);
                    if (e2 != null) {
                        i b2 = e2.b();
                        int hash = e2.getHash() & length2;
                        if (b2 == null) {
                            atomicReferenceArray2.set(hash, e2);
                        } else {
                            i iVar = e2;
                            while (b2 != null) {
                                int hash2 = b2.getHash() & length2;
                                if (hash2 != hash) {
                                    iVar = b2;
                                    hash = hash2;
                                }
                                b2 = b2.b();
                            }
                            atomicReferenceArray2.set(hash, iVar);
                            while (e2 != iVar) {
                                int hash3 = e2.getHash() & length2;
                                i c2 = this.a.f.c(n(), e2, (i) atomicReferenceArray2.get(hash3));
                                if (c2 != null) {
                                    atomicReferenceArray2.set(hash3, c2);
                                } else {
                                    i--;
                                }
                                e2 = e2.b();
                            }
                        }
                    }
                }
                this.e = atomicReferenceArray2;
                this.b = i;
            }
        }

        public E e(Object obj, int i) {
            if (this.b == 0) {
                return null;
            }
            AtomicReferenceArray<E> atomicReferenceArray = this.e;
            for (E e2 = atomicReferenceArray.get((atomicReferenceArray.length() - 1) & i); e2 != null; e2 = (E) e2.b()) {
                if (e2.getHash() == i) {
                    Object key = e2.getKey();
                    if (key == null) {
                        p();
                    } else if (this.a.e.equivalent(obj, key)) {
                        return e2;
                    }
                }
            }
            return null;
        }

        public void f() {
        }

        @GuardedBy("this")
        public void h() {
        }

        public void i() {
            if ((this.g.incrementAndGet() & 63) == 0) {
                m();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r10v4, resolved type: a2.j.d.c.b2$j<K, V, E extends a2.j.d.c.b2$i<K, V, E>, S extends a2.j.d.c.b2$n<K, V, E, S>> */
        /* JADX DEBUG: Multi-variable search result rejected for r9v7, resolved type: a2.j.d.c.b2$j<K, V, E extends a2.j.d.c.b2$i<K, V, E>, S extends a2.j.d.c.b2$n<K, V, E, S>> */
        /* JADX WARN: Multi-variable type inference failed */
        public V j(K k, int i, V v, boolean z) {
            lock();
            try {
                m();
                int i2 = this.b + 1;
                if (i2 > this.d) {
                    d();
                    i2 = this.b + 1;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.e;
                int length = (atomicReferenceArray.length() - 1) & i;
                E e2 = atomicReferenceArray.get(length);
                for (i iVar = e2; iVar != null; iVar = iVar.b()) {
                    Object key = iVar.getKey();
                    if (iVar.getHash() == i && key != null && this.a.e.equivalent(k, key)) {
                        V v2 = (V) iVar.getValue();
                        if (v2 == null) {
                            this.c++;
                            this.a.f.a(n(), iVar, v);
                            this.b = this.b;
                            return null;
                        } else if (z) {
                            unlock();
                            return v2;
                        } else {
                            this.c++;
                            this.a.f.a(n(), iVar, v);
                            unlock();
                            return v2;
                        }
                    }
                }
                this.c++;
                E e3 = this.a.f.e(n(), k, i, e2);
                o(e3, v);
                atomicReferenceArray.set(length, e3);
                this.b = i2;
                unlock();
                return null;
            } finally {
                unlock();
            }
        }

        @GuardedBy("this")
        public E l(E e2, E e3) {
            int i = this.b;
            E e4 = (E) e3.b();
            while (e2 != e3) {
                E c2 = this.a.f.c(n(), e2, e4);
                if (c2 != null) {
                    e4 = c2;
                } else {
                    i--;
                }
                e2 = (E) e2.b();
            }
            this.b = i;
            return e4;
        }

        public void m() {
            if (tryLock()) {
                try {
                    h();
                    this.g.set(0);
                } finally {
                    unlock();
                }
            }
        }

        public abstract S n();

        public void o(E e2, V v) {
            this.a.f.a(n(), e2, v);
        }

        public void p() {
            if (tryLock()) {
                try {
                    h();
                } finally {
                    unlock();
                }
            }
        }
    }

    public static final class o<K, V> extends b<K, V> {
        private static final long serialVersionUID = 3;

        public o(p pVar, p pVar2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i, ConcurrentMap<K, V> concurrentMap) {
            super(pVar, pVar2, equivalence, equivalence2, i, concurrentMap);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.concurrent.ConcurrentMap<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            MapMaker initialCapacity = new MapMaker().initialCapacity(objectInputStream.readInt());
            initialCapacity.d(this.a);
            initialCapacity.e(this.b);
            initialCapacity.c(this.c);
            this.e = initialCapacity.concurrencyLevel(this.d).makeMap();
            while (true) {
                Object readObject = objectInputStream.readObject();
                if (readObject != null) {
                    this.e.put(readObject, objectInputStream.readObject());
                } else {
                    return;
                }
            }
        }

        private Object readResolve() {
            return this.e;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeInt(this.e.size());
            for (Map.Entry<K, V> entry : this.e.entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            objectOutputStream.writeObject(null);
        }
    }

    public enum p {
        STRONG {
            @Override // a2.j.d.c.b2.p
            public Equivalence<Object> a() {
                return Equivalence.equals();
            }
        },
        WEAK {
            @Override // a2.j.d.c.b2.p
            public Equivalence<Object> a() {
                return Equivalence.identity();
            }
        };

        /* access modifiers changed from: public */
        p(a aVar) {
        }

        public abstract Equivalence<Object> a();
    }

    public static final class q<K> extends c<K, MapMaker.a, q<K>> implements Object<K, MapMaker.a, q<K>> {

        public static final class a<K> implements j<K, MapMaker.a, q<K>, r<K>> {
            public static final a<?> a = new a<>();

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [a2.j.d.c.b2$n, a2.j.d.c.b2$i, java.lang.Object] */
            @Override // a2.j.d.c.b2.j
            public void a(n nVar, i iVar, MapMaker.a aVar) {
                r rVar = (r) nVar;
                q qVar = (q) iVar;
            }

            @Override // a2.j.d.c.b2.j
            public p b() {
                return p.STRONG;
            }

            @Override // a2.j.d.c.b2.j
            public i c(n nVar, i iVar, @NullableDecl i iVar2) {
                r rVar = (r) nVar;
                q qVar = (q) iVar;
                return new q(qVar.a, qVar.b, (q) iVar2);
            }

            @Override // a2.j.d.c.b2.j
            public p d() {
                return p.STRONG;
            }

            @Override // a2.j.d.c.b2.j
            public i e(n nVar, Object obj, int i, @NullableDecl i iVar) {
                r rVar = (r) nVar;
                return new q(obj, i, (q) iVar);
            }

            @Override // a2.j.d.c.b2.j
            public n f(b2 b2Var, int i, int i2) {
                return new r(b2Var, i, i2);
            }
        }

        public q(K k, int i, @NullableDecl q<K> qVar) {
            super(k, i, qVar);
        }

        @Override // a2.j.d.c.b2.i
        public /* bridge */ /* synthetic */ Object getValue() {
            return MapMaker.a.VALUE;
        }
    }

    public static final class r<K> extends n<K, MapMaker.a, q<K>, r<K>> {
        public r(b2<K, MapMaker.a, q<K>, r<K>> b2Var, int i, int i2) {
            super(b2Var, i, i2);
        }

        @Override // a2.j.d.c.b2.n
        public n n() {
            return this;
        }
    }

    public static final class s<K, V> extends c<K, V, s<K, V>> implements Object<K, V, s<K, V>> {
        @NullableDecl
        public volatile V d = null;

        public static final class a<K, V> implements j<K, V, s<K, V>, t<K, V>> {
            public static final a<?, ?> a = new a<>();

            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // a2.j.d.c.b2.j
            public void a(n nVar, i iVar, Object obj) {
                t tVar = (t) nVar;
                ((s) iVar).d = obj;
            }

            @Override // a2.j.d.c.b2.j
            public p b() {
                return p.STRONG;
            }

            @Override // a2.j.d.c.b2.j
            public i c(n nVar, i iVar, @NullableDecl i iVar2) {
                t tVar = (t) nVar;
                s sVar = (s) iVar;
                s sVar2 = new s(sVar.a, sVar.b, (s) iVar2);
                sVar2.d = sVar.d;
                return sVar2;
            }

            @Override // a2.j.d.c.b2.j
            public p d() {
                return p.STRONG;
            }

            @Override // a2.j.d.c.b2.j
            public i e(n nVar, Object obj, int i, @NullableDecl i iVar) {
                t tVar = (t) nVar;
                return new s(obj, i, (s) iVar);
            }

            @Override // a2.j.d.c.b2.j
            public n f(b2 b2Var, int i, int i2) {
                return new t(b2Var, i, i2);
            }
        }

        public s(K k, int i, @NullableDecl s<K, V> sVar) {
            super(k, i, sVar);
        }

        @Override // a2.j.d.c.b2.i
        @NullableDecl
        public V getValue() {
            return this.d;
        }
    }

    public static final class t<K, V> extends n<K, V, s<K, V>, t<K, V>> {
        public t(b2<K, V, s<K, V>, t<K, V>> b2Var, int i, int i2) {
            super(b2Var, i, i2);
        }

        @Override // a2.j.d.c.b2.n
        public n n() {
            return this;
        }
    }

    public static final class u<K, V> extends c<K, V, u<K, V>> implements e0<K, V, u<K, V>> {
        public volatile f0<K, V, u<K, V>> d = ((f0<K, V, u<K, V>>) b2.j);

        public static final class a<K, V> implements j<K, V, u<K, V>, v<K, V>> {
            public static final a<?, ?> a = new a<>();

            @Override // a2.j.d.c.b2.j
            public void a(n nVar, i iVar, Object obj) {
                u uVar = (u) iVar;
                ReferenceQueue<V> referenceQueue = ((v) nVar).i;
                f0<K, V, u<K, V>> f0Var = uVar.d;
                uVar.d = new g0(referenceQueue, obj, uVar);
                f0Var.clear();
            }

            @Override // a2.j.d.c.b2.j
            public p b() {
                return p.STRONG;
            }

            @Override // a2.j.d.c.b2.j
            public i c(n nVar, i iVar, @NullableDecl i iVar2) {
                v vVar = (v) nVar;
                u uVar = (u) iVar;
                u uVar2 = (u) iVar2;
                int i = n.h;
                if (uVar.getValue() == null) {
                    return null;
                }
                ReferenceQueue<V> referenceQueue = vVar.i;
                u<K, V> uVar3 = new u<>(uVar.a, uVar.b, uVar2);
                uVar3.d = uVar.d.b(referenceQueue, uVar3);
                return uVar3;
            }

            @Override // a2.j.d.c.b2.j
            public p d() {
                return p.WEAK;
            }

            @Override // a2.j.d.c.b2.j
            public i e(n nVar, Object obj, int i, @NullableDecl i iVar) {
                v vVar = (v) nVar;
                return new u(obj, i, (u) iVar);
            }

            @Override // a2.j.d.c.b2.j
            public n f(b2 b2Var, int i, int i2) {
                return new v(b2Var, i, i2);
            }
        }

        public u(K k, int i, @NullableDecl u<K, V> uVar) {
            super(k, i, uVar);
            f0<Object, Object, e> f0Var = b2.j;
        }

        @Override // a2.j.d.c.b2.e0
        public f0<K, V, u<K, V>> a() {
            return this.d;
        }

        @Override // a2.j.d.c.b2.i
        public V getValue() {
            return this.d.get();
        }
    }

    public static final class v<K, V> extends n<K, V, u<K, V>, v<K, V>> {
        public final ReferenceQueue<V> i = new ReferenceQueue<>();

        public v(b2<K, V, u<K, V>, v<K, V>> b2Var, int i2, int i3) {
            super(b2Var, i2, i3);
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.lang.ref.ReferenceQueue<V>, java.lang.ref.ReferenceQueue<T> */
        @Override // a2.j.d.c.b2.n
        public void f() {
            a((ReferenceQueue<V>) this.i);
        }

        @Override // a2.j.d.c.b2.n
        public void h() {
            c(this.i);
        }

        @Override // a2.j.d.c.b2.n
        public n n() {
            return this;
        }
    }

    public final class w extends b2<K, V, E, S>.h {
        public w(b2 b2Var) {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return c().b;
        }
    }

    public final class x extends AbstractCollection<V> {
        public x() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            b2.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return b2.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return b2.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new w(b2.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return b2.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return b2.a(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) b2.a(this).toArray(tArr);
        }
    }

    public static final class y<K> extends d<K, MapMaker.a, y<K>> implements Object<K, MapMaker.a, y<K>> {

        public static final class a<K> implements j<K, MapMaker.a, y<K>, z<K>> {
            public static final a<?> a = new a<>();

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [a2.j.d.c.b2$n, a2.j.d.c.b2$i, java.lang.Object] */
            @Override // a2.j.d.c.b2.j
            public void a(n nVar, i iVar, MapMaker.a aVar) {
                z zVar = (z) nVar;
                y yVar = (y) iVar;
            }

            @Override // a2.j.d.c.b2.j
            public p b() {
                return p.WEAK;
            }

            @Override // a2.j.d.c.b2.j
            public i c(n nVar, i iVar, @NullableDecl i iVar2) {
                z zVar = (z) nVar;
                y yVar = (y) iVar;
                y yVar2 = (y) iVar2;
                if (yVar.get() == null) {
                    return null;
                }
                return new y(zVar.i, yVar.get(), yVar.a, yVar2);
            }

            @Override // a2.j.d.c.b2.j
            public p d() {
                return p.STRONG;
            }

            @Override // a2.j.d.c.b2.j
            public i e(n nVar, Object obj, int i, @NullableDecl i iVar) {
                return new y(((z) nVar).i, obj, i, (y) iVar);
            }

            @Override // a2.j.d.c.b2.j
            public n f(b2 b2Var, int i, int i2) {
                return new z(b2Var, i, i2);
            }
        }

        public y(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl y<K> yVar) {
            super(referenceQueue, k, i, yVar);
        }

        @Override // a2.j.d.c.b2.i
        public /* bridge */ /* synthetic */ Object getValue() {
            return MapMaker.a.VALUE;
        }
    }

    public static final class z<K> extends n<K, MapMaker.a, y<K>, z<K>> {
        public final ReferenceQueue<K> i = new ReferenceQueue<>();

        public z(b2<K, MapMaker.a, y<K>, z<K>> b2Var, int i2, int i3) {
            super(b2Var, i2, i3);
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.lang.ref.ReferenceQueue<K>, java.lang.ref.ReferenceQueue<T> */
        @Override // a2.j.d.c.b2.n
        public void f() {
            a((ReferenceQueue<K>) this.i);
        }

        @Override // a2.j.d.c.b2.n
        public void h() {
            b(this.i);
        }

        @Override // a2.j.d.c.b2.n
        public n n() {
            return this;
        }
    }

    public b2(MapMaker mapMaker, j<K, V, E, S> jVar) {
        int i2 = mapMaker.c;
        this.d = Math.min(i2 == -1 ? 4 : i2, 65536);
        this.e = (Equivalence) MoreObjects.firstNonNull(mapMaker.f, mapMaker.a().a());
        this.f = jVar;
        int i3 = mapMaker.b;
        int min = Math.min(i3 == -1 ? 16 : i3, 1073741824);
        int i4 = 0;
        int i5 = 1;
        int i6 = 1;
        int i7 = 0;
        while (i6 < this.d) {
            i7++;
            i6 <<= 1;
        }
        this.b = 32 - i7;
        this.a = i6 - 1;
        this.c = new n[i6];
        int i8 = min / i6;
        while (i5 < (i6 * i8 < min ? i8 + 1 : i8)) {
            i5 <<= 1;
        }
        while (true) {
            n<K, V, E, S>[] nVarArr = this.c;
            if (i4 < nVarArr.length) {
                nVarArr[i4] = this.f.f(this, i5, -1);
                i4++;
            } else {
                return;
            }
        }
    }

    public static ArrayList a(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterators.addAll(arrayList, collection.iterator());
        return arrayList;
    }

    public int c(Object obj) {
        int hash = this.e.hash(obj);
        int i2 = hash + ((hash << 15) ^ -12931);
        int i3 = i2 ^ (i2 >>> 10);
        int i4 = i3 + (i3 << 3);
        int i5 = i4 ^ (i4 >>> 6);
        int i6 = (i5 << 2) + (i5 << 14) + i5;
        return (i6 >>> 16) ^ i6;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        n<K, V, E, S>[] nVarArr = this.c;
        int length = nVarArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            n<K, V, E, S> nVar = nVarArr[i2];
            if (nVar.b != 0) {
                nVar.lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = nVar.e;
                    for (int i3 = 0; i3 < atomicReferenceArray.length(); i3++) {
                        atomicReferenceArray.set(i3, null);
                    }
                    nVar.f();
                    nVar.g.set(0);
                    nVar.c++;
                    nVar.b = 0;
                } finally {
                    nVar.unlock();
                }
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        E e2;
        boolean z2 = false;
        if (obj == null) {
            return false;
        }
        int c2 = c(obj);
        n<K, V, E, S> d2 = d(c2);
        Objects.requireNonNull(d2);
        try {
            if (!(d2.b == 0 || (e2 = d2.e(obj, c2)) == null || e2.getValue() == null)) {
                z2 = true;
            }
            return z2;
        } finally {
            d2.i();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        Object obj2;
        if (obj == null) {
            return false;
        }
        n<K, V, E, S>[] nVarArr = this.c;
        long j2 = -1;
        int i2 = 0;
        while (i2 < 3) {
            long j3 = 0;
            for (n<K, V, E, S> nVar : nVarArr) {
                int i3 = nVar.b;
                AtomicReferenceArray<E> atomicReferenceArray = nVar.e;
                for (int i4 = 0; i4 < atomicReferenceArray.length(); i4++) {
                    for (E e2 = atomicReferenceArray.get(i4); e2 != null; e2 = e2.b()) {
                        if (e2.getKey() == null) {
                            nVar.p();
                        } else {
                            obj2 = e2.getValue();
                            if (obj2 == null) {
                                nVar.p();
                            }
                            if (obj2 == null && e().equivalent(obj, obj2)) {
                                return true;
                            }
                        }
                        obj2 = null;
                        if (obj2 == null) {
                        }
                    }
                }
                j3 += (long) nVar.c;
            }
            if (j3 == j2) {
                return false;
            }
            i2++;
            j2 = j3;
        }
        return false;
    }

    public n<K, V, E, S> d(int i2) {
        return this.c[(i2 >>> this.b) & this.a];
    }

    @VisibleForTesting
    public Equivalence<Object> e() {
        return this.f.d().a();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.i;
        if (set != null) {
            return set;
        }
        g gVar = new g();
        this.i = gVar;
        return gVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(@NullableDecl Object obj) {
        V v2 = null;
        if (obj == null) {
            return null;
        }
        int c2 = c(obj);
        n<K, V, E, S> d2 = d(c2);
        Objects.requireNonNull(d2);
        try {
            E e2 = d2.e(obj, c2);
            if (e2 != null && (v2 = (V) e2.getValue()) == null) {
                d2.p();
            }
            return v2;
        } finally {
            d2.i();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        n<K, V, E, S>[] nVarArr = this.c;
        long j2 = 0;
        for (int i2 = 0; i2 < nVarArr.length; i2++) {
            if (nVarArr[i2].b != 0) {
                return false;
            }
            j2 += (long) nVarArr[i2].c;
        }
        if (j2 == 0) {
            return true;
        }
        for (int i3 = 0; i3 < nVarArr.length; i3++) {
            if (nVarArr[i3].b != 0) {
                return false;
            }
            j2 -= (long) nVarArr[i3].c;
        }
        if (j2 != 0) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.g;
        if (set != null) {
            return set;
        }
        l lVar = new l();
        this.g = lVar;
        return lVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public V put(K k2, V v2) {
        Preconditions.checkNotNull(k2);
        Preconditions.checkNotNull(v2);
        int c2 = c(k2);
        return d(c2).j(k2, c2, v2, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: a2.j.d.c.b2<K, V, E extends a2.j.d.c.b2$i<K, V, E>, S extends a2.j.d.c.b2$n<K, V, E, S>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V putIfAbsent(K k2, V v2) {
        Preconditions.checkNotNull(k2);
        Preconditions.checkNotNull(v2);
        int c2 = c(k2);
        return d(c2).j(k2, c2, v2, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004a, code lost:
        if ((r7.getValue() == null) != false) goto L_0x004c;
     */
    @Override // java.util.AbstractMap, java.util.Map
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object r11) {
        /*
            r10 = this;
            r0 = 0
            if (r11 != 0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = r10.c(r11)
            a2.j.d.c.b2$n r2 = r10.d(r1)
            r2.lock()
            r2.m()     // Catch:{ all -> 0x006b }
            java.util.concurrent.atomic.AtomicReferenceArray<E extends a2.j.d.c.b2$i<K, V, E>> r3 = r2.e     // Catch:{ all -> 0x006b }
            int r4 = r3.length()     // Catch:{ all -> 0x006b }
            r5 = 1
            int r4 = r4 - r5
            r4 = r4 & r1
            java.lang.Object r6 = r3.get(r4)     // Catch:{ all -> 0x006b }
            a2.j.d.c.b2$i r6 = (a2.j.d.c.b2.i) r6     // Catch:{ all -> 0x006b }
            r7 = r6
        L_0x0022:
            if (r7 == 0) goto L_0x0067
            java.lang.Object r8 = r7.getKey()     // Catch:{ all -> 0x006b }
            int r9 = r7.getHash()     // Catch:{ all -> 0x006b }
            if (r9 != r1) goto L_0x0062
            if (r8 == 0) goto L_0x0062
            a2.j.d.c.b2<K, V, E extends a2.j.d.c.b2$i<K, V, E>, S extends a2.j.d.c.b2$n<K, V, E, S>> r9 = r2.a     // Catch:{ all -> 0x006b }
            com.google.common.base.Equivalence<java.lang.Object> r9 = r9.e     // Catch:{ all -> 0x006b }
            boolean r8 = r9.equivalent(r11, r8)     // Catch:{ all -> 0x006b }
            if (r8 == 0) goto L_0x0062
            java.lang.Object r11 = r7.getValue()     // Catch:{ all -> 0x006b }
            if (r11 == 0) goto L_0x0041
            goto L_0x004c
        L_0x0041:
            java.lang.Object r1 = r7.getValue()     // Catch:{ all -> 0x006b }
            if (r1 != 0) goto L_0x0049
            r1 = 1
            goto L_0x004a
        L_0x0049:
            r1 = 0
        L_0x004a:
            if (r1 == 0) goto L_0x0067
        L_0x004c:
            int r0 = r2.c     // Catch:{ all -> 0x006b }
            int r0 = r0 + r5
            r2.c = r0     // Catch:{ all -> 0x006b }
            a2.j.d.c.b2$i r0 = r2.l(r6, r7)     // Catch:{ all -> 0x006b }
            int r1 = r2.b     // Catch:{ all -> 0x006b }
            int r1 = r1 - r5
            r3.set(r4, r0)     // Catch:{ all -> 0x006b }
            r2.b = r1     // Catch:{ all -> 0x006b }
            r2.unlock()
            r0 = r11
            goto L_0x006a
        L_0x0062:
            a2.j.d.c.b2$i r7 = r7.b()
            goto L_0x0022
        L_0x0067:
            r2.unlock()
        L_0x006a:
            return r0
        L_0x006b:
            r11 = move-exception
            r2.unlock()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.d.c.b2.remove(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean replace(K k2, @NullableDecl V v2, V v3) {
        Preconditions.checkNotNull(k2);
        Preconditions.checkNotNull(v3);
        if (v2 == null) {
            return false;
        }
        int c2 = c(k2);
        n<K, V, E, S> d2 = d(c2);
        d2.lock();
        try {
            d2.m();
            AtomicReferenceArray<E> atomicReferenceArray = d2.e;
            int length = (atomicReferenceArray.length() - 1) & c2;
            E e2 = atomicReferenceArray.get(length);
            E e3 = e2;
            while (true) {
                if (e3 == null) {
                    break;
                }
                Object key = e3.getKey();
                if (e3.getHash() != c2 || key == null || !d2.a.e.equivalent(k2, key)) {
                    e3 = (E) e3.b();
                } else {
                    Object value = e3.getValue();
                    if (value == null) {
                        if (e3.getValue() == null) {
                            d2.c++;
                            atomicReferenceArray.set(length, d2.l(e2, e3));
                            d2.b--;
                        }
                    } else if (d2.a.e().equivalent(v2, value)) {
                        d2.c++;
                        d2.a.f.a(d2.n(), e3, v3);
                        d2.unlock();
                        return true;
                    }
                }
            }
            return false;
        } finally {
            d2.unlock();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        n<K, V, E, S>[] nVarArr;
        long j2 = 0;
        for (n<K, V, E, S> nVar : this.c) {
            j2 += (long) nVar.b;
        }
        return Ints.saturatedCast(j2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.h;
        if (collection != null) {
            return collection;
        }
        x xVar = new x();
        this.h = xVar;
        return xVar;
    }

    public Object writeReplace() {
        return new o(this.f.b(), this.f.d(), this.e, this.f.d().a(), this.d, this);
    }

    public static abstract class b<K, V> extends ForwardingConcurrentMap<K, V> implements Serializable {
        private static final long serialVersionUID = 3;
        public final p a;
        public final p b;
        public final Equivalence<Object> c;
        public final int d;
        public transient ConcurrentMap<K, V> e;

        public b(p pVar, p pVar2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i, ConcurrentMap<K, V> concurrentMap) {
            this.a = pVar;
            this.b = pVar2;
            this.c = equivalence;
            this.d = i;
            this.e = concurrentMap;
        }

        @Override // com.google.common.collect.ForwardingConcurrentMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public ConcurrentMap<K, V> mo147delegate() {
            return this.e;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0058, code lost:
        if ((r7.getValue() == null) != false) goto L_0x005a;
     */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object r11, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object r12) {
        /*
            r10 = this;
            r0 = 0
            if (r11 == 0) goto L_0x007a
            if (r12 != 0) goto L_0x0007
            goto L_0x007a
        L_0x0007:
            int r1 = r10.c(r11)
            a2.j.d.c.b2$n r2 = r10.d(r1)
            r2.lock()
            r2.m()     // Catch:{ all -> 0x0075 }
            java.util.concurrent.atomic.AtomicReferenceArray<E extends a2.j.d.c.b2$i<K, V, E>> r3 = r2.e     // Catch:{ all -> 0x0075 }
            int r4 = r3.length()     // Catch:{ all -> 0x0075 }
            r5 = 1
            int r4 = r4 - r5
            r4 = r4 & r1
            java.lang.Object r6 = r3.get(r4)     // Catch:{ all -> 0x0075 }
            a2.j.d.c.b2$i r6 = (a2.j.d.c.b2.i) r6     // Catch:{ all -> 0x0075 }
            r7 = r6
        L_0x0025:
            if (r7 == 0) goto L_0x0071
            java.lang.Object r8 = r7.getKey()     // Catch:{ all -> 0x0075 }
            int r9 = r7.getHash()     // Catch:{ all -> 0x0075 }
            if (r9 != r1) goto L_0x006c
            if (r8 == 0) goto L_0x006c
            a2.j.d.c.b2<K, V, E extends a2.j.d.c.b2$i<K, V, E>, S extends a2.j.d.c.b2$n<K, V, E, S>> r9 = r2.a     // Catch:{ all -> 0x0075 }
            com.google.common.base.Equivalence<java.lang.Object> r9 = r9.e     // Catch:{ all -> 0x0075 }
            boolean r8 = r9.equivalent(r11, r8)     // Catch:{ all -> 0x0075 }
            if (r8 == 0) goto L_0x006c
            java.lang.Object r11 = r7.getValue()     // Catch:{ all -> 0x0075 }
            a2.j.d.c.b2<K, V, E extends a2.j.d.c.b2$i<K, V, E>, S extends a2.j.d.c.b2$n<K, V, E, S>> r1 = r2.a     // Catch:{ all -> 0x0075 }
            com.google.common.base.Equivalence r1 = r1.e()     // Catch:{ all -> 0x0075 }
            boolean r11 = r1.equivalent(r12, r11)     // Catch:{ all -> 0x0075 }
            if (r11 == 0) goto L_0x004f
            r0 = 1
            goto L_0x005a
        L_0x004f:
            java.lang.Object r11 = r7.getValue()     // Catch:{ all -> 0x0075 }
            if (r11 != 0) goto L_0x0057
            r11 = 1
            goto L_0x0058
        L_0x0057:
            r11 = 0
        L_0x0058:
            if (r11 == 0) goto L_0x0071
        L_0x005a:
            int r11 = r2.c     // Catch:{ all -> 0x0075 }
            int r11 = r11 + r5
            r2.c = r11     // Catch:{ all -> 0x0075 }
            a2.j.d.c.b2$i r11 = r2.l(r6, r7)     // Catch:{ all -> 0x0075 }
            int r12 = r2.b     // Catch:{ all -> 0x0075 }
            int r12 = r12 - r5
            r3.set(r4, r11)     // Catch:{ all -> 0x0075 }
            r2.b = r12     // Catch:{ all -> 0x0075 }
            goto L_0x0071
        L_0x006c:
            a2.j.d.c.b2$i r7 = r7.b()     // Catch:{ all -> 0x0075 }
            goto L_0x0025
        L_0x0071:
            r2.unlock()
            return r0
        L_0x0075:
            r11 = move-exception
            r2.unlock()
            throw r11
        L_0x007a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.d.c.b2.remove(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V replace(K k2, V v2) {
        Preconditions.checkNotNull(k2);
        Preconditions.checkNotNull(v2);
        int c2 = c(k2);
        n<K, V, E, S> d2 = d(c2);
        d2.lock();
        try {
            d2.m();
            AtomicReferenceArray<E> atomicReferenceArray = d2.e;
            int length = (atomicReferenceArray.length() - 1) & c2;
            E e2 = atomicReferenceArray.get(length);
            E e3 = e2;
            while (true) {
                if (e3 == null) {
                    break;
                }
                Object key = e3.getKey();
                if (e3.getHash() != c2 || key == null || !d2.a.e.equivalent(k2, key)) {
                    e3 = (E) e3.b();
                } else {
                    V v3 = (V) e3.getValue();
                    if (v3 == null) {
                        if (e3.getValue() == null) {
                            d2.c++;
                            atomicReferenceArray.set(length, d2.l(e2, e3));
                            d2.b--;
                        }
                    } else {
                        d2.c++;
                        d2.a.f.a(d2.n(), e3, v2);
                        d2.unlock();
                        return v3;
                    }
                }
            }
            return null;
        } finally {
            d2.unlock();
        }
    }
}
