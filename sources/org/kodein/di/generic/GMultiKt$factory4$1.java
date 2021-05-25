package org.kodein.di.generic;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.Multi4;
import org.kodein.di.TypesKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\f\u001a \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\t\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0006\b\u0001\u0010\u0001\u0018\u0001\"\u0006\b\u0002\u0010\u0002\u0018\u0001\"\u0006\b\u0003\u0010\u0003\u0018\u0001\"\n\b\u0004\u0010\u0005\u0018\u0001*\u00020\u00042*\u0010\b\u001a&\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007\u0012\u0004\u0012\u00028\u00040\u0006H\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"A1", "A2", "A3", "A4", "", "T", "Lkotlin/Function1;", "Lorg/kodein/di/Multi4;", "it", "Lkotlin/Function4;", "invoke", "(Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function4;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class GMultiKt$factory4$1 extends Lambda implements Function1<Function1<? super Multi4<A1, A2, A3, A4>, ? extends T>, Function4<? super A1, ? super A2, ? super A3, ? super A4, ? extends T>> {
    public static final GMultiKt$factory4$1 INSTANCE = new GMultiKt$factory4$1();

    public GMultiKt$factory4$1() {
        super(1);
    }

    @NotNull
    public final Function4<A1, A2, A3, A4, T> invoke(@NotNull final Function1<? super Multi4<A1, A2, A3, A4>, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "it");
        return new Function4<A1, A2, A3, A4, T>() { // from class: org.kodein.di.generic.GMultiKt$factory4$1.1
            @Override // kotlin.jvm.functions.Function4
            @NotNull
            public final T invoke(A1 a1, A2 a22, A3 a3, A4 a4) {
                return (T) function1.invoke(new Multi4(a1, a22, a3, a4, TypesKt.TT(new GMultiKt$factory4$1$1$M$$inlined$generic$1())));
            }
        };
    }
}
