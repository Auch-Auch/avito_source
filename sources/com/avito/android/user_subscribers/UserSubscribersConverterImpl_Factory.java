package com.avito.android.user_subscribers;

import dagger.internal.Factory;
public final class UserSubscribersConverterImpl_Factory implements Factory<UserSubscribersConverterImpl> {

    public static final class a {
        public static final UserSubscribersConverterImpl_Factory a = new UserSubscribersConverterImpl_Factory();
    }

    public static UserSubscribersConverterImpl_Factory create() {
        return a.a;
    }

    public static UserSubscribersConverterImpl newInstance() {
        return new UserSubscribersConverterImpl();
    }

    @Override // javax.inject.Provider
    public UserSubscribersConverterImpl get() {
        return newInstance();
    }
}
