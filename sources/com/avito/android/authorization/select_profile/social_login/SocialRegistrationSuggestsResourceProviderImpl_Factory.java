package com.avito.android.authorization.select_profile.social_login;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SocialRegistrationSuggestsResourceProviderImpl_Factory implements Factory<SocialRegistrationSuggestsResourceProviderImpl> {
    public final Provider<Resources> a;

    public SocialRegistrationSuggestsResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static SocialRegistrationSuggestsResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new SocialRegistrationSuggestsResourceProviderImpl_Factory(provider);
    }

    public static SocialRegistrationSuggestsResourceProviderImpl newInstance(Resources resources) {
        return new SocialRegistrationSuggestsResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public SocialRegistrationSuggestsResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
