package org.kodein.di.generic;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.Multi2;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0010\b\u001a\u00028\u0002\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0006\b\u0001\u0010\u0001\u0018\u0001\"\n\b\u0002\u0010\u0003\u0018\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"A1", "A2", "", "T", "a1", "a2", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class GMultiKt$factory2$2$1 extends Lambda implements Function2<A1, A2, T> {
    public final /* synthetic */ Function1 a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GMultiKt$factory2$2$1(Function1 function1) {
        super(2);
        this.a = function1;
    }

    @Override // kotlin.jvm.functions.Function2
    @NotNull
    public final T invoke(A1 a1, A2 a22) {
        return (T) this.a.invoke(new Multi2(a1, a22, TypesKt.TT(new TypeReference<Multi2<A1, A2>>() { // from class: org.kodein.di.generic.GMultiKt$factory2$2$1$M$$inlined$generic$1
        })));
    }
}
