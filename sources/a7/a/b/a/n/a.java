package a7.a.b.a.n;

import io.reactivex.functions.Consumer;
import ru.avito.messenger.internal.ConstantsKt;
import ru.avito.messenger.internal.entity.jsonrpc.JsonRpcResponse;
import ru.avito.messenger.internal.jsonrpc.WebSocketJsonRpcClient;
import ru.avito.messenger.internal.log.Logger;
public final class a<T> implements Consumer<JsonRpcResponse> {
    public final /* synthetic */ WebSocketJsonRpcClient a;

    public a(WebSocketJsonRpcClient webSocketJsonRpcClient) {
        this.a = webSocketJsonRpcClient;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(JsonRpcResponse jsonRpcResponse) {
        Logger logger = this.a.e;
        Logger.DefaultImpls.d$default(logger, ConstantsKt.LOG_TAG, "JsonRpc response = " + jsonRpcResponse, null, 4, null);
    }
}
