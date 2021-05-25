package org.kodein.di.generic;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.Multi3;
import org.kodein.di.TypesKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\b\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0006\b\u0001\u0010\u0001\u0018\u0001\"\u0006\b\u0002\u0010\u0002\u0018\u0001\"\n\b\u0003\u0010\u0004\u0018\u0001*\u00020\u00032$\u0010\u0007\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006\u0012\u0004\u0012\u00028\u00030\u0005H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"A1", "A2", "A3", "", "T", "Lkotlin/Function1;", "Lorg/kodein/di/Multi3;", "it", "Lkotlin/Function3;", "invoke", "(Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function3;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class GMultiKt$factory3$1 extends Lambda implements Function1<Function1<? super Multi3<A1, A2, A3>, ? extends T>, Function3<? super A1, ? super A2, ? super A3, ? extends T>> {
    public static final GMultiKt$factory3$1 INSTANCE = new GMultiKt$factory3$1();

    public GMultiKt$factory3$1() {
        super(1);
    }

    @NotNull
    public final Function3<A1, A2, A3, T> invoke(@NotNull final Function1<? super Multi3<A1, A2, A3>, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "it");
        return new Function3<A1, A2, A3, T>() { // from class: org.kodein.di.generic.GMultiKt$factory3$1.1
            @Override // kotlin.jvm.functions.Function3
            @NotNull
            public final T invoke(A1 a1, A2 a22, A3 a3) {
                return (T) function1.invoke(new Multi3(a1, a22, a3, TypesKt.TT(new GMultiKt$factory3$1$1$M$$inlined$generic$1())));
            }
        };
    }
}
