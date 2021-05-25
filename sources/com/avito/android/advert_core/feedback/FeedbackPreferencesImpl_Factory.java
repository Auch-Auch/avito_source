package com.avito.android.advert_core.feedback;

import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FeedbackPreferencesImpl_Factory implements Factory<FeedbackPreferencesImpl> {
    public final Provider<Preferences> a;

    public FeedbackPreferencesImpl_Factory(Provider<Preferences> provider) {
        this.a = provider;
    }

    public static FeedbackPreferencesImpl_Factory create(Provider<Preferences> provider) {
        return new FeedbackPreferencesImpl_Factory(provider);
    }

    public static FeedbackPreferencesImpl newInstance(Preferences preferences) {
        return new FeedbackPreferencesImpl(preferences);
    }

    @Override // javax.inject.Provider
    public FeedbackPreferencesImpl get() {
        return newInstance(this.a.get());
    }
}
