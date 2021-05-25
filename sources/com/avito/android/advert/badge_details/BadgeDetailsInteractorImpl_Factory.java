package com.avito.android.advert.badge_details;

import com.avito.android.advert_details.remote.AdvertDetailsApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BadgeDetailsInteractorImpl_Factory implements Factory<BadgeDetailsInteractorImpl> {
    public final Provider<AdvertDetailsApi> a;

    public BadgeDetailsInteractorImpl_Factory(Provider<AdvertDetailsApi> provider) {
        this.a = provider;
    }

    public static BadgeDetailsInteractorImpl_Factory create(Provider<AdvertDetailsApi> provider) {
        return new BadgeDetailsInteractorImpl_Factory(provider);
    }

    public static BadgeDetailsInteractorImpl newInstance(AdvertDetailsApi advertDetailsApi) {
        return new BadgeDetailsInteractorImpl(advertDetailsApi);
    }

    @Override // javax.inject.Provider
    public BadgeDetailsInteractorImpl get() {
        return newInstance(this.a.get());
    }
}
