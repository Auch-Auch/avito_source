package com.avito.android.remote.di;

import com.avito.android.remote.RetrofitFactory;
import com.avito.android.user_adverts.remote.UserAdvertsApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserAdvertsApiModule_ProvideUserAdvertsApiFactory implements Factory<UserAdvertsApi> {
    public final Provider<RetrofitFactory> a;

    public UserAdvertsApiModule_ProvideUserAdvertsApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static UserAdvertsApiModule_ProvideUserAdvertsApiFactory create(Provider<RetrofitFactory> provider) {
        return new UserAdvertsApiModule_ProvideUserAdvertsApiFactory(provider);
    }

    public static UserAdvertsApi provideUserAdvertsApi(RetrofitFactory retrofitFactory) {
        return (UserAdvertsApi) Preconditions.checkNotNullFromProvides(UserAdvertsApiModule.INSTANCE.provideUserAdvertsApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public UserAdvertsApi get() {
        return provideUserAdvertsApi(this.a.get());
    }
}
