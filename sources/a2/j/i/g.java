package a2.j.i;

import a2.b.a.a.a;
import com.google.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;
public final class g extends a<Long> implements Internal.LongList, RandomAccess {
    public static final g d;
    public long[] b;
    public int c;

    static {
        g gVar = new g();
        d = gVar;
        gVar.makeImmutable();
    }

    public g() {
        this.b = new long[10];
        this.c = 0;
    }

    public final void a(int i, long j) {
        int i2;
        ensureIsMutable();
        if (i < 0 || i > (i2 = this.c)) {
            throw new IndexOutOfBoundsException(c(i));
        }
        long[] jArr = this.b;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[a.y2(i2, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.b, i, jArr2, i + 1, this.c - i);
            this.b = jArr2;
        }
        this.b[i] = j;
        this.c++;
        ((AbstractList) this).modCount++;
    }

    @Override // a2.j.i.a, java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        a(i, ((Long) obj).longValue());
    }

    @Override // a2.j.i.a, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends Long> collection) {
        ensureIsMutable();
        Objects.requireNonNull(collection);
        if (!(collection instanceof g)) {
            return super.addAll(collection);
        }
        g gVar = (g) collection;
        int i = gVar.c;
        if (i == 0) {
            return false;
        }
        int i2 = this.c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.b;
            if (i3 > jArr.length) {
                this.b = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(gVar.b, 0, this.b, this.c, gVar.c);
            this.c = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // com.google.protobuf.Internal.LongList
    public void addLong(long j) {
        a(this.c, j);
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
        if (!(obj instanceof g)) {
            return super.equals(obj);
        }
        g gVar = (g) obj;
        if (this.c != gVar.c) {
            return false;
        }
        long[] jArr = gVar.b;
        for (int i = 0; i < this.c; i++) {
            if (this.b[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        b(i);
        return Long.valueOf(this.b[i]);
    }

    @Override // com.google.protobuf.Internal.LongList
    public long getLong(int i) {
        b(i);
        return this.b[i];
    }

    @Override // a2.j.i.a, java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            i = (i * 31) + Internal.hashLong(this.b[i2]);
        }
        return i;
    }

    @Override // a2.j.i.a, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        ensureIsMutable();
        for (int i = 0; i < this.c; i++) {
            if (obj.equals(Long.valueOf(this.b[i]))) {
                long[] jArr = this.b;
                System.arraycopy(jArr, i + 1, jArr, i, this.c - i);
                this.c--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // a2.j.i.a, java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        ensureIsMutable();
        b(i);
        long[] jArr = this.b;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    @Override // com.google.protobuf.Internal.LongList
    public long setLong(int i, long j) {
        ensureIsMutable();
        b(i);
        long[] jArr = this.b;
        long j2 = jArr[i];
        jArr[i] = j;
        return j2;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public int size() {
        return this.c;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public Internal.LongList mutableCopyWithCapacity(int i) {
        if (i >= this.c) {
            return new g(Arrays.copyOf(this.b, i), this.c);
        }
        throw new IllegalArgumentException();
    }

    public g(long[] jArr, int i) {
        this.b = jArr;
        this.c = i;
    }

    @Override // a2.j.i.a, java.util.AbstractList, java.util.List
    public Object remove(int i) {
        ensureIsMutable();
        b(i);
        long[] jArr = this.b;
        long j = jArr[i];
        System.arraycopy(jArr, i + 1, jArr, i, this.c - i);
        this.c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }
}
