package com.avito.android.advert_core.contactbar.anti_fraud;

import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AntiFraudPreferencesImpl_Factory implements Factory<AntiFraudPreferencesImpl> {
    public final Provider<Preferences> a;

    public AntiFraudPreferencesImpl_Factory(Provider<Preferences> provider) {
        this.a = provider;
    }

    public static AntiFraudPreferencesImpl_Factory create(Provider<Preferences> provider) {
        return new AntiFraudPreferencesImpl_Factory(provider);
    }

    public static AntiFraudPreferencesImpl newInstance(Preferences preferences) {
        return new AntiFraudPreferencesImpl(preferences);
    }

    @Override // javax.inject.Provider
    public AntiFraudPreferencesImpl get() {
        return newInstance(this.a.get());
    }
}
