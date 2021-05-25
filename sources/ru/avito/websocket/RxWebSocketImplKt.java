package ru.avito.websocket;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import okhttp3.WebSocket;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*4\b\u0002\u0010\u0003\u001a\u0004\b\u0000\u0010\u0000\"\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0002\b\u00022\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0002\b\u0002*(\b\u0002\u0010\u0007\"\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004¨\u0006\b"}, d2 = {"T", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "Mutator", "Lkotlin/Pair;", "Lokhttp3/WebSocket;", "Lru/avito/websocket/RxWebSocketState;", "SocketWithState", "rx-websocket"}, k = 2, mv = {1, 4, 2})
public final class RxWebSocketImplKt {
    public static final WebSocket access$getSocket$p(Pair pair) {
        return (WebSocket) pair.getFirst();
    }

    public static final RxWebSocketState access$getState$p(Pair pair) {
        return (RxWebSocketState) pair.getSecond();
    }

    public static final Pair access$socketWithState(WebSocket webSocket, RxWebSocketState rxWebSocketState) {
        return TuplesKt.to(webSocket, rxWebSocketState);
    }
}
