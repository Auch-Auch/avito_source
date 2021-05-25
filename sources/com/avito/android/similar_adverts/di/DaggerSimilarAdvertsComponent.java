package com.avito.android.similar_adverts.di;

import android.app.Activity;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.configs.PriceOnTopTestGroup;
import com.avito.android.ab_tests.configs.SerpItemsPrefetchTestGroup;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert.viewed.ViewedAdvertsEventInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsInteractorFactoryImpl_Factory;
import com.avito.android.advert_details.remote.AdvertDetailsApi;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.FavoriteAdvertsAnalyticsInteractorImpl;
import com.avito.android.analytics.FavoriteAdvertsAnalyticsInteractorImpl_Factory;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.db.favorites.FavoritesSyncDao;
import com.avito.android.db.viewed.ViewedAdvertsDao;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.ViewedAdvertsModule_ProvideViewedAdvertsInteractorFactory;
import com.avito.android.di.ViewedAdvertsModule_ProvideViewedStatusResolverFactory;
import com.avito.android.di.module.AbTestGroupModule;
import com.avito.android.di.module.AbTestGroupModule_ProvideOnTopTestGroupFactory;
import com.avito.android.di.module.AbTestGroupModule_ProvideSerpItemsPrefetchTestGroupFactory;
import com.avito.android.di.module.AdvertItemPresenterModule_ProvideRdsAdvertItemPresenterFactory;
import com.avito.android.di.module.FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsPresenter$favorite_core_releaseFactory;
import com.avito.android.di.module.FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsResourceProvider$favorite_core_releaseFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideAdvertConverterFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideBigAdvertSpanCountProviderFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideFavoriteStatusResolverFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideItemAdvertSpanCountProviderFactory;
import com.avito.android.di.module.SpanAdapterModule_ProvideSerpSpanProviderFactory;
import com.avito.android.di.module.SpanAdapterModule_ProvideSpannedGridPositionProviderFactory;
import com.avito.android.favorite.FavoriteAdvertsEventInteractor;
import com.avito.android.favorite.FavoriteAdvertsInteractorImpl;
import com.avito.android.favorite.FavoriteAdvertsInteractorImpl_Factory;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsResourceProvider;
import com.avito.android.favorite.FavoriteAdvertsUploadInteractor;
import com.avito.android.favorite_sellers.SellerCarouselItemConverter;
import com.avito.android.favorite_sellers.SellerCarouselItemConverterImpl_Factory;
import com.avito.android.rec.ScreenSource;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.section.SectionInsideItemsConverter;
import com.avito.android.section.SectionInsideItemsConverterImpl;
import com.avito.android.section.SectionInsideItemsConverterImpl_Factory;
import com.avito.android.section.SectionItemConverter;
import com.avito.android.section.SectionItemConverterImpl;
import com.avito.android.section.SectionItemConverterImpl_Factory;
import com.avito.android.section.action.SectionActionPresenter;
import com.avito.android.section.action.SectionActionPresenterImpl_Factory;
import com.avito.android.section.title.SectionTitleItemPresenter;
import com.avito.android.section.title.SectionTitleItemPresenterImpl_Factory;
import com.avito.android.section.title_with_action.SectionTitleWithActionPresenter;
import com.avito.android.section.title_with_action.SectionTitleWithActionPresenterImpl;
import com.avito.android.section.title_with_action.SectionTitleWithActionPresenterImpl_Factory;
import com.avito.android.serp.adapter.AdvertSpanCountProvider;
import com.avito.android.serp.adapter.FavoriteStatusResolver;
import com.avito.android.serp.adapter.RdsAdvertItemPresenter;
import com.avito.android.serp.adapter.SerpAdvertConverter;
import com.avito.android.serp.adapter.SerpItemAbViewConfig;
import com.avito.android.serp.adapter.SerpItemAbViewConfig_Factory;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SpanLookup;
import com.avito.android.serp.adapter.SpanLookup_Factory;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.ViewedStatusResolver;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandler;
import com.avito.android.serp.adapter.skeleton.SkeletonPresenter;
import com.avito.android.serp.adapter.skeleton.SkeletonPresenterImpl_Factory;
import com.avito.android.server_time.TimeSource;
import com.avito.android.similar_adverts.SimilarAdvertsDialog;
import com.avito.android.similar_adverts.SimilarAdvertsDialog_MembersInjector;
import com.avito.android.similar_adverts.SimilarAdvertsInteractor;
import com.avito.android.similar_adverts.SimilarAdvertsInteractorImpl;
import com.avito.android.similar_adverts.SimilarAdvertsInteractorImpl_Factory;
import com.avito.android.similar_adverts.SimilarAdvertsResourceProvider;
import com.avito.android.similar_adverts.SimilarAdvertsResourceProviderImpl;
import com.avito.android.similar_adverts.SimilarAdvertsResourceProviderImpl_Factory;
import com.avito.android.similar_adverts.SimilarAdvertsViewModel;
import com.avito.android.similar_adverts.SimilarAdvertsViewModelImplFactory;
import com.avito.android.similar_adverts.SimilarAdvertsViewModelImplFactory_Factory;
import com.avito.android.similar_adverts.adapter.SimilarAdvertBlueprint;
import com.avito.android.similar_adverts.adapter.SimilarAdvertBlueprintImpl;
import com.avito.android.similar_adverts.adapter.SimilarAdvertBlueprintImpl_Factory;
import com.avito.android.similar_adverts.adapter.SimilarSkeletonAdvertBlueprint;
import com.avito.android.similar_adverts.adapter.SimilarSkeletonAdvertBlueprint_Factory;
import com.avito.android.similar_adverts.adapter.SimilarTitleWithActionBlueprint;
import com.avito.android.similar_adverts.adapter.SimilarTitleWithActionBlueprint_Factory;
import com.avito.android.similar_adverts.adapter.skeleton_title.SimilarSkeletonTitleBlueprint;
import com.avito.android.similar_adverts.adapter.skeleton_title.SimilarSkeletonTitleBlueprint_Factory;
import com.avito.android.similar_adverts.adapter.skeleton_title.SimilarSkeletonTitlePresenter;
import com.avito.android.similar_adverts.adapter.skeleton_title.SimilarSkeletonTitlePresenterImpl_Factory;
import com.avito.android.similar_adverts.di.SimilarAdvertsComponent;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.Locale;
import javax.inject.Provider;
public final class DaggerSimilarAdvertsComponent implements SimilarAdvertsComponent {
    public Provider<ViewedAdvertsEventInteractor> A;
    public Provider<ViewedAdvertsInteractor> B;
    public Provider<ViewedStatusResolver> C;
    public Provider<SectionItemConverterImpl> D;
    public Provider<SectionItemConverter> E;
    public Provider<ActivityIntentFactory> F;
    public Provider<FavoriteAdvertsResourceProvider> G;
    public Provider<FavoriteAdvertsPresenter> H;
    public Provider<SimilarAdvertsResourceProviderImpl> I;
    public Provider<SimilarAdvertsResourceProvider> J;
    public Provider<SimilarAdvertsViewModelImplFactory> K;
    public Provider<SimilarAdvertsViewModel> L;
    public Provider<RdsAdvertItemPresenter> M;
    public Provider<TimeSource> N;
    public Provider<Locale> O;
    public Provider<AbTestsConfigProvider> P;
    public Provider<ExposedAbTestGroup<PriceOnTopTestGroup>> Q;
    public Provider<SerpItemsPrefetchTestGroup> R;
    public Provider<SerpItemAbViewConfig> S;
    public Provider<ConnectivityProvider> T;
    public Provider<SimilarAdvertBlueprintImpl> U;
    public Provider<SimilarAdvertBlueprint> V;
    public Provider<SectionTitleItemPresenter> W;
    public Provider<SectionActionPresenter> X;
    public Provider<SectionTitleWithActionPresenterImpl> Y;
    public Provider<SectionTitleWithActionPresenter> Z;
    public final SimilarAdvertsDependencies a;
    public Provider<SimilarTitleWithActionBlueprint> a0;
    public Provider<Fragment> b;
    public Provider<SkeletonPresenter> b0;
    public Provider<String> c;
    public Provider<SimilarSkeletonAdvertBlueprint> c0;
    public Provider<Boolean> d;
    public Provider<SimilarSkeletonTitlePresenter> d0;
    public Provider<SchedulersFactory3> e;
    public Provider<SimilarSkeletonTitleBlueprint> e0;
    public Provider<AdvertDetailsApi> f;
    public Provider<ItemBinder> f0;
    public Provider<ScreenSource> g;
    public Provider<AdapterPresenter> g0;
    public Provider<SimilarAdvertsInteractorImpl> h;
    public Provider<SimpleRecyclerAdapter> h0;
    public Provider<SimilarAdvertsInteractor> i;
    public Provider<SpannedGridPositionProvider> i0;
    public Provider<Resources> j;
    public Provider<SerpSpanProvider> j0;
    public Provider<AdvertSpanCountProvider> k;
    public Provider<SpanLookup> k0;
    public Provider<AdvertSpanCountProvider> l;
    public Provider<GridLayoutManager.SpanSizeLookup> l0;
    public Provider<Features> m;
    public Provider<DiffCalculator> m0;
    public Provider<SerpAdvertConverter> n;
    public Provider<DataAwareAdapterPresenter> n0;
    public Provider<SectionInsideItemsConverterImpl> o;
    public Provider<SectionInsideItemsConverter> p;
    public Provider<SellerCarouselItemConverter> q = SingleCheck.provider(SellerCarouselItemConverterImpl_Factory.create());
    public Provider<FavoritesSyncDao> r;
    public Provider<FavoriteAdvertsUploadInteractor> s;
    public Provider<FavoriteAdvertsEventInteractor> t;
    public Provider<Analytics> u;
    public Provider<AccountStateProvider> v;
    public Provider<FavoriteAdvertsAnalyticsInteractorImpl> w;
    public Provider<FavoriteAdvertsInteractorImpl> x;
    public Provider<FavoriteStatusResolver> y;
    public Provider<ViewedAdvertsDao> z;

    public static final class b implements SimilarAdvertsComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.similar_adverts.di.SimilarAdvertsComponent.Factory
        public SimilarAdvertsComponent create(Activity activity, Resources resources, Fragment fragment, String str, SerpOnboardingHandler serpOnboardingHandler, ScreenSource screenSource, boolean z, SimilarAdvertsDependencies similarAdvertsDependencies) {
            Preconditions.checkNotNull(activity);
            Preconditions.checkNotNull(resources);
            Preconditions.checkNotNull(fragment);
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(screenSource);
            Preconditions.checkNotNull(Boolean.valueOf(z));
            Preconditions.checkNotNull(similarAdvertsDependencies);
            return new DaggerSimilarAdvertsComponent(new AbTestGroupModule(), similarAdvertsDependencies, activity, resources, fragment, str, null, screenSource, Boolean.valueOf(z), null);
        }
    }

    public static class c implements Provider<AbTestsConfigProvider> {
        public final SimilarAdvertsDependencies a;

        public c(SimilarAdvertsDependencies similarAdvertsDependencies) {
            this.a = similarAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AbTestsConfigProvider get() {
            return (AbTestsConfigProvider) Preconditions.checkNotNullFromComponent(this.a.abTestConfigProvider());
        }
    }

    public static class d implements Provider<AccountStateProvider> {
        public final SimilarAdvertsDependencies a;

        public d(SimilarAdvertsDependencies similarAdvertsDependencies) {
            this.a = similarAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class e implements Provider<ActivityIntentFactory> {
        public final SimilarAdvertsDependencies a;

        public e(SimilarAdvertsDependencies similarAdvertsDependencies) {
            this.a = similarAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ActivityIntentFactory get() {
            return (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory());
        }
    }

    public static class f implements Provider<AdvertDetailsApi> {
        public final SimilarAdvertsDependencies a;

        public f(SimilarAdvertsDependencies similarAdvertsDependencies) {
            this.a = similarAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AdvertDetailsApi get() {
            return (AdvertDetailsApi) Preconditions.checkNotNullFromComponent(this.a.advertDetailsApi());
        }
    }

    public static class g implements Provider<Analytics> {
        public final SimilarAdvertsDependencies a;

        public g(SimilarAdvertsDependencies similarAdvertsDependencies) {
            this.a = similarAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class h implements Provider<ConnectivityProvider> {
        public final SimilarAdvertsDependencies a;

        public h(SimilarAdvertsDependencies similarAdvertsDependencies) {
            this.a = similarAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ConnectivityProvider get() {
            return (ConnectivityProvider) Preconditions.checkNotNullFromComponent(this.a.connectivityProvider());
        }
    }

    public static class i implements Provider<FavoriteAdvertsEventInteractor> {
        public final SimilarAdvertsDependencies a;

        public i(SimilarAdvertsDependencies similarAdvertsDependencies) {
            this.a = similarAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsEventInteractor get() {
            return (FavoriteAdvertsEventInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsEventInteractor());
        }
    }

    public static class j implements Provider<FavoriteAdvertsUploadInteractor> {
        public final SimilarAdvertsDependencies a;

        public j(SimilarAdvertsDependencies similarAdvertsDependencies) {
            this.a = similarAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsUploadInteractor get() {
            return (FavoriteAdvertsUploadInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsUploadInteractor());
        }
    }

    public static class k implements Provider<FavoritesSyncDao> {
        public final SimilarAdvertsDependencies a;

        public k(SimilarAdvertsDependencies similarAdvertsDependencies) {
            this.a = similarAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoritesSyncDao get() {
            return (FavoritesSyncDao) Preconditions.checkNotNullFromComponent(this.a.favoritesSyncDao());
        }
    }

    public static class l implements Provider<Features> {
        public final SimilarAdvertsDependencies a;

        public l(SimilarAdvertsDependencies similarAdvertsDependencies) {
            this.a = similarAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class m implements Provider<Locale> {
        public final SimilarAdvertsDependencies a;

        public m(SimilarAdvertsDependencies similarAdvertsDependencies) {
            this.a = similarAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class n implements Provider<SchedulersFactory3> {
        public final SimilarAdvertsDependencies a;

        public n(SimilarAdvertsDependencies similarAdvertsDependencies) {
            this.a = similarAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class o implements Provider<TimeSource> {
        public final SimilarAdvertsDependencies a;

        public o(SimilarAdvertsDependencies similarAdvertsDependencies) {
            this.a = similarAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public static class p implements Provider<ViewedAdvertsDao> {
        public final SimilarAdvertsDependencies a;

        public p(SimilarAdvertsDependencies similarAdvertsDependencies) {
            this.a = similarAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ViewedAdvertsDao get() {
            return (ViewedAdvertsDao) Preconditions.checkNotNullFromComponent(this.a.viewedAdvertsDao());
        }
    }

    public static class q implements Provider<ViewedAdvertsEventInteractor> {
        public final SimilarAdvertsDependencies a;

        public q(SimilarAdvertsDependencies similarAdvertsDependencies) {
            this.a = similarAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ViewedAdvertsEventInteractor get() {
            return (ViewedAdvertsEventInteractor) Preconditions.checkNotNullFromComponent(this.a.viewedAdvertsEventInteractor());
        }
    }

    public DaggerSimilarAdvertsComponent(AbTestGroupModule abTestGroupModule, SimilarAdvertsDependencies similarAdvertsDependencies, Activity activity, Resources resources, Fragment fragment, String str, SerpOnboardingHandler serpOnboardingHandler, ScreenSource screenSource, Boolean bool, a aVar) {
        this.a = similarAdvertsDependencies;
        this.b = InstanceFactory.create(fragment);
        this.c = InstanceFactory.create(str);
        this.d = InstanceFactory.create(bool);
        this.e = new n(similarAdvertsDependencies);
        this.f = new f(similarAdvertsDependencies);
        Factory create = InstanceFactory.create(screenSource);
        this.g = create;
        SimilarAdvertsInteractorImpl_Factory create2 = SimilarAdvertsInteractorImpl_Factory.create(this.f, this.e, create);
        this.h = create2;
        this.i = DoubleCheck.provider(create2);
        Factory create3 = InstanceFactory.create(resources);
        this.j = create3;
        this.k = SingleCheck.provider(SerpItemConverterModule_ProvideItemAdvertSpanCountProviderFactory.create(create3));
        Provider<AdvertSpanCountProvider> provider = SingleCheck.provider(SerpItemConverterModule_ProvideBigAdvertSpanCountProviderFactory.create(this.j));
        this.l = provider;
        l lVar = new l(similarAdvertsDependencies);
        this.m = lVar;
        Provider<SerpAdvertConverter> provider2 = SingleCheck.provider(SerpItemConverterModule_ProvideAdvertConverterFactory.create(this.k, provider, this.j, lVar));
        this.n = provider2;
        SectionInsideItemsConverterImpl_Factory create4 = SectionInsideItemsConverterImpl_Factory.create(provider2);
        this.o = create4;
        this.p = SingleCheck.provider(create4);
        this.r = new k(similarAdvertsDependencies);
        this.s = new j(similarAdvertsDependencies);
        this.t = new i(similarAdvertsDependencies);
        g gVar = new g(similarAdvertsDependencies);
        this.u = gVar;
        d dVar = new d(similarAdvertsDependencies);
        this.v = dVar;
        FavoriteAdvertsAnalyticsInteractorImpl_Factory create5 = FavoriteAdvertsAnalyticsInteractorImpl_Factory.create(gVar, dVar);
        this.w = create5;
        FavoriteAdvertsInteractorImpl_Factory create6 = FavoriteAdvertsInteractorImpl_Factory.create(this.r, this.s, this.t, create5, this.e);
        this.x = create6;
        this.y = SingleCheck.provider(SerpItemConverterModule_ProvideFavoriteStatusResolverFactory.create(create6));
        this.z = new p(similarAdvertsDependencies);
        this.A = new q(similarAdvertsDependencies);
        Provider<ViewedAdvertsInteractor> provider3 = SingleCheck.provider(ViewedAdvertsModule_ProvideViewedAdvertsInteractorFactory.create(ViewedAdvertsInteractorFactoryImpl_Factory.create(), this.z, this.e, this.A, this.m));
        this.B = provider3;
        Provider<ViewedStatusResolver> provider4 = SingleCheck.provider(ViewedAdvertsModule_ProvideViewedStatusResolverFactory.create(provider3));
        this.C = provider4;
        SectionItemConverterImpl_Factory create7 = SectionItemConverterImpl_Factory.create(this.p, this.q, this.y, provider4, this.e, this.m);
        this.D = create7;
        this.E = SingleCheck.provider(create7);
        this.F = new e(similarAdvertsDependencies);
        Provider<FavoriteAdvertsResourceProvider> provider5 = SingleCheck.provider(FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsResourceProvider$favorite_core_releaseFactory.create(this.j));
        this.G = provider5;
        this.H = SingleCheck.provider(FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsPresenter$favorite_core_releaseFactory.create(this.x, this.e, provider5));
        SimilarAdvertsResourceProviderImpl_Factory create8 = SimilarAdvertsResourceProviderImpl_Factory.create(this.j);
        this.I = create8;
        Provider<SimilarAdvertsResourceProvider> provider6 = DoubleCheck.provider(create8);
        this.J = provider6;
        SimilarAdvertsViewModelImplFactory_Factory create9 = SimilarAdvertsViewModelImplFactory_Factory.create(this.c, this.d, this.e, this.i, this.E, this.F, this.H, provider6, this.g, this.u);
        this.K = create9;
        Provider<SimilarAdvertsViewModel> provider7 = DoubleCheck.provider(SimilarAdvertsModule_ProvideSimilarAdvertsViewModel$similar_adverts_releaseFactory.create(this.b, create9));
        this.L = provider7;
        this.M = SingleCheck.provider(AdvertItemPresenterModule_ProvideRdsAdvertItemPresenterFactory.create(provider7, this.u, this.m));
        this.N = new o(similarAdvertsDependencies);
        this.O = new m(similarAdvertsDependencies);
        c cVar = new c(similarAdvertsDependencies);
        this.P = cVar;
        this.Q = SingleCheck.provider(AbTestGroupModule_ProvideOnTopTestGroupFactory.create(abTestGroupModule, cVar));
        Provider<SerpItemsPrefetchTestGroup> provider8 = SingleCheck.provider(AbTestGroupModule_ProvideSerpItemsPrefetchTestGroupFactory.create(abTestGroupModule, this.P));
        this.R = provider8;
        SerpItemAbViewConfig_Factory create10 = SerpItemAbViewConfig_Factory.create(this.Q, provider8);
        this.S = create10;
        h hVar = new h(similarAdvertsDependencies);
        this.T = hVar;
        SimilarAdvertBlueprintImpl_Factory create11 = SimilarAdvertBlueprintImpl_Factory.create(this.M, this.N, this.O, create10, hVar);
        this.U = create11;
        this.V = DoubleCheck.provider(create11);
        this.W = SingleCheck.provider(SectionTitleItemPresenterImpl_Factory.create());
        Provider<SectionActionPresenter> provider9 = SingleCheck.provider(SectionActionPresenterImpl_Factory.create());
        this.X = provider9;
        SectionTitleWithActionPresenterImpl_Factory create12 = SectionTitleWithActionPresenterImpl_Factory.create(this.W, provider9);
        this.Y = create12;
        Provider<SectionTitleWithActionPresenter> provider10 = SingleCheck.provider(create12);
        this.Z = provider10;
        this.a0 = SimilarTitleWithActionBlueprint_Factory.create(provider10);
        Provider<SkeletonPresenter> provider11 = DoubleCheck.provider(SkeletonPresenterImpl_Factory.create());
        this.b0 = provider11;
        this.c0 = SimilarSkeletonAdvertBlueprint_Factory.create(provider11);
        Provider<SimilarSkeletonTitlePresenter> provider12 = DoubleCheck.provider(SimilarSkeletonTitlePresenterImpl_Factory.create());
        this.d0 = provider12;
        SimilarSkeletonTitleBlueprint_Factory create13 = SimilarSkeletonTitleBlueprint_Factory.create(provider12);
        this.e0 = create13;
        Provider<ItemBinder> provider13 = DoubleCheck.provider(SimilarAdvertsBlueprintsModule_ProvideItemBinder$similar_adverts_releaseFactory.create(this.V, this.a0, this.c0, create13));
        this.f0 = provider13;
        Provider<AdapterPresenter> provider14 = DoubleCheck.provider(SimilarAdvertsBlueprintsModule_ProvideAdapterPresenter$similar_adverts_releaseFactory.create(provider13));
        this.g0 = provider14;
        this.h0 = DoubleCheck.provider(SimilarAdvertsBlueprintsModule_ProvideRecyclerAdapterFactory.create(provider14, this.f0));
        Provider<SpannedGridPositionProvider> provider15 = SingleCheck.provider(SpanAdapterModule_ProvideSpannedGridPositionProviderFactory.create(this.j));
        this.i0 = provider15;
        Provider<SerpSpanProvider> provider16 = SingleCheck.provider(SpanAdapterModule_ProvideSerpSpanProviderFactory.create(provider15, this.j));
        this.j0 = provider16;
        SpanLookup_Factory create14 = SpanLookup_Factory.create(provider16);
        this.k0 = create14;
        this.l0 = SingleCheck.provider(create14);
        Provider<DiffCalculator> provider17 = DoubleCheck.provider(SimilarAdvertsBlueprintsModule_ProvideDiffCalculator$similar_adverts_releaseFactory.create());
        this.m0 = provider17;
        this.n0 = DoubleCheck.provider(SimilarAdvertsBlueprintsModule_ProvideDataAwareAdapterPresenter$similar_adverts_releaseFactory.create(this.h0, this.g0, provider17));
    }

    public static SimilarAdvertsComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.similar_adverts.di.SimilarAdvertsComponent
    public void inject(SimilarAdvertsDialog similarAdvertsDialog) {
        SimilarAdvertsDialog_MembersInjector.injectDeepLinkIntentFactory(similarAdvertsDialog, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        SimilarAdvertsDialog_MembersInjector.injectRecyclerAdapter(similarAdvertsDialog, this.h0.get());
        SimilarAdvertsDialog_MembersInjector.injectSpanSizeLookup(similarAdvertsDialog, this.l0.get());
        SimilarAdvertsDialog_MembersInjector.injectViewModel(similarAdvertsDialog, this.L.get());
        SimilarAdvertsDialog_MembersInjector.injectFavoriteAdvertsPresenter(similarAdvertsDialog, this.H.get());
        SimilarAdvertsDialog_MembersInjector.injectResourceProvider(similarAdvertsDialog, this.J.get());
        SimilarAdvertsDialog_MembersInjector.injectAdapterPresenter(similarAdvertsDialog, this.n0.get());
        SimilarAdvertsDialog_MembersInjector.injectSerpSpanProvider(similarAdvertsDialog, this.j0.get());
        SimilarAdvertsDialog_MembersInjector.injectSectionActionPresenter(similarAdvertsDialog, this.X.get());
    }
}
