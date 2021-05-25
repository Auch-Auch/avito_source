package ru.avito.messenger.internal.connection;

import a2.g.r.g;
import a7.a.b.a.m.h;
import a7.a.b.a.m.i;
import androidx.annotation.VisibleForTesting;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.jsonrpc.client.JsonRpcCallException;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Singles;
import com.avito.android.util.preferences.SessionContract;
import hu.akarnokd.rxjava2.schedulers.SharedScheduler;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.rxkotlin.DisposableKt;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.KeepConnectionProvider;
import ru.avito.messenger.MessengerApi;
import ru.avito.messenger.MessengerSessionRefresher;
import ru.avito.messenger.NetworkMonitor;
import ru.avito.messenger.ReconnectIntervalGenerator;
import ru.avito.messenger.SessionProvider;
import ru.avito.messenger.api.entity.MessengerResponse;
import ru.avito.messenger.config.MessengerConfig;
import ru.avito.messenger.config.MessengerConfigKt;
import ru.avito.messenger.config.MessengerConfigStorage;
import ru.avito.messenger.internal.connection.MessengerConnectionHolder;
import ru.avito.messenger.internal.connection.MessengerConnectionHolderImpl;
import ru.avito.messenger.internal.entity.messenger.ServerConfig;
import ru.avito.messenger.internal.entity.messenger.SystemMessage;
import ru.avito.messenger.internal.entity.messenger.TerminationEvent;
import ru.avito.messenger.internal.entity.messenger.UserSession;
import ru.avito.messenger.internal.log.Logger;
import ru.avito.messenger.internal.state_machine.StateMachine;
import ru.avito.websocket.LegacyRxWebSocket;
import ru.avito.websocket.RxWebSocketState;
import ru.avito.websocket.WebsocketMessageParser;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\tLMNOPQRSTB\u0001\u0012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020'0&\u0012\u0006\u0010?\u001a\u00020<\u0012\u0006\u0010\u001d\u001a\u00028\u0000\u0012\f\u00103\u001a\b\u0012\u0004\u0012\u00020,00\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u00107\u001a\u000204\u0012\u0006\u0010;\u001a\u000208\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010C\u001a\u00020B\u0012\u0006\u0010E\u001a\u00020D\u0012\u0006\u0010G\u001a\u00020F\u0012\b\b\u0002\u0010I\u001a\u00020H¢\u0006\u0004\bJ\u0010KJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00028\u00008V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00028\u00008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020'0&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020,0+8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020,008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020'0+8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b@\u0010.¨\u0006U"}, d2 = {"Lru/avito/messenger/internal/connection/MessengerConnectionHolderImpl;", "Lru/avito/messenger/MessengerApi;", "T", "Lru/avito/messenger/internal/connection/MessengerConnectionHolder;", "", "connect", "()V", "disconnect", "Lio/reactivex/disposables/CompositeDisposable;", AuthSource.SEND_ABUSE, "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "getApi", "()Lru/avito/messenger/MessengerApi;", "api", "Lru/avito/messenger/internal/log/Logger;", "h", "Lru/avito/messenger/internal/log/Logger;", "logger", "Lcom/avito/android/util/SchedulersFactory;", "i", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lru/avito/messenger/ReconnectIntervalGenerator;", g.a, "Lru/avito/messenger/ReconnectIntervalGenerator;", "reconnectIntervalGenerator", "e", "Lru/avito/messenger/MessengerApi;", "socketApi", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "l", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "errorTracker", "Lio/reactivex/Scheduler;", AuthSource.BOOKING_ORDER, "Lio/reactivex/Scheduler;", "eventHandlingScheduler", "Lru/avito/messenger/internal/state_machine/StateMachine;", "Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State;", "c", "Lru/avito/messenger/internal/state_machine/StateMachine;", "stateMachine", "Lio/reactivex/Observable;", "Lru/avito/messenger/api/entity/MessengerResponse;", "getMessagesStream", "()Lio/reactivex/Observable;", "messagesStream", "Lru/avito/websocket/WebsocketMessageParser;", "f", "Lru/avito/websocket/WebsocketMessageParser;", "messageParser", "Lru/avito/messenger/MessengerSessionRefresher;", "j", "Lru/avito/messenger/MessengerSessionRefresher;", "sessionRefresher", "Lru/avito/messenger/config/MessengerConfigStorage;", "k", "Lru/avito/messenger/config/MessengerConfigStorage;", "configStorage", "Lru/avito/websocket/LegacyRxWebSocket;", "d", "Lru/avito/websocket/LegacyRxWebSocket;", "websocket", "getStateObservable", "stateObservable", "Lru/avito/messenger/NetworkMonitor;", "networkMonitor", "Lru/avito/messenger/SessionProvider;", "sessionProvider", "Lru/avito/messenger/KeepConnectionProvider;", "keepConnectionProvider", "", "manualPingIntervalMs", "<init>", "(Lru/avito/messenger/internal/state_machine/StateMachine;Lru/avito/websocket/LegacyRxWebSocket;Lru/avito/messenger/MessengerApi;Lru/avito/websocket/WebsocketMessageParser;Lru/avito/messenger/ReconnectIntervalGenerator;Lru/avito/messenger/internal/log/Logger;Lcom/avito/android/util/SchedulersFactory;Lru/avito/messenger/MessengerSessionRefresher;Lru/avito/messenger/config/MessengerConfigStorage;Lcom/avito/android/communications_common/analytics/ErrorTracker;Lru/avito/messenger/NetworkMonitor;Lru/avito/messenger/SessionProvider;Lru/avito/messenger/KeepConnectionProvider;J)V", "CanConnectChangedMutator", "ConnectMutator", "DisconnectMutator", "NewSequenceIdMutator", "PerformConnectMutator", "StateWatchDogMutator", "TransportConnectedMutator", "TransportDisconnectedMutator", "UserSessionReceivedMutator", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessengerConnectionHolderImpl<T extends MessengerApi> implements MessengerConnectionHolder<T> {
    public final CompositeDisposable a;
    public final Scheduler b;
    public final StateMachine<MessengerConnectionHolder.State> c;
    public final LegacyRxWebSocket d;
    public final T e;
    public final WebsocketMessageParser<MessengerResponse> f;
    public final ReconnectIntervalGenerator g;
    public final Logger h;
    public final SchedulersFactory i;
    public final MessengerSessionRefresher j;
    public final MessengerConfigStorage k;
    public final ErrorTracker l;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\n¨\u0006\u0014"}, d2 = {"Lru/avito/messenger/internal/connection/MessengerConnectionHolderImpl$CanConnectChangedMutator;", "Lru/avito/messenger/internal/state_machine/StateMachine$Mutator;", "Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State;", "oldState", "Lio/reactivex/Single;", "apply", "(Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State;)Lio/reactivex/Single;", "Lkotlin/Function0;", "", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function0;", "performConnect", "", AuthSource.SEND_ABUSE, "Z", "canConnect", "c", "performDisconnect", "<init>", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @VisibleForTesting(otherwise = 3)
    public static final class CanConnectChangedMutator implements StateMachine.Mutator<MessengerConnectionHolder.State> {
        public final boolean a;
        public final Function0<Unit> b;
        public final Function0<Unit> c;

        public static final class a<T> implements Consumer<MessengerConnectionHolder.State> {
            public final /* synthetic */ CanConnectChangedMutator a;
            public final /* synthetic */ MessengerConnectionHolder.State b;

            public a(CanConnectChangedMutator canConnectChangedMutator, MessengerConnectionHolder.State state) {
                this.a = canConnectChangedMutator;
                this.b = state;
            }

            @Override // io.reactivex.functions.Consumer
            public void accept(MessengerConnectionHolder.State state) {
                if (this.a.a && this.b.isAwaitingConnection()) {
                    this.a.b.invoke();
                }
            }
        }

        public static final class b<T> implements Consumer<MessengerConnectionHolder.State> {
            public final /* synthetic */ CanConnectChangedMutator a;

            public b(CanConnectChangedMutator canConnectChangedMutator) {
                this.a = canConnectChangedMutator;
            }

            @Override // io.reactivex.functions.Consumer
            public void accept(MessengerConnectionHolder.State state) {
                if (!this.a.a) {
                    this.a.c.invoke();
                }
            }
        }

        public CanConnectChangedMutator(boolean z, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
            Intrinsics.checkNotNullParameter(function0, "performConnect");
            Intrinsics.checkNotNullParameter(function02, "performDisconnect");
            this.a = z;
            this.b = function0;
            this.c = function02;
        }

        @NotNull
        public Single<MessengerConnectionHolder.State> apply(@NotNull MessengerConnectionHolder.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (state instanceof MessengerConnectionHolder.State.Disconnected) {
                Single<MessengerConnectionHolder.State> doAfterSuccess = Singles.toSingle(state).doAfterSuccess(new a(this, state));
                Intrinsics.checkNotNullExpressionValue(doAfterSuccess, "oldState.toSingle<State>…                        }");
                return doAfterSuccess;
            } else if (!(state instanceof MessengerConnectionHolder.State.Connecting.Socket) && !(state instanceof MessengerConnectionHolder.State.Connecting.Session) && !(state instanceof MessengerConnectionHolder.State.Connected)) {
                throw new NoWhenBranchMatchedException();
            } else {
                Single<MessengerConnectionHolder.State> doAfterSuccess2 = Singles.toSingle(state).doAfterSuccess(new b(this));
                Intrinsics.checkNotNullExpressionValue(doAfterSuccess2, "oldState.toSingle()\n    …                        }");
                return doAfterSuccess2;
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lru/avito/messenger/internal/connection/MessengerConnectionHolderImpl$ConnectMutator;", "Lru/avito/messenger/internal/state_machine/StateMachine$Mutator;", "Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State;", "oldState", "Lio/reactivex/Single;", "apply", "(Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State;)Lio/reactivex/Single;", "Lkotlin/Function0;", "", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function0;", "performConnect", "", AuthSource.SEND_ABUSE, "Z", "forceConnect", "<init>", "(ZLkotlin/jvm/functions/Function0;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @VisibleForTesting(otherwise = 3)
    public static final class ConnectMutator implements StateMachine.Mutator<MessengerConnectionHolder.State> {
        public final boolean a;
        public final Function0<Unit> b;

        public static final class a<T> implements Consumer<MessengerConnectionHolder.State> {
            public final /* synthetic */ ConnectMutator a;

            public a(ConnectMutator connectMutator) {
                this.a = connectMutator;
            }

            @Override // io.reactivex.functions.Consumer
            public void accept(MessengerConnectionHolder.State state) {
                this.a.b.invoke();
            }
        }

        public ConnectMutator(boolean z, @NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "performConnect");
            this.a = z;
            this.b = function0;
        }

        @NotNull
        public Single<MessengerConnectionHolder.State> apply(@NotNull MessengerConnectionHolder.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (state instanceof MessengerConnectionHolder.State.Disconnected) {
                if (!this.a && !state.isAwaitingConnection()) {
                    return Singles.toSingle(state);
                }
                Single<MessengerConnectionHolder.State> doAfterSuccess = Singles.toSingle(MessengerConnectionHolder.State.Disconnected.copy$default((MessengerConnectionHolder.State.Disconnected) state, true, null, null, 6, null)).doAfterSuccess(new a(this));
                Intrinsics.checkNotNullExpressionValue(doAfterSuccess, "oldState.copy(isAwaiting…cess { performConnect() }");
                return doAfterSuccess;
            } else if ((state instanceof MessengerConnectionHolder.State.Connecting) || (state instanceof MessengerConnectionHolder.State.Connected)) {
                return Singles.toSingle(state);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lru/avito/messenger/internal/connection/MessengerConnectionHolderImpl$DisconnectMutator;", "Lru/avito/messenger/internal/state_machine/StateMachine$Mutator;", "Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State;", "oldState", "Lio/reactivex/Single;", "apply", "(Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State;)Lio/reactivex/Single;", "", AuthSource.SEND_ABUSE, "Z", "shouldReconnect", "<init>", "(Lru/avito/messenger/internal/connection/MessengerConnectionHolderImpl;Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @VisibleForTesting(otherwise = 3)
    public final class DisconnectMutator implements StateMachine.Mutator<MessengerConnectionHolder.State> {
        public final boolean a;

        public static final class a<T, R> implements Function<Throwable, MessengerConnectionHolder.State> {
            public final /* synthetic */ MessengerConnectionHolder.State a;

            public a(MessengerConnectionHolder.State state) {
                this.a = state;
            }

            @Override // io.reactivex.functions.Function
            public MessengerConnectionHolder.State apply(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "it");
                return this.a;
            }
        }

        public DisconnectMutator(boolean z) {
            MessengerConnectionHolderImpl.this = r1;
            this.a = z;
        }

        @NotNull
        public Single<MessengerConnectionHolder.State> apply(@NotNull MessengerConnectionHolder.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if ((state instanceof MessengerConnectionHolder.State.Connected) || (state instanceof MessengerConnectionHolder.State.Connecting)) {
                Single<MessengerConnectionHolder.State> onErrorReturn = MessengerConnectionHolderImpl.this.d.close(1000, "Closed by client").toSingleDefault(new MessengerConnectionHolder.State.Disconnected(this.a, null, state.getSequenceId(), 2, null)).onErrorReturn(new a(state));
                Intrinsics.checkNotNullExpressionValue(onErrorReturn, "websocket.close(JSON_RPC…nErrorReturn { oldState }");
                return onErrorReturn;
            } else if (state instanceof MessengerConnectionHolder.State.Disconnected) {
                return Singles.toSingle(state);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lru/avito/messenger/internal/connection/MessengerConnectionHolderImpl$NewSequenceIdMutator;", "Lru/avito/messenger/internal/state_machine/StateMachine$Mutator;", "Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State;", "oldState", "Lio/reactivex/Single;", "apply", "(Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State;)Lio/reactivex/Single;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "sequenceId", "<init>", "(Lru/avito/messenger/internal/connection/MessengerConnectionHolderImpl;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @VisibleForTesting(otherwise = 3)
    public final class NewSequenceIdMutator implements StateMachine.Mutator<MessengerConnectionHolder.State> {
        public final String a;
        public final /* synthetic */ MessengerConnectionHolderImpl b;

        public NewSequenceIdMutator(@NotNull MessengerConnectionHolderImpl messengerConnectionHolderImpl, String str) {
            Intrinsics.checkNotNullParameter(str, "sequenceId");
            this.b = messengerConnectionHolderImpl;
            this.a = str;
        }

        @NotNull
        public Single<MessengerConnectionHolder.State> apply(@NotNull MessengerConnectionHolder.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (state instanceof MessengerConnectionHolder.State.Connected) {
                return Singles.toSingle(MessengerConnectionHolder.State.Connected.copy$default((MessengerConnectionHolder.State.Connected) state, null, false, this.a, 3, null));
            }
            Logger logger = this.b.h;
            StringBuilder L = a2.b.a.a.a.L("new sequenceId skipped: ");
            L.append(this.a);
            L.append(", state was = ");
            L.append(state);
            Logger.DefaultImpls.v$default(logger, "ConnectionHolder", L.toString(), null, 4, null);
            return Singles.toSingle(state);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lru/avito/messenger/internal/connection/MessengerConnectionHolderImpl$PerformConnectMutator;", "Lru/avito/messenger/internal/state_machine/StateMachine$Mutator;", "Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State;", "oldState", "Lio/reactivex/Single;", "apply", "(Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State;)Lio/reactivex/Single;", "", AuthSource.BOOKING_ORDER, "Z", "resetConnection", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", SessionContract.SESSION, "<init>", "(Lru/avito/messenger/internal/connection/MessengerConnectionHolderImpl;Ljava/lang/String;Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @VisibleForTesting(otherwise = 3)
    public final class PerformConnectMutator implements StateMachine.Mutator<MessengerConnectionHolder.State> {
        public final String a;
        public final boolean b;
        public final /* synthetic */ MessengerConnectionHolderImpl c;

        /* compiled from: java-style lambda group */
        public static final class a<T, R> implements Function<Unit, MessengerConnectionHolder.State> {
            public final /* synthetic */ int a;
            public final /* synthetic */ Object b;

            public a(int i, Object obj) {
                this.a = i;
                this.b = obj;
            }

            @Override // io.reactivex.functions.Function
            public final MessengerConnectionHolder.State apply(Unit unit) {
                int i = this.a;
                if (i == 0) {
                    Intrinsics.checkNotNullParameter(unit, "it");
                    return new MessengerConnectionHolder.State.Connecting.Socket(((MessengerConnectionHolder.State) this.b).getSequenceId());
                } else if (i == 1) {
                    Intrinsics.checkNotNullParameter(unit, "it");
                    return new MessengerConnectionHolder.State.Connecting.Socket(((MessengerConnectionHolder.State) this.b).getSequenceId());
                } else {
                    throw null;
                }
            }
        }

        public static final class b<T, R> implements Function<Throwable, SingleSource<? extends MessengerConnectionHolder.State>> {
            public final /* synthetic */ PerformConnectMutator a;
            public final /* synthetic */ MessengerConnectionHolder.State b;

            public b(PerformConnectMutator performConnectMutator, MessengerConnectionHolder.State state) {
                this.a = performConnectMutator;
                this.b = state;
            }

            @Override // io.reactivex.functions.Function
            public SingleSource<? extends MessengerConnectionHolder.State> apply(Throwable th) {
                TerminationEvent terminationEvent;
                Throwable th2 = th;
                Intrinsics.checkNotNullParameter(th2, "error");
                if (th2 instanceof JsonRpcCallException) {
                    int code = ((JsonRpcCallException) th2).getCode();
                    String message = th2.getMessage();
                    if (code != -32043) {
                        if (!(code == -32041 || code == 401)) {
                            if (code != 403) {
                                if (code == 1000) {
                                    terminationEvent = new TerminationEvent.ClosedByUser();
                                } else if (code != 3401) {
                                    if (code != 3403) {
                                        terminationEvent = new TerminationEvent.Unknown(Integer.valueOf(code), message, th2);
                                    }
                                }
                            }
                        }
                        terminationEvent = new TerminationEvent.UnauthorizedError(code, th2);
                    }
                    terminationEvent = new TerminationEvent.ForbiddenError(th2);
                } else if (th2 instanceof IOException) {
                    terminationEvent = new TerminationEvent.NetworkError(th2);
                } else {
                    terminationEvent = new TerminationEvent.Unknown(null, th2.getMessage(), th2);
                }
                return MessengerConnectionHolderKt.handleConnectionError(terminationEvent, this.a.c.j, this.a.a, "socket_open", this.b.getSequenceId(), this.a.c.l);
            }
        }

        public PerformConnectMutator(@NotNull MessengerConnectionHolderImpl messengerConnectionHolderImpl, String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, SessionContract.SESSION);
            this.c = messengerConnectionHolderImpl;
            this.a = str;
            this.b = z;
        }

        @NotNull
        public Single<MessengerConnectionHolder.State> apply(@NotNull MessengerConnectionHolder.State state) {
            Single<R> single;
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (state instanceof MessengerConnectionHolder.State.Disconnected) {
                single = this.c.d.open(state.getSequenceId()).map(new a(0, state));
                Intrinsics.checkNotNullExpressionValue(single, "websocket.open(oldState.…et(oldState.sequenceId) }");
            } else if (!(state instanceof MessengerConnectionHolder.State.Connecting) && !(state instanceof MessengerConnectionHolder.State.Connected)) {
                throw new NoWhenBranchMatchedException();
            } else if (this.b) {
                single = this.c.d.close(1000, "Forced reconnect").onErrorComplete().andThen(this.c.d.open(state.getSequenceId())).map(new a(1, state));
                Intrinsics.checkNotNullExpressionValue(single, "websocket.close(JSON_RPC…et(oldState.sequenceId) }");
            } else {
                single = Singles.toSingle(state);
            }
            Single<MessengerConnectionHolder.State> onErrorResumeNext = single.onErrorResumeNext(new b(this, state));
            Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "when (oldState) {\n      …          )\n            }");
            return onErrorResumeNext;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lru/avito/messenger/internal/connection/MessengerConnectionHolderImpl$StateWatchDogMutator;", "Lru/avito/messenger/internal/state_machine/StateMachine$Mutator;", "Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State;", "oldState", "Lio/reactivex/Single;", "apply", "(Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State;)Lio/reactivex/Single;", AuthSource.SEND_ABUSE, "Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State;", "trigger", "Lkotlin/Function0;", "", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function0;", "performConnect", "<init>", "(Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State;Lkotlin/jvm/functions/Function0;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @VisibleForTesting(otherwise = 3)
    public static final class StateWatchDogMutator implements StateMachine.Mutator<MessengerConnectionHolder.State> {
        public final MessengerConnectionHolder.State a;
        public final Function0<Unit> b;

        public static final class a<T> implements Consumer<MessengerConnectionHolder.State> {
            public final /* synthetic */ StateWatchDogMutator a;

            public a(StateWatchDogMutator stateWatchDogMutator) {
                this.a = stateWatchDogMutator;
            }

            @Override // io.reactivex.functions.Consumer
            public void accept(MessengerConnectionHolder.State state) {
                this.a.b.invoke();
            }
        }

        public StateWatchDogMutator(@NotNull MessengerConnectionHolder.State state, @NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(state, "trigger");
            Intrinsics.checkNotNullParameter(function0, "performConnect");
            this.a = state;
            this.b = function0;
        }

        @NotNull
        public Single<MessengerConnectionHolder.State> apply(@NotNull MessengerConnectionHolder.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (!state.isAwaitingConnection() || state != this.a) {
                return Singles.toSingle(state);
            }
            Single<MessengerConnectionHolder.State> doAfterSuccess = Singles.toSingle(state).doAfterSuccess(new a(this));
            Intrinsics.checkNotNullExpressionValue(doAfterSuccess, "oldState.toSingle()\n    …cess { performConnect() }");
            return doAfterSuccess;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lru/avito/messenger/internal/connection/MessengerConnectionHolderImpl$TransportConnectedMutator;", "Lru/avito/messenger/internal/state_machine/StateMachine$Mutator;", "Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State;", "oldState", "Lio/reactivex/Single;", "apply", "(Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State;)Lio/reactivex/Single;", "<init>", "(Lru/avito/messenger/internal/connection/MessengerConnectionHolderImpl;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @VisibleForTesting(otherwise = 3)
    public final class TransportConnectedMutator implements StateMachine.Mutator<MessengerConnectionHolder.State> {
        public TransportConnectedMutator() {
            MessengerConnectionHolderImpl.this = r1;
        }

        @NotNull
        public Single<MessengerConnectionHolder.State> apply(@NotNull MessengerConnectionHolder.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (state instanceof MessengerConnectionHolder.State.Connecting.Socket) {
                return Singles.toSingle(new MessengerConnectionHolder.State.Connecting.Session(state.getSequenceId()));
            }
            if (state instanceof MessengerConnectionHolder.State.Connecting.Session) {
                return Singles.toSingle(state);
            }
            if (state instanceof MessengerConnectionHolder.State.Disconnected) {
                if (state.isAwaitingConnection()) {
                    return Singles.toSingle(new MessengerConnectionHolder.State.Connecting.Session(state.getSequenceId()));
                }
                Single<MessengerConnectionHolder.State> singleDefault = MessengerConnectionHolderImpl.this.d.close(1000, "Closed by client").onErrorComplete().toSingleDefault(state);
                Intrinsics.checkNotNullExpressionValue(singleDefault, "websocket.close(JSON_RPC…toSingleDefault(oldState)");
                return singleDefault;
            } else if (state instanceof MessengerConnectionHolder.State.Connected) {
                return Singles.toSingle(state);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lru/avito/messenger/internal/connection/MessengerConnectionHolderImpl$TransportDisconnectedMutator;", "Lru/avito/messenger/internal/state_machine/StateMachine$Mutator;", "Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State;", "oldState", "Lio/reactivex/Single;", "apply", "(Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State;)Lio/reactivex/Single;", "Lru/avito/websocket/RxWebSocketState$Disconnected;", AuthSource.SEND_ABUSE, "Lru/avito/websocket/RxWebSocketState$Disconnected;", "socketState", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", SessionContract.SESSION, "<init>", "(Lru/avito/messenger/internal/connection/MessengerConnectionHolderImpl;Lru/avito/websocket/RxWebSocketState$Disconnected;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @VisibleForTesting(otherwise = 3)
    public final class TransportDisconnectedMutator implements StateMachine.Mutator<MessengerConnectionHolder.State> {
        public final RxWebSocketState.Disconnected a;
        public final String b;
        public final /* synthetic */ MessengerConnectionHolderImpl c;

        public TransportDisconnectedMutator(@NotNull MessengerConnectionHolderImpl messengerConnectionHolderImpl, @NotNull RxWebSocketState.Disconnected disconnected, String str) {
            Intrinsics.checkNotNullParameter(disconnected, "socketState");
            Intrinsics.checkNotNullParameter(str, SessionContract.SESSION);
            this.c = messengerConnectionHolderImpl;
            this.a = disconnected;
            this.b = str;
        }

        @NotNull
        public Single<MessengerConnectionHolder.State> apply(@NotNull MessengerConnectionHolder.State state) {
            TerminationEvent forbiddenError;
            Intrinsics.checkNotNullParameter(state, "oldState");
            if ((state instanceof MessengerConnectionHolder.State.Connecting) || (state instanceof MessengerConnectionHolder.State.Connected)) {
                RxWebSocketState.Disconnected disconnected = this.a;
                if (disconnected.getError() instanceof IOException) {
                    forbiddenError = new TerminationEvent.NetworkError(disconnected.getError());
                } else {
                    int code = disconnected.getCode();
                    String reason = disconnected.getReason();
                    Throwable error = disconnected.getError();
                    if (code != -32043) {
                        if (!(code == -32041 || code == 401)) {
                            if (code != 403) {
                                if (code == 1000) {
                                    forbiddenError = new TerminationEvent.ClosedByUser();
                                } else if (code != 3401) {
                                    if (code != 3403) {
                                        forbiddenError = new TerminationEvent.Unknown(Integer.valueOf(code), reason, error);
                                    }
                                }
                            }
                        }
                        forbiddenError = new TerminationEvent.UnauthorizedError(code, error);
                    }
                    forbiddenError = new TerminationEvent.ForbiddenError(error);
                }
                return MessengerConnectionHolderKt.handleConnectionError(forbiddenError, this.c.j, this.b, "socket_disconnect", state.getSequenceId(), this.c.l);
            } else if (state instanceof MessengerConnectionHolder.State.Disconnected) {
                return Singles.toSingle(state);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lru/avito/messenger/internal/connection/MessengerConnectionHolderImpl$UserSessionReceivedMutator;", "Lru/avito/messenger/internal/state_machine/StateMachine$Mutator;", "Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State;", "oldState", "Lio/reactivex/Single;", "apply", "(Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State;)Lio/reactivex/Single;", "Lru/avito/messenger/internal/entity/messenger/UserSession;", AuthSource.SEND_ABUSE, "Lru/avito/messenger/internal/entity/messenger/UserSession;", "newSession", "<init>", "(Lru/avito/messenger/internal/connection/MessengerConnectionHolderImpl;Lru/avito/messenger/internal/entity/messenger/UserSession;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @VisibleForTesting(otherwise = 3)
    public final class UserSessionReceivedMutator implements StateMachine.Mutator<MessengerConnectionHolder.State> {
        public final UserSession a;
        public final /* synthetic */ MessengerConnectionHolderImpl b;

        public static final class a implements Action {
            public final /* synthetic */ UserSessionReceivedMutator a;

            public a(UserSessionReceivedMutator userSessionReceivedMutator) {
                this.a = userSessionReceivedMutator;
            }

            @Override // io.reactivex.functions.Action
            public final void run() {
                Logger.DefaultImpls.v$default(this.a.b.h, "ConnectionHolder", "Config saved", null, 4, null);
            }
        }

        public static final class b<T> implements Consumer<Throwable> {
            public final /* synthetic */ UserSessionReceivedMutator a;

            public b(UserSessionReceivedMutator userSessionReceivedMutator) {
                this.a = userSessionReceivedMutator;
            }

            @Override // io.reactivex.functions.Consumer
            public void accept(Throwable th) {
                this.a.b.h.e("ConnectionHolder", "Failed to save config", th);
            }
        }

        public UserSessionReceivedMutator(@NotNull MessengerConnectionHolderImpl messengerConnectionHolderImpl, UserSession userSession) {
            Intrinsics.checkNotNullParameter(userSession, "newSession");
            this.b = messengerConnectionHolderImpl;
            this.a = userSession;
        }

        @NotNull
        public Single<MessengerConnectionHolder.State> apply(@NotNull MessengerConnectionHolder.State state) {
            Single<MessengerConnectionHolder.State> single;
            Intrinsics.checkNotNullParameter(state, "oldState");
            boolean z = state.getSequenceId() != null;
            String sequenceId = state.getSequenceId();
            if (sequenceId == null) {
                sequenceId = this.a.getSequenceId();
            }
            if (state instanceof MessengerConnectionHolder.State.Connecting.Session) {
                single = Singles.toSingle(new MessengerConnectionHolder.State.Connected(this.a, z, sequenceId));
            } else if (state instanceof MessengerConnectionHolder.State.Disconnected) {
                if (state.isAwaitingConnection()) {
                    single = Singles.toSingle(new MessengerConnectionHolder.State.Connected(this.a, z, sequenceId));
                } else {
                    single = this.b.d.close(1000, "Inconsistent state detected").onErrorComplete().toSingleDefault(state);
                    Intrinsics.checkNotNullExpressionValue(single, "websocket.close(JSON_RPC…eDefault<State>(oldState)");
                }
            } else if (state instanceof MessengerConnectionHolder.State.Connecting.Socket) {
                single = Singles.toSingle(new MessengerConnectionHolder.State.Connected(this.a, z, sequenceId));
            } else if (state instanceof MessengerConnectionHolder.State.Connected) {
                single = Singles.toSingle(((MessengerConnectionHolder.State.Connected) state).copy(this.a, z, sequenceId));
            } else {
                throw new NoWhenBranchMatchedException();
            }
            ServerConfig config = this.a.getConfig();
            MessengerConfig messengerConfig = config != null ? MessengerConfigKt.toMessengerConfig(config) : null;
            Logger logger = this.b.h;
            Logger.DefaultImpls.v$default(logger, "ConnectionHolder", "Session with config: " + messengerConfig, null, 4, null);
            if (messengerConfig == null) {
                return single;
            }
            Single<MessengerConnectionHolder.State> andThen = this.b.k.saveConfig(messengerConfig).doOnComplete(new a(this)).doOnError(new b(this)).onErrorComplete().andThen(single);
            Intrinsics.checkNotNullExpressionValue(andThen, "configStorage.saveConfig…ndThen(stateUpdateSingle)");
            return andThen;
        }
    }

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ MessengerConnectionHolderImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MessengerConnectionHolderImpl messengerConnectionHolderImpl) {
            super(0);
            this.a = messengerConnectionHolderImpl;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            MessengerConnectionHolderImpl messengerConnectionHolderImpl = this.a;
            messengerConnectionHolderImpl.c.enqueue(new PerformConnectMutator(messengerConnectionHolderImpl, "", true));
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Consumer<i> {
        public final /* synthetic */ MessengerConnectionHolderImpl a;

        public b(MessengerConnectionHolderImpl messengerConnectionHolderImpl) {
            this.a = messengerConnectionHolderImpl;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(i iVar) {
            Logger logger = this.a.h;
            Logger.DefaultImpls.v$default(logger, "ConnectionHolder", "Environment changed: " + iVar, null, 4, null);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r19v0, resolved type: ru.avito.websocket.WebsocketMessageParser<? extends ru.avito.messenger.api.entity.MessengerResponse> */
    /* JADX WARN: Multi-variable type inference failed */
    public MessengerConnectionHolderImpl(@NotNull StateMachine<MessengerConnectionHolder.State> stateMachine, @NotNull LegacyRxWebSocket legacyRxWebSocket, @NotNull T t, @NotNull WebsocketMessageParser<? extends MessengerResponse> websocketMessageParser, @NotNull ReconnectIntervalGenerator reconnectIntervalGenerator, @NotNull Logger logger, @NotNull SchedulersFactory schedulersFactory, @NotNull MessengerSessionRefresher messengerSessionRefresher, @NotNull MessengerConfigStorage messengerConfigStorage, @NotNull ErrorTracker errorTracker, @NotNull NetworkMonitor networkMonitor, @NotNull SessionProvider sessionProvider, @NotNull KeepConnectionProvider keepConnectionProvider, long j2) {
        Intrinsics.checkNotNullParameter(stateMachine, "stateMachine");
        Intrinsics.checkNotNullParameter(legacyRxWebSocket, "websocket");
        Intrinsics.checkNotNullParameter(t, "socketApi");
        Intrinsics.checkNotNullParameter(websocketMessageParser, "messageParser");
        Intrinsics.checkNotNullParameter(reconnectIntervalGenerator, "reconnectIntervalGenerator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(messengerSessionRefresher, "sessionRefresher");
        Intrinsics.checkNotNullParameter(messengerConfigStorage, "configStorage");
        Intrinsics.checkNotNullParameter(errorTracker, "errorTracker");
        Intrinsics.checkNotNullParameter(networkMonitor, "networkMonitor");
        Intrinsics.checkNotNullParameter(sessionProvider, "sessionProvider");
        Intrinsics.checkNotNullParameter(keepConnectionProvider, "keepConnectionProvider");
        this.c = stateMachine;
        this.d = legacyRxWebSocket;
        this.e = t;
        this.f = websocketMessageParser;
        this.g = reconnectIntervalGenerator;
        this.h = logger;
        this.i = schedulersFactory;
        this.j = messengerSessionRefresher;
        this.k = messengerConfigStorage;
        this.l = errorTracker;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.a = compositeDisposable;
        SharedScheduler sharedScheduler = new SharedScheduler(schedulersFactory.io());
        compositeDisposable.add(Disposables.fromAction(new Action() { // from class: ru.avito.messenger.internal.connection.MessengerConnectionHolderImpl$inlined$sam$i$io_reactivex_functions_Action$0
            @Override // io.reactivex.functions.Action
            public final /* synthetic */ void run() {
                Intrinsics.checkNotNullExpressionValue(Function0.this.invoke(), "invoke(...)");
            }
        }));
        this.b = sharedScheduler;
        stateMachine.start();
        Observable<MessengerResponse> observeOn = getMessagesStream().observeOn(this.b);
        Intrinsics.checkNotNullExpressionValue(observeOn, "messagesStream\n         …n(eventHandlingScheduler)");
        Observable<U> ofType = observeOn.ofType(SystemMessage.class);
        Intrinsics.checkExpressionValueIsNotNull(ofType, "ofType(R::class.java)");
        Disposable subscribe = ofType.subscribe(new Consumer<SystemMessage>() { // from class: ru.avito.messenger.internal.connection.MessengerConnectionHolderImpl$subscribeToSessionUpdates$1
            public final void accept(SystemMessage systemMessage) {
                if (systemMessage instanceof SystemMessage.Session) {
                    MessengerConnectionHolderImpl.this.c.enqueue(new MessengerConnectionHolderImpl.UserSessionReceivedMutator(MessengerConnectionHolderImpl.this, ((SystemMessage.Session) systemMessage).getValue()));
                    return;
                }
                String str = systemMessage.sequenceId;
                if (str != null) {
                    MessengerConnectionHolderImpl.this.c.enqueue(new MessengerConnectionHolderImpl.NewSequenceIdMutator(MessengerConnectionHolderImpl.this, str));
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "messagesStream\n         …          }\n            }");
        DisposableKt.addTo(subscribe, this.a);
        Disposable subscribe2 = getStateObservable().observeOn(this.i.computation()).distinctUntilChanged().switchMapMaybe(new MessengerConnectionHolderImpl$sendManualPingsWhenConnected$1(this, j2)).subscribe(new Consumer() { // from class: ru.avito.messenger.internal.connection.MessengerConnectionHolderKt$sam$i$io_reactivex_functions_Consumer$0
            @Override // io.reactivex.functions.Consumer
            public final /* synthetic */ void accept(Object obj) {
                Intrinsics.checkNotNullExpressionValue(Function1.this.invoke(obj), "invoke(...)");
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe2, "stateObservable\n        …be(stateMachine::enqueue)");
        DisposableKt.addTo(subscribe2, this.a);
        Observable combineLatest = Observable.combineLatest(networkMonitor.networkAvailability(), sessionProvider.getSessionObservable(), keepConnectionProvider.getShouldKeepConnection(), new Function3<T1, T2, T3, R>() { // from class: ru.avito.messenger.internal.connection.MessengerConnectionHolderImpl$$special$$inlined$combineLatestWith$1
            @Override // io.reactivex.functions.Function3
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2, @NotNull T3 t3) {
                Intrinsics.checkNotNullParameter(t1, "t1");
                Intrinsics.checkNotNullParameter(t2, "t2");
                Intrinsics.checkNotNullParameter(t3, "t3");
                boolean booleanValue = t3.booleanValue();
                return (R) new i(t1.booleanValue(), t2, booleanValue);
            }
        });
        Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…neFunction(t1, t2, t3) })");
        ConnectableObservable publish = combineLatest.observeOn(sharedScheduler).distinctUntilChanged().doOnNext(new b(this)).publish();
        Intrinsics.checkNotNullExpressionValue(publish, "sharedNetworkAndSessionStream");
        Observable<RxWebSocketState> distinctUntilChanged = this.d.getStateObservable().observeOn(this.b).skip(1).distinctUntilChanged(MessengerConnectionHolderImpl$subscribeToSocketStateChanges$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "websocket.stateObservabl…> socketState.javaClass }");
        Observable combineLatest2 = Observable.combineLatest(distinctUntilChanged, publish, new BiFunction<T1, T2, R>() { // from class: ru.avito.messenger.internal.connection.MessengerConnectionHolderImpl$subscribeToSocketStateChanges$$inlined$combineLatestWith$2
            @Override // io.reactivex.functions.BiFunction
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2) {
                Intrinsics.checkNotNullParameter(t1, "t1");
                Intrinsics.checkNotNullParameter(t2, "t2");
                return (R) TuplesKt.to(t1, t2.b);
            }
        });
        Intrinsics.checkNotNullExpressionValue(combineLatest2, "Observable.combineLatest…ombineFunction(t1, t2) })");
        Disposable subscribe3 = combineLatest2.subscribe(new Consumer<Pair<? extends RxWebSocketState, ? extends String>>() { // from class: ru.avito.messenger.internal.connection.MessengerConnectionHolderImpl$subscribeToSocketStateChanges$3
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public /* bridge */ /* synthetic */ void accept(Pair<? extends RxWebSocketState, ? extends String> pair) {
                accept((Pair<? extends RxWebSocketState, String>) pair);
            }

            public final void accept(Pair<? extends RxWebSocketState, String> pair) {
                RxWebSocketState rxWebSocketState = (RxWebSocketState) pair.component1();
                String component2 = pair.component2();
                if (rxWebSocketState instanceof RxWebSocketState.Connected) {
                    MessengerConnectionHolderImpl.this.c.enqueue(new MessengerConnectionHolderImpl.TransportConnectedMutator());
                } else if (rxWebSocketState instanceof RxWebSocketState.Disconnected) {
                    MessengerConnectionHolderImpl.this.c.enqueue(new MessengerConnectionHolderImpl.TransportDisconnectedMutator(MessengerConnectionHolderImpl.this, (RxWebSocketState.Disconnected) rxWebSocketState, component2));
                } else {
                    boolean z = rxWebSocketState instanceof RxWebSocketState.Connecting;
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe3, "websocket.stateObservabl…          }\n            }");
        DisposableKt.addTo(subscribe3, this.a);
        Disposable subscribe4 = publish.switchMap(new MessengerConnectionHolderImpl$subscribeNetworkAndSessionChanges$1(this)).subscribe(new Consumer() { // from class: ru.avito.messenger.internal.connection.MessengerConnectionHolderKt$sam$i$io_reactivex_functions_Consumer$0
            @Override // io.reactivex.functions.Consumer
            public final /* synthetic */ void accept(Object obj) {
                Intrinsics.checkNotNullExpressionValue(Function1.this.invoke(obj), "invoke(...)");
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe4, "networkAndSessionStream.…be(stateMachine::enqueue)");
        DisposableKt.addTo(subscribe4, this.a);
        Disposable subscribe5 = publish.switchMap(new MessengerConnectionHolderImpl$monitorStateFreeze$1(this)).subscribe(new Consumer() { // from class: ru.avito.messenger.internal.connection.MessengerConnectionHolderKt$sam$i$io_reactivex_functions_Consumer$0
            @Override // io.reactivex.functions.Consumer
            public final /* synthetic */ void accept(Object obj) {
                Intrinsics.checkNotNullExpressionValue(Function1.this.invoke(obj), "invoke(...)");
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe5, "networkAndSessionStream.…be(stateMachine::enqueue)");
        DisposableKt.addTo(subscribe5, this.a);
        Disposable connect = publish.connect();
        Intrinsics.checkNotNullExpressionValue(connect, "sharedNetworkAndSessionStream.connect()");
        DisposableKt.addTo(connect, compositeDisposable);
    }

    public static final Observable access$reconnectSequence(MessengerConnectionHolderImpl messengerConnectionHolderImpl, String str) {
        Observable<R> doOnNext = messengerConnectionHolderImpl.getStateObservable().observeOn(messengerConnectionHolderImpl.i.computation()).skip(1).filter(a7.a.b.a.m.a.a).distinctUntilChanged(a7.a.b.a.m.b.a).switchMap(new a7.a.b.a.m.g(messengerConnectionHolderImpl, str)).doOnNext(new h(messengerConnectionHolderImpl));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "stateObservable\n        … \"Reconnect triggered\") }");
        return doOnNext;
    }

    public static final void access$startConnecting(MessengerConnectionHolderImpl messengerConnectionHolderImpl, boolean z, String str) {
        Objects.requireNonNull(messengerConnectionHolderImpl);
        messengerConnectionHolderImpl.c.enqueue(new PerformConnectMutator(messengerConnectionHolderImpl, str, z));
    }

    @Override // ru.avito.messenger.internal.connection.MessengerConnectionHolder
    public void connect() {
        Logger.DefaultImpls.d$default(this.h, "ConnectionHolder", "Connect!", null, 4, null);
        this.c.enqueue(new ConnectMutator(true, new a(this)));
    }

    @Override // ru.avito.messenger.internal.connection.MessengerConnectionHolder
    public void disconnect() {
        Logger.DefaultImpls.d$default(this.h, "ConnectionHolder", "Disconnect!", null, 4, null);
        this.c.enqueue(new DisconnectMutator(false));
    }

    @Override // ru.avito.messenger.internal.connection.MessengerConnectionHolder
    @NotNull
    public T getApi() {
        return this.e;
    }

    @Override // ru.avito.messenger.internal.connection.MessengerConnectionHolder
    @NotNull
    public Observable<MessengerResponse> getMessagesStream() {
        Observable<MessengerResponse> share = this.d.messages(this.f).share();
        Intrinsics.checkNotNullExpressionValue(share, "websocket.messages(messageParser).share()");
        return share;
    }

    @Override // ru.avito.messenger.internal.connection.MessengerConnectionHolder
    @NotNull
    public Observable<MessengerConnectionHolder.State> getStateObservable() {
        return this.c.getStateObservable();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessengerConnectionHolderImpl(StateMachine stateMachine, LegacyRxWebSocket legacyRxWebSocket, MessengerApi messengerApi, WebsocketMessageParser websocketMessageParser, ReconnectIntervalGenerator reconnectIntervalGenerator, Logger logger, SchedulersFactory schedulersFactory, MessengerSessionRefresher messengerSessionRefresher, MessengerConfigStorage messengerConfigStorage, ErrorTracker errorTracker, NetworkMonitor networkMonitor, SessionProvider sessionProvider, KeepConnectionProvider keepConnectionProvider, long j2, int i2, j jVar) {
        this(stateMachine, legacyRxWebSocket, messengerApi, websocketMessageParser, reconnectIntervalGenerator, logger, schedulersFactory, messengerSessionRefresher, messengerConfigStorage, errorTracker, networkMonitor, sessionProvider, keepConnectionProvider, (i2 & 8192) != 0 ? TimeUnit.SECONDS.toMillis(15) : j2);
    }
}
