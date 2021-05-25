package com.avito.android.search.map.view;

import android.app.Activity;
import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SerpListResourcesProviderImpl_Factory implements Factory<SerpListResourcesProviderImpl> {
    public final Provider<Activity> a;
    public final Provider<Resources> b;

    public SerpListResourcesProviderImpl_Factory(Provider<Activity> provider, Provider<Resources> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SerpListResourcesProviderImpl_Factory create(Provider<Activity> provider, Provider<Resources> provider2) {
        return new SerpListResourcesProviderImpl_Factory(provider, provider2);
    }

    public static SerpListResourcesProviderImpl newInstance(Activity activity, Resources resources) {
        return new SerpListResourcesProviderImpl(activity, resources);
    }

    @Override // javax.inject.Provider
    public SerpListResourcesProviderImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
