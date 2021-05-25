package com.avito.android.extended_profile;

import com.avito.android.remote.ExtendedProfileApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ExtendedProfileContactsInteractorImpl_Factory implements Factory<ExtendedProfileContactsInteractorImpl> {
    public final Provider<ExtendedProfileApi> a;
    public final Provider<SchedulersFactory3> b;

    public ExtendedProfileContactsInteractorImpl_Factory(Provider<ExtendedProfileApi> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ExtendedProfileContactsInteractorImpl_Factory create(Provider<ExtendedProfileApi> provider, Provider<SchedulersFactory3> provider2) {
        return new ExtendedProfileContactsInteractorImpl_Factory(provider, provider2);
    }

    public static ExtendedProfileContactsInteractorImpl newInstance(ExtendedProfileApi extendedProfileApi, SchedulersFactory3 schedulersFactory3) {
        return new ExtendedProfileContactsInteractorImpl(extendedProfileApi, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public ExtendedProfileContactsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
