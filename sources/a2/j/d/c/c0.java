package a2.j.d.c;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ObjectArrays;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.spongycastle.asn1.cmc.BodyPartID;
@GwtIncompatible
public class c0<E> extends AbstractSet<E> implements Serializable {
    @MonotonicNonNullDecl
    public transient int[] a;
    @MonotonicNonNullDecl
    public transient long[] b;
    @MonotonicNonNullDecl
    public transient Object[] c;
    public transient int d;
    public transient int e;

    public class a implements Iterator<E> {
        public int a;
        public int b;
        public int c = -1;

        public a() {
            this.a = c0.this.d;
            this.b = c0.this.c();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b >= 0;
        }

        @Override // java.util.Iterator
        public E next() {
            if (c0.this.d != this.a) {
                throw new ConcurrentModificationException();
            } else if (hasNext()) {
                int i = this.b;
                this.c = i;
                c0 c0Var = c0.this;
                E e = (E) c0Var.c[i];
                this.b = c0Var.e(i);
                return e;
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (c0.this.d == this.a) {
                Preconditions.checkState(this.c >= 0, "no calls to next() since the last call to remove()");
                this.a++;
                c0 c0Var = c0.this;
                Object[] objArr = c0Var.c;
                int i = this.c;
                c0Var.m(objArr[i], c0.d(c0Var.b[i]));
                this.b = c0.this.a(this.b, this.c);
                this.c = -1;
                return;
            }
            throw new ConcurrentModificationException();
        }
    }

    public c0() {
        h(3);
    }

    public static int d(long j) {
        return (int) (j >>> 32);
    }

    public static long o(long j, int i) {
        return (j & -4294967296L) | (((long) i) & BodyPartID.bodyIdMax);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: a2.j.d.c.c0<E> */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            h(readInt);
            for (int i = 0; i < readInt; i++) {
                add(objectInputStream.readObject());
            }
            return;
        }
        throw new InvalidObjectException(a2.b.a.a.a.M2("Invalid size: ", readInt));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.e);
        int c2 = c();
        while (c2 >= 0) {
            objectOutputStream.writeObject(this.c[c2]);
            c2 = e(c2);
        }
    }

    public int a(int i, int i2) {
        return i - 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public boolean add(@NullableDecl E e2) {
        if (l()) {
            b();
        }
        long[] jArr = this.b;
        Object[] objArr = this.c;
        int W1 = AppCompatDelegateImpl.i.W1(e2);
        int f = f() & W1;
        int i = this.e;
        int[] iArr = this.a;
        int i2 = iArr[f];
        if (i2 == -1) {
            iArr[f] = i;
        } else {
            while (true) {
                long j = jArr[i2];
                if (d(j) == W1 && Objects.equal(e2, objArr[i2])) {
                    return false;
                }
                int i3 = (int) j;
                if (i3 == -1) {
                    jArr[i2] = o(j, i);
                    break;
                }
                i2 = i3;
            }
        }
        int i4 = Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            int i5 = i + 1;
            int length = this.b.length;
            if (i5 > length) {
                int max = Math.max(1, length >>> 1) + length;
                if (max >= 0) {
                    i4 = max;
                }
                if (i4 != length) {
                    n(i4);
                }
            }
            i(i, e2, W1);
            this.e = i5;
            int length2 = this.a.length;
            if (AppCompatDelegateImpl.i.l1(i, length2, 1.0d)) {
                int i6 = length2 * 2;
                int[] iArr2 = new int[i6];
                Arrays.fill(iArr2, -1);
                long[] jArr2 = this.b;
                int i7 = i6 - 1;
                for (int i8 = 0; i8 < this.e; i8++) {
                    int d2 = d(jArr2[i8]);
                    int i9 = d2 & i7;
                    int i10 = iArr2[i9];
                    iArr2[i9] = i8;
                    jArr2[i8] = (((long) d2) << 32) | (BodyPartID.bodyIdMax & ((long) i10));
                }
                this.a = iArr2;
            }
            this.d++;
            return true;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    public void b() {
        Preconditions.checkState(l(), "Arrays already allocated");
        int i = this.d;
        int[] iArr = new int[AppCompatDelegateImpl.i.J(i, 1.0d)];
        Arrays.fill(iArr, -1);
        this.a = iArr;
        long[] jArr = new long[i];
        Arrays.fill(jArr, -1L);
        this.b = jArr;
        this.c = new Object[i];
    }

    public int c() {
        return isEmpty() ? -1 : 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (!l()) {
            this.d++;
            Arrays.fill(this.c, 0, this.e, (Object) null);
            Arrays.fill(this.a, -1);
            Arrays.fill(this.b, 0, this.e, -1L);
            this.e = 0;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        if (l()) {
            return false;
        }
        int W1 = AppCompatDelegateImpl.i.W1(obj);
        int i = this.a[f() & W1];
        while (i != -1) {
            long j = this.b[i];
            if (d(j) == W1 && Objects.equal(obj, this.c[i])) {
                return true;
            }
            i = (int) j;
        }
        return false;
    }

    public int e(int i) {
        int i2 = i + 1;
        if (i2 < this.e) {
            return i2;
        }
        return -1;
    }

    public final int f() {
        return this.a.length - 1;
    }

    public void h(int i) {
        Preconditions.checkArgument(i >= 0, "Initial capacity must be non-negative");
        this.d = Math.max(1, i);
    }

    public void i(int i, E e2, int i2) {
        this.b[i] = (((long) i2) << 32) | BodyPartID.bodyIdMax;
        this.c[i] = e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.e == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public Iterator<E> iterator() {
        return new a();
    }

    public void j(int i) {
        int size = size() - 1;
        if (i < size) {
            Object[] objArr = this.c;
            objArr[i] = objArr[size];
            objArr[size] = null;
            long[] jArr = this.b;
            long j = jArr[size];
            jArr[i] = j;
            jArr[size] = -1;
            int d2 = d(j) & f();
            int[] iArr = this.a;
            int i2 = iArr[d2];
            if (i2 == size) {
                iArr[d2] = i;
                return;
            }
            while (true) {
                long[] jArr2 = this.b;
                long j2 = jArr2[i2];
                int i3 = (int) j2;
                if (i3 == size) {
                    jArr2[i2] = o(j2, i);
                    return;
                }
                i2 = i3;
            }
        } else {
            this.c[i] = null;
            this.b[i] = -1;
        }
    }

    public boolean l() {
        return this.a == null;
    }

    @CanIgnoreReturnValue
    public final boolean m(Object obj, int i) {
        int f = f() & i;
        int i2 = this.a[f];
        if (i2 == -1) {
            return false;
        }
        int i3 = -1;
        while (true) {
            if (d(this.b[i2]) != i || !Objects.equal(obj, this.c[i2])) {
                int i4 = (int) this.b[i2];
                if (i4 == -1) {
                    return false;
                }
                i3 = i2;
                i2 = i4;
            } else {
                if (i3 == -1) {
                    this.a[f] = (int) this.b[i2];
                } else {
                    long[] jArr = this.b;
                    jArr[i3] = o(jArr[i3], (int) jArr[i2]);
                }
                j(i2);
                this.e--;
                this.d++;
                return true;
            }
        }
    }

    public void n(int i) {
        this.c = Arrays.copyOf(this.c, i);
        long[] jArr = this.b;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i);
        if (i > length) {
            Arrays.fill(copyOf, length, i, -1L);
        }
        this.b = copyOf;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public boolean remove(@NullableDecl Object obj) {
        if (l()) {
            return false;
        }
        return m(obj, AppCompatDelegateImpl.i.W1(obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        if (l()) {
            return new Object[0];
        }
        return Arrays.copyOf(this.c, this.e);
    }

    public c0(int i) {
        h(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public <T> T[] toArray(T[] tArr) {
        if (l()) {
            if (tArr.length > 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        Object[] objArr = this.c;
        int i = this.e;
        Preconditions.checkPositionIndexes(0, 0 + i, objArr.length);
        if (tArr.length < i) {
            tArr = (T[]) ObjectArrays.newArray(tArr, i);
        } else if (tArr.length > i) {
            tArr[i] = null;
        }
        System.arraycopy(objArr, 0, tArr, 0, i);
        return tArr;
    }
}
