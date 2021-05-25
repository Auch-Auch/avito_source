package org.funktionale.utils;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a9\u0010\u0005\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001aL\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0004¢\u0006\u0004\b\b\u0010\t\u001aI\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"P1", "R", "Lorg/funktionale/utils/PartialFunction;", "p1", "default", "invokeOrElse", "(Lorg/funktionale/utils/PartialFunction;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "that", "orElse", "(Lorg/funktionale/utils/PartialFunction;Lorg/funktionale/utils/PartialFunction;)Lorg/funktionale/utils/PartialFunction;", "Lkotlin/Function1;", "", "definedAt", "toPartialFunction", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lorg/funktionale/utils/PartialFunction;", "funktionale-utils"}, k = 2, mv = {1, 4, 0})
public final class PartialfunctionsKt {

    public static final class a extends Lambda implements Function1<P1, Boolean> {
        public final /* synthetic */ PartialFunction a;
        public final /* synthetic */ PartialFunction b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PartialFunction partialFunction, PartialFunction partialFunction2) {
            super(1);
            this.a = partialFunction;
            this.b = partialFunction2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(Object obj) {
            return Boolean.valueOf(this.a.isDefinedAt(obj) || this.b.isDefinedAt(obj));
        }
    }

    public static final class b extends Lambda implements Function1<P1, R> {
        public final /* synthetic */ PartialFunction a;
        public final /* synthetic */ PartialFunction b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(PartialFunction partialFunction, PartialFunction partialFunction2) {
            super(1);
            this.a = partialFunction;
            this.b = partialFunction2;
        }

        @Override // kotlin.jvm.functions.Function1
        public final R invoke(P1 p1) {
            if (this.a.isDefinedAt(p1)) {
                return (R) this.a.invoke(p1);
            }
            if (this.b.isDefinedAt(p1)) {
                return (R) this.b.invoke(p1);
            }
            throw new IllegalArgumentException("function not definet for parameter (" + ((Object) p1) + ')');
        }
    }

    public static final <P1, R> R invokeOrElse(@NotNull PartialFunction<? super P1, ? extends R> partialFunction, P1 p1, R r) {
        Intrinsics.checkParameterIsNotNull(partialFunction, "$receiver");
        return partialFunction.isDefinedAt(p1) ? (R) partialFunction.invoke(p1) : r;
    }

    @NotNull
    public static final <P1, R> PartialFunction<P1, R> orElse(@NotNull PartialFunction<? super P1, ? extends R> partialFunction, @NotNull PartialFunction<? super P1, ? extends R> partialFunction2) {
        Intrinsics.checkParameterIsNotNull(partialFunction, "$receiver");
        Intrinsics.checkParameterIsNotNull(partialFunction2, "that");
        return new PartialFunction<>(new a(partialFunction, partialFunction2), new b(partialFunction, partialFunction2));
    }

    @NotNull
    public static final <P1, R> PartialFunction<P1, R> toPartialFunction(@NotNull Function1<? super P1, ? extends R> function1, @NotNull Function1<? super P1, Boolean> function12) {
        Intrinsics.checkParameterIsNotNull(function1, "$receiver");
        Intrinsics.checkParameterIsNotNull(function12, "definedAt");
        return new PartialFunction<>(function12, function1);
    }
}
