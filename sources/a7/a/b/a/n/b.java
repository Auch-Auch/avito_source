package a7.a.b.a.n;

import io.reactivex.functions.Consumer;
import ru.avito.messenger.internal.ConstantsKt;
import ru.avito.messenger.internal.jsonrpc.WebSocketJsonRpcClient;
import ru.avito.messenger.internal.log.Logger;
import ru.avito.websocket.RxWebSocketState;
public final class b<T> implements Consumer<RxWebSocketState.Disconnected> {
    public final /* synthetic */ WebSocketJsonRpcClient a;

    public b(WebSocketJsonRpcClient webSocketJsonRpcClient) {
        this.a = webSocketJsonRpcClient;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(RxWebSocketState.Disconnected disconnected) {
        Logger logger = this.a.e;
        Logger.DefaultImpls.e$default(logger, ConstantsKt.LOG_TAG, "WebSocket state is " + disconnected, null, 4, null);
    }
}
