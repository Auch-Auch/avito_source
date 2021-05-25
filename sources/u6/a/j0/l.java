package u6.a.j0;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.time.Duration;
import kotlinx.coroutines.DelayKt;
public final class l extends Lambda implements Function1<T, Long> {
    public final /* synthetic */ Function1 a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(Function1 function1) {
        super(1);
        this.a = function1;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function1
    public Long invoke(Object obj) {
        return Long.valueOf(DelayKt.m497toDelayMillisLRDsOJo(((Duration) this.a.invoke(obj)).m487unboximpl()));
    }
}
