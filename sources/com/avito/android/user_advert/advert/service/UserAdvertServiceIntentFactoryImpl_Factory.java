package com.avito.android.user_advert.advert.service;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserAdvertServiceIntentFactoryImpl_Factory implements Factory<UserAdvertServiceIntentFactoryImpl> {
    public final Provider<Context> a;

    public UserAdvertServiceIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static UserAdvertServiceIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new UserAdvertServiceIntentFactoryImpl_Factory(provider);
    }

    public static UserAdvertServiceIntentFactoryImpl newInstance(Context context) {
        return new UserAdvertServiceIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public UserAdvertServiceIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
