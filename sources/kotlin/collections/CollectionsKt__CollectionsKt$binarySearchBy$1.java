package kotlin.collections;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00010\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "", "K", "it", "", "invoke", "(Ljava/lang/Object;)I", "<anonymous>"}, k = 3, mv = {1, 4, 1})
public final class CollectionsKt__CollectionsKt$binarySearchBy$1 extends Lambda implements Function1<T, Integer> {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ Comparable b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CollectionsKt__CollectionsKt$binarySearchBy$1(Function1 function1, Comparable comparable) {
        super(1);
        this.a = function1;
        this.b = comparable;
    }

    /* Return type fixed from 'int' to match base method */
    /* JADX WARN: Type inference failed for: r2v3, types: [int, java.lang.Integer] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // kotlin.jvm.functions.Function1
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Integer invoke(T r2) {
        /*
            r1 = this;
            kotlin.jvm.functions.Function1 r0 = r1.a
            java.lang.Object r2 = r0.invoke(r2)
            java.lang.Comparable r2 = (java.lang.Comparable) r2
            java.lang.Comparable r0 = r1.b
            int r2 = t6.o.a.compareValues(r2, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.CollectionsKt__CollectionsKt$binarySearchBy$1.invoke(java.lang.Object):int");
    }
}
