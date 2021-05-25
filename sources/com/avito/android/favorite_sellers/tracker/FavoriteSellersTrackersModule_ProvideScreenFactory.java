package com.avito.android.favorite_sellers.tracker;

import com.avito.android.analytics.screens.Screen;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class FavoriteSellersTrackersModule_ProvideScreenFactory implements Factory<Screen> {

    public static final class a {
        public static final FavoriteSellersTrackersModule_ProvideScreenFactory a = new FavoriteSellersTrackersModule_ProvideScreenFactory();
    }

    public static FavoriteSellersTrackersModule_ProvideScreenFactory create() {
        return a.a;
    }

    public static Screen provideScreen() {
        return (Screen) Preconditions.checkNotNullFromProvides(FavoriteSellersTrackersModule.provideScreen());
    }

    @Override // javax.inject.Provider
    public Screen get() {
        return provideScreen();
    }
}
