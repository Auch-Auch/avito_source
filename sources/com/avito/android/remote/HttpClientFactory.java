package com.avito.android.remote;

import android.content.Context;
import android.os.Looper;
import com.avito.android.Features;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.interceptor.SupportedFeaturesInterceptor;
import com.avito.android.remote.interceptor.UserAgentInterceptor;
import com.avito.android.util.OkHttpInjector;
import com.facebook.common.util.UriUtil;
import java.io.File;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJG\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/HttpClientFactory;", "", "", "timeoutSeconds", "Landroid/content/Context;", "context", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/remote/interceptor/SupportedFeaturesInterceptor;", "featuresInterceptor", "Lcom/avito/android/remote/interceptor/UserAgentInterceptor;", "userAgentInterceptor", "Lcom/avito/android/util/OkHttpInjector;", "debugInjector", "", "isDebug", "Lokhttp3/OkHttpClient;", "getClient", "(JLandroid/content/Context;Lcom/avito/android/Features;Lcom/avito/android/remote/interceptor/SupportedFeaturesInterceptor;Lcom/avito/android/remote/interceptor/UserAgentInterceptor;Lcom/avito/android/util/OkHttpInjector;Z)Lokhttp3/OkHttpClient;", "Lokhttp3/Interceptor;", "interceptor", "getSimpleClient", "(JLokhttp3/Interceptor;)Lokhttp3/OkHttpClient;", "Lokhttp3/OkHttpClient$Builder;", AuthSource.SEND_ABUSE, "(J)Lokhttp3/OkHttpClient$Builder;", "<init>", "()V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class HttpClientFactory {
    public final OkHttpClient.Builder a(long j) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return builder.readTimeout(j, timeUnit).connectTimeout(j, timeUnit).protocols(CollectionsKt__CollectionsKt.listOf((Object[]) new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1}));
    }

    @NotNull
    public final OkHttpClient getClient(long j, @NotNull Context context, @NotNull Features features, @NotNull SupportedFeaturesInterceptor supportedFeaturesInterceptor, @NotNull UserAgentInterceptor userAgentInterceptor, @Nullable OkHttpInjector okHttpInjector, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(supportedFeaturesInterceptor, "featuresInterceptor");
        Intrinsics.checkNotNullParameter(userAgentInterceptor, "userAgentInterceptor");
        if (!z || (!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()))) {
            OkHttpClient.Builder a = a(j);
            if (!features.getDisableHttpCaching().getValue().booleanValue()) {
                a.cache(new Cache(new File(context.getCacheDir(), UriUtil.HTTP_SCHEME), 10485760));
            }
            if (okHttpInjector != null) {
                okHttpInjector.inject(a);
            }
            a.addInterceptor(supportedFeaturesInterceptor);
            return a.addInterceptor(userAgentInterceptor).build();
        }
        throw new IllegalStateException("Initializing OkHttpClient on the main thread".toString());
    }

    @NotNull
    public final OkHttpClient getSimpleClient(long j, @NotNull Interceptor interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        return a(j).addInterceptor(interceptor).build();
    }
}
