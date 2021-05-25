package com.avito.android.analytics.clickstream;

import com.avito.android.analytics.inhouse_transport.InHouseAnalyticsSettingsStorage;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ClickStreamCommonModule_ProvideClickStreamSettingsStorageFactory implements Factory<InHouseAnalyticsSettingsStorage> {
    public final Provider<Preferences> a;

    public ClickStreamCommonModule_ProvideClickStreamSettingsStorageFactory(Provider<Preferences> provider) {
        this.a = provider;
    }

    public static ClickStreamCommonModule_ProvideClickStreamSettingsStorageFactory create(Provider<Preferences> provider) {
        return new ClickStreamCommonModule_ProvideClickStreamSettingsStorageFactory(provider);
    }

    public static InHouseAnalyticsSettingsStorage provideClickStreamSettingsStorage(Preferences preferences) {
        return (InHouseAnalyticsSettingsStorage) Preconditions.checkNotNullFromProvides(ClickStreamCommonModule.provideClickStreamSettingsStorage(preferences));
    }

    @Override // javax.inject.Provider
    public InHouseAnalyticsSettingsStorage get() {
        return provideClickStreamSettingsStorage(this.a.get());
    }
}
