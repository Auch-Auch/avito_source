package com.avito.android.profile.tfa.settings;

import com.avito.android.remote.ProfileApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class TfaSettingsInteractorImpl_Factory implements Factory<TfaSettingsInteractorImpl> {
    public final Provider<ProfileApi> a;
    public final Provider<SchedulersFactory3> b;

    public TfaSettingsInteractorImpl_Factory(Provider<ProfileApi> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static TfaSettingsInteractorImpl_Factory create(Provider<ProfileApi> provider, Provider<SchedulersFactory3> provider2) {
        return new TfaSettingsInteractorImpl_Factory(provider, provider2);
    }

    public static TfaSettingsInteractorImpl newInstance(ProfileApi profileApi, SchedulersFactory3 schedulersFactory3) {
        return new TfaSettingsInteractorImpl(profileApi, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public TfaSettingsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
