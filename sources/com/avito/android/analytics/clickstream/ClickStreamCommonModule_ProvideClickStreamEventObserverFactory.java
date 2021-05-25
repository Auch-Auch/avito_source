package com.avito.android.analytics.clickstream;

import com.avito.android.ClickstreamToggles;
import com.avito.android.analytics.EventObserver;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ClickStreamCommonModule_ProvideClickStreamEventObserverFactory implements Factory<EventObserver> {
    public final Provider<ClickStreamEventTracker> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<ClickstreamToggles> c;

    public ClickStreamCommonModule_ProvideClickStreamEventObserverFactory(Provider<ClickStreamEventTracker> provider, Provider<SchedulersFactory> provider2, Provider<ClickstreamToggles> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static ClickStreamCommonModule_ProvideClickStreamEventObserverFactory create(Provider<ClickStreamEventTracker> provider, Provider<SchedulersFactory> provider2, Provider<ClickstreamToggles> provider3) {
        return new ClickStreamCommonModule_ProvideClickStreamEventObserverFactory(provider, provider2, provider3);
    }

    public static EventObserver provideClickStreamEventObserver(ClickStreamEventTracker clickStreamEventTracker, SchedulersFactory schedulersFactory, ClickstreamToggles clickstreamToggles) {
        return (EventObserver) Preconditions.checkNotNullFromProvides(ClickStreamCommonModule.provideClickStreamEventObserver(clickStreamEventTracker, schedulersFactory, clickstreamToggles));
    }

    @Override // javax.inject.Provider
    public EventObserver get() {
        return provideClickStreamEventObserver(this.a.get(), this.b.get(), this.c.get());
    }
}
