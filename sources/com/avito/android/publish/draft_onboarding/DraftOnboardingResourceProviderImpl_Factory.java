package com.avito.android.publish.draft_onboarding;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DraftOnboardingResourceProviderImpl_Factory implements Factory<DraftOnboardingResourceProviderImpl> {
    public final Provider<Resources> a;

    public DraftOnboardingResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static DraftOnboardingResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new DraftOnboardingResourceProviderImpl_Factory(provider);
    }

    public static DraftOnboardingResourceProviderImpl newInstance(Resources resources) {
        return new DraftOnboardingResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public DraftOnboardingResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
