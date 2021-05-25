package com.avito.android.di.module;

import com.avito.android.serp.warning.PermanentWarningStateStorage;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SerpInteractorModule_ProviderPermanentWarningStateStorage$serp_core_releaseFactory implements Factory<PermanentWarningStateStorage> {
    public final Provider<Preferences> a;

    public SerpInteractorModule_ProviderPermanentWarningStateStorage$serp_core_releaseFactory(Provider<Preferences> provider) {
        this.a = provider;
    }

    public static SerpInteractorModule_ProviderPermanentWarningStateStorage$serp_core_releaseFactory create(Provider<Preferences> provider) {
        return new SerpInteractorModule_ProviderPermanentWarningStateStorage$serp_core_releaseFactory(provider);
    }

    public static PermanentWarningStateStorage providerPermanentWarningStateStorage$serp_core_release(Preferences preferences) {
        return (PermanentWarningStateStorage) Preconditions.checkNotNullFromProvides(SerpInteractorModule.providerPermanentWarningStateStorage$serp_core_release(preferences));
    }

    @Override // javax.inject.Provider
    public PermanentWarningStateStorage get() {
        return providerPermanentWarningStateStorage$serp_core_release(this.a.get());
    }
}
