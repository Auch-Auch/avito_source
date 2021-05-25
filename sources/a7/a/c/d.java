package a7.a.c;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.WebSocket;
import ru.avito.websocket.RxWebSocketImplKt;
import ru.avito.websocket.RxWebSocketState;
public final class d extends Lambda implements Function1<Pair<? extends WebSocket, ? extends RxWebSocketState>, Pair<? extends WebSocket, ? extends RxWebSocketState>> {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(int i, String str) {
        super(1);
        this.a = i;
        this.b = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Pair<? extends WebSocket, ? extends RxWebSocketState> invoke(Pair<? extends WebSocket, ? extends RxWebSocketState> pair) {
        Pair<? extends WebSocket, ? extends RxWebSocketState> pair2 = pair;
        Intrinsics.checkNotNullParameter(pair2, "$receiver");
        RxWebSocketState access$getState$p = RxWebSocketImplKt.access$getState$p(pair2);
        if (access$getState$p instanceof RxWebSocketState.Connected) {
            WebSocket access$getSocket$p = RxWebSocketImplKt.access$getSocket$p(pair2);
            if (access$getSocket$p != null) {
                access$getSocket$p.close(this.a, this.b);
            }
        } else if (access$getState$p instanceof RxWebSocketState.Connecting) {
            WebSocket access$getSocket$p2 = RxWebSocketImplKt.access$getSocket$p(pair2);
            if (access$getSocket$p2 != null) {
                access$getSocket$p2.close(this.a, this.b);
            }
        } else {
            boolean z = access$getState$p instanceof RxWebSocketState.Disconnected;
        }
        return TuplesKt.to(null, new RxWebSocketState.Disconnected(this.a, this.b, null, 4, null));
    }
}
