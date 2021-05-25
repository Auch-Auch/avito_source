package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import okhttp3.HttpUrl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Immutable
@Beta
@GwtCompatible
public final class ImmutableDoubleArray implements Serializable {
    public static final ImmutableDoubleArray d = new ImmutableDoubleArray(new double[0]);
    public final double[] a;
    public final transient int b;
    public final int c;

    public static class b extends AbstractList<Double> implements RandomAccess, Serializable {
        public final ImmutableDoubleArray a;

        public b(ImmutableDoubleArray immutableDoubleArray, a aVar) {
            this.a = immutableDoubleArray;
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            return indexOf(obj) >= 0;
        }

        @Override // java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof b) {
                return this.a.equals(((b) obj).a);
            }
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            if (size() != list.size()) {
                return false;
            }
            int i = this.a.b;
            for (Object obj2 : list) {
                if (obj2 instanceof Double) {
                    int i2 = i + 1;
                    if (ImmutableDoubleArray.a(this.a.a[i], ((Double) obj2).doubleValue())) {
                        i = i2;
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i) {
            return Double.valueOf(this.a.get(i));
        }

        @Override // java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.a.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            if (obj instanceof Double) {
                return this.a.indexOf(((Double) obj).doubleValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            if (obj instanceof Double) {
                return this.a.lastIndexOf(((Double) obj).doubleValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return this.a.length();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Double> subList(int i, int i2) {
            return this.a.subArray(i, i2).asList();
        }

        @Override // java.util.AbstractCollection, java.lang.Object
        public String toString() {
            return this.a.toString();
        }
    }

    public ImmutableDoubleArray(double[] dArr) {
        int length = dArr.length;
        this.a = dArr;
        this.b = 0;
        this.c = length;
    }

    public static boolean a(double d2, double d3) {
        return Double.doubleToLongBits(d2) == Double.doubleToLongBits(d3);
    }

    public static Builder builder(int i) {
        Preconditions.checkArgument(i >= 0, "Invalid initialCapacity: %s", i);
        return new Builder(i);
    }

    public static ImmutableDoubleArray copyOf(double[] dArr) {
        if (dArr.length == 0) {
            return d;
        }
        return new ImmutableDoubleArray(Arrays.copyOf(dArr, dArr.length));
    }

    public static ImmutableDoubleArray of() {
        return d;
    }

    public List<Double> asList() {
        return new b(this, null);
    }

    public boolean contains(double d2) {
        return indexOf(d2) >= 0;
    }

    @Override // java.lang.Object
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableDoubleArray)) {
            return false;
        }
        ImmutableDoubleArray immutableDoubleArray = (ImmutableDoubleArray) obj;
        if (length() != immutableDoubleArray.length()) {
            return false;
        }
        for (int i = 0; i < length(); i++) {
            if (!a(get(i), immutableDoubleArray.get(i))) {
                return false;
            }
        }
        return true;
    }

    public double get(int i) {
        Preconditions.checkElementIndex(i, length());
        return this.a[this.b + i];
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = 1;
        for (int i2 = this.b; i2 < this.c; i2++) {
            i = (i * 31) + Doubles.hashCode(this.a[i2]);
        }
        return i;
    }

    public int indexOf(double d2) {
        for (int i = this.b; i < this.c; i++) {
            if (a(this.a[i], d2)) {
                return i - this.b;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.c == this.b;
    }

    public int lastIndexOf(double d2) {
        int i = this.c;
        while (true) {
            i--;
            if (i < this.b) {
                return -1;
            }
            if (a(this.a[i], d2)) {
                return i - this.b;
            }
        }
    }

    public int length() {
        return this.c - this.b;
    }

    public Object readResolve() {
        return isEmpty() ? d : this;
    }

    public ImmutableDoubleArray subArray(int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2, length());
        if (i == i2) {
            return d;
        }
        double[] dArr = this.a;
        int i3 = this.b;
        return new ImmutableDoubleArray(dArr, i + i3, i3 + i2);
    }

    public double[] toArray() {
        return Arrays.copyOfRange(this.a, this.b, this.c);
    }

    @Override // java.lang.Object
    public String toString() {
        if (isEmpty()) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder(length() * 5);
        sb.append('[');
        sb.append(this.a[this.b]);
        int i = this.b;
        while (true) {
            i++;
            if (i < this.c) {
                sb.append(", ");
                sb.append(this.a[i]);
            } else {
                sb.append(']');
                return sb.toString();
            }
        }
    }

    public ImmutableDoubleArray trimmed() {
        return this.b > 0 || this.c < this.a.length ? new ImmutableDoubleArray(toArray()) : this;
    }

    public Object writeReplace() {
        return trimmed();
    }

    public static ImmutableDoubleArray of(double d2) {
        return new ImmutableDoubleArray(new double[]{d2});
    }

    @CanIgnoreReturnValue
    public static final class Builder {
        public double[] a;
        public int b = 0;

        public Builder(int i) {
            this.a = new double[i];
        }

        public final void a(int i) {
            int i2 = this.b + i;
            double[] dArr = this.a;
            if (i2 > dArr.length) {
                int length = dArr.length;
                if (i2 >= 0) {
                    int i3 = length + (length >> 1) + 1;
                    if (i3 < i2) {
                        i3 = Integer.highestOneBit(i2 - 1) << 1;
                    }
                    if (i3 < 0) {
                        i3 = Integer.MAX_VALUE;
                    }
                    double[] dArr2 = new double[i3];
                    System.arraycopy(this.a, 0, dArr2, 0, this.b);
                    this.a = dArr2;
                    return;
                }
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
        }

        public Builder add(double d) {
            a(1);
            double[] dArr = this.a;
            int i = this.b;
            dArr[i] = d;
            this.b = i + 1;
            return this;
        }

        public Builder addAll(double[] dArr) {
            a(dArr.length);
            System.arraycopy(dArr, 0, this.a, this.b, dArr.length);
            this.b += dArr.length;
            return this;
        }

        @CheckReturnValue
        public ImmutableDoubleArray build() {
            if (this.b != 0) {
                return new ImmutableDoubleArray(this.a, 0, this.b, null);
            }
            ImmutableDoubleArray immutableDoubleArray = ImmutableDoubleArray.d;
            return ImmutableDoubleArray.d;
        }

        public Builder addAll(Iterable<Double> iterable) {
            if (iterable instanceof Collection) {
                return addAll((Collection) iterable);
            }
            for (Double d : iterable) {
                add(d.doubleValue());
            }
            return this;
        }

        public Builder addAll(Collection<Double> collection) {
            a(collection.size());
            for (Double d : collection) {
                double[] dArr = this.a;
                int i = this.b;
                this.b = i + 1;
                dArr[i] = d.doubleValue();
            }
            return this;
        }

        public Builder addAll(ImmutableDoubleArray immutableDoubleArray) {
            a(immutableDoubleArray.length());
            System.arraycopy(immutableDoubleArray.a, immutableDoubleArray.b, this.a, this.b, immutableDoubleArray.length());
            this.b = immutableDoubleArray.length() + this.b;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder(10);
    }

    public static ImmutableDoubleArray copyOf(Collection<Double> collection) {
        return collection.isEmpty() ? d : new ImmutableDoubleArray(Doubles.toArray(collection));
    }

    public static ImmutableDoubleArray of(double d2, double d3) {
        return new ImmutableDoubleArray(new double[]{d2, d3});
    }

    public static ImmutableDoubleArray copyOf(Iterable<Double> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection<Double>) ((Collection) iterable));
        }
        return builder().addAll(iterable).build();
    }

    public static ImmutableDoubleArray of(double d2, double d3, double d4) {
        return new ImmutableDoubleArray(new double[]{d2, d3, d4});
    }

    public static ImmutableDoubleArray of(double d2, double d3, double d4, double d5) {
        return new ImmutableDoubleArray(new double[]{d2, d3, d4, d5});
    }

    public ImmutableDoubleArray(double[] dArr, int i, int i2) {
        this.a = dArr;
        this.b = i;
        this.c = i2;
    }

    public static ImmutableDoubleArray of(double d2, double d3, double d4, double d5, double d6) {
        return new ImmutableDoubleArray(new double[]{d2, d3, d4, d5, d6});
    }

    public static ImmutableDoubleArray of(double d2, double d3, double d4, double d5, double d6, double d7) {
        return new ImmutableDoubleArray(new double[]{d2, d3, d4, d5, d6, d7});
    }

    public static ImmutableDoubleArray of(double d2, double... dArr) {
        Preconditions.checkArgument(dArr.length <= 2147483646, "the total number of elements must fit in an int");
        double[] dArr2 = new double[(dArr.length + 1)];
        dArr2[0] = d2;
        System.arraycopy(dArr, 0, dArr2, 1, dArr.length);
        return new ImmutableDoubleArray(dArr2);
    }

    public ImmutableDoubleArray(double[] dArr, int i, int i2, a aVar) {
        this.a = dArr;
        this.b = i;
        this.c = i2;
    }
}
