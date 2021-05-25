package com.avito.android.remote.interceptor;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.HeadersBuildersKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/avito/android/remote/interceptor/HeadersInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "", "", AuthSource.SEND_ABUSE, "Ljava/util/List;", "supportedHosts", "Lcom/avito/android/remote/interceptor/HeaderProvider;", AuthSource.BOOKING_ORDER, "providers", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public class HeadersInterceptor implements Interceptor {
    public final List<String> a;
    public final List<HeaderProvider> b;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.remote.interceptor.HeaderProvider> */
    /* JADX WARN: Multi-variable type inference failed */
    public HeadersInterceptor(@NotNull List<String> list, @NotNull List<? extends HeaderProvider> list2) {
        Intrinsics.checkNotNullParameter(list, "supportedHosts");
        Intrinsics.checkNotNullParameter(list2, "providers");
        this.a = list;
        this.b = list2;
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        if (!HeadersInterceptorKt.access$hostIsContainedIn(request, this.a)) {
            return chain.proceed(request);
        }
        Headers headers = request.headers();
        Map access$generateNewHeaders = HeadersInterceptorKt.access$generateNewHeaders(headers, this.b);
        List access$generateHeaderToRemove = HeadersInterceptorKt.access$generateHeaderToRemove(this.b);
        if (access$generateNewHeaders.isEmpty() && access$generateHeaderToRemove.isEmpty()) {
            return chain.proceed(request);
        }
        Headers.Builder removeAll = HeadersBuildersKt.removeAll(headers.newBuilder(), access$generateHeaderToRemove);
        for (Map.Entry entry : access$generateNewHeaders.entrySet()) {
            removeAll.set((String) entry.getKey(), (String) entry.getValue());
        }
        return chain.proceed(request.newBuilder().headers(removeAll.build()).build());
    }
}
