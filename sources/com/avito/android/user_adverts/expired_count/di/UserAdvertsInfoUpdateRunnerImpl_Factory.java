package com.avito.android.user_adverts.expired_count.di;

import dagger.internal.Factory;
public final class UserAdvertsInfoUpdateRunnerImpl_Factory implements Factory<UserAdvertsInfoUpdateRunnerImpl> {

    public static final class a {
        public static final UserAdvertsInfoUpdateRunnerImpl_Factory a = new UserAdvertsInfoUpdateRunnerImpl_Factory();
    }

    public static UserAdvertsInfoUpdateRunnerImpl_Factory create() {
        return a.a;
    }

    public static UserAdvertsInfoUpdateRunnerImpl newInstance() {
        return new UserAdvertsInfoUpdateRunnerImpl();
    }

    @Override // javax.inject.Provider
    public UserAdvertsInfoUpdateRunnerImpl get() {
        return newInstance();
    }
}
