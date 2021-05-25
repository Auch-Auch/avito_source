package kotlin.collections;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.b;
import t6.n.c;
public class ArraysKt___ArraysJvmKt extends c {
    @NotNull
    public static final <T> List<T> asList(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$asList");
        List<T> asList = Arrays.asList(tArr);
        Intrinsics.checkNotNullExpressionValue(asList, "ArraysUtilJVM.asList(this)");
        return asList;
    }

    public static final <T> int binarySearch(@NotNull T[] tArr, T t, @NotNull Comparator<? super T> comparator, int i, int i2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$binarySearch");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return Arrays.binarySearch(tArr, i, i2, t, comparator);
    }

    public static /* synthetic */ int binarySearch$default(Object[] objArr, Object obj, Comparator comparator, int i, int i2, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = objArr.length;
        }
        return binarySearch(objArr, obj, comparator, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <T> T[] copyInto(@NotNull T[] tArr, @NotNull T[] tArr2, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(tArr, "$this$copyInto");
        Intrinsics.checkNotNullParameter(tArr2, "destination");
        System.arraycopy(tArr, i2, tArr2, i, i3 - i2);
        return tArr2;
    }

    public static /* synthetic */ Object[] copyInto$default(Object[] objArr, Object[] objArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        return copyInto(objArr, objArr2, i, i2, i3);
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @NotNull
    @PublishedApi
    public static final <T> T[] copyOfRange(@NotNull T[] tArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$copyOfRangeImpl");
        b.copyOfRangeToIndexCheck(i2, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i, i2);
        Intrinsics.checkNotNullExpressionValue(tArr2, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return tArr2;
    }

    public static final <T> void fill(@NotNull T[] tArr, T t, int i, int i2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$fill");
        Arrays.fill(tArr, i, i2, t);
    }

    public static /* synthetic */ void fill$default(Object[] objArr, Object obj, int i, int i2, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        fill(objArr, obj, i, i2);
    }

    @NotNull
    public static final <R> List<R> filterIsInstance(@NotNull Object[] objArr, @NotNull Class<R> cls) {
        Intrinsics.checkNotNullParameter(objArr, "$this$filterIsInstance");
        Intrinsics.checkNotNullParameter(cls, "klass");
        return (List) filterIsInstanceTo(objArr, new ArrayList(), cls);
    }

    @NotNull
    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(@NotNull Object[] objArr, @NotNull C c, @NotNull Class<R> cls) {
        Intrinsics.checkNotNullParameter(objArr, "$this$filterIsInstanceTo");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(cls, "klass");
        for (Object obj : objArr) {
            if (cls.isInstance(obj)) {
                c.add(obj);
            }
        }
        return c;
    }

    @NotNull
    public static final <T> T[] plus(@NotNull T[] tArr, T t) {
        Intrinsics.checkNotNullParameter(tArr, "$this$plus");
        int length = tArr.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, length + 1);
        tArr2[length] = t;
        Intrinsics.checkNotNullExpressionValue(tArr2, "result");
        return tArr2;
    }

    public static final void sort(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$sort");
        if (iArr.length > 1) {
            Arrays.sort(iArr);
        }
    }

    public static /* synthetic */ void sort$default(Comparable[] comparableArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = comparableArr.length;
        }
        sort(comparableArr, i, i2);
    }

    public static final <T> void sortWith(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "$this$sortWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }

    public static /* synthetic */ void sortWith$default(Object[] objArr, Comparator comparator, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        sortWith(objArr, comparator, i, i2);
    }

    @NotNull
    public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$toSortedSet");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(tArr, new TreeSet());
    }

    @NotNull
    public static final Byte[] toTypedArray(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$toTypedArray");
        Byte[] bArr2 = new Byte[bArr.length];
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            bArr2[i] = Byte.valueOf(bArr[i]);
        }
        return bArr2;
    }

    public static final <T> int binarySearch(@NotNull T[] tArr, T t, int i, int i2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$binarySearch");
        return Arrays.binarySearch(tArr, i, i2, t);
    }

    public static /* synthetic */ int binarySearch$default(Object[] objArr, Object obj, int i, int i2, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        return binarySearch(objArr, obj, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final byte[] copyInto(@NotNull byte[] bArr, @NotNull byte[] bArr2, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "$this$copyInto");
        Intrinsics.checkNotNullParameter(bArr2, "destination");
        System.arraycopy(bArr, i2, bArr2, i, i3 - i2);
        return bArr2;
    }

    public static /* synthetic */ byte[] copyInto$default(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = bArr.length;
        }
        return copyInto(bArr, bArr2, i, i2, i3);
    }

    public static final void fill(@NotNull byte[] bArr, byte b, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$fill");
        Arrays.fill(bArr, i, i2, b);
    }

    public static /* synthetic */ void fill$default(byte[] bArr, byte b, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        fill(bArr, b, i, i2);
    }

    public static final void sort(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$sort");
        if (jArr.length > 1) {
            Arrays.sort(jArr);
        }
    }

    public static /* synthetic */ void sort$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        sort(bArr, i, i2);
    }

    public static final <T> void sortWith(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator, int i, int i2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$sortWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Arrays.sort(tArr, i, i2, comparator);
    }

    @NotNull
    public static final SortedSet<Byte> toSortedSet(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$toSortedSet");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(bArr, new TreeSet());
    }

    @NotNull
    public static final List<Byte> asList(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$asList");
        return new RandomAccess(bArr) { // from class: kotlin.collections.ArraysKt___ArraysJvmKt$asList$1
            public final /* synthetic */ byte[] a;

            {
                this.a = r1;
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection
            public final /* bridge */ boolean contains(Object obj) {
                if (obj instanceof Byte) {
                    return contains(((Number) obj).byteValue());
                }
                return false;
            }

            @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
            public int getSize() {
                return this.a.length;
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int indexOf(Object obj) {
                if (obj instanceof Byte) {
                    return indexOf(((Number) obj).byteValue());
                }
                return -1;
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection
            public boolean isEmpty() {
                return this.a.length == 0;
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int lastIndexOf(Object obj) {
                if (obj instanceof Byte) {
                    return lastIndexOf(((Number) obj).byteValue());
                }
                return -1;
            }

            public boolean contains(byte b) {
                return ArraysKt___ArraysKt.contains(this.a, b);
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            @NotNull
            public Byte get(int i) {
                return Byte.valueOf(this.a[i]);
            }

            public int indexOf(byte b) {
                return ArraysKt___ArraysKt.indexOf(this.a, b);
            }

            public int lastIndexOf(byte b) {
                return ArraysKt___ArraysKt.lastIndexOf(this.a, b);
            }
        };
    }

    public static final int binarySearch(@NotNull byte[] bArr, byte b, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$binarySearch");
        return Arrays.binarySearch(bArr, i, i2, b);
    }

    public static /* synthetic */ int binarySearch$default(byte[] bArr, byte b, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return binarySearch(bArr, b, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final short[] copyInto(@NotNull short[] sArr, @NotNull short[] sArr2, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(sArr, "$this$copyInto");
        Intrinsics.checkNotNullParameter(sArr2, "destination");
        System.arraycopy(sArr, i2, sArr2, i, i3 - i2);
        return sArr2;
    }

    public static /* synthetic */ short[] copyInto$default(short[] sArr, short[] sArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = sArr.length;
        }
        return copyInto(sArr, sArr2, i, i2, i3);
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @NotNull
    @PublishedApi
    public static final byte[] copyOfRange(@NotNull byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$copyOfRangeImpl");
        b.copyOfRangeToIndexCheck(i2, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i, i2);
        Intrinsics.checkNotNullExpressionValue(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    public static final void fill(@NotNull short[] sArr, short s, int i, int i2) {
        Intrinsics.checkNotNullParameter(sArr, "$this$fill");
        Arrays.fill(sArr, i, i2, s);
    }

    public static /* synthetic */ void fill$default(short[] sArr, short s, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length;
        }
        fill(sArr, s, i, i2);
    }

    public static final void sort(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$sort");
        if (bArr.length > 1) {
            Arrays.sort(bArr);
        }
    }

    public static /* synthetic */ void sort$default(short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = sArr.length;
        }
        sort(sArr, i, i2);
    }

    @NotNull
    public static final SortedSet<Short> toSortedSet(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$toSortedSet");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(sArr, new TreeSet());
    }

    @NotNull
    public static final List<Short> asList(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$asList");
        return new RandomAccess(sArr) { // from class: kotlin.collections.ArraysKt___ArraysJvmKt$asList$2
            public final /* synthetic */ short[] a;

            {
                this.a = r1;
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection
            public final /* bridge */ boolean contains(Object obj) {
                if (obj instanceof Short) {
                    return contains(((Number) obj).shortValue());
                }
                return false;
            }

            @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
            public int getSize() {
                return this.a.length;
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int indexOf(Object obj) {
                if (obj instanceof Short) {
                    return indexOf(((Number) obj).shortValue());
                }
                return -1;
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection
            public boolean isEmpty() {
                return this.a.length == 0;
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int lastIndexOf(Object obj) {
                if (obj instanceof Short) {
                    return lastIndexOf(((Number) obj).shortValue());
                }
                return -1;
            }

            public boolean contains(short s) {
                return ArraysKt___ArraysKt.contains(this.a, s);
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            @NotNull
            public Short get(int i) {
                return Short.valueOf(this.a[i]);
            }

            public int indexOf(short s) {
                return ArraysKt___ArraysKt.indexOf(this.a, s);
            }

            public int lastIndexOf(short s) {
                return ArraysKt___ArraysKt.lastIndexOf(this.a, s);
            }
        };
    }

    public static final int binarySearch(@NotNull short[] sArr, short s, int i, int i2) {
        Intrinsics.checkNotNullParameter(sArr, "$this$binarySearch");
        return Arrays.binarySearch(sArr, i, i2, s);
    }

    public static /* synthetic */ int binarySearch$default(short[] sArr, short s, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length;
        }
        return binarySearch(sArr, s, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final int[] copyInto(@NotNull int[] iArr, @NotNull int[] iArr2, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "$this$copyInto");
        Intrinsics.checkNotNullParameter(iArr2, "destination");
        System.arraycopy(iArr, i2, iArr2, i, i3 - i2);
        return iArr2;
    }

    public static /* synthetic */ int[] copyInto$default(int[] iArr, int[] iArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = iArr.length;
        }
        return copyInto(iArr, iArr2, i, i2, i3);
    }

    public static final void fill(@NotNull int[] iArr, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "$this$fill");
        Arrays.fill(iArr, i2, i3, i);
    }

    public static /* synthetic */ void fill$default(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = iArr.length;
        }
        fill(iArr, i, i2, i3);
    }

    public static final void sort(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$sort");
        if (sArr.length > 1) {
            Arrays.sort(sArr);
        }
    }

    public static /* synthetic */ void sort$default(int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = iArr.length;
        }
        sort(iArr, i, i2);
    }

    @NotNull
    public static final SortedSet<Integer> toSortedSet(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$toSortedSet");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(iArr, new TreeSet());
    }

    @NotNull
    public static final Short[] toTypedArray(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$toTypedArray");
        Short[] shArr = new Short[sArr.length];
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            shArr[i] = Short.valueOf(sArr[i]);
        }
        return shArr;
    }

    @NotNull
    public static final List<Integer> asList(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$asList");
        return new RandomAccess(iArr) { // from class: kotlin.collections.ArraysKt___ArraysJvmKt$asList$3
            public final /* synthetic */ int[] a;

            {
                this.a = r1;
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection
            public final /* bridge */ boolean contains(Object obj) {
                if (obj instanceof Integer) {
                    return contains(((Number) obj).intValue());
                }
                return false;
            }

            @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
            public int getSize() {
                return this.a.length;
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int indexOf(Object obj) {
                if (obj instanceof Integer) {
                    return indexOf(((Number) obj).intValue());
                }
                return -1;
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection
            public boolean isEmpty() {
                return this.a.length == 0;
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int lastIndexOf(Object obj) {
                if (obj instanceof Integer) {
                    return lastIndexOf(((Number) obj).intValue());
                }
                return -1;
            }

            public boolean contains(int i) {
                return ArraysKt___ArraysKt.contains(this.a, i);
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            @NotNull
            public Integer get(int i) {
                return Integer.valueOf(this.a[i]);
            }

            public int indexOf(int i) {
                return ArraysKt___ArraysKt.indexOf(this.a, i);
            }

            public int lastIndexOf(int i) {
                return ArraysKt___ArraysKt.lastIndexOf(this.a, i);
            }
        };
    }

    public static final int binarySearch(@NotNull int[] iArr, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "$this$binarySearch");
        return Arrays.binarySearch(iArr, i2, i3, i);
    }

    public static /* synthetic */ int binarySearch$default(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = iArr.length;
        }
        return binarySearch(iArr, i, i2, i3);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final long[] copyInto(@NotNull long[] jArr, @NotNull long[] jArr2, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(jArr, "$this$copyInto");
        Intrinsics.checkNotNullParameter(jArr2, "destination");
        System.arraycopy(jArr, i2, jArr2, i, i3 - i2);
        return jArr2;
    }

    public static /* synthetic */ long[] copyInto$default(long[] jArr, long[] jArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = jArr.length;
        }
        return copyInto(jArr, jArr2, i, i2, i3);
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @NotNull
    @PublishedApi
    public static final short[] copyOfRange(@NotNull short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(sArr, "$this$copyOfRangeImpl");
        b.copyOfRangeToIndexCheck(i2, sArr.length);
        short[] copyOfRange = Arrays.copyOfRange(sArr, i, i2);
        Intrinsics.checkNotNullExpressionValue(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    public static final void fill(@NotNull long[] jArr, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(jArr, "$this$fill");
        Arrays.fill(jArr, i, i2, j);
    }

    public static /* synthetic */ void fill$default(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length;
        }
        fill(jArr, j, i, i2);
    }

    @NotNull
    public static final byte[] plus(@NotNull byte[] bArr, byte b) {
        Intrinsics.checkNotNullParameter(bArr, "$this$plus");
        int length = bArr.length;
        byte[] copyOf = Arrays.copyOf(bArr, length + 1);
        copyOf[length] = b;
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    public static final void sort(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$sort");
        if (dArr.length > 1) {
            Arrays.sort(dArr);
        }
    }

    public static /* synthetic */ void sort$default(long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = jArr.length;
        }
        sort(jArr, i, i2);
    }

    @NotNull
    public static final SortedSet<Long> toSortedSet(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$toSortedSet");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(jArr, new TreeSet());
    }

    @NotNull
    public static final List<Long> asList(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$asList");
        return new RandomAccess(jArr) { // from class: kotlin.collections.ArraysKt___ArraysJvmKt$asList$4
            public final /* synthetic */ long[] a;

            {
                this.a = r1;
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection
            public final /* bridge */ boolean contains(Object obj) {
                if (obj instanceof Long) {
                    return contains(((Number) obj).longValue());
                }
                return false;
            }

            @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
            public int getSize() {
                return this.a.length;
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int indexOf(Object obj) {
                if (obj instanceof Long) {
                    return indexOf(((Number) obj).longValue());
                }
                return -1;
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection
            public boolean isEmpty() {
                return this.a.length == 0;
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int lastIndexOf(Object obj) {
                if (obj instanceof Long) {
                    return lastIndexOf(((Number) obj).longValue());
                }
                return -1;
            }

            public boolean contains(long j) {
                return ArraysKt___ArraysKt.contains(this.a, j);
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            @NotNull
            public Long get(int i) {
                return Long.valueOf(this.a[i]);
            }

            public int indexOf(long j) {
                return ArraysKt___ArraysKt.indexOf(this.a, j);
            }

            public int lastIndexOf(long j) {
                return ArraysKt___ArraysKt.lastIndexOf(this.a, j);
            }
        };
    }

    public static final int binarySearch(@NotNull long[] jArr, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(jArr, "$this$binarySearch");
        return Arrays.binarySearch(jArr, i, i2, j);
    }

    public static /* synthetic */ int binarySearch$default(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length;
        }
        return binarySearch(jArr, j, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final float[] copyInto(@NotNull float[] fArr, @NotNull float[] fArr2, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(fArr, "$this$copyInto");
        Intrinsics.checkNotNullParameter(fArr2, "destination");
        System.arraycopy(fArr, i2, fArr2, i, i3 - i2);
        return fArr2;
    }

    public static /* synthetic */ float[] copyInto$default(float[] fArr, float[] fArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = fArr.length;
        }
        return copyInto(fArr, fArr2, i, i2, i3);
    }

    public static final void fill(@NotNull float[] fArr, float f, int i, int i2) {
        Intrinsics.checkNotNullParameter(fArr, "$this$fill");
        Arrays.fill(fArr, i, i2, f);
    }

    public static /* synthetic */ void fill$default(float[] fArr, float f, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length;
        }
        fill(fArr, f, i, i2);
    }

    public static final void sort(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$sort");
        if (fArr.length > 1) {
            Arrays.sort(fArr);
        }
    }

    public static /* synthetic */ void sort$default(float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = fArr.length;
        }
        sort(fArr, i, i2);
    }

    @NotNull
    public static final SortedSet<Float> toSortedSet(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$toSortedSet");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(fArr, new TreeSet());
    }

    @NotNull
    public static final List<Float> asList(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$asList");
        return new RandomAccess(fArr) { // from class: kotlin.collections.ArraysKt___ArraysJvmKt$asList$5
            public final /* synthetic */ float[] a;

            {
                this.a = r1;
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection
            public final /* bridge */ boolean contains(Object obj) {
                if (obj instanceof Float) {
                    return contains(((Number) obj).floatValue());
                }
                return false;
            }

            @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
            public int getSize() {
                return this.a.length;
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int indexOf(Object obj) {
                if (obj instanceof Float) {
                    return indexOf(((Number) obj).floatValue());
                }
                return -1;
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection
            public boolean isEmpty() {
                return this.a.length == 0;
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int lastIndexOf(Object obj) {
                if (obj instanceof Float) {
                    return lastIndexOf(((Number) obj).floatValue());
                }
                return -1;
            }

            public boolean contains(float f) {
                float[] fArr2 = this.a;
                int length = fArr2.length;
                for (int i = 0; i < length; i++) {
                    if (Float.floatToIntBits(fArr2[i]) == Float.floatToIntBits(f)) {
                        return true;
                    }
                }
                return false;
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            @NotNull
            public Float get(int i) {
                return Float.valueOf(this.a[i]);
            }

            public int indexOf(float f) {
                float[] fArr2 = this.a;
                int length = fArr2.length;
                for (int i = 0; i < length; i++) {
                    if (Float.floatToIntBits(fArr2[i]) == Float.floatToIntBits(f)) {
                        return i;
                    }
                }
                return -1;
            }

            public int lastIndexOf(float f) {
                float[] fArr2 = this.a;
                for (int length = fArr2.length - 1; length >= 0; length--) {
                    if (Float.floatToIntBits(fArr2[length]) == Float.floatToIntBits(f)) {
                        return length;
                    }
                }
                return -1;
            }
        };
    }

    public static final int binarySearch(@NotNull float[] fArr, float f, int i, int i2) {
        Intrinsics.checkNotNullParameter(fArr, "$this$binarySearch");
        return Arrays.binarySearch(fArr, i, i2, f);
    }

    public static /* synthetic */ int binarySearch$default(float[] fArr, float f, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length;
        }
        return binarySearch(fArr, f, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final double[] copyInto(@NotNull double[] dArr, @NotNull double[] dArr2, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(dArr, "$this$copyInto");
        Intrinsics.checkNotNullParameter(dArr2, "destination");
        System.arraycopy(dArr, i2, dArr2, i, i3 - i2);
        return dArr2;
    }

    public static /* synthetic */ double[] copyInto$default(double[] dArr, double[] dArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = dArr.length;
        }
        return copyInto(dArr, dArr2, i, i2, i3);
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @NotNull
    @PublishedApi
    public static final int[] copyOfRange(@NotNull int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(iArr, "$this$copyOfRangeImpl");
        b.copyOfRangeToIndexCheck(i2, iArr.length);
        int[] copyOfRange = Arrays.copyOfRange(iArr, i, i2);
        Intrinsics.checkNotNullExpressionValue(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    public static final void fill(@NotNull double[] dArr, double d, int i, int i2) {
        Intrinsics.checkNotNullParameter(dArr, "$this$fill");
        Arrays.fill(dArr, i, i2, d);
    }

    public static /* synthetic */ void fill$default(double[] dArr, double d, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length;
        }
        fill(dArr, d, i, i2);
    }

    public static final void sort(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$sort");
        if (cArr.length > 1) {
            Arrays.sort(cArr);
        }
    }

    public static /* synthetic */ void sort$default(double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = dArr.length;
        }
        sort(dArr, i, i2);
    }

    @NotNull
    public static final SortedSet<Double> toSortedSet(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$toSortedSet");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(dArr, new TreeSet());
    }

    @NotNull
    public static final Integer[] toTypedArray(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$toTypedArray");
        Integer[] numArr = new Integer[iArr.length];
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }

    @NotNull
    public static final List<Double> asList(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$asList");
        return new RandomAccess(dArr) { // from class: kotlin.collections.ArraysKt___ArraysJvmKt$asList$6
            public final /* synthetic */ double[] a;

            {
                this.a = r1;
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection
            public final /* bridge */ boolean contains(Object obj) {
                if (obj instanceof Double) {
                    return contains(((Number) obj).doubleValue());
                }
                return false;
            }

            @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
            public int getSize() {
                return this.a.length;
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int indexOf(Object obj) {
                if (obj instanceof Double) {
                    return indexOf(((Number) obj).doubleValue());
                }
                return -1;
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection
            public boolean isEmpty() {
                return this.a.length == 0;
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int lastIndexOf(Object obj) {
                if (obj instanceof Double) {
                    return lastIndexOf(((Number) obj).doubleValue());
                }
                return -1;
            }

            public boolean contains(double d) {
                double[] dArr2 = this.a;
                int length = dArr2.length;
                for (int i = 0; i < length; i++) {
                    if (Double.doubleToLongBits(dArr2[i]) == Double.doubleToLongBits(d)) {
                        return true;
                    }
                }
                return false;
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            @NotNull
            public Double get(int i) {
                return Double.valueOf(this.a[i]);
            }

            public int indexOf(double d) {
                double[] dArr2 = this.a;
                int length = dArr2.length;
                for (int i = 0; i < length; i++) {
                    if (Double.doubleToLongBits(dArr2[i]) == Double.doubleToLongBits(d)) {
                        return i;
                    }
                }
                return -1;
            }

            public int lastIndexOf(double d) {
                double[] dArr2 = this.a;
                for (int length = dArr2.length - 1; length >= 0; length--) {
                    if (Double.doubleToLongBits(dArr2[length]) == Double.doubleToLongBits(d)) {
                        return length;
                    }
                }
                return -1;
            }
        };
    }

    public static final int binarySearch(@NotNull double[] dArr, double d, int i, int i2) {
        Intrinsics.checkNotNullParameter(dArr, "$this$binarySearch");
        return Arrays.binarySearch(dArr, i, i2, d);
    }

    public static /* synthetic */ int binarySearch$default(double[] dArr, double d, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length;
        }
        return binarySearch(dArr, d, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final boolean[] copyInto(@NotNull boolean[] zArr, @NotNull boolean[] zArr2, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(zArr, "$this$copyInto");
        Intrinsics.checkNotNullParameter(zArr2, "destination");
        System.arraycopy(zArr, i2, zArr2, i, i3 - i2);
        return zArr2;
    }

    public static /* synthetic */ boolean[] copyInto$default(boolean[] zArr, boolean[] zArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = zArr.length;
        }
        return copyInto(zArr, zArr2, i, i2, i3);
    }

    public static final void fill(@NotNull boolean[] zArr, boolean z, int i, int i2) {
        Intrinsics.checkNotNullParameter(zArr, "$this$fill");
        Arrays.fill(zArr, i, i2, z);
    }

    public static /* synthetic */ void fill$default(boolean[] zArr, boolean z, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = zArr.length;
        }
        fill(zArr, z, i, i2);
    }

    public static final <T> void sort(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$sort");
        if (tArr.length > 1) {
            Arrays.sort(tArr);
        }
    }

    public static /* synthetic */ void sort$default(char[] cArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = cArr.length;
        }
        sort(cArr, i, i2);
    }

    @NotNull
    public static final SortedSet<Boolean> toSortedSet(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "$this$toSortedSet");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(zArr, new TreeSet());
    }

    @NotNull
    public static final List<Boolean> asList(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "$this$asList");
        return new RandomAccess(zArr) { // from class: kotlin.collections.ArraysKt___ArraysJvmKt$asList$7
            public final /* synthetic */ boolean[] a;

            {
                this.a = r1;
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection
            public final /* bridge */ boolean contains(Object obj) {
                if (obj instanceof Boolean) {
                    return contains(((Boolean) obj).booleanValue());
                }
                return false;
            }

            @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
            public int getSize() {
                return this.a.length;
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int indexOf(Object obj) {
                if (obj instanceof Boolean) {
                    return indexOf(((Boolean) obj).booleanValue());
                }
                return -1;
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection
            public boolean isEmpty() {
                return this.a.length == 0;
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int lastIndexOf(Object obj) {
                if (obj instanceof Boolean) {
                    return lastIndexOf(((Boolean) obj).booleanValue());
                }
                return -1;
            }

            public boolean contains(boolean z) {
                return ArraysKt___ArraysKt.contains(this.a, z);
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            @NotNull
            public Boolean get(int i) {
                return Boolean.valueOf(this.a[i]);
            }

            public int indexOf(boolean z) {
                return ArraysKt___ArraysKt.indexOf(this.a, z);
            }

            public int lastIndexOf(boolean z) {
                return ArraysKt___ArraysKt.lastIndexOf(this.a, z);
            }
        };
    }

    public static final int binarySearch(@NotNull char[] cArr, char c, int i, int i2) {
        Intrinsics.checkNotNullParameter(cArr, "$this$binarySearch");
        return Arrays.binarySearch(cArr, i, i2, c);
    }

    public static /* synthetic */ int binarySearch$default(char[] cArr, char c, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = cArr.length;
        }
        return binarySearch(cArr, c, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final char[] copyInto(@NotNull char[] cArr, @NotNull char[] cArr2, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(cArr, "$this$copyInto");
        Intrinsics.checkNotNullParameter(cArr2, "destination");
        System.arraycopy(cArr, i2, cArr2, i, i3 - i2);
        return cArr2;
    }

    public static /* synthetic */ char[] copyInto$default(char[] cArr, char[] cArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = cArr.length;
        }
        return copyInto(cArr, cArr2, i, i2, i3);
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @NotNull
    @PublishedApi
    public static final long[] copyOfRange(@NotNull long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(jArr, "$this$copyOfRangeImpl");
        b.copyOfRangeToIndexCheck(i2, jArr.length);
        long[] copyOfRange = Arrays.copyOfRange(jArr, i, i2);
        Intrinsics.checkNotNullExpressionValue(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    public static final void fill(@NotNull char[] cArr, char c, int i, int i2) {
        Intrinsics.checkNotNullParameter(cArr, "$this$fill");
        Arrays.fill(cArr, i, i2, c);
    }

    public static /* synthetic */ void fill$default(char[] cArr, char c, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = cArr.length;
        }
        fill(cArr, c, i, i2);
    }

    @NotNull
    public static final short[] plus(@NotNull short[] sArr, short s) {
        Intrinsics.checkNotNullParameter(sArr, "$this$plus");
        int length = sArr.length;
        short[] copyOf = Arrays.copyOf(sArr, length + 1);
        copyOf[length] = s;
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @SinceKotlin(version = "1.4")
    public static final <T extends Comparable<? super T>> void sort(@NotNull T[] tArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$sort");
        Arrays.sort(tArr, i, i2);
    }

    public static /* synthetic */ void sort$default(Object[] objArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = objArr.length;
        }
        sort(objArr, i, i2);
    }

    @NotNull
    public static final SortedSet<Character> toSortedSet(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$toSortedSet");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(cArr, new TreeSet());
    }

    @NotNull
    public static final List<Character> asList(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$asList");
        return new RandomAccess(cArr) { // from class: kotlin.collections.ArraysKt___ArraysJvmKt$asList$8
            public final /* synthetic */ char[] a;

            {
                this.a = r1;
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection
            public final /* bridge */ boolean contains(Object obj) {
                if (obj instanceof Character) {
                    return contains(((Character) obj).charValue());
                }
                return false;
            }

            @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
            public int getSize() {
                return this.a.length;
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int indexOf(Object obj) {
                if (obj instanceof Character) {
                    return indexOf(((Character) obj).charValue());
                }
                return -1;
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection
            public boolean isEmpty() {
                return this.a.length == 0;
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int lastIndexOf(Object obj) {
                if (obj instanceof Character) {
                    return lastIndexOf(((Character) obj).charValue());
                }
                return -1;
            }

            public boolean contains(char c) {
                return ArraysKt___ArraysKt.contains(this.a, c);
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            @NotNull
            public Character get(int i) {
                return Character.valueOf(this.a[i]);
            }

            public int indexOf(char c) {
                return ArraysKt___ArraysKt.indexOf(this.a, c);
            }

            public int lastIndexOf(char c) {
                return ArraysKt___ArraysKt.lastIndexOf(this.a, c);
            }
        };
    }

    public static final void sort(@NotNull byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$sort");
        Arrays.sort(bArr, i, i2);
    }

    @NotNull
    public static final <T> SortedSet<T> toSortedSet(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "$this$toSortedSet");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(tArr, new TreeSet(comparator));
    }

    @NotNull
    public static final Long[] toTypedArray(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$toTypedArray");
        Long[] lArr = new Long[jArr.length];
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            lArr[i] = Long.valueOf(jArr[i]);
        }
        return lArr;
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @NotNull
    @PublishedApi
    public static final float[] copyOfRange(@NotNull float[] fArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(fArr, "$this$copyOfRangeImpl");
        b.copyOfRangeToIndexCheck(i2, fArr.length);
        float[] copyOfRange = Arrays.copyOfRange(fArr, i, i2);
        Intrinsics.checkNotNullExpressionValue(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    public static final void sort(@NotNull short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(sArr, "$this$sort");
        Arrays.sort(sArr, i, i2);
    }

    public static final void sort(@NotNull int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(iArr, "$this$sort");
        Arrays.sort(iArr, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @NotNull
    @PublishedApi
    public static final double[] copyOfRange(@NotNull double[] dArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(dArr, "$this$copyOfRangeImpl");
        b.copyOfRangeToIndexCheck(i2, dArr.length);
        double[] copyOfRange = Arrays.copyOfRange(dArr, i, i2);
        Intrinsics.checkNotNullExpressionValue(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @NotNull
    public static final int[] plus(@NotNull int[] iArr, int i) {
        Intrinsics.checkNotNullParameter(iArr, "$this$plus");
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, length + 1);
        copyOf[length] = i;
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    public static final void sort(@NotNull long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(jArr, "$this$sort");
        Arrays.sort(jArr, i, i2);
    }

    @NotNull
    public static final Float[] toTypedArray(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$toTypedArray");
        Float[] fArr2 = new Float[fArr.length];
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            fArr2[i] = Float.valueOf(fArr[i]);
        }
        return fArr2;
    }

    public static final void sort(@NotNull float[] fArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(fArr, "$this$sort");
        Arrays.sort(fArr, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @NotNull
    @PublishedApi
    public static final boolean[] copyOfRange(@NotNull boolean[] zArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(zArr, "$this$copyOfRangeImpl");
        b.copyOfRangeToIndexCheck(i2, zArr.length);
        boolean[] copyOfRange = Arrays.copyOfRange(zArr, i, i2);
        Intrinsics.checkNotNullExpressionValue(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    public static final void sort(@NotNull double[] dArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(dArr, "$this$sort");
        Arrays.sort(dArr, i, i2);
    }

    public static final void sort(@NotNull char[] cArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(cArr, "$this$sort");
        Arrays.sort(cArr, i, i2);
    }

    @NotNull
    public static final Double[] toTypedArray(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$toTypedArray");
        Double[] dArr2 = new Double[dArr.length];
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            dArr2[i] = Double.valueOf(dArr[i]);
        }
        return dArr2;
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @NotNull
    @PublishedApi
    public static final char[] copyOfRange(@NotNull char[] cArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(cArr, "$this$copyOfRangeImpl");
        b.copyOfRangeToIndexCheck(i2, cArr.length);
        char[] copyOfRange = Arrays.copyOfRange(cArr, i, i2);
        Intrinsics.checkNotNullExpressionValue(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @NotNull
    public static final long[] plus(@NotNull long[] jArr, long j) {
        Intrinsics.checkNotNullParameter(jArr, "$this$plus");
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, length + 1);
        copyOf[length] = j;
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    public static final <T> void sort(@NotNull T[] tArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$sort");
        Arrays.sort(tArr, i, i2);
    }

    @NotNull
    public static final Boolean[] toTypedArray(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "$this$toTypedArray");
        Boolean[] boolArr = new Boolean[zArr.length];
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            boolArr[i] = Boolean.valueOf(zArr[i]);
        }
        return boolArr;
    }

    @NotNull
    public static final float[] plus(@NotNull float[] fArr, float f) {
        Intrinsics.checkNotNullParameter(fArr, "$this$plus");
        int length = fArr.length;
        float[] copyOf = Arrays.copyOf(fArr, length + 1);
        copyOf[length] = f;
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final Character[] toTypedArray(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$toTypedArray");
        Character[] chArr = new Character[cArr.length];
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            chArr[i] = Character.valueOf(cArr[i]);
        }
        return chArr;
    }

    @NotNull
    public static final double[] plus(@NotNull double[] dArr, double d) {
        Intrinsics.checkNotNullParameter(dArr, "$this$plus");
        int length = dArr.length;
        double[] copyOf = Arrays.copyOf(dArr, length + 1);
        copyOf[length] = d;
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final boolean[] plus(@NotNull boolean[] zArr, boolean z) {
        Intrinsics.checkNotNullParameter(zArr, "$this$plus");
        int length = zArr.length;
        boolean[] copyOf = Arrays.copyOf(zArr, length + 1);
        copyOf[length] = z;
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final char[] plus(@NotNull char[] cArr, char c) {
        Intrinsics.checkNotNullParameter(cArr, "$this$plus");
        int length = cArr.length;
        char[] copyOf = Arrays.copyOf(cArr, length + 1);
        copyOf[length] = c;
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> T[] plus(@NotNull T[] tArr, @NotNull Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(tArr, "$this$plus");
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        int length = tArr.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, collection.size() + length);
        Iterator<? extends T> it = collection.iterator();
        while (it.hasNext()) {
            tArr2[length] = it.next();
            length++;
        }
        Intrinsics.checkNotNullExpressionValue(tArr2, "result");
        return tArr2;
    }

    @NotNull
    public static final byte[] plus(@NotNull byte[] bArr, @NotNull Collection<Byte> collection) {
        Intrinsics.checkNotNullParameter(bArr, "$this$plus");
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        int length = bArr.length;
        byte[] copyOf = Arrays.copyOf(bArr, collection.size() + length);
        for (Byte b : collection) {
            copyOf[length] = b.byteValue();
            length++;
        }
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final short[] plus(@NotNull short[] sArr, @NotNull Collection<Short> collection) {
        Intrinsics.checkNotNullParameter(sArr, "$this$plus");
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        int length = sArr.length;
        short[] copyOf = Arrays.copyOf(sArr, collection.size() + length);
        for (Short sh : collection) {
            copyOf[length] = sh.shortValue();
            length++;
        }
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final int[] plus(@NotNull int[] iArr, @NotNull Collection<Integer> collection) {
        Intrinsics.checkNotNullParameter(iArr, "$this$plus");
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, collection.size() + length);
        for (Integer num : collection) {
            copyOf[length] = num.intValue();
            length++;
        }
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final long[] plus(@NotNull long[] jArr, @NotNull Collection<Long> collection) {
        Intrinsics.checkNotNullParameter(jArr, "$this$plus");
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, collection.size() + length);
        for (Long l : collection) {
            copyOf[length] = l.longValue();
            length++;
        }
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final float[] plus(@NotNull float[] fArr, @NotNull Collection<Float> collection) {
        Intrinsics.checkNotNullParameter(fArr, "$this$plus");
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        int length = fArr.length;
        float[] copyOf = Arrays.copyOf(fArr, collection.size() + length);
        for (Float f : collection) {
            copyOf[length] = f.floatValue();
            length++;
        }
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final double[] plus(@NotNull double[] dArr, @NotNull Collection<Double> collection) {
        Intrinsics.checkNotNullParameter(dArr, "$this$plus");
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        int length = dArr.length;
        double[] copyOf = Arrays.copyOf(dArr, collection.size() + length);
        for (Double d : collection) {
            copyOf[length] = d.doubleValue();
            length++;
        }
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final boolean[] plus(@NotNull boolean[] zArr, @NotNull Collection<Boolean> collection) {
        Intrinsics.checkNotNullParameter(zArr, "$this$plus");
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        int length = zArr.length;
        boolean[] copyOf = Arrays.copyOf(zArr, collection.size() + length);
        for (Boolean bool : collection) {
            copyOf[length] = bool.booleanValue();
            length++;
        }
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final char[] plus(@NotNull char[] cArr, @NotNull Collection<Character> collection) {
        Intrinsics.checkNotNullParameter(cArr, "$this$plus");
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        int length = cArr.length;
        char[] copyOf = Arrays.copyOf(cArr, collection.size() + length);
        for (Character ch : collection) {
            copyOf[length] = ch.charValue();
            length++;
        }
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final <T> T[] plus(@NotNull T[] tArr, @NotNull T[] tArr2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$plus");
        Intrinsics.checkNotNullParameter(tArr2, MessengerShareContentUtility.ELEMENTS);
        int length = tArr.length;
        int length2 = tArr2.length;
        T[] tArr3 = (T[]) Arrays.copyOf(tArr, length + length2);
        System.arraycopy(tArr2, 0, tArr3, length, length2);
        Intrinsics.checkNotNullExpressionValue(tArr3, "result");
        return tArr3;
    }

    @NotNull
    public static final byte[] plus(@NotNull byte[] bArr, @NotNull byte[] bArr2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$plus");
        Intrinsics.checkNotNullParameter(bArr2, MessengerShareContentUtility.ELEMENTS);
        int length = bArr.length;
        int length2 = bArr2.length;
        byte[] copyOf = Arrays.copyOf(bArr, length + length2);
        System.arraycopy(bArr2, 0, copyOf, length, length2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final short[] plus(@NotNull short[] sArr, @NotNull short[] sArr2) {
        Intrinsics.checkNotNullParameter(sArr, "$this$plus");
        Intrinsics.checkNotNullParameter(sArr2, MessengerShareContentUtility.ELEMENTS);
        int length = sArr.length;
        int length2 = sArr2.length;
        short[] copyOf = Arrays.copyOf(sArr, length + length2);
        System.arraycopy(sArr2, 0, copyOf, length, length2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final int[] plus(@NotNull int[] iArr, @NotNull int[] iArr2) {
        Intrinsics.checkNotNullParameter(iArr, "$this$plus");
        Intrinsics.checkNotNullParameter(iArr2, MessengerShareContentUtility.ELEMENTS);
        int length = iArr.length;
        int length2 = iArr2.length;
        int[] copyOf = Arrays.copyOf(iArr, length + length2);
        System.arraycopy(iArr2, 0, copyOf, length, length2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final long[] plus(@NotNull long[] jArr, @NotNull long[] jArr2) {
        Intrinsics.checkNotNullParameter(jArr, "$this$plus");
        Intrinsics.checkNotNullParameter(jArr2, MessengerShareContentUtility.ELEMENTS);
        int length = jArr.length;
        int length2 = jArr2.length;
        long[] copyOf = Arrays.copyOf(jArr, length + length2);
        System.arraycopy(jArr2, 0, copyOf, length, length2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final float[] plus(@NotNull float[] fArr, @NotNull float[] fArr2) {
        Intrinsics.checkNotNullParameter(fArr, "$this$plus");
        Intrinsics.checkNotNullParameter(fArr2, MessengerShareContentUtility.ELEMENTS);
        int length = fArr.length;
        int length2 = fArr2.length;
        float[] copyOf = Arrays.copyOf(fArr, length + length2);
        System.arraycopy(fArr2, 0, copyOf, length, length2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final double[] plus(@NotNull double[] dArr, @NotNull double[] dArr2) {
        Intrinsics.checkNotNullParameter(dArr, "$this$plus");
        Intrinsics.checkNotNullParameter(dArr2, MessengerShareContentUtility.ELEMENTS);
        int length = dArr.length;
        int length2 = dArr2.length;
        double[] copyOf = Arrays.copyOf(dArr, length + length2);
        System.arraycopy(dArr2, 0, copyOf, length, length2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final boolean[] plus(@NotNull boolean[] zArr, @NotNull boolean[] zArr2) {
        Intrinsics.checkNotNullParameter(zArr, "$this$plus");
        Intrinsics.checkNotNullParameter(zArr2, MessengerShareContentUtility.ELEMENTS);
        int length = zArr.length;
        int length2 = zArr2.length;
        boolean[] copyOf = Arrays.copyOf(zArr, length + length2);
        System.arraycopy(zArr2, 0, copyOf, length, length2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final char[] plus(@NotNull char[] cArr, @NotNull char[] cArr2) {
        Intrinsics.checkNotNullParameter(cArr, "$this$plus");
        Intrinsics.checkNotNullParameter(cArr2, MessengerShareContentUtility.ELEMENTS);
        int length = cArr.length;
        int length2 = cArr2.length;
        char[] copyOf = Arrays.copyOf(cArr, length + length2);
        System.arraycopy(cArr2, 0, copyOf, length, length2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }
}
