package ru.avito.websocket;

import a2.g.r.g;
import arrow.core.Option;
import arrow.core.OptionKt;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;
import java.util.Objects;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.WebSocket;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.reporter.WebSocketReporter;
import ru.avito.websocket.RxWebSocketState;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010J\u001a\u00020G\u0012\u0014\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u000107\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001d\u0012\u001a\u00102\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u0005\u0018\u00010.¢\u0006\u0004\bK\u0010LJ\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J1\u0010\f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\n\u0012\f\u0012\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u000b0\t0\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0007J\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R$\u0010)\u001a\u0010\u0012\f\u0012\n &*\u0004\u0018\u00010%0%0$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R*\u00102\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u0005\u0018\u00010.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R$\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u0001078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\"\u0010B\u001a\b\u0012\u0004\u0012\u00020%0\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR$\u0010F\u001a\u0010\u0012\f\u0012\n &*\u0004\u0018\u00010%0%0C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010I¨\u0006M"}, d2 = {"Lru/avito/websocket/LegacyRxWebSocketImpl;", "Lru/avito/websocket/LegacyRxWebSocket;", "", "sequenceId", "Lio/reactivex/Single;", "", "open", "(Ljava/lang/String;)Lio/reactivex/Single;", "message", "Lkotlin/Pair;", "", "Lru/avito/websocket/RequestIdHeader;", "sendMessage", "", "code", "reason", "Lio/reactivex/Completable;", "close", "(ILjava/lang/String;)Lio/reactivex/Completable;", "T", "Lru/avito/websocket/WebsocketMessageParser;", "messageParser", "Lio/reactivex/Observable;", "messages", "(Lru/avito/websocket/WebsocketMessageParser;)Lio/reactivex/Observable;", "Lokhttp3/WebSocket;", "e", "Lokhttp3/WebSocket;", "webSocket", "Lru/avito/reporter/WebSocketReporter;", "k", "Lru/avito/reporter/WebSocketReporter;", "webSocketReporter", "f", "Ljava/lang/String;", "webSocketRequestIdHeader", "Lio/reactivex/subjects/BehaviorSubject;", "Lru/avito/websocket/RxWebSocketState;", "kotlin.jvm.PlatformType", "c", "Lio/reactivex/subjects/BehaviorSubject;", "stateStream", "Lio/reactivex/disposables/Disposable;", g.a, "Lio/reactivex/disposables/Disposable;", "socketCreationDisposable", "Lkotlin/Function2;", "", "l", "Lkotlin/jvm/functions/Function2;", "errorLog", "", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "lock", "Lkotlin/Function1;", "j", "Lkotlin/jvm/functions/Function1;", "log", "Lcom/jakewharton/rxrelay2/Relay;", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay2/Relay;", "h", "Lio/reactivex/Observable;", "getStateObservable", "()Lio/reactivex/Observable;", "stateObservable", "Lio/reactivex/subjects/Subject;", "d", "Lio/reactivex/subjects/Subject;", "serializedStateStream", "Lru/avito/websocket/WebSocketFactory;", "i", "Lru/avito/websocket/WebSocketFactory;", "webSocketFactory", "<init>", "(Lru/avito/websocket/WebSocketFactory;Lkotlin/jvm/functions/Function1;Lru/avito/reporter/WebSocketReporter;Lkotlin/jvm/functions/Function2;)V", "rx-websocket"}, k = 1, mv = {1, 4, 2})
public final class LegacyRxWebSocketImpl implements LegacyRxWebSocket {
    public final Object a = new Object();
    public final Relay<String> b = a2.b.a.a.a.J1("PublishRelay.create<T>().toSerialized()");
    public final BehaviorSubject<RxWebSocketState> c;
    public final Subject<RxWebSocketState> d;
    public volatile WebSocket e;
    public volatile String f;
    public Disposable g;
    @NotNull
    public final Observable<RxWebSocketState> h;
    public final WebSocketFactory i;
    public final Function1<String, Unit> j;
    public final WebSocketReporter k;
    public final Function2<String, Throwable, Unit> l;

    public static final class a<V> implements Callable<Object> {
        public final /* synthetic */ LegacyRxWebSocketImpl a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public a(LegacyRxWebSocketImpl legacyRxWebSocketImpl, int i, String str) {
            this.a = legacyRxWebSocketImpl;
            this.b = i;
            this.c = str;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            Unit unit;
            Function1 function1 = this.a.j;
            if (function1 != null) {
                StringBuilder L = a2.b.a.a.a.L("WS: close: ");
                L.append(this.b);
                L.append(", ");
                L.append(this.c);
                Unit unit2 = (Unit) function1.invoke(L.toString());
            }
            synchronized (this.a.a) {
                WebSocket webSocket = this.a.e;
                if (webSocket != null) {
                    webSocket.close(this.b, this.c);
                }
                this.a.d.onNext(new RxWebSocketState.Disconnected(this.b, this.c, null, 4, null));
                unit = Unit.INSTANCE;
            }
            return unit;
        }
    }

    public static final class b<T, R> implements Function<String, Option<? extends T>> {
        public final /* synthetic */ LegacyRxWebSocketImpl a;
        public final /* synthetic */ WebsocketMessageParser b;

        public b(LegacyRxWebSocketImpl legacyRxWebSocketImpl, WebsocketMessageParser websocketMessageParser) {
            this.a = legacyRxWebSocketImpl;
            this.b = websocketMessageParser;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Object apply(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "message");
            try {
                return OptionKt.toOption(this.b.parseMessage(str2));
            } catch (Exception e) {
                Function2 function2 = this.a.l;
                if (function2 != null) {
                    Unit unit = (Unit) function2.invoke("Failed to parse message: " + str2, e);
                }
                return Option.Companion.empty();
            }
        }
    }

    public static final class c<T, R> implements Function<RxWebSocketState, SingleSource<? extends Unit>> {
        public final /* synthetic */ LegacyRxWebSocketImpl a;
        public final /* synthetic */ String b;

        public c(LegacyRxWebSocketImpl legacyRxWebSocketImpl, String str) {
            this.a = legacyRxWebSocketImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends Unit> apply(RxWebSocketState rxWebSocketState) {
            RxWebSocketState rxWebSocketState2 = rxWebSocketState;
            Intrinsics.checkNotNullParameter(rxWebSocketState2, "state");
            if (rxWebSocketState2 instanceof RxWebSocketState.Connected) {
                Single just = Single.just(Unit.INSTANCE);
                Intrinsics.checkNotNullExpressionValue(just, "Single.just(Unit)");
                return just;
            } else if (rxWebSocketState2 instanceof RxWebSocketState.Connecting) {
                Single<R> flatMap = this.a.d.filter(a7.a.c.a.a).firstOrError().flatMap(a7.a.c.b.a);
                Intrinsics.checkNotNullExpressionValue(flatMap, "serializedStateStream\n  …                        }");
                return flatMap;
            } else if (rxWebSocketState2 instanceof RxWebSocketState.Disconnected) {
                Function1 function1 = this.a.j;
                if (function1 != null) {
                    Unit unit = (Unit) function1.invoke("WS: reconnect");
                }
                return LegacyRxWebSocketImpl.access$reconnect(this.a, this.b);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public static final class d<V> implements Callable<Pair<? extends Boolean, ? extends String>> {
        public final /* synthetic */ LegacyRxWebSocketImpl a;
        public final /* synthetic */ String b;

        public d(LegacyRxWebSocketImpl legacyRxWebSocketImpl, String str) {
            this.a = legacyRxWebSocketImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Pair<? extends Boolean, ? extends String> call() {
            Pair pair;
            String str;
            synchronized (this.a.a) {
                RxWebSocketState rxWebSocketState = (RxWebSocketState) this.a.c.getValue();
                boolean z = false;
                if (!(rxWebSocketState instanceof RxWebSocketState.Connected)) {
                    if (!(rxWebSocketState instanceof RxWebSocketState.Connecting)) {
                        if (!(rxWebSocketState instanceof RxWebSocketState.Disconnected)) {
                            if (rxWebSocketState != null) {
                                throw new NoWhenBranchMatchedException();
                            }
                        }
                    }
                    Function1 function1 = this.a.j;
                    if (function1 != null) {
                        Unit unit = (Unit) function1.invoke("WS: sendMessage() was called when socket is disconnected");
                    }
                } else if (this.a.e == null) {
                    Function1 function12 = this.a.j;
                    if (function12 != null) {
                        Unit unit2 = (Unit) function12.invoke("WS: Inconsistent state: state was CONNECTED and webSocket was null");
                    }
                    this.a.d.onNext(new RxWebSocketState.Disconnected(0, null, null, 7, null));
                } else {
                    WebSocket webSocket = this.a.e;
                    if (webSocket != null) {
                        z = webSocket.send(this.b);
                    }
                }
                pair = TuplesKt.to(Boolean.valueOf(z), this.a.f);
            }
            boolean booleanValue = ((Boolean) pair.component1()).booleanValue();
            String str2 = (String) pair.component2();
            WebSocketReporter webSocketReporter = this.a.k;
            if (webSocketReporter != null) {
                webSocketReporter.onSend(this.b, booleanValue);
            }
            Function1 function13 = this.a.j;
            if (function13 != null) {
                if (booleanValue) {
                    StringBuilder L = a2.b.a.a.a.L("WS: --> ");
                    L.append(this.b);
                    str = L.toString();
                } else {
                    StringBuilder L2 = a2.b.a.a.a.L("WS: send message: message wasn't enqueued: ");
                    L2.append(this.b);
                    str = L2.toString();
                }
                Unit unit3 = (Unit) function13.invoke(str);
            }
            return TuplesKt.to(Boolean.valueOf(booleanValue), str2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> */
    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Throwable, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public LegacyRxWebSocketImpl(@NotNull WebSocketFactory webSocketFactory, @Nullable Function1<? super String, Unit> function1, @Nullable WebSocketReporter webSocketReporter, @Nullable Function2<? super String, ? super Throwable, Unit> function2) {
        Intrinsics.checkNotNullParameter(webSocketFactory, "webSocketFactory");
        this.i = webSocketFactory;
        this.j = function1;
        this.k = webSocketReporter;
        this.l = function2;
        BehaviorSubject<RxWebSocketState> createDefault = BehaviorSubject.createDefault(new RxWebSocketState.Disconnected(0, null, null, 7, null));
        Intrinsics.checkNotNullExpressionValue(createDefault, "BehaviorSubject.createDe…cketState.Disconnected())");
        this.c = createDefault;
        Subject<RxWebSocketState> serialized = createDefault.toSerialized();
        Intrinsics.checkNotNullExpressionValue(serialized, "stateStream.toSerialized()");
        this.d = serialized;
        this.h = serialized;
    }

    public static final void access$cancelWebSocket(LegacyRxWebSocketImpl legacyRxWebSocketImpl) {
        Function1<String, Unit> function1 = legacyRxWebSocketImpl.j;
        if (function1 != null) {
            function1.invoke("WS: cancel previous websocket");
        }
        synchronized (legacyRxWebSocketImpl.a) {
            WebSocket webSocket = legacyRxWebSocketImpl.e;
            if (webSocket != null) {
                webSocket.cancel();
            }
            legacyRxWebSocketImpl.e = null;
            Disposable disposable = legacyRxWebSocketImpl.g;
            if (disposable != null) {
                disposable.dispose();
            }
        }
    }

    public static final LegacyRxWebSocketImpl$createWebSocketListener$1 access$createWebSocketListener(LegacyRxWebSocketImpl legacyRxWebSocketImpl, SingleEmitter singleEmitter) {
        Objects.requireNonNull(legacyRxWebSocketImpl);
        return new LegacyRxWebSocketImpl$createWebSocketListener$1(legacyRxWebSocketImpl, singleEmitter);
    }

    public static final Single access$reconnect(LegacyRxWebSocketImpl legacyRxWebSocketImpl, String str) {
        Objects.requireNonNull(legacyRxWebSocketImpl);
        Single create = Single.create(new a7.a.c.c(legacyRxWebSocketImpl, str));
        Intrinsics.checkNotNullExpressionValue(create, "Single.create { emitter …)\n            }\n        }");
        return create;
    }

    @Override // ru.avito.websocket.LegacyRxWebSocket
    @NotNull
    public Completable close(int i2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "reason");
        Completable fromCallable = Completable.fromCallable(new a(this, i2, str));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable… reason))\n        }\n    }");
        return fromCallable;
    }

    @Override // ru.avito.websocket.LegacyRxWebSocket
    @NotNull
    public Observable<RxWebSocketState> getStateObservable() {
        return this.h;
    }

    @Override // ru.avito.websocket.LegacyRxWebSocket
    @NotNull
    public <T> Observable<T> messages(@NotNull WebsocketMessageParser<? extends T> websocketMessageParser) {
        Intrinsics.checkNotNullParameter(websocketMessageParser, "messageParser");
        Observable<R> map = this.b.map(new b(this, websocketMessageParser));
        Intrinsics.checkNotNullExpressionValue(map, "messages.map { message -…)\n            }\n        }");
        return com.avito.android.util.rx.arrow.OptionKt.filterDefined(map);
    }

    @Override // ru.avito.websocket.LegacyRxWebSocket
    @NotNull
    public Single<Unit> open(@Nullable String str) {
        Single<R> flatMap = this.d.firstOrError().flatMap(new c(this, str));
        Intrinsics.checkNotNullExpressionValue(flatMap, "serializedStateStream\n  …          }\n            }");
        return flatMap;
    }

    @Override // ru.avito.websocket.LegacyRxWebSocket
    @NotNull
    public Single<Pair<Boolean, String>> sendMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Single<Pair<Boolean, String>> fromCallable = Single.fromCallable(new d(this, str));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable {\n  …requestIdHeader\n        }");
        return fromCallable;
    }
}
