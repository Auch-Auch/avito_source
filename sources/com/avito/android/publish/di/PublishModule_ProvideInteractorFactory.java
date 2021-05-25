package com.avito.android.publish.di;

import com.avito.android.publish.ProfileSourceInteractor;
import com.avito.android.publish.analytics.PublishContactsTracker;
import com.avito.android.remote.ProfileApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishModule_ProvideInteractorFactory implements Factory<ProfileSourceInteractor> {
    public final PublishModule a;
    public final Provider<ProfileApi> b;
    public final Provider<PublishContactsTracker> c;
    public final Provider<SchedulersFactory> d;

    public PublishModule_ProvideInteractorFactory(PublishModule publishModule, Provider<ProfileApi> provider, Provider<PublishContactsTracker> provider2, Provider<SchedulersFactory> provider3) {
        this.a = publishModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static PublishModule_ProvideInteractorFactory create(PublishModule publishModule, Provider<ProfileApi> provider, Provider<PublishContactsTracker> provider2, Provider<SchedulersFactory> provider3) {
        return new PublishModule_ProvideInteractorFactory(publishModule, provider, provider2, provider3);
    }

    public static ProfileSourceInteractor provideInteractor(PublishModule publishModule, ProfileApi profileApi, PublishContactsTracker publishContactsTracker, SchedulersFactory schedulersFactory) {
        return (ProfileSourceInteractor) Preconditions.checkNotNullFromProvides(publishModule.provideInteractor(profileApi, publishContactsTracker, schedulersFactory));
    }

    @Override // javax.inject.Provider
    public ProfileSourceInteractor get() {
        return provideInteractor(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
