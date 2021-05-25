package com.avito.android.brandspace.interactor;

import com.avito.android.brandspace.presenter.BrandspacePresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BrandspaceBlockViewAtTopOrBottomFilter_Factory implements Factory<BrandspaceBlockViewAtTopOrBottomFilter> {
    public final Provider<BrandspacePresenter> a;

    public BrandspaceBlockViewAtTopOrBottomFilter_Factory(Provider<BrandspacePresenter> provider) {
        this.a = provider;
    }

    public static BrandspaceBlockViewAtTopOrBottomFilter_Factory create(Provider<BrandspacePresenter> provider) {
        return new BrandspaceBlockViewAtTopOrBottomFilter_Factory(provider);
    }

    public static BrandspaceBlockViewAtTopOrBottomFilter newInstance(BrandspacePresenter brandspacePresenter) {
        return new BrandspaceBlockViewAtTopOrBottomFilter(brandspacePresenter);
    }

    @Override // javax.inject.Provider
    public BrandspaceBlockViewAtTopOrBottomFilter get() {
        return newInstance(this.a.get());
    }
}
