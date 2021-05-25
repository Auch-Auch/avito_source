package com.avito.android.developments_catalog.di;

import com.avito.android.analytics.screens.FiltersScreen;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.developments_catalog.tracker.DevelopmentsCatalogTracker;
import com.avito.android.developments_catalog.tracker.DevelopmentsCatalogTrackerImpl;
import com.avito.android.di.PerFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/developments_catalog/di/DevelopmentsCatalogTrackerModule;", "", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "screenTrackerFactory", "Lcom/avito/android/analytics/screens/TimerFactory;", "factory", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "providesScreenFlowTrackerProvider", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "<init>", "()V", "Declarations", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class DevelopmentsCatalogTrackerModule {
    @NotNull
    public static final DevelopmentsCatalogTrackerModule INSTANCE = new DevelopmentsCatalogTrackerModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/developments_catalog/di/DevelopmentsCatalogTrackerModule$Declarations;", "", "Lcom/avito/android/developments_catalog/tracker/DevelopmentsCatalogTrackerImpl;", "tracker", "Lcom/avito/android/developments_catalog/tracker/DevelopmentsCatalogTracker;", "bindAutoCatalogTracker", "(Lcom/avito/android/developments_catalog/tracker/DevelopmentsCatalogTrackerImpl;)Lcom/avito/android/developments_catalog/tracker/DevelopmentsCatalogTracker;", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        DevelopmentsCatalogTracker bindAutoCatalogTracker(@NotNull DevelopmentsCatalogTrackerImpl developmentsCatalogTrackerImpl);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ScreenFlowTrackerProvider providesScreenFlowTrackerProvider(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        return screenTrackerFactory.createScreenFlowTrackerProvider(FiltersScreen.INSTANCE, timerFactory);
    }
}
