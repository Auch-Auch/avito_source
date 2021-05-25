package com.avito.android.code_confirmation;

import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PhoneAntihackInteractorImpl_Factory implements Factory<PhoneAntihackInteractorImpl> {
    public final Provider<ProfileApi> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<TypedErrorThrowableConverter> c;
    public final Provider<CodeConfirmationResourceProvider> d;

    public PhoneAntihackInteractorImpl_Factory(Provider<ProfileApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<CodeConfirmationResourceProvider> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static PhoneAntihackInteractorImpl_Factory create(Provider<ProfileApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<CodeConfirmationResourceProvider> provider4) {
        return new PhoneAntihackInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static PhoneAntihackInteractorImpl newInstance(ProfileApi profileApi, SchedulersFactory schedulersFactory, TypedErrorThrowableConverter typedErrorThrowableConverter, CodeConfirmationResourceProvider codeConfirmationResourceProvider) {
        return new PhoneAntihackInteractorImpl(profileApi, schedulersFactory, typedErrorThrowableConverter, codeConfirmationResourceProvider);
    }

    @Override // javax.inject.Provider
    public PhoneAntihackInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
