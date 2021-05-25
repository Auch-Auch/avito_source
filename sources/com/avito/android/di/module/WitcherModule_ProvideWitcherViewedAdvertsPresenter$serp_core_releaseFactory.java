package com.avito.android.di.module;

import com.avito.android.advert.viewed.ViewedAdvertsEventInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class WitcherModule_ProvideWitcherViewedAdvertsPresenter$serp_core_releaseFactory implements Factory<ViewedAdvertsPresenter> {
    public final Provider<ViewedAdvertsEventInteractor> a;
    public final Provider<SchedulersFactory3> b;

    public WitcherModule_ProvideWitcherViewedAdvertsPresenter$serp_core_releaseFactory(Provider<ViewedAdvertsEventInteractor> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static WitcherModule_ProvideWitcherViewedAdvertsPresenter$serp_core_releaseFactory create(Provider<ViewedAdvertsEventInteractor> provider, Provider<SchedulersFactory3> provider2) {
        return new WitcherModule_ProvideWitcherViewedAdvertsPresenter$serp_core_releaseFactory(provider, provider2);
    }

    public static ViewedAdvertsPresenter provideWitcherViewedAdvertsPresenter$serp_core_release(ViewedAdvertsEventInteractor viewedAdvertsEventInteractor, SchedulersFactory3 schedulersFactory3) {
        return (ViewedAdvertsPresenter) Preconditions.checkNotNullFromProvides(WitcherModule.INSTANCE.provideWitcherViewedAdvertsPresenter$serp_core_release(viewedAdvertsEventInteractor, schedulersFactory3));
    }

    @Override // javax.inject.Provider
    public ViewedAdvertsPresenter get() {
        return provideWitcherViewedAdvertsPresenter$serp_core_release(this.a.get(), this.b.get());
    }
}
