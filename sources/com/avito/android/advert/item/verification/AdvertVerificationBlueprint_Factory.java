package com.avito.android.advert.item.verification;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertVerificationBlueprint_Factory implements Factory<AdvertVerificationBlueprint> {
    public final Provider<AdvertVerificationPresenter> a;

    public AdvertVerificationBlueprint_Factory(Provider<AdvertVerificationPresenter> provider) {
        this.a = provider;
    }

    public static AdvertVerificationBlueprint_Factory create(Provider<AdvertVerificationPresenter> provider) {
        return new AdvertVerificationBlueprint_Factory(provider);
    }

    public static AdvertVerificationBlueprint newInstance(AdvertVerificationPresenter advertVerificationPresenter) {
        return new AdvertVerificationBlueprint(advertVerificationPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertVerificationBlueprint get() {
        return newInstance(this.a.get());
    }
}
