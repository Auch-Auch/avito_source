package org.kodein.di.generic;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.Multi2;
import org.kodein.di.bindings.SimpleBindingKodein;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\n\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001\u0018\u0001\"\u0006\b\u0002\u0010\u0002\u0018\u0001\"\n\b\u0003\u0010\u0004\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"C", "A1", "A2", "", "T", "Lorg/kodein/di/bindings/SimpleBindingKodein;", "Lorg/kodein/di/Multi2;", "it", "invoke", "(Lorg/kodein/di/bindings/SimpleBindingKodein;Lorg/kodein/di/Multi2;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class GMultiKt$multiton$1 extends Lambda implements Function2<SimpleBindingKodein<? extends C>, Multi2<A1, A2>, T> {
    public final /* synthetic */ Function3 a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GMultiKt$multiton$1(Function3 function3) {
        super(2);
        this.a = function3;
    }

    @NotNull
    public final T invoke(@NotNull SimpleBindingKodein<? extends C> simpleBindingKodein, @NotNull Multi2<A1, A2> multi2) {
        Intrinsics.checkParameterIsNotNull(simpleBindingKodein, "$receiver");
        Intrinsics.checkParameterIsNotNull(multi2, "it");
        return (T) this.a.invoke(simpleBindingKodein, multi2.getA1(), multi2.getA2());
    }
}
