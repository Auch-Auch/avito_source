package com.avito.android.profile_phones.landline_verification;

import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LandlinePhoneVerificationInteractor_Factory implements Factory<LandlinePhoneVerificationInteractor> {
    public final Provider<ProfileApi> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<TypedErrorThrowableConverter> c;

    public LandlinePhoneVerificationInteractor_Factory(Provider<ProfileApi> provider, Provider<SchedulersFactory3> provider2, Provider<TypedErrorThrowableConverter> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static LandlinePhoneVerificationInteractor_Factory create(Provider<ProfileApi> provider, Provider<SchedulersFactory3> provider2, Provider<TypedErrorThrowableConverter> provider3) {
        return new LandlinePhoneVerificationInteractor_Factory(provider, provider2, provider3);
    }

    public static LandlinePhoneVerificationInteractor newInstance(ProfileApi profileApi, SchedulersFactory3 schedulersFactory3, TypedErrorThrowableConverter typedErrorThrowableConverter) {
        return new LandlinePhoneVerificationInteractor(profileApi, schedulersFactory3, typedErrorThrowableConverter);
    }

    @Override // javax.inject.Provider
    public LandlinePhoneVerificationInteractor get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
