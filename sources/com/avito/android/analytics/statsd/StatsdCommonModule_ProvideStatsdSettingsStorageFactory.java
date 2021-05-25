package com.avito.android.analytics.statsd;

import com.avito.android.analytics.inhouse_transport.InHouseAnalyticsSettingsStorage;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class StatsdCommonModule_ProvideStatsdSettingsStorageFactory implements Factory<InHouseAnalyticsSettingsStorage> {
    public final Provider<Preferences> a;

    public StatsdCommonModule_ProvideStatsdSettingsStorageFactory(Provider<Preferences> provider) {
        this.a = provider;
    }

    public static StatsdCommonModule_ProvideStatsdSettingsStorageFactory create(Provider<Preferences> provider) {
        return new StatsdCommonModule_ProvideStatsdSettingsStorageFactory(provider);
    }

    public static InHouseAnalyticsSettingsStorage provideStatsdSettingsStorage(Preferences preferences) {
        return (InHouseAnalyticsSettingsStorage) Preconditions.checkNotNullFromProvides(StatsdCommonModule.provideStatsdSettingsStorage(preferences));
    }

    @Override // javax.inject.Provider
    public InHouseAnalyticsSettingsStorage get() {
        return provideStatsdSettingsStorage(this.a.get());
    }
}
