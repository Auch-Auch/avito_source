package u6.a.h0;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import t6.b;
public final class f extends Lambda implements Function1<Throwable, Unit> {
    public final /* synthetic */ ReceiveChannel[] a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(ReceiveChannel[] receiveChannelArr) {
        super(1);
        this.a = receiveChannelArr;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        Throwable th2 = th;
        Throwable th3 = null;
        for (ReceiveChannel receiveChannel : this.a) {
            try {
                ChannelsKt.cancelConsumed(receiveChannel, th2);
            } catch (Throwable th4) {
                if (th3 == null) {
                    th3 = th4;
                } else {
                    b.addSuppressed(th3, th4);
                }
            }
        }
        if (th3 == null) {
            return Unit.INSTANCE;
        }
        throw th3;
    }
}
