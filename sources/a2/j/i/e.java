package a2.j.i;

import a2.b.a.a.a;
import com.google.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;
public final class e extends a<Float> implements Internal.FloatList, RandomAccess {
    public static final e d;
    public float[] b;
    public int c;

    static {
        e eVar = new e();
        d = eVar;
        eVar.makeImmutable();
    }

    public e() {
        this.b = new float[10];
        this.c = 0;
    }

    public final void a(int i, float f) {
        int i2;
        ensureIsMutable();
        if (i < 0 || i > (i2 = this.c)) {
            throw new IndexOutOfBoundsException(c(i));
        }
        float[] fArr = this.b;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[a.y2(i2, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.b, i, fArr2, i + 1, this.c - i);
            this.b = fArr2;
        }
        this.b[i] = f;
        this.c++;
        ((AbstractList) this).modCount++;
    }

    @Override // a2.j.i.a, java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        a(i, ((Float) obj).floatValue());
    }

    @Override // a2.j.i.a, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends Float> collection) {
        ensureIsMutable();
        Objects.requireNonNull(collection);
        if (!(collection instanceof e)) {
            return super.addAll(collection);
        }
        e eVar = (e) collection;
        int i = eVar.c;
        if (i == 0) {
            return false;
        }
        int i2 = this.c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.b;
            if (i3 > fArr.length) {
                this.b = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(eVar.b, 0, this.b, this.c, eVar.c);
            this.c = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // com.google.protobuf.Internal.FloatList
    public void addFloat(float f) {
        a(this.c, f);
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
        if (!(obj instanceof e)) {
            return super.equals(obj);
        }
        e eVar = (e) obj;
        if (this.c != eVar.c) {
            return false;
        }
        float[] fArr = eVar.b;
        for (int i = 0; i < this.c; i++) {
            if (this.b[i] != fArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        b(i);
        return Float.valueOf(this.b[i]);
    }

    @Override // com.google.protobuf.Internal.FloatList
    public float getFloat(int i) {
        b(i);
        return this.b[i];
    }

    @Override // a2.j.i.a, java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.b[i2]);
        }
        return i;
    }

    @Override // a2.j.i.a, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        ensureIsMutable();
        for (int i = 0; i < this.c; i++) {
            if (obj.equals(Float.valueOf(this.b[i]))) {
                float[] fArr = this.b;
                System.arraycopy(fArr, i + 1, fArr, i, this.c - i);
                this.c--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // a2.j.i.a, java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        ensureIsMutable();
        b(i);
        float[] fArr = this.b;
        float f = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f);
    }

    @Override // com.google.protobuf.Internal.FloatList
    public float setFloat(int i, float f) {
        ensureIsMutable();
        b(i);
        float[] fArr = this.b;
        float f2 = fArr[i];
        fArr[i] = f;
        return f2;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public int size() {
        return this.c;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public Internal.FloatList mutableCopyWithCapacity(int i) {
        if (i >= this.c) {
            return new e(Arrays.copyOf(this.b, i), this.c);
        }
        throw new IllegalArgumentException();
    }

    public e(float[] fArr, int i) {
        this.b = fArr;
        this.c = i;
    }

    @Override // a2.j.i.a, java.util.AbstractList, java.util.List
    public Object remove(int i) {
        ensureIsMutable();
        b(i);
        float[] fArr = this.b;
        float f = fArr[i];
        System.arraycopy(fArr, i + 1, fArr, i, this.c - i);
        this.c--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f);
    }
}
