package com.avito.android.user_stats.tab;

import com.avito.android.analytics.Analytics;
import com.avito.android.user_stats.UserStatsViewModel;
import com.avito.android.util.SchedulersFactory3;
import com.avito.user_stats.model.UserStatsTabData;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserStatsTabViewModelFactory_Factory implements Factory<UserStatsTabViewModelFactory> {
    public final Provider<UserStatsTabInteractor> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<UserStatsTabData> c;
    public final Provider<Analytics> d;
    public final Provider<UserStatsViewModel> e;

    public UserStatsTabViewModelFactory_Factory(Provider<UserStatsTabInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<UserStatsTabData> provider3, Provider<Analytics> provider4, Provider<UserStatsViewModel> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static UserStatsTabViewModelFactory_Factory create(Provider<UserStatsTabInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<UserStatsTabData> provider3, Provider<Analytics> provider4, Provider<UserStatsViewModel> provider5) {
        return new UserStatsTabViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static UserStatsTabViewModelFactory newInstance(UserStatsTabInteractor userStatsTabInteractor, SchedulersFactory3 schedulersFactory3, UserStatsTabData userStatsTabData, Analytics analytics, UserStatsViewModel userStatsViewModel) {
        return new UserStatsTabViewModelFactory(userStatsTabInteractor, schedulersFactory3, userStatsTabData, analytics, userStatsViewModel);
    }

    @Override // javax.inject.Provider
    public UserStatsTabViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
