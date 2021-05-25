package com.avito.android.photo_gallery;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.util.ImplicitIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class PhotoGalleryActivity_MembersInjector implements MembersInjector<PhotoGalleryActivity> {
    public final Provider<Features> a;
    public final Provider<ImplicitIntentFactory> b;
    public final Provider<Analytics> c;

    public PhotoGalleryActivity_MembersInjector(Provider<Features> provider, Provider<ImplicitIntentFactory> provider2, Provider<Analytics> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<PhotoGalleryActivity> create(Provider<Features> provider, Provider<ImplicitIntentFactory> provider2, Provider<Analytics> provider3) {
        return new PhotoGalleryActivity_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.photo_gallery.PhotoGalleryActivity.analytics")
    public static void injectAnalytics(PhotoGalleryActivity photoGalleryActivity, Analytics analytics) {
        photoGalleryActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.photo_gallery.PhotoGalleryActivity.features")
    public static void injectFeatures(PhotoGalleryActivity photoGalleryActivity, Features features) {
        photoGalleryActivity.features = features;
    }

    @InjectedFieldSignature("com.avito.android.photo_gallery.PhotoGalleryActivity.implicitIntentFactory")
    public static void injectImplicitIntentFactory(PhotoGalleryActivity photoGalleryActivity, ImplicitIntentFactory implicitIntentFactory) {
        photoGalleryActivity.implicitIntentFactory = implicitIntentFactory;
    }

    public void injectMembers(PhotoGalleryActivity photoGalleryActivity) {
        injectFeatures(photoGalleryActivity, this.a.get());
        injectImplicitIntentFactory(photoGalleryActivity, this.b.get());
        injectAnalytics(photoGalleryActivity, this.c.get());
    }
}
