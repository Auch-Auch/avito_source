package ru.avito.messenger.internal;

import a2.g.r.g;
import com.avito.android.analytics.Analytics;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.EndpointProvider;
import ru.avito.messenger.KeepConnectionProvider;
import ru.avito.messenger.MessengerApiWrapper;
import ru.avito.messenger.MessengerSessionRefresher;
import ru.avito.messenger.NetworkMonitor;
import ru.avito.messenger.ReconnectPolicy;
import ru.avito.messenger.SessionProvider;
import ru.avito.messenger.config.MessengerConfigStorage;
import ru.avito.reporter.WebSocketReporter;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B¡\u0001\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010:\u001a\u000205\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u0002050J\u0012\u0006\u0010=\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u00104\u001a\u00020\b\u0012\u0006\u0010+\u001a\u00020&\u0012\u0006\u0010a\u001a\u00020\\\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010%\u001a\u0004\u0018\u00010 \u0012\u0006\u0010C\u001a\u00020>\u0012\b\u0010[\u001a\u0004\u0018\u00010V\u0012\u0006\u00101\u001a\u00020,\u0012\u0006\u0010U\u001a\u00020P\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010I\u001a\u00020D¢\u0006\u0004\bb\u0010cR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0019\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010%\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010+\u001a\u00020&8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0019\u00101\u001a\u00020,8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0019\u00104\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010\n\u001a\u0004\b3\u0010\fR\u0019\u0010:\u001a\u0002058\u0006@\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0019\u0010=\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010\n\u001a\u0004\b<\u0010\fR\u0019\u0010C\u001a\u00020>8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0019\u0010I\u001a\u00020D8\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR%\u0010O\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u0002050J8\u0006@\u0006¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u0019\u0010U\u001a\u00020P8\u0006@\u0006¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR\u001b\u0010[\u001a\u0004\u0018\u00010V8\u0006@\u0006¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u0019\u0010a\u001a\u00020\\8\u0006@\u0006¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`¨\u0006d"}, d2 = {"Lru/avito/messenger/internal/Config;", "", "Lru/avito/messenger/EndpointProvider;", AuthSource.SEND_ABUSE, "Lru/avito/messenger/EndpointProvider;", "getEndpointProvider", "()Lru/avito/messenger/EndpointProvider;", "endpointProvider", "", "f", "J", "getCommandTimeout", "()J", "commandTimeout", "Lcom/avito/android/analytics/Analytics;", "c", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "analytics", "Lru/avito/messenger/KeepConnectionProvider;", "p", "Lru/avito/messenger/KeepConnectionProvider;", "getKeepConnectionProvider", "()Lru/avito/messenger/KeepConnectionProvider;", "keepConnectionProvider", "Lokhttp3/Headers;", "j", "Lokhttp3/Headers;", "getHandshakeHeaders", "()Lokhttp3/Headers;", "handshakeHeaders", "Lru/avito/reporter/WebSocketReporter;", "k", "Lru/avito/reporter/WebSocketReporter;", "getWebSocketReporter", "()Lru/avito/reporter/WebSocketReporter;", "webSocketReporter", "Lru/avito/messenger/ReconnectPolicy;", "h", "Lru/avito/messenger/ReconnectPolicy;", "getReconnectPolicy", "()Lru/avito/messenger/ReconnectPolicy;", "reconnectPolicy", "Lru/avito/messenger/SessionProvider;", "n", "Lru/avito/messenger/SessionProvider;", "getSessionProvider", "()Lru/avito/messenger/SessionProvider;", "sessionProvider", g.a, "getPingTimeout", "pingTimeout", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getOrigin", "()Ljava/lang/String;", "origin", "e", "getJsonRpcTimeout", "jsonRpcTimeout", "", "l", "Z", "getUseNewWebsocket", "()Z", "useNewWebsocket", "Lru/avito/messenger/config/MessengerConfigStorage;", VKApiConst.Q, "Lru/avito/messenger/config/MessengerConfigStorage;", "getConfigStorage", "()Lru/avito/messenger/config/MessengerConfigStorage;", "configStorage", "", "d", "Ljava/util/Map;", "getConnectionParams", "()Ljava/util/Map;", "connectionParams", "Lru/avito/messenger/MessengerSessionRefresher;", "o", "Lru/avito/messenger/MessengerSessionRefresher;", "getSessionRefresher", "()Lru/avito/messenger/MessengerSessionRefresher;", "sessionRefresher", "Lru/avito/messenger/MessengerApiWrapper;", AuthSource.OPEN_CHANNEL_LIST, "Lru/avito/messenger/MessengerApiWrapper;", "getApiWrapper", "()Lru/avito/messenger/MessengerApiWrapper;", "apiWrapper", "Lru/avito/messenger/NetworkMonitor;", "i", "Lru/avito/messenger/NetworkMonitor;", "getNetworkMonitor", "()Lru/avito/messenger/NetworkMonitor;", "networkMonitor", "<init>", "(Lru/avito/messenger/EndpointProvider;Ljava/lang/String;Lcom/avito/android/analytics/Analytics;Ljava/util/Map;JJJLru/avito/messenger/ReconnectPolicy;Lru/avito/messenger/NetworkMonitor;Lokhttp3/Headers;Lru/avito/reporter/WebSocketReporter;ZLru/avito/messenger/MessengerApiWrapper;Lru/avito/messenger/SessionProvider;Lru/avito/messenger/MessengerSessionRefresher;Lru/avito/messenger/KeepConnectionProvider;Lru/avito/messenger/config/MessengerConfigStorage;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class Config {
    @NotNull
    public final EndpointProvider a;
    @NotNull
    public final String b;
    @NotNull
    public final Analytics c;
    @NotNull
    public final Map<String, String> d;
    public final long e;
    public final long f;
    public final long g;
    @NotNull
    public final ReconnectPolicy h;
    @NotNull
    public final NetworkMonitor i;
    @Nullable
    public final Headers j;
    @Nullable
    public final WebSocketReporter k;
    public final boolean l;
    @Nullable
    public final MessengerApiWrapper m;
    @NotNull
    public final SessionProvider n;
    @NotNull
    public final MessengerSessionRefresher o;
    @NotNull
    public final KeepConnectionProvider p;
    @NotNull
    public final MessengerConfigStorage q;

    public Config(@NotNull EndpointProvider endpointProvider, @NotNull String str, @NotNull Analytics analytics, @NotNull Map<String, String> map, long j2, long j3, long j4, @NotNull ReconnectPolicy reconnectPolicy, @NotNull NetworkMonitor networkMonitor, @Nullable Headers headers, @Nullable WebSocketReporter webSocketReporter, boolean z, @Nullable MessengerApiWrapper messengerApiWrapper, @NotNull SessionProvider sessionProvider, @NotNull MessengerSessionRefresher messengerSessionRefresher, @NotNull KeepConnectionProvider keepConnectionProvider, @NotNull MessengerConfigStorage messengerConfigStorage) {
        Intrinsics.checkNotNullParameter(endpointProvider, "endpointProvider");
        Intrinsics.checkNotNullParameter(str, "origin");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(map, "connectionParams");
        Intrinsics.checkNotNullParameter(reconnectPolicy, "reconnectPolicy");
        Intrinsics.checkNotNullParameter(networkMonitor, "networkMonitor");
        Intrinsics.checkNotNullParameter(sessionProvider, "sessionProvider");
        Intrinsics.checkNotNullParameter(messengerSessionRefresher, "sessionRefresher");
        Intrinsics.checkNotNullParameter(keepConnectionProvider, "keepConnectionProvider");
        Intrinsics.checkNotNullParameter(messengerConfigStorage, "configStorage");
        this.a = endpointProvider;
        this.b = str;
        this.c = analytics;
        this.d = map;
        this.e = j2;
        this.f = j3;
        this.g = j4;
        this.h = reconnectPolicy;
        this.i = networkMonitor;
        this.j = headers;
        this.k = webSocketReporter;
        this.l = z;
        this.m = messengerApiWrapper;
        this.n = sessionProvider;
        this.o = messengerSessionRefresher;
        this.p = keepConnectionProvider;
        this.q = messengerConfigStorage;
    }

    @NotNull
    public final Analytics getAnalytics() {
        return this.c;
    }

    @Nullable
    public final MessengerApiWrapper getApiWrapper() {
        return this.m;
    }

    public final long getCommandTimeout() {
        return this.f;
    }

    @NotNull
    public final MessengerConfigStorage getConfigStorage() {
        return this.q;
    }

    @NotNull
    public final Map<String, String> getConnectionParams() {
        return this.d;
    }

    @NotNull
    public final EndpointProvider getEndpointProvider() {
        return this.a;
    }

    @Nullable
    public final Headers getHandshakeHeaders() {
        return this.j;
    }

    public final long getJsonRpcTimeout() {
        return this.e;
    }

    @NotNull
    public final KeepConnectionProvider getKeepConnectionProvider() {
        return this.p;
    }

    @NotNull
    public final NetworkMonitor getNetworkMonitor() {
        return this.i;
    }

    @NotNull
    public final String getOrigin() {
        return this.b;
    }

    public final long getPingTimeout() {
        return this.g;
    }

    @NotNull
    public final ReconnectPolicy getReconnectPolicy() {
        return this.h;
    }

    @NotNull
    public final SessionProvider getSessionProvider() {
        return this.n;
    }

    @NotNull
    public final MessengerSessionRefresher getSessionRefresher() {
        return this.o;
    }

    public final boolean getUseNewWebsocket() {
        return this.l;
    }

    @Nullable
    public final WebSocketReporter getWebSocketReporter() {
        return this.k;
    }
}
