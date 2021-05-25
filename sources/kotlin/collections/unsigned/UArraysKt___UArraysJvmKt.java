package kotlin.collections.unsigned;

import java.util.List;
import java.util.RandomAccess;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public class UArraysKt___UArraysJvmKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: asList--ajY-9A  reason: not valid java name */
    public static final List<UInt> m371asListajY9A(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$asList");
        return new RandomAccess(iArr) { // from class: kotlin.collections.unsigned.UArraysKt___UArraysJvmKt$asList$1
            public final /* synthetic */ int[] a;

            {
                this.a = r1;
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection
            public final /* bridge */ boolean contains(Object obj) {
                if (obj instanceof UInt) {
                    return m383containsWZ4Q5Ns(((UInt) obj).m282unboximpl());
                }
                return false;
            }

            /* renamed from: contains-WZ4Q5Ns  reason: not valid java name */
            public boolean m383containsWZ4Q5Ns(int i) {
                return UIntArray.m286containsWZ4Q5Ns(this.a, i);
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public /* bridge */ /* synthetic */ Object get(int i) {
                return UInt.m276boximpl(m384getpVg5ArA(i));
            }

            /* renamed from: get-pVg5ArA  reason: not valid java name */
            public int m384getpVg5ArA(int i) {
                return UIntArray.m290getpVg5ArA(this.a, i);
            }

            @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
            public int getSize() {
                return UIntArray.m291getSizeimpl(this.a);
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int indexOf(Object obj) {
                if (obj instanceof UInt) {
                    return m385indexOfWZ4Q5Ns(((UInt) obj).m282unboximpl());
                }
                return -1;
            }

            /* renamed from: indexOf-WZ4Q5Ns  reason: not valid java name */
            public int m385indexOfWZ4Q5Ns(int i) {
                return ArraysKt___ArraysKt.indexOf(this.a, i);
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection
            public boolean isEmpty() {
                return UIntArray.m293isEmptyimpl(this.a);
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int lastIndexOf(Object obj) {
                if (obj instanceof UInt) {
                    return m386lastIndexOfWZ4Q5Ns(((UInt) obj).m282unboximpl());
                }
                return -1;
            }

            /* renamed from: lastIndexOf-WZ4Q5Ns  reason: not valid java name */
            public int m386lastIndexOfWZ4Q5Ns(int i) {
                return ArraysKt___ArraysKt.lastIndexOf(this.a, i);
            }
        };
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: asList-GBYM_sE  reason: not valid java name */
    public static final List<UByte> m372asListGBYM_sE(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$asList");
        return new RandomAccess(bArr) { // from class: kotlin.collections.unsigned.UArraysKt___UArraysJvmKt$asList$3
            public final /* synthetic */ byte[] a;

            {
                this.a = r1;
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection
            public final /* bridge */ boolean contains(Object obj) {
                if (obj instanceof UByte) {
                    return m391contains7apg3OU(((UByte) obj).m257unboximpl());
                }
                return false;
            }

            /* renamed from: contains-7apg3OU  reason: not valid java name */
            public boolean m391contains7apg3OU(byte b) {
                return UByteArray.m261contains7apg3OU(this.a, b);
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public /* bridge */ /* synthetic */ Object get(int i) {
                return UByte.m251boximpl(m392getw2LRezQ(i));
            }

            /* renamed from: get-w2LRezQ  reason: not valid java name */
            public byte m392getw2LRezQ(int i) {
                return UByteArray.m265getw2LRezQ(this.a, i);
            }

            @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
            public int getSize() {
                return UByteArray.m266getSizeimpl(this.a);
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int indexOf(Object obj) {
                if (obj instanceof UByte) {
                    return m393indexOf7apg3OU(((UByte) obj).m257unboximpl());
                }
                return -1;
            }

            /* renamed from: indexOf-7apg3OU  reason: not valid java name */
            public int m393indexOf7apg3OU(byte b) {
                return ArraysKt___ArraysKt.indexOf(this.a, b);
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection
            public boolean isEmpty() {
                return UByteArray.m268isEmptyimpl(this.a);
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int lastIndexOf(Object obj) {
                if (obj instanceof UByte) {
                    return m394lastIndexOf7apg3OU(((UByte) obj).m257unboximpl());
                }
                return -1;
            }

            /* renamed from: lastIndexOf-7apg3OU  reason: not valid java name */
            public int m394lastIndexOf7apg3OU(byte b) {
                return ArraysKt___ArraysKt.lastIndexOf(this.a, b);
            }
        };
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: asList-QwZRm1k  reason: not valid java name */
    public static final List<ULong> m373asListQwZRm1k(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$asList");
        return new RandomAccess(jArr) { // from class: kotlin.collections.unsigned.UArraysKt___UArraysJvmKt$asList$2
            public final /* synthetic */ long[] a;

            {
                this.a = r1;
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection
            public final /* bridge */ boolean contains(Object obj) {
                if (obj instanceof ULong) {
                    return m387containsVKZWuLQ(((ULong) obj).m307unboximpl());
                }
                return false;
            }

            /* renamed from: contains-VKZWuLQ  reason: not valid java name */
            public boolean m387containsVKZWuLQ(long j) {
                return ULongArray.m311containsVKZWuLQ(this.a, j);
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public /* bridge */ /* synthetic */ Object get(int i) {
                return ULong.m301boximpl(m388getsVKNKU(i));
            }

            /* renamed from: get-s-VKNKU  reason: not valid java name */
            public long m388getsVKNKU(int i) {
                return ULongArray.m315getsVKNKU(this.a, i);
            }

            @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
            public int getSize() {
                return ULongArray.m316getSizeimpl(this.a);
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int indexOf(Object obj) {
                if (obj instanceof ULong) {
                    return m389indexOfVKZWuLQ(((ULong) obj).m307unboximpl());
                }
                return -1;
            }

            /* renamed from: indexOf-VKZWuLQ  reason: not valid java name */
            public int m389indexOfVKZWuLQ(long j) {
                return ArraysKt___ArraysKt.indexOf(this.a, j);
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection
            public boolean isEmpty() {
                return ULongArray.m318isEmptyimpl(this.a);
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int lastIndexOf(Object obj) {
                if (obj instanceof ULong) {
                    return m390lastIndexOfVKZWuLQ(((ULong) obj).m307unboximpl());
                }
                return -1;
            }

            /* renamed from: lastIndexOf-VKZWuLQ  reason: not valid java name */
            public int m390lastIndexOfVKZWuLQ(long j) {
                return ArraysKt___ArraysKt.lastIndexOf(this.a, j);
            }
        };
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: asList-rL5Bavg  reason: not valid java name */
    public static final List<UShort> m374asListrL5Bavg(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$asList");
        return new RandomAccess(sArr) { // from class: kotlin.collections.unsigned.UArraysKt___UArraysJvmKt$asList$4
            public final /* synthetic */ short[] a;

            {
                this.a = r1;
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection
            public final /* bridge */ boolean contains(Object obj) {
                if (obj instanceof UShort) {
                    return m395containsxj2QHRw(((UShort) obj).m332unboximpl());
                }
                return false;
            }

            /* renamed from: contains-xj2QHRw  reason: not valid java name */
            public boolean m395containsxj2QHRw(short s) {
                return UShortArray.m336containsxj2QHRw(this.a, s);
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public /* bridge */ /* synthetic */ Object get(int i) {
                return UShort.m326boximpl(m396getMh2AYeg(i));
            }

            /* renamed from: get-Mh2AYeg  reason: not valid java name */
            public short m396getMh2AYeg(int i) {
                return UShortArray.m340getMh2AYeg(this.a, i);
            }

            @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
            public int getSize() {
                return UShortArray.m341getSizeimpl(this.a);
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int indexOf(Object obj) {
                if (obj instanceof UShort) {
                    return m397indexOfxj2QHRw(((UShort) obj).m332unboximpl());
                }
                return -1;
            }

            /* renamed from: indexOf-xj2QHRw  reason: not valid java name */
            public int m397indexOfxj2QHRw(short s) {
                return ArraysKt___ArraysKt.indexOf(this.a, s);
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection
            public boolean isEmpty() {
                return UShortArray.m343isEmptyimpl(this.a);
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int lastIndexOf(Object obj) {
                if (obj instanceof UShort) {
                    return m398lastIndexOfxj2QHRw(((UShort) obj).m332unboximpl());
                }
                return -1;
            }

            /* renamed from: lastIndexOf-xj2QHRw  reason: not valid java name */
            public int m398lastIndexOfxj2QHRw(short s) {
                return ArraysKt___ArraysKt.lastIndexOf(this.a, s);
            }
        };
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: binarySearch-2fe2U9s  reason: not valid java name */
    public static final int m375binarySearch2fe2U9s(@NotNull int[] iArr, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i2, i3, UIntArray.m291getSizeimpl(iArr));
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int uintCompare = UnsignedKt.uintCompare(iArr[i5], i);
            if (uintCompare < 0) {
                i2 = i5 + 1;
            } else if (uintCompare <= 0) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    /* renamed from: binarySearch-2fe2U9s$default  reason: not valid java name */
    public static /* synthetic */ int m376binarySearch2fe2U9s$default(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = UIntArray.m291getSizeimpl(iArr);
        }
        return m375binarySearch2fe2U9s(iArr, i, i2, i3);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: binarySearch-EtDCXyQ  reason: not valid java name */
    public static final int m377binarySearchEtDCXyQ(@NotNull short[] sArr, short s, int i, int i2) {
        Intrinsics.checkNotNullParameter(sArr, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i, i2, UShortArray.m341getSizeimpl(sArr));
        int i3 = s & UShort.MAX_VALUE;
        int i4 = i2 - 1;
        while (i <= i4) {
            int i5 = (i + i4) >>> 1;
            int uintCompare = UnsignedKt.uintCompare(sArr[i5], i3);
            if (uintCompare < 0) {
                i = i5 + 1;
            } else if (uintCompare <= 0) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return -(i + 1);
    }

    /* renamed from: binarySearch-EtDCXyQ$default  reason: not valid java name */
    public static /* synthetic */ int m378binarySearchEtDCXyQ$default(short[] sArr, short s, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m341getSizeimpl(sArr);
        }
        return m377binarySearchEtDCXyQ(sArr, s, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: binarySearch-K6DWlUc  reason: not valid java name */
    public static final int m379binarySearchK6DWlUc(@NotNull long[] jArr, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(jArr, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i, i2, ULongArray.m316getSizeimpl(jArr));
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int ulongCompare = UnsignedKt.ulongCompare(jArr[i4], j);
            if (ulongCompare < 0) {
                i = i4 + 1;
            } else if (ulongCompare <= 0) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    /* renamed from: binarySearch-K6DWlUc$default  reason: not valid java name */
    public static /* synthetic */ int m380binarySearchK6DWlUc$default(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m316getSizeimpl(jArr);
        }
        return m379binarySearchK6DWlUc(jArr, j, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: binarySearch-WpHrYlw  reason: not valid java name */
    public static final int m381binarySearchWpHrYlw(@NotNull byte[] bArr, byte b, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i, i2, UByteArray.m266getSizeimpl(bArr));
        int i3 = b & 255;
        int i4 = i2 - 1;
        while (i <= i4) {
            int i5 = (i + i4) >>> 1;
            int uintCompare = UnsignedKt.uintCompare(bArr[i5], i3);
            if (uintCompare < 0) {
                i = i5 + 1;
            } else if (uintCompare <= 0) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return -(i + 1);
    }

    /* renamed from: binarySearch-WpHrYlw$default  reason: not valid java name */
    public static /* synthetic */ int m382binarySearchWpHrYlw$default(byte[] bArr, byte b, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m266getSizeimpl(bArr);
        }
        return m381binarySearchWpHrYlw(bArr, b, i, i2);
    }
}
