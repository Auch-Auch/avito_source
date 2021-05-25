package com.avito.android.authorization.auth.tracker.check;

import com.avito.android.performance.ContentTracker;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CheckTrackerModule_ProvideContentTrackerToSetFactory implements Factory<ContentTracker> {
    public final Provider<ContentTracker> a;

    public CheckTrackerModule_ProvideContentTrackerToSetFactory(Provider<ContentTracker> provider) {
        this.a = provider;
    }

    public static CheckTrackerModule_ProvideContentTrackerToSetFactory create(Provider<ContentTracker> provider) {
        return new CheckTrackerModule_ProvideContentTrackerToSetFactory(provider);
    }

    public static ContentTracker provideContentTrackerToSet(ContentTracker contentTracker) {
        return (ContentTracker) Preconditions.checkNotNullFromProvides(CheckTrackerModule.provideContentTrackerToSet(contentTracker));
    }

    @Override // javax.inject.Provider
    public ContentTracker get() {
        return provideContentTrackerToSet(this.a.get());
    }
}
