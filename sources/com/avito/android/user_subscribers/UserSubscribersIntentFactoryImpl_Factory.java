package com.avito.android.user_subscribers;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserSubscribersIntentFactoryImpl_Factory implements Factory<UserSubscribersIntentFactoryImpl> {
    public final Provider<Context> a;

    public UserSubscribersIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static UserSubscribersIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new UserSubscribersIntentFactoryImpl_Factory(provider);
    }

    public static UserSubscribersIntentFactoryImpl newInstance(Context context) {
        return new UserSubscribersIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public UserSubscribersIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
