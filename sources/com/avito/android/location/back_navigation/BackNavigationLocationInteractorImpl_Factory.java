package com.avito.android.location.back_navigation;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class BackNavigationLocationInteractorImpl_Factory implements Factory<BackNavigationLocationInteractorImpl> {
    public final Provider<BackNavigationLocationStorage> a;

    public BackNavigationLocationInteractorImpl_Factory(Provider<BackNavigationLocationStorage> provider) {
        this.a = provider;
    }

    public static BackNavigationLocationInteractorImpl_Factory create(Provider<BackNavigationLocationStorage> provider) {
        return new BackNavigationLocationInteractorImpl_Factory(provider);
    }

    public static BackNavigationLocationInteractorImpl newInstance(BackNavigationLocationStorage backNavigationLocationStorage) {
        return new BackNavigationLocationInteractorImpl(backNavigationLocationStorage);
    }

    @Override // javax.inject.Provider
    public BackNavigationLocationInteractorImpl get() {
        return newInstance(this.a.get());
    }
}
