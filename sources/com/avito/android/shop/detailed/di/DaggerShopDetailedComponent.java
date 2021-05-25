package com.avito.android.shop.detailed.di;

import android.content.Context;
import android.content.res.Resources;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.FavoriteSellersRepository;
import com.avito.android.Features;
import com.avito.android.ab_tests.configs.PriceOnTopTestGroup;
import com.avito.android.ab_tests.configs.SerpItemsPrefetchTestGroup;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert.viewed.ViewedAdvertsEventInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsInteractorFactoryImpl_Factory;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.advert.viewed.ViewedAdvertsPresenterImpl;
import com.avito.android.advert.viewed.ViewedAdvertsPresenterImpl_Factory;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.FavoriteAdvertsAnalyticsInteractorImpl;
import com.avito.android.analytics.FavoriteAdvertsAnalyticsInteractorImpl_Factory;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.cart_fab.CartFabModule_ProvideCartFabViewModelFactory;
import com.avito.android.cart_fab.CartFabPreferences;
import com.avito.android.cart_fab.CartFabPreferencesImpl;
import com.avito.android.cart_fab.CartFabPreferencesImpl_Factory;
import com.avito.android.cart_fab.CartFabQuantityVisibilityHandler_Factory;
import com.avito.android.cart_fab.CartFabRepository;
import com.avito.android.cart_fab.CartFabRepositoryImpl;
import com.avito.android.cart_fab.CartFabRepositoryImpl_Factory;
import com.avito.android.cart_fab.CartFabViewModel;
import com.avito.android.cart_fab.CartFabViewModelFactory;
import com.avito.android.cart_fab.CartFabViewModelFactory_Factory;
import com.avito.android.cart_fab.CartQuantityChangesHandler;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.db.favorites.FavoritesSyncDao;
import com.avito.android.db.viewed.ViewedAdvertsDao;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.ViewedAdvertsModule_ProvideViewedAdvertsInteractorFactory;
import com.avito.android.di.ViewedAdvertsModule_ProvideViewedAdvertsPresenterFactory;
import com.avito.android.di.ViewedAdvertsModule_ProvideViewedStatusResolverFactory;
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
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.error_helper.ErrorHelperImpl;
import com.avito.android.error_helper.ErrorHelperImpl_Factory;
import com.avito.android.favorite.FavoriteAdvertsEventInteractor;
import com.avito.android.favorite.FavoriteAdvertsInteractorImpl;
import com.avito.android.favorite.FavoriteAdvertsInteractorImpl_Factory;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsPresenterImpl;
import com.avito.android.favorite.FavoriteAdvertsPresenterImpl_Factory;
import com.avito.android.favorite.FavoriteAdvertsResourceProvider;
import com.avito.android.favorite.FavoriteAdvertsUploadInteractor;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarModule_ProvideCompositeSnackbarPresenterFactory;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.notification_manager_provider.NotificationManagerModule;
import com.avito.android.notification_manager_provider.NotificationManagerModule_ProvideNotificationManagerProviderFactory;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.public_profile.ui.SubscriptionsPresenter;
import com.avito.android.public_profile.ui.SubscriptionsResourceProvider;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistry;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.remote.FavoriteSellersApi;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.cart.CartApi;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.SearchParamsConverterImpl_Factory;
import com.avito.android.section.SectionResourceProvider;
import com.avito.android.section.SectionResourceProviderImpl;
import com.avito.android.section.SectionResourceProviderImpl_Factory;
import com.avito.android.section.di.SectionAdvertItemsModule_ProvideSectionAdvertItemPresenter$serp_core_releaseFactory;
import com.avito.android.section.di.SectionAdvertItemsModule_ProvideSectionItemWidthProvider$serp_core_releaseFactory;
import com.avito.android.section.item.SectionAdvertItemBlueprint;
import com.avito.android.section.item.SectionAdvertItemBlueprintImpl;
import com.avito.android.section.item.SectionAdvertItemBlueprintImpl_Factory;
import com.avito.android.section.item.SectionAdvertItemDoubleBlueprint;
import com.avito.android.section.item.SectionAdvertItemDoubleBlueprintImpl;
import com.avito.android.section.item.SectionAdvertItemDoubleBlueprintImpl_Factory;
import com.avito.android.section.item.SectionAdvertItemPresenter;
import com.avito.android.section.item.SectionItemWidthProvider;
import com.avito.android.serp.InlineFiltersChangesParamsConverter;
import com.avito.android.serp.InlineFiltersChangesParamsConverterImpl_Factory;
import com.avito.android.serp.InlineFiltersInteractor;
import com.avito.android.serp.InlineFiltersInteractorImpl;
import com.avito.android.serp.InlineFiltersInteractorImpl_Factory;
import com.avito.android.serp.InlineFiltersParametersKeyWrapper_Factory;
import com.avito.android.serp.ad.AdResourceProvider;
import com.avito.android.serp.ad.AdResourceProviderImpl_Factory;
import com.avito.android.serp.adapter.AdvertGridItemPresenter;
import com.avito.android.serp.adapter.AdvertItemDoubleBlueprint;
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
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.ShortcutBannerConverter;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.ViewedStatusResolver;
import com.avito.android.serp.adapter.advert_xl.SerpAdvertXlConverter;
import com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemConverter;
import com.avito.android.serp.adapter.empty_search.EmptySearchItemConverter;
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
import com.avito.android.shop.detailed.NoItemsFoundHeightProvider;
import com.avito.android.shop.detailed.NoItemsFoundHeightProviderImpl;
import com.avito.android.shop.detailed.NoItemsFoundHeightProviderImpl_Factory;
import com.avito.android.shop.detailed.ShopAdvertsResourceProvider;
import com.avito.android.shop.detailed.ShopAdvertsResourceProviderImpl;
import com.avito.android.shop.detailed.ShopAdvertsResourceProviderImpl_Factory;
import com.avito.android.shop.detailed.ShopAndSubscribeInteractor;
import com.avito.android.shop.detailed.ShopDetailedFragment;
import com.avito.android.shop.detailed.ShopDetailedFragment_MembersInjector;
import com.avito.android.shop.detailed.ShopDetailedImageHeightProvider;
import com.avito.android.shop.detailed.ShopDetailedImageHeightProviderImpl;
import com.avito.android.shop.detailed.ShopDetailedImageHeightProviderImpl_Factory;
import com.avito.android.shop.detailed.ShopDetailedInteractorImpl;
import com.avito.android.shop.detailed.ShopDetailedInteractorImpl_Factory;
import com.avito.android.shop.detailed.ShopDetailedItemsConverter;
import com.avito.android.shop.detailed.ShopDetailedItemsConverterImpl;
import com.avito.android.shop.detailed.ShopDetailedItemsConverterImpl_Factory;
import com.avito.android.shop.detailed.ShopDetailedPresenter;
import com.avito.android.shop.detailed.ShopDetailedPresenterImpl;
import com.avito.android.shop.detailed.ShopDetailedPresenterImpl_Factory;
import com.avito.android.shop.detailed.ShopItemVisibilityTracker;
import com.avito.android.shop.detailed.ShopItemVisibilityTrackerImpl;
import com.avito.android.shop.detailed.ShopItemVisibilityTrackerImpl_Factory;
import com.avito.android.shop.detailed.di.ShopDetailedComponent;
import com.avito.android.shop.detailed.item.AdvertsCountCaptionBlueprint;
import com.avito.android.shop.detailed.item.AdvertsCountCaptionItemPresenter;
import com.avito.android.shop.detailed.item.AdvertsCountCaptionItemPresenter_Factory;
import com.avito.android.shop.detailed.item.NoItemsFoundBlueprint;
import com.avito.android.shop.detailed.item.NoItemsFoundItemPresenter;
import com.avito.android.shop.detailed.item.NoItemsFoundItemPresenterImpl;
import com.avito.android.shop.detailed.item.NoItemsFoundItemPresenterImpl_Factory;
import com.avito.android.shop.detailed.item.ShopAdvertGridItemPresenter;
import com.avito.android.shop.detailed.item.ShopAdvertGridItemPresenter_Factory;
import com.avito.android.shop.detailed.item.ShopAdvertListItemPresenter;
import com.avito.android.shop.detailed.item.ShopAdvertListItemPresenter_Factory;
import com.avito.android.shop.detailed.item.ShopGoldBlueprint;
import com.avito.android.shop.detailed.item.ShopGoldBlueprint_Factory;
import com.avito.android.shop.detailed.item.ShopGoldHeaderBlueprint;
import com.avito.android.shop.detailed.item.ShopGoldHeaderBlueprint_Factory;
import com.avito.android.shop.detailed.item.ShopGoldHeaderItemPresenter;
import com.avito.android.shop.detailed.item.ShopGoldHeaderItemPresenterImpl;
import com.avito.android.shop.detailed.item.ShopGoldHeaderItemPresenterImpl_Factory;
import com.avito.android.shop.detailed.item.ShopGoldItemPresenter;
import com.avito.android.shop.detailed.item.ShopGoldItemPresenterImpl;
import com.avito.android.shop.detailed.item.ShopGoldItemPresenterImpl_Factory;
import com.avito.android.shop.detailed.item.ShopGoldResourceProvider;
import com.avito.android.shop.detailed.item.ShopGoldResourceProviderImpl;
import com.avito.android.shop.detailed.item.ShopGoldResourceProviderImpl_Factory;
import com.avito.android.shop.detailed.item.ShopItemRatingPresenter;
import com.avito.android.shop.detailed.item.ShopRegularBlueprint;
import com.avito.android.shop.detailed.item.ShopRegularBlueprint_Factory;
import com.avito.android.shop.detailed.item.ShopRegularItemPresenter;
import com.avito.android.shop.detailed.item.ShopRegularItemPresenterImpl;
import com.avito.android.shop.detailed.item.ShopRegularItemPresenterImpl_Factory;
import com.avito.android.shop.detailed.item.ShopRegularResourceProvider;
import com.avito.android.shop.detailed.item.ShopRegularResourceProviderImpl;
import com.avito.android.shop.detailed.item.ShopRegularResourceProviderImpl_Factory;
import com.avito.android.shop.detailed.item.ShopSubscriptionsResourceProvider;
import com.avito.android.shop.detailed.item.ShopSubscriptionsResourceProvider_Factory;
import com.avito.android.shop.detailed.item.ShowcaseBlueprint;
import com.avito.android.shop.detailed.item.ShowcaseBlueprint_Factory;
import com.avito.android.shop.detailed.item.ShowcaseItemPresenter;
import com.avito.android.shop.detailed.item.ShowcaseItemPresenterImpl;
import com.avito.android.shop.detailed.item.ShowcaseItemPresenterImpl_Factory;
import com.avito.android.shop.detailed.tracker.ShopDetailedTracker;
import com.avito.android.shop.detailed.tracker.ShopDetailedTrackerImpl;
import com.avito.android.shop.detailed.tracker.ShopDetailedTrackerImpl_Factory;
import com.avito.android.shop.remote.ShopsApi;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.Formatter;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Kundle;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.SearchContextWrapper;
import com.avito.android.util.preferences.Preferences;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.google.common.base.Optional;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.Locale;
import javax.inject.Provider;
public final class DaggerShopDetailedComponent implements ShopDetailedComponent {
    public Provider<Resources> A;
    public Provider<ShopGoldItemPresenter> A0;
    public Provider<PromoCardConverter> A1;
    public Provider<SectionResourceProviderImpl> B;
    public Provider<ShopGoldBlueprint> B0;
    public Provider<MapBannerItemConverter> B1;
    public Provider<SectionResourceProvider> C;
    public Provider<ShopDetailedImageHeightProviderImpl> C0;
    public Provider<VerticalFilterItemConverter> C1;
    public Provider<SectionItemWidthProvider> D;
    public Provider<ShopDetailedImageHeightProvider> D0;
    public Provider<SerpElementItemConverter> D1;
    public Provider<SectionAdvertItemPresenter> E;
    public Provider<ShopGoldHeaderItemPresenterImpl> E0;
    public Provider<ShopDetailedItemsConverterImpl> E1;
    public Provider<SectionAdvertItemBlueprintImpl> F;
    public Provider<ShopGoldHeaderItemPresenter> F0;
    public Provider<ShopDetailedItemsConverter> F1;
    public Provider<SectionAdvertItemBlueprint> G;
    public Provider<ShopGoldHeaderBlueprint> G0;
    public Provider<TreeStateIdGenerator> G1;
    public Provider<SectionAdvertItemDoubleBlueprintImpl> H;
    public Provider<ShopRegularResourceProviderImpl> H0;
    public Provider<TreeClickStreamParent> H1;
    public Provider<SectionAdvertItemDoubleBlueprint> I;
    public Provider<ShopRegularResourceProvider> I0;
    public Provider<Kundle> I1;
    public Provider<ItemBinder> J;
    public Provider<Kundle> J0;
    public Provider<ScreenTrackerFactory> J1;
    public Provider<AdapterPresenter> K;
    public Provider<ShopRegularItemPresenterImpl> K0;
    public Provider<TimerFactory> K1;
    public Provider<FavoritesSyncDao> L;
    public Provider<ShopRegularItemPresenter> L0;
    public Provider<ScreenDiInjectTracker> L1;
    public Provider<FavoriteAdvertsUploadInteractor> M;
    public Provider<ShopRegularBlueprint> M0;
    public Provider<ScreenInitTracker> M1;
    public Provider<FavoriteAdvertsEventInteractor> N;
    public Provider<AdvertsCountCaptionItemPresenter> N0;
    public Provider<ScreenFlowTrackerProvider> N1;
    public Provider<AccountStateProvider> O;
    public Provider<AdvertsCountCaptionBlueprint> O0;
    public Provider<ShopDetailedTrackerImpl> O1;
    public Provider<FavoriteAdvertsAnalyticsInteractorImpl> P;
    public Provider<NoItemsFoundHeightProviderImpl> P0;
    public Provider<ShopDetailedTracker> P1;
    public Provider<SchedulersFactory3> Q;
    public Provider<NoItemsFoundHeightProvider> Q0;
    public Provider<MutableLiveData<String>> Q1;
    public Provider<FavoriteAdvertsInteractorImpl> R;
    public Provider<NoItemsFoundItemPresenterImpl> R0;
    public Provider<ShopDetailedPresenterImpl> R1;
    public Provider<FavoriteAdvertsResourceProvider> S;
    public Provider<NoItemsFoundItemPresenter> S0;
    public Provider<DestroyableViewHolderBuilder> S1;
    public Provider<FavoriteAdvertsPresenterImpl> T;
    public Provider<NoItemsFoundBlueprint> T0;
    public Provider<GridLayoutManager.SpanSizeLookup> T1;
    public Provider<ViewedAdvertsEventInteractor> U;
    public Provider<ItemBinder> U0;
    public Provider<Fragment> U1;
    public Provider<ViewedAdvertsPresenterImpl> V;
    public Provider<AdapterPresenter> V0;
    public Provider<ViewModelStoreOwner> V1;
    public Provider<ShowcaseBlueprint> W;
    public Provider<SpannedGridPositionProvider> W0;
    public Provider<CartApi> W1;
    public Provider<Context> X;
    public Provider<SerpSpanProvider> X0;
    public Provider<CartFabRepositoryImpl> X1;
    public Provider<NotificationManagerCompat> Y;
    public Provider<ShopAdvertsResourceProviderImpl> Y0;
    public Provider<CartFabRepository> Y1;
    public Provider<NotificationManagerProvider> Z;
    public Provider<ShopAdvertsResourceProvider> Z0;
    public Provider<Preferences> Z1;
    public final ShopDetailedDependencies a;
    public Provider<FavoriteSellersRepository> a0;
    public Provider<Formatter<Throwable>> a1;

    /* renamed from: a2  reason: collision with root package name */
    public Provider<CartFabPreferencesImpl> f59a2;
    public Provider<String> b;
    public Provider<ShopSubscriptionsResourceProvider> b0;
    public Provider<FavoriteAdvertsPresenter> b1;
    public Provider<CartFabPreferences> b2;
    public Provider<SearchParams> c;
    public Provider<SubscriptionsResourceProvider> c0;
    public Provider<ViewedAdvertsPresenter> c1;
    public Provider<SearchContextWrapper> c2;
    public Provider<ShopDetailedPresenter> d = new DelegateFactory();
    public Provider<String> d0;
    public Provider<AdvertSpanCountProvider> d1;
    public Provider<Optional<SearchContextWrapper>> d2;
    public Provider<Analytics> e;
    public Provider<String> e0;
    public Provider<AdvertSpanCountProvider> e1;
    public Provider<CartFabViewModelFactory> e2;
    public Provider<Features> f;
    public Provider<ShopsApi> f0;
    public Provider<SerpAdvertConverter> f1;
    public Provider<CartFabViewModel> f2;
    public Provider<SerpOnboardingHandler> g;
    public Provider<SearchApi> g0;
    public Provider<SerpAdvertXlConverter> g1;
    public Provider<CartQuantityChangesHandler> g2;
    public Provider<AdvertGridItemPresenter> h;
    public Provider<FavoriteSellersApi> h0;
    public Provider<AdResourceProvider> h1;
    public Provider<CallableResponsiveItemPresenterRegistry> h2;
    public Provider<TimeSource> i;
    public Provider<SearchParamsConverter> i0;
    public Provider<RandomKeyProvider> i1;
    public Provider<ResponsiveAdapterPresenter> i2;
    public Provider<ShopItemVisibilityTrackerImpl> j;
    public Provider<InlineFiltersChangesParamsConverter> j0;
    public Provider<SerpCommercialBannerConverter> j1;
    public Provider<ShopItemVisibilityTracker> k;
    public Provider<InlineFiltersInteractorImpl> k0;
    public Provider<DeepLinkFactory> k1;
    public Provider<ShopAdvertGridItemPresenter> l;
    public Provider<InlineFiltersInteractor> l0;
    public Provider<ShortcutBannerConverter> l1;
    public Provider<Locale> m;
    public Provider<Kundle> m0;
    public Provider<SerpWarningConverter> m1;
    public Provider<ExposedAbTestGroup<PriceOnTopTestGroup>> n;
    public Provider<ShopDetailedInteractorImpl> n0;
    public Provider<SnippetConverter> n1;
    public Provider<SerpItemsPrefetchTestGroup> o;
    public Provider<ShopAndSubscribeInteractor> o0;
    public Provider<EmptySearchItemConverter> o1;
    public Provider<SerpItemAbViewConfig> p;
    public Provider<ErrorFormatterImpl> p0;
    public Provider<GroupTitleItemConverter> p1;
    public Provider<ConnectivityProvider> q;
    public Provider<ErrorFormatter> q0;
    public Provider<EmptyPlaceholderItemConverter> q1;
    public Provider<AdvertItemGridBlueprint> r;
    public Provider<ErrorHelperImpl> r0;
    public Provider<HeaderElementConverter> r1;
    public Provider<AdvertItemDoubleBlueprint> s;
    public Provider<ErrorHelper> s0;
    public Provider<FavoriteStatusResolver> s1;
    public Provider<AdvertListItemPresenter> t;
    public Provider<CompositeSnackbarPresenter> t0;
    public Provider<ViewedAdvertsDao> t1;
    public Provider<ShopAdvertListItemPresenter> u;
    public Provider<SubscriptionsPresenter> u0;
    public Provider<ViewedAdvertsInteractor> u1;
    public Provider<AdvertItemListBlueprint> v;
    public Provider<ShopItemRatingPresenter> v0;
    public Provider<ViewedStatusResolver> v1;
    public Provider<Kundle> w;
    public Provider<ShopGoldResourceProviderImpl> w0;
    public Provider<WitcherElementConverter> w1;
    public Provider<ShowcaseItemPresenterImpl> x;
    public Provider<ShopGoldResourceProvider> x0;
    public Provider<LocationNotificationItemConverter> x1;
    public Provider<ShowcaseItemPresenter> y;
    public Provider<Kundle> y0;
    public Provider<SellerElementConverter> y1;
    public Provider<DeviceMetrics> z;
    public Provider<ShopGoldItemPresenterImpl> z0;
    public Provider<ReportBannerConverter> z1;

    public static class a0 implements Provider<TimerFactory> {
        public final ShopDetailedDependencies a;

        public a0(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimerFactory get() {
            return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
        }
    }

    public static final class b implements ShopDetailedComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.shop.detailed.di.ShopDetailedComponent.Factory
        public ShopDetailedComponent create(String str, String str2, String str3, SearchParams searchParams, Kundle kundle, Kundle kundle2, TreeClickStreamParent treeClickStreamParent, MutableLiveData<String> mutableLiveData, Resources resources, Fragment fragment, SerpOnboardingHandler serpOnboardingHandler, ShopDetailedDependencies shopDetailedDependencies, ShopDetailedModule shopDetailedModule) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(searchParams);
            Preconditions.checkNotNull(mutableLiveData);
            Preconditions.checkNotNull(resources);
            Preconditions.checkNotNull(fragment);
            Preconditions.checkNotNull(shopDetailedDependencies);
            Preconditions.checkNotNull(shopDetailedModule);
            return new DaggerShopDetailedComponent(shopDetailedModule, new NotificationManagerModule(), shopDetailedDependencies, str, str2, str3, searchParams, kundle, kundle2, treeClickStreamParent, mutableLiveData, resources, fragment, null, null);
        }
    }

    public static class b0 implements Provider<TreeStateIdGenerator> {
        public final ShopDetailedDependencies a;

        public b0(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TreeStateIdGenerator get() {
            return (TreeStateIdGenerator) Preconditions.checkNotNullFromComponent(this.a.treeStateIdGenerator());
        }
    }

    public static final class c<T> implements Provider<Optional<T>> {
        public final Provider<T> a;

        public c(Provider<T> provider) {
            this.a = (Provider) Preconditions.checkNotNull(provider);
        }

        @Override // javax.inject.Provider
        public Object get() {
            return Optional.of(this.a.get());
        }
    }

    public static class c0 implements Provider<ViewedAdvertsDao> {
        public final ShopDetailedDependencies a;

        public c0(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ViewedAdvertsDao get() {
            return (ViewedAdvertsDao) Preconditions.checkNotNullFromComponent(this.a.viewedAdvertsDao());
        }
    }

    public static class d implements Provider<AccountStateProvider> {
        public final ShopDetailedDependencies a;

        public d(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class d0 implements Provider<ViewedAdvertsEventInteractor> {
        public final ShopDetailedDependencies a;

        public d0(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ViewedAdvertsEventInteractor get() {
            return (ViewedAdvertsEventInteractor) Preconditions.checkNotNullFromComponent(this.a.viewedAdvertsEventInteractor());
        }
    }

    public static class e implements Provider<Analytics> {
        public final ShopDetailedDependencies a;

        public e(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class f implements Provider<CartApi> {
        public final ShopDetailedDependencies a;

        public f(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CartApi get() {
            return (CartApi) Preconditions.checkNotNullFromComponent(this.a.cartApi());
        }
    }

    public static class g implements Provider<ConnectivityProvider> {
        public final ShopDetailedDependencies a;

        public g(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ConnectivityProvider get() {
            return (ConnectivityProvider) Preconditions.checkNotNullFromComponent(this.a.connectivityProvider());
        }
    }

    public static class h implements Provider<Context> {
        public final ShopDetailedDependencies a;

        public h(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public static class i implements Provider<DeepLinkFactory> {
        public final ShopDetailedDependencies a;

        public i(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeepLinkFactory get() {
            return (DeepLinkFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkFactory());
        }
    }

    public static class j implements Provider<DeviceMetrics> {
        public final ShopDetailedDependencies a;

        public j(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeviceMetrics get() {
            return (DeviceMetrics) Preconditions.checkNotNullFromComponent(this.a.deviceMetrics());
        }
    }

    public static class k implements Provider<FavoriteAdvertsEventInteractor> {
        public final ShopDetailedDependencies a;

        public k(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsEventInteractor get() {
            return (FavoriteAdvertsEventInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsEventInteractor());
        }
    }

    public static class l implements Provider<FavoriteAdvertsUploadInteractor> {
        public final ShopDetailedDependencies a;

        public l(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsUploadInteractor get() {
            return (FavoriteAdvertsUploadInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsUploadInteractor());
        }
    }

    public static class m implements Provider<FavoriteSellersApi> {
        public final ShopDetailedDependencies a;

        public m(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteSellersApi get() {
            return (FavoriteSellersApi) Preconditions.checkNotNullFromComponent(this.a.favoriteSellersApi());
        }
    }

    public static class n implements Provider<FavoriteSellersRepository> {
        public final ShopDetailedDependencies a;

        public n(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteSellersRepository get() {
            return (FavoriteSellersRepository) Preconditions.checkNotNullFromComponent(this.a.favoriteSellersRepository());
        }
    }

    public static class o implements Provider<FavoritesSyncDao> {
        public final ShopDetailedDependencies a;

        public o(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoritesSyncDao get() {
            return (FavoritesSyncDao) Preconditions.checkNotNullFromComponent(this.a.favoritesSyncDao());
        }
    }

    public static class p implements Provider<Features> {
        public final ShopDetailedDependencies a;

        public p(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class q implements Provider<Locale> {
        public final ShopDetailedDependencies a;

        public q(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class r implements Provider<Preferences> {
        public final ShopDetailedDependencies a;

        public r(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Preferences get() {
            return (Preferences) Preconditions.checkNotNullFromComponent(this.a.preferences());
        }
    }

    public static class s implements Provider<SerpItemsPrefetchTestGroup> {
        public final ShopDetailedDependencies a;

        public s(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SerpItemsPrefetchTestGroup get() {
            return (SerpItemsPrefetchTestGroup) Preconditions.checkNotNullFromComponent(this.a.prefetchTestGroup());
        }
    }

    public static class t implements Provider<ExposedAbTestGroup<PriceOnTopTestGroup>> {
        public final ShopDetailedDependencies a;

        public t(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ExposedAbTestGroup<PriceOnTopTestGroup> get() {
            return (ExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.priceOnTop());
        }
    }

    public static class u implements Provider<RandomKeyProvider> {
        public final ShopDetailedDependencies a;

        public u(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public RandomKeyProvider get() {
            return (RandomKeyProvider) Preconditions.checkNotNullFromComponent(this.a.randomKeyProvider());
        }
    }

    public static class v implements Provider<SchedulersFactory3> {
        public final ShopDetailedDependencies a;

        public v(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class w implements Provider<ScreenTrackerFactory> {
        public final ShopDetailedDependencies a;

        public w(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class x implements Provider<SearchApi> {
        public final ShopDetailedDependencies a;

        public x(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SearchApi get() {
            return (SearchApi) Preconditions.checkNotNullFromComponent(this.a.searchApi());
        }
    }

    public static class y implements Provider<ShopsApi> {
        public final ShopDetailedDependencies a;

        public y(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ShopsApi get() {
            return (ShopsApi) Preconditions.checkNotNullFromComponent(this.a.shopsApi());
        }
    }

    public static class z implements Provider<TimeSource> {
        public final ShopDetailedDependencies a;

        public z(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public DaggerShopDetailedComponent(ShopDetailedModule shopDetailedModule, NotificationManagerModule notificationManagerModule, ShopDetailedDependencies shopDetailedDependencies, String str, String str2, String str3, SearchParams searchParams, Kundle kundle, Kundle kundle2, TreeClickStreamParent treeClickStreamParent, MutableLiveData mutableLiveData, Resources resources, Fragment fragment, SerpOnboardingHandler serpOnboardingHandler, a aVar) {
        this.a = shopDetailedDependencies;
        this.b = InstanceFactory.create(str);
        this.c = InstanceFactory.create(searchParams);
        this.e = new e(shopDetailedDependencies);
        this.f = new p(shopDetailedDependencies);
        Factory createNullable = InstanceFactory.createNullable(serpOnboardingHandler);
        this.g = createNullable;
        this.h = SingleCheck.provider(AdvertItemPresenterModule_ProvideAdvertGridItemPresenterFactory.create(this.d, this.e, this.f, createNullable));
        z zVar = new z(shopDetailedDependencies);
        this.i = zVar;
        ShopItemVisibilityTrackerImpl_Factory create = ShopItemVisibilityTrackerImpl_Factory.create(zVar);
        this.j = create;
        Provider<ShopItemVisibilityTracker> provider = DoubleCheck.provider(create);
        this.k = provider;
        this.l = DoubleCheck.provider(ShopAdvertGridItemPresenter_Factory.create(this.h, provider));
        this.m = new q(shopDetailedDependencies);
        t tVar = new t(shopDetailedDependencies);
        this.n = tVar;
        s sVar = new s(shopDetailedDependencies);
        this.o = sVar;
        SerpItemAbViewConfig_Factory create2 = SerpItemAbViewConfig_Factory.create(tVar, sVar);
        this.p = create2;
        g gVar = new g(shopDetailedDependencies);
        this.q = gVar;
        this.r = DoubleCheck.provider(ShopDetailedModule_ProvideAdvertItemGridBlueprint$shop_releaseFactory.create(shopDetailedModule, this.l, this.i, this.m, create2, gVar));
        this.s = DoubleCheck.provider(ShopDetailedModule_ProvideAdvertItemDoubleBlueprint$shop_releaseFactory.create(shopDetailedModule, this.l, this.i, this.m, this.p, this.q));
        Provider<AdvertListItemPresenter> provider2 = SingleCheck.provider(AdvertItemPresenterModule_ProvideAdvertListItemPresenterFactory.create(this.d, this.e, this.f, this.g));
        this.t = provider2;
        Provider<ShopAdvertListItemPresenter> provider3 = DoubleCheck.provider(ShopAdvertListItemPresenter_Factory.create(provider2, this.k));
        this.u = provider3;
        this.v = DoubleCheck.provider(ShopDetailedModule_ProvideAdvertItemListBlueprint$shop_releaseFactory.create(shopDetailedModule, provider3, this.i, this.m, this.p, this.q));
        Provider<Kundle> provider4 = DoubleCheck.provider(ShopDetailedModule_ProvideShowcasePresenterState$shop_releaseFactory.create(shopDetailedModule));
        this.w = provider4;
        ShowcaseItemPresenterImpl_Factory create3 = ShowcaseItemPresenterImpl_Factory.create(provider4);
        this.x = create3;
        this.y = DoubleCheck.provider(create3);
        this.z = new j(shopDetailedDependencies);
        Factory create4 = InstanceFactory.create(resources);
        this.A = create4;
        SectionResourceProviderImpl_Factory create5 = SectionResourceProviderImpl_Factory.create(create4);
        this.B = create5;
        Provider<SectionResourceProvider> provider5 = SingleCheck.provider(create5);
        this.C = provider5;
        Provider<SectionItemWidthProvider> provider6 = SingleCheck.provider(SectionAdvertItemsModule_ProvideSectionItemWidthProvider$serp_core_releaseFactory.create(this.z, provider5));
        this.D = provider6;
        Provider<SectionAdvertItemPresenter> provider7 = SingleCheck.provider(SectionAdvertItemsModule_ProvideSectionAdvertItemPresenter$serp_core_releaseFactory.create(this.d, provider6));
        this.E = provider7;
        SectionAdvertItemBlueprintImpl_Factory create6 = SectionAdvertItemBlueprintImpl_Factory.create(provider7, this.i, this.m, this.q);
        this.F = create6;
        this.G = SingleCheck.provider(create6);
        SectionAdvertItemDoubleBlueprintImpl_Factory create7 = SectionAdvertItemDoubleBlueprintImpl_Factory.create(this.E, this.i, this.m, this.q);
        this.H = create7;
        Provider<SectionAdvertItemDoubleBlueprint> provider8 = SingleCheck.provider(create7);
        this.I = provider8;
        Provider<ItemBinder> provider9 = DoubleCheck.provider(ShopDetailedModule_ProvideShowcaseItemBinder$shop_releaseFactory.create(shopDetailedModule, this.G, provider8));
        this.J = provider9;
        this.K = DoubleCheck.provider(ShopDetailedModule_ProvideShowcaseAdapterPresenter$shop_releaseFactory.create(shopDetailedModule, provider9));
        this.L = new o(shopDetailedDependencies);
        this.M = new l(shopDetailedDependencies);
        this.N = new k(shopDetailedDependencies);
        d dVar = new d(shopDetailedDependencies);
        this.O = dVar;
        FavoriteAdvertsAnalyticsInteractorImpl_Factory create8 = FavoriteAdvertsAnalyticsInteractorImpl_Factory.create(this.e, dVar);
        this.P = create8;
        v vVar = new v(shopDetailedDependencies);
        this.Q = vVar;
        this.R = FavoriteAdvertsInteractorImpl_Factory.create(this.L, this.M, this.N, create8, vVar);
        Provider<FavoriteAdvertsResourceProvider> provider10 = SingleCheck.provider(FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsResourceProvider$favorite_core_releaseFactory.create(this.A));
        this.S = provider10;
        this.T = FavoriteAdvertsPresenterImpl_Factory.create(this.R, provider10, this.Q);
        d0 d0Var = new d0(shopDetailedDependencies);
        this.U = d0Var;
        ViewedAdvertsPresenterImpl_Factory create9 = ViewedAdvertsPresenterImpl_Factory.create(d0Var, this.Q);
        this.V = create9;
        this.W = DoubleCheck.provider(ShowcaseBlueprint_Factory.create(this.y, this.K, this.T, create9, this.J));
        h hVar = new h(shopDetailedDependencies);
        this.X = hVar;
        Provider<NotificationManagerCompat> provider11 = DoubleCheck.provider(ShopDetailedModule_ProvideNotificationManagerFactory.create(shopDetailedModule, hVar));
        this.Y = provider11;
        this.Z = NotificationManagerModule_ProvideNotificationManagerProviderFactory.create(notificationManagerModule, provider11);
        this.a0 = new n(shopDetailedDependencies);
        ShopSubscriptionsResourceProvider_Factory create10 = ShopSubscriptionsResourceProvider_Factory.create(this.A);
        this.b0 = create10;
        this.c0 = DoubleCheck.provider(create10);
        this.d0 = InstanceFactory.createNullable(str2);
        this.e0 = InstanceFactory.createNullable(str3);
        this.f0 = new y(shopDetailedDependencies);
        this.g0 = new x(shopDetailedDependencies);
        this.h0 = new m(shopDetailedDependencies);
        this.i0 = DoubleCheck.provider(SearchParamsConverterImpl_Factory.create());
        Provider<InlineFiltersChangesParamsConverter> provider12 = DoubleCheck.provider(InlineFiltersChangesParamsConverterImpl_Factory.create());
        this.j0 = provider12;
        InlineFiltersInteractorImpl_Factory create11 = InlineFiltersInteractorImpl_Factory.create(this.g0, this.i0, provider12, InlineFiltersParametersKeyWrapper_Factory.create(), this.Q, this.f);
        this.k0 = create11;
        this.l0 = DoubleCheck.provider(create11);
        Factory createNullable2 = InstanceFactory.createNullable(kundle);
        this.m0 = createNullable2;
        ShopDetailedInteractorImpl_Factory create12 = ShopDetailedInteractorImpl_Factory.create(this.b, this.d0, this.e0, this.f0, this.g0, this.h0, this.Q, this.Z, this.l0, this.i0, this.a0, createNullable2);
        this.n0 = create12;
        this.o0 = DoubleCheck.provider(create12);
        ErrorFormatterImpl_Factory create13 = ErrorFormatterImpl_Factory.create(this.A);
        this.p0 = create13;
        Provider<ErrorFormatter> provider13 = SingleCheck.provider(create13);
        this.q0 = provider13;
        ErrorHelperImpl_Factory create14 = ErrorHelperImpl_Factory.create(provider13);
        this.r0 = create14;
        this.s0 = SingleCheck.provider(create14);
        Provider<CompositeSnackbarPresenter> provider14 = SingleCheck.provider(CompositeSnackbarModule_ProvideCompositeSnackbarPresenterFactory.create());
        this.t0 = provider14;
        this.u0 = DoubleCheck.provider(ShopDetailedModule_ProvideSubscriptionsPresenterImplFactory.create(shopDetailedModule, this.d, this.Z, this.a0, this.O, this.c0, this.o0, this.s0, this.e, this.Q, provider14, this.f));
        this.v0 = DoubleCheck.provider(ShopDetailedModule_ProvideShopItemRatingPresenter$shop_releaseFactory.create(shopDetailedModule, this.d));
        ShopGoldResourceProviderImpl_Factory create15 = ShopGoldResourceProviderImpl_Factory.create(this.X);
        this.w0 = create15;
        this.x0 = DoubleCheck.provider(create15);
        Provider<Kundle> provider15 = DoubleCheck.provider(ShopDetailedModule_ProvideShopGoldItemPresenterState$shop_releaseFactory.create(shopDetailedModule));
        this.y0 = provider15;
        ShopGoldItemPresenterImpl_Factory create16 = ShopGoldItemPresenterImpl_Factory.create(this.u0, this.t0, this.v0, this.d, this.x0, provider15);
        this.z0 = create16;
        Provider<ShopGoldItemPresenter> provider16 = DoubleCheck.provider(create16);
        this.A0 = provider16;
        this.B0 = ShopGoldBlueprint_Factory.create(provider16, this.f);
        ShopDetailedImageHeightProviderImpl_Factory create17 = ShopDetailedImageHeightProviderImpl_Factory.create(this.z, this.A);
        this.C0 = create17;
        Provider<ShopDetailedImageHeightProvider> provider17 = DoubleCheck.provider(create17);
        this.D0 = provider17;
        ShopGoldHeaderItemPresenterImpl_Factory create18 = ShopGoldHeaderItemPresenterImpl_Factory.create(provider17);
        this.E0 = create18;
        Provider<ShopGoldHeaderItemPresenter> provider18 = DoubleCheck.provider(create18);
        this.F0 = provider18;
        this.G0 = ShopGoldHeaderBlueprint_Factory.create(provider18);
        ShopRegularResourceProviderImpl_Factory create19 = ShopRegularResourceProviderImpl_Factory.create(this.X);
        this.H0 = create19;
        this.I0 = DoubleCheck.provider(create19);
        Provider<Kundle> provider19 = DoubleCheck.provider(ShopDetailedModule_ProvideShopRegularItemPresenterState$shop_releaseFactory.create(shopDetailedModule));
        this.J0 = provider19;
        Provider<SubscriptionsPresenter> provider20 = this.u0;
        Provider<CompositeSnackbarPresenter> provider21 = this.t0;
        Provider<ShopItemRatingPresenter> provider22 = this.v0;
        Provider<ShopDetailedPresenter> provider23 = this.d;
        ShopRegularItemPresenterImpl_Factory create20 = ShopRegularItemPresenterImpl_Factory.create(provider20, provider21, provider22, provider23, provider23, this.I0, provider19);
        this.K0 = create20;
        Provider<ShopRegularItemPresenter> provider24 = DoubleCheck.provider(create20);
        this.L0 = provider24;
        this.M0 = DoubleCheck.provider(ShopRegularBlueprint_Factory.create(provider24, this.f));
        Provider<AdvertsCountCaptionItemPresenter> provider25 = DoubleCheck.provider(AdvertsCountCaptionItemPresenter_Factory.create());
        this.N0 = provider25;
        this.O0 = DoubleCheck.provider(ShopDetailedModule_ProvideAdvertsCountCaptionBlueprint$shop_releaseFactory.create(shopDetailedModule, provider25));
        NoItemsFoundHeightProviderImpl_Factory create21 = NoItemsFoundHeightProviderImpl_Factory.create(this.A);
        this.P0 = create21;
        Provider<NoItemsFoundHeightProvider> provider26 = DoubleCheck.provider(create21);
        this.Q0 = provider26;
        NoItemsFoundItemPresenterImpl_Factory create22 = NoItemsFoundItemPresenterImpl_Factory.create(provider26);
        this.R0 = create22;
        Provider<NoItemsFoundItemPresenter> provider27 = DoubleCheck.provider(create22);
        this.S0 = provider27;
        Provider<NoItemsFoundBlueprint> provider28 = DoubleCheck.provider(ShopDetailedModule_ProvideNoItemsFoundBlueprint$shop_releaseFactory.create(shopDetailedModule, provider27));
        this.T0 = provider28;
        Provider<ItemBinder> provider29 = DoubleCheck.provider(ShopDetailedModule_ProvideItemBinder$shop_releaseFactory.create(shopDetailedModule, this.r, this.s, this.v, this.W, this.B0, this.G0, this.M0, this.O0, provider28));
        this.U0 = provider29;
        this.V0 = DoubleCheck.provider(ShopDetailedModule_ProvideAdapterPresenter$shop_releaseFactory.create(shopDetailedModule, provider29));
        Provider<SpannedGridPositionProvider> provider30 = DoubleCheck.provider(ShopDetailedModule_ProvideGridPositionProvider$shop_releaseFactory.create(shopDetailedModule, this.A));
        this.W0 = provider30;
        this.X0 = DoubleCheck.provider(ShopDetailedModule_ProvideSpanProvider$shop_releaseFactory.create(shopDetailedModule, provider30, this.A));
        ShopAdvertsResourceProviderImpl_Factory create23 = ShopAdvertsResourceProviderImpl_Factory.create(this.A);
        this.Y0 = create23;
        this.Z0 = DoubleCheck.provider(create23);
        this.a1 = DoubleCheck.provider(this.p0);
        this.b1 = SingleCheck.provider(FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsPresenter$favorite_core_releaseFactory.create(this.R, this.Q, this.S));
        this.c1 = SingleCheck.provider(ViewedAdvertsModule_ProvideViewedAdvertsPresenterFactory.create(this.U, this.Q));
        this.d1 = SingleCheck.provider(SerpItemConverterModule_ProvideItemAdvertSpanCountProviderFactory.create(this.A));
        Provider<AdvertSpanCountProvider> provider31 = SingleCheck.provider(SerpItemConverterModule_ProvideBigAdvertSpanCountProviderFactory.create(this.A));
        this.e1 = provider31;
        this.f1 = SingleCheck.provider(SerpItemConverterModule_ProvideAdvertConverterFactory.create(this.d1, provider31, this.A, this.f));
        this.g1 = SingleCheck.provider(SerpItemConverterModule_ProvideAdvertXlConverterFactory.create(this.A, this.f));
        Provider<AdResourceProvider> provider32 = DoubleCheck.provider(AdResourceProviderImpl_Factory.create());
        this.h1 = provider32;
        u uVar = new u(shopDetailedDependencies);
        this.i1 = uVar;
        this.j1 = SingleCheck.provider(SerpItemConverterModule_ProvideCommercialConverterFactory.create(this.d1, this.e1, provider32, uVar));
        i iVar = new i(shopDetailedDependencies);
        this.k1 = iVar;
        this.l1 = SingleCheck.provider(SerpItemConverterModule_ProvideShortcutBannerConverterFactory.create(iVar, this.A));
        this.m1 = SingleCheck.provider(SerpItemConverterModule_ProvideSerpWarningConverterFactory.create());
        this.n1 = SingleCheck.provider(SerpItemConverterModule_ProvideSnippetConverterFactory.create());
        this.o1 = SingleCheck.provider(SerpItemConverterModule_ProvideSerpEmptySearchConverterFactory.create());
        this.p1 = SingleCheck.provider(SerpItemConverterModule_ProvideGroupTitleItemConverterFactory.create());
        this.q1 = SingleCheck.provider(SerpItemConverterModule_ProvideEmptyPlaceholderItemConverterFactory.create());
        this.r1 = SingleCheck.provider(SerpItemConverterModule_ProvideHeaderElementConverterFactory.create());
        this.s1 = SingleCheck.provider(SerpItemConverterModule_ProvideFavoriteStatusResolverFactory.create(this.R));
        this.t1 = new c0(shopDetailedDependencies);
        Provider<ViewedAdvertsInteractor> provider33 = SingleCheck.provider(ViewedAdvertsModule_ProvideViewedAdvertsInteractorFactory.create(ViewedAdvertsInteractorFactoryImpl_Factory.create(), this.t1, this.Q, this.U, this.f));
        this.u1 = provider33;
        Provider<ViewedStatusResolver> provider34 = SingleCheck.provider(ViewedAdvertsModule_ProvideViewedStatusResolverFactory.create(provider33));
        this.v1 = provider34;
        this.w1 = SingleCheck.provider(SerpItemConverterModule_ProvideWitcherElementConverterFactory.create(this.f1, this.s1, provider34));
        this.x1 = SingleCheck.provider(SerpItemConverterModule_ProvideLocationNotificationConverterFactory.create());
        this.y1 = SingleCheck.provider(SerpItemConverterModule_ProvideSellerElementConverterFactory.create());
        this.z1 = SingleCheck.provider(SerpItemConverterModule_ProvideReportBannerConverterFactory.create(this.A, this.f));
        this.A1 = SingleCheck.provider(SerpItemConverterModule_ProvidePromoCardConverterFactory.create(this.A, this.f));
        this.B1 = SingleCheck.provider(SerpItemConverterModule_ProvideMapBannerConverterFactory.create());
        Provider<VerticalFilterItemConverter> provider35 = SingleCheck.provider(SerpItemConverterModule_ProvideVerticalFilterItemConverterFactory.create());
        this.C1 = provider35;
        Provider<SerpElementItemConverter> provider36 = SingleCheck.provider(SerpItemConverterModule_ProvideElementItemConverterFactory.create(this.f1, this.g1, this.j1, this.l1, this.m1, this.n1, this.o1, this.p1, this.q1, this.r1, this.w1, this.x1, this.y1, this.z1, this.A1, this.B1, provider35));
        this.D1 = provider36;
        ShopDetailedItemsConverterImpl_Factory create24 = ShopDetailedItemsConverterImpl_Factory.create(this.Z0, provider36, this.s1, this.v1);
        this.E1 = create24;
        this.F1 = DoubleCheck.provider(create24);
        this.G1 = new b0(shopDetailedDependencies);
        this.H1 = InstanceFactory.createNullable(treeClickStreamParent);
        this.I1 = InstanceFactory.createNullable(kundle2);
        w wVar = new w(shopDetailedDependencies);
        this.J1 = wVar;
        a0 a0Var = new a0(shopDetailedDependencies);
        this.K1 = a0Var;
        this.L1 = DoubleCheck.provider(ShopDetailedTrackerModule_ProvideScreenDiInjectTracker$shop_releaseFactory.create(wVar, a0Var));
        this.M1 = DoubleCheck.provider(ShopDetailedTrackerModule_ProvideScreenInitTrackerFactory.create(this.J1, this.K1));
        Provider<ScreenFlowTrackerProvider> provider37 = DoubleCheck.provider(ShopDetailedTrackerModule_ProvidesScreenFlowTrackerProviderFactory.create(this.J1, this.K1));
        this.N1 = provider37;
        ShopDetailedTrackerImpl_Factory create25 = ShopDetailedTrackerImpl_Factory.create(this.L1, this.M1, provider37);
        this.O1 = create25;
        this.P1 = DoubleCheck.provider(create25);
        Factory create26 = InstanceFactory.create(mutableLiveData);
        this.Q1 = create26;
        ShopDetailedPresenterImpl_Factory create27 = ShopDetailedPresenterImpl_Factory.create(this.b, this.c, this.V0, this.X0, this.W0, this.o0, this.Q, this.Z0, this.a1, this.b1, this.c1, this.F1, this.e, this.k, this.G1, this.H1, this.t0, this.I1, this.f, this.P1, create26);
        this.R1 = create27;
        DelegateFactory.setDelegate(this.d, DoubleCheck.provider(create27));
        this.S1 = DoubleCheck.provider(ShopDetailedModule_ProvideDestroyableViewHolderBuilder$shop_releaseFactory.create(shopDetailedModule, this.U0));
        this.T1 = DoubleCheck.provider(ShopDetailedModule_ProvideSpanLookup$shop_releaseFactory.create(shopDetailedModule, this.X0));
        Factory create28 = InstanceFactory.create(fragment);
        this.U1 = create28;
        this.V1 = DoubleCheck.provider(create28);
        f fVar = new f(shopDetailedDependencies);
        this.W1 = fVar;
        CartFabRepositoryImpl_Factory create29 = CartFabRepositoryImpl_Factory.create(fVar, this.Q);
        this.X1 = create29;
        this.Y1 = SingleCheck.provider(create29);
        r rVar = new r(shopDetailedDependencies);
        this.Z1 = rVar;
        CartFabPreferencesImpl_Factory create30 = CartFabPreferencesImpl_Factory.create(rVar);
        this.f59a2 = create30;
        this.b2 = SingleCheck.provider(create30);
        ShopDetailedModule_ProvideSearchContextWrapper$shop_releaseFactory create31 = ShopDetailedModule_ProvideSearchContextWrapper$shop_releaseFactory.create(shopDetailedModule, this.e0);
        this.c2 = create31;
        c cVar = new c(create31);
        this.d2 = cVar;
        CartFabViewModelFactory_Factory create32 = CartFabViewModelFactory_Factory.create(this.f, this.Y1, this.b2, this.O, this.Q, this.e, cVar);
        this.e2 = create32;
        this.f2 = SingleCheck.provider(CartFabModule_ProvideCartFabViewModelFactory.create(this.V1, create32));
        this.g2 = SingleCheck.provider(CartFabQuantityVisibilityHandler_Factory.create());
        Provider<CallableResponsiveItemPresenterRegistry> provider38 = DoubleCheck.provider(ShopDetailedModule_ProvideItemCallableResponsiveItemPresenterRegistry$shop_releaseFactory.create(shopDetailedModule, this.u, this.l));
        this.h2 = provider38;
        this.i2 = DoubleCheck.provider(ShopDetailedModule_ProvideItemResponsiveAdapterPresenter$shop_releaseFactory.create(shopDetailedModule, this.V0, provider38));
    }

    public static ShopDetailedComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.shop.detailed.di.ShopDetailedComponent
    public void inject(ShopDetailedFragment shopDetailedFragment) {
        ShopDetailedFragment_MembersInjector.injectAnalytics(shopDetailedFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        ShopDetailedFragment_MembersInjector.injectSchedulers(shopDetailedFragment, (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3()));
        ShopDetailedFragment_MembersInjector.injectPresenter(shopDetailedFragment, this.d.get());
        ShopDetailedFragment_MembersInjector.injectInteractor(shopDetailedFragment, this.o0.get());
        ShopDetailedFragment_MembersInjector.injectActivityIntentFactory(shopDetailedFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        ShopDetailedFragment_MembersInjector.injectImplicitIntentFactory(shopDetailedFragment, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
        ShopDetailedFragment_MembersInjector.injectDestroyableViewHolderBuilder(shopDetailedFragment, this.S1.get());
        ShopDetailedFragment_MembersInjector.injectSpanSizeLookup(shopDetailedFragment, this.T1.get());
        ShopDetailedFragment_MembersInjector.injectGridPositionProvider(shopDetailedFragment, this.W0.get());
        ShopDetailedFragment_MembersInjector.injectShopGoldItemPresenter(shopDetailedFragment, this.A0.get());
        ShopDetailedFragment_MembersInjector.injectShopRegularItemPresenter(shopDetailedFragment, this.L0.get());
        ShopDetailedFragment_MembersInjector.injectFavoriteAdvertsPresenter(shopDetailedFragment, this.b1.get());
        ShopDetailedFragment_MembersInjector.injectViewedAdvertsPresenter(shopDetailedFragment, this.c1.get());
        ShopDetailedFragment_MembersInjector.injectShowcaseItemPresenter(shopDetailedFragment, this.y.get());
        ShopDetailedFragment_MembersInjector.injectSubscriptionsPresenter(shopDetailedFragment, this.u0.get());
        ShopDetailedFragment_MembersInjector.injectSnackbarPresenter(shopDetailedFragment, this.t0.get());
        ShopDetailedFragment_MembersInjector.injectDeepLinkIntentFactory(shopDetailedFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        ShopDetailedFragment_MembersInjector.injectFeatures(shopDetailedFragment, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        ShopDetailedFragment_MembersInjector.injectCartFabViewModel(shopDetailedFragment, this.f2.get());
        ShopDetailedFragment_MembersInjector.injectCartQuantityHandler(shopDetailedFragment, this.g2.get());
        ShopDetailedFragment_MembersInjector.injectFavoriteShowcasePresenter(shopDetailedFragment, new FavoriteAdvertsPresenterImpl(new FavoriteAdvertsInteractorImpl((FavoritesSyncDao) Preconditions.checkNotNullFromComponent(this.a.favoritesSyncDao()), (FavoriteAdvertsUploadInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsUploadInteractor()), (FavoriteAdvertsEventInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsEventInteractor()), new FavoriteAdvertsAnalyticsInteractorImpl((Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()), (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider())), (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3())), this.S.get(), (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3())));
        ShopDetailedFragment_MembersInjector.injectAdapterPresenter(shopDetailedFragment, this.i2.get());
        ShopDetailedFragment_MembersInjector.injectTracker(shopDetailedFragment, this.P1.get());
    }
}
