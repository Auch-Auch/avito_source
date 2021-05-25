package com.avito.android.home;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class HomePresenterResourcesProviderImpl_Factory implements Factory<HomePresenterResourcesProviderImpl> {
    public final Provider<Resources> a;

    public HomePresenterResourcesProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static HomePresenterResourcesProviderImpl_Factory create(Provider<Resources> provider) {
        return new HomePresenterResourcesProviderImpl_Factory(provider);
    }

    public static HomePresenterResourcesProviderImpl newInstance(Resources resources) {
        return new HomePresenterResourcesProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public HomePresenterResourcesProviderImpl get() {
        return newInstance(this.a.get());
    }
}
