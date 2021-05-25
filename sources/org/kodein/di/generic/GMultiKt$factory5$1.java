package org.kodein.di.generic;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.Multi5;
import org.kodein.di.TypesKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\r\u001a&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\n\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0006\b\u0001\u0010\u0001\u0018\u0001\"\u0006\b\u0002\u0010\u0002\u0018\u0001\"\u0006\b\u0003\u0010\u0003\u0018\u0001\"\u0006\b\u0004\u0010\u0004\u0018\u0001\"\n\b\u0005\u0010\u0006\u0018\u0001*\u00020\u000520\u0010\t\u001a,\u0012\"\u0012 \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\b\u0012\u0004\u0012\u00028\u00050\u0007H\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"A1", "A2", "A3", "A4", "A5", "", "T", "Lkotlin/Function1;", "Lorg/kodein/di/Multi5;", "it", "Lkotlin/Function5;", "invoke", "(Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function5;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class GMultiKt$factory5$1 extends Lambda implements Function1<Function1<? super Multi5<A1, A2, A3, A4, A5>, ? extends T>, Function5<? super A1, ? super A2, ? super A3, ? super A4, ? super A5, ? extends T>> {
    public static final GMultiKt$factory5$1 INSTANCE = new GMultiKt$factory5$1();

    public GMultiKt$factory5$1() {
        super(1);
    }

    @NotNull
    public final Function5<A1, A2, A3, A4, A5, T> invoke(@NotNull final Function1<? super Multi5<A1, A2, A3, A4, A5>, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "it");
        return new Function5<A1, A2, A3, A4, A5, T>() { // from class: org.kodein.di.generic.GMultiKt$factory5$1.1
            @Override // kotlin.jvm.functions.Function5
            @NotNull
            public final T invoke(A1 a1, A2 a22, A3 a3, A4 a4, A5 a5) {
                return (T) function1.invoke(new Multi5(a1, a22, a3, a4, a5, TypesKt.TT(new GMultiKt$factory5$1$1$M$$inlined$generic$1())));
            }
        };
    }
}
