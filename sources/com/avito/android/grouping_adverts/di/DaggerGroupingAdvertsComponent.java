package com.avito.android.grouping_adverts.di;

import android.content.res.Resources;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.ab_tests.configs.PriceOnTopTestGroup;
import com.avito.android.ab_tests.configs.SellerInfoInRichSnippetTestGroup;
import com.avito.android.ab_tests.configs.SerpItemsPrefetchTestGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithControl2;
import com.avito.android.ab_tests.models.AbTestGroup;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert.viewed.ViewedAdvertsEventInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsInteractorFactoryImpl_Factory;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.FavoriteAdvertsAnalyticsInteractorImpl;
import com.avito.android.analytics.FavoriteAdvertsAnalyticsInteractorImpl_Factory;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.async_phone.AsyncPhoneInteractor;
import com.avito.android.async_phone.AsyncPhoneInteractorImpl;
import com.avito.android.async_phone.AsyncPhoneInteractorImpl_Factory;
import com.avito.android.async_phone.AsyncPhonePresenter;
import com.avito.android.async_phone.AsyncPhonePresenterImpl;
import com.avito.android.async_phone.AsyncPhonePresenterImpl_Factory;
import com.avito.android.async_phone.AsyncPhoneTracker;
import com.avito.android.async_phone.AsyncPhoneTrackerImpl;
import com.avito.android.async_phone.AsyncPhoneTrackerImpl_Factory;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.date_time_formatter.DateTimeFormatter;
import com.avito.android.date_time_formatter.DateTimeFormatterResourceProviderImpl;
import com.avito.android.date_time_formatter.DateTimeFormatterResourceProviderImpl_Factory;
import com.avito.android.db.favorites.FavoritesSyncDao;
import com.avito.android.db.viewed.ViewedAdvertsDao;
import com.avito.android.deep_linking.ClickStreamLinkHandler;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.SimpleClickStreamLinkHandler;
import com.avito.android.deep_linking.SimpleClickStreamLinkHandler_Factory;
import com.avito.android.di.ViewedAdvertsModule_ProvideViewedAdvertsInteractorFactory;
import com.avito.android.di.ViewedAdvertsModule_ProvideViewedAdvertsPresenterFactory;
import com.avito.android.di.ViewedAdvertsModule_ProvideViewedStatusResolverFactory;
import com.avito.android.di.module.AdvertItemModule_ProvideAdvertItemGridBlueprintFactory;
import com.avito.android.di.module.AdvertItemModule_ProvideAdvertItemListBlueprintFactory;
import com.avito.android.di.module.AdvertItemPresenterModule_ProvideAdvertGridItemPresenterFactory;
import com.avito.android.di.module.AdvertItemPresenterModule_ProvideAdvertListItemPresenterFactory;
import com.avito.android.di.module.AppendingLoaderModule;
import com.avito.android.di.module.AppendingLoaderModule_ProvideAppendingLoaderItemBlueprintFactory;
import com.avito.android.di.module.AppendingLoaderModule_ProvideAppendingLoaderItemPresenterFactory;
import com.avito.android.di.module.DateTimeFormatterModule_ProvideUpperCaseDateTimeFormatterFactory;
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
import com.avito.android.di.module.SpanAdapterModule_ProvideSerpSpanProviderFactory;
import com.avito.android.di.module.SpanAdapterModule_ProvideSpannedGridPositionProviderFactory;
import com.avito.android.favorite.FavoriteAdvertsEventInteractor;
import com.avito.android.favorite.FavoriteAdvertsInteractorImpl;
import com.avito.android.favorite.FavoriteAdvertsInteractorImpl_Factory;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsResourceProvider;
import com.avito.android.favorite.FavoriteAdvertsUploadInteractor;
import com.avito.android.favorites.FavoriteAdvertItemConverter;
import com.avito.android.favorites.FavoriteAdvertItemConverterImpl;
import com.avito.android.favorites.FavoriteAdvertItemConverterImpl_Factory;
import com.avito.android.favorites.FavoriteAdvertItemConverterResourceProvider;
import com.avito.android.favorites.FavoriteAdvertItemConverterResourceProviderImpl;
import com.avito.android.favorites.FavoriteAdvertItemConverterResourceProviderImpl_Factory;
import com.avito.android.favorites.remote.FavoritesApi;
import com.avito.android.grouping_adverts.GroupingAdvertsArguments;
import com.avito.android.grouping_adverts.GroupingAdvertsFragment;
import com.avito.android.grouping_adverts.GroupingAdvertsFragment_MembersInjector;
import com.avito.android.grouping_adverts.GroupingAdvertsInteractor;
import com.avito.android.grouping_adverts.GroupingAdvertsInteractorImpl;
import com.avito.android.grouping_adverts.GroupingAdvertsInteractorImpl_Factory;
import com.avito.android.grouping_adverts.GroupingAdvertsItemsFilter;
import com.avito.android.grouping_adverts.GroupingAdvertsItemsFilterImpl;
import com.avito.android.grouping_adverts.GroupingAdvertsItemsFilterImpl_Factory;
import com.avito.android.grouping_adverts.GroupingAdvertsPresenter;
import com.avito.android.grouping_adverts.GroupingAdvertsPresenterImpl;
import com.avito.android.grouping_adverts.GroupingAdvertsPresenterImpl_Factory;
import com.avito.android.grouping_adverts.GroupingAdvertsResourcesProvider;
import com.avito.android.grouping_adverts.GroupingAdvertsResourcesProviderImpl;
import com.avito.android.grouping_adverts.GroupingAdvertsResourcesProviderImpl_Factory;
import com.avito.android.grouping_adverts.di.GroupingAdvertsComponent;
import com.avito.android.grouping_adverts.tracker.GroupingAdvertsTracker;
import com.avito.android.grouping_adverts.tracker.GroupingAdvertsTrackerImpl;
import com.avito.android.grouping_adverts.tracker.GroupingAdvertsTrackerImpl_Factory;
import com.avito.android.home.appending_item.loader.AppendingLoaderItemBlueprint;
import com.avito.android.home.appending_item.loader.AppendingLoaderItemPresenter;
import com.avito.android.remote.AsyncPhoneApi;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.AdvertPrice;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.SearchParamsConverterImpl_Factory;
import com.avito.android.serp.SerpItemProcessor;
import com.avito.android.serp.ad.AdResourceProvider;
import com.avito.android.serp.ad.AdResourceProviderImpl_Factory;
import com.avito.android.serp.adapter.AdvertGridItemPresenter;
import com.avito.android.serp.adapter.AdvertItemGridBlueprint;
import com.avito.android.serp.adapter.AdvertItemListBlueprint;
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
import com.avito.android.serp.adapter.SpanLookup;
import com.avito.android.serp.adapter.SpanLookup_Factory;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.ViewedStatusResolver;
import com.avito.android.serp.adapter.advert_xl.SerpAdvertXlConverter;
import com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemConverter;
import com.avito.android.serp.adapter.empty_search.EmptySearchItemConverter;
import com.avito.android.serp.adapter.header.HeaderBlueprint;
import com.avito.android.serp.adapter.header.HeaderBlueprint_Factory;
import com.avito.android.serp.adapter.header.HeaderPresenter;
import com.avito.android.serp.adapter.header.HeaderPresenterImpl_Factory;
import com.avito.android.serp.adapter.item_sorter.SerpItemSorter;
import com.avito.android.serp.adapter.location_notification.LocationNotificationItemConverter;
import com.avito.android.serp.adapter.map_banner.MapBannerItemConverter;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandler;
import com.avito.android.serp.adapter.promo_card.PromoCardConverter;
import com.avito.android.serp.adapter.promo_card.ReportBannerConverter;
import com.avito.android.serp.adapter.rich_snippets.AdvertSellerConverter;
import com.avito.android.serp.adapter.rich_snippets.AdvertSellerConverterImpl;
import com.avito.android.serp.adapter.rich_snippets.AdvertSellerConverterImpl_Factory;
import com.avito.android.serp.adapter.rich_snippets.RichSnippetStateProvider;
import com.avito.android.serp.adapter.rich_snippets.RichSnippetStateProviderProxy;
import com.avito.android.serp.adapter.rich_snippets.RichSnippetStateProviderProxy_Factory;
import com.avito.android.serp.adapter.rich_snippets.RichSnippetsResourceProvider;
import com.avito.android.serp.adapter.rich_snippets.RichSnippetsResourceProviderImpl;
import com.avito.android.serp.adapter.rich_snippets.RichSnippetsResourceProviderImpl_Factory;
import com.avito.android.serp.adapter.rich_snippets.SellerInfoParamsFactory;
import com.avito.android.serp.adapter.rich_snippets.SellerInfoParamsFactoryImpl;
import com.avito.android.serp.adapter.rich_snippets.SellerInfoParamsFactoryImpl_Factory;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichItemPresenter;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichItemPresenterImpl;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichItemPresenterImpl_Factory;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichSmallItemBlueprint;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichSmallItemBlueprint_Factory;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertXlRichItemBlueprint;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertXlRichItemBlueprint_Factory;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertXlRichItemPresenter;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertXlRichItemPresenterImpl;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertXlRichItemPresenterImpl_Factory;
import com.avito.android.serp.adapter.snippet.SnippetConverter;
import com.avito.android.serp.adapter.title.GroupTitleItemConverter;
import com.avito.android.serp.adapter.vertical_main.VerticalFilterItemConverter;
import com.avito.android.serp.adapter.warning.SerpWarningConverter;
import com.avito.android.serp.adapter.witcher.WitcherElementConverter;
import com.avito.android.serp.analytics.SerpAnalyticsInteractor;
import com.avito.android.server_time.TimeSource;
import com.avito.android.ui.adapter.AppendingHandler;
import com.avito.android.util.AdvertPriceFormatter;
import com.avito.android.util.AdvertPriceFormatter_Factory;
import com.avito.android.util.Formatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Locale;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerGroupingAdvertsComponent implements GroupingAdvertsComponent {
    public Provider<ExposedAbTestGroup<PriceOnTopTestGroup>> A;
    public Provider<RandomKeyProvider> A0;
    public Provider<SerpItemsPrefetchTestGroup> B;
    public Provider<SerpCommercialBannerConverter> B0;
    public Provider<SerpItemAbViewConfig> C;
    public Provider<DeepLinkFactory> C0;
    public Provider<ConnectivityProvider> D;
    public Provider<ShortcutBannerConverter> D0;
    public Provider<AdvertItemListBlueprint> E;
    public Provider<SerpWarningConverter> E0;
    public Provider<DateTimeFormatterResourceProviderImpl> F;
    public Provider<SnippetConverter> F0;
    public Provider<DateTimeFormatter> G;
    public Provider<EmptySearchItemConverter> G0;
    public Provider<Kundle> H;
    public Provider<GroupTitleItemConverter> H0;
    public Provider<AdvertSellerConverterImpl> I;
    public Provider<EmptyPlaceholderItemConverter> I0;
    public Provider<AdvertSellerConverter> J;
    public Provider<HeaderElementConverter> J0;
    public Provider<AsyncPhoneApi> K;
    public Provider<FavoriteStatusResolver> K0;
    public Provider<AsyncPhoneInteractorImpl> L;
    public Provider<ViewedAdvertsDao> L0;
    public Provider<AsyncPhoneInteractor> M;
    public Provider<ViewedAdvertsEventInteractor> M0;
    public Provider<TypedErrorThrowableConverter> N;
    public Provider<ViewedAdvertsInteractor> N0;
    public Provider<ScreenTrackerFactory> O;
    public Provider<ViewedStatusResolver> O0;
    public Provider<TimerFactory> P;
    public Provider<WitcherElementConverter> P0;
    public Provider<Screen> Q;
    public Provider<LocationNotificationItemConverter> Q0;
    public Provider<AsyncPhoneTrackerImpl> R;
    public Provider<SellerElementConverter> R0;
    public Provider<AsyncPhoneTracker> S;
    public Provider<ReportBannerConverter> S0;
    public Provider<AccountStateProvider> T;
    public Provider<PromoCardConverter> T0;
    public Provider<AsyncPhonePresenterImpl> U;
    public Provider<MapBannerItemConverter> U0;
    public Provider<AsyncPhonePresenter> V;
    public Provider<VerticalFilterItemConverter> V0;
    public Provider<SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup>> W;
    public Provider<SerpElementItemConverter> W0;
    public Provider<AdvertRichItemPresenterImpl> X;
    public Provider<SerpItemSorter> X0;
    public Provider<AdvertRichItemPresenter> Y;
    public Provider<SerpItemSizeAdjuster> Y0;
    public Provider<RecyclerView.RecycledViewPool> Z;
    public Provider<SerpItemProcessor> Z0;
    public final GroupingAdvertsDependencies a;
    public Provider<SellerInfoParamsFactoryImpl> a0;
    public Provider<ViewedAdvertsPresenter> a1;
    public Provider<GroupingAdvertsArguments> b;
    public Provider<SellerInfoParamsFactory> b0;
    public Provider<SpannedGridPositionProvider> b1;
    public Provider<SearchApi> c;
    public Provider<AdvertRichSmallItemBlueprint> c0;
    public Provider<SerpSpanProvider> c1;
    public Provider<FavoritesApi> d;
    public Provider<AdvertGridItemPresenter> d0;
    public Provider<GroupingAdvertsResourcesProviderImpl> d1;
    public Provider<SchedulersFactory3> e;
    public Provider<AdvertItemGridBlueprint> e0;
    public Provider<GroupingAdvertsResourcesProvider> e1;
    public Provider<SearchParamsConverter> f = DoubleCheck.provider(SearchParamsConverterImpl_Factory.create());
    public Provider<AppendingLoaderItemPresenter> f0;
    public Provider<SimpleClickStreamLinkHandler> f1;
    public Provider<Locale> g;
    public Provider<AppendingLoaderItemBlueprint> g0;
    public Provider<ClickStreamLinkHandler> g1;
    public Provider<AdvertPriceFormatter> h;
    public Provider<RichSnippetsResourceProviderImpl> h0;
    public Provider<AbTestGroup<SimpleTestGroupWithControl2>> h1;
    public Provider<Formatter<AdvertPrice>> i;
    public Provider<RichSnippetsResourceProvider> i0;
    public Provider<GroupingAdvertsItemsFilterImpl> i1;
    public Provider<Resources> j;
    public Provider<AdvertXlRichItemPresenterImpl> j0;
    public Provider<GroupingAdvertsItemsFilter> j1;
    public Provider<FavoriteAdvertItemConverterResourceProviderImpl> k;
    public Provider<AdvertXlRichItemPresenter> k0;
    public Provider<Kundle> k1;
    public Provider<FavoriteAdvertItemConverterResourceProvider> l;
    public Provider<AdvertXlRichItemBlueprint> l0;
    public Provider<GroupingAdvertsPresenterImpl> l1;
    public Provider<Features> m;
    public Provider<ItemBinder> m0;
    public Provider<SpanLookup> m1;
    public Provider<FavoriteAdvertItemConverterImpl> n;
    public Provider<AdapterPresenter> n0;
    public Provider<GridLayoutManager.SpanSizeLookup> n1;
    public Provider<FavoriteAdvertItemConverter> o;
    public Provider<FavoritesSyncDao> o0;
    public Provider<AppendingHandler> o1;
    public Provider<GroupingAdvertsInteractorImpl> p;
    public Provider<FavoriteAdvertsUploadInteractor> p0;
    public Provider<RichSnippetStateProvider> p1;
    public Provider<GroupingAdvertsInteractor> q;
    public Provider<FavoriteAdvertsEventInteractor> q0;
    public Provider<Set<RichSnippetStateProvider>> q1;
    public Provider<Analytics> r;
    public Provider<FavoriteAdvertsAnalyticsInteractorImpl> r0;
    public Provider<RichSnippetStateProviderProxy> r1;
    public Provider<TreeStateIdGenerator> s;
    public Provider<FavoriteAdvertsInteractorImpl> s0;
    public Provider<RichSnippetStateProvider> s1;
    public Provider<SerpAnalyticsInteractor> t;
    public Provider<FavoriteAdvertsResourceProvider> t0;
    public Provider<GroupingAdvertsTrackerImpl> t1;
    public Provider<HeaderPresenter> u;
    public Provider<FavoriteAdvertsPresenter> u0;
    public Provider<GroupingAdvertsTracker> u1;
    public Provider<HeaderBlueprint> v;
    public Provider<AdvertSpanCountProvider> v0;
    public Provider<GroupingAdvertsPresenter> w;
    public Provider<AdvertSpanCountProvider> w0;
    public Provider<SerpOnboardingHandler> x;
    public Provider<SerpAdvertConverter> x0;
    public Provider<AdvertListItemPresenter> y;
    public Provider<SerpAdvertXlConverter> y0;
    public Provider<TimeSource> z;
    public Provider<AdResourceProvider> z0;

    public static class a0 implements Provider<ViewedAdvertsEventInteractor> {
        public final GroupingAdvertsDependencies a;

        public a0(GroupingAdvertsDependencies groupingAdvertsDependencies) {
            this.a = groupingAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ViewedAdvertsEventInteractor get() {
            return (ViewedAdvertsEventInteractor) Preconditions.checkNotNullFromComponent(this.a.viewedAdvertsEventInteractor());
        }
    }

    public static final class b implements GroupingAdvertsComponent.Builder {
        public GroupingAdvertsDependencies a;
        public GroupingAdvertsArguments b;
        public Screen c;
        public Resources d;
        public Kundle e;
        public Kundle f;
        public RecyclerView.RecycledViewPool g;
        public SerpOnboardingHandler h;

        public b(a aVar) {
        }

        @Override // com.avito.android.grouping_adverts.di.GroupingAdvertsComponent.Builder
        public GroupingAdvertsComponent build() {
            Preconditions.checkBuilderRequirement(this.a, GroupingAdvertsDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, GroupingAdvertsArguments.class);
            Preconditions.checkBuilderRequirement(this.c, Screen.class);
            Preconditions.checkBuilderRequirement(this.d, Resources.class);
            Preconditions.checkBuilderRequirement(this.g, RecyclerView.RecycledViewPool.class);
            return new DaggerGroupingAdvertsComponent(new AppendingLoaderModule(), this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, null);
        }

        @Override // com.avito.android.grouping_adverts.di.GroupingAdvertsComponent.Builder
        public GroupingAdvertsComponent.Builder dependentOn(GroupingAdvertsDependencies groupingAdvertsDependencies) {
            this.a = (GroupingAdvertsDependencies) Preconditions.checkNotNull(groupingAdvertsDependencies);
            return this;
        }

        @Override // com.avito.android.grouping_adverts.di.GroupingAdvertsComponent.Builder
        public GroupingAdvertsComponent.Builder withPresenterState(Kundle kundle) {
            this.e = kundle;
            return this;
        }

        @Override // com.avito.android.grouping_adverts.di.GroupingAdvertsComponent.Builder
        public GroupingAdvertsComponent.Builder withResources(Resources resources) {
            this.d = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.grouping_adverts.di.GroupingAdvertsComponent.Builder
        public GroupingAdvertsComponent.Builder withRichGalleryState(Kundle kundle) {
            this.f = kundle;
            return this;
        }

        @Override // com.avito.android.grouping_adverts.di.GroupingAdvertsComponent.Builder
        public GroupingAdvertsComponent.Builder withRichSnippetRecycledViewPool(RecyclerView.RecycledViewPool recycledViewPool) {
            this.g = (RecyclerView.RecycledViewPool) Preconditions.checkNotNull(recycledViewPool);
            return this;
        }

        @Override // com.avito.android.grouping_adverts.di.GroupingAdvertsComponent.Builder
        public GroupingAdvertsComponent.Builder withScreen(Screen screen) {
            this.c = (Screen) Preconditions.checkNotNull(screen);
            return this;
        }

        @Override // com.avito.android.grouping_adverts.di.GroupingAdvertsComponent.Builder
        public GroupingAdvertsComponent.Builder withSearchParams(GroupingAdvertsArguments groupingAdvertsArguments) {
            this.b = (GroupingAdvertsArguments) Preconditions.checkNotNull(groupingAdvertsArguments);
            return this;
        }

        @Override // com.avito.android.grouping_adverts.di.GroupingAdvertsComponent.Builder
        public GroupingAdvertsComponent.Builder withSerpOnboardingHandler(SerpOnboardingHandler serpOnboardingHandler) {
            this.h = null;
            return this;
        }
    }

    public static class c implements Provider<AccountStateProvider> {
        public final GroupingAdvertsDependencies a;

        public c(GroupingAdvertsDependencies groupingAdvertsDependencies) {
            this.a = groupingAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class d implements Provider<Analytics> {
        public final GroupingAdvertsDependencies a;

        public d(GroupingAdvertsDependencies groupingAdvertsDependencies) {
            this.a = groupingAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class e implements Provider<AsyncPhoneApi> {
        public final GroupingAdvertsDependencies a;

        public e(GroupingAdvertsDependencies groupingAdvertsDependencies) {
            this.a = groupingAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AsyncPhoneApi get() {
            return (AsyncPhoneApi) Preconditions.checkNotNullFromComponent(this.a.asyncPhoneApi());
        }
    }

    public static class f implements Provider<ConnectivityProvider> {
        public final GroupingAdvertsDependencies a;

        public f(GroupingAdvertsDependencies groupingAdvertsDependencies) {
            this.a = groupingAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ConnectivityProvider get() {
            return (ConnectivityProvider) Preconditions.checkNotNullFromComponent(this.a.connectivityProvider());
        }
    }

    public static class g implements Provider<DeepLinkFactory> {
        public final GroupingAdvertsDependencies a;

        public g(GroupingAdvertsDependencies groupingAdvertsDependencies) {
            this.a = groupingAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeepLinkFactory get() {
            return (DeepLinkFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkFactory());
        }
    }

    public static class h implements Provider<FavoriteAdvertsEventInteractor> {
        public final GroupingAdvertsDependencies a;

        public h(GroupingAdvertsDependencies groupingAdvertsDependencies) {
            this.a = groupingAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsEventInteractor get() {
            return (FavoriteAdvertsEventInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsEventInteractor());
        }
    }

    public static class i implements Provider<FavoriteAdvertsUploadInteractor> {
        public final GroupingAdvertsDependencies a;

        public i(GroupingAdvertsDependencies groupingAdvertsDependencies) {
            this.a = groupingAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsUploadInteractor get() {
            return (FavoriteAdvertsUploadInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsUploadInteractor());
        }
    }

    public static class j implements Provider<FavoritesApi> {
        public final GroupingAdvertsDependencies a;

        public j(GroupingAdvertsDependencies groupingAdvertsDependencies) {
            this.a = groupingAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoritesApi get() {
            return (FavoritesApi) Preconditions.checkNotNullFromComponent(this.a.favoritesApi());
        }
    }

    public static class k implements Provider<FavoritesSyncDao> {
        public final GroupingAdvertsDependencies a;

        public k(GroupingAdvertsDependencies groupingAdvertsDependencies) {
            this.a = groupingAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoritesSyncDao get() {
            return (FavoritesSyncDao) Preconditions.checkNotNullFromComponent(this.a.favoritesSyncDao());
        }
    }

    public static class l implements Provider<Features> {
        public final GroupingAdvertsDependencies a;

        public l(GroupingAdvertsDependencies groupingAdvertsDependencies) {
            this.a = groupingAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class m implements Provider<AbTestGroup<SimpleTestGroupWithControl2>> {
        public final GroupingAdvertsDependencies a;

        public m(GroupingAdvertsDependencies groupingAdvertsDependencies) {
            this.a = groupingAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AbTestGroup<SimpleTestGroupWithControl2> get() {
            return (AbTestGroup) Preconditions.checkNotNullFromComponent(this.a.justDialSellerPhoneTestGroup());
        }
    }

    public static class n implements Provider<Locale> {
        public final GroupingAdvertsDependencies a;

        public n(GroupingAdvertsDependencies groupingAdvertsDependencies) {
            this.a = groupingAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class o implements Provider<SerpItemsPrefetchTestGroup> {
        public final GroupingAdvertsDependencies a;

        public o(GroupingAdvertsDependencies groupingAdvertsDependencies) {
            this.a = groupingAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SerpItemsPrefetchTestGroup get() {
            return (SerpItemsPrefetchTestGroup) Preconditions.checkNotNullFromComponent(this.a.prefetchTestGroup());
        }
    }

    public static class p implements Provider<ExposedAbTestGroup<PriceOnTopTestGroup>> {
        public final GroupingAdvertsDependencies a;

        public p(GroupingAdvertsDependencies groupingAdvertsDependencies) {
            this.a = groupingAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ExposedAbTestGroup<PriceOnTopTestGroup> get() {
            return (ExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.priceOnTop());
        }
    }

    public static class q implements Provider<RandomKeyProvider> {
        public final GroupingAdvertsDependencies a;

        public q(GroupingAdvertsDependencies groupingAdvertsDependencies) {
            this.a = groupingAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public RandomKeyProvider get() {
            return (RandomKeyProvider) Preconditions.checkNotNullFromComponent(this.a.randomKeyProvider());
        }
    }

    public static class r implements Provider<SchedulersFactory3> {
        public final GroupingAdvertsDependencies a;

        public r(GroupingAdvertsDependencies groupingAdvertsDependencies) {
            this.a = groupingAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class s implements Provider<ScreenTrackerFactory> {
        public final GroupingAdvertsDependencies a;

        public s(GroupingAdvertsDependencies groupingAdvertsDependencies) {
            this.a = groupingAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class t implements Provider<SearchApi> {
        public final GroupingAdvertsDependencies a;

        public t(GroupingAdvertsDependencies groupingAdvertsDependencies) {
            this.a = groupingAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SearchApi get() {
            return (SearchApi) Preconditions.checkNotNullFromComponent(this.a.searchApi());
        }
    }

    public static class u implements Provider<SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup>> {
        public final GroupingAdvertsDependencies a;

        public u(GroupingAdvertsDependencies groupingAdvertsDependencies) {
            this.a = groupingAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup> get() {
            return (SingleManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.sellerInfoInRichSnippet());
        }
    }

    public static class v implements Provider<TimeSource> {
        public final GroupingAdvertsDependencies a;

        public v(GroupingAdvertsDependencies groupingAdvertsDependencies) {
            this.a = groupingAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public static class w implements Provider<TimerFactory> {
        public final GroupingAdvertsDependencies a;

        public w(GroupingAdvertsDependencies groupingAdvertsDependencies) {
            this.a = groupingAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimerFactory get() {
            return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
        }
    }

    public static class x implements Provider<TreeStateIdGenerator> {
        public final GroupingAdvertsDependencies a;

        public x(GroupingAdvertsDependencies groupingAdvertsDependencies) {
            this.a = groupingAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TreeStateIdGenerator get() {
            return (TreeStateIdGenerator) Preconditions.checkNotNullFromComponent(this.a.treeStateIdGenerator());
        }
    }

    public static class y implements Provider<TypedErrorThrowableConverter> {
        public final GroupingAdvertsDependencies a;

        public y(GroupingAdvertsDependencies groupingAdvertsDependencies) {
            this.a = groupingAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public static class z implements Provider<ViewedAdvertsDao> {
        public final GroupingAdvertsDependencies a;

        public z(GroupingAdvertsDependencies groupingAdvertsDependencies) {
            this.a = groupingAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ViewedAdvertsDao get() {
            return (ViewedAdvertsDao) Preconditions.checkNotNullFromComponent(this.a.viewedAdvertsDao());
        }
    }

    public DaggerGroupingAdvertsComponent(AppendingLoaderModule appendingLoaderModule, GroupingAdvertsDependencies groupingAdvertsDependencies, GroupingAdvertsArguments groupingAdvertsArguments, Screen screen, Resources resources, Kundle kundle, Kundle kundle2, RecyclerView.RecycledViewPool recycledViewPool, SerpOnboardingHandler serpOnboardingHandler, a aVar) {
        this.a = groupingAdvertsDependencies;
        this.b = InstanceFactory.create(groupingAdvertsArguments);
        this.c = new t(groupingAdvertsDependencies);
        this.d = new j(groupingAdvertsDependencies);
        this.e = new r(groupingAdvertsDependencies);
        n nVar = new n(groupingAdvertsDependencies);
        this.g = nVar;
        AdvertPriceFormatter_Factory create = AdvertPriceFormatter_Factory.create(nVar);
        this.h = create;
        this.i = DoubleCheck.provider(create);
        Factory create2 = InstanceFactory.create(resources);
        this.j = create2;
        FavoriteAdvertItemConverterResourceProviderImpl_Factory create3 = FavoriteAdvertItemConverterResourceProviderImpl_Factory.create(create2);
        this.k = create3;
        Provider<FavoriteAdvertItemConverterResourceProvider> provider = DoubleCheck.provider(create3);
        this.l = provider;
        l lVar = new l(groupingAdvertsDependencies);
        this.m = lVar;
        FavoriteAdvertItemConverterImpl_Factory create4 = FavoriteAdvertItemConverterImpl_Factory.create(this.i, provider, lVar);
        this.n = create4;
        Provider<FavoriteAdvertItemConverter> provider2 = DoubleCheck.provider(create4);
        this.o = provider2;
        GroupingAdvertsInteractorImpl_Factory create5 = GroupingAdvertsInteractorImpl_Factory.create(this.c, this.d, this.e, this.f, provider2);
        this.p = create5;
        this.q = DoubleCheck.provider(create5);
        d dVar = new d(groupingAdvertsDependencies);
        this.r = dVar;
        x xVar = new x(groupingAdvertsDependencies);
        this.s = xVar;
        this.t = DoubleCheck.provider(GroupingAdvertsModule_ProvideSerpAnalyticsInteractor$grouping_adverts_releaseFactory.create(dVar, xVar, this.m));
        Provider<HeaderPresenter> provider3 = SingleCheck.provider(HeaderPresenterImpl_Factory.create());
        this.u = provider3;
        this.v = HeaderBlueprint_Factory.create(provider3);
        this.w = new DelegateFactory();
        Factory createNullable = InstanceFactory.createNullable(serpOnboardingHandler);
        this.x = createNullable;
        this.y = SingleCheck.provider(AdvertItemPresenterModule_ProvideAdvertListItemPresenterFactory.create(this.w, this.r, this.m, createNullable));
        this.z = new v(groupingAdvertsDependencies);
        p pVar = new p(groupingAdvertsDependencies);
        this.A = pVar;
        o oVar = new o(groupingAdvertsDependencies);
        this.B = oVar;
        SerpItemAbViewConfig_Factory create6 = SerpItemAbViewConfig_Factory.create(pVar, oVar);
        this.C = create6;
        f fVar = new f(groupingAdvertsDependencies);
        this.D = fVar;
        this.E = SingleCheck.provider(AdvertItemModule_ProvideAdvertItemListBlueprintFactory.create(this.y, this.z, this.g, create6, fVar));
        DateTimeFormatterResourceProviderImpl_Factory create7 = DateTimeFormatterResourceProviderImpl_Factory.create(this.j);
        this.F = create7;
        this.G = DateTimeFormatterModule_ProvideUpperCaseDateTimeFormatterFactory.create(this.z, create7, this.g);
        this.H = InstanceFactory.createNullable(kundle2);
        AdvertSellerConverterImpl_Factory create8 = AdvertSellerConverterImpl_Factory.create(this.m);
        this.I = create8;
        this.J = SingleCheck.provider(create8);
        e eVar = new e(groupingAdvertsDependencies);
        this.K = eVar;
        AsyncPhoneInteractorImpl_Factory create9 = AsyncPhoneInteractorImpl_Factory.create(eVar, this.e);
        this.L = create9;
        this.M = SingleCheck.provider(create9);
        this.N = new y(groupingAdvertsDependencies);
        this.O = new s(groupingAdvertsDependencies);
        this.P = new w(groupingAdvertsDependencies);
        Factory create10 = InstanceFactory.create(screen);
        this.Q = create10;
        AsyncPhoneTrackerImpl_Factory create11 = AsyncPhoneTrackerImpl_Factory.create(this.O, this.P, create10);
        this.R = create11;
        Provider<AsyncPhoneTracker> provider4 = SingleCheck.provider(create11);
        this.S = provider4;
        c cVar = new c(groupingAdvertsDependencies);
        this.T = cVar;
        Provider<AsyncPhoneInteractor> provider5 = this.M;
        Provider<TypedErrorThrowableConverter> provider6 = this.N;
        AsyncPhonePresenterImpl_Factory create12 = AsyncPhonePresenterImpl_Factory.create(provider5, provider6, provider4, this.e, cVar, this.m, this.w, provider6);
        this.U = create12;
        Provider<AsyncPhonePresenter> provider7 = SingleCheck.provider(create12);
        this.V = provider7;
        u uVar = new u(groupingAdvertsDependencies);
        this.W = uVar;
        AdvertRichItemPresenterImpl_Factory create13 = AdvertRichItemPresenterImpl_Factory.create(this.w, this.G, this.r, this.H, this.J, provider7, uVar, this.m, this.x);
        this.X = create13;
        this.Y = SingleCheck.provider(create13);
        this.Z = InstanceFactory.create(recycledViewPool);
        SellerInfoParamsFactoryImpl_Factory create14 = SellerInfoParamsFactoryImpl_Factory.create(this.j, this.W);
        this.a0 = create14;
        Provider<SellerInfoParamsFactory> provider8 = SingleCheck.provider(create14);
        this.b0 = provider8;
        this.c0 = AdvertRichSmallItemBlueprint_Factory.create(this.Y, this.Z, this.m, provider8, this.B);
        Provider<AdvertGridItemPresenter> provider9 = SingleCheck.provider(AdvertItemPresenterModule_ProvideAdvertGridItemPresenterFactory.create(this.w, this.r, this.m, this.x));
        this.d0 = provider9;
        this.e0 = SingleCheck.provider(AdvertItemModule_ProvideAdvertItemGridBlueprintFactory.create(provider9, this.z, this.g, this.C, this.D));
        Provider<AppendingLoaderItemPresenter> provider10 = DoubleCheck.provider(AppendingLoaderModule_ProvideAppendingLoaderItemPresenterFactory.create(appendingLoaderModule));
        this.f0 = provider10;
        this.g0 = DoubleCheck.provider(AppendingLoaderModule_ProvideAppendingLoaderItemBlueprintFactory.create(appendingLoaderModule, provider10));
        RichSnippetsResourceProviderImpl_Factory create15 = RichSnippetsResourceProviderImpl_Factory.create(this.j);
        this.h0 = create15;
        Provider<RichSnippetsResourceProvider> provider11 = SingleCheck.provider(create15);
        this.i0 = provider11;
        AdvertXlRichItemPresenterImpl_Factory create16 = AdvertXlRichItemPresenterImpl_Factory.create(this.w, this.G, provider11, this.r, this.J, this.V, this.m, this.x, this.W, this.H);
        this.j0 = create16;
        Provider<AdvertXlRichItemPresenter> provider12 = SingleCheck.provider(create16);
        this.k0 = provider12;
        AdvertXlRichItemBlueprint_Factory create17 = AdvertXlRichItemBlueprint_Factory.create(provider12, this.Z, this.m, this.b0, this.B);
        this.l0 = create17;
        Provider<ItemBinder> provider13 = DoubleCheck.provider(GroupingAdvertsModule_ProvideItemBinder$grouping_adverts_releaseFactory.create(this.v, this.E, this.c0, this.e0, this.g0, create17));
        this.m0 = provider13;
        this.n0 = DoubleCheck.provider(GroupingAdvertsModule_ProvideAdapterPresenter$grouping_adverts_releaseFactory.create(provider13));
        this.o0 = new k(groupingAdvertsDependencies);
        this.p0 = new i(groupingAdvertsDependencies);
        this.q0 = new h(groupingAdvertsDependencies);
        FavoriteAdvertsAnalyticsInteractorImpl_Factory create18 = FavoriteAdvertsAnalyticsInteractorImpl_Factory.create(this.r, this.T);
        this.r0 = create18;
        this.s0 = FavoriteAdvertsInteractorImpl_Factory.create(this.o0, this.p0, this.q0, create18, this.e);
        Provider<FavoriteAdvertsResourceProvider> provider14 = SingleCheck.provider(FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsResourceProvider$favorite_core_releaseFactory.create(this.j));
        this.t0 = provider14;
        this.u0 = SingleCheck.provider(FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsPresenter$favorite_core_releaseFactory.create(this.s0, this.e, provider14));
        this.v0 = SingleCheck.provider(SerpItemConverterModule_ProvideItemAdvertSpanCountProviderFactory.create(this.j));
        Provider<AdvertSpanCountProvider> provider15 = SingleCheck.provider(SerpItemConverterModule_ProvideBigAdvertSpanCountProviderFactory.create(this.j));
        this.w0 = provider15;
        this.x0 = SingleCheck.provider(SerpItemConverterModule_ProvideAdvertConverterFactory.create(this.v0, provider15, this.j, this.m));
        this.y0 = SingleCheck.provider(SerpItemConverterModule_ProvideAdvertXlConverterFactory.create(this.j, this.m));
        Provider<AdResourceProvider> provider16 = DoubleCheck.provider(AdResourceProviderImpl_Factory.create());
        this.z0 = provider16;
        q qVar = new q(groupingAdvertsDependencies);
        this.A0 = qVar;
        this.B0 = SingleCheck.provider(SerpItemConverterModule_ProvideCommercialConverterFactory.create(this.v0, this.w0, provider16, qVar));
        g gVar = new g(groupingAdvertsDependencies);
        this.C0 = gVar;
        this.D0 = SingleCheck.provider(SerpItemConverterModule_ProvideShortcutBannerConverterFactory.create(gVar, this.j));
        this.E0 = SingleCheck.provider(SerpItemConverterModule_ProvideSerpWarningConverterFactory.create());
        this.F0 = SingleCheck.provider(SerpItemConverterModule_ProvideSnippetConverterFactory.create());
        this.G0 = SingleCheck.provider(SerpItemConverterModule_ProvideSerpEmptySearchConverterFactory.create());
        this.H0 = SingleCheck.provider(SerpItemConverterModule_ProvideGroupTitleItemConverterFactory.create());
        this.I0 = SingleCheck.provider(SerpItemConverterModule_ProvideEmptyPlaceholderItemConverterFactory.create());
        this.J0 = SingleCheck.provider(SerpItemConverterModule_ProvideHeaderElementConverterFactory.create());
        this.K0 = SingleCheck.provider(SerpItemConverterModule_ProvideFavoriteStatusResolverFactory.create(this.s0));
        this.L0 = new z(groupingAdvertsDependencies);
        this.M0 = new a0(groupingAdvertsDependencies);
        Provider<ViewedAdvertsInteractor> provider17 = SingleCheck.provider(ViewedAdvertsModule_ProvideViewedAdvertsInteractorFactory.create(ViewedAdvertsInteractorFactoryImpl_Factory.create(), this.L0, this.e, this.M0, this.m));
        this.N0 = provider17;
        Provider<ViewedStatusResolver> provider18 = SingleCheck.provider(ViewedAdvertsModule_ProvideViewedStatusResolverFactory.create(provider17));
        this.O0 = provider18;
        this.P0 = SingleCheck.provider(SerpItemConverterModule_ProvideWitcherElementConverterFactory.create(this.x0, this.K0, provider18));
        this.Q0 = SingleCheck.provider(SerpItemConverterModule_ProvideLocationNotificationConverterFactory.create());
        this.R0 = SingleCheck.provider(SerpItemConverterModule_ProvideSellerElementConverterFactory.create());
        this.S0 = SingleCheck.provider(SerpItemConverterModule_ProvideReportBannerConverterFactory.create(this.j, this.m));
        this.T0 = SingleCheck.provider(SerpItemConverterModule_ProvidePromoCardConverterFactory.create(this.j, this.m));
        this.U0 = SingleCheck.provider(SerpItemConverterModule_ProvideMapBannerConverterFactory.create());
        Provider<VerticalFilterItemConverter> provider19 = SingleCheck.provider(SerpItemConverterModule_ProvideVerticalFilterItemConverterFactory.create());
        this.V0 = provider19;
        this.W0 = SingleCheck.provider(SerpItemConverterModule_ProvideElementItemConverterFactory.create(this.x0, this.y0, this.B0, this.D0, this.E0, this.F0, this.G0, this.H0, this.I0, this.J0, this.P0, this.Q0, this.R0, this.S0, this.T0, this.U0, provider19));
        this.X0 = SingleCheck.provider(SerpItemConverterModule_ProvideSerpItemSorterFactory.create());
        Provider<SerpItemSizeAdjuster> provider20 = SingleCheck.provider(SerpItemConverterModule_ProvideItemSizeAdjusterFactory.create());
        this.Y0 = provider20;
        this.Z0 = SingleCheck.provider(SerpItemConverterModule_ProvideSerpItemProcessorFactory.create(this.W0, this.X0, provider20, this.K0, this.O0, this.e));
        this.a1 = SingleCheck.provider(ViewedAdvertsModule_ProvideViewedAdvertsPresenterFactory.create(this.M0, this.e));
        Provider<SpannedGridPositionProvider> provider21 = SingleCheck.provider(SpanAdapterModule_ProvideSpannedGridPositionProviderFactory.create(this.j));
        this.b1 = provider21;
        this.c1 = SingleCheck.provider(SpanAdapterModule_ProvideSerpSpanProviderFactory.create(provider21, this.j));
        GroupingAdvertsResourcesProviderImpl_Factory create19 = GroupingAdvertsResourcesProviderImpl_Factory.create(this.j);
        this.d1 = create19;
        this.e1 = DoubleCheck.provider(create19);
        SimpleClickStreamLinkHandler_Factory create20 = SimpleClickStreamLinkHandler_Factory.create(this.r);
        this.f1 = create20;
        this.g1 = DoubleCheck.provider(create20);
        this.h1 = new m(groupingAdvertsDependencies);
        GroupingAdvertsItemsFilterImpl_Factory create21 = GroupingAdvertsItemsFilterImpl_Factory.create(this.m0);
        this.i1 = create21;
        this.j1 = DoubleCheck.provider(create21);
        this.k1 = InstanceFactory.createNullable(kundle);
        GroupingAdvertsPresenterImpl_Factory create22 = GroupingAdvertsPresenterImpl_Factory.create(this.b, this.q, this.t, this.e, this.n0, this.u0, this.Z0, this.a1, this.c1, this.b1, this.e1, this.g1, PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory.create(), this.r, this.h1, this.V, this.j1, this.k1);
        this.l1 = create22;
        DelegateFactory.setDelegate(this.w, DoubleCheck.provider(create22));
        SpanLookup_Factory create23 = SpanLookup_Factory.create(this.c1);
        this.m1 = create23;
        this.n1 = SingleCheck.provider(create23);
        this.o1 = DoubleCheck.provider(GroupingAdvertsModule_ProvideAppendingHandler$grouping_adverts_releaseFactory.create(this.b1, this.w));
        this.p1 = SingleCheck.provider(this.j0);
        SetFactory build = SetFactory.builder(2, 0).addProvider(this.Y).addProvider(this.p1).build();
        this.q1 = build;
        RichSnippetStateProviderProxy_Factory create24 = RichSnippetStateProviderProxy_Factory.create(build);
        this.r1 = create24;
        this.s1 = SingleCheck.provider(create24);
        GroupingAdvertsTrackerImpl_Factory create25 = GroupingAdvertsTrackerImpl_Factory.create(this.O, this.P);
        this.t1 = create25;
        this.u1 = DoubleCheck.provider(create25);
    }

    public static GroupingAdvertsComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.grouping_adverts.di.GroupingAdvertsComponent
    public void inject(GroupingAdvertsFragment groupingAdvertsFragment) {
        GroupingAdvertsFragment_MembersInjector.injectPresenter(groupingAdvertsFragment, this.w.get());
        GroupingAdvertsFragment_MembersInjector.injectAdapterPresenter(groupingAdvertsFragment, this.n0.get());
        GroupingAdvertsFragment_MembersInjector.injectItemBinder(groupingAdvertsFragment, this.m0.get());
        GroupingAdvertsFragment_MembersInjector.injectDeepLinkIntentFactory(groupingAdvertsFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        GroupingAdvertsFragment_MembersInjector.injectActivityIntentFactory(groupingAdvertsFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        GroupingAdvertsFragment_MembersInjector.injectAnalytics(groupingAdvertsFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        GroupingAdvertsFragment_MembersInjector.injectFavoriteAdvertsPresenter(groupingAdvertsFragment, this.u0.get());
        GroupingAdvertsFragment_MembersInjector.injectViewedAdvertsPresenter(groupingAdvertsFragment, this.a1.get());
        GroupingAdvertsFragment_MembersInjector.injectAsyncPhonePresenter(groupingAdvertsFragment, this.V.get());
        GroupingAdvertsFragment_MembersInjector.injectSpanLookup(groupingAdvertsFragment, this.n1.get());
        GroupingAdvertsFragment_MembersInjector.injectGridPositionProvider(groupingAdvertsFragment, this.b1.get());
        GroupingAdvertsFragment_MembersInjector.injectAppendingHandler(groupingAdvertsFragment, this.o1.get());
        GroupingAdvertsFragment_MembersInjector.injectRichSnippetStateProvider(groupingAdvertsFragment, this.s1.get());
        GroupingAdvertsFragment_MembersInjector.injectTracker(groupingAdvertsFragment, this.u1.get());
    }
}
