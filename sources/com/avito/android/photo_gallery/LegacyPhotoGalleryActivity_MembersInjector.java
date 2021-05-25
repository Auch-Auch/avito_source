package com.avito.android.photo_gallery;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.advert_core.contactbar.AdvertContactsPresenter;
import com.avito.android.advert_core.teaser.TeaserObserver;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.photo_gallery.tracker.PhotoGalleryTracker;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Formatter;
import com.avito.android.util.ImplicitIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class LegacyPhotoGalleryActivity_MembersInjector implements MembersInjector<LegacyPhotoGalleryActivity> {
    public final Provider<ImplicitIntentFactory> a;
    public final Provider<DeepLinkIntentFactory> b;
    public final Provider<ActivityIntentFactory> c;
    public final Provider<Features> d;
    public final Provider<Analytics> e;
    public final Provider<AdvertContactsPresenter> f;
    public final Provider<Formatter<String>> g;
    public final Provider<Formatter<Throwable>> h;
    public final Provider<PhotoGalleryTracker> i;
    public final Provider<DialogRouter> j;
    public final Provider<TeaserObserver> k;

    public LegacyPhotoGalleryActivity_MembersInjector(Provider<ImplicitIntentFactory> provider, Provider<DeepLinkIntentFactory> provider2, Provider<ActivityIntentFactory> provider3, Provider<Features> provider4, Provider<Analytics> provider5, Provider<AdvertContactsPresenter> provider6, Provider<Formatter<String>> provider7, Provider<Formatter<Throwable>> provider8, Provider<PhotoGalleryTracker> provider9, Provider<DialogRouter> provider10, Provider<TeaserObserver> provider11) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
        this.k = provider11;
    }

    public static MembersInjector<LegacyPhotoGalleryActivity> create(Provider<ImplicitIntentFactory> provider, Provider<DeepLinkIntentFactory> provider2, Provider<ActivityIntentFactory> provider3, Provider<Features> provider4, Provider<Analytics> provider5, Provider<AdvertContactsPresenter> provider6, Provider<Formatter<String>> provider7, Provider<Formatter<Throwable>> provider8, Provider<PhotoGalleryTracker> provider9, Provider<DialogRouter> provider10, Provider<TeaserObserver> provider11) {
        return new LegacyPhotoGalleryActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    @InjectedFieldSignature("com.avito.android.photo_gallery.LegacyPhotoGalleryActivity.activityIntentFactory")
    public static void injectActivityIntentFactory(LegacyPhotoGalleryActivity legacyPhotoGalleryActivity, ActivityIntentFactory activityIntentFactory) {
        legacyPhotoGalleryActivity.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.photo_gallery.LegacyPhotoGalleryActivity.advertContactsPresenter")
    public static void injectAdvertContactsPresenter(LegacyPhotoGalleryActivity legacyPhotoGalleryActivity, AdvertContactsPresenter advertContactsPresenter) {
        legacyPhotoGalleryActivity.advertContactsPresenter = advertContactsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.photo_gallery.LegacyPhotoGalleryActivity.analytics")
    public static void injectAnalytics(LegacyPhotoGalleryActivity legacyPhotoGalleryActivity, Analytics analytics) {
        legacyPhotoGalleryActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.photo_gallery.LegacyPhotoGalleryActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(LegacyPhotoGalleryActivity legacyPhotoGalleryActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        legacyPhotoGalleryActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.photo_gallery.LegacyPhotoGalleryActivity.dialogRouter")
    public static void injectDialogRouter(LegacyPhotoGalleryActivity legacyPhotoGalleryActivity, DialogRouter dialogRouter) {
        legacyPhotoGalleryActivity.dialogRouter = dialogRouter;
    }

    @InjectedFieldSignature("com.avito.android.photo_gallery.LegacyPhotoGalleryActivity.errorFormatter")
    public static void injectErrorFormatter(LegacyPhotoGalleryActivity legacyPhotoGalleryActivity, Formatter<Throwable> formatter) {
        legacyPhotoGalleryActivity.errorFormatter = formatter;
    }

    @InjectedFieldSignature("com.avito.android.photo_gallery.LegacyPhotoGalleryActivity.features")
    public static void injectFeatures(LegacyPhotoGalleryActivity legacyPhotoGalleryActivity, Features features) {
        legacyPhotoGalleryActivity.features = features;
    }

    @InjectedFieldSignature("com.avito.android.photo_gallery.LegacyPhotoGalleryActivity.implicitIntentFactory")
    public static void injectImplicitIntentFactory(LegacyPhotoGalleryActivity legacyPhotoGalleryActivity, ImplicitIntentFactory implicitIntentFactory) {
        legacyPhotoGalleryActivity.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.photo_gallery.LegacyPhotoGalleryActivity.phoneNumberFormatter")
    public static void injectPhoneNumberFormatter(LegacyPhotoGalleryActivity legacyPhotoGalleryActivity, Formatter<String> formatter) {
        legacyPhotoGalleryActivity.phoneNumberFormatter = formatter;
    }

    @InjectedFieldSignature("com.avito.android.photo_gallery.LegacyPhotoGalleryActivity.teaserObserver")
    public static void injectTeaserObserver(LegacyPhotoGalleryActivity legacyPhotoGalleryActivity, TeaserObserver teaserObserver) {
        legacyPhotoGalleryActivity.teaserObserver = teaserObserver;
    }

    @InjectedFieldSignature("com.avito.android.photo_gallery.LegacyPhotoGalleryActivity.tracker")
    public static void injectTracker(LegacyPhotoGalleryActivity legacyPhotoGalleryActivity, PhotoGalleryTracker photoGalleryTracker) {
        legacyPhotoGalleryActivity.tracker = photoGalleryTracker;
    }

    public void injectMembers(LegacyPhotoGalleryActivity legacyPhotoGalleryActivity) {
        injectImplicitIntentFactory(legacyPhotoGalleryActivity, this.a.get());
        injectDeepLinkIntentFactory(legacyPhotoGalleryActivity, this.b.get());
        injectActivityIntentFactory(legacyPhotoGalleryActivity, this.c.get());
        injectFeatures(legacyPhotoGalleryActivity, this.d.get());
        injectAnalytics(legacyPhotoGalleryActivity, this.e.get());
        injectAdvertContactsPresenter(legacyPhotoGalleryActivity, this.f.get());
        injectPhoneNumberFormatter(legacyPhotoGalleryActivity, this.g.get());
        injectErrorFormatter(legacyPhotoGalleryActivity, this.h.get());
        injectTracker(legacyPhotoGalleryActivity, this.i.get());
        injectDialogRouter(legacyPhotoGalleryActivity, this.j.get());
        injectTeaserObserver(legacyPhotoGalleryActivity, this.k.get());
    }
}
