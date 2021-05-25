package com.avito.android.extended_profile.adapter.gallery;

import android.app.Activity;
import com.avito.android.Features;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class GalleryItemBlueprint_Factory implements Factory<GalleryItemBlueprint> {
    public final Provider<GalleryItemPresenter> a;
    public final Provider<Consumer<TnsGalleryItemClickAction>> b;
    public final Provider<Activity> c;
    public final Provider<Features> d;

    public GalleryItemBlueprint_Factory(Provider<GalleryItemPresenter> provider, Provider<Consumer<TnsGalleryItemClickAction>> provider2, Provider<Activity> provider3, Provider<Features> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static GalleryItemBlueprint_Factory create(Provider<GalleryItemPresenter> provider, Provider<Consumer<TnsGalleryItemClickAction>> provider2, Provider<Activity> provider3, Provider<Features> provider4) {
        return new GalleryItemBlueprint_Factory(provider, provider2, provider3, provider4);
    }

    public static GalleryItemBlueprint newInstance(GalleryItemPresenter galleryItemPresenter, Consumer<TnsGalleryItemClickAction> consumer, Activity activity, Features features) {
        return new GalleryItemBlueprint(galleryItemPresenter, consumer, activity, features);
    }

    @Override // javax.inject.Provider
    public GalleryItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
