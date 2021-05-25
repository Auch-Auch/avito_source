package org.kodein.di.generic;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.Multi4;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\b\u0010\f\u001a\u00028\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0006\b\u0001\u0010\u0001\u0018\u0001\"\u0006\b\u0002\u0010\u0002\u0018\u0001\"\u0006\b\u0003\u0010\u0003\u0018\u0001\"\n\b\u0004\u0010\u0005\u0018\u0001*\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u00012\u0006\u0010\b\u001a\u00028\u00022\u0006\u0010\t\u001a\u00028\u0003H\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"A1", "A2", "A3", "A4", "", "T", "a1", "a2", "a3", "a4", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class GMultiKt$factory4OrNull$2$1$1 extends Lambda implements Function4<A1, A2, A3, A4, T> {
    public final /* synthetic */ Function1 a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GMultiKt$factory4OrNull$2$1$1(Function1 function1) {
        super(4);
        this.a = function1;
    }

    @Override // kotlin.jvm.functions.Function4
    @NotNull
    public final T invoke(A1 a1, A2 a22, A3 a3, A4 a4) {
        return (T) this.a.invoke(new Multi4(a1, a22, a3, a4, TypesKt.TT(new TypeReference<Multi4<A1, A2, A3, A4>>() { // from class: org.kodein.di.generic.GMultiKt$factory4OrNull$2$1$1$M$$inlined$generic$1
        })));
    }
}
