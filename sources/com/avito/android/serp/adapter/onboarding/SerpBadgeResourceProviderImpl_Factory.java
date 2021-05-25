package com.avito.android.serp.adapter.onboarding;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SerpBadgeResourceProviderImpl_Factory implements Factory<SerpBadgeResourceProviderImpl> {
    public final Provider<Resources> a;

    public SerpBadgeResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static SerpBadgeResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new SerpBadgeResourceProviderImpl_Factory(provider);
    }

    public static SerpBadgeResourceProviderImpl newInstance(Resources resources) {
        return new SerpBadgeResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public SerpBadgeResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
