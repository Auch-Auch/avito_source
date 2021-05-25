package com.avito.android.di.module;

import com.avito.android.connection_quality.BandwidthSampler;
import com.avito.android.connection_quality.BandwidthSamplerImpl;
import com.avito.android.connection_quality.BandwidthSamplerInterceptor;
import com.facebook.network.connectionclass.DeviceBandwidthSampler;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/di/module/ApiConnectionQualityModule;", "", "Lcom/facebook/network/connectionclass/DeviceBandwidthSampler;", "provideDeviceBandwidthSampler", "()Lcom/facebook/network/connectionclass/DeviceBandwidthSampler;", "Lcom/avito/android/connection_quality/BandwidthSampler;", "sampler", "Lcom/avito/android/connection_quality/BandwidthSamplerInterceptor;", "provideBandwidthSamplerInterceptor", "(Lcom/avito/android/connection_quality/BandwidthSampler;)Lcom/avito/android/connection_quality/BandwidthSamplerInterceptor;", "provideBandwidthSampler", "(Lcom/facebook/network/connectionclass/DeviceBandwidthSampler;)Lcom/avito/android/connection_quality/BandwidthSampler;", "<init>", "()V", "connection-quality_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class ApiConnectionQualityModule {
    @Provides
    @Reusable
    @NotNull
    public final BandwidthSampler provideBandwidthSampler(@NotNull DeviceBandwidthSampler deviceBandwidthSampler) {
        Intrinsics.checkNotNullParameter(deviceBandwidthSampler, "sampler");
        return new BandwidthSamplerImpl(deviceBandwidthSampler);
    }

    @Provides
    @Reusable
    @NotNull
    public final BandwidthSamplerInterceptor provideBandwidthSamplerInterceptor(@NotNull BandwidthSampler bandwidthSampler) {
        Intrinsics.checkNotNullParameter(bandwidthSampler, "sampler");
        return new BandwidthSamplerInterceptor(bandwidthSampler);
    }

    @Provides
    @Reusable
    @NotNull
    public final DeviceBandwidthSampler provideDeviceBandwidthSampler() {
        DeviceBandwidthSampler instance = DeviceBandwidthSampler.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DeviceBandwidthSampler.getInstance()");
        return instance;
    }
}
