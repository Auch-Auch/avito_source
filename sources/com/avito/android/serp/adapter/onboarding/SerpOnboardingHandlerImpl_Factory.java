package com.avito.android.serp.adapter.onboarding;

import com.avito.android.Features;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SerpOnboardingHandlerImpl_Factory implements Factory<SerpOnboardingHandlerImpl> {
    public final Provider<SerpBadgeResourceProvider> a;
    public final Provider<Preferences> b;
    public final Provider<Features> c;
    public final Provider<SerpOnboardingHandlerState> d;

    public SerpOnboardingHandlerImpl_Factory(Provider<SerpBadgeResourceProvider> provider, Provider<Preferences> provider2, Provider<Features> provider3, Provider<SerpOnboardingHandlerState> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static SerpOnboardingHandlerImpl_Factory create(Provider<SerpBadgeResourceProvider> provider, Provider<Preferences> provider2, Provider<Features> provider3, Provider<SerpOnboardingHandlerState> provider4) {
        return new SerpOnboardingHandlerImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static SerpOnboardingHandlerImpl newInstance(SerpBadgeResourceProvider serpBadgeResourceProvider, Preferences preferences, Features features, SerpOnboardingHandlerState serpOnboardingHandlerState) {
        return new SerpOnboardingHandlerImpl(serpBadgeResourceProvider, preferences, features, serpOnboardingHandlerState);
    }

    @Override // javax.inject.Provider
    public SerpOnboardingHandlerImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
