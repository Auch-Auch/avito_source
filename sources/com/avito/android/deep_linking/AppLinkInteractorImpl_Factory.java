package com.avito.android.deep_linking;

import com.avito.android.deep_linking.remote.DeeplinkApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AppLinkInteractorImpl_Factory implements Factory<AppLinkInteractorImpl> {
    public final Provider<DeeplinkApi> a;
    public final Provider<SchedulersFactory> b;

    public AppLinkInteractorImpl_Factory(Provider<DeeplinkApi> provider, Provider<SchedulersFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AppLinkInteractorImpl_Factory create(Provider<DeeplinkApi> provider, Provider<SchedulersFactory> provider2) {
        return new AppLinkInteractorImpl_Factory(provider, provider2);
    }

    public static AppLinkInteractorImpl newInstance(DeeplinkApi deeplinkApi, SchedulersFactory schedulersFactory) {
        return new AppLinkInteractorImpl(deeplinkApi, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public AppLinkInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
