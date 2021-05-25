package a2.j.i;

import a2.b.a.a.a;
import com.google.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;
public final class b extends a<Boolean> implements Internal.BooleanList, RandomAccess {
    public static final b d;
    public boolean[] b;
    public int c;

    static {
        b bVar = new b();
        d = bVar;
        bVar.makeImmutable();
    }

    public b() {
        this.b = new boolean[10];
        this.c = 0;
    }

    public final void a(int i, boolean z) {
        int i2;
        ensureIsMutable();
        if (i < 0 || i > (i2 = this.c)) {
            throw new IndexOutOfBoundsException(c(i));
        }
        boolean[] zArr = this.b;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[a.y2(i2, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.b, i, zArr2, i + 1, this.c - i);
            this.b = zArr2;
        }
        this.b[i] = z;
        this.c++;
        ((AbstractList) this).modCount++;
    }

    @Override // a2.j.i.a, java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        a(i, ((Boolean) obj).booleanValue());
    }

    @Override // a2.j.i.a, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends Boolean> collection) {
        ensureIsMutable();
        Objects.requireNonNull(collection);
        if (!(collection instanceof b)) {
            return super.addAll(collection);
        }
        b bVar = (b) collection;
        int i = bVar.c;
        if (i == 0) {
            return false;
        }
        int i2 = this.c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.b;
            if (i3 > zArr.length) {
                this.b = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(bVar.b, 0, this.b, this.c, bVar.c);
            this.c = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // com.google.protobuf.Internal.BooleanList
    public void addBoolean(boolean z) {
        a(this.c, z);
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
        if (!(obj instanceof b)) {
            return super.equals(obj);
        }
        b bVar = (b) obj;
        if (this.c != bVar.c) {
            return false;
        }
        boolean[] zArr = bVar.b;
        for (int i = 0; i < this.c; i++) {
            if (this.b[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        b(i);
        return Boolean.valueOf(this.b[i]);
    }

    @Override // com.google.protobuf.Internal.BooleanList
    public boolean getBoolean(int i) {
        b(i);
        return this.b[i];
    }

    @Override // a2.j.i.a, java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            i = (i * 31) + Internal.hashBoolean(this.b[i2]);
        }
        return i;
    }

    @Override // a2.j.i.a, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        ensureIsMutable();
        for (int i = 0; i < this.c; i++) {
            if (obj.equals(Boolean.valueOf(this.b[i]))) {
                boolean[] zArr = this.b;
                System.arraycopy(zArr, i + 1, zArr, i, this.c - i);
                this.c--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // a2.j.i.a, java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        ensureIsMutable();
        b(i);
        boolean[] zArr = this.b;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    @Override // com.google.protobuf.Internal.BooleanList
    public boolean setBoolean(int i, boolean z) {
        ensureIsMutable();
        b(i);
        boolean[] zArr = this.b;
        boolean z2 = zArr[i];
        zArr[i] = z;
        return z2;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public int size() {
        return this.c;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public Internal.BooleanList mutableCopyWithCapacity(int i) {
        if (i >= this.c) {
            return new b(Arrays.copyOf(this.b, i), this.c);
        }
        throw new IllegalArgumentException();
    }

    public b(boolean[] zArr, int i) {
        this.b = zArr;
        this.c = i;
    }

    @Override // a2.j.i.a, java.util.AbstractList, java.util.List
    public Object remove(int i) {
        ensureIsMutable();
        b(i);
        boolean[] zArr = this.b;
        boolean z = zArr[i];
        System.arraycopy(zArr, i + 1, zArr, i, this.c - i);
        this.c--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }
}
