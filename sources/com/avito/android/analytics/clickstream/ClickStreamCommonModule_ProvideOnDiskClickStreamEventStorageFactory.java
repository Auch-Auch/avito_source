package com.avito.android.analytics.clickstream;

import com.avito.android.analytics.inhouse_transport.DiskStorageConverter;
import com.avito.android.analytics.inhouse_transport.FileStorage;
import com.avito.android.analytics.inhouse_transport.InHouseAnalyticsSettingsStorage;
import com.avito.android.analytics.inhouse_transport.OnDiskEventStorage;
import com.avito.android.util.RandomKeyProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import proto.events.apps.EventOuterClass;
public final class ClickStreamCommonModule_ProvideOnDiskClickStreamEventStorageFactory implements Factory<OnDiskEventStorage<EventOuterClass.Event>> {
    public final Provider<FileStorage> a;
    public final Provider<InHouseAnalyticsSettingsStorage> b;
    public final Provider<DiskStorageConverter<EventOuterClass.Event>> c;
    public final Provider<RandomKeyProvider> d;

    public ClickStreamCommonModule_ProvideOnDiskClickStreamEventStorageFactory(Provider<FileStorage> provider, Provider<InHouseAnalyticsSettingsStorage> provider2, Provider<DiskStorageConverter<EventOuterClass.Event>> provider3, Provider<RandomKeyProvider> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static ClickStreamCommonModule_ProvideOnDiskClickStreamEventStorageFactory create(Provider<FileStorage> provider, Provider<InHouseAnalyticsSettingsStorage> provider2, Provider<DiskStorageConverter<EventOuterClass.Event>> provider3, Provider<RandomKeyProvider> provider4) {
        return new ClickStreamCommonModule_ProvideOnDiskClickStreamEventStorageFactory(provider, provider2, provider3, provider4);
    }

    public static OnDiskEventStorage<EventOuterClass.Event> provideOnDiskClickStreamEventStorage(FileStorage fileStorage, InHouseAnalyticsSettingsStorage inHouseAnalyticsSettingsStorage, DiskStorageConverter<EventOuterClass.Event> diskStorageConverter, RandomKeyProvider randomKeyProvider) {
        return (OnDiskEventStorage) Preconditions.checkNotNullFromProvides(ClickStreamCommonModule.provideOnDiskClickStreamEventStorage(fileStorage, inHouseAnalyticsSettingsStorage, diskStorageConverter, randomKeyProvider));
    }

    @Override // javax.inject.Provider
    public OnDiskEventStorage<EventOuterClass.Event> get() {
        return provideOnDiskClickStreamEventStorage(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
