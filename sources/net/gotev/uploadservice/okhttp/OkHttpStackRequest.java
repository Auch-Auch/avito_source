package net.gotev.uploadservice.okhttp;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import net.gotev.uploadservice.data.NameValue;
import net.gotev.uploadservice.logger.UploadServiceLogger;
import net.gotev.uploadservice.network.HttpRequest;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010-\u001a\u00020\u001f\u0012\u0006\u0010.\u001a\u00020\u001f¢\u0006\u0004\b/\u00100J\u001d\u0010\u0005\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010!¨\u00061"}, d2 = {"Lnet/gotev/uploadservice/okhttp/OkHttpStackRequest;", "Lnet/gotev/uploadservice/network/HttpRequest;", "", "Lnet/gotev/uploadservice/data/NameValue;", "requestHeaders", "setHeaders", "(Ljava/util/List;)Lnet/gotev/uploadservice/network/HttpRequest;", "", "totalBodyBytes", "", "isFixedLengthStreamingMode", "setTotalBodyBytes", "(JZ)Lnet/gotev/uploadservice/network/HttpRequest;", "Lnet/gotev/uploadservice/network/HttpRequest$RequestBodyDelegate;", "delegate", "Lnet/gotev/uploadservice/network/BodyWriter$OnStreamWriteListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lnet/gotev/uploadservice/network/ServerResponse;", "getResponse", "(Lnet/gotev/uploadservice/network/HttpRequest$RequestBodyDelegate;Lnet/gotev/uploadservice/network/BodyWriter$OnStreamWriteListener;)Lnet/gotev/uploadservice/network/ServerResponse;", "", "close", "()V", "Lokhttp3/MediaType;", "c", "Lokhttp3/MediaType;", "contentType", "Lokhttp3/Request$Builder;", AuthSource.SEND_ABUSE, "Lokhttp3/Request$Builder;", "requestBuilder", "", "e", "Ljava/lang/String;", "uploadId", "d", "uuid", "Lokhttp3/OkHttpClient;", "f", "Lokhttp3/OkHttpClient;", "httpClient", AuthSource.BOOKING_ORDER, "J", "bodyLength", g.a, "httpMethod", "url", "<init>", "(Ljava/lang/String;Lokhttp3/OkHttpClient;Ljava/lang/String;Ljava/lang/String;)V", "uploadservice-okhttp_release"}, k = 1, mv = {1, 4, 0})
public final class OkHttpStackRequest implements HttpRequest {
    public final Request.Builder a;
    public long b;
    public MediaType c;
    public final String d = a2.b.a.a.a.I2("UUID.randomUUID().toString()");
    public final String e;
    public final OkHttpClient f;
    public final String g;

    public static final class a extends Lambda implements Function0<String> {
        public final /* synthetic */ OkHttpStackRequest a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(OkHttpStackRequest okHttpStackRequest) {
            super(0);
            this.a = okHttpStackRequest;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public String invoke() {
            StringBuilder L = a2.b.a.a.a.L("creating new OkHttp connection (uuid: ");
            L.append(this.a.d);
            L.append(')');
            return L.toString();
        }
    }

    public static final class b extends Lambda implements Function0<String> {
        public final /* synthetic */ OkHttpStackRequest a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(OkHttpStackRequest okHttpStackRequest) {
            super(0);
            this.a = okHttpStackRequest;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public String invoke() {
            StringBuilder L = a2.b.a.a.a.L("closing OkHttp connection (uuid: ");
            L.append(this.a.d);
            L.append(')');
            return L.toString();
        }
    }

    public OkHttpStackRequest(@NotNull String str, @NotNull OkHttpClient okHttpClient, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "uploadId");
        Intrinsics.checkNotNullParameter(okHttpClient, "httpClient");
        Intrinsics.checkNotNullParameter(str2, "httpMethod");
        Intrinsics.checkNotNullParameter(str3, "url");
        this.e = str;
        this.f = okHttpClient;
        this.g = str2;
        this.a = new Request.Builder().url(new URL(str3));
        String simpleName = OkHttpStackRequest.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        UploadServiceLogger.debug(simpleName, str, new a(this));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        String simpleName = OkHttpStackRequest.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        UploadServiceLogger.debug(simpleName, this.e, new b(this));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003c, code lost:
        kotlin.io.CloseableKt.closeFinally(r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0042, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0043, code lost:
        kotlin.io.CloseableKt.closeFinally(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0046, code lost:
        throw r7;
     */
    @Override // net.gotev.uploadservice.network.HttpRequest
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public net.gotev.uploadservice.network.ServerResponse getResponse(@org.jetbrains.annotations.NotNull net.gotev.uploadservice.network.HttpRequest.RequestBodyDelegate r6, @org.jetbrains.annotations.NotNull net.gotev.uploadservice.network.BodyWriter.OnStreamWriteListener r7) throws java.io.IOException {
        /*
            r5 = this;
            java.lang.String r0 = "delegate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "listener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            okhttp3.OkHttpClient r0 = r5.f     // Catch:{ all -> 0x0040 }
            okhttp3.Request$Builder r1 = r5.a     // Catch:{ all -> 0x0040 }
            java.lang.String r2 = r5.g     // Catch:{ all -> 0x0040 }
            boolean r3 = net.gotev.uploadservice.okhttp.OkHttpExtensionsKt.hasBody(r2)     // Catch:{ all -> 0x0040 }
            r4 = 0
            if (r3 != 0) goto L_0x0019
            r3 = r4
            goto L_0x001e
        L_0x0019:
            net.gotev.uploadservice.okhttp.OkHttpStackRequest$createBody$1 r3 = new net.gotev.uploadservice.okhttp.OkHttpStackRequest$createBody$1     // Catch:{ all -> 0x0040 }
            r3.<init>(r7, r6)     // Catch:{ all -> 0x0040 }
        L_0x001e:
            okhttp3.Request$Builder r6 = r1.method(r2, r3)     // Catch:{ all -> 0x0040 }
            okhttp3.Request r6 = r6.build()     // Catch:{ all -> 0x0040 }
            okhttp3.Call r6 = r0.newCall(r6)     // Catch:{ all -> 0x0040 }
            okhttp3.Response r6 = r6.execute()     // Catch:{ all -> 0x0040 }
            net.gotev.uploadservice.network.ServerResponse r7 = net.gotev.uploadservice.okhttp.OkHttpExtensionsKt.asServerResponse(r6)     // Catch:{ all -> 0x0039 }
            kotlin.io.CloseableKt.closeFinally(r6, r4)
            kotlin.io.CloseableKt.closeFinally(r5, r4)
            return r7
        L_0x0039:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x003b }
        L_0x003b:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r6, r7)
            throw r0
        L_0x0040:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0042 }
        L_0x0042:
            r7 = move-exception
            kotlin.io.CloseableKt.closeFinally(r5, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: net.gotev.uploadservice.okhttp.OkHttpStackRequest.getResponse(net.gotev.uploadservice.network.HttpRequest$RequestBodyDelegate, net.gotev.uploadservice.network.BodyWriter$OnStreamWriteListener):net.gotev.uploadservice.network.ServerResponse");
    }

    @Override // net.gotev.uploadservice.network.HttpRequest
    @NotNull
    public HttpRequest setHeaders(@NotNull List<NameValue> list) throws IOException {
        Intrinsics.checkNotNullParameter(list, "requestHeaders");
        for (NameValue nameValue : list) {
            String name = nameValue.getName();
            Objects.requireNonNull(name, "null cannot be cast to non-null type kotlin.CharSequence");
            String obj = StringsKt__StringsKt.trim(name).toString();
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "Locale.getDefault()");
            Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = obj.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            if (Intrinsics.areEqual("content-type", lowerCase)) {
                MediaType.Companion companion = MediaType.Companion;
                String value = nameValue.getValue();
                Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.CharSequence");
                this.c = companion.parse(StringsKt__StringsKt.trim(value).toString());
            }
            Request.Builder builder = this.a;
            String name2 = nameValue.getName();
            Objects.requireNonNull(name2, "null cannot be cast to non-null type kotlin.CharSequence");
            String obj2 = StringsKt__StringsKt.trim(name2).toString();
            String value2 = nameValue.getValue();
            Objects.requireNonNull(value2, "null cannot be cast to non-null type kotlin.CharSequence");
            builder.header(obj2, StringsKt__StringsKt.trim(value2).toString());
        }
        return this;
    }

    @Override // net.gotev.uploadservice.network.HttpRequest
    @NotNull
    public HttpRequest setTotalBodyBytes(long j, boolean z) {
        if (!z) {
            j = -1;
        }
        this.b = j;
        return this;
    }
}
