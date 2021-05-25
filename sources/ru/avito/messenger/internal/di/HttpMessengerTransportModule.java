package ru.avito.messenger.internal.di;

import androidx.core.app.NotificationCompat;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.jsonrpc.client.JsonRpcClient;
import com.avito.android.jsonrpc.client.JsonRpcServiceBuilder;
import com.avito.android.remote.model.Navigation;
import com.avito.android.util.SchedulersFactory;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.avito.messenger.MessengerApi;
import ru.avito.messenger.MessengerApiWrapper;
import ru.avito.messenger.internal.Config;
import ru.avito.messenger.internal.ConstantsKt;
import ru.avito.messenger.internal.gson.GsonDeserializer;
import ru.avito.messenger.internal.jsonrpc.HttpApi;
import ru.avito.messenger.internal.jsonrpc.HttpJsonRpcClient;
import ru.avito.messenger.internal.log.Logger;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001:\u0002 !B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ=\u0010\f\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\rJ=\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u001c\u001a\u00020\u000e2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lru/avito/messenger/internal/di/HttpMessengerTransportModule;", "", "Ljava/lang/Class;", "Lru/avito/messenger/MessengerApi;", NotificationCompat.CATEGORY_SERVICE, "Lcom/avito/android/jsonrpc/client/JsonRpcClient;", "Lcom/google/gson/JsonElement;", "client", "Lru/avito/messenger/internal/gson/GsonDeserializer;", "gsonDeserializer", "Lru/avito/messenger/internal/log/Logger;", "logger", "provideHttpMessengerApi", "(Ljava/lang/Class;Lcom/avito/android/jsonrpc/client/JsonRpcClient;Lru/avito/messenger/internal/gson/GsonDeserializer;Lru/avito/messenger/internal/log/Logger;)Lru/avito/messenger/MessengerApi;", "Lru/avito/messenger/internal/jsonrpc/HttpApi;", "api", "Lru/avito/messenger/internal/Config;", Navigation.CONFIG, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "errorTracker", "provideHttpJsonRpcClient", "(Lru/avito/messenger/internal/jsonrpc/HttpApi;Lru/avito/messenger/internal/Config;Lru/avito/messenger/internal/log/Logger;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/communications_common/analytics/ErrorTracker;)Lcom/avito/android/jsonrpc/client/JsonRpcClient;", "Ldagger/Lazy;", "Lokhttp3/OkHttpClient;", "Lcom/google/gson/Gson;", "gson", "provideHttpApi", "(Ldagger/Lazy;Lcom/google/gson/Gson;Lru/avito/messenger/internal/Config;)Lru/avito/messenger/internal/jsonrpc/HttpApi;", "<init>", "()V", "HttpClient", "HttpTransportApi", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {SchedulersModule.class, LoggerModule.class, ConfigModule.class, GsonModule.class, OkHttpModule.class, ErrorTrackerModule.class})
public final class HttpMessengerTransportModule {

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/avito/messenger/internal/di/HttpMessengerTransportModule$HttpClient;", "", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface HttpClient {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/avito/messenger/internal/di/HttpMessengerTransportModule$HttpTransportApi;", "", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface HttpTransportApi {
    }

    public static final class a extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ Logger a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Logger logger) {
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
    public final HttpApi provideHttpApi(@NotNull Lazy<OkHttpClient> lazy, @NotNull Gson gson, @NotNull Config config) {
        Intrinsics.checkNotNullParameter(lazy, "client");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(config, Navigation.CONFIG);
        Retrofit.Builder addConverterFactory = new Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create(gson));
        HttpUrl blockingGet = config.getEndpointProvider().endpoint().blockingGet();
        if (CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"socket.avito.ru", "socket.t.avito.ru"}).contains(blockingGet.host())) {
            blockingGet = blockingGet.newBuilder().encodedPath("/").build();
        } else if (m.endsWith$default(blockingGet.encodedPath(), "/socket", false, 2, null)) {
            blockingGet = blockingGet.newBuilder().encodedPath(StringsKt__StringsKt.removeSuffix(blockingGet.encodedPath(), (CharSequence) "/socket")).addPathSegment("").build();
        } else if (!m.endsWith$default(blockingGet.encodedPath(), "/", false, 2, null)) {
            blockingGet = blockingGet.newBuilder().encodedPath("").addPathSegment("").build();
        } else {
            Intrinsics.checkNotNullExpressionValue(blockingGet, "socketEndpoint");
        }
        Retrofit build = addConverterFactory.baseUrl(blockingGet).callFactory(new Call.Factory(lazy) { // from class: ru.avito.messenger.internal.di.HttpMessengerTransportModule$provideHttpApi$1
            public final /* synthetic */ Lazy a;

            {
                this.a = r1;
            }

            @Override // okhttp3.Call.Factory
            @NotNull
            public Call newCall(@NotNull Request request) {
                Intrinsics.checkNotNullParameter(request, "request");
                return ((OkHttpClient) this.a.get()).newCall(request);
            }
        }).build();
        Intrinsics.checkNotNullExpressionValue(build, "Retrofit.Builder()\n     …  })\n            .build()");
        return (HttpApi) build.create(HttpApi.class);
    }

    @Provides
    @PerMessenger
    @NotNull
    public final JsonRpcClient<JsonElement> provideHttpJsonRpcClient(@NotNull HttpApi httpApi, @NotNull Config config, @NotNull Logger logger, @NotNull SchedulersFactory schedulersFactory, @NotNull ErrorTracker errorTracker) {
        JsonRpcClient<JsonElement> wrapHttp;
        Intrinsics.checkNotNullParameter(httpApi, "api");
        Intrinsics.checkNotNullParameter(config, Navigation.CONFIG);
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(errorTracker, "errorTracker");
        HttpJsonRpcClient httpJsonRpcClient = new HttpJsonRpcClient(httpApi, config.getSessionProvider(), config.getOrigin(), config.getConnectionParams(), logger, schedulersFactory, errorTracker);
        MessengerApiWrapper apiWrapper = config.getApiWrapper();
        return (apiWrapper == null || (wrapHttp = apiWrapper.wrapHttp(httpJsonRpcClient)) == null) ? httpJsonRpcClient : wrapHttp;
    }

    @Provides
    @PerMessenger
    @NotNull
    public final MessengerApi provideHttpMessengerApi(@NotNull Class<? extends MessengerApi> cls, @NotNull JsonRpcClient<JsonElement> jsonRpcClient, @NotNull GsonDeserializer gsonDeserializer, @NotNull Logger logger) {
        Intrinsics.checkNotNullParameter(cls, NotificationCompat.CATEGORY_SERVICE);
        Intrinsics.checkNotNullParameter(jsonRpcClient, "client");
        Intrinsics.checkNotNullParameter(gsonDeserializer, "gsonDeserializer");
        Intrinsics.checkNotNullParameter(logger, "logger");
        return (MessengerApi) new JsonRpcServiceBuilder(cls, jsonRpcClient, gsonDeserializer, new a(logger)).build();
    }
}
