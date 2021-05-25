package arrow.core;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import n6.a.f;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aL\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0004¢\u0006\u0004\b\u0004\u0010\u0005\u001aM\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\t\u0010\n\u001a;\u0010\f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b0\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\f\u0010\r\u001aY\u0010\u0012\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0001*\u00028\u0003\"\b\b\u0002\u0010\u000e*\u00028\u0000\"\u0004\b\u0003\u0010\u000f*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0010\u001a\u00028\u00022\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0004\b\u0012\u0010\u0013\u001a9\u0010\u0012\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0014\"\u0004\b\u0001\u0010\u0015*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0001¢\u0006\u0004\b\u0012\u0010\u0017\u001aO\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0018*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001a\u001aI\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u001b\u0010\n\u001aQ\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u001d\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u001c¢\u0006\u0004\b\u001e\u0010\u001f\u001ad\u0010 \u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u001c\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006H\u0004¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Larrow/core/PartialFunction;", "f", "orElse", "(Larrow/core/PartialFunction;Larrow/core/PartialFunction;)Larrow/core/PartialFunction;", "Lkotlin/Function1;", "", "definedAt", "PartialFunction", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Larrow/core/PartialFunction;", "Larrow/core/Option;", "lift", "(Larrow/core/PartialFunction;)Lkotlin/jvm/functions/Function1;", "A1", "B1", "x", "default", "invokeOrElse", "(Larrow/core/PartialFunction;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "P1", "R", "p1", "(Larrow/core/PartialFunction;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "C", "andThen", "(Larrow/core/PartialFunction;Lkotlin/jvm/functions/Function1;)Larrow/core/PartialFunction;", "toPartialFunction", "Larrow/core/Tuple2;", "ff", "case", "(Larrow/core/Tuple2;)Larrow/core/PartialFunction;", "then", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Larrow/core/Tuple2;", "arrow-core"}, k = 2, mv = {1, 4, 0})
public final class PartialFunctionKt {
    @NotNull
    public static final <A, B> PartialFunction<A, B> PartialFunction(@NotNull Function1<? super A, Boolean> function1, @NotNull Function1<? super A, ? extends B> function12) {
        Intrinsics.checkParameterIsNotNull(function1, "definedAt");
        Intrinsics.checkParameterIsNotNull(function12, "f");
        return new PartialFunction<A, B>(function1, function12) { // from class: arrow.core.PartialFunctionKt$PartialFunction$1
            public final /* synthetic */ Function1 a;
            public final /* synthetic */ Function1 b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // kotlin.jvm.functions.Function1
            public B invoke(A a3) {
                if (((Boolean) this.a.invoke(a3)).booleanValue()) {
                    return (B) this.b.invoke(a3);
                }
                throw new IllegalArgumentException("Value: (" + ((Object) a3) + ") isn't supported by this function");
            }

            @Override // arrow.core.PartialFunction
            public boolean isDefinedAt(A a3) {
                return ((Boolean) this.a.invoke(a3)).booleanValue();
            }
        };
    }

    @NotNull
    public static final <A, B, C> PartialFunction<A, C> andThen(@NotNull PartialFunction<? super A, ? extends B> partialFunction, @NotNull Function1<? super B, ? extends C> function1) {
        Intrinsics.checkParameterIsNotNull(partialFunction, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        return new PartialFunction<A, C>(partialFunction, function1) { // from class: arrow.core.PartialFunctionKt$andThen$1
            public final /* synthetic */ PartialFunction a;
            public final /* synthetic */ Function1 b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // kotlin.jvm.functions.Function1
            public C invoke(A a3) {
                return (C) this.b.invoke(this.a.invoke(a3));
            }

            @Override // arrow.core.PartialFunction
            public boolean isDefinedAt(A a3) {
                return this.a.isDefinedAt(a3);
            }
        };
    }

    @NotNull
    /* renamed from: case  reason: not valid java name */
    public static final <A, B> PartialFunction<A, B> m68case(@NotNull Tuple2<? extends Function1<? super A, Boolean>, ? extends Function1<? super A, ? extends B>> tuple2) {
        Intrinsics.checkParameterIsNotNull(tuple2, "ff");
        return new PartialFunction<A, B>(tuple2) { // from class: arrow.core.PartialFunctionKt$case$1
            public final /* synthetic */ Tuple2 a;

            {
                this.a = r1;
            }

            @Override // kotlin.jvm.functions.Function1
            public B invoke(A a3) {
                return (B) ((Function1) this.a.getB()).invoke(a3);
            }

            @Override // arrow.core.PartialFunction
            public boolean isDefinedAt(A a3) {
                return ((Boolean) ((Function1) this.a.getA()).invoke(a3)).booleanValue();
            }
        };
    }

    public static final <A, B extends B1, A1 extends A, B1> B1 invokeOrElse(@NotNull PartialFunction<? super A, ? extends B> partialFunction, A1 a1, @NotNull Function1<? super A1, ? extends B1> function1) {
        Intrinsics.checkParameterIsNotNull(partialFunction, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "default");
        return partialFunction.isDefinedAt(a1) ? (B1) partialFunction.invoke(a1) : (B1) function1.invoke(a1);
    }

    @NotNull
    public static final <A, B> Function1<A, Option<B>> lift(@NotNull PartialFunction<? super A, ? extends B> partialFunction) {
        Intrinsics.checkParameterIsNotNull(partialFunction, "$receiver");
        return new f(partialFunction);
    }

    @NotNull
    public static final <A, B> PartialFunction<A, B> orElse(@NotNull PartialFunction<? super A, ? extends B> partialFunction, @NotNull PartialFunction<? super A, ? extends B> partialFunction2) {
        Intrinsics.checkParameterIsNotNull(partialFunction, "$receiver");
        Intrinsics.checkParameterIsNotNull(partialFunction2, "f");
        return new PartialFunction<A, B>(partialFunction, partialFunction2) { // from class: arrow.core.PartialFunctionKt$orElse$1
            public final /* synthetic */ PartialFunction a;
            public final /* synthetic */ PartialFunction b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // kotlin.jvm.functions.Function1
            public B invoke(A a3) {
                return this.a.isDefinedAt(a3) ? (B) this.a.invoke(a3) : (B) this.b.invoke(a3);
            }

            @Override // arrow.core.PartialFunction
            public boolean isDefinedAt(A a3) {
                return this.a.isDefinedAt(a3) || this.b.isDefinedAt(a3);
            }
        };
    }

    @NotNull
    public static final <A, B> Tuple2<Function1<A, Boolean>, Function1<A, B>> then(@NotNull Function1<? super A, Boolean> function1, @NotNull Function1<? super A, ? extends B> function12) {
        Intrinsics.checkParameterIsNotNull(function1, "$receiver");
        Intrinsics.checkParameterIsNotNull(function12, "f");
        return new Tuple2<>(function1, function12);
    }

    @NotNull
    public static final <A, B> PartialFunction<A, B> toPartialFunction(@NotNull Function1<? super A, ? extends B> function1, @NotNull Function1<? super A, Boolean> function12) {
        Intrinsics.checkParameterIsNotNull(function1, "$receiver");
        Intrinsics.checkParameterIsNotNull(function12, "definedAt");
        return PartialFunction(function12, function1);
    }

    public static final <P1, R> R invokeOrElse(@NotNull PartialFunction<? super P1, ? extends R> partialFunction, P1 p1, R r) {
        Intrinsics.checkParameterIsNotNull(partialFunction, "$receiver");
        return partialFunction.isDefinedAt(p1) ? (R) partialFunction.invoke(p1) : r;
    }
}
