package com.avito.android.photo_picker.legacy.di;

import android.app.Application;
import android.content.Context;
import com.avito.android.Features;
import com.avito.android.PublishIntentFactory;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.PhotoPickerEventTracker;
import com.avito.android.computer_vision.ComputerVisionInteractor;
import com.avito.android.permissions.PermissionHelper;
import com.avito.android.photo.BitmapFileProvider;
import com.avito.android.photo.ThumbnailProvider;
import com.avito.android.photo_picker.ExifExtraDataSerializer;
import com.avito.android.photo_picker.ExifExtraDataSerializerImpl;
import com.avito.android.photo_picker.ExifExtraDataSerializerImpl_Factory;
import com.avito.android.photo_picker.PhotoPickerActivity;
import com.avito.android.photo_picker.PhotoPickerActivity_MembersInjector;
import com.avito.android.photo_picker.PhotoPickerViewModelFactory;
import com.avito.android.photo_picker.PhotoPickerViewModelFactory_Factory;
import com.avito.android.photo_picker.legacy.CameraOpenInteractor;
import com.avito.android.photo_picker.legacy.CameraPresenterResourceProvider;
import com.avito.android.photo_picker.legacy.CameraSource;
import com.avito.android.photo_picker.legacy.DescriptionProvider;
import com.avito.android.photo_picker.legacy.DeviceOrientationProvider;
import com.avito.android.photo_picker.legacy.GalleryInteractor;
import com.avito.android.photo_picker.legacy.GalleryResultsExtractor;
import com.avito.android.photo_picker.legacy.PhotoDragAndDrop;
import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.photo_picker.legacy.PhotoPickerInteractor;
import com.avito.android.photo_picker.legacy.PhotoPickerPresenter;
import com.avito.android.photo_picker.legacy.PhotoPickerPresenterResourceProvider;
import com.avito.android.photo_picker.legacy.PhotoResizer;
import com.avito.android.photo_picker.legacy.RotationInteractor;
import com.avito.android.photo_picker.legacy.RotationProvider;
import com.avito.android.photo_picker.legacy.StoppableRotationInteractor;
import com.avito.android.photo_picker.legacy.details_list.CameraItemPermissionHandler;
import com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter;
import com.avito.android.photo_picker.legacy.details_list.DetailsBlueprintProvider;
import com.avito.android.photo_picker.legacy.details_list.DisplayAnalyzer;
import com.avito.android.photo_picker.legacy.details_list.EditorItemPresenter;
import com.avito.android.photo_picker.legacy.di.PhotoPickerComponent;
import com.avito.android.photo_picker.legacy.thumbnail_list.BasePhotoItem;
import com.avito.android.photo_picker.legacy.thumbnail_list.ThumbnailItemPresenter;
import com.avito.android.photo_picker.legacy.thumbnail_list.ThumbnailItemView;
import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistry;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.PrivatePhotosStorage;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.shared_image_files_storage.SharedPhotosStorage;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.google.gson.Gson;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerPhotoPickerComponent implements PhotoPickerComponent {
    public Provider<PublishIntentFactory.PhotoPickerMode> A;
    public Provider<EditorItemPresenter> B;
    public Provider<DeviceMetrics> C;
    public Provider<DisplayAnalyzer> D;
    public Provider<DetailsBlueprintProvider> E;
    public Provider<ItemBinder> F;
    public Provider<AdapterPresenter> G;
    public Provider<ThumbnailItemPresenter> H;
    public Provider<ItemBlueprint<ThumbnailItemView, BasePhotoItem>> I;
    public Provider<ItemBinder> J;
    public Provider<AdapterPresenter> K;
    public Provider<BuildInfo> L;
    public Provider<PhotoInteractor> M;
    public Provider<PrivatePhotosStorage> N;
    public Provider<BitmapFileProvider> O;
    public Provider<ThumbnailProvider> P;
    public Provider<PhotoPickerEventTracker> Q;
    public Provider<ComputerVisionInteractor> R;
    public Provider<Features> S;
    public Provider<PhotoPickerInteractor> T;
    public Provider<PhotoPickerPresenterResourceProvider> U;
    public Provider<RandomKeyProvider> V;
    public Provider<PhotoDragAndDrop> W;
    public Provider<GalleryResultsExtractor> X;
    public Provider<Integer> Y;
    public Provider<PhotoPickerViewModelFactory> Z;
    public final PhotoPickerDependencies a;
    public Provider<ResponsiveAdapterPresenter> a0;
    public final Gson b;
    public Provider<SimpleRecyclerAdapter> b0;
    public final PhotoPickerModule c;
    public Provider<SimpleRecyclerAdapter> c0;
    public Provider<PermissionHelper> d;
    public Provider<Gson> e;
    public Provider<ExifExtraDataSerializerImpl> f;
    public Provider<ExifExtraDataSerializer> g;
    public Provider<CameraSource> h;
    public Provider<Analytics> i;
    public Provider<CameraOpenInteractor> j;
    public Provider<Application> k;
    public Provider<GalleryInteractor> l;
    public Provider<DeviceOrientationProvider> m;
    public Provider<StoppableRotationInteractor> n;
    public Provider<RotationInteractor> o;
    public Provider<PhotoPickerPresenter> p;
    public Provider<CameraItemPresenter.Listener> q;
    public Provider<SchedulersFactory> r;
    public Provider<CameraItemPermissionHandler> s;
    public Provider<CameraPresenterResourceProvider> t;
    public Provider<RotationProvider> u;
    public Provider<DescriptionProvider> v;
    public Provider<CallableResponsiveItemPresenterRegistry> w;
    public Provider<PhotoResizer> x;
    public Provider<SharedPhotosStorage> y;
    public Provider<CameraItemPresenter> z;

    public static final class b implements PhotoPickerComponent.Builder {
        public PhotoPickerDependencies a;
        public PhotoPickerModule b;
        public CameraItemPresenterModule c;
        public PublishIntentFactory.PhotoPickerMode d;
        public Integer e;
        public Gson f;

        public b(a aVar) {
        }

        @Override // com.avito.android.photo_picker.legacy.di.PhotoPickerComponent.Builder
        public PhotoPickerComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PhotoPickerDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, PhotoPickerModule.class);
            Preconditions.checkBuilderRequirement(this.c, CameraItemPresenterModule.class);
            Preconditions.checkBuilderRequirement(this.d, PublishIntentFactory.PhotoPickerMode.class);
            Preconditions.checkBuilderRequirement(this.e, Integer.class);
            Preconditions.checkBuilderRequirement(this.f, Gson.class);
            return new DaggerPhotoPickerComponent(this.b, this.c, this.a, this.d, this.e, this.f, null);
        }

        @Override // com.avito.android.photo_picker.legacy.di.PhotoPickerComponent.Builder
        public PhotoPickerComponent.Builder cameraItemPresenterModule(CameraItemPresenterModule cameraItemPresenterModule) {
            this.c = (CameraItemPresenterModule) Preconditions.checkNotNull(cameraItemPresenterModule);
            return this;
        }

        @Override // com.avito.android.photo_picker.legacy.di.PhotoPickerComponent.Builder
        public PhotoPickerComponent.Builder dependencies(PhotoPickerDependencies photoPickerDependencies) {
            this.a = (PhotoPickerDependencies) Preconditions.checkNotNull(photoPickerDependencies);
            return this;
        }

        @Override // com.avito.android.photo_picker.legacy.di.PhotoPickerComponent.Builder
        public PhotoPickerComponent.Builder photoPickerModule(PhotoPickerModule photoPickerModule) {
            this.b = (PhotoPickerModule) Preconditions.checkNotNull(photoPickerModule);
            return this;
        }

        @Override // com.avito.android.photo_picker.legacy.di.PhotoPickerComponent.Builder
        public PhotoPickerComponent.Builder withGson(Gson gson) {
            this.f = (Gson) Preconditions.checkNotNull(gson);
            return this;
        }

        @Override // com.avito.android.photo_picker.legacy.di.PhotoPickerComponent.Builder
        public PhotoPickerComponent.Builder withMaxPhotoCount(int i) {
            this.e = (Integer) Preconditions.checkNotNull(Integer.valueOf(i));
            return this;
        }

        @Override // com.avito.android.photo_picker.legacy.di.PhotoPickerComponent.Builder
        public PhotoPickerComponent.Builder withMode(PublishIntentFactory.PhotoPickerMode photoPickerMode) {
            this.d = (PublishIntentFactory.PhotoPickerMode) Preconditions.checkNotNull(photoPickerMode);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final PhotoPickerDependencies a;

        public c(PhotoPickerDependencies photoPickerDependencies) {
            this.a = photoPickerDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<Application> {
        public final PhotoPickerDependencies a;

        public d(PhotoPickerDependencies photoPickerDependencies) {
            this.a = photoPickerDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Application get() {
            return (Application) Preconditions.checkNotNullFromComponent(this.a.application());
        }
    }

    public static class e implements Provider<BuildInfo> {
        public final PhotoPickerDependencies a;

        public e(PhotoPickerDependencies photoPickerDependencies) {
            this.a = photoPickerDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BuildInfo get() {
            return (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo());
        }
    }

    public static class f implements Provider<ComputerVisionInteractor> {
        public final PhotoPickerDependencies a;

        public f(PhotoPickerDependencies photoPickerDependencies) {
            this.a = photoPickerDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ComputerVisionInteractor get() {
            return (ComputerVisionInteractor) Preconditions.checkNotNullFromComponent(this.a.computerVisionInteractor());
        }
    }

    public static class g implements Provider<DeviceMetrics> {
        public final PhotoPickerDependencies a;

        public g(PhotoPickerDependencies photoPickerDependencies) {
            this.a = photoPickerDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeviceMetrics get() {
            return (DeviceMetrics) Preconditions.checkNotNullFromComponent(this.a.deviceMetrics());
        }
    }

    public static class h implements Provider<Features> {
        public final PhotoPickerDependencies a;

        public h(PhotoPickerDependencies photoPickerDependencies) {
            this.a = photoPickerDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class i implements Provider<PhotoPickerEventTracker> {
        public final PhotoPickerDependencies a;

        public i(PhotoPickerDependencies photoPickerDependencies) {
            this.a = photoPickerDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PhotoPickerEventTracker get() {
            return (PhotoPickerEventTracker) Preconditions.checkNotNullFromComponent(this.a.photoPickerEventTracker());
        }
    }

    public static class j implements Provider<PrivatePhotosStorage> {
        public final PhotoPickerDependencies a;

        public j(PhotoPickerDependencies photoPickerDependencies) {
            this.a = photoPickerDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PrivatePhotosStorage get() {
            return (PrivatePhotosStorage) Preconditions.checkNotNullFromComponent(this.a.privatePhotosStorage());
        }
    }

    public static class k implements Provider<RandomKeyProvider> {
        public final PhotoPickerDependencies a;

        public k(PhotoPickerDependencies photoPickerDependencies) {
            this.a = photoPickerDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public RandomKeyProvider get() {
            return (RandomKeyProvider) Preconditions.checkNotNullFromComponent(this.a.randomKeyProvider());
        }
    }

    public static class l implements Provider<SchedulersFactory> {
        public final PhotoPickerDependencies a;

        public l(PhotoPickerDependencies photoPickerDependencies) {
            this.a = photoPickerDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class m implements Provider<SharedPhotosStorage> {
        public final PhotoPickerDependencies a;

        public m(PhotoPickerDependencies photoPickerDependencies) {
            this.a = photoPickerDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SharedPhotosStorage get() {
            return (SharedPhotosStorage) Preconditions.checkNotNullFromComponent(this.a.sharedPhotosStorage());
        }
    }

    public DaggerPhotoPickerComponent(PhotoPickerModule photoPickerModule, CameraItemPresenterModule cameraItemPresenterModule, PhotoPickerDependencies photoPickerDependencies, PublishIntentFactory.PhotoPickerMode photoPickerMode, Integer num, Gson gson, a aVar) {
        this.a = photoPickerDependencies;
        this.b = gson;
        this.c = photoPickerModule;
        this.d = DoubleCheck.provider(PhotoPickerModule_ProvidePermissionHelper$photo_picker_releaseFactory.create(photoPickerModule));
        Factory create = InstanceFactory.create(gson);
        this.e = create;
        ExifExtraDataSerializerImpl_Factory create2 = ExifExtraDataSerializerImpl_Factory.create(create);
        this.f = create2;
        this.g = DoubleCheck.provider(PhotoPickerModule_ProvideExifExtraDataSerializerFactory.create(photoPickerModule, create2));
        Provider<CameraSource> provider = SingleCheck.provider(CameraItemPresenterModule_ProvideCameraSource$photo_picker_releaseFactory.create(cameraItemPresenterModule));
        this.h = provider;
        c cVar = new c(photoPickerDependencies);
        this.i = cVar;
        this.j = SingleCheck.provider(CameraItemPresenterModule_ProvideCameraOpenInteractor$photo_picker_releaseFactory.create(cameraItemPresenterModule, provider, cVar));
        d dVar = new d(photoPickerDependencies);
        this.k = dVar;
        this.l = SingleCheck.provider(CameraItemPresenterModule_ProvideGalleryInteractor$photo_picker_releaseFactory.create(cameraItemPresenterModule, dVar));
        Provider<DeviceOrientationProvider> provider2 = DoubleCheck.provider(PhotoPickerModule_ProvideOrientationProvider$photo_picker_releaseFactory.create(photoPickerModule, this.k));
        this.m = provider2;
        Provider<StoppableRotationInteractor> provider3 = DoubleCheck.provider(PhotoPickerModule_ProvideStoppableRotationInteractor$photo_picker_releaseFactory.create(photoPickerModule, provider2));
        this.n = provider3;
        this.o = DoubleCheck.provider(PhotoPickerModule_ProvideRotationInteractor$photo_picker_releaseFactory.create(photoPickerModule, provider3));
        DelegateFactory delegateFactory = new DelegateFactory();
        this.p = delegateFactory;
        this.q = DoubleCheck.provider(PhotoPickerModule_ProvideCameraItemPresenterListener$photo_picker_releaseFactory.create(photoPickerModule, delegateFactory));
        this.r = new l(photoPickerDependencies);
        this.s = SingleCheck.provider(CameraItemPresenterModule_ProvidePermissionHandler$photo_picker_releaseFactory.create(cameraItemPresenterModule, this.d));
        this.t = SingleCheck.provider(CameraItemPresenterModule_ProvideCameraPresenterResourceProvider$photo_picker_releaseFactory.create(cameraItemPresenterModule));
        this.u = SingleCheck.provider(CameraItemPresenterModule_ProvideRotationProvider$photo_picker_releaseFactory.create(cameraItemPresenterModule));
        this.v = SingleCheck.provider(CameraItemPresenterModule_ProvideDescriptionProvider$photo_picker_releaseFactory.create(cameraItemPresenterModule));
        this.w = DoubleCheck.provider(PhotoPickerModule_ProvideResponsiveItemPresenterRegistry$photo_picker_releaseFactory.create(photoPickerModule));
        Provider<PhotoResizer> provider4 = DoubleCheck.provider(PhotoPickerModule_ProvidePhotoSaver$photo_picker_releaseFactory.create(photoPickerModule, this.r));
        this.x = provider4;
        m mVar = new m(photoPickerDependencies);
        this.y = mVar;
        this.z = SingleCheck.provider(CameraItemPresenterModule_ProvideCameraPresenter$photo_picker_releaseFactory.create(cameraItemPresenterModule, this.j, this.l, this.o, this.q, this.r, this.s, this.t, this.i, this.u, this.v, this.w, provider4, mVar));
        Factory create3 = InstanceFactory.create(photoPickerMode);
        this.A = create3;
        this.B = DoubleCheck.provider(PhotoPickerModule_ProvideEditorItemPresenter$photo_picker_releaseFactory.create(photoPickerModule, this.p, this.n, create3));
        g gVar = new g(photoPickerDependencies);
        this.C = gVar;
        PhotoPickerModule_ProvideDisplayAnalyzer$photo_picker_releaseFactory create4 = PhotoPickerModule_ProvideDisplayAnalyzer$photo_picker_releaseFactory.create(photoPickerModule, gVar);
        this.D = create4;
        Provider<DetailsBlueprintProvider> provider5 = DoubleCheck.provider(PhotoPickerModule_ProvideDetailsBluePrintProvider$photo_picker_releaseFactory.create(photoPickerModule, this.z, this.B, create4));
        this.E = provider5;
        Provider<ItemBinder> provider6 = DoubleCheck.provider(PhotoPickerModule_ProvideDetailsItemBinder$photo_picker_releaseFactory.create(photoPickerModule, provider5));
        this.F = provider6;
        this.G = DoubleCheck.provider(PhotoPickerModule_ProvidesDetailsAdapterPresenter$photo_picker_releaseFactory.create(photoPickerModule, provider6));
        Provider<ThumbnailItemPresenter> provider7 = DoubleCheck.provider(PhotoPickerModule_ProvidesPhotoItemPresenter$photo_picker_releaseFactory.create(photoPickerModule, this.p, this.n));
        this.H = provider7;
        Provider<ItemBlueprint<ThumbnailItemView, BasePhotoItem>> provider8 = DoubleCheck.provider(PhotoPickerModule_ProvideThumbnailItemBlueprint$photo_picker_releaseFactory.create(photoPickerModule, provider7));
        this.I = provider8;
        Provider<ItemBinder> provider9 = DoubleCheck.provider(PhotoPickerModule_ProvideThumbnailsItemBinder$photo_picker_releaseFactory.create(photoPickerModule, provider8));
        this.J = provider9;
        this.K = DoubleCheck.provider(PhotoPickerModule_ProvidesThumbnailsAdapterPresenter$photo_picker_releaseFactory.create(photoPickerModule, provider9));
        e eVar = new e(photoPickerDependencies);
        this.L = eVar;
        this.M = DoubleCheck.provider(PhotoPickerModule_ProvidePhotoInteractor$photo_picker_releaseFactory.create(photoPickerModule, this.k, eVar));
        j jVar = new j(photoPickerDependencies);
        this.N = jVar;
        this.O = DoubleCheck.provider(PhotoPickerModule_ProvideBitmapFileProviderFactory.create(photoPickerModule, this.k, this.i, jVar));
        Provider<ThumbnailProvider> provider10 = DoubleCheck.provider(PhotoPickerModule_ProvideThumbnailProviderFactory.create(photoPickerModule, this.k));
        this.P = provider10;
        i iVar = new i(photoPickerDependencies);
        this.Q = iVar;
        f fVar = new f(photoPickerDependencies);
        this.R = fVar;
        h hVar = new h(photoPickerDependencies);
        this.S = hVar;
        this.T = DoubleCheck.provider(PhotoPickerModule_ProvidePhotoPickerInteractor$photo_picker_releaseFactory.create(photoPickerModule, this.M, this.y, this.O, provider10, iVar, fVar, this.r, this.g, hVar));
        Provider<PhotoPickerPresenterResourceProvider> provider11 = DoubleCheck.provider(PhotoPickerModule_ProvidePhotoPickerPresenterResourceProvider$photo_picker_releaseFactory.create(photoPickerModule));
        this.U = provider11;
        k kVar = new k(photoPickerDependencies);
        this.V = kVar;
        DelegateFactory.setDelegate(this.p, DoubleCheck.provider(PhotoPickerModule_ProvidePhotoPickerPresenter$photo_picker_releaseFactory.create(photoPickerModule, this.G, this.K, this.T, this.z, this.n, this.r, this.i, provider11, this.R, kVar, this.Q)));
        this.W = DoubleCheck.provider(PhotoPickerModule_ProvidePhotoDragAndDrop$photo_picker_releaseFactory.create(photoPickerModule));
        this.X = DoubleCheck.provider(PhotoPickerModule_ProvideGalleryResultsExtractor$photo_picker_releaseFactory.create(photoPickerModule));
        Factory create5 = InstanceFactory.create(num);
        this.Y = create5;
        this.Z = DoubleCheck.provider(PhotoPickerViewModelFactory_Factory.create(this.T, this.r, this.Q, this.R, this.V, this.A, create5));
        Provider<ResponsiveAdapterPresenter> provider12 = DoubleCheck.provider(PhotoPickerModule_ProvidesResponsiveAdapterPresenter$photo_picker_releaseFactory.create(photoPickerModule, this.G, this.w));
        this.a0 = provider12;
        this.b0 = DoubleCheck.provider(PhotoPickerModule_ProvideDetailsRecyclerAdapter$photo_picker_releaseFactory.create(photoPickerModule, provider12, this.F));
        this.c0 = DoubleCheck.provider(PhotoPickerModule_ProvideThumbnailsRecyclerAdapter$photo_picker_releaseFactory.create(photoPickerModule, this.K, this.J));
    }

    public static PhotoPickerComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.photo_picker.camera.di.CameraDependencies
    public AbTestsConfigProvider abTestConfigProvider() {
        return (AbTestsConfigProvider) Preconditions.checkNotNullFromComponent(this.a.abTestConfigProvider());
    }

    @Override // com.avito.android.photo_picker.gallery.di.GalleryPickerDependencies, com.avito.android.photo_picker.camera.di.CameraDependencies
    public Analytics analytics() {
        return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
    }

    @Override // com.avito.android.photo_picker.edit.di.EditPhotoDependencies
    public Context context() {
        return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
    }

    @Override // com.avito.android.photo_picker.camera.di.CameraDependencies
    public ExifExtraDataSerializer exifExtraDataSerializer() {
        return this.g.get();
    }

    @Override // com.avito.android.photo_picker.gallery.di.GalleryPickerDependencies, com.avito.android.photo_picker.camera.di.CameraDependencies, com.avito.android.photo_picker.edit.di.EditPhotoDependencies
    public Features features() {
        return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
    }

    @Override // com.avito.android.photo_picker.edit.di.EditPhotoDependencies
    public Gson gson() {
        return this.b;
    }

    @Override // com.avito.android.photo_picker.legacy.di.PhotoPickerComponent
    public void inject(PhotoPickerActivity photoPickerActivity) {
        PhotoPickerActivity_MembersInjector.injectIntentFactory(photoPickerActivity, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
        PhotoPickerActivity_MembersInjector.injectPresenter(photoPickerActivity, this.p.get());
        PhotoPickerActivity_MembersInjector.injectPhotoDragAndDrop(photoPickerActivity, this.W.get());
        PhotoPickerActivity_MembersInjector.injectInteractor(photoPickerActivity, this.T.get());
        PhotoPickerActivity_MembersInjector.injectCameraPresenter(photoPickerActivity, this.z.get());
        PhotoPickerActivity_MembersInjector.injectRotationInteractor(photoPickerActivity, this.n.get());
        PhotoPickerActivity_MembersInjector.injectDisplayAnalyzer(photoPickerActivity, PhotoPickerModule_ProvideDisplayAnalyzer$photo_picker_releaseFactory.provideDisplayAnalyzer$photo_picker_release(this.c, (DeviceMetrics) Preconditions.checkNotNullFromComponent(this.a.deviceMetrics())));
        PhotoPickerActivity_MembersInjector.injectGalleryResultsExtractor(photoPickerActivity, this.X.get());
        PhotoPickerActivity_MembersInjector.injectViewModelFactory(photoPickerActivity, this.Z.get());
        PhotoPickerActivity_MembersInjector.injectCameraAdapter(photoPickerActivity, this.b0.get());
        PhotoPickerActivity_MembersInjector.injectThumbnailsAdapter(photoPickerActivity, this.c0.get());
        PhotoPickerActivity_MembersInjector.injectAnalytics(photoPickerActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
    }

    @Override // com.avito.android.photo_picker.camera.di.CameraDependencies
    public PermissionHelper permissionHelper() {
        return this.d.get();
    }

    @Override // com.avito.android.photo_picker.edit.di.EditPhotoDependencies
    public PhotoPickerEventTracker photoPickerEventTracker() {
        return (PhotoPickerEventTracker) Preconditions.checkNotNullFromComponent(this.a.photoPickerEventTracker());
    }

    @Override // com.avito.android.photo_picker.edit.di.EditPhotoDependencies
    public PrivatePhotosStorage privatePhotoStorage() {
        return (PrivatePhotosStorage) Preconditions.checkNotNullFromComponent(this.a.privatePhotosStorage());
    }

    @Override // com.avito.android.photo_picker.camera.di.CameraDependencies
    public PrivatePhotosStorage privatePhotosStorage() {
        return (PrivatePhotosStorage) Preconditions.checkNotNullFromComponent(this.a.privatePhotosStorage());
    }

    @Override // com.avito.android.photo_picker.gallery.di.GalleryPickerDependencies, com.avito.android.photo_picker.camera.di.CameraDependencies
    public SchedulersFactory schedulersFactory() {
        return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
    }

    @Override // com.avito.android.photo_picker.edit.di.EditPhotoDependencies
    public SchedulersFactory3 schedulersFactory3() {
        return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
    }

    @Override // com.avito.android.photo_picker.edit.di.EditPhotoDependencies
    public SharedPhotosStorage sharedPhotoStorage() {
        return (SharedPhotosStorage) Preconditions.checkNotNullFromComponent(this.a.sharedPhotosStorage());
    }

    @Override // com.avito.android.photo_picker.camera.di.CameraDependencies
    public SharedPhotosStorage sharedPhotosStorage() {
        return (SharedPhotosStorage) Preconditions.checkNotNullFromComponent(this.a.sharedPhotosStorage());
    }
}
