package com.avito.android.search.map.di;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.TopLocationInteractor;
import com.avito.android.ab_tests.configs.OrangeAdBadgeTestGroup;
import com.avito.android.ab_tests.configs.PriceOnTopTestGroup;
import com.avito.android.ab_tests.configs.SellerInfoInRichSnippetTestGroup;
import com.avito.android.ab_tests.configs.SerpItemsPrefetchTestGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithNone;
import com.avito.android.ab_tests.groups.ViewedItemsTabTestGroup;
import com.avito.android.ab_tests.models.AbTestGroup;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
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
import com.avito.android.app.task.ApplicationStartupTasksRegistry;
import com.avito.android.async_phone.AsyncPhoneInteractor;
import com.avito.android.async_phone.AsyncPhoneInteractorImpl;
import com.avito.android.async_phone.AsyncPhoneInteractorImpl_Factory;
import com.avito.android.async_phone.AsyncPhonePresenter;
import com.avito.android.async_phone.AsyncPhonePresenterImpl;
import com.avito.android.async_phone.AsyncPhonePresenterImpl_Factory;
import com.avito.android.async_phone.AsyncPhoneTracker;
import com.avito.android.async_phone.AsyncPhoneTrackerImpl;
import com.avito.android.async_phone.AsyncPhoneTrackerImpl_Factory;
import com.avito.android.avito_map.AvitoMapAttachHelper;
import com.avito.android.avito_map.AvitoMapZoomLevel;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.date_time_formatter.DateTimeFormatter;
import com.avito.android.date_time_formatter.DateTimeFormatterResourceProviderImpl;
import com.avito.android.date_time_formatter.DateTimeFormatterResourceProviderImpl_Factory;
import com.avito.android.db.SearchSubscriptionDao;
import com.avito.android.db.favorites.FavoritesSyncDao;
import com.avito.android.db.viewed.ViewedAdvertsDao;
import com.avito.android.deep_linking.ClickStreamLinkHandler;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.SimpleClickStreamLinkHandler;
import com.avito.android.deep_linking.SimpleClickStreamLinkHandler_Factory;
import com.avito.android.design.widget.dfp_debug.DfpDebugPresenter;
import com.avito.android.design.widget.dfp_debug.DfpDebugPresenterImpl_Factory;
import com.avito.android.di.ViewedAdvertsModule_ProvideViewedAdvertsInteractorFactory;
import com.avito.android.di.ViewedAdvertsModule_ProvideViewedStatusResolverFactory;
import com.avito.android.di.module.AdvertItemModule_ProvideAdvertItemDoubleBlueprintFactory;
import com.avito.android.di.module.AdvertItemModule_ProvideAdvertItemGridBlueprintFactory;
import com.avito.android.di.module.AdvertItemModule_ProvideAdvertItemListBlueprintFactory;
import com.avito.android.di.module.AdvertItemPresenterModule_ProvideAdvertGridItemPresenterFactory;
import com.avito.android.di.module.AdvertItemPresenterModule_ProvideAdvertListItemPresenterFactory;
import com.avito.android.di.module.DateTimeFormatterModule_ProvideUpperCaseDateTimeFormatterFactory;
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
import com.avito.android.favorite.FavoriteAdvertsPresenterImpl;
import com.avito.android.favorite.FavoriteAdvertsPresenterImpl_Factory;
import com.avito.android.favorite.FavoriteAdvertsResourceProvider;
import com.avito.android.favorite.FavoriteAdvertsResourceProviderImpl;
import com.avito.android.favorite.FavoriteAdvertsResourceProviderImpl_Factory;
import com.avito.android.favorite.FavoriteAdvertsUploadInteractor;
import com.avito.android.geo.GeoStorage;
import com.avito.android.inline_filters.InlineFiltersPresenter;
import com.avito.android.inline_filters.InlineFiltersPresenterImpl;
import com.avito.android.inline_filters.InlineFiltersPresenterImpl_Factory;
import com.avito.android.inline_filters.dialog.InlineFilterDialogFactory;
import com.avito.android.inline_filters.dialog.InlineFilterDialogFactoryImpl;
import com.avito.android.inline_filters.dialog.InlineFilterDialogFactoryImpl_Factory;
import com.avito.android.inline_filters.dialog.InlineFiltersDialogItemConverter;
import com.avito.android.inline_filters.dialog.InlineFiltersDialogItemConverterImpl;
import com.avito.android.inline_filters.dialog.InlineFiltersDialogItemConverterImpl_Factory;
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
import com.avito.android.location.di.module.FindLocationModule_ProvideDefaultLocationInteractorFactory;
import com.avito.android.location.di.module.FindLocationModule_ProvideDefaultLocationProviderFactory;
import com.avito.android.location.find.DefaultLocationInteractor;
import com.avito.android.location.find.DefaultLocationProvider;
import com.avito.android.location.find.FindLocationPresenter;
import com.avito.android.location.find.FindLocationPresenterImpl;
import com.avito.android.location.find.FindLocationPresenterImpl_Factory;
import com.avito.android.location.find.FusedLocationInteractor;
import com.avito.android.location.find.FusedLocationInteractorImpl;
import com.avito.android.location.find.FusedLocationInteractorImpl_Factory;
import com.avito.android.location.find.GoogleServicesLocationProvider;
import com.avito.android.location.find.GoogleServicesLocationProviderImpl;
import com.avito.android.location.find.GoogleServicesLocationProviderImpl_Factory;
import com.avito.android.module.serp.adapter.ad.adfox.AdfoxImageItemPresenter;
import com.avito.android.module.serp.adapter.ad.adfox.AdfoxImageItemPresenterImpl;
import com.avito.android.module.serp.adapter.ad.adfox.AdfoxImageItemPresenterImpl_Factory;
import com.avito.android.module.serp.adapter.ad.adfox.AdfoxSingleGridBlueprint;
import com.avito.android.module.serp.adapter.ad.adfox.AdfoxSingleGridBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.adfox.AdfoxSingleListBlueprint;
import com.avito.android.module.serp.adapter.ad.adfox.AdfoxSingleListBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.dfp.DfpAppInstallDoubleBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.DfpAppInstallDoubleBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.dfp.DfpAppInstallListBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.DfpAppInstallListBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.dfp.DfpAppInstallPresenter;
import com.avito.android.module.serp.adapter.ad.dfp.DfpAppInstallPresenterImpl;
import com.avito.android.module.serp.adapter.ad.dfp.DfpAppInstallPresenterImpl_Factory;
import com.avito.android.module.serp.adapter.ad.dfp.DfpAppInstallSingleBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.DfpAppInstallSingleBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.dfp.DfpContentDoubleGridBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.DfpContentDoubleGridBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.dfp.DfpContentListBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.DfpContentListBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.dfp.DfpContentPresenter;
import com.avito.android.module.serp.adapter.ad.dfp.DfpContentPresenterImpl;
import com.avito.android.module.serp.adapter.ad.dfp.DfpContentPresenterImpl_Factory;
import com.avito.android.module.serp.adapter.ad.dfp.DfpContentSingleGridBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.DfpContentSingleGridBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.dfp.DfpUnifiedDoubleBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.DfpUnifiedDoubleBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.dfp.DfpUnifiedListBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.DfpUnifiedListBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.dfp.DfpUnifiedPresenter;
import com.avito.android.module.serp.adapter.ad.dfp.DfpUnifiedPresenterImpl;
import com.avito.android.module.serp.adapter.ad.dfp.DfpUnifiedPresenterImpl_Factory;
import com.avito.android.module.serp.adapter.ad.dfp.DfpUnifiedSingleGridBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.DfpUnifiedSingleGridBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetAppInstallBlueprint;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetAppInstallBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetAppInstallListBlueprint;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetAppInstallListBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetAppInstallPresenter;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetAppInstallPresenterImpl;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetAppInstallPresenterImpl_Factory;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetAppInstallSingleBlueprint;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetAppInstallSingleBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetContentBlueprint;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetContentBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetContentListBlueprint;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetContentListBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetContentPresenter;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetContentPresenterImpl;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetContentPresenterImpl_Factory;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetContentSingleBlueprint;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetContentSingleBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.yandex.app_install.YandexAppInstallDoubleItemBlueprint;
import com.avito.android.module.serp.adapter.ad.yandex.app_install.YandexAppInstallDoubleItemBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.yandex.app_install.YandexAppInstallItemPresenter;
import com.avito.android.module.serp.adapter.ad.yandex.app_install.YandexAppInstallItemPresenterImpl;
import com.avito.android.module.serp.adapter.ad.yandex.app_install.YandexAppInstallItemPresenterImpl_Factory;
import com.avito.android.module.serp.adapter.ad.yandex.app_install.YandexAppInstallListItemBlueprint;
import com.avito.android.module.serp.adapter.ad.yandex.app_install.YandexAppInstallListItemBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.yandex.app_install.YandexAppInstallSingleItemBlueprint;
import com.avito.android.module.serp.adapter.ad.yandex.app_install.YandexAppInstallSingleItemBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.yandex.content.YandexContentDoubleGridBlueprint;
import com.avito.android.module.serp.adapter.ad.yandex.content.YandexContentDoubleGridBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.yandex.content.YandexContentItemPresenter;
import com.avito.android.module.serp.adapter.ad.yandex.content.YandexContentItemPresenterImpl;
import com.avito.android.module.serp.adapter.ad.yandex.content.YandexContentItemPresenterImpl_Factory;
import com.avito.android.module.serp.adapter.ad.yandex.content.YandexContentListBlueprint;
import com.avito.android.module.serp.adapter.ad.yandex.content.YandexContentListBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.yandex.content.YandexContentSingleGridBlueprint;
import com.avito.android.module.serp.adapter.ad.yandex.content.YandexContentSingleGridBlueprint_Factory;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.permissions.LocationPermissionProvider;
import com.avito.android.permissions.LocationPermissionProviderImpl;
import com.avito.android.permissions.LocationPermissionProviderImpl_Factory;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.redux.SubscribableStore;
import com.avito.android.remote.AsyncPhoneApi;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.SearchParamsConverterImpl_Factory;
import com.avito.android.remote.model.SuggestParamsConverter;
import com.avito.android.remote.model.SuggestParamsConverterImpl;
import com.avito.android.remote.model.SuggestParamsConverterImpl_Factory;
import com.avito.android.saved_searches.SavedSearchesPresenter;
import com.avito.android.saved_searches.SavedSearchesPresenterImpl;
import com.avito.android.saved_searches.SavedSearchesPresenterImpl_Factory;
import com.avito.android.scroll_tracker.SnippetScrollDepthTracker;
import com.avito.android.scroll_tracker.SnippetScrollDepthTrackerImpl_Factory;
import com.avito.android.search.SearchDeepLinkInteractor;
import com.avito.android.search.SearchDeepLinkInteractorImpl;
import com.avito.android.search.SearchDeepLinkInteractorImpl_Factory;
import com.avito.android.search.map.SearchMapFragment;
import com.avito.android.search.map.SearchMapFragment_MembersInjector;
import com.avito.android.search.map.SearchMapState;
import com.avito.android.search.map.SearchMapViewFactory;
import com.avito.android.search.map.SearchMapViewFactoryImpl;
import com.avito.android.search.map.SearchMapViewFactoryImpl_Factory;
import com.avito.android.search.map.ViewBinder;
import com.avito.android.search.map.ViewBinder_Factory;
import com.avito.android.search.map.action.MapAction;
import com.avito.android.search.map.di.SearchMapComponent;
import com.avito.android.search.map.favorite_pins.FavoritePinsInteractor;
import com.avito.android.search.map.favorite_pins.FavouritePinsInteractorImpl;
import com.avito.android.search.map.favorite_pins.FavouritePinsInteractorImpl_Factory;
import com.avito.android.search.map.interactor.MapAreaConverter;
import com.avito.android.search.map.interactor.MapAreaConverterImpl;
import com.avito.android.search.map.interactor.MapAreaConverterImpl_Factory;
import com.avito.android.search.map.interactor.MapViewPortProvider;
import com.avito.android.search.map.interactor.MapViewPortProviderImpl;
import com.avito.android.search.map.interactor.MapViewPortProviderImpl_Factory;
import com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor;
import com.avito.android.search.map.interactor.SearchMapAnalyticsInteractorImpl;
import com.avito.android.search.map.interactor.SearchMapAnalyticsInteractorImpl_Factory;
import com.avito.android.search.map.interactor.SearchMapInteractor;
import com.avito.android.search.map.interactor.SearchMapInteractorImpl;
import com.avito.android.search.map.interactor.SearchMapInteractorImpl_Factory;
import com.avito.android.search.map.interactor.SerpCacheInteractor;
import com.avito.android.search.map.interactor.SerpInteractor;
import com.avito.android.search.map.interactor.SerpInteractorImpl;
import com.avito.android.search.map.interactor.SerpInteractorImpl_Factory;
import com.avito.android.search.map.interactor.ViewedPinsInteractor;
import com.avito.android.search.map.interactor.ViewedPinsInteractorImpl;
import com.avito.android.search.map.interactor.ViewedPinsInteractorImpl_Factory;
import com.avito.android.search.map.metric.SearchMapTracker;
import com.avito.android.search.map.metric.SearchMapTrackerImpl;
import com.avito.android.search.map.metric.SearchMapTrackerImpl_Factory;
import com.avito.android.search.map.middleware.AdvertItemEventMiddleware;
import com.avito.android.search.map.middleware.AdvertItemEventMiddleware_Factory;
import com.avito.android.search.map.middleware.LoadMiddleware;
import com.avito.android.search.map.middleware.LoadMiddleware_Factory;
import com.avito.android.search.map.middleware.LocationMiddleware;
import com.avito.android.search.map.middleware.LocationMiddlewareImpl;
import com.avito.android.search.map.middleware.LocationMiddlewareImpl_Factory;
import com.avito.android.search.map.middleware.LoggingMiddleware;
import com.avito.android.search.map.middleware.LoggingMiddlewareImpl;
import com.avito.android.search.map.middleware.LoggingMiddlewareImpl_Factory;
import com.avito.android.search.map.middleware.NavigationMiddleware;
import com.avito.android.search.map.middleware.NavigationMiddlewareImpl;
import com.avito.android.search.map.middleware.NavigationMiddlewareImpl_Factory;
import com.avito.android.search.map.middleware.SubscriptionMiddleware;
import com.avito.android.search.map.middleware.SubscriptionMiddleware_Factory;
import com.avito.android.search.map.provider.PublishFloatingViewsProvider;
import com.avito.android.search.map.provider.SearchHashProvider;
import com.avito.android.search.map.provider.SearchHashProviderImpl_Factory;
import com.avito.android.search.map.reducer.LoadReducer;
import com.avito.android.search.map.reducer.LoadReducer_Factory;
import com.avito.android.search.map.reducer.MapReducer;
import com.avito.android.search.map.reducer.MapReducer_Factory;
import com.avito.android.search.map.reducer.PinAdvertsReducer;
import com.avito.android.search.map.reducer.PinAdvertsReducer_Factory;
import com.avito.android.search.map.reducer.SerpReducer;
import com.avito.android.search.map.reducer.SerpReducer_Factory;
import com.avito.android.search.map.reducer.SubscriptionReducer_Factory;
import com.avito.android.search.map.reducer.UiReducer_Factory;
import com.avito.android.search.map.utils.BottomSheetBehaviourEventsProvider;
import com.avito.android.search.map.view.MarkerIconFactory;
import com.avito.android.search.map.view.MarkerIconFactoryImpl;
import com.avito.android.search.map.view.MarkerIconFactoryImpl_Factory;
import com.avito.android.search.map.view.PinAdvertsListViewBinder;
import com.avito.android.search.map.view.PinAdvertsListViewBinderImpl;
import com.avito.android.search.map.view.PinAdvertsListViewBinderImpl_Factory;
import com.avito.android.search.map.view.SerpListResourcesProvider;
import com.avito.android.search.map.view.SerpListResourcesProviderImpl;
import com.avito.android.search.map.view.SerpListResourcesProviderImpl_Factory;
import com.avito.android.search.map.view.SerpListViewBinder;
import com.avito.android.search.map.view.SerpListViewBinderImpl;
import com.avito.android.search.map.view.SerpListViewBinderImpl_Factory;
import com.avito.android.search.map.view.adapter.AppendingRetryListener;
import com.avito.android.search.map.view.adapter.AppendingRetryListenerImpl_Factory;
import com.avito.android.search.map.view.advert.AdvertItemEventListener;
import com.avito.android.search.map.view.advert.AdvertItemEventListenerImpl_Factory;
import com.avito.android.search.map.viewed_pins.ViewedPinsStorageImpl;
import com.avito.android.search.map.viewed_pins.ViewedPinsStorageImpl_Factory;
import com.avito.android.search.subscriptions.SubscribeSearchInteractor;
import com.avito.android.search.subscriptions.SubscribeSearchInteractorImpl;
import com.avito.android.search.subscriptions.SubscribeSearchInteractorImpl_Factory;
import com.avito.android.serp.BannerInfoFactory;
import com.avito.android.serp.BannerInfoFactoryImpl_Factory;
import com.avito.android.serp.CommercialBannerTimeProviderImpl;
import com.avito.android.serp.CommercialBannerTimeProviderImpl_Factory;
import com.avito.android.serp.CommercialBannersAnalyticsInteractorImpl;
import com.avito.android.serp.CommercialBannersAnalyticsInteractorImpl_Factory;
import com.avito.android.serp.CommercialBannersInteractor;
import com.avito.android.serp.CommercialBannersInteractorImpl;
import com.avito.android.serp.CommercialBannersInteractorImpl_Factory;
import com.avito.android.serp.InlineFiltersChangesParamsConverter;
import com.avito.android.serp.InlineFiltersChangesParamsConverterImpl_Factory;
import com.avito.android.serp.InlineFiltersInteractor;
import com.avito.android.serp.InlineFiltersInteractorImpl;
import com.avito.android.serp.InlineFiltersInteractorImpl_Factory;
import com.avito.android.serp.InlineFiltersParametersKeyWrapper_Factory;
import com.avito.android.serp.SerpItemProcessor;
import com.avito.android.serp.SerpSnippetInteractor;
import com.avito.android.serp.SerpSnippetInteractor_Impl_Factory;
import com.avito.android.serp.ad.AdResourceProvider;
import com.avito.android.serp.ad.AdResourceProviderImpl_Factory;
import com.avito.android.serp.ad.DfpBannerLoader;
import com.avito.android.serp.ad.DfpBannerLoaderImpl;
import com.avito.android.serp.ad.DfpBannerLoaderImpl_Factory;
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
import com.avito.android.serp.adapter.AdvertItemListBlueprint;
import com.avito.android.serp.adapter.AdvertListItemPresenter;
import com.avito.android.serp.adapter.AdvertSpanCountProvider;
import com.avito.android.serp.adapter.FavoriteStatusResolver;
import com.avito.android.serp.adapter.HeaderElementConverter;
import com.avito.android.serp.adapter.SellerElementConverter;
import com.avito.android.serp.adapter.SellerPinItemBlueprint;
import com.avito.android.serp.adapter.SellerPinItemBlueprint_Factory;
import com.avito.android.serp.adapter.SellerPinItemPresenter;
import com.avito.android.serp.adapter.SellerPinItemPresenterImpl;
import com.avito.android.serp.adapter.SellerPinItemPresenterImpl_Factory;
import com.avito.android.serp.adapter.SerpAdvertConverter;
import com.avito.android.serp.adapter.SerpCommercialBannerConverter;
import com.avito.android.serp.adapter.SerpElementItemConverter;
import com.avito.android.serp.adapter.SerpItemAbViewConfig;
import com.avito.android.serp.adapter.SerpItemAbViewConfig_Factory;
import com.avito.android.serp.adapter.SerpItemSaturatorImpl;
import com.avito.android.serp.adapter.SerpItemSaturatorImpl_Factory;
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
import com.avito.android.serp.adapter.adstub.NotLoadAdRichStubBlueprint;
import com.avito.android.serp.adapter.adstub.NotLoadAdRichStubBlueprint_Factory;
import com.avito.android.serp.adapter.adstub.NotLoadAdStubGridBlueprint;
import com.avito.android.serp.adapter.adstub.NotLoadAdStubGridBlueprint_Factory;
import com.avito.android.serp.adapter.adstub.NotLoadAdStubListBlueprint;
import com.avito.android.serp.adapter.adstub.NotLoadAdStubListBlueprint_Factory;
import com.avito.android.serp.adapter.adstub.NotLoadAdStubPresenter_Factory;
import com.avito.android.serp.adapter.advert_xl.AdvertXlDimensionsProvider;
import com.avito.android.serp.adapter.advert_xl.AdvertXlDimensionsProviderImpl;
import com.avito.android.serp.adapter.advert_xl.AdvertXlDimensionsProviderImpl_Factory;
import com.avito.android.serp.adapter.advert_xl.AdvertXlItemBlueprint;
import com.avito.android.serp.adapter.advert_xl.AdvertXlItemBlueprint_Factory;
import com.avito.android.serp.adapter.advert_xl.AdvertXlItemPresenter;
import com.avito.android.serp.adapter.advert_xl.AdvertXlItemPresenterImpl;
import com.avito.android.serp.adapter.advert_xl.AdvertXlItemPresenterImpl_Factory;
import com.avito.android.serp.adapter.advert_xl.SerpAdvertXlConverter;
import com.avito.android.serp.adapter.closable.ClosedItemEventInteractor;
import com.avito.android.serp.adapter.closable.ClosedItemInteractor;
import com.avito.android.serp.adapter.closable.ClosedItemPresenter;
import com.avito.android.serp.adapter.closable.di.ClosedItemModule_ProvideClosedItemEventInteractorFactory;
import com.avito.android.serp.adapter.closable.di.ClosedItemModule_ProvideClosedItemInteractorFactory;
import com.avito.android.serp.adapter.closable.di.ClosedItemModule_ProvideViewedAdvertsPresenterFactory;
import com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemBlueprint;
import com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemBlueprint_Factory;
import com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemConverter;
import com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemPresenter;
import com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemPresenterImpl;
import com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemPresenterImpl_Factory;
import com.avito.android.serp.adapter.empty_search.EmptySearchItemConverter;
import com.avito.android.serp.adapter.item_sorter.SerpItemSorter;
import com.avito.android.serp.adapter.location_notification.LocationNotificationItemConverter;
import com.avito.android.serp.adapter.map_banner.MapBannerItemBlueprint;
import com.avito.android.serp.adapter.map_banner.MapBannerItemBlueprint_Factory;
import com.avito.android.serp.adapter.map_banner.MapBannerItemConverter;
import com.avito.android.serp.adapter.map_banner.MapBannerItemPresenter;
import com.avito.android.serp.adapter.map_banner.MapBannerItemPresenterImpl;
import com.avito.android.serp.adapter.map_banner.MapBannerItemPresenterImpl_Factory;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandler;
import com.avito.android.serp.adapter.promo_card.PromoCardBlueprint;
import com.avito.android.serp.adapter.promo_card.PromoCardBlueprint_Factory;
import com.avito.android.serp.adapter.promo_card.PromoCardConverter;
import com.avito.android.serp.adapter.promo_card.PromoCardItemPresenter;
import com.avito.android.serp.adapter.promo_card.PromoCardItemPresenter_Factory;
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
import com.avito.android.serp.adapter.rich_snippets.YandexAppInstallRichBlueprint;
import com.avito.android.serp.adapter.rich_snippets.YandexAppInstallRichBlueprint_Factory;
import com.avito.android.serp.adapter.rich_snippets.YandexContentRichBlueprint;
import com.avito.android.serp.adapter.rich_snippets.YandexContentRichBlueprint_Factory;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichItemBlueprint;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichItemBlueprint_Factory;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichItemPresenter;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichItemPresenterImpl;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichItemPresenterImpl_Factory;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichSmallItemBlueprint;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichSmallItemBlueprint_Factory;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertVipRichItemBlueprint;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertVipRichItemBlueprint_Factory;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertXlRichItemBlueprint;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertXlRichItemBlueprint_Factory;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertXlRichItemPresenter;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertXlRichItemPresenterImpl;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertXlRichItemPresenterImpl_Factory;
import com.avito.android.serp.adapter.snippet.SnippetBlueprint;
import com.avito.android.serp.adapter.snippet.SnippetBlueprint_Factory;
import com.avito.android.serp.adapter.snippet.SnippetConverter;
import com.avito.android.serp.adapter.snippet.SnippetItem;
import com.avito.android.serp.adapter.snippet.SnippetPresenter;
import com.avito.android.serp.adapter.snippet.SnippetPresenter_Impl_Factory;
import com.avito.android.serp.adapter.title.GroupTitleItemBlueprint;
import com.avito.android.serp.adapter.title.GroupTitleItemBlueprint_Factory;
import com.avito.android.serp.adapter.title.GroupTitleItemConverter;
import com.avito.android.serp.adapter.title.GroupTitleItemPresenter;
import com.avito.android.serp.adapter.title.GroupTitleItemPresenterImpl_Factory;
import com.avito.android.serp.adapter.vertical_main.VerticalFilterItemConverter;
import com.avito.android.serp.adapter.warning.SerpWarningConverter;
import com.avito.android.serp.adapter.warning.SerpWarningItemBlueprint;
import com.avito.android.serp.adapter.warning.SerpWarningItemBlueprint_Factory;
import com.avito.android.serp.adapter.warning.SerpWarningItemPresenter;
import com.avito.android.serp.adapter.warning.SerpWarningItemPresenterImpl;
import com.avito.android.serp.adapter.warning.SerpWarningItemPresenterImpl_Factory;
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
import com.avito.android.serp.analytics.SerpTracker;
import com.avito.android.serp.analytics.SerpTrackerImpl;
import com.avito.android.serp.analytics.SerpTrackerImpl_Factory;
import com.avito.android.server_time.TimeSource;
import com.avito.android.subscriptions.remote.SubscriptionsApi;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.Formatter;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Kundle;
import com.avito.android.util.PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.jakewharton.rxrelay3.Relay;
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
public final class DaggerSearchMapComponent implements SearchMapComponent {
    public Provider<ShortcutNavigationItemConverter> A;
    public Provider<SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup>> A0;
    public Provider<YandexContentItemPresenter> A1;
    public Provider<YandexContentListBlueprint> A2;
    public Provider<SerpListResourcesProviderImpl> A3;
    public Provider<SerpItemSorter> A4;
    public Provider<RichSnippetStateProvider> A5;
    public Provider<SingleManuallyExposedAbTestGroup<SimpleTestGroup>> B;
    public Provider<AdvertRichItemPresenterImpl> B0;
    public Provider<YandexContentSingleGridBlueprint> B1;
    public Provider<YandexAppInstallListItemBlueprint> B2;
    public Provider<SerpListResourcesProvider> B3;
    public Provider<SerpItemSizeAdjuster> B4;
    public Provider<Set<RichSnippetStateProvider>> B5;
    public Provider<InlineFiltersDialogItemConverterImpl> C;
    public Provider<AdvertRichItemPresenter> C0;
    public Provider<YandexContentDoubleGridBlueprint> C1;
    public Provider<DfpUnifiedListBlueprint> C2;
    public Provider<MapAreaConverterImpl> C3;
    public Provider<SerpItemProcessor> C4;
    public Provider<RichSnippetStateProviderProxy> C5;
    public Provider<InlineFiltersDialogItemConverter> D;
    public Provider<RecyclerView.RecycledViewPool> D0;
    public Provider<YandexContentRichBlueprint> D1;
    public Provider<DfpContentListBlueprint> D2;
    public Provider<MapAreaConverter> D3;
    public Provider<SerpItemProcessor> D4;
    public Provider<RichSnippetStateProvider> D5;
    public Provider<ScreenTrackerFactory> E;
    public Provider<SellerInfoParamsFactoryImpl> E0;
    public Provider<YandexAppInstallItemPresenterImpl> E1;
    public Provider<DfpAppInstallListBlueprint> E2;
    public Provider<BottomSheetBehaviourEventsProvider> E3;
    public Provider<Context> E4;
    public Provider<ErrorFormatterImpl> E5;
    public Provider<TimerFactory> F;
    public Provider<SellerInfoParamsFactory> F0;
    public Provider<YandexAppInstallItemPresenter> F1;
    public Provider<MyTargetContentListBlueprint> F2;
    public Provider<BottomSheetBehaviourEventsProvider> F3;
    public Provider<DfpBannerLoaderImpl> F4;
    public Provider<Formatter<Throwable>> F5;
    public Provider<SerpTrackerImpl> G;
    public Provider<AdvertRichSmallItemBlueprint> G0;
    public Provider<YandexAppInstallSingleItemBlueprint> G1;
    public Provider<MyTargetAppInstallListBlueprint> G2;
    public Provider<SearchMapTrackerImpl> G3;
    public Provider<DfpBannerLoader> G4;
    public Provider<Formatter<String>> G5;
    public Provider<SerpTracker> H;
    public Provider<SellerPinItemPresenterImpl> H0;
    public Provider<YandexAppInstallDoubleItemBlueprint> H1;
    public Provider<NotLoadAdStubListBlueprint> H2;
    public Provider<SearchMapTracker> H3;
    public Provider<YandexBannerLoaderImpl> H4;
    public Provider<SnippetScrollDepthAnalyticsInteractorImpl> H5;
    public Provider<Kundle> I;
    public Provider<SellerPinItemPresenter> I0;
    public Provider<YandexAppInstallRichBlueprint> I1;
    public Provider<NotLoadAdRichStubBlueprint> I2;
    public Provider<AvitoMapAttachHelper> I3;
    public Provider<YandexBannerLoader> I4;
    public Provider<SnippetScrollDepthAnalyticsInteractor> I5;
    public Provider<InlineFiltersPresenterImpl> J;
    public Provider<SellerPinItemBlueprint> J0;
    public Provider<AdfoxImageItemPresenterImpl> J1;
    public Provider<WitcherResourceProviderImpl> J2;
    public Provider<InlineFilterDialogFactoryImpl> J3;
    public Provider<MyTargetBannerLoaderImpl> J4;
    public Provider<InlineFiltersPresenter> K;
    public Provider<ItemBinder> K0;
    public Provider<AdfoxImageItemPresenter> K1;
    public Provider<WitcherResourceProvider> K2;
    public Provider<InlineFilterDialogFactory> K3;
    public Provider<MyTargetBannerLoader> K4;
    public Provider<AsyncPhoneApi> L;
    public Provider<AdapterPresenter> L0;
    public Provider<AdfoxSingleGridBlueprint> L1;
    public Provider<Kundle> L2;
    public Provider<SubscriptionsApi> L3;
    public Provider<BannerInfoFactory> L4;
    public Provider<AsyncPhoneInteractorImpl> M;
    public Provider<FavoritesSyncDao> M0;
    public Provider<AdfoxSingleListBlueprint> M1;
    public Provider<WitcherAnalyticsInteractorImpl> M2;
    public Provider<SearchSubscriptionDao> M3;
    public Provider<CommercialBannersInteractorImpl> M4;
    public Provider<AsyncPhoneInteractor> N;
    public Provider<FavoriteAdvertsUploadInteractor> N0;
    public Provider<DfpDebugPresenter> N1;
    public Provider<WitcherAnalyticsInteractor> N2;
    public Provider<SubscribeSearchInteractorImpl> N3;
    public Provider<CommercialBannersInteractor> N4;
    public Provider<TypedErrorThrowableConverter> O;
    public Provider<FavoriteAdvertsEventInteractor> O0;
    public Provider<DfpUnifiedPresenterImpl> O1;
    public Provider<SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup>> O2;
    public Provider<SubscribeSearchInteractor> O3;
    public Provider<ClosedItemInteractor> O4;
    public Provider<Screen> P;
    public Provider<FavoriteAdvertsAnalyticsInteractorImpl> P0;
    public Provider<DfpUnifiedPresenter> P1;
    public Provider<WitcherItemPresenterImpl> P2;
    public Provider<Kundle> P3;
    public Provider<SerpItemSaturatorImpl> P4;
    public Provider<AsyncPhoneTrackerImpl> Q;
    public Provider<FavoriteAdvertsInteractorImpl> Q0;
    public Provider<DfpUnifiedDoubleBlueprint> Q1;
    public Provider<WitcherItemPresenter> Q2;
    public Provider<SavedSearchesPresenterImpl> Q3;
    public Provider<SearchMapState> Q4;
    public Provider<AsyncPhoneTracker> R;
    public Provider<FavoriteAdvertsResourceProviderImpl> R0;
    public Provider<DfpAppInstallPresenterImpl> R1;
    public Provider<ItemBinder> R2;
    public Provider<SavedSearchesPresenter> R3;
    public Provider<SerpCacheInteractor> R4;
    public Provider<AdvertItemEventListener> S;
    public Provider<FavoriteAdvertsResourceProvider> S0;
    public Provider<DfpAppInstallPresenter> S1;
    public Provider<ViewedAdvertsPresenter> S2;
    public Provider<ManuallyExposedAbTestGroup<SimpleTestGroupWithNone>> S3;
    public Provider<SerpInteractorImpl> S4;
    public Provider<AsyncPhonePresenterImpl> T;
    public Provider<FavoriteAdvertsPresenterImpl> T0;
    public Provider<DfpAppInstallDoubleBlueprint> T1;
    public Provider<FavoriteAdvertsPresenter> T2;
    public Provider<SearchMapViewFactoryImpl> T3;
    public Provider<SerpInteractor> T4;
    public Provider<AsyncPhonePresenter> U;
    public Provider<FavoriteAdvertsPresenter> U0;
    public Provider<DfpAppInstallSingleBlueprint> U1;
    public Provider<SimpleAdapterPresenter> U2;
    public Provider<SearchMapViewFactory> U3;
    public Provider<LoadMiddleware> U4;
    public Provider<NavigationMiddlewareImpl> V;
    public Provider<ViewedAdvertsEventInteractor> V0;
    public Provider<DfpUnifiedSingleGridBlueprint> V1;
    public Provider<DeviceMetrics> V2;
    public Provider<LocationAnalyticsInteractorImpl> V3;
    public Provider<AdvertItemEventMiddleware> V4;
    public Provider<NavigationMiddleware> W;
    public Provider<ViewedAdvertsPresenterImpl> W0;
    public Provider<DfpContentPresenterImpl> W1;
    public Provider<WitcherItemBlueprint> W2;
    public Provider<LocationAnalyticsInteractor> W3;
    public Provider<Fragment> W4;
    public Provider<SearchMapFragment.Factory.Arguments> X;
    public Provider<ViewedAdvertsPresenter> X0;
    public Provider<DfpContentPresenter> X1;
    public Provider<PromoCardItemPresenter> X2;
    public Provider<LoggingMiddlewareImpl> X3;
    public Provider<LocationPermissionProviderImpl> X4;
    public Provider<SearchParams> Y;
    public Provider<SpannedGridPositionProvider> Y0;
    public Provider<DfpContentSingleGridBlueprint> Y1;
    public Provider<PromoCardBlueprint> Y2;
    public Provider<LoggingMiddleware> Y3;
    public Provider<LocationPermissionProvider> Y4;
    public Provider<SuggestParamsConverterImpl> Z;
    public Provider<SpannedGridPositionProvider> Z0;
    public Provider<DfpContentDoubleGridBlueprint> Z1;
    public Provider<MapBannerItemPresenterImpl> Z2;
    public Provider<AdvertSpanCountProvider> Z3;
    public Provider<GeoStorage> Z4;
    public final SearchMapDependencies a;
    public Provider<SuggestParamsConverter> a0;
    public Provider<SerpSpanProvider> a1;

    /* renamed from: a2  reason: collision with root package name */
    public Provider<MyTargetImageBgProvider> f58a2;
    public Provider<MapBannerItemPresenter> a3;
    public Provider<AdvertSpanCountProvider> a4;
    public Provider<DefaultLocationInteractor> a5;
    public final ScreenAnalyticsDependencies b;
    public Provider<SearchDeepLinkInteractorImpl> b0;
    public Provider<AppendingRetryListener> b1;
    public Provider<MyTargetContentPresenterImpl> b2;
    public Provider<MapBannerItemBlueprint> b3;
    public Provider<SerpAdvertConverter> b4;
    public Provider<DefaultLocationProvider> b5;
    public final Screen c;
    public Provider<SearchDeepLinkInteractor> c0;
    public Provider<PublishFloatingViewsProvider> c1;
    public Provider<MyTargetContentPresenter> c2;
    public Provider<ItemBinder> c3;
    public Provider<SerpAdvertXlConverter> c4;
    public Provider<FusedLocationInteractorImpl> c5;
    public final BannerPageSource d;
    public Provider<View> d0;
    public Provider<PinAdvertsListViewBinderImpl> d1;
    public Provider<MyTargetContentBlueprint> d2;
    public Provider<AdapterPresenter> d3;
    public Provider<AdResourceProvider> d4;
    public Provider<FusedLocationInteractor> d5;
    public Provider<SavedLocationStorage> e;
    public Provider<Resources> e0;
    public Provider<PinAdvertsListViewBinder> e1;
    public Provider<MyTargetAppInstallPresenterImpl> e2;
    public Provider<FavoriteAdvertsPresenter> e3;
    public Provider<RandomKeyProvider> e4;
    public Provider<GoogleServicesLocationProviderImpl> e5;
    public Provider<LocationApi> f;
    public Provider<MapViewPortProviderImpl> f0;
    public Provider<BuildInfo> f1;
    public Provider<MyTargetAppInstallPresenter> f2;
    public Provider<ViewedAdvertsPresenter> f3;
    public Provider<SerpCommercialBannerConverter> f4;
    public Provider<GoogleServicesLocationProvider> f5;
    public Provider<TopLocationInteractor> g;
    public Provider<MapViewPortProvider> g0;
    public Provider<SimpleRecyclerAdapter> g1;
    public Provider<MyTargetAppInstallSingleBlueprint> g2;
    public Provider<SerpSpanProvider> g3;
    public Provider<DeepLinkFactory> g4;
    public Provider<FindLocationPresenterImpl> g5;
    public Provider<Features> h;
    public Provider<SearchMapInteractorImpl> h0;
    public Provider<GridLayoutManager.SpanSizeLookup> h1;
    public Provider<MyTargetAppInstallBlueprint> h2;
    public Provider<SerpSpanProvider> h3;
    public Provider<ShortcutBannerConverter> h4;
    public Provider<FindLocationPresenter> h5;
    public Provider<BackNavigationLocationInteractor> i;
    public Provider<SearchMapInteractor> i0;
    public Provider<AdvertGridItemPresenter> i1;
    public Provider<MyTargetContentSingleBlueprint> i2;
    public Provider<SpannedGridPositionProvider> i3;
    public Provider<SerpWarningConverter> i4;
    public Provider<LocationMiddlewareImpl> i5;
    public Provider<SavedLocationInteractorImpl> j;
    public Provider<Activity> j0;
    public Provider<AdvertItemGridBlueprint> j1;
    public Provider<NotLoadAdStubGridBlueprint> j2;
    public Provider<BannerPageSource> j3;
    public Provider<SnippetConverter> j4;
    public Provider<LocationMiddleware> j5;
    public Provider<SavedLocationInteractor> k;
    public Provider<MarkerIconFactoryImpl> k0;
    public Provider<AdvertItemDoubleBlueprint> k1;
    public Provider<EmptyAdStubItemPresenter> k2;
    public Provider<TreeClickStreamParent> k3;
    public Provider<EmptySearchItemConverter> k4;
    public Provider<SerpSnippetInteractor.Impl> k5;
    public Provider<Analytics> l;
    public Provider<MarkerIconFactory> l0;
    public Provider<AdvertXlDimensionsProviderImpl> l1;
    public Provider<EmptyAdStubItemBlueprint> l2;
    public Provider<CommercialBannersAnalyticsInteractorImpl> l3;
    public Provider<GroupTitleItemConverter> l4;
    public Provider<SerpSnippetInteractor> l5;
    public Provider<TreeStateIdGenerator> m;
    public Provider<SerpOnboardingHandler> m0;
    public Provider<AdvertXlDimensionsProvider> m1;
    public Provider<SerpWarningItemPresenterImpl> m2;
    public Provider<BannerViewFilter> m3;
    public Provider<EmptyPlaceholderItemConverter> m4;
    public Provider<SubscriptionMiddleware> m5;
    public Provider<SearchHashProvider> n = DoubleCheck.provider(SearchHashProviderImpl_Factory.create());
    public Provider<AdvertListItemPresenter> n0;
    public Provider<Kundle> n1;
    public Provider<SerpWarningItemPresenter> n2;
    public Provider<Bundle> n3;
    public Provider<HeaderElementConverter> n4;
    public Provider<LoadReducer> n5;
    public Provider<TreeClickStreamParent> o;
    public Provider<TimeSource> o0;
    public Provider<AdvertXlItemPresenterImpl> o1;
    public Provider<SerpWarningItemBlueprint> o2;
    public Provider<ItemVisibilityTracker> o3;
    public Provider<FavoriteStatusResolver> o4;
    public Provider<SerpReducer> o5;
    public Provider<SearchMapAnalyticsInteractorImpl> p;
    public Provider<Locale> p0;
    public Provider<AdvertXlItemPresenter> p1;
    public Provider<Relay<Pair<SnippetItem, Integer>>> p2;
    public Provider<ClosedItemEventInteractor> p3;
    public Provider<ViewedAdvertsDao> p4;
    public Provider<SharedPreferences> p5;
    public Provider<SearchMapAnalyticsInteractor> q;
    public Provider<ExposedAbTestGroup<PriceOnTopTestGroup>> q0;
    public Provider<AdvertXlItemBlueprint> q1;
    public Provider<Relay<Pair<SnippetItem, Integer>>> q2;
    public Provider<ClosedItemPresenter> q3;
    public Provider<ViewedAdvertsInteractor> q4;
    public Provider<ViewedPinsStorageImpl> q5;
    public Provider<SimpleClickStreamLinkHandler> r;
    public Provider<SerpItemsPrefetchTestGroup> r0;
    public Provider<AdvertVipRichItemBlueprint> r1;
    public Provider<Relay<Pair<SnippetItem, Boolean>>> r2;
    public Provider<AppendingRetryListener> r3;
    public Provider<ViewedStatusResolver> r4;
    public Provider<ViewedPinsInteractorImpl> r5;
    public Provider<ClickStreamLinkHandler> s;
    public Provider<SerpItemAbViewConfig> s0;
    public Provider<RichSnippetsResourceProviderImpl> s1;
    public Provider<SnippetPresenter.Impl> s2;
    public Provider<SnippetScrollDepthTracker> s3;
    public Provider<WitcherElementConverter> s4;
    public Provider<ViewedPinsInteractor> s5;
    public Provider<AccountStateProvider> t;
    public Provider<ConnectivityProvider> t0;
    public Provider<RichSnippetsResourceProvider> t1;
    public Provider<SnippetPresenter> t2;
    public Provider<SerpListViewBinderImpl> t3;
    public Provider<LocationNotificationItemConverter> t4;
    public Provider<AvitoMapZoomLevel> t5;
    public Provider<SearchApi> u;
    public Provider<AdvertItemListBlueprint> u0;
    public Provider<AdvertXlRichItemPresenterImpl> u1;
    public Provider<SnippetBlueprint> u2;
    public Provider<SerpListViewBinder> u3;
    public Provider<SellerElementConverter> u4;
    public Provider<FavouritePinsInteractorImpl> u5;
    public Provider<SearchParamsConverter> v;
    public Provider<DateTimeFormatterResourceProviderImpl> v0;
    public Provider<AdvertXlRichItemPresenter> v1;
    public Provider<GroupTitleItemPresenter> v2;
    public Provider<DestroyableViewHolderBuilder> v3;
    public Provider<ReportBannerConverter> v4;
    public Provider<FavoritePinsInteractor> v5;
    public Provider<InlineFiltersChangesParamsConverter> w;
    public Provider<DateTimeFormatter> w0;
    public Provider<AdvertXlRichItemBlueprint> w1;
    public Provider<GroupTitleItemBlueprint> w2;
    public Provider<SimpleRecyclerAdapter> w3;
    public Provider<PromoCardConverter> w4;
    public Provider<MapReducer> w5;
    public Provider<SchedulersFactory3> x;
    public Provider<Kundle> x0;
    public Provider<AdvertRichItemBlueprint> x1;
    public Provider<EmptyPlaceholderItemPresenterImpl> x2;
    public Provider<SpanLookup> x3;
    public Provider<MapBannerItemConverter> x4;
    public Provider<PinAdvertsReducer> x5;
    public Provider<InlineFiltersInteractorImpl> y;
    public Provider<AdvertSellerConverterImpl> y0;
    public Provider<ExposedAbTestGroup<OrangeAdBadgeTestGroup>> y1;
    public Provider<EmptyPlaceholderItemPresenter> y2;
    public Provider<GridLayoutManager.SpanSizeLookup> y3;
    public Provider<VerticalFilterItemConverter> y4;
    public Provider<SubscribableStore<SearchMapState, ? super MapAction>> y5;
    public Provider<InlineFiltersInteractor> z;
    public Provider<AdvertSellerConverter> z0;
    public Provider<YandexContentItemPresenterImpl> z1;
    public Provider<EmptyPlaceholderItemBlueprint> z2;
    public Provider<GridLayoutManager.SpanSizeLookup> z3;
    public Provider<SerpElementItemConverter> z4;
    public Provider<ViewBinder> z5;

    public static class a0 implements Provider<ExposedAbTestGroup<PriceOnTopTestGroup>> {
        public final SearchMapDependencies a;

        public a0(SearchMapDependencies searchMapDependencies) {
            this.a = searchMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ExposedAbTestGroup<PriceOnTopTestGroup> get() {
            return (ExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.priceOnTop());
        }
    }

    public static final class b implements SearchMapComponent.Builder {
        public SearchMapDependencies a;
        public ScreenAnalyticsDependencies b;
        public LocationDependencies c;
        public Screen d;
        public Activity e;
        public Fragment f;
        public Resources g;
        public SearchMapFragment.Factory.Arguments h;
        public SearchMapState i;
        public Kundle j;
        public TreeClickStreamParent k;
        public View l;
        public AvitoMapZoomLevel m;
        public Kundle n;
        public Kundle o;
        public RecyclerView.RecycledViewPool p;
        public Kundle q;
        public Kundle r;
        public Bundle s;
        public BannerPageSource t;
        public Relay<Pair<SnippetItem, Integer>> u;
        public Relay<Pair<SnippetItem, Integer>> v;
        public Relay<Pair<SnippetItem, Boolean>> w;
        public FragmentManager x;
        public SerpOnboardingHandler y;

        public b(a aVar) {
        }

        @Override // com.avito.android.search.map.di.SearchMapComponent.Builder
        public SearchMapComponent.Builder bannerPageSource(BannerPageSource bannerPageSource) {
            this.t = (BannerPageSource) Preconditions.checkNotNull(bannerPageSource);
            return this;
        }

        @Override // com.avito.android.search.map.di.SearchMapComponent.Builder
        public SearchMapComponent build() {
            Preconditions.checkBuilderRequirement(this.a, SearchMapDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, ScreenAnalyticsDependencies.class);
            Preconditions.checkBuilderRequirement(this.c, LocationDependencies.class);
            Preconditions.checkBuilderRequirement(this.d, Screen.class);
            Preconditions.checkBuilderRequirement(this.e, Activity.class);
            Preconditions.checkBuilderRequirement(this.f, Fragment.class);
            Preconditions.checkBuilderRequirement(this.g, Resources.class);
            Preconditions.checkBuilderRequirement(this.h, SearchMapFragment.Factory.Arguments.class);
            Preconditions.checkBuilderRequirement(this.m, AvitoMapZoomLevel.class);
            Preconditions.checkBuilderRequirement(this.p, RecyclerView.RecycledViewPool.class);
            Preconditions.checkBuilderRequirement(this.t, BannerPageSource.class);
            Preconditions.checkBuilderRequirement(this.u, Relay.class);
            Preconditions.checkBuilderRequirement(this.v, Relay.class);
            Preconditions.checkBuilderRequirement(this.w, Relay.class);
            Preconditions.checkBuilderRequirement(this.x, FragmentManager.class);
            return new DaggerSearchMapComponent(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, null);
        }

        @Override // com.avito.android.search.map.di.SearchMapComponent.Builder
        public SearchMapComponent.Builder locationDependencies(LocationDependencies locationDependencies) {
            this.c = (LocationDependencies) Preconditions.checkNotNull(locationDependencies);
            return this;
        }

        @Override // com.avito.android.search.map.di.SearchMapComponent.Builder
        public SearchMapComponent.Builder screen(Screen screen) {
            this.d = (Screen) Preconditions.checkNotNull(screen);
            return this;
        }

        @Override // com.avito.android.search.map.di.SearchMapComponent.Builder
        public SearchMapComponent.Builder screenAnalyticsDependencies(ScreenAnalyticsDependencies screenAnalyticsDependencies) {
            this.b = (ScreenAnalyticsDependencies) Preconditions.checkNotNull(screenAnalyticsDependencies);
            return this;
        }

        @Override // com.avito.android.search.map.di.SearchMapComponent.Builder
        public SearchMapComponent.Builder searchMapDependencies(SearchMapDependencies searchMapDependencies) {
            this.a = (SearchMapDependencies) Preconditions.checkNotNull(searchMapDependencies);
            return this;
        }

        @Override // com.avito.android.search.map.di.SearchMapComponent.Builder
        @Deprecated
        public SearchMapComponent.Builder searchMapModule(SearchMapModule searchMapModule) {
            Preconditions.checkNotNull(searchMapModule);
            return this;
        }

        @Override // com.avito.android.search.map.di.SearchMapComponent.Builder
        public SearchMapComponent.Builder snippetClick(Relay relay) {
            this.u = (Relay) Preconditions.checkNotNull(relay);
            return this;
        }

        @Override // com.avito.android.search.map.di.SearchMapComponent.Builder
        public SearchMapComponent.Builder snippetClose(Relay relay) {
            this.v = (Relay) Preconditions.checkNotNull(relay);
            return this;
        }

        @Override // com.avito.android.search.map.di.SearchMapComponent.Builder
        public SearchMapComponent.Builder snippetVisibility(Relay relay) {
            this.w = (Relay) Preconditions.checkNotNull(relay);
            return this;
        }

        @Override // com.avito.android.search.map.di.SearchMapComponent.Builder
        public SearchMapComponent.Builder withActivity(Activity activity) {
            this.e = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.search.map.di.SearchMapComponent.Builder
        public SearchMapComponent.Builder withAdvertXlState(Kundle kundle) {
            this.n = kundle;
            return this;
        }

        @Override // com.avito.android.search.map.di.SearchMapComponent.Builder
        public SearchMapComponent.Builder withArguments(SearchMapFragment.Factory.Arguments arguments) {
            this.h = (SearchMapFragment.Factory.Arguments) Preconditions.checkNotNull(arguments);
            return this;
        }

        @Override // com.avito.android.search.map.di.SearchMapComponent.Builder
        public SearchMapComponent.Builder withFragment(Fragment fragment) {
            this.f = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }

        @Override // com.avito.android.search.map.di.SearchMapComponent.Builder
        public SearchMapComponent.Builder withFragmentManager(FragmentManager fragmentManager) {
            this.x = (FragmentManager) Preconditions.checkNotNull(fragmentManager);
            return this;
        }

        @Override // com.avito.android.search.map.di.SearchMapComponent.Builder
        public SearchMapComponent.Builder withInitTreeClickStreamParent(TreeClickStreamParent treeClickStreamParent) {
            this.k = treeClickStreamParent;
            return this;
        }

        @Override // com.avito.android.search.map.di.SearchMapComponent.Builder
        public SearchMapComponent.Builder withInlineFiltersState(Kundle kundle) {
            this.q = kundle;
            return this;
        }

        @Override // com.avito.android.search.map.di.SearchMapComponent.Builder
        public SearchMapComponent.Builder withItemVisibilityTrackerState(Bundle bundle) {
            this.s = bundle;
            return this;
        }

        @Override // com.avito.android.search.map.di.SearchMapComponent.Builder
        public SearchMapComponent.Builder withMapZoomLevelBounds(AvitoMapZoomLevel avitoMapZoomLevel) {
            this.m = (AvitoMapZoomLevel) Preconditions.checkNotNull(avitoMapZoomLevel);
            return this;
        }

        @Override // com.avito.android.search.map.di.SearchMapComponent.Builder
        public SearchMapComponent.Builder withResources(Resources resources) {
            this.g = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.search.map.di.SearchMapComponent.Builder
        public SearchMapComponent.Builder withRichGalleryState(Kundle kundle) {
            this.o = kundle;
            return this;
        }

        @Override // com.avito.android.search.map.di.SearchMapComponent.Builder
        public SearchMapComponent.Builder withRichSnippetRecycledViewPool(RecyclerView.RecycledViewPool recycledViewPool) {
            this.p = (RecyclerView.RecycledViewPool) Preconditions.checkNotNull(recycledViewPool);
            return this;
        }

        @Override // com.avito.android.search.map.di.SearchMapComponent.Builder
        public SearchMapComponent.Builder withSavedSearchMapState(SearchMapState searchMapState) {
            this.i = searchMapState;
            return this;
        }

        @Override // com.avito.android.search.map.di.SearchMapComponent.Builder
        public SearchMapComponent.Builder withSavedSearchesPresenterState(Kundle kundle) {
            this.r = kundle;
            return this;
        }

        @Override // com.avito.android.search.map.di.SearchMapComponent.Builder
        public SearchMapComponent.Builder withSerpOnboardingHandler(SerpOnboardingHandler serpOnboardingHandler) {
            this.y = null;
            return this;
        }

        @Override // com.avito.android.search.map.di.SearchMapComponent.Builder
        public SearchMapComponent.Builder withViewProvider(View view) {
            this.l = view;
            return this;
        }

        @Override // com.avito.android.search.map.di.SearchMapComponent.Builder
        public SearchMapComponent.Builder withWitcherSavedState(Kundle kundle) {
            this.j = kundle;
            return this;
        }
    }

    public static class b0 implements Provider<RandomKeyProvider> {
        public final SearchMapDependencies a;

        public b0(SearchMapDependencies searchMapDependencies) {
            this.a = searchMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public RandomKeyProvider get() {
            return (RandomKeyProvider) Preconditions.checkNotNullFromComponent(this.a.randomKeyProvider());
        }
    }

    public static class c implements Provider<ScreenTrackerFactory> {
        public final ScreenAnalyticsDependencies a;

        public c(ScreenAnalyticsDependencies screenAnalyticsDependencies) {
            this.a = screenAnalyticsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class c0 implements Provider<ManuallyExposedAbTestGroup<SimpleTestGroupWithNone>> {
        public final SearchMapDependencies a;

        public c0(SearchMapDependencies searchMapDependencies) {
            this.a = searchMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ManuallyExposedAbTestGroup<SimpleTestGroupWithNone> get() {
            return (ManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.realtyNewBackNavigation());
        }
    }

    public static class d implements Provider<TimerFactory> {
        public final ScreenAnalyticsDependencies a;

        public d(ScreenAnalyticsDependencies screenAnalyticsDependencies) {
            this.a = screenAnalyticsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimerFactory get() {
            return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
        }
    }

    public static class d0 implements Provider<SchedulersFactory3> {
        public final SearchMapDependencies a;

        public d0(SearchMapDependencies searchMapDependencies) {
            this.a = searchMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class e implements Provider<BackNavigationLocationInteractor> {
        public final LocationDependencies a;

        public e(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BackNavigationLocationInteractor get() {
            return (BackNavigationLocationInteractor) Preconditions.checkNotNullFromComponent(this.a.backNavigationLocationInteractor());
        }
    }

    public static class e0 implements Provider<SearchApi> {
        public final SearchMapDependencies a;

        public e0(SearchMapDependencies searchMapDependencies) {
            this.a = searchMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SearchApi get() {
            return (SearchApi) Preconditions.checkNotNullFromComponent(this.a.searchApi());
        }
    }

    public static class f implements Provider<LocationApi> {
        public final LocationDependencies a;

        public f(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public LocationApi get() {
            return (LocationApi) Preconditions.checkNotNullFromComponent(this.a.locationApi());
        }
    }

    public static class f0 implements Provider<SearchSubscriptionDao> {
        public final SearchMapDependencies a;

        public f0(SearchMapDependencies searchMapDependencies) {
            this.a = searchMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SearchSubscriptionDao get() {
            return (SearchSubscriptionDao) Preconditions.checkNotNullFromComponent(this.a.searchSubscriptionDao());
        }
    }

    public static class g implements Provider<SavedLocationStorage> {
        public final LocationDependencies a;

        public g(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SavedLocationStorage get() {
            return (SavedLocationStorage) Preconditions.checkNotNullFromComponent(this.a.savedLocationStorage());
        }
    }

    public static class g0 implements Provider<SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup>> {
        public final SearchMapDependencies a;

        public g0(SearchMapDependencies searchMapDependencies) {
            this.a = searchMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup> get() {
            return (SingleManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.sellerInfoInRichSnippet());
        }
    }

    public static class h implements Provider<TopLocationInteractor> {
        public final LocationDependencies a;

        public h(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TopLocationInteractor get() {
            return (TopLocationInteractor) Preconditions.checkNotNullFromComponent(this.a.topLocationInteractor());
        }
    }

    public static class h0 implements Provider<SharedPreferences> {
        public final SearchMapDependencies a;

        public h0(SearchMapDependencies searchMapDependencies) {
            this.a = searchMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SharedPreferences get() {
            return (SharedPreferences) Preconditions.checkNotNullFromComponent(this.a.sharedPreferences());
        }
    }

    public static class i implements Provider<AccountStateProvider> {
        public final SearchMapDependencies a;

        public i(SearchMapDependencies searchMapDependencies) {
            this.a = searchMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class i0 implements Provider<SubscriptionsApi> {
        public final SearchMapDependencies a;

        public i0(SearchMapDependencies searchMapDependencies) {
            this.a = searchMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SubscriptionsApi get() {
            return (SubscriptionsApi) Preconditions.checkNotNullFromComponent(this.a.subscriptionsApi());
        }
    }

    public static class j implements Provider<Analytics> {
        public final SearchMapDependencies a;

        public j(SearchMapDependencies searchMapDependencies) {
            this.a = searchMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class j0 implements Provider<TimeSource> {
        public final SearchMapDependencies a;

        public j0(SearchMapDependencies searchMapDependencies) {
            this.a = searchMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public static class k implements Provider<AsyncPhoneApi> {
        public final SearchMapDependencies a;

        public k(SearchMapDependencies searchMapDependencies) {
            this.a = searchMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AsyncPhoneApi get() {
            return (AsyncPhoneApi) Preconditions.checkNotNullFromComponent(this.a.asyncPhoneApi());
        }
    }

    public static class k0 implements Provider<TreeStateIdGenerator> {
        public final SearchMapDependencies a;

        public k0(SearchMapDependencies searchMapDependencies) {
            this.a = searchMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TreeStateIdGenerator get() {
            return (TreeStateIdGenerator) Preconditions.checkNotNullFromComponent(this.a.treeStateIdGenerator());
        }
    }

    public static class l implements Provider<SingleManuallyExposedAbTestGroup<SimpleTestGroup>> {
        public final SearchMapDependencies a;

        public l(SearchMapDependencies searchMapDependencies) {
            this.a = searchMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SingleManuallyExposedAbTestGroup<SimpleTestGroup> get() {
            return (SingleManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.autoGenerationsFilterWithPhotosTestGroup());
        }
    }

    public static class l0 implements Provider<TypedErrorThrowableConverter> {
        public final SearchMapDependencies a;

        public l0(SearchMapDependencies searchMapDependencies) {
            this.a = searchMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public static class m implements Provider<BuildInfo> {
        public final SearchMapDependencies a;

        public m(SearchMapDependencies searchMapDependencies) {
            this.a = searchMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BuildInfo get() {
            return (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo());
        }
    }

    public static class m0 implements Provider<ViewedAdvertsDao> {
        public final SearchMapDependencies a;

        public m0(SearchMapDependencies searchMapDependencies) {
            this.a = searchMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ViewedAdvertsDao get() {
            return (ViewedAdvertsDao) Preconditions.checkNotNullFromComponent(this.a.viewedAdvertsDao());
        }
    }

    public static class n implements Provider<ConnectivityProvider> {
        public final SearchMapDependencies a;

        public n(SearchMapDependencies searchMapDependencies) {
            this.a = searchMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ConnectivityProvider get() {
            return (ConnectivityProvider) Preconditions.checkNotNullFromComponent(this.a.connectivityProvider());
        }
    }

    public static class n0 implements Provider<ViewedAdvertsEventInteractor> {
        public final SearchMapDependencies a;

        public n0(SearchMapDependencies searchMapDependencies) {
            this.a = searchMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ViewedAdvertsEventInteractor get() {
            return (ViewedAdvertsEventInteractor) Preconditions.checkNotNullFromComponent(this.a.viewedAdvertsEventInteractor());
        }
    }

    public static class o implements Provider<Context> {
        public final SearchMapDependencies a;

        public o(SearchMapDependencies searchMapDependencies) {
            this.a = searchMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public static class p implements Provider<DeepLinkFactory> {
        public final SearchMapDependencies a;

        public p(SearchMapDependencies searchMapDependencies) {
            this.a = searchMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeepLinkFactory get() {
            return (DeepLinkFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkFactory());
        }
    }

    public static class q implements Provider<DeviceMetrics> {
        public final SearchMapDependencies a;

        public q(SearchMapDependencies searchMapDependencies) {
            this.a = searchMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeviceMetrics get() {
            return (DeviceMetrics) Preconditions.checkNotNullFromComponent(this.a.deviceMetrics());
        }
    }

    public static class r implements Provider<FavoriteAdvertsEventInteractor> {
        public final SearchMapDependencies a;

        public r(SearchMapDependencies searchMapDependencies) {
            this.a = searchMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsEventInteractor get() {
            return (FavoriteAdvertsEventInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsEventInteractor());
        }
    }

    public static class s implements Provider<FavoriteAdvertsUploadInteractor> {
        public final SearchMapDependencies a;

        public s(SearchMapDependencies searchMapDependencies) {
            this.a = searchMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsUploadInteractor get() {
            return (FavoriteAdvertsUploadInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsUploadInteractor());
        }
    }

    public static class t implements Provider<FavoritesSyncDao> {
        public final SearchMapDependencies a;

        public t(SearchMapDependencies searchMapDependencies) {
            this.a = searchMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoritesSyncDao get() {
            return (FavoritesSyncDao) Preconditions.checkNotNullFromComponent(this.a.favoritesSyncDao());
        }
    }

    public static class u implements Provider<Features> {
        public final SearchMapDependencies a;

        public u(SearchMapDependencies searchMapDependencies) {
            this.a = searchMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class v implements Provider<GeoStorage> {
        public final SearchMapDependencies a;

        public v(SearchMapDependencies searchMapDependencies) {
            this.a = searchMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public GeoStorage get() {
            return (GeoStorage) Preconditions.checkNotNullFromComponent(this.a.geoStorage());
        }
    }

    public static class w implements Provider<Locale> {
        public final SearchMapDependencies a;

        public w(SearchMapDependencies searchMapDependencies) {
            this.a = searchMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class x implements Provider<MyTargetImageBgProvider> {
        public final SearchMapDependencies a;

        public x(SearchMapDependencies searchMapDependencies) {
            this.a = searchMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MyTargetImageBgProvider get() {
            return (MyTargetImageBgProvider) Preconditions.checkNotNullFromComponent(this.a.myTargetImageBgProvider());
        }
    }

    public static class y implements Provider<ExposedAbTestGroup<OrangeAdBadgeTestGroup>> {
        public final SearchMapDependencies a;

        public y(SearchMapDependencies searchMapDependencies) {
            this.a = searchMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ExposedAbTestGroup<OrangeAdBadgeTestGroup> get() {
            return (ExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.orangeAdBadgeTestGroup());
        }
    }

    public static class z implements Provider<SerpItemsPrefetchTestGroup> {
        public final SearchMapDependencies a;

        public z(SearchMapDependencies searchMapDependencies) {
            this.a = searchMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SerpItemsPrefetchTestGroup get() {
            return (SerpItemsPrefetchTestGroup) Preconditions.checkNotNullFromComponent(this.a.prefetchTestGroup());
        }
    }

    public DaggerSearchMapComponent(SearchMapDependencies searchMapDependencies, ScreenAnalyticsDependencies screenAnalyticsDependencies, LocationDependencies locationDependencies, Screen screen, Activity activity, Fragment fragment, Resources resources, SearchMapFragment.Factory.Arguments arguments, SearchMapState searchMapState, Kundle kundle, TreeClickStreamParent treeClickStreamParent, View view, AvitoMapZoomLevel avitoMapZoomLevel, Kundle kundle2, Kundle kundle3, RecyclerView.RecycledViewPool recycledViewPool, Kundle kundle4, Kundle kundle5, Bundle bundle, BannerPageSource bannerPageSource, Relay relay, Relay relay2, Relay relay3, FragmentManager fragmentManager, SerpOnboardingHandler serpOnboardingHandler, a aVar) {
        this.a = searchMapDependencies;
        this.b = screenAnalyticsDependencies;
        this.c = screen;
        this.d = bannerPageSource;
        g gVar = new g(locationDependencies);
        this.e = gVar;
        f fVar = new f(locationDependencies);
        this.f = fVar;
        h hVar = new h(locationDependencies);
        this.g = hVar;
        u uVar = new u(searchMapDependencies);
        this.h = uVar;
        e eVar = new e(locationDependencies);
        this.i = eVar;
        SavedLocationInteractorImpl_Factory create = SavedLocationInteractorImpl_Factory.create(gVar, fVar, hVar, uVar, eVar);
        this.j = create;
        this.k = SingleCheck.provider(create);
        this.l = new j(searchMapDependencies);
        this.m = new k0(searchMapDependencies);
        Factory createNullable = InstanceFactory.createNullable(treeClickStreamParent);
        this.o = createNullable;
        SearchMapAnalyticsInteractorImpl_Factory create2 = SearchMapAnalyticsInteractorImpl_Factory.create(this.l, this.m, this.h, this.n, createNullable);
        this.p = create2;
        this.q = DoubleCheck.provider(create2);
        SimpleClickStreamLinkHandler_Factory create3 = SimpleClickStreamLinkHandler_Factory.create(this.l);
        this.r = create3;
        this.s = DoubleCheck.provider(create3);
        this.t = new i(searchMapDependencies);
        this.u = new e0(searchMapDependencies);
        this.v = DoubleCheck.provider(SearchParamsConverterImpl_Factory.create());
        Provider<InlineFiltersChangesParamsConverter> provider = DoubleCheck.provider(InlineFiltersChangesParamsConverterImpl_Factory.create());
        this.w = provider;
        this.x = new d0(searchMapDependencies);
        InlineFiltersInteractorImpl_Factory create4 = InlineFiltersInteractorImpl_Factory.create(this.u, this.v, provider, InlineFiltersParametersKeyWrapper_Factory.create(), this.x, this.h);
        this.y = create4;
        this.z = DoubleCheck.provider(create4);
        this.A = DoubleCheck.provider(ShortcutNavigationItemConverterImpl_Factory.create());
        l lVar = new l(searchMapDependencies);
        this.B = lVar;
        InlineFiltersDialogItemConverterImpl_Factory create5 = InlineFiltersDialogItemConverterImpl_Factory.create(this.h, lVar);
        this.C = create5;
        this.D = DoubleCheck.provider(create5);
        c cVar = new c(screenAnalyticsDependencies);
        this.E = cVar;
        d dVar = new d(screenAnalyticsDependencies);
        this.F = dVar;
        SerpTrackerImpl_Factory create6 = SerpTrackerImpl_Factory.create(cVar, dVar);
        this.G = create6;
        this.H = DoubleCheck.provider(create6);
        Factory createNullable2 = InstanceFactory.createNullable(kundle4);
        this.I = createNullable2;
        InlineFiltersPresenterImpl_Factory create7 = InlineFiltersPresenterImpl_Factory.create(this.z, this.A, this.D, this.x, this.l, this.H, createNullable2);
        this.J = create7;
        this.K = DoubleCheck.provider(create7);
        k kVar = new k(searchMapDependencies);
        this.L = kVar;
        AsyncPhoneInteractorImpl_Factory create8 = AsyncPhoneInteractorImpl_Factory.create(kVar, this.x);
        this.M = create8;
        this.N = SingleCheck.provider(create8);
        this.O = new l0(searchMapDependencies);
        Factory create9 = InstanceFactory.create(screen);
        this.P = create9;
        AsyncPhoneTrackerImpl_Factory create10 = AsyncPhoneTrackerImpl_Factory.create(this.E, this.F, create9);
        this.Q = create10;
        this.R = SingleCheck.provider(create10);
        Provider<AdvertItemEventListener> provider2 = DoubleCheck.provider(AdvertItemEventListenerImpl_Factory.create());
        this.S = provider2;
        Provider<AsyncPhoneInteractor> provider3 = this.N;
        Provider<TypedErrorThrowableConverter> provider4 = this.O;
        AsyncPhonePresenterImpl_Factory create11 = AsyncPhonePresenterImpl_Factory.create(provider3, provider4, this.R, this.x, this.t, this.h, provider2, provider4);
        this.T = create11;
        Provider<AsyncPhonePresenter> provider5 = SingleCheck.provider(create11);
        this.U = provider5;
        NavigationMiddlewareImpl_Factory create12 = NavigationMiddlewareImpl_Factory.create(this.q, this.s, this.t, this.K, provider5);
        this.V = create12;
        this.W = DoubleCheck.provider(create12);
        Factory create13 = InstanceFactory.create(arguments);
        this.X = create13;
        this.Y = DoubleCheck.provider(SearchMapModule_ProvideSearchParamsFactory.create(create13));
        SuggestParamsConverterImpl_Factory create14 = SuggestParamsConverterImpl_Factory.create(this.v);
        this.Z = create14;
        this.a0 = DoubleCheck.provider(create14);
        SearchDeepLinkInteractorImpl_Factory create15 = SearchDeepLinkInteractorImpl_Factory.create(this.u, this.v, this.x);
        this.b0 = create15;
        this.c0 = DoubleCheck.provider(create15);
        this.d0 = InstanceFactory.createNullable(view);
        Factory create16 = InstanceFactory.create(resources);
        this.e0 = create16;
        MapViewPortProviderImpl_Factory create17 = MapViewPortProviderImpl_Factory.create(this.d0, create16);
        this.f0 = create17;
        Provider<MapViewPortProvider> provider6 = DoubleCheck.provider(create17);
        this.g0 = provider6;
        SearchMapInteractorImpl_Factory create18 = SearchMapInteractorImpl_Factory.create(this.u, this.Y, this.a0, this.v, this.O, this.c0, provider6, this.x, this.n, this.z, this.h);
        this.h0 = create18;
        this.i0 = DoubleCheck.provider(create18);
        Factory create19 = InstanceFactory.create(activity);
        this.j0 = create19;
        MarkerIconFactoryImpl_Factory create20 = MarkerIconFactoryImpl_Factory.create(create19);
        this.k0 = create20;
        this.l0 = DoubleCheck.provider(create20);
        Factory createNullable3 = InstanceFactory.createNullable(serpOnboardingHandler);
        this.m0 = createNullable3;
        this.n0 = SingleCheck.provider(AdvertItemPresenterModule_ProvideAdvertListItemPresenterFactory.create(this.S, this.l, this.h, createNullable3));
        this.o0 = new j0(searchMapDependencies);
        this.p0 = new w(searchMapDependencies);
        a0 a0Var = new a0(searchMapDependencies);
        this.q0 = a0Var;
        z zVar = new z(searchMapDependencies);
        this.r0 = zVar;
        SerpItemAbViewConfig_Factory create21 = SerpItemAbViewConfig_Factory.create(a0Var, zVar);
        this.s0 = create21;
        n nVar = new n(searchMapDependencies);
        this.t0 = nVar;
        this.u0 = SingleCheck.provider(AdvertItemModule_ProvideAdvertItemListBlueprintFactory.create(this.n0, this.o0, this.p0, create21, nVar));
        DateTimeFormatterResourceProviderImpl_Factory create22 = DateTimeFormatterResourceProviderImpl_Factory.create(this.e0);
        this.v0 = create22;
        this.w0 = DateTimeFormatterModule_ProvideUpperCaseDateTimeFormatterFactory.create(this.o0, create22, this.p0);
        this.x0 = InstanceFactory.createNullable(kundle3);
        AdvertSellerConverterImpl_Factory create23 = AdvertSellerConverterImpl_Factory.create(this.h);
        this.y0 = create23;
        Provider<AdvertSellerConverter> provider7 = SingleCheck.provider(create23);
        this.z0 = provider7;
        g0 g0Var = new g0(searchMapDependencies);
        this.A0 = g0Var;
        AdvertRichItemPresenterImpl_Factory create24 = AdvertRichItemPresenterImpl_Factory.create(this.S, this.w0, this.l, this.x0, provider7, this.U, g0Var, this.h, this.m0);
        this.B0 = create24;
        this.C0 = SingleCheck.provider(create24);
        this.D0 = InstanceFactory.create(recycledViewPool);
        SellerInfoParamsFactoryImpl_Factory create25 = SellerInfoParamsFactoryImpl_Factory.create(this.e0, this.A0);
        this.E0 = create25;
        Provider<SellerInfoParamsFactory> provider8 = SingleCheck.provider(create25);
        this.F0 = provider8;
        this.G0 = AdvertRichSmallItemBlueprint_Factory.create(this.C0, this.D0, this.h, provider8, this.r0);
        SellerPinItemPresenterImpl_Factory create26 = SellerPinItemPresenterImpl_Factory.create(this.S);
        this.H0 = create26;
        Provider<SellerPinItemPresenter> provider9 = DoubleCheck.provider(create26);
        this.I0 = provider9;
        SellerPinItemBlueprint_Factory create27 = SellerPinItemBlueprint_Factory.create(provider9);
        this.J0 = create27;
        Provider<ItemBinder> provider10 = DoubleCheck.provider(PinAdvertsListModule_ProvidePinAdvertsItemBinderFactory.create(this.u0, this.G0, create27));
        this.K0 = provider10;
        this.L0 = DoubleCheck.provider(PinAdvertsListModule_ProvidePinAdvertsAdapterPresenterFactory.create(provider10));
        this.M0 = new t(searchMapDependencies);
        this.N0 = new s(searchMapDependencies);
        this.O0 = new r(searchMapDependencies);
        FavoriteAdvertsAnalyticsInteractorImpl_Factory create28 = FavoriteAdvertsAnalyticsInteractorImpl_Factory.create(this.l, this.t);
        this.P0 = create28;
        this.Q0 = FavoriteAdvertsInteractorImpl_Factory.create(this.M0, this.N0, this.O0, create28, this.x);
        FavoriteAdvertsResourceProviderImpl_Factory create29 = FavoriteAdvertsResourceProviderImpl_Factory.create(this.e0);
        this.R0 = create29;
        Provider<FavoriteAdvertsResourceProvider> provider11 = DoubleCheck.provider(create29);
        this.S0 = provider11;
        FavoriteAdvertsPresenterImpl_Factory create30 = FavoriteAdvertsPresenterImpl_Factory.create(this.Q0, provider11, this.x);
        this.T0 = create30;
        this.U0 = DoubleCheck.provider(create30);
        n0 n0Var = new n0(searchMapDependencies);
        this.V0 = n0Var;
        ViewedAdvertsPresenterImpl_Factory create31 = ViewedAdvertsPresenterImpl_Factory.create(n0Var, this.x);
        this.W0 = create31;
        this.X0 = DoubleCheck.provider(create31);
        Provider<SpannedGridPositionProvider> provider12 = SingleCheck.provider(SpanAdapterModule_ProvideSpannedGridPositionProviderFactory.create(this.e0));
        this.Y0 = provider12;
        Provider<SpannedGridPositionProvider> provider13 = DoubleCheck.provider(provider12);
        this.Z0 = provider13;
        this.a1 = DoubleCheck.provider(PinAdvertsListModule_ProvideSpanProvider$map_releaseFactory.create(provider13, this.e0));
        this.b1 = DoubleCheck.provider(AppendingRetryListenerImpl_Factory.create());
        Provider<PublishFloatingViewsProvider> provider14 = DoubleCheck.provider(SearchMapModule_ProvidePublishFloatingViewsPresenterFactory.create());
        this.c1 = provider14;
        PinAdvertsListViewBinderImpl_Factory create32 = PinAdvertsListViewBinderImpl_Factory.create(this.L0, this.U0, this.X0, this.a1, this.Z0, this.b1, provider14);
        this.d1 = create32;
        this.e1 = DoubleCheck.provider(create32);
        m mVar = new m(searchMapDependencies);
        this.f1 = mVar;
        this.g1 = DoubleCheck.provider(PinAdvertsListModule_ProvidePinAdvertsAdapterFactory.create(this.L0, this.K0, mVar, this.l));
        this.h1 = DoubleCheck.provider(PinAdvertsListModule_ProvideSpanSizeLookup$map_releaseFactory.create(this.a1));
        Provider<AdvertGridItemPresenter> provider15 = SingleCheck.provider(AdvertItemPresenterModule_ProvideAdvertGridItemPresenterFactory.create(this.S, this.l, this.h, this.m0));
        this.i1 = provider15;
        this.j1 = SingleCheck.provider(AdvertItemModule_ProvideAdvertItemGridBlueprintFactory.create(provider15, this.o0, this.p0, this.s0, this.t0));
        this.k1 = SingleCheck.provider(AdvertItemModule_ProvideAdvertItemDoubleBlueprintFactory.create(this.i1, this.o0, this.p0, this.s0, this.t0));
        AdvertXlDimensionsProviderImpl_Factory create33 = AdvertXlDimensionsProviderImpl_Factory.create(this.e0);
        this.l1 = create33;
        this.m1 = SingleCheck.provider(create33);
        Factory createNullable4 = InstanceFactory.createNullable(kundle2);
        this.n1 = createNullable4;
        AdvertXlItemPresenterImpl_Factory create34 = AdvertXlItemPresenterImpl_Factory.create(this.S, this.w0, this.m1, this.U, this.l, this.h, this.m0, createNullable4);
        this.o1 = create34;
        Provider<AdvertXlItemPresenter> provider16 = SingleCheck.provider(create34);
        this.p1 = provider16;
        this.q1 = AdvertXlItemBlueprint_Factory.create(provider16, this.s0);
        this.r1 = AdvertVipRichItemBlueprint_Factory.create(this.C0, this.D0, this.h, this.F0, this.r0);
        RichSnippetsResourceProviderImpl_Factory create35 = RichSnippetsResourceProviderImpl_Factory.create(this.e0);
        this.s1 = create35;
        Provider<RichSnippetsResourceProvider> provider17 = SingleCheck.provider(create35);
        this.t1 = provider17;
        AdvertXlRichItemPresenterImpl_Factory create36 = AdvertXlRichItemPresenterImpl_Factory.create(this.S, this.w0, provider17, this.l, this.z0, this.U, this.h, this.m0, this.A0, this.x0);
        this.u1 = create36;
        Provider<AdvertXlRichItemPresenter> provider18 = SingleCheck.provider(create36);
        this.v1 = provider18;
        this.w1 = AdvertXlRichItemBlueprint_Factory.create(provider18, this.D0, this.h, this.F0, this.r0);
        this.x1 = AdvertRichItemBlueprint_Factory.create(this.C0, this.D0, this.h, this.F0, this.r0);
        y yVar = new y(searchMapDependencies);
        this.y1 = yVar;
        YandexContentItemPresenterImpl_Factory create37 = YandexContentItemPresenterImpl_Factory.create(this.S, this.l, yVar);
        this.z1 = create37;
        Provider<YandexContentItemPresenter> provider19 = DoubleCheck.provider(create37);
        this.A1 = provider19;
        this.B1 = YandexContentSingleGridBlueprint_Factory.create(provider19);
        this.C1 = YandexContentDoubleGridBlueprint_Factory.create(this.A1);
        this.D1 = YandexContentRichBlueprint_Factory.create(this.A1);
        YandexAppInstallItemPresenterImpl_Factory create38 = YandexAppInstallItemPresenterImpl_Factory.create(this.S, this.l);
        this.E1 = create38;
        Provider<YandexAppInstallItemPresenter> provider20 = DoubleCheck.provider(create38);
        this.F1 = provider20;
        this.G1 = YandexAppInstallSingleItemBlueprint_Factory.create(provider20);
        this.H1 = YandexAppInstallDoubleItemBlueprint_Factory.create(this.F1);
        this.I1 = YandexAppInstallRichBlueprint_Factory.create(this.F1);
        AdfoxImageItemPresenterImpl_Factory create39 = AdfoxImageItemPresenterImpl_Factory.create(this.S, this.l, this.y1);
        this.J1 = create39;
        Provider<AdfoxImageItemPresenter> provider21 = DoubleCheck.provider(create39);
        this.K1 = provider21;
        this.L1 = AdfoxSingleGridBlueprint_Factory.create(provider21);
        this.M1 = AdfoxSingleListBlueprint_Factory.create(this.K1);
        Provider<DfpDebugPresenter> provider22 = DoubleCheck.provider(DfpDebugPresenterImpl_Factory.create());
        this.N1 = provider22;
        DfpUnifiedPresenterImpl_Factory create40 = DfpUnifiedPresenterImpl_Factory.create(this.S, provider22, this.x);
        this.O1 = create40;
        Provider<DfpUnifiedPresenter> provider23 = DoubleCheck.provider(create40);
        this.P1 = provider23;
        this.Q1 = DfpUnifiedDoubleBlueprint_Factory.create(provider23);
        DfpAppInstallPresenterImpl_Factory create41 = DfpAppInstallPresenterImpl_Factory.create(this.S, this.N1);
        this.R1 = create41;
        Provider<DfpAppInstallPresenter> provider24 = DoubleCheck.provider(create41);
        this.S1 = provider24;
        this.T1 = DfpAppInstallDoubleBlueprint_Factory.create(provider24);
        this.U1 = DfpAppInstallSingleBlueprint_Factory.create(this.S1);
        this.V1 = DfpUnifiedSingleGridBlueprint_Factory.create(this.P1);
        DfpContentPresenterImpl_Factory create42 = DfpContentPresenterImpl_Factory.create(this.S, this.N1);
        this.W1 = create42;
        Provider<DfpContentPresenter> provider25 = DoubleCheck.provider(create42);
        this.X1 = provider25;
        this.Y1 = DfpContentSingleGridBlueprint_Factory.create(provider25);
        this.Z1 = DfpContentDoubleGridBlueprint_Factory.create(this.X1);
        x xVar = new x(searchMapDependencies);
        this.f58a2 = xVar;
        MyTargetContentPresenterImpl_Factory create43 = MyTargetContentPresenterImpl_Factory.create(this.S, xVar, this.h);
        this.b2 = create43;
        Provider<MyTargetContentPresenter> provider26 = DoubleCheck.provider(create43);
        this.c2 = provider26;
        this.d2 = MyTargetContentBlueprint_Factory.create(provider26);
        MyTargetAppInstallPresenterImpl_Factory create44 = MyTargetAppInstallPresenterImpl_Factory.create(this.S, this.f58a2, this.h);
        this.e2 = create44;
        Provider<MyTargetAppInstallPresenter> provider27 = DoubleCheck.provider(create44);
        this.f2 = provider27;
        this.g2 = MyTargetAppInstallSingleBlueprint_Factory.create(provider27);
        this.h2 = MyTargetAppInstallBlueprint_Factory.create(this.f2);
        this.i2 = MyTargetContentSingleBlueprint_Factory.create(this.c2);
        this.j2 = NotLoadAdStubGridBlueprint_Factory.create(NotLoadAdStubPresenter_Factory.create());
        Provider<EmptyAdStubItemPresenter> provider28 = DoubleCheck.provider(EmptyAdStubItemPresenterImpl_Factory.create());
        this.k2 = provider28;
        this.l2 = EmptyAdStubItemBlueprint_Factory.create(provider28);
        SerpWarningItemPresenterImpl_Factory create45 = SerpWarningItemPresenterImpl_Factory.create(this.S);
        this.m2 = create45;
        Provider<SerpWarningItemPresenter> provider29 = SingleCheck.provider(create45);
        this.n2 = provider29;
        this.o2 = SerpWarningItemBlueprint_Factory.create(provider29);
        this.p2 = InstanceFactory.create(relay);
        this.q2 = InstanceFactory.create(relay2);
        Factory create46 = InstanceFactory.create(relay3);
        this.r2 = create46;
        SnippetPresenter_Impl_Factory create47 = SnippetPresenter_Impl_Factory.create(this.p2, this.q2, create46);
        this.s2 = create47;
        Provider<SnippetPresenter> provider30 = SingleCheck.provider(create47);
        this.t2 = provider30;
        this.u2 = SnippetBlueprint_Factory.create(provider30);
        Provider<GroupTitleItemPresenter> provider31 = SingleCheck.provider(GroupTitleItemPresenterImpl_Factory.create());
        this.v2 = provider31;
        this.w2 = GroupTitleItemBlueprint_Factory.create(provider31);
        EmptyPlaceholderItemPresenterImpl_Factory create48 = EmptyPlaceholderItemPresenterImpl_Factory.create(this.S);
        this.x2 = create48;
        Provider<EmptyPlaceholderItemPresenter> provider32 = SingleCheck.provider(create48);
        this.y2 = provider32;
        this.z2 = EmptyPlaceholderItemBlueprint_Factory.create(provider32);
        this.A2 = YandexContentListBlueprint_Factory.create(this.A1);
        this.B2 = YandexAppInstallListItemBlueprint_Factory.create(this.F1);
        this.C2 = DfpUnifiedListBlueprint_Factory.create(this.P1);
        this.D2 = DfpContentListBlueprint_Factory.create(this.X1);
        this.E2 = DfpAppInstallListBlueprint_Factory.create(this.S1);
        this.F2 = MyTargetContentListBlueprint_Factory.create(this.c2);
        this.G2 = MyTargetAppInstallListBlueprint_Factory.create(this.f2);
        this.H2 = NotLoadAdStubListBlueprint_Factory.create(NotLoadAdStubPresenter_Factory.create());
        this.I2 = NotLoadAdRichStubBlueprint_Factory.create(NotLoadAdStubPresenter_Factory.create());
        WitcherResourceProviderImpl_Factory create49 = WitcherResourceProviderImpl_Factory.create(this.e0);
        this.J2 = create49;
        this.K2 = DoubleCheck.provider(create49);
        this.L2 = InstanceFactory.createNullable(kundle);
        WitcherAnalyticsInteractorImpl_Factory create50 = WitcherAnalyticsInteractorImpl_Factory.create(this.l);
        this.M2 = create50;
        this.N2 = DoubleCheck.provider(create50);
        Provider<SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup>> provider33 = DoubleCheck.provider(SearchMapModule_ProvideViewedItemsTabTestGroupFactory.create());
        this.O2 = provider33;
        WitcherItemPresenterImpl_Factory create51 = WitcherItemPresenterImpl_Factory.create(this.K2, this.S, this.L2, this.N2, provider33);
        this.P2 = create51;
        this.Q2 = SingleCheck.provider(create51);
        this.R2 = DoubleCheck.provider(WitcherModule_ProvidesWitcherItemsBinderFactory.create(this.j1));
        this.S2 = WitcherModule_ProvideWitcherViewedAdvertsPresenter$serp_core_releaseFactory.create(this.V0, this.x);
        this.T2 = WitcherModule_ProvideWitcherFavoriteAdvertsPresenter$serp_core_releaseFactory.create(this.Q0, this.S0, this.x);
        WitcherModule_ProvideWitcherAdapter$serp_core_releaseFactory create52 = WitcherModule_ProvideWitcherAdapter$serp_core_releaseFactory.create(this.R2);
        this.U2 = create52;
        q qVar = new q(searchMapDependencies);
        this.V2 = qVar;
        this.W2 = WitcherItemBlueprint_Factory.create(this.Q2, this.R2, this.K2, this.S2, this.T2, create52, qVar);
        PromoCardItemPresenter_Factory create53 = PromoCardItemPresenter_Factory.create(this.S, this.l);
        this.X2 = create53;
        this.Y2 = PromoCardBlueprint_Factory.create(create53);
        MapBannerItemPresenterImpl_Factory create54 = MapBannerItemPresenterImpl_Factory.create(this.S);
        this.Z2 = create54;
        Provider<MapBannerItemPresenter> provider34 = SingleCheck.provider(create54);
        this.a3 = provider34;
        MapBannerItemBlueprint_Factory create55 = MapBannerItemBlueprint_Factory.create(provider34);
        this.b3 = create55;
        Provider<ItemBinder> provider35 = DoubleCheck.provider(SerpListModule_ProvideSerpListItemBinderFactory.create(this.j1, this.u0, this.k1, this.q1, this.r1, this.w1, this.x1, this.B1, this.C1, this.D1, this.G1, this.H1, this.I1, this.L1, this.M1, this.Q1, this.T1, this.U1, this.V1, this.Y1, this.Z1, this.d2, this.g2, this.h2, this.i2, this.j2, this.l2, this.o2, this.u2, this.w2, this.z2, this.A2, this.B2, this.C2, this.D2, this.E2, this.F2, this.G2, this.H2, this.I2, this.W2, this.Y2, create55));
        this.c3 = provider35;
        this.d3 = DoubleCheck.provider(SerpListModule_ProvideSerpListAdapterPresenterFactory.create(provider35));
        this.e3 = DoubleCheck.provider(this.T0);
        this.f3 = DoubleCheck.provider(this.W0);
        Provider<SerpSpanProvider> provider36 = SingleCheck.provider(SpanAdapterModule_ProvideSerpSpanProviderFactory.create(this.Y0, this.e0));
        this.g3 = provider36;
        this.h3 = DoubleCheck.provider(provider36);
        this.i3 = DoubleCheck.provider(this.Y0);
        this.j3 = InstanceFactory.create(bannerPageSource);
        Provider<TreeClickStreamParent> provider37 = DoubleCheck.provider(SearchMapModule_ProvideTreeParent$map_releaseFactory.create(this.q));
        this.k3 = provider37;
        CommercialBannersAnalyticsInteractorImpl_Factory create56 = CommercialBannersAnalyticsInteractorImpl_Factory.create(this.j3, this.l, provider37, this.m, CommercialBannerTimeProviderImpl_Factory.create());
        this.l3 = create56;
        this.m3 = BannerViewFilter_Factory.create(create56);
        Factory createNullable5 = InstanceFactory.createNullable(bundle);
        this.n3 = createNullable5;
        this.o3 = DoubleCheck.provider(SerpListModule_ProvideItemVisibilityTracker$map_releaseFactory.create(this.m3, createNullable5));
        Provider<ClosedItemEventInteractor> provider38 = SingleCheck.provider(ClosedItemModule_ProvideClosedItemEventInteractorFactory.create());
        this.p3 = provider38;
        this.q3 = DoubleCheck.provider(ClosedItemModule_ProvideViewedAdvertsPresenterFactory.create(provider38, this.x));
        this.r3 = DoubleCheck.provider(AppendingRetryListenerImpl_Factory.create());
        Provider<SnippetScrollDepthTracker> provider39 = DoubleCheck.provider(SnippetScrollDepthTrackerImpl_Factory.create());
        this.s3 = provider39;
        SerpListViewBinderImpl_Factory create57 = SerpListViewBinderImpl_Factory.create(this.d3, this.e3, this.f3, this.h3, this.i3, this.o3, this.q3, this.r3, this.c1, provider39);
        this.t3 = create57;
        this.u3 = DoubleCheck.provider(create57);
        Provider<DestroyableViewHolderBuilder> provider40 = DoubleCheck.provider(SerpListModule_ProvideDestroyableViewHolderBuilderFactory.create(this.c3));
        this.v3 = provider40;
        this.w3 = DoubleCheck.provider(SerpListModule_ProvideSerpListAdapterFactory.create(this.d3, provider40, this.f1, this.l));
        SpanLookup_Factory create58 = SpanLookup_Factory.create(this.g3);
        this.x3 = create58;
        Provider<GridLayoutManager.SpanSizeLookup> provider41 = SingleCheck.provider(create58);
        this.y3 = provider41;
        this.z3 = DoubleCheck.provider(provider41);
        SerpListResourcesProviderImpl_Factory create59 = SerpListResourcesProviderImpl_Factory.create(this.j0, this.e0);
        this.A3 = create59;
        this.B3 = DoubleCheck.provider(create59);
        MapAreaConverterImpl_Factory create60 = MapAreaConverterImpl_Factory.create(this.g0);
        this.C3 = create60;
        this.D3 = DoubleCheck.provider(create60);
        this.E3 = DoubleCheck.provider(SearchMapModule_ProvideSerpBottomSheetBehaviourProviderFactory.create());
        this.F3 = DoubleCheck.provider(SearchMapModule_ProvidePinAdvertsBottomSheetBehaviourProviderFactory.create());
        SearchMapTrackerImpl_Factory create61 = SearchMapTrackerImpl_Factory.create(this.F, this.E);
        this.G3 = create61;
        this.H3 = DoubleCheck.provider(create61);
        this.I3 = DoubleCheck.provider(SearchMapModule_ProvideAvitoMapAttachHelperFactory.create(this.h));
        InlineFilterDialogFactoryImpl_Factory create62 = InlineFilterDialogFactoryImpl_Factory.create(this.j0, this.B, this.h);
        this.J3 = create62;
        this.K3 = DoubleCheck.provider(create62);
        i0 i0Var = new i0(searchMapDependencies);
        this.L3 = i0Var;
        f0 f0Var = new f0(searchMapDependencies);
        this.M3 = f0Var;
        SubscribeSearchInteractorImpl_Factory create63 = SubscribeSearchInteractorImpl_Factory.create(i0Var, f0Var, this.v, this.O, this.x);
        this.N3 = create63;
        this.O3 = DoubleCheck.provider(create63);
        Factory createNullable6 = InstanceFactory.createNullable(kundle5);
        this.P3 = createNullable6;
        SavedSearchesPresenterImpl_Factory create64 = SavedSearchesPresenterImpl_Factory.create(this.O3, this.x, this.t, this.l, createNullable6);
        this.Q3 = create64;
        Provider<SavedSearchesPresenter> provider42 = DoubleCheck.provider(create64);
        this.R3 = provider42;
        c0 c0Var = new c0(searchMapDependencies);
        this.S3 = c0Var;
        SearchMapViewFactoryImpl_Factory create65 = SearchMapViewFactoryImpl_Factory.create(this.x, this.i0, this.l0, this.l, this.e1, this.g1, this.h1, this.Z0, this.b1, this.u3, this.w3, this.z3, this.i3, this.r3, this.o3, this.B3, this.D3, this.p2, this.q2, this.r2, this.c1, this.E3, this.F3, this.H3, this.I3, this.K, this.K3, provider42, c0Var, this.r0, this.h, this.U0, this.s3);
        this.T3 = create65;
        this.U3 = DoubleCheck.provider(create65);
        LocationAnalyticsInteractorImpl_Factory create66 = LocationAnalyticsInteractorImpl_Factory.create(this.l, this.o0);
        this.V3 = create66;
        Provider<LocationAnalyticsInteractor> provider43 = SingleCheck.provider(create66);
        this.W3 = provider43;
        LoggingMiddlewareImpl_Factory create67 = LoggingMiddlewareImpl_Factory.create(this.H3, this.q, provider43, this.l3);
        this.X3 = create67;
        this.Y3 = DoubleCheck.provider(create67);
        this.Z3 = SingleCheck.provider(SerpItemConverterModule_ProvideItemAdvertSpanCountProviderFactory.create(this.e0));
        Provider<AdvertSpanCountProvider> provider44 = SingleCheck.provider(SerpItemConverterModule_ProvideBigAdvertSpanCountProviderFactory.create(this.e0));
        this.a4 = provider44;
        this.b4 = SingleCheck.provider(SerpItemConverterModule_ProvideAdvertConverterFactory.create(this.Z3, provider44, this.e0, this.h));
        this.c4 = SingleCheck.provider(SerpItemConverterModule_ProvideAdvertXlConverterFactory.create(this.e0, this.h));
        Provider<AdResourceProvider> provider45 = DoubleCheck.provider(AdResourceProviderImpl_Factory.create());
        this.d4 = provider45;
        b0 b0Var = new b0(searchMapDependencies);
        this.e4 = b0Var;
        this.f4 = SingleCheck.provider(SerpItemConverterModule_ProvideCommercialConverterFactory.create(this.Z3, this.a4, provider45, b0Var));
        p pVar = new p(searchMapDependencies);
        this.g4 = pVar;
        this.h4 = SingleCheck.provider(SerpItemConverterModule_ProvideShortcutBannerConverterFactory.create(pVar, this.e0));
        this.i4 = SingleCheck.provider(SerpItemConverterModule_ProvideSerpWarningConverterFactory.create());
        this.j4 = SingleCheck.provider(SerpItemConverterModule_ProvideSnippetConverterFactory.create());
        this.k4 = SingleCheck.provider(SerpItemConverterModule_ProvideSerpEmptySearchConverterFactory.create());
        this.l4 = SingleCheck.provider(SerpItemConverterModule_ProvideGroupTitleItemConverterFactory.create());
        this.m4 = SingleCheck.provider(SerpItemConverterModule_ProvideEmptyPlaceholderItemConverterFactory.create());
        this.n4 = SingleCheck.provider(SerpItemConverterModule_ProvideHeaderElementConverterFactory.create());
        this.o4 = SingleCheck.provider(SerpItemConverterModule_ProvideFavoriteStatusResolverFactory.create(this.Q0));
        this.p4 = new m0(searchMapDependencies);
        Provider<ViewedAdvertsInteractor> provider46 = SingleCheck.provider(ViewedAdvertsModule_ProvideViewedAdvertsInteractorFactory.create(ViewedAdvertsInteractorFactoryImpl_Factory.create(), this.p4, this.x, this.V0, this.h));
        this.q4 = provider46;
        Provider<ViewedStatusResolver> provider47 = SingleCheck.provider(ViewedAdvertsModule_ProvideViewedStatusResolverFactory.create(provider46));
        this.r4 = provider47;
        this.s4 = SingleCheck.provider(SerpItemConverterModule_ProvideWitcherElementConverterFactory.create(this.b4, this.o4, provider47));
        this.t4 = SingleCheck.provider(SerpItemConverterModule_ProvideLocationNotificationConverterFactory.create());
        this.u4 = SingleCheck.provider(SerpItemConverterModule_ProvideSellerElementConverterFactory.create());
        this.v4 = SingleCheck.provider(SerpItemConverterModule_ProvideReportBannerConverterFactory.create(this.e0, this.h));
        this.w4 = SingleCheck.provider(SerpItemConverterModule_ProvidePromoCardConverterFactory.create(this.e0, this.h));
        this.x4 = SingleCheck.provider(SerpItemConverterModule_ProvideMapBannerConverterFactory.create());
        Provider<VerticalFilterItemConverter> provider48 = SingleCheck.provider(SerpItemConverterModule_ProvideVerticalFilterItemConverterFactory.create());
        this.y4 = provider48;
        this.z4 = SingleCheck.provider(SerpItemConverterModule_ProvideElementItemConverterFactory.create(this.b4, this.c4, this.f4, this.h4, this.i4, this.j4, this.k4, this.l4, this.m4, this.n4, this.s4, this.t4, this.u4, this.v4, this.w4, this.x4, provider48));
        this.A4 = SingleCheck.provider(SerpItemConverterModule_ProvideSerpItemSorterFactory.create());
        Provider<SerpItemSizeAdjuster> provider49 = SingleCheck.provider(SerpItemConverterModule_ProvideItemSizeAdjusterFactory.create());
        this.B4 = provider49;
        Provider<SerpItemProcessor> provider50 = SingleCheck.provider(SerpItemConverterModule_ProvideSerpItemProcessorFactory.create(this.z4, this.A4, provider49, this.o4, this.r4, this.x));
        this.C4 = provider50;
        this.D4 = DoubleCheck.provider(provider50);
        o oVar = new o(searchMapDependencies);
        this.E4 = oVar;
        DfpBannerLoaderImpl_Factory create68 = DfpBannerLoaderImpl_Factory.create(oVar, this.l, this.f1, this.h);
        this.F4 = create68;
        this.G4 = DoubleCheck.provider(create68);
        YandexBannerLoaderImpl_Factory create69 = YandexBannerLoaderImpl_Factory.create(this.E4, this.x, this.l);
        this.H4 = create69;
        this.I4 = DoubleCheck.provider(create69);
        MyTargetBannerLoaderImpl_Factory create70 = MyTargetBannerLoaderImpl_Factory.create(this.E4, this.l, this.f58a2);
        this.J4 = create70;
        this.K4 = DoubleCheck.provider(create70);
        this.L4 = DoubleCheck.provider(BannerInfoFactoryImpl_Factory.create());
        CommercialBannersInteractorImpl_Factory create71 = CommercialBannersInteractorImpl_Factory.create(this.G4, this.I4, this.K4, this.l3, CommercialBannerTimeProviderImpl_Factory.create(), this.x, this.L4);
        this.M4 = create71;
        this.N4 = DoubleCheck.provider(create71);
        Provider<ClosedItemInteractor> provider51 = DoubleCheck.provider(ClosedItemModule_ProvideClosedItemInteractorFactory.create(this.p3));
        this.O4 = provider51;
        this.P4 = SerpItemSaturatorImpl_Factory.create(this.M0, this.q4, provider51);
        Factory createNullable7 = InstanceFactory.createNullable(searchMapState);
        this.Q4 = createNullable7;
        Provider<SerpCacheInteractor> provider52 = DoubleCheck.provider(SerpInteractorModule_ProvideCacheInteractorFactory.create(this.D4, this.P4, createNullable7));
        this.R4 = provider52;
        SerpInteractorImpl_Factory create72 = SerpInteractorImpl_Factory.create(this.u, this.v, this.N4, provider52, this.e4, this.B3, this.O, this.g0, this.x);
        this.S4 = create72;
        Provider<SerpInteractor> provider53 = DoubleCheck.provider(create72);
        this.T4 = provider53;
        this.U4 = DoubleCheck.provider(LoadMiddleware_Factory.create(this.i0, this.D4, provider53, this.B3, this.x, this.O3));
        this.V4 = DoubleCheck.provider(AdvertItemEventMiddleware_Factory.create(this.U0));
        Factory create73 = InstanceFactory.create(fragment);
        this.W4 = create73;
        LocationPermissionProviderImpl_Factory create74 = LocationPermissionProviderImpl_Factory.create(create73);
        this.X4 = create74;
        this.Y4 = DoubleCheck.provider(create74);
        v vVar = new v(searchMapDependencies);
        this.Z4 = vVar;
        Provider<DefaultLocationInteractor> provider54 = DoubleCheck.provider(FindLocationModule_ProvideDefaultLocationInteractorFactory.create(vVar));
        this.a5 = provider54;
        this.b5 = DoubleCheck.provider(FindLocationModule_ProvideDefaultLocationProviderFactory.create(provider54));
        FusedLocationInteractorImpl_Factory create75 = FusedLocationInteractorImpl_Factory.create(this.Z4);
        this.c5 = create75;
        Provider<FusedLocationInteractor> provider55 = DoubleCheck.provider(create75);
        this.d5 = provider55;
        GoogleServicesLocationProviderImpl_Factory create76 = GoogleServicesLocationProviderImpl_Factory.create(provider55);
        this.e5 = create76;
        Provider<GoogleServicesLocationProvider> provider56 = DoubleCheck.provider(create76);
        this.f5 = provider56;
        FindLocationPresenterImpl_Factory create77 = FindLocationPresenterImpl_Factory.create(this.b5, provider56);
        this.g5 = create77;
        Provider<FindLocationPresenter> provider57 = DoubleCheck.provider(create77);
        this.h5 = provider57;
        LocationMiddlewareImpl_Factory create78 = LocationMiddlewareImpl_Factory.create(this.Y4, provider57, this.j0);
        this.i5 = create78;
        this.j5 = DoubleCheck.provider(create78);
        SerpSnippetInteractor_Impl_Factory create79 = SerpSnippetInteractor_Impl_Factory.create(this.x, this.u);
        this.k5 = create79;
        Provider<SerpSnippetInteractor> provider58 = DoubleCheck.provider(create79);
        this.l5 = provider58;
        this.m5 = SubscriptionMiddleware_Factory.create(this.l, provider58, this.R4);
        this.n5 = DoubleCheck.provider(LoadReducer_Factory.create(this.B3, this.A));
        this.o5 = DoubleCheck.provider(SerpReducer_Factory.create(this.R3));
        h0 h0Var = new h0(searchMapDependencies);
        this.p5 = h0Var;
        ViewedPinsStorageImpl_Factory create80 = ViewedPinsStorageImpl_Factory.create(h0Var, this.h);
        this.q5 = create80;
        ViewedPinsInteractorImpl_Factory create81 = ViewedPinsInteractorImpl_Factory.create(create80);
        this.r5 = create81;
        this.s5 = DoubleCheck.provider(create81);
        this.t5 = InstanceFactory.create(avitoMapZoomLevel);
        FavouritePinsInteractorImpl_Factory create82 = FavouritePinsInteractorImpl_Factory.create(this.Q0);
        this.u5 = create82;
        Provider<FavoritePinsInteractor> provider59 = DoubleCheck.provider(create82);
        this.v5 = provider59;
        this.w5 = DoubleCheck.provider(MapReducer_Factory.create(this.s5, this.g0, this.t5, provider59));
        Provider<PinAdvertsReducer> provider60 = DoubleCheck.provider(PinAdvertsReducer_Factory.create());
        this.x5 = provider60;
        Provider<SubscribableStore<SearchMapState, ? super MapAction>> provider61 = DoubleCheck.provider(SearchMapModule_ProvideStoreFactory.create(this.Y3, this.W, this.U4, this.V4, this.j5, this.m5, this.n5, this.o5, this.w5, provider60, UiReducer_Factory.create(), SubscriptionReducer_Factory.create(), this.x, this.B3, this.Q4, this.X));
        this.y5 = provider61;
        this.z5 = DoubleCheck.provider(ViewBinder_Factory.create(provider61, this.e1, this.u3, this.S, this.x, this.k));
        this.A5 = SingleCheck.provider(this.u1);
        SetFactory build = SetFactory.builder(2, 0).addProvider(this.C0).addProvider(this.A5).build();
        this.B5 = build;
        RichSnippetStateProviderProxy_Factory create83 = RichSnippetStateProviderProxy_Factory.create(build);
        this.C5 = create83;
        this.D5 = SingleCheck.provider(create83);
        ErrorFormatterImpl_Factory create84 = ErrorFormatterImpl_Factory.create(this.e0);
        this.E5 = create84;
        this.F5 = DoubleCheck.provider(create84);
        this.G5 = DoubleCheck.provider(PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory.create());
        SnippetScrollDepthAnalyticsInteractorImpl_Factory create85 = SnippetScrollDepthAnalyticsInteractorImpl_Factory.create(this.l);
        this.H5 = create85;
        this.I5 = DoubleCheck.provider(create85);
    }

    public static SearchMapComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.search.map.di.SearchMapComponent
    public void inject(SearchMapFragment searchMapFragment) {
        SearchMapFragment_MembersInjector.injectLocationInteractor(searchMapFragment, this.k.get());
        SearchMapFragment_MembersInjector.injectDeepLinkIntentFactory(searchMapFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        SearchMapFragment_MembersInjector.injectIntentFactory(searchMapFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        SearchMapFragment_MembersInjector.injectSupplier(searchMapFragment, new FpsStateSupplier(new FpsMetricsSupplier.Impl((Observable) Preconditions.checkNotNullFromComponent(this.b.frameStream()), (FpsMetricsTracker) Preconditions.checkNotNullFromComponent(this.b.fpsMetricsTracker()), this.c, this.b.fpsTrackingThreshold(), (Features) Preconditions.checkNotNullFromComponent(this.a.features())), (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo())));
        SearchMapFragment_MembersInjector.injectImplicitIntentFactory(searchMapFragment, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
        SearchMapFragment_MembersInjector.injectNavigationMiddleware(searchMapFragment, this.W.get());
        SearchMapFragment_MembersInjector.injectViewFactory(searchMapFragment, this.U3.get());
        SearchMapFragment_MembersInjector.injectViewBinder(searchMapFragment, this.z5.get());
        SearchMapFragment_MembersInjector.injectAdvertXlStateProvider(searchMapFragment, this.p1.get());
        SearchMapFragment_MembersInjector.injectRichSnippetStateProvider(searchMapFragment, this.D5.get());
        SearchMapFragment_MembersInjector.injectInlineFiltersPresenter(searchMapFragment, this.K.get());
        SearchMapFragment_MembersInjector.injectSavedSearchesPresenter(searchMapFragment, this.R3.get());
        SearchMapFragment_MembersInjector.injectNotificationManagerProvider(searchMapFragment, (NotificationManagerProvider) Preconditions.checkNotNullFromComponent(this.a.notificationManagerProvider()));
        SearchMapFragment_MembersInjector.injectAsyncPhonePresenter(searchMapFragment, this.U.get());
        SearchMapFragment_MembersInjector.injectErrorFormatter(searchMapFragment, this.F5.get());
        SearchMapFragment_MembersInjector.injectPhoneNumberFormatter(searchMapFragment, this.G5.get());
        SearchMapFragment_MembersInjector.injectStore(searchMapFragment, this.y5.get());
        SearchMapFragment_MembersInjector.injectAnalyticsInteractor(searchMapFragment, this.q.get());
        SearchMapFragment_MembersInjector.injectCommercialBannersAnalyticsInteractor(searchMapFragment, new CommercialBannersAnalyticsInteractorImpl(this.d, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()), this.k3, (TreeStateIdGenerator) Preconditions.checkNotNullFromComponent(this.a.treeStateIdGenerator()), new CommercialBannerTimeProviderImpl()));
        SearchMapFragment_MembersInjector.injectSerpCacheInteractor(searchMapFragment, this.R4.get());
        SearchMapFragment_MembersInjector.injectFeatures(searchMapFragment, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        SearchMapFragment_MembersInjector.injectSearchMapTracker(searchMapFragment, this.H3.get());
        SearchMapFragment_MembersInjector.injectListItemVisibilityTracker(searchMapFragment, this.o3.get());
        SearchMapFragment_MembersInjector.injectJustDialSellerPhoneTestGroup(searchMapFragment, (AbTestGroup) Preconditions.checkNotNullFromComponent(this.a.justDialSellerPhoneTestGroup()));
        SearchMapFragment_MembersInjector.injectWitcherItemPresenter(searchMapFragment, this.Q2.get());
        SearchMapFragment_MembersInjector.injectFindLocationPresenter(searchMapFragment, this.h5.get());
        SearchMapFragment_MembersInjector.injectTasksRegistry(searchMapFragment, (ApplicationStartupTasksRegistry) Preconditions.checkNotNullFromComponent(this.a.startupTasksRegistry()));
        SearchMapFragment_MembersInjector.injectSnippetScrollDepthAnalyticsInteractor(searchMapFragment, this.I5.get());
        SearchMapFragment_MembersInjector.injectSnippetScrollDepthTracker(searchMapFragment, this.s3.get());
        SearchMapFragment_MembersInjector.injectBackNavigationTestGroup(searchMapFragment, (ManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.realtyNewBackNavigation()));
    }
}
