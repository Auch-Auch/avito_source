package com.avito.android.user_advert;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserAdvertIntentFactoryImpl_Factory implements Factory<UserAdvertIntentFactoryImpl> {
    public final Provider<Context> a;

    public UserAdvertIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static UserAdvertIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new UserAdvertIntentFactoryImpl_Factory(provider);
    }

    public static UserAdvertIntentFactoryImpl newInstance(Context context) {
        return new UserAdvertIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public UserAdvertIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
