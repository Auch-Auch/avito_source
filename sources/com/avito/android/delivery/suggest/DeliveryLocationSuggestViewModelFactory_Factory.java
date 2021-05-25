package com.avito.android.delivery.suggest;

import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryLocationSuggestViewModelFactory_Factory implements Factory<DeliveryLocationSuggestViewModelFactory> {
    public final Provider<DeliveryLocationSuggestInteractor> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<AvitoMapBounds> c;
    public final Provider<BaseScreenPerformanceTracker> d;

    public DeliveryLocationSuggestViewModelFactory_Factory(Provider<DeliveryLocationSuggestInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<AvitoMapBounds> provider3, Provider<BaseScreenPerformanceTracker> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static DeliveryLocationSuggestViewModelFactory_Factory create(Provider<DeliveryLocationSuggestInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<AvitoMapBounds> provider3, Provider<BaseScreenPerformanceTracker> provider4) {
        return new DeliveryLocationSuggestViewModelFactory_Factory(provider, provider2, provider3, provider4);
    }

    public static DeliveryLocationSuggestViewModelFactory newInstance(DeliveryLocationSuggestInteractor deliveryLocationSuggestInteractor, SchedulersFactory3 schedulersFactory3, AvitoMapBounds avitoMapBounds, BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        return new DeliveryLocationSuggestViewModelFactory(deliveryLocationSuggestInteractor, schedulersFactory3, avitoMapBounds, baseScreenPerformanceTracker);
    }

    @Override // javax.inject.Provider
    public DeliveryLocationSuggestViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
