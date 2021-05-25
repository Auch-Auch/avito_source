package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
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
public final class Booleans {

    public enum b implements Comparator<Boolean> {
        TRUE_FIRST(1, "Booleans.trueFirst()"),
        FALSE_FIRST(-1, "Booleans.falseFirst()");
        
        public final int a;
        public final String b;

        /* access modifiers changed from: public */
        b(int i, String str) {
            this.a = i;
            this.b = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(Boolean bool, Boolean bool2) {
            Boolean bool3 = bool2;
            int i = 0;
            int i2 = bool.booleanValue() ? this.a : 0;
            if (bool3.booleanValue()) {
                i = this.a;
            }
            return i - i2;
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return this.b;
        }
    }

    public enum c implements Comparator<boolean[]> {
        INSTANCE;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(boolean[] zArr, boolean[] zArr2) {
            boolean[] zArr3 = zArr;
            boolean[] zArr4 = zArr2;
            int min = Math.min(zArr3.length, zArr4.length);
            for (int i = 0; i < min; i++) {
                int compare = Booleans.compare(zArr3[i], zArr4[i]);
                if (compare != 0) {
                    return compare;
                }
            }
            return zArr3.length - zArr4.length;
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return "Booleans.lexicographicalComparator()";
        }
    }

    public static List<Boolean> asList(boolean... zArr) {
        if (zArr.length == 0) {
            return Collections.emptyList();
        }
        return new a(zArr);
    }

    public static int compare(boolean z, boolean z2) {
        if (z == z2) {
            return 0;
        }
        return z ? 1 : -1;
    }

    public static boolean[] concat(boolean[]... zArr) {
        int i = 0;
        for (boolean[] zArr2 : zArr) {
            i += zArr2.length;
        }
        boolean[] zArr3 = new boolean[i];
        int i2 = 0;
        for (boolean[] zArr4 : zArr) {
            System.arraycopy(zArr4, 0, zArr3, i2, zArr4.length);
            i2 += zArr4.length;
        }
        return zArr3;
    }

    public static boolean contains(boolean[] zArr, boolean z) {
        for (boolean z2 : zArr) {
            if (z2 == z) {
                return true;
            }
        }
        return false;
    }

    @Beta
    public static int countTrue(boolean... zArr) {
        int i = 0;
        for (boolean z : zArr) {
            if (z) {
                i++;
            }
        }
        return i;
    }

    public static boolean[] ensureCapacity(boolean[] zArr, int i, int i2) {
        boolean z = true;
        Preconditions.checkArgument(i >= 0, "Invalid minLength: %s", i);
        if (i2 < 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "Invalid padding: %s", i2);
        return zArr.length < i ? Arrays.copyOf(zArr, i + i2) : zArr;
    }

    @Beta
    public static Comparator<Boolean> falseFirst() {
        return b.FALSE_FIRST;
    }

    public static int hashCode(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int indexOf(boolean[] zArr, boolean z) {
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            if (zArr[i] == z) {
                return i;
            }
        }
        return -1;
    }

    public static String join(String str, boolean... zArr) {
        Preconditions.checkNotNull(str);
        if (zArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(zArr.length * 7);
        sb.append(zArr[0]);
        for (int i = 1; i < zArr.length; i++) {
            sb.append(str);
            sb.append(zArr[i]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(boolean[] zArr, boolean z) {
        for (int length = zArr.length - 1; length >= 0; length--) {
            if (zArr[length] == z) {
                return length;
            }
        }
        return -1;
    }

    public static Comparator<boolean[]> lexicographicalComparator() {
        return c.INSTANCE;
    }

    public static void reverse(boolean[] zArr) {
        Preconditions.checkNotNull(zArr);
        reverse(zArr, 0, zArr.length);
    }

    public static boolean[] toArray(Collection<Boolean> collection) {
        if (collection instanceof a) {
            a aVar = (a) collection;
            return Arrays.copyOfRange(aVar.a, aVar.b, aVar.c);
        }
        Object[] array = collection.toArray();
        int length = array.length;
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            zArr[i] = ((Boolean) Preconditions.checkNotNull(array[i])).booleanValue();
        }
        return zArr;
    }

    @Beta
    public static Comparator<Boolean> trueFirst() {
        return b.TRUE_FIRST;
    }

    public static int indexOf(boolean[] zArr, boolean[] zArr2) {
        Preconditions.checkNotNull(zArr, "array");
        Preconditions.checkNotNull(zArr2, "target");
        if (zArr2.length == 0) {
            return 0;
        }
        for (int i = 0; i < (zArr.length - zArr2.length) + 1; i++) {
            for (int i2 = 0; i2 < zArr2.length; i2++) {
                if (zArr[i + i2] != zArr2[i2]) {
                }
            }
            return i;
        }
        return -1;
    }

    public static void reverse(boolean[] zArr, int i, int i2) {
        Preconditions.checkNotNull(zArr);
        Preconditions.checkPositionIndexes(i, i2, zArr.length);
        for (int i3 = i2 - 1; i < i3; i3--) {
            boolean z = zArr[i];
            zArr[i] = zArr[i3];
            zArr[i3] = z;
            i++;
        }
    }

    @GwtCompatible
    public static class a extends AbstractList<Boolean> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        public final boolean[] a;
        public final int b;
        public final int c;

        public a(boolean[] zArr) {
            int length = zArr.length;
            this.a = zArr;
            this.b = 0;
            this.c = length;
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            if (obj instanceof Boolean) {
                boolean[] zArr = this.a;
                boolean booleanValue = ((Boolean) obj).booleanValue();
                int i = this.b;
                int i2 = this.c;
                while (true) {
                    if (i >= i2) {
                        i = -1;
                        break;
                    } else if (zArr[i] == booleanValue) {
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
            if (!(obj instanceof a)) {
                return super.equals(obj);
            }
            a aVar = (a) obj;
            int size = size();
            if (aVar.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.a[this.b + i] != aVar.a[aVar.b + i]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i) {
            Preconditions.checkElementIndex(i, size());
            return Boolean.valueOf(this.a[this.b + i]);
        }

        @Override // java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
        public int hashCode() {
            int i = 1;
            for (int i2 = this.b; i2 < this.c; i2++) {
                i = (i * 31) + Booleans.hashCode(this.a[i2]);
            }
            return i;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            if (obj instanceof Boolean) {
                boolean[] zArr = this.a;
                boolean booleanValue = ((Boolean) obj).booleanValue();
                int i = this.b;
                int i2 = this.c;
                while (true) {
                    if (i >= i2) {
                        i = -1;
                        break;
                    } else if (zArr[i] == booleanValue) {
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
            if (obj instanceof Boolean) {
                boolean[] zArr = this.a;
                boolean booleanValue = ((Boolean) obj).booleanValue();
                int i = this.b;
                int i2 = this.c - 1;
                while (true) {
                    if (i2 < i) {
                        i2 = -1;
                        break;
                    } else if (zArr[i2] == booleanValue) {
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
            boolean[] zArr = this.a;
            int i2 = this.b + i;
            boolean z = zArr[i2];
            zArr[i2] = ((Boolean) Preconditions.checkNotNull((Boolean) obj)).booleanValue();
            return Boolean.valueOf(z);
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return this.c - this.b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Boolean> subList(int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            boolean[] zArr = this.a;
            int i3 = this.b;
            return new a(zArr, i + i3, i3 + i2);
        }

        @Override // java.util.AbstractCollection, java.lang.Object
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 7);
            sb.append(this.a[this.b] ? "[true" : "[false");
            int i = this.b;
            while (true) {
                i++;
                if (i < this.c) {
                    sb.append(this.a[i] ? ", true" : ", false");
                } else {
                    sb.append(']');
                    return sb.toString();
                }
            }
        }

        public a(boolean[] zArr, int i, int i2) {
            this.a = zArr;
            this.b = i;
            this.c = i2;
        }
    }
}
