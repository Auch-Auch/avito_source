package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
public final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    public static final Comparator<Comparable> i = new a();
    public Comparator<? super K> a;
    public f<K, V>[] b;
    public final f<K, V> c;
    public int d;
    public int e;
    public int f;
    public LinkedHashTreeMap<K, V>.c g;
    public LinkedHashTreeMap<K, V>.d h;

    public class a implements Comparator<Comparable> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    public static final class b<K, V> {
        public f<K, V> a;
        public int b;
        public int c;
        public int d;

        public void a(f<K, V> fVar) {
            fVar.c = null;
            fVar.a = null;
            fVar.b = null;
            fVar.i = 1;
            int i = this.b;
            if (i > 0) {
                int i2 = this.d;
                if ((i2 & 1) == 0) {
                    this.d = i2 + 1;
                    this.b = i - 1;
                    this.c++;
                }
            }
            fVar.a = this.a;
            this.a = fVar;
            int i3 = this.d + 1;
            this.d = i3;
            int i4 = this.b;
            if (i4 > 0 && (i3 & 1) == 0) {
                this.d = i3 + 1;
                this.b = i4 - 1;
                this.c++;
            }
            int i5 = 4;
            while (true) {
                int i6 = i5 - 1;
                if ((this.d & i6) == i6) {
                    int i7 = this.c;
                    if (i7 == 0) {
                        f<K, V> fVar2 = this.a;
                        f<K, V> fVar3 = fVar2.a;
                        f<K, V> fVar4 = fVar3.a;
                        fVar3.a = fVar4.a;
                        this.a = fVar3;
                        fVar3.b = fVar4;
                        fVar3.c = fVar2;
                        fVar3.i = fVar2.i + 1;
                        fVar4.a = fVar3;
                        fVar2.a = fVar3;
                    } else if (i7 == 1) {
                        f<K, V> fVar5 = this.a;
                        f<K, V> fVar6 = fVar5.a;
                        this.a = fVar6;
                        fVar6.c = fVar5;
                        fVar6.i = fVar5.i + 1;
                        fVar5.a = fVar6;
                        this.c = 0;
                    } else if (i7 == 2) {
                        this.c = 0;
                    }
                    i5 *= 2;
                } else {
                    return;
                }
            }
        }

        public void b(int i) {
            this.b = ((Integer.highestOneBit(i) * 2) - 1) - i;
            this.d = 0;
            this.c = 0;
            this.a = null;
        }
    }

    public final class c extends AbstractSet<Map.Entry<K, V>> {

        public class a extends LinkedHashTreeMap<K, V>.e {
            public a(c cVar) {
                super();
            }

            @Override // java.util.Iterator
            public Object next() {
                return a();
            }
        }

        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedHashTreeMap.this.c((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            f<K, V> c;
            if (!(obj instanceof Map.Entry) || (c = LinkedHashTreeMap.this.c((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedHashTreeMap.this.f(c, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedHashTreeMap.this.d;
        }
    }

    public final class d extends AbstractSet<K> {

        public class a extends LinkedHashTreeMap<K, V>.e {
            public a(d dVar) {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().f;
            }
        }

        public d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedHashTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
            f<K, V> d = linkedHashTreeMap.d(obj);
            if (d != null) {
                linkedHashTreeMap.f(d, true);
            }
            if (d != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedHashTreeMap.this.d;
        }
    }

    public abstract class e<T> implements Iterator<T> {
        public f<K, V> a;
        public f<K, V> b = null;
        public int c;

        public e() {
            this.a = LinkedHashTreeMap.this.c.d;
            this.c = LinkedHashTreeMap.this.e;
        }

        public final f<K, V> a() {
            f<K, V> fVar = this.a;
            LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
            if (fVar == linkedHashTreeMap.c) {
                throw new NoSuchElementException();
            } else if (linkedHashTreeMap.e == this.c) {
                this.a = fVar.d;
                this.b = fVar;
                return fVar;
            } else {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.a != LinkedHashTreeMap.this.c;
        }

        @Override // java.util.Iterator
        public final void remove() {
            f<K, V> fVar = this.b;
            if (fVar != null) {
                LinkedHashTreeMap.this.f(fVar, true);
                this.b = null;
                this.c = LinkedHashTreeMap.this.e;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public LinkedHashTreeMap() {
        this(i);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    public f<K, V> a(K k, boolean z) {
        int i2;
        f<K, V> fVar;
        f<K, V> fVar2;
        f<K, V> fVar3;
        f<K, V> fVar4;
        f<K, V> fVar5;
        f<K, V> fVar6;
        int i3;
        Comparator<? super K> comparator = this.a;
        f<K, V>[] fVarArr = this.b;
        int hashCode = k.hashCode();
        int i4 = hashCode ^ ((hashCode >>> 20) ^ (hashCode >>> 12));
        int i5 = ((i4 >>> 7) ^ i4) ^ (i4 >>> 4);
        int length = i5 & (fVarArr.length - 1);
        f<K, V> fVar7 = fVarArr[length];
        if (fVar7 != null) {
            K k2 = comparator == i ? k : null;
            while (true) {
                if (k2 != null) {
                    i3 = k2.compareTo(fVar7.f);
                } else {
                    i3 = comparator.compare(k, fVar7.f);
                }
                if (i3 == 0) {
                    return fVar7;
                }
                f<K, V> fVar8 = i3 < 0 ? fVar7.b : fVar7.c;
                if (fVar8 == null) {
                    fVar = fVar7;
                    i2 = i3;
                    break;
                }
                fVar7 = fVar8;
            }
        } else {
            fVar = fVar7;
            i2 = 0;
        }
        if (!z) {
            return null;
        }
        f<K, V> fVar9 = this.c;
        if (fVar != null) {
            f<K, V> fVar10 = new f<>(fVar, k, i5, fVar9, fVar9.e);
            if (i2 < 0) {
                fVar.b = fVar10;
            } else {
                fVar.c = fVar10;
            }
            e(fVar, true);
            fVar2 = fVar10;
        } else if (comparator != i || (k instanceof Comparable)) {
            fVar2 = new f<>(fVar, k, i5, fVar9, fVar9.e);
            fVarArr[length] = fVar2;
        } else {
            throw new ClassCastException(k.getClass().getName() + " is not Comparable");
        }
        int i6 = this.d;
        this.d = i6 + 1;
        if (i6 > this.f) {
            f<K, V>[] fVarArr2 = this.b;
            int length2 = fVarArr2.length;
            int i7 = length2 * 2;
            f<K, V>[] fVarArr3 = new f[i7];
            b bVar = new b();
            b bVar2 = new b();
            for (int i8 = 0; i8 < length2; i8++) {
                f<K, V> fVar11 = fVarArr2[i8];
                if (fVar11 != null) {
                    f<K, V> fVar12 = null;
                    for (f<K, V> fVar13 = fVar11; fVar13 != null; fVar13 = fVar13.b) {
                        fVar13.a = fVar12;
                        fVar12 = fVar13;
                    }
                    int i9 = 0;
                    int i10 = 0;
                    while (true) {
                        if (fVar12 == null) {
                            fVar3 = fVar12;
                            fVar12 = null;
                        } else {
                            fVar3 = fVar12.a;
                            fVar12.a = null;
                            for (f<K, V> fVar14 = fVar12.c; fVar14 != null; fVar14 = fVar14.b) {
                                fVar14.a = fVar3;
                                fVar3 = fVar14;
                            }
                        }
                        if (fVar12 == null) {
                            break;
                        }
                        if ((fVar12.g & length2) == 0) {
                            i9++;
                        } else {
                            i10++;
                        }
                        fVar12 = fVar3;
                    }
                    bVar.b(i9);
                    bVar2.b(i10);
                    f<K, V> fVar15 = null;
                    while (fVar11 != null) {
                        fVar11.a = fVar15;
                        fVar11 = fVar11.b;
                        fVar15 = fVar11;
                    }
                    while (true) {
                        if (fVar15 != null) {
                            f<K, V> fVar16 = fVar15.a;
                            fVar15.a = null;
                            f<K, V> fVar17 = fVar15.c;
                            while (true) {
                                fVar4 = fVar16;
                                fVar16 = fVar17;
                                if (fVar16 == null) {
                                    break;
                                }
                                fVar16.a = fVar4;
                                fVar17 = fVar16.b;
                            }
                        } else {
                            fVar4 = fVar15;
                            fVar15 = null;
                        }
                        if (fVar15 == null) {
                            break;
                        }
                        if ((fVar15.g & length2) == 0) {
                            bVar.a(fVar15);
                        } else {
                            bVar2.a(fVar15);
                        }
                        fVar15 = fVar4;
                    }
                    if (i9 > 0) {
                        fVar5 = bVar.a;
                        if (fVar5.a != null) {
                            throw new IllegalStateException();
                        }
                    } else {
                        fVar5 = null;
                    }
                    fVarArr3[i8] = fVar5;
                    int i11 = i8 + length2;
                    if (i10 > 0) {
                        fVar6 = bVar2.a;
                        if (fVar6.a != null) {
                            throw new IllegalStateException();
                        }
                    } else {
                        fVar6 = null;
                    }
                    fVarArr3[i11] = fVar6;
                }
            }
            this.b = fVarArr3;
            this.f = (i7 / 4) + (i7 / 2);
        }
        this.e++;
        return fVar2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        if ((r3 == r5 || (r3 != null && r3.equals(r5))) != false) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.gson.internal.LinkedHashTreeMap.f<K, V> c(java.util.Map.Entry<?, ?> r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r5.getKey()
            com.google.gson.internal.LinkedHashTreeMap$f r0 = r4.d(r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0023
            V r3 = r0.h
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LinkedHashTreeMap.c(java.util.Map$Entry):com.google.gson.internal.LinkedHashTreeMap$f");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.b, (Object) null);
        this.d = 0;
        this.e++;
        f<K, V> fVar = this.c;
        f<K, V> fVar2 = fVar.d;
        while (fVar2 != fVar) {
            f<K, V> fVar3 = fVar2.d;
            fVar2.e = null;
            fVar2.d = null;
            fVar2 = fVar3;
        }
        fVar.e = fVar;
        fVar.d = fVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return d(obj) != null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public f<K, V> d(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return a(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public final void e(f<K, V> fVar, boolean z) {
        while (fVar != null) {
            f<K, V> fVar2 = fVar.b;
            f<K, V> fVar3 = fVar.c;
            int i2 = 0;
            int i3 = fVar2 != null ? fVar2.i : 0;
            int i4 = fVar3 != null ? fVar3.i : 0;
            int i5 = i3 - i4;
            if (i5 == -2) {
                f<K, V> fVar4 = fVar3.b;
                f<K, V> fVar5 = fVar3.c;
                int i6 = fVar5 != null ? fVar5.i : 0;
                if (fVar4 != null) {
                    i2 = fVar4.i;
                }
                int i7 = i2 - i6;
                if (i7 == -1 || (i7 == 0 && !z)) {
                    i(fVar);
                } else {
                    j(fVar3);
                    i(fVar);
                }
                if (z) {
                    return;
                }
            } else if (i5 == 2) {
                f<K, V> fVar6 = fVar2.b;
                f<K, V> fVar7 = fVar2.c;
                int i8 = fVar7 != null ? fVar7.i : 0;
                if (fVar6 != null) {
                    i2 = fVar6.i;
                }
                int i9 = i2 - i8;
                if (i9 == 1 || (i9 == 0 && !z)) {
                    j(fVar);
                } else {
                    i(fVar2);
                    j(fVar);
                }
                if (z) {
                    return;
                }
            } else if (i5 == 0) {
                fVar.i = i3 + 1;
                if (z) {
                    return;
                }
            } else {
                fVar.i = Math.max(i3, i4) + 1;
                if (!z) {
                    return;
                }
            }
            fVar = fVar.a;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedHashTreeMap<K, V>.c cVar = this.g;
        if (cVar != null) {
            return cVar;
        }
        LinkedHashTreeMap<K, V>.c cVar2 = new c();
        this.g = cVar2;
        return cVar2;
    }

    public void f(f<K, V> fVar, boolean z) {
        f<K, V> fVar2;
        int i2;
        if (z) {
            f<K, V> fVar3 = fVar.e;
            fVar3.d = fVar.d;
            fVar.d.e = fVar3;
            fVar.e = null;
            fVar.d = null;
        }
        f<K, V> fVar4 = fVar.b;
        f<K, V> fVar5 = fVar.c;
        f<K, V> fVar6 = fVar.a;
        int i3 = 0;
        if (fVar4 == null || fVar5 == null) {
            if (fVar4 != null) {
                h(fVar, fVar4);
                fVar.b = null;
            } else if (fVar5 != null) {
                h(fVar, fVar5);
                fVar.c = null;
            } else {
                h(fVar, null);
            }
            e(fVar6, false);
            this.d--;
            this.e++;
            return;
        }
        if (fVar4.i > fVar5.i) {
            f<K, V> fVar7 = fVar4.c;
            while (true) {
                fVar2 = fVar4;
                fVar4 = fVar7;
                if (fVar4 == null) {
                    break;
                }
                fVar7 = fVar4.c;
            }
        } else {
            f<K, V> fVar8 = fVar5.b;
            while (true) {
                fVar5 = fVar8;
                if (fVar5 == null) {
                    break;
                }
                fVar8 = fVar5.b;
            }
            fVar2 = fVar5;
        }
        f(fVar2, false);
        f<K, V> fVar9 = fVar.b;
        if (fVar9 != null) {
            i2 = fVar9.i;
            fVar2.b = fVar9;
            fVar9.a = fVar2;
            fVar.b = null;
        } else {
            i2 = 0;
        }
        f<K, V> fVar10 = fVar.c;
        if (fVar10 != null) {
            i3 = fVar10.i;
            fVar2.c = fVar10;
            fVar10.a = fVar2;
            fVar.c = null;
        }
        fVar2.i = Math.max(i2, i3) + 1;
        h(fVar, fVar2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        f<K, V> d2 = d(obj);
        if (d2 != null) {
            return d2.h;
        }
        return null;
    }

    public final void h(f<K, V> fVar, f<K, V> fVar2) {
        f<K, V> fVar3 = fVar.a;
        fVar.a = null;
        if (fVar2 != null) {
            fVar2.a = fVar3;
        }
        if (fVar3 == null) {
            int i2 = fVar.g;
            f<K, V>[] fVarArr = this.b;
            fVarArr[i2 & (fVarArr.length - 1)] = fVar2;
        } else if (fVar3.b == fVar) {
            fVar3.b = fVar2;
        } else {
            fVar3.c = fVar2;
        }
    }

    public final void i(f<K, V> fVar) {
        f<K, V> fVar2 = fVar.b;
        f<K, V> fVar3 = fVar.c;
        f<K, V> fVar4 = fVar3.b;
        f<K, V> fVar5 = fVar3.c;
        fVar.c = fVar4;
        if (fVar4 != null) {
            fVar4.a = fVar;
        }
        h(fVar, fVar3);
        fVar3.b = fVar;
        fVar.a = fVar3;
        int i2 = 0;
        int max = Math.max(fVar2 != null ? fVar2.i : 0, fVar4 != null ? fVar4.i : 0) + 1;
        fVar.i = max;
        if (fVar5 != null) {
            i2 = fVar5.i;
        }
        fVar3.i = Math.max(max, i2) + 1;
    }

    public final void j(f<K, V> fVar) {
        f<K, V> fVar2 = fVar.b;
        f<K, V> fVar3 = fVar.c;
        f<K, V> fVar4 = fVar2.b;
        f<K, V> fVar5 = fVar2.c;
        fVar.b = fVar5;
        if (fVar5 != null) {
            fVar5.a = fVar;
        }
        h(fVar, fVar2);
        fVar2.c = fVar;
        fVar.a = fVar2;
        int i2 = 0;
        int max = Math.max(fVar3 != null ? fVar3.i : 0, fVar5 != null ? fVar5.i : 0) + 1;
        fVar.i = max;
        if (fVar4 != null) {
            i2 = fVar4.i;
        }
        fVar2.i = Math.max(max, i2) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedHashTreeMap<K, V>.d dVar = this.h;
        if (dVar != null) {
            return dVar;
        }
        LinkedHashTreeMap<K, V>.d dVar2 = new d();
        this.h = dVar2;
        return dVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        Objects.requireNonNull(k, "key == null");
        f<K, V> a3 = a(k, true);
        V v2 = a3.h;
        a3.h = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        f<K, V> d2 = d(obj);
        if (d2 != null) {
            f(d2, true);
        }
        if (d2 != null) {
            return d2.h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.d;
    }

    public LinkedHashTreeMap(Comparator<? super K> comparator) {
        this.d = 0;
        this.e = 0;
        this.a = comparator == null ? i : comparator;
        this.c = new f<>();
        f<K, V>[] fVarArr = new f[16];
        this.b = fVarArr;
        this.f = (fVarArr.length / 4) + (fVarArr.length / 2);
    }

    public static final class f<K, V> implements Map.Entry<K, V> {
        public f<K, V> a;
        public f<K, V> b;
        public f<K, V> c;
        public f<K, V> d;
        public f<K, V> e;
        public final K f;
        public final int g;
        public V h;
        public int i;

        public f() {
            this.f = null;
            this.g = -1;
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
            V v = this.h;
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
            return this.h;
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            K k = this.f;
            int i2 = 0;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.h;
            if (v != null) {
                i2 = v.hashCode();
            }
            return hashCode ^ i2;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.h;
            this.h = v;
            return v2;
        }

        @Override // java.lang.Object
        public String toString() {
            return ((Object) this.f) + "=" + ((Object) this.h);
        }

        public f(f<K, V> fVar, K k, int i2, f<K, V> fVar2, f<K, V> fVar3) {
            this.a = fVar;
            this.f = k;
            this.g = i2;
            this.i = 1;
            this.d = fVar2;
            this.e = fVar3;
            fVar3.d = this;
            fVar2.e = this;
        }
    }
}
