package com.avito.android.performance.di;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.performance.ContentTracker;
import com.avito.android.performance.DiInjectTracker;
import com.avito.android.performance.DiInjectTrackerImpl;
import com.avito.android.performance.InitTracker;
import com.avito.android.performance.ScreenTracker;
import com.avito.android.performance.ScreenTrackerImpl;
import com.avito.android.performance.SimpleTracker;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import dagger.multibindings.ElementsIntoSet;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001:\u0004\u0018\u0019\u001a\u001bB\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ)\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/avito/android/performance/di/PerformanceTrackersModule;", "", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "screenTrackerFactory", "Lcom/avito/android/analytics/screens/TimerFactory;", "factory", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "providesScreenInitTracker", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;Lcom/avito/android/analytics/screens/Screen;)Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "providesScreenDiInjectTracker$tns_core_release", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;Lcom/avito/android/analytics/screens/Screen;)Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "providesScreenDiInjectTracker", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "providesScreenFlowTrackerProvider", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;Lcom/avito/android/analytics/screens/Screen;)Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "", "Lcom/avito/android/performance/ContentTracker;", "provideContentTrackers", "()Ljava/util/Set;", "<init>", "()V", "Declarations", "Init", "ScreenProvider", "Tracker", "tns-core_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class PerformanceTrackersModule {
    @NotNull
    public static final PerformanceTrackersModule INSTANCE = new PerformanceTrackersModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/performance/di/PerformanceTrackersModule$Declarations;", "", "Lcom/avito/android/performance/DiInjectTrackerImpl;", "diInjectTracker", "Lcom/avito/android/performance/DiInjectTracker;", "bindDiInjectTracker", "(Lcom/avito/android/performance/DiInjectTrackerImpl;)Lcom/avito/android/performance/DiInjectTracker;", "Lcom/avito/android/performance/InitTracker;", "initTracker", "Lcom/avito/android/performance/SimpleTracker;", "bindInitTracker", "(Lcom/avito/android/performance/InitTracker;)Lcom/avito/android/performance/SimpleTracker;", "Lcom/avito/android/performance/ScreenTrackerImpl;", "screenTracker", "Lcom/avito/android/performance/ScreenTracker;", "bindScreenTracker", "(Lcom/avito/android/performance/ScreenTrackerImpl;)Lcom/avito/android/performance/ScreenTracker;", "tns-core_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Reusable
        @Binds
        @NotNull
        DiInjectTracker bindDiInjectTracker(@NotNull DiInjectTrackerImpl diInjectTrackerImpl);

        @Reusable
        @Binds
        @NotNull
        @Init
        SimpleTracker bindInitTracker(@NotNull InitTracker initTracker);

        @Reusable
        @Binds
        @NotNull
        ScreenTracker bindScreenTracker(@NotNull ScreenTrackerImpl screenTrackerImpl);
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/performance/di/PerformanceTrackersModule$Init;", "", "<init>", "()V", "tns-core_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface Init {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/performance/di/PerformanceTrackersModule$ScreenProvider;", "", "<init>", "()V", "tns-core_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface ScreenProvider {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/performance/di/PerformanceTrackersModule$Tracker;", "", "<init>", "()V", "tns-core_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface Tracker {
    }

    @Provides
    @JvmStatic
    @Reusable
    @ElementsIntoSet
    @NotNull
    public static final Set<ContentTracker> provideContentTrackers() {
        return y.emptySet();
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final ScreenDiInjectTracker providesScreenDiInjectTracker$tns_core_release(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory, @ScreenProvider @NotNull Screen screen) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        return ScreenTrackerFactory.DefaultImpls.createDiInjectTracker$default(screenTrackerFactory, screen, timerFactory, null, 4, null);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final ScreenFlowTrackerProvider providesScreenFlowTrackerProvider(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory, @ScreenProvider @NotNull Screen screen) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        return screenTrackerFactory.createScreenFlowTrackerProvider(screen, timerFactory);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final ScreenInitTracker providesScreenInitTracker(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory, @ScreenProvider @NotNull Screen screen) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        return ScreenTrackerFactory.DefaultImpls.createInitTracker$default(screenTrackerFactory, screen, timerFactory, null, 4, null);
    }
}
