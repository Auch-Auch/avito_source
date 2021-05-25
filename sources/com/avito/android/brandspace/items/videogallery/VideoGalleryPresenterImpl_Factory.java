package com.avito.android.brandspace.items.videogallery;

import com.avito.android.brandspace.interactor.BrandspaceAnalyticsInteractor;
import com.avito.android.brandspace.items.videogallery.VideoGalleryItemView;
import com.avito.android.brandspace.presenter.BrandspacePresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class VideoGalleryPresenterImpl_Factory implements Factory<VideoGalleryPresenterImpl> {
    public final Provider<BrandspacePresenter> a;
    public final Provider<BrandspaceAnalyticsInteractor> b;
    public final Provider<VideoGalleryItemView.Measurer> c;

    public VideoGalleryPresenterImpl_Factory(Provider<BrandspacePresenter> provider, Provider<BrandspaceAnalyticsInteractor> provider2, Provider<VideoGalleryItemView.Measurer> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static VideoGalleryPresenterImpl_Factory create(Provider<BrandspacePresenter> provider, Provider<BrandspaceAnalyticsInteractor> provider2, Provider<VideoGalleryItemView.Measurer> provider3) {
        return new VideoGalleryPresenterImpl_Factory(provider, provider2, provider3);
    }

    public static VideoGalleryPresenterImpl newInstance(BrandspacePresenter brandspacePresenter, BrandspaceAnalyticsInteractor brandspaceAnalyticsInteractor, VideoGalleryItemView.Measurer measurer) {
        return new VideoGalleryPresenterImpl(brandspacePresenter, brandspaceAnalyticsInteractor, measurer);
    }

    @Override // javax.inject.Provider
    public VideoGalleryPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
