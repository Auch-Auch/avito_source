package com.avito.android.authorization.login_suggests.tracker.suggests;

import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.performance.ContentTracker;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SuggestsTrackerModule_ProvideContentTrackerFactory implements Factory<ContentTracker> {
    public final Provider<ScreenFlowTrackerProvider> a;

    public SuggestsTrackerModule_ProvideContentTrackerFactory(Provider<ScreenFlowTrackerProvider> provider) {
        this.a = provider;
    }

    public static SuggestsTrackerModule_ProvideContentTrackerFactory create(Provider<ScreenFlowTrackerProvider> provider) {
        return new SuggestsTrackerModule_ProvideContentTrackerFactory(provider);
    }

    public static ContentTracker provideContentTracker(ScreenFlowTrackerProvider screenFlowTrackerProvider) {
        return (ContentTracker) Preconditions.checkNotNullFromProvides(SuggestsTrackerModule.provideContentTracker(screenFlowTrackerProvider));
    }

    @Override // javax.inject.Provider
    public ContentTracker get() {
        return provideContentTracker(this.a.get());
    }
}
