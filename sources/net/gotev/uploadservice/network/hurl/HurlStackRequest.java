package net.gotev.uploadservice.network.hurl;

import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.HttpsURLConnection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import net.gotev.uploadservice.data.NameValue;
import net.gotev.uploadservice.logger.UploadServiceLogger;
import net.gotev.uploadservice.network.HttpRequest;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010 \u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010'\u001a\u00020\u0017\u0012\u0006\u0010(\u001a\u00020\u0017\u0012\u0006\u0010)\u001a\u00020\t\u0012\u0006\u0010*\u001a\u00020\t\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010-\u001a\u00020+¢\u0006\u0004\b.\u0010/J\u001d\u0010\u0005\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0019R\u0016\u0010\"\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0019R2\u0010&\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170#j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017`$8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010%¨\u00060"}, d2 = {"Lnet/gotev/uploadservice/network/hurl/HurlStackRequest;", "Lnet/gotev/uploadservice/network/HttpRequest;", "", "Lnet/gotev/uploadservice/data/NameValue;", "requestHeaders", "setHeaders", "(Ljava/util/List;)Lnet/gotev/uploadservice/network/HttpRequest;", "", "totalBodyBytes", "", "isFixedLengthStreamingMode", "setTotalBodyBytes", "(JZ)Lnet/gotev/uploadservice/network/HttpRequest;", "Lnet/gotev/uploadservice/network/HttpRequest$RequestBodyDelegate;", "delegate", "Lnet/gotev/uploadservice/network/BodyWriter$OnStreamWriteListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lnet/gotev/uploadservice/network/ServerResponse;", "getResponse", "(Lnet/gotev/uploadservice/network/HttpRequest$RequestBodyDelegate;Lnet/gotev/uploadservice/network/BodyWriter$OnStreamWriteListener;)Lnet/gotev/uploadservice/network/ServerResponse;", "", "close", "()V", "", "d", "Ljava/lang/String;", "uploadId", "Ljava/net/HttpURLConnection;", AuthSource.SEND_ABUSE, "Ljava/net/HttpURLConnection;", "connection", "c", "userAgent", AuthSource.BOOKING_ORDER, "uuid", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "()Ljava/util/LinkedHashMap;", "responseHeaders", "method", "url", "followRedirects", "useCaches", "", "connectTimeoutMillis", "readTimeoutMillis", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZII)V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public final class HurlStackRequest implements HttpRequest {
    public final HttpURLConnection a;
    public final String b = a2.b.a.a.a.I2("UUID.randomUUID().toString()");
    public final String c;
    public final String d;

    public static final class a extends Lambda implements Function0<String> {
        public final /* synthetic */ HurlStackRequest a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(HurlStackRequest hurlStackRequest) {
            super(0);
            this.a = hurlStackRequest;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public String invoke() {
            StringBuilder L = a2.b.a.a.a.L("creating new HttpURLConnection (uuid: ");
            L.append(this.a.b);
            L.append(')');
            return L.toString();
        }
    }

    public static final class b extends Lambda implements Function0<String> {
        public final /* synthetic */ HurlStackRequest a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(HurlStackRequest hurlStackRequest) {
            super(0);
            this.a = hurlStackRequest;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public String invoke() {
            StringBuilder L = a2.b.a.a.a.L("closing HttpURLConnection (uuid: ");
            L.append(this.a.b);
            L.append(')');
            return L.toString();
        }
    }

    public HurlStackRequest(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z, boolean z2, int i, int i2) {
        HttpURLConnection httpURLConnection;
        a2.b.a.a.a.b1(str, "userAgent", str2, "uploadId", str3, "method", str4, "url");
        this.c = str;
        this.d = str2;
        String simpleName = HurlStackRequest.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        UploadServiceLogger.debug(simpleName, str2, new a(this));
        Objects.requireNonNull(str4, "null cannot be cast to non-null type kotlin.CharSequence");
        URL url = new URL(StringsKt__StringsKt.trim(str4).toString());
        if (m.equals("https", url.getProtocol(), true)) {
            URLConnection openConnection = url.openConnection();
            Objects.requireNonNull(openConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
            httpURLConnection = (HttpsURLConnection) openConnection;
        } else {
            URLConnection openConnection2 = url.openConnection();
            Objects.requireNonNull(openConnection2, "null cannot be cast to non-null type java.net.HttpURLConnection");
            httpURLConnection = (HttpURLConnection) openConnection2;
        }
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setConnectTimeout(i);
        httpURLConnection.setReadTimeout(i2);
        httpURLConnection.setUseCaches(z2);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setRequestMethod(str3);
        this.a = httpURLConnection;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.LinkedHashMap<java.lang.String, java.lang.String> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0049, code lost:
        if ((!((java.util.Collection) r5).isEmpty()) != false) goto L_0x004d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.LinkedHashMap<java.lang.String, java.lang.String> a() throws java.io.IOException {
        /*
            r8 = this;
            java.net.HttpURLConnection r0 = r8.a
            java.util.Map r0 = r0.getHeaderFields()
            r1 = 0
            if (r0 == 0) goto L_0x0089
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            int r3 = r0.size()
            r2.<init>(r3)
            java.util.Set r0 = r0.entrySet()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x001f:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0053
            java.lang.Object r4 = r0.next()
            r5 = r4
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r6 = r5.getKey()
            r7 = 1
            if (r6 == 0) goto L_0x004c
            java.lang.Object r6 = r5.getValue()
            if (r6 == 0) goto L_0x004c
            java.lang.Object r5 = r5.getValue()
            java.lang.String r6 = "it.value"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            r5 = r5 ^ r7
            if (r5 == 0) goto L_0x004c
            goto L_0x004d
        L_0x004c:
            r7 = 0
        L_0x004d:
            if (r7 == 0) goto L_0x001f
            r3.add(r4)
            goto L_0x001f
        L_0x0053:
            java.util.Iterator r0 = r3.iterator()
        L_0x0057:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0088
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r3 = r1.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r1 = r1.getValue()
            java.util.List r1 = (java.util.List) r1
            java.lang.String r4 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            java.lang.String r4 = "values"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            java.lang.Object r1 = kotlin.collections.CollectionsKt___CollectionsKt.first(r1)
            java.lang.String r4 = "values.first()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            r2.put(r3, r1)
            goto L_0x0057
        L_0x0088:
            return r2
        L_0x0089:
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.gotev.uploadservice.network.hurl.HurlStackRequest.a():java.util.LinkedHashMap");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        String simpleName = HurlStackRequest.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        UploadServiceLogger.debug(simpleName, this.d, new b(this));
        try {
            this.a.getInputStream().close();
        } catch (Throwable unused) {
        }
        try {
            this.a.getOutputStream().flush();
        } catch (Throwable unused2) {
        }
        try {
            this.a.getOutputStream().close();
        } catch (Throwable unused3) {
        }
        try {
            this.a.disconnect();
        } catch (Throwable unused4) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005a, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005b, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005e, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0061, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0062, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0065, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0069, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006c, code lost:
        throw r5;
     */
    @Override // net.gotev.uploadservice.network.HttpRequest
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public net.gotev.uploadservice.network.ServerResponse getResponse(@org.jetbrains.annotations.NotNull net.gotev.uploadservice.network.HttpRequest.RequestBodyDelegate r4, @org.jetbrains.annotations.NotNull net.gotev.uploadservice.network.BodyWriter.OnStreamWriteListener r5) throws java.io.IOException {
        /*
            r3 = this;
            java.lang.String r0 = "delegate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "listener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            net.gotev.uploadservice.network.hurl.HurlBodyWriter r0 = new net.gotev.uploadservice.network.hurl.HurlBodyWriter     // Catch:{ all -> 0x0066 }
            java.net.HttpURLConnection r1 = r3.a     // Catch:{ all -> 0x0066 }
            java.io.OutputStream r1 = r1.getOutputStream()     // Catch:{ all -> 0x0066 }
            java.lang.String r2 = "connection.outputStream"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ all -> 0x0066 }
            r0.<init>(r1, r5)     // Catch:{ all -> 0x0066 }
            r4.onWriteRequestBody(r0)     // Catch:{ all -> 0x005f }
            r4 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r4)
            net.gotev.uploadservice.network.ServerResponse r5 = new net.gotev.uploadservice.network.ServerResponse
            java.net.HttpURLConnection r0 = r3.a
            int r0 = r0.getResponseCode()
            java.net.HttpURLConnection r1 = r3.a
            int r1 = r1.getResponseCode()
            int r1 = r1 / 100
            r2 = 2
            if (r1 != r2) goto L_0x003b
            java.net.HttpURLConnection r1 = r3.a
            java.io.InputStream r1 = r1.getInputStream()
            goto L_0x0041
        L_0x003b:
            java.net.HttpURLConnection r1 = r3.a
            java.io.InputStream r1 = r1.getErrorStream()
        L_0x0041:
            java.lang.String r2 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ all -> 0x0058 }
            byte[] r2 = kotlin.io.ByteStreamsKt.readBytes(r1)     // Catch:{ all -> 0x0058 }
            kotlin.io.CloseableKt.closeFinally(r1, r4)
            java.util.LinkedHashMap r1 = r3.a()
            r5.<init>(r0, r2, r1)
            kotlin.io.CloseableKt.closeFinally(r3, r4)
            return r5
        L_0x0058:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x005a }
        L_0x005a:
            r5 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r4)
            throw r5
        L_0x005f:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0061 }
        L_0x0061:
            r5 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r4)
            throw r5
        L_0x0066:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0068 }
        L_0x0068:
            r5 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.gotev.uploadservice.network.hurl.HurlStackRequest.getResponse(net.gotev.uploadservice.network.HttpRequest$RequestBodyDelegate, net.gotev.uploadservice.network.BodyWriter$OnStreamWriteListener):net.gotev.uploadservice.network.ServerResponse");
    }

    @Override // net.gotev.uploadservice.network.HttpRequest
    @NotNull
    public HttpRequest setHeaders(@NotNull List<NameValue> list) throws IOException {
        Intrinsics.checkNotNullParameter(list, "requestHeaders");
        this.a.setRequestProperty("User-Agent", this.c);
        for (NameValue nameValue : list) {
            HttpURLConnection httpURLConnection = this.a;
            String name = nameValue.getName();
            Objects.requireNonNull(name, "null cannot be cast to non-null type kotlin.CharSequence");
            String obj = StringsKt__StringsKt.trim(name).toString();
            String value = nameValue.getValue();
            Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.CharSequence");
            httpURLConnection.setRequestProperty(obj, StringsKt__StringsKt.trim(value).toString());
        }
        return this;
    }

    @Override // net.gotev.uploadservice.network.HttpRequest
    @NotNull
    public HttpRequest setTotalBodyBytes(long j, boolean z) {
        HttpURLConnection httpURLConnection = this.a;
        if (z) {
            httpURLConnection.setFixedLengthStreamingMode(j);
        } else {
            httpURLConnection.setChunkedStreamingMode(0);
        }
        return this;
    }
}
