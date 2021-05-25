package ru.avito.websocket;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.Pair;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J=\u0010\n\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\t0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lru/avito/websocket/WebSocketFactory;", "", "Lokhttp3/WebSocketListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "sequenceId", "Lio/reactivex/Single;", "Lkotlin/Pair;", "Lokhttp3/WebSocket;", "Lru/avito/websocket/RequestIdHeader;", "create", "(Lokhttp3/WebSocketListener;Ljava/lang/String;)Lio/reactivex/Single;", "rx-websocket"}, k = 1, mv = {1, 4, 2})
public interface WebSocketFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Single create$default(WebSocketFactory webSocketFactory, WebSocketListener webSocketListener, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = null;
                }
                return webSocketFactory.create(webSocketListener, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: create");
        }
    }

    @NotNull
    Single<Pair<WebSocket, String>> create(@NotNull WebSocketListener webSocketListener, @Nullable String str);
}
