package com.avito.android.public_profile.di;

import android.content.res.Resources;
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
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.FavoriteAdvertsAnalyticsInteractorImpl;
import com.avito.android.analytics.FavoriteAdvertsAnalyticsInteractorImpl_Factory;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.db.favorites.FavoritesSyncDao;
import com.avito.android.db.viewed.ViewedAdvertsDao;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.ViewedAdvertsModule_ProvideViewedAdvertsInteractorFactory;
import com.avito.android.di.ViewedAdvertsModule_ProvideViewedAdvertsPresenterFactory;
import com.avito.android.di.ViewedAdvertsModule_ProvideViewedStatusResolverFactory;
import com.avito.android.di.module.AdvertItemModule_ProvideAdvertItemDoubleBlueprintFactory;
import com.avito.android.di.module.AdvertItemModule_ProvideAdvertItemGridBlueprintFactory;
import com.avito.android.di.module.AdvertItemModule_ProvideAdvertItemListBlueprintFactory;
import com.avito.android.di.module.AdvertItemPresenterModule_ProvideAdvertGridItemPresenterFactory;
import com.avito.android.di.module.AdvertItemPresenterModule_ProvideAdvertListItemPresenterFactory;
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
import com.avito.android.di.module.SerpItemConverterModule_ProvideItemSizeAdjusterFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideLocationNotificationConverterFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideMapBannerConverterFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvidePromoCardConverterFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideReportBannerConverterFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideSellerElementConverterFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideSerpEmptySearchConverterFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideSerpItemProcessorFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideSerpItemSorterFactory;
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
import com.avito.android.public_profile.ProfileAdvertsFragment;
import com.avito.android.public_profile.ProfileAdvertsFragment_MembersInjector;
import com.avito.android.public_profile.ProfileAdvertsInteractor;
import com.avito.android.public_profile.ProfileAdvertsPresenter;
import com.avito.android.public_profile.ProfileAdvertsResourceProvider;
import com.avito.android.public_profile.adapter.error_snippet.ErrorSnippetItem;
import com.avito.android.public_profile.adapter.error_snippet.ErrorSnippetItemBlueprint;
import com.avito.android.public_profile.adapter.error_snippet.ErrorSnippetItemPresenter;
import com.avito.android.public_profile.adapter.error_snippet.di.ErrorSnippetItemModule;
import com.avito.android.public_profile.adapter.error_snippet.di.ErrorSnippetItemModule_ProvideBlueprint$public_profile_releaseFactory;
import com.avito.android.public_profile.adapter.error_snippet.di.ErrorSnippetItemModule_ProvideItemClicksStream$public_profile_releaseFactory;
import com.avito.android.public_profile.adapter.error_snippet.di.ErrorSnippetItemModule_ProvidePresenter$public_profile_releaseFactory;
import com.avito.android.public_profile.adapter.loading_item.PageLoadingItemBlueprint;
import com.avito.android.public_profile.adapter.loading_item.PageLoadingItemPresenter;
import com.avito.android.public_profile.adapter.loading_item.di.PageLoadingItemModule;
import com.avito.android.public_profile.adapter.loading_item.di.PageLoadingItemModule_ProvideBlueprint$public_profile_releaseFactory;
import com.avito.android.public_profile.adapter.loading_item.di.PageLoadingItemModule_ProvidePresenter$public_profile_releaseFactory;
import com.avito.android.public_profile.adapter.placeholder.PlaceholderItemBlueprint;
import com.avito.android.public_profile.adapter.placeholder.PlaceholderItemPresenter;
import com.avito.android.public_profile.adapter.placeholder.di.PlaceholderItemModule;
import com.avito.android.public_profile.adapter.placeholder.di.PlaceholderItemModule_ProvideBlueprint$public_profile_releaseFactory;
import com.avito.android.public_profile.adapter.placeholder.di.PlaceholderItemModule_ProvidePresenter$public_profile_releaseFactory;
import com.avito.android.public_profile.di.ProfileAdvertsComponent;
import com.avito.android.public_profile.remote.PublicProfileApi;
import com.avito.android.public_profile.remote.model.ProfileAdvertsResult;
import com.avito.android.public_profile.tracker.PublicProfileAdvertsTracker;
import com.avito.android.public_profile.tracker.PublicProfileAdvertsTrackerImpl;
import com.avito.android.public_profile.tracker.PublicProfileAdvertsTrackerImpl_Factory;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.serp.SerpItemProcessor;
import com.avito.android.serp.ad.AdResourceProvider;
import com.avito.android.serp.ad.AdResourceProviderImpl_Factory;
import com.avito.android.serp.adapter.AdvertGridItemPresenter;
import com.avito.android.serp.adapter.AdvertItemDoubleBlueprint;
import com.avito.android.serp.adapter.AdvertItemGridBlueprint;
import com.avito.android.serp.adapter.AdvertItemListBlueprint;
import com.avito.android.serp.adapter.AdvertItemListener;
import com.avito.android.serp.adapter.AdvertListItemPresenter;
import com.avito.android.serp.adapter.AdvertSpanCountProvider;
import com.avito.android.serp.adapter.FavoriteStatusResolver;
import com.avito.android.serp.adapter.HeaderElementConverter;
import com.avito.android.serp.adapter.SellerElementConverter;
import com.avito.android.serp.adapter.SerpAdvertConverter;
import com.avito.android.serp.adapter.SerpCommercialBannerConverter;
import com.avito.android.serp.adapter.SerpElementItemConverter;
import com.avito.android.serp.adapter.SerpItemAbViewConfig;
import com.avito.android.serp.adapter.SerpItemAbViewConfig_Factory;
import com.avito.android.serp.adapter.SerpItemSizeAdjuster;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.ShortcutBannerConverter;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.ViewedStatusResolver;
import com.avito.android.serp.adapter.advert_xl.SerpAdvertXlConverter;
import com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemConverter;
import com.avito.android.serp.adapter.empty_search.EmptySearchItemConverter;
import com.avito.android.serp.adapter.item_sorter.SerpItemSorter;
import com.avito.android.serp.adapter.location_notification.LocationNotificationItemConverter;
import com.avito.android.serp.adapter.map_banner.MapBannerItemConverter;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandler;
import com.avito.android.serp.adapter.promo_card.PromoCardConverter;
import com.avito.android.serp.adapter.promo_card.ReportBannerConverter;
import com.avito.android.serp.adapter.snippet.SnippetConverter;
import com.avito.android.serp.adapter.title.GroupTitleItemConverter;
import com.avito.android.serp.adapter.vertical_main.VerticalFilterItemConverter;
import com.avito.android.serp.adapter.warning.SerpWarningConverter;
import com.avito.android.serp.adapter.witcher.WitcherElementConverter;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Locale;
import javax.inject.Provider;
import kotlin.Unit;
public final class DaggerProfileAdvertsComponent implements ProfileAdvertsComponent {
    public Provider<PageLoadingItemBlueprint> A;
    public Provider<ScreenDiInjectTracker> A0;
    public Provider<ItemBinder> B;
    public Provider<ScreenInitTracker> B0;
    public Provider<AdapterPresenter> C;
    public Provider<ScreenFlowTrackerProvider> C0;
    public Provider<SpannedGridPositionProvider> D;
    public Provider<String> D0;
    public Provider<SerpSpanProvider> E;
    public Provider<PublicProfileAdvertsTrackerImpl> E0;
    public Provider<Resources> F;
    public Provider<PublicProfileAdvertsTracker> F0;
    public Provider<AdvertSpanCountProvider> G;
    public Provider<String> G0;
    public Provider<AdvertSpanCountProvider> H;
    public Provider<PublishRelay<ProfileAdvertsResult>> H0;
    public Provider<SerpAdvertConverter> I;
    public Provider<Consumer<ProfileAdvertsResult>> I0;
    public Provider<SerpAdvertXlConverter> J;
    public Provider<PublishRelay<Unit>> J0;
    public Provider<AdResourceProvider> K;
    public Provider<DestroyableViewHolderBuilder> K0;
    public Provider<RandomKeyProvider> L;
    public Provider<GridLayoutManager.SpanSizeLookup> L0;
    public Provider<SerpCommercialBannerConverter> M;
    public Provider<DeepLinkFactory> N;
    public Provider<ShortcutBannerConverter> O;
    public Provider<SerpWarningConverter> P;
    public Provider<SnippetConverter> Q;
    public Provider<EmptySearchItemConverter> R;
    public Provider<GroupTitleItemConverter> S;
    public Provider<EmptyPlaceholderItemConverter> T;
    public Provider<HeaderElementConverter> U;
    public Provider<FavoritesSyncDao> V;
    public Provider<FavoriteAdvertsUploadInteractor> W;
    public Provider<FavoriteAdvertsEventInteractor> X;
    public Provider<AccountStateProvider> Y;
    public Provider<FavoriteAdvertsAnalyticsInteractorImpl> Z;
    public final ProfileAdvertsDependencies a;
    public Provider<FavoriteAdvertsInteractorImpl> a0;
    public Provider<PublicProfileApi> b;
    public Provider<FavoriteStatusResolver> b0;
    public Provider<SchedulersFactory3> c;
    public Provider<ViewedAdvertsDao> c0;
    public Provider<ProfileAdvertsInteractor> d;
    public Provider<ViewedAdvertsEventInteractor> d0;
    public Provider<ProfileAdvertsPresenter> e;
    public Provider<ViewedAdvertsInteractor> e0;
    public Provider<AdvertItemListener> f;
    public Provider<ViewedStatusResolver> f0;
    public Provider<Analytics> g;
    public Provider<WitcherElementConverter> g0;
    public Provider<Features> h;
    public Provider<LocationNotificationItemConverter> h0;
    public Provider<SerpOnboardingHandler> i;
    public Provider<SellerElementConverter> i0;
    public Provider<AdvertGridItemPresenter> j;
    public Provider<ReportBannerConverter> j0;
    public Provider<TimeSource> k;
    public Provider<PromoCardConverter> k0;
    public Provider<Locale> l;
    public Provider<MapBannerItemConverter> l0;
    public Provider<ExposedAbTestGroup<PriceOnTopTestGroup>> m;
    public Provider<VerticalFilterItemConverter> m0;
    public Provider<SerpItemsPrefetchTestGroup> n;
    public Provider<SerpElementItemConverter> n0;
    public Provider<SerpItemAbViewConfig> o;
    public Provider<SerpItemSorter> o0;
    public Provider<ConnectivityProvider> p;
    public Provider<SerpItemSizeAdjuster> p0;
    public Provider<AdvertItemGridBlueprint> q;
    public Provider<SerpItemProcessor> q0;
    public Provider<AdvertListItemPresenter> r;
    public Provider<ErrorFormatter> r0;
    public Provider<AdvertItemListBlueprint> s;
    public Provider<FavoriteAdvertsResourceProvider> s0;
    public Provider<AdvertItemDoubleBlueprint> t = SingleCheck.provider(AdvertItemModule_ProvideAdvertItemDoubleBlueprintFactory.create(this.j, this.k, this.l, this.o, this.p));
    public Provider<FavoriteAdvertsPresenter> t0;
    public Provider<PlaceholderItemPresenter> u;
    public Provider<ViewedAdvertsPresenter> u0;
    public Provider<PlaceholderItemBlueprint> v;
    public Provider<ProfileAdvertsResourceProvider> v0;
    public Provider<PublishRelay<ErrorSnippetItem>> w;
    public Provider<ScreenTrackerFactory> w0;
    public Provider<ErrorSnippetItemPresenter> x;
    public Provider<Screen> x0;
    public Provider<ErrorSnippetItemBlueprint> y;
    public Provider<Boolean> y0;
    public Provider<PageLoadingItemPresenter> z;
    public Provider<TimerFactory> z0;

    public static final class b implements ProfileAdvertsComponent.Builder {
        public ProfileAdvertsDependencies a;
        public ProfileAdvertsModule b;
        public ProfileAdvertsAdapterModule c;
        public String d;
        public Resources e;
        public Screen f;
        public Boolean g;
        public String h;
        public SerpOnboardingHandler i;

        public b(a aVar) {
        }

        @Override // com.avito.android.public_profile.di.ProfileAdvertsComponent.Builder
        public ProfileAdvertsComponent.Builder bindContextId(String str) {
            this.h = str;
            return this;
        }

        @Override // com.avito.android.public_profile.di.ProfileAdvertsComponent.Builder
        public ProfileAdvertsComponent.Builder bindShortcut(String str) {
            this.d = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.public_profile.di.ProfileAdvertsComponent.Builder
        public ProfileAdvertsComponent build() {
            Preconditions.checkBuilderRequirement(this.a, ProfileAdvertsDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, ProfileAdvertsModule.class);
            Preconditions.checkBuilderRequirement(this.c, ProfileAdvertsAdapterModule.class);
            Preconditions.checkBuilderRequirement(this.d, String.class);
            Preconditions.checkBuilderRequirement(this.e, Resources.class);
            Preconditions.checkBuilderRequirement(this.f, Screen.class);
            Preconditions.checkBuilderRequirement(this.g, Boolean.class);
            return new DaggerProfileAdvertsComponent(this.b, this.c, new PlaceholderItemModule(), new ErrorSnippetItemModule(), new PageLoadingItemModule(), this.a, this.d, this.e, this.f, this.g, this.h, this.i, null);
        }

        @Override // com.avito.android.public_profile.di.ProfileAdvertsComponent.Builder
        public ProfileAdvertsComponent.Builder profileAdvertsAdapterModule(ProfileAdvertsAdapterModule profileAdvertsAdapterModule) {
            this.c = (ProfileAdvertsAdapterModule) Preconditions.checkNotNull(profileAdvertsAdapterModule);
            return this;
        }

        @Override // com.avito.android.public_profile.di.ProfileAdvertsComponent.Builder
        public ProfileAdvertsComponent.Builder profileAdvertsDependencies(ProfileAdvertsDependencies profileAdvertsDependencies) {
            this.a = (ProfileAdvertsDependencies) Preconditions.checkNotNull(profileAdvertsDependencies);
            return this;
        }

        @Override // com.avito.android.public_profile.di.ProfileAdvertsComponent.Builder
        public ProfileAdvertsComponent.Builder profileAdvertsModule(ProfileAdvertsModule profileAdvertsModule) {
            this.b = (ProfileAdvertsModule) Preconditions.checkNotNull(profileAdvertsModule);
            return this;
        }

        @Override // com.avito.android.public_profile.di.ProfileAdvertsComponent.Builder
        public ProfileAdvertsComponent.Builder withResources(Resources resources) {
            this.e = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.public_profile.di.ProfileAdvertsComponent.Builder
        public ProfileAdvertsComponent.Builder withScreen(Screen screen) {
            this.f = (Screen) Preconditions.checkNotNull(screen);
            return this;
        }

        @Override // com.avito.android.public_profile.di.ProfileAdvertsComponent.Builder
        public ProfileAdvertsComponent.Builder withSerpOnboardingHandler(SerpOnboardingHandler serpOnboardingHandler) {
            this.i = null;
            return this;
        }

        @Override // com.avito.android.public_profile.di.ProfileAdvertsComponent.Builder
        public ProfileAdvertsComponent.Builder withSubComponent(boolean z) {
            this.g = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }
    }

    public static class c implements Provider<AccountStateProvider> {
        public final ProfileAdvertsDependencies a;

        public c(ProfileAdvertsDependencies profileAdvertsDependencies) {
            this.a = profileAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class d implements Provider<PublishRelay<Unit>> {
        public final ProfileAdvertsDependencies a;

        public d(ProfileAdvertsDependencies profileAdvertsDependencies) {
            this.a = profileAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishRelay<Unit> get() {
            return (PublishRelay) Preconditions.checkNotNullFromComponent(this.a.advertsReload());
        }
    }

    public static class e implements Provider<PublishRelay<ProfileAdvertsResult>> {
        public final ProfileAdvertsDependencies a;

        public e(ProfileAdvertsDependencies profileAdvertsDependencies) {
            this.a = profileAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishRelay<ProfileAdvertsResult> get() {
            return (PublishRelay) Preconditions.checkNotNullFromComponent(this.a.advertsResults());
        }
    }

    public static class f implements Provider<Analytics> {
        public final ProfileAdvertsDependencies a;

        public f(ProfileAdvertsDependencies profileAdvertsDependencies) {
            this.a = profileAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class g implements Provider<ConnectivityProvider> {
        public final ProfileAdvertsDependencies a;

        public g(ProfileAdvertsDependencies profileAdvertsDependencies) {
            this.a = profileAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ConnectivityProvider get() {
            return (ConnectivityProvider) Preconditions.checkNotNullFromComponent(this.a.connectivityProvider());
        }
    }

    public static class h implements Provider<DeepLinkFactory> {
        public final ProfileAdvertsDependencies a;

        public h(ProfileAdvertsDependencies profileAdvertsDependencies) {
            this.a = profileAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeepLinkFactory get() {
            return (DeepLinkFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkFactory());
        }
    }

    public static class i implements Provider<FavoriteAdvertsEventInteractor> {
        public final ProfileAdvertsDependencies a;

        public i(ProfileAdvertsDependencies profileAdvertsDependencies) {
            this.a = profileAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsEventInteractor get() {
            return (FavoriteAdvertsEventInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsEventInteractor());
        }
    }

    public static class j implements Provider<FavoriteAdvertsUploadInteractor> {
        public final ProfileAdvertsDependencies a;

        public j(ProfileAdvertsDependencies profileAdvertsDependencies) {
            this.a = profileAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsUploadInteractor get() {
            return (FavoriteAdvertsUploadInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsUploadInteractor());
        }
    }

    public static class k implements Provider<FavoritesSyncDao> {
        public final ProfileAdvertsDependencies a;

        public k(ProfileAdvertsDependencies profileAdvertsDependencies) {
            this.a = profileAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoritesSyncDao get() {
            return (FavoritesSyncDao) Preconditions.checkNotNullFromComponent(this.a.favoritesSyncDao());
        }
    }

    public static class l implements Provider<Features> {
        public final ProfileAdvertsDependencies a;

        public l(ProfileAdvertsDependencies profileAdvertsDependencies) {
            this.a = profileAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class m implements Provider<Locale> {
        public final ProfileAdvertsDependencies a;

        public m(ProfileAdvertsDependencies profileAdvertsDependencies) {
            this.a = profileAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class n implements Provider<SerpItemsPrefetchTestGroup> {
        public final ProfileAdvertsDependencies a;

        public n(ProfileAdvertsDependencies profileAdvertsDependencies) {
            this.a = profileAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SerpItemsPrefetchTestGroup get() {
            return (SerpItemsPrefetchTestGroup) Preconditions.checkNotNullFromComponent(this.a.prefetchTestGroup());
        }
    }

    public static class o implements Provider<ExposedAbTestGroup<PriceOnTopTestGroup>> {
        public final ProfileAdvertsDependencies a;

        public o(ProfileAdvertsDependencies profileAdvertsDependencies) {
            this.a = profileAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ExposedAbTestGroup<PriceOnTopTestGroup> get() {
            return (ExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.priceOnTop());
        }
    }

    public static class p implements Provider<PublicProfileApi> {
        public final ProfileAdvertsDependencies a;

        public p(ProfileAdvertsDependencies profileAdvertsDependencies) {
            this.a = profileAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublicProfileApi get() {
            return (PublicProfileApi) Preconditions.checkNotNullFromComponent(this.a.publicProfileApi());
        }
    }

    public static class q implements Provider<RandomKeyProvider> {
        public final ProfileAdvertsDependencies a;

        public q(ProfileAdvertsDependencies profileAdvertsDependencies) {
            this.a = profileAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public RandomKeyProvider get() {
            return (RandomKeyProvider) Preconditions.checkNotNullFromComponent(this.a.randomKeyProvider());
        }
    }

    public static class r implements Provider<SchedulersFactory3> {
        public final ProfileAdvertsDependencies a;

        public r(ProfileAdvertsDependencies profileAdvertsDependencies) {
            this.a = profileAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class s implements Provider<ScreenTrackerFactory> {
        public final ProfileAdvertsDependencies a;

        public s(ProfileAdvertsDependencies profileAdvertsDependencies) {
            this.a = profileAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class t implements Provider<TimeSource> {
        public final ProfileAdvertsDependencies a;

        public t(ProfileAdvertsDependencies profileAdvertsDependencies) {
            this.a = profileAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public static class u implements Provider<TimerFactory> {
        public final ProfileAdvertsDependencies a;

        public u(ProfileAdvertsDependencies profileAdvertsDependencies) {
            this.a = profileAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimerFactory get() {
            return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
        }
    }

    public static class v implements Provider<ViewedAdvertsDao> {
        public final ProfileAdvertsDependencies a;

        public v(ProfileAdvertsDependencies profileAdvertsDependencies) {
            this.a = profileAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ViewedAdvertsDao get() {
            return (ViewedAdvertsDao) Preconditions.checkNotNullFromComponent(this.a.viewedAdvertsDao());
        }
    }

    public static class w implements Provider<ViewedAdvertsEventInteractor> {
        public final ProfileAdvertsDependencies a;

        public w(ProfileAdvertsDependencies profileAdvertsDependencies) {
            this.a = profileAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ViewedAdvertsEventInteractor get() {
            return (ViewedAdvertsEventInteractor) Preconditions.checkNotNullFromComponent(this.a.viewedAdvertsEventInteractor());
        }
    }

    public DaggerProfileAdvertsComponent(ProfileAdvertsModule profileAdvertsModule, ProfileAdvertsAdapterModule profileAdvertsAdapterModule, PlaceholderItemModule placeholderItemModule, ErrorSnippetItemModule errorSnippetItemModule, PageLoadingItemModule pageLoadingItemModule, ProfileAdvertsDependencies profileAdvertsDependencies, String str, Resources resources, Screen screen, Boolean bool, String str2, SerpOnboardingHandler serpOnboardingHandler, a aVar) {
        this.a = profileAdvertsDependencies;
        p pVar = new p(profileAdvertsDependencies);
        this.b = pVar;
        r rVar = new r(profileAdvertsDependencies);
        this.c = rVar;
        this.d = DoubleCheck.provider(ProfileAdvertsModule_ProvideInteractor$public_profile_releaseFactory.create(profileAdvertsModule, pVar, rVar));
        DelegateFactory delegateFactory = new DelegateFactory();
        this.e = delegateFactory;
        this.f = DoubleCheck.provider(ProfileAdvertsModule_ProvideAdvertItemListener$public_profile_releaseFactory.create(profileAdvertsModule, delegateFactory));
        this.g = new f(profileAdvertsDependencies);
        this.h = new l(profileAdvertsDependencies);
        Factory createNullable = InstanceFactory.createNullable(serpOnboardingHandler);
        this.i = createNullable;
        this.j = SingleCheck.provider(AdvertItemPresenterModule_ProvideAdvertGridItemPresenterFactory.create(this.f, this.g, this.h, createNullable));
        this.k = new t(profileAdvertsDependencies);
        this.l = new m(profileAdvertsDependencies);
        o oVar = new o(profileAdvertsDependencies);
        this.m = oVar;
        n nVar = new n(profileAdvertsDependencies);
        this.n = nVar;
        SerpItemAbViewConfig_Factory create = SerpItemAbViewConfig_Factory.create(oVar, nVar);
        this.o = create;
        g gVar = new g(profileAdvertsDependencies);
        this.p = gVar;
        this.q = SingleCheck.provider(AdvertItemModule_ProvideAdvertItemGridBlueprintFactory.create(this.j, this.k, this.l, create, gVar));
        Provider<AdvertListItemPresenter> provider = SingleCheck.provider(AdvertItemPresenterModule_ProvideAdvertListItemPresenterFactory.create(this.f, this.g, this.h, this.i));
        this.r = provider;
        this.s = SingleCheck.provider(AdvertItemModule_ProvideAdvertItemListBlueprintFactory.create(provider, this.k, this.l, this.o, this.p));
        Provider<PlaceholderItemPresenter> provider2 = DoubleCheck.provider(PlaceholderItemModule_ProvidePresenter$public_profile_releaseFactory.create(placeholderItemModule));
        this.u = provider2;
        this.v = DoubleCheck.provider(PlaceholderItemModule_ProvideBlueprint$public_profile_releaseFactory.create(placeholderItemModule, provider2));
        Provider<PublishRelay<ErrorSnippetItem>> provider3 = DoubleCheck.provider(ErrorSnippetItemModule_ProvideItemClicksStream$public_profile_releaseFactory.create(errorSnippetItemModule));
        this.w = provider3;
        Provider<ErrorSnippetItemPresenter> provider4 = DoubleCheck.provider(ErrorSnippetItemModule_ProvidePresenter$public_profile_releaseFactory.create(errorSnippetItemModule, provider3));
        this.x = provider4;
        this.y = DoubleCheck.provider(ErrorSnippetItemModule_ProvideBlueprint$public_profile_releaseFactory.create(errorSnippetItemModule, provider4));
        Provider<PageLoadingItemPresenter> provider5 = DoubleCheck.provider(PageLoadingItemModule_ProvidePresenter$public_profile_releaseFactory.create(pageLoadingItemModule));
        this.z = provider5;
        Provider<PageLoadingItemBlueprint> provider6 = DoubleCheck.provider(PageLoadingItemModule_ProvideBlueprint$public_profile_releaseFactory.create(pageLoadingItemModule, provider5));
        this.A = provider6;
        Provider<ItemBinder> provider7 = DoubleCheck.provider(ProfileAdvertsModule_ProvideItemBinder$public_profile_releaseFactory.create(profileAdvertsModule, this.q, this.s, this.t, this.v, this.y, provider6));
        this.B = provider7;
        this.C = DoubleCheck.provider(ProfileAdvertsModule_ProvideAdapterPresenter$public_profile_releaseFactory.create(profileAdvertsModule, provider7));
        Provider<SpannedGridPositionProvider> provider8 = DoubleCheck.provider(ProfileAdvertsAdapterModule_ProvideGridPositionProvider$public_profile_releaseFactory.create(profileAdvertsAdapterModule));
        this.D = provider8;
        this.E = DoubleCheck.provider(ProfileAdvertsAdapterModule_ProvideSpanProvider$public_profile_releaseFactory.create(profileAdvertsAdapterModule, provider8));
        Factory create2 = InstanceFactory.create(resources);
        this.F = create2;
        this.G = SingleCheck.provider(SerpItemConverterModule_ProvideItemAdvertSpanCountProviderFactory.create(create2));
        Provider<AdvertSpanCountProvider> provider9 = SingleCheck.provider(SerpItemConverterModule_ProvideBigAdvertSpanCountProviderFactory.create(this.F));
        this.H = provider9;
        this.I = SingleCheck.provider(SerpItemConverterModule_ProvideAdvertConverterFactory.create(this.G, provider9, this.F, this.h));
        this.J = SingleCheck.provider(SerpItemConverterModule_ProvideAdvertXlConverterFactory.create(this.F, this.h));
        Provider<AdResourceProvider> provider10 = DoubleCheck.provider(AdResourceProviderImpl_Factory.create());
        this.K = provider10;
        q qVar = new q(profileAdvertsDependencies);
        this.L = qVar;
        this.M = SingleCheck.provider(SerpItemConverterModule_ProvideCommercialConverterFactory.create(this.G, this.H, provider10, qVar));
        h hVar = new h(profileAdvertsDependencies);
        this.N = hVar;
        this.O = SingleCheck.provider(SerpItemConverterModule_ProvideShortcutBannerConverterFactory.create(hVar, this.F));
        this.P = SingleCheck.provider(SerpItemConverterModule_ProvideSerpWarningConverterFactory.create());
        this.Q = SingleCheck.provider(SerpItemConverterModule_ProvideSnippetConverterFactory.create());
        this.R = SingleCheck.provider(SerpItemConverterModule_ProvideSerpEmptySearchConverterFactory.create());
        this.S = SingleCheck.provider(SerpItemConverterModule_ProvideGroupTitleItemConverterFactory.create());
        this.T = SingleCheck.provider(SerpItemConverterModule_ProvideEmptyPlaceholderItemConverterFactory.create());
        this.U = SingleCheck.provider(SerpItemConverterModule_ProvideHeaderElementConverterFactory.create());
        this.V = new k(profileAdvertsDependencies);
        this.W = new j(profileAdvertsDependencies);
        this.X = new i(profileAdvertsDependencies);
        c cVar = new c(profileAdvertsDependencies);
        this.Y = cVar;
        FavoriteAdvertsAnalyticsInteractorImpl_Factory create3 = FavoriteAdvertsAnalyticsInteractorImpl_Factory.create(this.g, cVar);
        this.Z = create3;
        FavoriteAdvertsInteractorImpl_Factory create4 = FavoriteAdvertsInteractorImpl_Factory.create(this.V, this.W, this.X, create3, this.c);
        this.a0 = create4;
        this.b0 = SingleCheck.provider(SerpItemConverterModule_ProvideFavoriteStatusResolverFactory.create(create4));
        this.c0 = new v(profileAdvertsDependencies);
        this.d0 = new w(profileAdvertsDependencies);
        Provider<ViewedAdvertsInteractor> provider11 = SingleCheck.provider(ViewedAdvertsModule_ProvideViewedAdvertsInteractorFactory.create(ViewedAdvertsInteractorFactoryImpl_Factory.create(), this.c0, this.c, this.d0, this.h));
        this.e0 = provider11;
        Provider<ViewedStatusResolver> provider12 = SingleCheck.provider(ViewedAdvertsModule_ProvideViewedStatusResolverFactory.create(provider11));
        this.f0 = provider12;
        this.g0 = SingleCheck.provider(SerpItemConverterModule_ProvideWitcherElementConverterFactory.create(this.I, this.b0, provider12));
        this.h0 = SingleCheck.provider(SerpItemConverterModule_ProvideLocationNotificationConverterFactory.create());
        this.i0 = SingleCheck.provider(SerpItemConverterModule_ProvideSellerElementConverterFactory.create());
        this.j0 = SingleCheck.provider(SerpItemConverterModule_ProvideReportBannerConverterFactory.create(this.F, this.h));
        this.k0 = SingleCheck.provider(SerpItemConverterModule_ProvidePromoCardConverterFactory.create(this.F, this.h));
        this.l0 = SingleCheck.provider(SerpItemConverterModule_ProvideMapBannerConverterFactory.create());
        Provider<VerticalFilterItemConverter> provider13 = SingleCheck.provider(SerpItemConverterModule_ProvideVerticalFilterItemConverterFactory.create());
        this.m0 = provider13;
        this.n0 = SingleCheck.provider(SerpItemConverterModule_ProvideElementItemConverterFactory.create(this.I, this.J, this.M, this.O, this.P, this.Q, this.R, this.S, this.T, this.U, this.g0, this.h0, this.i0, this.j0, this.k0, this.l0, provider13));
        this.o0 = SingleCheck.provider(SerpItemConverterModule_ProvideSerpItemSorterFactory.create());
        Provider<SerpItemSizeAdjuster> provider14 = SingleCheck.provider(SerpItemConverterModule_ProvideItemSizeAdjusterFactory.create());
        this.p0 = provider14;
        this.q0 = SingleCheck.provider(SerpItemConverterModule_ProvideSerpItemProcessorFactory.create(this.n0, this.o0, provider14, this.b0, this.f0, this.c));
        this.r0 = DoubleCheck.provider(ProfileAdvertsModule_ProvideErrorFormatter$public_profile_releaseFactory.create(profileAdvertsModule));
        Provider<FavoriteAdvertsResourceProvider> provider15 = SingleCheck.provider(FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsResourceProvider$favorite_core_releaseFactory.create(this.F));
        this.s0 = provider15;
        this.t0 = SingleCheck.provider(FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsPresenter$favorite_core_releaseFactory.create(this.a0, this.c, provider15));
        this.u0 = SingleCheck.provider(ViewedAdvertsModule_ProvideViewedAdvertsPresenterFactory.create(this.d0, this.c));
        this.v0 = DoubleCheck.provider(ProfileAdvertsModule_ProfileAdvertsResourceProvider$public_profile_releaseFactory.create(profileAdvertsModule));
        this.w0 = new s(profileAdvertsDependencies);
        this.x0 = InstanceFactory.create(screen);
        Factory create5 = InstanceFactory.create(bool);
        this.y0 = create5;
        u uVar = new u(profileAdvertsDependencies);
        this.z0 = uVar;
        this.A0 = DoubleCheck.provider(PublicProfileAdvertsTrackerModule_ProvidesScreenDiInjectTracker$public_profile_releaseFactory.create(this.w0, this.x0, create5, uVar));
        this.B0 = DoubleCheck.provider(PublicProfileAdvertsTrackerModule_ProvidesScreenInitTrackerFactory.create(this.w0, this.x0, this.y0, this.z0));
        this.C0 = DoubleCheck.provider(PublicProfileAdvertsTrackerModule_ProvidesScreenFlowTrackerProviderFactory.create(this.w0, this.x0, this.z0));
        Factory create6 = InstanceFactory.create(str);
        this.D0 = create6;
        PublicProfileAdvertsTrackerImpl_Factory create7 = PublicProfileAdvertsTrackerImpl_Factory.create(this.A0, this.B0, this.C0, create6);
        this.E0 = create7;
        this.F0 = DoubleCheck.provider(create7);
        this.G0 = InstanceFactory.createNullable(str2);
        e eVar = new e(profileAdvertsDependencies);
        this.H0 = eVar;
        Provider<Consumer<ProfileAdvertsResult>> provider16 = DoubleCheck.provider(eVar);
        this.I0 = provider16;
        d dVar = new d(profileAdvertsDependencies);
        this.J0 = dVar;
        DelegateFactory.setDelegate(this.e, DoubleCheck.provider(ProfileAdvertsModule_ProvidePresenter$public_profile_releaseFactory.create(profileAdvertsModule, this.d, this.c, this.C, this.E, this.D, this.q0, this.r0, this.t0, this.u0, this.v0, this.F0, this.D0, this.w, this.G0, provider16, dVar)));
        this.K0 = DoubleCheck.provider(ProfileAdvertsModule_ProvideDestroyableViewHolderBuilder$public_profile_releaseFactory.create(profileAdvertsModule, this.B));
        this.L0 = DoubleCheck.provider(ProfileAdvertsAdapterModule_ProvideSpanLookup$public_profile_releaseFactory.create(profileAdvertsAdapterModule, this.E));
    }

    public static ProfileAdvertsComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.public_profile.di.ProfileAdvertsComponent
    public void inject(ProfileAdvertsFragment profileAdvertsFragment) {
        ProfileAdvertsFragment_MembersInjector.injectPresenter(profileAdvertsFragment, this.e.get());
        ProfileAdvertsFragment_MembersInjector.injectInteractor(profileAdvertsFragment, this.d.get());
        ProfileAdvertsFragment_MembersInjector.injectAdapterPresenter(profileAdvertsFragment, this.C.get());
        ProfileAdvertsFragment_MembersInjector.injectViewHolderBuilder(profileAdvertsFragment, this.K0.get());
        ProfileAdvertsFragment_MembersInjector.injectGridPositionProvider(profileAdvertsFragment, this.D.get());
        ProfileAdvertsFragment_MembersInjector.injectSpanSizeLookup(profileAdvertsFragment, this.L0.get());
        ProfileAdvertsFragment_MembersInjector.injectIntentFactory(profileAdvertsFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        ProfileAdvertsFragment_MembersInjector.injectFavoriteAdvertsPresenter(profileAdvertsFragment, this.t0.get());
        ProfileAdvertsFragment_MembersInjector.injectViewedAdvertsPresenter(profileAdvertsFragment, this.u0.get());
        ProfileAdvertsFragment_MembersInjector.injectDeepLinkIntentFactory(profileAdvertsFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        ProfileAdvertsFragment_MembersInjector.injectAbTestsConfigProvider(profileAdvertsFragment, (AbTestsConfigProvider) Preconditions.checkNotNullFromComponent(this.a.abTestsConfigProvider()));
        ProfileAdvertsFragment_MembersInjector.injectTracker(profileAdvertsFragment, this.F0.get());
    }
}
