package com.avito.android.favorite_sellers.tracker.sellers;

import com.avito.android.performance.ContentTracker;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SellersTrackerModule_ProvideContentTrackerToSetFactory implements Factory<ContentTracker> {
    public final Provider<ContentTracker> a;

    public SellersTrackerModule_ProvideContentTrackerToSetFactory(Provider<ContentTracker> provider) {
        this.a = provider;
    }

    public static SellersTrackerModule_ProvideContentTrackerToSetFactory create(Provider<ContentTracker> provider) {
        return new SellersTrackerModule_ProvideContentTrackerToSetFactory(provider);
    }

    public static ContentTracker provideContentTrackerToSet(ContentTracker contentTracker) {
        return (ContentTracker) Preconditions.checkNotNullFromProvides(SellersTrackerModule.provideContentTrackerToSet(contentTracker));
    }

    @Override // javax.inject.Provider
    public ContentTracker get() {
        return provideContentTrackerToSet(this.a.get());
    }
}
