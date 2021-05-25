package com.avito.android.authorization.login_suggests.tracker;

import com.avito.android.analytics.screens.Screen;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class LoginSuggestTrackersModule_ProvideScreenFactory implements Factory<Screen> {

    public static final class a {
        public static final LoginSuggestTrackersModule_ProvideScreenFactory a = new LoginSuggestTrackersModule_ProvideScreenFactory();
    }

    public static LoginSuggestTrackersModule_ProvideScreenFactory create() {
        return a.a;
    }

    public static Screen provideScreen() {
        return (Screen) Preconditions.checkNotNullFromProvides(LoginSuggestTrackersModule.provideScreen());
    }

    @Override // javax.inject.Provider
    public Screen get() {
        return provideScreen();
    }
}
