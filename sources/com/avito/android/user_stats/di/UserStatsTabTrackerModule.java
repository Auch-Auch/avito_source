package com.avito.android.user_stats.di;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.analytics.screens.SmbStatisticsScreen;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.di.PerFragment;
import com.avito.android.user_stats.tracker.UserStatsTabTracker;
import com.avito.android.user_stats.tracker.UserStatsTabTrackerImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/user_stats/di/UserStatsTabTrackerModule;", "", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "screenTrackerFactory", "Lcom/avito/android/analytics/screens/TimerFactory;", "timerFactory", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "provideScreenDiInjectTracker", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "provideScreenInitTracker", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "<init>", "()V", "Declarations", "user-stats_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class UserStatsTabTrackerModule {
    @NotNull
    public static final UserStatsTabTrackerModule INSTANCE = new UserStatsTabTrackerModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/user_stats/di/UserStatsTabTrackerModule$Declarations;", "", "Lcom/avito/android/user_stats/tracker/UserStatsTabTrackerImpl;", "impl", "Lcom/avito/android/user_stats/tracker/UserStatsTabTracker;", "bindUserStatsTabTracker", "(Lcom/avito/android/user_stats/tracker/UserStatsTabTrackerImpl;)Lcom/avito/android/user_stats/tracker/UserStatsTabTracker;", "user-stats_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        UserStatsTabTracker bindUserStatsTabTracker(@NotNull UserStatsTabTrackerImpl userStatsTabTrackerImpl);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ScreenDiInjectTracker provideScreenDiInjectTracker(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "timerFactory");
        return screenTrackerFactory.createDiInjectTracker(SmbStatisticsScreen.INSTANCE, timerFactory, ScreenPublicConstsKt.CONTENT_TYPE_SMB_STATISTICS_TAB);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ScreenInitTracker provideScreenInitTracker(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "timerFactory");
        return screenTrackerFactory.createInitTracker(SmbStatisticsScreen.INSTANCE, timerFactory, ScreenPublicConstsKt.CONTENT_TYPE_SMB_STATISTICS_TAB);
    }
}
