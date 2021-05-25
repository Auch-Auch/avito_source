package com.avito.android.advert.item.photogallery;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.util.ImplicitIntentFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsGalleryBlueprint_Factory implements Factory<AdvertDetailsGalleryBlueprint> {
    public final Provider<AdvertDetailsGalleryPresenter> a;
    public final Provider<ImplicitIntentFactory> b;
    public final Provider<Analytics> c;
    public final Provider<Features> d;

    public AdvertDetailsGalleryBlueprint_Factory(Provider<AdvertDetailsGalleryPresenter> provider, Provider<ImplicitIntentFactory> provider2, Provider<Analytics> provider3, Provider<Features> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static AdvertDetailsGalleryBlueprint_Factory create(Provider<AdvertDetailsGalleryPresenter> provider, Provider<ImplicitIntentFactory> provider2, Provider<Analytics> provider3, Provider<Features> provider4) {
        return new AdvertDetailsGalleryBlueprint_Factory(provider, provider2, provider3, provider4);
    }

    public static AdvertDetailsGalleryBlueprint newInstance(AdvertDetailsGalleryPresenter advertDetailsGalleryPresenter, ImplicitIntentFactory implicitIntentFactory, Analytics analytics, Features features) {
        return new AdvertDetailsGalleryBlueprint(advertDetailsGalleryPresenter, implicitIntentFactory, analytics, features);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsGalleryBlueprint get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
