package com.avito.android.user_adverts.expired_count;

import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.preferences.UserAdvertsInfoStorage;
import com.avito.android.user_advert.UserAdvertsInfoCache;
import com.avito.android.user_adverts.remote.UserAdvertsApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserAdvertsInfoInteractorImpl_Factory implements Factory<UserAdvertsInfoInteractorImpl> {
    public final Provider<UserAdvertsApi> a;
    public final Provider<UserAdvertsInfoStorage> b;
    public final Provider<AccountStorageInteractor> c;
    public final Provider<UserAdvertsInfoCache> d;

    public UserAdvertsInfoInteractorImpl_Factory(Provider<UserAdvertsApi> provider, Provider<UserAdvertsInfoStorage> provider2, Provider<AccountStorageInteractor> provider3, Provider<UserAdvertsInfoCache> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static UserAdvertsInfoInteractorImpl_Factory create(Provider<UserAdvertsApi> provider, Provider<UserAdvertsInfoStorage> provider2, Provider<AccountStorageInteractor> provider3, Provider<UserAdvertsInfoCache> provider4) {
        return new UserAdvertsInfoInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static UserAdvertsInfoInteractorImpl newInstance(UserAdvertsApi userAdvertsApi, UserAdvertsInfoStorage userAdvertsInfoStorage, AccountStorageInteractor accountStorageInteractor, UserAdvertsInfoCache userAdvertsInfoCache) {
        return new UserAdvertsInfoInteractorImpl(userAdvertsApi, userAdvertsInfoStorage, accountStorageInteractor, userAdvertsInfoCache);
    }

    @Override // javax.inject.Provider
    public UserAdvertsInfoInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
