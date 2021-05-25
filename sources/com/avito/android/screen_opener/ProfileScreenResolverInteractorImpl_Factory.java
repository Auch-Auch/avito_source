package com.avito.android.screen_opener;

import com.avito.android.public_profile.remote.PublicProfileApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ProfileScreenResolverInteractorImpl_Factory implements Factory<ProfileScreenResolverInteractorImpl> {
    public final Provider<PublicProfileApi> a;
    public final Provider<SchedulersFactory3> b;

    public ProfileScreenResolverInteractorImpl_Factory(Provider<PublicProfileApi> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ProfileScreenResolverInteractorImpl_Factory create(Provider<PublicProfileApi> provider, Provider<SchedulersFactory3> provider2) {
        return new ProfileScreenResolverInteractorImpl_Factory(provider, provider2);
    }

    public static ProfileScreenResolverInteractorImpl newInstance(PublicProfileApi publicProfileApi, SchedulersFactory3 schedulersFactory3) {
        return new ProfileScreenResolverInteractorImpl(publicProfileApi, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public ProfileScreenResolverInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
