package ru.avito.messenger.internal.di;

import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.jsonrpc.client.JsonRpcClient;
import com.avito.android.util.SchedulersFactory;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import ru.avito.messenger.MessengerApi;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.MessengerImageUploadApi;
import ru.avito.messenger.MessengerImpl;
import ru.avito.messenger.ReconnectIntervalGenerator;
import ru.avito.messenger.RequestIdHolderImpl;
import ru.avito.messenger.api.entity.MessengerResponse;
import ru.avito.messenger.config.MessengerConfigProvider;
import ru.avito.messenger.config.MessengerConfigStorage;
import ru.avito.messenger.internal.Config;
import ru.avito.messenger.internal.connection.MessengerConnectionHolder;
import ru.avito.messenger.internal.gson.GsonDeserializer;
import ru.avito.messenger.internal.jsonrpc.HttpApi;
import ru.avito.messenger.internal.jsonrpc.JsonRpcCallAnalyticsInterceptor;
import ru.avito.messenger.internal.log.Logger;
import ru.avito.websocket.LegacyRxWebSocket;
import ru.avito.websocket.RequestProvider;
import ru.avito.websocket.WebSocketFactory;
import ru.avito.websocket.WebsocketMessageParser;
public final class DaggerMessengerComponent implements MessengerComponent {
    public Provider<Class<? extends MessengerApi>> a;
    public Provider<Config> b;
    public Provider<OkHttpClient> c;
    public Provider<Logger> d;
    public Provider<Gson> e;
    public Provider<HttpApi> f;
    public Provider<SchedulersFactory> g;
    public Provider<ErrorTracker> h;
    public Provider<JsonRpcClient<JsonElement>> i;
    public Provider<GsonDeserializer> j;
    public Provider<MessengerApi> k;
    public Provider<RequestIdHolderImpl> l;
    public Provider<RequestProvider> m;
    public Provider<WebSocketFactory> n;
    public Provider<LegacyRxWebSocket> o;
    public Provider<WebsocketMessageParser<MessengerResponse>> p;
    public Provider<JsonRpcClient<JsonElement>> q;
    public Provider<JsonRpcCallAnalyticsInterceptor> r;
    public Provider<MessengerApi> s;
    public Provider<ReconnectIntervalGenerator> t = DoubleCheck.provider(MessengerClientModule_ProvideReconnectIntervalGeneratorFactory.create(this.b));
    public Provider<MessengerConfigStorage> u;
    public Provider<MessengerConnectionHolder<MessengerApi>> v;
    public Provider<MessengerClient<MessengerApi>> w;
    public Provider<OkHttpClient> x;
    public Provider<MessengerImageUploadApi> y;
    public Provider<MessengerConfigProvider> z;

    public static final class Builder {
        public WebSocketMessengerTransportModule a;
        public GsonModule b;
        public OkHttpModule c;
        public ConfigModule d;
        public LoggerModule e;
        public ServiceModule f;
        public SchedulersModule g;
        public ErrorTrackerModule h;
        public InterceptorsModule i;
        public HttpMessengerTransportModule j;
        public ImageUploadModule k;
        public MessengerConfigModule l;

        public Builder() {
        }

        public MessengerComponent build() {
            if (this.a == null) {
                this.a = new WebSocketMessengerTransportModule();
            }
            Preconditions.checkBuilderRequirement(this.b, GsonModule.class);
            Preconditions.checkBuilderRequirement(this.c, OkHttpModule.class);
            Preconditions.checkBuilderRequirement(this.d, ConfigModule.class);
            Preconditions.checkBuilderRequirement(this.e, LoggerModule.class);
            Preconditions.checkBuilderRequirement(this.f, ServiceModule.class);
            if (this.g == null) {
                this.g = new SchedulersModule();
            }
            Preconditions.checkBuilderRequirement(this.h, ErrorTrackerModule.class);
            if (this.i == null) {
                this.i = new InterceptorsModule();
            }
            if (this.j == null) {
                this.j = new HttpMessengerTransportModule();
            }
            Preconditions.checkBuilderRequirement(this.k, ImageUploadModule.class);
            if (this.l == null) {
                this.l = new MessengerConfigModule();
            }
            return new DaggerMessengerComponent(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, null);
        }

        public Builder configModule(ConfigModule configModule) {
            this.d = (ConfigModule) Preconditions.checkNotNull(configModule);
            return this;
        }

        public Builder errorTrackerModule(ErrorTrackerModule errorTrackerModule) {
            this.h = (ErrorTrackerModule) Preconditions.checkNotNull(errorTrackerModule);
            return this;
        }

        public Builder gsonModule(GsonModule gsonModule) {
            this.b = (GsonModule) Preconditions.checkNotNull(gsonModule);
            return this;
        }

        public Builder httpMessengerTransportModule(HttpMessengerTransportModule httpMessengerTransportModule) {
            this.j = (HttpMessengerTransportModule) Preconditions.checkNotNull(httpMessengerTransportModule);
            return this;
        }

        public Builder imageUploadModule(ImageUploadModule imageUploadModule) {
            this.k = (ImageUploadModule) Preconditions.checkNotNull(imageUploadModule);
            return this;
        }

        public Builder interceptorsModule(InterceptorsModule interceptorsModule) {
            this.i = (InterceptorsModule) Preconditions.checkNotNull(interceptorsModule);
            return this;
        }

        public Builder loggerModule(LoggerModule loggerModule) {
            this.e = (LoggerModule) Preconditions.checkNotNull(loggerModule);
            return this;
        }

        @Deprecated
        public Builder messengerClientModule(MessengerClientModule messengerClientModule) {
            Preconditions.checkNotNull(messengerClientModule);
            return this;
        }

        public Builder messengerConfigModule(MessengerConfigModule messengerConfigModule) {
            this.l = (MessengerConfigModule) Preconditions.checkNotNull(messengerConfigModule);
            return this;
        }

        public Builder okHttpModule(OkHttpModule okHttpModule) {
            this.c = (OkHttpModule) Preconditions.checkNotNull(okHttpModule);
            return this;
        }

        public Builder schedulersModule(SchedulersModule schedulersModule) {
            this.g = (SchedulersModule) Preconditions.checkNotNull(schedulersModule);
            return this;
        }

        public Builder serviceModule(ServiceModule serviceModule) {
            this.f = (ServiceModule) Preconditions.checkNotNull(serviceModule);
            return this;
        }

        public Builder webSocketMessengerTransportModule(WebSocketMessengerTransportModule webSocketMessengerTransportModule) {
            this.a = (WebSocketMessengerTransportModule) Preconditions.checkNotNull(webSocketMessengerTransportModule);
            return this;
        }

        public Builder(a aVar) {
        }
    }

    public DaggerMessengerComponent(WebSocketMessengerTransportModule webSocketMessengerTransportModule, GsonModule gsonModule, OkHttpModule okHttpModule, ConfigModule configModule, LoggerModule loggerModule, ServiceModule serviceModule, SchedulersModule schedulersModule, ErrorTrackerModule errorTrackerModule, InterceptorsModule interceptorsModule, HttpMessengerTransportModule httpMessengerTransportModule, ImageUploadModule imageUploadModule, MessengerConfigModule messengerConfigModule, a aVar) {
        this.a = DoubleCheck.provider(ServiceModule_ProvideServiceFactory.create(serviceModule));
        Provider<Config> provider = DoubleCheck.provider(ConfigModule_ProvideConfigFactory.create(configModule));
        this.b = provider;
        this.c = DoubleCheck.provider(OkHttpModule_ProvideOkHttpClientFactory.create(okHttpModule, provider));
        Provider<Logger> provider2 = DoubleCheck.provider(LoggerModule_ProvideLoggerFactory.create(loggerModule));
        this.d = provider2;
        Provider<Gson> provider3 = DoubleCheck.provider(GsonModule_ProvideGsonFactory.create(gsonModule, provider2));
        this.e = provider3;
        this.f = DoubleCheck.provider(HttpMessengerTransportModule_ProvideHttpApiFactory.create(httpMessengerTransportModule, this.c, provider3, this.b));
        this.g = DoubleCheck.provider(SchedulersModule_ProvideSchedulersFactory.create(schedulersModule));
        Provider<ErrorTracker> provider4 = DoubleCheck.provider(ErrorTrackerModule_ProvideErrorTrackerFactory.create(errorTrackerModule));
        this.h = provider4;
        this.i = DoubleCheck.provider(HttpMessengerTransportModule_ProvideHttpJsonRpcClientFactory.create(httpMessengerTransportModule, this.f, this.b, this.d, this.g, provider4));
        Provider<GsonDeserializer> provider5 = DoubleCheck.provider(GsonModule_ProvideGsonDeserializerFactory.create(gsonModule, this.e));
        this.j = provider5;
        this.k = DoubleCheck.provider(HttpMessengerTransportModule_ProvideHttpMessengerApiFactory.create(httpMessengerTransportModule, this.a, this.i, provider5, this.d));
        Provider<RequestIdHolderImpl> provider6 = DoubleCheck.provider(WebSocketMessengerTransportModule_ProvideRequestIdHolderProvider$messenger_releaseFactory.create(webSocketMessengerTransportModule));
        this.l = provider6;
        Provider<RequestProvider> provider7 = DoubleCheck.provider(WebSocketMessengerTransportModule_ProvideRequestBuilderFactory.create(webSocketMessengerTransportModule, this.b, this.d, provider6));
        this.m = provider7;
        Provider<WebSocketFactory> provider8 = DoubleCheck.provider(WebSocketMessengerTransportModule_ProvideWebSocketFactoryFactory.create(webSocketMessengerTransportModule, this.c, provider7));
        this.n = provider8;
        this.o = DoubleCheck.provider(WebSocketMessengerTransportModule_ProvideRxWebSocketFactory.create(webSocketMessengerTransportModule, provider8, this.d, this.b, this.g));
        Provider<WebsocketMessageParser<MessengerResponse>> provider9 = DoubleCheck.provider(WebSocketMessengerTransportModule_ProvideWebsocketMessageParserFactory.create(webSocketMessengerTransportModule, this.e, this.h));
        this.p = provider9;
        this.q = DoubleCheck.provider(WebSocketMessengerTransportModule_ProvideWebSocketJsonRpcClientFactory.create(webSocketMessengerTransportModule, this.o, provider9, this.e, this.b, this.d, this.g, this.h));
        Provider<JsonRpcCallAnalyticsInterceptor> provider10 = DoubleCheck.provider(InterceptorsModule_ProvideJsonRpcCallAnalyticsInterceptorFactory.create(interceptorsModule, this.b, this.l));
        this.r = provider10;
        this.s = DoubleCheck.provider(WebSocketMessengerTransportModule_ProvideWebSocketTransportApiFactory.create(webSocketMessengerTransportModule, this.q, this.j, this.d, this.a, provider10));
        Provider<MessengerConfigStorage> provider11 = DoubleCheck.provider(MessengerConfigModule_ProvideMessengerConfigStorageFactory.create(messengerConfigModule, this.b));
        this.u = provider11;
        Provider<MessengerConnectionHolder<MessengerApi>> provider12 = DoubleCheck.provider(MessengerClientModule_ProvideConnectionHolderFactory.create(this.o, this.s, this.p, this.t, this.b, provider11, this.g, this.d, this.h));
        this.v = provider12;
        this.w = DoubleCheck.provider(MessengerClientModule_ProvideMessengerClientFactory.create(this.k, this.g, this.b, provider12, this.h));
        Provider<OkHttpClient> provider13 = DoubleCheck.provider(ImageUploadModule_ProvideImageUploadOkHttpClientFactory.create(imageUploadModule, this.c));
        this.x = provider13;
        this.y = DoubleCheck.provider(ImageUploadModule_ProvideImageUploadApiFactory.create(imageUploadModule, provider13, this.b, this.e, this.g));
        this.z = DoubleCheck.provider(MessengerConfigModule_ProvideMessengerConfigProviderFactory.create(messengerConfigModule, this.u, this.g));
    }

    public static Builder builder() {
        return new Builder(null);
    }

    @Override // ru.avito.messenger.internal.di.MessengerComponent
    public MessengerImpl<MessengerApi> createMessenger() {
        return new MessengerImpl<>(this.w.get(), this.y.get(), this.e.get(), this.z.get());
    }
}
