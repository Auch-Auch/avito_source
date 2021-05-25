package com.avito.android.info.business;

import com.avito.android.remote.InfoApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class InfoInteractorImpl_Factory implements Factory<InfoInteractorImpl> {
    public final Provider<InfoApi> a;
    public final Provider<String> b;

    public InfoInteractorImpl_Factory(Provider<InfoApi> provider, Provider<String> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static InfoInteractorImpl_Factory create(Provider<InfoApi> provider, Provider<String> provider2) {
        return new InfoInteractorImpl_Factory(provider, provider2);
    }

    public static InfoInteractorImpl newInstance(InfoApi infoApi, String str) {
        return new InfoInteractorImpl(infoApi, str);
    }

    @Override // javax.inject.Provider
    public InfoInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
