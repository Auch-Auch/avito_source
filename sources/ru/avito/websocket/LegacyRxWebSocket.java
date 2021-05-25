package ru.avito.websocket;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J1\u0010\f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\n\u0012\f\u0012\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u000b0\t0\u00042\u0006\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0007J\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H&¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lru/avito/websocket/LegacyRxWebSocket;", "", "", "sequenceId", "Lio/reactivex/Single;", "", "open", "(Ljava/lang/String;)Lio/reactivex/Single;", "message", "Lkotlin/Pair;", "", "Lru/avito/websocket/RequestIdHeader;", "sendMessage", "", "code", "reason", "Lio/reactivex/Completable;", "close", "(ILjava/lang/String;)Lio/reactivex/Completable;", "T", "Lru/avito/websocket/WebsocketMessageParser;", "messageParser", "Lio/reactivex/Observable;", "messages", "(Lru/avito/websocket/WebsocketMessageParser;)Lio/reactivex/Observable;", "Lru/avito/websocket/RxWebSocketState;", "getStateObservable", "()Lio/reactivex/Observable;", "stateObservable", "rx-websocket"}, k = 1, mv = {1, 4, 2})
public interface LegacyRxWebSocket {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Single open$default(LegacyRxWebSocket legacyRxWebSocket, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                return legacyRxWebSocket.open(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: open");
        }
    }

    @NotNull
    Completable close(int i, @NotNull String str);

    @NotNull
    Observable<RxWebSocketState> getStateObservable();

    @NotNull
    <T> Observable<T> messages(@NotNull WebsocketMessageParser<? extends T> websocketMessageParser);

    @NotNull
    Single<Unit> open(@Nullable String str);

    @NotNull
    Single<Pair<Boolean, String>> sendMessage(@NotNull String str);
}
