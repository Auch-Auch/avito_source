package com.avito.android.di.component;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.IdProvider;
import com.avito.android.TopLocationInteractor;
import com.avito.android.ab_tests.configs.AntifraudStartupBannerTestGroup;
import com.avito.android.ab_tests.configs.HomeNewRubricatorTestGroup;
import com.avito.android.ab_tests.configs.OrangeAdBadgeTestGroup;
import com.avito.android.ab_tests.configs.PriceOnTopTestGroup;
import com.avito.android.ab_tests.configs.SerpItemsPrefetchTestGroup;
import com.avito.android.ab_tests.groups.HomeSkeletonTestGroup;
import com.avito.android.ab_tests.groups.ViewedItemsTabTestGroup;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.adapter.MoreActionsItemProcessor;
import com.avito.android.adapter.MoreActionsItemProcessorImpl;
import com.avito.android.adapter.MoreActionsItemProcessorImpl_Factory;
import com.avito.android.advert.actions.AdvertItemActionsPresenter;
import com.avito.android.advert.actions.AdvertItemActionsPresenterImpl;
import com.avito.android.advert.actions.AdvertItemActionsPresenterImpl_Factory;
import com.avito.android.advert.actions.HiddenAdvertsInteractor;
import com.avito.android.advert.actions.HiddenAdvertsInteractorImpl;
import com.avito.android.advert.actions.HiddenAdvertsInteractorImpl_Factory;
import com.avito.android.advert.actions.HiddenAdvertsStorage;
import com.avito.android.advert.viewed.ViewedAdvertsEventInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsInteractorFactoryImpl_Factory;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.FavoriteAdvertsAnalyticsInteractorImpl;
import com.avito.android.analytics.FavoriteAdvertsAnalyticsInteractorImpl_Factory;
import com.avito.android.analytics.interactor.SnippetScrollDepthAnalyticsInteractor;
import com.avito.android.analytics.interactor.SnippetScrollDepthAnalyticsInteractorImpl;
import com.avito.android.analytics.interactor.SnippetScrollDepthAnalyticsInteractorImpl_Factory;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.fps.FpsMetricsSupplier;
import com.avito.android.analytics.screens.fps.FpsMetricsTracker;
import com.avito.android.analytics.screens.fps.FpsStateSupplier;
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
import com.avito.android.connection_quality.ConnectionManager;
import com.avito.android.connection_quality.ConnectionQualityInteractor;
import com.avito.android.connection_quality.ConnectionQualitySubscriber;
import com.avito.android.connection_quality.NetworkInfoBroadcastReceiver;
import com.avito.android.connection_quality.NetworkInfoChangeListener;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.connection_quality.di.ConnectionQualityInteractorModule;
import com.avito.android.connection_quality.di.ConnectionQualityInteractorModule_ProvideConnectionClassManager$connection_quality_releaseFactory;
import com.avito.android.connection_quality.di.ConnectionQualityInteractorModule_ProvideConnectionClassSubscriber$connection_quality_releaseFactory;
import com.avito.android.connection_quality.di.ConnectionQualityInteractorModule_ProvideConnectionManager$connection_quality_releaseFactory;
import com.avito.android.connection_quality.di.ConnectionQualityInteractorModule_ProvideConnectionQualityInteractor$connection_quality_releaseFactory;
import com.avito.android.connection_quality.di.ConnectionQualityInteractorModule_ProvideConnectionQualityNetworkListenerFactory;
import com.avito.android.connection_quality.di.ConnectionQualityInteractorModule_ProvideConnectivityManager$connection_quality_releaseFactory;
import com.avito.android.connection_quality.di.ConnectionQualityInteractorModule_ProvideNetworkInfoBroadcastReceiver$connection_quality_releaseFactory;
import com.avito.android.conveyor_shared_item.single_text.SingleTextPresenter;
import com.avito.android.conveyor_shared_item.single_text.SingleTextPresenterImpl_Factory;
import com.avito.android.db.favorites.FavoritesSyncDao;
import com.avito.android.db.viewed.ViewedAdvertsDao;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.design.widget.dfp_debug.DfpDebugPresenter;
import com.avito.android.design.widget.dfp_debug.DfpDebugPresenterImpl_Factory;
import com.avito.android.di.ViewedAdvertsModule_ProvideViewedAdvertsInteractorFactory;
import com.avito.android.di.ViewedAdvertsModule_ProvideViewedAdvertsPresenterFactory;
import com.avito.android.di.ViewedAdvertsModule_ProvideViewedStatusResolverFactory;
import com.avito.android.di.component.HomeComponent;
import com.avito.android.di.module.AdvertItemModule_ProvideAdvertItemDoubleBlueprintFactory;
import com.avito.android.di.module.AdvertItemModule_ProvideAdvertItemGridBlueprintFactory;
import com.avito.android.di.module.AdvertItemPresenterModule_ProvideAdvertGridItemPresenterFactory;
import com.avito.android.di.module.AppendingLoaderModule;
import com.avito.android.di.module.AppendingLoaderModule_ProvideAppendingLargeLoaderItemBlueprintFactory;
import com.avito.android.di.module.AppendingLoaderModule_ProvideAppendingLoaderItemBlueprintFactory;
import com.avito.android.di.module.AppendingLoaderModule_ProvideAppendingLoaderItemPresenterFactory;
import com.avito.android.di.module.DefaultSearchLocationModule_ProvideDefaultLocationNotificationInteractor$serp_releaseFactory;
import com.avito.android.di.module.DefaultSearchLocationModule_ProvideDefaultLocationPresenter$serp_releaseFactory;
import com.avito.android.di.module.DefaultSearchLocationModule_ProvideDefaultSearchLocationAnalyticsInteractorImpl$serp_releaseFactory;
import com.avito.android.di.module.DefaultSearchLocationModule_ProvideLocationPermissionDialogPresenter$serp_releaseFactory;
import com.avito.android.di.module.FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsPresenter$favorite_core_releaseFactory;
import com.avito.android.di.module.FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsResourceProvider$favorite_core_releaseFactory;
import com.avito.android.di.module.HomeModule_ProvideAdapterPresenter$serp_releaseFactory;
import com.avito.android.di.module.HomeModule_ProvideDestroyableViewHolderBuilder$serp_releaseFactory;
import com.avito.android.di.module.HomeModule_ProvideItemBinder$serp_releaseFactory;
import com.avito.android.di.module.HomeModule_ProvideItemVisibilityTracker$serp_releaseFactory;
import com.avito.android.di.module.HomeModule_ProvideSerpTreeParent$serp_releaseFactory;
import com.avito.android.di.module.ScreenAnalyticsDependencies;
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
import com.avito.android.di.module.WitcherModule_ProvideWitcherAdapter$serp_core_releaseFactory;
import com.avito.android.di.module.WitcherModule_ProvideWitcherFavoriteAdvertsPresenter$serp_core_releaseFactory;
import com.avito.android.di.module.WitcherModule_ProvideWitcherViewedAdvertsPresenter$serp_core_releaseFactory;
import com.avito.android.di.module.WitcherModule_ProvidesWitcherItemsBinderFactory;
import com.avito.android.favorite.FavoriteAdvertsEventInteractor;
import com.avito.android.favorite.FavoriteAdvertsInteractorImpl;
import com.avito.android.favorite.FavoriteAdvertsInteractorImpl_Factory;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsResourceProvider;
import com.avito.android.favorite.FavoriteAdvertsUploadInteractor;
import com.avito.android.floating_views.FloatingViewsPresenterImpl;
import com.avito.android.floating_views.FloatingViewsPresenterImpl_Factory;
import com.avito.android.floating_views.PersistableFloatingViewsPresenter;
import com.avito.android.geo.GeoStorage;
import com.avito.android.home.HomeFragment;
import com.avito.android.home.HomeFragment_MembersInjector;
import com.avito.android.home.HomeInteractor;
import com.avito.android.home.HomeInteractorImpl;
import com.avito.android.home.HomeInteractorImpl_Factory;
import com.avito.android.home.HomeInteractorState;
import com.avito.android.home.HomePresenter;
import com.avito.android.home.HomePresenterImpl;
import com.avito.android.home.HomePresenterImpl_Factory;
import com.avito.android.home.HomePresenterResourcesProvider;
import com.avito.android.home.HomePresenterResourcesProviderImpl;
import com.avito.android.home.HomePresenterResourcesProviderImpl_Factory;
import com.avito.android.home.HomePresenterState;
import com.avito.android.home.HomeSerpHeaderBluePrint;
import com.avito.android.home.HomeSerpHeaderBluePrint_Factory;
import com.avito.android.home.analytics.HomeAnalyticsInteractor;
import com.avito.android.home.analytics.HomeAnalyticsInteractorImpl;
import com.avito.android.home.analytics.HomeAnalyticsInteractorImpl_Factory;
import com.avito.android.home.analytics.HomeTracker;
import com.avito.android.home.analytics.HomeTrackerImpl;
import com.avito.android.home.analytics.HomeTrackerImpl_Factory;
import com.avito.android.home.appending_item.di.AppendingEmptyModule;
import com.avito.android.home.appending_item.di.AppendingEmptyModule_ProvideAppendingEmptyBlueprintFactory;
import com.avito.android.home.appending_item.di.AppendingEmptyModule_ProvideAppendingEmptyPresenterFactory;
import com.avito.android.home.appending_item.di.AppendingRetryModule;
import com.avito.android.home.appending_item.di.AppendingRetryModule_ProvideAppendingLargeRetryItemBlueprintFactory;
import com.avito.android.home.appending_item.di.AppendingRetryModule_ProvideAppendingRetryItemBlueprintFactory;
import com.avito.android.home.appending_item.di.AppendingRetryModule_ProvideAppendingRetryItemPresenterFactory;
import com.avito.android.home.appending_item.empty.AppendingEmptyItemBlueprint;
import com.avito.android.home.appending_item.empty.AppendingEmptyItemPresenter;
import com.avito.android.home.appending_item.loader.AppendingLargeLoaderItemBlueprint;
import com.avito.android.home.appending_item.loader.AppendingLoaderItemBlueprint;
import com.avito.android.home.appending_item.loader.AppendingLoaderItemPresenter;
import com.avito.android.home.appending_item.retry.AppendingLargeRetryItemBlueprint;
import com.avito.android.home.appending_item.retry.AppendingRetryItemBlueprint;
import com.avito.android.home.appending_item.retry.AppendingRetryItemPresenter;
import com.avito.android.home.default_search_location.DefaultSearchLocationAnalyticsInteractor;
import com.avito.android.home.default_search_location.DefaultSearchLocationInteractor;
import com.avito.android.home.default_search_location.DefaultSearchLocationPresenter;
import com.avito.android.home.default_search_location.DefaultSearchLocationStorage;
import com.avito.android.home.tabs_item.SectionTabsItemBlueprint;
import com.avito.android.home.tabs_item.SectionTabsItemPresenter;
import com.avito.android.home.tabs_item.di.SectionTabsItemModule;
import com.avito.android.home.tabs_item.di.SectionTabsItemModule_ProvideSectionTabsItemBlueprintFactory;
import com.avito.android.home.tabs_item.di.SectionTabsItemModule_ProvideSectionTabsItemPresenterFactory;
import com.avito.android.home.tabs_item.di.SectionTabsItemModule_ProvideSkeletonSectionTabsItemPresenterFactory;
import com.avito.android.home.tabs_item.skeleton.SkeletonSectionTabsItemBlueprint;
import com.avito.android.home.tabs_item.skeleton.SkeletonSectionTabsItemBlueprint_Factory;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.item_visibility_tracker.filters.BannerViewFilter;
import com.avito.android.item_visibility_tracker.filters.BannerViewFilter_Factory;
import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.location.SavedLocationInteractorImpl;
import com.avito.android.location.SavedLocationInteractorImpl_Factory;
import com.avito.android.location.SavedLocationStorage;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.location.analytics.LocationAnalyticsInteractorImpl;
import com.avito.android.location.analytics.LocationAnalyticsInteractorImpl_Factory;
import com.avito.android.location.back_navigation.BackNavigationLocationInteractor;
import com.avito.android.location.di.LocationDependencies;
import com.avito.android.location.di.module.FindDetectLocationModule_ProvideDefaultLocationInteractorFactory;
import com.avito.android.location.di.module.FindDetectLocationModule_ProvideDefaultLocationProviderFactory;
import com.avito.android.location.di.module.FindDetectLocationModule_ProvideDetectLocationHelper$user_location_releaseFactory;
import com.avito.android.location.di.module.FindDetectLocationModule_ProvideDetectLocationInteractor$user_location_releaseFactory;
import com.avito.android.location.di.module.FindDetectLocationModule_ProvideWeakHandler$user_location_releaseFactory;
import com.avito.android.location.find.DefaultLocationInteractor;
import com.avito.android.location.find.DefaultLocationProvider;
import com.avito.android.location.find.DetectLocationInteractor;
import com.avito.android.location.find.DetectLocationProvider;
import com.avito.android.location.find.DetectLocationProviderImpl;
import com.avito.android.location.find.DetectLocationProviderImpl_Factory;
import com.avito.android.location.find.FindDetectLocationPresenter;
import com.avito.android.location.find.FindDetectLocationPresenterImpl;
import com.avito.android.location.find.FindDetectLocationPresenterImpl_Factory;
import com.avito.android.location.find.util.DetectLocationHelper;
import com.avito.android.module.serp.adapter.ad.adfox.AdfoxImageItemPresenter;
import com.avito.android.module.serp.adapter.ad.adfox.AdfoxImageItemPresenterImpl;
import com.avito.android.module.serp.adapter.ad.adfox.AdfoxImageItemPresenterImpl_Factory;
import com.avito.android.module.serp.adapter.ad.adfox.AdfoxSingleGridBlueprint;
import com.avito.android.module.serp.adapter.ad.adfox.AdfoxSingleGridBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.dfp.DfpAppInstallPresenter;
import com.avito.android.module.serp.adapter.ad.dfp.DfpAppInstallPresenterImpl;
import com.avito.android.module.serp.adapter.ad.dfp.DfpAppInstallPresenterImpl_Factory;
import com.avito.android.module.serp.adapter.ad.dfp.DfpAppInstallSingleBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.DfpAppInstallSingleBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.dfp.DfpContentPresenter;
import com.avito.android.module.serp.adapter.ad.dfp.DfpContentPresenterImpl;
import com.avito.android.module.serp.adapter.ad.dfp.DfpContentPresenterImpl_Factory;
import com.avito.android.module.serp.adapter.ad.dfp.DfpContentSingleGridBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.DfpContentSingleGridBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.dfp.DfpUnifiedPresenter;
import com.avito.android.module.serp.adapter.ad.dfp.DfpUnifiedPresenterImpl;
import com.avito.android.module.serp.adapter.ad.dfp.DfpUnifiedPresenterImpl_Factory;
import com.avito.android.module.serp.adapter.ad.dfp.DfpUnifiedSingleGridBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.DfpUnifiedSingleGridBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetAppInstallPresenter;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetAppInstallPresenterImpl;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetAppInstallPresenterImpl_Factory;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetAppInstallSingleBlueprint;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetAppInstallSingleBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetContentPresenter;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetContentPresenterImpl;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetContentPresenterImpl_Factory;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetContentSingleBlueprint;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetContentSingleBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.yandex.app_install.YandexAppInstallItemPresenter;
import com.avito.android.module.serp.adapter.ad.yandex.app_install.YandexAppInstallItemPresenterImpl;
import com.avito.android.module.serp.adapter.ad.yandex.app_install.YandexAppInstallItemPresenterImpl_Factory;
import com.avito.android.module.serp.adapter.ad.yandex.app_install.YandexAppInstallSingleItemBlueprint;
import com.avito.android.module.serp.adapter.ad.yandex.app_install.YandexAppInstallSingleItemBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.yandex.content.YandexContentItemPresenter;
import com.avito.android.module.serp.adapter.ad.yandex.content.YandexContentItemPresenterImpl;
import com.avito.android.module.serp.adapter.ad.yandex.content.YandexContentItemPresenterImpl_Factory;
import com.avito.android.module.serp.adapter.ad.yandex.content.YandexContentSingleGridBlueprint;
import com.avito.android.module.serp.adapter.ad.yandex.content.YandexContentSingleGridBlueprint_Factory;
import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.permissions.LocationPermissionProvider;
import com.avito.android.permissions.LocationPermissionProviderImpl;
import com.avito.android.permissions.LocationPermissionProviderImpl_Factory;
import com.avito.android.preferences.UpdateStorage;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistry;
import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistryImpl_Factory;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenterImpl;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenterImpl_Factory;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.StoriesApi;
import com.avito.android.remote.cart.CartApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.SearchParamsConverterImpl_Factory;
import com.avito.android.remote.model.SuggestParamsConverter;
import com.avito.android.remote.model.SuggestParamsConverterImpl;
import com.avito.android.remote.model.SuggestParamsConverterImpl_Factory;
import com.avito.android.scroll_tracker.SnippetScrollDepthTracker;
import com.avito.android.scroll_tracker.SnippetScrollDepthTrackerImpl_Factory;
import com.avito.android.search.SearchDeepLinkInteractor;
import com.avito.android.search.SearchDeepLinkInteractorImpl;
import com.avito.android.search.SearchDeepLinkInteractorImpl_Factory;
import com.avito.android.serp.BannerInfoFactory;
import com.avito.android.serp.BannerInfoFactoryImpl_Factory;
import com.avito.android.serp.CommercialBannerTimeProviderImpl_Factory;
import com.avito.android.serp.CommercialBannersAnalyticsInteractorImpl;
import com.avito.android.serp.CommercialBannersAnalyticsInteractorImpl_Factory;
import com.avito.android.serp.CommercialBannersInteractor;
import com.avito.android.serp.CommercialBannersInteractorImpl;
import com.avito.android.serp.CommercialBannersInteractorImpl_Factory;
import com.avito.android.serp.SerpItemProcessor;
import com.avito.android.serp.ad.AdResourceProvider;
import com.avito.android.serp.ad.DfpBannerLoader;
import com.avito.android.serp.ad.DfpBannerLoaderImpl;
import com.avito.android.serp.ad.DfpBannerLoaderImpl_Factory;
import com.avito.android.serp.ad.HomeAdResourceProviderImpl_Factory;
import com.avito.android.serp.ad.MyTargetBannerLoader;
import com.avito.android.serp.ad.MyTargetBannerLoaderImpl;
import com.avito.android.serp.ad.MyTargetBannerLoaderImpl_Factory;
import com.avito.android.serp.ad.MyTargetImageBgProvider;
import com.avito.android.serp.ad.YandexBannerLoader;
import com.avito.android.serp.ad.YandexBannerLoaderImpl;
import com.avito.android.serp.ad.YandexBannerLoaderImpl_Factory;
import com.avito.android.serp.adapter.AdvertGridItemPresenter;
import com.avito.android.serp.adapter.AdvertItemDoubleBlueprint;
import com.avito.android.serp.adapter.AdvertItemGridBlueprint;
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
import com.avito.android.serp.adapter.adstub.EmptyAdStubItemBlueprint;
import com.avito.android.serp.adapter.adstub.EmptyAdStubItemBlueprint_Factory;
import com.avito.android.serp.adapter.adstub.EmptyAdStubItemPresenter;
import com.avito.android.serp.adapter.adstub.EmptyAdStubItemPresenterImpl_Factory;
import com.avito.android.serp.adapter.adstub.NotLoadAdStubGridBlueprint;
import com.avito.android.serp.adapter.adstub.NotLoadAdStubGridBlueprint_Factory;
import com.avito.android.serp.adapter.adstub.NotLoadAdStubPresenter_Factory;
import com.avito.android.serp.adapter.advert_xl.SerpAdvertXlConverter;
import com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemConverter;
import com.avito.android.serp.adapter.empty_search.EmptySearchItemConverter;
import com.avito.android.serp.adapter.item_sorter.SerpItemSorter;
import com.avito.android.serp.adapter.location_notification.LocationNotificationActionData;
import com.avito.android.serp.adapter.location_notification.LocationNotificationItemBlueprint;
import com.avito.android.serp.adapter.location_notification.LocationNotificationItemBlueprint_Factory;
import com.avito.android.serp.adapter.location_notification.LocationNotificationItemConverter;
import com.avito.android.serp.adapter.location_notification.LocationNotificationItemPresenter;
import com.avito.android.serp.adapter.location_notification.LocationNotificationItemPresenterImpl;
import com.avito.android.serp.adapter.location_notification.LocationNotificationItemPresenterImpl_Factory;
import com.avito.android.serp.adapter.map_banner.MapBannerItemConverter;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandler;
import com.avito.android.serp.adapter.promo_card.PromoCardConverter;
import com.avito.android.serp.adapter.promo_card.ReportBannerConverter;
import com.avito.android.serp.adapter.skeleton.AdvertItemGridSkeletonBlueprint;
import com.avito.android.serp.adapter.skeleton.AdvertItemGridSkeletonBlueprint_Factory;
import com.avito.android.serp.adapter.skeleton.SkeletonGenerator;
import com.avito.android.serp.adapter.skeleton.SkeletonGenerator_Impl_Factory;
import com.avito.android.serp.adapter.skeleton.SkeletonPresenter;
import com.avito.android.serp.adapter.skeleton.SkeletonPresenterImpl_Factory;
import com.avito.android.serp.adapter.snippet.SnippetBlueprint;
import com.avito.android.serp.adapter.snippet.SnippetBlueprint_Factory;
import com.avito.android.serp.adapter.snippet.SnippetConverter;
import com.avito.android.serp.adapter.snippet.SnippetItem;
import com.avito.android.serp.adapter.snippet.SnippetPresenter;
import com.avito.android.serp.adapter.snippet.SnippetPresenter_Impl_Factory;
import com.avito.android.serp.adapter.title.GroupTitleItemConverter;
import com.avito.android.serp.adapter.vertical_main.VerticalFilterItemConverter;
import com.avito.android.serp.adapter.warning.SerpWarningConverter;
import com.avito.android.serp.adapter.witcher.WitcherAnalyticsInteractor;
import com.avito.android.serp.adapter.witcher.WitcherAnalyticsInteractorImpl;
import com.avito.android.serp.adapter.witcher.WitcherAnalyticsInteractorImpl_Factory;
import com.avito.android.serp.adapter.witcher.WitcherElementConverter;
import com.avito.android.serp.adapter.witcher.WitcherItemBlueprint;
import com.avito.android.serp.adapter.witcher.WitcherItemBlueprint_Factory;
import com.avito.android.serp.adapter.witcher.WitcherItemPresenter;
import com.avito.android.serp.adapter.witcher.WitcherItemPresenterImpl;
import com.avito.android.serp.adapter.witcher.WitcherItemPresenterImpl_Factory;
import com.avito.android.serp.adapter.witcher.WitcherResourceProvider;
import com.avito.android.serp.adapter.witcher.WitcherResourceProviderImpl;
import com.avito.android.serp.adapter.witcher.WitcherResourceProviderImpl_Factory;
import com.avito.android.serp.analytics.BannerPageSource;
import com.avito.android.server_time.TimeSource;
import com.avito.android.stories.LocalStartupBannerInteractor;
import com.avito.android.stories.LocalStartupBannerInteractor_Factory;
import com.avito.android.stories.StartupBannerInteractor;
import com.avito.android.stories.StoriesInteractorImpl;
import com.avito.android.stories.StoriesInteractorImpl_Factory;
import com.avito.android.stories.adapter.StoriesItemBlueprint;
import com.avito.android.stories.adapter.StoriesItemBlueprint_Factory;
import com.avito.android.stories.adapter.StoriesItemPresenterImpl;
import com.avito.android.stories.adapter.StoriesItemPresenterImpl_Factory;
import com.avito.android.ui.ActivityInteractor;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.Kundle;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.SearchContextWrapper;
import com.avito.android.util.WeakHandler;
import com.avito.android.util.preferences.Preferences;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.facebook.network.connectionclass.ConnectionClassManager;
import com.google.common.base.Optional;
import com.jakewharton.rxrelay3.Relay;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import io.reactivex.Observable;
import java.util.Locale;
import java.util.Set;
import javax.inject.Provider;
import kotlin.Pair;
import ru.avito.component.shortcut_navigation_bar.ShortcutNavigationItemConverter;
import ru.avito.component.shortcut_navigation_bar.ShortcutNavigationItemConverterImpl_Factory;
public final class DaggerHomeComponent implements HomeComponent {
    public static final Provider X3 = InstanceFactory.create(Optional.absent());
    public Provider<Analytics> A;
    public Provider<SavedLocationInteractor> A0;
    public Provider<DfpAppInstallPresenterImpl> A1;
    public Provider<SkeletonPresenter> A2;
    public Provider<HomeSkeletonTestGroup> A3;
    public Provider<AccountStateProvider> B;
    public Provider<IdProvider> B0;
    public Provider<DfpAppInstallPresenter> B1;
    public Provider<AdvertItemGridSkeletonBlueprint> B2;
    public Provider<HomeNewRubricatorTestGroup> B3;
    public Provider<FavoriteAdvertsAnalyticsInteractorImpl> C;
    public Provider<SearchDeepLinkInteractorImpl> C0;
    public Provider<DfpAppInstallSingleBlueprint> C1;
    public Provider<ItemBlueprint<?, ?>> C2;
    public Provider<HomePresenterState> C3;
    public Provider<SchedulersFactory3> D;
    public Provider<SearchDeepLinkInteractor> D0;
    public Provider<MyTargetContentPresenterImpl> D1;
    public Provider<Set<ItemBlueprint<?, ?>>> D2;
    public Provider<HomePresenterImpl> D3;
    public Provider<FavoriteAdvertsInteractorImpl> E;
    public Provider<StoriesApi> E0;
    public Provider<MyTargetContentPresenter> E1;
    public Provider<ItemBinder> E2;
    public Provider<CallableResponsiveItemPresenterRegistry> E3;
    public Provider<FavoriteStatusResolver> F;
    public Provider<Preferences> F0;
    public Provider<MyTargetContentSingleBlueprint> F1;
    public Provider<AdapterPresenter> F2;
    public Provider<ResponsiveAdapterPresenterImpl> F3;
    public Provider<ViewedAdvertsDao> G;
    public Provider<TimeSource> G0;
    public Provider<MyTargetAppInstallPresenterImpl> G1;
    public Provider<ErrorFormatterImpl> G2;
    public Provider<ResponsiveAdapterPresenter> G3;
    public Provider<ViewedAdvertsEventInteractor> H;
    public Provider<StoriesInteractorImpl> H0;
    public Provider<MyTargetAppInstallPresenter> H1;
    public Provider<ErrorFormatter> H2;
    public Provider<SpanLookup> H3;
    public Provider<ViewedAdvertsInteractor> I;
    public Provider<ConnectivityProvider> I0;
    public Provider<MyTargetAppInstallSingleBlueprint> I1;
    public Provider<SnippetScrollDepthAnalyticsInteractorImpl> I2;
    public Provider<GridLayoutManager.SpanSizeLookup> I3;
    public Provider<ViewedStatusResolver> J;
    public Provider<AntifraudStartupBannerTestGroup> J0;
    public Provider<NotLoadAdStubGridBlueprint> J1;
    public Provider<SnippetScrollDepthAnalyticsInteractor> J2;
    public Provider<DestroyableViewHolderBuilder> J3;
    public Provider<WitcherElementConverter> K;
    public Provider<LocalStartupBannerInteractor> K0;
    public Provider<EmptyAdStubItemPresenter> K1;
    public Provider<SnippetScrollDepthTracker> K2;
    public Provider<NetworkInfoChangeListener> K3;
    public Provider<LocationNotificationItemConverter> L;
    public Provider<StartupBannerInteractor> L0;
    public Provider<EmptyAdStubItemBlueprint> L1;
    public Provider<HomePresenterResourcesProviderImpl> L2;
    public Provider<Set<NetworkInfoChangeListener>> L3;
    public Provider<SellerElementConverter> M;
    public Provider<ScreenTrackerFactory> M0;
    public Provider<AppendingLoaderItemPresenter> M1;
    public Provider<HomePresenterResourcesProvider> M2;
    public Provider<NetworkInfoBroadcastReceiver> M3;
    public Provider<ReportBannerConverter> N;
    public Provider<TimerFactory> N0;
    public Provider<AppendingLoaderItemBlueprint> N1;
    public Provider<SpannedGridPositionProvider> N2;
    public Provider<ViewModelStoreOwner> N3;
    public Provider<PromoCardConverter> O;
    public Provider<HomeTrackerImpl> O0;
    public Provider<AppendingLargeLoaderItemBlueprint> O1;
    public Provider<SerpSpanProvider> O2;
    public Provider<CartApi> O3;
    public Provider<MapBannerItemConverter> P;
    public Provider<HomeTracker> P0;
    public Provider<AppendingRetryItemPresenter> P1;
    public Provider<ShortcutNavigationItemConverter> P2;
    public Provider<CartFabRepositoryImpl> P3;
    public Provider<VerticalFilterItemConverter> Q;
    public Provider<LocationAnalyticsInteractorImpl> Q0;
    public Provider<AppendingRetryItemBlueprint> Q1;
    public Provider<ConnectionManager> Q2;
    public Provider<CartFabRepository> Q3;
    public Provider<SerpElementItemConverter> R;
    public Provider<LocationAnalyticsInteractor> R0;
    public Provider<AppendingLargeRetryItemBlueprint> R1;
    public Provider<Application> R2;
    public Provider<CartFabPreferencesImpl> R3;
    public Provider<SerpItemSorter> S;
    public Provider<HomeInteractorState> S0;
    public Provider<AppendingEmptyItemPresenter> S1;
    public Provider<ConnectivityManager> S2;
    public Provider<CartFabPreferences> S3;
    public Provider<SerpItemSizeAdjuster> T;
    public Provider<HomeInteractorImpl> T0;
    public Provider<AppendingEmptyItemBlueprint> T1;
    public Provider<ConnectionClassManager> T2;
    public Provider<Optional<SearchContextWrapper>> T3;
    public Provider<SerpItemProcessor> U;
    public Provider<HomeInteractor> U0;
    public Provider<SectionTabsItemPresenter> U1;
    public Provider<ConnectionQualityInteractor> U2;
    public Provider<CartFabViewModelFactory> U3;
    public Provider<HiddenAdvertsStorage> V;
    public Provider<Bundle> V0;
    public Provider<SectionTabsItemBlueprint> V1;
    public Provider<ConnectionQualitySubscriber> V2;
    public Provider<CartFabViewModel> V3;
    public Provider<HiddenAdvertsInteractorImpl> W;
    public Provider<FloatingViewsPresenterImpl> W0;
    public Provider<com.avito.android.home.tabs_item.skeleton.SkeletonPresenter> W1;
    public Provider<FavoriteAdvertsPresenter> W2;
    public Provider<CartQuantityChangesHandler> W3;
    public Provider<HiddenAdvertsInteractor> X;
    public Provider<PersistableFloatingViewsPresenter> X0;
    public Provider<SkeletonSectionTabsItemBlueprint> X1;
    public Provider<Activity> X2;
    public Provider<MoreActionsItemProcessorImpl> Y;
    public Provider<HomePresenter> Y0;
    public Provider<Relay<Pair<SnippetItem, Integer>>> Y1;
    public Provider<GeoStorage> Y2;
    public Provider<MoreActionsItemProcessor> Z;
    public Provider<SerpOnboardingHandler> Z0;
    public Provider<Relay<Pair<SnippetItem, Integer>>> Z1;
    public Provider<DefaultLocationInteractor> Z2;
    public final SerpDependencies a;
    public Provider<Context> a0;
    public Provider<AdvertGridItemPresenter> a1;

    /* renamed from: a2  reason: collision with root package name */
    public Provider<Relay<Pair<SnippetItem, Boolean>>> f54a2;
    public Provider<DefaultLocationProvider> a3;
    public final ScreenAnalyticsDependencies b;
    public Provider<BuildInfo> b0;
    public Provider<Locale> b1;
    public Provider<SnippetPresenter.Impl> b2;
    public Provider<ActivityInteractor> b3;
    public final Screen c;
    public Provider<DfpBannerLoaderImpl> c0;
    public Provider<ExposedAbTestGroup<PriceOnTopTestGroup>> c1;
    public Provider<SnippetPresenter> c2;
    public Provider<WeakHandler> c3;
    public final HomeDependencies d;
    public Provider<DfpBannerLoader> d0;
    public Provider<SerpItemsPrefetchTestGroup> d1;
    public Provider<SnippetBlueprint> d2;
    public Provider<DetectLocationHelper> d3;
    public Provider<LocationApi> e;
    public Provider<YandexBannerLoaderImpl> e0;
    public Provider<SerpItemAbViewConfig> e1;
    public Provider<StoriesItemPresenterImpl> e2;
    public Provider<SchedulersFactory> e3;
    public Provider<SearchApi> f;
    public Provider<YandexBannerLoader> f0;
    public Provider<AdvertItemGridBlueprint> f1;
    public Provider<StoriesItemBlueprint> f2;
    public Provider<DetectLocationInteractor> f3;
    public Provider<Resources> g;
    public Provider<MyTargetImageBgProvider> g0;
    public Provider<AdvertItemDoubleBlueprint> g1;
    public Provider<Relay<LocationNotificationActionData>> g2;
    public Provider<DetectLocationProviderImpl> g3;
    public Provider<AdvertSpanCountProvider> h;
    public Provider<MyTargetBannerLoaderImpl> h0;
    public Provider<SingleTextPresenter> h1;
    public Provider<Relay<LocationNotificationActionData>> h2;
    public Provider<DetectLocationProvider> h3;
    public Provider<AdvertSpanCountProvider> i;
    public Provider<MyTargetBannerLoader> i0;
    public Provider<HomeSerpHeaderBluePrint> i1;
    public Provider<LocationNotificationItemPresenterImpl> i2;
    public Provider<FindDetectLocationPresenterImpl> i3;
    public Provider<Features> j;
    public Provider<BannerPageSource> j0;
    public Provider<ExposedAbTestGroup<OrangeAdBadgeTestGroup>> j1;
    public Provider<LocationNotificationItemPresenter> j2;
    public Provider<FindDetectLocationPresenter> j3;
    public Provider<SerpAdvertConverter> k;
    public Provider<TreeStateIdGenerator> k0;
    public Provider<YandexContentItemPresenterImpl> k1;
    public Provider<LocationNotificationItemBlueprint> k2;
    public Provider<DefaultSearchLocationInteractor> k3;
    public Provider<SerpAdvertXlConverter> l = SingleCheck.provider(SerpItemConverterModule_ProvideAdvertXlConverterFactory.create(this.g, this.j));
    public Provider<HomeAnalyticsInteractorImpl> l0;
    public Provider<YandexContentItemPresenter> l1;
    public Provider<WitcherResourceProviderImpl> l2;
    public Provider<DefaultSearchLocationAnalyticsInteractor> l3;
    public Provider<AdResourceProvider> m;
    public Provider<HomeAnalyticsInteractor> m0;
    public Provider<YandexContentSingleGridBlueprint> m1;
    public Provider<WitcherResourceProvider> m2;
    public Provider<DefaultSearchLocationStorage> m3;
    public Provider<RandomKeyProvider> n;
    public Provider<TreeClickStreamParent> n0;
    public Provider<YandexAppInstallItemPresenterImpl> n1;
    public Provider<Kundle> n2;
    public Provider<Fragment> n3;
    public Provider<SerpCommercialBannerConverter> o;
    public Provider<CommercialBannersAnalyticsInteractorImpl> o0;
    public Provider<YandexAppInstallItemPresenter> o1;
    public Provider<WitcherAnalyticsInteractorImpl> o2;
    public Provider<LocationPermissionProviderImpl> o3;
    public Provider<DeepLinkFactory> p;
    public Provider<BannerInfoFactory> p0;
    public Provider<YandexAppInstallSingleItemBlueprint> p1;
    public Provider<WitcherAnalyticsInteractor> p2;
    public Provider<LocationPermissionProvider> p3;
    public Provider<ShortcutBannerConverter> q;
    public Provider<CommercialBannersInteractorImpl> q0;
    public Provider<AdfoxImageItemPresenterImpl> q1;
    public Provider<SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup>> q2;
    public Provider<LocationPermissionDialogPresenter> q3;
    public Provider<SerpWarningConverter> r;
    public Provider<CommercialBannersInteractor> r0;
    public Provider<AdfoxImageItemPresenter> r1;
    public Provider<WitcherItemPresenterImpl> r2;
    public Provider<DefaultSearchLocationPresenter> r3;
    public Provider<SnippetConverter> s;
    public Provider<SearchParamsConverter> s0;
    public Provider<AdfoxSingleGridBlueprint> s1;
    public Provider<WitcherItemPresenter> s2;
    public Provider<ViewedAdvertsPresenter> s3;
    public Provider<EmptySearchItemConverter> t;
    public Provider<SuggestParamsConverterImpl> t0;
    public Provider<DfpDebugPresenter> t1;
    public Provider<ItemBinder> t2;
    public Provider<UpdateStorage> t3;
    public Provider<GroupTitleItemConverter> u;
    public Provider<SuggestParamsConverter> u0;
    public Provider<DfpUnifiedPresenterImpl> u1;
    public Provider<ViewedAdvertsPresenter> u2;
    public Provider<BannerViewFilter> u3;
    public Provider<EmptyPlaceholderItemConverter> v;
    public Provider<TypedErrorThrowableConverter> v0;
    public Provider<DfpUnifiedPresenter> v1;
    public Provider<FavoriteAdvertsResourceProvider> v2;
    public Provider<Bundle> v3;
    public Provider<HeaderElementConverter> w;
    public Provider<SavedLocationStorage> w0;
    public Provider<DfpUnifiedSingleGridBlueprint> w1;
    public Provider<FavoriteAdvertsPresenter> w2;
    public Provider<ItemVisibilityTracker> w3;
    public Provider<FavoritesSyncDao> x;
    public Provider<TopLocationInteractor> x0;
    public Provider<DfpContentPresenterImpl> x1;
    public Provider<SimpleAdapterPresenter> x2;
    public Provider<AdvertItemActionsPresenterImpl> x3;
    public Provider<FavoriteAdvertsUploadInteractor> y;
    public Provider<BackNavigationLocationInteractor> y0;
    public Provider<DfpContentPresenter> y1;
    public Provider<DeviceMetrics> y2;
    public Provider<AdvertItemActionsPresenter> y3;
    public Provider<FavoriteAdvertsEventInteractor> z;
    public Provider<SavedLocationInteractorImpl> z0;
    public Provider<DfpContentSingleGridBlueprint> z1;
    public Provider<WitcherItemBlueprint> z2;
    public Provider<SkeletonGenerator> z3;

    public static class a0 implements Provider<MyTargetImageBgProvider> {
        public final SerpDependencies a;

        public a0(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MyTargetImageBgProvider get() {
            return (MyTargetImageBgProvider) Preconditions.checkNotNullFromComponent(this.a.myTargetImageBgProvider());
        }
    }

    public static final class b implements HomeComponent.Builder {
        public Resources a;
        public HomePresenterState b;
        public HomeInteractorState c;
        public Bundle d;
        public Bundle e;
        public Bundle f;
        public Bundle g;
        public Bundle h;
        public Activity i;
        public Fragment j;
        public ActivityInteractor k;
        public BannerPageSource l;
        public SerpDependencies m;
        public HomeDependencies n;
        public ScreenAnalyticsDependencies o;
        public Screen p;
        public LocationDependencies q;
        public Relay<Pair<SnippetItem, Integer>> r;
        public Relay<Pair<SnippetItem, Integer>> s;
        public Relay<Pair<SnippetItem, Boolean>> t;
        public Relay<LocationNotificationActionData> u;
        public Relay<LocationNotificationActionData> v;
        public SerpOnboardingHandler w;
        public Kundle x;

        public b(a aVar) {
        }

        @Override // com.avito.android.di.component.HomeComponent.Builder
        public HomeComponent.Builder activity(Activity activity) {
            this.i = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.di.component.HomeComponent.Builder
        public HomeComponent.Builder activityInteractor(ActivityInteractor activityInteractor) {
            this.k = (ActivityInteractor) Preconditions.checkNotNull(activityInteractor);
            return this;
        }

        @Override // com.avito.android.di.component.HomeComponent.Builder
        public HomeComponent.Builder bannerPageSource(BannerPageSource bannerPageSource) {
            this.l = (BannerPageSource) Preconditions.checkNotNull(bannerPageSource);
            return this;
        }

        @Override // com.avito.android.di.component.HomeComponent.Builder
        public HomeComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Resources.class);
            Preconditions.checkBuilderRequirement(this.i, Activity.class);
            Preconditions.checkBuilderRequirement(this.j, Fragment.class);
            Preconditions.checkBuilderRequirement(this.k, ActivityInteractor.class);
            Preconditions.checkBuilderRequirement(this.l, BannerPageSource.class);
            Preconditions.checkBuilderRequirement(this.m, SerpDependencies.class);
            Preconditions.checkBuilderRequirement(this.n, HomeDependencies.class);
            Preconditions.checkBuilderRequirement(this.o, ScreenAnalyticsDependencies.class);
            Preconditions.checkBuilderRequirement(this.p, Screen.class);
            Preconditions.checkBuilderRequirement(this.q, LocationDependencies.class);
            Preconditions.checkBuilderRequirement(this.r, Relay.class);
            Preconditions.checkBuilderRequirement(this.s, Relay.class);
            Preconditions.checkBuilderRequirement(this.t, Relay.class);
            Preconditions.checkBuilderRequirement(this.u, Relay.class);
            Preconditions.checkBuilderRequirement(this.v, Relay.class);
            return new DaggerHomeComponent(new AppendingEmptyModule(), new AppendingLoaderModule(), new AppendingRetryModule(), new ConnectionQualityInteractorModule(), new SectionTabsItemModule(), this.m, this.q, this.n, this.o, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.p, this.r, this.s, this.t, this.u, this.v, this.w, this.x, null);
        }

        @Override // com.avito.android.di.component.HomeComponent.Builder
        public HomeComponent.Builder defaultLocationInteractorState(Bundle bundle) {
            this.g = bundle;
            return this;
        }

        @Override // com.avito.android.di.component.HomeComponent.Builder
        public HomeComponent.Builder defaultLocationPresenterState(Bundle bundle) {
            this.f = bundle;
            return this;
        }

        @Override // com.avito.android.di.component.HomeComponent.Builder
        public HomeComponent.Builder floatingViewsPresenterState(Bundle bundle) {
            this.d = bundle;
            return this;
        }

        @Override // com.avito.android.di.component.HomeComponent.Builder
        public HomeComponent.Builder fragment(Fragment fragment) {
            this.j = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }

        @Override // com.avito.android.di.component.HomeComponent.Builder
        public HomeComponent.Builder homeDependencies(HomeDependencies homeDependencies) {
            this.n = (HomeDependencies) Preconditions.checkNotNull(homeDependencies);
            return this;
        }

        @Override // com.avito.android.di.component.HomeComponent.Builder
        public HomeComponent.Builder homeInteractorState(HomeInteractorState homeInteractorState) {
            this.c = homeInteractorState;
            return this;
        }

        @Override // com.avito.android.di.component.HomeComponent.Builder
        public HomeComponent.Builder homePresenterState(HomePresenterState homePresenterState) {
            this.b = homePresenterState;
            return this;
        }

        @Override // com.avito.android.di.component.HomeComponent.Builder
        public HomeComponent.Builder itemVisibilityTrackerState(Bundle bundle) {
            this.h = bundle;
            return this;
        }

        @Override // com.avito.android.di.component.HomeComponent.Builder
        public HomeComponent.Builder locationDependencies(LocationDependencies locationDependencies) {
            this.q = (LocationDependencies) Preconditions.checkNotNull(locationDependencies);
            return this;
        }

        @Override // com.avito.android.di.component.HomeComponent.Builder
        public HomeComponent.Builder locationNotificationClick(Relay relay) {
            this.u = (Relay) Preconditions.checkNotNull(relay);
            return this;
        }

        @Override // com.avito.android.di.component.HomeComponent.Builder
        public HomeComponent.Builder locationNotificationVisibility(Relay relay) {
            this.v = (Relay) Preconditions.checkNotNull(relay);
            return this;
        }

        @Override // com.avito.android.di.component.HomeComponent.Builder
        public HomeComponent.Builder resources(Resources resources) {
            this.a = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.di.component.HomeComponent.Builder
        public HomeComponent.Builder screen(Screen screen) {
            this.p = (Screen) Preconditions.checkNotNull(screen);
            return this;
        }

        @Override // com.avito.android.di.component.HomeComponent.Builder
        public HomeComponent.Builder screenAnalyticsDependencies(ScreenAnalyticsDependencies screenAnalyticsDependencies) {
            this.o = (ScreenAnalyticsDependencies) Preconditions.checkNotNull(screenAnalyticsDependencies);
            return this;
        }

        @Override // com.avito.android.di.component.HomeComponent.Builder
        public HomeComponent.Builder screenTrackerState(Bundle bundle) {
            this.e = bundle;
            return this;
        }

        @Override // com.avito.android.di.component.HomeComponent.Builder
        public HomeComponent.Builder serpDependencies(SerpDependencies serpDependencies) {
            this.m = (SerpDependencies) Preconditions.checkNotNull(serpDependencies);
            return this;
        }

        @Override // com.avito.android.di.component.HomeComponent.Builder
        public HomeComponent.Builder snippetClick(Relay relay) {
            this.r = (Relay) Preconditions.checkNotNull(relay);
            return this;
        }

        @Override // com.avito.android.di.component.HomeComponent.Builder
        public HomeComponent.Builder snippetClose(Relay relay) {
            this.s = (Relay) Preconditions.checkNotNull(relay);
            return this;
        }

        @Override // com.avito.android.di.component.HomeComponent.Builder
        public HomeComponent.Builder snippetVisibility(Relay relay) {
            this.t = (Relay) Preconditions.checkNotNull(relay);
            return this;
        }

        @Override // com.avito.android.di.component.HomeComponent.Builder
        public HomeComponent.Builder withSerpOnboardingHandler(SerpOnboardingHandler serpOnboardingHandler) {
            this.w = null;
            return this;
        }

        @Override // com.avito.android.di.component.HomeComponent.Builder
        public HomeComponent.Builder withWitcherSavedState(Kundle kundle) {
            this.x = kundle;
            return this;
        }
    }

    public static class b0 implements Provider<ExposedAbTestGroup<OrangeAdBadgeTestGroup>> {
        public final SerpDependencies a;

        public b0(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ExposedAbTestGroup<OrangeAdBadgeTestGroup> get() {
            return (ExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.orangeAdBadgeTestGroup());
        }
    }

    public static class c implements Provider<DefaultSearchLocationStorage> {
        public final HomeDependencies a;

        public c(HomeDependencies homeDependencies) {
            this.a = homeDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DefaultSearchLocationStorage get() {
            return (DefaultSearchLocationStorage) Preconditions.checkNotNullFromComponent(this.a.defaultSearchLocationStorage());
        }
    }

    public static class c0 implements Provider<Preferences> {
        public final SerpDependencies a;

        public c0(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Preferences get() {
            return (Preferences) Preconditions.checkNotNullFromComponent(this.a.preferences());
        }
    }

    public static class d implements Provider<GeoStorage> {
        public final HomeDependencies a;

        public d(HomeDependencies homeDependencies) {
            this.a = homeDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public GeoStorage get() {
            return (GeoStorage) Preconditions.checkNotNullFromComponent(this.a.geoStorage());
        }
    }

    public static class d0 implements Provider<SerpItemsPrefetchTestGroup> {
        public final SerpDependencies a;

        public d0(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SerpItemsPrefetchTestGroup get() {
            return (SerpItemsPrefetchTestGroup) Preconditions.checkNotNullFromComponent(this.a.prefetchTestGroup());
        }
    }

    public static class e implements Provider<HiddenAdvertsStorage> {
        public final HomeDependencies a;

        public e(HomeDependencies homeDependencies) {
            this.a = homeDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HiddenAdvertsStorage get() {
            return (HiddenAdvertsStorage) Preconditions.checkNotNullFromComponent(this.a.hiddenAdvertsStorage());
        }
    }

    public static class e0 implements Provider<ExposedAbTestGroup<PriceOnTopTestGroup>> {
        public final SerpDependencies a;

        public e0(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ExposedAbTestGroup<PriceOnTopTestGroup> get() {
            return (ExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.priceOnTop());
        }
    }

    public static class f implements Provider<HomeNewRubricatorTestGroup> {
        public final HomeDependencies a;

        public f(HomeDependencies homeDependencies) {
            this.a = homeDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HomeNewRubricatorTestGroup get() {
            return (HomeNewRubricatorTestGroup) Preconditions.checkNotNullFromComponent(this.a.homeNewRubricatorTestGroup());
        }
    }

    public static class f0 implements Provider<RandomKeyProvider> {
        public final SerpDependencies a;

        public f0(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public RandomKeyProvider get() {
            return (RandomKeyProvider) Preconditions.checkNotNullFromComponent(this.a.randomKeyProvider());
        }
    }

    public static class g implements Provider<HomeSkeletonTestGroup> {
        public final HomeDependencies a;

        public g(HomeDependencies homeDependencies) {
            this.a = homeDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HomeSkeletonTestGroup get() {
            return (HomeSkeletonTestGroup) Preconditions.checkNotNullFromComponent(this.a.homeSkeletonTestGroup());
        }
    }

    public static class g0 implements Provider<SchedulersFactory3> {
        public final SerpDependencies a;

        public g0(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class h implements Provider<AntifraudStartupBannerTestGroup> {
        public final HomeDependencies a;

        public h(HomeDependencies homeDependencies) {
            this.a = homeDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AntifraudStartupBannerTestGroup get() {
            return (AntifraudStartupBannerTestGroup) Preconditions.checkNotNullFromComponent(this.a.startupBannerTestGroup());
        }
    }

    public static class h0 implements Provider<SchedulersFactory> {
        public final SerpDependencies a;

        public h0(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class i implements Provider<StoriesApi> {
        public final HomeDependencies a;

        public i(HomeDependencies homeDependencies) {
            this.a = homeDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public StoriesApi get() {
            return (StoriesApi) Preconditions.checkNotNullFromComponent(this.a.storiesApi());
        }
    }

    public static class i0 implements Provider<SearchApi> {
        public final SerpDependencies a;

        public i0(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SearchApi get() {
            return (SearchApi) Preconditions.checkNotNullFromComponent(this.a.searchApi());
        }
    }

    public static class j implements Provider<UpdateStorage> {
        public final HomeDependencies a;

        public j(HomeDependencies homeDependencies) {
            this.a = homeDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public UpdateStorage get() {
            return (UpdateStorage) Preconditions.checkNotNullFromComponent(this.a.updateStorage());
        }
    }

    public static class j0 implements Provider<TimeSource> {
        public final SerpDependencies a;

        public j0(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public static class k implements Provider<SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup>> {
        public final HomeDependencies a;

        public k(HomeDependencies homeDependencies) {
            this.a = homeDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup> get() {
            return (SingleManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.viewedItemsWidgetOnMainTestGroup());
        }
    }

    public static class k0 implements Provider<TreeStateIdGenerator> {
        public final SerpDependencies a;

        public k0(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TreeStateIdGenerator get() {
            return (TreeStateIdGenerator) Preconditions.checkNotNullFromComponent(this.a.treeStateIdGenerator());
        }
    }

    public static class l implements Provider<AccountStateProvider> {
        public final SerpDependencies a;

        public l(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class l0 implements Provider<TypedErrorThrowableConverter> {
        public final SerpDependencies a;

        public l0(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public static class m implements Provider<Analytics> {
        public final SerpDependencies a;

        public m(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class m0 implements Provider<ViewedAdvertsDao> {
        public final SerpDependencies a;

        public m0(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ViewedAdvertsDao get() {
            return (ViewedAdvertsDao) Preconditions.checkNotNullFromComponent(this.a.viewedAdvertsDao());
        }
    }

    public static class n implements Provider<Application> {
        public final SerpDependencies a;

        public n(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Application get() {
            return (Application) Preconditions.checkNotNullFromComponent(this.a.application());
        }
    }

    public static class n0 implements Provider<ViewedAdvertsEventInteractor> {
        public final SerpDependencies a;

        public n0(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ViewedAdvertsEventInteractor get() {
            return (ViewedAdvertsEventInteractor) Preconditions.checkNotNullFromComponent(this.a.viewedAdvertsEventInteractor());
        }
    }

    public static class o implements Provider<BuildInfo> {
        public final SerpDependencies a;

        public o(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BuildInfo get() {
            return (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo());
        }
    }

    public static class o0 implements Provider<ScreenTrackerFactory> {
        public final ScreenAnalyticsDependencies a;

        public o0(ScreenAnalyticsDependencies screenAnalyticsDependencies) {
            this.a = screenAnalyticsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class p implements Provider<CartApi> {
        public final SerpDependencies a;

        public p(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CartApi get() {
            return (CartApi) Preconditions.checkNotNullFromComponent(this.a.cartApi());
        }
    }

    public static class p0 implements Provider<TimerFactory> {
        public final ScreenAnalyticsDependencies a;

        public p0(ScreenAnalyticsDependencies screenAnalyticsDependencies) {
            this.a = screenAnalyticsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimerFactory get() {
            return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
        }
    }

    public static class q implements Provider<ConnectivityProvider> {
        public final SerpDependencies a;

        public q(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ConnectivityProvider get() {
            return (ConnectivityProvider) Preconditions.checkNotNullFromComponent(this.a.connectivityProvider());
        }
    }

    public static class q0 implements Provider<BackNavigationLocationInteractor> {
        public final LocationDependencies a;

        public q0(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BackNavigationLocationInteractor get() {
            return (BackNavigationLocationInteractor) Preconditions.checkNotNullFromComponent(this.a.backNavigationLocationInteractor());
        }
    }

    public static class r implements Provider<Context> {
        public final SerpDependencies a;

        public r(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public static class r0 implements Provider<LocationApi> {
        public final LocationDependencies a;

        public r0(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public LocationApi get() {
            return (LocationApi) Preconditions.checkNotNullFromComponent(this.a.locationApi());
        }
    }

    public static class s implements Provider<DeepLinkFactory> {
        public final SerpDependencies a;

        public s(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeepLinkFactory get() {
            return (DeepLinkFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkFactory());
        }
    }

    public static class s0 implements Provider<SavedLocationStorage> {
        public final LocationDependencies a;

        public s0(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SavedLocationStorage get() {
            return (SavedLocationStorage) Preconditions.checkNotNullFromComponent(this.a.savedLocationStorage());
        }
    }

    public static class t implements Provider<DeviceMetrics> {
        public final SerpDependencies a;

        public t(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeviceMetrics get() {
            return (DeviceMetrics) Preconditions.checkNotNullFromComponent(this.a.deviceMetrics());
        }
    }

    public static class t0 implements Provider<TopLocationInteractor> {
        public final LocationDependencies a;

        public t0(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TopLocationInteractor get() {
            return (TopLocationInteractor) Preconditions.checkNotNullFromComponent(this.a.topLocationInteractor());
        }
    }

    public static class u implements Provider<FavoriteAdvertsEventInteractor> {
        public final SerpDependencies a;

        public u(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsEventInteractor get() {
            return (FavoriteAdvertsEventInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsEventInteractor());
        }
    }

    public static class v implements Provider<FavoriteAdvertsUploadInteractor> {
        public final SerpDependencies a;

        public v(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsUploadInteractor get() {
            return (FavoriteAdvertsUploadInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsUploadInteractor());
        }
    }

    public static class w implements Provider<FavoritesSyncDao> {
        public final SerpDependencies a;

        public w(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoritesSyncDao get() {
            return (FavoritesSyncDao) Preconditions.checkNotNullFromComponent(this.a.favoritesSyncDao());
        }
    }

    public static class x implements Provider<Features> {
        public final SerpDependencies a;

        public x(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class y implements Provider<IdProvider> {
        public final SerpDependencies a;

        public y(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public IdProvider get() {
            return (IdProvider) Preconditions.checkNotNullFromComponent(this.a.idProvider());
        }
    }

    public static class z implements Provider<Locale> {
        public final SerpDependencies a;

        public z(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public DaggerHomeComponent(AppendingEmptyModule appendingEmptyModule, AppendingLoaderModule appendingLoaderModule, AppendingRetryModule appendingRetryModule, ConnectionQualityInteractorModule connectionQualityInteractorModule, SectionTabsItemModule sectionTabsItemModule, SerpDependencies serpDependencies, LocationDependencies locationDependencies, HomeDependencies homeDependencies, ScreenAnalyticsDependencies screenAnalyticsDependencies, Resources resources, HomePresenterState homePresenterState, HomeInteractorState homeInteractorState, Bundle bundle, Bundle bundle2, Bundle bundle3, Bundle bundle4, Bundle bundle5, Activity activity, Fragment fragment, ActivityInteractor activityInteractor, BannerPageSource bannerPageSource, Screen screen, Relay relay, Relay relay2, Relay relay3, Relay relay4, Relay relay5, SerpOnboardingHandler serpOnboardingHandler, Kundle kundle, a aVar) {
        this.a = serpDependencies;
        this.b = screenAnalyticsDependencies;
        this.c = screen;
        this.d = homeDependencies;
        this.e = new r0(locationDependencies);
        this.f = new i0(serpDependencies);
        Factory create = InstanceFactory.create(resources);
        this.g = create;
        this.h = SingleCheck.provider(SerpItemConverterModule_ProvideItemAdvertSpanCountProviderFactory.create(create));
        Provider<AdvertSpanCountProvider> provider = SingleCheck.provider(SerpItemConverterModule_ProvideBigAdvertSpanCountProviderFactory.create(this.g));
        this.i = provider;
        x xVar = new x(serpDependencies);
        this.j = xVar;
        this.k = SingleCheck.provider(SerpItemConverterModule_ProvideAdvertConverterFactory.create(this.h, provider, this.g, xVar));
        Provider<AdResourceProvider> provider2 = DoubleCheck.provider(HomeAdResourceProviderImpl_Factory.create());
        this.m = provider2;
        f0 f0Var = new f0(serpDependencies);
        this.n = f0Var;
        this.o = SingleCheck.provider(SerpItemConverterModule_ProvideCommercialConverterFactory.create(this.h, this.i, provider2, f0Var));
        s sVar = new s(serpDependencies);
        this.p = sVar;
        this.q = SingleCheck.provider(SerpItemConverterModule_ProvideShortcutBannerConverterFactory.create(sVar, this.g));
        this.r = SingleCheck.provider(SerpItemConverterModule_ProvideSerpWarningConverterFactory.create());
        this.s = SingleCheck.provider(SerpItemConverterModule_ProvideSnippetConverterFactory.create());
        this.t = SingleCheck.provider(SerpItemConverterModule_ProvideSerpEmptySearchConverterFactory.create());
        this.u = SingleCheck.provider(SerpItemConverterModule_ProvideGroupTitleItemConverterFactory.create());
        this.v = SingleCheck.provider(SerpItemConverterModule_ProvideEmptyPlaceholderItemConverterFactory.create());
        this.w = SingleCheck.provider(SerpItemConverterModule_ProvideHeaderElementConverterFactory.create());
        this.x = new w(serpDependencies);
        this.y = new v(serpDependencies);
        this.z = new u(serpDependencies);
        m mVar = new m(serpDependencies);
        this.A = mVar;
        l lVar = new l(serpDependencies);
        this.B = lVar;
        FavoriteAdvertsAnalyticsInteractorImpl_Factory create2 = FavoriteAdvertsAnalyticsInteractorImpl_Factory.create(mVar, lVar);
        this.C = create2;
        g0 g0Var = new g0(serpDependencies);
        this.D = g0Var;
        FavoriteAdvertsInteractorImpl_Factory create3 = FavoriteAdvertsInteractorImpl_Factory.create(this.x, this.y, this.z, create2, g0Var);
        this.E = create3;
        this.F = SingleCheck.provider(SerpItemConverterModule_ProvideFavoriteStatusResolverFactory.create(create3));
        this.G = new m0(serpDependencies);
        this.H = new n0(serpDependencies);
        Provider<ViewedAdvertsInteractor> provider3 = SingleCheck.provider(ViewedAdvertsModule_ProvideViewedAdvertsInteractorFactory.create(ViewedAdvertsInteractorFactoryImpl_Factory.create(), this.G, this.D, this.H, this.j));
        this.I = provider3;
        Provider<ViewedStatusResolver> provider4 = SingleCheck.provider(ViewedAdvertsModule_ProvideViewedStatusResolverFactory.create(provider3));
        this.J = provider4;
        this.K = SingleCheck.provider(SerpItemConverterModule_ProvideWitcherElementConverterFactory.create(this.k, this.F, provider4));
        this.L = SingleCheck.provider(SerpItemConverterModule_ProvideLocationNotificationConverterFactory.create());
        this.M = SingleCheck.provider(SerpItemConverterModule_ProvideSellerElementConverterFactory.create());
        this.N = SingleCheck.provider(SerpItemConverterModule_ProvideReportBannerConverterFactory.create(this.g, this.j));
        this.O = SingleCheck.provider(SerpItemConverterModule_ProvidePromoCardConverterFactory.create(this.g, this.j));
        this.P = SingleCheck.provider(SerpItemConverterModule_ProvideMapBannerConverterFactory.create());
        Provider<VerticalFilterItemConverter> provider5 = SingleCheck.provider(SerpItemConverterModule_ProvideVerticalFilterItemConverterFactory.create());
        this.Q = provider5;
        this.R = SingleCheck.provider(SerpItemConverterModule_ProvideElementItemConverterFactory.create(this.k, this.l, this.o, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.K, this.L, this.M, this.N, this.O, this.P, provider5));
        this.S = SingleCheck.provider(SerpItemConverterModule_ProvideSerpItemSorterFactory.create());
        Provider<SerpItemSizeAdjuster> provider6 = SingleCheck.provider(SerpItemConverterModule_ProvideItemSizeAdjusterFactory.create());
        this.T = provider6;
        this.U = SingleCheck.provider(SerpItemConverterModule_ProvideSerpItemProcessorFactory.create(this.R, this.S, provider6, this.F, this.J, this.D));
        e eVar = new e(homeDependencies);
        this.V = eVar;
        HiddenAdvertsInteractorImpl_Factory create4 = HiddenAdvertsInteractorImpl_Factory.create(this.f, eVar, this.D);
        this.W = create4;
        Provider<HiddenAdvertsInteractor> provider7 = SingleCheck.provider(create4);
        this.X = provider7;
        MoreActionsItemProcessorImpl_Factory create5 = MoreActionsItemProcessorImpl_Factory.create(provider7);
        this.Y = create5;
        this.Z = SingleCheck.provider(create5);
        r rVar = new r(serpDependencies);
        this.a0 = rVar;
        o oVar = new o(serpDependencies);
        this.b0 = oVar;
        DfpBannerLoaderImpl_Factory create6 = DfpBannerLoaderImpl_Factory.create(rVar, this.A, oVar, this.j);
        this.c0 = create6;
        this.d0 = DoubleCheck.provider(create6);
        YandexBannerLoaderImpl_Factory create7 = YandexBannerLoaderImpl_Factory.create(this.a0, this.D, this.A);
        this.e0 = create7;
        this.f0 = DoubleCheck.provider(create7);
        a0 a0Var = new a0(serpDependencies);
        this.g0 = a0Var;
        MyTargetBannerLoaderImpl_Factory create8 = MyTargetBannerLoaderImpl_Factory.create(this.a0, this.A, a0Var);
        this.h0 = create8;
        this.i0 = DoubleCheck.provider(create8);
        this.j0 = InstanceFactory.create(bannerPageSource);
        k0 k0Var = new k0(serpDependencies);
        this.k0 = k0Var;
        HomeAnalyticsInteractorImpl_Factory create9 = HomeAnalyticsInteractorImpl_Factory.create(this.A, k0Var, this.j);
        this.l0 = create9;
        Provider<HomeAnalyticsInteractor> provider8 = DoubleCheck.provider(create9);
        this.m0 = provider8;
        Provider<TreeClickStreamParent> provider9 = DoubleCheck.provider(HomeModule_ProvideSerpTreeParent$serp_releaseFactory.create(provider8));
        this.n0 = provider9;
        this.o0 = CommercialBannersAnalyticsInteractorImpl_Factory.create(this.j0, this.A, provider9, this.k0, CommercialBannerTimeProviderImpl_Factory.create());
        this.p0 = DoubleCheck.provider(BannerInfoFactoryImpl_Factory.create());
        CommercialBannersInteractorImpl_Factory create10 = CommercialBannersInteractorImpl_Factory.create(this.d0, this.f0, this.i0, this.o0, CommercialBannerTimeProviderImpl_Factory.create(), this.D, this.p0);
        this.q0 = create10;
        this.r0 = DoubleCheck.provider(create10);
        Provider<SearchParamsConverter> provider10 = DoubleCheck.provider(SearchParamsConverterImpl_Factory.create());
        this.s0 = provider10;
        SuggestParamsConverterImpl_Factory create11 = SuggestParamsConverterImpl_Factory.create(provider10);
        this.t0 = create11;
        this.u0 = DoubleCheck.provider(create11);
        this.v0 = new l0(serpDependencies);
        s0 s0Var = new s0(locationDependencies);
        this.w0 = s0Var;
        t0 t0Var = new t0(locationDependencies);
        this.x0 = t0Var;
        q0 q0Var = new q0(locationDependencies);
        this.y0 = q0Var;
        SavedLocationInteractorImpl_Factory create12 = SavedLocationInteractorImpl_Factory.create(s0Var, this.e, t0Var, this.j, q0Var);
        this.z0 = create12;
        this.A0 = SingleCheck.provider(create12);
        this.B0 = new y(serpDependencies);
        SearchDeepLinkInteractorImpl_Factory create13 = SearchDeepLinkInteractorImpl_Factory.create(this.f, this.s0, this.D);
        this.C0 = create13;
        this.D0 = DoubleCheck.provider(create13);
        i iVar = new i(homeDependencies);
        this.E0 = iVar;
        c0 c0Var = new c0(serpDependencies);
        this.F0 = c0Var;
        j0 j0Var = new j0(serpDependencies);
        this.G0 = j0Var;
        this.H0 = StoriesInteractorImpl_Factory.create(iVar, c0Var, this.v0, this.D, j0Var);
        q qVar = new q(serpDependencies);
        this.I0 = qVar;
        h hVar = new h(homeDependencies);
        this.J0 = hVar;
        LocalStartupBannerInteractor_Factory create14 = LocalStartupBannerInteractor_Factory.create(this.F0, qVar, hVar, this.j);
        this.K0 = create14;
        this.L0 = DoubleCheck.provider(create14);
        o0 o0Var = new o0(screenAnalyticsDependencies);
        this.M0 = o0Var;
        p0 p0Var = new p0(screenAnalyticsDependencies);
        this.N0 = p0Var;
        HomeTrackerImpl_Factory create15 = HomeTrackerImpl_Factory.create(o0Var, p0Var);
        this.O0 = create15;
        this.P0 = DoubleCheck.provider(create15);
        LocationAnalyticsInteractorImpl_Factory create16 = LocationAnalyticsInteractorImpl_Factory.create(this.A, this.G0);
        this.Q0 = create16;
        this.R0 = SingleCheck.provider(create16);
        Factory createNullable = InstanceFactory.createNullable(homeInteractorState);
        this.S0 = createNullable;
        HomeInteractorImpl_Factory create17 = HomeInteractorImpl_Factory.create(this.e, this.f, this.U, this.Z, this.r0, this.u0, this.v0, this.A0, this.B0, this.D, this.B, this.D0, this.H0, this.L0, this.P0, this.R0, createNullable);
        this.T0 = create17;
        this.U0 = DoubleCheck.provider(create17);
        Factory createNullable2 = InstanceFactory.createNullable(bundle);
        this.V0 = createNullable2;
        FloatingViewsPresenterImpl_Factory create18 = FloatingViewsPresenterImpl_Factory.create(createNullable2);
        this.W0 = create18;
        this.X0 = DoubleCheck.provider(create18);
        this.Y0 = new DelegateFactory();
        Factory createNullable3 = InstanceFactory.createNullable(serpOnboardingHandler);
        this.Z0 = createNullable3;
        this.a1 = SingleCheck.provider(AdvertItemPresenterModule_ProvideAdvertGridItemPresenterFactory.create(this.Y0, this.A, this.j, createNullable3));
        this.b1 = new z(serpDependencies);
        e0 e0Var = new e0(serpDependencies);
        this.c1 = e0Var;
        d0 d0Var = new d0(serpDependencies);
        this.d1 = d0Var;
        SerpItemAbViewConfig_Factory create19 = SerpItemAbViewConfig_Factory.create(e0Var, d0Var);
        this.e1 = create19;
        this.f1 = SingleCheck.provider(AdvertItemModule_ProvideAdvertItemGridBlueprintFactory.create(this.a1, this.G0, this.b1, create19, this.I0));
        this.g1 = SingleCheck.provider(AdvertItemModule_ProvideAdvertItemDoubleBlueprintFactory.create(this.a1, this.G0, this.b1, this.e1, this.I0));
        Provider<SingleTextPresenter> provider11 = DoubleCheck.provider(SingleTextPresenterImpl_Factory.create());
        this.h1 = provider11;
        this.i1 = HomeSerpHeaderBluePrint_Factory.create(provider11);
        b0 b0Var = new b0(serpDependencies);
        this.j1 = b0Var;
        YandexContentItemPresenterImpl_Factory create20 = YandexContentItemPresenterImpl_Factory.create(this.Y0, this.A, b0Var);
        this.k1 = create20;
        Provider<YandexContentItemPresenter> provider12 = DoubleCheck.provider(create20);
        this.l1 = provider12;
        this.m1 = YandexContentSingleGridBlueprint_Factory.create(provider12);
        YandexAppInstallItemPresenterImpl_Factory create21 = YandexAppInstallItemPresenterImpl_Factory.create(this.Y0, this.A);
        this.n1 = create21;
        Provider<YandexAppInstallItemPresenter> provider13 = DoubleCheck.provider(create21);
        this.o1 = provider13;
        this.p1 = YandexAppInstallSingleItemBlueprint_Factory.create(provider13);
        AdfoxImageItemPresenterImpl_Factory create22 = AdfoxImageItemPresenterImpl_Factory.create(this.Y0, this.A, this.j1);
        this.q1 = create22;
        Provider<AdfoxImageItemPresenter> provider14 = DoubleCheck.provider(create22);
        this.r1 = provider14;
        this.s1 = AdfoxSingleGridBlueprint_Factory.create(provider14);
        Provider<DfpDebugPresenter> provider15 = DoubleCheck.provider(DfpDebugPresenterImpl_Factory.create());
        this.t1 = provider15;
        DfpUnifiedPresenterImpl_Factory create23 = DfpUnifiedPresenterImpl_Factory.create(this.Y0, provider15, this.D);
        this.u1 = create23;
        Provider<DfpUnifiedPresenter> provider16 = DoubleCheck.provider(create23);
        this.v1 = provider16;
        this.w1 = DfpUnifiedSingleGridBlueprint_Factory.create(provider16);
        DfpContentPresenterImpl_Factory create24 = DfpContentPresenterImpl_Factory.create(this.Y0, this.t1);
        this.x1 = create24;
        Provider<DfpContentPresenter> provider17 = DoubleCheck.provider(create24);
        this.y1 = provider17;
        this.z1 = DfpContentSingleGridBlueprint_Factory.create(provider17);
        DfpAppInstallPresenterImpl_Factory create25 = DfpAppInstallPresenterImpl_Factory.create(this.Y0, this.t1);
        this.A1 = create25;
        Provider<DfpAppInstallPresenter> provider18 = DoubleCheck.provider(create25);
        this.B1 = provider18;
        this.C1 = DfpAppInstallSingleBlueprint_Factory.create(provider18);
        MyTargetContentPresenterImpl_Factory create26 = MyTargetContentPresenterImpl_Factory.create(this.Y0, this.g0, this.j);
        this.D1 = create26;
        Provider<MyTargetContentPresenter> provider19 = DoubleCheck.provider(create26);
        this.E1 = provider19;
        this.F1 = MyTargetContentSingleBlueprint_Factory.create(provider19);
        MyTargetAppInstallPresenterImpl_Factory create27 = MyTargetAppInstallPresenterImpl_Factory.create(this.Y0, this.g0, this.j);
        this.G1 = create27;
        Provider<MyTargetAppInstallPresenter> provider20 = DoubleCheck.provider(create27);
        this.H1 = provider20;
        this.I1 = MyTargetAppInstallSingleBlueprint_Factory.create(provider20);
        this.J1 = NotLoadAdStubGridBlueprint_Factory.create(NotLoadAdStubPresenter_Factory.create());
        Provider<EmptyAdStubItemPresenter> provider21 = DoubleCheck.provider(EmptyAdStubItemPresenterImpl_Factory.create());
        this.K1 = provider21;
        this.L1 = EmptyAdStubItemBlueprint_Factory.create(provider21);
        Provider<AppendingLoaderItemPresenter> provider22 = DoubleCheck.provider(AppendingLoaderModule_ProvideAppendingLoaderItemPresenterFactory.create(appendingLoaderModule));
        this.M1 = provider22;
        this.N1 = DoubleCheck.provider(AppendingLoaderModule_ProvideAppendingLoaderItemBlueprintFactory.create(appendingLoaderModule, provider22));
        this.O1 = DoubleCheck.provider(AppendingLoaderModule_ProvideAppendingLargeLoaderItemBlueprintFactory.create(appendingLoaderModule, this.M1));
        Provider<AppendingRetryItemPresenter> provider23 = DoubleCheck.provider(AppendingRetryModule_ProvideAppendingRetryItemPresenterFactory.create(appendingRetryModule));
        this.P1 = provider23;
        this.Q1 = DoubleCheck.provider(AppendingRetryModule_ProvideAppendingRetryItemBlueprintFactory.create(appendingRetryModule, provider23));
        this.R1 = DoubleCheck.provider(AppendingRetryModule_ProvideAppendingLargeRetryItemBlueprintFactory.create(appendingRetryModule, this.P1));
        Provider<AppendingEmptyItemPresenter> provider24 = DoubleCheck.provider(AppendingEmptyModule_ProvideAppendingEmptyPresenterFactory.create(appendingEmptyModule));
        this.S1 = provider24;
        this.T1 = DoubleCheck.provider(AppendingEmptyModule_ProvideAppendingEmptyBlueprintFactory.create(appendingEmptyModule, provider24));
        Provider<SectionTabsItemPresenter> provider25 = DoubleCheck.provider(SectionTabsItemModule_ProvideSectionTabsItemPresenterFactory.create(sectionTabsItemModule));
        this.U1 = provider25;
        this.V1 = DoubleCheck.provider(SectionTabsItemModule_ProvideSectionTabsItemBlueprintFactory.create(sectionTabsItemModule, provider25, this.F0));
        Provider<com.avito.android.home.tabs_item.skeleton.SkeletonPresenter> provider26 = DoubleCheck.provider(SectionTabsItemModule_ProvideSkeletonSectionTabsItemPresenterFactory.create(sectionTabsItemModule));
        this.W1 = provider26;
        this.X1 = SkeletonSectionTabsItemBlueprint_Factory.create(provider26);
        this.Y1 = InstanceFactory.create(relay);
        this.Z1 = InstanceFactory.create(relay2);
        Factory create28 = InstanceFactory.create(relay3);
        this.f54a2 = create28;
        SnippetPresenter_Impl_Factory create29 = SnippetPresenter_Impl_Factory.create(this.Y1, this.Z1, create28);
        this.b2 = create29;
        Provider<SnippetPresenter> provider27 = DoubleCheck.provider(create29);
        this.c2 = provider27;
        this.d2 = SnippetBlueprint_Factory.create(provider27);
        StoriesItemPresenterImpl_Factory create30 = StoriesItemPresenterImpl_Factory.create(this.Y0, this.A);
        this.e2 = create30;
        this.f2 = StoriesItemBlueprint_Factory.create(create30);
        this.g2 = InstanceFactory.create(relay4);
        Factory create31 = InstanceFactory.create(relay5);
        this.h2 = create31;
        LocationNotificationItemPresenterImpl_Factory create32 = LocationNotificationItemPresenterImpl_Factory.create(this.g2, create31);
        this.i2 = create32;
        Provider<LocationNotificationItemPresenter> provider28 = DoubleCheck.provider(create32);
        this.j2 = provider28;
        this.k2 = LocationNotificationItemBlueprint_Factory.create(provider28);
        WitcherResourceProviderImpl_Factory create33 = WitcherResourceProviderImpl_Factory.create(this.g);
        this.l2 = create33;
        this.m2 = DoubleCheck.provider(create33);
        this.n2 = InstanceFactory.createNullable(kundle);
        WitcherAnalyticsInteractorImpl_Factory create34 = WitcherAnalyticsInteractorImpl_Factory.create(this.A);
        this.o2 = create34;
        Provider<WitcherAnalyticsInteractor> provider29 = DoubleCheck.provider(create34);
        this.p2 = provider29;
        k kVar = new k(homeDependencies);
        this.q2 = kVar;
        WitcherItemPresenterImpl_Factory create35 = WitcherItemPresenterImpl_Factory.create(this.m2, this.Y0, this.n2, provider29, kVar);
        this.r2 = create35;
        this.s2 = SingleCheck.provider(create35);
        this.t2 = DoubleCheck.provider(WitcherModule_ProvidesWitcherItemsBinderFactory.create(this.f1));
        this.u2 = WitcherModule_ProvideWitcherViewedAdvertsPresenter$serp_core_releaseFactory.create(this.H, this.D);
        Provider<FavoriteAdvertsResourceProvider> provider30 = SingleCheck.provider(FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsResourceProvider$favorite_core_releaseFactory.create(this.g));
        this.v2 = provider30;
        this.w2 = WitcherModule_ProvideWitcherFavoriteAdvertsPresenter$serp_core_releaseFactory.create(this.E, provider30, this.D);
        WitcherModule_ProvideWitcherAdapter$serp_core_releaseFactory create36 = WitcherModule_ProvideWitcherAdapter$serp_core_releaseFactory.create(this.t2);
        this.x2 = create36;
        t tVar = new t(serpDependencies);
        this.y2 = tVar;
        this.z2 = WitcherItemBlueprint_Factory.create(this.s2, this.t2, this.m2, this.u2, this.w2, create36, tVar);
        Provider<SkeletonPresenter> provider31 = DoubleCheck.provider(SkeletonPresenterImpl_Factory.create());
        this.A2 = provider31;
        AdvertItemGridSkeletonBlueprint_Factory create37 = AdvertItemGridSkeletonBlueprint_Factory.create(provider31);
        this.B2 = create37;
        this.C2 = DoubleCheck.provider(create37);
        SetFactory build = SetFactory.builder(1, 0).addProvider(this.C2).build();
        this.D2 = build;
        Provider<ItemBinder> provider32 = DoubleCheck.provider(HomeModule_ProvideItemBinder$serp_releaseFactory.create(this.f1, this.g1, this.i1, this.m1, this.p1, this.s1, this.w1, this.z1, this.C1, this.F1, this.I1, this.J1, this.L1, this.N1, this.O1, this.Q1, this.R1, this.T1, this.V1, this.X1, this.d2, this.f2, this.k2, this.z2, build));
        this.E2 = provider32;
        this.F2 = DoubleCheck.provider(HomeModule_ProvideAdapterPresenter$serp_releaseFactory.create(provider32));
        ErrorFormatterImpl_Factory create38 = ErrorFormatterImpl_Factory.create(this.g);
        this.G2 = create38;
        this.H2 = DoubleCheck.provider(create38);
        SnippetScrollDepthAnalyticsInteractorImpl_Factory create39 = SnippetScrollDepthAnalyticsInteractorImpl_Factory.create(this.A);
        this.I2 = create39;
        this.J2 = DoubleCheck.provider(create39);
        this.K2 = DoubleCheck.provider(SnippetScrollDepthTrackerImpl_Factory.create());
        HomePresenterResourcesProviderImpl_Factory create40 = HomePresenterResourcesProviderImpl_Factory.create(this.g);
        this.L2 = create40;
        this.M2 = DoubleCheck.provider(create40);
        Provider<SpannedGridPositionProvider> provider33 = SingleCheck.provider(SpanAdapterModule_ProvideSpannedGridPositionProviderFactory.create(this.g));
        this.N2 = provider33;
        this.O2 = SingleCheck.provider(SpanAdapterModule_ProvideSerpSpanProviderFactory.create(provider33, this.g));
        this.P2 = DoubleCheck.provider(ShortcutNavigationItemConverterImpl_Factory.create());
        this.Q2 = SingleCheck.provider(ConnectionQualityInteractorModule_ProvideConnectionManager$connection_quality_releaseFactory.create(connectionQualityInteractorModule));
        n nVar = new n(serpDependencies);
        this.R2 = nVar;
        this.S2 = SingleCheck.provider(ConnectionQualityInteractorModule_ProvideConnectivityManager$connection_quality_releaseFactory.create(connectionQualityInteractorModule, nVar));
        Provider<ConnectionClassManager> provider34 = SingleCheck.provider(ConnectionQualityInteractorModule_ProvideConnectionClassManager$connection_quality_releaseFactory.create(connectionQualityInteractorModule));
        this.T2 = provider34;
        Provider<ConnectionQualityInteractor> provider35 = SingleCheck.provider(ConnectionQualityInteractorModule_ProvideConnectionQualityInteractor$connection_quality_releaseFactory.create(connectionQualityInteractorModule, this.S2, provider34));
        this.U2 = provider35;
        this.V2 = SingleCheck.provider(ConnectionQualityInteractorModule_ProvideConnectionClassSubscriber$connection_quality_releaseFactory.create(connectionQualityInteractorModule, this.Q2, provider35));
        this.W2 = SingleCheck.provider(FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsPresenter$favorite_core_releaseFactory.create(this.E, this.D, this.v2));
        this.X2 = InstanceFactory.create(activity);
        d dVar = new d(homeDependencies);
        this.Y2 = dVar;
        Provider<DefaultLocationInteractor> provider36 = DoubleCheck.provider(FindDetectLocationModule_ProvideDefaultLocationInteractorFactory.create(dVar));
        this.Z2 = provider36;
        this.a3 = DoubleCheck.provider(FindDetectLocationModule_ProvideDefaultLocationProviderFactory.create(provider36));
        this.b3 = InstanceFactory.create(activityInteractor);
        Provider<WeakHandler> provider37 = DoubleCheck.provider(FindDetectLocationModule_ProvideWeakHandler$user_location_releaseFactory.create());
        this.c3 = provider37;
        Provider<DetectLocationHelper> provider38 = DoubleCheck.provider(FindDetectLocationModule_ProvideDetectLocationHelper$user_location_releaseFactory.create(this.X2, this.b3, provider37));
        this.d3 = provider38;
        h0 h0Var = new h0(serpDependencies);
        this.e3 = h0Var;
        Provider<DetectLocationInteractor> provider39 = DoubleCheck.provider(FindDetectLocationModule_ProvideDetectLocationInteractor$user_location_releaseFactory.create(provider38, h0Var, this.Y2));
        this.f3 = provider39;
        DetectLocationProviderImpl_Factory create41 = DetectLocationProviderImpl_Factory.create(provider39);
        this.g3 = create41;
        Provider<DetectLocationProvider> provider40 = DoubleCheck.provider(create41);
        this.h3 = provider40;
        FindDetectLocationPresenterImpl_Factory create42 = FindDetectLocationPresenterImpl_Factory.create(this.a3, provider40);
        this.i3 = create42;
        Provider<FindDetectLocationPresenter> provider41 = DoubleCheck.provider(create42);
        this.j3 = provider41;
        this.k3 = DoubleCheck.provider(DefaultSearchLocationModule_ProvideDefaultLocationNotificationInteractor$serp_releaseFactory.create(this.D, this.X2, provider41));
        this.l3 = DoubleCheck.provider(DefaultSearchLocationModule_ProvideDefaultSearchLocationAnalyticsInteractorImpl$serp_releaseFactory.create(this.R0));
        this.m3 = new c(homeDependencies);
        Factory create43 = InstanceFactory.create(fragment);
        this.n3 = create43;
        LocationPermissionProviderImpl_Factory create44 = LocationPermissionProviderImpl_Factory.create(create43);
        this.o3 = create44;
        Provider<LocationPermissionProvider> provider42 = DoubleCheck.provider(create44);
        this.p3 = provider42;
        Provider<LocationPermissionDialogPresenter> provider43 = DoubleCheck.provider(DefaultSearchLocationModule_ProvideLocationPermissionDialogPresenter$serp_releaseFactory.create(provider42));
        this.q3 = provider43;
        this.r3 = DoubleCheck.provider(DefaultSearchLocationModule_ProvideDefaultLocationPresenter$serp_releaseFactory.create(this.k3, this.A0, this.l3, this.L0, this.D, this.Y2, this.m3, this.G0, provider43));
        this.s3 = SingleCheck.provider(ViewedAdvertsModule_ProvideViewedAdvertsPresenterFactory.create(this.H, this.D));
        this.t3 = new j(homeDependencies);
        this.u3 = BannerViewFilter_Factory.create(this.o0);
        Factory createNullable4 = InstanceFactory.createNullable(bundle5);
        this.v3 = createNullable4;
        this.w3 = DoubleCheck.provider(HomeModule_ProvideItemVisibilityTracker$serp_releaseFactory.create(this.u3, createNullable4));
        AdvertItemActionsPresenterImpl_Factory create45 = AdvertItemActionsPresenterImpl_Factory.create(this.X, this.A, this.D);
        this.x3 = create45;
        this.y3 = SingleCheck.provider(create45);
        this.z3 = DoubleCheck.provider(SkeletonGenerator_Impl_Factory.create());
        this.A3 = new g(homeDependencies);
        this.B3 = new f(homeDependencies);
        Factory createNullable5 = InstanceFactory.createNullable(homePresenterState);
        this.C3 = createNullable5;
        HomePresenterImpl_Factory create46 = HomePresenterImpl_Factory.create(this.U0, this.X0, this.F2, this.P1, this.H2, this.m0, this.J2, this.K2, this.o0, this.D, this.M2, this.O2, this.P2, this.N2, this.V2, this.W2, this.r3, this.s3, this.U1, this.Y1, this.g2, this.h2, this.j, this.t3, this.B0, this.P0, this.w3, this.y3, this.R0, this.Y2, this.z3, this.A3, this.B3, createNullable5);
        this.D3 = create46;
        DelegateFactory.setDelegate(this.Y0, DoubleCheck.provider(create46));
        Provider<CallableResponsiveItemPresenterRegistry> provider44 = DoubleCheck.provider(CallableResponsiveItemPresenterRegistryImpl_Factory.create());
        this.E3 = provider44;
        ResponsiveAdapterPresenterImpl_Factory create47 = ResponsiveAdapterPresenterImpl_Factory.create(this.F2, provider44);
        this.F3 = create47;
        this.G3 = DoubleCheck.provider(create47);
        SpanLookup_Factory create48 = SpanLookup_Factory.create(this.O2);
        this.H3 = create48;
        this.I3 = SingleCheck.provider(create48);
        this.J3 = DoubleCheck.provider(HomeModule_ProvideDestroyableViewHolderBuilder$serp_releaseFactory.create(this.E2));
        this.K3 = SingleCheck.provider(ConnectionQualityInteractorModule_ProvideConnectionQualityNetworkListenerFactory.create(connectionQualityInteractorModule, this.U2));
        SetFactory build2 = SetFactory.builder(1, 0).addProvider(this.K3).build();
        this.L3 = build2;
        this.M3 = SingleCheck.provider(ConnectionQualityInteractorModule_ProvideNetworkInfoBroadcastReceiver$connection_quality_releaseFactory.create(connectionQualityInteractorModule, build2));
        this.N3 = DoubleCheck.provider(this.n3);
        p pVar = new p(serpDependencies);
        this.O3 = pVar;
        CartFabRepositoryImpl_Factory create49 = CartFabRepositoryImpl_Factory.create(pVar, this.D);
        this.P3 = create49;
        this.Q3 = SingleCheck.provider(create49);
        CartFabPreferencesImpl_Factory create50 = CartFabPreferencesImpl_Factory.create(this.F0);
        this.R3 = create50;
        Provider<CartFabPreferences> provider45 = SingleCheck.provider(create50);
        this.S3 = provider45;
        Provider<Optional<SearchContextWrapper>> provider46 = X3;
        this.T3 = provider46;
        CartFabViewModelFactory_Factory create51 = CartFabViewModelFactory_Factory.create(this.j, this.Q3, provider45, this.B, this.D, this.A, provider46);
        this.U3 = create51;
        this.V3 = SingleCheck.provider(CartFabModule_ProvideCartFabViewModelFactory.create(this.N3, create51));
        this.W3 = SingleCheck.provider(CartFabQuantityVisibilityHandler_Factory.create());
    }

    public static HomeComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.di.component.HomeComponent
    public void inject(HomeFragment homeFragment) {
        HomeFragment_MembersInjector.injectPresenter(homeFragment, this.Y0.get());
        HomeFragment_MembersInjector.injectResourceProvider(homeFragment, this.M2.get());
        HomeFragment_MembersInjector.injectAnalytics(homeFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        HomeFragment_MembersInjector.injectItemVisibilityTracker(homeFragment, this.w3.get());
        HomeFragment_MembersInjector.injectAnalyticsInteractor(homeFragment, this.m0.get());
        HomeFragment_MembersInjector.injectFeatures(homeFragment, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        HomeFragment_MembersInjector.injectFloatingViewsPresenter(homeFragment, this.X0.get());
        HomeFragment_MembersInjector.injectInteractor(homeFragment, this.U0.get());
        HomeFragment_MembersInjector.injectAdapterPresenter(homeFragment, this.G3.get());
        HomeFragment_MembersInjector.injectSpanSizeLookup(homeFragment, this.I3.get());
        HomeFragment_MembersInjector.injectIntentFactory(homeFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        HomeFragment_MembersInjector.injectDeepLinkIntentFactory(homeFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        HomeFragment_MembersInjector.injectGridPositionProvider(homeFragment, this.N2.get());
        HomeFragment_MembersInjector.injectDestroyableViewHolderBuilder(homeFragment, this.J3.get());
        HomeFragment_MembersInjector.injectNetworkInfoBroadcastReceiver(homeFragment, this.M3.get());
        HomeFragment_MembersInjector.injectFavoriteAdvertsPresenter(homeFragment, this.W2.get());
        HomeFragment_MembersInjector.injectAdvertItemActionsPresenter(homeFragment, this.y3.get());
        HomeFragment_MembersInjector.injectDefaultLocationPresenter(homeFragment, this.r3.get());
        HomeFragment_MembersInjector.injectDefaultSearchLocationInteractor(homeFragment, this.k3.get());
        HomeFragment_MembersInjector.injectDefaultLocationInteractor(homeFragment, this.Z2.get());
        HomeFragment_MembersInjector.injectSchedulers(homeFragment, (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3()));
        HomeFragment_MembersInjector.injectSupplier(homeFragment, new FpsStateSupplier(new FpsMetricsSupplier.Impl((Observable) Preconditions.checkNotNullFromComponent(this.b.frameStream()), (FpsMetricsTracker) Preconditions.checkNotNullFromComponent(this.b.fpsMetricsTracker()), this.c, this.b.fpsTrackingThreshold(), (Features) Preconditions.checkNotNullFromComponent(this.a.features())), (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo())));
        HomeFragment_MembersInjector.injectViewedAdvertsPresenter(homeFragment, this.s3.get());
        HomeFragment_MembersInjector.injectTracker(homeFragment, this.P0.get());
        HomeFragment_MembersInjector.injectHomeSkeletonTestGroup(homeFragment, (HomeSkeletonTestGroup) Preconditions.checkNotNullFromComponent(this.d.homeSkeletonTestGroup()));
        HomeFragment_MembersInjector.injectWitcherItemPresenter(homeFragment, this.s2.get());
        HomeFragment_MembersInjector.injectHomeNewRubricatorTestGroup(homeFragment, (HomeNewRubricatorTestGroup) Preconditions.checkNotNullFromComponent(this.d.homeNewRubricatorTestGroup()));
        HomeFragment_MembersInjector.injectCartFabViewModel(homeFragment, this.V3.get());
        HomeFragment_MembersInjector.injectCartFabQuantityHandler(homeFragment, this.W3.get());
    }
}
