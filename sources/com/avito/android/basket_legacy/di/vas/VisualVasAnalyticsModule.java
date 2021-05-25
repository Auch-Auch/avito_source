package com.avito.android.basket_legacy.di.vas;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.basket_legacy.di.ScreenAnalytics;
import com.avito.android.di.PerActivity;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J3\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/avito/android/basket_legacy/di/vas/VisualVasAnalyticsModule;", "", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "screenTrackerFactory", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "", "isSubComponent", "Lcom/avito/android/analytics/screens/TimerFactory;", "factory", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "providesScreenInitTracker$basket_release", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/Screen;ZLcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "providesScreenInitTracker", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "providesScreenDiInjectTracker$basket_release", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/Screen;ZLcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "providesScreenDiInjectTracker", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "providesScreenFlowTrackerProvider$basket_release", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/Screen;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "providesScreenFlowTrackerProvider", "<init>", "()V", "Declarations", "basket_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class VisualVasAnalyticsModule {
    @NotNull
    public static final VisualVasAnalyticsModule INSTANCE = new VisualVasAnalyticsModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/basket_legacy/di/vas/VisualVasAnalyticsModule$Declarations;", "", "Lcom/avito/android/vas_performance/tracker/VisualVasTrackerImpl;", "tracker", "Lcom/avito/android/vas_performance/tracker/VisualVasTracker;", "bindVisualVasTracker", "(Lcom/avito/android/vas_performance/tracker/VisualVasTrackerImpl;)Lcom/avito/android/vas_performance/tracker/VisualVasTracker;", "basket_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerActivity
        @Binds
        @NotNull
        VisualVasTracker bindVisualVasTracker(@NotNull VisualVasTrackerImpl visualVasTrackerImpl);
    }

    @Provides
    @JvmStatic
    @VisualVasAnalytics
    @NotNull
    @PerActivity
    public static final ScreenDiInjectTracker providesScreenDiInjectTracker$basket_release(@NotNull ScreenTrackerFactory screenTrackerFactory, @ScreenAnalytics @NotNull Screen screen, @ScreenAnalytics boolean z, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        if (z) {
            return screenTrackerFactory.createDiInjectTracker(screen, timerFactory, ScreenPublicConstsKt.CONTENT_TYPE_MNZ_VISUAL_VAS);
        }
        return ScreenTrackerFactory.DefaultImpls.createDiInjectTracker$default(screenTrackerFactory, screen, timerFactory, null, 4, null);
    }

    @Provides
    @JvmStatic
    @VisualVasAnalytics
    @NotNull
    @PerActivity
    public static final ScreenFlowTrackerProvider providesScreenFlowTrackerProvider$basket_release(@NotNull ScreenTrackerFactory screenTrackerFactory, @ScreenAnalytics @NotNull Screen screen, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        return screenTrackerFactory.createScreenFlowTrackerProvider(screen, timerFactory);
    }

    @Provides
    @JvmStatic
    @VisualVasAnalytics
    @NotNull
    @PerActivity
    public static final ScreenInitTracker providesScreenInitTracker$basket_release(@NotNull ScreenTrackerFactory screenTrackerFactory, @ScreenAnalytics @NotNull Screen screen, @ScreenAnalytics boolean z, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        if (z) {
            return screenTrackerFactory.createInitTracker(screen, timerFactory, ScreenPublicConstsKt.CONTENT_TYPE_MNZ_VISUAL_VAS);
        }
        return ScreenTrackerFactory.DefaultImpls.createInitTracker$default(screenTrackerFactory, screen, timerFactory, null, 4, null);
    }
}
