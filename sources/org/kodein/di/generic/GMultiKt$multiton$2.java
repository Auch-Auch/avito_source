package org.kodein.di.generic;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.Multi3;
import org.kodein.di.bindings.SimpleBindingKodein;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u000b\u001a\u00028\u0004\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001\u0018\u0001\"\u0006\b\u0002\u0010\u0002\u0018\u0001\"\u0006\b\u0003\u0010\u0003\u0018\u0001\"\n\b\u0004\u0010\u0005\u0018\u0001*\u00020\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00062\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"C", "A1", "A2", "A3", "", "T", "Lorg/kodein/di/bindings/SimpleBindingKodein;", "Lorg/kodein/di/Multi3;", "it", "invoke", "(Lorg/kodein/di/bindings/SimpleBindingKodein;Lorg/kodein/di/Multi3;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class GMultiKt$multiton$2 extends Lambda implements Function2<SimpleBindingKodein<? extends C>, Multi3<A1, A2, A3>, T> {
    public final /* synthetic */ Function4 a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GMultiKt$multiton$2(Function4 function4) {
        super(2);
        this.a = function4;
    }

    @NotNull
    public final T invoke(@NotNull SimpleBindingKodein<? extends C> simpleBindingKodein, @NotNull Multi3<A1, A2, A3> multi3) {
        Intrinsics.checkParameterIsNotNull(simpleBindingKodein, "$receiver");
        Intrinsics.checkParameterIsNotNull(multi3, "it");
        return (T) this.a.invoke(simpleBindingKodein, multi3.getA1(), multi3.getA2(), multi3.getA3());
    }
}
