package com.avito.android.performance.di;

import com.avito.android.performance.ContentTracker;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class PerformanceTrackersModule_ProvideContentTrackersFactory implements Factory<Set<ContentTracker>> {

    public static final class a {
        public static final PerformanceTrackersModule_ProvideContentTrackersFactory a = new PerformanceTrackersModule_ProvideContentTrackersFactory();
    }

    public static PerformanceTrackersModule_ProvideContentTrackersFactory create() {
        return a.a;
    }

    public static Set<ContentTracker> provideContentTrackers() {
        return (Set) Preconditions.checkNotNullFromProvides(PerformanceTrackersModule.provideContentTrackers());
    }

    @Override // javax.inject.Provider
    public Set<ContentTracker> get() {
        return provideContentTrackers();
    }
}
