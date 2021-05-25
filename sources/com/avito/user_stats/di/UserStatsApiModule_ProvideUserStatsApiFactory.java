package com.avito.user_stats.di;

import com.avito.android.remote.RetrofitFactory;
import com.avito.user_stats.UserStatsApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserStatsApiModule_ProvideUserStatsApiFactory implements Factory<UserStatsApi> {
    public final Provider<RetrofitFactory> a;

    public UserStatsApiModule_ProvideUserStatsApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static UserStatsApiModule_ProvideUserStatsApiFactory create(Provider<RetrofitFactory> provider) {
        return new UserStatsApiModule_ProvideUserStatsApiFactory(provider);
    }

    public static UserStatsApi provideUserStatsApi(RetrofitFactory retrofitFactory) {
        return (UserStatsApi) Preconditions.checkNotNullFromProvides(UserStatsApiModule.INSTANCE.provideUserStatsApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public UserStatsApi get() {
        return provideUserStatsApi(this.a.get());
    }
}
