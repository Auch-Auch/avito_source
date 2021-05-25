package a2.j.i;

import a2.b.a.a.a;
import com.google.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;
public final class c extends a<Double> implements Internal.DoubleList, RandomAccess {
    public static final c d;
    public double[] b;
    public int c;

    static {
        c cVar = new c();
        d = cVar;
        cVar.makeImmutable();
    }

    public c() {
        this.b = new double[10];
        this.c = 0;
    }

    public final void a(int i, double d2) {
        int i2;
        ensureIsMutable();
        if (i < 0 || i > (i2 = this.c)) {
            throw new IndexOutOfBoundsException(c(i));
        }
        double[] dArr = this.b;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[a.y2(i2, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.b, i, dArr2, i + 1, this.c - i);
            this.b = dArr2;
        }
        this.b[i] = d2;
        this.c++;
        ((AbstractList) this).modCount++;
    }

    @Override // a2.j.i.a, java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        a(i, ((Double) obj).doubleValue());
    }

    @Override // a2.j.i.a, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends Double> collection) {
        ensureIsMutable();
        Objects.requireNonNull(collection);
        if (!(collection instanceof c)) {
            return super.addAll(collection);
        }
        c cVar = (c) collection;
        int i = cVar.c;
        if (i == 0) {
            return false;
        }
        int i2 = this.c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            double[] dArr = this.b;
            if (i3 > dArr.length) {
                this.b = Arrays.copyOf(dArr, i3);
            }
            System.arraycopy(cVar.b, 0, this.b, this.c, cVar.c);
            this.c = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // com.google.protobuf.Internal.DoubleList
    public void addDouble(double d2) {
        a(this.c, d2);
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
        if (!(obj instanceof c)) {
            return super.equals(obj);
        }
        c cVar = (c) obj;
        if (this.c != cVar.c) {
            return false;
        }
        double[] dArr = cVar.b;
        for (int i = 0; i < this.c; i++) {
            if (this.b[i] != dArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        b(i);
        return Double.valueOf(this.b[i]);
    }

    @Override // com.google.protobuf.Internal.DoubleList
    public double getDouble(int i) {
        b(i);
        return this.b[i];
    }

    @Override // a2.j.i.a, java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            i = (i * 31) + Internal.hashLong(Double.doubleToLongBits(this.b[i2]));
        }
        return i;
    }

    @Override // a2.j.i.a, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        ensureIsMutable();
        for (int i = 0; i < this.c; i++) {
            if (obj.equals(Double.valueOf(this.b[i]))) {
                double[] dArr = this.b;
                System.arraycopy(dArr, i + 1, dArr, i, this.c - i);
                this.c--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // a2.j.i.a, java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        ensureIsMutable();
        b(i);
        double[] dArr = this.b;
        double d2 = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d2);
    }

    @Override // com.google.protobuf.Internal.DoubleList
    public double setDouble(int i, double d2) {
        ensureIsMutable();
        b(i);
        double[] dArr = this.b;
        double d3 = dArr[i];
        dArr[i] = d2;
        return d3;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public int size() {
        return this.c;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public Internal.DoubleList mutableCopyWithCapacity(int i) {
        if (i >= this.c) {
            return new c(Arrays.copyOf(this.b, i), this.c);
        }
        throw new IllegalArgumentException();
    }

    public c(double[] dArr, int i) {
        this.b = dArr;
        this.c = i;
    }

    @Override // a2.j.i.a, java.util.AbstractList, java.util.List
    public Object remove(int i) {
        ensureIsMutable();
        b(i);
        double[] dArr = this.b;
        double d2 = dArr[i];
        System.arraycopy(dArr, i + 1, dArr, i, this.c - i);
        this.c--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d2);
    }
}
