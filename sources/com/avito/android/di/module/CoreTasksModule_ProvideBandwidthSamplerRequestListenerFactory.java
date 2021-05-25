package com.avito.android.di.module;

import com.avito.android.connection_quality.BandwidthSampler;
import com.avito.android.connection_quality.BandwidthSamplerRequestListener;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CoreTasksModule_ProvideBandwidthSamplerRequestListenerFactory implements Factory<BandwidthSamplerRequestListener> {
    public final Provider<BandwidthSampler> a;

    public CoreTasksModule_ProvideBandwidthSamplerRequestListenerFactory(Provider<BandwidthSampler> provider) {
        this.a = provider;
    }

    public static CoreTasksModule_ProvideBandwidthSamplerRequestListenerFactory create(Provider<BandwidthSampler> provider) {
        return new CoreTasksModule_ProvideBandwidthSamplerRequestListenerFactory(provider);
    }

    public static BandwidthSamplerRequestListener provideBandwidthSamplerRequestListener(BandwidthSampler bandwidthSampler) {
        return (BandwidthSamplerRequestListener) Preconditions.checkNotNullFromProvides(CoreTasksModule.INSTANCE.provideBandwidthSamplerRequestListener(bandwidthSampler));
    }

    @Override // javax.inject.Provider
    public BandwidthSamplerRequestListener get() {
        return provideBandwidthSamplerRequestListener(this.a.get());
    }
}
