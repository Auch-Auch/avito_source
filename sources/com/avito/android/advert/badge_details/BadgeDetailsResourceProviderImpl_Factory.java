package com.avito.android.advert.badge_details;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BadgeDetailsResourceProviderImpl_Factory implements Factory<BadgeDetailsResourceProviderImpl> {
    public final Provider<Resources> a;

    public BadgeDetailsResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static BadgeDetailsResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new BadgeDetailsResourceProviderImpl_Factory(provider);
    }

    public static BadgeDetailsResourceProviderImpl newInstance(Resources resources) {
        return new BadgeDetailsResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public BadgeDetailsResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
