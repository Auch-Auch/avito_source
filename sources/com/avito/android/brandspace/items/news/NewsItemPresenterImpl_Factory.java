package com.avito.android.brandspace.items.news;

import com.avito.android.brandspace.interactor.BrandspaceAnalyticsInteractor;
import com.avito.android.brandspace.presenter.BrandspacePresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NewsItemPresenterImpl_Factory implements Factory<NewsItemPresenterImpl> {
    public final Provider<BrandspacePresenter> a;
    public final Provider<BrandspaceAnalyticsInteractor> b;

    public NewsItemPresenterImpl_Factory(Provider<BrandspacePresenter> provider, Provider<BrandspaceAnalyticsInteractor> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static NewsItemPresenterImpl_Factory create(Provider<BrandspacePresenter> provider, Provider<BrandspaceAnalyticsInteractor> provider2) {
        return new NewsItemPresenterImpl_Factory(provider, provider2);
    }

    public static NewsItemPresenterImpl newInstance(BrandspacePresenter brandspacePresenter, BrandspaceAnalyticsInteractor brandspaceAnalyticsInteractor) {
        return new NewsItemPresenterImpl(brandspacePresenter, brandspaceAnalyticsInteractor);
    }

    @Override // javax.inject.Provider
    public NewsItemPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
