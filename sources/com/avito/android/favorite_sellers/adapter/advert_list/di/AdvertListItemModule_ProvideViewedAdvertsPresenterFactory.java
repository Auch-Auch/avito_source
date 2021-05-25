package com.avito.android.favorite_sellers.adapter.advert_list.di;

import com.avito.android.advert.viewed.ViewedAdvertsEventInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AdvertListItemModule_ProvideViewedAdvertsPresenterFactory implements Factory<ViewedAdvertsPresenter> {
    public final Provider<ViewedAdvertsEventInteractor> a;
    public final Provider<SchedulersFactory3> b;

    public AdvertListItemModule_ProvideViewedAdvertsPresenterFactory(Provider<ViewedAdvertsEventInteractor> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdvertListItemModule_ProvideViewedAdvertsPresenterFactory create(Provider<ViewedAdvertsEventInteractor> provider, Provider<SchedulersFactory3> provider2) {
        return new AdvertListItemModule_ProvideViewedAdvertsPresenterFactory(provider, provider2);
    }

    public static ViewedAdvertsPresenter provideViewedAdvertsPresenter(ViewedAdvertsEventInteractor viewedAdvertsEventInteractor, SchedulersFactory3 schedulersFactory3) {
        return (ViewedAdvertsPresenter) Preconditions.checkNotNullFromProvides(AdvertListItemModule.provideViewedAdvertsPresenter(viewedAdvertsEventInteractor, schedulersFactory3));
    }

    @Override // javax.inject.Provider
    public ViewedAdvertsPresenter get() {
        return provideViewedAdvertsPresenter(this.a.get(), this.b.get());
    }
}
