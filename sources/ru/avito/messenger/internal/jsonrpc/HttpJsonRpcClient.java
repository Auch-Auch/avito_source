package ru.avito.messenger.internal.jsonrpc;

import a2.g.r.g;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.jsonrpc.client.JsonRpcClient;
import com.avito.android.jsonrpc.client.RpcRequest;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.preferences.SessionContract;
import com.google.gson.JsonElement;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.SessionProvider;
import ru.avito.messenger.internal.ConstantsKt;
import ru.avito.messenger.internal.entity.jsonrpc.JsonRpcRequest;
import ru.avito.messenger.internal.entity.jsonrpc.JsonRpcResponse;
import ru.avito.messenger.internal.entity.jsonrpc.MessengerJsonRpcCallException;
import ru.avito.messenger.internal.entity.jsonrpc.MessengerJsonRpcParsingException;
import ru.avito.messenger.internal.log.Logger;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BK\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u001c\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b(\u0010)J;\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\b\b\u0000\u0010\u0004*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lru/avito/messenger/internal/jsonrpc/HttpJsonRpcClient;", "Lcom/avito/android/jsonrpc/client/JsonRpcClient;", "Lcom/google/gson/JsonElement;", "", "R", "Lcom/avito/android/jsonrpc/client/RpcRequest;", "request", "Lkotlin/Function1;", "responseParser", "Lio/reactivex/Single;", "call", "(Lcom/avito/android/jsonrpc/client/RpcRequest;Lkotlin/jvm/functions/Function1;)Lio/reactivex/Single;", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", g.a, "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "errorTracker", "Lru/avito/messenger/internal/jsonrpc/HttpApi;", AuthSource.SEND_ABUSE, "Lru/avito/messenger/internal/jsonrpc/HttpApi;", "httpApi", "Lru/avito/messenger/SessionProvider;", AuthSource.BOOKING_ORDER, "Lru/avito/messenger/SessionProvider;", "sessionProvider", "", "c", "Ljava/lang/String;", "origin", "", "d", "Ljava/util/Map;", "queryParameters", "Lcom/avito/android/util/SchedulersFactory;", "f", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lru/avito/messenger/internal/log/Logger;", "e", "Lru/avito/messenger/internal/log/Logger;", "logger", "<init>", "(Lru/avito/messenger/internal/jsonrpc/HttpApi;Lru/avito/messenger/SessionProvider;Ljava/lang/String;Ljava/util/Map;Lru/avito/messenger/internal/log/Logger;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/communications_common/analytics/ErrorTracker;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class HttpJsonRpcClient implements JsonRpcClient<JsonElement> {
    public final HttpApi a;
    public final SessionProvider b;
    public final String c;
    public final Map<String, String> d;
    public final Logger e;
    public final SchedulersFactory f;
    public final ErrorTracker g;

    public static final class a<T, R> implements Function<String, SingleSource<? extends JsonRpcResponse>> {
        public final /* synthetic */ HttpJsonRpcClient a;
        public final /* synthetic */ JsonRpcRequest b;

        public a(HttpJsonRpcClient httpJsonRpcClient, JsonRpcRequest jsonRpcRequest) {
            this.a = httpJsonRpcClient;
            this.b = jsonRpcRequest;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends JsonRpcResponse> apply(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, SessionContract.SESSION);
            return this.a.a.sendRequest(this.a.c, str2, this.a.d, this.b).subscribeOn(this.a.f.io());
        }
    }

    public static final class b<T> implements Consumer<JsonRpcResponse> {
        public final /* synthetic */ HttpJsonRpcClient a;

        public b(HttpJsonRpcClient httpJsonRpcClient) {
            this.a = httpJsonRpcClient;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(JsonRpcResponse jsonRpcResponse) {
            Logger logger = this.a.e;
            Logger.DefaultImpls.d$default(logger, ConstantsKt.LOG_TAG, "JsonRpc response = " + jsonRpcResponse, null, 4, null);
        }
    }

    public static final class c<T, R> implements Function<Throwable, SingleSource<? extends JsonRpcResponse>> {
        public final /* synthetic */ RpcRequest a;

        public c(RpcRequest rpcRequest) {
            this.a = rpcRequest;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends JsonRpcResponse> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "error");
            StringBuilder L = a2.b.a.a.a.L("Failed to execute JsonRpc request ");
            L.append(this.a);
            return Single.error(new MessengerJsonRpcCallException(-1, L.toString(), th2, String.valueOf(this.a.getId()), null, null, 48, null));
        }
    }

    public static final class d<T, R> implements Function<JsonRpcResponse, SingleSource<? extends R>> {
        public final /* synthetic */ HttpJsonRpcClient a;
        public final /* synthetic */ RpcRequest b;
        public final /* synthetic */ Function1 c;

        public d(HttpJsonRpcClient httpJsonRpcClient, RpcRequest rpcRequest, Function1 function1) {
            this.a = httpJsonRpcClient;
            this.b = rpcRequest;
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

    public HttpJsonRpcClient(@NotNull HttpApi httpApi, @NotNull SessionProvider sessionProvider, @NotNull String str, @NotNull Map<String, String> map, @NotNull Logger logger, @NotNull SchedulersFactory schedulersFactory, @NotNull ErrorTracker errorTracker) {
        Intrinsics.checkNotNullParameter(httpApi, "httpApi");
        Intrinsics.checkNotNullParameter(sessionProvider, "sessionProvider");
        Intrinsics.checkNotNullParameter(str, "origin");
        Intrinsics.checkNotNullParameter(map, "queryParameters");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(errorTracker, "errorTracker");
        this.a = httpApi;
        this.b = sessionProvider;
        this.c = str;
        this.d = map;
        this.e = logger;
        this.f = schedulersFactory;
        this.g = errorTracker;
    }

    @Override // com.avito.android.jsonrpc.client.JsonRpcClient
    @NotNull
    public <R> Single<R> call(@NotNull RpcRequest rpcRequest, @NotNull Function1<? super JsonElement, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(rpcRequest, "request");
        Intrinsics.checkNotNullParameter(function1, "responseParser");
        Single<R> flatMap = this.b.session().flatMap(new a(this, new JsonRpcRequest(rpcRequest.getId(), rpcRequest.getMethod(), rpcRequest.getParams()))).doOnSuccess(new b(this)).onErrorResumeNext(new c(rpcRequest)).flatMap(new d(this, rpcRequest, function1));
        Intrinsics.checkNotNullExpressionValue(flatMap, "sessionProvider.session(…          }\n            }");
        return flatMap;
    }
}
