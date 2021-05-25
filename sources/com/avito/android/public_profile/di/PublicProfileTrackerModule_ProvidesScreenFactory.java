package com.avito.android.public_profile.di;

import com.avito.android.analytics.screens.Screen;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublicProfileTrackerModule_ProvidesScreenFactory implements Factory<Screen> {
    public final Provider<Screen> a;

    public PublicProfileTrackerModule_ProvidesScreenFactory(Provider<Screen> provider) {
        this.a = provider;
    }

    public static PublicProfileTrackerModule_ProvidesScreenFactory create(Provider<Screen> provider) {
        return new PublicProfileTrackerModule_ProvidesScreenFactory(provider);
    }

    public static Screen providesScreen(Screen screen) {
        return (Screen) Preconditions.checkNotNullFromProvides(PublicProfileTrackerModule.INSTANCE.providesScreen(screen));
    }

    @Override // javax.inject.Provider
    public Screen get() {
        return providesScreen(this.a.get());
    }
}
