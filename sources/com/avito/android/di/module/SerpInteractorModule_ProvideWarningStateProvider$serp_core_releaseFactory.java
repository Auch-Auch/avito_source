package com.avito.android.di.module;

import com.avito.android.serp.warning.PermanentWarningStateStorage;
import com.avito.android.serp.warning.TemporalWarningStateStorage;
import com.avito.android.serp.warning.WarningStateProvider;
import com.avito.android.serp.warning.WarningStateProviderState;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SerpInteractorModule_ProvideWarningStateProvider$serp_core_releaseFactory implements Factory<WarningStateProvider> {
    public final Provider<TemporalWarningStateStorage> a;
    public final Provider<PermanentWarningStateStorage> b;
    public final Provider<WarningStateProviderState> c;

    public SerpInteractorModule_ProvideWarningStateProvider$serp_core_releaseFactory(Provider<TemporalWarningStateStorage> provider, Provider<PermanentWarningStateStorage> provider2, Provider<WarningStateProviderState> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static SerpInteractorModule_ProvideWarningStateProvider$serp_core_releaseFactory create(Provider<TemporalWarningStateStorage> provider, Provider<PermanentWarningStateStorage> provider2, Provider<WarningStateProviderState> provider3) {
        return new SerpInteractorModule_ProvideWarningStateProvider$serp_core_releaseFactory(provider, provider2, provider3);
    }

    public static WarningStateProvider provideWarningStateProvider$serp_core_release(TemporalWarningStateStorage temporalWarningStateStorage, PermanentWarningStateStorage permanentWarningStateStorage, WarningStateProviderState warningStateProviderState) {
        return (WarningStateProvider) Preconditions.checkNotNullFromProvides(SerpInteractorModule.provideWarningStateProvider$serp_core_release(temporalWarningStateStorage, permanentWarningStateStorage, warningStateProviderState));
    }

    @Override // javax.inject.Provider
    public WarningStateProvider get() {
        return provideWarningStateProvider$serp_core_release(this.a.get(), this.b.get(), this.c.get());
    }
}
