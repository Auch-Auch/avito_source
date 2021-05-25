package com.avito.android.delivery.summary;

import com.avito.android.Features;
import com.avito.android.SummaryState;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.delivery.summary.common.DeliveryRdsContactsFieldsInteractor;
import com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryItemsConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryRdsSummaryViewModelFactory_Factory implements Factory<DeliveryRdsSummaryViewModelFactory> {
    public final Provider<Analytics> a;
    public final Provider<Features> b;
    public final Provider<DeliveryRdsSummaryInteractor> c;
    public final Provider<SchedulersFactory3> d;
    public final Provider<String> e;
    public final Provider<DeliveryRdsSummaryItemsConverter> f;
    public final Provider<DeliveryRdsSummaryResourceProvider> g;
    public final Provider<DeliveryRdsContactsFieldsInteractor> h;
    public final Provider<SummaryState> i;
    public final Provider<Boolean> j;
    public final Provider<BaseScreenPerformanceTracker> k;

    public DeliveryRdsSummaryViewModelFactory_Factory(Provider<Analytics> provider, Provider<Features> provider2, Provider<DeliveryRdsSummaryInteractor> provider3, Provider<SchedulersFactory3> provider4, Provider<String> provider5, Provider<DeliveryRdsSummaryItemsConverter> provider6, Provider<DeliveryRdsSummaryResourceProvider> provider7, Provider<DeliveryRdsContactsFieldsInteractor> provider8, Provider<SummaryState> provider9, Provider<Boolean> provider10, Provider<BaseScreenPerformanceTracker> provider11) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
        this.k = provider11;
    }

    public static DeliveryRdsSummaryViewModelFactory_Factory create(Provider<Analytics> provider, Provider<Features> provider2, Provider<DeliveryRdsSummaryInteractor> provider3, Provider<SchedulersFactory3> provider4, Provider<String> provider5, Provider<DeliveryRdsSummaryItemsConverter> provider6, Provider<DeliveryRdsSummaryResourceProvider> provider7, Provider<DeliveryRdsContactsFieldsInteractor> provider8, Provider<SummaryState> provider9, Provider<Boolean> provider10, Provider<BaseScreenPerformanceTracker> provider11) {
        return new DeliveryRdsSummaryViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static DeliveryRdsSummaryViewModelFactory newInstance(Analytics analytics, Features features, DeliveryRdsSummaryInteractor deliveryRdsSummaryInteractor, SchedulersFactory3 schedulersFactory3, String str, DeliveryRdsSummaryItemsConverter deliveryRdsSummaryItemsConverter, DeliveryRdsSummaryResourceProvider deliveryRdsSummaryResourceProvider, DeliveryRdsContactsFieldsInteractor deliveryRdsContactsFieldsInteractor, SummaryState summaryState, boolean z, BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        return new DeliveryRdsSummaryViewModelFactory(analytics, features, deliveryRdsSummaryInteractor, schedulersFactory3, str, deliveryRdsSummaryItemsConverter, deliveryRdsSummaryResourceProvider, deliveryRdsContactsFieldsInteractor, summaryState, z, baseScreenPerformanceTracker);
    }

    @Override // javax.inject.Provider
    public DeliveryRdsSummaryViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get().booleanValue(), this.k.get());
    }
}
