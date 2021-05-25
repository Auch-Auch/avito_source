package com.avito.android.rating.di;

import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class RatingsTnsGalleryClicksModule_ProvidesTnsImageGalleryClicksRelayFactory implements Factory<PublishRelay<TnsGalleryItemClickAction>> {

    public static final class a {
        public static final RatingsTnsGalleryClicksModule_ProvidesTnsImageGalleryClicksRelayFactory a = new RatingsTnsGalleryClicksModule_ProvidesTnsImageGalleryClicksRelayFactory();
    }

    public static RatingsTnsGalleryClicksModule_ProvidesTnsImageGalleryClicksRelayFactory create() {
        return a.a;
    }

    public static PublishRelay<TnsGalleryItemClickAction> providesTnsImageGalleryClicksRelay() {
        return (PublishRelay) Preconditions.checkNotNullFromProvides(RatingsTnsGalleryClicksModule.providesTnsImageGalleryClicksRelay());
    }

    @Override // javax.inject.Provider
    public PublishRelay<TnsGalleryItemClickAction> get() {
        return providesTnsImageGalleryClicksRelay();
    }
}
