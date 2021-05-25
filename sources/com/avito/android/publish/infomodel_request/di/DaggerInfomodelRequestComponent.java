package com.avito.android.publish.infomodel_request.di;

import android.content.Context;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.UnknownScreenTracker;
import com.avito.android.analytics.screens.tracker.UnknownScreenTracker_Impl_Factory;
import com.avito.android.photo_picker.legacy.api.UploadConverter;
import com.avito.android.progress_overlay.LoadingProgressOverlay;
import com.avito.android.progress_overlay.LoadingProgressOverlayImpl;
import com.avito.android.progress_overlay.LoadingProgressOverlayImpl_Factory;
import com.avito.android.progress_overlay.ProgressDialogRouter;
import com.avito.android.publish.PublishParametersInteractor;
import com.avito.android.publish.di.GsonModule;
import com.avito.android.publish.di.GsonModule_ProvideGsonFactory;
import com.avito.android.publish.di.GsonModule_ProvideTypeAdapterFactoryFactory;
import com.avito.android.publish.di.PublishComponent;
import com.avito.android.publish.di.PublishParametersModule;
import com.avito.android.publish.di.PublishParametersModule_ProvidePublishParametersInteractorFactory;
import com.avito.android.publish.di.PublishParametersModule_ProvideUploadConverterFactory;
import com.avito.android.publish.drafts.PublishDraftRepository;
import com.avito.android.publish.drafts.PublishDraftWiper;
import com.avito.android.publish.drafts.analytics.PublishDraftEventTracker;
import com.avito.android.publish.drafts.analytics.PublishSessionIdGenerator;
import com.avito.android.publish.infomodel_request.InfomodelRequestFragment;
import com.avito.android.publish.infomodel_request.InfomodelRequestFragment_MembersInjector;
import com.avito.android.publish.infomodel_request.InfomodelRequestViewModelFactory;
import com.avito.android.publish.infomodel_request.InfomodelRequestViewModelFactoryImpl;
import com.avito.android.publish.infomodel_request.InfomodelRequestViewModelFactoryImpl_Factory;
import com.avito.android.publish.infomodel_request.di.InfomodelRequestComponent;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.model.category_parameters.AttributesTreeConverter;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.util.SchedulersFactory;
import com.google.gson.Gson;
import com.google.gson.TypeAdapterFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerInfomodelRequestComponent implements InfomodelRequestComponent {
    public Provider<PublishApi> a;
    public Provider<PublishAnalyticsDataProvider> b;
    public Provider<PublishDraftRepository> c;
    public Provider<Context> d;
    public Provider<Analytics> e;
    public Provider<UploadConverter> f;
    public Provider<CategoryParametersConverter> g;
    public Provider<AttributesTreeConverter> h;
    public Provider<PublishDraftWiper> i;
    public Provider<Features> j;
    public Provider<PublishParametersInteractor> k;
    public Provider<TypeAdapterFactory> l;
    public Provider<Gson> m;
    public Provider<SchedulersFactory> n;
    public Provider<PublishDraftEventTracker> o;
    public Provider<PublishSessionIdGenerator> p;
    public Provider<TimerFactory> q;
    public Provider<UnknownScreenTracker.Impl> r;
    public Provider<UnknownScreenTracker> s;
    public Provider<InfomodelRequestViewModelFactoryImpl> t;
    public Provider<InfomodelRequestViewModelFactory> u;
    public Provider<ProgressDialogRouter> v;
    public Provider<LoadingProgressOverlayImpl> w;
    public Provider<LoadingProgressOverlay> x;

    public static final class b implements InfomodelRequestComponent.Builder {
        public PublishComponent a;

        public b(a aVar) {
        }

        @Override // com.avito.android.publish.infomodel_request.di.InfomodelRequestComponent.Builder
        public InfomodelRequestComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PublishComponent.class);
            return new DaggerInfomodelRequestComponent(new PublishParametersModule(), new GsonModule(), this.a, null);
        }

        @Override // com.avito.android.publish.infomodel_request.di.InfomodelRequestComponent.Builder
        public InfomodelRequestComponent.Builder publishComponent(PublishComponent publishComponent) {
            this.a = (PublishComponent) Preconditions.checkNotNull(publishComponent);
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

    public static class d implements Provider<AttributesTreeConverter> {
        public final PublishComponent a;

        public d(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AttributesTreeConverter get() {
            return (AttributesTreeConverter) Preconditions.checkNotNullFromComponent(this.a.attributesConverter());
        }
    }

    public static class e implements Provider<CategoryParametersConverter> {
        public final PublishComponent a;

        public e(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CategoryParametersConverter get() {
            return (CategoryParametersConverter) Preconditions.checkNotNullFromComponent(this.a.categoryParametersConverter());
        }
    }

    public static class f implements Provider<Context> {
        public final PublishComponent a;

        public f(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public static class g implements Provider<PublishDraftEventTracker> {
        public final PublishComponent a;

        public g(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishDraftEventTracker get() {
            return (PublishDraftEventTracker) Preconditions.checkNotNullFromComponent(this.a.draftEventTracker());
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

    public static class i implements Provider<ProgressDialogRouter> {
        public final PublishComponent a;

        public i(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProgressDialogRouter get() {
            return (ProgressDialogRouter) Preconditions.checkNotNullFromComponent(this.a.progressDialogRouter());
        }
    }

    public static class j implements Provider<PublishAnalyticsDataProvider> {
        public final PublishComponent a;

        public j(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishAnalyticsDataProvider get() {
            return (PublishAnalyticsDataProvider) Preconditions.checkNotNullFromComponent(this.a.publishAnalyticsDataProvider());
        }
    }

    public static class k implements Provider<PublishApi> {
        public final PublishComponent a;

        public k(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishApi get() {
            return (PublishApi) Preconditions.checkNotNullFromComponent(this.a.publishApi());
        }
    }

    public static class l implements Provider<PublishDraftRepository> {
        public final PublishComponent a;

        public l(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishDraftRepository get() {
            return (PublishDraftRepository) Preconditions.checkNotNullFromComponent(this.a.publishDraftRepository());
        }
    }

    public static class m implements Provider<PublishDraftWiper> {
        public final PublishComponent a;

        public m(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishDraftWiper get() {
            return (PublishDraftWiper) Preconditions.checkNotNullFromComponent(this.a.publishDraftWiper());
        }
    }

    public static class n implements Provider<PublishSessionIdGenerator> {
        public final PublishComponent a;

        public n(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishSessionIdGenerator get() {
            return (PublishSessionIdGenerator) Preconditions.checkNotNullFromComponent(this.a.publishSessionIdGenerator());
        }
    }

    public static class o implements Provider<SchedulersFactory> {
        public final PublishComponent a;

        public o(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class p implements Provider<TimerFactory> {
        public final PublishComponent a;

        public p(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimerFactory get() {
            return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
        }
    }

    public DaggerInfomodelRequestComponent(PublishParametersModule publishParametersModule, GsonModule gsonModule, PublishComponent publishComponent, a aVar) {
        this.a = new k(publishComponent);
        this.b = new j(publishComponent);
        this.c = new l(publishComponent);
        f fVar = new f(publishComponent);
        this.d = fVar;
        c cVar = new c(publishComponent);
        this.e = cVar;
        Provider<UploadConverter> provider = SingleCheck.provider(PublishParametersModule_ProvideUploadConverterFactory.create(publishParametersModule, fVar, cVar));
        this.f = provider;
        e eVar = new e(publishComponent);
        this.g = eVar;
        d dVar = new d(publishComponent);
        this.h = dVar;
        m mVar = new m(publishComponent);
        this.i = mVar;
        h hVar = new h(publishComponent);
        this.j = hVar;
        this.k = SingleCheck.provider(PublishParametersModule_ProvidePublishParametersInteractorFactory.create(publishParametersModule, this.a, this.b, this.c, provider, eVar, dVar, mVar, hVar));
        GsonModule_ProvideTypeAdapterFactoryFactory create = GsonModule_ProvideTypeAdapterFactoryFactory.create(gsonModule);
        this.l = create;
        this.m = GsonModule_ProvideGsonFactory.create(gsonModule, create);
        this.n = new o(publishComponent);
        this.o = new g(publishComponent);
        this.p = new n(publishComponent);
        p pVar = new p(publishComponent);
        this.q = pVar;
        UnknownScreenTracker_Impl_Factory create2 = UnknownScreenTracker_Impl_Factory.create(pVar);
        this.r = create2;
        Provider<UnknownScreenTracker> provider2 = DoubleCheck.provider(create2);
        this.s = provider2;
        InfomodelRequestViewModelFactoryImpl_Factory create3 = InfomodelRequestViewModelFactoryImpl_Factory.create(this.k, this.m, this.n, this.o, this.b, this.p, provider2);
        this.t = create3;
        this.u = DoubleCheck.provider(create3);
        i iVar = new i(publishComponent);
        this.v = iVar;
        LoadingProgressOverlayImpl_Factory create4 = LoadingProgressOverlayImpl_Factory.create(this.e, iVar);
        this.w = create4;
        this.x = DoubleCheck.provider(create4);
    }

    public static InfomodelRequestComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.publish.infomodel_request.di.InfomodelRequestComponent
    public void inject(InfomodelRequestFragment infomodelRequestFragment) {
        InfomodelRequestFragment_MembersInjector.injectViewModelFactory(infomodelRequestFragment, this.u.get());
        InfomodelRequestFragment_MembersInjector.injectLoadingProgress(infomodelRequestFragment, this.x.get());
        InfomodelRequestFragment_MembersInjector.injectPerformanceTracker(infomodelRequestFragment, this.s.get());
    }
}
