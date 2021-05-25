package org.kodein.di.generic;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.Multi2;
import org.kodein.di.TypesKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0007\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0006\b\u0001\u0010\u0001\u0018\u0001\"\n\b\u0002\u0010\u0003\u0018\u0001*\u00020\u00022\u001e\u0010\u0006\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0004\u0012\u00028\u00020\u0004H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"A1", "A2", "", "T", "Lkotlin/Function1;", "Lorg/kodein/di/Multi2;", "it", "Lkotlin/Function2;", "invoke", "(Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function2;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class GMultiKt$factory2$1 extends Lambda implements Function1<Function1<? super Multi2<A1, A2>, ? extends T>, Function2<? super A1, ? super A2, ? extends T>> {
    public static final GMultiKt$factory2$1 INSTANCE = new GMultiKt$factory2$1();

    public GMultiKt$factory2$1() {
        super(1);
    }

    @NotNull
    public final Function2<A1, A2, T> invoke(@NotNull final Function1<? super Multi2<A1, A2>, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "it");
        return new Function2<A1, A2, T>() { // from class: org.kodein.di.generic.GMultiKt$factory2$1.1
            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final T invoke(A1 a1, A2 a22) {
                return (T) function1.invoke(new Multi2(a1, a22, TypesKt.TT(new GMultiKt$factory2$1$1$M$$inlined$generic$1())));
            }
        };
    }
}
