package com.avito.android.profile_phones.landline_verification;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class LandlinePhoneVerificationVMFactory_Factory implements Factory<LandlinePhoneVerificationVMFactory> {
    public final Provider<LandlinePhoneVerificationInteractor> a;

    public LandlinePhoneVerificationVMFactory_Factory(Provider<LandlinePhoneVerificationInteractor> provider) {
        this.a = provider;
    }

    public static LandlinePhoneVerificationVMFactory_Factory create(Provider<LandlinePhoneVerificationInteractor> provider) {
        return new LandlinePhoneVerificationVMFactory_Factory(provider);
    }

    public static LandlinePhoneVerificationVMFactory newInstance(LandlinePhoneVerificationInteractor landlinePhoneVerificationInteractor) {
        return new LandlinePhoneVerificationVMFactory(landlinePhoneVerificationInteractor);
    }

    @Override // javax.inject.Provider
    public LandlinePhoneVerificationVMFactory get() {
        return newInstance(this.a.get());
    }
}
