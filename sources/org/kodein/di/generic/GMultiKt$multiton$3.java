package org.kodein.di.generic;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.Multi4;
import org.kodein.di.bindings.SimpleBindingKodein;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\f\u001a\u00028\u0005\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001\u0018\u0001\"\u0006\b\u0002\u0010\u0002\u0018\u0001\"\u0006\b\u0003\u0010\u0003\u0018\u0001\"\u0006\b\u0004\u0010\u0004\u0018\u0001\"\n\b\u0005\u0010\u0006\u0018\u0001*\u00020\u0005*\b\u0012\u0004\u0012\u00028\u00000\u00072\u001e\u0010\t\u001a\u001a\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\bH\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"C", "A1", "A2", "A3", "A4", "", "T", "Lorg/kodein/di/bindings/SimpleBindingKodein;", "Lorg/kodein/di/Multi4;", "it", "invoke", "(Lorg/kodein/di/bindings/SimpleBindingKodein;Lorg/kodein/di/Multi4;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class GMultiKt$multiton$3 extends Lambda implements Function2<SimpleBindingKodein<? extends C>, Multi4<A1, A2, A3, A4>, T> {
    public final /* synthetic */ Function5 a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GMultiKt$multiton$3(Function5 function5) {
        super(2);
        this.a = function5;
    }

    @NotNull
    public final T invoke(@NotNull SimpleBindingKodein<? extends C> simpleBindingKodein, @NotNull Multi4<A1, A2, A3, A4> multi4) {
        Intrinsics.checkParameterIsNotNull(simpleBindingKodein, "$receiver");
        Intrinsics.checkParameterIsNotNull(multi4, "it");
        return (T) this.a.invoke(simpleBindingKodein, multi4.getA1(), multi4.getA2(), multi4.getA3(), multi4.getA4());
    }
}
