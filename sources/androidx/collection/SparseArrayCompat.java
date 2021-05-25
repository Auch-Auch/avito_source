package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import l6.e.b;
public class SparseArrayCompat<E> implements Cloneable {
    public static final Object e = new Object();
    public boolean a;
    public int[] b;
    public Object[] c;
    public int d;

    public SparseArrayCompat() {
        this(10);
    }

    public final void a() {
        int i = this.d;
        int[] iArr = this.b;
        Object[] objArr = this.c;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != e) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.a = false;
        this.d = i2;
    }

    public void append(int i, E e2) {
        int i2 = this.d;
        if (i2 == 0 || i > this.b[i2 - 1]) {
            if (this.a && i2 >= this.b.length) {
                a();
            }
            int i3 = this.d;
            if (i3 >= this.b.length) {
                int e3 = b.e(i3 + 1);
                int[] iArr = new int[e3];
                Object[] objArr = new Object[e3];
                int[] iArr2 = this.b;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr2 = this.c;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.b = iArr;
                this.c = objArr;
            }
            this.b[i3] = i;
            this.c[i3] = e2;
            this.d = i3 + 1;
            return;
        }
        put(i, e2);
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

    public boolean containsKey(int i) {
        return indexOfKey(i) >= 0;
    }

    public boolean containsValue(E e2) {
        return indexOfValue(e2) >= 0;
    }

    @Deprecated
    public void delete(int i) {
        remove(i);
    }

    @Nullable
    public E get(int i) {
        return get(i, null);
    }

    public int indexOfKey(int i) {
        if (this.a) {
            a();
        }
        return b.a(this.b, this.d, i);
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

    public int keyAt(int i) {
        if (this.a) {
            a();
        }
        return this.b[i];
    }

    public void put(int i, E e2) {
        int a3 = b.a(this.b, this.d, i);
        if (a3 >= 0) {
            this.c[a3] = e2;
            return;
        }
        int i2 = ~a3;
        int i3 = this.d;
        if (i2 < i3) {
            Object[] objArr = this.c;
            if (objArr[i2] == e) {
                this.b[i2] = i;
                objArr[i2] = e2;
                return;
            }
        }
        if (this.a && i3 >= this.b.length) {
            a();
            i2 = ~b.a(this.b, this.d, i);
        }
        int i4 = this.d;
        if (i4 >= this.b.length) {
            int e3 = b.e(i4 + 1);
            int[] iArr = new int[e3];
            Object[] objArr2 = new Object[e3];
            int[] iArr2 = this.b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.b = iArr;
            this.c = objArr2;
        }
        int i5 = this.d;
        if (i5 - i2 != 0) {
            int[] iArr3 = this.b;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr4 = this.c;
            System.arraycopy(objArr4, i2, objArr4, i6, this.d - i2);
        }
        this.b[i2] = i;
        this.c[i2] = e2;
        this.d++;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: androidx.collection.SparseArrayCompat<E> */
    /* JADX WARN: Multi-variable type inference failed */
    public void putAll(@NonNull SparseArrayCompat<? extends E> sparseArrayCompat) {
        int size = sparseArrayCompat.size();
        for (int i = 0; i < size; i++) {
            put(sparseArrayCompat.keyAt(i), sparseArrayCompat.valueAt(i));
        }
    }

    @Nullable
    public E putIfAbsent(int i, E e2) {
        E e3 = get(i);
        if (e3 == null) {
            put(i, e2);
        }
        return e3;
    }

    public void remove(int i) {
        Object[] objArr;
        Object obj;
        int a3 = b.a(this.b, this.d, i);
        if (a3 >= 0 && (objArr = this.c)[a3] != (obj = e)) {
            objArr[a3] = obj;
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

    public void removeAtRange(int i, int i2) {
        int min = Math.min(this.d, i2 + i);
        while (i < min) {
            removeAt(i);
            i++;
        }
    }

    @Nullable
    public E replace(int i, E e2) {
        int indexOfKey = indexOfKey(i);
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

    public SparseArrayCompat(int i) {
        this.a = false;
        if (i == 0) {
            this.b = b.a;
            this.c = b.c;
            return;
        }
        int e2 = b.e(i);
        this.b = new int[e2];
        this.c = new Object[e2];
    }

    @Override // java.lang.Object
    public SparseArrayCompat<E> clone() {
        try {
            SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) super.clone();
            sparseArrayCompat.b = (int[]) this.b.clone();
            sparseArrayCompat.c = (Object[]) this.c.clone();
            return sparseArrayCompat;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public E get(int i, E e2) {
        int a3 = b.a(this.b, this.d, i);
        if (a3 >= 0) {
            Object[] objArr = this.c;
            if (objArr[a3] != e) {
                return (E) objArr[a3];
            }
        }
        return e2;
    }

    public boolean replace(int i, E e2, E e3) {
        int indexOfKey = indexOfKey(i);
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

    public boolean remove(int i, Object obj) {
        int indexOfKey = indexOfKey(i);
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
