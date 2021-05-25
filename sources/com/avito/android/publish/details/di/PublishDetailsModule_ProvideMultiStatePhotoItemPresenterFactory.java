package com.avito.android.publish.details.di;

import com.avito.android.photo_view.ImageListPresenter;
import com.avito.android.photo_view.PhotoViewResourceProvider;
import com.avito.android.photo_view.blueprints.MultiStatePhotoItemPresenter;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvideMultiStatePhotoItemPresenterFactory implements Factory<MultiStatePhotoItemPresenter> {
    public final PublishDetailsModule a;
    public final Provider<ImageListPresenter> b;
    public final Provider<AttributedTextFormatter> c;
    public final Provider<PhotoViewResourceProvider> d;

    public PublishDetailsModule_ProvideMultiStatePhotoItemPresenterFactory(PublishDetailsModule publishDetailsModule, Provider<ImageListPresenter> provider, Provider<AttributedTextFormatter> provider2, Provider<PhotoViewResourceProvider> provider3) {
        this.a = publishDetailsModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static PublishDetailsModule_ProvideMultiStatePhotoItemPresenterFactory create(PublishDetailsModule publishDetailsModule, Provider<ImageListPresenter> provider, Provider<AttributedTextFormatter> provider2, Provider<PhotoViewResourceProvider> provider3) {
        return new PublishDetailsModule_ProvideMultiStatePhotoItemPresenterFactory(publishDetailsModule, provider, provider2, provider3);
    }

    public static MultiStatePhotoItemPresenter provideMultiStatePhotoItemPresenter(PublishDetailsModule publishDetailsModule, ImageListPresenter imageListPresenter, AttributedTextFormatter attributedTextFormatter, PhotoViewResourceProvider photoViewResourceProvider) {
        return (MultiStatePhotoItemPresenter) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideMultiStatePhotoItemPresenter(imageListPresenter, attributedTextFormatter, photoViewResourceProvider));
    }

    @Override // javax.inject.Provider
    public MultiStatePhotoItemPresenter get() {
        return provideMultiStatePhotoItemPresenter(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
