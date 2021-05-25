package a7.a.b.a.n;

import com.avito.android.communications_common.analytics.ErrorTracker;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.internal.entity.jsonrpc.JsonRpcRequest;
import ru.avito.messenger.internal.entity.jsonrpc.JsonRpcResponse;
import ru.avito.messenger.internal.entity.jsonrpc.MessengerJsonRpcCallException;
import ru.avito.messenger.internal.entity.jsonrpc.MessengerJsonRpcParsingException;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
import ru.avito.messenger.internal.jsonrpc.WebSocketJsonRpcClient;
import t6.n.r;
public final class d<T, R> implements Function<JsonRpcResponse, SingleSource<? extends T>> {
    public final /* synthetic */ WebSocketJsonRpcClient a;
    public final /* synthetic */ JsonRpcRequest b;
    public final /* synthetic */ Function1 c;

    public d(WebSocketJsonRpcClient webSocketJsonRpcClient, JsonRpcRequest jsonRpcRequest, Function1 function1) {
        this.a = webSocketJsonRpcClient;
        this.b = jsonRpcRequest;
        this.c = function1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Object apply(JsonRpcResponse jsonRpcResponse) {
        JsonRpcResponse jsonRpcResponse2 = jsonRpcResponse;
        Intrinsics.checkNotNullParameter(jsonRpcResponse2, CommonKt.EXTRA_RESPONSE);
        if (jsonRpcResponse2.getError() != null) {
            MessengerJsonRpcCallException messengerJsonRpcCallException = new MessengerJsonRpcCallException(jsonRpcResponse2.getError().getCode(), jsonRpcResponse2.getError().getMessage(), null, jsonRpcResponse2.getRequestId(), jsonRpcResponse2.getRpcId(), this.b.getMethod(), 4, null);
            ErrorTracker.DefaultImpls.track$default(this.a.g, messengerJsonRpcCallException, null, r.mapOf(TuplesKt.to("request", this.b), TuplesKt.to(CommonKt.EXTRA_RESPONSE, jsonRpcResponse2)), 2, null);
            return Single.error(messengerJsonRpcCallException);
        }
        try {
            return Single.just(this.c.invoke(jsonRpcResponse2.getResult()));
        } catch (Throwable th) {
            ErrorTracker.DefaultImpls.track$default(this.a.g, new MessengerJsonRpcParsingException(null, th, jsonRpcResponse2.getRequestId(), jsonRpcResponse2.getRpcId(), this.b.getMethod(), 1, null), null, r.mapOf(TuplesKt.to("request", this.b), TuplesKt.to(CommonKt.EXTRA_RESPONSE, jsonRpcResponse2)), 2, null);
            return Single.error(th);
        }
    }
}
