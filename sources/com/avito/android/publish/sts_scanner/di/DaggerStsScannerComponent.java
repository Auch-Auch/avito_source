package com.avito.android.publish.sts_scanner.di;

import android.app.Application;
import android.content.Context;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.permissions.PermissionHelper;
import com.avito.android.photo_picker.legacy.CameraOpenInteractor;
import com.avito.android.photo_picker.legacy.CameraPresenterResourceProvider;
import com.avito.android.photo_picker.legacy.CameraSource;
import com.avito.android.photo_picker.legacy.DescriptionProvider;
import com.avito.android.photo_picker.legacy.DeviceOrientationProvider;
import com.avito.android.photo_picker.legacy.GalleryInteractor;
import com.avito.android.photo_picker.legacy.GalleryResultsExtractor;
import com.avito.android.photo_picker.legacy.PhotoResizer;
import com.avito.android.photo_picker.legacy.RotationInteractor;
import com.avito.android.photo_picker.legacy.RotationProvider;
import com.avito.android.photo_picker.legacy.StoppableRotationInteractor;
import com.avito.android.photo_picker.legacy.api.UploadConverter;
import com.avito.android.photo_picker.legacy.details_list.CameraItemPermissionHandler;
import com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter;
import com.avito.android.photo_picker.legacy.di.CameraItemPresenterModule;
import com.avito.android.photo_picker.legacy.di.CameraItemPresenterModule_ProvideCameraOpenInteractor$photo_picker_releaseFactory;
import com.avito.android.photo_picker.legacy.di.CameraItemPresenterModule_ProvideCameraPresenter$photo_picker_releaseFactory;
import com.avito.android.photo_picker.legacy.di.CameraItemPresenterModule_ProvideCameraPresenterResourceProvider$photo_picker_releaseFactory;
import com.avito.android.photo_picker.legacy.di.CameraItemPresenterModule_ProvideCameraSource$photo_picker_releaseFactory;
import com.avito.android.photo_picker.legacy.di.CameraItemPresenterModule_ProvideDescriptionProvider$photo_picker_releaseFactory;
import com.avito.android.photo_picker.legacy.di.CameraItemPresenterModule_ProvideGalleryInteractor$photo_picker_releaseFactory;
import com.avito.android.photo_picker.legacy.di.CameraItemPresenterModule_ProvidePermissionHandler$photo_picker_releaseFactory;
import com.avito.android.photo_picker.legacy.di.CameraItemPresenterModule_ProvideRotationProvider$photo_picker_releaseFactory;
import com.avito.android.publish.PublishParametersInteractor;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.di.PublishComponent;
import com.avito.android.publish.di.PublishParametersModule;
import com.avito.android.publish.di.PublishParametersModule_ProvidePublishParametersInteractorFactory;
import com.avito.android.publish.di.PublishParametersModule_ProvideUploadConverterFactory;
import com.avito.android.publish.drafts.PublishDraftRepository;
import com.avito.android.publish.drafts.PublishDraftWiper;
import com.avito.android.publish.sts_scanner.StsScannerFragment;
import com.avito.android.publish.sts_scanner.StsScannerFragment_MembersInjector;
import com.avito.android.publish.sts_scanner.StsScannerPresenter;
import com.avito.android.publish.sts_scanner.di.StsScannerComponent;
import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistry;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.model.category_parameters.AttributesTreeConverter;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.shared_image_files_storage.SharedPhotosStorage;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerStsScannerComponent implements StsScannerComponent {
    public Provider<RotationProvider> A;
    public Provider<DescriptionProvider> B;
    public Provider<CallableResponsiveItemPresenterRegistry> C;
    public Provider<PhotoResizer> D;
    public Provider<SharedPhotosStorage> E;
    public Provider<CameraItemPresenter> F;
    public Provider<GalleryResultsExtractor> G;
    public final PublishComponent a;
    public Provider<CameraSource> b;
    public Provider<Analytics> c;
    public Provider<CameraOpenInteractor> d;
    public Provider<Application> e;
    public Provider<GalleryInteractor> f;
    public Provider<DeviceOrientationProvider> g;
    public Provider<StoppableRotationInteractor> h;
    public Provider<RotationInteractor> i;
    public Provider<PublishApi> j;
    public Provider<PublishAnalyticsDataProvider> k;
    public Provider<PublishDraftRepository> l;
    public Provider<Context> m;
    public Provider<UploadConverter> n;
    public Provider<CategoryParametersConverter> o;
    public Provider<AttributesTreeConverter> p;
    public Provider<PublishDraftWiper> q;
    public Provider<Features> r;
    public Provider<PublishParametersInteractor> s;
    public Provider<PublishEventTracker> t;
    public Provider<SchedulersFactory> u;
    public Provider<StsScannerPresenter> v;
    public Provider<CameraItemPresenter.Listener> w;
    public Provider<PermissionHelper> x;
    public Provider<CameraItemPermissionHandler> y;
    public Provider<CameraPresenterResourceProvider> z;

    public static final class b implements StsScannerComponent.Builder {
        public PublishComponent a;
        public StsScannerModule b;
        public CameraItemPresenterModule c;

        public b(a aVar) {
        }

        @Override // com.avito.android.publish.sts_scanner.di.StsScannerComponent.Builder
        public StsScannerComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PublishComponent.class);
            Preconditions.checkBuilderRequirement(this.b, StsScannerModule.class);
            Preconditions.checkBuilderRequirement(this.c, CameraItemPresenterModule.class);
            return new DaggerStsScannerComponent(this.b, new PublishParametersModule(), this.c, this.a, null);
        }

        @Override // com.avito.android.publish.sts_scanner.di.StsScannerComponent.Builder
        public StsScannerComponent.Builder cameraPresenterModule(CameraItemPresenterModule cameraItemPresenterModule) {
            this.c = (CameraItemPresenterModule) Preconditions.checkNotNull(cameraItemPresenterModule);
            return this;
        }

        @Override // com.avito.android.publish.sts_scanner.di.StsScannerComponent.Builder
        public StsScannerComponent.Builder publishComponent(PublishComponent publishComponent) {
            this.a = (PublishComponent) Preconditions.checkNotNull(publishComponent);
            return this;
        }

        @Override // com.avito.android.publish.sts_scanner.di.StsScannerComponent.Builder
        public StsScannerComponent.Builder stsScannerModule(StsScannerModule stsScannerModule) {
            this.b = (StsScannerModule) Preconditions.checkNotNull(stsScannerModule);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final PublishComponent a;

        public c(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<Application> {
        public final PublishComponent a;

        public d(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Application get() {
            return (Application) Preconditions.checkNotNullFromComponent(this.a.application());
        }
    }

    public static class e implements Provider<AttributesTreeConverter> {
        public final PublishComponent a;

        public e(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AttributesTreeConverter get() {
            return (AttributesTreeConverter) Preconditions.checkNotNullFromComponent(this.a.attributesConverter());
        }
    }

    public static class f implements Provider<CategoryParametersConverter> {
        public final PublishComponent a;

        public f(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CategoryParametersConverter get() {
            return (CategoryParametersConverter) Preconditions.checkNotNullFromComponent(this.a.categoryParametersConverter());
        }
    }

    public static class g implements Provider<Context> {
        public final PublishComponent a;

        public g(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public static class h implements Provider<Features> {
        public final PublishComponent a;

        public h(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class i implements Provider<PublishAnalyticsDataProvider> {
        public final PublishComponent a;

        public i(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishAnalyticsDataProvider get() {
            return (PublishAnalyticsDataProvider) Preconditions.checkNotNullFromComponent(this.a.publishAnalyticsDataProvider());
        }
    }

    public static class j implements Provider<PublishApi> {
        public final PublishComponent a;

        public j(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishApi get() {
            return (PublishApi) Preconditions.checkNotNullFromComponent(this.a.publishApi());
        }
    }

    public static class k implements Provider<PublishDraftRepository> {
        public final PublishComponent a;

        public k(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishDraftRepository get() {
            return (PublishDraftRepository) Preconditions.checkNotNullFromComponent(this.a.publishDraftRepository());
        }
    }

    public static class l implements Provider<PublishDraftWiper> {
        public final PublishComponent a;

        public l(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishDraftWiper get() {
            return (PublishDraftWiper) Preconditions.checkNotNullFromComponent(this.a.publishDraftWiper());
        }
    }

    public static class m implements Provider<PublishEventTracker> {
        public final PublishComponent a;

        public m(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishEventTracker get() {
            return (PublishEventTracker) Preconditions.checkNotNullFromComponent(this.a.publishEventTracker());
        }
    }

    public static class n implements Provider<SchedulersFactory> {
        public final PublishComponent a;

        public n(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class o implements Provider<SharedPhotosStorage> {
        public final PublishComponent a;

        public o(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SharedPhotosStorage get() {
            return (SharedPhotosStorage) Preconditions.checkNotNullFromComponent(this.a.sharedPhotosStorage());
        }
    }

    public DaggerStsScannerComponent(StsScannerModule stsScannerModule, PublishParametersModule publishParametersModule, CameraItemPresenterModule cameraItemPresenterModule, PublishComponent publishComponent, a aVar) {
        this.a = publishComponent;
        Provider<CameraSource> provider = SingleCheck.provider(CameraItemPresenterModule_ProvideCameraSource$photo_picker_releaseFactory.create(cameraItemPresenterModule));
        this.b = provider;
        c cVar = new c(publishComponent);
        this.c = cVar;
        this.d = SingleCheck.provider(CameraItemPresenterModule_ProvideCameraOpenInteractor$photo_picker_releaseFactory.create(cameraItemPresenterModule, provider, cVar));
        d dVar = new d(publishComponent);
        this.e = dVar;
        this.f = SingleCheck.provider(CameraItemPresenterModule_ProvideGalleryInteractor$photo_picker_releaseFactory.create(cameraItemPresenterModule, dVar));
        Provider<DeviceOrientationProvider> provider2 = DoubleCheck.provider(StsScannerModule_ProvideDeviceOrientationProvider$publish_releaseFactory.create(stsScannerModule, this.e));
        this.g = provider2;
        Provider<StoppableRotationInteractor> provider3 = DoubleCheck.provider(StsScannerModule_ProvideStoppableRotationInteractor$publish_releaseFactory.create(stsScannerModule, provider2));
        this.h = provider3;
        this.i = DoubleCheck.provider(StsScannerModule_ProvideRotationInteractor$publish_releaseFactory.create(stsScannerModule, provider3));
        this.j = new j(publishComponent);
        this.k = new i(publishComponent);
        this.l = new k(publishComponent);
        g gVar = new g(publishComponent);
        this.m = gVar;
        Provider<UploadConverter> provider4 = SingleCheck.provider(PublishParametersModule_ProvideUploadConverterFactory.create(publishParametersModule, gVar, this.c));
        this.n = provider4;
        f fVar = new f(publishComponent);
        this.o = fVar;
        e eVar = new e(publishComponent);
        this.p = eVar;
        l lVar = new l(publishComponent);
        this.q = lVar;
        h hVar = new h(publishComponent);
        this.r = hVar;
        Provider<PublishParametersInteractor> provider5 = SingleCheck.provider(PublishParametersModule_ProvidePublishParametersInteractorFactory.create(publishParametersModule, this.j, this.k, this.l, provider4, fVar, eVar, lVar, hVar));
        this.s = provider5;
        m mVar = new m(publishComponent);
        this.t = mVar;
        n nVar = new n(publishComponent);
        this.u = nVar;
        Provider<StsScannerPresenter> provider6 = DoubleCheck.provider(StsScannerModule_ProviderStsScannerPresenterFactory.create(stsScannerModule, provider5, mVar, nVar));
        this.v = provider6;
        this.w = DoubleCheck.provider(StsScannerModule_ProvideListener$publish_releaseFactory.create(stsScannerModule, provider6));
        Provider<PermissionHelper> provider7 = DoubleCheck.provider(StsScannerModule_ProvidePermissionHelper$publish_releaseFactory.create(stsScannerModule));
        this.x = provider7;
        this.y = SingleCheck.provider(CameraItemPresenterModule_ProvidePermissionHandler$photo_picker_releaseFactory.create(cameraItemPresenterModule, provider7));
        this.z = SingleCheck.provider(CameraItemPresenterModule_ProvideCameraPresenterResourceProvider$photo_picker_releaseFactory.create(cameraItemPresenterModule));
        this.A = SingleCheck.provider(CameraItemPresenterModule_ProvideRotationProvider$photo_picker_releaseFactory.create(cameraItemPresenterModule));
        this.B = SingleCheck.provider(CameraItemPresenterModule_ProvideDescriptionProvider$photo_picker_releaseFactory.create(cameraItemPresenterModule));
        this.C = DoubleCheck.provider(StsScannerModule_ProvideCallableResponsiveItemPresenterRegistry$publish_releaseFactory.create(stsScannerModule));
        Provider<PhotoResizer> provider8 = DoubleCheck.provider(StsScannerModule_ProvidePhotoSaver$publish_releaseFactory.create(stsScannerModule, this.u));
        this.D = provider8;
        o oVar = new o(publishComponent);
        this.E = oVar;
        this.F = SingleCheck.provider(CameraItemPresenterModule_ProvideCameraPresenter$photo_picker_releaseFactory.create(cameraItemPresenterModule, this.d, this.f, this.i, this.w, this.u, this.y, this.z, this.c, this.A, this.B, this.C, provider8, oVar));
        this.G = DoubleCheck.provider(StsScannerModule_ProvideGalleryResultsExtractor$publish_releaseFactory.create(stsScannerModule));
    }

    public static StsScannerComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.publish.sts_scanner.di.StsScannerComponent
    public void inject(StsScannerFragment stsScannerFragment) {
        StsScannerFragment_MembersInjector.injectAnalytics(stsScannerFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        StsScannerFragment_MembersInjector.injectCameraPresenter(stsScannerFragment, this.F.get());
        StsScannerFragment_MembersInjector.injectRotationInteractor(stsScannerFragment, this.h.get());
        StsScannerFragment_MembersInjector.injectImplicitIntentFactory(stsScannerFragment, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
        StsScannerFragment_MembersInjector.injectActivityIntentFactory(stsScannerFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        StsScannerFragment_MembersInjector.injectGalleryResultsExtractor(stsScannerFragment, this.G.get());
        StsScannerFragment_MembersInjector.injectPresenter(stsScannerFragment, this.v.get());
        StsScannerFragment_MembersInjector.injectDeepLinkIntentFactory(stsScannerFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
    }
}
