package com.avito.android.publish.details.di;

import com.avito.android.analytics.screens.EditParametersScreen;
import com.avito.android.analytics.screens.PublishParametersScreen;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.ScreenTransferRecovery;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.di.PerFragment;
import com.avito.android.publish.details.analytics.FlowTrackerFactory;
import com.avito.android.publish.details.analytics.FlowTrackerFactoryImpl;
import com.avito.android.publish.details.analytics.PublishDetailsFlowTracker;
import com.avito.android.publish.details.analytics.PublishDetailsFlowTrackerImpl;
import com.avito.android.publish.details.analytics.PublishDetailsTracker;
import com.avito.android.publish.details.analytics.PublishDetailsTrackerImpl;
import com.avito.android.remote.auth.AuthSource;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/avito/android/publish/details/di/PublishDetailsAnalyticsModule;", "", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "screenTrackerFactory", "Lcom/avito/android/analytics/screens/TimerFactory;", "factory", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "providesScreenInitTracker", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "providesScreenDiInjectTracker$publish_release", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "providesScreenDiInjectTracker", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "providesScreenFlowTrackerProvider", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "", AuthSource.SEND_ABUSE, "Z", "isEdit", "<init>", "(Z)V", "Declarations", "publish_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class PublishDetailsAnalyticsModule {
    public final boolean a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/publish/details/di/PublishDetailsAnalyticsModule$Declarations;", "", "Lcom/avito/android/publish/details/analytics/PublishDetailsTrackerImpl;", "tracker", "Lcom/avito/android/publish/details/analytics/PublishDetailsTracker;", "bindPublishDetailsTracker", "(Lcom/avito/android/publish/details/analytics/PublishDetailsTrackerImpl;)Lcom/avito/android/publish/details/analytics/PublishDetailsTracker;", "Lcom/avito/android/publish/details/analytics/PublishDetailsFlowTrackerImpl;", "Lcom/avito/android/publish/details/analytics/PublishDetailsFlowTracker;", "bindPublishDetailsFlowTrackerProvider", "(Lcom/avito/android/publish/details/analytics/PublishDetailsFlowTrackerImpl;)Lcom/avito/android/publish/details/analytics/PublishDetailsFlowTracker;", "Lcom/avito/android/publish/details/analytics/FlowTrackerFactoryImpl;", "factory", "Lcom/avito/android/publish/details/analytics/FlowTrackerFactory;", "bindFlowTrackerFactory", "(Lcom/avito/android/publish/details/analytics/FlowTrackerFactoryImpl;)Lcom/avito/android/publish/details/analytics/FlowTrackerFactory;", "Lcom/avito/android/analytics/screens/ScreenTransferRecovery$Impl;", "recovery", "Lcom/avito/android/analytics/screens/ScreenTransferRecovery;", "bindScreenTransferRecovery", "(Lcom/avito/android/analytics/screens/ScreenTransferRecovery$Impl;)Lcom/avito/android/analytics/screens/ScreenTransferRecovery;", "publish_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        FlowTrackerFactory bindFlowTrackerFactory(@NotNull FlowTrackerFactoryImpl flowTrackerFactoryImpl);

        @PerFragment
        @Binds
        @NotNull
        PublishDetailsFlowTracker bindPublishDetailsFlowTrackerProvider(@NotNull PublishDetailsFlowTrackerImpl publishDetailsFlowTrackerImpl);

        @PerFragment
        @Binds
        @NotNull
        PublishDetailsTracker bindPublishDetailsTracker(@NotNull PublishDetailsTrackerImpl publishDetailsTrackerImpl);

        @PerFragment
        @Binds
        @NotNull
        ScreenTransferRecovery bindScreenTransferRecovery(@NotNull ScreenTransferRecovery.Impl impl);
    }

    public PublishDetailsAnalyticsModule(boolean z) {
        this.a = z;
    }

    @Provides
    @PerFragment
    @NotNull
    public final ScreenDiInjectTracker providesScreenDiInjectTracker$publish_release(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        if (this.a) {
            return ScreenTrackerFactory.DefaultImpls.createDiInjectTracker$default(screenTrackerFactory, EditParametersScreen.INSTANCE, timerFactory, null, 4, null);
        }
        return ScreenTrackerFactory.DefaultImpls.createDiInjectTracker$default(screenTrackerFactory, PublishParametersScreen.INSTANCE, timerFactory, null, 4, null);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ScreenFlowTrackerProvider providesScreenFlowTrackerProvider(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        if (this.a) {
            return screenTrackerFactory.createScreenFlowTrackerProvider(EditParametersScreen.INSTANCE, timerFactory);
        }
        return screenTrackerFactory.createScreenFlowTrackerProvider(PublishParametersScreen.INSTANCE, timerFactory);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ScreenInitTracker providesScreenInitTracker(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        if (this.a) {
            return ScreenTrackerFactory.DefaultImpls.createInitTracker$default(screenTrackerFactory, EditParametersScreen.INSTANCE, timerFactory, null, 4, null);
        }
        return ScreenTrackerFactory.DefaultImpls.createInitTracker$default(screenTrackerFactory, PublishParametersScreen.INSTANCE, timerFactory, null, 4, null);
    }
}
