package com.avito.android.public_profile.di;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.ScreenTransferRecovery;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.di.PerFragment;
import com.avito.android.public_profile.ProfileAdvertsTab;
import com.avito.android.public_profile.tracker.PublicProfileTracker;
import com.avito.android.public_profile.tracker.PublicProfileTrackerImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J3\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/public_profile/di/PublicProfileTrackerModule;", "", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "screenTrackerFactory", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "", "isSubComponent", "Lcom/avito/android/analytics/screens/TimerFactory;", "factory", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "providesScreenInitTracker", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/Screen;ZLcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "providesScreenDiInjectTracker$public_profile_release", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/Screen;ZLcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "providesScreenDiInjectTracker", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "providesScreenFlowTrackerProvider", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/Screen;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "providesScreen", "(Lcom/avito/android/analytics/screens/Screen;)Lcom/avito/android/analytics/screens/Screen;", "providesIsSubComponent", "(Z)Z", "<init>", "()V", "Declarations", "public-profile_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class PublicProfileTrackerModule {
    @NotNull
    public static final PublicProfileTrackerModule INSTANCE = new PublicProfileTrackerModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/public_profile/di/PublicProfileTrackerModule$Declarations;", "", "Lcom/avito/android/public_profile/tracker/PublicProfileTrackerImpl;", "tracker", "Lcom/avito/android/public_profile/tracker/PublicProfileTracker;", "bindSelectAdvertTracker", "(Lcom/avito/android/public_profile/tracker/PublicProfileTrackerImpl;)Lcom/avito/android/public_profile/tracker/PublicProfileTracker;", "Lcom/avito/android/analytics/screens/ScreenTransferRecovery$Impl;", "impl", "Lcom/avito/android/analytics/screens/ScreenTransferRecovery;", "bindScreenTransferRecovery", "(Lcom/avito/android/analytics/screens/ScreenTransferRecovery$Impl;)Lcom/avito/android/analytics/screens/ScreenTransferRecovery;", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        ScreenTransferRecovery bindScreenTransferRecovery(@NotNull ScreenTransferRecovery.Impl impl);

        @PerFragment
        @Binds
        @NotNull
        PublicProfileTracker bindSelectAdvertTracker(@NotNull PublicProfileTrackerImpl publicProfileTrackerImpl);
    }

    @Provides
    @ProfileAdvertsTab
    @PerFragment
    public final boolean providesIsSubComponent(@ScreenAnalytics boolean z) {
        return true;
    }

    @Provides
    @ProfileAdvertsTab
    @NotNull
    @PerFragment
    public final Screen providesScreen(@ScreenAnalytics @NotNull Screen screen) {
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        return screen;
    }

    @Provides
    @PerFragment
    @NotNull
    public final ScreenDiInjectTracker providesScreenDiInjectTracker$public_profile_release(@NotNull ScreenTrackerFactory screenTrackerFactory, @ScreenAnalytics @NotNull Screen screen, @ScreenAnalytics boolean z, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        if (z) {
            return screenTrackerFactory.createDiInjectTracker(screen, timerFactory, "profile");
        }
        return ScreenTrackerFactory.DefaultImpls.createDiInjectTracker$default(screenTrackerFactory, screen, timerFactory, null, 4, null);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ScreenFlowTrackerProvider providesScreenFlowTrackerProvider(@NotNull ScreenTrackerFactory screenTrackerFactory, @ScreenAnalytics @NotNull Screen screen, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        return screenTrackerFactory.createScreenFlowTrackerProvider(screen, timerFactory);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ScreenInitTracker providesScreenInitTracker(@NotNull ScreenTrackerFactory screenTrackerFactory, @ScreenAnalytics @NotNull Screen screen, @ScreenAnalytics boolean z, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        if (z) {
            return screenTrackerFactory.createInitTracker(screen, timerFactory, "profile");
        }
        return ScreenTrackerFactory.DefaultImpls.createInitTracker$default(screenTrackerFactory, screen, timerFactory, null, 4, null);
    }
}
