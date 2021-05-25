package com.avito.android.remote.interceptors;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.NonFatalError;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.util.GsonsKt;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/remote/interceptors/FirewallErrorInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "Lcom/avito/android/remote/interceptors/FirewallErrorRouter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/interceptors/FirewallErrorRouter;", "router", "Lcom/google/gson/Gson;", AuthSource.SEND_ABUSE, "Lcom/google/gson/Gson;", "gson", "Lcom/avito/android/analytics/Analytics;", "c", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/google/gson/Gson;Lcom/avito/android/remote/interceptors/FirewallErrorRouter;Lcom/avito/android/analytics/Analytics;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class FirewallErrorInterceptor implements Interceptor {
    public final Gson a;
    public final FirewallErrorRouter b;
    public final Analytics c;

    public FirewallErrorInterceptor(@NotNull Gson gson, @NotNull FirewallErrorRouter firewallErrorRouter, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(firewallErrorRouter, "router");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = gson;
        this.b = firewallErrorRouter;
        this.c = analytics;
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Type type;
        DeepLink link;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Response proceed = chain.proceed(chain.request());
        if (proceed.code() == 403) {
            try {
                ResponseBody body = proceed.newBuilder().build().body();
                if (body != null) {
                    Gson gson = this.a;
                    String string = body.string();
                    Type type2 = new TypeToken<ErrorResult>() { // from class: com.avito.android.remote.interceptors.FirewallErrorInterceptor$checkFirewallError$$inlined$fromJson$1
                    }.getType();
                    Intrinsics.checkNotNullExpressionValue(type2, "object : TypeToken<T>() {}.type");
                    if (!(type2 instanceof ParameterizedType) || !GsonsKt.isWildcard((ParameterizedType) type2)) {
                        type = GsonsKt.removeTypeWildcards(type2);
                    } else {
                        type = ((ParameterizedType) type2).getRawType();
                        Intrinsics.checkNotNullExpressionValue(type, "type.rawType");
                    }
                    Object fromJson = gson.fromJson(string, type);
                    Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(json, typeToken<T>())");
                    ErrorResult errorResult = (ErrorResult) fromJson;
                    if ((errorResult instanceof ErrorResult.Forbidden) && (link = ((ErrorResult.Forbidden) errorResult).getLink()) != null) {
                        this.b.followDeeplink(link);
                    }
                } else {
                    throw new IllegalArgumentException("empty response body".toString());
                }
            } catch (Throwable th) {
                this.c.track(new NonFatalError("FirewallErrorInterceptor: 403 not from firewall", th, null, 4, null));
            }
        }
        return proceed;
    }
}
