package com.avito.android.di.module;

import com.avito.android.analytics.inhouse_transport.InHouseAnalyticsTimer;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ClickStreamModule_ProvideClickstreamTimerFactory implements Factory<InHouseAnalyticsTimer> {
    public final Provider<SchedulersFactory> a;

    public ClickStreamModule_ProvideClickstreamTimerFactory(Provider<SchedulersFactory> provider) {
        this.a = provider;
    }

    public static ClickStreamModule_ProvideClickstreamTimerFactory create(Provider<SchedulersFactory> provider) {
        return new ClickStreamModule_ProvideClickstreamTimerFactory(provider);
    }

    public static InHouseAnalyticsTimer provideClickstreamTimer(SchedulersFactory schedulersFactory) {
        return (InHouseAnalyticsTimer) Preconditions.checkNotNullFromProvides(ClickStreamModule.provideClickstreamTimer(schedulersFactory));
    }

    @Override // javax.inject.Provider
    public InHouseAnalyticsTimer get() {
        return provideClickstreamTimer(this.a.get());
    }
}
