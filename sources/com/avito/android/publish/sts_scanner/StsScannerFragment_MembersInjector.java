package com.avito.android.publish.sts_scanner;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.photo_picker.legacy.GalleryResultsExtractor;
import com.avito.android.photo_picker.legacy.StoppableRotationInteractor;
import com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter;
import com.avito.android.util.ImplicitIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class StsScannerFragment_MembersInjector implements MembersInjector<StsScannerFragment> {
    public final Provider<Analytics> a;
    public final Provider<CameraItemPresenter> b;
    public final Provider<StoppableRotationInteractor> c;
    public final Provider<ImplicitIntentFactory> d;
    public final Provider<ActivityIntentFactory> e;
    public final Provider<GalleryResultsExtractor> f;
    public final Provider<StsScannerPresenter> g;
    public final Provider<DeepLinkIntentFactory> h;

    public StsScannerFragment_MembersInjector(Provider<Analytics> provider, Provider<CameraItemPresenter> provider2, Provider<StoppableRotationInteractor> provider3, Provider<ImplicitIntentFactory> provider4, Provider<ActivityIntentFactory> provider5, Provider<GalleryResultsExtractor> provider6, Provider<StsScannerPresenter> provider7, Provider<DeepLinkIntentFactory> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static MembersInjector<StsScannerFragment> create(Provider<Analytics> provider, Provider<CameraItemPresenter> provider2, Provider<StoppableRotationInteractor> provider3, Provider<ImplicitIntentFactory> provider4, Provider<ActivityIntentFactory> provider5, Provider<GalleryResultsExtractor> provider6, Provider<StsScannerPresenter> provider7, Provider<DeepLinkIntentFactory> provider8) {
        return new StsScannerFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    @InjectedFieldSignature("com.avito.android.publish.sts_scanner.StsScannerFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(StsScannerFragment stsScannerFragment, ActivityIntentFactory activityIntentFactory) {
        stsScannerFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.publish.sts_scanner.StsScannerFragment.analytics")
    public static void injectAnalytics(StsScannerFragment stsScannerFragment, Analytics analytics) {
        stsScannerFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.publish.sts_scanner.StsScannerFragment.cameraPresenter")
    public static void injectCameraPresenter(StsScannerFragment stsScannerFragment, CameraItemPresenter cameraItemPresenter) {
        stsScannerFragment.cameraPresenter = cameraItemPresenter;
    }

    @InjectedFieldSignature("com.avito.android.publish.sts_scanner.StsScannerFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(StsScannerFragment stsScannerFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        stsScannerFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.publish.sts_scanner.StsScannerFragment.galleryResultsExtractor")
    public static void injectGalleryResultsExtractor(StsScannerFragment stsScannerFragment, GalleryResultsExtractor galleryResultsExtractor) {
        stsScannerFragment.galleryResultsExtractor = galleryResultsExtractor;
    }

    @InjectedFieldSignature("com.avito.android.publish.sts_scanner.StsScannerFragment.implicitIntentFactory")
    public static void injectImplicitIntentFactory(StsScannerFragment stsScannerFragment, ImplicitIntentFactory implicitIntentFactory) {
        stsScannerFragment.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.publish.sts_scanner.StsScannerFragment.presenter")
    public static void injectPresenter(StsScannerFragment stsScannerFragment, StsScannerPresenter stsScannerPresenter) {
        stsScannerFragment.presenter = stsScannerPresenter;
    }

    @InjectedFieldSignature("com.avito.android.publish.sts_scanner.StsScannerFragment.rotationInteractor")
    public static void injectRotationInteractor(StsScannerFragment stsScannerFragment, StoppableRotationInteractor stoppableRotationInteractor) {
        stsScannerFragment.rotationInteractor = stoppableRotationInteractor;
    }

    public void injectMembers(StsScannerFragment stsScannerFragment) {
        injectAnalytics(stsScannerFragment, this.a.get());
        injectCameraPresenter(stsScannerFragment, this.b.get());
        injectRotationInteractor(stsScannerFragment, this.c.get());
        injectImplicitIntentFactory(stsScannerFragment, this.d.get());
        injectActivityIntentFactory(stsScannerFragment, this.e.get());
        injectGalleryResultsExtractor(stsScannerFragment, this.f.get());
        injectPresenter(stsScannerFragment, this.g.get());
        injectDeepLinkIntentFactory(stsScannerFragment, this.h.get());
    }
}
