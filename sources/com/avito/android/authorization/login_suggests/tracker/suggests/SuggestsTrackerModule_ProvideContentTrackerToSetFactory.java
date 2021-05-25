package com.avito.android.authorization.login_suggests.tracker.suggests;

import com.avito.android.performance.ContentTracker;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SuggestsTrackerModule_ProvideContentTrackerToSetFactory implements Factory<ContentTracker> {
    public final Provider<ContentTracker> a;

    public SuggestsTrackerModule_ProvideContentTrackerToSetFactory(Provider<ContentTracker> provider) {
        this.a = provider;
    }

    public static SuggestsTrackerModule_ProvideContentTrackerToSetFactory create(Provider<ContentTracker> provider) {
        return new SuggestsTrackerModule_ProvideContentTrackerToSetFactory(provider);
    }

    public static ContentTracker provideContentTrackerToSet(ContentTracker contentTracker) {
        return (ContentTracker) Preconditions.checkNotNullFromProvides(SuggestsTrackerModule.provideContentTrackerToSet(contentTracker));
    }

    @Override // javax.inject.Provider
    public ContentTracker get() {
        return provideContentTrackerToSet(this.a.get());
    }
}
