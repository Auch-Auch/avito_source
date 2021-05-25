package com.avito.android.photo_gallery;

import com.avito.android.Features;
import com.avito.android.ab_tests.groups.AdvertAutotekaTeaserInGalleryTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.photo_gallery.tracker.GalleryTracker;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class GalleryFragment_MembersInjector implements MembersInjector<GalleryFragment> {
    public final Provider<GalleryTracker> a;
    public final Provider<Analytics> b;
    public final Provider<ConnectivityProvider> c;
    public final Provider<Features> d;
    public final Provider<ManuallyExposedAbTestGroup<AdvertAutotekaTeaserInGalleryTestGroup>> e;

    public GalleryFragment_MembersInjector(Provider<GalleryTracker> provider, Provider<Analytics> provider2, Provider<ConnectivityProvider> provider3, Provider<Features> provider4, Provider<ManuallyExposedAbTestGroup<AdvertAutotekaTeaserInGalleryTestGroup>> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<GalleryFragment> create(Provider<GalleryTracker> provider, Provider<Analytics> provider2, Provider<ConnectivityProvider> provider3, Provider<Features> provider4, Provider<ManuallyExposedAbTestGroup<AdvertAutotekaTeaserInGalleryTestGroup>> provider5) {
        return new GalleryFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.photo_gallery.GalleryFragment.analytics")
    public static void injectAnalytics(GalleryFragment galleryFragment, Analytics analytics) {
        galleryFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.photo_gallery.GalleryFragment.autotekaTeaserInGalleryTestGroup")
    public static void injectAutotekaTeaserInGalleryTestGroup(GalleryFragment galleryFragment, ManuallyExposedAbTestGroup<AdvertAutotekaTeaserInGalleryTestGroup> manuallyExposedAbTestGroup) {
        galleryFragment.autotekaTeaserInGalleryTestGroup = manuallyExposedAbTestGroup;
    }

    @InjectedFieldSignature("com.avito.android.photo_gallery.GalleryFragment.connectivityProvider")
    public static void injectConnectivityProvider(GalleryFragment galleryFragment, ConnectivityProvider connectivityProvider) {
        galleryFragment.connectivityProvider = connectivityProvider;
    }

    @InjectedFieldSignature("com.avito.android.photo_gallery.GalleryFragment.features")
    public static void injectFeatures(GalleryFragment galleryFragment, Features features) {
        galleryFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.photo_gallery.GalleryFragment.tracker")
    public static void injectTracker(GalleryFragment galleryFragment, GalleryTracker galleryTracker) {
        galleryFragment.tracker = galleryTracker;
    }

    public void injectMembers(GalleryFragment galleryFragment) {
        injectTracker(galleryFragment, this.a.get());
        injectAnalytics(galleryFragment, this.b.get());
        injectConnectivityProvider(galleryFragment, this.c.get());
        injectFeatures(galleryFragment, this.d.get());
        injectAutotekaTeaserInGalleryTestGroup(galleryFragment, this.e.get());
    }
}
