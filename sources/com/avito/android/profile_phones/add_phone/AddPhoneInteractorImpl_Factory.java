package com.avito.android.profile_phones.add_phone;

import com.avito.android.code_confirmation.phone_confirm.PhoneConfirmResourceProvider;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AddPhoneInteractorImpl_Factory implements Factory<AddPhoneInteractorImpl> {
    public final Provider<ProfileApi> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<TypedErrorThrowableConverter> c;
    public final Provider<PhoneConfirmResourceProvider> d;

    public AddPhoneInteractorImpl_Factory(Provider<ProfileApi> provider, Provider<SchedulersFactory3> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<PhoneConfirmResourceProvider> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static AddPhoneInteractorImpl_Factory create(Provider<ProfileApi> provider, Provider<SchedulersFactory3> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<PhoneConfirmResourceProvider> provider4) {
        return new AddPhoneInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static AddPhoneInteractorImpl newInstance(ProfileApi profileApi, SchedulersFactory3 schedulersFactory3, TypedErrorThrowableConverter typedErrorThrowableConverter, PhoneConfirmResourceProvider phoneConfirmResourceProvider) {
        return new AddPhoneInteractorImpl(profileApi, schedulersFactory3, typedErrorThrowableConverter, phoneConfirmResourceProvider);
    }

    @Override // javax.inject.Provider
    public AddPhoneInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
