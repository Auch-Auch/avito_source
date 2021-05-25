package com.avito.android.analytics.statsd;

import com.avito.android.analytics.inhouse_transport.DiskStorageConverter;
import com.avito.android.analytics.inhouse_transport.FileStorage;
import com.avito.android.analytics.inhouse_transport.InHouseAnalyticsSettingsStorage;
import com.avito.android.analytics.inhouse_transport.OnDiskEventStorage;
import com.avito.android.util.RandomKeyProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class StatsdCommonModule_ProvideOnDiskStatsdEventStorageFactory implements Factory<OnDiskEventStorage<StatsdRecord>> {
    public final Provider<FileStorage> a;
    public final Provider<InHouseAnalyticsSettingsStorage> b;
    public final Provider<DiskStorageConverter<StatsdRecord>> c;
    public final Provider<RandomKeyProvider> d;

    public StatsdCommonModule_ProvideOnDiskStatsdEventStorageFactory(Provider<FileStorage> provider, Provider<InHouseAnalyticsSettingsStorage> provider2, Provider<DiskStorageConverter<StatsdRecord>> provider3, Provider<RandomKeyProvider> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static StatsdCommonModule_ProvideOnDiskStatsdEventStorageFactory create(Provider<FileStorage> provider, Provider<InHouseAnalyticsSettingsStorage> provider2, Provider<DiskStorageConverter<StatsdRecord>> provider3, Provider<RandomKeyProvider> provider4) {
        return new StatsdCommonModule_ProvideOnDiskStatsdEventStorageFactory(provider, provider2, provider3, provider4);
    }

    public static OnDiskEventStorage<StatsdRecord> provideOnDiskStatsdEventStorage(FileStorage fileStorage, InHouseAnalyticsSettingsStorage inHouseAnalyticsSettingsStorage, DiskStorageConverter<StatsdRecord> diskStorageConverter, RandomKeyProvider randomKeyProvider) {
        return (OnDiskEventStorage) Preconditions.checkNotNullFromProvides(StatsdCommonModule.provideOnDiskStatsdEventStorage(fileStorage, inHouseAnalyticsSettingsStorage, diskStorageConverter, randomKeyProvider));
    }

    @Override // javax.inject.Provider
    public OnDiskEventStorage<StatsdRecord> get() {
        return provideOnDiskStatsdEventStorage(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
