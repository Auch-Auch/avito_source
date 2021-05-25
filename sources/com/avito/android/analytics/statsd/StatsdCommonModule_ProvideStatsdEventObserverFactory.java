package com.avito.android.analytics.statsd;

import com.avito.android.analytics.EventObserver;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class StatsdCommonModule_ProvideStatsdEventObserverFactory implements Factory<EventObserver> {
    public final Provider<StatsdEventTracker> a;
    public final Provider<SchedulersFactory> b;

    public StatsdCommonModule_ProvideStatsdEventObserverFactory(Provider<StatsdEventTracker> provider, Provider<SchedulersFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static StatsdCommonModule_ProvideStatsdEventObserverFactory create(Provider<StatsdEventTracker> provider, Provider<SchedulersFactory> provider2) {
        return new StatsdCommonModule_ProvideStatsdEventObserverFactory(provider, provider2);
    }

    public static EventObserver provideStatsdEventObserver(StatsdEventTracker statsdEventTracker, SchedulersFactory schedulersFactory) {
        return (EventObserver) Preconditions.checkNotNullFromProvides(StatsdCommonModule.provideStatsdEventObserver(statsdEventTracker, schedulersFactory));
    }

    @Override // javax.inject.Provider
    public EventObserver get() {
        return provideStatsdEventObserver(this.a.get(), this.b.get());
    }
}
