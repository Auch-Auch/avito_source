package com.avito.android.authorization.phone_proving;

import com.avito.android.remote.ProfileApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PhoneProvingInteractorImpl_Factory implements Factory<PhoneProvingInteractorImpl> {
    public final Provider<ProfileApi> a;
    public final Provider<SchedulersFactory> b;

    public PhoneProvingInteractorImpl_Factory(Provider<ProfileApi> provider, Provider<SchedulersFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static PhoneProvingInteractorImpl_Factory create(Provider<ProfileApi> provider, Provider<SchedulersFactory> provider2) {
        return new PhoneProvingInteractorImpl_Factory(provider, provider2);
    }

    public static PhoneProvingInteractorImpl newInstance(ProfileApi profileApi, SchedulersFactory schedulersFactory) {
        return new PhoneProvingInteractorImpl(profileApi, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public PhoneProvingInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
