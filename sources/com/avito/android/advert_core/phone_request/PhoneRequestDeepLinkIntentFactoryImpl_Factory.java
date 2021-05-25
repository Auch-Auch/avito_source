package com.avito.android.advert_core.phone_request;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PhoneRequestDeepLinkIntentFactoryImpl_Factory implements Factory<PhoneRequestDeepLinkIntentFactoryImpl> {
    public final Provider<Application> a;

    public PhoneRequestDeepLinkIntentFactoryImpl_Factory(Provider<Application> provider) {
        this.a = provider;
    }

    public static PhoneRequestDeepLinkIntentFactoryImpl_Factory create(Provider<Application> provider) {
        return new PhoneRequestDeepLinkIntentFactoryImpl_Factory(provider);
    }

    public static PhoneRequestDeepLinkIntentFactoryImpl newInstance(Application application) {
        return new PhoneRequestDeepLinkIntentFactoryImpl(application);
    }

    @Override // javax.inject.Provider
    public PhoneRequestDeepLinkIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
