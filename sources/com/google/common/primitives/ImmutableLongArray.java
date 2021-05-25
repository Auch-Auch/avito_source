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
public final class ImmutableLongArray implements Serializable {
    public static final ImmutableLongArray d = new ImmutableLongArray(new long[0]);
    public final long[] a;
    public final transient int b;
    public final int c;

    public static class b extends AbstractList<Long> implements RandomAccess, Serializable {
        public final ImmutableLongArray a;

        public b(ImmutableLongArray immutableLongArray, a aVar) {
            this.a = immutableLongArray;
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
                if (obj2 instanceof Long) {
                    int i2 = i + 1;
                    if (this.a.a[i] == ((Long) obj2).longValue()) {
                        i = i2;
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i) {
            return Long.valueOf(this.a.get(i));
        }

        @Override // java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
        public int hashCode() {
            return this.a.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            if (obj instanceof Long) {
                return this.a.indexOf(((Long) obj).longValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            if (obj instanceof Long) {
                return this.a.lastIndexOf(((Long) obj).longValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return this.a.length();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Long> subList(int i, int i2) {
            return this.a.subArray(i, i2).asList();
        }

        @Override // java.util.AbstractCollection, java.lang.Object
        public String toString() {
            return this.a.toString();
        }
    }

    public ImmutableLongArray(long[] jArr) {
        int length = jArr.length;
        this.a = jArr;
        this.b = 0;
        this.c = length;
    }

    public static Builder builder(int i) {
        Preconditions.checkArgument(i >= 0, "Invalid initialCapacity: %s", i);
        return new Builder(i);
    }

    public static ImmutableLongArray copyOf(long[] jArr) {
        if (jArr.length == 0) {
            return d;
        }
        return new ImmutableLongArray(Arrays.copyOf(jArr, jArr.length));
    }

    public static ImmutableLongArray of() {
        return d;
    }

    public List<Long> asList() {
        return new b(this, null);
    }

    public boolean contains(long j) {
        return indexOf(j) >= 0;
    }

    @Override // java.lang.Object
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableLongArray)) {
            return false;
        }
        ImmutableLongArray immutableLongArray = (ImmutableLongArray) obj;
        if (length() != immutableLongArray.length()) {
            return false;
        }
        for (int i = 0; i < length(); i++) {
            if (get(i) != immutableLongArray.get(i)) {
                return false;
            }
        }
        return true;
    }

    public long get(int i) {
        Preconditions.checkElementIndex(i, length());
        return this.a[this.b + i];
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = 1;
        for (int i2 = this.b; i2 < this.c; i2++) {
            i = (i * 31) + Longs.hashCode(this.a[i2]);
        }
        return i;
    }

    public int indexOf(long j) {
        for (int i = this.b; i < this.c; i++) {
            if (this.a[i] == j) {
                return i - this.b;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.c == this.b;
    }

    public int lastIndexOf(long j) {
        int i = this.c;
        while (true) {
            i--;
            int i2 = this.b;
            if (i < i2) {
                return -1;
            }
            if (this.a[i] == j) {
                return i - i2;
            }
        }
    }

    public int length() {
        return this.c - this.b;
    }

    public Object readResolve() {
        return isEmpty() ? d : this;
    }

    public ImmutableLongArray subArray(int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2, length());
        if (i == i2) {
            return d;
        }
        long[] jArr = this.a;
        int i3 = this.b;
        return new ImmutableLongArray(jArr, i + i3, i3 + i2);
    }

    public long[] toArray() {
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

    public ImmutableLongArray trimmed() {
        return this.b > 0 || this.c < this.a.length ? new ImmutableLongArray(toArray()) : this;
    }

    public Object writeReplace() {
        return trimmed();
    }

    public static ImmutableLongArray of(long j) {
        return new ImmutableLongArray(new long[]{j});
    }

    @CanIgnoreReturnValue
    public static final class Builder {
        public long[] a;
        public int b = 0;

        public Builder(int i) {
            this.a = new long[i];
        }

        public final void a(int i) {
            int i2 = this.b + i;
            long[] jArr = this.a;
            if (i2 > jArr.length) {
                int length = jArr.length;
                if (i2 >= 0) {
                    int i3 = length + (length >> 1) + 1;
                    if (i3 < i2) {
                        i3 = Integer.highestOneBit(i2 - 1) << 1;
                    }
                    if (i3 < 0) {
                        i3 = Integer.MAX_VALUE;
                    }
                    long[] jArr2 = new long[i3];
                    System.arraycopy(this.a, 0, jArr2, 0, this.b);
                    this.a = jArr2;
                    return;
                }
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
        }

        public Builder add(long j) {
            a(1);
            long[] jArr = this.a;
            int i = this.b;
            jArr[i] = j;
            this.b = i + 1;
            return this;
        }

        public Builder addAll(long[] jArr) {
            a(jArr.length);
            System.arraycopy(jArr, 0, this.a, this.b, jArr.length);
            this.b += jArr.length;
            return this;
        }

        @CheckReturnValue
        public ImmutableLongArray build() {
            if (this.b != 0) {
                return new ImmutableLongArray(this.a, 0, this.b, null);
            }
            ImmutableLongArray immutableLongArray = ImmutableLongArray.d;
            return ImmutableLongArray.d;
        }

        public Builder addAll(Iterable<Long> iterable) {
            if (iterable instanceof Collection) {
                return addAll((Collection) iterable);
            }
            for (Long l : iterable) {
                add(l.longValue());
            }
            return this;
        }

        public Builder addAll(Collection<Long> collection) {
            a(collection.size());
            for (Long l : collection) {
                long[] jArr = this.a;
                int i = this.b;
                this.b = i + 1;
                jArr[i] = l.longValue();
            }
            return this;
        }

        public Builder addAll(ImmutableLongArray immutableLongArray) {
            a(immutableLongArray.length());
            System.arraycopy(immutableLongArray.a, immutableLongArray.b, this.a, this.b, immutableLongArray.length());
            this.b = immutableLongArray.length() + this.b;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder(10);
    }

    public static ImmutableLongArray copyOf(Collection<Long> collection) {
        return collection.isEmpty() ? d : new ImmutableLongArray(Longs.toArray(collection));
    }

    public static ImmutableLongArray of(long j, long j2) {
        return new ImmutableLongArray(new long[]{j, j2});
    }

    public static ImmutableLongArray copyOf(Iterable<Long> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection<Long>) ((Collection) iterable));
        }
        return builder().addAll(iterable).build();
    }

    public static ImmutableLongArray of(long j, long j2, long j3) {
        return new ImmutableLongArray(new long[]{j, j2, j3});
    }

    public static ImmutableLongArray of(long j, long j2, long j3, long j4) {
        return new ImmutableLongArray(new long[]{j, j2, j3, j4});
    }

    public ImmutableLongArray(long[] jArr, int i, int i2) {
        this.a = jArr;
        this.b = i;
        this.c = i2;
    }

    public static ImmutableLongArray of(long j, long j2, long j3, long j4, long j5) {
        return new ImmutableLongArray(new long[]{j, j2, j3, j4, j5});
    }

    public static ImmutableLongArray of(long j, long j2, long j3, long j4, long j5, long j6) {
        return new ImmutableLongArray(new long[]{j, j2, j3, j4, j5, j6});
    }

    public static ImmutableLongArray of(long j, long... jArr) {
        Preconditions.checkArgument(jArr.length <= 2147483646, "the total number of elements must fit in an int");
        long[] jArr2 = new long[(jArr.length + 1)];
        jArr2[0] = j;
        System.arraycopy(jArr, 0, jArr2, 1, jArr.length);
        return new ImmutableLongArray(jArr2);
    }

    public ImmutableLongArray(long[] jArr, int i, int i2, a aVar) {
        this.a = jArr;
        this.b = i;
        this.c = i2;
    }
}
