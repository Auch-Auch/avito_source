package ru.avito.messenger.internal.jsonrpc;

import a2.g.r.g;
import a7.a.b.a.n.d;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.jsonrpc.client.JsonRpcClient;
import com.avito.android.jsonrpc.client.RpcRequest;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Singles;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.ResponseCodesKt;
import ru.avito.messenger.api.entity.MessengerResponse;
import ru.avito.messenger.internal.ConstantsKt;
import ru.avito.messenger.internal.entity.jsonrpc.JsonRpcRequest;
import ru.avito.messenger.internal.entity.jsonrpc.JsonRpcResponse;
import ru.avito.messenger.internal.entity.jsonrpc.MessengerJsonRpcCallException;
import ru.avito.messenger.internal.entity.jsonrpc.MessengerSocketResponseTimeoutException;
import ru.avito.messenger.internal.log.Logger;
import ru.avito.websocket.LegacyRxWebSocket;
import ru.avito.websocket.RxWebSocketState;
import ru.avito.websocket.WebsocketMessageParser;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BE\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010$\u001a\u00020!¢\u0006\u0004\b)\u0010*J;\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\b\b\u0000\u0010\u0004*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lru/avito/messenger/internal/jsonrpc/WebSocketJsonRpcClient;", "Lcom/avito/android/jsonrpc/client/JsonRpcClient;", "Lcom/google/gson/JsonElement;", "", "R", "Lcom/avito/android/jsonrpc/client/RpcRequest;", "request", "Lkotlin/Function1;", "responseParser", "Lio/reactivex/Single;", "call", "(Lcom/avito/android/jsonrpc/client/RpcRequest;Lkotlin/jvm/functions/Function1;)Lio/reactivex/Single;", "Lru/avito/websocket/LegacyRxWebSocket;", AuthSource.SEND_ABUSE, "Lru/avito/websocket/LegacyRxWebSocket;", "rxWebSocket", "", "d", "J", "timeout", "Lcom/avito/android/util/SchedulersFactory;", "f", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/google/gson/Gson;", "c", "Lcom/google/gson/Gson;", "gson", "Lru/avito/websocket/WebsocketMessageParser;", "Lru/avito/messenger/api/entity/MessengerResponse;", AuthSource.BOOKING_ORDER, "Lru/avito/websocket/WebsocketMessageParser;", "messageParser", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", g.a, "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "errorTracker", "Lru/avito/messenger/internal/log/Logger;", "e", "Lru/avito/messenger/internal/log/Logger;", "logger", "<init>", "(Lru/avito/websocket/LegacyRxWebSocket;Lru/avito/websocket/WebsocketMessageParser;Lcom/google/gson/Gson;JLru/avito/messenger/internal/log/Logger;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/communications_common/analytics/ErrorTracker;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class WebSocketJsonRpcClient implements JsonRpcClient<JsonElement> {
    public final LegacyRxWebSocket a;
    public final WebsocketMessageParser<MessengerResponse> b;
    public final Gson c;
    public final long d;
    public final Logger e;
    public final SchedulersFactory f;
    public final ErrorTracker g;

    public static final class a<T1, T2, R> implements BiFunction<R, Pair<? extends Boolean, ? extends String>, R> {
        public static final a a = new a();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // io.reactivex.functions.BiFunction
        public Object apply(Object obj, Pair<? extends Boolean, ? extends String> pair) {
            Intrinsics.checkNotNullParameter(obj, CommonKt.EXTRA_RESPONSE);
            Intrinsics.checkNotNullParameter(pair, "<anonymous parameter 1>");
            return obj;
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ WebSocketJsonRpcClient a;
        public final /* synthetic */ RpcRequest b;
        public final /* synthetic */ AtomicReference c;

        public b(WebSocketJsonRpcClient webSocketJsonRpcClient, RpcRequest rpcRequest, AtomicReference atomicReference) {
            this.a = webSocketJsonRpcClient;
            this.b = rpcRequest;
            this.c = atomicReference;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            if (th2 instanceof TimeoutException) {
                ErrorTracker errorTracker = this.a.g;
                MessengerSocketResponseTimeoutException messengerSocketResponseTimeoutException = new MessengerSocketResponseTimeoutException(th2);
                Map mutableMapOf = r.mutableMapOf(TuplesKt.to("request", this.b));
                String str = (String) this.c.get();
                if (str != null) {
                    mutableMapOf.put(CommonKt.EXTRA_RPC_ID, str);
                }
                ErrorTracker.DefaultImpls.track$default(errorTracker, messengerSocketResponseTimeoutException, null, mutableMapOf, 2, null);
            }
        }
    }

    public static final class c<T, R> implements Function<Pair<? extends Boolean, ? extends String>, SingleSource<? extends Pair<? extends Boolean, ? extends String>>> {
        public final /* synthetic */ WebSocketJsonRpcClient a;
        public final /* synthetic */ AtomicReference b;
        public final /* synthetic */ RpcRequest c;

        public c(WebSocketJsonRpcClient webSocketJsonRpcClient, AtomicReference atomicReference, RpcRequest rpcRequest) {
            this.a = webSocketJsonRpcClient;
            this.b = atomicReference;
            this.c = rpcRequest;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends Pair<? extends Boolean, ? extends String>> apply(Pair<? extends Boolean, ? extends String> pair) {
            String str;
            Pair<? extends Boolean, ? extends String> pair2 = pair;
            Intrinsics.checkNotNullParameter(pair2, "<name for destructuring parameter 0>");
            boolean booleanValue = ((Boolean) pair2.component1()).booleanValue();
            String str2 = (String) pair2.component2();
            AtomicReference atomicReference = this.b;
            if (str2 != null) {
                str = str2 + '#' + this.c.getId();
            } else {
                str = null;
            }
            atomicReference.set(str);
            if (booleanValue) {
                return Singles.toSingle(TuplesKt.to(Boolean.valueOf(booleanValue), str2));
            }
            Single error = Single.error(new MessengerJsonRpcCallException(ResponseCodesKt.JSON_RPC_CLOSED, "Message wasn't enqueued", null, String.valueOf(this.c.getId()), (String) this.b.get(), this.c.getMethod(), 4, null));
            Intrinsics.checkNotNullExpressionValue(error, "Single.error(\n          …  )\n                    )");
            return error;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: ru.avito.websocket.WebsocketMessageParser<? extends ru.avito.messenger.api.entity.MessengerResponse> */
    /* JADX WARN: Multi-variable type inference failed */
    public WebSocketJsonRpcClient(@NotNull LegacyRxWebSocket legacyRxWebSocket, @NotNull WebsocketMessageParser<? extends MessengerResponse> websocketMessageParser, @NotNull Gson gson, long j, @NotNull Logger logger, @NotNull SchedulersFactory schedulersFactory, @NotNull ErrorTracker errorTracker) {
        Intrinsics.checkNotNullParameter(legacyRxWebSocket, "rxWebSocket");
        Intrinsics.checkNotNullParameter(websocketMessageParser, "messageParser");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(errorTracker, "errorTracker");
        this.a = legacyRxWebSocket;
        this.b = websocketMessageParser;
        this.c = gson;
        this.d = j;
        this.e = logger;
        this.f = schedulersFactory;
        this.g = errorTracker;
    }

    public static final String access$toRpcId(WebSocketJsonRpcClient webSocketJsonRpcClient, String str, long j) {
        Objects.requireNonNull(webSocketJsonRpcClient);
        return str + '#' + j;
    }

    @Override // com.avito.android.jsonrpc.client.JsonRpcClient
    @NotNull
    public <R> Single<R> call(@NotNull RpcRequest rpcRequest, @NotNull Function1<? super JsonElement, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(rpcRequest, "request");
        Intrinsics.checkNotNullParameter(function1, "responseParser");
        JsonRpcRequest jsonRpcRequest = new JsonRpcRequest(rpcRequest.getId(), rpcRequest.getMethod(), rpcRequest.getParams());
        String json = this.c.toJson(jsonRpcRequest);
        Logger logger = this.e;
        Logger.DefaultImpls.d$default(logger, ConstantsKt.LOG_TAG, "JsonRpc request = " + rpcRequest, null, 4, null);
        AtomicReference atomicReference = new AtomicReference(null);
        LegacyRxWebSocket legacyRxWebSocket = this.a;
        Intrinsics.checkNotNullExpressionValue(json, "requestStr");
        Single<R> flatMap = legacyRxWebSocket.sendMessage(json).flatMap(new c(this, atomicReference, rpcRequest));
        Intrinsics.checkNotNullExpressionValue(flatMap, "rxWebSocket.sendMessage(…          }\n            }");
        long j = this.d;
        Observable doOnNext = this.a.messages(this.b).ofType(JsonRpcResponse.class).doOnNext(new a7.a.b.a.n.a(this));
        Observable<RxWebSocketState> skip = this.a.getStateObservable().skip(1);
        Intrinsics.checkNotNullExpressionValue(skip, "rxWebSocket.stateObserva…                 .skip(1)");
        Observable<U> ofType = skip.ofType(RxWebSocketState.Disconnected.class);
        Intrinsics.checkExpressionValueIsNotNull(ofType, "ofType(R::class.java)");
        Observable filter = doOnNext.takeUntil(ofType.doOnNext(new a7.a.b.a.n.b(this))).switchIfEmpty(Observable.error(new MessengerJsonRpcCallException(ResponseCodesKt.JSON_RPC_CLOSED, "WS closed or failed", null, String.valueOf(jsonRpcRequest.getId()), null, null, 52, null))).filter(new a7.a.b.a.n.c(jsonRpcRequest));
        if (j > 0) {
            filter = filter.timeout(j, TimeUnit.MILLISECONDS, this.f.computation());
        }
        Single<R> flatMap2 = filter.firstOrError().flatMap(new d(this, jsonRpcRequest, function1));
        Intrinsics.checkNotNullExpressionValue(flatMap2, "rxWebSocket.messages(mes…          }\n            }");
        Single<R> doOnError = flatMap2.zipWith(flatMap, a.a).doOnError(new b(this, rpcRequest, atomicReference));
        Intrinsics.checkNotNullExpressionValue(doOnError, "responseSingle.zipWith(s…)\n            }\n        }");
        return doOnError;
    }
}
