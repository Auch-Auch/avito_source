package a2.j.d.c;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.spongycastle.asn1.cmc.BodyPartID;
@GwtIncompatible
public class b0<K, V> extends AbstractMap<K, V> implements Serializable {
    public static final /* synthetic */ int j = 0;
    @MonotonicNonNullDecl
    public transient int[] a;
    @VisibleForTesting
    @MonotonicNonNullDecl
    public transient long[] b;
    @VisibleForTesting
    @MonotonicNonNullDecl
    public transient Object[] c;
    @VisibleForTesting
    @MonotonicNonNullDecl
    public transient Object[] d;
    public transient int e;
    public transient int f;
    @MonotonicNonNullDecl
    public transient Set<K> g;
    @MonotonicNonNullDecl
    public transient Set<Map.Entry<K, V>> h;
    @MonotonicNonNullDecl
    public transient Collection<V> i;

    public class a extends AbstractSet<Map.Entry<K, V>> {
        public a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            b0.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            b0 b0Var = b0.this;
            Object key = entry.getKey();
            int i = b0.j;
            int l = b0Var.l(key);
            if (l == -1 || !Objects.equal(b0.this.d[l], entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            b0 b0Var = b0.this;
            java.util.Objects.requireNonNull(b0Var);
            return new z(b0Var);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            b0 b0Var = b0.this;
            Object key = entry.getKey();
            int i = b0.j;
            int l = b0Var.l(key);
            if (l == -1 || !Objects.equal(b0.this.d[l], entry.getValue())) {
                return false;
            }
            b0.a(b0.this, l);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return b0.this.f;
        }
    }

    public abstract class b<T> implements Iterator<T> {
        public int a;
        public int b;
        public int c = -1;

        public b(y yVar) {
            this.a = b0.this.e;
            this.b = b0.this.f();
        }

        public abstract T a(int i);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b >= 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (b0.this.e != this.a) {
                throw new ConcurrentModificationException();
            } else if (hasNext()) {
                int i = this.b;
                this.c = i;
                T a3 = a(i);
                this.b = b0.this.i(this.b);
                return a3;
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (b0.this.e == this.a) {
                Preconditions.checkState(this.c >= 0, "no calls to next() since the last call to remove()");
                this.a++;
                b0.a(b0.this, this.c);
                this.b = b0.this.d(this.b, this.c);
                this.c = -1;
                return;
            }
            throw new ConcurrentModificationException();
        }
    }

    public class c extends AbstractSet<K> {
        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            b0.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return b0.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<K> iterator() {
            b0 b0Var = b0.this;
            java.util.Objects.requireNonNull(b0Var);
            return new y(b0Var);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object obj) {
            b0 b0Var = b0.this;
            int i = b0.j;
            int l = b0Var.l(obj);
            if (l == -1) {
                return false;
            }
            b0.a(b0.this, l);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return b0.this.f;
        }
    }

    public final class d extends g<K, V> {
        @NullableDecl
        public final K a;
        public int b;

        public d(int i) {
            this.a = (K) b0.this.c[i];
            this.b = i;
        }

        public final void d() {
            int i = this.b;
            if (i == -1 || i >= b0.this.size() || !Objects.equal(this.a, b0.this.c[this.b])) {
                b0 b0Var = b0.this;
                K k = this.a;
                int i2 = b0.j;
                this.b = b0Var.l(k);
            }
        }

        @Override // a2.j.d.c.g, java.util.Map.Entry
        public K getKey() {
            return this.a;
        }

        @Override // a2.j.d.c.g, java.util.Map.Entry
        public V getValue() {
            d();
            int i = this.b;
            if (i == -1) {
                return null;
            }
            return (V) b0.this.d[i];
        }

        @Override // a2.j.d.c.g, java.util.Map.Entry
        public V setValue(V v) {
            d();
            int i = this.b;
            if (i == -1) {
                b0.this.put(this.a, v);
                return null;
            }
            Object[] objArr = b0.this.d;
            V v2 = (V) objArr[i];
            objArr[i] = v;
            return v2;
        }
    }

    public class e extends AbstractCollection<V> {
        public e() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            b0.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            b0 b0Var = b0.this;
            java.util.Objects.requireNonNull(b0Var);
            return new a0(b0Var);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return b0.this.f;
        }
    }

    public b0() {
        m(3);
    }

    public static Object a(b0 b0Var, int i2) {
        return b0Var.q(b0Var.c[i2], h(b0Var.b[i2]));
    }

    public static int h(long j2) {
        return (int) (j2 >>> 32);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: a2.j.d.c.b0<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            m(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                put(objectInputStream.readObject(), objectInputStream.readObject());
            }
            return;
        }
        throw new InvalidObjectException(a2.b.a.a.a.M2("Invalid size: ", readInt));
    }

    public static long s(long j2, int i2) {
        return (j2 & -4294967296L) | (((long) i2) & BodyPartID.bodyIdMax);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.f);
        int f2 = f();
        while (f2 >= 0) {
            objectOutputStream.writeObject(this.c[f2]);
            objectOutputStream.writeObject(this.d[f2]);
            f2 = i(f2);
        }
    }

    public void c(int i2) {
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (!p()) {
            this.e++;
            Arrays.fill(this.c, 0, this.f, (Object) null);
            Arrays.fill(this.d, 0, this.f, (Object) null);
            Arrays.fill(this.a, -1);
            Arrays.fill(this.b, 0, this.f, -1L);
            this.f = 0;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return l(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        for (int i2 = 0; i2 < this.f; i2++) {
            if (Objects.equal(obj, this.d[i2])) {
                return true;
            }
        }
        return false;
    }

    public int d(int i2, int i3) {
        return i2 - 1;
    }

    public void e() {
        Preconditions.checkState(p(), "Arrays already allocated");
        int i2 = this.e;
        int[] iArr = new int[AppCompatDelegateImpl.i.J(i2, 1.0d)];
        Arrays.fill(iArr, -1);
        this.a = iArr;
        long[] jArr = new long[i2];
        Arrays.fill(jArr, -1L);
        this.b = jArr;
        this.c = new Object[i2];
        this.d = new Object[i2];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.h;
        if (set != null) {
            return set;
        }
        a aVar = new a();
        this.h = aVar;
        return aVar;
    }

    public int f() {
        return isEmpty() ? -1 : 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(@NullableDecl Object obj) {
        int l = l(obj);
        c(l);
        if (l == -1) {
            return null;
        }
        return (V) this.d[l];
    }

    public int i(int i2) {
        int i3 = i2 + 1;
        if (i3 < this.f) {
            return i3;
        }
        return -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.f == 0;
    }

    public final int j() {
        return this.a.length - 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.g;
        if (set != null) {
            return set;
        }
        c cVar = new c();
        this.g = cVar;
        return cVar;
    }

    public final int l(@NullableDecl Object obj) {
        if (p()) {
            return -1;
        }
        int W1 = AppCompatDelegateImpl.i.W1(obj);
        int i2 = this.a[j() & W1];
        while (i2 != -1) {
            long j2 = this.b[i2];
            if (h(j2) == W1 && Objects.equal(obj, this.c[i2])) {
                return i2;
            }
            i2 = (int) j2;
        }
        return -1;
    }

    public void m(int i2) {
        Preconditions.checkArgument(i2 >= 0, "Expected size must be non-negative");
        this.e = Math.max(1, i2);
    }

    public void n(int i2, @NullableDecl K k, @NullableDecl V v, int i3) {
        this.b[i2] = (((long) i3) << 32) | BodyPartID.bodyIdMax;
        this.c[i2] = k;
        this.d[i2] = v;
    }

    public void o(int i2) {
        int size = size() - 1;
        if (i2 < size) {
            Object[] objArr = this.c;
            objArr[i2] = objArr[size];
            Object[] objArr2 = this.d;
            objArr2[i2] = objArr2[size];
            objArr[size] = null;
            objArr2[size] = null;
            long[] jArr = this.b;
            long j2 = jArr[size];
            jArr[i2] = j2;
            jArr[size] = -1;
            int h2 = h(j2) & j();
            int[] iArr = this.a;
            int i3 = iArr[h2];
            if (i3 == size) {
                iArr[h2] = i2;
                return;
            }
            while (true) {
                long[] jArr2 = this.b;
                long j3 = jArr2[i3];
                int i4 = (int) j3;
                if (i4 == size) {
                    jArr2[i3] = s(j3, i2);
                    return;
                }
                i3 = i4;
            }
        } else {
            this.c[i2] = null;
            this.d[i2] = null;
            this.b[i2] = -1;
        }
    }

    public boolean p() {
        return this.a == null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @NullableDecl
    public V put(@NullableDecl K k, @NullableDecl V v) {
        if (p()) {
            e();
        }
        long[] jArr = this.b;
        Object[] objArr = this.c;
        Object[] objArr2 = this.d;
        int W1 = AppCompatDelegateImpl.i.W1(k);
        int j2 = j() & W1;
        int i2 = this.f;
        int[] iArr = this.a;
        int i3 = iArr[j2];
        if (i3 == -1) {
            iArr[j2] = i2;
        } else {
            while (true) {
                long j3 = jArr[i3];
                if (h(j3) != W1 || !Objects.equal(k, objArr[i3])) {
                    int i4 = (int) j3;
                    if (i4 == -1) {
                        jArr[i3] = s(j3, i2);
                        break;
                    }
                    i3 = i4;
                } else {
                    V v2 = (V) objArr2[i3];
                    objArr2[i3] = v;
                    c(i3);
                    return v2;
                }
            }
        }
        int i5 = Integer.MAX_VALUE;
        if (i2 != Integer.MAX_VALUE) {
            int i6 = i2 + 1;
            int length = this.b.length;
            if (i6 > length) {
                int max = Math.max(1, length >>> 1) + length;
                if (max >= 0) {
                    i5 = max;
                }
                if (i5 != length) {
                    r(i5);
                }
            }
            n(i2, k, v, W1);
            this.f = i6;
            int length2 = this.a.length;
            if (AppCompatDelegateImpl.i.l1(i2, length2, 1.0d)) {
                int i7 = length2 * 2;
                int[] iArr2 = new int[i7];
                Arrays.fill(iArr2, -1);
                long[] jArr2 = this.b;
                int i8 = i7 - 1;
                for (int i9 = 0; i9 < this.f; i9++) {
                    int h2 = h(jArr2[i9]);
                    int i10 = h2 & i8;
                    int i11 = iArr2[i10];
                    iArr2[i10] = i9;
                    jArr2[i9] = (((long) h2) << 32) | (((long) i11) & BodyPartID.bodyIdMax);
                }
                this.a = iArr2;
            }
            this.e++;
            return null;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    @NullableDecl
    public final V q(@NullableDecl Object obj, int i2) {
        int j2 = j() & i2;
        int i3 = this.a[j2];
        if (i3 == -1) {
            return null;
        }
        int i4 = -1;
        while (true) {
            if (h(this.b[i3]) != i2 || !Objects.equal(obj, this.c[i3])) {
                int i5 = (int) this.b[i3];
                if (i5 == -1) {
                    return null;
                }
                i4 = i3;
                i3 = i5;
            } else {
                V v = (V) this.d[i3];
                if (i4 == -1) {
                    this.a[j2] = (int) this.b[i3];
                } else {
                    long[] jArr = this.b;
                    jArr[i4] = s(jArr[i4], (int) jArr[i3]);
                }
                o(i3);
                this.f--;
                this.e++;
                return v;
            }
        }
    }

    public void r(int i2) {
        this.c = Arrays.copyOf(this.c, i2);
        this.d = Arrays.copyOf(this.d, i2);
        long[] jArr = this.b;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i2);
        if (i2 > length) {
            Arrays.fill(copyOf, length, i2, -1L);
        }
        this.b = copyOf;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @NullableDecl
    public V remove(@NullableDecl Object obj) {
        if (p()) {
            return null;
        }
        return q(obj, AppCompatDelegateImpl.i.W1(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.i;
        if (collection != null) {
            return collection;
        }
        e eVar = new e();
        this.i = eVar;
        return eVar;
    }

    public b0(int i2) {
        m(i2);
    }
}
