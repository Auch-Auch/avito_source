package com.avito.android.safedeal.profile_settings;

import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.safedeal.remote.SafeDealApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ProfileDeliverySettingsInteractorImpl_Factory implements Factory<ProfileDeliverySettingsInteractorImpl> {
    public final Provider<SafeDealApi> a;
    public final Provider<TypedErrorThrowableConverter> b;
    public final Provider<SchedulersFactory3> c;

    public ProfileDeliverySettingsInteractorImpl_Factory(Provider<SafeDealApi> provider, Provider<TypedErrorThrowableConverter> provider2, Provider<SchedulersFactory3> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static ProfileDeliverySettingsInteractorImpl_Factory create(Provider<SafeDealApi> provider, Provider<TypedErrorThrowableConverter> provider2, Provider<SchedulersFactory3> provider3) {
        return new ProfileDeliverySettingsInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static ProfileDeliverySettingsInteractorImpl newInstance(SafeDealApi safeDealApi, TypedErrorThrowableConverter typedErrorThrowableConverter, SchedulersFactory3 schedulersFactory3) {
        return new ProfileDeliverySettingsInteractorImpl(safeDealApi, typedErrorThrowableConverter, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public ProfileDeliverySettingsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
