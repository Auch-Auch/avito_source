package org.kodein.di.generic;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.Multi5;
import org.kodein.di.bindings.SimpleBindingKodein;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\r\u001a\u00028\u0006\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001\u0018\u0001\"\u0006\b\u0002\u0010\u0002\u0018\u0001\"\u0006\b\u0003\u0010\u0003\u0018\u0001\"\u0006\b\u0004\u0010\u0004\u0018\u0001\"\u0006\b\u0005\u0010\u0005\u0018\u0001\"\n\b\u0006\u0010\u0007\u0018\u0001*\u00020\u0006*\b\u0012\u0004\u0012\u00028\u00000\b2$\u0010\n\u001a \u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\tH\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"C", "A1", "A2", "A3", "A4", "A5", "", "T", "Lorg/kodein/di/bindings/SimpleBindingKodein;", "Lorg/kodein/di/Multi5;", "it", "invoke", "(Lorg/kodein/di/bindings/SimpleBindingKodein;Lorg/kodein/di/Multi5;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class GMultiKt$multiton$4 extends Lambda implements Function2<SimpleBindingKodein<? extends C>, Multi5<A1, A2, A3, A4, A5>, T> {
    public final /* synthetic */ Function6 a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GMultiKt$multiton$4(Function6 function6) {
        super(2);
        this.a = function6;
    }

    @NotNull
    public final T invoke(@NotNull SimpleBindingKodein<? extends C> simpleBindingKodein, @NotNull Multi5<A1, A2, A3, A4, A5> multi5) {
        Intrinsics.checkParameterIsNotNull(simpleBindingKodein, "$receiver");
        Intrinsics.checkParameterIsNotNull(multi5, "it");
        return (T) this.a.invoke(simpleBindingKodein, multi5.getA1(), multi5.getA2(), multi5.getA3(), multi5.getA4(), multi5.getA5());
    }
}
