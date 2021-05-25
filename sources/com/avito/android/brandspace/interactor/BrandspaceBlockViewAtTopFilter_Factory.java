package com.avito.android.brandspace.interactor;

import com.avito.android.brandspace.presenter.BrandspacePresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BrandspaceBlockViewAtTopFilter_Factory implements Factory<BrandspaceBlockViewAtTopFilter> {
    public final Provider<BrandspacePresenter> a;

    public BrandspaceBlockViewAtTopFilter_Factory(Provider<BrandspacePresenter> provider) {
        this.a = provider;
    }

    public static BrandspaceBlockViewAtTopFilter_Factory create(Provider<BrandspacePresenter> provider) {
        return new BrandspaceBlockViewAtTopFilter_Factory(provider);
    }

    public static BrandspaceBlockViewAtTopFilter newInstance(BrandspacePresenter brandspacePresenter) {
        return new BrandspaceBlockViewAtTopFilter(brandspacePresenter);
    }

    @Override // javax.inject.Provider
    public BrandspaceBlockViewAtTopFilter get() {
        return newInstance(this.a.get());
    }
}
