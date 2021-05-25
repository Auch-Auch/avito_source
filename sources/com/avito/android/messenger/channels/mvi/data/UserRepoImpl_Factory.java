package com.avito.android.messenger.channels.mvi.data;

import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.android.persistence.messenger.UserDao;
public final class UserRepoImpl_Factory implements Factory<UserRepoImpl> {
    public final Provider<UserDao> a;
    public final Provider<UserEntityConverter> b;

    public UserRepoImpl_Factory(Provider<UserDao> provider, Provider<UserEntityConverter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static UserRepoImpl_Factory create(Provider<UserDao> provider, Provider<UserEntityConverter> provider2) {
        return new UserRepoImpl_Factory(provider, provider2);
    }

    public static UserRepoImpl newInstance(UserDao userDao, UserEntityConverter userEntityConverter) {
        return new UserRepoImpl(userDao, userEntityConverter);
    }

    @Override // javax.inject.Provider
    public UserRepoImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
