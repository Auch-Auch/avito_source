package com.avito.android.session_refresh;

import a2.b.a.a.a;
import com.avito.android.Features;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.interceptor.RequestParamsInterceptor;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Logs;
import com.avito.android.util.RequestUtils;
import com.avito.android.util.Strings;
import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.http.HttpMethod;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000e\u001a\u00020\u00072\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/session_refresh/RequestParamsInterceptorImpl;", "Lcom/avito/android/remote/interceptor/RequestParamsInterceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "", "query", "", AuthSource.BOOKING_ORDER, "(Ljava/lang/String;)Ljava/util/Map;", "Ljava/util/SortedMap;", "params", AuthSource.SEND_ABUSE, "(Ljava/util/SortedMap;)Ljava/lang/String;", "Lcom/avito/android/util/BuildInfo;", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/Features;", "c", "Lcom/avito/android/Features;", "features", "Lokhttp3/HttpUrl;", "Lokhttp3/HttpUrl;", "baseUrl", "<init>", "(Lcom/avito/android/util/BuildInfo;Lcom/avito/android/Features;)V", "session-refresher_release"}, k = 1, mv = {1, 4, 2})
public final class RequestParamsInterceptorImpl implements RequestParamsInterceptor {
    public final HttpUrl a;
    public final BuildInfo b;
    public final Features c;

    @Inject
    public RequestParamsInterceptorImpl(@NotNull BuildInfo buildInfo, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(features, "features");
        this.b = buildInfo;
        this.c = features;
        HttpUrl parse = HttpUrl.Companion.parse(Strings.ensureEndsWith(features.getApiUrl().invoke(), "/"));
        if (parse != null) {
            this.a = parse;
            return;
        }
        StringBuilder L = a.L("Invalid api url: ");
        L.append(features.getApiUrl().invoke());
        throw new IllegalArgumentException(L.toString().toString());
    }

    public final String a(SortedMap<String, String> sortedMap) {
        StringBuilder sb = new StringBuilder(sortedMap.size() * 6);
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (sb.length() > 0) {
                sb.append(Typography.amp);
            }
            RequestUtils requestUtils = RequestUtils.INSTANCE;
            sb.append(requestUtils.encodeString(key));
            sb.append('=');
            sb.append(requestUtils.encodeString(value));
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
        return sb2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00f0 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.String, java.lang.String> b(java.lang.String r19) {
        /*
        // Method dump skipped, instructions count: 250
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.session_refresh.RequestParamsInterceptorImpl.b(java.lang.String):java.util.Map");
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Map<String, String> map;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        boolean z = false;
        if (Intrinsics.areEqual(request.url().host(), this.a.host()) && m.startsWith$default(request.url().encodedPath(), this.a.encodedPath(), false, 2, null)) {
            z = true;
        }
        if (!z) {
            StringBuilder L = a.L("Skipping request: ");
            L.append(request.url());
            Logs.verbose$default("RequestParamsInterceptor", L.toString(), null, 4, null);
            return chain.proceed(request);
        }
        String encodedQuery = request.url().encodedQuery();
        String method = request.method();
        RequestBody body = request.body();
        TreeMap treeMap = new TreeMap();
        treeMap.putAll(b(encodedQuery));
        if (body == null || (body instanceof MultipartBody)) {
            map = r.emptyMap();
        } else {
            try {
                Buffer buffer = new Buffer();
                body.writeTo(buffer);
                map = b(buffer.readUtf8());
            } catch (IOException e) {
                Logs.error("RequestParamsInterceptor", "getBodyParams", e);
                map = r.emptyMap();
            }
        }
        treeMap.putAll(map);
        Headers.Builder newBuilder = request.headers().newBuilder();
        treeMap.put("key", this.b.getApiKey());
        HttpUrl.Builder newBuilder2 = request.url().newBuilder();
        newBuilder2.query(null);
        if (!HttpMethod.permitsRequestBody(method)) {
            newBuilder2.encodedQuery(a(treeMap));
        } else if (body instanceof MultipartBody) {
            MultipartBody.Builder type = new MultipartBody.Builder(null, 1, null).setType(MultipartBody.FORM);
            for (Map.Entry entry : treeMap.entrySet()) {
                type.addFormDataPart((String) entry.getKey(), (String) entry.getValue());
            }
            for (MultipartBody.Part part : ((MultipartBody) body).parts()) {
                type.addPart(part);
            }
            body = type.build();
        } else {
            body = RequestBody.Companion.create(a(treeMap), RequestsKt.getMEDIA_TYPE_FORM_URLENCODED());
        }
        return chain.proceed(request.newBuilder().url(newBuilder2.build()).headers(newBuilder.build()).method(method, body).build());
    }
}
