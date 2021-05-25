package com.avito.android.user_stats;

import com.avito.android.analytics.Analytics;
import com.avito.android.user_stats.tracker.UserStatsTracker;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class UserStatsFragment_MembersInjector implements MembersInjector<UserStatsFragment> {
    public final Provider<Analytics> a;
    public final Provider<UserStatsViewModel> b;
    public final Provider<UserStatsTracker> c;

    public UserStatsFragment_MembersInjector(Provider<Analytics> provider, Provider<UserStatsViewModel> provider2, Provider<UserStatsTracker> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<UserStatsFragment> create(Provider<Analytics> provider, Provider<UserStatsViewModel> provider2, Provider<UserStatsTracker> provider3) {
        return new UserStatsFragment_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.user_stats.UserStatsFragment.analytics")
    public static void injectAnalytics(UserStatsFragment userStatsFragment, Analytics analytics) {
        userStatsFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.user_stats.UserStatsFragment.userStatsTracker")
    public static void injectUserStatsTracker(UserStatsFragment userStatsFragment, UserStatsTracker userStatsTracker) {
        userStatsFragment.userStatsTracker = userStatsTracker;
    }

    @InjectedFieldSignature("com.avito.android.user_stats.UserStatsFragment.viewModel")
    public static void injectViewModel(UserStatsFragment userStatsFragment, UserStatsViewModel userStatsViewModel) {
        userStatsFragment.viewModel = userStatsViewModel;
    }

    public void injectMembers(UserStatsFragment userStatsFragment) {
        injectAnalytics(userStatsFragment, this.a.get());
        injectViewModel(userStatsFragment, this.b.get());
        injectUserStatsTracker(userStatsFragment, this.c.get());
    }
}
