package com.avito.android.auto_catalog.di;

import android.content.res.Resources;
import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.ab_tests.configs.PriceOnTopTestGroup;
import com.avito.android.ab_tests.configs.SerpItemsPrefetchTestGroup;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert.viewed.ViewedAdvertsEventInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsInteractorFactoryImpl_Factory;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.advert_core.gap.AdvertDetailsGapBlueprint;
import com.avito.android.advert_core.gap.AdvertDetailsGapBlueprint_Factory;
import com.avito.android.advert_core.gap.AdvertDetailsGapPresenter;
import com.avito.android.advert_core.gap.AdvertDetailsGapPresenterImpl_Factory;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.FavoriteAdvertsAnalyticsInteractorImpl;
import com.avito.android.analytics.FavoriteAdvertsAnalyticsInteractorImpl_Factory;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.auto_catalog.AutoCatalogData;
import com.avito.android.auto_catalog.AutoCatalogFragment;
import com.avito.android.auto_catalog.AutoCatalogFragment_MembersInjector;
import com.avito.android.auto_catalog.AutoCatalogInteractor;
import com.avito.android.auto_catalog.AutoCatalogInteractorImpl;
import com.avito.android.auto_catalog.AutoCatalogInteractorImpl_Factory;
import com.avito.android.auto_catalog.AutoCatalogPresenter;
import com.avito.android.auto_catalog.AutoCatalogPresenterImpl;
import com.avito.android.auto_catalog.AutoCatalogPresenterImpl_Factory;
import com.avito.android.auto_catalog.analytics.AutoCatalogAnalyticsInteractor;
import com.avito.android.auto_catalog.analytics.AutoCatalogAnalyticsInteractorImpl;
import com.avito.android.auto_catalog.analytics.AutoCatalogAnalyticsInteractorImpl_Factory;
import com.avito.android.auto_catalog.di.AutoCatalogComponent;
import com.avito.android.auto_catalog.items.AutoCatalogResourceProvider;
import com.avito.android.auto_catalog.items.AutoCatalogResourceProviderImpl;
import com.avito.android.auto_catalog.items.AutoCatalogResourceProviderImpl_Factory;
import com.avito.android.auto_catalog.items.image.ImageBlueprint;
import com.avito.android.auto_catalog.items.image.ImageBlueprint_Factory;
import com.avito.android.auto_catalog.items.image.ImagePresenter;
import com.avito.android.auto_catalog.items.image.ImagePresenterImpl_Factory;
import com.avito.android.auto_catalog.items.image.SchemeBlueprint;
import com.avito.android.auto_catalog.items.image.SchemeBlueprint_Factory;
import com.avito.android.auto_catalog.items.image.SchemePresenter;
import com.avito.android.auto_catalog.items.image.SchemePresenterImpl_Factory;
import com.avito.android.auto_catalog.items.serp.SerpButtonBlueprint;
import com.avito.android.auto_catalog.items.serp.SerpButtonBlueprint_Factory;
import com.avito.android.auto_catalog.items.serp.SerpButtonPresenter;
import com.avito.android.auto_catalog.items.serp.SerpButtonPresenterImpl;
import com.avito.android.auto_catalog.items.serp.SerpButtonPresenterImpl_Factory;
import com.avito.android.auto_catalog.items.serp.SerpHeaderBlueprint;
import com.avito.android.auto_catalog.items.serp.SerpHeaderBlueprint_Factory;
import com.avito.android.auto_catalog.items.serp.SerpHeaderPresenter;
import com.avito.android.auto_catalog.items.serp.SerpHeaderPresenterImpl_Factory;
import com.avito.android.auto_catalog.items.serp.SerpSecondaryButtonBlueprint;
import com.avito.android.auto_catalog.items.serp.SerpSecondaryButtonBlueprint_Factory;
import com.avito.android.auto_catalog.items.serp.SerpSecondaryButtonPresenter;
import com.avito.android.auto_catalog.items.serp.SerpSecondaryButtonPresenterImpl;
import com.avito.android.auto_catalog.items.serp.SerpSecondaryButtonPresenterImpl_Factory;
import com.avito.android.auto_catalog.items.serp.SerpSecondaryHeaderBlueprint;
import com.avito.android.auto_catalog.items.serp.SerpSecondaryHeaderBlueprint_Factory;
import com.avito.android.auto_catalog.items.serp.SerpSecondaryHeaderPresenter;
import com.avito.android.auto_catalog.items.serp.SerpSecondaryHeaderPresenterImpl_Factory;
import com.avito.android.auto_catalog.items.skeleton.SkeletonBlueprint;
import com.avito.android.auto_catalog.items.skeleton.SkeletonBlueprint_Factory;
import com.avito.android.auto_catalog.items.skeleton.SkeletonPresenter;
import com.avito.android.auto_catalog.items.skeleton.SkeletonPresenterImpl_Factory;
import com.avito.android.auto_catalog.items.specs_selector.SpecsSelectorBlueprint;
import com.avito.android.auto_catalog.items.specs_selector.SpecsSelectorBlueprint_Factory;
import com.avito.android.auto_catalog.items.specs_selector.SpecsSelectorPresenter;
import com.avito.android.auto_catalog.items.specs_selector.SpecsSelectorPresenterImpl;
import com.avito.android.auto_catalog.items.specs_selector.SpecsSelectorPresenterImpl_Factory;
import com.avito.android.auto_catalog.items.title.TitleBlueprint;
import com.avito.android.auto_catalog.items.title.TitleBlueprint_Factory;
import com.avito.android.auto_catalog.items.title.TitlePresenter;
import com.avito.android.auto_catalog.items.title.TitlePresenterImpl_Factory;
import com.avito.android.auto_catalog.remote.AutoCatalogApi;
import com.avito.android.auto_catalog.tracker.AutoCatalogTracker;
import com.avito.android.auto_catalog.tracker.AutoCatalogTrackerImpl;
import com.avito.android.auto_catalog.tracker.AutoCatalogTrackerImpl_Factory;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.db.favorites.FavoritesSyncDao;
import com.avito.android.db.viewed.ViewedAdvertsDao;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.ViewedAdvertsModule_ProvideViewedAdvertsInteractorFactory;
import com.avito.android.di.ViewedAdvertsModule_ProvideViewedAdvertsPresenterFactory;
import com.avito.android.di.ViewedAdvertsModule_ProvideViewedStatusResolverFactory;
import com.avito.android.di.module.AdvertItemModule_ProvideRdsAdvertGridItemBlueprintFactory;
import com.avito.android.di.module.AdvertItemPresenterModule_ProvideRdsAdvertItemPresenterFactory;
import com.avito.android.di.module.FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsPresenter$favorite_core_releaseFactory;
import com.avito.android.di.module.FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsResourceProvider$favorite_core_releaseFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideAdvertConverterFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideAdvertXlConverterFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideBigAdvertSpanCountProviderFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideCommercialConverterFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideElementItemConverterFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideEmptyPlaceholderItemConverterFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideFavoriteStatusResolverFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideGroupTitleItemConverterFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideHeaderElementConverterFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideItemAdvertSpanCountProviderFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideLocationNotificationConverterFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideMapBannerConverterFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvidePromoCardConverterFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideReportBannerConverterFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideSellerElementConverterFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideSerpEmptySearchConverterFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideSerpWarningConverterFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideShortcutBannerConverterFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideSnippetConverterFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideVerticalFilterItemConverterFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideWitcherElementConverterFactory;
import com.avito.android.favorite.FavoriteAdvertsEventInteractor;
import com.avito.android.favorite.FavoriteAdvertsInteractorImpl;
import com.avito.android.favorite.FavoriteAdvertsInteractorImpl_Factory;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsResourceProvider;
import com.avito.android.favorite.FavoriteAdvertsUploadInteractor;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.base.SafeRecyclerAdapter;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.SearchParamsConverterImpl_Factory;
import com.avito.android.serp.ad.AdResourceProvider;
import com.avito.android.serp.ad.AdResourceProviderImpl_Factory;
import com.avito.android.serp.adapter.AdvertSpanCountProvider;
import com.avito.android.serp.adapter.FavoriteStatusResolver;
import com.avito.android.serp.adapter.HeaderElementConverter;
import com.avito.android.serp.adapter.RdsAdvertGridItemBlueprint;
import com.avito.android.serp.adapter.RdsAdvertItemPresenter;
import com.avito.android.serp.adapter.SellerElementConverter;
import com.avito.android.serp.adapter.SerpAdvertConverter;
import com.avito.android.serp.adapter.SerpCommercialBannerConverter;
import com.avito.android.serp.adapter.SerpElementItemConverter;
import com.avito.android.serp.adapter.SerpItemAbViewConfig;
import com.avito.android.serp.adapter.SerpItemAbViewConfig_Factory;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.ShortcutBannerConverter;
import com.avito.android.serp.adapter.SpanLookup;
import com.avito.android.serp.adapter.SpanLookup_Factory;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.ViewedStatusResolver;
import com.avito.android.serp.adapter.advert_xl.SerpAdvertXlConverter;
import com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemConverter;
import com.avito.android.serp.adapter.empty_search.EmptySearchItemConverter;
import com.avito.android.serp.adapter.location_notification.LocationNotificationItemConverter;
import com.avito.android.serp.adapter.map_banner.MapBannerItemConverter;
import com.avito.android.serp.adapter.promo_card.PromoCardConverter;
import com.avito.android.serp.adapter.promo_card.ReportBannerConverter;
import com.avito.android.serp.adapter.snippet.SnippetConverter;
import com.avito.android.serp.adapter.title.GroupTitleItemConverter;
import com.avito.android.serp.adapter.vertical_main.VerticalFilterItemConverter;
import com.avito.android.serp.adapter.warning.SerpWarningConverter;
import com.avito.android.serp.adapter.witcher.WitcherElementConverter;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Locale;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerAutoCatalogComponent implements AutoCatalogComponent {
    public Provider<AccountStateProvider> A;
    public Provider<AdvertDetailsGapPresenter> A0;
    public Provider<FavoriteAdvertsAnalyticsInteractorImpl> B;
    public Provider<AdvertDetailsGapBlueprint> B0;
    public Provider<SchedulersFactory3> C;
    public Provider<ItemBlueprint<?, ?>> C0;
    public Provider<FavoriteAdvertsInteractorImpl> D;
    public Provider<SpecsSelectorPresenterImpl> D0;
    public Provider<FavoriteStatusResolver> E;
    public Provider<SpecsSelectorPresenter> E0;
    public Provider<ViewedAdvertsDao> F;
    public Provider<SpecsSelectorBlueprint> F0;
    public Provider<ViewedAdvertsEventInteractor> G;
    public Provider<ItemBlueprint<?, ?>> G0;
    public Provider<ViewedAdvertsInteractor> H;
    public Provider<SerpHeaderPresenter> H0;
    public Provider<ViewedStatusResolver> I;
    public Provider<SerpHeaderBlueprint> I0;
    public Provider<WitcherElementConverter> J;
    public Provider<ItemBlueprint<?, ?>> J0;
    public Provider<LocationNotificationItemConverter> K;
    public Provider<SerpButtonPresenterImpl> K0;
    public Provider<SellerElementConverter> L;
    public Provider<SerpButtonPresenter> L0;
    public Provider<ReportBannerConverter> M;
    public Provider<SerpButtonBlueprint> M0;
    public Provider<PromoCardConverter> N;
    public Provider<ItemBlueprint<?, ?>> N0;
    public Provider<MapBannerItemConverter> O;
    public Provider<SerpSecondaryButtonPresenterImpl> O0;
    public Provider<VerticalFilterItemConverter> P;
    public Provider<SerpSecondaryButtonPresenter> P0;
    public Provider<SerpElementItemConverter> Q;
    public Provider<SerpSecondaryButtonBlueprint> Q0;
    public Provider<SearchParamsConverter> R;
    public Provider<ItemBlueprint<?, ?>> R0;
    public Provider<SchedulersFactory> S;
    public Provider<SerpSecondaryHeaderPresenter> S0;
    public Provider<TypedErrorThrowableConverter> T;
    public Provider<SerpSecondaryHeaderBlueprint> T0;
    public Provider<AutoCatalogInteractorImpl> U;
    public Provider<ItemBlueprint<?, ?>> U0;
    public Provider<AutoCatalogInteractor> V;
    public Provider<Set<ItemBlueprint<?, ?>>> V0;
    public Provider<String> W;
    public Provider<ItemBinder> W0;
    public Provider<AutoCatalogAnalyticsInteractorImpl> X;
    public Provider<AdapterPresenter> X0;
    public Provider<AutoCatalogAnalyticsInteractor> Y;
    public Provider<DestroyableViewHolderBuilder> Y0;
    public Provider<FavoriteAdvertsResourceProvider> Z;
    public Provider<BuildInfo> Z0;
    public final AutoCatalogDependencies a;
    public Provider<FavoriteAdvertsPresenter> a0;
    public Provider<SafeRecyclerAdapter> a1;
    public Provider<String> b;
    public Provider<AutoCatalogResourceProviderImpl> b0;
    public Provider<SpannedGridPositionProvider> b1;
    public Provider<AutoCatalogData> c;
    public Provider<AutoCatalogResourceProvider> c0;
    public Provider<SerpSpanProvider> c1;
    public Provider<AutoCatalogApi> d;
    public Provider<AutoCatalogPresenterImpl> d0;
    public Provider<SpanLookup> d1;
    public Provider<SearchApi> e;
    public Provider<AutoCatalogPresenter> e0;
    public Provider<GridLayoutManager.SpanSizeLookup> e1;
    public Provider<Resources> f;
    public Provider<ViewedAdvertsPresenter> f0;
    public Provider<ScreenTrackerFactory> f1;
    public Provider<AdvertSpanCountProvider> g;
    public Provider<RdsAdvertItemPresenter> g0;
    public Provider<TimerFactory> g1;
    public Provider<AdvertSpanCountProvider> h;
    public Provider<TimeSource> h0;
    public Provider<AutoCatalogTrackerImpl> h1;
    public Provider<Features> i;
    public Provider<Locale> i0;
    public Provider<AutoCatalogTracker> i1;
    public Provider<SerpAdvertConverter> j;
    public Provider<ExposedAbTestGroup<PriceOnTopTestGroup>> j0;
    public Provider<SerpAdvertXlConverter> k = SingleCheck.provider(SerpItemConverterModule_ProvideAdvertXlConverterFactory.create(this.f, this.i));
    public Provider<SerpItemsPrefetchTestGroup> k0;
    public Provider<AdResourceProvider> l;
    public Provider<SerpItemAbViewConfig> l0;
    public Provider<RandomKeyProvider> m;
    public Provider<ConnectivityProvider> m0;
    public Provider<SerpCommercialBannerConverter> n;
    public Provider<RdsAdvertGridItemBlueprint> n0;
    public Provider<DeepLinkFactory> o;
    public Provider<SkeletonPresenter> o0;
    public Provider<ShortcutBannerConverter> p;
    public Provider<SkeletonBlueprint> p0;
    public Provider<SerpWarningConverter> q;
    public Provider<ItemBlueprint<?, ?>> q0;
    public Provider<SnippetConverter> r;
    public Provider<TitlePresenter> r0;
    public Provider<EmptySearchItemConverter> s;
    public Provider<TitleBlueprint> s0;
    public Provider<GroupTitleItemConverter> t;
    public Provider<ItemBlueprint<?, ?>> t0;
    public Provider<EmptyPlaceholderItemConverter> u;
    public Provider<ImagePresenter> u0;
    public Provider<HeaderElementConverter> v;
    public Provider<ImageBlueprint> v0;
    public Provider<FavoritesSyncDao> w;
    public Provider<ItemBlueprint<?, ?>> w0;
    public Provider<FavoriteAdvertsUploadInteractor> x;
    public Provider<SchemePresenter> x0;
    public Provider<FavoriteAdvertsEventInteractor> y;
    public Provider<SchemeBlueprint> y0;
    public Provider<Analytics> z;
    public Provider<ItemBlueprint<?, ?>> z0;

    public static final class b implements AutoCatalogComponent.Builder {
        public AutoCatalogDependencies a;
        public AutoCatalogData b;
        public String c;
        public String d;
        public Resources e;

        public b(a aVar) {
        }

        @Override // com.avito.android.auto_catalog.di.AutoCatalogComponent.Builder
        public AutoCatalogComponent.Builder autoCatalogDependencies(AutoCatalogDependencies autoCatalogDependencies) {
            this.a = (AutoCatalogDependencies) Preconditions.checkNotNull(autoCatalogDependencies);
            return this;
        }

        @Override // com.avito.android.auto_catalog.di.AutoCatalogComponent.Builder
        public AutoCatalogComponent build() {
            Preconditions.checkBuilderRequirement(this.a, AutoCatalogDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, AutoCatalogData.class);
            Preconditions.checkBuilderRequirement(this.e, Resources.class);
            return new DaggerAutoCatalogComponent(this.a, this.b, this.c, this.d, this.e, null);
        }

        @Override // com.avito.android.auto_catalog.di.AutoCatalogComponent.Builder
        public AutoCatalogComponent.Builder withAutoCatalogData(AutoCatalogData autoCatalogData) {
            this.b = (AutoCatalogData) Preconditions.checkNotNull(autoCatalogData);
            return this;
        }

        @Override // com.avito.android.auto_catalog.di.AutoCatalogComponent.Builder
        public AutoCatalogComponent.Builder withFromScreen(String str) {
            this.d = str;
            return this;
        }

        @Override // com.avito.android.auto_catalog.di.AutoCatalogComponent.Builder
        public AutoCatalogComponent.Builder withResources(Resources resources) {
            this.e = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.auto_catalog.di.AutoCatalogComponent.Builder
        public AutoCatalogComponent.Builder withSearchContext(String str) {
            this.c = str;
            return this;
        }
    }

    public static class c implements Provider<AccountStateProvider> {
        public final AutoCatalogDependencies a;

        public c(AutoCatalogDependencies autoCatalogDependencies) {
            this.a = autoCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class d implements Provider<Analytics> {
        public final AutoCatalogDependencies a;

        public d(AutoCatalogDependencies autoCatalogDependencies) {
            this.a = autoCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class e implements Provider<AutoCatalogApi> {
        public final AutoCatalogDependencies a;

        public e(AutoCatalogDependencies autoCatalogDependencies) {
            this.a = autoCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AutoCatalogApi get() {
            return (AutoCatalogApi) Preconditions.checkNotNullFromComponent(this.a.autoCatalogApi());
        }
    }

    public static class f implements Provider<BuildInfo> {
        public final AutoCatalogDependencies a;

        public f(AutoCatalogDependencies autoCatalogDependencies) {
            this.a = autoCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BuildInfo get() {
            return (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo());
        }
    }

    public static class g implements Provider<ConnectivityProvider> {
        public final AutoCatalogDependencies a;

        public g(AutoCatalogDependencies autoCatalogDependencies) {
            this.a = autoCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ConnectivityProvider get() {
            return (ConnectivityProvider) Preconditions.checkNotNullFromComponent(this.a.connectivityProvider());
        }
    }

    public static class h implements Provider<DeepLinkFactory> {
        public final AutoCatalogDependencies a;

        public h(AutoCatalogDependencies autoCatalogDependencies) {
            this.a = autoCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeepLinkFactory get() {
            return (DeepLinkFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkFactory());
        }
    }

    public static class i implements Provider<FavoriteAdvertsEventInteractor> {
        public final AutoCatalogDependencies a;

        public i(AutoCatalogDependencies autoCatalogDependencies) {
            this.a = autoCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsEventInteractor get() {
            return (FavoriteAdvertsEventInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsEventInteractor());
        }
    }

    public static class j implements Provider<FavoriteAdvertsUploadInteractor> {
        public final AutoCatalogDependencies a;

        public j(AutoCatalogDependencies autoCatalogDependencies) {
            this.a = autoCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsUploadInteractor get() {
            return (FavoriteAdvertsUploadInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsUploadInteractor());
        }
    }

    public static class k implements Provider<FavoritesSyncDao> {
        public final AutoCatalogDependencies a;

        public k(AutoCatalogDependencies autoCatalogDependencies) {
            this.a = autoCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoritesSyncDao get() {
            return (FavoritesSyncDao) Preconditions.checkNotNullFromComponent(this.a.favoritesSyncDao());
        }
    }

    public static class l implements Provider<Features> {
        public final AutoCatalogDependencies a;

        public l(AutoCatalogDependencies autoCatalogDependencies) {
            this.a = autoCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class m implements Provider<Locale> {
        public final AutoCatalogDependencies a;

        public m(AutoCatalogDependencies autoCatalogDependencies) {
            this.a = autoCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class n implements Provider<SerpItemsPrefetchTestGroup> {
        public final AutoCatalogDependencies a;

        public n(AutoCatalogDependencies autoCatalogDependencies) {
            this.a = autoCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SerpItemsPrefetchTestGroup get() {
            return (SerpItemsPrefetchTestGroup) Preconditions.checkNotNullFromComponent(this.a.prefetchTestGroup());
        }
    }

    public static class o implements Provider<ExposedAbTestGroup<PriceOnTopTestGroup>> {
        public final AutoCatalogDependencies a;

        public o(AutoCatalogDependencies autoCatalogDependencies) {
            this.a = autoCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ExposedAbTestGroup<PriceOnTopTestGroup> get() {
            return (ExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.priceOnTop());
        }
    }

    public static class p implements Provider<RandomKeyProvider> {
        public final AutoCatalogDependencies a;

        public p(AutoCatalogDependencies autoCatalogDependencies) {
            this.a = autoCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public RandomKeyProvider get() {
            return (RandomKeyProvider) Preconditions.checkNotNullFromComponent(this.a.randomKeyProvider());
        }
    }

    public static class q implements Provider<SchedulersFactory3> {
        public final AutoCatalogDependencies a;

        public q(AutoCatalogDependencies autoCatalogDependencies) {
            this.a = autoCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class r implements Provider<SchedulersFactory> {
        public final AutoCatalogDependencies a;

        public r(AutoCatalogDependencies autoCatalogDependencies) {
            this.a = autoCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class s implements Provider<ScreenTrackerFactory> {
        public final AutoCatalogDependencies a;

        public s(AutoCatalogDependencies autoCatalogDependencies) {
            this.a = autoCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class t implements Provider<SearchApi> {
        public final AutoCatalogDependencies a;

        public t(AutoCatalogDependencies autoCatalogDependencies) {
            this.a = autoCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SearchApi get() {
            return (SearchApi) Preconditions.checkNotNullFromComponent(this.a.searchApi());
        }
    }

    public static class u implements Provider<TimeSource> {
        public final AutoCatalogDependencies a;

        public u(AutoCatalogDependencies autoCatalogDependencies) {
            this.a = autoCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public static class v implements Provider<TimerFactory> {
        public final AutoCatalogDependencies a;

        public v(AutoCatalogDependencies autoCatalogDependencies) {
            this.a = autoCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimerFactory get() {
            return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
        }
    }

    public static class w implements Provider<TypedErrorThrowableConverter> {
        public final AutoCatalogDependencies a;

        public w(AutoCatalogDependencies autoCatalogDependencies) {
            this.a = autoCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public static class x implements Provider<ViewedAdvertsDao> {
        public final AutoCatalogDependencies a;

        public x(AutoCatalogDependencies autoCatalogDependencies) {
            this.a = autoCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ViewedAdvertsDao get() {
            return (ViewedAdvertsDao) Preconditions.checkNotNullFromComponent(this.a.viewedAdvertsDao());
        }
    }

    public static class y implements Provider<ViewedAdvertsEventInteractor> {
        public final AutoCatalogDependencies a;

        public y(AutoCatalogDependencies autoCatalogDependencies) {
            this.a = autoCatalogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ViewedAdvertsEventInteractor get() {
            return (ViewedAdvertsEventInteractor) Preconditions.checkNotNullFromComponent(this.a.viewedAdvertsEventInteractor());
        }
    }

    public DaggerAutoCatalogComponent(AutoCatalogDependencies autoCatalogDependencies, AutoCatalogData autoCatalogData, String str, String str2, Resources resources, a aVar) {
        this.a = autoCatalogDependencies;
        this.b = InstanceFactory.createNullable(str2);
        this.c = InstanceFactory.create(autoCatalogData);
        this.d = new e(autoCatalogDependencies);
        this.e = new t(autoCatalogDependencies);
        Factory create = InstanceFactory.create(resources);
        this.f = create;
        this.g = SingleCheck.provider(SerpItemConverterModule_ProvideItemAdvertSpanCountProviderFactory.create(create));
        Provider<AdvertSpanCountProvider> provider = SingleCheck.provider(SerpItemConverterModule_ProvideBigAdvertSpanCountProviderFactory.create(this.f));
        this.h = provider;
        l lVar = new l(autoCatalogDependencies);
        this.i = lVar;
        this.j = SingleCheck.provider(SerpItemConverterModule_ProvideAdvertConverterFactory.create(this.g, provider, this.f, lVar));
        Provider<AdResourceProvider> provider2 = DoubleCheck.provider(AdResourceProviderImpl_Factory.create());
        this.l = provider2;
        p pVar = new p(autoCatalogDependencies);
        this.m = pVar;
        this.n = SingleCheck.provider(SerpItemConverterModule_ProvideCommercialConverterFactory.create(this.g, this.h, provider2, pVar));
        h hVar = new h(autoCatalogDependencies);
        this.o = hVar;
        this.p = SingleCheck.provider(SerpItemConverterModule_ProvideShortcutBannerConverterFactory.create(hVar, this.f));
        this.q = SingleCheck.provider(SerpItemConverterModule_ProvideSerpWarningConverterFactory.create());
        this.r = SingleCheck.provider(SerpItemConverterModule_ProvideSnippetConverterFactory.create());
        this.s = SingleCheck.provider(SerpItemConverterModule_ProvideSerpEmptySearchConverterFactory.create());
        this.t = SingleCheck.provider(SerpItemConverterModule_ProvideGroupTitleItemConverterFactory.create());
        this.u = SingleCheck.provider(SerpItemConverterModule_ProvideEmptyPlaceholderItemConverterFactory.create());
        this.v = SingleCheck.provider(SerpItemConverterModule_ProvideHeaderElementConverterFactory.create());
        this.w = new k(autoCatalogDependencies);
        this.x = new j(autoCatalogDependencies);
        this.y = new i(autoCatalogDependencies);
        d dVar = new d(autoCatalogDependencies);
        this.z = dVar;
        c cVar = new c(autoCatalogDependencies);
        this.A = cVar;
        FavoriteAdvertsAnalyticsInteractorImpl_Factory create2 = FavoriteAdvertsAnalyticsInteractorImpl_Factory.create(dVar, cVar);
        this.B = create2;
        q qVar = new q(autoCatalogDependencies);
        this.C = qVar;
        FavoriteAdvertsInteractorImpl_Factory create3 = FavoriteAdvertsInteractorImpl_Factory.create(this.w, this.x, this.y, create2, qVar);
        this.D = create3;
        this.E = SingleCheck.provider(SerpItemConverterModule_ProvideFavoriteStatusResolverFactory.create(create3));
        this.F = new x(autoCatalogDependencies);
        this.G = new y(autoCatalogDependencies);
        Provider<ViewedAdvertsInteractor> provider3 = SingleCheck.provider(ViewedAdvertsModule_ProvideViewedAdvertsInteractorFactory.create(ViewedAdvertsInteractorFactoryImpl_Factory.create(), this.F, this.C, this.G, this.i));
        this.H = provider3;
        Provider<ViewedStatusResolver> provider4 = SingleCheck.provider(ViewedAdvertsModule_ProvideViewedStatusResolverFactory.create(provider3));
        this.I = provider4;
        this.J = SingleCheck.provider(SerpItemConverterModule_ProvideWitcherElementConverterFactory.create(this.j, this.E, provider4));
        this.K = SingleCheck.provider(SerpItemConverterModule_ProvideLocationNotificationConverterFactory.create());
        this.L = SingleCheck.provider(SerpItemConverterModule_ProvideSellerElementConverterFactory.create());
        this.M = SingleCheck.provider(SerpItemConverterModule_ProvideReportBannerConverterFactory.create(this.f, this.i));
        this.N = SingleCheck.provider(SerpItemConverterModule_ProvidePromoCardConverterFactory.create(this.f, this.i));
        this.O = SingleCheck.provider(SerpItemConverterModule_ProvideMapBannerConverterFactory.create());
        Provider<VerticalFilterItemConverter> provider5 = SingleCheck.provider(SerpItemConverterModule_ProvideVerticalFilterItemConverterFactory.create());
        this.P = provider5;
        this.Q = SingleCheck.provider(SerpItemConverterModule_ProvideElementItemConverterFactory.create(this.j, this.k, this.n, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.J, this.K, this.L, this.M, this.N, this.O, provider5));
        Provider<SearchParamsConverter> provider6 = DoubleCheck.provider(SearchParamsConverterImpl_Factory.create());
        this.R = provider6;
        r rVar = new r(autoCatalogDependencies);
        this.S = rVar;
        w wVar = new w(autoCatalogDependencies);
        this.T = wVar;
        AutoCatalogInteractorImpl_Factory create4 = AutoCatalogInteractorImpl_Factory.create(this.b, this.c, this.d, this.e, this.Q, provider6, rVar, wVar);
        this.U = create4;
        this.V = DoubleCheck.provider(create4);
        Factory createNullable = InstanceFactory.createNullable(str);
        this.W = createNullable;
        AutoCatalogAnalyticsInteractorImpl_Factory create5 = AutoCatalogAnalyticsInteractorImpl_Factory.create(this.c, createNullable, this.b, this.z);
        this.X = create5;
        this.Y = DoubleCheck.provider(create5);
        Provider<FavoriteAdvertsResourceProvider> provider7 = SingleCheck.provider(FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsResourceProvider$favorite_core_releaseFactory.create(this.f));
        this.Z = provider7;
        this.a0 = SingleCheck.provider(FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsPresenter$favorite_core_releaseFactory.create(this.D, this.C, provider7));
        AutoCatalogResourceProviderImpl_Factory create6 = AutoCatalogResourceProviderImpl_Factory.create(this.f);
        this.b0 = create6;
        Provider<AutoCatalogResourceProvider> provider8 = DoubleCheck.provider(create6);
        this.c0 = provider8;
        AutoCatalogPresenterImpl_Factory create7 = AutoCatalogPresenterImpl_Factory.create(this.V, this.Y, this.a0, this.S, provider8);
        this.d0 = create7;
        this.e0 = DoubleCheck.provider(create7);
        this.f0 = SingleCheck.provider(ViewedAdvertsModule_ProvideViewedAdvertsPresenterFactory.create(this.G, this.C));
        this.g0 = SingleCheck.provider(AdvertItemPresenterModule_ProvideRdsAdvertItemPresenterFactory.create(this.e0, this.z, this.i));
        this.h0 = new u(autoCatalogDependencies);
        this.i0 = new m(autoCatalogDependencies);
        o oVar = new o(autoCatalogDependencies);
        this.j0 = oVar;
        n nVar = new n(autoCatalogDependencies);
        this.k0 = nVar;
        SerpItemAbViewConfig_Factory create8 = SerpItemAbViewConfig_Factory.create(oVar, nVar);
        this.l0 = create8;
        g gVar = new g(autoCatalogDependencies);
        this.m0 = gVar;
        this.n0 = SingleCheck.provider(AdvertItemModule_ProvideRdsAdvertGridItemBlueprintFactory.create(this.g0, this.h0, this.i0, create8, gVar));
        Provider<SkeletonPresenter> provider9 = DoubleCheck.provider(SkeletonPresenterImpl_Factory.create());
        this.o0 = provider9;
        SkeletonBlueprint_Factory create9 = SkeletonBlueprint_Factory.create(provider9);
        this.p0 = create9;
        this.q0 = DoubleCheck.provider(create9);
        Provider<TitlePresenter> provider10 = DoubleCheck.provider(TitlePresenterImpl_Factory.create());
        this.r0 = provider10;
        TitleBlueprint_Factory create10 = TitleBlueprint_Factory.create(provider10);
        this.s0 = create10;
        this.t0 = DoubleCheck.provider(create10);
        Provider<ImagePresenter> provider11 = DoubleCheck.provider(ImagePresenterImpl_Factory.create());
        this.u0 = provider11;
        ImageBlueprint_Factory create11 = ImageBlueprint_Factory.create(provider11);
        this.v0 = create11;
        this.w0 = DoubleCheck.provider(create11);
        Provider<SchemePresenter> provider12 = DoubleCheck.provider(SchemePresenterImpl_Factory.create());
        this.x0 = provider12;
        SchemeBlueprint_Factory create12 = SchemeBlueprint_Factory.create(provider12);
        this.y0 = create12;
        this.z0 = DoubleCheck.provider(create12);
        Provider<AdvertDetailsGapPresenter> provider13 = DoubleCheck.provider(AdvertDetailsGapPresenterImpl_Factory.create());
        this.A0 = provider13;
        AdvertDetailsGapBlueprint_Factory create13 = AdvertDetailsGapBlueprint_Factory.create(provider13);
        this.B0 = create13;
        this.C0 = DoubleCheck.provider(create13);
        SpecsSelectorPresenterImpl_Factory create14 = SpecsSelectorPresenterImpl_Factory.create(this.e0);
        this.D0 = create14;
        Provider<SpecsSelectorPresenter> provider14 = DoubleCheck.provider(create14);
        this.E0 = provider14;
        SpecsSelectorBlueprint_Factory create15 = SpecsSelectorBlueprint_Factory.create(provider14);
        this.F0 = create15;
        this.G0 = DoubleCheck.provider(create15);
        Provider<SerpHeaderPresenter> provider15 = DoubleCheck.provider(SerpHeaderPresenterImpl_Factory.create());
        this.H0 = provider15;
        SerpHeaderBlueprint_Factory create16 = SerpHeaderBlueprint_Factory.create(provider15);
        this.I0 = create16;
        this.J0 = DoubleCheck.provider(create16);
        SerpButtonPresenterImpl_Factory create17 = SerpButtonPresenterImpl_Factory.create(this.e0);
        this.K0 = create17;
        Provider<SerpButtonPresenter> provider16 = DoubleCheck.provider(create17);
        this.L0 = provider16;
        SerpButtonBlueprint_Factory create18 = SerpButtonBlueprint_Factory.create(provider16);
        this.M0 = create18;
        this.N0 = DoubleCheck.provider(create18);
        SerpSecondaryButtonPresenterImpl_Factory create19 = SerpSecondaryButtonPresenterImpl_Factory.create(this.e0);
        this.O0 = create19;
        Provider<SerpSecondaryButtonPresenter> provider17 = DoubleCheck.provider(create19);
        this.P0 = provider17;
        SerpSecondaryButtonBlueprint_Factory create20 = SerpSecondaryButtonBlueprint_Factory.create(provider17);
        this.Q0 = create20;
        this.R0 = DoubleCheck.provider(create20);
        Provider<SerpSecondaryHeaderPresenter> provider18 = DoubleCheck.provider(SerpSecondaryHeaderPresenterImpl_Factory.create());
        this.S0 = provider18;
        SerpSecondaryHeaderBlueprint_Factory create21 = SerpSecondaryHeaderBlueprint_Factory.create(provider18);
        this.T0 = create21;
        this.U0 = DoubleCheck.provider(create21);
        SetFactory build = SetFactory.builder(10, 0).addProvider(this.q0).addProvider(this.t0).addProvider(this.w0).addProvider(this.z0).addProvider(this.C0).addProvider(this.G0).addProvider(this.J0).addProvider(this.N0).addProvider(this.R0).addProvider(this.U0).build();
        this.V0 = build;
        Provider<ItemBinder> provider19 = DoubleCheck.provider(AutoCatalogModule_ProvideItemBinderFactory.create(this.n0, build));
        this.W0 = provider19;
        this.X0 = DoubleCheck.provider(AutoCatalogModule_ProvideAdapterPresenter$auto_catalog_releaseFactory.create(provider19));
        Provider<DestroyableViewHolderBuilder> provider20 = DoubleCheck.provider(AutoCatalogModule_ProvideDestroyableViewHolderBuilder$auto_catalog_releaseFactory.create(this.W0));
        this.Y0 = provider20;
        f fVar = new f(autoCatalogDependencies);
        this.Z0 = fVar;
        this.a1 = DoubleCheck.provider(AutoCatalogModule_ProvideSafeRecyclerAdapter$auto_catalog_releaseFactory.create(this.X0, provider20, fVar, this.z));
        Provider<SpannedGridPositionProvider> provider21 = DoubleCheck.provider(AutoCatalogModule_ProvideGridPositionProvider$auto_catalog_releaseFactory.create(this.c0));
        this.b1 = provider21;
        Provider<SerpSpanProvider> provider22 = DoubleCheck.provider(AutoCatalogModule_ProvideSpanProvider$auto_catalog_releaseFactory.create(provider21, this.c0));
        this.c1 = provider22;
        SpanLookup_Factory create22 = SpanLookup_Factory.create(provider22);
        this.d1 = create22;
        this.e1 = DoubleCheck.provider(create22);
        s sVar = new s(autoCatalogDependencies);
        this.f1 = sVar;
        v vVar = new v(autoCatalogDependencies);
        this.g1 = vVar;
        AutoCatalogTrackerImpl_Factory create23 = AutoCatalogTrackerImpl_Factory.create(sVar, vVar);
        this.h1 = create23;
        this.i1 = DoubleCheck.provider(create23);
    }

    public static AutoCatalogComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.auto_catalog.di.AutoCatalogComponent
    public void inject(AutoCatalogFragment autoCatalogFragment) {
        AutoCatalogFragment_MembersInjector.injectDeepLinkIntentFactory(autoCatalogFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        AutoCatalogFragment_MembersInjector.injectImplicitIntentFactory(autoCatalogFragment, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
        AutoCatalogFragment_MembersInjector.injectActivityIntentFactory(autoCatalogFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        AutoCatalogFragment_MembersInjector.injectFeatures(autoCatalogFragment, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        AutoCatalogFragment_MembersInjector.injectPresenter(autoCatalogFragment, this.e0.get());
        AutoCatalogFragment_MembersInjector.injectFavoriteAdvertsPresenter(autoCatalogFragment, this.a0.get());
        AutoCatalogFragment_MembersInjector.injectViewedAdvertsPresenter(autoCatalogFragment, this.f0.get());
        AutoCatalogFragment_MembersInjector.injectAdapterPresenter(autoCatalogFragment, this.X0.get());
        AutoCatalogFragment_MembersInjector.injectRecyclerAdapter(autoCatalogFragment, this.a1.get());
        AutoCatalogFragment_MembersInjector.injectDestroyableViewHolderBuilder(autoCatalogFragment, this.Y0.get());
        AutoCatalogFragment_MembersInjector.injectResourceProvider(autoCatalogFragment, this.c0.get());
        AutoCatalogFragment_MembersInjector.injectGridPositionProvider(autoCatalogFragment, this.b1.get());
        AutoCatalogFragment_MembersInjector.injectSpanSizeLookup(autoCatalogFragment, this.e1.get());
        AutoCatalogFragment_MembersInjector.injectSpanProvider(autoCatalogFragment, this.c1.get());
        AutoCatalogFragment_MembersInjector.injectDeviceMetrics(autoCatalogFragment, (DeviceMetrics) Preconditions.checkNotNullFromComponent(this.a.deviceMetrics()));
        AutoCatalogFragment_MembersInjector.injectTracker(autoCatalogFragment, this.i1.get());
    }
}
