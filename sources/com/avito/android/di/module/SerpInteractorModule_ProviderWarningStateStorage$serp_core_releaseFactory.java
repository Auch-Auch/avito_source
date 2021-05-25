package com.avito.android.di.module;

import com.avito.android.serp.warning.TemporalWarningStateStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SerpInteractorModule_ProviderWarningStateStorage$serp_core_releaseFactory implements Factory<TemporalWarningStateStorage> {

    public static final class a {
        public static final SerpInteractorModule_ProviderWarningStateStorage$serp_core_releaseFactory a = new SerpInteractorModule_ProviderWarningStateStorage$serp_core_releaseFactory();
    }

    public static SerpInteractorModule_ProviderWarningStateStorage$serp_core_releaseFactory create() {
        return a.a;
    }

    public static TemporalWarningStateStorage providerWarningStateStorage$serp_core_release() {
        return (TemporalWarningStateStorage) Preconditions.checkNotNullFromProvides(SerpInteractorModule.providerWarningStateStorage$serp_core_release());
    }

    @Override // javax.inject.Provider
    public TemporalWarningStateStorage get() {
        return providerWarningStateStorage$serp_core_release();
    }
}
