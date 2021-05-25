package com.avito.android.user_stats.di;

import android.content.res.Resources;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.user_stats.UserStatsResourcesProvider;
import com.avito.android.user_stats.UserStatsViewModel;
import com.avito.android.user_stats.tab.ActiveMonthIndexHolder;
import com.avito.android.user_stats.tab.UserStatsProvider;
import com.avito.user_stats.UserStatsApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/avito/android/user_stats/di/UserStatsTabDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/user_stats/tab/UserStatsProvider;", "userStatsProvider", "()Lcom/avito/android/user_stats/tab/UserStatsProvider;", "Lcom/avito/android/user_stats/tab/ActiveMonthIndexHolder;", "activeMonthIndexHolder", "()Lcom/avito/android/user_stats/tab/ActiveMonthIndexHolder;", "Landroid/content/res/Resources;", "resources", "()Landroid/content/res/Resources;", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "Lcom/avito/user_stats/UserStatsApi;", "userStatsApi", "()Lcom/avito/user_stats/UserStatsApi;", "Lcom/avito/android/user_stats/UserStatsResourcesProvider;", "userStatsResourcesProvider", "()Lcom/avito/android/user_stats/UserStatsResourcesProvider;", "Lcom/avito/android/user_stats/UserStatsViewModel;", "userStatsViewModel", "()Lcom/avito/android/user_stats/UserStatsViewModel;", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "screenTrackerFactory", "()Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "Lcom/avito/android/analytics/screens/TimerFactory;", "timerFactory", "()Lcom/avito/android/analytics/screens/TimerFactory;", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public interface UserStatsTabDependencies extends CoreComponentDependencies {
    @NotNull
    ActiveMonthIndexHolder activeMonthIndexHolder();

    @NotNull
    DeepLinkIntentFactory deepLinkIntentFactory();

    @NotNull
    Resources resources();

    @NotNull
    ScreenTrackerFactory screenTrackerFactory();

    @NotNull
    TimerFactory timerFactory();

    @NotNull
    UserStatsApi userStatsApi();

    @NotNull
    UserStatsProvider userStatsProvider();

    @NotNull
    UserStatsResourcesProvider userStatsResourcesProvider();

    @NotNull
    UserStatsViewModel userStatsViewModel();
}
