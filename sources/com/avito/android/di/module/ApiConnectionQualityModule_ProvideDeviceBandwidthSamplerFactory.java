package com.avito.android.di.module;

import com.facebook.network.connectionclass.DeviceBandwidthSampler;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class ApiConnectionQualityModule_ProvideDeviceBandwidthSamplerFactory implements Factory<DeviceBandwidthSampler> {
    public final ApiConnectionQualityModule a;

    public ApiConnectionQualityModule_ProvideDeviceBandwidthSamplerFactory(ApiConnectionQualityModule apiConnectionQualityModule) {
        this.a = apiConnectionQualityModule;
    }

    public static ApiConnectionQualityModule_ProvideDeviceBandwidthSamplerFactory create(ApiConnectionQualityModule apiConnectionQualityModule) {
        return new ApiConnectionQualityModule_ProvideDeviceBandwidthSamplerFactory(apiConnectionQualityModule);
    }

    public static DeviceBandwidthSampler provideDeviceBandwidthSampler(ApiConnectionQualityModule apiConnectionQualityModule) {
        return (DeviceBandwidthSampler) Preconditions.checkNotNullFromProvides(apiConnectionQualityModule.provideDeviceBandwidthSampler());
    }

    @Override // javax.inject.Provider
    public DeviceBandwidthSampler get() {
        return provideDeviceBandwidthSampler(this.a);
    }
}
