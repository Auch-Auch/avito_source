package com.avito.android.remote.interceptor;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.NetworkRequestEvent;
import com.avito.android.remote.NetworkRequestEventId;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.RandomKeyProvider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import retrofit2.Invocation;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/remote/interceptor/ApiAnalyticsInterceptorImpl;", "Lcom/avito/android/remote/interceptor/ApiAnalyticsInterceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "Lcom/avito/android/util/RandomKeyProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/RandomKeyProvider;", "keyProvider", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/RandomKeyProvider;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class ApiAnalyticsInterceptorImpl implements ApiAnalyticsInterceptor {
    public final Analytics a;
    public final RandomKeyProvider b;

    public ApiAnalyticsInterceptorImpl(@NotNull Analytics analytics, @NotNull RandomKeyProvider randomKeyProvider) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(randomKeyProvider, "keyProvider");
        this.a = analytics;
        this.b = randomKeyProvider;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x0035 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.avito.android.remote.NetworkRequestEventId */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        Invocation invocation = (Invocation) request.tag(Invocation.class);
        NetworkRequestEventId networkRequestEventId = null;
        if (invocation != null) {
            Method method = invocation.method();
            Intrinsics.checkNotNullExpressionValue(method, "invocation.method()");
            Annotation[] annotations = method.getAnnotations();
            Intrinsics.checkNotNullExpressionValue(annotations, "invocation.method().annotations");
            int length = annotations.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Annotation annotation = annotations[i];
                if (annotation instanceof NetworkRequestEventId) {
                    networkRequestEventId = annotation;
                    break;
                }
                i++;
            }
            networkRequestEventId = networkRequestEventId;
        }
        if (networkRequestEventId == null) {
            return chain.proceed(request);
        }
        String generateKey = this.b.generateKey();
        this.a.track(new NetworkRequestEvent(networkRequestEventId.eventId(), generateKey));
        return chain.proceed(request.newBuilder().addHeader("X-RequestId", generateKey).build());
    }
}
