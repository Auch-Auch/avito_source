package kotlin.collections;

import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a*\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a*\u0010\t\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a*\u0010\f\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a*\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a*\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0007\u001a*\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\n\u001a*\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\r\u001a*\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lkotlin/UByteArray;", "array", "", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "right", "", AuthSource.BOOKING_ORDER, "([BII)V", "Lkotlin/UShortArray;", "c", "([SII)V", "Lkotlin/UIntArray;", "d", "([III)V", "Lkotlin/ULongArray;", AuthSource.SEND_ABUSE, "([JII)V", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray", "sortArray-Aa5vz7o", "sortArray-oBK06Vg", "sortArray--nroSd4", "kotlin-stdlib"}, k = 2, mv = {1, 4, 1})
public final class UArraySortingKt {
    @ExperimentalUnsignedTypes
    public static final void a(long[] jArr, int i, int i2) {
        long j = ULongArray.m315getsVKNKU(jArr, (i + i2) / 2);
        int i3 = i;
        int i4 = i2;
        while (i3 <= i4) {
            while (UnsignedKt.ulongCompare(ULongArray.m315getsVKNKU(jArr, i3), j) < 0) {
                i3++;
            }
            while (UnsignedKt.ulongCompare(ULongArray.m315getsVKNKU(jArr, i4), j) > 0) {
                i4--;
            }
            if (i3 <= i4) {
                long j2 = ULongArray.m315getsVKNKU(jArr, i3);
                ULongArray.m320setk8EXiF4(jArr, i3, ULongArray.m315getsVKNKU(jArr, i4));
                ULongArray.m320setk8EXiF4(jArr, i4, j2);
                i3++;
                i4--;
            }
        }
        int i5 = i3 - 1;
        if (i < i5) {
            a(jArr, i, i5);
        }
        if (i3 < i2) {
            a(jArr, i3, i2);
        }
    }

    @ExperimentalUnsignedTypes
    public static final void b(byte[] bArr, int i, int i2) {
        int i3;
        byte b = UByteArray.m265getw2LRezQ(bArr, (i + i2) / 2);
        int i4 = i;
        int i5 = i2;
        while (i4 <= i5) {
            while (true) {
                i3 = b & 255;
                if (Intrinsics.compare(UByteArray.m265getw2LRezQ(bArr, i4) & 255, i3) >= 0) {
                    break;
                }
                i4++;
            }
            while (Intrinsics.compare(UByteArray.m265getw2LRezQ(bArr, i5) & 255, i3) > 0) {
                i5--;
            }
            if (i4 <= i5) {
                byte b2 = UByteArray.m265getw2LRezQ(bArr, i4);
                UByteArray.m270setVurrAj0(bArr, i4, UByteArray.m265getw2LRezQ(bArr, i5));
                UByteArray.m270setVurrAj0(bArr, i5, b2);
                i4++;
                i5--;
            }
        }
        int i6 = i4 - 1;
        if (i < i6) {
            b(bArr, i, i6);
        }
        if (i4 < i2) {
            b(bArr, i4, i2);
        }
    }

    @ExperimentalUnsignedTypes
    public static final void c(short[] sArr, int i, int i2) {
        int i3;
        short s = UShortArray.m340getMh2AYeg(sArr, (i + i2) / 2);
        int i4 = i;
        int i5 = i2;
        while (i4 <= i5) {
            while (true) {
                int i6 = UShortArray.m340getMh2AYeg(sArr, i4) & UShort.MAX_VALUE;
                i3 = s & UShort.MAX_VALUE;
                if (Intrinsics.compare(i6, i3) >= 0) {
                    break;
                }
                i4++;
            }
            while (Intrinsics.compare(UShortArray.m340getMh2AYeg(sArr, i5) & UShort.MAX_VALUE, i3) > 0) {
                i5--;
            }
            if (i4 <= i5) {
                short s2 = UShortArray.m340getMh2AYeg(sArr, i4);
                UShortArray.m345set01HTLdE(sArr, i4, UShortArray.m340getMh2AYeg(sArr, i5));
                UShortArray.m345set01HTLdE(sArr, i5, s2);
                i4++;
                i5--;
            }
        }
        int i7 = i4 - 1;
        if (i < i7) {
            c(sArr, i, i7);
        }
        if (i4 < i2) {
            c(sArr, i4, i2);
        }
    }

    @ExperimentalUnsignedTypes
    public static final void d(int[] iArr, int i, int i2) {
        int i3 = UIntArray.m290getpVg5ArA(iArr, (i + i2) / 2);
        int i4 = i;
        int i5 = i2;
        while (i4 <= i5) {
            while (UnsignedKt.uintCompare(UIntArray.m290getpVg5ArA(iArr, i4), i3) < 0) {
                i4++;
            }
            while (UnsignedKt.uintCompare(UIntArray.m290getpVg5ArA(iArr, i5), i3) > 0) {
                i5--;
            }
            if (i4 <= i5) {
                int i6 = UIntArray.m290getpVg5ArA(iArr, i4);
                UIntArray.m295setVXSXFK8(iArr, i4, UIntArray.m290getpVg5ArA(iArr, i5));
                UIntArray.m295setVXSXFK8(iArr, i5, i6);
                i4++;
                i5--;
            }
        }
        int i7 = i4 - 1;
        if (i < i7) {
            d(iArr, i, i7);
        }
        if (i4 < i2) {
            d(iArr, i4, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray--nroSd4  reason: not valid java name */
    public static final void m363sortArraynroSd4(@NotNull long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(jArr, "array");
        a(jArr, i, i2 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-4UcCI2c  reason: not valid java name */
    public static final void m364sortArray4UcCI2c(@NotNull byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "array");
        b(bArr, i, i2 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-Aa5vz7o  reason: not valid java name */
    public static final void m365sortArrayAa5vz7o(@NotNull short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(sArr, "array");
        c(sArr, i, i2 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-oBK06Vg  reason: not valid java name */
    public static final void m366sortArrayoBK06Vg(@NotNull int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(iArr, "array");
        d(iArr, i, i2 - 1);
    }
}
