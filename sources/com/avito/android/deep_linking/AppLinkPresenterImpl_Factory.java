package com.avito.android.deep_linking;

import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AppLinkPresenterImpl_Factory implements Factory<AppLinkPresenterImpl> {
    public final Provider<AppLinkInteractor> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<SavedLocationInteractor> c;
    public final Provider<LocationAnalyticsInteractor> d;
    public final Provider<AdjustReattributionInteractor> e;

    public AppLinkPresenterImpl_Factory(Provider<AppLinkInteractor> provider, Provider<SchedulersFactory> provider2, Provider<SavedLocationInteractor> provider3, Provider<LocationAnalyticsInteractor> provider4, Provider<AdjustReattributionInteractor> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static AppLinkPresenterImpl_Factory create(Provider<AppLinkInteractor> provider, Provider<SchedulersFactory> provider2, Provider<SavedLocationInteractor> provider3, Provider<LocationAnalyticsInteractor> provider4, Provider<AdjustReattributionInteractor> provider5) {
        return new AppLinkPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static AppLinkPresenterImpl newInstance(AppLinkInteractor appLinkInteractor, SchedulersFactory schedulersFactory, SavedLocationInteractor savedLocationInteractor, LocationAnalyticsInteractor locationAnalyticsInteractor, AdjustReattributionInteractor adjustReattributionInteractor) {
        return new AppLinkPresenterImpl(appLinkInteractor, schedulersFactory, savedLocationInteractor, locationAnalyticsInteractor, adjustReattributionInteractor);
    }

    @Override // javax.inject.Provider
    public AppLinkPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
