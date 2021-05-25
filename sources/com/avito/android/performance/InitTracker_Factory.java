package com.avito.android.performance;

import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class InitTracker_Factory implements Factory<InitTracker> {
    public final Provider<ScreenInitTracker> a;

    public InitTracker_Factory(Provider<ScreenInitTracker> provider) {
        this.a = provider;
    }

    public static InitTracker_Factory create(Provider<ScreenInitTracker> provider) {
        return new InitTracker_Factory(provider);
    }

    public static InitTracker newInstance(ScreenInitTracker screenInitTracker) {
        return new InitTracker(screenInitTracker);
    }

    @Override // javax.inject.Provider
    public InitTracker get() {
        return newInstance(this.a.get());
    }
}
