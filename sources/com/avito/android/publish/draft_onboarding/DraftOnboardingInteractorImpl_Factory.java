package com.avito.android.publish.draft_onboarding;

import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DraftOnboardingInteractorImpl_Factory implements Factory<DraftOnboardingInteractorImpl> {
    public final Provider<DraftOnboardingSessionStorage> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<DraftOnboardingResourceProvider> c;

    public DraftOnboardingInteractorImpl_Factory(Provider<DraftOnboardingSessionStorage> provider, Provider<SchedulersFactory> provider2, Provider<DraftOnboardingResourceProvider> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static DraftOnboardingInteractorImpl_Factory create(Provider<DraftOnboardingSessionStorage> provider, Provider<SchedulersFactory> provider2, Provider<DraftOnboardingResourceProvider> provider3) {
        return new DraftOnboardingInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static DraftOnboardingInteractorImpl newInstance(DraftOnboardingSessionStorage draftOnboardingSessionStorage, SchedulersFactory schedulersFactory, DraftOnboardingResourceProvider draftOnboardingResourceProvider) {
        return new DraftOnboardingInteractorImpl(draftOnboardingSessionStorage, schedulersFactory, draftOnboardingResourceProvider);
    }

    @Override // javax.inject.Provider
    public DraftOnboardingInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
