package ru.avito.messenger.internal.di;

import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.remote.model.Navigation;
import com.avito.android.util.SchedulersFactory;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import hu.akarnokd.rxjava2.schedulers.SharedScheduler;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.RandomKt;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerApi;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.ReconnectIntervalGenerator;
import ru.avito.messenger.ReconnectPolicy;
import ru.avito.messenger.api.entity.MessengerResponse;
import ru.avito.messenger.config.MessengerConfigStorage;
import ru.avito.messenger.internal.Config;
import ru.avito.messenger.internal.MessengerClientImpl;
import ru.avito.messenger.internal.connection.MessengerConnectionHolder;
import ru.avito.messenger.internal.connection.MessengerConnectionHolderImpl;
import ru.avito.messenger.internal.log.Logger;
import ru.avito.messenger.internal.reconnect.BackoffReconnectIntervalGenerator;
import ru.avito.messenger.internal.reconnect.FixedReconnectIntervalGenerator;
import ru.avito.messenger.internal.state_machine.SequentialStateMachine;
import ru.avito.websocket.LegacyRxWebSocket;
import ru.avito.websocket.WebsocketMessageParser;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b!\u0010\"JI\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJh\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u0011\u0010\u0016\u001a\r\u0012\t\u0012\u00070\u0014¢\u0006\u0002\b\u00150\u00132\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lru/avito/messenger/internal/di/MessengerClientModule;", "", "Lru/avito/messenger/MessengerApi;", "fallbackApi", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lru/avito/messenger/internal/Config;", Navigation.CONFIG, "Ldagger/Lazy;", "Lru/avito/messenger/internal/connection/MessengerConnectionHolder;", "connectionHolder", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "errorTracker", "Lru/avito/messenger/MessengerClient;", "provideMessengerClient", "(Lru/avito/messenger/MessengerApi;Lcom/avito/android/util/SchedulersFactory;Lru/avito/messenger/internal/Config;Ldagger/Lazy;Lcom/avito/android/communications_common/analytics/ErrorTracker;)Lru/avito/messenger/MessengerClient;", "Lru/avito/websocket/LegacyRxWebSocket;", "websocket", "api", "Lru/avito/websocket/WebsocketMessageParser;", "Lru/avito/messenger/api/entity/MessengerResponse;", "Lkotlin/jvm/JvmSuppressWildcards;", "messageParser", "Lru/avito/messenger/ReconnectIntervalGenerator;", "reconnectIntervalGenerator", "Lru/avito/messenger/config/MessengerConfigStorage;", "configStorage", "Lru/avito/messenger/internal/log/Logger;", "logger", "provideConnectionHolder", "(Lru/avito/websocket/LegacyRxWebSocket;Lru/avito/messenger/MessengerApi;Lru/avito/websocket/WebsocketMessageParser;Lru/avito/messenger/ReconnectIntervalGenerator;Lru/avito/messenger/internal/Config;Lru/avito/messenger/config/MessengerConfigStorage;Lcom/avito/android/util/SchedulersFactory;Lru/avito/messenger/internal/log/Logger;Lcom/avito/android/communications_common/analytics/ErrorTracker;)Lru/avito/messenger/internal/connection/MessengerConnectionHolder;", "provideReconnectIntervalGenerator", "(Lru/avito/messenger/internal/Config;)Lru/avito/messenger/ReconnectIntervalGenerator;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {WebSocketMessengerTransportModule.class, HttpMessengerTransportModule.class, ImageUploadModule.class, LoggerModule.class, MessengerConfigModule.class})
public final class MessengerClientModule {
    @NotNull
    public static final MessengerClientModule INSTANCE = new MessengerClientModule();

    @Provides
    @JvmStatic
    @PerMessenger
    @NotNull
    public static final MessengerConnectionHolder<MessengerApi> provideConnectionHolder(@NotNull LegacyRxWebSocket legacyRxWebSocket, @NotNull MessengerApi messengerApi, @NotNull WebsocketMessageParser<MessengerResponse> websocketMessageParser, @NotNull ReconnectIntervalGenerator reconnectIntervalGenerator, @NotNull Config config, @NotNull MessengerConfigStorage messengerConfigStorage, @NotNull SchedulersFactory schedulersFactory, @NotNull Logger logger, @NotNull ErrorTracker errorTracker) {
        Intrinsics.checkNotNullParameter(legacyRxWebSocket, "websocket");
        Intrinsics.checkNotNullParameter(messengerApi, "api");
        Intrinsics.checkNotNullParameter(websocketMessageParser, "messageParser");
        Intrinsics.checkNotNullParameter(reconnectIntervalGenerator, "reconnectIntervalGenerator");
        Intrinsics.checkNotNullParameter(config, Navigation.CONFIG);
        Intrinsics.checkNotNullParameter(messengerConfigStorage, "configStorage");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(errorTracker, "errorTracker");
        return new MessengerConnectionHolderImpl(new SequentialStateMachine(new MessengerConnectionHolder.State.Disconnected(true, null, null, 6, null), logger, new SharedScheduler(schedulersFactory.io()), "MsgConnectionHolder"), legacyRxWebSocket, messengerApi, websocketMessageParser, reconnectIntervalGenerator, logger, schedulersFactory, config.getSessionRefresher(), messengerConfigStorage, errorTracker, config.getNetworkMonitor(), config.getSessionProvider(), config.getKeepConnectionProvider(), 0, 8192, null);
    }

    @Provides
    @JvmStatic
    @PerMessenger
    @NotNull
    public static final MessengerClient<MessengerApi> provideMessengerClient(@NotNull MessengerApi messengerApi, @NotNull SchedulersFactory schedulersFactory, @NotNull Config config, @NotNull Lazy<MessengerConnectionHolder<MessengerApi>> lazy, @NotNull ErrorTracker errorTracker) {
        Intrinsics.checkNotNullParameter(messengerApi, "fallbackApi");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(config, Navigation.CONFIG);
        Intrinsics.checkNotNullParameter(lazy, "connectionHolder");
        Intrinsics.checkNotNullParameter(errorTracker, "errorTracker");
        return new MessengerClientImpl(lazy, config.getNetworkMonitor(), messengerApi, schedulersFactory, config.getCommandTimeout(), errorTracker);
    }

    @Provides
    @JvmStatic
    @PerMessenger
    @NotNull
    public static final ReconnectIntervalGenerator provideReconnectIntervalGenerator(@NotNull Config config) {
        Intrinsics.checkNotNullParameter(config, Navigation.CONFIG);
        ReconnectPolicy reconnectPolicy = config.getReconnectPolicy();
        if (reconnectPolicy instanceof ReconnectPolicy.Backoff) {
            return new BackoffReconnectIntervalGenerator(RandomKt.Random(System.currentTimeMillis()), ((ReconnectPolicy.Backoff) config.getReconnectPolicy()).getJitter(), ((ReconnectPolicy.Backoff) config.getReconnectPolicy()).getIntervalsInSeconds());
        }
        if (reconnectPolicy instanceof ReconnectPolicy.Fixed) {
            return new FixedReconnectIntervalGenerator(((ReconnectPolicy.Fixed) config.getReconnectPolicy()).getDelayInSeconds());
        }
        throw new NoWhenBranchMatchedException();
    }
}
