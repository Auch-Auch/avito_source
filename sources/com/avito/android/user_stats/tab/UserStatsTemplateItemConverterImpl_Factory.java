package com.avito.android.user_stats.tab;

import com.avito.android.util.RandomKeyProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserStatsTemplateItemConverterImpl_Factory implements Factory<UserStatsTemplateItemConverterImpl> {
    public final Provider<RandomKeyProvider> a;
    public final Provider<UserStatsChartBarItemConverter> b;

    public UserStatsTemplateItemConverterImpl_Factory(Provider<RandomKeyProvider> provider, Provider<UserStatsChartBarItemConverter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static UserStatsTemplateItemConverterImpl_Factory create(Provider<RandomKeyProvider> provider, Provider<UserStatsChartBarItemConverter> provider2) {
        return new UserStatsTemplateItemConverterImpl_Factory(provider, provider2);
    }

    public static UserStatsTemplateItemConverterImpl newInstance(RandomKeyProvider randomKeyProvider, UserStatsChartBarItemConverter userStatsChartBarItemConverter) {
        return new UserStatsTemplateItemConverterImpl(randomKeyProvider, userStatsChartBarItemConverter);
    }

    @Override // javax.inject.Provider
    public UserStatsTemplateItemConverterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
