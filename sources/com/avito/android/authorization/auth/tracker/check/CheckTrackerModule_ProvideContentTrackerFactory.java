package com.avito.android.authorization.auth.tracker.check;

import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.performance.ContentTracker;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CheckTrackerModule_ProvideContentTrackerFactory implements Factory<ContentTracker> {
    public final Provider<ScreenFlowTrackerProvider> a;

    public CheckTrackerModule_ProvideContentTrackerFactory(Provider<ScreenFlowTrackerProvider> provider) {
        this.a = provider;
    }

    public static CheckTrackerModule_ProvideContentTrackerFactory create(Provider<ScreenFlowTrackerProvider> provider) {
        return new CheckTrackerModule_ProvideContentTrackerFactory(provider);
    }

    public static ContentTracker provideContentTracker(ScreenFlowTrackerProvider screenFlowTrackerProvider) {
        return (ContentTracker) Preconditions.checkNotNullFromProvides(CheckTrackerModule.provideContentTracker(screenFlowTrackerProvider));
    }

    @Override // javax.inject.Provider
    public ContentTracker get() {
        return provideContentTracker(this.a.get());
    }
}
