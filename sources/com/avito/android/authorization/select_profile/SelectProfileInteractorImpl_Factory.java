package com.avito.android.authorization.select_profile;

import com.avito.android.remote.ProfileApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SelectProfileInteractorImpl_Factory implements Factory<SelectProfileInteractorImpl> {
    public final Provider<String> a;
    public final Provider<ProfileApi> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<SelectProfileResourceProvider> d;

    public SelectProfileInteractorImpl_Factory(Provider<String> provider, Provider<ProfileApi> provider2, Provider<SchedulersFactory3> provider3, Provider<SelectProfileResourceProvider> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static SelectProfileInteractorImpl_Factory create(Provider<String> provider, Provider<ProfileApi> provider2, Provider<SchedulersFactory3> provider3, Provider<SelectProfileResourceProvider> provider4) {
        return new SelectProfileInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static SelectProfileInteractorImpl newInstance(String str, ProfileApi profileApi, SchedulersFactory3 schedulersFactory3, SelectProfileResourceProvider selectProfileResourceProvider) {
        return new SelectProfileInteractorImpl(str, profileApi, schedulersFactory3, selectProfileResourceProvider);
    }

    @Override // javax.inject.Provider
    public SelectProfileInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
