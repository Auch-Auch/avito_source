package com.avito.android.vas_performance.di.visual;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.di.PerFragment;
import com.avito.android.vas_performance.di.visual_legacy.VisualVasAnalytics;
import com.avito.android.vas_performance.tracker.VisualVasTracker;
import com.avito.android.vas_performance.tracker.VisualVasTrackerImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/avito/android/vas_performance/di/visual/VisualVasAnalyticsModuleNew;", "", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "screenTrackerFactory", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "Lcom/avito/android/analytics/screens/TimerFactory;", "factory", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "providesScreenInitTracker$vas_performance_release", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/Screen;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "providesScreenInitTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "providesScreenDiInjectTracker$vas_performance_release", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/Screen;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "providesScreenDiInjectTracker", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "providesScreenFlowTrackerProvider$vas_performance_release", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/Screen;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "providesScreenFlowTrackerProvider", "<init>", "()V", "Declarations", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class VisualVasAnalyticsModuleNew {
    @NotNull
    public static final VisualVasAnalyticsModuleNew INSTANCE = new VisualVasAnalyticsModuleNew();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/vas_performance/di/visual/VisualVasAnalyticsModuleNew$Declarations;", "", "Lcom/avito/android/vas_performance/tracker/VisualVasTrackerImpl;", "tracker", "Lcom/avito/android/vas_performance/tracker/VisualVasTracker;", "bindVisualVasTracker", "(Lcom/avito/android/vas_performance/tracker/VisualVasTrackerImpl;)Lcom/avito/android/vas_performance/tracker/VisualVasTracker;", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        VisualVasTracker bindVisualVasTracker(@NotNull VisualVasTrackerImpl visualVasTrackerImpl);
    }

    @Provides
    @JvmStatic
    @VisualVasAnalytics
    @NotNull
    @PerFragment
    public static final ScreenDiInjectTracker providesScreenDiInjectTracker$vas_performance_release(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull Screen screen, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        return screenTrackerFactory.createDiInjectTracker(screen, timerFactory, ScreenPublicConstsKt.CONTENT_TYPE_MNZ_VISUAL_VAS);
    }

    @Provides
    @JvmStatic
    @VisualVasAnalytics
    @NotNull
    @PerFragment
    public static final ScreenFlowTrackerProvider providesScreenFlowTrackerProvider$vas_performance_release(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull Screen screen, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        return screenTrackerFactory.createScreenFlowTrackerProvider(screen, timerFactory);
    }

    @Provides
    @JvmStatic
    @VisualVasAnalytics
    @NotNull
    @PerFragment
    public static final ScreenInitTracker providesScreenInitTracker$vas_performance_release(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull Screen screen, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        return screenTrackerFactory.createInitTracker(screen, timerFactory, ScreenPublicConstsKt.CONTENT_TYPE_MNZ_VISUAL_VAS);
    }
}
