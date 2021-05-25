package com.avito.android.brandspace.items.carousel;

import com.avito.android.brandspace.presenter.BrandspacePresenter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CarouselPresenterImpl_Factory implements Factory<CarouselPresenterImpl> {
    public final Provider<BrandspacePresenter> a;
    public final Provider<SchedulersFactory3> b;

    public CarouselPresenterImpl_Factory(Provider<BrandspacePresenter> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CarouselPresenterImpl_Factory create(Provider<BrandspacePresenter> provider, Provider<SchedulersFactory3> provider2) {
        return new CarouselPresenterImpl_Factory(provider, provider2);
    }

    public static CarouselPresenterImpl newInstance(BrandspacePresenter brandspacePresenter, SchedulersFactory3 schedulersFactory3) {
        return new CarouselPresenterImpl(brandspacePresenter, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public CarouselPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
