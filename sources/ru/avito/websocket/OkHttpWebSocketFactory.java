package ru.avito.websocket;

import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dagger.Lazy;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0015\u0010\u0016J;\u0010\n\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\t0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lru/avito/websocket/OkHttpWebSocketFactory;", "Lru/avito/websocket/WebSocketFactory;", "Lokhttp3/WebSocketListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "sequenceId", "Lio/reactivex/Single;", "Lkotlin/Pair;", "Lokhttp3/WebSocket;", "Lru/avito/websocket/RequestIdHeader;", "create", "(Lokhttp3/WebSocketListener;Ljava/lang/String;)Lio/reactivex/Single;", "Lru/avito/websocket/RequestProvider;", AuthSource.BOOKING_ORDER, "Lru/avito/websocket/RequestProvider;", "requestProvider", "Ldagger/Lazy;", "Lokhttp3/OkHttpClient;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", "okHttpClient", "<init>", "(Ldagger/Lazy;Lru/avito/websocket/RequestProvider;)V", "rx-websocket"}, k = 1, mv = {1, 4, 2})
public final class OkHttpWebSocketFactory implements WebSocketFactory {
    public final Lazy<OkHttpClient> a;
    public final RequestProvider b;

    public static final class a<T, R> implements Function<Pair<? extends Request, ? extends String>, Pair<? extends WebSocket, ? extends String>> {
        public final /* synthetic */ OkHttpWebSocketFactory a;
        public final /* synthetic */ WebSocketListener b;

        public a(OkHttpWebSocketFactory okHttpWebSocketFactory, WebSocketListener webSocketListener) {
            this.a = okHttpWebSocketFactory;
            this.b = webSocketListener;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Pair<? extends WebSocket, ? extends String> apply(Pair<? extends Request, ? extends String> pair) {
            Pair<? extends Request, ? extends String> pair2 = pair;
            Intrinsics.checkNotNullParameter(pair2, "<name for destructuring parameter 0>");
            return TuplesKt.to(((OkHttpClient) this.a.a.get()).newWebSocket((Request) pair2.component1(), this.b), (String) pair2.component2());
        }
    }

    public OkHttpWebSocketFactory(@NotNull Lazy<OkHttpClient> lazy, @NotNull RequestProvider requestProvider) {
        Intrinsics.checkNotNullParameter(lazy, "okHttpClient");
        Intrinsics.checkNotNullParameter(requestProvider, "requestProvider");
        this.a = lazy;
        this.b = requestProvider;
    }

    @Override // ru.avito.websocket.WebSocketFactory
    @NotNull
    public Single<Pair<WebSocket, String>> create(@NotNull WebSocketListener webSocketListener, @Nullable String str) {
        Intrinsics.checkNotNullParameter(webSocketListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Single<R> map = this.b.request(str).map(new a(this, webSocketListener));
        Intrinsics.checkNotNullExpressionValue(map, "requestProvider.request(…estIdHeader\n            }");
        return map;
    }
}
