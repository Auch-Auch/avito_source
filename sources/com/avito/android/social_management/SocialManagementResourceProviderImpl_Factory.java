package com.avito.android.social_management;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SocialManagementResourceProviderImpl_Factory implements Factory<SocialManagementResourceProviderImpl> {
    public final Provider<Resources> a;

    public SocialManagementResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static SocialManagementResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new SocialManagementResourceProviderImpl_Factory(provider);
    }

    public static SocialManagementResourceProviderImpl newInstance(Resources resources) {
        return new SocialManagementResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public SocialManagementResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
