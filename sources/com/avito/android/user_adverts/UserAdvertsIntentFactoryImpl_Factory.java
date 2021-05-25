package com.avito.android.user_adverts;

import com.avito.android.CoreActivityIntentFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserAdvertsIntentFactoryImpl_Factory implements Factory<UserAdvertsIntentFactoryImpl> {
    public final Provider<CoreActivityIntentFactory> a;

    public UserAdvertsIntentFactoryImpl_Factory(Provider<CoreActivityIntentFactory> provider) {
        this.a = provider;
    }

    public static UserAdvertsIntentFactoryImpl_Factory create(Provider<CoreActivityIntentFactory> provider) {
        return new UserAdvertsIntentFactoryImpl_Factory(provider);
    }

    public static UserAdvertsIntentFactoryImpl newInstance(CoreActivityIntentFactory coreActivityIntentFactory) {
        return new UserAdvertsIntentFactoryImpl(coreActivityIntentFactory);
    }

    @Override // javax.inject.Provider
    public UserAdvertsIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
