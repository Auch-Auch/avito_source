package t6.n.c0;

import com.avito.android.BuildConfig;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalStdlibApi;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.WasExperimental;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.IndexingIterable;
import kotlin.collections.UArraySortingKt;
import kotlin.collections.unsigned.UArraysKt___UArraysJvmKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.j;
import t6.v.e;
public class a extends UArraysKt___UArraysJvmKt {

    /* renamed from: t6.n.c0.a$a  reason: collision with other inner class name */
    public static final class C0679a extends Lambda implements Function0<Iterator<? extends UInt>> {
        public final /* synthetic */ int[] a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0679a(int[] iArr) {
            super(0);
            this.a = iArr;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Iterator<? extends UInt> invoke() {
            return UIntArray.m294iteratorimpl(this.a);
        }
    }

    public static final class b extends Lambda implements Function0<Iterator<? extends ULong>> {
        public final /* synthetic */ long[] a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(long[] jArr) {
            super(0);
            this.a = jArr;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Iterator<? extends ULong> invoke() {
            return ULongArray.m319iteratorimpl(this.a);
        }
    }

    public static final class c extends Lambda implements Function0<Iterator<? extends UByte>> {
        public final /* synthetic */ byte[] a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(byte[] bArr) {
            super(0);
            this.a = bArr;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Iterator<? extends UByte> invoke() {
            return UByteArray.m269iteratorimpl(this.a);
        }
    }

    public static final class d extends Lambda implements Function0<Iterator<? extends UShort>> {
        public final /* synthetic */ short[] a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(short[] sArr) {
            super(0);
            this.a = sArr;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Iterator<? extends UShort> invoke() {
            return UShortArray.m344iteratorimpl(this.a);
        }
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: contentEquals-FGO6Aew  reason: not valid java name */
    public static final boolean m735contentEqualsFGO6Aew(@Nullable short[] sArr, @Nullable short[] sArr2) {
        if (sArr == null) {
            sArr = null;
        }
        if (sArr2 == null) {
            sArr2 = null;
        }
        return Arrays.equals(sArr, sArr2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: contentEquals-KJPZfPQ  reason: not valid java name */
    public static final boolean m736contentEqualsKJPZfPQ(@Nullable int[] iArr, @Nullable int[] iArr2) {
        if (iArr == null) {
            iArr = null;
        }
        if (iArr2 == null) {
            iArr2 = null;
        }
        return Arrays.equals(iArr, iArr2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    /* renamed from: contentEquals-ctEhBpI  reason: not valid java name */
    public static final /* synthetic */ boolean m737contentEqualsctEhBpI(int[] iArr, int[] iArr2) {
        Intrinsics.checkNotNullParameter(iArr, "$this$contentEquals");
        Intrinsics.checkNotNullParameter(iArr2, "other");
        return m736contentEqualsKJPZfPQ(iArr, iArr2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: contentEquals-kV0jMPg  reason: not valid java name */
    public static final boolean m738contentEqualskV0jMPg(@Nullable byte[] bArr, @Nullable byte[] bArr2) {
        if (bArr == null) {
            bArr = null;
        }
        if (bArr2 == null) {
            bArr2 = null;
        }
        return Arrays.equals(bArr, bArr2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    /* renamed from: contentEquals-kdPth3s  reason: not valid java name */
    public static final /* synthetic */ boolean m739contentEqualskdPth3s(byte[] bArr, byte[] bArr2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$contentEquals");
        Intrinsics.checkNotNullParameter(bArr2, "other");
        return m738contentEqualskV0jMPg(bArr, bArr2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: contentEquals-lec5QzE  reason: not valid java name */
    public static final boolean m740contentEqualslec5QzE(@Nullable long[] jArr, @Nullable long[] jArr2) {
        if (jArr == null) {
            jArr = null;
        }
        if (jArr2 == null) {
            jArr2 = null;
        }
        return Arrays.equals(jArr, jArr2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    /* renamed from: contentEquals-mazbYpA  reason: not valid java name */
    public static final /* synthetic */ boolean m741contentEqualsmazbYpA(short[] sArr, short[] sArr2) {
        Intrinsics.checkNotNullParameter(sArr, "$this$contentEquals");
        Intrinsics.checkNotNullParameter(sArr2, "other");
        return m735contentEqualsFGO6Aew(sArr, sArr2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    /* renamed from: contentEquals-us8wMrg  reason: not valid java name */
    public static final /* synthetic */ boolean m742contentEqualsus8wMrg(long[] jArr, long[] jArr2) {
        Intrinsics.checkNotNullParameter(jArr, "$this$contentEquals");
        Intrinsics.checkNotNullParameter(jArr2, "other");
        return m740contentEqualslec5QzE(jArr, jArr2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: contentHashCode-2csIQuQ  reason: not valid java name */
    public static final int m744contentHashCode2csIQuQ(@Nullable byte[] bArr) {
        if (bArr == null) {
            bArr = null;
        }
        return Arrays.hashCode(bArr);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: contentHashCode-XUkPCBk  reason: not valid java name */
    public static final int m747contentHashCodeXUkPCBk(@Nullable int[] iArr) {
        if (iArr == null) {
            iArr = null;
        }
        return Arrays.hashCode(iArr);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: contentHashCode-d-6D3K8  reason: not valid java name */
    public static final int m748contentHashCoded6D3K8(@Nullable short[] sArr) {
        if (sArr == null) {
            sArr = null;
        }
        return Arrays.hashCode(sArr);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: contentHashCode-uLth9ew  reason: not valid java name */
    public static final int m750contentHashCodeuLth9ew(@Nullable long[] jArr) {
        if (jArr == null) {
            jArr = null;
        }
        return Arrays.hashCode(jArr);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: contentToString-2csIQuQ  reason: not valid java name */
    public static final String m752contentToString2csIQuQ(@Nullable byte[] bArr) {
        String joinToString$default;
        return (bArr == null || (joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(Intrinsics.checkNotNullParameter(bArr, VKApiConst.VERSION), ", ", "[", "]", 0, null, null, 56, null)) == null) ? BuildConfig.ADJUST_DEFAULT_TRACKER : joinToString$default;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: contentToString-XUkPCBk  reason: not valid java name */
    public static final String m755contentToStringXUkPCBk(@Nullable int[] iArr) {
        String joinToString$default;
        return (iArr == null || (joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(Intrinsics.checkNotNullParameter(iArr, VKApiConst.VERSION), ", ", "[", "]", 0, null, null, 56, null)) == null) ? BuildConfig.ADJUST_DEFAULT_TRACKER : joinToString$default;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: contentToString-d-6D3K8  reason: not valid java name */
    public static final String m756contentToStringd6D3K8(@Nullable short[] sArr) {
        String joinToString$default;
        return (sArr == null || (joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(Intrinsics.checkNotNullParameter(sArr, VKApiConst.VERSION), ", ", "[", "]", 0, null, null, 56, null)) == null) ? BuildConfig.ADJUST_DEFAULT_TRACKER : joinToString$default;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: contentToString-uLth9ew  reason: not valid java name */
    public static final String m758contentToStringuLth9ew(@Nullable long[] jArr) {
        String joinToString$default;
        return (jArr == null || (joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(Intrinsics.checkNotNullParameter(jArr, VKApiConst.VERSION), ", ", "[", "]", 0, null, null, 56, null)) == null) ? BuildConfig.ADJUST_DEFAULT_TRACKER : joinToString$default;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: drop-PpDY95g  reason: not valid java name */
    public static final List<UByte> m759dropPpDY95g(@NotNull byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "$this$drop");
        if (i >= 0) {
            return m919takeLastPpDY95g(bArr, e.coerceAtLeast(UByteArray.m266getSizeimpl(bArr) - i, 0));
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i, " is less than zero.").toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: drop-nggk6HY  reason: not valid java name */
    public static final List<UShort> m760dropnggk6HY(@NotNull short[] sArr, int i) {
        Intrinsics.checkNotNullParameter(sArr, "$this$drop");
        if (i >= 0) {
            return m920takeLastnggk6HY(sArr, e.coerceAtLeast(UShortArray.m341getSizeimpl(sArr) - i, 0));
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i, " is less than zero.").toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: drop-qFRl0hI  reason: not valid java name */
    public static final List<UInt> m761dropqFRl0hI(@NotNull int[] iArr, int i) {
        Intrinsics.checkNotNullParameter(iArr, "$this$drop");
        if (i >= 0) {
            return m921takeLastqFRl0hI(iArr, e.coerceAtLeast(UIntArray.m291getSizeimpl(iArr) - i, 0));
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i, " is less than zero.").toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: drop-r7IrZao  reason: not valid java name */
    public static final List<ULong> m762dropr7IrZao(@NotNull long[] jArr, int i) {
        Intrinsics.checkNotNullParameter(jArr, "$this$drop");
        if (i >= 0) {
            return m922takeLastr7IrZao(jArr, e.coerceAtLeast(ULongArray.m316getSizeimpl(jArr) - i, 0));
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i, " is less than zero.").toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: dropLast-PpDY95g  reason: not valid java name */
    public static final List<UByte> m763dropLastPpDY95g(@NotNull byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "$this$dropLast");
        if (i >= 0) {
            return m915takePpDY95g(bArr, e.coerceAtLeast(UByteArray.m266getSizeimpl(bArr) - i, 0));
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i, " is less than zero.").toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: dropLast-nggk6HY  reason: not valid java name */
    public static final List<UShort> m764dropLastnggk6HY(@NotNull short[] sArr, int i) {
        Intrinsics.checkNotNullParameter(sArr, "$this$dropLast");
        if (i >= 0) {
            return m916takenggk6HY(sArr, e.coerceAtLeast(UShortArray.m341getSizeimpl(sArr) - i, 0));
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i, " is less than zero.").toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: dropLast-qFRl0hI  reason: not valid java name */
    public static final List<UInt> m765dropLastqFRl0hI(@NotNull int[] iArr, int i) {
        Intrinsics.checkNotNullParameter(iArr, "$this$dropLast");
        if (i >= 0) {
            return m917takeqFRl0hI(iArr, e.coerceAtLeast(UIntArray.m291getSizeimpl(iArr) - i, 0));
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i, " is less than zero.").toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: dropLast-r7IrZao  reason: not valid java name */
    public static final List<ULong> m766dropLastr7IrZao(@NotNull long[] jArr, int i) {
        Intrinsics.checkNotNullParameter(jArr, "$this$dropLast");
        if (i >= 0) {
            return m918taker7IrZao(jArr, e.coerceAtLeast(ULongArray.m316getSizeimpl(jArr) - i, 0));
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i, " is less than zero.").toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: fill-2fe2U9s  reason: not valid java name */
    public static final void m767fill2fe2U9s(@NotNull int[] iArr, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "$this$fill");
        ArraysKt___ArraysJvmKt.fill(iArr, i, i2, i3);
    }

    /* renamed from: fill-2fe2U9s$default  reason: not valid java name */
    public static /* synthetic */ void m768fill2fe2U9s$default(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = UIntArray.m291getSizeimpl(iArr);
        }
        m767fill2fe2U9s(iArr, i, i2, i3);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: fill-EtDCXyQ  reason: not valid java name */
    public static final void m769fillEtDCXyQ(@NotNull short[] sArr, short s, int i, int i2) {
        Intrinsics.checkNotNullParameter(sArr, "$this$fill");
        ArraysKt___ArraysJvmKt.fill(sArr, s, i, i2);
    }

    /* renamed from: fill-EtDCXyQ$default  reason: not valid java name */
    public static /* synthetic */ void m770fillEtDCXyQ$default(short[] sArr, short s, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m341getSizeimpl(sArr);
        }
        m769fillEtDCXyQ(sArr, s, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: fill-K6DWlUc  reason: not valid java name */
    public static final void m771fillK6DWlUc(@NotNull long[] jArr, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(jArr, "$this$fill");
        ArraysKt___ArraysJvmKt.fill(jArr, j, i, i2);
    }

    /* renamed from: fill-K6DWlUc$default  reason: not valid java name */
    public static /* synthetic */ void m772fillK6DWlUc$default(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m316getSizeimpl(jArr);
        }
        m771fillK6DWlUc(jArr, j, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: fill-WpHrYlw  reason: not valid java name */
    public static final void m773fillWpHrYlw(@NotNull byte[] bArr, byte b2, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$fill");
        ArraysKt___ArraysJvmKt.fill(bArr, b2, i, i2);
    }

    /* renamed from: fill-WpHrYlw$default  reason: not valid java name */
    public static /* synthetic */ void m774fillWpHrYlw$default(byte[] bArr, byte b2, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m266getSizeimpl(bArr);
        }
        m773fillWpHrYlw(bArr, b2, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: firstOrNull--ajY-9A  reason: not valid java name */
    public static final UInt m775firstOrNullajY9A(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$firstOrNull");
        if (UIntArray.m293isEmptyimpl(iArr)) {
            return null;
        }
        return UInt.m276boximpl(UIntArray.m290getpVg5ArA(iArr, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: firstOrNull-GBYM_sE  reason: not valid java name */
    public static final UByte m776firstOrNullGBYM_sE(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$firstOrNull");
        if (UByteArray.m268isEmptyimpl(bArr)) {
            return null;
        }
        return UByte.m251boximpl(UByteArray.m265getw2LRezQ(bArr, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: firstOrNull-QwZRm1k  reason: not valid java name */
    public static final ULong m777firstOrNullQwZRm1k(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$firstOrNull");
        if (ULongArray.m318isEmptyimpl(jArr)) {
            return null;
        }
        return ULong.m301boximpl(ULongArray.m315getsVKNKU(jArr, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: firstOrNull-rL5Bavg  reason: not valid java name */
    public static final UShort m778firstOrNullrL5Bavg(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$firstOrNull");
        if (UShortArray.m343isEmptyimpl(sArr)) {
            return null;
        }
        return UShort.m326boximpl(UShortArray.m340getMh2AYeg(sArr, 0));
    }

    @NotNull
    /* renamed from: getIndices--ajY-9A  reason: not valid java name */
    public static final IntRange m779getIndicesajY9A(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$indices");
        return ArraysKt___ArraysKt.getIndices(iArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: getIndices--ajY-9A$annotations  reason: not valid java name */
    public static /* synthetic */ void m780getIndicesajY9A$annotations(int[] iArr) {
    }

    @NotNull
    /* renamed from: getIndices-GBYM_sE  reason: not valid java name */
    public static final IntRange m781getIndicesGBYM_sE(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$indices");
        return ArraysKt___ArraysKt.getIndices(bArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: getIndices-GBYM_sE$annotations  reason: not valid java name */
    public static /* synthetic */ void m782getIndicesGBYM_sE$annotations(byte[] bArr) {
    }

    @NotNull
    /* renamed from: getIndices-QwZRm1k  reason: not valid java name */
    public static final IntRange m783getIndicesQwZRm1k(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$indices");
        return ArraysKt___ArraysKt.getIndices(jArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: getIndices-QwZRm1k$annotations  reason: not valid java name */
    public static /* synthetic */ void m784getIndicesQwZRm1k$annotations(long[] jArr) {
    }

    @NotNull
    /* renamed from: getIndices-rL5Bavg  reason: not valid java name */
    public static final IntRange m785getIndicesrL5Bavg(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$indices");
        return ArraysKt___ArraysKt.getIndices(sArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: getIndices-rL5Bavg$annotations  reason: not valid java name */
    public static /* synthetic */ void m786getIndicesrL5Bavg$annotations(short[] sArr) {
    }

    /* renamed from: getLastIndex--ajY-9A  reason: not valid java name */
    public static final int m787getLastIndexajY9A(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$lastIndex");
        return ArraysKt___ArraysKt.getLastIndex(iArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: getLastIndex--ajY-9A$annotations  reason: not valid java name */
    public static /* synthetic */ void m788getLastIndexajY9A$annotations(int[] iArr) {
    }

    /* renamed from: getLastIndex-GBYM_sE  reason: not valid java name */
    public static final int m789getLastIndexGBYM_sE(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$lastIndex");
        return ArraysKt___ArraysKt.getLastIndex(bArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: getLastIndex-GBYM_sE$annotations  reason: not valid java name */
    public static /* synthetic */ void m790getLastIndexGBYM_sE$annotations(byte[] bArr) {
    }

    /* renamed from: getLastIndex-QwZRm1k  reason: not valid java name */
    public static final int m791getLastIndexQwZRm1k(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$lastIndex");
        return ArraysKt___ArraysKt.getLastIndex(jArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: getLastIndex-QwZRm1k$annotations  reason: not valid java name */
    public static /* synthetic */ void m792getLastIndexQwZRm1k$annotations(long[] jArr) {
    }

    /* renamed from: getLastIndex-rL5Bavg  reason: not valid java name */
    public static final int m793getLastIndexrL5Bavg(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$lastIndex");
        return ArraysKt___ArraysKt.getLastIndex(sArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: getLastIndex-rL5Bavg$annotations  reason: not valid java name */
    public static /* synthetic */ void m794getLastIndexrL5Bavg$annotations(short[] sArr) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: getOrNull-PpDY95g  reason: not valid java name */
    public static final UByte m795getOrNullPpDY95g(@NotNull byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "$this$getOrNull");
        if (i < 0 || i > ArraysKt___ArraysKt.getLastIndex(bArr)) {
            return null;
        }
        return UByte.m251boximpl(UByteArray.m265getw2LRezQ(bArr, i));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: getOrNull-nggk6HY  reason: not valid java name */
    public static final UShort m796getOrNullnggk6HY(@NotNull short[] sArr, int i) {
        Intrinsics.checkNotNullParameter(sArr, "$this$getOrNull");
        if (i < 0 || i > ArraysKt___ArraysKt.getLastIndex(sArr)) {
            return null;
        }
        return UShort.m326boximpl(UShortArray.m340getMh2AYeg(sArr, i));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: getOrNull-qFRl0hI  reason: not valid java name */
    public static final UInt m797getOrNullqFRl0hI(@NotNull int[] iArr, int i) {
        Intrinsics.checkNotNullParameter(iArr, "$this$getOrNull");
        if (i < 0 || i > ArraysKt___ArraysKt.getLastIndex(iArr)) {
            return null;
        }
        return UInt.m276boximpl(UIntArray.m290getpVg5ArA(iArr, i));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: getOrNull-r7IrZao  reason: not valid java name */
    public static final ULong m798getOrNullr7IrZao(@NotNull long[] jArr, int i) {
        Intrinsics.checkNotNullParameter(jArr, "$this$getOrNull");
        if (i < 0 || i > ArraysKt___ArraysKt.getLastIndex(jArr)) {
            return null;
        }
        return ULong.m301boximpl(ULongArray.m315getsVKNKU(jArr, i));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: lastOrNull--ajY-9A  reason: not valid java name */
    public static final UInt m799lastOrNullajY9A(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$lastOrNull");
        if (UIntArray.m293isEmptyimpl(iArr)) {
            return null;
        }
        return UInt.m276boximpl(UIntArray.m290getpVg5ArA(iArr, UIntArray.m291getSizeimpl(iArr) - 1));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: lastOrNull-GBYM_sE  reason: not valid java name */
    public static final UByte m800lastOrNullGBYM_sE(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$lastOrNull");
        if (UByteArray.m268isEmptyimpl(bArr)) {
            return null;
        }
        return UByte.m251boximpl(UByteArray.m265getw2LRezQ(bArr, UByteArray.m266getSizeimpl(bArr) - 1));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: lastOrNull-QwZRm1k  reason: not valid java name */
    public static final ULong m801lastOrNullQwZRm1k(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$lastOrNull");
        if (ULongArray.m318isEmptyimpl(jArr)) {
            return null;
        }
        return ULong.m301boximpl(ULongArray.m315getsVKNKU(jArr, ULongArray.m316getSizeimpl(jArr) - 1));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: lastOrNull-rL5Bavg  reason: not valid java name */
    public static final UShort m802lastOrNullrL5Bavg(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$lastOrNull");
        if (UShortArray.m343isEmptyimpl(sArr)) {
            return null;
        }
        return UShort.m326boximpl(UShortArray.m340getMh2AYeg(sArr, UShortArray.m341getSizeimpl(sArr) - 1));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    /* renamed from: max--ajY-9A  reason: not valid java name */
    public static final UInt m803maxajY9A(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$max");
        return m807maxOrNullajY9A(iArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    /* renamed from: max-GBYM_sE  reason: not valid java name */
    public static final UByte m804maxGBYM_sE(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$max");
        return m808maxOrNullGBYM_sE(bArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    /* renamed from: max-QwZRm1k  reason: not valid java name */
    public static final ULong m805maxQwZRm1k(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$max");
        return m809maxOrNullQwZRm1k(jArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    /* renamed from: max-rL5Bavg  reason: not valid java name */
    public static final UShort m806maxrL5Bavg(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$max");
        return m810maxOrNullrL5Bavg(sArr);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: maxOrNull--ajY-9A  reason: not valid java name */
    public static final UInt m807maxOrNullajY9A(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$maxOrNull");
        if (UIntArray.m293isEmptyimpl(iArr)) {
            return null;
        }
        int i = UIntArray.m290getpVg5ArA(iArr, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(iArr);
        int i2 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int i3 = UIntArray.m290getpVg5ArA(iArr, i2);
                if (UnsignedKt.uintCompare(i, i3) < 0) {
                    i = i3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return UInt.m276boximpl(i);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: maxOrNull-GBYM_sE  reason: not valid java name */
    public static final UByte m808maxOrNullGBYM_sE(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$maxOrNull");
        if (UByteArray.m268isEmptyimpl(bArr)) {
            return null;
        }
        byte b2 = UByteArray.m265getw2LRezQ(bArr, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(bArr);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte b3 = UByteArray.m265getw2LRezQ(bArr, i);
                if (Intrinsics.compare(b2 & 255, b3 & 255) < 0) {
                    b2 = b3;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UByte.m251boximpl(b2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: maxOrNull-QwZRm1k  reason: not valid java name */
    public static final ULong m809maxOrNullQwZRm1k(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$maxOrNull");
        if (ULongArray.m318isEmptyimpl(jArr)) {
            return null;
        }
        long j = ULongArray.m315getsVKNKU(jArr, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(jArr);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long j2 = ULongArray.m315getsVKNKU(jArr, i);
                if (UnsignedKt.ulongCompare(j, j2) < 0) {
                    j = j2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return ULong.m301boximpl(j);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: maxOrNull-rL5Bavg  reason: not valid java name */
    public static final UShort m810maxOrNullrL5Bavg(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$maxOrNull");
        if (UShortArray.m343isEmptyimpl(sArr)) {
            return null;
        }
        short s = UShortArray.m340getMh2AYeg(sArr, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(sArr);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short s2 = UShortArray.m340getMh2AYeg(sArr, i);
                if (Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) < 0) {
                    s = s2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UShort.m326boximpl(s);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    /* renamed from: maxWith-XMRcp5o  reason: not valid java name */
    public static final UByte m811maxWithXMRcp5o(@NotNull byte[] bArr, @NotNull Comparator<? super UByte> comparator) {
        Intrinsics.checkNotNullParameter(bArr, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return m815maxWithOrNullXMRcp5o(bArr, comparator);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    /* renamed from: maxWith-YmdZ_VM  reason: not valid java name */
    public static final UInt m812maxWithYmdZ_VM(@NotNull int[] iArr, @NotNull Comparator<? super UInt> comparator) {
        Intrinsics.checkNotNullParameter(iArr, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return m816maxWithOrNullYmdZ_VM(iArr, comparator);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    /* renamed from: maxWith-eOHTfZs  reason: not valid java name */
    public static final UShort m813maxWitheOHTfZs(@NotNull short[] sArr, @NotNull Comparator<? super UShort> comparator) {
        Intrinsics.checkNotNullParameter(sArr, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return m817maxWithOrNulleOHTfZs(sArr, comparator);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    /* renamed from: maxWith-zrEWJaI  reason: not valid java name */
    public static final ULong m814maxWithzrEWJaI(@NotNull long[] jArr, @NotNull Comparator<? super ULong> comparator) {
        Intrinsics.checkNotNullParameter(jArr, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return m818maxWithOrNullzrEWJaI(jArr, comparator);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: maxWithOrNull-XMRcp5o  reason: not valid java name */
    public static final UByte m815maxWithOrNullXMRcp5o(@NotNull byte[] bArr, @NotNull Comparator<? super UByte> comparator) {
        Intrinsics.checkNotNullParameter(bArr, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UByteArray.m268isEmptyimpl(bArr)) {
            return null;
        }
        byte b2 = UByteArray.m265getw2LRezQ(bArr, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(bArr);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte b3 = UByteArray.m265getw2LRezQ(bArr, i);
                if (comparator.compare(UByte.m251boximpl(b2), UByte.m251boximpl(b3)) < 0) {
                    b2 = b3;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UByte.m251boximpl(b2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: maxWithOrNull-YmdZ_VM  reason: not valid java name */
    public static final UInt m816maxWithOrNullYmdZ_VM(@NotNull int[] iArr, @NotNull Comparator<? super UInt> comparator) {
        Intrinsics.checkNotNullParameter(iArr, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UIntArray.m293isEmptyimpl(iArr)) {
            return null;
        }
        int i = UIntArray.m290getpVg5ArA(iArr, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(iArr);
        int i2 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int i3 = UIntArray.m290getpVg5ArA(iArr, i2);
                if (comparator.compare(UInt.m276boximpl(i), UInt.m276boximpl(i3)) < 0) {
                    i = i3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return UInt.m276boximpl(i);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: maxWithOrNull-eOHTfZs  reason: not valid java name */
    public static final UShort m817maxWithOrNulleOHTfZs(@NotNull short[] sArr, @NotNull Comparator<? super UShort> comparator) {
        Intrinsics.checkNotNullParameter(sArr, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UShortArray.m343isEmptyimpl(sArr)) {
            return null;
        }
        short s = UShortArray.m340getMh2AYeg(sArr, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(sArr);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short s2 = UShortArray.m340getMh2AYeg(sArr, i);
                if (comparator.compare(UShort.m326boximpl(s), UShort.m326boximpl(s2)) < 0) {
                    s = s2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UShort.m326boximpl(s);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: maxWithOrNull-zrEWJaI  reason: not valid java name */
    public static final ULong m818maxWithOrNullzrEWJaI(@NotNull long[] jArr, @NotNull Comparator<? super ULong> comparator) {
        Intrinsics.checkNotNullParameter(jArr, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (ULongArray.m318isEmptyimpl(jArr)) {
            return null;
        }
        long j = ULongArray.m315getsVKNKU(jArr, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(jArr);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long j2 = ULongArray.m315getsVKNKU(jArr, i);
                if (comparator.compare(ULong.m301boximpl(j), ULong.m301boximpl(j2)) < 0) {
                    j = j2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return ULong.m301boximpl(j);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    /* renamed from: min--ajY-9A  reason: not valid java name */
    public static final UInt m819minajY9A(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$min");
        return m823minOrNullajY9A(iArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    /* renamed from: min-GBYM_sE  reason: not valid java name */
    public static final UByte m820minGBYM_sE(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$min");
        return m824minOrNullGBYM_sE(bArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    /* renamed from: min-QwZRm1k  reason: not valid java name */
    public static final ULong m821minQwZRm1k(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$min");
        return m825minOrNullQwZRm1k(jArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    /* renamed from: min-rL5Bavg  reason: not valid java name */
    public static final UShort m822minrL5Bavg(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$min");
        return m826minOrNullrL5Bavg(sArr);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: minOrNull--ajY-9A  reason: not valid java name */
    public static final UInt m823minOrNullajY9A(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$minOrNull");
        if (UIntArray.m293isEmptyimpl(iArr)) {
            return null;
        }
        int i = UIntArray.m290getpVg5ArA(iArr, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(iArr);
        int i2 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int i3 = UIntArray.m290getpVg5ArA(iArr, i2);
                if (UnsignedKt.uintCompare(i, i3) > 0) {
                    i = i3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return UInt.m276boximpl(i);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: minOrNull-GBYM_sE  reason: not valid java name */
    public static final UByte m824minOrNullGBYM_sE(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$minOrNull");
        if (UByteArray.m268isEmptyimpl(bArr)) {
            return null;
        }
        byte b2 = UByteArray.m265getw2LRezQ(bArr, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(bArr);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte b3 = UByteArray.m265getw2LRezQ(bArr, i);
                if (Intrinsics.compare(b2 & 255, b3 & 255) > 0) {
                    b2 = b3;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UByte.m251boximpl(b2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: minOrNull-QwZRm1k  reason: not valid java name */
    public static final ULong m825minOrNullQwZRm1k(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$minOrNull");
        if (ULongArray.m318isEmptyimpl(jArr)) {
            return null;
        }
        long j = ULongArray.m315getsVKNKU(jArr, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(jArr);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long j2 = ULongArray.m315getsVKNKU(jArr, i);
                if (UnsignedKt.ulongCompare(j, j2) > 0) {
                    j = j2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return ULong.m301boximpl(j);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: minOrNull-rL5Bavg  reason: not valid java name */
    public static final UShort m826minOrNullrL5Bavg(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$minOrNull");
        if (UShortArray.m343isEmptyimpl(sArr)) {
            return null;
        }
        short s = UShortArray.m340getMh2AYeg(sArr, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(sArr);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short s2 = UShortArray.m340getMh2AYeg(sArr, i);
                if (Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) > 0) {
                    s = s2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UShort.m326boximpl(s);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    /* renamed from: minWith-XMRcp5o  reason: not valid java name */
    public static final UByte m827minWithXMRcp5o(@NotNull byte[] bArr, @NotNull Comparator<? super UByte> comparator) {
        Intrinsics.checkNotNullParameter(bArr, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return m831minWithOrNullXMRcp5o(bArr, comparator);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    /* renamed from: minWith-YmdZ_VM  reason: not valid java name */
    public static final UInt m828minWithYmdZ_VM(@NotNull int[] iArr, @NotNull Comparator<? super UInt> comparator) {
        Intrinsics.checkNotNullParameter(iArr, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return m832minWithOrNullYmdZ_VM(iArr, comparator);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    /* renamed from: minWith-eOHTfZs  reason: not valid java name */
    public static final UShort m829minWitheOHTfZs(@NotNull short[] sArr, @NotNull Comparator<? super UShort> comparator) {
        Intrinsics.checkNotNullParameter(sArr, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return m833minWithOrNulleOHTfZs(sArr, comparator);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    /* renamed from: minWith-zrEWJaI  reason: not valid java name */
    public static final ULong m830minWithzrEWJaI(@NotNull long[] jArr, @NotNull Comparator<? super ULong> comparator) {
        Intrinsics.checkNotNullParameter(jArr, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return m834minWithOrNullzrEWJaI(jArr, comparator);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: minWithOrNull-XMRcp5o  reason: not valid java name */
    public static final UByte m831minWithOrNullXMRcp5o(@NotNull byte[] bArr, @NotNull Comparator<? super UByte> comparator) {
        Intrinsics.checkNotNullParameter(bArr, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UByteArray.m268isEmptyimpl(bArr)) {
            return null;
        }
        byte b2 = UByteArray.m265getw2LRezQ(bArr, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(bArr);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte b3 = UByteArray.m265getw2LRezQ(bArr, i);
                if (comparator.compare(UByte.m251boximpl(b2), UByte.m251boximpl(b3)) > 0) {
                    b2 = b3;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UByte.m251boximpl(b2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: minWithOrNull-YmdZ_VM  reason: not valid java name */
    public static final UInt m832minWithOrNullYmdZ_VM(@NotNull int[] iArr, @NotNull Comparator<? super UInt> comparator) {
        Intrinsics.checkNotNullParameter(iArr, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UIntArray.m293isEmptyimpl(iArr)) {
            return null;
        }
        int i = UIntArray.m290getpVg5ArA(iArr, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(iArr);
        int i2 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int i3 = UIntArray.m290getpVg5ArA(iArr, i2);
                if (comparator.compare(UInt.m276boximpl(i), UInt.m276boximpl(i3)) > 0) {
                    i = i3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return UInt.m276boximpl(i);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: minWithOrNull-eOHTfZs  reason: not valid java name */
    public static final UShort m833minWithOrNulleOHTfZs(@NotNull short[] sArr, @NotNull Comparator<? super UShort> comparator) {
        Intrinsics.checkNotNullParameter(sArr, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UShortArray.m343isEmptyimpl(sArr)) {
            return null;
        }
        short s = UShortArray.m340getMh2AYeg(sArr, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(sArr);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short s2 = UShortArray.m340getMh2AYeg(sArr, i);
                if (comparator.compare(UShort.m326boximpl(s), UShort.m326boximpl(s2)) > 0) {
                    s = s2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UShort.m326boximpl(s);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: minWithOrNull-zrEWJaI  reason: not valid java name */
    public static final ULong m834minWithOrNullzrEWJaI(@NotNull long[] jArr, @NotNull Comparator<? super ULong> comparator) {
        Intrinsics.checkNotNullParameter(jArr, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (ULongArray.m318isEmptyimpl(jArr)) {
            return null;
        }
        long j = ULongArray.m315getsVKNKU(jArr, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(jArr);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long j2 = ULongArray.m315getsVKNKU(jArr, i);
                if (comparator.compare(ULong.m301boximpl(j), ULong.m301boximpl(j2)) > 0) {
                    j = j2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return ULong.m301boximpl(j);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: plus-CFIt9YE  reason: not valid java name */
    public static final int[] m835plusCFIt9YE(@NotNull int[] iArr, @NotNull Collection<UInt> collection) {
        Intrinsics.checkNotNullParameter(iArr, "$this$plus");
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        int r0 = UIntArray.m291getSizeimpl(iArr);
        int[] copyOf = Arrays.copyOf(iArr, collection.size() + UIntArray.m291getSizeimpl(iArr));
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        for (UInt uInt : collection) {
            copyOf[r0] = uInt.m282unboximpl();
            r0++;
        }
        return UIntArray.m285constructorimpl(copyOf);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: plus-kzHmqpY  reason: not valid java name */
    public static final long[] m836pluskzHmqpY(@NotNull long[] jArr, @NotNull Collection<ULong> collection) {
        Intrinsics.checkNotNullParameter(jArr, "$this$plus");
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        int r0 = ULongArray.m316getSizeimpl(jArr);
        long[] copyOf = Arrays.copyOf(jArr, collection.size() + ULongArray.m316getSizeimpl(jArr));
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        for (ULong uLong : collection) {
            copyOf[r0] = uLong.m307unboximpl();
            r0++;
        }
        return ULongArray.m310constructorimpl(copyOf);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: plus-ojwP5H8  reason: not valid java name */
    public static final short[] m837plusojwP5H8(@NotNull short[] sArr, @NotNull Collection<UShort> collection) {
        Intrinsics.checkNotNullParameter(sArr, "$this$plus");
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        int r0 = UShortArray.m341getSizeimpl(sArr);
        short[] copyOf = Arrays.copyOf(sArr, collection.size() + UShortArray.m341getSizeimpl(sArr));
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        for (UShort uShort : collection) {
            copyOf[r0] = uShort.m332unboximpl();
            r0++;
        }
        return UShortArray.m335constructorimpl(copyOf);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: plus-xo_DsdI  reason: not valid java name */
    public static final byte[] m838plusxo_DsdI(@NotNull byte[] bArr, @NotNull Collection<UByte> collection) {
        Intrinsics.checkNotNullParameter(bArr, "$this$plus");
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        int r0 = UByteArray.m266getSizeimpl(bArr);
        byte[] copyOf = Arrays.copyOf(bArr, collection.size() + UByteArray.m266getSizeimpl(bArr));
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        for (UByte uByte : collection) {
            copyOf[r0] = uByte.m257unboximpl();
            r0++;
        }
        return UByteArray.m260constructorimpl(copyOf);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: random-2D5oskM  reason: not valid java name */
    public static final int m839random2D5oskM(@NotNull int[] iArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(iArr, "$this$random");
        Intrinsics.checkNotNullParameter(random, "random");
        if (!UIntArray.m293isEmptyimpl(iArr)) {
            return UIntArray.m290getpVg5ArA(iArr, random.nextInt(UIntArray.m291getSizeimpl(iArr)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: random-JzugnMA  reason: not valid java name */
    public static final long m840randomJzugnMA(@NotNull long[] jArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(jArr, "$this$random");
        Intrinsics.checkNotNullParameter(random, "random");
        if (!ULongArray.m318isEmptyimpl(jArr)) {
            return ULongArray.m315getsVKNKU(jArr, random.nextInt(ULongArray.m316getSizeimpl(jArr)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: random-oSF2wD8  reason: not valid java name */
    public static final byte m841randomoSF2wD8(@NotNull byte[] bArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(bArr, "$this$random");
        Intrinsics.checkNotNullParameter(random, "random");
        if (!UByteArray.m268isEmptyimpl(bArr)) {
            return UByteArray.m265getw2LRezQ(bArr, random.nextInt(UByteArray.m266getSizeimpl(bArr)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: random-s5X_as8  reason: not valid java name */
    public static final short m842randoms5X_as8(@NotNull short[] sArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(sArr, "$this$random");
        Intrinsics.checkNotNullParameter(random, "random");
        if (!UShortArray.m343isEmptyimpl(sArr)) {
            return UShortArray.m340getMh2AYeg(sArr, random.nextInt(UShortArray.m341getSizeimpl(sArr)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: randomOrNull-2D5oskM  reason: not valid java name */
    public static final UInt m843randomOrNull2D5oskM(@NotNull int[] iArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(iArr, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (UIntArray.m293isEmptyimpl(iArr)) {
            return null;
        }
        return UInt.m276boximpl(UIntArray.m290getpVg5ArA(iArr, random.nextInt(UIntArray.m291getSizeimpl(iArr))));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: randomOrNull-JzugnMA  reason: not valid java name */
    public static final ULong m844randomOrNullJzugnMA(@NotNull long[] jArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(jArr, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (ULongArray.m318isEmptyimpl(jArr)) {
            return null;
        }
        return ULong.m301boximpl(ULongArray.m315getsVKNKU(jArr, random.nextInt(ULongArray.m316getSizeimpl(jArr))));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: randomOrNull-oSF2wD8  reason: not valid java name */
    public static final UByte m845randomOrNulloSF2wD8(@NotNull byte[] bArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(bArr, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (UByteArray.m268isEmptyimpl(bArr)) {
            return null;
        }
        return UByte.m251boximpl(UByteArray.m265getw2LRezQ(bArr, random.nextInt(UByteArray.m266getSizeimpl(bArr))));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: randomOrNull-s5X_as8  reason: not valid java name */
    public static final UShort m846randomOrNulls5X_as8(@NotNull short[] sArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(sArr, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (UShortArray.m343isEmptyimpl(sArr)) {
            return null;
        }
        return UShort.m326boximpl(UShortArray.m340getMh2AYeg(sArr, random.nextInt(UShortArray.m341getSizeimpl(sArr))));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: reversed--ajY-9A  reason: not valid java name */
    public static final List<UInt> m847reversedajY9A(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$reversed");
        if (UIntArray.m293isEmptyimpl(iArr)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<UInt> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) Intrinsics.checkNotNullParameter(iArr, VKApiConst.VERSION));
        j.reverse(mutableList);
        return mutableList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: reversed-GBYM_sE  reason: not valid java name */
    public static final List<UByte> m848reversedGBYM_sE(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$reversed");
        if (UByteArray.m268isEmptyimpl(bArr)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<UByte> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) Intrinsics.checkNotNullParameter(bArr, VKApiConst.VERSION));
        j.reverse(mutableList);
        return mutableList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: reversed-QwZRm1k  reason: not valid java name */
    public static final List<ULong> m849reversedQwZRm1k(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$reversed");
        if (ULongArray.m318isEmptyimpl(jArr)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<ULong> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) Intrinsics.checkNotNullParameter(jArr, VKApiConst.VERSION));
        j.reverse(mutableList);
        return mutableList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: reversed-rL5Bavg  reason: not valid java name */
    public static final List<UShort> m850reversedrL5Bavg(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$reversed");
        if (UShortArray.m343isEmptyimpl(sArr)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<UShort> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) Intrinsics.checkNotNullParameter(sArr, VKApiConst.VERSION));
        j.reverse(mutableList);
        return mutableList;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: shuffle--ajY-9A  reason: not valid java name */
    public static final void m851shuffleajY9A(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$shuffle");
        m852shuffle2D5oskM(iArr, Random.Default);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: shuffle-2D5oskM  reason: not valid java name */
    public static final void m852shuffle2D5oskM(@NotNull int[] iArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(iArr, "$this$shuffle");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = ArraysKt___ArraysKt.getLastIndex(iArr); lastIndex >= 1; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            int i = UIntArray.m290getpVg5ArA(iArr, lastIndex);
            UIntArray.m295setVXSXFK8(iArr, lastIndex, UIntArray.m290getpVg5ArA(iArr, nextInt));
            UIntArray.m295setVXSXFK8(iArr, nextInt, i);
        }
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: shuffle-GBYM_sE  reason: not valid java name */
    public static final void m853shuffleGBYM_sE(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$shuffle");
        m856shuffleoSF2wD8(bArr, Random.Default);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: shuffle-JzugnMA  reason: not valid java name */
    public static final void m854shuffleJzugnMA(@NotNull long[] jArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(jArr, "$this$shuffle");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = ArraysKt___ArraysKt.getLastIndex(jArr); lastIndex >= 1; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            long j = ULongArray.m315getsVKNKU(jArr, lastIndex);
            ULongArray.m320setk8EXiF4(jArr, lastIndex, ULongArray.m315getsVKNKU(jArr, nextInt));
            ULongArray.m320setk8EXiF4(jArr, nextInt, j);
        }
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: shuffle-QwZRm1k  reason: not valid java name */
    public static final void m855shuffleQwZRm1k(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$shuffle");
        m854shuffleJzugnMA(jArr, Random.Default);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: shuffle-oSF2wD8  reason: not valid java name */
    public static final void m856shuffleoSF2wD8(@NotNull byte[] bArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(bArr, "$this$shuffle");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = ArraysKt___ArraysKt.getLastIndex(bArr); lastIndex >= 1; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            byte b2 = UByteArray.m265getw2LRezQ(bArr, lastIndex);
            UByteArray.m270setVurrAj0(bArr, lastIndex, UByteArray.m265getw2LRezQ(bArr, nextInt));
            UByteArray.m270setVurrAj0(bArr, nextInt, b2);
        }
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: shuffle-rL5Bavg  reason: not valid java name */
    public static final void m857shufflerL5Bavg(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$shuffle");
        m858shuffles5X_as8(sArr, Random.Default);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: shuffle-s5X_as8  reason: not valid java name */
    public static final void m858shuffles5X_as8(@NotNull short[] sArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(sArr, "$this$shuffle");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = ArraysKt___ArraysKt.getLastIndex(sArr); lastIndex >= 1; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            short s = UShortArray.m340getMh2AYeg(sArr, lastIndex);
            UShortArray.m345set01HTLdE(sArr, lastIndex, UShortArray.m340getMh2AYeg(sArr, nextInt));
            UShortArray.m345set01HTLdE(sArr, nextInt, s);
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: singleOrNull--ajY-9A  reason: not valid java name */
    public static final UInt m859singleOrNullajY9A(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$singleOrNull");
        if (UIntArray.m291getSizeimpl(iArr) == 1) {
            return UInt.m276boximpl(UIntArray.m290getpVg5ArA(iArr, 0));
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: singleOrNull-GBYM_sE  reason: not valid java name */
    public static final UByte m860singleOrNullGBYM_sE(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$singleOrNull");
        if (UByteArray.m266getSizeimpl(bArr) == 1) {
            return UByte.m251boximpl(UByteArray.m265getw2LRezQ(bArr, 0));
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: singleOrNull-QwZRm1k  reason: not valid java name */
    public static final ULong m861singleOrNullQwZRm1k(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$singleOrNull");
        if (ULongArray.m316getSizeimpl(jArr) == 1) {
            return ULong.m301boximpl(ULongArray.m315getsVKNKU(jArr, 0));
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: singleOrNull-rL5Bavg  reason: not valid java name */
    public static final UShort m862singleOrNullrL5Bavg(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$singleOrNull");
        if (UShortArray.m341getSizeimpl(sArr) == 1) {
            return UShort.m326boximpl(UShortArray.m340getMh2AYeg(sArr, 0));
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: slice-F7u83W8  reason: not valid java name */
    public static final List<ULong> m863sliceF7u83W8(@NotNull long[] jArr, @NotNull Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(jArr, "$this$slice");
        Intrinsics.checkNotNullParameter(iterable, "indices");
        int collectionSizeOrDefault = t6.n.e.collectionSizeOrDefault(iterable, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Integer num : iterable) {
            arrayList.add(ULong.m301boximpl(ULongArray.m315getsVKNKU(jArr, num.intValue())));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: slice-HwE9HBo  reason: not valid java name */
    public static final List<UInt> m864sliceHwE9HBo(@NotNull int[] iArr, @NotNull Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(iArr, "$this$slice");
        Intrinsics.checkNotNullParameter(iterable, "indices");
        int collectionSizeOrDefault = t6.n.e.collectionSizeOrDefault(iterable, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Integer num : iterable) {
            arrayList.add(UInt.m276boximpl(UIntArray.m290getpVg5ArA(iArr, num.intValue())));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: slice-JGPC0-M  reason: not valid java name */
    public static final List<UShort> m865sliceJGPC0M(@NotNull short[] sArr, @NotNull Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(sArr, "$this$slice");
        Intrinsics.checkNotNullParameter(iterable, "indices");
        int collectionSizeOrDefault = t6.n.e.collectionSizeOrDefault(iterable, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Integer num : iterable) {
            arrayList.add(UShort.m326boximpl(UShortArray.m340getMh2AYeg(sArr, num.intValue())));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: slice-JQknh5Q  reason: not valid java name */
    public static final List<UByte> m866sliceJQknh5Q(@NotNull byte[] bArr, @NotNull Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(bArr, "$this$slice");
        Intrinsics.checkNotNullParameter(iterable, "indices");
        int collectionSizeOrDefault = t6.n.e.collectionSizeOrDefault(iterable, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Integer num : iterable) {
            arrayList.add(UByte.m251boximpl(UByteArray.m265getw2LRezQ(bArr, num.intValue())));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: slice-Q6IL4kU  reason: not valid java name */
    public static final List<UShort> m867sliceQ6IL4kU(@NotNull short[] sArr, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(sArr, "$this$slice");
        Intrinsics.checkNotNullParameter(intRange, "indices");
        if (intRange.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return UArraysKt___UArraysJvmKt.m374asListrL5Bavg(UShortArray.m335constructorimpl(ArraysKt___ArraysJvmKt.copyOfRange(sArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: slice-ZRhS8yI  reason: not valid java name */
    public static final List<ULong> m868sliceZRhS8yI(@NotNull long[] jArr, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(jArr, "$this$slice");
        Intrinsics.checkNotNullParameter(intRange, "indices");
        if (intRange.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return UArraysKt___UArraysJvmKt.m373asListQwZRm1k(ULongArray.m310constructorimpl(ArraysKt___ArraysJvmKt.copyOfRange(jArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: slice-c0bezYM  reason: not valid java name */
    public static final List<UByte> m869slicec0bezYM(@NotNull byte[] bArr, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(bArr, "$this$slice");
        Intrinsics.checkNotNullParameter(intRange, "indices");
        if (intRange.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return UArraysKt___UArraysJvmKt.m372asListGBYM_sE(UByteArray.m260constructorimpl(ArraysKt___ArraysJvmKt.copyOfRange(bArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: slice-tAntMlw  reason: not valid java name */
    public static final List<UInt> m870slicetAntMlw(@NotNull int[] iArr, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(iArr, "$this$slice");
        Intrinsics.checkNotNullParameter(intRange, "indices");
        if (intRange.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return UArraysKt___UArraysJvmKt.m371asListajY9A(UIntArray.m285constructorimpl(ArraysKt___ArraysJvmKt.copyOfRange(iArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sliceArray-CFIt9YE  reason: not valid java name */
    public static final int[] m871sliceArrayCFIt9YE(@NotNull int[] iArr, @NotNull Collection<Integer> collection) {
        Intrinsics.checkNotNullParameter(iArr, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(collection, "indices");
        return UIntArray.m285constructorimpl(ArraysKt___ArraysKt.sliceArray(iArr, collection));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sliceArray-Q6IL4kU  reason: not valid java name */
    public static final short[] m872sliceArrayQ6IL4kU(@NotNull short[] sArr, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(sArr, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(intRange, "indices");
        return UShortArray.m335constructorimpl(ArraysKt___ArraysKt.sliceArray(sArr, intRange));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sliceArray-ZRhS8yI  reason: not valid java name */
    public static final long[] m873sliceArrayZRhS8yI(@NotNull long[] jArr, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(jArr, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(intRange, "indices");
        return ULongArray.m310constructorimpl(ArraysKt___ArraysKt.sliceArray(jArr, intRange));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sliceArray-c0bezYM  reason: not valid java name */
    public static final byte[] m874sliceArrayc0bezYM(@NotNull byte[] bArr, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(bArr, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(intRange, "indices");
        return UByteArray.m260constructorimpl(ArraysKt___ArraysKt.sliceArray(bArr, intRange));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sliceArray-kzHmqpY  reason: not valid java name */
    public static final long[] m875sliceArraykzHmqpY(@NotNull long[] jArr, @NotNull Collection<Integer> collection) {
        Intrinsics.checkNotNullParameter(jArr, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(collection, "indices");
        return ULongArray.m310constructorimpl(ArraysKt___ArraysKt.sliceArray(jArr, collection));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sliceArray-ojwP5H8  reason: not valid java name */
    public static final short[] m876sliceArrayojwP5H8(@NotNull short[] sArr, @NotNull Collection<Integer> collection) {
        Intrinsics.checkNotNullParameter(sArr, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(collection, "indices");
        return UShortArray.m335constructorimpl(ArraysKt___ArraysKt.sliceArray(sArr, collection));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sliceArray-tAntMlw  reason: not valid java name */
    public static final int[] m877sliceArraytAntMlw(@NotNull int[] iArr, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(iArr, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(intRange, "indices");
        return UIntArray.m285constructorimpl(ArraysKt___ArraysKt.sliceArray(iArr, intRange));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sliceArray-xo_DsdI  reason: not valid java name */
    public static final byte[] m878sliceArrayxo_DsdI(@NotNull byte[] bArr, @NotNull Collection<Integer> collection) {
        Intrinsics.checkNotNullParameter(bArr, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(collection, "indices");
        return UByteArray.m260constructorimpl(ArraysKt___ArraysKt.sliceArray(bArr, collection));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: sort--ajY-9A  reason: not valid java name */
    public static final void m879sortajY9A(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$sort");
        if (UIntArray.m291getSizeimpl(iArr) > 1) {
            UArraySortingKt.m366sortArrayoBK06Vg(iArr, 0, UIntArray.m291getSizeimpl(iArr));
        }
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: sort--nroSd4  reason: not valid java name */
    public static final void m880sortnroSd4(@NotNull long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(jArr, "$this$sort");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i, i2, ULongArray.m316getSizeimpl(jArr));
        UArraySortingKt.m363sortArraynroSd4(jArr, i, i2);
    }

    /* renamed from: sort--nroSd4$default  reason: not valid java name */
    public static /* synthetic */ void m881sortnroSd4$default(long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = ULongArray.m316getSizeimpl(jArr);
        }
        m880sortnroSd4(jArr, i, i2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: sort-4UcCI2c  reason: not valid java name */
    public static final void m882sort4UcCI2c(@NotNull byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$sort");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i, i2, UByteArray.m266getSizeimpl(bArr));
        UArraySortingKt.m364sortArray4UcCI2c(bArr, i, i2);
    }

    /* renamed from: sort-4UcCI2c$default  reason: not valid java name */
    public static /* synthetic */ void m883sort4UcCI2c$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = UByteArray.m266getSizeimpl(bArr);
        }
        m882sort4UcCI2c(bArr, i, i2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: sort-Aa5vz7o  reason: not valid java name */
    public static final void m884sortAa5vz7o(@NotNull short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(sArr, "$this$sort");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i, i2, UShortArray.m341getSizeimpl(sArr));
        UArraySortingKt.m365sortArrayAa5vz7o(sArr, i, i2);
    }

    /* renamed from: sort-Aa5vz7o$default  reason: not valid java name */
    public static /* synthetic */ void m885sortAa5vz7o$default(short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = UShortArray.m341getSizeimpl(sArr);
        }
        m884sortAa5vz7o(sArr, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: sort-GBYM_sE  reason: not valid java name */
    public static final void m886sortGBYM_sE(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$sort");
        if (UByteArray.m266getSizeimpl(bArr) > 1) {
            UArraySortingKt.m364sortArray4UcCI2c(bArr, 0, UByteArray.m266getSizeimpl(bArr));
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: sort-QwZRm1k  reason: not valid java name */
    public static final void m887sortQwZRm1k(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$sort");
        if (ULongArray.m316getSizeimpl(jArr) > 1) {
            UArraySortingKt.m363sortArraynroSd4(jArr, 0, ULongArray.m316getSizeimpl(jArr));
        }
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: sort-oBK06Vg  reason: not valid java name */
    public static final void m888sortoBK06Vg(@NotNull int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(iArr, "$this$sort");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i, i2, UIntArray.m291getSizeimpl(iArr));
        UArraySortingKt.m366sortArrayoBK06Vg(iArr, i, i2);
    }

    /* renamed from: sort-oBK06Vg$default  reason: not valid java name */
    public static /* synthetic */ void m889sortoBK06Vg$default(int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = UIntArray.m291getSizeimpl(iArr);
        }
        m888sortoBK06Vg(iArr, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: sort-rL5Bavg  reason: not valid java name */
    public static final void m890sortrL5Bavg(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$sort");
        if (UShortArray.m341getSizeimpl(sArr) > 1) {
            UArraySortingKt.m365sortArrayAa5vz7o(sArr, 0, UShortArray.m341getSizeimpl(sArr));
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: sortDescending--ajY-9A  reason: not valid java name */
    public static final void m891sortDescendingajY9A(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$sortDescending");
        if (UIntArray.m291getSizeimpl(iArr) > 1) {
            m879sortajY9A(iArr);
            ArraysKt___ArraysKt.reverse(iArr);
        }
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: sortDescending--nroSd4  reason: not valid java name */
    public static final void m892sortDescendingnroSd4(@NotNull long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(jArr, "$this$sortDescending");
        m880sortnroSd4(jArr, i, i2);
        ArraysKt___ArraysKt.reverse(jArr, i, i2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: sortDescending-4UcCI2c  reason: not valid java name */
    public static final void m893sortDescending4UcCI2c(@NotNull byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$sortDescending");
        m882sort4UcCI2c(bArr, i, i2);
        ArraysKt___ArraysKt.reverse(bArr, i, i2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: sortDescending-Aa5vz7o  reason: not valid java name */
    public static final void m894sortDescendingAa5vz7o(@NotNull short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(sArr, "$this$sortDescending");
        m884sortAa5vz7o(sArr, i, i2);
        ArraysKt___ArraysKt.reverse(sArr, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: sortDescending-GBYM_sE  reason: not valid java name */
    public static final void m895sortDescendingGBYM_sE(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$sortDescending");
        if (UByteArray.m266getSizeimpl(bArr) > 1) {
            m886sortGBYM_sE(bArr);
            ArraysKt___ArraysKt.reverse(bArr);
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: sortDescending-QwZRm1k  reason: not valid java name */
    public static final void m896sortDescendingQwZRm1k(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$sortDescending");
        if (ULongArray.m316getSizeimpl(jArr) > 1) {
            m887sortQwZRm1k(jArr);
            ArraysKt___ArraysKt.reverse(jArr);
        }
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: sortDescending-oBK06Vg  reason: not valid java name */
    public static final void m897sortDescendingoBK06Vg(@NotNull int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(iArr, "$this$sortDescending");
        m888sortoBK06Vg(iArr, i, i2);
        ArraysKt___ArraysKt.reverse(iArr, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: sortDescending-rL5Bavg  reason: not valid java name */
    public static final void m898sortDescendingrL5Bavg(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$sortDescending");
        if (UShortArray.m341getSizeimpl(sArr) > 1) {
            m890sortrL5Bavg(sArr);
            ArraysKt___ArraysKt.reverse(sArr);
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sorted--ajY-9A  reason: not valid java name */
    public static final List<UInt> m899sortedajY9A(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$sorted");
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        int[] r1 = UIntArray.m285constructorimpl(copyOf);
        m879sortajY9A(r1);
        return UArraysKt___UArraysJvmKt.m371asListajY9A(r1);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sorted-GBYM_sE  reason: not valid java name */
    public static final List<UByte> m900sortedGBYM_sE(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$sorted");
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        byte[] r1 = UByteArray.m260constructorimpl(copyOf);
        m886sortGBYM_sE(r1);
        return UArraysKt___UArraysJvmKt.m372asListGBYM_sE(r1);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sorted-QwZRm1k  reason: not valid java name */
    public static final List<ULong> m901sortedQwZRm1k(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$sorted");
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        long[] r1 = ULongArray.m310constructorimpl(copyOf);
        m887sortQwZRm1k(r1);
        return UArraysKt___UArraysJvmKt.m373asListQwZRm1k(r1);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sorted-rL5Bavg  reason: not valid java name */
    public static final List<UShort> m902sortedrL5Bavg(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$sorted");
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        short[] r1 = UShortArray.m335constructorimpl(copyOf);
        m890sortrL5Bavg(r1);
        return UArraysKt___UArraysJvmKt.m374asListrL5Bavg(r1);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedArray--ajY-9A  reason: not valid java name */
    public static final int[] m903sortedArrayajY9A(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$sortedArray");
        if (UIntArray.m293isEmptyimpl(iArr)) {
            return iArr;
        }
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        int[] r1 = UIntArray.m285constructorimpl(copyOf);
        m879sortajY9A(r1);
        return r1;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedArray-GBYM_sE  reason: not valid java name */
    public static final byte[] m904sortedArrayGBYM_sE(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$sortedArray");
        if (UByteArray.m268isEmptyimpl(bArr)) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        byte[] r1 = UByteArray.m260constructorimpl(copyOf);
        m886sortGBYM_sE(r1);
        return r1;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedArray-QwZRm1k  reason: not valid java name */
    public static final long[] m905sortedArrayQwZRm1k(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$sortedArray");
        if (ULongArray.m318isEmptyimpl(jArr)) {
            return jArr;
        }
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        long[] r1 = ULongArray.m310constructorimpl(copyOf);
        m887sortQwZRm1k(r1);
        return r1;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedArray-rL5Bavg  reason: not valid java name */
    public static final short[] m906sortedArrayrL5Bavg(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$sortedArray");
        if (UShortArray.m343isEmptyimpl(sArr)) {
            return sArr;
        }
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        short[] r1 = UShortArray.m335constructorimpl(copyOf);
        m890sortrL5Bavg(r1);
        return r1;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedArrayDescending--ajY-9A  reason: not valid java name */
    public static final int[] m907sortedArrayDescendingajY9A(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$sortedArrayDescending");
        if (UIntArray.m293isEmptyimpl(iArr)) {
            return iArr;
        }
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        int[] r1 = UIntArray.m285constructorimpl(copyOf);
        m891sortDescendingajY9A(r1);
        return r1;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedArrayDescending-GBYM_sE  reason: not valid java name */
    public static final byte[] m908sortedArrayDescendingGBYM_sE(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$sortedArrayDescending");
        if (UByteArray.m268isEmptyimpl(bArr)) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        byte[] r1 = UByteArray.m260constructorimpl(copyOf);
        m895sortDescendingGBYM_sE(r1);
        return r1;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedArrayDescending-QwZRm1k  reason: not valid java name */
    public static final long[] m909sortedArrayDescendingQwZRm1k(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$sortedArrayDescending");
        if (ULongArray.m318isEmptyimpl(jArr)) {
            return jArr;
        }
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        long[] r1 = ULongArray.m310constructorimpl(copyOf);
        m896sortDescendingQwZRm1k(r1);
        return r1;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedArrayDescending-rL5Bavg  reason: not valid java name */
    public static final short[] m910sortedArrayDescendingrL5Bavg(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$sortedArrayDescending");
        if (UShortArray.m343isEmptyimpl(sArr)) {
            return sArr;
        }
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        short[] r1 = UShortArray.m335constructorimpl(copyOf);
        m898sortDescendingrL5Bavg(r1);
        return r1;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedDescending--ajY-9A  reason: not valid java name */
    public static final List<UInt> m911sortedDescendingajY9A(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$sortedDescending");
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        int[] r1 = UIntArray.m285constructorimpl(copyOf);
        m879sortajY9A(r1);
        return m847reversedajY9A(r1);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedDescending-GBYM_sE  reason: not valid java name */
    public static final List<UByte> m912sortedDescendingGBYM_sE(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$sortedDescending");
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        byte[] r1 = UByteArray.m260constructorimpl(copyOf);
        m886sortGBYM_sE(r1);
        return m848reversedGBYM_sE(r1);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedDescending-QwZRm1k  reason: not valid java name */
    public static final List<ULong> m913sortedDescendingQwZRm1k(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$sortedDescending");
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        long[] r1 = ULongArray.m310constructorimpl(copyOf);
        m887sortQwZRm1k(r1);
        return m849reversedQwZRm1k(r1);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedDescending-rL5Bavg  reason: not valid java name */
    public static final List<UShort> m914sortedDescendingrL5Bavg(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$sortedDescending");
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        short[] r1 = UShortArray.m335constructorimpl(copyOf);
        m890sortrL5Bavg(r1);
        return m850reversedrL5Bavg(r1);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @JvmName(name = "sumOfUByte")
    public static final int sumOfUByte(@NotNull UByte[] uByteArr) {
        Intrinsics.checkNotNullParameter(uByteArr, "$this$sum");
        int i = 0;
        for (UByte uByte : uByteArr) {
            i = UInt.m277constructorimpl(UInt.m277constructorimpl(uByte.m257unboximpl() & 255) + i);
        }
        return i;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @JvmName(name = "sumOfUInt")
    public static final int sumOfUInt(@NotNull UInt[] uIntArr) {
        Intrinsics.checkNotNullParameter(uIntArr, "$this$sum");
        int i = 0;
        for (UInt uInt : uIntArr) {
            i = UInt.m277constructorimpl(uInt.m282unboximpl() + i);
        }
        return i;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @JvmName(name = "sumOfULong")
    public static final long sumOfULong(@NotNull ULong[] uLongArr) {
        Intrinsics.checkNotNullParameter(uLongArr, "$this$sum");
        long j = 0;
        for (ULong uLong : uLongArr) {
            j = ULong.m302constructorimpl(uLong.m307unboximpl() + j);
        }
        return j;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @JvmName(name = "sumOfUShort")
    public static final int sumOfUShort(@NotNull UShort[] uShortArr) {
        Intrinsics.checkNotNullParameter(uShortArr, "$this$sum");
        int i = 0;
        for (UShort uShort : uShortArr) {
            i = UInt.m277constructorimpl(UInt.m277constructorimpl(uShort.m332unboximpl() & UShort.MAX_VALUE) + i);
        }
        return i;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: take-PpDY95g  reason: not valid java name */
    public static final List<UByte> m915takePpDY95g(@NotNull byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "$this$take");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i, " is less than zero.").toString());
        } else if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            if (i >= UByteArray.m266getSizeimpl(bArr)) {
                return CollectionsKt___CollectionsKt.toList(Intrinsics.checkNotNullParameter(bArr, VKApiConst.VERSION));
            }
            if (i == 1) {
                return t6.n.d.listOf(UByte.m251boximpl(UByteArray.m265getw2LRezQ(bArr, 0)));
            }
            ArrayList arrayList = new ArrayList(i);
            int i2 = 0;
            for (byte b2 : bArr) {
                arrayList.add(UByte.m251boximpl(b2));
                i2++;
                if (i2 == i) {
                    break;
                }
            }
            return arrayList;
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: take-nggk6HY  reason: not valid java name */
    public static final List<UShort> m916takenggk6HY(@NotNull short[] sArr, int i) {
        Intrinsics.checkNotNullParameter(sArr, "$this$take");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i, " is less than zero.").toString());
        } else if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            if (i >= UShortArray.m341getSizeimpl(sArr)) {
                return CollectionsKt___CollectionsKt.toList(Intrinsics.checkNotNullParameter(sArr, VKApiConst.VERSION));
            }
            if (i == 1) {
                return t6.n.d.listOf(UShort.m326boximpl(UShortArray.m340getMh2AYeg(sArr, 0)));
            }
            ArrayList arrayList = new ArrayList(i);
            int i2 = 0;
            for (short s : sArr) {
                arrayList.add(UShort.m326boximpl(s));
                i2++;
                if (i2 == i) {
                    break;
                }
            }
            return arrayList;
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: take-qFRl0hI  reason: not valid java name */
    public static final List<UInt> m917takeqFRl0hI(@NotNull int[] iArr, int i) {
        Intrinsics.checkNotNullParameter(iArr, "$this$take");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i, " is less than zero.").toString());
        } else if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            if (i >= UIntArray.m291getSizeimpl(iArr)) {
                return CollectionsKt___CollectionsKt.toList(Intrinsics.checkNotNullParameter(iArr, VKApiConst.VERSION));
            }
            if (i == 1) {
                return t6.n.d.listOf(UInt.m276boximpl(UIntArray.m290getpVg5ArA(iArr, 0)));
            }
            ArrayList arrayList = new ArrayList(i);
            int i2 = 0;
            for (int i3 : iArr) {
                arrayList.add(UInt.m276boximpl(i3));
                i2++;
                if (i2 == i) {
                    break;
                }
            }
            return arrayList;
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: take-r7IrZao  reason: not valid java name */
    public static final List<ULong> m918taker7IrZao(@NotNull long[] jArr, int i) {
        Intrinsics.checkNotNullParameter(jArr, "$this$take");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i, " is less than zero.").toString());
        } else if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            if (i >= ULongArray.m316getSizeimpl(jArr)) {
                return CollectionsKt___CollectionsKt.toList(Intrinsics.checkNotNullParameter(jArr, VKApiConst.VERSION));
            }
            if (i == 1) {
                return t6.n.d.listOf(ULong.m301boximpl(ULongArray.m315getsVKNKU(jArr, 0)));
            }
            ArrayList arrayList = new ArrayList(i);
            int i2 = 0;
            for (long j : jArr) {
                arrayList.add(ULong.m301boximpl(j));
                i2++;
                if (i2 == i) {
                    break;
                }
            }
            return arrayList;
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: takeLast-PpDY95g  reason: not valid java name */
    public static final List<UByte> m919takeLastPpDY95g(@NotNull byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "$this$takeLast");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i, " is less than zero.").toString());
        } else if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            int r1 = UByteArray.m266getSizeimpl(bArr);
            if (i >= r1) {
                return CollectionsKt___CollectionsKt.toList(Intrinsics.checkNotNullParameter(bArr, VKApiConst.VERSION));
            }
            if (i == 1) {
                return t6.n.d.listOf(UByte.m251boximpl(UByteArray.m265getw2LRezQ(bArr, r1 - 1)));
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = r1 - i; i2 < r1; i2++) {
                arrayList.add(UByte.m251boximpl(UByteArray.m265getw2LRezQ(bArr, i2)));
            }
            return arrayList;
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: takeLast-nggk6HY  reason: not valid java name */
    public static final List<UShort> m920takeLastnggk6HY(@NotNull short[] sArr, int i) {
        Intrinsics.checkNotNullParameter(sArr, "$this$takeLast");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i, " is less than zero.").toString());
        } else if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            int r1 = UShortArray.m341getSizeimpl(sArr);
            if (i >= r1) {
                return CollectionsKt___CollectionsKt.toList(Intrinsics.checkNotNullParameter(sArr, VKApiConst.VERSION));
            }
            if (i == 1) {
                return t6.n.d.listOf(UShort.m326boximpl(UShortArray.m340getMh2AYeg(sArr, r1 - 1)));
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = r1 - i; i2 < r1; i2++) {
                arrayList.add(UShort.m326boximpl(UShortArray.m340getMh2AYeg(sArr, i2)));
            }
            return arrayList;
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: takeLast-qFRl0hI  reason: not valid java name */
    public static final List<UInt> m921takeLastqFRl0hI(@NotNull int[] iArr, int i) {
        Intrinsics.checkNotNullParameter(iArr, "$this$takeLast");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i, " is less than zero.").toString());
        } else if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            int r1 = UIntArray.m291getSizeimpl(iArr);
            if (i >= r1) {
                return CollectionsKt___CollectionsKt.toList(Intrinsics.checkNotNullParameter(iArr, VKApiConst.VERSION));
            }
            if (i == 1) {
                return t6.n.d.listOf(UInt.m276boximpl(UIntArray.m290getpVg5ArA(iArr, r1 - 1)));
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = r1 - i; i2 < r1; i2++) {
                arrayList.add(UInt.m276boximpl(UIntArray.m290getpVg5ArA(iArr, i2)));
            }
            return arrayList;
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: takeLast-r7IrZao  reason: not valid java name */
    public static final List<ULong> m922takeLastr7IrZao(@NotNull long[] jArr, int i) {
        Intrinsics.checkNotNullParameter(jArr, "$this$takeLast");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i, " is less than zero.").toString());
        } else if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            int r1 = ULongArray.m316getSizeimpl(jArr);
            if (i >= r1) {
                return CollectionsKt___CollectionsKt.toList(Intrinsics.checkNotNullParameter(jArr, VKApiConst.VERSION));
            }
            if (i == 1) {
                return t6.n.d.listOf(ULong.m301boximpl(ULongArray.m315getsVKNKU(jArr, r1 - 1)));
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = r1 - i; i2 < r1; i2++) {
                arrayList.add(ULong.m301boximpl(ULongArray.m315getsVKNKU(jArr, i2)));
            }
            return arrayList;
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: toTypedArray--ajY-9A  reason: not valid java name */
    public static final UInt[] m923toTypedArrayajY9A(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$toTypedArray");
        int r0 = UIntArray.m291getSizeimpl(iArr);
        UInt[] uIntArr = new UInt[r0];
        for (int i = 0; i < r0; i++) {
            uIntArr[i] = UInt.m276boximpl(UIntArray.m290getpVg5ArA(iArr, i));
        }
        return uIntArr;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: toTypedArray-GBYM_sE  reason: not valid java name */
    public static final UByte[] m924toTypedArrayGBYM_sE(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$toTypedArray");
        int r0 = UByteArray.m266getSizeimpl(bArr);
        UByte[] uByteArr = new UByte[r0];
        for (int i = 0; i < r0; i++) {
            uByteArr[i] = UByte.m251boximpl(UByteArray.m265getw2LRezQ(bArr, i));
        }
        return uByteArr;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: toTypedArray-QwZRm1k  reason: not valid java name */
    public static final ULong[] m925toTypedArrayQwZRm1k(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$toTypedArray");
        int r0 = ULongArray.m316getSizeimpl(jArr);
        ULong[] uLongArr = new ULong[r0];
        for (int i = 0; i < r0; i++) {
            uLongArr[i] = ULong.m301boximpl(ULongArray.m315getsVKNKU(jArr, i));
        }
        return uLongArr;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: toTypedArray-rL5Bavg  reason: not valid java name */
    public static final UShort[] m926toTypedArrayrL5Bavg(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$toTypedArray");
        int r0 = UShortArray.m341getSizeimpl(sArr);
        UShort[] uShortArr = new UShort[r0];
        for (int i = 0; i < r0; i++) {
            uShortArr[i] = UShort.m326boximpl(UShortArray.m340getMh2AYeg(sArr, i));
        }
        return uShortArr;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final byte[] toUByteArray(@NotNull UByte[] uByteArr) {
        Intrinsics.checkNotNullParameter(uByteArr, "$this$toUByteArray");
        int length = uByteArr.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = uByteArr[i].m257unboximpl();
        }
        return UByteArray.m260constructorimpl(bArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final int[] toUIntArray(@NotNull UInt[] uIntArr) {
        Intrinsics.checkNotNullParameter(uIntArr, "$this$toUIntArray");
        int length = uIntArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = uIntArr[i].m282unboximpl();
        }
        return UIntArray.m285constructorimpl(iArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final long[] toULongArray(@NotNull ULong[] uLongArr) {
        Intrinsics.checkNotNullParameter(uLongArr, "$this$toULongArray");
        int length = uLongArr.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = uLongArr[i].m307unboximpl();
        }
        return ULongArray.m310constructorimpl(jArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final short[] toUShortArray(@NotNull UShort[] uShortArr) {
        Intrinsics.checkNotNullParameter(uShortArr, "$this$toUShortArray");
        int length = uShortArr.length;
        short[] sArr = new short[length];
        for (int i = 0; i < length; i++) {
            sArr[i] = uShortArr[i].m332unboximpl();
        }
        return UShortArray.m335constructorimpl(sArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: withIndex--ajY-9A  reason: not valid java name */
    public static final Iterable<IndexedValue<UInt>> m927withIndexajY9A(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$withIndex");
        return new IndexingIterable(new C0679a(iArr));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: withIndex-GBYM_sE  reason: not valid java name */
    public static final Iterable<IndexedValue<UByte>> m928withIndexGBYM_sE(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$withIndex");
        return new IndexingIterable(new c(bArr));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: withIndex-QwZRm1k  reason: not valid java name */
    public static final Iterable<IndexedValue<ULong>> m929withIndexQwZRm1k(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$withIndex");
        return new IndexingIterable(new b(jArr));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: withIndex-rL5Bavg  reason: not valid java name */
    public static final Iterable<IndexedValue<UShort>> m930withIndexrL5Bavg(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$withIndex");
        return new IndexingIterable(new d(sArr));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-C-E_24M  reason: not valid java name */
    public static final <R> List<Pair<UInt, R>> m931zipCE_24M(@NotNull int[] iArr, @NotNull R[] rArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$zip");
        Intrinsics.checkNotNullParameter(rArr, "other");
        int min = Math.min(UIntArray.m291getSizeimpl(iArr), rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            int i2 = UIntArray.m290getpVg5ArA(iArr, i);
            arrayList.add(TuplesKt.to(UInt.m276boximpl(i2), rArr[i]));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-F7u83W8  reason: not valid java name */
    public static final <R> List<Pair<ULong, R>> m932zipF7u83W8(@NotNull long[] jArr, @NotNull Iterable<? extends R> iterable) {
        Intrinsics.checkNotNullParameter(jArr, "$this$zip");
        Intrinsics.checkNotNullParameter(iterable, "other");
        int r0 = ULongArray.m316getSizeimpl(jArr);
        ArrayList arrayList = new ArrayList(Math.min(t6.n.e.collectionSizeOrDefault(iterable, 10), r0));
        int i = 0;
        for (Object obj : iterable) {
            if (i >= r0) {
                break;
            }
            arrayList.add(TuplesKt.to(ULong.m301boximpl(ULongArray.m315getsVKNKU(jArr, i)), obj));
            i++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-HwE9HBo  reason: not valid java name */
    public static final <R> List<Pair<UInt, R>> m933zipHwE9HBo(@NotNull int[] iArr, @NotNull Iterable<? extends R> iterable) {
        Intrinsics.checkNotNullParameter(iArr, "$this$zip");
        Intrinsics.checkNotNullParameter(iterable, "other");
        int r0 = UIntArray.m291getSizeimpl(iArr);
        ArrayList arrayList = new ArrayList(Math.min(t6.n.e.collectionSizeOrDefault(iterable, 10), r0));
        int i = 0;
        for (Object obj : iterable) {
            if (i >= r0) {
                break;
            }
            arrayList.add(TuplesKt.to(UInt.m276boximpl(UIntArray.m290getpVg5ArA(iArr, i)), obj));
            i++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-JGPC0-M  reason: not valid java name */
    public static final <R> List<Pair<UShort, R>> m934zipJGPC0M(@NotNull short[] sArr, @NotNull Iterable<? extends R> iterable) {
        Intrinsics.checkNotNullParameter(sArr, "$this$zip");
        Intrinsics.checkNotNullParameter(iterable, "other");
        int r0 = UShortArray.m341getSizeimpl(sArr);
        ArrayList arrayList = new ArrayList(Math.min(t6.n.e.collectionSizeOrDefault(iterable, 10), r0));
        int i = 0;
        for (Object obj : iterable) {
            if (i >= r0) {
                break;
            }
            arrayList.add(TuplesKt.to(UShort.m326boximpl(UShortArray.m340getMh2AYeg(sArr, i)), obj));
            i++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-JQknh5Q  reason: not valid java name */
    public static final <R> List<Pair<UByte, R>> m935zipJQknh5Q(@NotNull byte[] bArr, @NotNull Iterable<? extends R> iterable) {
        Intrinsics.checkNotNullParameter(bArr, "$this$zip");
        Intrinsics.checkNotNullParameter(iterable, "other");
        int r0 = UByteArray.m266getSizeimpl(bArr);
        ArrayList arrayList = new ArrayList(Math.min(t6.n.e.collectionSizeOrDefault(iterable, 10), r0));
        int i = 0;
        for (Object obj : iterable) {
            if (i >= r0) {
                break;
            }
            arrayList.add(TuplesKt.to(UByte.m251boximpl(UByteArray.m265getw2LRezQ(bArr, i)), obj));
            i++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-ctEhBpI  reason: not valid java name */
    public static final List<Pair<UInt, UInt>> m936zipctEhBpI(@NotNull int[] iArr, @NotNull int[] iArr2) {
        Intrinsics.checkNotNullParameter(iArr, "$this$zip");
        Intrinsics.checkNotNullParameter(iArr2, "other");
        int min = Math.min(UIntArray.m291getSizeimpl(iArr), UIntArray.m291getSizeimpl(iArr2));
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(TuplesKt.to(UInt.m276boximpl(UIntArray.m290getpVg5ArA(iArr, i)), UInt.m276boximpl(UIntArray.m290getpVg5ArA(iArr2, i))));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-f7H3mmw  reason: not valid java name */
    public static final <R> List<Pair<ULong, R>> m937zipf7H3mmw(@NotNull long[] jArr, @NotNull R[] rArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$zip");
        Intrinsics.checkNotNullParameter(rArr, "other");
        int min = Math.min(ULongArray.m316getSizeimpl(jArr), rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            long j = ULongArray.m315getsVKNKU(jArr, i);
            arrayList.add(TuplesKt.to(ULong.m301boximpl(j), rArr[i]));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-kdPth3s  reason: not valid java name */
    public static final List<Pair<UByte, UByte>> m938zipkdPth3s(@NotNull byte[] bArr, @NotNull byte[] bArr2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$zip");
        Intrinsics.checkNotNullParameter(bArr2, "other");
        int min = Math.min(UByteArray.m266getSizeimpl(bArr), UByteArray.m266getSizeimpl(bArr2));
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(TuplesKt.to(UByte.m251boximpl(UByteArray.m265getw2LRezQ(bArr, i)), UByte.m251boximpl(UByteArray.m265getw2LRezQ(bArr2, i))));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-mazbYpA  reason: not valid java name */
    public static final List<Pair<UShort, UShort>> m939zipmazbYpA(@NotNull short[] sArr, @NotNull short[] sArr2) {
        Intrinsics.checkNotNullParameter(sArr, "$this$zip");
        Intrinsics.checkNotNullParameter(sArr2, "other");
        int min = Math.min(UShortArray.m341getSizeimpl(sArr), UShortArray.m341getSizeimpl(sArr2));
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(TuplesKt.to(UShort.m326boximpl(UShortArray.m340getMh2AYeg(sArr, i)), UShort.m326boximpl(UShortArray.m340getMh2AYeg(sArr2, i))));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-nl983wc  reason: not valid java name */
    public static final <R> List<Pair<UByte, R>> m940zipnl983wc(@NotNull byte[] bArr, @NotNull R[] rArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$zip");
        Intrinsics.checkNotNullParameter(rArr, "other");
        int min = Math.min(UByteArray.m266getSizeimpl(bArr), rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            byte b2 = UByteArray.m265getw2LRezQ(bArr, i);
            arrayList.add(TuplesKt.to(UByte.m251boximpl(b2), rArr[i]));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-uaTIQ5s  reason: not valid java name */
    public static final <R> List<Pair<UShort, R>> m941zipuaTIQ5s(@NotNull short[] sArr, @NotNull R[] rArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$zip");
        Intrinsics.checkNotNullParameter(rArr, "other");
        int min = Math.min(UShortArray.m341getSizeimpl(sArr), rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            short s = UShortArray.m340getMh2AYeg(sArr, i);
            arrayList.add(TuplesKt.to(UShort.m326boximpl(s), rArr[i]));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-us8wMrg  reason: not valid java name */
    public static final List<Pair<ULong, ULong>> m942zipus8wMrg(@NotNull long[] jArr, @NotNull long[] jArr2) {
        Intrinsics.checkNotNullParameter(jArr, "$this$zip");
        Intrinsics.checkNotNullParameter(jArr2, "other");
        int min = Math.min(ULongArray.m316getSizeimpl(jArr), ULongArray.m316getSizeimpl(jArr2));
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(TuplesKt.to(ULong.m301boximpl(ULongArray.m315getsVKNKU(jArr, i)), ULong.m301boximpl(ULongArray.m315getsVKNKU(jArr2, i))));
        }
        return arrayList;
    }
}
