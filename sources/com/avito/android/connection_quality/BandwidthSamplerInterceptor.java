package com.avito.android.connection_quality;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/connection_quality/BandwidthSamplerInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "Lcom/avito/android/connection_quality/BandwidthSampler;", AuthSource.SEND_ABUSE, "Lcom/avito/android/connection_quality/BandwidthSampler;", "sampler", "<init>", "(Lcom/avito/android/connection_quality/BandwidthSampler;)V", "connection-quality_release"}, k = 1, mv = {1, 4, 2})
public class BandwidthSamplerInterceptor implements Interceptor {
    public final BandwidthSampler a;

    public BandwidthSamplerInterceptor(@NotNull BandwidthSampler bandwidthSampler) {
        Intrinsics.checkNotNullParameter(bandwidthSampler, "sampler");
        this.a = bandwidthSampler;
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        this.a.startSampling();
        Response proceed = chain.proceed(chain.request());
        this.a.stopSampling();
        return proceed;
    }
}
