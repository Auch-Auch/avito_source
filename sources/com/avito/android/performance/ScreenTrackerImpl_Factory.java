package com.avito.android.performance;

import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;
public final class ScreenTrackerImpl_Factory implements Factory<ScreenTrackerImpl> {
    public final Provider<DiInjectTracker> a;
    public final Provider<SimpleTracker> b;
    public final Provider<Set<ContentTracker>> c;

    public ScreenTrackerImpl_Factory(Provider<DiInjectTracker> provider, Provider<SimpleTracker> provider2, Provider<Set<ContentTracker>> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static ScreenTrackerImpl_Factory create(Provider<DiInjectTracker> provider, Provider<SimpleTracker> provider2, Provider<Set<ContentTracker>> provider3) {
        return new ScreenTrackerImpl_Factory(provider, provider2, provider3);
    }

    public static ScreenTrackerImpl newInstance(DiInjectTracker diInjectTracker, SimpleTracker simpleTracker, Set<ContentTracker> set) {
        return new ScreenTrackerImpl(diInjectTracker, simpleTracker, set);
    }

    @Override // javax.inject.Provider
    public ScreenTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
