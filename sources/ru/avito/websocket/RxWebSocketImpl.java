package ru.avito.websocket;

import arrow.core.Option;
import arrow.core.OptionKt;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.reporter.WebSocketReporter;
import ru.avito.websocket.RxWebSocketState;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BS\u0012\u0006\u00105\u001a\u000202\u0012\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010#\u0012\b\u0010?\u001a\u0004\u0018\u00010<\u0012\u001a\u0010+\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u0005\u0018\u00010'\u0012\u0006\u0010A\u001a\u00020@¢\u0006\u0004\bB\u0010CJ\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J1\u0010\f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\n\u0012\f\u0012\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u000b0\t0\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0007J)\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R$\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R*\u0010+\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u0005\u0018\u00010'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R.\u00101\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010-\u0012\u0004\u0012\u00020\u00190\tj\u0002`.0,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u001c\u00107\u001a\b\u0012\u0004\u0012\u00020\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00100Re\u0010;\u001aQ\u0012M\u0012K\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010-\u0012\u0004\u0012\u00020\u00190\t\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010-\u0012\u0004\u0012\u00020\u00190\t0#j\u001a\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010-\u0012\u0004\u0012\u00020\u00190\tj\u0002`.`8¢\u0006\u0002\b90,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u00100R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006D"}, d2 = {"Lru/avito/websocket/RxWebSocketImpl;", "Lru/avito/websocket/RxWebSocket;", "", "sequenceId", "Lio/reactivex/Single;", "", "open", "(Ljava/lang/String;)Lio/reactivex/Single;", "message", "Lkotlin/Pair;", "", "Lru/avito/websocket/RequestIdHeader;", "sendMessage", "T", "Lru/avito/websocket/WebsocketMessageParser;", "messageParser", "Lio/reactivex/Observable;", "messages", "(Lru/avito/websocket/WebsocketMessageParser;)Lio/reactivex/Observable;", "", "code", "reason", "Lio/reactivex/Completable;", "close", "(ILjava/lang/String;)Lio/reactivex/Completable;", "Lru/avito/websocket/RxWebSocketState;", AuthSource.BOOKING_ORDER, "Lio/reactivex/Observable;", "getStateObservable", "()Lio/reactivex/Observable;", "stateObservable", "Lokhttp3/WebSocketListener;", "e", "Lokhttp3/WebSocketListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", a2.g.r.g.a, "Lkotlin/jvm/functions/Function1;", "log", "Lkotlin/Function2;", "", "i", "Lkotlin/jvm/functions/Function2;", "errorLog", "Lcom/jakewharton/rxrelay2/Relay;", "Lokhttp3/WebSocket;", "Lru/avito/websocket/SocketWithState;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/Relay;", "socketWithStateRelay", "Lru/avito/websocket/WebSocketFactory;", "f", "Lru/avito/websocket/WebSocketFactory;", "webSocketFactory", "d", "messageRelay", "Lru/avito/websocket/Mutator;", "Lkotlin/ExtensionFunctionType;", "c", "swsMutatorRelay", "Lru/avito/reporter/WebSocketReporter;", "h", "Lru/avito/reporter/WebSocketReporter;", "webSocketReporter", "Lio/reactivex/Scheduler;", "scheduler", "<init>", "(Lru/avito/websocket/WebSocketFactory;Lkotlin/jvm/functions/Function1;Lru/avito/reporter/WebSocketReporter;Lkotlin/jvm/functions/Function2;Lio/reactivex/Scheduler;)V", "rx-websocket"}, k = 1, mv = {1, 4, 2})
public final class RxWebSocketImpl implements RxWebSocket {
    public final Relay<Pair<WebSocket, RxWebSocketState>> a;
    @NotNull
    public final Observable<RxWebSocketState> b;
    public final Relay<Function1<Pair<? extends WebSocket, ? extends RxWebSocketState>, Pair<WebSocket, RxWebSocketState>>> c;
    public final Relay<String> d = a2.b.a.a.a.J1("PublishRelay.create<T>().toSerialized()");
    public final WebSocketListener e = new RxWebSocketImpl$listener$1(this);
    public final WebSocketFactory f;
    public final Function1<String, Unit> g;
    public final WebSocketReporter h;
    public final Function2<String, Throwable, Unit> i;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Pair<? extends WebSocket, ? extends RxWebSocketState>> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: com.jakewharton.rxrelay2.Relay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Pair<? extends WebSocket, ? extends RxWebSocketState> pair) {
            int i = this.a;
            if (i == 0) {
                RxWebSocketState rxWebSocketState = (RxWebSocketState) pair.component2();
                Function1 function1 = ((RxWebSocketImpl) this.b).g;
                if (function1 != null) {
                    Unit unit = (Unit) function1.invoke("Socket state after last action: " + rxWebSocketState);
                }
            } else if (i == 1) {
                ((RxWebSocketImpl) this.b).a.accept(pair);
            } else {
                throw null;
            }
        }
    }

    public static final class b<T1, T2, R> implements BiFunction<Pair<? extends WebSocket, ? extends RxWebSocketState>, Function1<? super Pair<? extends WebSocket, ? extends RxWebSocketState>, ? extends Pair<? extends WebSocket, ? extends RxWebSocketState>>, Pair<? extends WebSocket, ? extends RxWebSocketState>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // io.reactivex.functions.BiFunction
        public Pair<? extends WebSocket, ? extends RxWebSocketState> apply(Pair<? extends WebSocket, ? extends RxWebSocketState> pair, Function1<? super Pair<? extends WebSocket, ? extends RxWebSocketState>, ? extends Pair<? extends WebSocket, ? extends RxWebSocketState>> function1) {
            Pair<? extends WebSocket, ? extends RxWebSocketState> pair2 = pair;
            Function1<? super Pair<? extends WebSocket, ? extends RxWebSocketState>, ? extends Pair<? extends WebSocket, ? extends RxWebSocketState>> function12 = function1;
            Intrinsics.checkNotNullParameter(pair2, "socketWithState");
            Intrinsics.checkNotNullParameter(function12, "socketAction");
            return (Pair) function12.invoke(pair2);
        }
    }

    public static final class c implements Action {
        public final /* synthetic */ RxWebSocketImpl a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public c(RxWebSocketImpl rxWebSocketImpl, int i, String str) {
            this.a = rxWebSocketImpl;
            this.b = i;
            this.c = str;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            RxWebSocketImpl.access$closeInternal(this.a, this.b, this.c);
        }
    }

    public static final class d<T, R> implements Function<String, Option<? extends T>> {
        public final /* synthetic */ RxWebSocketImpl a;
        public final /* synthetic */ WebsocketMessageParser b;

        public d(RxWebSocketImpl rxWebSocketImpl, WebsocketMessageParser websocketMessageParser) {
            this.a = rxWebSocketImpl;
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
                Function2 function2 = this.a.i;
                if (function2 != null) {
                    Unit unit = (Unit) function2.invoke("Failed to parse message: " + str2, e);
                }
                return Option.Companion.empty();
            }
        }
    }

    public static final class e<T> implements SingleOnSubscribe<Unit> {
        public final /* synthetic */ RxWebSocketImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ AtomicReference c;
        public final /* synthetic */ CountDownLatch d;

        public static final class a extends Lambda implements Function1<Pair<? extends WebSocket, ? extends RxWebSocketState>, Pair<? extends WebSocket, ? extends RxWebSocketState>> {
            public final /* synthetic */ e a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(e eVar) {
                super(1);
                this.a = eVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Pair<? extends WebSocket, ? extends RxWebSocketState> invoke(Pair<? extends WebSocket, ? extends RxWebSocketState> pair) {
                Pair<? extends WebSocket, ? extends RxWebSocketState> pair2 = pair;
                Intrinsics.checkNotNullParameter(pair2, "$receiver");
                RxWebSocketState access$getState$p = RxWebSocketImplKt.access$getState$p(pair2);
                if (!(access$getState$p instanceof RxWebSocketState.Connecting) && !(access$getState$p instanceof RxWebSocketState.Connected)) {
                    if (access$getState$p instanceof RxWebSocketState.Disconnected) {
                        try {
                            pair2 = TuplesKt.to(this.a.a.f.create(this.a.a.e, this.a.b).blockingGet().getFirst(), new RxWebSocketState.Connecting());
                        } catch (Throwable th) {
                            this.a.c.set(th);
                            Throwable cause = th.getCause();
                            pair2 = TuplesKt.to(null, new RxWebSocketState.Disconnected(0, null, cause != null ? cause : th, 3, null));
                        }
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                this.a.d.countDown();
                return pair2;
            }
        }

        public e(RxWebSocketImpl rxWebSocketImpl, String str, AtomicReference atomicReference, CountDownLatch countDownLatch) {
            this.a = rxWebSocketImpl;
            this.b = str;
            this.c = atomicReference;
            this.d = countDownLatch;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.jakewharton.rxrelay2.Relay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.SingleOnSubscribe
        public final void subscribe(@NotNull SingleEmitter<Unit> singleEmitter) {
            Intrinsics.checkNotNullParameter(singleEmitter, "emitter");
            this.a.c.accept(new a(this));
            this.d.await();
            Throwable th = (Throwable) this.c.get();
            if (th != null) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    th = cause;
                }
                singleEmitter.onError(th);
                return;
            }
            singleEmitter.onSuccess(Unit.INSTANCE);
        }
    }

    public static final class f<V> implements Callable<Pair<? extends Boolean, ? extends String>> {
        public final /* synthetic */ RxWebSocketImpl a;
        public final /* synthetic */ AtomicBoolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ CountDownLatch d;

        public f(RxWebSocketImpl rxWebSocketImpl, AtomicBoolean atomicBoolean, String str, CountDownLatch countDownLatch) {
            this.a = rxWebSocketImpl;
            this.b = atomicBoolean;
            this.c = str;
            this.d = countDownLatch;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Pair<? extends Boolean, ? extends String> call() {
            this.a.c.accept(new a7.a.c.e(this));
            this.d.await();
            return TuplesKt.to(Boolean.valueOf(this.b.get()), null);
        }
    }

    public static final class g<T, R> implements Function<Pair<? extends WebSocket, ? extends RxWebSocketState>, RxWebSocketState> {
        public static final g a = new g();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public RxWebSocketState apply(Pair<? extends WebSocket, ? extends RxWebSocketState> pair) {
            Pair<? extends WebSocket, ? extends RxWebSocketState> pair2 = pair;
            Intrinsics.checkNotNullParameter(pair2, "it");
            return RxWebSocketImplKt.access$getState$p(pair2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> */
    /* JADX DEBUG: Multi-variable search result rejected for r13v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Throwable, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public RxWebSocketImpl(@NotNull WebSocketFactory webSocketFactory, @Nullable Function1<? super String, Unit> function1, @Nullable WebSocketReporter webSocketReporter, @Nullable Function2<? super String, ? super Throwable, Unit> function2, @NotNull Scheduler scheduler) {
        Intrinsics.checkNotNullParameter(webSocketFactory, "webSocketFactory");
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        this.f = webSocketFactory;
        this.g = function1;
        this.h = webSocketReporter;
        this.i = function2;
        Relay<Pair<WebSocket, RxWebSocketState>> serialized = BehaviorRelay.createDefault(TuplesKt.to(null, new RxWebSocketState.Disconnected(0, null, null, 7, null))).toSerialized();
        Intrinsics.checkNotNullExpressionValue(serialized, "BehaviorRelay.createDefa…aultValue).toSerialized()");
        this.a = serialized;
        Observable<R> map = serialized.map(g.a);
        Intrinsics.checkNotNullExpressionValue(map, "socketWithStateRelay.map { it.state }");
        this.b = map;
        Relay<Function1<Pair<? extends WebSocket, ? extends RxWebSocketState>, Pair<WebSocket, RxWebSocketState>>> J1 = a2.b.a.a.a.J1("PublishRelay.create<T>().toSerialized()");
        this.c = J1;
        J1.observeOn(scheduler).scan(TuplesKt.to(null, new RxWebSocketState.Disconnected(0, null, null, 7, null)), b.a).subscribeOn(scheduler).doOnNext(new a(0, this)).subscribe(new a(1, this));
    }

    public static final void access$closeInternal(RxWebSocketImpl rxWebSocketImpl, int i2, String str) {
        rxWebSocketImpl.c.accept(new a7.a.c.d(i2, str));
    }

    @Override // ru.avito.websocket.RxWebSocket, ru.avito.websocket.LegacyRxWebSocket
    @NotNull
    public Completable close(int i2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "reason");
        Completable fromAction = Completable.fromAction(new c(this, i2, str));
        Intrinsics.checkNotNullExpressionValue(fromAction, "Completable.fromAction {…eInternal(code, reason) }");
        return fromAction;
    }

    @Override // ru.avito.websocket.RxWebSocket, ru.avito.websocket.LegacyRxWebSocket
    @NotNull
    public Observable<RxWebSocketState> getStateObservable() {
        return this.b;
    }

    @Override // ru.avito.websocket.RxWebSocket, ru.avito.websocket.LegacyRxWebSocket
    @NotNull
    public <T> Observable<T> messages(@NotNull WebsocketMessageParser<? extends T> websocketMessageParser) {
        Intrinsics.checkNotNullParameter(websocketMessageParser, "messageParser");
        Observable<R> map = this.d.map(new d(this, websocketMessageParser));
        Intrinsics.checkNotNullExpressionValue(map, "messageRelay\n           …          }\n            }");
        return com.avito.android.util.rx.arrow.OptionKt.filterDefined(map);
    }

    @Override // ru.avito.websocket.RxWebSocket, ru.avito.websocket.LegacyRxWebSocket
    @NotNull
    public Single<Unit> open(@Nullable String str) {
        Single<Unit> create = Single.create(new e(this, str, new AtomicReference(null), new CountDownLatch(1)));
        Intrinsics.checkNotNullExpressionValue(create, "Single.create<Unit> { em…onSuccess(Unit)\n        }");
        return create;
    }

    @Override // ru.avito.websocket.RxWebSocket, ru.avito.websocket.LegacyRxWebSocket
    @NotNull
    public Single<Pair<Boolean, String>> sendMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Single<Pair<Boolean, String>> fromCallable = Single.fromCallable(new f(this, new AtomicBoolean(false), str, new CountDownLatch(1)));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable {\n  …RequestIdHeader\n        }");
        return fromCallable;
    }
}
