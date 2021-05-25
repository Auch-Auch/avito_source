package com.avito.android.user_advert;

import dagger.internal.Factory;
public final class UserAdvertsInfoCacheImpl_Factory implements Factory<UserAdvertsInfoCacheImpl> {

    public static final class a {
        public static final UserAdvertsInfoCacheImpl_Factory a = new UserAdvertsInfoCacheImpl_Factory();
    }

    public static UserAdvertsInfoCacheImpl_Factory create() {
        return a.a;
    }

    public static UserAdvertsInfoCacheImpl newInstance() {
        return new UserAdvertsInfoCacheImpl();
    }

    @Override // javax.inject.Provider
    public UserAdvertsInfoCacheImpl get() {
        return newInstance();
    }
}
