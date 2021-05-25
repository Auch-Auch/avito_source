package com.avito.android.di.module;

import com.avito.android.remote.RetrofitFactory;
import com.avito.android.remote.UserAdvertsCommonApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserAdvertsCommonApiModule_ProvideUserAdvertApiFactory implements Factory<UserAdvertsCommonApi> {
    public final Provider<RetrofitFactory> a;

    public UserAdvertsCommonApiModule_ProvideUserAdvertApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static UserAdvertsCommonApiModule_ProvideUserAdvertApiFactory create(Provider<RetrofitFactory> provider) {
        return new UserAdvertsCommonApiModule_ProvideUserAdvertApiFactory(provider);
    }

    public static UserAdvertsCommonApi provideUserAdvertApi(RetrofitFactory retrofitFactory) {
        return (UserAdvertsCommonApi) Preconditions.checkNotNullFromProvides(UserAdvertsCommonApiModule.INSTANCE.provideUserAdvertApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public UserAdvertsCommonApi get() {
        return provideUserAdvertApi(this.a.get());
    }
}
