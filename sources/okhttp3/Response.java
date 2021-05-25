package okhttp3;

import a2.b.a.a.a;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.google.common.net.HttpHeaders;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.internal.connection.Exchange;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001XB}\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\n\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u001d\u0012\b\u0010(\u001a\u0004\u0018\u00010#\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0000\u0012\b\u00100\u001a\u0004\u0018\u00010\u0000\u0012\b\u00102\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010<\u001a\u00020!\u0012\u0006\u0010>\u001a\u00020!\u0012\b\u0010K\u001a\u0004\u0018\u00010J¢\u0006\u0004\bV\u0010WJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0011\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00172\u0006\u0010\u0016\u001a\u00020\u000e¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0018\u001a\u00020\u001dH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u001d¢\u0006\u0004\b \u0010\u001fJ\u0015\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b$\u0010%J\u0011\u0010(\u001a\u0004\u0018\u00010#H\u0007¢\u0006\u0004\b&\u0010'J\r\u0010*\u001a\u00020)¢\u0006\u0004\b*\u0010+J\u0011\u0010.\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b,\u0010-J\u0011\u00100\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b/\u0010-J\u0011\u00102\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b1\u0010-J\u0013\u00104\u001a\b\u0012\u0004\u0012\u0002030\u0017¢\u0006\u0004\b4\u00105J\u000f\u00109\u001a\u000206H\u0007¢\u0006\u0004\b7\u00108J\u000f\u0010<\u001a\u00020!H\u0007¢\u0006\u0004\b:\u0010;J\u000f\u0010>\u001a\u00020!H\u0007¢\u0006\u0004\b=\u0010;J\u000f\u0010@\u001a\u00020?H\u0016¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\u000eH\u0016¢\u0006\u0004\bB\u0010\u0010R\u0019\u0010>\u001a\u00020!8\u0007@\u0006¢\u0006\f\n\u0004\b>\u0010C\u001a\u0004\b>\u0010;R\u001b\u00102\u001a\u0004\u0018\u00010\u00008\u0007@\u0006¢\u0006\f\n\u0004\b2\u0010D\u001a\u0004\b2\u0010-R\u0019\u0010\u0018\u001a\u00020\u001d8\u0007@\u0006¢\u0006\f\n\u0004\b\u0018\u0010E\u001a\u0004\b\u0018\u0010\u001fR\u0013\u00109\u001a\u0002068G@\u0006¢\u0006\u0006\u001a\u0004\b9\u00108R\u0019\u0010\u0011\u001a\u00020\u000e8\u0007@\u0006¢\u0006\f\n\u0004\b\u0011\u0010F\u001a\u0004\b\u0011\u0010\u0010R\u0019\u0010<\u001a\u00020!8\u0007@\u0006¢\u0006\f\n\u0004\b<\u0010C\u001a\u0004\b<\u0010;R\u001b\u0010.\u001a\u0004\u0018\u00010\u00008\u0007@\u0006¢\u0006\f\n\u0004\b.\u0010D\u001a\u0004\b.\u0010-R\u001b\u0010(\u001a\u0004\u0018\u00010#8\u0007@\u0006¢\u0006\f\n\u0004\b(\u0010G\u001a\u0004\b(\u0010'R\u0019\u0010\t\u001a\u00020\u00068\u0007@\u0006¢\u0006\f\n\u0004\b\t\u0010H\u001a\u0004\b\t\u0010\bR\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0007@\u0006¢\u0006\f\n\u0004\b\u0015\u0010I\u001a\u0004\b\u0015\u0010\u0014R\u001b\u00100\u001a\u0004\u0018\u00010\u00008\u0007@\u0006¢\u0006\f\n\u0004\b0\u0010D\u001a\u0004\b0\u0010-R\u001e\u0010K\u001a\u0004\u0018\u00010J8\u0001@\u0000X\u0004¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bK\u0010MR\u0018\u0010N\u001a\u0004\u0018\u0001068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0019\u0010\u0005\u001a\u00020\u00028\u0007@\u0006¢\u0006\f\n\u0004\b\u0005\u0010P\u001a\u0004\b\u0005\u0010\u0004R\u0013\u0010R\u001a\u00020Q8F@\u0006¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0013\u0010T\u001a\u00020Q8F@\u0006¢\u0006\u0006\u001a\u0004\bT\u0010SR\u0019\u0010\r\u001a\u00020\n8\u0007@\u0006¢\u0006\f\n\u0004\b\r\u0010U\u001a\u0004\b\r\u0010\f¨\u0006Y"}, d2 = {"Lokhttp3/Response;", "Ljava/io/Closeable;", "Lokhttp3/Request;", "-deprecated_request", "()Lokhttp3/Request;", "request", "Lokhttp3/Protocol;", "-deprecated_protocol", "()Lokhttp3/Protocol;", "protocol", "", "-deprecated_code", "()I", "code", "", "-deprecated_message", "()Ljava/lang/String;", "message", "Lokhttp3/Handshake;", "-deprecated_handshake", "()Lokhttp3/Handshake;", "handshake", "name", "", "headers", "(Ljava/lang/String;)Ljava/util/List;", "defaultValue", TariffPackageInfoConverterKt.HEADER_STRING_ID, "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lokhttp3/Headers;", "-deprecated_headers", "()Lokhttp3/Headers;", "trailers", "", DecodeProducer.EXTRA_BITMAP_BYTES, "Lokhttp3/ResponseBody;", "peekBody", "(J)Lokhttp3/ResponseBody;", "-deprecated_body", "()Lokhttp3/ResponseBody;", SDKConstants.PARAM_A2U_BODY, "Lokhttp3/Response$Builder;", "newBuilder", "()Lokhttp3/Response$Builder;", "-deprecated_networkResponse", "()Lokhttp3/Response;", "networkResponse", "-deprecated_cacheResponse", "cacheResponse", "-deprecated_priorResponse", "priorResponse", "Lokhttp3/Challenge;", "challenges", "()Ljava/util/List;", "Lokhttp3/CacheControl;", "-deprecated_cacheControl", "()Lokhttp3/CacheControl;", "cacheControl", "-deprecated_sentRequestAtMillis", "()J", "sentRequestAtMillis", "-deprecated_receivedResponseAtMillis", "receivedResponseAtMillis", "", "close", "()V", "toString", "J", "Lokhttp3/Response;", "Lokhttp3/Headers;", "Ljava/lang/String;", "Lokhttp3/ResponseBody;", "Lokhttp3/Protocol;", "Lokhttp3/Handshake;", "Lokhttp3/internal/connection/Exchange;", "exchange", "Lokhttp3/internal/connection/Exchange;", "()Lokhttp3/internal/connection/Exchange;", "lazyCacheControl", "Lokhttp3/CacheControl;", "Lokhttp3/Request;", "", "isSuccessful", "()Z", "isRedirect", "I", "<init>", "(Lokhttp3/Request;Lokhttp3/Protocol;Ljava/lang/String;ILokhttp3/Handshake;Lokhttp3/Headers;Lokhttp3/ResponseBody;Lokhttp3/Response;Lokhttp3/Response;Lokhttp3/Response;JJLokhttp3/internal/connection/Exchange;)V", "Builder", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Response implements Closeable {
    @Nullable
    private final ResponseBody body;
    @Nullable
    private final Response cacheResponse;
    private final int code;
    @Nullable
    private final Exchange exchange;
    @Nullable
    private final Handshake handshake;
    @NotNull
    private final Headers headers;
    private CacheControl lazyCacheControl;
    @NotNull
    private final String message;
    @Nullable
    private final Response networkResponse;
    @Nullable
    private final Response priorResponse;
    @NotNull
    private final Protocol protocol;
    private final long receivedResponseAtMillis;
    @NotNull
    private final Request request;
    private final long sentRequestAtMillis;

    public Response(@NotNull Request request2, @NotNull Protocol protocol2, @NotNull String str, int i, @Nullable Handshake handshake2, @NotNull Headers headers2, @Nullable ResponseBody responseBody, @Nullable Response response, @Nullable Response response2, @Nullable Response response3, long j, long j2, @Nullable Exchange exchange2) {
        Intrinsics.checkNotNullParameter(request2, "request");
        Intrinsics.checkNotNullParameter(protocol2, "protocol");
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(headers2, "headers");
        this.request = request2;
        this.protocol = protocol2;
        this.message = str;
        this.code = i;
        this.handshake = handshake2;
        this.headers = headers2;
        this.body = responseBody;
        this.networkResponse = response;
        this.cacheResponse = response2;
        this.priorResponse = response3;
        this.sentRequestAtMillis = j;
        this.receivedResponseAtMillis = j2;
        this.exchange = exchange2;
    }

    public static /* synthetic */ String header$default(Response response, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return response.header(str, str2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "body", imports = {}))
    @JvmName(name = "-deprecated_body")
    @Nullable
    /* renamed from: -deprecated_body */
    public final ResponseBody m659deprecated_body() {
        return this.body;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cacheControl", imports = {}))
    @JvmName(name = "-deprecated_cacheControl")
    @NotNull
    /* renamed from: -deprecated_cacheControl */
    public final CacheControl m660deprecated_cacheControl() {
        return cacheControl();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cacheResponse", imports = {}))
    @JvmName(name = "-deprecated_cacheResponse")
    @Nullable
    /* renamed from: -deprecated_cacheResponse */
    public final Response m661deprecated_cacheResponse() {
        return this.cacheResponse;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "code", imports = {}))
    @JvmName(name = "-deprecated_code")
    /* renamed from: -deprecated_code */
    public final int m662deprecated_code() {
        return this.code;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "handshake", imports = {}))
    @JvmName(name = "-deprecated_handshake")
    @Nullable
    /* renamed from: -deprecated_handshake */
    public final Handshake m663deprecated_handshake() {
        return this.handshake;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "headers", imports = {}))
    @JvmName(name = "-deprecated_headers")
    @NotNull
    /* renamed from: -deprecated_headers */
    public final Headers m664deprecated_headers() {
        return this.headers;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "message", imports = {}))
    @JvmName(name = "-deprecated_message")
    @NotNull
    /* renamed from: -deprecated_message */
    public final String m665deprecated_message() {
        return this.message;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "networkResponse", imports = {}))
    @JvmName(name = "-deprecated_networkResponse")
    @Nullable
    /* renamed from: -deprecated_networkResponse */
    public final Response m666deprecated_networkResponse() {
        return this.networkResponse;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "priorResponse", imports = {}))
    @JvmName(name = "-deprecated_priorResponse")
    @Nullable
    /* renamed from: -deprecated_priorResponse */
    public final Response m667deprecated_priorResponse() {
        return this.priorResponse;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "protocol", imports = {}))
    @JvmName(name = "-deprecated_protocol")
    @NotNull
    /* renamed from: -deprecated_protocol */
    public final Protocol m668deprecated_protocol() {
        return this.protocol;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "receivedResponseAtMillis", imports = {}))
    @JvmName(name = "-deprecated_receivedResponseAtMillis")
    /* renamed from: -deprecated_receivedResponseAtMillis */
    public final long m669deprecated_receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "request", imports = {}))
    @JvmName(name = "-deprecated_request")
    @NotNull
    /* renamed from: -deprecated_request */
    public final Request m670deprecated_request() {
        return this.request;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sentRequestAtMillis", imports = {}))
    @JvmName(name = "-deprecated_sentRequestAtMillis")
    /* renamed from: -deprecated_sentRequestAtMillis */
    public final long m671deprecated_sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    @JvmName(name = SDKConstants.PARAM_A2U_BODY)
    @Nullable
    public final ResponseBody body() {
        return this.body;
    }

    @JvmName(name = "cacheControl")
    @NotNull
    public final CacheControl cacheControl() {
        CacheControl cacheControl = this.lazyCacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl parse = CacheControl.Companion.parse(this.headers);
        this.lazyCacheControl = parse;
        return parse;
    }

    @JvmName(name = "cacheResponse")
    @Nullable
    public final Response cacheResponse() {
        return this.cacheResponse;
    }

    @NotNull
    public final List<Challenge> challenges() {
        String str;
        Headers headers2 = this.headers;
        int i = this.code;
        if (i == 401) {
            str = HttpHeaders.WWW_AUTHENTICATE;
        } else if (i != 407) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            str = HttpHeaders.PROXY_AUTHENTICATE;
        }
        return okhttp3.internal.http.HttpHeaders.parseChallenges(headers2, str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ResponseBody responseBody = this.body;
        if (responseBody != null) {
            responseBody.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed".toString());
    }

    @JvmName(name = "code")
    public final int code() {
        return this.code;
    }

    @JvmName(name = "exchange")
    @Nullable
    public final Exchange exchange() {
        return this.exchange;
    }

    @JvmName(name = "handshake")
    @Nullable
    public final Handshake handshake() {
        return this.handshake;
    }

    @JvmOverloads
    @Nullable
    public final String header(@NotNull String str) {
        return header$default(this, str, null, 2, null);
    }

    @JvmOverloads
    @Nullable
    public final String header(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        String str3 = this.headers.get(str);
        return str3 != null ? str3 : str2;
    }

    @JvmName(name = "headers")
    @NotNull
    public final Headers headers() {
        return this.headers;
    }

    public final boolean isRedirect() {
        int i = this.code;
        if (!(i == 307 || i == 308)) {
            switch (i) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public final boolean isSuccessful() {
        int i = this.code;
        return 200 <= i && 299 >= i;
    }

    @JvmName(name = "message")
    @NotNull
    public final String message() {
        return this.message;
    }

    @JvmName(name = "networkResponse")
    @Nullable
    public final Response networkResponse() {
        return this.networkResponse;
    }

    @NotNull
    public final Builder newBuilder() {
        return new Builder(this);
    }

    @NotNull
    public final ResponseBody peekBody(long j) throws IOException {
        ResponseBody responseBody = this.body;
        Intrinsics.checkNotNull(responseBody);
        BufferedSource peek = responseBody.source().peek();
        Buffer buffer = new Buffer();
        peek.request(j);
        buffer.write((Source) peek, Math.min(j, peek.getBuffer().size()));
        return ResponseBody.Companion.create(buffer, this.body.contentType(), buffer.size());
    }

    @JvmName(name = "priorResponse")
    @Nullable
    public final Response priorResponse() {
        return this.priorResponse;
    }

    @JvmName(name = "protocol")
    @NotNull
    public final Protocol protocol() {
        return this.protocol;
    }

    @JvmName(name = "receivedResponseAtMillis")
    public final long receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    @JvmName(name = "request")
    @NotNull
    public final Request request() {
        return this.request;
    }

    @JvmName(name = "sentRequestAtMillis")
    public final long sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("Response{protocol=");
        L.append(this.protocol);
        L.append(", code=");
        L.append(this.code);
        L.append(", message=");
        L.append(this.message);
        L.append(", url=");
        L.append(this.request.url());
        L.append('}');
        return L.toString();
    }

    @NotNull
    public final Headers trailers() throws IOException {
        Exchange exchange2 = this.exchange;
        if (exchange2 != null) {
            return exchange2.trailers();
        }
        throw new IllegalStateException("trailers not available".toString());
    }

    @NotNull
    public final List<String> headers(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return this.headers.values(str);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b#\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\bj\u0010kB\u0011\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bj\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0017\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0015J\u0017\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010\"\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b\"\u0010#J\u0019\u0010$\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b$\u0010%J\u0019\u0010&\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b&\u0010%J\u0019\u0010'\u001a\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b'\u0010%J\u0017\u0010)\u001a\u00020\u00002\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u00002\u0006\u0010+\u001a\u00020(H\u0016¢\u0006\u0004\b+\u0010*J\u0017\u00100\u001a\u00020\u00062\u0006\u0010-\u001a\u00020,H\u0000¢\u0006\u0004\b.\u0010/J\u000f\u00101\u001a\u00020\u0004H\u0016¢\u0006\u0004\b1\u00102R$\u0010$\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b$\u00103\u001a\u0004\b4\u00102\"\u0004\b5\u0010\nR\"\u0010+\u001a\u00020(8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b+\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010)\u001a\u00020(8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b)\u00106\u001a\u0004\b;\u00108\"\u0004\b<\u0010:R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\f\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR$\u0010&\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b&\u00103\u001a\u0004\bG\u00102\"\u0004\bH\u0010\nR\"\u0010\u001f\u001a\u00020I8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010\u0012\u001a\u00020\u00118\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R$\u0010'\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b'\u00103\u001a\u0004\b^\u00102\"\u0004\b_\u0010\nR$\u0010\"\u001a\u0004\u0018\u00010!8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\"\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR$\u0010e\u001a\u0004\u0018\u00010,8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010/¨\u0006l"}, d2 = {"Lokhttp3/Response$Builder;", "", "", "name", "Lokhttp3/Response;", CommonKt.EXTRA_RESPONSE, "", "checkSupportResponse", "(Ljava/lang/String;Lokhttp3/Response;)V", "checkPriorResponse", "(Lokhttp3/Response;)V", "Lokhttp3/Request;", "request", "(Lokhttp3/Request;)Lokhttp3/Response$Builder;", "Lokhttp3/Protocol;", "protocol", "(Lokhttp3/Protocol;)Lokhttp3/Response$Builder;", "", "code", "(I)Lokhttp3/Response$Builder;", "message", "(Ljava/lang/String;)Lokhttp3/Response$Builder;", "Lokhttp3/Handshake;", "handshake", "(Lokhttp3/Handshake;)Lokhttp3/Response$Builder;", "value", TariffPackageInfoConverterKt.HEADER_STRING_ID, "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Response$Builder;", "addHeader", "removeHeader", "Lokhttp3/Headers;", "headers", "(Lokhttp3/Headers;)Lokhttp3/Response$Builder;", "Lokhttp3/ResponseBody;", SDKConstants.PARAM_A2U_BODY, "(Lokhttp3/ResponseBody;)Lokhttp3/Response$Builder;", "networkResponse", "(Lokhttp3/Response;)Lokhttp3/Response$Builder;", "cacheResponse", "priorResponse", "", "sentRequestAtMillis", "(J)Lokhttp3/Response$Builder;", "receivedResponseAtMillis", "Lokhttp3/internal/connection/Exchange;", "deferredTrailers", "initExchange$okhttp", "(Lokhttp3/internal/connection/Exchange;)V", "initExchange", "build", "()Lokhttp3/Response;", "Lokhttp3/Response;", "getNetworkResponse$okhttp", "setNetworkResponse$okhttp", "J", "getReceivedResponseAtMillis$okhttp", "()J", "setReceivedResponseAtMillis$okhttp", "(J)V", "getSentRequestAtMillis$okhttp", "setSentRequestAtMillis$okhttp", "Lokhttp3/Handshake;", "getHandshake$okhttp", "()Lokhttp3/Handshake;", "setHandshake$okhttp", "(Lokhttp3/Handshake;)V", "Lokhttp3/Request;", "getRequest$okhttp", "()Lokhttp3/Request;", "setRequest$okhttp", "(Lokhttp3/Request;)V", "getCacheResponse$okhttp", "setCacheResponse$okhttp", "Lokhttp3/Headers$Builder;", "Lokhttp3/Headers$Builder;", "getHeaders$okhttp", "()Lokhttp3/Headers$Builder;", "setHeaders$okhttp", "(Lokhttp3/Headers$Builder;)V", "I", "getCode$okhttp", "()I", "setCode$okhttp", "(I)V", "Ljava/lang/String;", "getMessage$okhttp", "()Ljava/lang/String;", "setMessage$okhttp", "(Ljava/lang/String;)V", "Lokhttp3/Protocol;", "getProtocol$okhttp", "()Lokhttp3/Protocol;", "setProtocol$okhttp", "(Lokhttp3/Protocol;)V", "getPriorResponse$okhttp", "setPriorResponse$okhttp", "Lokhttp3/ResponseBody;", "getBody$okhttp", "()Lokhttp3/ResponseBody;", "setBody$okhttp", "(Lokhttp3/ResponseBody;)V", "exchange", "Lokhttp3/internal/connection/Exchange;", "getExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "setExchange$okhttp", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static class Builder {
        @Nullable
        private ResponseBody body;
        @Nullable
        private Response cacheResponse;
        private int code;
        @Nullable
        private Exchange exchange;
        @Nullable
        private Handshake handshake;
        @NotNull
        private Headers.Builder headers;
        @Nullable
        private String message;
        @Nullable
        private Response networkResponse;
        @Nullable
        private Response priorResponse;
        @Nullable
        private Protocol protocol;
        private long receivedResponseAtMillis;
        @Nullable
        private Request request;
        private long sentRequestAtMillis;

        public Builder() {
            this.code = -1;
            this.headers = new Headers.Builder();
        }

        private final void checkPriorResponse(Response response) {
            if (response != null) {
                if (!(response.body() == null)) {
                    throw new IllegalArgumentException("priorResponse.body != null".toString());
                }
            }
        }

        private final void checkSupportResponse(String str, Response response) {
            if (response != null) {
                boolean z = true;
                if (response.body() == null) {
                    if (response.networkResponse() == null) {
                        if (response.cacheResponse() == null) {
                            if (response.priorResponse() != null) {
                                z = false;
                            }
                            if (!z) {
                                throw new IllegalArgumentException(a.c3(str, ".priorResponse != null").toString());
                            }
                            return;
                        }
                        throw new IllegalArgumentException(a.c3(str, ".cacheResponse != null").toString());
                    }
                    throw new IllegalArgumentException(a.c3(str, ".networkResponse != null").toString());
                }
                throw new IllegalArgumentException(a.c3(str, ".body != null").toString());
            }
        }

        @NotNull
        public Builder addHeader(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "value");
            this.headers.add(str, str2);
            return this;
        }

        @NotNull
        public Builder body(@Nullable ResponseBody responseBody) {
            this.body = responseBody;
            return this;
        }

        @NotNull
        public Response build() {
            int i = this.code;
            if (i >= 0) {
                Request request2 = this.request;
                if (request2 != null) {
                    Protocol protocol2 = this.protocol;
                    if (protocol2 != null) {
                        String str = this.message;
                        if (str != null) {
                            return new Response(request2, protocol2, str, i, this.handshake, this.headers.build(), this.body, this.networkResponse, this.cacheResponse, this.priorResponse, this.sentRequestAtMillis, this.receivedResponseAtMillis, this.exchange);
                        }
                        throw new IllegalStateException("message == null".toString());
                    }
                    throw new IllegalStateException("protocol == null".toString());
                }
                throw new IllegalStateException("request == null".toString());
            }
            StringBuilder L = a.L("code < 0: ");
            L.append(this.code);
            throw new IllegalStateException(L.toString().toString());
        }

        @NotNull
        public Builder cacheResponse(@Nullable Response response) {
            checkSupportResponse("cacheResponse", response);
            this.cacheResponse = response;
            return this;
        }

        @NotNull
        public Builder code(int i) {
            this.code = i;
            return this;
        }

        @Nullable
        public final ResponseBody getBody$okhttp() {
            return this.body;
        }

        @Nullable
        public final Response getCacheResponse$okhttp() {
            return this.cacheResponse;
        }

        public final int getCode$okhttp() {
            return this.code;
        }

        @Nullable
        public final Exchange getExchange$okhttp() {
            return this.exchange;
        }

        @Nullable
        public final Handshake getHandshake$okhttp() {
            return this.handshake;
        }

        @NotNull
        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        @Nullable
        public final String getMessage$okhttp() {
            return this.message;
        }

        @Nullable
        public final Response getNetworkResponse$okhttp() {
            return this.networkResponse;
        }

        @Nullable
        public final Response getPriorResponse$okhttp() {
            return this.priorResponse;
        }

        @Nullable
        public final Protocol getProtocol$okhttp() {
            return this.protocol;
        }

        public final long getReceivedResponseAtMillis$okhttp() {
            return this.receivedResponseAtMillis;
        }

        @Nullable
        public final Request getRequest$okhttp() {
            return this.request;
        }

        public final long getSentRequestAtMillis$okhttp() {
            return this.sentRequestAtMillis;
        }

        @NotNull
        public Builder handshake(@Nullable Handshake handshake2) {
            this.handshake = handshake2;
            return this;
        }

        @NotNull
        public Builder header(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "value");
            this.headers.set(str, str2);
            return this;
        }

        @NotNull
        public Builder headers(@NotNull Headers headers2) {
            Intrinsics.checkNotNullParameter(headers2, "headers");
            this.headers = headers2.newBuilder();
            return this;
        }

        public final void initExchange$okhttp(@NotNull Exchange exchange2) {
            Intrinsics.checkNotNullParameter(exchange2, "deferredTrailers");
            this.exchange = exchange2;
        }

        @NotNull
        public Builder message(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
            return this;
        }

        @NotNull
        public Builder networkResponse(@Nullable Response response) {
            checkSupportResponse("networkResponse", response);
            this.networkResponse = response;
            return this;
        }

        @NotNull
        public Builder priorResponse(@Nullable Response response) {
            checkPriorResponse(response);
            this.priorResponse = response;
            return this;
        }

        @NotNull
        public Builder protocol(@NotNull Protocol protocol2) {
            Intrinsics.checkNotNullParameter(protocol2, "protocol");
            this.protocol = protocol2;
            return this;
        }

        @NotNull
        public Builder receivedResponseAtMillis(long j) {
            this.receivedResponseAtMillis = j;
            return this;
        }

        @NotNull
        public Builder removeHeader(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            this.headers.removeAll(str);
            return this;
        }

        @NotNull
        public Builder request(@NotNull Request request2) {
            Intrinsics.checkNotNullParameter(request2, "request");
            this.request = request2;
            return this;
        }

        @NotNull
        public Builder sentRequestAtMillis(long j) {
            this.sentRequestAtMillis = j;
            return this;
        }

        public final void setBody$okhttp(@Nullable ResponseBody responseBody) {
            this.body = responseBody;
        }

        public final void setCacheResponse$okhttp(@Nullable Response response) {
            this.cacheResponse = response;
        }

        public final void setCode$okhttp(int i) {
            this.code = i;
        }

        public final void setExchange$okhttp(@Nullable Exchange exchange2) {
            this.exchange = exchange2;
        }

        public final void setHandshake$okhttp(@Nullable Handshake handshake2) {
            this.handshake = handshake2;
        }

        public final void setHeaders$okhttp(@NotNull Headers.Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "<set-?>");
            this.headers = builder;
        }

        public final void setMessage$okhttp(@Nullable String str) {
            this.message = str;
        }

        public final void setNetworkResponse$okhttp(@Nullable Response response) {
            this.networkResponse = response;
        }

        public final void setPriorResponse$okhttp(@Nullable Response response) {
            this.priorResponse = response;
        }

        public final void setProtocol$okhttp(@Nullable Protocol protocol2) {
            this.protocol = protocol2;
        }

        public final void setReceivedResponseAtMillis$okhttp(long j) {
            this.receivedResponseAtMillis = j;
        }

        public final void setRequest$okhttp(@Nullable Request request2) {
            this.request = request2;
        }

        public final void setSentRequestAtMillis$okhttp(long j) {
            this.sentRequestAtMillis = j;
        }

        public Builder(@NotNull Response response) {
            Intrinsics.checkNotNullParameter(response, CommonKt.EXTRA_RESPONSE);
            this.code = -1;
            this.request = response.request();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.handshake = response.handshake();
            this.headers = response.headers().newBuilder();
            this.body = response.body();
            this.networkResponse = response.networkResponse();
            this.cacheResponse = response.cacheResponse();
            this.priorResponse = response.priorResponse();
            this.sentRequestAtMillis = response.sentRequestAtMillis();
            this.receivedResponseAtMillis = response.receivedResponseAtMillis();
            this.exchange = response.exchange();
        }
    }
}
