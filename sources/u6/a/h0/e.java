package u6.a.h0;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
public final class e extends Lambda implements Function1<Throwable, Unit> {
    public final /* synthetic */ ReceiveChannel a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(ReceiveChannel receiveChannel) {
        super(1);
        this.a = receiveChannel;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        ChannelsKt.cancelConsumed(this.a, th);
        return Unit.INSTANCE;
    }
}
