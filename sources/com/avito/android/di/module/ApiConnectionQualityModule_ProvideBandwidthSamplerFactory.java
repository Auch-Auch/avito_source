package com.avito.android.di.module;

import com.avito.android.connection_quality.BandwidthSampler;
import com.facebook.network.connectionclass.DeviceBandwidthSampler;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ApiConnectionQualityModule_ProvideBandwidthSamplerFactory implements Factory<BandwidthSampler> {
    public final ApiConnectionQualityModule a;
    public final Provider<DeviceBandwidthSampler> b;

    public ApiConnectionQualityModule_ProvideBandwidthSamplerFactory(ApiConnectionQualityModule apiConnectionQualityModule, Provider<DeviceBandwidthSampler> provider) {
        this.a = apiConnectionQualityModule;
        this.b = provider;
    }

    public static ApiConnectionQualityModule_ProvideBandwidthSamplerFactory create(ApiConnectionQualityModule apiConnectionQualityModule, Provider<DeviceBandwidthSampler> provider) {
        return new ApiConnectionQualityModule_ProvideBandwidthSamplerFactory(apiConnectionQualityModule, provider);
    }

    public static BandwidthSampler provideBandwidthSampler(ApiConnectionQualityModule apiConnectionQualityModule, DeviceBandwidthSampler deviceBandwidthSampler) {
        return (BandwidthSampler) Preconditions.checkNotNullFromProvides(apiConnectionQualityModule.provideBandwidthSampler(deviceBandwidthSampler));
    }

    @Override // javax.inject.Provider
    public BandwidthSampler get() {
        return provideBandwidthSampler(this.a, this.b.get());
    }
}
