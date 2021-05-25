package com.avito.android.favorite_sellers.tracker;

import com.avito.android.analytics.screens.Screen;
import com.avito.android.favorite_sellers.tracker.sellers.SellersTrackerModule;
import com.avito.android.performance.di.PerformanceTrackersModule;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/favorite_sellers/tracker/FavoriteSellersTrackersModule;", "", "Lcom/avito/android/analytics/screens/Screen;", "provideScreen", "()Lcom/avito/android/analytics/screens/Screen;", "<init>", "()V", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {SellersTrackerModule.class})
public final class FavoriteSellersTrackersModule {
    @NotNull
    public static final FavoriteSellersTrackersModule INSTANCE = new FavoriteSellersTrackersModule();

    @Provides
    @JvmStatic
    @PerformanceTrackersModule.ScreenProvider
    @NotNull
    public static final Screen provideScreen() {
        return FavoriteSellersScreen.INSTANCE;
    }
}
