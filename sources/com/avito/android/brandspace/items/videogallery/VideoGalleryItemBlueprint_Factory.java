package com.avito.android.brandspace.items.videogallery;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class VideoGalleryItemBlueprint_Factory implements Factory<VideoGalleryItemBlueprint> {
    public final Provider<VideoGalleryPresenter> a;

    public VideoGalleryItemBlueprint_Factory(Provider<VideoGalleryPresenter> provider) {
        this.a = provider;
    }

    public static VideoGalleryItemBlueprint_Factory create(Provider<VideoGalleryPresenter> provider) {
        return new VideoGalleryItemBlueprint_Factory(provider);
    }

    public static VideoGalleryItemBlueprint newInstance(VideoGalleryPresenter videoGalleryPresenter) {
        return new VideoGalleryItemBlueprint(videoGalleryPresenter);
    }

    @Override // javax.inject.Provider
    public VideoGalleryItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
