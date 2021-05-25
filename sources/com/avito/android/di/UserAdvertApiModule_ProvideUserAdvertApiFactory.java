package com.avito.android.di;

import com.avito.android.remote.RetrofitFactory;
import com.avito.android.user_advert_api.remote.UserAdvertApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserAdvertApiModule_ProvideUserAdvertApiFactory implements Factory<UserAdvertApi> {
    public final Provider<RetrofitFactory> a;

    public UserAdvertApiModule_ProvideUserAdvertApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static UserAdvertApiModule_ProvideUserAdvertApiFactory create(Provider<RetrofitFactory> provider) {
        return new UserAdvertApiModule_ProvideUserAdvertApiFactory(provider);
    }

    public static UserAdvertApi provideUserAdvertApi(RetrofitFactory retrofitFactory) {
        return (UserAdvertApi) Preconditions.checkNotNullFromProvides(UserAdvertApiModule.INSTANCE.provideUserAdvertApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public UserAdvertApi get() {
        return provideUserAdvertApi(this.a.get());
    }
}
