package com.avito.android.publish.draft_onboarding;

import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PrefDraftOnboardingSessionStorage_Factory implements Factory<PrefDraftOnboardingSessionStorage> {
    public final Provider<Preferences> a;

    public PrefDraftOnboardingSessionStorage_Factory(Provider<Preferences> provider) {
        this.a = provider;
    }

    public static PrefDraftOnboardingSessionStorage_Factory create(Provider<Preferences> provider) {
        return new PrefDraftOnboardingSessionStorage_Factory(provider);
    }

    public static PrefDraftOnboardingSessionStorage newInstance(Preferences preferences) {
        return new PrefDraftOnboardingSessionStorage(preferences);
    }

    @Override // javax.inject.Provider
    public PrefDraftOnboardingSessionStorage get() {
        return newInstance(this.a.get());
    }
}
