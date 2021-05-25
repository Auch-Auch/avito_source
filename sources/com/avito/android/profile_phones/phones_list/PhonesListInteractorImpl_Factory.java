package com.avito.android.profile_phones.phones_list;

import com.avito.android.remote.ProfileApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PhonesListInteractorImpl_Factory implements Factory<PhonesListInteractorImpl> {
    public final Provider<PhonesConverter> a;
    public final Provider<ProfileApi> b;
    public final Provider<SchedulersFactory3> c;

    public PhonesListInteractorImpl_Factory(Provider<PhonesConverter> provider, Provider<ProfileApi> provider2, Provider<SchedulersFactory3> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static PhonesListInteractorImpl_Factory create(Provider<PhonesConverter> provider, Provider<ProfileApi> provider2, Provider<SchedulersFactory3> provider3) {
        return new PhonesListInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static PhonesListInteractorImpl newInstance(PhonesConverter phonesConverter, ProfileApi profileApi, SchedulersFactory3 schedulersFactory3) {
        return new PhonesListInteractorImpl(phonesConverter, profileApi, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public PhonesListInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
