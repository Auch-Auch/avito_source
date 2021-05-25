package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
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
@GwtCompatible(emulated = true)
public final class Floats {
    public static final int BYTES = 4;

    public static final class b extends Converter<String, Float> implements Serializable {
        public static final b c = new b();
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return c;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.Converter
        public String doBackward(Float f) {
            return f.toString();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.Converter
        public Float doForward(String str) {
            return Float.valueOf(str);
        }

        @Override // java.lang.Object
        public String toString() {
            return "Floats.stringConverter()";
        }
    }

    public enum c implements Comparator<float[]> {
        INSTANCE;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(float[] fArr, float[] fArr2) {
            float[] fArr3 = fArr;
            float[] fArr4 = fArr2;
            int min = Math.min(fArr3.length, fArr4.length);
            for (int i = 0; i < min; i++) {
                int compare = Float.compare(fArr3[i], fArr4[i]);
                if (compare != 0) {
                    return compare;
                }
            }
            return fArr3.length - fArr4.length;
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return "Floats.lexicographicalComparator()";
        }
    }

    public static List<Float> asList(float... fArr) {
        if (fArr.length == 0) {
            return Collections.emptyList();
        }
        return new a(fArr);
    }

    public static int compare(float f, float f2) {
        return Float.compare(f, f2);
    }

    public static float[] concat(float[]... fArr) {
        int i = 0;
        for (float[] fArr2 : fArr) {
            i += fArr2.length;
        }
        float[] fArr3 = new float[i];
        int i2 = 0;
        for (float[] fArr4 : fArr) {
            System.arraycopy(fArr4, 0, fArr3, i2, fArr4.length);
            i2 += fArr4.length;
        }
        return fArr3;
    }

    @Beta
    public static float constrainToRange(float f, float f2, float f3) {
        Preconditions.checkArgument(f2 <= f3, "min (%s) must be less than or equal to max (%s)", Float.valueOf(f2), Float.valueOf(f3));
        return Math.min(Math.max(f, f2), f3);
    }

    public static boolean contains(float[] fArr, float f) {
        for (float f2 : fArr) {
            if (f2 == f) {
                return true;
            }
        }
        return false;
    }

    public static float[] ensureCapacity(float[] fArr, int i, int i2) {
        boolean z = true;
        Preconditions.checkArgument(i >= 0, "Invalid minLength: %s", i);
        if (i2 < 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "Invalid padding: %s", i2);
        return fArr.length < i ? Arrays.copyOf(fArr, i + i2) : fArr;
    }

    public static int hashCode(float f) {
        return Float.valueOf(f).hashCode();
    }

    public static int indexOf(float[] fArr, float f) {
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            if (fArr[i] == f) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isFinite(float f) {
        return Float.NEGATIVE_INFINITY < f && f < Float.POSITIVE_INFINITY;
    }

    public static String join(String str, float... fArr) {
        Preconditions.checkNotNull(str);
        if (fArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(fArr.length * 12);
        sb.append(fArr[0]);
        for (int i = 1; i < fArr.length; i++) {
            sb.append(str);
            sb.append(fArr[i]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(float[] fArr, float f) {
        for (int length = fArr.length - 1; length >= 0; length--) {
            if (fArr[length] == f) {
                return length;
            }
        }
        return -1;
    }

    public static Comparator<float[]> lexicographicalComparator() {
        return c.INSTANCE;
    }

    public static float max(float... fArr) {
        Preconditions.checkArgument(fArr.length > 0);
        float f = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            f = Math.max(f, fArr[i]);
        }
        return f;
    }

    public static float min(float... fArr) {
        Preconditions.checkArgument(fArr.length > 0);
        float f = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            f = Math.min(f, fArr[i]);
        }
        return f;
    }

    public static void reverse(float[] fArr) {
        Preconditions.checkNotNull(fArr);
        reverse(fArr, 0, fArr.length);
    }

    public static void sortDescending(float[] fArr) {
        Preconditions.checkNotNull(fArr);
        sortDescending(fArr, 0, fArr.length);
    }

    @Beta
    public static Converter<String, Float> stringConverter() {
        return b.c;
    }

    public static float[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof a) {
            a aVar = (a) collection;
            return Arrays.copyOfRange(aVar.a, aVar.b, aVar.c);
        }
        Object[] array = collection.toArray();
        int length = array.length;
        float[] fArr = new float[length];
        for (int i = 0; i < length; i++) {
            fArr[i] = ((Number) Preconditions.checkNotNull(array[i])).floatValue();
        }
        return fArr;
    }

    @Beta
    @NullableDecl
    @GwtIncompatible
    public static Float tryParse(String str) {
        if (!Doubles.a.matcher(str).matches()) {
            return null;
        }
        try {
            return Float.valueOf(Float.parseFloat(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static int indexOf(float[] fArr, float[] fArr2) {
        Preconditions.checkNotNull(fArr, "array");
        Preconditions.checkNotNull(fArr2, "target");
        if (fArr2.length == 0) {
            return 0;
        }
        for (int i = 0; i < (fArr.length - fArr2.length) + 1; i++) {
            for (int i2 = 0; i2 < fArr2.length; i2++) {
                if (fArr[i + i2] != fArr2[i2]) {
                }
            }
            return i;
        }
        return -1;
    }

    public static void reverse(float[] fArr, int i, int i2) {
        Preconditions.checkNotNull(fArr);
        Preconditions.checkPositionIndexes(i, i2, fArr.length);
        for (int i3 = i2 - 1; i < i3; i3--) {
            float f = fArr[i];
            fArr[i] = fArr[i3];
            fArr[i3] = f;
            i++;
        }
    }

    public static void sortDescending(float[] fArr, int i, int i2) {
        Preconditions.checkNotNull(fArr);
        Preconditions.checkPositionIndexes(i, i2, fArr.length);
        Arrays.sort(fArr, i, i2);
        reverse(fArr, i, i2);
    }

    @GwtCompatible
    public static class a extends AbstractList<Float> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        public final float[] a;
        public final int b;
        public final int c;

        public a(float[] fArr) {
            int length = fArr.length;
            this.a = fArr;
            this.b = 0;
            this.c = length;
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            if (obj instanceof Float) {
                float[] fArr = this.a;
                float floatValue = ((Float) obj).floatValue();
                int i = this.b;
                int i2 = this.c;
                while (true) {
                    if (i >= i2) {
                        i = -1;
                        break;
                    } else if (fArr[i] == floatValue) {
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
            return Float.valueOf(this.a[this.b + i]);
        }

        @Override // java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
        public int hashCode() {
            int i = 1;
            for (int i2 = this.b; i2 < this.c; i2++) {
                i = (i * 31) + Floats.hashCode(this.a[i2]);
            }
            return i;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            if (obj instanceof Float) {
                float[] fArr = this.a;
                float floatValue = ((Float) obj).floatValue();
                int i = this.b;
                int i2 = this.c;
                while (true) {
                    if (i >= i2) {
                        i = -1;
                        break;
                    } else if (fArr[i] == floatValue) {
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
            if (obj instanceof Float) {
                float[] fArr = this.a;
                float floatValue = ((Float) obj).floatValue();
                int i = this.b;
                int i2 = this.c - 1;
                while (true) {
                    if (i2 < i) {
                        i2 = -1;
                        break;
                    } else if (fArr[i2] == floatValue) {
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
            float[] fArr = this.a;
            int i2 = this.b + i;
            float f = fArr[i2];
            fArr[i2] = ((Float) Preconditions.checkNotNull((Float) obj)).floatValue();
            return Float.valueOf(f);
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return this.c - this.b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Float> subList(int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            float[] fArr = this.a;
            int i3 = this.b;
            return new a(fArr, i + i3, i3 + i2);
        }

        @Override // java.util.AbstractCollection, java.lang.Object
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 12);
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

        public a(float[] fArr, int i, int i2) {
            this.a = fArr;
            this.b = i;
            this.c = i2;
        }
    }
}
