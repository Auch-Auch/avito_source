package com.avito.android.user_stats.di;

import com.avito.android.user_stats.tab.UserStatsProvider;
import com.avito.user_stats.model.UserStatsTabData;
import dagger.internal.Factory;
import javax.inject.Provider;
import org.jetbrains.annotations.Nullable;
public final class UserStatsTabModule_ProvideTabModelFactory implements Factory<UserStatsTabData> {
    public final Provider<String> a;
    public final Provider<UserStatsProvider> b;

    public UserStatsTabModule_ProvideTabModelFactory(Provider<String> provider, Provider<UserStatsProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static UserStatsTabModule_ProvideTabModelFactory create(Provider<String> provider, Provider<UserStatsProvider> provider2) {
        return new UserStatsTabModule_ProvideTabModelFactory(provider, provider2);
    }

    @Nullable
    public static UserStatsTabData provideTabModel(String str, UserStatsProvider userStatsProvider) {
        return UserStatsTabModule.INSTANCE.provideTabModel(str, userStatsProvider);
    }

    @Override // javax.inject.Provider
    @Nullable
    public UserStatsTabData get() {
        return provideTabModel(this.a.get(), this.b.get());
    }
}
