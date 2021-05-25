package ru.avito.messenger.internal.di;

import androidx.core.app.NotificationCompat;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.jsonrpc.client.JsonRpcClient;
import com.avito.android.jsonrpc.client.JsonRpcServiceBuilder;
import com.avito.android.remote.model.Navigation;
import com.avito.android.util.SchedulersFactory;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerApi;
import ru.avito.messenger.MessengerApiWrapper;
import ru.avito.messenger.RequestIdGenerator;
import ru.avito.messenger.RequestIdHolder;
import ru.avito.messenger.RequestIdHolderImpl;
import ru.avito.messenger.api.entity.MessengerResponse;
import ru.avito.messenger.internal.Config;
import ru.avito.messenger.internal.ConstantsKt;
import ru.avito.messenger.internal.MessengerRequestProvider;
import ru.avito.messenger.internal.MessengerWebsocketMessageParser;
import ru.avito.messenger.internal.gson.GsonDeserializer;
import ru.avito.messenger.internal.jsonrpc.JsonRpcCallAnalyticsInterceptor;
import ru.avito.messenger.internal.jsonrpc.WebSocketJsonRpcClient;
import ru.avito.messenger.internal.log.Logger;
import ru.avito.websocket.LegacyRxWebSocket;
import ru.avito.websocket.LegacyRxWebSocketImpl;
import ru.avito.websocket.OkHttpWebSocketFactory;
import ru.avito.websocket.RequestProvider;
import ru.avito.websocket.RxWebSocket;
import ru.avito.websocket.RxWebSocketImpl;
import ru.avito.websocket.RxWebSocketToLegacyAdapter;
import ru.avito.websocket.WebSocketFactory;
import ru.avito.websocket.WebsocketMessageParser;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001:\u0003678B\u0007¢\u0006\u0004\b4\u00105J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ%\u0010\u0010\u001a\u00020\u000f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000e\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0016\u0010\u0017JX\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010\u0018\u001a\u00020\u00152\u0011\u0010\u001c\u001a\r\u0012\t\u0012\u00070\u001a¢\u0006\u0002\b\u001b0\u00192\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\b#\u0010$J%\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\b%\u0010&JG\u0010.\u001a\u00020*2\u000e\b\u0001\u0010\r\u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010(\u001a\u00020'2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010+\u001a\n\u0012\u0006\b\u0001\u0012\u00020*0)2\u0006\u0010-\u001a\u00020,H\u0007¢\u0006\u0004\b.\u0010/J\u000f\u00103\u001a\u000200H\u0001¢\u0006\u0004\b1\u00102¨\u00069"}, d2 = {"Lru/avito/messenger/internal/di/WebSocketMessengerTransportModule;", "", "Lru/avito/messenger/internal/Config;", Navigation.CONFIG, "Lru/avito/messenger/internal/log/Logger;", "logger", "Lru/avito/messenger/RequestIdGenerator;", "requestIdGenerator", "Lru/avito/websocket/RequestProvider;", "provideRequestBuilder", "(Lru/avito/messenger/internal/Config;Lru/avito/messenger/internal/log/Logger;Lru/avito/messenger/RequestIdGenerator;)Lru/avito/websocket/RequestProvider;", "Ldagger/Lazy;", "Lokhttp3/OkHttpClient;", "client", "requestProvider", "Lru/avito/websocket/WebSocketFactory;", "provideWebSocketFactory", "(Ldagger/Lazy;Lru/avito/websocket/RequestProvider;)Lru/avito/websocket/WebSocketFactory;", "webSocketFactory", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lru/avito/websocket/LegacyRxWebSocket;", "provideRxWebSocket", "(Lru/avito/websocket/WebSocketFactory;Lru/avito/messenger/internal/log/Logger;Lru/avito/messenger/internal/Config;Lcom/avito/android/util/SchedulersFactory;)Lru/avito/websocket/LegacyRxWebSocket;", "webSocket", "Lru/avito/websocket/WebsocketMessageParser;", "Lru/avito/messenger/api/entity/MessengerResponse;", "Lkotlin/jvm/JvmSuppressWildcards;", "messageParser", "Lcom/google/gson/Gson;", "gson", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "errorTracker", "Lcom/avito/android/jsonrpc/client/JsonRpcClient;", "Lcom/google/gson/JsonElement;", "provideWebSocketJsonRpcClient", "(Lru/avito/websocket/LegacyRxWebSocket;Lru/avito/websocket/WebsocketMessageParser;Lcom/google/gson/Gson;Lru/avito/messenger/internal/Config;Lru/avito/messenger/internal/log/Logger;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/communications_common/analytics/ErrorTracker;)Lcom/avito/android/jsonrpc/client/JsonRpcClient;", "provideWebsocketMessageParser", "(Lcom/google/gson/Gson;Lcom/avito/android/communications_common/analytics/ErrorTracker;)Lru/avito/websocket/WebsocketMessageParser;", "Lru/avito/messenger/internal/gson/GsonDeserializer;", "gsonDeserializer", "Ljava/lang/Class;", "Lru/avito/messenger/MessengerApi;", NotificationCompat.CATEGORY_SERVICE, "Lru/avito/messenger/internal/jsonrpc/JsonRpcCallAnalyticsInterceptor;", "jsonRpcCallAnalyticsInterceptor", "provideWebSocketTransportApi", "(Lcom/avito/android/jsonrpc/client/JsonRpcClient;Lru/avito/messenger/internal/gson/GsonDeserializer;Lru/avito/messenger/internal/log/Logger;Ljava/lang/Class;Lru/avito/messenger/internal/jsonrpc/JsonRpcCallAnalyticsInterceptor;)Lru/avito/messenger/MessengerApi;", "Lru/avito/messenger/RequestIdHolderImpl;", "provideRequestIdHolderProvider$messenger_release", "()Lru/avito/messenger/RequestIdHolderImpl;", "provideRequestIdHolderProvider", "<init>", "()V", "Declarations", "WebSocketClient", "WebSocketTransportApi", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {GsonModule.class, OkHttpModule.class, ConfigModule.class, LoggerModule.class, ServiceModule.class, SchedulersModule.class, ErrorTrackerModule.class, InterceptorsModule.class, Declarations.class})
public final class WebSocketMessengerTransportModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/avito/messenger/internal/di/WebSocketMessengerTransportModule$Declarations;", "", "Lru/avito/messenger/RequestIdHolderImpl;", "impl", "Lru/avito/messenger/RequestIdHolder;", "bindRequestIdHolder", "(Lru/avito/messenger/RequestIdHolderImpl;)Lru/avito/messenger/RequestIdHolder;", "Lru/avito/messenger/RequestIdGenerator;", "bindRequestIdGenerator", "(Lru/avito/messenger/RequestIdHolderImpl;)Lru/avito/messenger/RequestIdGenerator;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerMessenger
        @Binds
        @NotNull
        RequestIdGenerator bindRequestIdGenerator(@NotNull RequestIdHolderImpl requestIdHolderImpl);

        @PerMessenger
        @Binds
        @NotNull
        RequestIdHolder bindRequestIdHolder(@NotNull RequestIdHolderImpl requestIdHolderImpl);
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/avito/messenger/internal/di/WebSocketMessengerTransportModule$WebSocketClient;", "", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface WebSocketClient {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/avito/messenger/internal/di/WebSocketMessengerTransportModule$WebSocketTransportApi;", "", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface WebSocketTransportApi {
    }

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function2<String, Throwable, Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(2);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(String str, Throwable th) {
            int i = this.a;
            if (i == 0) {
                String str2 = str;
                Throwable th2 = th;
                Intrinsics.checkNotNullParameter(str2, "message");
                Intrinsics.checkNotNullParameter(th2, "throwable");
                ((Logger) this.b).e(ConstantsKt.LOG_TAG, str2, th2);
                return Unit.INSTANCE;
            } else if (i == 1) {
                String str3 = str;
                Throwable th3 = th;
                Intrinsics.checkNotNullParameter(str3, "message");
                Intrinsics.checkNotNullParameter(th3, "throwable");
                ((Logger) this.b).e(ConstantsKt.LOG_TAG, str3, th3);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class b extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(int i, Object obj) {
            super(1);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(String str) {
            int i = this.a;
            if (i == 0) {
                String str2 = str;
                Intrinsics.checkNotNullParameter(str2, "it");
                Logger.DefaultImpls.d$default((Logger) this.b, ConstantsKt.LOG_TAG, str2, null, 4, null);
                return Unit.INSTANCE;
            } else if (i == 1) {
                String str3 = str;
                Intrinsics.checkNotNullParameter(str3, "it");
                Logger.DefaultImpls.d$default((Logger) this.b, ConstantsKt.LOG_TAG, str3, null, 4, null);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class c extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ Logger a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Logger logger) {
            super(1);
            this.a = logger;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "it");
            Logger.DefaultImpls.d$default(this.a, ConstantsKt.LOG_TAG, str2, null, 4, null);
            return Unit.INSTANCE;
        }
    }

    @Provides
    @PerMessenger
    @NotNull
    public final RequestProvider provideRequestBuilder(@NotNull Config config, @NotNull Logger logger, @NotNull RequestIdGenerator requestIdGenerator) {
        Intrinsics.checkNotNullParameter(config, Navigation.CONFIG);
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(requestIdGenerator, "requestIdGenerator");
        return new MessengerRequestProvider(config.getSessionProvider(), config.getEndpointProvider(), requestIdGenerator, config.getOrigin(), config.getHandshakeHeaders(), config.getConnectionParams(), logger);
    }

    @Provides
    @PerMessenger
    @NotNull
    public final RequestIdHolderImpl provideRequestIdHolderProvider$messenger_release() {
        return new RequestIdHolderImpl();
    }

    @Provides
    @PerMessenger
    @NotNull
    public final LegacyRxWebSocket provideRxWebSocket(@NotNull WebSocketFactory webSocketFactory, @NotNull Logger logger, @NotNull Config config, @NotNull SchedulersFactory schedulersFactory) {
        LegacyRxWebSocket wrap;
        RxWebSocket wrap2;
        Intrinsics.checkNotNullParameter(webSocketFactory, "webSocketFactory");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(config, Navigation.CONFIG);
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        if (config.getUseNewWebsocket()) {
            RxWebSocket rxWebSocketImpl = new RxWebSocketImpl(webSocketFactory, new b(0, logger), config.getWebSocketReporter(), new a(0, logger), schedulersFactory.io());
            MessengerApiWrapper apiWrapper = config.getApiWrapper();
            if (!(apiWrapper == null || (wrap2 = apiWrapper.wrap(rxWebSocketImpl)) == null)) {
                rxWebSocketImpl = wrap2;
            }
            return new RxWebSocketToLegacyAdapter(rxWebSocketImpl);
        }
        LegacyRxWebSocketImpl legacyRxWebSocketImpl = new LegacyRxWebSocketImpl(webSocketFactory, new b(1, logger), config.getWebSocketReporter(), new a(1, logger));
        MessengerApiWrapper apiWrapper2 = config.getApiWrapper();
        return (apiWrapper2 == null || (wrap = apiWrapper2.wrap(legacyRxWebSocketImpl)) == null) ? legacyRxWebSocketImpl : wrap;
    }

    @Provides
    @PerMessenger
    @NotNull
    public final WebSocketFactory provideWebSocketFactory(@NotNull Lazy<OkHttpClient> lazy, @NotNull RequestProvider requestProvider) {
        Intrinsics.checkNotNullParameter(lazy, "client");
        Intrinsics.checkNotNullParameter(requestProvider, "requestProvider");
        return new OkHttpWebSocketFactory(lazy, requestProvider);
    }

    @Provides
    @PerMessenger
    @WebSocketClient
    @NotNull
    public final JsonRpcClient<JsonElement> provideWebSocketJsonRpcClient(@NotNull LegacyRxWebSocket legacyRxWebSocket, @NotNull WebsocketMessageParser<MessengerResponse> websocketMessageParser, @NotNull Gson gson, @NotNull Config config, @NotNull Logger logger, @NotNull SchedulersFactory schedulersFactory, @NotNull ErrorTracker errorTracker) {
        JsonRpcClient<JsonElement> wrapWebsocket;
        Intrinsics.checkNotNullParameter(legacyRxWebSocket, "webSocket");
        Intrinsics.checkNotNullParameter(websocketMessageParser, "messageParser");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(config, Navigation.CONFIG);
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(errorTracker, "errorTracker");
        WebSocketJsonRpcClient webSocketJsonRpcClient = new WebSocketJsonRpcClient(legacyRxWebSocket, websocketMessageParser, gson, config.getJsonRpcTimeout(), logger, schedulersFactory, errorTracker);
        MessengerApiWrapper apiWrapper = config.getApiWrapper();
        return (apiWrapper == null || (wrapWebsocket = apiWrapper.wrapWebsocket(webSocketJsonRpcClient)) == null) ? webSocketJsonRpcClient : wrapWebsocket;
    }

    @Provides
    @PerMessenger
    @NotNull
    public final MessengerApi provideWebSocketTransportApi(@WebSocketClient @NotNull JsonRpcClient<JsonElement> jsonRpcClient, @NotNull GsonDeserializer gsonDeserializer, @NotNull Logger logger, @NotNull Class<? extends MessengerApi> cls, @NotNull JsonRpcCallAnalyticsInterceptor jsonRpcCallAnalyticsInterceptor) {
        Intrinsics.checkNotNullParameter(jsonRpcClient, "client");
        Intrinsics.checkNotNullParameter(gsonDeserializer, "gsonDeserializer");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(cls, NotificationCompat.CATEGORY_SERVICE);
        Intrinsics.checkNotNullParameter(jsonRpcCallAnalyticsInterceptor, "jsonRpcCallAnalyticsInterceptor");
        return (MessengerApi) new JsonRpcServiceBuilder(cls, jsonRpcClient, gsonDeserializer, new c(logger)).addInterceptor(jsonRpcCallAnalyticsInterceptor).build();
    }

    @Provides
    @PerMessenger
    @NotNull
    public final WebsocketMessageParser<MessengerResponse> provideWebsocketMessageParser(@NotNull Gson gson, @NotNull ErrorTracker errorTracker) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(errorTracker, "errorTracker");
        return new MessengerWebsocketMessageParser(gson, errorTracker);
    }
}
