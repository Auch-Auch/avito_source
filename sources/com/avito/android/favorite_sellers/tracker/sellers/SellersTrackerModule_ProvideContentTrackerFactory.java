package com.avito.android.favorite_sellers.tracker.sellers;

import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.performance.ContentTracker;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SellersTrackerModule_ProvideContentTrackerFactory implements Factory<ContentTracker> {
    public final Provider<ScreenFlowTrackerProvider> a;

    public SellersTrackerModule_ProvideContentTrackerFactory(Provider<ScreenFlowTrackerProvider> provider) {
        this.a = provider;
    }

    public static SellersTrackerModule_ProvideContentTrackerFactory create(Provider<ScreenFlowTrackerProvider> provider) {
        return new SellersTrackerModule_ProvideContentTrackerFactory(provider);
    }

    public static ContentTracker provideContentTracker(ScreenFlowTrackerProvider screenFlowTrackerProvider) {
        return (ContentTracker) Preconditions.checkNotNullFromProvides(SellersTrackerModule.provideContentTracker(screenFlowTrackerProvider));
    }

    @Override // javax.inject.Provider
    public ContentTracker get() {
        return provideContentTracker(this.a.get());
    }
}
