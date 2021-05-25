package com.avito.android.di.module;

import com.avito.android.connection_quality.BandwidthSampler;
import com.avito.android.connection_quality.BandwidthSamplerInterceptor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ApiConnectionQualityModule_ProvideBandwidthSamplerInterceptorFactory implements Factory<BandwidthSamplerInterceptor> {
    public final ApiConnectionQualityModule a;
    public final Provider<BandwidthSampler> b;

    public ApiConnectionQualityModule_ProvideBandwidthSamplerInterceptorFactory(ApiConnectionQualityModule apiConnectionQualityModule, Provider<BandwidthSampler> provider) {
        this.a = apiConnectionQualityModule;
        this.b = provider;
    }

    public static ApiConnectionQualityModule_ProvideBandwidthSamplerInterceptorFactory create(ApiConnectionQualityModule apiConnectionQualityModule, Provider<BandwidthSampler> provider) {
        return new ApiConnectionQualityModule_ProvideBandwidthSamplerInterceptorFactory(apiConnectionQualityModule, provider);
    }

    public static BandwidthSamplerInterceptor provideBandwidthSamplerInterceptor(ApiConnectionQualityModule apiConnectionQualityModule, BandwidthSampler bandwidthSampler) {
        return (BandwidthSamplerInterceptor) Preconditions.checkNotNullFromProvides(apiConnectionQualityModule.provideBandwidthSamplerInterceptor(bandwidthSampler));
    }

    @Override // javax.inject.Provider
    public BandwidthSamplerInterceptor get() {
        return provideBandwidthSamplerInterceptor(this.a, this.b.get());
    }
}
