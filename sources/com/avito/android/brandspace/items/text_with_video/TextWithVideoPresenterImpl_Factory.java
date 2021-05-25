package com.avito.android.brandspace.items.text_with_video;

import com.avito.android.brandspace.interactor.BrandspaceAnalyticsInteractor;
import com.avito.android.brandspace.presenter.BrandspacePresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class TextWithVideoPresenterImpl_Factory implements Factory<TextWithVideoPresenterImpl> {
    public final Provider<BrandspacePresenter> a;
    public final Provider<BrandspaceAnalyticsInteractor> b;

    public TextWithVideoPresenterImpl_Factory(Provider<BrandspacePresenter> provider, Provider<BrandspaceAnalyticsInteractor> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static TextWithVideoPresenterImpl_Factory create(Provider<BrandspacePresenter> provider, Provider<BrandspaceAnalyticsInteractor> provider2) {
        return new TextWithVideoPresenterImpl_Factory(provider, provider2);
    }

    public static TextWithVideoPresenterImpl newInstance(BrandspacePresenter brandspacePresenter, BrandspaceAnalyticsInteractor brandspaceAnalyticsInteractor) {
        return new TextWithVideoPresenterImpl(brandspacePresenter, brandspaceAnalyticsInteractor);
    }

    @Override // javax.inject.Provider
    public TextWithVideoPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
