package com.avito.android.analytics.inhouse_transport;

import com.avito.android.util.Logs;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/analytics/inhouse_transport/GzipRequestInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "<init>", "()V", "analytics-transport_release"}, k = 1, mv = {1, 4, 2})
public final class GzipRequestInterceptor implements Interceptor {
    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        if (request.body() == null) {
            Request build = request.newBuilder().header("Content-Encoding", "gzip").build();
            Logs.debug$default("GzipRequestInterceptor", "newRequest.toString():" + build, null, 4, null);
            return chain.proceed(build);
        } else if (request.header("Content-Encoding") != null) {
            return chain.proceed(request);
        } else {
            Request.Builder header = request.newBuilder().header("Content-Encoding", "gzip");
            String method = request.method();
            GzipRequestInterceptor$gzip$1 gzipRequestInterceptor$gzip$1 = new RequestBody() { // from class: com.avito.android.analytics.inhouse_transport.GzipRequestInterceptor$gzip$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return -1;
                }

                @Override // okhttp3.RequestBody
                @Nullable
                public MediaType contentType() {
                    RequestBody requestBody = RequestBody.this;
                    if (requestBody != null) {
                        return requestBody.contentType();
                    }
                    return null;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(@NotNull BufferedSink bufferedSink) throws IOException {
                    Intrinsics.checkNotNullParameter(bufferedSink, "sink");
                    BufferedSink buffer = Okio.buffer(new GzipSink(bufferedSink));
                    RequestBody requestBody = RequestBody.this;
                    if (requestBody != null) {
                        requestBody.writeTo(buffer);
                    }
                    buffer.close();
                }
            };
            Buffer buffer = new Buffer();
            gzipRequestInterceptor$gzip$1.writeTo(buffer);
            return chain.proceed(header.method(method, new RequestBody(buffer) { // from class: com.avito.android.analytics.inhouse_transport.GzipRequestInterceptor$forceContentLength$1
                public final /* synthetic */ Buffer b;

                {
                    this.b = r2;
                }

                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return this.b.size();
                }

                @Override // okhttp3.RequestBody
                @Nullable
                public MediaType contentType() {
                    return RequestBody.this.contentType();
                }

                @Override // okhttp3.RequestBody
                public void writeTo(@NotNull BufferedSink bufferedSink) throws IOException {
                    Intrinsics.checkNotNullParameter(bufferedSink, "sink");
                    bufferedSink.write(this.b.snapshot());
                }
            }).build());
        }
    }
}
