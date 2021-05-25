package com.avito.android.analytics.statsd;

import com.avito.android.analytics.inhouse_transport.OverflowTrimmer;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class StatsdCommonModule_ProvideOverflowTrimmerFactory implements Factory<OverflowTrimmer<StatsdRecord>> {

    public static final class a {
        public static final StatsdCommonModule_ProvideOverflowTrimmerFactory a = new StatsdCommonModule_ProvideOverflowTrimmerFactory();
    }

    public static StatsdCommonModule_ProvideOverflowTrimmerFactory create() {
        return a.a;
    }

    public static OverflowTrimmer<StatsdRecord> provideOverflowTrimmer() {
        return (OverflowTrimmer) Preconditions.checkNotNullFromProvides(StatsdCommonModule.provideOverflowTrimmer());
    }

    @Override // javax.inject.Provider
    public OverflowTrimmer<StatsdRecord> get() {
        return provideOverflowTrimmer();
    }
}
