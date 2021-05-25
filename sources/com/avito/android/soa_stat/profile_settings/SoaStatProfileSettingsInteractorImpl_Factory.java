package com.avito.android.soa_stat.profile_settings;

import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SoaStatProfileSettingsInteractorImpl_Factory implements Factory<SoaStatProfileSettingsInteractorImpl> {
    public final Provider<ProfileApi> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<TypedErrorThrowableConverter> c;

    public SoaStatProfileSettingsInteractorImpl_Factory(Provider<ProfileApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static SoaStatProfileSettingsInteractorImpl_Factory create(Provider<ProfileApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3) {
        return new SoaStatProfileSettingsInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static SoaStatProfileSettingsInteractorImpl newInstance(ProfileApi profileApi, SchedulersFactory schedulersFactory, TypedErrorThrowableConverter typedErrorThrowableConverter) {
        return new SoaStatProfileSettingsInteractorImpl(profileApi, schedulersFactory, typedErrorThrowableConverter);
    }

    @Override // javax.inject.Provider
    public SoaStatProfileSettingsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
