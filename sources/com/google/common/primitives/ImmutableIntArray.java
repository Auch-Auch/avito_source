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
public final class ImmutableIntArray implements Serializable {
    public static final ImmutableIntArray d = new ImmutableIntArray(new int[0]);
    public final int[] a;
    public final transient int b;
    public final int c;

    public static class b extends AbstractList<Integer> implements RandomAccess, Serializable {
        public final ImmutableIntArray a;

        public b(ImmutableIntArray immutableIntArray, a aVar) {
            this.a = immutableIntArray;
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
                if (obj2 instanceof Integer) {
                    int i2 = i + 1;
                    if (this.a.a[i] == ((Integer) obj2).intValue()) {
                        i = i2;
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i) {
            return Integer.valueOf(this.a.get(i));
        }

        @Override // java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.a.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            if (obj instanceof Integer) {
                return this.a.indexOf(((Integer) obj).intValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                return this.a.lastIndexOf(((Integer) obj).intValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return this.a.length();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Integer> subList(int i, int i2) {
            return this.a.subArray(i, i2).asList();
        }

        @Override // java.util.AbstractCollection, java.lang.Object
        public String toString() {
            return this.a.toString();
        }
    }

    public ImmutableIntArray(int[] iArr) {
        int length = iArr.length;
        this.a = iArr;
        this.b = 0;
        this.c = length;
    }

    public static Builder builder(int i) {
        Preconditions.checkArgument(i >= 0, "Invalid initialCapacity: %s", i);
        return new Builder(i);
    }

    public static ImmutableIntArray copyOf(int[] iArr) {
        return iArr.length == 0 ? d : new ImmutableIntArray(Arrays.copyOf(iArr, iArr.length));
    }

    public static ImmutableIntArray of() {
        return d;
    }

    public List<Integer> asList() {
        return new b(this, null);
    }

    public boolean contains(int i) {
        return indexOf(i) >= 0;
    }

    @Override // java.lang.Object
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableIntArray)) {
            return false;
        }
        ImmutableIntArray immutableIntArray = (ImmutableIntArray) obj;
        if (length() != immutableIntArray.length()) {
            return false;
        }
        for (int i = 0; i < length(); i++) {
            if (get(i) != immutableIntArray.get(i)) {
                return false;
            }
        }
        return true;
    }

    public int get(int i) {
        Preconditions.checkElementIndex(i, length());
        return this.a[this.b + i];
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = 1;
        for (int i2 = this.b; i2 < this.c; i2++) {
            i = (i * 31) + Ints.hashCode(this.a[i2]);
        }
        return i;
    }

    public int indexOf(int i) {
        for (int i2 = this.b; i2 < this.c; i2++) {
            if (this.a[i2] == i) {
                return i2 - this.b;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.c == this.b;
    }

    public int lastIndexOf(int i) {
        int i2 = this.c;
        while (true) {
            i2--;
            int i3 = this.b;
            if (i2 < i3) {
                return -1;
            }
            if (this.a[i2] == i) {
                return i2 - i3;
            }
        }
    }

    public int length() {
        return this.c - this.b;
    }

    public Object readResolve() {
        return isEmpty() ? d : this;
    }

    public ImmutableIntArray subArray(int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2, length());
        if (i == i2) {
            return d;
        }
        int[] iArr = this.a;
        int i3 = this.b;
        return new ImmutableIntArray(iArr, i + i3, i3 + i2);
    }

    public int[] toArray() {
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

    public ImmutableIntArray trimmed() {
        return this.b > 0 || this.c < this.a.length ? new ImmutableIntArray(toArray()) : this;
    }

    public Object writeReplace() {
        return trimmed();
    }

    public static ImmutableIntArray copyOf(Collection<Integer> collection) {
        return collection.isEmpty() ? d : new ImmutableIntArray(Ints.toArray(collection));
    }

    public static ImmutableIntArray of(int i) {
        return new ImmutableIntArray(new int[]{i});
    }

    @CanIgnoreReturnValue
    public static final class Builder {
        public int[] a;
        public int b = 0;

        public Builder(int i) {
            this.a = new int[i];
        }

        public final void a(int i) {
            int i2 = this.b + i;
            int[] iArr = this.a;
            if (i2 > iArr.length) {
                int length = iArr.length;
                if (i2 >= 0) {
                    int i3 = length + (length >> 1) + 1;
                    if (i3 < i2) {
                        i3 = Integer.highestOneBit(i2 - 1) << 1;
                    }
                    if (i3 < 0) {
                        i3 = Integer.MAX_VALUE;
                    }
                    int[] iArr2 = new int[i3];
                    System.arraycopy(this.a, 0, iArr2, 0, this.b);
                    this.a = iArr2;
                    return;
                }
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
        }

        public Builder add(int i) {
            a(1);
            int[] iArr = this.a;
            int i2 = this.b;
            iArr[i2] = i;
            this.b = i2 + 1;
            return this;
        }

        public Builder addAll(int[] iArr) {
            a(iArr.length);
            System.arraycopy(iArr, 0, this.a, this.b, iArr.length);
            this.b += iArr.length;
            return this;
        }

        @CheckReturnValue
        public ImmutableIntArray build() {
            if (this.b != 0) {
                return new ImmutableIntArray(this.a, 0, this.b, null);
            }
            ImmutableIntArray immutableIntArray = ImmutableIntArray.d;
            return ImmutableIntArray.d;
        }

        public Builder addAll(Iterable<Integer> iterable) {
            if (iterable instanceof Collection) {
                return addAll((Collection) iterable);
            }
            for (Integer num : iterable) {
                add(num.intValue());
            }
            return this;
        }

        public Builder addAll(Collection<Integer> collection) {
            a(collection.size());
            for (Integer num : collection) {
                int[] iArr = this.a;
                int i = this.b;
                this.b = i + 1;
                iArr[i] = num.intValue();
            }
            return this;
        }

        public Builder addAll(ImmutableIntArray immutableIntArray) {
            a(immutableIntArray.length());
            System.arraycopy(immutableIntArray.a, immutableIntArray.b, this.a, this.b, immutableIntArray.length());
            this.b = immutableIntArray.length() + this.b;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder(10);
    }

    public static ImmutableIntArray copyOf(Iterable<Integer> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection<Integer>) ((Collection) iterable));
        }
        return builder().addAll(iterable).build();
    }

    public static ImmutableIntArray of(int i, int i2) {
        return new ImmutableIntArray(new int[]{i, i2});
    }

    public static ImmutableIntArray of(int i, int i2, int i3) {
        return new ImmutableIntArray(new int[]{i, i2, i3});
    }

    public static ImmutableIntArray of(int i, int i2, int i3, int i4) {
        return new ImmutableIntArray(new int[]{i, i2, i3, i4});
    }

    public ImmutableIntArray(int[] iArr, int i, int i2) {
        this.a = iArr;
        this.b = i;
        this.c = i2;
    }

    public static ImmutableIntArray of(int i, int i2, int i3, int i4, int i5) {
        return new ImmutableIntArray(new int[]{i, i2, i3, i4, i5});
    }

    public static ImmutableIntArray of(int i, int i2, int i3, int i4, int i5, int i6) {
        return new ImmutableIntArray(new int[]{i, i2, i3, i4, i5, i6});
    }

    public static ImmutableIntArray of(int i, int... iArr) {
        Preconditions.checkArgument(iArr.length <= 2147483646, "the total number of elements must fit in an int");
        int[] iArr2 = new int[(iArr.length + 1)];
        iArr2[0] = i;
        System.arraycopy(iArr, 0, iArr2, 1, iArr.length);
        return new ImmutableIntArray(iArr2);
    }

    public ImmutableIntArray(int[] iArr, int i, int i2, a aVar) {
        this.a = iArr;
        this.b = i;
        this.c = i2;
    }
}
