package com.avito.android.advert_core.di.module;

import com.avito.android.advert_core.teaser.TeaserObserver;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class GalleryTeaserModule_ProvideTeaserObserverFactory implements Factory<TeaserObserver> {
    public final GalleryTeaserModule a;

    public GalleryTeaserModule_ProvideTeaserObserverFactory(GalleryTeaserModule galleryTeaserModule) {
        this.a = galleryTeaserModule;
    }

    public static GalleryTeaserModule_ProvideTeaserObserverFactory create(GalleryTeaserModule galleryTeaserModule) {
        return new GalleryTeaserModule_ProvideTeaserObserverFactory(galleryTeaserModule);
    }

    public static TeaserObserver provideTeaserObserver(GalleryTeaserModule galleryTeaserModule) {
        return (TeaserObserver) Preconditions.checkNotNullFromProvides(galleryTeaserModule.provideTeaserObserver());
    }

    @Override // javax.inject.Provider
    public TeaserObserver get() {
        return provideTeaserObserver(this.a);
    }
}
