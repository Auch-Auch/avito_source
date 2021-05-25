package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import l6.e.b;
public class LongSparseArray<E> implements Cloneable {
    public static final Object e = new Object();
    public boolean a;
    public long[] b;
    public Object[] c;
    public int d;

    public LongSparseArray() {
        this(10);
    }

    public final void a() {
        int i = this.d;
        long[] jArr = this.b;
        Object[] objArr = this.c;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != e) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.a = false;
        this.d = i2;
    }

    public void append(long j, E e2) {
        int i = this.d;
        if (i == 0 || j > this.b[i - 1]) {
            if (this.a && i >= this.b.length) {
                a();
            }
            int i2 = this.d;
            if (i2 >= this.b.length) {
                int f = b.f(i2 + 1);
                long[] jArr = new long[f];
                Object[] objArr = new Object[f];
                long[] jArr2 = this.b;
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
                Object[] objArr2 = this.c;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.b = jArr;
                this.c = objArr;
            }
            this.b[i2] = j;
            this.c[i2] = e2;
            this.d = i2 + 1;
            return;
        }
        put(j, e2);
    }

    public void clear() {
        int i = this.d;
        Object[] objArr = this.c;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.d = 0;
        this.a = false;
    }

    public boolean containsKey(long j) {
        return indexOfKey(j) >= 0;
    }

    public boolean containsValue(E e2) {
        return indexOfValue(e2) >= 0;
    }

    @Deprecated
    public void delete(long j) {
        remove(j);
    }

    @Nullable
    public E get(long j) {
        return get(j, null);
    }

    public int indexOfKey(long j) {
        if (this.a) {
            a();
        }
        return b.b(this.b, this.d, j);
    }

    public int indexOfValue(E e2) {
        if (this.a) {
            a();
        }
        for (int i = 0; i < this.d; i++) {
            if (this.c[i] == e2) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public long keyAt(int i) {
        if (this.a) {
            a();
        }
        return this.b[i];
    }

    public void put(long j, E e2) {
        int b2 = b.b(this.b, this.d, j);
        if (b2 >= 0) {
            this.c[b2] = e2;
            return;
        }
        int i = ~b2;
        int i2 = this.d;
        if (i < i2) {
            Object[] objArr = this.c;
            if (objArr[i] == e) {
                this.b[i] = j;
                objArr[i] = e2;
                return;
            }
        }
        if (this.a && i2 >= this.b.length) {
            a();
            i = ~b.b(this.b, this.d, j);
        }
        int i3 = this.d;
        if (i3 >= this.b.length) {
            int f = b.f(i3 + 1);
            long[] jArr = new long[f];
            Object[] objArr2 = new Object[f];
            long[] jArr2 = this.b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.b = jArr;
            this.c = objArr2;
        }
        int i4 = this.d;
        if (i4 - i != 0) {
            long[] jArr3 = this.b;
            int i5 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i5, i4 - i);
            Object[] objArr4 = this.c;
            System.arraycopy(objArr4, i, objArr4, i5, this.d - i);
        }
        this.b[i] = j;
        this.c[i] = e2;
        this.d++;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: androidx.collection.LongSparseArray<E> */
    /* JADX WARN: Multi-variable type inference failed */
    public void putAll(@NonNull LongSparseArray<? extends E> longSparseArray) {
        int size = longSparseArray.size();
        for (int i = 0; i < size; i++) {
            put(longSparseArray.keyAt(i), longSparseArray.valueAt(i));
        }
    }

    @Nullable
    public E putIfAbsent(long j, E e2) {
        E e3 = get(j);
        if (e3 == null) {
            put(j, e2);
        }
        return e3;
    }

    public void remove(long j) {
        Object[] objArr;
        Object obj;
        int b2 = b.b(this.b, this.d, j);
        if (b2 >= 0 && (objArr = this.c)[b2] != (obj = e)) {
            objArr[b2] = obj;
            this.a = true;
        }
    }

    public void removeAt(int i) {
        Object[] objArr = this.c;
        Object obj = objArr[i];
        Object obj2 = e;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.a = true;
        }
    }

    @Nullable
    public E replace(long j, E e2) {
        int indexOfKey = indexOfKey(j);
        if (indexOfKey < 0) {
            return null;
        }
        Object[] objArr = this.c;
        E e3 = (E) objArr[indexOfKey];
        objArr[indexOfKey] = e2;
        return e3;
    }

    public void setValueAt(int i, E e2) {
        if (this.a) {
            a();
        }
        this.c[i] = e2;
    }

    public int size() {
        if (this.a) {
            a();
        }
        return this.d;
    }

    @Override // java.lang.Object
    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.d * 28);
        sb.append('{');
        for (int i = 0; i < this.d; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(keyAt(i));
            sb.append('=');
            E valueAt = valueAt(i);
            if (valueAt != this) {
                sb.append((Object) valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public E valueAt(int i) {
        if (this.a) {
            a();
        }
        return (E) this.c[i];
    }

    public LongSparseArray(int i) {
        this.a = false;
        if (i == 0) {
            this.b = b.b;
            this.c = b.c;
            return;
        }
        int f = b.f(i);
        this.b = new long[f];
        this.c = new Object[f];
    }

    @Override // java.lang.Object
    public LongSparseArray<E> clone() {
        try {
            LongSparseArray<E> longSparseArray = (LongSparseArray) super.clone();
            longSparseArray.b = (long[]) this.b.clone();
            longSparseArray.c = (Object[]) this.c.clone();
            return longSparseArray;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public E get(long j, E e2) {
        int b2 = b.b(this.b, this.d, j);
        if (b2 >= 0) {
            Object[] objArr = this.c;
            if (objArr[b2] != e) {
                return (E) objArr[b2];
            }
        }
        return e2;
    }

    public boolean replace(long j, E e2, E e3) {
        int indexOfKey = indexOfKey(j);
        if (indexOfKey < 0) {
            return false;
        }
        Object obj = this.c[indexOfKey];
        if (obj != e2 && (e2 == null || !e2.equals(obj))) {
            return false;
        }
        this.c[indexOfKey] = e3;
        return true;
    }

    public boolean remove(long j, Object obj) {
        int indexOfKey = indexOfKey(j);
        if (indexOfKey < 0) {
            return false;
        }
        E valueAt = valueAt(indexOfKey);
        if (obj != valueAt && (obj == null || !obj.equals(valueAt))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }
}
