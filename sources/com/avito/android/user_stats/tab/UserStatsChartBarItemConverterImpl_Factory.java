package com.avito.android.user_stats.tab;

import com.avito.android.user_stats.UserStatsResourcesProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserStatsChartBarItemConverterImpl_Factory implements Factory<UserStatsChartBarItemConverterImpl> {
    public final Provider<UserStatsResourcesProvider> a;

    public UserStatsChartBarItemConverterImpl_Factory(Provider<UserStatsResourcesProvider> provider) {
        this.a = provider;
    }

    public static UserStatsChartBarItemConverterImpl_Factory create(Provider<UserStatsResourcesProvider> provider) {
        return new UserStatsChartBarItemConverterImpl_Factory(provider);
    }

    public static UserStatsChartBarItemConverterImpl newInstance(UserStatsResourcesProvider userStatsResourcesProvider) {
        return new UserStatsChartBarItemConverterImpl(userStatsResourcesProvider);
    }

    @Override // javax.inject.Provider
    public UserStatsChartBarItemConverterImpl get() {
        return newInstance(this.a.get());
    }
}
