package com.google.common.collect;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public final class HashBiMap<K, V> extends AbstractMap<K, V> implements BiMap<K, V>, Serializable {
    public transient K[] a;
    public transient V[] b;
    public transient int c;
    public transient int d;
    public transient int[] e;
    public transient int[] f;
    public transient int[] g;
    public transient int[] h;
    @NullableDecl
    public transient int i;
    @NullableDecl
    public transient int j;
    public transient int[] k;
    public transient int[] l;
    public transient Set<K> m;
    public transient Set<V> n;
    public transient Set<Map.Entry<K, V>> o;
    @RetainedWith
    @MonotonicNonNullDecl
    public transient BiMap<V, K> p;

    public final class a extends a2.j.d.c.g<K, V> {
        @NullableDecl
        public final K a;
        public int b;

        public a(int i) {
            this.a = HashBiMap.this.a[i];
            this.b = i;
        }

        public void d() {
            int i = this.b;
            if (i != -1) {
                HashBiMap hashBiMap = HashBiMap.this;
                if (i <= hashBiMap.c && Objects.equal(hashBiMap.a[i], this.a)) {
                    return;
                }
            }
            this.b = HashBiMap.this.j(this.a);
        }

        @Override // a2.j.d.c.g, java.util.Map.Entry
        public K getKey() {
            return this.a;
        }

        @Override // a2.j.d.c.g, java.util.Map.Entry
        @NullableDecl
        public V getValue() {
            d();
            int i = this.b;
            if (i == -1) {
                return null;
            }
            return HashBiMap.this.b[i];
        }

        @Override // a2.j.d.c.g, java.util.Map.Entry
        public V setValue(V v) {
            d();
            int i = this.b;
            if (i == -1) {
                return (V) HashBiMap.this.put(this.a, v);
            }
            V v2 = HashBiMap.this.b[i];
            if (Objects.equal(v2, v)) {
                return v;
            }
            HashBiMap.this.x(this.b, v, false);
            return v2;
        }
    }

    public static final class b<K, V> extends a2.j.d.c.g<V, K> {
        public final HashBiMap<K, V> a;
        public final V b;
        public int c;

        public b(HashBiMap<K, V> hashBiMap, int i) {
            this.a = hashBiMap;
            this.b = hashBiMap.b[i];
            this.c = i;
        }

        public final void d() {
            int i = this.c;
            if (i != -1) {
                HashBiMap<K, V> hashBiMap = this.a;
                if (i <= hashBiMap.c && Objects.equal(this.b, hashBiMap.b[i])) {
                    return;
                }
            }
            this.c = this.a.m(this.b);
        }

        @Override // a2.j.d.c.g, java.util.Map.Entry
        public V getKey() {
            return this.b;
        }

        @Override // a2.j.d.c.g, java.util.Map.Entry
        public K getValue() {
            d();
            int i = this.c;
            if (i == -1) {
                return null;
            }
            return this.a.a[i];
        }

        @Override // a2.j.d.c.g, java.util.Map.Entry
        public K setValue(K k) {
            d();
            int i = this.c;
            if (i == -1) {
                return this.a.s(this.b, k, false);
            }
            K k2 = this.a.a[i];
            if (Objects.equal(k2, k)) {
                return k;
            }
            this.a.w(this.c, k, false);
            return k2;
        }
    }

    public final class c extends h<K, V, Map.Entry<K, V>> {
        public c() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.h
        public Object a(int i) {
            return new a(i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int j = HashBiMap.this.j(key);
            if (j == -1 || !Objects.equal(value, HashBiMap.this.b[j])) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        public boolean remove(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int W1 = AppCompatDelegateImpl.i.W1(key);
            int l = HashBiMap.this.l(key, W1);
            if (l == -1 || !Objects.equal(value, HashBiMap.this.b[l])) {
                return false;
            }
            HashBiMap.this.u(l, W1);
            return true;
        }
    }

    public static class d<K, V> extends AbstractMap<V, K> implements BiMap<V, K>, Serializable {
        public final HashBiMap<K, V> a;
        public transient Set<Map.Entry<V, K>> b;

        public d(HashBiMap<K, V> hashBiMap) {
            this.a = hashBiMap;
        }

        @GwtIncompatible("serialization")
        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.a.p = this;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.a.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@NullableDecl Object obj) {
            return this.a.containsValue(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(@NullableDecl Object obj) {
            return this.a.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<V, K>> entrySet() {
            Set<Map.Entry<V, K>> set = this.b;
            if (set != null) {
                return set;
            }
            e eVar = new e(this.a);
            this.b = eVar;
            return eVar;
        }

        @Override // com.google.common.collect.BiMap
        @CanIgnoreReturnValue
        @NullableDecl
        public K forcePut(@NullableDecl V v, @NullableDecl K k) {
            return this.a.s(v, k, true);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @NullableDecl
        public K get(@NullableDecl Object obj) {
            HashBiMap<K, V> hashBiMap = this.a;
            int m = hashBiMap.m(obj);
            if (m == -1) {
                return null;
            }
            return hashBiMap.a[m];
        }

        @Override // com.google.common.collect.BiMap
        /* renamed from: inverse */
        public BiMap<K, V> mo35inverse() {
            return this.a;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<V> keySet() {
            return this.a.values();
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
        @CanIgnoreReturnValue
        @NullableDecl
        public K put(@NullableDecl V v, @NullableDecl K k) {
            return this.a.s(v, k, false);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CanIgnoreReturnValue
        @NullableDecl
        public K remove(@NullableDecl Object obj) {
            HashBiMap<K, V> hashBiMap = this.a;
            java.util.Objects.requireNonNull(hashBiMap);
            int W1 = AppCompatDelegateImpl.i.W1(obj);
            int n = hashBiMap.n(obj, W1);
            if (n == -1) {
                return null;
            }
            K k = hashBiMap.a[n];
            hashBiMap.v(n, W1);
            return k;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.a.c;
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
        public Set<K> values() {
            return this.a.keySet();
        }
    }

    public static class e<K, V> extends h<K, V, Map.Entry<V, K>> {
        public e(HashBiMap<K, V> hashBiMap) {
            super(hashBiMap);
        }

        @Override // com.google.common.collect.HashBiMap.h
        public Object a(int i) {
            return new b(this.a, i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int m = this.a.m(key);
            if (m == -1 || !Objects.equal(this.a.a[m], value)) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int W1 = AppCompatDelegateImpl.i.W1(key);
            int n = this.a.n(key, W1);
            if (n == -1 || !Objects.equal(this.a.a[n], value)) {
                return false;
            }
            this.a.v(n, W1);
            return true;
        }
    }

    public final class f extends h<K, V, K> {
        public f() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.h
        public K a(int i) {
            return HashBiMap.this.a[i];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            return HashBiMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object obj) {
            int W1 = AppCompatDelegateImpl.i.W1(obj);
            int l = HashBiMap.this.l(obj, W1);
            if (l == -1) {
                return false;
            }
            HashBiMap.this.u(l, W1);
            return true;
        }
    }

    public final class g extends h<K, V, V> {
        public g() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.h
        public V a(int i) {
            return HashBiMap.this.b[i];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            return HashBiMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object obj) {
            int W1 = AppCompatDelegateImpl.i.W1(obj);
            int n = HashBiMap.this.n(obj, W1);
            if (n == -1) {
                return false;
            }
            HashBiMap.this.v(n, W1);
            return true;
        }
    }

    public static abstract class h<K, V, T> extends AbstractSet<T> {
        public final HashBiMap<K, V> a;

        public class a implements Iterator<T> {
            public int a;
            public int b = -1;
            public int c;
            public int d;

            public a() {
                HashBiMap<K, V> hashBiMap = h.this.a;
                this.a = hashBiMap.i;
                this.c = hashBiMap.d;
                this.d = hashBiMap.c;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (h.this.a.d == this.c) {
                    return this.a != -2 && this.d > 0;
                }
                throw new ConcurrentModificationException();
            }

            @Override // java.util.Iterator
            public T next() {
                if (hasNext()) {
                    T t = (T) h.this.a(this.a);
                    int i = this.a;
                    this.b = i;
                    this.a = h.this.a.l[i];
                    this.d--;
                    return t;
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                if (h.this.a.d == this.c) {
                    Preconditions.checkState(this.b != -1, "no calls to next() since the last call to remove()");
                    HashBiMap<K, V> hashBiMap = h.this.a;
                    int i = this.b;
                    hashBiMap.t(i, AppCompatDelegateImpl.i.W1(hashBiMap.a[i]), AppCompatDelegateImpl.i.W1(hashBiMap.b[i]));
                    int i2 = this.a;
                    HashBiMap<K, V> hashBiMap2 = h.this.a;
                    if (i2 == hashBiMap2.c) {
                        this.a = this.b;
                    }
                    this.b = -1;
                    this.c = hashBiMap2.d;
                    return;
                }
                throw new ConcurrentModificationException();
            }
        }

        public h(HashBiMap<K, V> hashBiMap) {
            this.a = hashBiMap;
        }

        public abstract T a(int i);

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<T> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.a.c;
        }
    }

    public HashBiMap(int i2) {
        o(i2);
    }

    public static int[] c(int i2) {
        int[] iArr = new int[i2];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    public static <K, V> HashBiMap<K, V> create() {
        return create(16);
    }

    public static int[] h(int[] iArr, int i2) {
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, i2);
        Arrays.fill(copyOf, length, i2, -1);
        return copyOf;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.HashBiMap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        o(16);
        for (int i2 = 0; i2 < readInt; i2++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        AppCompatDelegateImpl.i.p2(this, objectOutputStream);
    }

    public final int a(int i2) {
        return i2 & (this.e.length - 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.a, 0, this.c, (Object) null);
        Arrays.fill(this.b, 0, this.c, (Object) null);
        Arrays.fill(this.e, -1);
        Arrays.fill(this.f, -1);
        Arrays.fill(this.g, 0, this.c, -1);
        Arrays.fill(this.h, 0, this.c, -1);
        Arrays.fill(this.k, 0, this.c, -1);
        Arrays.fill(this.l, 0, this.c, -1);
        this.c = 0;
        this.i = -2;
        this.j = -2;
        this.d++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return j(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        return m(obj) != -1;
    }

    public final void d(int i2, int i3) {
        Preconditions.checkArgument(i2 != -1);
        int[] iArr = this.e;
        int length = i3 & (iArr.length - 1);
        if (iArr[length] == i2) {
            int[] iArr2 = this.g;
            iArr[length] = iArr2[i2];
            iArr2[i2] = -1;
            return;
        }
        int i4 = iArr[length];
        int i5 = this.g[i4];
        while (true) {
            i4 = i5;
            if (i4 == -1) {
                StringBuilder L = a2.b.a.a.a.L("Expected to find entry with key ");
                L.append((Object) this.a[i2]);
                throw new AssertionError(L.toString());
            } else if (i4 == i2) {
                int[] iArr3 = this.g;
                iArr3[i4] = iArr3[i2];
                iArr3[i2] = -1;
                return;
            } else {
                i5 = this.g[i4];
            }
        }
    }

    public final void e(int i2, int i3) {
        Preconditions.checkArgument(i2 != -1);
        int length = i3 & (this.e.length - 1);
        int[] iArr = this.f;
        if (iArr[length] == i2) {
            int[] iArr2 = this.h;
            iArr[length] = iArr2[i2];
            iArr2[i2] = -1;
            return;
        }
        int i4 = iArr[length];
        int i5 = this.h[i4];
        while (true) {
            i4 = i5;
            if (i4 == -1) {
                StringBuilder L = a2.b.a.a.a.L("Expected to find entry with value ");
                L.append((Object) this.b[i2]);
                throw new AssertionError(L.toString());
            } else if (i4 == i2) {
                int[] iArr3 = this.h;
                iArr3[i4] = iArr3[i2];
                iArr3[i2] = -1;
                return;
            } else {
                i5 = this.h[i4];
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.o;
        if (set != null) {
            return set;
        }
        c cVar = new c();
        this.o = cVar;
        return cVar;
    }

    public final void f(int i2) {
        int[] iArr = this.g;
        if (iArr.length < i2) {
            int a3 = ImmutableCollection.Builder.a(iArr.length, i2);
            this.a = (K[]) Arrays.copyOf(this.a, a3);
            this.b = (V[]) Arrays.copyOf(this.b, a3);
            this.g = h(this.g, a3);
            this.h = h(this.h, a3);
            this.k = h(this.k, a3);
            this.l = h(this.l, a3);
        }
        if (this.e.length < i2) {
            int J = AppCompatDelegateImpl.i.J(i2, 1.0d);
            this.e = c(J);
            this.f = c(J);
            for (int i3 = 0; i3 < this.c; i3++) {
                int a4 = a(AppCompatDelegateImpl.i.W1(this.a[i3]));
                int[] iArr2 = this.g;
                int[] iArr3 = this.e;
                iArr2[i3] = iArr3[a4];
                iArr3[a4] = i3;
                int a5 = a(AppCompatDelegateImpl.i.W1(this.b[i3]));
                int[] iArr4 = this.h;
                int[] iArr5 = this.f;
                iArr4[i3] = iArr5[a5];
                iArr5[a5] = i3;
            }
        }
    }

    @Override // com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    @NullableDecl
    public V forcePut(@NullableDecl K k2, @NullableDecl V v) {
        return r(k2, v, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public V get(@NullableDecl Object obj) {
        int j2 = j(obj);
        if (j2 == -1) {
            return null;
        }
        return this.b[j2];
    }

    public int i(@NullableDecl Object obj, int i2, int[] iArr, int[] iArr2, Object[] objArr) {
        int i3 = iArr[i2 & (this.e.length - 1)];
        while (i3 != -1) {
            if (Objects.equal(objArr[i3], obj)) {
                return i3;
            }
            i3 = iArr2[i3];
        }
        return -1;
    }

    @Override // com.google.common.collect.BiMap
    /* renamed from: inverse */
    public BiMap<V, K> mo35inverse() {
        BiMap<V, K> biMap = this.p;
        if (biMap != null) {
            return biMap;
        }
        d dVar = new d(this);
        this.p = dVar;
        return dVar;
    }

    public int j(@NullableDecl Object obj) {
        return l(obj, AppCompatDelegateImpl.i.W1(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.m;
        if (set != null) {
            return set;
        }
        f fVar = new f();
        this.m = fVar;
        return fVar;
    }

    public int l(@NullableDecl Object obj, int i2) {
        return i(obj, i2, this.e, this.g, this.a);
    }

    public int m(@NullableDecl Object obj) {
        return n(obj, AppCompatDelegateImpl.i.W1(obj));
    }

    public int n(@NullableDecl Object obj, int i2) {
        return i(obj, i2, this.f, this.h, this.b);
    }

    public void o(int i2) {
        AppCompatDelegateImpl.i.z(i2, "expectedSize");
        int J = AppCompatDelegateImpl.i.J(i2, 1.0d);
        this.c = 0;
        this.a = (K[]) new Object[i2];
        this.b = (V[]) new Object[i2];
        this.e = c(J);
        this.f = c(J);
        this.g = c(i2);
        this.h = c(i2);
        this.i = -2;
        this.j = -2;
        this.k = c(i2);
        this.l = c(i2);
    }

    public final void p(int i2, int i3) {
        Preconditions.checkArgument(i2 != -1);
        int[] iArr = this.e;
        int length = i3 & (iArr.length - 1);
        this.g[i2] = iArr[length];
        iArr[length] = i2;
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    public V put(@NullableDecl K k2, @NullableDecl V v) {
        return r(k2, v, false);
    }

    public final void q(int i2, int i3) {
        Preconditions.checkArgument(i2 != -1);
        int length = i3 & (this.e.length - 1);
        int[] iArr = this.h;
        int[] iArr2 = this.f;
        iArr[i2] = iArr2[length];
        iArr2[length] = i2;
    }

    @NullableDecl
    public V r(@NullableDecl K k2, @NullableDecl V v, boolean z) {
        int W1 = AppCompatDelegateImpl.i.W1(k2);
        int l2 = l(k2, W1);
        if (l2 != -1) {
            V v2 = this.b[l2];
            if (Objects.equal(v2, v)) {
                return v;
            }
            x(l2, v, z);
            return v2;
        }
        int W12 = AppCompatDelegateImpl.i.W1(v);
        int n2 = n(v, W12);
        if (!z) {
            Preconditions.checkArgument(n2 == -1, "Value already present: %s", v);
        } else if (n2 != -1) {
            v(n2, W12);
        }
        f(this.c + 1);
        K[] kArr = this.a;
        int i2 = this.c;
        kArr[i2] = k2;
        this.b[i2] = v;
        p(i2, W1);
        q(this.c, W12);
        y(this.j, this.c);
        y(this.c, -2);
        this.c++;
        this.d++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @NullableDecl
    public V remove(@NullableDecl Object obj) {
        int W1 = AppCompatDelegateImpl.i.W1(obj);
        int l2 = l(obj, W1);
        if (l2 == -1) {
            return null;
        }
        V v = this.b[l2];
        u(l2, W1);
        return v;
    }

    @NullableDecl
    public K s(@NullableDecl V v, @NullableDecl K k2, boolean z) {
        int W1 = AppCompatDelegateImpl.i.W1(v);
        int n2 = n(v, W1);
        if (n2 != -1) {
            K k3 = this.a[n2];
            if (Objects.equal(k3, k2)) {
                return k2;
            }
            w(n2, k2, z);
            return k3;
        }
        int i2 = this.j;
        int W12 = AppCompatDelegateImpl.i.W1(k2);
        int l2 = l(k2, W12);
        if (!z) {
            Preconditions.checkArgument(l2 == -1, "Key already present: %s", k2);
        } else if (l2 != -1) {
            i2 = this.k[l2];
            u(l2, W12);
        }
        f(this.c + 1);
        K[] kArr = this.a;
        int i3 = this.c;
        kArr[i3] = k2;
        this.b[i3] = v;
        p(i3, W12);
        q(this.c, W1);
        int i4 = i2 == -2 ? this.i : this.l[i2];
        y(i2, this.c);
        y(this.c, i4);
        this.c++;
        this.d++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.c;
    }

    public final void t(int i2, int i3, int i4) {
        Preconditions.checkArgument(i2 != -1);
        d(i2, i3);
        e(i2, i4);
        y(this.k[i2], this.l[i2]);
        int i5 = this.c - 1;
        if (i5 != i2) {
            int i6 = this.k[i5];
            int i7 = this.l[i5];
            y(i6, i2);
            y(i2, i7);
            K[] kArr = this.a;
            K k2 = kArr[i5];
            V[] vArr = this.b;
            V v = vArr[i5];
            kArr[i2] = k2;
            vArr[i2] = v;
            int a3 = a(AppCompatDelegateImpl.i.W1(k2));
            int[] iArr = this.e;
            if (iArr[a3] == i5) {
                iArr[a3] = i2;
            } else {
                int i8 = iArr[a3];
                int i9 = this.g[i8];
                while (true) {
                    i8 = i9;
                    if (i8 == i5) {
                        break;
                    }
                    i9 = this.g[i8];
                }
                this.g[i8] = i2;
            }
            int[] iArr2 = this.g;
            iArr2[i2] = iArr2[i5];
            iArr2[i5] = -1;
            int a4 = a(AppCompatDelegateImpl.i.W1(v));
            int[] iArr3 = this.f;
            if (iArr3[a4] == i5) {
                iArr3[a4] = i2;
            } else {
                int i10 = iArr3[a4];
                int i11 = this.h[i10];
                while (true) {
                    i10 = i11;
                    if (i10 == i5) {
                        break;
                    }
                    i11 = this.h[i10];
                }
                this.h[i10] = i2;
            }
            int[] iArr4 = this.h;
            iArr4[i2] = iArr4[i5];
            iArr4[i5] = -1;
        }
        K[] kArr2 = this.a;
        int i12 = this.c;
        kArr2[i12 - 1] = null;
        this.b[i12 - 1] = null;
        this.c = i12 - 1;
        this.d++;
    }

    public void u(int i2, int i3) {
        t(i2, i3, AppCompatDelegateImpl.i.W1(this.b[i2]));
    }

    public void v(int i2, int i3) {
        t(i2, AppCompatDelegateImpl.i.W1(this.a[i2]), i3);
    }

    public final void w(int i2, @NullableDecl K k2, boolean z) {
        Preconditions.checkArgument(i2 != -1);
        int W1 = AppCompatDelegateImpl.i.W1(k2);
        int l2 = l(k2, W1);
        int i3 = this.j;
        int i4 = -2;
        if (l2 != -1) {
            if (z) {
                i3 = this.k[l2];
                i4 = this.l[l2];
                u(l2, W1);
                if (i2 == this.c) {
                    i2 = l2;
                }
            } else {
                throw new IllegalArgumentException(a2.b.a.a.a.b3("Key already present in map: ", k2));
            }
        }
        if (i3 == i2) {
            i3 = this.k[i2];
        } else if (i3 == this.c) {
            i3 = l2;
        }
        if (i4 == i2) {
            l2 = this.l[i2];
        } else if (i4 != this.c) {
            l2 = i4;
        }
        y(this.k[i2], this.l[i2]);
        d(i2, AppCompatDelegateImpl.i.W1(this.a[i2]));
        this.a[i2] = k2;
        p(i2, AppCompatDelegateImpl.i.W1(k2));
        y(i3, i2);
        y(i2, l2);
    }

    public final void x(int i2, @NullableDecl V v, boolean z) {
        Preconditions.checkArgument(i2 != -1);
        int W1 = AppCompatDelegateImpl.i.W1(v);
        int n2 = n(v, W1);
        if (n2 != -1) {
            if (z) {
                v(n2, W1);
                if (i2 == this.c) {
                    i2 = n2;
                }
            } else {
                throw new IllegalArgumentException(a2.b.a.a.a.b3("Value already present in map: ", v));
            }
        }
        e(i2, AppCompatDelegateImpl.i.W1(this.b[i2]));
        this.b[i2] = v;
        q(i2, W1);
    }

    public final void y(int i2, int i3) {
        if (i2 == -2) {
            this.i = i3;
        } else {
            this.l[i2] = i3;
        }
        if (i3 == -2) {
            this.j = i2;
        } else {
            this.k[i3] = i2;
        }
    }

    public static <K, V> HashBiMap<K, V> create(int i2) {
        return new HashBiMap<>(i2);
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
    public Set<V> values() {
        Set<V> set = this.n;
        if (set != null) {
            return set;
        }
        g gVar = new g();
        this.n = gVar;
        return gVar;
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> map) {
        HashBiMap<K, V> create = create(map.size());
        create.putAll(map);
        return create;
    }
}
