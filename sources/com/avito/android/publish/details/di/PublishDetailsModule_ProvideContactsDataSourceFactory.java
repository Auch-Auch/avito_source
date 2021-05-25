package com.avito.android.publish.details.di;

import com.avito.android.publish.ContactsDataSource;
import com.avito.android.publish.ProfileSourceInteractor;
import com.avito.android.publish.details.analytics.PublishDetailsTracker;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvideContactsDataSourceFactory implements Factory<ContactsDataSource> {
    public final PublishDetailsModule a;
    public final Provider<ProfileSourceInteractor> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<PublishDetailsTracker> d;

    public PublishDetailsModule_ProvideContactsDataSourceFactory(PublishDetailsModule publishDetailsModule, Provider<ProfileSourceInteractor> provider, Provider<SchedulersFactory> provider2, Provider<PublishDetailsTracker> provider3) {
        this.a = publishDetailsModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static PublishDetailsModule_ProvideContactsDataSourceFactory create(PublishDetailsModule publishDetailsModule, Provider<ProfileSourceInteractor> provider, Provider<SchedulersFactory> provider2, Provider<PublishDetailsTracker> provider3) {
        return new PublishDetailsModule_ProvideContactsDataSourceFactory(publishDetailsModule, provider, provider2, provider3);
    }

    public static ContactsDataSource provideContactsDataSource(PublishDetailsModule publishDetailsModule, ProfileSourceInteractor profileSourceInteractor, SchedulersFactory schedulersFactory, PublishDetailsTracker publishDetailsTracker) {
        return (ContactsDataSource) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideContactsDataSource(profileSourceInteractor, schedulersFactory, publishDetailsTracker));
    }

    @Override // javax.inject.Provider
    public ContactsDataSource get() {
        return provideContactsDataSource(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
