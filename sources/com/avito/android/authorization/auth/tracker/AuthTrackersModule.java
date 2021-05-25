package com.avito.android.authorization.auth.tracker;

import com.avito.android.analytics.screens.Screen;
import com.avito.android.authorization.auth.tracker.check.CheckTrackerModule;
import com.avito.android.performance.di.PerformanceTrackersModule;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/authorization/auth/tracker/AuthTrackersModule;", "", "Lcom/avito/android/analytics/screens/Screen;", "provideScreen", "()Lcom/avito/android/analytics/screens/Screen;", "<init>", "()V", "authorization_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {CheckTrackerModule.class})
public final class AuthTrackersModule {
    @NotNull
    public static final AuthTrackersModule INSTANCE = new AuthTrackersModule();

    @Provides
    @JvmStatic
    @PerformanceTrackersModule.ScreenProvider
    @NotNull
    public static final Screen provideScreen() {
        return AuthScreen.INSTANCE;
    }
}
