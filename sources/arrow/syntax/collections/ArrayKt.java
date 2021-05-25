package arrow.syntax.collections;

import arrow.core.Option;
import arrow.core.OptionKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0019\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0013\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0014\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0017\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002*\u00020\u0005¢\u0006\u0004\b\u0003\u0010\u0007\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\t0\u0002*\u00020\b¢\u0006\u0004\b\u0003\u0010\n\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\f0\u0002*\u00020\u000b¢\u0006\u0004\b\u0003\u0010\r\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0002*\u00020\u000e¢\u0006\u0004\b\u0003\u0010\u0010\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00120\u0002*\u00020\u0011¢\u0006\u0004\b\u0003\u0010\u0013\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00150\u0002*\u00020\u0014¢\u0006\u0004\b\u0003\u0010\u0016\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00180\u0002*\u00020\u0017¢\u0006\u0004\b\u0003\u0010\u0019\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0002*\u00020\u001a¢\u0006\u0004\b\u0003\u0010\u001c\u001aC\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u001c\u0010\u001f\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u001dj\b\u0012\u0004\u0012\u00028\u0000`\u001e¢\u0006\u0004\b\u0003\u0010 \u001a8\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002*\u00020\u00052\u001c\u0010\u001f\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001dj\b\u0012\u0004\u0012\u00020\u0006`\u001eH\b¢\u0006\u0004\b\u0003\u0010!\u001a8\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\t0\u0002*\u00020\b2\u001c\u0010\u001f\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u001dj\b\u0012\u0004\u0012\u00020\t`\u001eH\b¢\u0006\u0004\b\u0003\u0010\"\u001a8\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\f0\u0002*\u00020\u000b2\u001c\u0010\u001f\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u001dj\b\u0012\u0004\u0012\u00020\f`\u001eH\b¢\u0006\u0004\b\u0003\u0010#\u001a8\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0002*\u00020\u000e2\u001c\u0010\u001f\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00060\u001dj\b\u0012\u0004\u0012\u00020\u000f`\u001eH\b¢\u0006\u0004\b\u0003\u0010$\u001a8\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00120\u0002*\u00020\u00112\u001c\u0010\u001f\u001a\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00060\u001dj\b\u0012\u0004\u0012\u00020\u0012`\u001eH\b¢\u0006\u0004\b\u0003\u0010%\u001a8\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00150\u0002*\u00020\u00142\u001c\u0010\u001f\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00060\u001dj\b\u0012\u0004\u0012\u00020\u0015`\u001eH\b¢\u0006\u0004\b\u0003\u0010&\u001a8\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00180\u0002*\u00020\u00172\u001c\u0010\u001f\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00060\u001dj\b\u0012\u0004\u0012\u00020\u0018`\u001eH\b¢\u0006\u0004\b\u0003\u0010'\u001a8\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0002*\u00020\u001a2\u001c\u0010\u001f\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00060\u001dj\b\u0012\u0004\u0012\u00020\u001b`\u001eH\b¢\u0006\u0004\b\u0003\u0010(¨\u0006)"}, d2 = {"T", "", "Larrow/core/Option;", "firstOption", "([Ljava/lang/Object;)Larrow/core/Option;", "", "", "([Z)Larrow/core/Option;", "", "", "([B)Larrow/core/Option;", "", "", "([C)Larrow/core/Option;", "", "", "([D)Larrow/core/Option;", "", "", "([F)Larrow/core/Option;", "", "", "([I)Larrow/core/Option;", "", "", "([J)Larrow/core/Option;", "", "", "([S)Larrow/core/Option;", "Lkotlin/Function1;", "Larrow/core/Predicate;", "predicate", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Larrow/core/Option;", "([ZLkotlin/jvm/functions/Function1;)Larrow/core/Option;", "([BLkotlin/jvm/functions/Function1;)Larrow/core/Option;", "([CLkotlin/jvm/functions/Function1;)Larrow/core/Option;", "([DLkotlin/jvm/functions/Function1;)Larrow/core/Option;", "([FLkotlin/jvm/functions/Function1;)Larrow/core/Option;", "([ILkotlin/jvm/functions/Function1;)Larrow/core/Option;", "([JLkotlin/jvm/functions/Function1;)Larrow/core/Option;", "([SLkotlin/jvm/functions/Function1;)Larrow/core/Option;", "arrow-syntax"}, k = 2, mv = {1, 4, 0})
public final class ArrayKt {
    @NotNull
    public static final <T> Option<T> firstOption(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "$receiver");
        return OptionKt.toOption(ArraysKt___ArraysKt.firstOrNull(tArr));
    }

    @NotNull
    public static final Option<Boolean> firstOption(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "$receiver");
        return OptionKt.toOption(ArraysKt___ArraysKt.firstOrNull(zArr));
    }

    @NotNull
    public static final Option<Byte> firstOption(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "$receiver");
        return OptionKt.toOption(ArraysKt___ArraysKt.firstOrNull(bArr));
    }

    @NotNull
    public static final Option<Character> firstOption(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "$receiver");
        return OptionKt.toOption(ArraysKt___ArraysKt.firstOrNull(cArr));
    }

    @NotNull
    public static final Option<Double> firstOption(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "$receiver");
        return OptionKt.toOption(ArraysKt___ArraysKt.firstOrNull(dArr));
    }

    @NotNull
    public static final Option<Float> firstOption(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "$receiver");
        return OptionKt.toOption(ArraysKt___ArraysKt.firstOrNull(fArr));
    }

    @NotNull
    public static final Option<Integer> firstOption(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "$receiver");
        return OptionKt.toOption(ArraysKt___ArraysKt.firstOrNull(iArr));
    }

    @NotNull
    public static final Option<Long> firstOption(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "$receiver");
        return OptionKt.toOption(ArraysKt___ArraysKt.firstOrNull(jArr));
    }

    @NotNull
    public static final Option<Short> firstOption(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "$receiver");
        return OptionKt.toOption(ArraysKt___ArraysKt.firstOrNull(sArr));
    }

    @NotNull
    public static final <T> Option<T> firstOption(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        T t;
        Intrinsics.checkParameterIsNotNull(tArr, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int length = tArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                t = null;
                break;
            }
            t = tArr[i];
            if (function1.invoke(t).booleanValue()) {
                break;
            }
            i++;
        }
        return OptionKt.toOption(t);
    }

    @NotNull
    public static final Option<Boolean> firstOption(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Boolean bool;
        Intrinsics.checkParameterIsNotNull(zArr, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int length = zArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                bool = null;
                break;
            }
            boolean z = zArr[i];
            if (function1.invoke(Boolean.valueOf(z)).booleanValue()) {
                bool = Boolean.valueOf(z);
                break;
            }
            i++;
        }
        return OptionKt.toOption(bool);
    }

    @NotNull
    public static final Option<Byte> firstOption(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Byte b;
        Intrinsics.checkParameterIsNotNull(bArr, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int length = bArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                b = null;
                break;
            }
            byte b2 = bArr[i];
            if (function1.invoke(Byte.valueOf(b2)).booleanValue()) {
                b = Byte.valueOf(b2);
                break;
            }
            i++;
        }
        return OptionKt.toOption(b);
    }

    @NotNull
    public static final Option<Character> firstOption(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Character ch;
        Intrinsics.checkParameterIsNotNull(cArr, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int length = cArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                ch = null;
                break;
            }
            char c = cArr[i];
            if (function1.invoke(Character.valueOf(c)).booleanValue()) {
                ch = Character.valueOf(c);
                break;
            }
            i++;
        }
        return OptionKt.toOption(ch);
    }

    @NotNull
    public static final Option<Double> firstOption(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Double d;
        Intrinsics.checkParameterIsNotNull(dArr, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int length = dArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                d = null;
                break;
            }
            double d2 = dArr[i];
            if (function1.invoke(Double.valueOf(d2)).booleanValue()) {
                d = Double.valueOf(d2);
                break;
            }
            i++;
        }
        return OptionKt.toOption(d);
    }

    @NotNull
    public static final Option<Float> firstOption(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Float f;
        Intrinsics.checkParameterIsNotNull(fArr, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int length = fArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                f = null;
                break;
            }
            float f2 = fArr[i];
            if (function1.invoke(Float.valueOf(f2)).booleanValue()) {
                f = Float.valueOf(f2);
                break;
            }
            i++;
        }
        return OptionKt.toOption(f);
    }

    @NotNull
    public static final Option<Integer> firstOption(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Integer num;
        Intrinsics.checkParameterIsNotNull(iArr, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int length = iArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                num = null;
                break;
            }
            int i2 = iArr[i];
            if (function1.invoke(Integer.valueOf(i2)).booleanValue()) {
                num = Integer.valueOf(i2);
                break;
            }
            i++;
        }
        return OptionKt.toOption(num);
    }

    @NotNull
    public static final Option<Long> firstOption(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Long l;
        Intrinsics.checkParameterIsNotNull(jArr, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int length = jArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                l = null;
                break;
            }
            long j = jArr[i];
            if (function1.invoke(Long.valueOf(j)).booleanValue()) {
                l = Long.valueOf(j);
                break;
            }
            i++;
        }
        return OptionKt.toOption(l);
    }

    @NotNull
    public static final Option<Short> firstOption(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Short sh;
        Intrinsics.checkParameterIsNotNull(sArr, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int length = sArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                sh = null;
                break;
            }
            short s = sArr[i];
            if (function1.invoke(Short.valueOf(s)).booleanValue()) {
                sh = Short.valueOf(s);
                break;
            }
            i++;
        }
        return OptionKt.toOption(sh);
    }
}
