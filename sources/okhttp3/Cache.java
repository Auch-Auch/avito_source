package okhttp3;

import androidx.browser.trusted.sharing.ShareTarget;
import com.avito.android.profile_phones.analytics.event.PhoneActionStrings;
import com.avito.android.remote.model.payment.status.PaymentStateKt;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.common.net.HttpHeaders;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.Typography;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
import t6.n.y;
import t6.r.a.j;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010)\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0004ONPQB!\b\u0000\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010J\u001a\u00020I¢\u0006\u0004\bK\u0010LB\u0019\b\u0016\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010+\u001a\u00020(¢\u0006\u0004\bK\u0010MJ\u001d\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0018\u00010\u0003R\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u001dJ\r\u0010\u001f\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010\u001dJ\u0013\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 ¢\u0006\u0004\b\"\u0010#J\r\u0010%\u001a\u00020$¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00020$¢\u0006\u0004\b'\u0010&J\r\u0010)\u001a\u00020(¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020(¢\u0006\u0004\b+\u0010*J\u000f\u0010,\u001a\u00020\u0006H\u0016¢\u0006\u0004\b,\u0010\u001dJ\u000f\u0010-\u001a\u00020\u0006H\u0016¢\u0006\u0004\b-\u0010\u001dJ\u000f\u00101\u001a\u00020.H\u0007¢\u0006\u0004\b/\u00100J\u0017\u00106\u001a\u00020\u00062\u0006\u00103\u001a\u000202H\u0000¢\u0006\u0004\b4\u00105J\u000f\u00108\u001a\u00020\u0006H\u0000¢\u0006\u0004\b7\u0010\u001dJ\r\u00109\u001a\u00020$¢\u0006\u0004\b9\u0010&J\r\u0010:\u001a\u00020$¢\u0006\u0004\b:\u0010&J\r\u0010;\u001a\u00020$¢\u0006\u0004\b;\u0010&R\u0013\u00101\u001a\u00020.8G@\u0006¢\u0006\u0006\u001a\u0004\b1\u00100R\u0016\u0010;\u001a\u00020$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\"\u0010'\u001a\u00020$8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b'\u0010<\u001a\u0004\b=\u0010&\"\u0004\b>\u0010?R\u0013\u0010A\u001a\u00020@8F@\u0006¢\u0006\u0006\u001a\u0004\bA\u0010BR\"\u0010%\u001a\u00020$8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b%\u0010<\u001a\u0004\bC\u0010&\"\u0004\bD\u0010?R\u0016\u00109\u001a\u00020$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010<R\u0016\u0010:\u001a\u00020$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010<R\u001c\u0010E\u001a\u00020\u00048\u0000@\u0000X\u0004¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H¨\u0006R"}, d2 = {"Lokhttp3/Cache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "editor", "", "abortQuietly", "(Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "Lokhttp3/Request;", "request", "Lokhttp3/Response;", "get$okhttp", "(Lokhttp3/Request;)Lokhttp3/Response;", "get", CommonKt.EXTRA_RESPONSE, "Lokhttp3/internal/cache/CacheRequest;", "put$okhttp", "(Lokhttp3/Response;)Lokhttp3/internal/cache/CacheRequest;", "put", "remove$okhttp", "(Lokhttp3/Request;)V", ProductAction.ACTION_REMOVE, "cached", "network", "update$okhttp", "(Lokhttp3/Response;Lokhttp3/Response;)V", "update", "initialize", "()V", PhoneActionStrings.REMOVE, "evictAll", "", "", "urls", "()Ljava/util/Iterator;", "", "writeAbortCount", "()I", "writeSuccessCount", "", "size", "()J", SDKConstants.PARAM_CONTEXT_MAX_SIZE, "flush", "close", "Ljava/io/File;", "-deprecated_directory", "()Ljava/io/File;", "directory", "Lokhttp3/internal/cache/CacheStrategy;", "cacheStrategy", "trackResponse$okhttp", "(Lokhttp3/internal/cache/CacheStrategy;)V", "trackResponse", "trackConditionalCacheHit$okhttp", "trackConditionalCacheHit", "networkCount", "hitCount", "requestCount", "I", "getWriteSuccessCount$okhttp", "setWriteSuccessCount$okhttp", "(I)V", "", "isClosed", "()Z", "getWriteAbortCount$okhttp", "setWriteAbortCount$okhttp", "cache", "Lokhttp3/internal/cache/DiskLruCache;", "getCache$okhttp", "()Lokhttp3/internal/cache/DiskLruCache;", "Lokhttp3/internal/io/FileSystem;", "fileSystem", "<init>", "(Ljava/io/File;JLokhttp3/internal/io/FileSystem;)V", "(Ljava/io/File;J)V", "Companion", "CacheResponseBody", "Entry", "RealCacheRequest", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Cache implements Closeable, Flushable {
    public static final Companion Companion = new Companion(null);
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    @NotNull
    private final DiskLruCache cache;
    private int hitCount;
    private int networkCount;
    private int requestCount;
    private int writeAbortCount;
    private int writeSuccessCount;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B'\u0012\n\u0010\u000f\u001a\u00060\rR\u00020\u000e\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\fR\u001d\u0010\u000f\u001a\u00060\rR\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lokhttp3/Cache$CacheResponseBody;", "Lokhttp3/ResponseBody;", "Lokhttp3/MediaType;", "contentType", "()Lokhttp3/MediaType;", "", "contentLength", "()J", "Lokio/BufferedSource;", "source", "()Lokio/BufferedSource;", "", "Ljava/lang/String;", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "snapshot", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "getSnapshot", "()Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "bodySource", "Lokio/BufferedSource;", "<init>", "(Lokhttp3/internal/cache/DiskLruCache$Snapshot;Ljava/lang/String;Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class CacheResponseBody extends ResponseBody {
        private final BufferedSource bodySource;
        private final String contentLength;
        private final String contentType;
        @NotNull
        private final DiskLruCache.Snapshot snapshot;

        public CacheResponseBody(@NotNull DiskLruCache.Snapshot snapshot2, @Nullable String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(snapshot2, "snapshot");
            this.snapshot = snapshot2;
            this.contentType = str;
            this.contentLength = str2;
            Source source = snapshot2.getSource(1);
            this.bodySource = Okio.buffer(new ForwardingSource(this, source, source) { // from class: okhttp3.Cache.CacheResponseBody.1
                public final /* synthetic */ Source $source;
                public final /* synthetic */ CacheResponseBody this$0;

                {
                    this.this$0 = r1;
                    this.$source = r2;
                }

                @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    this.this$0.getSnapshot().close();
                    super.close();
                }
            });
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            String str = this.contentLength;
            if (str != null) {
                return Util.toLongOrDefault(str, -1);
            }
            return -1;
        }

        @Override // okhttp3.ResponseBody
        @Nullable
        public MediaType contentType() {
            String str = this.contentType;
            if (str != null) {
                return MediaType.Companion.parse(str);
            }
            return null;
        }

        @NotNull
        public final DiskLruCache.Snapshot getSnapshot() {
            return this.snapshot;
        }

        @Override // okhttp3.ResponseBody
        @NotNull
        public BufferedSource source() {
            return this.bodySource;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b%\u0010&J\u0019\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001d\u001a\u00020\u001a*\u00020\u0015¢\u0006\u0004\b\u001d\u0010\u001eJ\u0011\u0010\t\u001a\u00020\u0002*\u00020\u0015¢\u0006\u0004\b\t\u0010\u001fR\u0016\u0010 \u001a\u00020\u00118\u0002@\u0002XT¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u00118\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\"\u0010!R\u0016\u0010#\u001a\u00020\u00118\u0002@\u0002XT¢\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010$\u001a\u00020\u00118\u0002@\u0002XT¢\u0006\u0006\n\u0004\b$\u0010!¨\u0006'"}, d2 = {"Lokhttp3/Cache$Companion;", "", "Lokhttp3/Headers;", "", "", "varyFields", "(Lokhttp3/Headers;)Ljava/util/Set;", "requestHeaders", "responseHeaders", "varyHeaders", "(Lokhttp3/Headers;Lokhttp3/Headers;)Lokhttp3/Headers;", "Lokhttp3/HttpUrl;", "url", "key", "(Lokhttp3/HttpUrl;)Ljava/lang/String;", "Lokio/BufferedSource;", "source", "", "readInt$okhttp", "(Lokio/BufferedSource;)I", "readInt", "Lokhttp3/Response;", "cachedResponse", "cachedRequest", "Lokhttp3/Request;", "newRequest", "", "varyMatches", "(Lokhttp3/Response;Lokhttp3/Headers;Lokhttp3/Request;)Z", "hasVaryAll", "(Lokhttp3/Response;)Z", "(Lokhttp3/Response;)Lokhttp3/Headers;", "ENTRY_BODY", "I", "ENTRY_COUNT", "ENTRY_METADATA", "VERSION", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        private final Set<String> varyFields(Headers headers) {
            int size = headers.size();
            TreeSet treeSet = null;
            for (int i = 0; i < size; i++) {
                if (m.equals(HttpHeaders.VARY, headers.name(i), true)) {
                    String value = headers.value(i);
                    if (treeSet == null) {
                        treeSet = new TreeSet(m.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
                    }
                    for (String str : StringsKt__StringsKt.split$default((CharSequence) value, new char[]{','}, false, 0, 6, (Object) null)) {
                        Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
                        treeSet.add(StringsKt__StringsKt.trim(str).toString());
                    }
                }
            }
            return treeSet != null ? treeSet : y.emptySet();
        }

        public final boolean hasVaryAll(@NotNull Response response) {
            Intrinsics.checkNotNullParameter(response, "$this$hasVaryAll");
            return varyFields(response.headers()).contains("*");
        }

        @JvmStatic
        @NotNull
        public final String key(@NotNull HttpUrl httpUrl) {
            Intrinsics.checkNotNullParameter(httpUrl, "url");
            return ByteString.Companion.encodeUtf8(httpUrl.toString()).md5().hex();
        }

        public final int readInt$okhttp(@NotNull BufferedSource bufferedSource) throws IOException {
            Intrinsics.checkNotNullParameter(bufferedSource, "source");
            try {
                long readDecimalLong = bufferedSource.readDecimalLong();
                String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
                if (readDecimalLong >= 0 && readDecimalLong <= ((long) Integer.MAX_VALUE)) {
                    if (!(readUtf8LineStrict.length() > 0)) {
                        return (int) readDecimalLong;
                    }
                }
                throw new IOException("expected an int but was \"" + readDecimalLong + readUtf8LineStrict + Typography.quote);
            } catch (NumberFormatException e) {
                throw new IOException(e.getMessage());
            }
        }

        @NotNull
        public final Headers varyHeaders(@NotNull Response response) {
            Intrinsics.checkNotNullParameter(response, "$this$varyHeaders");
            Response networkResponse = response.networkResponse();
            Intrinsics.checkNotNull(networkResponse);
            return varyHeaders(networkResponse.request().headers(), response.headers());
        }

        public final boolean varyMatches(@NotNull Response response, @NotNull Headers headers, @NotNull Request request) {
            Intrinsics.checkNotNullParameter(response, "cachedResponse");
            Intrinsics.checkNotNullParameter(headers, "cachedRequest");
            Intrinsics.checkNotNullParameter(request, "newRequest");
            Set<String> varyFields = varyFields(response.headers());
            if ((varyFields instanceof Collection) && varyFields.isEmpty()) {
                return true;
            }
            for (T t : varyFields) {
                if (!Intrinsics.areEqual(headers.values(t), request.headers(t))) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }

        private final Headers varyHeaders(Headers headers, Headers headers2) {
            Set<String> varyFields = varyFields(headers2);
            if (varyFields.isEmpty()) {
                return Util.EMPTY_HEADERS;
            }
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                String name = headers.name(i);
                if (varyFields.contains(name)) {
                    builder.add(name, headers.value(i));
                }
            }
            return builder.build();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0011\u001a\u00060\u000fR\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0011\u001a\u00060\u000fR\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0014¨\u0006\u0017"}, d2 = {"Lokhttp3/Cache$RealCacheRequest;", "Lokhttp3/internal/cache/CacheRequest;", "", "abort", "()V", "Lokio/Sink;", SDKConstants.PARAM_A2U_BODY, "()Lokio/Sink;", "", PaymentStateKt.PAYMENT_STATE_DONE, "Z", "getDone", "()Z", "setDone", "(Z)V", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "editor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "cacheOut", "Lokio/Sink;", "<init>", "(Lokhttp3/Cache;Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class RealCacheRequest implements CacheRequest {
        private final Sink body;
        private final Sink cacheOut;
        private boolean done;
        private final DiskLruCache.Editor editor;
        public final /* synthetic */ Cache this$0;

        public RealCacheRequest(@NotNull Cache cache, DiskLruCache.Editor editor2) {
            Intrinsics.checkNotNullParameter(editor2, "editor");
            this.this$0 = cache;
            this.editor = editor2;
            Sink newSink = editor2.newSink(1);
            this.cacheOut = newSink;
            this.body = new ForwardingSink(this, newSink) { // from class: okhttp3.Cache.RealCacheRequest.1
                public final /* synthetic */ RealCacheRequest this$0;

                {
                    this.this$0 = r1;
                }

                @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    synchronized (this.this$0.this$0) {
                        if (!this.this$0.getDone()) {
                            this.this$0.setDone(true);
                            Cache cache2 = this.this$0.this$0;
                            cache2.setWriteSuccessCount$okhttp(cache2.getWriteSuccessCount$okhttp() + 1);
                            super.close();
                            this.this$0.editor.commit();
                        }
                    }
                }
            };
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public void abort() {
            synchronized (this.this$0) {
                if (!this.done) {
                    this.done = true;
                    Cache cache = this.this$0;
                    cache.setWriteAbortCount$okhttp(cache.getWriteAbortCount$okhttp() + 1);
                    Util.closeQuietly(this.cacheOut);
                    try {
                        this.editor.abort();
                    } catch (IOException unused) {
                    }
                }
            }
        }

        @Override // okhttp3.internal.cache.CacheRequest
        @NotNull
        public Sink body() {
            return this.body;
        }

        public final boolean getDone() {
            return this.done;
        }

        public final void setDone(boolean z) {
            this.done = z;
        }
    }

    public Cache(@NotNull File file, long j, @NotNull FileSystem fileSystem) {
        Intrinsics.checkNotNullParameter(file, "directory");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        this.cache = new DiskLruCache(fileSystem, file, VERSION, 2, j, TaskRunner.INSTANCE);
    }

    private final void abortQuietly(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException unused) {
            }
        }
    }

    @JvmStatic
    @NotNull
    public static final String key(@NotNull HttpUrl httpUrl) {
        return Companion.key(httpUrl);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "directory", imports = {}))
    @JvmName(name = "-deprecated_directory")
    @NotNull
    /* renamed from: -deprecated_directory  reason: not valid java name */
    public final File m553deprecated_directory() {
        return this.cache.getDirectory();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.cache.close();
    }

    public final void delete() throws IOException {
        this.cache.delete();
    }

    @JvmName(name = "directory")
    @NotNull
    public final File directory() {
        return this.cache.getDirectory();
    }

    public final void evictAll() throws IOException {
        this.cache.evictAll();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.cache.flush();
    }

    @Nullable
    public final Response get$okhttp(@NotNull Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        try {
            DiskLruCache.Snapshot snapshot = this.cache.get(Companion.key(request.url()));
            if (snapshot != null) {
                try {
                    Entry entry = new Entry(snapshot.getSource(0));
                    Response response = entry.response(snapshot);
                    if (entry.matches(request, response)) {
                        return response;
                    }
                    ResponseBody body = response.body();
                    if (body != null) {
                        Util.closeQuietly(body);
                    }
                    return null;
                } catch (IOException unused) {
                    Util.closeQuietly(snapshot);
                }
            }
        } catch (IOException unused2) {
        }
        return null;
    }

    @NotNull
    public final DiskLruCache getCache$okhttp() {
        return this.cache;
    }

    public final int getWriteAbortCount$okhttp() {
        return this.writeAbortCount;
    }

    public final int getWriteSuccessCount$okhttp() {
        return this.writeSuccessCount;
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final void initialize() throws IOException {
        this.cache.initialize();
    }

    public final boolean isClosed() {
        return this.cache.isClosed();
    }

    public final long maxSize() {
        return this.cache.getMaxSize();
    }

    public final synchronized int networkCount() {
        return this.networkCount;
    }

    @Nullable
    public final CacheRequest put$okhttp(@NotNull Response response) {
        DiskLruCache.Editor editor;
        Intrinsics.checkNotNullParameter(response, CommonKt.EXTRA_RESPONSE);
        String method = response.request().method();
        if (HttpMethod.INSTANCE.invalidatesCache(response.request().method())) {
            try {
                remove$okhttp(response.request());
            } catch (IOException unused) {
            }
            return null;
        } else if (!Intrinsics.areEqual(method, ShareTarget.METHOD_GET)) {
            return null;
        } else {
            Companion companion = Companion;
            if (companion.hasVaryAll(response)) {
                return null;
            }
            Entry entry = new Entry(response);
            try {
                editor = DiskLruCache.edit$default(this.cache, companion.key(response.request().url()), 0, 2, null);
                if (editor == null) {
                    return null;
                }
                try {
                    entry.writeTo(editor);
                    return new RealCacheRequest(this, editor);
                } catch (IOException unused2) {
                    abortQuietly(editor);
                    return null;
                }
            } catch (IOException unused3) {
                editor = null;
                abortQuietly(editor);
                return null;
            }
        }
    }

    public final void remove$okhttp(@NotNull Request request) throws IOException {
        Intrinsics.checkNotNullParameter(request, "request");
        this.cache.remove(Companion.key(request.url()));
    }

    public final synchronized int requestCount() {
        return this.requestCount;
    }

    public final void setWriteAbortCount$okhttp(int i) {
        this.writeAbortCount = i;
    }

    public final void setWriteSuccessCount$okhttp(int i) {
        this.writeSuccessCount = i;
    }

    public final long size() throws IOException {
        return this.cache.size();
    }

    public final synchronized void trackConditionalCacheHit$okhttp() {
        this.hitCount++;
    }

    public final synchronized void trackResponse$okhttp(@NotNull CacheStrategy cacheStrategy) {
        Intrinsics.checkNotNullParameter(cacheStrategy, "cacheStrategy");
        this.requestCount++;
        if (cacheStrategy.getNetworkRequest() != null) {
            this.networkCount++;
        } else if (cacheStrategy.getCacheResponse() != null) {
            this.hitCount++;
        }
    }

    public final void update$okhttp(@NotNull Response response, @NotNull Response response2) {
        Intrinsics.checkNotNullParameter(response, "cached");
        Intrinsics.checkNotNullParameter(response2, "network");
        Entry entry = new Entry(response2);
        ResponseBody body = response.body();
        Objects.requireNonNull(body, "null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody");
        try {
            DiskLruCache.Editor edit = ((CacheResponseBody) body).getSnapshot().edit();
            if (edit != null) {
                entry.writeTo(edit);
                edit.commit();
            }
        } catch (IOException unused) {
            abortQuietly(null);
        }
    }

    @NotNull
    public final Iterator<String> urls() throws IOException {
        return new Object(this) { // from class: okhttp3.Cache$urls$1
            private boolean canRemove;
            private final Iterator<DiskLruCache.Snapshot> delegate;
            private String nextUrl;
            public final /* synthetic */ Cache this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
                this.delegate = r1.getCache$okhttp().snapshots();
            }

            /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
                r4 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:17:0x0032, code lost:
                kotlin.io.CloseableKt.closeFinally(r2, r3);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
                throw r4;
             */
            @Override // java.util.Iterator
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean hasNext() {
                /*
                    r5 = this;
                    java.lang.String r0 = r5.nextUrl
                    r1 = 1
                    if (r0 == 0) goto L_0x0006
                    return r1
                L_0x0006:
                    r0 = 0
                    r5.canRemove = r0
                L_0x0009:
                    java.util.Iterator<okhttp3.internal.cache.DiskLruCache$Snapshot> r2 = r5.delegate
                    boolean r2 = r2.hasNext()
                    if (r2 == 0) goto L_0x0038
                    java.util.Iterator<okhttp3.internal.cache.DiskLruCache$Snapshot> r2 = r5.delegate     // Catch:{ IOException -> 0x0036 }
                    java.lang.Object r2 = r2.next()     // Catch:{ IOException -> 0x0036 }
                    java.io.Closeable r2 = (java.io.Closeable) r2     // Catch:{ IOException -> 0x0036 }
                    r3 = 0
                    r4 = r2
                    okhttp3.internal.cache.DiskLruCache$Snapshot r4 = (okhttp3.internal.cache.DiskLruCache.Snapshot) r4     // Catch:{ all -> 0x002f }
                    okio.Source r4 = r4.getSource(r0)     // Catch:{ all -> 0x002f }
                    okio.BufferedSource r4 = okio.Okio.buffer(r4)     // Catch:{ all -> 0x002f }
                    java.lang.String r4 = r4.readUtf8LineStrict()     // Catch:{ all -> 0x002f }
                    r5.nextUrl = r4     // Catch:{ all -> 0x002f }
                    kotlin.io.CloseableKt.closeFinally(r2, r3)
                    return r1
                L_0x002f:
                    r3 = move-exception
                    throw r3     // Catch:{ all -> 0x0031 }
                L_0x0031:
                    r4 = move-exception
                    kotlin.io.CloseableKt.closeFinally(r2, r3)
                    throw r4
                L_0x0036:
                    goto L_0x0009
                L_0x0038:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cache$urls$1.hasNext():boolean");
            }

            @Override // java.util.Iterator
            public void remove() {
                if (this.canRemove) {
                    this.delegate.remove();
                    return;
                }
                throw new IllegalStateException("remove() before next()".toString());
            }

            @Override // java.util.Iterator
            @NotNull
            public String next() {
                if (hasNext()) {
                    String str = this.nextUrl;
                    Intrinsics.checkNotNull(str);
                    this.nextUrl = null;
                    this.canRemove = true;
                    return str;
                }
                throw new NoSuchElementException();
            }
        };
    }

    public final synchronized int writeAbortCount() {
        return this.writeAbortCount;
    }

    public final synchronized int writeSuccessCount() {
        return this.writeSuccessCount;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Cache(@NotNull File file, long j) {
        this(file, j, FileSystem.SYSTEM);
        Intrinsics.checkNotNullParameter(file, "directory");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000 :2\u00020\u0001:\u0001:B\u0011\b\u0016\u0012\u0006\u00106\u001a\u000205¢\u0006\u0004\b7\u00108B\u0011\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b7\u00109J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0011\u001a\u00020\u000b2\n\u0010\u0010\u001a\u00060\u000eR\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u0016\u001a\u00020\u00152\n\u0010\u001b\u001a\u00060\u001aR\u00020\u000f¢\u0006\u0004\b\u0016\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u00178B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010\u001fR\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010$R\u0016\u00100\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u0010$R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00103¨\u0006;"}, d2 = {"Lokhttp3/Cache$Entry;", "", "Lokio/BufferedSource;", "source", "", "Ljava/security/cert/Certificate;", "readCertificateList", "(Lokio/BufferedSource;)Ljava/util/List;", "Lokio/BufferedSink;", "sink", "certificates", "", "writeCertList", "(Lokio/BufferedSink;Ljava/util/List;)V", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "editor", "writeTo", "(Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "Lokhttp3/Request;", "request", "Lokhttp3/Response;", CommonKt.EXTRA_RESPONSE, "", "matches", "(Lokhttp3/Request;Lokhttp3/Response;)Z", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "snapshot", "(Lokhttp3/internal/cache/DiskLruCache$Snapshot;)Lokhttp3/Response;", "Lokhttp3/Headers;", "varyHeaders", "Lokhttp3/Headers;", "isHttps", "()Z", "", "message", "Ljava/lang/String;", "Lokhttp3/Handshake;", "handshake", "Lokhttp3/Handshake;", "responseHeaders", "", "code", "I", "Lokhttp3/Protocol;", "protocol", "Lokhttp3/Protocol;", "requestMethod", "url", "", "receivedResponseMillis", "J", "sentRequestMillis", "Lokio/Source;", "rawSource", "<init>", "(Lokio/Source;)V", "(Lokhttp3/Response;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Entry {
        public static final Companion Companion = new Companion(null);
        private static final String RECEIVED_MILLIS;
        private static final String SENT_MILLIS;
        private final int code;
        private final Handshake handshake;
        private final String message;
        private final Protocol protocol;
        private final long receivedResponseMillis;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final long sentRequestMillis;
        private final String url;
        private final Headers varyHeaders;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lokhttp3/Cache$Entry$Companion;", "", "", "RECEIVED_MILLIS", "Ljava/lang/String;", "SENT_MILLIS", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        static {
            StringBuilder sb = new StringBuilder();
            Platform.Companion companion = Platform.Companion;
            sb.append(companion.get().getPrefix());
            sb.append("-Sent-Millis");
            SENT_MILLIS = sb.toString();
            RECEIVED_MILLIS = companion.get().getPrefix() + "-Received-Millis";
        }

        public Entry(@NotNull Source source) throws IOException {
            TlsVersion tlsVersion;
            Intrinsics.checkNotNullParameter(source, "rawSource");
            try {
                BufferedSource buffer = Okio.buffer(source);
                this.url = buffer.readUtf8LineStrict();
                this.requestMethod = buffer.readUtf8LineStrict();
                Headers.Builder builder = new Headers.Builder();
                int readInt$okhttp = Cache.Companion.readInt$okhttp(buffer);
                boolean z = false;
                for (int i = 0; i < readInt$okhttp; i++) {
                    builder.addLenient$okhttp(buffer.readUtf8LineStrict());
                }
                this.varyHeaders = builder.build();
                StatusLine parse = StatusLine.Companion.parse(buffer.readUtf8LineStrict());
                this.protocol = parse.protocol;
                this.code = parse.code;
                this.message = parse.message;
                Headers.Builder builder2 = new Headers.Builder();
                int readInt$okhttp2 = Cache.Companion.readInt$okhttp(buffer);
                for (int i2 = 0; i2 < readInt$okhttp2; i2++) {
                    builder2.addLenient$okhttp(buffer.readUtf8LineStrict());
                }
                String str = SENT_MILLIS;
                String str2 = builder2.get(str);
                String str3 = RECEIVED_MILLIS;
                String str4 = builder2.get(str3);
                builder2.removeAll(str);
                builder2.removeAll(str3);
                long j = 0;
                this.sentRequestMillis = str2 != null ? Long.parseLong(str2) : 0;
                this.receivedResponseMillis = str4 != null ? Long.parseLong(str4) : j;
                this.responseHeaders = builder2.build();
                if (isHttps()) {
                    String readUtf8LineStrict = buffer.readUtf8LineStrict();
                    if (!(readUtf8LineStrict.length() > 0 ? true : z)) {
                        CipherSuite forJavaName = CipherSuite.Companion.forJavaName(buffer.readUtf8LineStrict());
                        List<Certificate> readCertificateList = readCertificateList(buffer);
                        List<Certificate> readCertificateList2 = readCertificateList(buffer);
                        if (!buffer.exhausted()) {
                            tlsVersion = TlsVersion.Companion.forJavaName(buffer.readUtf8LineStrict());
                        } else {
                            tlsVersion = TlsVersion.SSL_3_0;
                        }
                        this.handshake = Handshake.Companion.get(tlsVersion, forJavaName, readCertificateList, readCertificateList2);
                    } else {
                        throw new IOException("expected \"\" but was \"" + readUtf8LineStrict + Typography.quote);
                    }
                } else {
                    this.handshake = null;
                }
            } finally {
                source.close();
            }
        }

        private final boolean isHttps() {
            return m.startsWith$default(this.url, "https://", false, 2, null);
        }

        private final List<Certificate> readCertificateList(BufferedSource bufferedSource) throws IOException {
            int readInt$okhttp = Cache.Companion.readInt$okhttp(bufferedSource);
            if (readInt$okhttp == -1) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(readInt$okhttp);
                for (int i = 0; i < readInt$okhttp; i++) {
                    String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
                    Buffer buffer = new Buffer();
                    ByteString decodeBase64 = ByteString.Companion.decodeBase64(readUtf8LineStrict);
                    Intrinsics.checkNotNull(decodeBase64);
                    buffer.write(decodeBase64);
                    arrayList.add(instance.generateCertificate(buffer.inputStream()));
                }
                return arrayList;
            } catch (CertificateException e) {
                throw new IOException(e.getMessage());
            }
        }

        private final void writeCertList(BufferedSink bufferedSink, List<? extends Certificate> list) throws IOException {
            try {
                bufferedSink.writeDecimalLong((long) list.size()).writeByte(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    byte[] encoded = ((Certificate) list.get(i)).getEncoded();
                    ByteString.Companion companion = ByteString.Companion;
                    Intrinsics.checkNotNullExpressionValue(encoded, "bytes");
                    bufferedSink.writeUtf8(ByteString.Companion.of$default(companion, encoded, 0, 0, 3, null).base64()).writeByte(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        public final boolean matches(@NotNull Request request, @NotNull Response response) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(response, CommonKt.EXTRA_RESPONSE);
            return Intrinsics.areEqual(this.url, request.url().toString()) && Intrinsics.areEqual(this.requestMethod, request.method()) && Cache.Companion.varyMatches(response, this.varyHeaders, request);
        }

        @NotNull
        public final Response response(@NotNull DiskLruCache.Snapshot snapshot) {
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            String str = this.responseHeaders.get("Content-Type");
            String str2 = this.responseHeaders.get(HttpHeaders.CONTENT_LENGTH);
            return new Response.Builder().request(new Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build()).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(snapshot, str, str2)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0114, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0115, code lost:
            kotlin.io.CloseableKt.closeFinally(r8, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0118, code lost:
            throw r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void writeTo(@org.jetbrains.annotations.NotNull okhttp3.internal.cache.DiskLruCache.Editor r8) throws java.io.IOException {
            /*
                r7 = this;
                java.lang.String r0 = "editor"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                r0 = 0
                okio.Sink r8 = r8.newSink(r0)
                okio.BufferedSink r8 = okio.Okio.buffer(r8)
                java.lang.String r1 = r7.url     // Catch:{ all -> 0x0112 }
                okio.BufferedSink r1 = r8.writeUtf8(r1)     // Catch:{ all -> 0x0112 }
                r2 = 10
                r1.writeByte(r2)     // Catch:{ all -> 0x0112 }
                java.lang.String r1 = r7.requestMethod     // Catch:{ all -> 0x0112 }
                okio.BufferedSink r1 = r8.writeUtf8(r1)     // Catch:{ all -> 0x0112 }
                r1.writeByte(r2)     // Catch:{ all -> 0x0112 }
                okhttp3.Headers r1 = r7.varyHeaders     // Catch:{ all -> 0x0112 }
                int r1 = r1.size()     // Catch:{ all -> 0x0112 }
                long r3 = (long) r1     // Catch:{ all -> 0x0112 }
                okio.BufferedSink r1 = r8.writeDecimalLong(r3)     // Catch:{ all -> 0x0112 }
                r1.writeByte(r2)     // Catch:{ all -> 0x0112 }
                okhttp3.Headers r1 = r7.varyHeaders     // Catch:{ all -> 0x0112 }
                int r1 = r1.size()     // Catch:{ all -> 0x0112 }
                r3 = 0
            L_0x0037:
                java.lang.String r4 = ": "
                if (r3 >= r1) goto L_0x0059
                okhttp3.Headers r5 = r7.varyHeaders
                java.lang.String r5 = r5.name(r3)
                okio.BufferedSink r5 = r8.writeUtf8(r5)
                okio.BufferedSink r4 = r5.writeUtf8(r4)
                okhttp3.Headers r5 = r7.varyHeaders
                java.lang.String r5 = r5.value(r3)
                okio.BufferedSink r4 = r4.writeUtf8(r5)
                r4.writeByte(r2)
                int r3 = r3 + 1
                goto L_0x0037
            L_0x0059:
                okhttp3.internal.http.StatusLine r1 = new okhttp3.internal.http.StatusLine
                okhttp3.Protocol r3 = r7.protocol
                int r5 = r7.code
                java.lang.String r6 = r7.message
                r1.<init>(r3, r5, r6)
                java.lang.String r1 = r1.toString()
                okio.BufferedSink r1 = r8.writeUtf8(r1)
                r1.writeByte(r2)
                okhttp3.Headers r1 = r7.responseHeaders
                int r1 = r1.size()
                int r1 = r1 + 2
                long r5 = (long) r1
                okio.BufferedSink r1 = r8.writeDecimalLong(r5)
                r1.writeByte(r2)
                okhttp3.Headers r1 = r7.responseHeaders
                int r1 = r1.size()
            L_0x0085:
                if (r0 >= r1) goto L_0x00a5
                okhttp3.Headers r3 = r7.responseHeaders
                java.lang.String r3 = r3.name(r0)
                okio.BufferedSink r3 = r8.writeUtf8(r3)
                okio.BufferedSink r3 = r3.writeUtf8(r4)
                okhttp3.Headers r5 = r7.responseHeaders
                java.lang.String r5 = r5.value(r0)
                okio.BufferedSink r3 = r3.writeUtf8(r5)
                r3.writeByte(r2)
                int r0 = r0 + 1
                goto L_0x0085
            L_0x00a5:
                java.lang.String r0 = okhttp3.Cache.Entry.SENT_MILLIS
                okio.BufferedSink r0 = r8.writeUtf8(r0)
                okio.BufferedSink r0 = r0.writeUtf8(r4)
                long r5 = r7.sentRequestMillis
                okio.BufferedSink r0 = r0.writeDecimalLong(r5)
                r0.writeByte(r2)
                java.lang.String r0 = okhttp3.Cache.Entry.RECEIVED_MILLIS
                okio.BufferedSink r0 = r8.writeUtf8(r0)
                okio.BufferedSink r0 = r0.writeUtf8(r4)
                long r3 = r7.receivedResponseMillis
                okio.BufferedSink r0 = r0.writeDecimalLong(r3)
                r0.writeByte(r2)
                boolean r0 = r7.isHttps()
                if (r0 == 0) goto L_0x010b
                r8.writeByte(r2)
                okhttp3.Handshake r0 = r7.handshake
                kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                okhttp3.CipherSuite r0 = r0.cipherSuite()
                java.lang.String r0 = r0.javaName()
                okio.BufferedSink r0 = r8.writeUtf8(r0)
                r0.writeByte(r2)
                okhttp3.Handshake r0 = r7.handshake
                java.util.List r0 = r0.peerCertificates()
                r7.writeCertList(r8, r0)
                okhttp3.Handshake r0 = r7.handshake
                java.util.List r0 = r0.localCertificates()
                r7.writeCertList(r8, r0)
                okhttp3.Handshake r0 = r7.handshake
                okhttp3.TlsVersion r0 = r0.tlsVersion()
                java.lang.String r0 = r0.javaName()
                okio.BufferedSink r0 = r8.writeUtf8(r0)
                r0.writeByte(r2)
            L_0x010b:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                r0 = 0
                kotlin.io.CloseableKt.closeFinally(r8, r0)
                return
            L_0x0112:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x0114 }
            L_0x0114:
                r1 = move-exception
                kotlin.io.CloseableKt.closeFinally(r8, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cache.Entry.writeTo(okhttp3.internal.cache.DiskLruCache$Editor):void");
        }

        public Entry(@NotNull Response response) {
            Intrinsics.checkNotNullParameter(response, CommonKt.EXTRA_RESPONSE);
            this.url = response.request().url().toString();
            this.varyHeaders = Cache.Companion.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
            this.sentRequestMillis = response.sentRequestAtMillis();
            this.receivedResponseMillis = response.receivedResponseAtMillis();
        }
    }
}
