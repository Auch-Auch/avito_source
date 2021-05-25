package com.avito.android.extended_profile.di;

import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class ExtendedProfileModule_ProvideCommentGalleryClicksStream$extended_profile_releaseFactory implements Factory<PublishRelay<TnsGalleryItemClickAction>> {

    public static final class a {
        public static final ExtendedProfileModule_ProvideCommentGalleryClicksStream$extended_profile_releaseFactory a = new ExtendedProfileModule_ProvideCommentGalleryClicksStream$extended_profile_releaseFactory();
    }

    public static ExtendedProfileModule_ProvideCommentGalleryClicksStream$extended_profile_releaseFactory create() {
        return a.a;
    }

    public static PublishRelay<TnsGalleryItemClickAction> provideCommentGalleryClicksStream$extended_profile_release() {
        return (PublishRelay) Preconditions.checkNotNullFromProvides(ExtendedProfileModule.provideCommentGalleryClicksStream$extended_profile_release());
    }

    @Override // javax.inject.Provider
    public PublishRelay<TnsGalleryItemClickAction> get() {
        return provideCommentGalleryClicksStream$extended_profile_release();
    }
}
