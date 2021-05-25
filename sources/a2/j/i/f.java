package a2.j.i;

import a2.b.a.a.a;
import com.google.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;
public final class f extends a<Integer> implements Internal.IntList, RandomAccess {
    public static final f d;
    public int[] b;
    public int c;

    static {
        f fVar = new f();
        d = fVar;
        fVar.makeImmutable();
    }

    public f() {
        this.b = new int[10];
        this.c = 0;
    }

    public final void a(int i, int i2) {
        int i3;
        ensureIsMutable();
        if (i < 0 || i > (i3 = this.c)) {
            throw new IndexOutOfBoundsException(c(i));
        }
        int[] iArr = this.b;
        if (i3 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i3 - i);
        } else {
            int[] iArr2 = new int[a.y2(i3, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.b, i, iArr2, i + 1, this.c - i);
            this.b = iArr2;
        }
        this.b[i] = i2;
        this.c++;
        ((AbstractList) this).modCount++;
    }

    @Override // a2.j.i.a, java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        a(i, ((Integer) obj).intValue());
    }

    @Override // a2.j.i.a, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends Integer> collection) {
        ensureIsMutable();
        Objects.requireNonNull(collection);
        if (!(collection instanceof f)) {
            return super.addAll(collection);
        }
        f fVar = (f) collection;
        int i = fVar.c;
        if (i == 0) {
            return false;
        }
        int i2 = this.c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.b;
            if (i3 > iArr.length) {
                this.b = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(fVar.b, 0, this.b, this.c, fVar.c);
            this.c = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // com.google.protobuf.Internal.IntList
    public void addInt(int i) {
        a(this.c, i);
    }

    public final void b(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException(c(i));
        }
    }

    public final String c(int i) {
        StringBuilder M = a.M("Index:", i, ", Size:");
        M.append(this.c);
        return M.toString();
    }

    @Override // a2.j.i.a, java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return super.equals(obj);
        }
        f fVar = (f) obj;
        if (this.c != fVar.c) {
            return false;
        }
        int[] iArr = fVar.b;
        for (int i = 0; i < this.c; i++) {
            if (this.b[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        b(i);
        return Integer.valueOf(this.b[i]);
    }

    @Override // com.google.protobuf.Internal.IntList
    public int getInt(int i) {
        b(i);
        return this.b[i];
    }

    @Override // a2.j.i.a, java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            i = (i * 31) + this.b[i2];
        }
        return i;
    }

    @Override // a2.j.i.a, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        ensureIsMutable();
        for (int i = 0; i < this.c; i++) {
            if (obj.equals(Integer.valueOf(this.b[i]))) {
                int[] iArr = this.b;
                System.arraycopy(iArr, i + 1, iArr, i, this.c - i);
                this.c--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // a2.j.i.a, java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        ensureIsMutable();
        b(i);
        int[] iArr = this.b;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    @Override // com.google.protobuf.Internal.IntList
    public int setInt(int i, int i2) {
        ensureIsMutable();
        b(i);
        int[] iArr = this.b;
        int i3 = iArr[i];
        iArr[i] = i2;
        return i3;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public int size() {
        return this.c;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public Internal.IntList mutableCopyWithCapacity(int i) {
        if (i >= this.c) {
            return new f(Arrays.copyOf(this.b, i), this.c);
        }
        throw new IllegalArgumentException();
    }

    public f(int[] iArr, int i) {
        this.b = iArr;
        this.c = i;
    }

    @Override // a2.j.i.a, java.util.AbstractList, java.util.List
    public Object remove(int i) {
        ensureIsMutable();
        b(i);
        int[] iArr = this.b;
        int i2 = iArr[i];
        System.arraycopy(iArr, i + 1, iArr, i, this.c - i);
        this.c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }
}
