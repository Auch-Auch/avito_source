package a2.j.d.c;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractMap;
import java.util.Map;
import kotlin.UShort;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true, serializable = true)
public final class b3<K, V> extends ImmutableMap<K, V> {
    public static final ImmutableMap<Object, Object> i = new b3(null, new Object[0], 0);
    private static final long serialVersionUID = 0;
    public final transient Object f;
    @VisibleForTesting
    public final transient Object[] g;
    public final transient int h;

    public static class a<K, V> extends ImmutableSet<Map.Entry<K, V>> {
        public final transient ImmutableMap<K, V> c;
        public final transient Object[] d;
        public final transient int e;
        public final transient int f;

        /* renamed from: a2.j.d.c.b3$a$a  reason: collision with other inner class name */
        public class C0060a extends ImmutableList<Map.Entry<K, V>> {
            public C0060a() {
            }

            @Override // com.google.common.collect.ImmutableCollection
            public boolean e() {
                return true;
            }

            @Override // java.util.List
            public Object get(int i) {
                Preconditions.checkElementIndex(i, a.this.f);
                a aVar = a.this;
                Object[] objArr = aVar.d;
                int i2 = i * 2;
                int i3 = aVar.e;
                return new AbstractMap.SimpleImmutableEntry(objArr[i2 + i3], objArr[i2 + (i3 ^ 1)]);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return a.this.f;
            }
        }

        public a(ImmutableMap<K, V> immutableMap, Object[] objArr, int i, int i2) {
            this.c = immutableMap;
            this.d = objArr;
            this.e = i;
            this.f = i2;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int a(Object[] objArr, int i) {
            return asList().a(objArr, i);
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.c.get(key))) {
                return false;
            }
            return true;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean e() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableSet
        public ImmutableList<Map.Entry<K, V>> i() {
            return new C0060a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: iterator */
        public UnmodifiableIterator<Map.Entry<K, V>> mo99iterator() {
            return asList().mo99iterator();
        }
    }

    public static final class b<K> extends ImmutableSet<K> {
        public final transient ImmutableMap<K, ?> c;
        public final transient ImmutableList<K> d;

        public b(ImmutableMap<K, ?> immutableMap, ImmutableList<K> immutableList) {
            this.c = immutableMap;
            this.d = immutableList;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int a(Object[] objArr, int i) {
            return this.d.a(objArr, i);
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public ImmutableList<K> asList() {
            return this.d;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            return this.c.get(obj) != null;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean e() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.c.size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: iterator */
        public UnmodifiableIterator<K> mo99iterator() {
            return this.d.mo99iterator();
        }
    }

    public static final class c extends ImmutableList<Object> {
        public final transient Object[] c;
        public final transient int d;
        public final transient int e;

        public c(Object[] objArr, int i, int i2) {
            this.c = objArr;
            this.d = i;
            this.e = i2;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean e() {
            return true;
        }

        @Override // java.util.List
        public Object get(int i) {
            Preconditions.checkElementIndex(i, this.e);
            return this.c[(i * 2) + this.d];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.e;
        }
    }

    public b3(Object obj, Object[] objArr, int i2) {
        this.f = obj;
        this.g = objArr;
        this.h = i2;
    }

    public static <K, V> b3<K, V> j(int i2, Object[] objArr) {
        if (i2 == 0) {
            return (b3) i;
        }
        if (i2 == 1) {
            AppCompatDelegateImpl.i.s(objArr[0], objArr[1]);
            return new b3<>(null, objArr, 1);
        }
        Preconditions.checkPositionIndex(i2, objArr.length >> 1);
        return new b3<>(l(objArr, i2, ImmutableSet.f(i2), 0), objArr, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
        r11[r5] = (byte) r1;
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0079, code lost:
        r11[r5] = (short) r1;
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b0, code lost:
        r11[r6] = r1;
        r2 = r2 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object l(java.lang.Object[] r9, int r10, int r11, int r12) {
        /*
            r0 = 1
            if (r10 != r0) goto L_0x000e
            r10 = r9[r12]
            r11 = r12 ^ 1
            r9 = r9[r11]
            androidx.appcompat.app.AppCompatDelegateImpl.i.s(r10, r9)
            r9 = 0
            return r9
        L_0x000e:
            int r0 = r11 + -1
            r1 = 128(0x80, float:1.794E-43)
            r2 = 0
            r3 = -1
            if (r11 > r1) goto L_0x0050
            byte[] r11 = new byte[r11]
            java.util.Arrays.fill(r11, r3)
        L_0x001b:
            if (r2 >= r10) goto L_0x004f
            int r1 = r2 * 2
            int r1 = r1 + r12
            r3 = r9[r1]
            r4 = r1 ^ 1
            r4 = r9[r4]
            androidx.appcompat.app.AppCompatDelegateImpl.i.s(r3, r4)
            int r5 = r3.hashCode()
            int r5 = androidx.appcompat.app.AppCompatDelegateImpl.i.V1(r5)
        L_0x0031:
            r5 = r5 & r0
            byte r6 = r11[r5]
            r7 = 255(0xff, float:3.57E-43)
            r6 = r6 & r7
            if (r6 != r7) goto L_0x003f
            byte r1 = (byte) r1
            r11[r5] = r1
            int r2 = r2 + 1
            goto L_0x001b
        L_0x003f:
            r7 = r9[r6]
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x004a
            int r5 = r5 + 1
            goto L_0x0031
        L_0x004a:
            java.lang.IllegalArgumentException r9 = m(r3, r4, r9, r6)
            throw r9
        L_0x004f:
            return r11
        L_0x0050:
            r1 = 32768(0x8000, float:4.5918E-41)
            if (r11 > r1) goto L_0x0090
            short[] r11 = new short[r11]
            java.util.Arrays.fill(r11, r3)
        L_0x005a:
            if (r2 >= r10) goto L_0x008f
            int r1 = r2 * 2
            int r1 = r1 + r12
            r3 = r9[r1]
            r4 = r1 ^ 1
            r4 = r9[r4]
            androidx.appcompat.app.AppCompatDelegateImpl.i.s(r3, r4)
            int r5 = r3.hashCode()
            int r5 = androidx.appcompat.app.AppCompatDelegateImpl.i.V1(r5)
        L_0x0070:
            r5 = r5 & r0
            short r6 = r11[r5]
            r7 = 65535(0xffff, float:9.1834E-41)
            r6 = r6 & r7
            if (r6 != r7) goto L_0x007f
            short r1 = (short) r1
            r11[r5] = r1
            int r2 = r2 + 1
            goto L_0x005a
        L_0x007f:
            r7 = r9[r6]
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x008a
            int r5 = r5 + 1
            goto L_0x0070
        L_0x008a:
            java.lang.IllegalArgumentException r9 = m(r3, r4, r9, r6)
            throw r9
        L_0x008f:
            return r11
        L_0x0090:
            int[] r11 = new int[r11]
            java.util.Arrays.fill(r11, r3)
        L_0x0095:
            if (r2 >= r10) goto L_0x00c5
            int r1 = r2 * 2
            int r1 = r1 + r12
            r4 = r9[r1]
            r5 = r1 ^ 1
            r5 = r9[r5]
            androidx.appcompat.app.AppCompatDelegateImpl.i.s(r4, r5)
            int r6 = r4.hashCode()
            int r6 = androidx.appcompat.app.AppCompatDelegateImpl.i.V1(r6)
        L_0x00ab:
            r6 = r6 & r0
            r7 = r11[r6]
            if (r7 != r3) goto L_0x00b5
            r11[r6] = r1
            int r2 = r2 + 1
            goto L_0x0095
        L_0x00b5:
            r8 = r9[r7]
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x00c0
            int r6 = r6 + 1
            goto L_0x00ab
        L_0x00c0:
            java.lang.IllegalArgumentException r9 = m(r4, r5, r9, r7)
            throw r9
        L_0x00c5:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.d.c.b3.l(java.lang.Object[], int, int, int):java.lang.Object");
    }

    public static IllegalArgumentException m(Object obj, Object obj2, Object[] objArr, int i2) {
        return new IllegalArgumentException("Multiple entries with same key: " + obj + "=" + obj2 + " and " + objArr[i2] + "=" + objArr[i2 ^ 1]);
    }

    public static Object n(@NullableDecl Object obj, @NullableDecl Object[] objArr, int i2, int i3, @NullableDecl Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i2 == 1) {
            if (objArr[i3].equals(obj2)) {
                return objArr[i3 ^ 1];
            }
            return null;
        } else if (obj == null) {
            return null;
        } else {
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                int length = bArr.length - 1;
                int V1 = AppCompatDelegateImpl.i.V1(obj2.hashCode());
                while (true) {
                    int i4 = V1 & length;
                    int i5 = bArr[i4] & 255;
                    if (i5 == 255) {
                        return null;
                    }
                    if (objArr[i5].equals(obj2)) {
                        return objArr[i5 ^ 1];
                    }
                    V1 = i4 + 1;
                }
            } else if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                int length2 = sArr.length - 1;
                int V12 = AppCompatDelegateImpl.i.V1(obj2.hashCode());
                while (true) {
                    int i6 = V12 & length2;
                    int i7 = sArr[i6] & UShort.MAX_VALUE;
                    if (i7 == 65535) {
                        return null;
                    }
                    if (objArr[i7].equals(obj2)) {
                        return objArr[i7 ^ 1];
                    }
                    V12 = i6 + 1;
                }
            } else {
                int[] iArr = (int[]) obj;
                int length3 = iArr.length - 1;
                int V13 = AppCompatDelegateImpl.i.V1(obj2.hashCode());
                while (true) {
                    int i8 = V13 & length3;
                    int i9 = iArr[i8];
                    if (i9 == -1) {
                        return null;
                    }
                    if (objArr[i9].equals(obj2)) {
                        return objArr[i9 ^ 1];
                    }
                    V13 = i8 + 1;
                }
            }
        }
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> a() {
        return new a(this, this.g, 0, this.h);
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<K> c() {
        return new b(this, new c(this.g, 0, this.h));
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableCollection<V> d() {
        return new c(this.g, 1, this.h);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    @NullableDecl
    public V get(@NullableDecl Object obj) {
        return (V) n(this.f, this.g, this.h, 0, obj);
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean h() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.h;
    }
}
