package com.google.common.collect;

import a2.j.d.c.d0;
import a2.j.d.c.e0;
import a2.j.d.c.e1;
import a2.j.d.c.h2;
import a2.j.d.c.w1;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true, serializable = true)
public final class LinkedHashMultimap<K, V> extends w1<K, V> {
    @GwtIncompatible
    private static final long serialVersionUID = 1;
    @VisibleForTesting
    public transient int h = 2;
    public transient b<K, V> i;

    public class a implements Iterator<Map.Entry<K, V>> {
        public b<K, V> a;
        @NullableDecl
        public b<K, V> b;

        public a() {
            this.a = LinkedHashMultimap.this.i.h;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a != LinkedHashMultimap.this.i;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (hasNext()) {
                b<K, V> bVar = this.a;
                this.b = bVar;
                this.a = bVar.h;
                return bVar;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            Preconditions.checkState(this.b != null, "no calls to next() since the last call to remove()");
            LinkedHashMultimap linkedHashMultimap = LinkedHashMultimap.this;
            b<K, V> bVar = this.b;
            linkedHashMultimap.remove(bVar.a, bVar.b);
            this.b = null;
        }
    }

    @VisibleForTesting
    public static final class b<K, V> extends e1<K, V> implements d<K, V> {
        public final int c;
        @NullableDecl
        public b<K, V> d;
        @NullableDecl
        public d<K, V> e;
        @NullableDecl
        public d<K, V> f;
        @NullableDecl
        public b<K, V> g;
        @NullableDecl
        public b<K, V> h;

        public b(@NullableDecl K k, @NullableDecl V v, int i, @NullableDecl b<K, V> bVar) {
            super(k, v);
            this.c = i;
            this.d = bVar;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public void a(d<K, V> dVar) {
            this.f = dVar;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public void b(d<K, V> dVar) {
            this.e = dVar;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public d<K, V> c() {
            return this.f;
        }

        public boolean d(@NullableDecl Object obj, int i) {
            return this.c == i && Objects.equal(this.b, obj);
        }
    }

    @VisibleForTesting
    public final class c extends Sets.k<V> implements d<K, V> {
        public final K a;
        @VisibleForTesting
        public b<K, V>[] b;
        public int c = 0;
        public int d = 0;
        public d<K, V> e;
        public d<K, V> f;

        public class a implements Iterator<V> {
            public d<K, V> a;
            @NullableDecl
            public b<K, V> b;
            public int c;

            public a() {
                this.a = c.this.e;
                this.c = c.this.d;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                c cVar = c.this;
                if (cVar.d == this.c) {
                    return this.a != cVar;
                }
                throw new ConcurrentModificationException();
            }

            @Override // java.util.Iterator
            public V next() {
                if (hasNext()) {
                    b<K, V> bVar = (b) this.a;
                    V v = bVar.b;
                    this.b = bVar;
                    this.a = bVar.f;
                    return v;
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                if (c.this.d == this.c) {
                    Preconditions.checkState(this.b != null, "no calls to next() since the last call to remove()");
                    c.this.remove(this.b.b);
                    this.c = c.this.d;
                    this.b = null;
                    return;
                }
                throw new ConcurrentModificationException();
            }
        }

        public c(K k, int i) {
            this.a = k;
            this.e = this;
            this.f = this;
            this.b = new b[AppCompatDelegateImpl.i.J(i, 1.0d)];
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public void a(d<K, V> dVar) {
            this.e = dVar;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(@NullableDecl V v) {
            int W1 = AppCompatDelegateImpl.i.W1(v);
            int d2 = d() & W1;
            b<K, V> bVar = this.b[d2];
            for (b<K, V> bVar2 = bVar; bVar2 != null; bVar2 = bVar2.d) {
                if (bVar2.d(v, W1)) {
                    return false;
                }
            }
            b<K, V> bVar3 = new b<>(this.a, v, W1, bVar);
            d<K, V> dVar = this.f;
            dVar.a(bVar3);
            bVar3.e = dVar;
            bVar3.f = this;
            this.f = bVar3;
            b<K, V> bVar4 = LinkedHashMultimap.this.i;
            b<K, V> bVar5 = bVar4.g;
            bVar5.h = bVar3;
            bVar3.g = bVar5;
            bVar3.h = bVar4;
            bVar4.g = bVar3;
            b<K, V>[] bVarArr = this.b;
            bVarArr[d2] = bVar3;
            int i = this.c + 1;
            this.c = i;
            this.d++;
            if (AppCompatDelegateImpl.i.l1(i, bVarArr.length, 1.0d)) {
                int length = this.b.length * 2;
                b<K, V>[] bVarArr2 = new b[length];
                this.b = bVarArr2;
                int i2 = length - 1;
                for (d<K, V> dVar2 = this.e; dVar2 != this; dVar2 = dVar2.c()) {
                    b<K, V> bVar6 = (b) dVar2;
                    int i3 = bVar6.c & i2;
                    bVar6.d = bVarArr2[i3];
                    bVarArr2[i3] = bVar6;
                }
            }
            return true;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public void b(d<K, V> dVar) {
            this.f = dVar;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public d<K, V> c() {
            return this.e;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Arrays.fill(this.b, (Object) null);
            this.c = 0;
            for (d<K, V> dVar = this.e; dVar != this; dVar = dVar.c()) {
                b bVar = (b) dVar;
                b<K, V> bVar2 = bVar.g;
                b<K, V> bVar3 = bVar.h;
                bVar2.h = bVar3;
                bVar3.g = bVar2;
            }
            this.e = this;
            this.f = this;
            this.d++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            int W1 = AppCompatDelegateImpl.i.W1(obj);
            for (b<K, V> bVar = this.b[d() & W1]; bVar != null; bVar = bVar.d) {
                if (bVar.d(obj, W1)) {
                    return true;
                }
            }
            return false;
        }

        public final int d() {
            return this.b.length - 1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<V> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        public boolean remove(@NullableDecl Object obj) {
            int W1 = AppCompatDelegateImpl.i.W1(obj);
            int d2 = d() & W1;
            b<K, V> bVar = null;
            for (b<K, V> bVar2 = this.b[d2]; bVar2 != null; bVar2 = bVar2.d) {
                if (bVar2.d(obj, W1)) {
                    if (bVar == null) {
                        this.b[d2] = bVar2.d;
                    } else {
                        bVar.d = bVar2.d;
                    }
                    d<K, V> dVar = bVar2.e;
                    d<K, V> dVar2 = bVar2.f;
                    dVar.a(dVar2);
                    dVar2.b(dVar);
                    b<K, V> bVar3 = bVar2.g;
                    b<K, V> bVar4 = bVar2.h;
                    bVar3.h = bVar4;
                    bVar4.g = bVar3;
                    this.c--;
                    this.d++;
                    return true;
                }
                bVar = bVar2;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.c;
        }
    }

    public interface d<K, V> {
        void a(d<K, V> dVar);

        void b(d<K, V> dVar);

        d<K, V> c();
    }

    public LinkedHashMultimap(int i2, int i3) {
        super(new d0(i2));
        AppCompatDelegateImpl.i.z(i3, "expectedValuesPerKey");
        this.h = i3;
        b<K, V> bVar = new b<>(null, null, 0, null);
        this.i = bVar;
        bVar.h = bVar;
        bVar.g = bVar;
    }

    public static <K, V> LinkedHashMultimap<K, V> create() {
        return new LinkedHashMultimap<>(16, 2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.google.common.collect.LinkedHashMultimap<K, V> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: a2.j.d.c.d0 */
    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        b<K, V> bVar = new b<>(null, null, 0, null);
        this.i = bVar;
        bVar.h = bVar;
        bVar.g = bVar;
        this.h = 2;
        int readInt = objectInputStream.readInt();
        d0 d0Var = new d0(12);
        for (int i2 = 0; i2 < readInt; i2++) {
            Object readObject = objectInputStream.readObject();
            d0Var.put(readObject, o(readObject));
        }
        int readInt2 = objectInputStream.readInt();
        for (int i3 = 0; i3 < readInt2; i3++) {
            Object readObject2 = objectInputStream.readObject();
            ((Collection) d0Var.get(readObject2)).add(objectInputStream.readObject());
        }
        s(d0Var);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(keySet().size());
        for (K k : keySet()) {
            objectOutputStream.writeObject(k);
        }
        objectOutputStream.writeInt(size());
        for (Map.Entry<K, V> entry : entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @Override // a2.j.d.c.l, a2.j.d.c.h, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // a2.j.d.c.e, com.google.common.collect.Multimap
    public void clear() {
        super.clear();
        b<K, V> bVar = this.i;
        bVar.h = bVar;
        bVar.g = bVar;
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsEntry(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // a2.j.d.c.e, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsKey(@NullableDecl Object obj) {
        return super.containsKey(obj);
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsValue(@NullableDecl Object obj) {
        return super.containsValue(obj);
    }

    @Override // a2.j.d.c.l, a2.j.d.c.h, com.google.common.collect.Multimap, java.lang.Object, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.c.l, a2.j.d.c.e, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: get */
    public /* bridge */ /* synthetic */ Set mo118get(@NullableDecl Object obj) {
        return super.mo118get((LinkedHashMultimap<K, V>) obj);
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // a2.j.d.c.e, a2.j.d.c.h
    public Iterator<Map.Entry<K, V>> i() {
        return new a();
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // a2.j.d.c.e, a2.j.d.c.h
    public Iterator<V> j() {
        return new h2(new a());
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public Set<K> keySet() {
        return super.keySet();
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Multiset keys() {
        return super.keys();
    }

    @Override // a2.j.d.c.e
    public Collection n() {
        return new e0(this.h);
    }

    @Override // a2.j.d.c.e
    public Collection<V> o(K k) {
        return new c(k, this.h);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.c.l, a2.j.d.c.e, a2.j.d.c.h, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean put(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.put(obj, obj2);
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(Multimap multimap) {
        return super.putAll(multimap);
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // a2.j.d.c.l, a2.j.d.c.e, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    /* renamed from: removeAll */
    public /* bridge */ /* synthetic */ Set mo119removeAll(@NullableDecl Object obj) {
        return super.mo119removeAll(obj);
    }

    @Override // a2.j.d.c.e, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // a2.j.d.c.h, java.lang.Object
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // a2.j.d.c.e, a2.j.d.c.h, com.google.common.collect.Multimap
    public Collection<V> values() {
        return super.values();
    }

    public static <K, V> LinkedHashMultimap<K, V> create(int i2, int i3) {
        return new LinkedHashMultimap<>(Maps.e(i2), Maps.e(i3));
    }

    @Override // a2.j.d.c.l, a2.j.d.c.e, a2.j.d.c.h, com.google.common.collect.Multimap
    public Set<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(@NullableDecl Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @Override // a2.j.d.c.l, a2.j.d.c.e, a2.j.d.c.h, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    /* renamed from: replaceValues */
    public Set<V> mo120replaceValues(@NullableDecl K k, Iterable<? extends V> iterable) {
        return super.mo120replaceValues((LinkedHashMultimap<K, V>) k, (Iterable) iterable);
    }

    public static <K, V> LinkedHashMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        LinkedHashMultimap<K, V> create = create(multimap.keySet().size(), 2);
        create.putAll(multimap);
        return create;
    }
}
