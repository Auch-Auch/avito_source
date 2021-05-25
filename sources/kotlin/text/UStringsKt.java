package kotlin.text;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.asn1.cmc.BodyPartID;
import t6.y.a;
import t6.y.l;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\u001a\u001e\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001e\u0010\u0006\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001e\u0010\u0006\u001a\u00020\u0003*\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001e\u0010\u0006\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0016\u0010\u0010\u001a\u00020\u0000*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001e\u0010\u0010\u001a\u00020\u0000*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0012\u001a\u0016\u0010\u0013\u001a\u00020\u0007*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001e\u0010\u0013\u001a\u00020\u0007*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0015\u001a\u0016\u0010\u0016\u001a\u00020\n*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001e\u0010\u0016\u001a\u00020\n*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0018\u001a\u0016\u0010\u0019\u001a\u00020\r*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001e\u0010\u0019\u001a\u00020\r*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001b\u001a\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u0000*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a \u0010\u001c\u001a\u0004\u0018\u00010\u0000*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001e\u001a\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u0007*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a \u0010\u001f\u001a\u0004\u0018\u00010\u0007*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010!\u001a\u0018\u0010\"\u001a\u0004\u0018\u00010\n*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a \u0010\"\u001a\u0004\u0018\u00010\n*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010$\u001a\u0018\u0010%\u001a\u0004\u0018\u00010\r*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a \u0010%\u001a\u0004\u0018\u00010\r*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010'\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lkotlin/UByte;", "", "radix", "", "toString-LxnNnR4", "(BI)Ljava/lang/String;", "toString", "Lkotlin/UShort;", "toString-olVBNx4", "(SI)Ljava/lang/String;", "Lkotlin/UInt;", "toString-V7xB4Y4", "(II)Ljava/lang/String;", "Lkotlin/ULong;", "toString-JSWoG40", "(JI)Ljava/lang/String;", "toUByte", "(Ljava/lang/String;)B", "(Ljava/lang/String;I)B", "toUShort", "(Ljava/lang/String;)S", "(Ljava/lang/String;I)S", "toUInt", "(Ljava/lang/String;)I", "(Ljava/lang/String;I)I", "toULong", "(Ljava/lang/String;)J", "(Ljava/lang/String;I)J", "toUByteOrNull", "(Ljava/lang/String;)Lkotlin/UByte;", "(Ljava/lang/String;I)Lkotlin/UByte;", "toUShortOrNull", "(Ljava/lang/String;)Lkotlin/UShort;", "(Ljava/lang/String;I)Lkotlin/UShort;", "toUIntOrNull", "(Ljava/lang/String;)Lkotlin/UInt;", "(Ljava/lang/String;I)Lkotlin/UInt;", "toULongOrNull", "(Ljava/lang/String;)Lkotlin/ULong;", "(Ljava/lang/String;I)Lkotlin/ULong;", "kotlin-stdlib"}, k = 2, mv = {1, 4, 1})
@JvmName(name = "UStringsKt")
public final class UStringsKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: toString-JSWoG40  reason: not valid java name */
    public static final String m435toStringJSWoG40(long j, int i) {
        return UnsignedKt.ulongToString(j, a.checkRadix(i));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: toString-LxnNnR4  reason: not valid java name */
    public static final String m436toStringLxnNnR4(byte b, int i) {
        String num = Integer.toString(b & 255, a.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: toString-V7xB4Y4  reason: not valid java name */
    public static final String m437toStringV7xB4Y4(int i, int i2) {
        String l = Long.toString(((long) i) & BodyPartID.bodyIdMax, a.checkRadix(i2));
        Intrinsics.checkNotNullExpressionValue(l, "java.lang.Long.toString(this, checkRadix(radix))");
        return l;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: toString-olVBNx4  reason: not valid java name */
    public static final String m438toStringolVBNx4(short s, int i) {
        String num = Integer.toString(s & UShort.MAX_VALUE, a.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final byte toUByte(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$toUByte");
        UByte uByteOrNull = toUByteOrNull(str);
        if (uByteOrNull != null) {
            return uByteOrNull.m257unboximpl();
        }
        l.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    public static final UByte toUByteOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$toUByteOrNull");
        return toUByteOrNull(str, 10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int toUInt(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$toUInt");
        UInt uIntOrNull = toUIntOrNull(str);
        if (uIntOrNull != null) {
            return uIntOrNull.m282unboximpl();
        }
        l.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    public static final UInt toUIntOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$toUIntOrNull");
        return toUIntOrNull(str, 10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final long toULong(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$toULong");
        ULong uLongOrNull = toULongOrNull(str);
        if (uLongOrNull != null) {
            return uLongOrNull.m307unboximpl();
        }
        l.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    public static final ULong toULongOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$toULongOrNull");
        return toULongOrNull(str, 10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final short toUShort(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$toUShort");
        UShort uShortOrNull = toUShortOrNull(str);
        if (uShortOrNull != null) {
            return uShortOrNull.m332unboximpl();
        }
        l.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    public static final UShort toUShortOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$toUShortOrNull");
        return toUShortOrNull(str, 10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final byte toUByte(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "$this$toUByte");
        UByte uByteOrNull = toUByteOrNull(str, i);
        if (uByteOrNull != null) {
            return uByteOrNull.m257unboximpl();
        }
        l.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    public static final UByte toUByteOrNull(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "$this$toUByteOrNull");
        UInt uIntOrNull = toUIntOrNull(str, i);
        if (uIntOrNull == null) {
            return null;
        }
        int r1 = uIntOrNull.m282unboximpl();
        if (UnsignedKt.uintCompare(r1, UInt.m277constructorimpl(255)) > 0) {
            return null;
        }
        return UByte.m251boximpl(UByte.m252constructorimpl((byte) r1));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int toUInt(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "$this$toUInt");
        UInt uIntOrNull = toUIntOrNull(str, i);
        if (uIntOrNull != null) {
            return uIntOrNull.m282unboximpl();
        }
        l.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    public static final UInt toUIntOrNull(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "$this$toUIntOrNull");
        a.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char charAt = str.charAt(0);
        int i3 = 1;
        if (Intrinsics.compare((int) charAt, 48) >= 0) {
            i3 = 0;
        } else if (length == 1 || charAt != '+') {
            return null;
        }
        int r5 = UInt.m277constructorimpl(i);
        int i4 = 119304647;
        while (i3 < length) {
            int digitOf = a.digitOf(str.charAt(i3), i);
            if (digitOf < 0) {
                return null;
            }
            if (UnsignedKt.uintCompare(i2, i4) > 0) {
                if (i4 == 119304647) {
                    i4 = UnsignedKt.m351uintDivideJ1ME1BU(-1, r5);
                    if (UnsignedKt.uintCompare(i2, i4) > 0) {
                    }
                }
                return null;
            }
            int r3 = UInt.m277constructorimpl(i2 * r5);
            int r8 = UInt.m277constructorimpl(UInt.m277constructorimpl(digitOf) + r3);
            if (UnsignedKt.uintCompare(r8, r3) < 0) {
                return null;
            }
            i3++;
            i2 = r8;
        }
        return UInt.m276boximpl(i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final long toULong(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "$this$toULong");
        ULong uLongOrNull = toULongOrNull(str, i);
        if (uLongOrNull != null) {
            return uLongOrNull.m307unboximpl();
        }
        l.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    public static final ULong toULongOrNull(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "$this$toULongOrNull");
        a.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        long j = -1;
        int i2 = 0;
        char charAt = str.charAt(0);
        if (Intrinsics.compare((int) charAt, 48) < 0) {
            if (length == 1 || charAt != '+') {
                return null;
            }
            i2 = 1;
        }
        long r9 = ULong.m302constructorimpl((long) i);
        long j2 = 0;
        long j3 = 512409557603043100L;
        while (i2 < length) {
            int digitOf = a.digitOf(str.charAt(i2), i);
            if (digitOf < 0) {
                return null;
            }
            if (UnsignedKt.ulongCompare(j2, j3) > 0) {
                if (j3 == 512409557603043100L) {
                    j3 = UnsignedKt.m353ulongDivideeb3DHEI(j, r9);
                    if (UnsignedKt.ulongCompare(j2, j3) > 0) {
                    }
                }
                return null;
            }
            long r11 = ULong.m302constructorimpl(j2 * r9);
            long r4 = ULong.m302constructorimpl(ULong.m302constructorimpl(((long) UInt.m277constructorimpl(digitOf)) & BodyPartID.bodyIdMax) + r11);
            if (UnsignedKt.ulongCompare(r4, r11) < 0) {
                return null;
            }
            i2++;
            j2 = r4;
            j = -1;
        }
        return ULong.m301boximpl(j2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final short toUShort(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "$this$toUShort");
        UShort uShortOrNull = toUShortOrNull(str, i);
        if (uShortOrNull != null) {
            return uShortOrNull.m332unboximpl();
        }
        l.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    public static final UShort toUShortOrNull(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "$this$toUShortOrNull");
        UInt uIntOrNull = toUIntOrNull(str, i);
        if (uIntOrNull == null) {
            return null;
        }
        int r1 = uIntOrNull.m282unboximpl();
        if (UnsignedKt.uintCompare(r1, UInt.m277constructorimpl(65535)) > 0) {
            return null;
        }
        return UShort.m326boximpl(UShort.m327constructorimpl((short) r1));
    }
}
