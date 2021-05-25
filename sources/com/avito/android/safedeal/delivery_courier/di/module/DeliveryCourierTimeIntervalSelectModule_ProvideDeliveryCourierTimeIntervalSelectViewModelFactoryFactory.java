package com.avito.android.safedeal.delivery_courier.di.module;

import com.avito.android.remote.model.delivery_courier.TimeInterval;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectAnalyticsTracker;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectInteractor;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectResourceProvider;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectViewModelFactory;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DeliveryCourierTimeIntervalSelectModule_ProvideDeliveryCourierTimeIntervalSelectViewModelFactoryFactory implements Factory<DeliveryCourierTimeIntervalSelectViewModelFactory> {
    public final Provider<String> a;
    public final Provider<String> b;
    public final Provider<TimeInterval> c;
    public final Provider<DeliveryCourierTimeIntervalSelectInteractor> d;
    public final Provider<SchedulersFactory> e;
    public final Provider<DeliveryCourierTimeIntervalSelectResourceProvider> f;
    public final Provider<DeliveryCourierTimeIntervalSelectAnalyticsTracker> g;

    public DeliveryCourierTimeIntervalSelectModule_ProvideDeliveryCourierTimeIntervalSelectViewModelFactoryFactory(Provider<String> provider, Provider<String> provider2, Provider<TimeInterval> provider3, Provider<DeliveryCourierTimeIntervalSelectInteractor> provider4, Provider<SchedulersFactory> provider5, Provider<DeliveryCourierTimeIntervalSelectResourceProvider> provider6, Provider<DeliveryCourierTimeIntervalSelectAnalyticsTracker> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static DeliveryCourierTimeIntervalSelectModule_ProvideDeliveryCourierTimeIntervalSelectViewModelFactoryFactory create(Provider<String> provider, Provider<String> provider2, Provider<TimeInterval> provider3, Provider<DeliveryCourierTimeIntervalSelectInteractor> provider4, Provider<SchedulersFactory> provider5, Provider<DeliveryCourierTimeIntervalSelectResourceProvider> provider6, Provider<DeliveryCourierTimeIntervalSelectAnalyticsTracker> provider7) {
        return new DeliveryCourierTimeIntervalSelectModule_ProvideDeliveryCourierTimeIntervalSelectViewModelFactoryFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static DeliveryCourierTimeIntervalSelectViewModelFactory provideDeliveryCourierTimeIntervalSelectViewModelFactory(String str, String str2, TimeInterval timeInterval, DeliveryCourierTimeIntervalSelectInteractor deliveryCourierTimeIntervalSelectInteractor, SchedulersFactory schedulersFactory, DeliveryCourierTimeIntervalSelectResourceProvider deliveryCourierTimeIntervalSelectResourceProvider, DeliveryCourierTimeIntervalSelectAnalyticsTracker deliveryCourierTimeIntervalSelectAnalyticsTracker) {
        return (DeliveryCourierTimeIntervalSelectViewModelFactory) Preconditions.checkNotNullFromProvides(DeliveryCourierTimeIntervalSelectModule.provideDeliveryCourierTimeIntervalSelectViewModelFactory(str, str2, timeInterval, deliveryCourierTimeIntervalSelectInteractor, schedulersFactory, deliveryCourierTimeIntervalSelectResourceProvider, deliveryCourierTimeIntervalSelectAnalyticsTracker));
    }

    @Override // javax.inject.Provider
    public DeliveryCourierTimeIntervalSelectViewModelFactory get() {
        return provideDeliveryCourierTimeIntervalSelectViewModelFactory(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
