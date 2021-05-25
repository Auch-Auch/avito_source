package com.avito.android.analytics.statsd;

import com.avito.android.AnalyticsToggles;
import com.avito.android.analytics.grafana.GraphitePrefix;
import com.avito.android.analytics.inhouse_transport.InHouseAnalyticsFlushInteractor;
import com.avito.android.analytics.inhouse_transport.InHouseEventStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class StatsdCommonModule_ProvideStatsdEventTrackerFactory implements Factory<StatsdEventTracker> {
    public final Provider<InHouseEventStorage<StatsdRecord>> a;
    public final Provider<InHouseAnalyticsFlushInteractor> b;
    public final Provider<AnalyticsToggles> c;
    public final Provider<StatsdEventValidator> d;
    public final Provider<GraphitePrefix> e;

    public StatsdCommonModule_ProvideStatsdEventTrackerFactory(Provider<InHouseEventStorage<StatsdRecord>> provider, Provider<InHouseAnalyticsFlushInteractor> provider2, Provider<AnalyticsToggles> provider3, Provider<StatsdEventValidator> provider4, Provider<GraphitePrefix> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static StatsdCommonModule_ProvideStatsdEventTrackerFactory create(Provider<InHouseEventStorage<StatsdRecord>> provider, Provider<InHouseAnalyticsFlushInteractor> provider2, Provider<AnalyticsToggles> provider3, Provider<StatsdEventValidator> provider4, Provider<GraphitePrefix> provider5) {
        return new StatsdCommonModule_ProvideStatsdEventTrackerFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static StatsdEventTracker provideStatsdEventTracker(InHouseEventStorage<StatsdRecord> inHouseEventStorage, InHouseAnalyticsFlushInteractor inHouseAnalyticsFlushInteractor, AnalyticsToggles analyticsToggles, StatsdEventValidator statsdEventValidator, GraphitePrefix graphitePrefix) {
        return (StatsdEventTracker) Preconditions.checkNotNullFromProvides(StatsdCommonModule.provideStatsdEventTracker(inHouseEventStorage, inHouseAnalyticsFlushInteractor, analyticsToggles, statsdEventValidator, graphitePrefix));
    }

    @Override // javax.inject.Provider
    public StatsdEventTracker get() {
        return provideStatsdEventTracker(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
