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
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true)
public final class Doubles {
    public static final int BYTES = 8;
    @GwtIncompatible
    public static final Pattern a = Pattern.compile(a2.b.a.a.a.f("[+-]?(?:NaN|Infinity|", a2.b.a.a.a.c3("(?:\\d+#(?:\\.\\d*#)?|\\.\\d+#)", "(?:[eE][+-]?\\d+#)?[fFdD]?"), "|", a2.b.a.a.a.e3("0[xX]", "(?:[0-9a-fA-F]+#(?:\\.[0-9a-fA-F]*#)?|\\.[0-9a-fA-F]+#)", "[pP][+-]?\\d+#[fFdD]?"), ")").replace("#", "+"));

    public static final class b extends Converter<String, Double> implements Serializable {
        public static final b c = new b();
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return c;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.Converter
        public String doBackward(Double d) {
            return d.toString();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.Converter
        public Double doForward(String str) {
            return Double.valueOf(str);
        }

        @Override // java.lang.Object
        public String toString() {
            return "Doubles.stringConverter()";
        }
    }

    public enum c implements Comparator<double[]> {
        INSTANCE;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(double[] dArr, double[] dArr2) {
            double[] dArr3 = dArr;
            double[] dArr4 = dArr2;
            int min = Math.min(dArr3.length, dArr4.length);
            for (int i = 0; i < min; i++) {
                int compare = Double.compare(dArr3[i], dArr4[i]);
                if (compare != 0) {
                    return compare;
                }
            }
            return dArr3.length - dArr4.length;
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return "Doubles.lexicographicalComparator()";
        }
    }

    public static List<Double> asList(double... dArr) {
        if (dArr.length == 0) {
            return Collections.emptyList();
        }
        return new a(dArr);
    }

    public static int compare(double d, double d2) {
        return Double.compare(d, d2);
    }

    public static double[] concat(double[]... dArr) {
        int i = 0;
        for (double[] dArr2 : dArr) {
            i += dArr2.length;
        }
        double[] dArr3 = new double[i];
        int i2 = 0;
        for (double[] dArr4 : dArr) {
            System.arraycopy(dArr4, 0, dArr3, i2, dArr4.length);
            i2 += dArr4.length;
        }
        return dArr3;
    }

    @Beta
    public static double constrainToRange(double d, double d2, double d3) {
        Preconditions.checkArgument(d2 <= d3, "min (%s) must be less than or equal to max (%s)", Double.valueOf(d2), Double.valueOf(d3));
        return Math.min(Math.max(d, d2), d3);
    }

    public static boolean contains(double[] dArr, double d) {
        for (double d2 : dArr) {
            if (d2 == d) {
                return true;
            }
        }
        return false;
    }

    public static double[] ensureCapacity(double[] dArr, int i, int i2) {
        boolean z = true;
        Preconditions.checkArgument(i >= 0, "Invalid minLength: %s", i);
        if (i2 < 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "Invalid padding: %s", i2);
        return dArr.length < i ? Arrays.copyOf(dArr, i + i2) : dArr;
    }

    public static int hashCode(double d) {
        return Double.valueOf(d).hashCode();
    }

    public static int indexOf(double[] dArr, double d) {
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            if (dArr[i] == d) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isFinite(double d) {
        return Double.NEGATIVE_INFINITY < d && d < Double.POSITIVE_INFINITY;
    }

    public static String join(String str, double... dArr) {
        Preconditions.checkNotNull(str);
        if (dArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(dArr.length * 12);
        sb.append(dArr[0]);
        for (int i = 1; i < dArr.length; i++) {
            sb.append(str);
            sb.append(dArr[i]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(double[] dArr, double d) {
        for (int length = dArr.length - 1; length >= 0; length--) {
            if (dArr[length] == d) {
                return length;
            }
        }
        return -1;
    }

    public static Comparator<double[]> lexicographicalComparator() {
        return c.INSTANCE;
    }

    public static double max(double... dArr) {
        Preconditions.checkArgument(dArr.length > 0);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            d = Math.max(d, dArr[i]);
        }
        return d;
    }

    public static double min(double... dArr) {
        Preconditions.checkArgument(dArr.length > 0);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            d = Math.min(d, dArr[i]);
        }
        return d;
    }

    public static void reverse(double[] dArr) {
        Preconditions.checkNotNull(dArr);
        reverse(dArr, 0, dArr.length);
    }

    public static void sortDescending(double[] dArr) {
        Preconditions.checkNotNull(dArr);
        sortDescending(dArr, 0, dArr.length);
    }

    @Beta
    public static Converter<String, Double> stringConverter() {
        return b.c;
    }

    public static double[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof a) {
            a aVar = (a) collection;
            return Arrays.copyOfRange(aVar.a, aVar.b, aVar.c);
        }
        Object[] array = collection.toArray();
        int length = array.length;
        double[] dArr = new double[length];
        for (int i = 0; i < length; i++) {
            dArr[i] = ((Number) Preconditions.checkNotNull(array[i])).doubleValue();
        }
        return dArr;
    }

    @Beta
    @NullableDecl
    @GwtIncompatible
    public static Double tryParse(String str) {
        if (!a.matcher(str).matches()) {
            return null;
        }
        try {
            return Double.valueOf(Double.parseDouble(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static int indexOf(double[] dArr, double[] dArr2) {
        Preconditions.checkNotNull(dArr, "array");
        Preconditions.checkNotNull(dArr2, "target");
        if (dArr2.length == 0) {
            return 0;
        }
        for (int i = 0; i < (dArr.length - dArr2.length) + 1; i++) {
            for (int i2 = 0; i2 < dArr2.length; i2++) {
                if (dArr[i + i2] != dArr2[i2]) {
                }
            }
            return i;
        }
        return -1;
    }

    public static void reverse(double[] dArr, int i, int i2) {
        Preconditions.checkNotNull(dArr);
        Preconditions.checkPositionIndexes(i, i2, dArr.length);
        for (int i3 = i2 - 1; i < i3; i3--) {
            double d = dArr[i];
            dArr[i] = dArr[i3];
            dArr[i3] = d;
            i++;
        }
    }

    public static void sortDescending(double[] dArr, int i, int i2) {
        Preconditions.checkNotNull(dArr);
        Preconditions.checkPositionIndexes(i, i2, dArr.length);
        Arrays.sort(dArr, i, i2);
        reverse(dArr, i, i2);
    }

    @GwtCompatible
    public static class a extends AbstractList<Double> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        public final double[] a;
        public final int b;
        public final int c;

        public a(double[] dArr) {
            int length = dArr.length;
            this.a = dArr;
            this.b = 0;
            this.c = length;
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            if (obj instanceof Double) {
                double[] dArr = this.a;
                double doubleValue = ((Double) obj).doubleValue();
                int i = this.b;
                int i2 = this.c;
                int i3 = Doubles.BYTES;
                while (true) {
                    if (i >= i2) {
                        i = -1;
                        break;
                    } else if (dArr[i] == doubleValue) {
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
            return Double.valueOf(this.a[this.b + i]);
        }

        @Override // java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
        public int hashCode() {
            int i = 1;
            for (int i2 = this.b; i2 < this.c; i2++) {
                i = (i * 31) + Doubles.hashCode(this.a[i2]);
            }
            return i;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            if (obj instanceof Double) {
                double[] dArr = this.a;
                double doubleValue = ((Double) obj).doubleValue();
                int i = this.b;
                int i2 = this.c;
                int i3 = Doubles.BYTES;
                while (true) {
                    if (i >= i2) {
                        i = -1;
                        break;
                    } else if (dArr[i] == doubleValue) {
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
            if (obj instanceof Double) {
                double[] dArr = this.a;
                double doubleValue = ((Double) obj).doubleValue();
                int i = this.b;
                int i2 = this.c;
                int i3 = Doubles.BYTES;
                int i4 = i2 - 1;
                while (true) {
                    if (i4 < i) {
                        i4 = -1;
                        break;
                    } else if (dArr[i4] == doubleValue) {
                        break;
                    } else {
                        i4--;
                    }
                }
                if (i4 >= 0) {
                    return i4 - this.b;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public Object set(int i, Object obj) {
            Preconditions.checkElementIndex(i, size());
            double[] dArr = this.a;
            int i2 = this.b + i;
            double d = dArr[i2];
            dArr[i2] = ((Double) Preconditions.checkNotNull((Double) obj)).doubleValue();
            return Double.valueOf(d);
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return this.c - this.b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Double> subList(int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            double[] dArr = this.a;
            int i3 = this.b;
            return new a(dArr, i + i3, i3 + i2);
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

        public a(double[] dArr, int i, int i2) {
            this.a = dArr;
            this.b = i;
            this.c = i2;
        }
    }
}
