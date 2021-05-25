package com.avito.android.contact_access;

import com.avito.android.remote.ProfileApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class IncompleteSocialInteractorImpl_Factory implements Factory<IncompleteSocialInteractorImpl> {
    public final Provider<ProfileApi> a;

    public IncompleteSocialInteractorImpl_Factory(Provider<ProfileApi> provider) {
        this.a = provider;
    }

    public static IncompleteSocialInteractorImpl_Factory create(Provider<ProfileApi> provider) {
        return new IncompleteSocialInteractorImpl_Factory(provider);
    }

    public static IncompleteSocialInteractorImpl newInstance(ProfileApi profileApi) {
        return new IncompleteSocialInteractorImpl(profileApi);
    }

    @Override // javax.inject.Provider
    public IncompleteSocialInteractorImpl get() {
        return newInstance(this.a.get());
    }
}
