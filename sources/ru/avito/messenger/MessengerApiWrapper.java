package ru.avito.messenger;

import com.avito.android.jsonrpc.client.JsonRpcClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.websocket.LegacyRxWebSocket;
import ru.avito.websocket.RxWebSocket;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0004\u0010\u0007J)\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016¢\u0006\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lru/avito/messenger/MessengerApiWrapper;", "", "Lru/avito/websocket/LegacyRxWebSocket;", "rxWebsocket", "wrap", "(Lru/avito/websocket/LegacyRxWebSocket;)Lru/avito/websocket/LegacyRxWebSocket;", "Lru/avito/websocket/RxWebSocket;", "(Lru/avito/websocket/RxWebSocket;)Lru/avito/websocket/RxWebSocket;", "T", "Lcom/avito/android/jsonrpc/client/JsonRpcClient;", "client", "wrapHttp", "(Lcom/avito/android/jsonrpc/client/JsonRpcClient;)Lcom/avito/android/jsonrpc/client/JsonRpcClient;", "wrapWebsocket", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessengerApiWrapper {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @NotNull
        public static LegacyRxWebSocket wrap(@NotNull MessengerApiWrapper messengerApiWrapper, @NotNull LegacyRxWebSocket legacyRxWebSocket) {
            Intrinsics.checkNotNullParameter(legacyRxWebSocket, "rxWebsocket");
            return legacyRxWebSocket;
        }

        @NotNull
        public static RxWebSocket wrap(@NotNull MessengerApiWrapper messengerApiWrapper, @NotNull RxWebSocket rxWebSocket) {
            Intrinsics.checkNotNullParameter(rxWebSocket, "rxWebsocket");
            return rxWebSocket;
        }

        @NotNull
        public static <T> JsonRpcClient<T> wrapHttp(@NotNull MessengerApiWrapper messengerApiWrapper, @NotNull JsonRpcClient<T> jsonRpcClient) {
            Intrinsics.checkNotNullParameter(jsonRpcClient, "client");
            return jsonRpcClient;
        }

        @NotNull
        public static <T> JsonRpcClient<T> wrapWebsocket(@NotNull MessengerApiWrapper messengerApiWrapper, @NotNull JsonRpcClient<T> jsonRpcClient) {
            Intrinsics.checkNotNullParameter(jsonRpcClient, "client");
            return jsonRpcClient;
        }
    }

    @NotNull
    LegacyRxWebSocket wrap(@NotNull LegacyRxWebSocket legacyRxWebSocket);

    @NotNull
    RxWebSocket wrap(@NotNull RxWebSocket rxWebSocket);

    @NotNull
    <T> JsonRpcClient<T> wrapHttp(@NotNull JsonRpcClient<T> jsonRpcClient);

    @NotNull
    <T> JsonRpcClient<T> wrapWebsocket(@NotNull JsonRpcClient<T> jsonRpcClient);
}
