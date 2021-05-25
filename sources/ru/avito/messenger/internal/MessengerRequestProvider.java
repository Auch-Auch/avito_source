package ru.avito.messenger.internal;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.SessionContract;
import com.facebook.internal.ServerProtocol;
import io.reactivex.Single;
import io.reactivex.functions.BiFunction;
import io.reactivex.rxkotlin.Singles;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.EndpointProvider;
import ru.avito.messenger.RequestIdGenerator;
import ru.avito.messenger.SessionProvider;
import ru.avito.messenger.internal.log.Logger;
import ru.avito.websocket.RequestProvider;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0011\u0012\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0019\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010!¢\u0006\u0004\b%\u0010&J3\u0010\b\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00070\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lru/avito/messenger/internal/MessengerRequestProvider;", "Lru/avito/websocket/RequestProvider;", "", "sequenceId", "Lio/reactivex/Single;", "Lkotlin/Pair;", "Lokhttp3/Request;", "Lru/avito/websocket/RequestIdHeader;", "request", "(Ljava/lang/String;)Lio/reactivex/Single;", "Lru/avito/messenger/RequestIdGenerator;", "c", "Lru/avito/messenger/RequestIdGenerator;", "requestIdGenerator", "d", "Ljava/lang/String;", "origin", "Lokhttp3/Headers;", "e", "Lokhttp3/Headers;", "headers", "Lru/avito/messenger/SessionProvider;", AuthSource.SEND_ABUSE, "Lru/avito/messenger/SessionProvider;", "sessionProvider", "", "f", "Ljava/util/Map;", "params", "Lru/avito/messenger/EndpointProvider;", AuthSource.BOOKING_ORDER, "Lru/avito/messenger/EndpointProvider;", "endpointProvider", "Lru/avito/messenger/internal/log/Logger;", g.a, "Lru/avito/messenger/internal/log/Logger;", "logger", "<init>", "(Lru/avito/messenger/SessionProvider;Lru/avito/messenger/EndpointProvider;Lru/avito/messenger/RequestIdGenerator;Ljava/lang/String;Lokhttp3/Headers;Ljava/util/Map;Lru/avito/messenger/internal/log/Logger;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessengerRequestProvider implements RequestProvider {
    public final SessionProvider a;
    public final EndpointProvider b;
    public final RequestIdGenerator c;
    public final String d;
    public final Headers e;
    public final Map<String, String> f;
    public final Logger g;

    public MessengerRequestProvider(@NotNull SessionProvider sessionProvider, @NotNull EndpointProvider endpointProvider, @NotNull RequestIdGenerator requestIdGenerator, @NotNull String str, @Nullable Headers headers, @NotNull Map<String, String> map, @Nullable Logger logger) {
        Intrinsics.checkNotNullParameter(sessionProvider, "sessionProvider");
        Intrinsics.checkNotNullParameter(endpointProvider, "endpointProvider");
        Intrinsics.checkNotNullParameter(requestIdGenerator, "requestIdGenerator");
        Intrinsics.checkNotNullParameter(str, "origin");
        Intrinsics.checkNotNullParameter(map, "params");
        this.a = sessionProvider;
        this.b = endpointProvider;
        this.c = requestIdGenerator;
        this.d = str;
        this.e = headers;
        this.f = map;
        this.g = logger;
    }

    public static final Request access$buildRequest(MessengerRequestProvider messengerRequestProvider, HttpUrl httpUrl, String str, String str2, String str3) {
        Logger logger = messengerRequestProvider.g;
        if (logger != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("building upgrade request: endpoint=");
            sb.append(httpUrl);
            sb.append(", origin=");
            Logger.DefaultImpls.d$default(logger, ConstantsKt.LOG_TAG, a.u(sb, messengerRequestProvider.d, ", session=", str), null, 4, null);
        }
        Logger logger2 = messengerRequestProvider.g;
        if (logger2 != null) {
            StringBuilder L = a.L("extra headers: ");
            L.append(messengerRequestProvider.e);
            Logger.DefaultImpls.d$default(logger2, ConstantsKt.LOG_TAG, L.toString(), null, 4, null);
        }
        Logger logger3 = messengerRequestProvider.g;
        if (logger3 != null) {
            StringBuilder L2 = a.L("params: ");
            L2.append(messengerRequestProvider.f);
            Logger.DefaultImpls.d$default(logger3, ConstantsKt.LOG_TAG, L2.toString(), null, 4, null);
        }
        Logger logger4 = messengerRequestProvider.g;
        if (logger4 != null) {
            Logger.DefaultImpls.d$default(logger4, ConstantsKt.LOG_TAG, a.c3("sequenceId: ", str2), null, 4, null);
        }
        Logger logger5 = messengerRequestProvider.g;
        if (logger5 != null) {
            Logger.DefaultImpls.d$default(logger5, ConstantsKt.LOG_TAG, a.c3("requestId: ", str3), null, 4, null);
        }
        Request.Builder addHeader = new Request.Builder().addHeader(OkHttpMessengerImageUploaderKt.IMAGE_UPLOAD_SESSION_HEADER, str).addHeader("Origin", messengerRequestProvider.d).addHeader("X-Request-Id", str3);
        Headers headers = messengerRequestProvider.e;
        Map<String, List<String>> multimap = headers != null ? headers.toMultimap() : null;
        if (multimap == null) {
            multimap = r.emptyMap();
        }
        for (Map.Entry<String, List<String>> entry : multimap.entrySet()) {
            String key = entry.getKey();
            Iterator<T> it = entry.getValue().iterator();
            while (it.hasNext()) {
                addHeader.addHeader(key, it.next());
            }
        }
        Map<String, String> map = messengerRequestProvider.f;
        HttpUrl.Builder newBuilder = httpUrl.newBuilder();
        for (Map.Entry<String, String> entry2 : map.entrySet()) {
            newBuilder.setQueryParameter(entry2.getKey(), entry2.getValue());
        }
        if (Intrinsics.areEqual(map.get("use_seq"), ServerProtocol.DIALOG_RETURN_SCOPES_TRUE) && str2 != null) {
            newBuilder.setQueryParameter("seq", str2);
        }
        return addHeader.url(newBuilder.build()).get().build();
    }

    @Override // ru.avito.websocket.RequestProvider
    @NotNull
    public Single<Pair<Request, String>> request(@Nullable String str) {
        Singles singles = Singles.INSTANCE;
        Single<Pair<Request, String>> zip = Single.zip(this.a.session(), this.b.endpoint(), new BiFunction<String, HttpUrl, R>(this, str) { // from class: ru.avito.messenger.internal.MessengerRequestProvider$request$$inlined$zip$1
            public final /* synthetic */ MessengerRequestProvider a;
            public final /* synthetic */ String b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // io.reactivex.functions.BiFunction
            public final R apply(String str2, HttpUrl httpUrl) {
                HttpUrl httpUrl2 = httpUrl;
                String str3 = str2;
                String generateRequestId = MessengerRequestProvider.access$getRequestIdGenerator$p(this.a).generateRequestId();
                MessengerRequestProvider messengerRequestProvider = this.a;
                Intrinsics.checkNotNullExpressionValue(httpUrl2, "endpoint");
                Intrinsics.checkNotNullExpressionValue(str3, SessionContract.SESSION);
                return (R) TuplesKt.to(MessengerRequestProvider.access$buildRequest(messengerRequestProvider, httpUrl2, str3, this.b, generateRequestId), generateRequestId);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zip, "Single.zip(s1, s2, BiFun…-> zipper.invoke(t, u) })");
        return zip;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessengerRequestProvider(SessionProvider sessionProvider, EndpointProvider endpointProvider, RequestIdGenerator requestIdGenerator, String str, Headers headers, Map map, Logger logger, int i, j jVar) {
        this(sessionProvider, endpointProvider, requestIdGenerator, str, (i & 16) != 0 ? null : headers, (i & 32) != 0 ? r.emptyMap() : map, (i & 64) != 0 ? null : logger);
    }
}
