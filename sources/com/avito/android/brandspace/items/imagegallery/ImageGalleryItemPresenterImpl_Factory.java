package com.avito.android.brandspace.items.imagegallery;

import com.avito.android.brandspace.presenter.BrandspaceResourcesProvider;
import com.avito.android.util.DeviceMetrics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ImageGalleryItemPresenterImpl_Factory implements Factory<ImageGalleryItemPresenterImpl> {
    public final Provider<DeviceMetrics> a;
    public final Provider<BrandspaceResourcesProvider> b;

    public ImageGalleryItemPresenterImpl_Factory(Provider<DeviceMetrics> provider, Provider<BrandspaceResourcesProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ImageGalleryItemPresenterImpl_Factory create(Provider<DeviceMetrics> provider, Provider<BrandspaceResourcesProvider> provider2) {
        return new ImageGalleryItemPresenterImpl_Factory(provider, provider2);
    }

    public static ImageGalleryItemPresenterImpl newInstance(DeviceMetrics deviceMetrics, BrandspaceResourcesProvider brandspaceResourcesProvider) {
        return new ImageGalleryItemPresenterImpl(deviceMetrics, brandspaceResourcesProvider);
    }

    @Override // javax.inject.Provider
    public ImageGalleryItemPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
