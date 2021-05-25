package ru.avito.websocket;

import a7.a.c.f;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.websocket.RxWebSocketState;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b!\u0010\"J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J1\u0010\f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\n\u0012\f\u0012\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u000b0\t0\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0007J\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00168V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lru/avito/websocket/RxWebSocketToLegacyAdapter;", "Lru/avito/websocket/LegacyRxWebSocket;", "", "sequenceId", "Lio/reactivex/Single;", "", "open", "(Ljava/lang/String;)Lio/reactivex/Single;", "message", "Lkotlin/Pair;", "", "Lru/avito/websocket/RequestIdHeader;", "sendMessage", "", "code", "reason", "Lio/reactivex/Completable;", "close", "(ILjava/lang/String;)Lio/reactivex/Completable;", "T", "Lru/avito/websocket/WebsocketMessageParser;", "messageParser", "Lio/reactivex/Observable;", "messages", "(Lru/avito/websocket/WebsocketMessageParser;)Lio/reactivex/Observable;", "Lru/avito/websocket/RxWebSocketState;", "getStateObservable", "()Lio/reactivex/Observable;", "stateObservable", "Lru/avito/websocket/RxWebSocket;", AuthSource.SEND_ABUSE, "Lru/avito/websocket/RxWebSocket;", "rxWebSocket", "<init>", "(Lru/avito/websocket/RxWebSocket;)V", "rx-websocket"}, k = 1, mv = {1, 4, 2})
public final class RxWebSocketToLegacyAdapter implements LegacyRxWebSocket {
    public final RxWebSocket a;

    public static final class a<T, R> implements Function<Throwable, SingleSource<? extends Unit>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends Unit> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            Throwable cause = th2.getCause();
            if (cause != null) {
                th2 = cause;
            }
            return Single.error(th2);
        }
    }

    public static final class b<T, R> implements Function<Unit, SingleSource<? extends RxWebSocketState>> {
        public final /* synthetic */ RxWebSocketToLegacyAdapter a;

        public b(RxWebSocketToLegacyAdapter rxWebSocketToLegacyAdapter) {
            this.a = rxWebSocketToLegacyAdapter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends RxWebSocketState> apply(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return this.a.a.getStateObservable().filter(f.a).firstOrError();
        }
    }

    public static final class c<T, R> implements Function<RxWebSocketState, SingleSource<? extends Unit>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends Unit> apply(RxWebSocketState rxWebSocketState) {
            Single error;
            RxWebSocketState rxWebSocketState2 = rxWebSocketState;
            Intrinsics.checkNotNullParameter(rxWebSocketState2, "state");
            if ((rxWebSocketState2 instanceof RxWebSocketState.Connected) || (rxWebSocketState2 instanceof RxWebSocketState.Connecting)) {
                return Single.just(Unit.INSTANCE);
            }
            if (rxWebSocketState2 instanceof RxWebSocketState.Disconnected) {
                RxWebSocketState.Disconnected disconnected = (RxWebSocketState.Disconnected) rxWebSocketState2;
                Throwable error2 = disconnected.getError();
                if (error2 != null && (error = Single.error(error2)) != null) {
                    return error;
                }
                StringBuilder L = a2.b.a.a.a.L("Failed to open socket. Socket state is DISCONNECTED with code ");
                L.append(disconnected.getCode());
                return Single.error(new RuntimeException(L.toString()));
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public RxWebSocketToLegacyAdapter(@NotNull RxWebSocket rxWebSocket) {
        Intrinsics.checkNotNullParameter(rxWebSocket, "rxWebSocket");
        this.a = rxWebSocket;
    }

    @Override // ru.avito.websocket.LegacyRxWebSocket
    @NotNull
    public Completable close(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "reason");
        Single flatMap = this.a.close(i, str).toSingleDefault(Unit.INSTANCE).flatMap(new Function<Unit, SingleSource<? extends T>>(this) { // from class: ru.avito.websocket.RxWebSocketToLegacyAdapter$close$$inlined$flatMapSingle$1
            public final /* synthetic */ RxWebSocketToLegacyAdapter a;

            {
                this.a = r1;
            }

            public final SingleSource<? extends T> apply(@NotNull Unit unit) {
                Intrinsics.checkNotNullParameter(unit, "it");
                Single<U> firstOrError = this.a.a.getStateObservable().ofType(RxWebSocketState.Disconnected.class).firstOrError();
                Intrinsics.checkNotNullExpressionValue(firstOrError, "rxWebSocket.stateObserva…          .firstOrError()");
                return firstOrError;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "toSingleDefault(Unit).flatMap { singleFactory() }");
        Completable ignoreElement = flatMap.ignoreElement();
        Intrinsics.checkNotNullExpressionValue(ignoreElement, "rxWebSocket.close(code, …         .ignoreElement()");
        return ignoreElement;
    }

    @Override // ru.avito.websocket.LegacyRxWebSocket
    @NotNull
    public Observable<RxWebSocketState> getStateObservable() {
        return this.a.getStateObservable();
    }

    @Override // ru.avito.websocket.LegacyRxWebSocket
    @NotNull
    public <T> Observable<T> messages(@NotNull WebsocketMessageParser<? extends T> websocketMessageParser) {
        Intrinsics.checkNotNullParameter(websocketMessageParser, "messageParser");
        return this.a.messages(websocketMessageParser);
    }

    @Override // ru.avito.websocket.LegacyRxWebSocket
    @NotNull
    public Single<Unit> open(@Nullable String str) {
        Single<R> flatMap = this.a.open(str).onErrorResumeNext(a.a).flatMap(new b(this)).flatMap(c.a);
        Intrinsics.checkNotNullExpressionValue(flatMap, "rxWebSocket.open(sequenc…          }\n            }");
        return flatMap;
    }

    @Override // ru.avito.websocket.LegacyRxWebSocket
    @NotNull
    public Single<Pair<Boolean, String>> sendMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        return this.a.sendMessage(str);
    }
}
