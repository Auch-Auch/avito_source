package a7.a.c;

import a2.b.a.a.a;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.WebSocket;
import ru.avito.reporter.WebSocketReporter;
import ru.avito.websocket.RxWebSocketImpl;
import ru.avito.websocket.RxWebSocketImplKt;
import ru.avito.websocket.RxWebSocketState;
public final class e extends Lambda implements Function1<Pair<? extends WebSocket, ? extends RxWebSocketState>, Pair<? extends WebSocket, ? extends RxWebSocketState>> {
    public final /* synthetic */ RxWebSocketImpl.f a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(RxWebSocketImpl.f fVar) {
        super(1);
        this.a = fVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Pair<? extends WebSocket, ? extends RxWebSocketState> invoke(Pair<? extends WebSocket, ? extends RxWebSocketState> pair) {
        Pair<? extends WebSocket, ? extends RxWebSocketState> pair2 = pair;
        Intrinsics.checkNotNullParameter(pair2, "$receiver");
        RxWebSocketState access$getState$p = RxWebSocketImplKt.access$getState$p(pair2);
        if (!(access$getState$p instanceof RxWebSocketState.Connecting) && !(access$getState$p instanceof RxWebSocketState.Connected)) {
            boolean z = access$getState$p instanceof RxWebSocketState.Disconnected;
        } else {
            WebSocket access$getSocket$p = RxWebSocketImplKt.access$getSocket$p(pair2);
            if (access$getSocket$p != null) {
                RxWebSocketImpl.f fVar = this.a;
                fVar.b.set(access$getSocket$p.send(fVar.c));
            }
        }
        WebSocketReporter webSocketReporter = this.a.a.h;
        if (webSocketReporter != null) {
            RxWebSocketImpl.f fVar2 = this.a;
            webSocketReporter.onSend(fVar2.c, fVar2.b.get());
        }
        if (this.a.b.get()) {
            Function1 function1 = this.a.a.g;
            if (function1 != null) {
                StringBuilder L = a.L("WS: --> ");
                L.append(this.a.c);
                Unit unit = (Unit) function1.invoke(L.toString());
            }
        } else {
            Function1 function12 = this.a.a.g;
            if (function12 != null) {
                StringBuilder L2 = a.L("WS: send message: message wasn't enqueued: ");
                L2.append(this.a.c);
                Unit unit2 = (Unit) function12.invoke(L2.toString());
            }
        }
        this.a.d.countDown();
        return pair2;
    }
}
