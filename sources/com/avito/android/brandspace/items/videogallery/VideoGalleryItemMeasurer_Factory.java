package com.avito.android.brandspace.items.videogallery;

import com.avito.android.brandspace.items.videogallery.VideoGalleryItemView;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class VideoGalleryItemMeasurer_Factory implements Factory<VideoGalleryItemMeasurer> {
    public final Provider<VideoGalleryItemView.Measurer> a;

    public VideoGalleryItemMeasurer_Factory(Provider<VideoGalleryItemView.Measurer> provider) {
        this.a = provider;
    }

    public static VideoGalleryItemMeasurer_Factory create(Provider<VideoGalleryItemView.Measurer> provider) {
        return new VideoGalleryItemMeasurer_Factory(provider);
    }

    public static VideoGalleryItemMeasurer newInstance(Lazy<VideoGalleryItemView.Measurer> lazy) {
        return new VideoGalleryItemMeasurer(lazy);
    }

    @Override // javax.inject.Provider
    public VideoGalleryItemMeasurer get() {
        return newInstance(DoubleCheck.lazy(this.a));
    }
}
