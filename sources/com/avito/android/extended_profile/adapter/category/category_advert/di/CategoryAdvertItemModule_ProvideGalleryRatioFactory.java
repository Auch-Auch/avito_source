package com.avito.android.extended_profile.adapter.category.category_advert.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import ru.avito.component.serp.cyclic_gallery.image_carousel.GalleryRatio;
public final class CategoryAdvertItemModule_ProvideGalleryRatioFactory implements Factory<GalleryRatio> {

    public static final class a {
        public static final CategoryAdvertItemModule_ProvideGalleryRatioFactory a = new CategoryAdvertItemModule_ProvideGalleryRatioFactory();
    }

    public static CategoryAdvertItemModule_ProvideGalleryRatioFactory create() {
        return a.a;
    }

    public static GalleryRatio provideGalleryRatio() {
        return (GalleryRatio) Preconditions.checkNotNullFromProvides(CategoryAdvertItemModule.INSTANCE.provideGalleryRatio());
    }

    @Override // javax.inject.Provider
    public GalleryRatio get() {
        return provideGalleryRatio();
    }
}
