package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public final class Longs {
    public static final int BYTES = 8;
    public static final long MAX_POWER_OF_TWO = 4611686018427387904L;

    public static final class a {
        public static final byte[] a;

        static {
            byte[] bArr = new byte[128];
            Arrays.fill(bArr, (byte) -1);
            for (int i = 0; i <= 9; i++) {
                bArr[i + 48] = (byte) i;
            }
            for (int i2 = 0; i2 <= 26; i2++) {
                byte b = (byte) (i2 + 10);
                bArr[i2 + 65] = b;
                bArr[i2 + 97] = b;
            }
            a = bArr;
        }
    }

    public enum b implements Comparator<long[]> {
        INSTANCE;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(long[] jArr, long[] jArr2) {
            long[] jArr3 = jArr;
            long[] jArr4 = jArr2;
            int min = Math.min(jArr3.length, jArr4.length);
            for (int i = 0; i < min; i++) {
                int compare = Longs.compare(jArr3[i], jArr4[i]);
                if (compare != 0) {
                    return compare;
                }
            }
            return jArr3.length - jArr4.length;
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return "Longs.lexicographicalComparator()";
        }
    }

    public static final class d extends Converter<String, Long> implements Serializable {
        public static final d c = new d();
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return c;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.Converter
        public String doBackward(Long l) {
            return l.toString();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.Converter
        public Long doForward(String str) {
            return Long.decode(str);
        }

        @Override // java.lang.Object
        public String toString() {
            return "Longs.stringConverter()";
        }
    }

    public static List<Long> asList(long... jArr) {
        if (jArr.length == 0) {
            return Collections.emptyList();
        }
        return new c(jArr);
    }

    public static int compare(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i > 0 ? 1 : 0;
    }

    public static long[] concat(long[]... jArr) {
        int i = 0;
        for (long[] jArr2 : jArr) {
            i += jArr2.length;
        }
        long[] jArr3 = new long[i];
        int i2 = 0;
        for (long[] jArr4 : jArr) {
            System.arraycopy(jArr4, 0, jArr3, i2, jArr4.length);
            i2 += jArr4.length;
        }
        return jArr3;
    }

    @Beta
    public static long constrainToRange(long j, long j2, long j3) {
        Preconditions.checkArgument(j2 <= j3, "min (%s) must be less than or equal to max (%s)", j2, j3);
        return Math.min(Math.max(j, j2), j3);
    }

    public static boolean contains(long[] jArr, long j) {
        for (long j2 : jArr) {
            if (j2 == j) {
                return true;
            }
        }
        return false;
    }

    public static long[] ensureCapacity(long[] jArr, int i, int i2) {
        boolean z = true;
        Preconditions.checkArgument(i >= 0, "Invalid minLength: %s", i);
        if (i2 < 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "Invalid padding: %s", i2);
        return jArr.length < i ? Arrays.copyOf(jArr, i + i2) : jArr;
    }

    public static long fromByteArray(byte[] bArr) {
        Preconditions.checkArgument(bArr.length >= 8, "array too small: %s < %s", bArr.length, 8);
        return fromBytes(bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5], bArr[6], bArr[7]);
    }

    public static long fromBytes(byte b2, byte b3, byte b4, byte b5, byte b6, byte b8, byte b9, byte b10) {
        return ((((long) b3) & 255) << 48) | ((((long) b2) & 255) << 56) | ((((long) b4) & 255) << 40) | ((((long) b5) & 255) << 32) | ((((long) b6) & 255) << 24) | ((((long) b8) & 255) << 16) | ((((long) b9) & 255) << 8) | (((long) b10) & 255);
    }

    public static int hashCode(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int indexOf(long[] jArr, long j) {
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            if (jArr[i] == j) {
                return i;
            }
        }
        return -1;
    }

    public static String join(String str, long... jArr) {
        Preconditions.checkNotNull(str);
        if (jArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(jArr.length * 10);
        sb.append(jArr[0]);
        for (int i = 1; i < jArr.length; i++) {
            sb.append(str);
            sb.append(jArr[i]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(long[] jArr, long j) {
        for (int length = jArr.length - 1; length >= 0; length--) {
            if (jArr[length] == j) {
                return length;
            }
        }
        return -1;
    }

    public static Comparator<long[]> lexicographicalComparator() {
        return b.INSTANCE;
    }

    public static long max(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        long j = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            if (jArr[i] > j) {
                j = jArr[i];
            }
        }
        return j;
    }

    public static long min(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        long j = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            if (jArr[i] < j) {
                j = jArr[i];
            }
        }
        return j;
    }

    public static void reverse(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        reverse(jArr, 0, jArr.length);
    }

    public static void sortDescending(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        sortDescending(jArr, 0, jArr.length);
    }

    @Beta
    public static Converter<String, Long> stringConverter() {
        return d.c;
    }

    public static long[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof c) {
            c cVar = (c) collection;
            return Arrays.copyOfRange(cVar.a, cVar.b, cVar.c);
        }
        Object[] array = collection.toArray();
        int length = array.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = ((Number) Preconditions.checkNotNull(array[i])).longValue();
        }
        return jArr;
    }

    public static byte[] toByteArray(long j) {
        byte[] bArr = new byte[8];
        for (int i = 7; i >= 0; i--) {
            bArr[i] = (byte) ((int) (255 & j));
            j >>= 8;
        }
        return bArr;
    }

    @Beta
    @NullableDecl
    public static Long tryParse(String str) {
        return tryParse(str, 10);
    }

    @Beta
    @NullableDecl
    public static Long tryParse(String str, int i) {
        Long l = null;
        if (((String) Preconditions.checkNotNull(str)).isEmpty()) {
            return null;
        }
        if (i < 2 || i > 36) {
            throw new IllegalArgumentException(a2.b.a.a.a.M2("radix must be between MIN_RADIX and MAX_RADIX but was ", i));
        }
        int i2 = 0;
        if (str.charAt(0) == '-') {
            i2 = 1;
        }
        if (i2 == str.length()) {
            return null;
        }
        int i3 = i2 + 1;
        char charAt = str.charAt(i2);
        byte[] bArr = a.a;
        char c2 = 128;
        byte b2 = charAt < 128 ? a.a[charAt] : -1;
        if (b2 < 0 || b2 >= i) {
            return null;
        }
        long j = (long) (-b2);
        long j2 = (long) i;
        long j3 = Long.MIN_VALUE / j2;
        while (i3 < str.length()) {
            int i4 = i3 + 1;
            char charAt2 = str.charAt(i3);
            byte b3 = charAt2 < c2 ? a.a[charAt2] : -1;
            if (b3 < 0 || b3 >= i || j < j3) {
                return l;
            }
            long j4 = j * j2;
            long j5 = (long) b3;
            if (j4 < j5 - Long.MIN_VALUE) {
                return null;
            }
            j = j4 - j5;
            i3 = i4;
            l = null;
            c2 = 128;
        }
        if (i2 != 0) {
            return Long.valueOf(j);
        }
        if (j == Long.MIN_VALUE) {
            return l;
        }
        return Long.valueOf(-j);
    }

    public static int indexOf(long[] jArr, long[] jArr2) {
        Preconditions.checkNotNull(jArr, "array");
        Preconditions.checkNotNull(jArr2, "target");
        if (jArr2.length == 0) {
            return 0;
        }
        for (int i = 0; i < (jArr.length - jArr2.length) + 1; i++) {
            for (int i2 = 0; i2 < jArr2.length; i2++) {
                if (jArr[i + i2] != jArr2[i2]) {
                }
            }
            return i;
        }
        return -1;
    }

    public static void reverse(long[] jArr, int i, int i2) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i, i2, jArr.length);
        for (int i3 = i2 - 1; i < i3; i3--) {
            long j = jArr[i];
            jArr[i] = jArr[i3];
            jArr[i3] = j;
            i++;
        }
    }

    public static void sortDescending(long[] jArr, int i, int i2) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i, i2, jArr.length);
        Arrays.sort(jArr, i, i2);
        reverse(jArr, i, i2);
    }

    @GwtCompatible
    public static class c extends AbstractList<Long> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        public final long[] a;
        public final int b;
        public final int c;

        public c(long[] jArr) {
            int length = jArr.length;
            this.a = jArr;
            this.b = 0;
            this.c = length;
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            if (obj instanceof Long) {
                long[] jArr = this.a;
                long longValue = ((Long) obj).longValue();
                int i = this.b;
                int i2 = this.c;
                while (true) {
                    if (i >= i2) {
                        i = -1;
                        break;
                    } else if (jArr[i] == longValue) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i != -1) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return super.equals(obj);
            }
            c cVar = (c) obj;
            int size = size();
            if (cVar.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.a[this.b + i] != cVar.a[cVar.b + i]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i) {
            Preconditions.checkElementIndex(i, size());
            return Long.valueOf(this.a[this.b + i]);
        }

        @Override // java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
        public int hashCode() {
            int i = 1;
            for (int i2 = this.b; i2 < this.c; i2++) {
                i = (i * 31) + Longs.hashCode(this.a[i2]);
            }
            return i;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            if (obj instanceof Long) {
                long[] jArr = this.a;
                long longValue = ((Long) obj).longValue();
                int i = this.b;
                int i2 = this.c;
                while (true) {
                    if (i >= i2) {
                        i = -1;
                        break;
                    } else if (jArr[i] == longValue) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i >= 0) {
                    return i - this.b;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            if (obj instanceof Long) {
                long[] jArr = this.a;
                long longValue = ((Long) obj).longValue();
                int i = this.b;
                int i2 = this.c - 1;
                while (true) {
                    if (i2 < i) {
                        i2 = -1;
                        break;
                    } else if (jArr[i2] == longValue) {
                        break;
                    } else {
                        i2--;
                    }
                }
                if (i2 >= 0) {
                    return i2 - this.b;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public Object set(int i, Object obj) {
            Preconditions.checkElementIndex(i, size());
            long[] jArr = this.a;
            int i2 = this.b + i;
            long j = jArr[i2];
            jArr[i2] = ((Long) Preconditions.checkNotNull((Long) obj)).longValue();
            return Long.valueOf(j);
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return this.c - this.b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Long> subList(int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            long[] jArr = this.a;
            int i3 = this.b;
            return new c(jArr, i + i3, i3 + i2);
        }

        @Override // java.util.AbstractCollection, java.lang.Object
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 10);
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

        public c(long[] jArr, int i, int i2) {
            this.a = jArr;
            this.b = i;
            this.c = i2;
        }
    }
}
