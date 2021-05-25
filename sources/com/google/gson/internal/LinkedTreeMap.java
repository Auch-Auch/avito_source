package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    public static final Comparator<Comparable> h = new a();
    public Comparator<? super K> a;
    public e<K, V> b;
    public int c;
    public int d;
    public final e<K, V> e;
    public LinkedTreeMap<K, V>.b f;
    public LinkedTreeMap<K, V>.c g;

    public class a implements Comparator<Comparable> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    public class b extends AbstractSet<Map.Entry<K, V>> {

        public class a extends LinkedTreeMap<K, V>.d {
            public a(b bVar) {
                super();
            }

            @Override // java.util.Iterator
            public Object next() {
                return a();
            }
        }

        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedTreeMap.this.c((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e<K, V> c;
            if (!(obj instanceof Map.Entry) || (c = LinkedTreeMap.this.c((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedTreeMap.this.f(c, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.c;
        }
    }

    public final class c extends AbstractSet<K> {

        public class a extends LinkedTreeMap<K, V>.d {
            public a(c cVar) {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().f;
            }
        }

        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            e<K, V> d = linkedTreeMap.d(obj);
            if (d != null) {
                linkedTreeMap.f(d, true);
            }
            if (d != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.c;
        }
    }

    public abstract class d<T> implements Iterator<T> {
        public e<K, V> a;
        public e<K, V> b = null;
        public int c;

        public d() {
            this.a = LinkedTreeMap.this.e.d;
            this.c = LinkedTreeMap.this.d;
        }

        public final e<K, V> a() {
            e<K, V> eVar = this.a;
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            if (eVar == linkedTreeMap.e) {
                throw new NoSuchElementException();
            } else if (linkedTreeMap.d == this.c) {
                this.a = eVar.d;
                this.b = eVar;
                return eVar;
            } else {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.a != LinkedTreeMap.this.e;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.b;
            if (eVar != null) {
                LinkedTreeMap.this.f(eVar, true);
                this.b = null;
                this.c = LinkedTreeMap.this.d;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public LinkedTreeMap() {
        this(h);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    public e<K, V> a(K k, boolean z) {
        int i;
        e<K, V> eVar;
        Comparator<? super K> comparator = this.a;
        e<K, V> eVar2 = this.b;
        if (eVar2 != null) {
            K k2 = comparator == h ? k : null;
            while (true) {
                if (k2 != null) {
                    i = k2.compareTo(eVar2.f);
                } else {
                    i = comparator.compare(k, eVar2.f);
                }
                if (i == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = i < 0 ? eVar2.b : eVar2.c;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            i = 0;
        }
        if (!z) {
            return null;
        }
        e<K, V> eVar4 = this.e;
        if (eVar2 != null) {
            eVar = new e<>(eVar2, k, eVar4, eVar4.e);
            if (i < 0) {
                eVar2.b = eVar;
            } else {
                eVar2.c = eVar;
            }
            e(eVar2, true);
        } else if (comparator != h || (k instanceof Comparable)) {
            eVar = new e<>(eVar2, k, eVar4, eVar4.e);
            this.b = eVar;
        } else {
            throw new ClassCastException(k.getClass().getName() + " is not Comparable");
        }
        this.c++;
        this.d++;
        return eVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        if ((r3 == r5 || (r3 != null && r3.equals(r5))) != false) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.gson.internal.LinkedTreeMap.e<K, V> c(java.util.Map.Entry<?, ?> r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r5.getKey()
            com.google.gson.internal.LinkedTreeMap$e r0 = r4.d(r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0023
            V r3 = r0.g
            java.lang.Object r5 = r5.getValue()
            if (r3 == r5) goto L_0x001f
            if (r3 == 0) goto L_0x001d
            boolean r5 = r3.equals(r5)
            if (r5 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r5 = 0
            goto L_0x0020
        L_0x001f:
            r5 = 1
        L_0x0020:
            if (r5 == 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r1 = 0
        L_0x0024:
            if (r1 == 0) goto L_0x0027
            goto L_0x0028
        L_0x0027:
            r0 = 0
        L_0x0028:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LinkedTreeMap.c(java.util.Map$Entry):com.google.gson.internal.LinkedTreeMap$e");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.b = null;
        this.c = 0;
        this.d++;
        e<K, V> eVar = this.e;
        eVar.e = eVar;
        eVar.d = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return d(obj) != null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public e<K, V> d(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return a(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public final void e(e<K, V> eVar, boolean z) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.b;
            e<K, V> eVar3 = eVar.c;
            int i = 0;
            int i2 = eVar2 != null ? eVar2.h : 0;
            int i3 = eVar3 != null ? eVar3.h : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                e<K, V> eVar4 = eVar3.b;
                e<K, V> eVar5 = eVar3.c;
                int i5 = eVar5 != null ? eVar5.h : 0;
                if (eVar4 != null) {
                    i = eVar4.h;
                }
                int i6 = i - i5;
                if (i6 == -1 || (i6 == 0 && !z)) {
                    i(eVar);
                } else {
                    j(eVar3);
                    i(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 2) {
                e<K, V> eVar6 = eVar2.b;
                e<K, V> eVar7 = eVar2.c;
                int i7 = eVar7 != null ? eVar7.h : 0;
                if (eVar6 != null) {
                    i = eVar6.h;
                }
                int i8 = i - i7;
                if (i8 == 1 || (i8 == 0 && !z)) {
                    j(eVar);
                } else {
                    i(eVar2);
                    j(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 0) {
                eVar.h = i2 + 1;
                if (z) {
                    return;
                }
            } else {
                eVar.h = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            eVar = eVar.a;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedTreeMap<K, V>.b bVar = this.f;
        if (bVar != null) {
            return bVar;
        }
        LinkedTreeMap<K, V>.b bVar2 = new b();
        this.f = bVar2;
        return bVar2;
    }

    public void f(e<K, V> eVar, boolean z) {
        e<K, V> eVar2;
        int i;
        if (z) {
            e<K, V> eVar3 = eVar.e;
            eVar3.d = eVar.d;
            eVar.d.e = eVar3;
        }
        e<K, V> eVar4 = eVar.b;
        e<K, V> eVar5 = eVar.c;
        e<K, V> eVar6 = eVar.a;
        int i2 = 0;
        if (eVar4 == null || eVar5 == null) {
            if (eVar4 != null) {
                h(eVar, eVar4);
                eVar.b = null;
            } else if (eVar5 != null) {
                h(eVar, eVar5);
                eVar.c = null;
            } else {
                h(eVar, null);
            }
            e(eVar6, false);
            this.c--;
            this.d++;
            return;
        }
        if (eVar4.h > eVar5.h) {
            e<K, V> eVar7 = eVar4.c;
            while (true) {
                eVar2 = eVar4;
                eVar4 = eVar7;
                if (eVar4 == null) {
                    break;
                }
                eVar7 = eVar4.c;
            }
        } else {
            e<K, V> eVar8 = eVar5.b;
            while (true) {
                eVar5 = eVar8;
                if (eVar5 == null) {
                    break;
                }
                eVar8 = eVar5.b;
            }
            eVar2 = eVar5;
        }
        f(eVar2, false);
        e<K, V> eVar9 = eVar.b;
        if (eVar9 != null) {
            i = eVar9.h;
            eVar2.b = eVar9;
            eVar9.a = eVar2;
            eVar.b = null;
        } else {
            i = 0;
        }
        e<K, V> eVar10 = eVar.c;
        if (eVar10 != null) {
            i2 = eVar10.h;
            eVar2.c = eVar10;
            eVar10.a = eVar2;
            eVar.c = null;
        }
        eVar2.h = Math.max(i, i2) + 1;
        h(eVar, eVar2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        e<K, V> d2 = d(obj);
        if (d2 != null) {
            return d2.g;
        }
        return null;
    }

    public final void h(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.a;
        eVar.a = null;
        if (eVar2 != null) {
            eVar2.a = eVar3;
        }
        if (eVar3 == null) {
            this.b = eVar2;
        } else if (eVar3.b == eVar) {
            eVar3.b = eVar2;
        } else {
            eVar3.c = eVar2;
        }
    }

    public final void i(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.b;
        e<K, V> eVar3 = eVar.c;
        e<K, V> eVar4 = eVar3.b;
        e<K, V> eVar5 = eVar3.c;
        eVar.c = eVar4;
        if (eVar4 != null) {
            eVar4.a = eVar;
        }
        h(eVar, eVar3);
        eVar3.b = eVar;
        eVar.a = eVar3;
        int i = 0;
        int max = Math.max(eVar2 != null ? eVar2.h : 0, eVar4 != null ? eVar4.h : 0) + 1;
        eVar.h = max;
        if (eVar5 != null) {
            i = eVar5.h;
        }
        eVar3.h = Math.max(max, i) + 1;
    }

    public final void j(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.b;
        e<K, V> eVar3 = eVar.c;
        e<K, V> eVar4 = eVar2.b;
        e<K, V> eVar5 = eVar2.c;
        eVar.b = eVar5;
        if (eVar5 != null) {
            eVar5.a = eVar;
        }
        h(eVar, eVar2);
        eVar2.c = eVar;
        eVar.a = eVar2;
        int i = 0;
        int max = Math.max(eVar3 != null ? eVar3.h : 0, eVar5 != null ? eVar5.h : 0) + 1;
        eVar.h = max;
        if (eVar4 != null) {
            i = eVar4.h;
        }
        eVar2.h = Math.max(max, i) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedTreeMap<K, V>.c cVar = this.g;
        if (cVar != null) {
            return cVar;
        }
        LinkedTreeMap<K, V>.c cVar2 = new c();
        this.g = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        Objects.requireNonNull(k, "key == null");
        e<K, V> a3 = a(k, true);
        V v2 = a3.g;
        a3.g = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> d2 = d(obj);
        if (d2 != null) {
            f(d2, true);
        }
        if (d2 != null) {
            return d2.g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.c;
    }

    public LinkedTreeMap(Comparator<? super K> comparator) {
        this.c = 0;
        this.d = 0;
        this.e = new e<>();
        this.a = comparator == null ? h : comparator;
    }

    public static final class e<K, V> implements Map.Entry<K, V> {
        public e<K, V> a;
        public e<K, V> b;
        public e<K, V> c;
        public e<K, V> d;
        public e<K, V> e;
        public final K f;
        public V g;
        public int h;

        public e() {
            this.f = null;
            this.e = this;
            this.d = this;
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k = this.f;
            if (k == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k.equals(entry.getKey())) {
                return false;
            }
            V v = this.g;
            if (v == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!v.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.g;
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            K k = this.f;
            int i = 0;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.g;
            if (v != null) {
                i = v.hashCode();
            }
            return hashCode ^ i;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.g;
            this.g = v;
            return v2;
        }

        @Override // java.lang.Object
        public String toString() {
            return ((Object) this.f) + "=" + ((Object) this.g);
        }

        public e(e<K, V> eVar, K k, e<K, V> eVar2, e<K, V> eVar3) {
            this.a = eVar;
            this.f = k;
            this.h = 1;
            this.d = eVar2;
            this.e = eVar3;
            eVar3.d = this;
            eVar2.e = this;
        }
    }
}
