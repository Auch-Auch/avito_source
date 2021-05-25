package com.avito.android.deep_linking;

import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeepLinkingPresenterImpl_Factory implements Factory<DeepLinkingPresenterImpl> {
    public final Provider<DeepLinkFactory> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<DeepLinkingRouter> c;
    public final Provider<LocationAnalyticsInteractor> d;
    public final Provider<SavedLocationInteractor> e;
    public final Provider<AdjustReattributionInteractor> f;

    public DeepLinkingPresenterImpl_Factory(Provider<DeepLinkFactory> provider, Provider<SchedulersFactory> provider2, Provider<DeepLinkingRouter> provider3, Provider<LocationAnalyticsInteractor> provider4, Provider<SavedLocationInteractor> provider5, Provider<AdjustReattributionInteractor> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static DeepLinkingPresenterImpl_Factory create(Provider<DeepLinkFactory> provider, Provider<SchedulersFactory> provider2, Provider<DeepLinkingRouter> provider3, Provider<LocationAnalyticsInteractor> provider4, Provider<SavedLocationInteractor> provider5, Provider<AdjustReattributionInteractor> provider6) {
        return new DeepLinkingPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static DeepLinkingPresenterImpl newInstance(DeepLinkFactory deepLinkFactory, SchedulersFactory schedulersFactory, DeepLinkingRouter deepLinkingRouter, LocationAnalyticsInteractor locationAnalyticsInteractor, SavedLocationInteractor savedLocationInteractor, AdjustReattributionInteractor adjustReattributionInteractor) {
        return new DeepLinkingPresenterImpl(deepLinkFactory, schedulersFactory, deepLinkingRouter, locationAnalyticsInteractor, savedLocationInteractor, adjustReattributionInteractor);
    }

    @Override // javax.inject.Provider
    public DeepLinkingPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
