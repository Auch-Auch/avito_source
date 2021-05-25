package com.avito.android.publish.publish_advert_request.di;

import android.app.Application;
import android.content.res.Resources;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.computer_vision.ComputerVisionInteractor;
import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.photo_picker.legacy.UploadingProgressInteractor;
import com.avito.android.photo_picker.legacy.service.UploadingInteractor;
import com.avito.android.progress_overlay.LoadingProgressOverlay;
import com.avito.android.progress_overlay.LoadingProgressOverlayModule;
import com.avito.android.progress_overlay.LoadingProgressOverlayModule_ProvideLoadingProgressOverlayFactory;
import com.avito.android.progress_overlay.ProgressDialogRouter;
import com.avito.android.publish.SubmissionPresenter;
import com.avito.android.publish.di.PublishComponent;
import com.avito.android.publish.objects.di.ImageUploadModule;
import com.avito.android.publish.objects.di.ImageUploadModule_ProvidePhotoInteractor$publish_releaseFactory;
import com.avito.android.publish.objects.di.ImageUploadModule_ProvideUploadingInteractor$publish_releaseFactory;
import com.avito.android.publish.objects.di.ImageUploadModule_ProvideUploadingProgressInteractor$publish_releaseFactory;
import com.avito.android.publish.publish_advert_request.PublishAdvertRequestFragment;
import com.avito.android.publish.publish_advert_request.PublishAdvertRequestFragment_MembersInjector;
import com.avito.android.publish.publish_advert_request.PublishAdvertRequestViewModelFactory;
import com.avito.android.publish.publish_advert_request.data.PublishAdvertCloudDataSource;
import com.avito.android.publish.publish_advert_request.data.PublishAdvertCloudDataSource_Factory;
import com.avito.android.publish.publish_advert_request.data.PublishAdvertDataSource;
import com.avito.android.publish.publish_advert_request.data.PublishAdvertRepository;
import com.avito.android.publish.publish_advert_request.di.PublishAdvertRequestComponent;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerPublishAdvertRequestComponent implements PublishAdvertRequestComponent {
    public final PublishComponent a;
    public Provider<PublishApi> b;
    public Provider<PublishAdvertCloudDataSource> c;
    public Provider<PublishAdvertDataSource> d;
    public Provider<PublishAnalyticsDataProvider> e;
    public Provider<CategoryParametersConverter> f;
    public Provider<TypedErrorThrowableConverter> g;
    public Provider<PublishAdvertRepository> h;
    public Provider<Analytics> i;
    public Provider<SchedulersFactory> j;
    public Provider<Application> k;
    public Provider<UploadingInteractor> l;
    public Provider<BuildInfo> m;
    public Provider<ComputerVisionInteractor> n;
    public Provider<PhotoInteractor> o;
    public Provider<UploadingProgressInteractor> p;
    public Provider<PublishAdvertRequestViewModelFactory> q;
    public Provider<ProgressDialogRouter> r;
    public Provider<LoadingProgressOverlay> s;

    public static final class b implements PublishAdvertRequestComponent.Builder {
        public PublishComponent a;
        public PublishAdvertRequestModule b;
        public ImageUploadModule c;
        public Resources d;

        public b(a aVar) {
        }

        @Override // com.avito.android.publish.publish_advert_request.di.PublishAdvertRequestComponent.Builder
        public PublishAdvertRequestComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PublishComponent.class);
            if (this.b == null) {
                this.b = new PublishAdvertRequestModule();
            }
            Preconditions.checkBuilderRequirement(this.c, ImageUploadModule.class);
            Preconditions.checkBuilderRequirement(this.d, Resources.class);
            return new DaggerPublishAdvertRequestComponent(this.b, new LoadingProgressOverlayModule(), this.c, this.a, this.d, null);
        }

        @Override // com.avito.android.publish.publish_advert_request.di.PublishAdvertRequestComponent.Builder
        public PublishAdvertRequestComponent.Builder imageUploadModule(ImageUploadModule imageUploadModule) {
            this.c = (ImageUploadModule) Preconditions.checkNotNull(imageUploadModule);
            return this;
        }

        @Override // com.avito.android.publish.publish_advert_request.di.PublishAdvertRequestComponent.Builder
        public PublishAdvertRequestComponent.Builder publishAdvertRequestModule(PublishAdvertRequestModule publishAdvertRequestModule) {
            this.b = (PublishAdvertRequestModule) Preconditions.checkNotNull(publishAdvertRequestModule);
            return this;
        }

        @Override // com.avito.android.publish.publish_advert_request.di.PublishAdvertRequestComponent.Builder
        public PublishAdvertRequestComponent.Builder publishComponent(PublishComponent publishComponent) {
            this.a = (PublishComponent) Preconditions.checkNotNull(publishComponent);
            return this;
        }

        @Override // com.avito.android.publish.publish_advert_request.di.PublishAdvertRequestComponent.Builder
        public PublishAdvertRequestComponent.Builder resources(Resources resources) {
            this.d = (Resources) Preconditions.checkNotNull(resources);
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

    public static class e implements Provider<BuildInfo> {
        public final PublishComponent a;

        public e(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BuildInfo get() {
            return (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo());
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

    public static class g implements Provider<ComputerVisionInteractor> {
        public final PublishComponent a;

        public g(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ComputerVisionInteractor get() {
            return (ComputerVisionInteractor) Preconditions.checkNotNullFromComponent(this.a.computerVisionInteractor());
        }
    }

    public static class h implements Provider<ProgressDialogRouter> {
        public final PublishComponent a;

        public h(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProgressDialogRouter get() {
            return (ProgressDialogRouter) Preconditions.checkNotNullFromComponent(this.a.progressDialogRouter());
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

    public static class k implements Provider<SchedulersFactory> {
        public final PublishComponent a;

        public k(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class l implements Provider<TypedErrorThrowableConverter> {
        public final PublishComponent a;

        public l(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerPublishAdvertRequestComponent(PublishAdvertRequestModule publishAdvertRequestModule, LoadingProgressOverlayModule loadingProgressOverlayModule, ImageUploadModule imageUploadModule, PublishComponent publishComponent, Resources resources, a aVar) {
        this.a = publishComponent;
        j jVar = new j(publishComponent);
        this.b = jVar;
        PublishAdvertCloudDataSource_Factory create = PublishAdvertCloudDataSource_Factory.create(jVar);
        this.c = create;
        Provider<PublishAdvertDataSource> provider = DoubleCheck.provider(create);
        this.d = provider;
        i iVar = new i(publishComponent);
        this.e = iVar;
        f fVar = new f(publishComponent);
        this.f = fVar;
        l lVar = new l(publishComponent);
        this.g = lVar;
        this.h = DoubleCheck.provider(PublishAdvertRequestModule_ProvidePublishAdvertRepositoryFactory.create(publishAdvertRequestModule, provider, iVar, fVar, lVar));
        this.i = new c(publishComponent);
        this.j = new k(publishComponent);
        d dVar = new d(publishComponent);
        this.k = dVar;
        this.l = DoubleCheck.provider(ImageUploadModule_ProvideUploadingInteractor$publish_releaseFactory.create(imageUploadModule, dVar));
        e eVar = new e(publishComponent);
        this.m = eVar;
        g gVar = new g(publishComponent);
        this.n = gVar;
        Provider<PhotoInteractor> provider2 = DoubleCheck.provider(ImageUploadModule_ProvidePhotoInteractor$publish_releaseFactory.create(imageUploadModule, this.k, eVar, gVar));
        this.o = provider2;
        Provider<UploadingProgressInteractor> provider3 = DoubleCheck.provider(ImageUploadModule_ProvideUploadingProgressInteractor$publish_releaseFactory.create(imageUploadModule, provider2, this.j));
        this.p = provider3;
        this.q = DoubleCheck.provider(PublishAdvertRequestModule_ProvidePublishAdvertRequestViewModelFactoryFactory.create(publishAdvertRequestModule, this.h, this.i, this.j, this.l, provider3));
        h hVar = new h(publishComponent);
        this.r = hVar;
        this.s = DoubleCheck.provider(LoadingProgressOverlayModule_ProvideLoadingProgressOverlayFactory.create(loadingProgressOverlayModule, hVar, this.i));
    }

    public static PublishAdvertRequestComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.publish.publish_advert_request.di.PublishAdvertRequestComponent
    public void inject(PublishAdvertRequestFragment publishAdvertRequestFragment) {
        PublishAdvertRequestFragment_MembersInjector.injectViewModelFactory(publishAdvertRequestFragment, this.q.get());
        PublishAdvertRequestFragment_MembersInjector.injectLoadingProgress(publishAdvertRequestFragment, this.s.get());
        PublishAdvertRequestFragment_MembersInjector.injectSubmissionPresenter(publishAdvertRequestFragment, (SubmissionPresenter) Preconditions.checkNotNullFromComponent(this.a.submissionPresenter()));
    }
}
