package u6.a.j0;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class k extends Lambda implements Function1<T, Long> {
    public final /* synthetic */ long a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(long j) {
        super(1);
        this.a = j;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function1
    public Long invoke(Object obj) {
        return Long.valueOf(this.a);
    }
}
