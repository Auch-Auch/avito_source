package com.avito.android.di;

import com.avito.android.advert.viewed.ViewedAdvertsEventInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ViewedAdvertsModule_ProvideViewedAdvertsPresenterFactory implements Factory<ViewedAdvertsPresenter> {
    public final Provider<ViewedAdvertsEventInteractor> a;
    public final Provider<SchedulersFactory3> b;

    public ViewedAdvertsModule_ProvideViewedAdvertsPresenterFactory(Provider<ViewedAdvertsEventInteractor> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ViewedAdvertsModule_ProvideViewedAdvertsPresenterFactory create(Provider<ViewedAdvertsEventInteractor> provider, Provider<SchedulersFactory3> provider2) {
        return new ViewedAdvertsModule_ProvideViewedAdvertsPresenterFactory(provider, provider2);
    }

    public static ViewedAdvertsPresenter provideViewedAdvertsPresenter(ViewedAdvertsEventInteractor viewedAdvertsEventInteractor, SchedulersFactory3 schedulersFactory3) {
        return (ViewedAdvertsPresenter) Preconditions.checkNotNullFromProvides(ViewedAdvertsModule.provideViewedAdvertsPresenter(viewedAdvertsEventInteractor, schedulersFactory3));
    }

    @Override // javax.inject.Provider
    public ViewedAdvertsPresenter get() {
        return provideViewedAdvertsPresenter(this.a.get(), this.b.get());
    }
}
