package com.avito.android.publish.drafts.di;

import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.publish.drafts.analytics.PublishSessionIdGenerator;
import com.avito.android.remote.DeviceIdProvider;
import com.avito.android.server_time.TimeSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDraftsModule_ProvideAdvertIdGeneratorFactory implements Factory<PublishSessionIdGenerator> {
    public final Provider<TimeSource> a;
    public final Provider<AccountStorageInteractor> b;
    public final Provider<DeviceIdProvider> c;

    public PublishDraftsModule_ProvideAdvertIdGeneratorFactory(Provider<TimeSource> provider, Provider<AccountStorageInteractor> provider2, Provider<DeviceIdProvider> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static PublishDraftsModule_ProvideAdvertIdGeneratorFactory create(Provider<TimeSource> provider, Provider<AccountStorageInteractor> provider2, Provider<DeviceIdProvider> provider3) {
        return new PublishDraftsModule_ProvideAdvertIdGeneratorFactory(provider, provider2, provider3);
    }

    public static PublishSessionIdGenerator provideAdvertIdGenerator(TimeSource timeSource, AccountStorageInteractor accountStorageInteractor, DeviceIdProvider deviceIdProvider) {
        return (PublishSessionIdGenerator) Preconditions.checkNotNullFromProvides(PublishDraftsModule.provideAdvertIdGenerator(timeSource, accountStorageInteractor, deviceIdProvider));
    }

    @Override // javax.inject.Provider
    public PublishSessionIdGenerator get() {
        return provideAdvertIdGenerator(this.a.get(), this.b.get(), this.c.get());
    }
}
