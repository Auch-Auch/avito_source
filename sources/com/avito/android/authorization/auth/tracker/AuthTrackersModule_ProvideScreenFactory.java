package com.avito.android.authorization.auth.tracker;

import com.avito.android.analytics.screens.Screen;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class AuthTrackersModule_ProvideScreenFactory implements Factory<Screen> {

    public static final class a {
        public static final AuthTrackersModule_ProvideScreenFactory a = new AuthTrackersModule_ProvideScreenFactory();
    }

    public static AuthTrackersModule_ProvideScreenFactory create() {
        return a.a;
    }

    public static Screen provideScreen() {
        return (Screen) Preconditions.checkNotNullFromProvides(AuthTrackersModule.provideScreen());
    }

    @Override // javax.inject.Provider
    public Screen get() {
        return provideScreen();
    }
}
