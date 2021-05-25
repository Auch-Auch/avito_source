package com.avito.android.app_rater;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AppRaterInteractorImpl_Factory implements Factory<AppRaterInteractorImpl> {
    public final Provider<AppRaterSessionStorage> a;

    public AppRaterInteractorImpl_Factory(Provider<AppRaterSessionStorage> provider) {
        this.a = provider;
    }

    public static AppRaterInteractorImpl_Factory create(Provider<AppRaterSessionStorage> provider) {
        return new AppRaterInteractorImpl_Factory(provider);
    }

    public static AppRaterInteractorImpl newInstance(AppRaterSessionStorage appRaterSessionStorage) {
        return new AppRaterInteractorImpl(appRaterSessionStorage);
    }

    @Override // javax.inject.Provider
    public AppRaterInteractorImpl get() {
        return newInstance(this.a.get());
    }
}
