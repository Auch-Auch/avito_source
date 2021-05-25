package com.avito.android.di.component;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.TopLocationInteractor;
import com.avito.android.ab_tests.configs.OrangeAdBadgeTestGroup;
import com.avito.android.ab_tests.configs.PriceOnTopTestGroup;
import com.avito.android.ab_tests.configs.SellerInfoInRichSnippetTestGroup;
import com.avito.android.ab_tests.configs.SerpItemsPrefetchTestGroup;
import com.avito.android.ab_tests.groups.SerpSkeletonTestGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithControl2;
import com.avito.android.ab_tests.groups.ViewedItemsTabTestGroup;
import com.avito.android.ab_tests.models.AbTestGroup;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert.viewed.ViewedAdvertsEventInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsInteractorFactoryImpl_Factory;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.advert_core.messenger.AdvertMessengerInteractor;
import com.avito.android.advert_core.messenger.AdvertMessengerInteractorImpl;
import com.avito.android.advert_core.messenger.AdvertMessengerInteractorImpl_Factory;
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
import com.avito.android.async_phone.AsyncPhoneInteractor;
import com.avito.android.async_phone.AsyncPhoneInteractorImpl;
import com.avito.android.async_phone.AsyncPhoneInteractorImpl_Factory;
import com.avito.android.async_phone.AsyncPhonePresenter;
import com.avito.android.async_phone.AsyncPhonePresenterImpl;
import com.avito.android.async_phone.AsyncPhonePresenterImpl_Factory;
import com.avito.android.async_phone.AsyncPhoneTracker;
import com.avito.android.async_phone.AsyncPhoneTrackerImpl;
import com.avito.android.async_phone.AsyncPhoneTrackerImpl_Factory;
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
import com.avito.android.di.ViewedAdvertsModule_ProvideViewedAdvertsPresenterFactory;
import com.avito.android.di.ViewedAdvertsModule_ProvideViewedStatusResolverFactory;
import com.avito.android.di.component.SerpComponent;
import com.avito.android.di.module.AdvertItemModule_ProvideAdvertItemDoubleBlueprintFactory;
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
import com.avito.android.di.module.ScreenAnalyticsDependencies;
import com.avito.android.di.module.SerpAdapterModule_ProvideShortcutBannerItemPresenterFactory;
import com.avito.android.di.module.SerpInteractorModule_ProvideResourcesProvider$serp_core_releaseFactory;
import com.avito.android.di.module.SerpInteractorModule_ProvideSearchDeepLinkInteractor$serp_core_releaseFactory;
import com.avito.android.di.module.SerpInteractorModule_ProvideSearchParamsConverter$serp_core_releaseFactory;
import com.avito.android.di.module.SerpInteractorModule_ProvideSerpSnippetInteractor$serp_core_releaseFactory;
import com.avito.android.di.module.SerpInteractorModule_ProvideServiceInteractor$serp_core_releaseFactory;
import com.avito.android.di.module.SerpInteractorModule_ProvideSubscribeSearchInteractor$serp_core_releaseFactory;
import com.avito.android.di.module.SerpInteractorModule_ProvideSuggestParamsConverter$serp_core_releaseFactory;
import com.avito.android.di.module.SerpInteractorModule_ProvideWarningStateProvider$serp_core_releaseFactory;
import com.avito.android.di.module.SerpInteractorModule_ProviderPermanentWarningStateStorage$serp_core_releaseFactory;
import com.avito.android.di.module.SerpInteractorModule_ProviderWarningStateStorage$serp_core_releaseFactory;
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
import com.avito.android.di.module.SerpModule_ProvideAdapterPresenter$serp_releaseFactory;
import com.avito.android.di.module.SerpModule_ProvideDestroyableViewHolderBuilder$serp_releaseFactory;
import com.avito.android.di.module.SerpModule_ProvideItemBinder$serp_releaseFactory;
import com.avito.android.di.module.SerpModule_ProvideItemVisibilityTracker$serp_releaseFactory;
import com.avito.android.di.module.SerpModule_ProvideSearchContextWrapper$serp_releaseFactory;
import com.avito.android.di.module.SerpModule_ProvideSerpAnalyticsInteractor$serp_releaseFactory;
import com.avito.android.di.module.SerpModule_ProvideSerpTreeParent$serp_releaseFactory;
import com.avito.android.di.module.SerpModule_ProvideViewedItemsTabTestGroupFactory;
import com.avito.android.di.module.SerpModule_ProvidesInitialQuery$serp_releaseFactory;
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
import com.avito.android.home.HomeSerpHeaderBluePrint;
import com.avito.android.home.HomeSerpHeaderBluePrint_Factory;
import com.avito.android.home.appending_item.di.AppendingRetryModule;
import com.avito.android.home.appending_item.di.AppendingRetryModule_ProvideAppendingRetryItemBlueprintFactory;
import com.avito.android.home.appending_item.di.AppendingRetryModule_ProvideAppendingRetryItemPresenterFactory;
import com.avito.android.home.appending_item.loader.AppendingLoaderItemBlueprint;
import com.avito.android.home.appending_item.loader.AppendingLoaderItemPresenter;
import com.avito.android.home.appending_item.retry.AppendingRetryItemBlueprint;
import com.avito.android.home.appending_item.retry.AppendingRetryItemPresenter;
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
import com.avito.android.location.back_navigation.BackNavigationLocationInteractor;
import com.avito.android.location.di.LocationDependencies;
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
import com.avito.android.profile.ProfileInfoStorage;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.base.SafeRecyclerAdapter;
import com.avito.android.remote.AsyncPhoneApi;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.cart.CartApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.SearchParamsConverterImpl_Factory;
import com.avito.android.remote.model.SuggestParamsConverter;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.saved_searches.SavedSearchesPresenter;
import com.avito.android.saved_searches.SavedSearchesPresenterImpl;
import com.avito.android.saved_searches.SavedSearchesPresenterImpl_Factory;
import com.avito.android.scroll_tracker.SnippetScrollDepthTracker;
import com.avito.android.scroll_tracker.SnippetScrollDepthTrackerImpl_Factory;
import com.avito.android.search.SearchDeepLinkInteractor;
import com.avito.android.search.subscriptions.SearchSubscriptionConsumer;
import com.avito.android.search.subscriptions.SerpSearchSubscriptionInteractor;
import com.avito.android.search.subscriptions.SubscribeSearchInteractor;
import com.avito.android.serp.BannerInfoFactory;
import com.avito.android.serp.BannerInfoFactoryImpl_Factory;
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
import com.avito.android.serp.SerpArguments;
import com.avito.android.serp.SerpFragment;
import com.avito.android.serp.SerpFragment_MembersInjector;
import com.avito.android.serp.SerpInteractor;
import com.avito.android.serp.SerpInteractorImpl;
import com.avito.android.serp.SerpInteractorImpl_Factory;
import com.avito.android.serp.SerpItemProcessor;
import com.avito.android.serp.SerpPresenter;
import com.avito.android.serp.SerpPresenterImpl;
import com.avito.android.serp.SerpPresenterImpl_Factory;
import com.avito.android.serp.SerpPresenterState;
import com.avito.android.serp.SerpResourcesProvider;
import com.avito.android.serp.SerpSnippetInteractor;
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
import com.avito.android.serp.adapter.SerpAdvertConverter;
import com.avito.android.serp.adapter.SerpCommercialBannerConverter;
import com.avito.android.serp.adapter.SerpElementItemConverter;
import com.avito.android.serp.adapter.SerpItemAbViewConfig;
import com.avito.android.serp.adapter.SerpItemAbViewConfig_Factory;
import com.avito.android.serp.adapter.SerpItemAligner;
import com.avito.android.serp.adapter.SerpItemAlignerImpl;
import com.avito.android.serp.adapter.SerpItemAlignerImpl_Factory;
import com.avito.android.serp.adapter.SerpItemSaturatorImpl;
import com.avito.android.serp.adapter.SerpItemSaturatorImpl_Factory;
import com.avito.android.serp.adapter.SerpItemSizeAdjuster;
import com.avito.android.serp.adapter.SerpShortcutBannerWidthProvider;
import com.avito.android.serp.adapter.SerpShortcutBannerWidthProvider_Factory;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.ShortcutBannerBlueprint;
import com.avito.android.serp.adapter.ShortcutBannerBlueprint_Factory;
import com.avito.android.serp.adapter.ShortcutBannerConverter;
import com.avito.android.serp.adapter.ShortcutBannerItemPresenter;
import com.avito.android.serp.adapter.ShortcutBannerWidthProvider;
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
import com.avito.android.serp.adapter.empty_search.EmptySearchItemBlueprint;
import com.avito.android.serp.adapter.empty_search.EmptySearchItemBlueprint_Factory;
import com.avito.android.serp.adapter.empty_search.EmptySearchItemConverter;
import com.avito.android.serp.adapter.empty_search.EmptySearchItemPresenter;
import com.avito.android.serp.adapter.empty_search.EmptySearchItemPresenterImpl_Factory;
import com.avito.android.serp.adapter.item_sorter.SerpItemSorter;
import com.avito.android.serp.adapter.location_notification.LocationNotificationItemConverter;
import com.avito.android.serp.adapter.map_banner.MapBannerItemBlueprint;
import com.avito.android.serp.adapter.map_banner.MapBannerItemBlueprint_Factory;
import com.avito.android.serp.adapter.map_banner.MapBannerItemConverter;
import com.avito.android.serp.adapter.map_banner.MapBannerItemPresenter;
import com.avito.android.serp.adapter.map_banner.MapBannerItemPresenterImpl;
import com.avito.android.serp.adapter.map_banner.MapBannerItemPresenterImpl_Factory;
import com.avito.android.serp.adapter.onboarding.SerpBadgeResourceProvider;
import com.avito.android.serp.adapter.onboarding.SerpBadgeResourceProviderImpl;
import com.avito.android.serp.adapter.onboarding.SerpBadgeResourceProviderImpl_Factory;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandler;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandlerImpl;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandlerImpl_Factory;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandlerState;
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
import com.avito.android.serp.adapter.rich_snippets.job.AdvertRichJobItemBlueprint;
import com.avito.android.serp.adapter.rich_snippets.job.AdvertRichJobItemBlueprint_Factory;
import com.avito.android.serp.adapter.rich_snippets.job.AdvertRichJobItemPresenter;
import com.avito.android.serp.adapter.rich_snippets.job.AdvertRichJobItemPresenterImpl;
import com.avito.android.serp.adapter.rich_snippets.job.AdvertRichJobItemPresenterImpl_Factory;
import com.avito.android.serp.adapter.rich_snippets.job.AdvertVipRichJobItemBlueprint;
import com.avito.android.serp.adapter.rich_snippets.job.AdvertVipRichJobItemBlueprint_Factory;
import com.avito.android.serp.adapter.rich_snippets.job.AdvertXlRichJobItemBlueprint;
import com.avito.android.serp.adapter.rich_snippets.job.AdvertXlRichJobItemBlueprint_Factory;
import com.avito.android.serp.adapter.rich_snippets.job.AdvertXlRichJobItemPresenter;
import com.avito.android.serp.adapter.rich_snippets.job.AdvertXlRichJobItemPresenterImpl;
import com.avito.android.serp.adapter.rich_snippets.job.AdvertXlRichJobItemPresenterImpl_Factory;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichItemBlueprint;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichItemBlueprint_Factory;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichItemPresenter;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichItemPresenterImpl;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichItemPresenterImpl_Factory;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertVipRichItemBlueprint;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertVipRichItemBlueprint_Factory;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertXlRichItemBlueprint;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertXlRichItemBlueprint_Factory;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertXlRichItemPresenter;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertXlRichItemPresenterImpl;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertXlRichItemPresenterImpl_Factory;
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
import com.avito.android.serp.adapter.title.GroupTitleItemBlueprint;
import com.avito.android.serp.adapter.title.GroupTitleItemBlueprint_Factory;
import com.avito.android.serp.adapter.title.GroupTitleItemConverter;
import com.avito.android.serp.adapter.title.GroupTitleItemPresenter;
import com.avito.android.serp.adapter.title.GroupTitleItemPresenterImpl_Factory;
import com.avito.android.serp.adapter.vertical_main.VerticalFilterItemConverter;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterInteractor;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterInteractorImpl;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterInteractorImpl_Factory;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterPresenter;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterPresenterImpl;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterPresenterImpl_Factory;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterState;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalSearchFilterResourceProvider;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalSearchFilterResourceProviderImpl;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalSearchFilterResourceProviderImpl_Factory;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.VerticalSearchFilterItemPresenter;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.VerticalSearchFilterItemPresenterImpl;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.VerticalSearchFilterItemPresenterImpl_Factory;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.VerticalSearchFilterMultiSelectItemBlueprint;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.VerticalSearchFilterMultiSelectItemBlueprint_Factory;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.VerticalSearchFilterSelectItemBlueprint;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.VerticalSearchFilterSelectItemBlueprint_Factory;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.segmented.VerticalSearchFilterSegmentedItemBlueprint;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.segmented.VerticalSearchFilterSegmentedItemBlueprintImpl;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.segmented.VerticalSearchFilterSegmentedItemBlueprintImpl_Factory;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.segmented.VerticalSearchFilterSegmentedItemPresenter;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.segmented.VerticalSearchFilterSegmentedItemPresenterImpl;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.segmented.VerticalSearchFilterSegmentedItemPresenterImpl_Factory;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.di.VerticalFilterModule_ProvideAdapterPresenter$serp_core_releaseFactory;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.di.VerticalFilterModule_ProvideDestroyableViewHolderBuilder$serp_core_releaseFactory;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.di.VerticalFilterModule_ProvideItemBinderFactory;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.di.VerticalFilterModule_ProvideSafeRecyclerAdapter$serp_core_releaseFactory;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.item.VerticalFilterItemBlueprint;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.item.VerticalFilterItemBlueprint_Factory;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.item.VerticalFilterItemPresenter;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.item.VerticalFilterItemPresenterImpl;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.item.VerticalFilterItemPresenterImpl_Factory;
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
import com.avito.android.serp.analytics.SerpAnalyticsInteractor;
import com.avito.android.serp.analytics.SerpTracker;
import com.avito.android.serp.analytics.SerpTrackerImpl;
import com.avito.android.serp.analytics.SerpTrackerImpl_Factory;
import com.avito.android.serp.dfp_mobile_ads.DfpMobileAdsWrapper;
import com.avito.android.serp.diff_calculator.DiffCalculator;
import com.avito.android.serp.diff_calculator.DiffCalculator_Impl_Factory;
import com.avito.android.serp.warning.PermanentWarningStateStorage;
import com.avito.android.serp.warning.WarningStateProvider;
import com.avito.android.serp.warning.WarningStateProviderState;
import com.avito.android.server_time.TimeSource;
import com.avito.android.subscriptions.remote.SubscriptionsApi;
import com.avito.android.ui.ActivityInteractor;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Kundle;
import com.avito.android.util.PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.SearchContextWrapper;
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
import ru.avito.messenger.api.AvitoMessengerApi;
public final class DaggerSerpComponent implements SerpComponent {
    public Provider<CommercialBannersAnalyticsInteractorImpl> A;
    public Provider<Preferences> A0;
    public Provider<Kundle> A1;
    public Provider<MyTargetContentSingleBlueprint> A2;
    public Provider<WitcherItemPresenter> A3;
    public Provider<AvitoMessengerApi> A4;
    public Provider<Set<NetworkInfoChangeListener>> A5;
    public Provider<BannerInfoFactory> B;
    public Provider<PermanentWarningStateStorage> B0;
    public Provider<AdvertSellerConverterImpl> B1;
    public Provider<MyTargetContentBlueprint> B2;
    public Provider<ItemBinder> B3;
    public Provider<AdvertMessengerInteractorImpl> B4;
    public Provider<NetworkInfoBroadcastReceiver> B5;
    public Provider<CommercialBannersInteractorImpl> C;
    public Provider<WarningStateProviderState> C0;
    public Provider<AdvertSellerConverter> C1;
    public Provider<MyTargetAppInstallPresenterImpl> C2;
    public Provider<ViewedAdvertsPresenter> C3;
    public Provider<AdvertMessengerInteractor> C4;
    public Provider<InlineFilterDialogFactoryImpl> C5;
    public Provider<CommercialBannersInteractor> D;
    public Provider<WarningStateProvider> D0;
    public Provider<SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup>> D1;
    public Provider<MyTargetAppInstallPresenter> D2;
    public Provider<FavoriteAdvertsResourceProvider> D3;
    public Provider<SerpSpanProvider> D4;
    public Provider<InlineFilterDialogFactory> D5;
    public Provider<Resources> E;
    public Provider<NotificationManagerProvider> E0;
    public Provider<AdvertRichItemPresenterImpl> E1;
    public Provider<MyTargetAppInstallSingleBlueprint> E2;
    public Provider<FavoriteAdvertsPresenter> E3;
    public Provider<String> E4;
    public Provider<Fragment> E5;
    public Provider<AdvertSpanCountProvider> F;
    public Provider<ScreenTrackerFactory> F0;
    public Provider<AdvertRichItemPresenter> F1;
    public Provider<MyTargetAppInstallBlueprint> F2;
    public Provider<SimpleAdapterPresenter> F3;
    public Provider<ConnectionManager> F4;
    public Provider<ViewModelStoreOwner> F5;
    public Provider<AdvertSpanCountProvider> G;
    public Provider<TimerFactory> G0;
    public Provider<RecyclerView.RecycledViewPool> G1;
    public Provider<SerpShortcutBannerWidthProvider> G2;
    public Provider<DeviceMetrics> G3;
    public Provider<Application> G4;
    public Provider<CartApi> G5;
    public Provider<SerpAdvertConverter> H;
    public Provider<SerpTrackerImpl> H0;
    public Provider<SellerInfoParamsFactoryImpl> H1;
    public Provider<ShortcutBannerWidthProvider> H2;
    public Provider<WitcherItemBlueprint> H3;
    public Provider<ConnectivityManager> H4;
    public Provider<CartFabRepositoryImpl> H5;
    public Provider<SerpAdvertXlConverter> I;
    public Provider<SerpTracker> I0;
    public Provider<SellerInfoParamsFactory> I1;
    public Provider<Activity> I2;
    public Provider<VerticalFilterInteractorImpl> I3;
    public Provider<ConnectionClassManager> I4;
    public Provider<CartFabRepository> I5;
    public Provider<AdResourceProvider> J;
    public Provider<SerpSnippetInteractor> J0;
    public Provider<AdvertVipRichItemBlueprint> J1;
    public Provider<ShortcutBannerItemPresenter> J2;
    public Provider<VerticalFilterInteractor> J3;
    public Provider<ConnectionQualityInteractor> J4;
    public Provider<CartFabPreferencesImpl> J5;
    public Provider<RandomKeyProvider> K;
    public Provider<SearchParamsConverter> K0;
    public Provider<RichSnippetsResourceProviderImpl> K1;
    public Provider<ShortcutBannerBlueprint> K2;
    public Provider<SingleManuallyExposedAbTestGroup<SimpleTestGroup>> K3;
    public Provider<ConnectionQualitySubscriber> K4;
    public Provider<CartFabPreferences> K5;
    public Provider<SerpCommercialBannerConverter> L;
    public Provider<InlineFiltersChangesParamsConverter> L0;
    public Provider<RichSnippetsResourceProvider> L1;
    public Provider<SerpWarningItemPresenterImpl> L2;
    public Provider<InlineFiltersDialogItemConverterImpl> L3;
    public Provider<FavoriteAdvertsPresenter> L4;
    public Provider<SearchContextWrapper> L5;
    public Provider<DeepLinkFactory> M;
    public Provider<InlineFiltersInteractorImpl> M0;
    public Provider<AdvertXlRichItemPresenterImpl> M1;
    public Provider<SerpWarningItemPresenter> M2;
    public Provider<InlineFiltersDialogItemConverter> M3;
    public Provider<ViewedAdvertsPresenter> M4;
    public Provider<Optional<SearchContextWrapper>> M5;
    public Provider<ShortcutBannerConverter> N;
    public Provider<InlineFiltersInteractor> N0;
    public Provider<AdvertXlRichItemPresenter> N1;
    public Provider<SerpWarningItemBlueprint> N2;
    public Provider<VerticalSearchFilterResourceProviderImpl> N3;
    public Provider<ClosedItemEventInteractor> N4;
    public Provider<CartFabViewModelFactory> N5;
    public Provider<SerpWarningConverter> O;
    public Provider<Boolean> O0;
    public Provider<AdvertXlRichItemBlueprint> O1;
    public Provider<Relay<Pair<SnippetItem, Integer>>> O2;
    public Provider<VerticalSearchFilterResourceProvider> O3;
    public Provider<ClosedItemPresenter> O4;
    public Provider<CartFabViewModel> O5;
    public Provider<SnippetConverter> P;
    public Provider<Kundle> P0;
    public Provider<AdvertRichJobItemPresenterImpl> P1;
    public Provider<Relay<Pair<SnippetItem, Integer>>> P2;
    public Provider<VerticalFilterState> P3;
    public Provider<ClosedItemInteractor> P4;
    public Provider<CartQuantityChangesHandler> P5;
    public Provider<EmptySearchItemConverter> Q;
    public Provider<SerpInteractorImpl> Q0;
    public Provider<AdvertRichJobItemPresenter> Q1;
    public Provider<Relay<Pair<SnippetItem, Boolean>>> Q2;
    public Provider<VerticalFilterPresenterImpl> Q3;
    public Provider<RichSnippetStateProvider> Q4;
    public Provider<GroupTitleItemConverter> R;
    public Provider<SerpInteractor> R0;
    public Provider<AdvertRichJobItemBlueprint> R1;
    public Provider<SnippetPresenter.Impl> R2;
    public Provider<VerticalFilterPresenter> R3;
    public Provider<Set<RichSnippetStateProvider>> R4;
    public Provider<EmptyPlaceholderItemConverter> S;
    public Provider<SubscribeSearchInteractor> S0;
    public Provider<AdvertVipRichJobItemBlueprint> S1;
    public Provider<SnippetPresenter> S2;
    public Provider<VerticalFilterItemPresenterImpl> S3;
    public Provider<RichSnippetStateProviderProxy> S4;
    public Provider<HeaderElementConverter> T;
    public Provider<SerpPresenter> T0;
    public Provider<AdvertXlRichJobItemPresenterImpl> T1;
    public Provider<SnippetBlueprint> T2;
    public Provider<VerticalFilterItemPresenter> T3;
    public Provider<RichSnippetStateProvider> T4;
    public Provider<FavoritesSyncDao> U;
    public Provider<SerpBadgeResourceProviderImpl> U0;
    public Provider<AdvertXlRichJobItemPresenter> U1;
    public Provider<EmptyAdStubItemPresenter> U2;
    public Provider<VerticalSearchFilterItemPresenterImpl> U3;
    public Provider<SimpleClickStreamLinkHandler> U4;
    public Provider<FavoriteAdvertsUploadInteractor> V;
    public Provider<SerpBadgeResourceProvider> V0;
    public Provider<AdvertXlRichJobItemBlueprint> V1;
    public Provider<EmptyAdStubItemBlueprint> V2;
    public Provider<VerticalSearchFilterItemPresenter> V3;
    public Provider<ClickStreamLinkHandler> V4;
    public Provider<FavoriteAdvertsEventInteractor> W;
    public Provider<SerpOnboardingHandlerState> W0;
    public Provider<AdvertRichItemBlueprint> W1;
    public Provider<EmptySearchItemPresenter> W2;
    public Provider<VerticalSearchFilterSelectItemBlueprint> W3;
    public Provider<AbTestGroup<SimpleTestGroupWithControl2>> W4;
    public Provider<AccountStateProvider> X;
    public Provider<SerpOnboardingHandlerImpl> X0;
    public Provider<ExposedAbTestGroup<OrangeAdBadgeTestGroup>> X1;
    public Provider<EmptySearchItemBlueprint> X2;
    public Provider<ItemBlueprint<?, ?>> X3;
    public Provider<ShortcutNavigationItemConverter> X4;
    public Provider<FavoriteAdvertsAnalyticsInteractorImpl> Y;
    public Provider<SerpOnboardingHandler> Y0;
    public Provider<YandexContentItemPresenterImpl> Y1;
    public Provider<SingleTextPresenter> Y2;
    public Provider<VerticalSearchFilterMultiSelectItemBlueprint> Y3;
    public Provider<Kundle> Y4;
    public Provider<FavoriteAdvertsInteractorImpl> Z;
    public Provider<AdvertGridItemPresenter> Z0;
    public Provider<YandexContentItemPresenter> Z1;
    public Provider<HomeSerpHeaderBluePrint> Z2;
    public Provider<ItemBlueprint<?, ?>> Z3;
    public Provider<InlineFiltersPresenterImpl> Z4;
    public final Resources a;
    public Provider<FavoriteStatusResolver> a0;
    public Provider<TimeSource> a1;

    /* renamed from: a2  reason: collision with root package name */
    public Provider<YandexContentSingleGridBlueprint> f55a2;
    public Provider<NotLoadAdStubGridBlueprint> a3;
    public Provider<Set<ItemBlueprint<?, ?>>> a4;
    public Provider<InlineFiltersPresenter> a5;
    public final ScreenAnalyticsDependencies b;
    public Provider<ViewedAdvertsDao> b0;
    public Provider<Locale> b1;
    public Provider<YandexContentRichBlueprint> b2;
    public Provider<AppendingLoaderItemPresenter> b3;
    public Provider<VerticalSearchFilterSegmentedItemPresenterImpl> b4;
    public Provider<SerpItemSaturatorImpl> b5;
    public final Screen c;
    public Provider<ViewedAdvertsEventInteractor> c0;
    public Provider<ExposedAbTestGroup<PriceOnTopTestGroup>> c1;
    public Provider<YandexAppInstallItemPresenterImpl> c2;
    public Provider<AppendingLoaderItemBlueprint> c3;
    public Provider<VerticalSearchFilterSegmentedItemPresenter> c4;
    public Provider<BannerViewFilter> c5;
    public final SerpDependencies d;
    public Provider<ViewedAdvertsInteractor> d0;
    public Provider<SerpItemsPrefetchTestGroup> d1;
    public Provider<YandexAppInstallItemPresenter> d2;
    public Provider<AppendingRetryItemPresenter> d3;
    public Provider<VerticalSearchFilterSegmentedItemBlueprintImpl> d4;
    public Provider<Bundle> d5;
    public final WarningStateProviderState e;
    public Provider<ViewedStatusResolver> e0;
    public Provider<SerpItemAbViewConfig> e1;
    public Provider<YandexAppInstallRichBlueprint> e2;
    public Provider<AppendingRetryItemBlueprint> e3;
    public Provider<VerticalSearchFilterSegmentedItemBlueprint> e4;
    public Provider<ItemVisibilityTracker> e5;
    public Provider<DfpDebugPresenter> f = DoubleCheck.provider(DfpDebugPresenterImpl_Factory.create());
    public Provider<WitcherElementConverter> f0;
    public Provider<ConnectivityProvider> f1;
    public Provider<YandexContentDoubleGridBlueprint> f2;
    public Provider<GroupTitleItemPresenter> f3;
    public Provider<ItemBinder> f4;
    public Provider<DiffCalculator> f5;
    public Provider<SerpArguments> g;
    public Provider<LocationNotificationItemConverter> g0;
    public Provider<AdvertItemGridBlueprint> g1;
    public Provider<YandexAppInstallSingleItemBlueprint> g2;
    public Provider<GroupTitleItemBlueprint> g3;
    public Provider<AdapterPresenter> g4;
    public Provider<Kundle> g5;
    public Provider<SearchApi> h;
    public Provider<SellerElementConverter> h0;
    public Provider<AdvertListItemPresenter> h1;
    public Provider<YandexAppInstallDoubleItemBlueprint> h2;
    public Provider<EmptyPlaceholderItemPresenterImpl> h3;
    public Provider<DestroyableViewHolderBuilder> h4;
    public Provider<SavedSearchesPresenterImpl> h5;
    public Provider<SuggestParamsConverter> i;
    public Provider<ReportBannerConverter> i0;
    public Provider<AdvertItemListBlueprint> i1;
    public Provider<AdfoxImageItemPresenterImpl> i2;
    public Provider<EmptyPlaceholderItemPresenter> i3;
    public Provider<SafeRecyclerAdapter> i4;
    public Provider<SavedSearchesPresenter> i5;
    public Provider<TypedErrorThrowableConverter> j;
    public Provider<PromoCardConverter> j0;
    public Provider<AdvertItemDoubleBlueprint> j1;
    public Provider<AdfoxImageItemPresenter> j2;
    public Provider<EmptyPlaceholderItemBlueprint> j3;
    public Provider<VerticalFilterItemBlueprint> j4;
    public Provider<SkeletonGenerator> j5;
    public Provider<Context> k;
    public Provider<MapBannerItemConverter> k0;
    public Provider<DateTimeFormatterResourceProviderImpl> k1;
    public Provider<AdfoxSingleGridBlueprint> k2;
    public Provider<YandexContentListBlueprint> k3;
    public Provider<PromoCardItemPresenter> k4;
    public Provider<SerpSkeletonTestGroup> k5;
    public Provider<Analytics> l;
    public Provider<VerticalFilterItemConverter> l0;
    public Provider<DateTimeFormatter> l1;
    public Provider<AdfoxSingleListBlueprint> l2;
    public Provider<YandexAppInstallListItemBlueprint> l3;
    public Provider<PromoCardBlueprint> l4;
    public Provider<SnippetScrollDepthTracker> l5;
    public Provider<BuildInfo> m;
    public Provider<SerpElementItemConverter> m0;
    public Provider<AdvertXlDimensionsProviderImpl> m1;
    public Provider<DfpUnifiedPresenterImpl> m2;
    public Provider<DfpUnifiedListBlueprint> m3;
    public Provider<MapBannerItemPresenterImpl> m4;
    public Provider<SnippetScrollDepthAnalyticsInteractorImpl> m5;
    public Provider<Features> n;
    public Provider<SerpItemSorter> n0;
    public Provider<AdvertXlDimensionsProvider> n1;
    public Provider<DfpUnifiedPresenter> n2;
    public Provider<DfpContentListBlueprint> n3;
    public Provider<MapBannerItemPresenter> n4;
    public Provider<SnippetScrollDepthAnalyticsInteractor> n5;
    public Provider<DfpBannerLoaderImpl> o;
    public Provider<SerpItemSizeAdjuster> o0;
    public Provider<AsyncPhoneApi> o1;
    public Provider<DfpUnifiedDoubleBlueprint> o2;
    public Provider<DfpAppInstallListBlueprint> o3;
    public Provider<MapBannerItemBlueprint> o4;
    public Provider<SerpPresenterState> o5;
    public Provider<DfpBannerLoader> p;
    public Provider<SerpItemProcessor> p0;
    public Provider<AsyncPhoneInteractorImpl> p1;
    public Provider<DfpUnifiedSingleGridBlueprint> p2;
    public Provider<MyTargetContentListBlueprint> p3;
    public Provider<SkeletonPresenter> p4;
    public Provider<SavedLocationStorage> p5;
    public Provider<SchedulersFactory3> q;
    public Provider<SpannedGridPositionProvider> q0;
    public Provider<AsyncPhoneInteractor> q1;
    public Provider<DfpAppInstallPresenterImpl> q2;
    public Provider<MyTargetAppInstallListBlueprint> q3;
    public Provider<AdvertItemGridSkeletonBlueprint> q4;
    public Provider<LocationApi> q5;
    public Provider<YandexBannerLoaderImpl> r;
    public Provider<SerpItemAlignerImpl> r0;
    public Provider<Screen> r1;
    public Provider<DfpAppInstallPresenter> r2;
    public Provider<NotLoadAdStubListBlueprint> r3;
    public Provider<ItemBlueprint<?, ?>> r4;
    public Provider<TopLocationInteractor> r5;
    public Provider<YandexBannerLoader> s;
    public Provider<SerpItemAligner> s0;
    public Provider<AsyncPhoneTrackerImpl> s1;
    public Provider<DfpAppInstallDoubleBlueprint> s2;
    public Provider<NotLoadAdRichStubBlueprint> s3;
    public Provider<Set<ItemBlueprint<?, ?>>> s4;
    public Provider<BackNavigationLocationInteractor> s5;
    public Provider<MyTargetImageBgProvider> t;
    public Provider<SerpResourcesProvider> t0;
    public Provider<AsyncPhoneTracker> t1;
    public Provider<DfpAppInstallSingleBlueprint> t2;
    public Provider<WitcherResourceProviderImpl> t3;
    public Provider<ItemBinder> t4;
    public Provider<SavedLocationInteractorImpl> t5;
    public Provider<MyTargetBannerLoaderImpl> u;
    public Provider<ProfileInfoStorage> u0;
    public Provider<AsyncPhonePresenterImpl> u1;
    public Provider<DfpContentPresenterImpl> u2;
    public Provider<WitcherResourceProvider> u3;
    public Provider<AdapterPresenter> u4;
    public Provider<SavedLocationInteractor> u5;
    public Provider<MyTargetBannerLoader> v;
    public Provider<SearchSubscriptionDao> v0;
    public Provider<AsyncPhonePresenter> v1;
    public Provider<DfpContentPresenter> v2;
    public Provider<Kundle> v3;
    public Provider<Bundle> v4;
    public Provider<SerpPresenterImpl> v5;
    public Provider<BannerPageSource> w;
    public Provider<SubscriptionsApi> w0;
    public Provider<Kundle> w1;
    public Provider<DfpContentSingleGridBlueprint> w2;
    public Provider<WitcherAnalyticsInteractorImpl> w3;
    public Provider<FloatingViewsPresenterImpl> w4;
    public Provider<SpanLookup> w5;
    public Provider<TreeStateIdGenerator> x;
    public Provider<SearchSubscriptionConsumer> x0;
    public Provider<AdvertXlItemPresenterImpl> x1;
    public Provider<DfpContentDoubleGridBlueprint> x2;
    public Provider<WitcherAnalyticsInteractor> x3;
    public Provider<PersistableFloatingViewsPresenter> x4;
    public Provider<GridLayoutManager.SpanSizeLookup> x5;
    public Provider<SerpAnalyticsInteractor> y;
    public Provider<SerpSearchSubscriptionInteractor> y0;
    public Provider<AdvertXlItemPresenter> y1;
    public Provider<MyTargetContentPresenterImpl> y2;
    public Provider<SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup>> y3;
    public Provider<ErrorFormatterImpl> y4;
    public Provider<DestroyableViewHolderBuilder> y5;
    public Provider<TreeClickStreamParent> z;
    public Provider<SearchDeepLinkInteractor> z0;
    public Provider<AdvertXlItemBlueprint> z1;
    public Provider<MyTargetContentPresenter> z2;
    public Provider<WitcherItemPresenterImpl> z3;
    public Provider<ErrorFormatter> z4;
    public Provider<NetworkInfoChangeListener> z5;

    public static class a0 implements Provider<ExposedAbTestGroup<PriceOnTopTestGroup>> {
        public final SerpDependencies a;

        public a0(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ExposedAbTestGroup<PriceOnTopTestGroup> get() {
            return (ExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.priceOnTop());
        }
    }

    public static final class b implements SerpComponent.Builder {
        public Kundle A;
        public Kundle B;
        public Bundle C;
        public VerticalFilterState D;
        public BannerPageSource E;
        public Boolean F;
        public Kundle G;
        public SerpOnboardingHandlerState H;
        public SerpDependencies a;
        public ScreenAnalyticsDependencies b;
        public Screen c;
        public LocationDependencies d;
        public Resources e;
        public SerpArguments f;
        public Kundle g;
        public Kundle h;
        public Kundle i;
        public RecyclerView.RecycledViewPool j;
        public SerpPresenterState k;
        public Kundle l;
        public Bundle m;
        public WarningStateProviderState n;
        public FragmentManager o;
        public Boolean p;
        public Relay<Pair<SnippetItem, Integer>> q;
        public Relay<Pair<SnippetItem, Integer>> r;
        public Relay<Pair<SnippetItem, Boolean>> s;
        public Activity t;
        public Fragment u;
        public ActivityInteractor v;
        public SearchParams w;
        public Area x;
        public Kundle y;
        public String z;

        public b(a aVar) {
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder bannerPageSource(BannerPageSource bannerPageSource) {
            this.E = (BannerPageSource) Preconditions.checkNotNull(bannerPageSource);
            return this;
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent build() {
            Preconditions.checkBuilderRequirement(this.a, SerpDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, ScreenAnalyticsDependencies.class);
            Preconditions.checkBuilderRequirement(this.c, Screen.class);
            Preconditions.checkBuilderRequirement(this.d, LocationDependencies.class);
            Preconditions.checkBuilderRequirement(this.e, Resources.class);
            Preconditions.checkBuilderRequirement(this.f, SerpArguments.class);
            Preconditions.checkBuilderRequirement(this.j, RecyclerView.RecycledViewPool.class);
            Preconditions.checkBuilderRequirement(this.o, FragmentManager.class);
            Preconditions.checkBuilderRequirement(this.p, Boolean.class);
            Preconditions.checkBuilderRequirement(this.q, Relay.class);
            Preconditions.checkBuilderRequirement(this.r, Relay.class);
            Preconditions.checkBuilderRequirement(this.s, Relay.class);
            Preconditions.checkBuilderRequirement(this.t, Activity.class);
            Preconditions.checkBuilderRequirement(this.u, Fragment.class);
            Preconditions.checkBuilderRequirement(this.v, ActivityInteractor.class);
            Preconditions.checkBuilderRequirement(this.E, BannerPageSource.class);
            Preconditions.checkBuilderRequirement(this.F, Boolean.class);
            return new DaggerSerpComponent(new AppendingLoaderModule(), new ConnectionQualityInteractorModule(), new AppendingRetryModule(), this.a, this.d, this.b, this.c, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.C, this.D, this.E, this.F, this.G, this.H, null);
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder floatingViewsPresenterState(Bundle bundle) {
            this.m = bundle;
            return this;
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder fragmentManager(FragmentManager fragmentManager) {
            this.o = (FragmentManager) Preconditions.checkNotNull(fragmentManager);
            return this;
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder interactorState(Kundle kundle) {
            this.l = kundle;
            return this;
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder locationDependencies(LocationDependencies locationDependencies) {
            this.d = (LocationDependencies) Preconditions.checkNotNull(locationDependencies);
            return this;
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder presenterState(SerpPresenterState serpPresenterState) {
            this.k = serpPresenterState;
            return this;
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder resources(Resources resources) {
            this.e = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder screen(Screen screen) {
            this.c = (Screen) Preconditions.checkNotNull(screen);
            return this;
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder screenAnalyticsDependencies(ScreenAnalyticsDependencies screenAnalyticsDependencies) {
            this.b = (ScreenAnalyticsDependencies) Preconditions.checkNotNull(screenAnalyticsDependencies);
            return this;
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder serpArguments(SerpArguments serpArguments) {
            this.f = (SerpArguments) Preconditions.checkNotNull(serpArguments);
            return this;
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder serpDependencies(SerpDependencies serpDependencies) {
            this.a = (SerpDependencies) Preconditions.checkNotNull(serpDependencies);
            return this;
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder showJobNearbyBanner(boolean z2) {
            this.p = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z2));
            return this;
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder snippetClick(Relay relay) {
            this.q = (Relay) Preconditions.checkNotNull(relay);
            return this;
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder snippetClose(Relay relay) {
            this.r = (Relay) Preconditions.checkNotNull(relay);
            return this;
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder snippetVisibility(Relay relay) {
            this.s = (Relay) Preconditions.checkNotNull(relay);
            return this;
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder warningStates(WarningStateProviderState warningStateProviderState) {
            this.n = warningStateProviderState;
            return this;
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder withActivity(Activity activity) {
            this.t = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder withActivityInteractor(ActivityInteractor activityInteractor) {
            this.v = (ActivityInteractor) Preconditions.checkNotNull(activityInteractor);
            return this;
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder withAdvertXlState(Kundle kundle) {
            this.g = kundle;
            return this;
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder withBubblePresenterState(Kundle kundle) {
            this.B = null;
            return this;
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder withFragment(Fragment fragment) {
            this.u = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder withInlineFiltersState(Kundle kundle) {
            this.y = kundle;
            return this;
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder withInteractorState(Kundle kundle) {
            this.A = null;
            return this;
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder withIsFirstStart(boolean z2) {
            this.F = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z2));
            return this;
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder withItemVisibilityTrackerState(Bundle bundle) {
            this.C = bundle;
            return this;
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder withMapSerpState(String str) {
            this.z = null;
            return this;
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder withRichGalleryState(Kundle kundle) {
            this.h = kundle;
            return this;
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder withRichSnippetRecycledViewPool(RecyclerView.RecycledViewPool recycledViewPool) {
            this.j = (RecyclerView.RecycledViewPool) Preconditions.checkNotNull(recycledViewPool);
            return this;
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder withSavedSearchState(Kundle kundle) {
            this.G = kundle;
            return this;
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder withSearchArea(Area area) {
            this.x = null;
            return this;
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder withSearchParams(SearchParams searchParams) {
            this.w = searchParams;
            return this;
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder withSerpOnboardingHandlerState(SerpOnboardingHandlerState serpOnboardingHandlerState) {
            this.H = serpOnboardingHandlerState;
            return this;
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder withVerticalFilterState(VerticalFilterState verticalFilterState) {
            this.D = verticalFilterState;
            return this;
        }

        @Override // com.avito.android.di.component.SerpComponent.Builder
        public SerpComponent.Builder withWitcherSavedState(Kundle kundle) {
            this.i = kundle;
            return this;
        }
    }

    public static class b0 implements Provider<ProfileInfoStorage> {
        public final SerpDependencies a;

        public b0(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProfileInfoStorage get() {
            return (ProfileInfoStorage) Preconditions.checkNotNullFromComponent(this.a.profileInfoStorage());
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

    public static class c0 implements Provider<RandomKeyProvider> {
        public final SerpDependencies a;

        public c0(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public RandomKeyProvider get() {
            return (RandomKeyProvider) Preconditions.checkNotNullFromComponent(this.a.randomKeyProvider());
        }
    }

    public static class d implements Provider<AccountStateProvider> {
        public final SerpDependencies a;

        public d(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class d0 implements Provider<SchedulersFactory3> {
        public final SerpDependencies a;

        public d0(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class e implements Provider<Analytics> {
        public final SerpDependencies a;

        public e(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class e0 implements Provider<SearchApi> {
        public final SerpDependencies a;

        public e0(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SearchApi get() {
            return (SearchApi) Preconditions.checkNotNullFromComponent(this.a.searchApi());
        }
    }

    public static class f implements Provider<Application> {
        public final SerpDependencies a;

        public f(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Application get() {
            return (Application) Preconditions.checkNotNullFromComponent(this.a.application());
        }
    }

    public static class f0 implements Provider<SearchSubscriptionConsumer> {
        public final SerpDependencies a;

        public f0(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SearchSubscriptionConsumer get() {
            return (SearchSubscriptionConsumer) Preconditions.checkNotNullFromComponent(this.a.searchSubscriptionConsumer());
        }
    }

    public static class g implements Provider<AsyncPhoneApi> {
        public final SerpDependencies a;

        public g(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AsyncPhoneApi get() {
            return (AsyncPhoneApi) Preconditions.checkNotNullFromComponent(this.a.asyncPhoneApi());
        }
    }

    public static class g0 implements Provider<SearchSubscriptionDao> {
        public final SerpDependencies a;

        public g0(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SearchSubscriptionDao get() {
            return (SearchSubscriptionDao) Preconditions.checkNotNullFromComponent(this.a.searchSubscriptionDao());
        }
    }

    public static class h implements Provider<SingleManuallyExposedAbTestGroup<SimpleTestGroup>> {
        public final SerpDependencies a;

        public h(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SingleManuallyExposedAbTestGroup<SimpleTestGroup> get() {
            return (SingleManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.autoGenerationsFilterWithPhotosTestGroup());
        }
    }

    public static class h0 implements Provider<SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup>> {
        public final SerpDependencies a;

        public h0(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup> get() {
            return (SingleManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.sellerInfoInRichSnippet());
        }
    }

    public static class i implements Provider<AvitoMessengerApi> {
        public final SerpDependencies a;

        public i(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AvitoMessengerApi get() {
            return (AvitoMessengerApi) Preconditions.checkNotNullFromComponent(this.a.avitoMessengerApi());
        }
    }

    public static class i0 implements Provider<SerpSkeletonTestGroup> {
        public final SerpDependencies a;

        public i0(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SerpSkeletonTestGroup get() {
            return (SerpSkeletonTestGroup) Preconditions.checkNotNullFromComponent(this.a.serpSkeletonTestGroup());
        }
    }

    public static class j implements Provider<BuildInfo> {
        public final SerpDependencies a;

        public j(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BuildInfo get() {
            return (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo());
        }
    }

    public static class j0 implements Provider<SubscriptionsApi> {
        public final SerpDependencies a;

        public j0(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SubscriptionsApi get() {
            return (SubscriptionsApi) Preconditions.checkNotNullFromComponent(this.a.subscriptionsApi());
        }
    }

    public static class k implements Provider<CartApi> {
        public final SerpDependencies a;

        public k(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CartApi get() {
            return (CartApi) Preconditions.checkNotNullFromComponent(this.a.cartApi());
        }
    }

    public static class k0 implements Provider<TimeSource> {
        public final SerpDependencies a;

        public k0(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public static class l implements Provider<ConnectivityProvider> {
        public final SerpDependencies a;

        public l(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ConnectivityProvider get() {
            return (ConnectivityProvider) Preconditions.checkNotNullFromComponent(this.a.connectivityProvider());
        }
    }

    public static class l0 implements Provider<TreeStateIdGenerator> {
        public final SerpDependencies a;

        public l0(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TreeStateIdGenerator get() {
            return (TreeStateIdGenerator) Preconditions.checkNotNullFromComponent(this.a.treeStateIdGenerator());
        }
    }

    public static class m implements Provider<Context> {
        public final SerpDependencies a;

        public m(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public static class m0 implements Provider<TypedErrorThrowableConverter> {
        public final SerpDependencies a;

        public m0(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public static class n implements Provider<DeepLinkFactory> {
        public final SerpDependencies a;

        public n(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeepLinkFactory get() {
            return (DeepLinkFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkFactory());
        }
    }

    public static class n0 implements Provider<ViewedAdvertsDao> {
        public final SerpDependencies a;

        public n0(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ViewedAdvertsDao get() {
            return (ViewedAdvertsDao) Preconditions.checkNotNullFromComponent(this.a.viewedAdvertsDao());
        }
    }

    public static class o implements Provider<DeviceMetrics> {
        public final SerpDependencies a;

        public o(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeviceMetrics get() {
            return (DeviceMetrics) Preconditions.checkNotNullFromComponent(this.a.deviceMetrics());
        }
    }

    public static class o0 implements Provider<ViewedAdvertsEventInteractor> {
        public final SerpDependencies a;

        public o0(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ViewedAdvertsEventInteractor get() {
            return (ViewedAdvertsEventInteractor) Preconditions.checkNotNullFromComponent(this.a.viewedAdvertsEventInteractor());
        }
    }

    public static class p implements Provider<FavoriteAdvertsEventInteractor> {
        public final SerpDependencies a;

        public p(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsEventInteractor get() {
            return (FavoriteAdvertsEventInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsEventInteractor());
        }
    }

    public static class p0 implements Provider<ScreenTrackerFactory> {
        public final ScreenAnalyticsDependencies a;

        public p0(ScreenAnalyticsDependencies screenAnalyticsDependencies) {
            this.a = screenAnalyticsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class q implements Provider<FavoriteAdvertsUploadInteractor> {
        public final SerpDependencies a;

        public q(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsUploadInteractor get() {
            return (FavoriteAdvertsUploadInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsUploadInteractor());
        }
    }

    public static class q0 implements Provider<TimerFactory> {
        public final ScreenAnalyticsDependencies a;

        public q0(ScreenAnalyticsDependencies screenAnalyticsDependencies) {
            this.a = screenAnalyticsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimerFactory get() {
            return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
        }
    }

    public static class r implements Provider<FavoritesSyncDao> {
        public final SerpDependencies a;

        public r(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoritesSyncDao get() {
            return (FavoritesSyncDao) Preconditions.checkNotNullFromComponent(this.a.favoritesSyncDao());
        }
    }

    public static class r0 implements Provider<BackNavigationLocationInteractor> {
        public final LocationDependencies a;

        public r0(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BackNavigationLocationInteractor get() {
            return (BackNavigationLocationInteractor) Preconditions.checkNotNullFromComponent(this.a.backNavigationLocationInteractor());
        }
    }

    public static class s implements Provider<Features> {
        public final SerpDependencies a;

        public s(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class s0 implements Provider<LocationApi> {
        public final LocationDependencies a;

        public s0(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public LocationApi get() {
            return (LocationApi) Preconditions.checkNotNullFromComponent(this.a.locationApi());
        }
    }

    public static class t implements Provider<AbTestGroup<SimpleTestGroupWithControl2>> {
        public final SerpDependencies a;

        public t(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AbTestGroup<SimpleTestGroupWithControl2> get() {
            return (AbTestGroup) Preconditions.checkNotNullFromComponent(this.a.justDialSellerPhoneTestGroup());
        }
    }

    public static class t0 implements Provider<SavedLocationStorage> {
        public final LocationDependencies a;

        public t0(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SavedLocationStorage get() {
            return (SavedLocationStorage) Preconditions.checkNotNullFromComponent(this.a.savedLocationStorage());
        }
    }

    public static class u implements Provider<Locale> {
        public final SerpDependencies a;

        public u(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class u0 implements Provider<TopLocationInteractor> {
        public final LocationDependencies a;

        public u0(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TopLocationInteractor get() {
            return (TopLocationInteractor) Preconditions.checkNotNullFromComponent(this.a.topLocationInteractor());
        }
    }

    public static class v implements Provider<MyTargetImageBgProvider> {
        public final SerpDependencies a;

        public v(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MyTargetImageBgProvider get() {
            return (MyTargetImageBgProvider) Preconditions.checkNotNullFromComponent(this.a.myTargetImageBgProvider());
        }
    }

    public static class w implements Provider<NotificationManagerProvider> {
        public final SerpDependencies a;

        public w(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public NotificationManagerProvider get() {
            return (NotificationManagerProvider) Preconditions.checkNotNullFromComponent(this.a.notificationManagerProvider());
        }
    }

    public static class x implements Provider<ExposedAbTestGroup<OrangeAdBadgeTestGroup>> {
        public final SerpDependencies a;

        public x(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ExposedAbTestGroup<OrangeAdBadgeTestGroup> get() {
            return (ExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.orangeAdBadgeTestGroup());
        }
    }

    public static class y implements Provider<Preferences> {
        public final SerpDependencies a;

        public y(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Preferences get() {
            return (Preferences) Preconditions.checkNotNullFromComponent(this.a.preferences());
        }
    }

    public static class z implements Provider<SerpItemsPrefetchTestGroup> {
        public final SerpDependencies a;

        public z(SerpDependencies serpDependencies) {
            this.a = serpDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SerpItemsPrefetchTestGroup get() {
            return (SerpItemsPrefetchTestGroup) Preconditions.checkNotNullFromComponent(this.a.prefetchTestGroup());
        }
    }

    public DaggerSerpComponent(AppendingLoaderModule appendingLoaderModule, ConnectionQualityInteractorModule connectionQualityInteractorModule, AppendingRetryModule appendingRetryModule, SerpDependencies serpDependencies, LocationDependencies locationDependencies, ScreenAnalyticsDependencies screenAnalyticsDependencies, Screen screen, Resources resources, SerpArguments serpArguments, Kundle kundle, Kundle kundle2, Kundle kundle3, RecyclerView.RecycledViewPool recycledViewPool, SerpPresenterState serpPresenterState, Kundle kundle4, Bundle bundle, WarningStateProviderState warningStateProviderState, FragmentManager fragmentManager, Boolean bool, Relay relay, Relay relay2, Relay relay3, Activity activity, Fragment fragment, ActivityInteractor activityInteractor, SearchParams searchParams, Area area, Kundle kundle5, String str, Kundle kundle6, Kundle kundle7, Bundle bundle2, VerticalFilterState verticalFilterState, BannerPageSource bannerPageSource, Boolean bool2, Kundle kundle8, SerpOnboardingHandlerState serpOnboardingHandlerState, a aVar) {
        this.a = resources;
        this.b = screenAnalyticsDependencies;
        this.c = screen;
        this.d = serpDependencies;
        this.e = warningStateProviderState;
        this.g = InstanceFactory.create(serpArguments);
        this.h = new e0(serpDependencies);
        this.i = SerpInteractorModule_ProvideSuggestParamsConverter$serp_core_releaseFactory.create(SerpInteractorModule_ProvideSearchParamsConverter$serp_core_releaseFactory.create());
        this.j = new m0(serpDependencies);
        m mVar = new m(serpDependencies);
        this.k = mVar;
        e eVar = new e(serpDependencies);
        this.l = eVar;
        j jVar = new j(serpDependencies);
        this.m = jVar;
        s sVar = new s(serpDependencies);
        this.n = sVar;
        DfpBannerLoaderImpl_Factory create = DfpBannerLoaderImpl_Factory.create(mVar, eVar, jVar, sVar);
        this.o = create;
        this.p = DoubleCheck.provider(create);
        d0 d0Var = new d0(serpDependencies);
        this.q = d0Var;
        YandexBannerLoaderImpl_Factory create2 = YandexBannerLoaderImpl_Factory.create(this.k, d0Var, this.l);
        this.r = create2;
        this.s = DoubleCheck.provider(create2);
        v vVar = new v(serpDependencies);
        this.t = vVar;
        MyTargetBannerLoaderImpl_Factory create3 = MyTargetBannerLoaderImpl_Factory.create(this.k, this.l, vVar);
        this.u = create3;
        this.v = DoubleCheck.provider(create3);
        this.w = InstanceFactory.create(bannerPageSource);
        l0 l0Var = new l0(serpDependencies);
        this.x = l0Var;
        Provider<SerpAnalyticsInteractor> provider = DoubleCheck.provider(SerpModule_ProvideSerpAnalyticsInteractor$serp_releaseFactory.create(this.l, l0Var, this.g, this.n));
        this.y = provider;
        Provider<TreeClickStreamParent> provider2 = DoubleCheck.provider(SerpModule_ProvideSerpTreeParent$serp_releaseFactory.create(provider));
        this.z = provider2;
        this.A = CommercialBannersAnalyticsInteractorImpl_Factory.create(this.w, this.l, provider2, this.x, CommercialBannerTimeProviderImpl_Factory.create());
        this.B = DoubleCheck.provider(BannerInfoFactoryImpl_Factory.create());
        CommercialBannersInteractorImpl_Factory create4 = CommercialBannersInteractorImpl_Factory.create(this.p, this.s, this.v, this.A, CommercialBannerTimeProviderImpl_Factory.create(), this.q, this.B);
        this.C = create4;
        this.D = DoubleCheck.provider(create4);
        Factory create5 = InstanceFactory.create(resources);
        this.E = create5;
        this.F = SingleCheck.provider(SerpItemConverterModule_ProvideItemAdvertSpanCountProviderFactory.create(create5));
        Provider<AdvertSpanCountProvider> provider3 = SingleCheck.provider(SerpItemConverterModule_ProvideBigAdvertSpanCountProviderFactory.create(this.E));
        this.G = provider3;
        this.H = SingleCheck.provider(SerpItemConverterModule_ProvideAdvertConverterFactory.create(this.F, provider3, this.E, this.n));
        this.I = SingleCheck.provider(SerpItemConverterModule_ProvideAdvertXlConverterFactory.create(this.E, this.n));
        Provider<AdResourceProvider> provider4 = DoubleCheck.provider(AdResourceProviderImpl_Factory.create());
        this.J = provider4;
        c0 c0Var = new c0(serpDependencies);
        this.K = c0Var;
        this.L = SingleCheck.provider(SerpItemConverterModule_ProvideCommercialConverterFactory.create(this.F, this.G, provider4, c0Var));
        n nVar = new n(serpDependencies);
        this.M = nVar;
        this.N = SingleCheck.provider(SerpItemConverterModule_ProvideShortcutBannerConverterFactory.create(nVar, this.E));
        this.O = SingleCheck.provider(SerpItemConverterModule_ProvideSerpWarningConverterFactory.create());
        this.P = SingleCheck.provider(SerpItemConverterModule_ProvideSnippetConverterFactory.create());
        this.Q = SingleCheck.provider(SerpItemConverterModule_ProvideSerpEmptySearchConverterFactory.create());
        this.R = SingleCheck.provider(SerpItemConverterModule_ProvideGroupTitleItemConverterFactory.create());
        this.S = SingleCheck.provider(SerpItemConverterModule_ProvideEmptyPlaceholderItemConverterFactory.create());
        this.T = SingleCheck.provider(SerpItemConverterModule_ProvideHeaderElementConverterFactory.create());
        this.U = new r(serpDependencies);
        this.V = new q(serpDependencies);
        this.W = new p(serpDependencies);
        d dVar = new d(serpDependencies);
        this.X = dVar;
        FavoriteAdvertsAnalyticsInteractorImpl_Factory create6 = FavoriteAdvertsAnalyticsInteractorImpl_Factory.create(this.l, dVar);
        this.Y = create6;
        FavoriteAdvertsInteractorImpl_Factory create7 = FavoriteAdvertsInteractorImpl_Factory.create(this.U, this.V, this.W, create6, this.q);
        this.Z = create7;
        this.a0 = SingleCheck.provider(SerpItemConverterModule_ProvideFavoriteStatusResolverFactory.create(create7));
        this.b0 = new n0(serpDependencies);
        this.c0 = new o0(serpDependencies);
        Provider<ViewedAdvertsInteractor> provider5 = SingleCheck.provider(ViewedAdvertsModule_ProvideViewedAdvertsInteractorFactory.create(ViewedAdvertsInteractorFactoryImpl_Factory.create(), this.b0, this.q, this.c0, this.n));
        this.d0 = provider5;
        Provider<ViewedStatusResolver> provider6 = SingleCheck.provider(ViewedAdvertsModule_ProvideViewedStatusResolverFactory.create(provider5));
        this.e0 = provider6;
        this.f0 = SingleCheck.provider(SerpItemConverterModule_ProvideWitcherElementConverterFactory.create(this.H, this.a0, provider6));
        this.g0 = SingleCheck.provider(SerpItemConverterModule_ProvideLocationNotificationConverterFactory.create());
        this.h0 = SingleCheck.provider(SerpItemConverterModule_ProvideSellerElementConverterFactory.create());
        this.i0 = SingleCheck.provider(SerpItemConverterModule_ProvideReportBannerConverterFactory.create(this.E, this.n));
        this.j0 = SingleCheck.provider(SerpItemConverterModule_ProvidePromoCardConverterFactory.create(this.E, this.n));
        this.k0 = SingleCheck.provider(SerpItemConverterModule_ProvideMapBannerConverterFactory.create());
        Provider<VerticalFilterItemConverter> provider7 = SingleCheck.provider(SerpItemConverterModule_ProvideVerticalFilterItemConverterFactory.create());
        this.l0 = provider7;
        this.m0 = SingleCheck.provider(SerpItemConverterModule_ProvideElementItemConverterFactory.create(this.H, this.I, this.L, this.N, this.O, this.P, this.Q, this.R, this.S, this.T, this.f0, this.g0, this.h0, this.i0, this.j0, this.k0, provider7));
        this.n0 = SingleCheck.provider(SerpItemConverterModule_ProvideSerpItemSorterFactory.create());
        Provider<SerpItemSizeAdjuster> provider8 = SingleCheck.provider(SerpItemConverterModule_ProvideItemSizeAdjusterFactory.create());
        this.o0 = provider8;
        this.p0 = SingleCheck.provider(SerpItemConverterModule_ProvideSerpItemProcessorFactory.create(this.m0, this.n0, provider8, this.a0, this.e0, this.q));
        Provider<SpannedGridPositionProvider> provider9 = SingleCheck.provider(SpanAdapterModule_ProvideSpannedGridPositionProviderFactory.create(this.E));
        this.q0 = provider9;
        SerpItemAlignerImpl_Factory create8 = SerpItemAlignerImpl_Factory.create(provider9);
        this.r0 = create8;
        this.s0 = SingleCheck.provider(create8);
        this.t0 = SerpInteractorModule_ProvideResourcesProvider$serp_core_releaseFactory.create(this.E);
        this.u0 = new b0(serpDependencies);
        g0 g0Var = new g0(serpDependencies);
        this.v0 = g0Var;
        j0 j0Var = new j0(serpDependencies);
        this.w0 = j0Var;
        f0 f0Var = new f0(serpDependencies);
        this.x0 = f0Var;
        this.y0 = SerpInteractorModule_ProvideServiceInteractor$serp_core_releaseFactory.create(g0Var, this.q, j0Var, f0Var, this.n);
        this.z0 = SerpInteractorModule_ProvideSearchDeepLinkInteractor$serp_core_releaseFactory.create(this.h, SerpInteractorModule_ProvideSearchParamsConverter$serp_core_releaseFactory.create(), this.q);
        y yVar = new y(serpDependencies);
        this.A0 = yVar;
        this.B0 = SerpInteractorModule_ProviderPermanentWarningStateStorage$serp_core_releaseFactory.create(yVar);
        this.C0 = InstanceFactory.createNullable(warningStateProviderState);
        this.D0 = SerpInteractorModule_ProvideWarningStateProvider$serp_core_releaseFactory.create(SerpInteractorModule_ProviderWarningStateStorage$serp_core_releaseFactory.create(), this.B0, this.C0);
        this.E0 = new w(serpDependencies);
        p0 p0Var = new p0(screenAnalyticsDependencies);
        this.F0 = p0Var;
        q0 q0Var = new q0(screenAnalyticsDependencies);
        this.G0 = q0Var;
        SerpTrackerImpl_Factory create9 = SerpTrackerImpl_Factory.create(p0Var, q0Var);
        this.H0 = create9;
        this.I0 = DoubleCheck.provider(create9);
        this.J0 = SerpInteractorModule_ProvideSerpSnippetInteractor$serp_core_releaseFactory.create(this.q, this.h);
        this.K0 = DoubleCheck.provider(SearchParamsConverterImpl_Factory.create());
        Provider<InlineFiltersChangesParamsConverter> provider10 = DoubleCheck.provider(InlineFiltersChangesParamsConverterImpl_Factory.create());
        this.L0 = provider10;
        InlineFiltersInteractorImpl_Factory create10 = InlineFiltersInteractorImpl_Factory.create(this.h, this.K0, provider10, InlineFiltersParametersKeyWrapper_Factory.create(), this.q, this.n);
        this.M0 = create10;
        this.N0 = DoubleCheck.provider(create10);
        this.O0 = InstanceFactory.create(bool);
        this.P0 = InstanceFactory.createNullable(kundle4);
        SerpInteractorImpl_Factory create11 = SerpInteractorImpl_Factory.create(this.g, this.h, SerpInteractorModule_ProvideSearchParamsConverter$serp_core_releaseFactory.create(), this.i, this.j, this.D, this.q, this.p0, this.s0, this.l, this.t0, this.u0, this.n, this.y0, this.z0, this.D0, this.E0, this.I0, this.J0, this.N0, this.O0, this.P0);
        this.Q0 = create11;
        this.R0 = DoubleCheck.provider(create11);
        this.S0 = SerpInteractorModule_ProvideSubscribeSearchInteractor$serp_core_releaseFactory.create(this.w0, this.v0, SerpInteractorModule_ProvideSearchParamsConverter$serp_core_releaseFactory.create(), this.j, this.q);
        this.T0 = new DelegateFactory();
        SerpBadgeResourceProviderImpl_Factory create12 = SerpBadgeResourceProviderImpl_Factory.create(this.E);
        this.U0 = create12;
        this.V0 = DoubleCheck.provider(create12);
        Factory createNullable = InstanceFactory.createNullable(serpOnboardingHandlerState);
        this.W0 = createNullable;
        SerpOnboardingHandlerImpl_Factory create13 = SerpOnboardingHandlerImpl_Factory.create(this.V0, this.A0, this.n, createNullable);
        this.X0 = create13;
        Provider<SerpOnboardingHandler> provider11 = DoubleCheck.provider(create13);
        this.Y0 = provider11;
        this.Z0 = SingleCheck.provider(AdvertItemPresenterModule_ProvideAdvertGridItemPresenterFactory.create(this.T0, this.l, this.n, provider11));
        this.a1 = new k0(serpDependencies);
        this.b1 = new u(serpDependencies);
        a0 a0Var = new a0(serpDependencies);
        this.c1 = a0Var;
        z zVar = new z(serpDependencies);
        this.d1 = zVar;
        SerpItemAbViewConfig_Factory create14 = SerpItemAbViewConfig_Factory.create(a0Var, zVar);
        this.e1 = create14;
        l lVar = new l(serpDependencies);
        this.f1 = lVar;
        this.g1 = SingleCheck.provider(AdvertItemModule_ProvideAdvertItemGridBlueprintFactory.create(this.Z0, this.a1, this.b1, create14, lVar));
        Provider<AdvertListItemPresenter> provider12 = SingleCheck.provider(AdvertItemPresenterModule_ProvideAdvertListItemPresenterFactory.create(this.T0, this.l, this.n, this.Y0));
        this.h1 = provider12;
        this.i1 = SingleCheck.provider(AdvertItemModule_ProvideAdvertItemListBlueprintFactory.create(provider12, this.a1, this.b1, this.e1, this.f1));
        this.j1 = SingleCheck.provider(AdvertItemModule_ProvideAdvertItemDoubleBlueprintFactory.create(this.Z0, this.a1, this.b1, this.e1, this.f1));
        DateTimeFormatterResourceProviderImpl_Factory create15 = DateTimeFormatterResourceProviderImpl_Factory.create(this.E);
        this.k1 = create15;
        this.l1 = DateTimeFormatterModule_ProvideUpperCaseDateTimeFormatterFactory.create(this.a1, create15, this.b1);
        AdvertXlDimensionsProviderImpl_Factory create16 = AdvertXlDimensionsProviderImpl_Factory.create(this.E);
        this.m1 = create16;
        this.n1 = SingleCheck.provider(create16);
        g gVar = new g(serpDependencies);
        this.o1 = gVar;
        AsyncPhoneInteractorImpl_Factory create17 = AsyncPhoneInteractorImpl_Factory.create(gVar, this.q);
        this.p1 = create17;
        this.q1 = SingleCheck.provider(create17);
        Factory create18 = InstanceFactory.create(screen);
        this.r1 = create18;
        AsyncPhoneTrackerImpl_Factory create19 = AsyncPhoneTrackerImpl_Factory.create(this.F0, this.G0, create18);
        this.s1 = create19;
        Provider<AsyncPhoneTracker> provider13 = SingleCheck.provider(create19);
        this.t1 = provider13;
        Provider<AsyncPhoneInteractor> provider14 = this.q1;
        Provider<TypedErrorThrowableConverter> provider15 = this.j;
        AsyncPhonePresenterImpl_Factory create20 = AsyncPhonePresenterImpl_Factory.create(provider14, provider15, provider13, this.q, this.X, this.n, this.T0, provider15);
        this.u1 = create20;
        this.v1 = SingleCheck.provider(create20);
        Factory createNullable2 = InstanceFactory.createNullable(kundle);
        this.w1 = createNullable2;
        AdvertXlItemPresenterImpl_Factory create21 = AdvertXlItemPresenterImpl_Factory.create(this.T0, this.l1, this.n1, this.v1, this.l, this.n, this.Y0, createNullable2);
        this.x1 = create21;
        Provider<AdvertXlItemPresenter> provider16 = SingleCheck.provider(create21);
        this.y1 = provider16;
        this.z1 = AdvertXlItemBlueprint_Factory.create(provider16, this.e1);
        this.A1 = InstanceFactory.createNullable(kundle2);
        AdvertSellerConverterImpl_Factory create22 = AdvertSellerConverterImpl_Factory.create(this.n);
        this.B1 = create22;
        Provider<AdvertSellerConverter> provider17 = SingleCheck.provider(create22);
        this.C1 = provider17;
        h0 h0Var = new h0(serpDependencies);
        this.D1 = h0Var;
        AdvertRichItemPresenterImpl_Factory create23 = AdvertRichItemPresenterImpl_Factory.create(this.T0, this.l1, this.l, this.A1, provider17, this.v1, h0Var, this.n, this.Y0);
        this.E1 = create23;
        this.F1 = SingleCheck.provider(create23);
        this.G1 = InstanceFactory.create(recycledViewPool);
        SellerInfoParamsFactoryImpl_Factory create24 = SellerInfoParamsFactoryImpl_Factory.create(this.E, this.D1);
        this.H1 = create24;
        Provider<SellerInfoParamsFactory> provider18 = SingleCheck.provider(create24);
        this.I1 = provider18;
        this.J1 = AdvertVipRichItemBlueprint_Factory.create(this.F1, this.G1, this.n, provider18, this.d1);
        RichSnippetsResourceProviderImpl_Factory create25 = RichSnippetsResourceProviderImpl_Factory.create(this.E);
        this.K1 = create25;
        Provider<RichSnippetsResourceProvider> provider19 = SingleCheck.provider(create25);
        this.L1 = provider19;
        AdvertXlRichItemPresenterImpl_Factory create26 = AdvertXlRichItemPresenterImpl_Factory.create(this.T0, this.l1, provider19, this.l, this.C1, this.v1, this.n, this.Y0, this.D1, this.A1);
        this.M1 = create26;
        Provider<AdvertXlRichItemPresenter> provider20 = SingleCheck.provider(create26);
        this.N1 = provider20;
        this.O1 = AdvertXlRichItemBlueprint_Factory.create(provider20, this.G1, this.n, this.I1, this.d1);
        AdvertRichJobItemPresenterImpl_Factory create27 = AdvertRichJobItemPresenterImpl_Factory.create(this.T0, this.l1, this.v1, this.l);
        this.P1 = create27;
        Provider<AdvertRichJobItemPresenter> provider21 = SingleCheck.provider(create27);
        this.Q1 = provider21;
        this.R1 = AdvertRichJobItemBlueprint_Factory.create(provider21);
        this.S1 = AdvertVipRichJobItemBlueprint_Factory.create(this.Q1);
        AdvertXlRichJobItemPresenterImpl_Factory create28 = AdvertXlRichJobItemPresenterImpl_Factory.create(this.T0, this.l1, this.v1, this.l, this.A1);
        this.T1 = create28;
        Provider<AdvertXlRichJobItemPresenter> provider22 = SingleCheck.provider(create28);
        this.U1 = provider22;
        this.V1 = AdvertXlRichJobItemBlueprint_Factory.create(provider22, this.G1);
        this.W1 = AdvertRichItemBlueprint_Factory.create(this.F1, this.G1, this.n, this.I1, this.d1);
        x xVar = new x(serpDependencies);
        this.X1 = xVar;
        YandexContentItemPresenterImpl_Factory create29 = YandexContentItemPresenterImpl_Factory.create(this.T0, this.l, xVar);
        this.Y1 = create29;
        Provider<YandexContentItemPresenter> provider23 = DoubleCheck.provider(create29);
        this.Z1 = provider23;
        this.f55a2 = YandexContentSingleGridBlueprint_Factory.create(provider23);
        this.b2 = YandexContentRichBlueprint_Factory.create(this.Z1);
        YandexAppInstallItemPresenterImpl_Factory create30 = YandexAppInstallItemPresenterImpl_Factory.create(this.T0, this.l);
        this.c2 = create30;
        Provider<YandexAppInstallItemPresenter> provider24 = DoubleCheck.provider(create30);
        this.d2 = provider24;
        this.e2 = YandexAppInstallRichBlueprint_Factory.create(provider24);
        this.f2 = YandexContentDoubleGridBlueprint_Factory.create(this.Z1);
        this.g2 = YandexAppInstallSingleItemBlueprint_Factory.create(this.d2);
        this.h2 = YandexAppInstallDoubleItemBlueprint_Factory.create(this.d2);
        AdfoxImageItemPresenterImpl_Factory create31 = AdfoxImageItemPresenterImpl_Factory.create(this.T0, this.l, this.X1);
        this.i2 = create31;
        Provider<AdfoxImageItemPresenter> provider25 = DoubleCheck.provider(create31);
        this.j2 = provider25;
        this.k2 = AdfoxSingleGridBlueprint_Factory.create(provider25);
        this.l2 = AdfoxSingleListBlueprint_Factory.create(this.j2);
        DfpUnifiedPresenterImpl_Factory create32 = DfpUnifiedPresenterImpl_Factory.create(this.T0, this.f, this.q);
        this.m2 = create32;
        Provider<DfpUnifiedPresenter> provider26 = DoubleCheck.provider(create32);
        this.n2 = provider26;
        this.o2 = DfpUnifiedDoubleBlueprint_Factory.create(provider26);
        this.p2 = DfpUnifiedSingleGridBlueprint_Factory.create(this.n2);
        DfpAppInstallPresenterImpl_Factory create33 = DfpAppInstallPresenterImpl_Factory.create(this.T0, this.f);
        this.q2 = create33;
        Provider<DfpAppInstallPresenter> provider27 = DoubleCheck.provider(create33);
        this.r2 = provider27;
        this.s2 = DfpAppInstallDoubleBlueprint_Factory.create(provider27);
        this.t2 = DfpAppInstallSingleBlueprint_Factory.create(this.r2);
        DfpContentPresenterImpl_Factory create34 = DfpContentPresenterImpl_Factory.create(this.T0, this.f);
        this.u2 = create34;
        Provider<DfpContentPresenter> provider28 = DoubleCheck.provider(create34);
        this.v2 = provider28;
        this.w2 = DfpContentSingleGridBlueprint_Factory.create(provider28);
        this.x2 = DfpContentDoubleGridBlueprint_Factory.create(this.v2);
        MyTargetContentPresenterImpl_Factory create35 = MyTargetContentPresenterImpl_Factory.create(this.T0, this.t, this.n);
        this.y2 = create35;
        Provider<MyTargetContentPresenter> provider29 = DoubleCheck.provider(create35);
        this.z2 = provider29;
        this.A2 = MyTargetContentSingleBlueprint_Factory.create(provider29);
        this.B2 = MyTargetContentBlueprint_Factory.create(this.z2);
        MyTargetAppInstallPresenterImpl_Factory create36 = MyTargetAppInstallPresenterImpl_Factory.create(this.T0, this.t, this.n);
        this.C2 = create36;
        Provider<MyTargetAppInstallPresenter> provider30 = DoubleCheck.provider(create36);
        this.D2 = provider30;
        this.E2 = MyTargetAppInstallSingleBlueprint_Factory.create(provider30);
        this.F2 = MyTargetAppInstallBlueprint_Factory.create(this.D2);
        SerpShortcutBannerWidthProvider_Factory create37 = SerpShortcutBannerWidthProvider_Factory.create(this.E, this.m);
        this.G2 = create37;
        this.H2 = SingleCheck.provider(create37);
        Factory create38 = InstanceFactory.create(activity);
        this.I2 = create38;
        Provider<ShortcutBannerItemPresenter> provider31 = DoubleCheck.provider(SerpAdapterModule_ProvideShortcutBannerItemPresenterFactory.create(this.T0, this.H2, create38));
        this.J2 = provider31;
        this.K2 = ShortcutBannerBlueprint_Factory.create(provider31);
        SerpWarningItemPresenterImpl_Factory create39 = SerpWarningItemPresenterImpl_Factory.create(this.T0);
        this.L2 = create39;
        Provider<SerpWarningItemPresenter> provider32 = SingleCheck.provider(create39);
        this.M2 = provider32;
        this.N2 = SerpWarningItemBlueprint_Factory.create(provider32);
        this.O2 = InstanceFactory.create(relay);
        this.P2 = InstanceFactory.create(relay2);
        Factory create40 = InstanceFactory.create(relay3);
        this.Q2 = create40;
        SnippetPresenter_Impl_Factory create41 = SnippetPresenter_Impl_Factory.create(this.O2, this.P2, create40);
        this.R2 = create41;
        Provider<SnippetPresenter> provider33 = SingleCheck.provider(create41);
        this.S2 = provider33;
        this.T2 = SnippetBlueprint_Factory.create(provider33);
        Provider<EmptyAdStubItemPresenter> provider34 = DoubleCheck.provider(EmptyAdStubItemPresenterImpl_Factory.create());
        this.U2 = provider34;
        this.V2 = EmptyAdStubItemBlueprint_Factory.create(provider34);
        Provider<EmptySearchItemPresenter> provider35 = DoubleCheck.provider(EmptySearchItemPresenterImpl_Factory.create());
        this.W2 = provider35;
        this.X2 = EmptySearchItemBlueprint_Factory.create(provider35);
        Provider<SingleTextPresenter> provider36 = DoubleCheck.provider(SingleTextPresenterImpl_Factory.create());
        this.Y2 = provider36;
        this.Z2 = HomeSerpHeaderBluePrint_Factory.create(provider36);
        this.a3 = NotLoadAdStubGridBlueprint_Factory.create(NotLoadAdStubPresenter_Factory.create());
        Provider<AppendingLoaderItemPresenter> provider37 = DoubleCheck.provider(AppendingLoaderModule_ProvideAppendingLoaderItemPresenterFactory.create(appendingLoaderModule));
        this.b3 = provider37;
        this.c3 = DoubleCheck.provider(AppendingLoaderModule_ProvideAppendingLoaderItemBlueprintFactory.create(appendingLoaderModule, provider37));
        Provider<AppendingRetryItemPresenter> provider38 = DoubleCheck.provider(AppendingRetryModule_ProvideAppendingRetryItemPresenterFactory.create(appendingRetryModule));
        this.d3 = provider38;
        this.e3 = DoubleCheck.provider(AppendingRetryModule_ProvideAppendingRetryItemBlueprintFactory.create(appendingRetryModule, provider38));
        Provider<GroupTitleItemPresenter> provider39 = SingleCheck.provider(GroupTitleItemPresenterImpl_Factory.create());
        this.f3 = provider39;
        this.g3 = GroupTitleItemBlueprint_Factory.create(provider39);
        EmptyPlaceholderItemPresenterImpl_Factory create42 = EmptyPlaceholderItemPresenterImpl_Factory.create(this.T0);
        this.h3 = create42;
        Provider<EmptyPlaceholderItemPresenter> provider40 = SingleCheck.provider(create42);
        this.i3 = provider40;
        this.j3 = EmptyPlaceholderItemBlueprint_Factory.create(provider40);
        this.k3 = YandexContentListBlueprint_Factory.create(this.Z1);
        this.l3 = YandexAppInstallListItemBlueprint_Factory.create(this.d2);
        this.m3 = DfpUnifiedListBlueprint_Factory.create(this.n2);
        this.n3 = DfpContentListBlueprint_Factory.create(this.v2);
        this.o3 = DfpAppInstallListBlueprint_Factory.create(this.r2);
        this.p3 = MyTargetContentListBlueprint_Factory.create(this.z2);
        this.q3 = MyTargetAppInstallListBlueprint_Factory.create(this.D2);
        this.r3 = NotLoadAdStubListBlueprint_Factory.create(NotLoadAdStubPresenter_Factory.create());
        this.s3 = NotLoadAdRichStubBlueprint_Factory.create(NotLoadAdStubPresenter_Factory.create());
        WitcherResourceProviderImpl_Factory create43 = WitcherResourceProviderImpl_Factory.create(this.E);
        this.t3 = create43;
        this.u3 = DoubleCheck.provider(create43);
        this.v3 = InstanceFactory.createNullable(kundle3);
        WitcherAnalyticsInteractorImpl_Factory create44 = WitcherAnalyticsInteractorImpl_Factory.create(this.l);
        this.w3 = create44;
        this.x3 = DoubleCheck.provider(create44);
        Provider<SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup>> provider41 = DoubleCheck.provider(SerpModule_ProvideViewedItemsTabTestGroupFactory.create());
        this.y3 = provider41;
        WitcherItemPresenterImpl_Factory create45 = WitcherItemPresenterImpl_Factory.create(this.u3, this.T0, this.v3, this.x3, provider41);
        this.z3 = create45;
        this.A3 = SingleCheck.provider(create45);
        this.B3 = DoubleCheck.provider(WitcherModule_ProvidesWitcherItemsBinderFactory.create(this.g1));
        this.C3 = WitcherModule_ProvideWitcherViewedAdvertsPresenter$serp_core_releaseFactory.create(this.c0, this.q);
        Provider<FavoriteAdvertsResourceProvider> provider42 = SingleCheck.provider(FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsResourceProvider$favorite_core_releaseFactory.create(this.E));
        this.D3 = provider42;
        this.E3 = WitcherModule_ProvideWitcherFavoriteAdvertsPresenter$serp_core_releaseFactory.create(this.Z, provider42, this.q);
        WitcherModule_ProvideWitcherAdapter$serp_core_releaseFactory create46 = WitcherModule_ProvideWitcherAdapter$serp_core_releaseFactory.create(this.B3);
        this.F3 = create46;
        o oVar = new o(serpDependencies);
        this.G3 = oVar;
        this.H3 = WitcherItemBlueprint_Factory.create(this.A3, this.B3, this.u3, this.C3, this.E3, create46, oVar);
        VerticalFilterInteractorImpl_Factory create47 = VerticalFilterInteractorImpl_Factory.create(this.h, this.q);
        this.I3 = create47;
        this.J3 = DoubleCheck.provider(create47);
        h hVar = new h(serpDependencies);
        this.K3 = hVar;
        InlineFiltersDialogItemConverterImpl_Factory create48 = InlineFiltersDialogItemConverterImpl_Factory.create(this.n, hVar);
        this.L3 = create48;
        this.M3 = DoubleCheck.provider(create48);
        VerticalSearchFilterResourceProviderImpl_Factory create49 = VerticalSearchFilterResourceProviderImpl_Factory.create(this.E);
        this.N3 = create49;
        this.O3 = DoubleCheck.provider(create49);
        Factory createNullable3 = InstanceFactory.createNullable(verticalFilterState);
        this.P3 = createNullable3;
        VerticalFilterPresenterImpl_Factory create50 = VerticalFilterPresenterImpl_Factory.create(this.J3, this.l, this.M3, this.O3, this.q, createNullable3);
        this.Q3 = create50;
        Provider<VerticalFilterPresenter> provider43 = DoubleCheck.provider(create50);
        this.R3 = provider43;
        VerticalFilterItemPresenterImpl_Factory create51 = VerticalFilterItemPresenterImpl_Factory.create(provider43, this.l);
        this.S3 = create51;
        this.T3 = DoubleCheck.provider(create51);
        VerticalSearchFilterItemPresenterImpl_Factory create52 = VerticalSearchFilterItemPresenterImpl_Factory.create(this.R3);
        this.U3 = create52;
        Provider<VerticalSearchFilterItemPresenter> provider44 = DoubleCheck.provider(create52);
        this.V3 = provider44;
        VerticalSearchFilterSelectItemBlueprint_Factory create53 = VerticalSearchFilterSelectItemBlueprint_Factory.create(provider44);
        this.W3 = create53;
        this.X3 = DoubleCheck.provider(create53);
        VerticalSearchFilterMultiSelectItemBlueprint_Factory create54 = VerticalSearchFilterMultiSelectItemBlueprint_Factory.create(this.V3);
        this.Y3 = create54;
        this.Z3 = DoubleCheck.provider(create54);
        this.a4 = SetFactory.builder(2, 0).addProvider(this.X3).addProvider(this.Z3).build();
        VerticalSearchFilterSegmentedItemPresenterImpl_Factory create55 = VerticalSearchFilterSegmentedItemPresenterImpl_Factory.create(this.R3);
        this.b4 = create55;
        Provider<VerticalSearchFilterSegmentedItemPresenter> provider45 = DoubleCheck.provider(create55);
        this.c4 = provider45;
        VerticalSearchFilterSegmentedItemBlueprintImpl_Factory create56 = VerticalSearchFilterSegmentedItemBlueprintImpl_Factory.create(provider45);
        this.d4 = create56;
        Provider<VerticalSearchFilterSegmentedItemBlueprint> provider46 = DoubleCheck.provider(create56);
        this.e4 = provider46;
        Provider<ItemBinder> provider47 = DoubleCheck.provider(VerticalFilterModule_ProvideItemBinderFactory.create(this.a4, provider46));
        this.f4 = provider47;
        this.g4 = DoubleCheck.provider(VerticalFilterModule_ProvideAdapterPresenter$serp_core_releaseFactory.create(provider47));
        Provider<DestroyableViewHolderBuilder> provider48 = DoubleCheck.provider(VerticalFilterModule_ProvideDestroyableViewHolderBuilder$serp_core_releaseFactory.create(this.f4));
        this.h4 = provider48;
        Provider<SafeRecyclerAdapter> provider49 = DoubleCheck.provider(VerticalFilterModule_ProvideSafeRecyclerAdapter$serp_core_releaseFactory.create(this.g4, provider48, this.m, this.l));
        this.i4 = provider49;
        this.j4 = VerticalFilterItemBlueprint_Factory.create(this.T3, this.g4, provider49, this.O3);
        PromoCardItemPresenter_Factory create57 = PromoCardItemPresenter_Factory.create(this.T0, this.l);
        this.k4 = create57;
        this.l4 = PromoCardBlueprint_Factory.create(create57);
        MapBannerItemPresenterImpl_Factory create58 = MapBannerItemPresenterImpl_Factory.create(this.T0);
        this.m4 = create58;
        Provider<MapBannerItemPresenter> provider50 = SingleCheck.provider(create58);
        this.n4 = provider50;
        this.o4 = MapBannerItemBlueprint_Factory.create(provider50);
        Provider<SkeletonPresenter> provider51 = DoubleCheck.provider(SkeletonPresenterImpl_Factory.create());
        this.p4 = provider51;
        AdvertItemGridSkeletonBlueprint_Factory create59 = AdvertItemGridSkeletonBlueprint_Factory.create(provider51);
        this.q4 = create59;
        this.r4 = DoubleCheck.provider(create59);
        this.s4 = SetFactory.builder(1, 0).addProvider(this.r4).build();
        Provider<ItemBinder> provider52 = DoubleCheck.provider(SerpModule_ProvideItemBinder$serp_releaseFactory.create(this.g1, this.i1, this.j1, this.z1, this.J1, this.O1, this.R1, this.S1, this.V1, this.W1, this.f55a2, this.b2, this.e2, this.f2, this.g2, this.h2, this.k2, this.l2, this.o2, this.p2, this.s2, this.t2, this.w2, this.x2, this.A2, this.B2, this.E2, this.F2, this.K2, this.N2, this.T2, this.V2, this.X2, this.Z2, this.a3, this.c3, this.e3, this.g3, this.j3, this.k3, this.l3, this.m3, this.n3, this.o3, this.p3, this.q3, this.r3, this.s3, this.H3, this.j4, this.l4, this.o4, this.s4));
        this.t4 = provider52;
        this.u4 = DoubleCheck.provider(SerpModule_ProvideAdapterPresenter$serp_releaseFactory.create(provider52));
        Factory createNullable4 = InstanceFactory.createNullable(bundle);
        this.v4 = createNullable4;
        FloatingViewsPresenterImpl_Factory create60 = FloatingViewsPresenterImpl_Factory.create(createNullable4);
        this.w4 = create60;
        this.x4 = DoubleCheck.provider(create60);
        ErrorFormatterImpl_Factory create61 = ErrorFormatterImpl_Factory.create(this.E);
        this.y4 = create61;
        this.z4 = DoubleCheck.provider(create61);
        i iVar = new i(serpDependencies);
        this.A4 = iVar;
        AdvertMessengerInteractorImpl_Factory create62 = AdvertMessengerInteractorImpl_Factory.create(iVar, this.X, this.q);
        this.B4 = create62;
        this.C4 = DoubleCheck.provider(create62);
        this.D4 = SingleCheck.provider(SpanAdapterModule_ProvideSerpSpanProviderFactory.create(this.q0, this.E));
        this.E4 = SerpModule_ProvidesInitialQuery$serp_releaseFactory.create(this.g);
        this.F4 = SingleCheck.provider(ConnectionQualityInteractorModule_ProvideConnectionManager$connection_quality_releaseFactory.create(connectionQualityInteractorModule));
        f fVar = new f(serpDependencies);
        this.G4 = fVar;
        this.H4 = SingleCheck.provider(ConnectionQualityInteractorModule_ProvideConnectivityManager$connection_quality_releaseFactory.create(connectionQualityInteractorModule, fVar));
        Provider<ConnectionClassManager> provider53 = SingleCheck.provider(ConnectionQualityInteractorModule_ProvideConnectionClassManager$connection_quality_releaseFactory.create(connectionQualityInteractorModule));
        this.I4 = provider53;
        Provider<ConnectionQualityInteractor> provider54 = SingleCheck.provider(ConnectionQualityInteractorModule_ProvideConnectionQualityInteractor$connection_quality_releaseFactory.create(connectionQualityInteractorModule, this.H4, provider53));
        this.J4 = provider54;
        this.K4 = SingleCheck.provider(ConnectionQualityInteractorModule_ProvideConnectionClassSubscriber$connection_quality_releaseFactory.create(connectionQualityInteractorModule, this.F4, provider54));
        this.L4 = SingleCheck.provider(FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsPresenter$favorite_core_releaseFactory.create(this.Z, this.q, this.D3));
        this.M4 = SingleCheck.provider(ViewedAdvertsModule_ProvideViewedAdvertsPresenterFactory.create(this.c0, this.q));
        Provider<ClosedItemEventInteractor> provider55 = SingleCheck.provider(ClosedItemModule_ProvideClosedItemEventInteractorFactory.create());
        this.N4 = provider55;
        this.O4 = DoubleCheck.provider(ClosedItemModule_ProvideViewedAdvertsPresenterFactory.create(provider55, this.q));
        this.P4 = DoubleCheck.provider(ClosedItemModule_ProvideClosedItemInteractorFactory.create(this.N4));
        this.Q4 = SingleCheck.provider(this.M1);
        SetFactory build = SetFactory.builder(2, 0).addProvider(this.F1).addProvider(this.Q4).build();
        this.R4 = build;
        RichSnippetStateProviderProxy_Factory create63 = RichSnippetStateProviderProxy_Factory.create(build);
        this.S4 = create63;
        this.T4 = SingleCheck.provider(create63);
        SimpleClickStreamLinkHandler_Factory create64 = SimpleClickStreamLinkHandler_Factory.create(this.l);
        this.U4 = create64;
        this.V4 = DoubleCheck.provider(create64);
        this.W4 = new t(serpDependencies);
        this.X4 = DoubleCheck.provider(ShortcutNavigationItemConverterImpl_Factory.create());
        Factory createNullable5 = InstanceFactory.createNullable(kundle5);
        this.Y4 = createNullable5;
        InlineFiltersPresenterImpl_Factory create65 = InlineFiltersPresenterImpl_Factory.create(this.N0, this.X4, this.M3, this.q, this.l, this.I0, createNullable5);
        this.Z4 = create65;
        this.a5 = DoubleCheck.provider(create65);
        this.b5 = SerpItemSaturatorImpl_Factory.create(this.U, this.d0, this.P4);
        this.c5 = BannerViewFilter_Factory.create(this.A);
        Factory createNullable6 = InstanceFactory.createNullable(bundle2);
        this.d5 = createNullable6;
        this.e5 = DoubleCheck.provider(SerpModule_ProvideItemVisibilityTracker$serp_releaseFactory.create(this.c5, createNullable6));
        this.f5 = DoubleCheck.provider(DiffCalculator_Impl_Factory.create());
        Factory createNullable7 = InstanceFactory.createNullable(kundle8);
        this.g5 = createNullable7;
        SavedSearchesPresenterImpl_Factory create66 = SavedSearchesPresenterImpl_Factory.create(this.S0, this.q, this.X, this.l, createNullable7);
        this.h5 = create66;
        this.i5 = DoubleCheck.provider(create66);
        this.j5 = DoubleCheck.provider(SkeletonGenerator_Impl_Factory.create());
        this.k5 = new i0(serpDependencies);
        this.l5 = DoubleCheck.provider(SnippetScrollDepthTrackerImpl_Factory.create());
        SnippetScrollDepthAnalyticsInteractorImpl_Factory create67 = SnippetScrollDepthAnalyticsInteractorImpl_Factory.create(this.l);
        this.m5 = create67;
        this.n5 = DoubleCheck.provider(create67);
        this.o5 = InstanceFactory.createNullable(serpPresenterState);
        t0 t0Var = new t0(locationDependencies);
        this.p5 = t0Var;
        s0 s0Var = new s0(locationDependencies);
        this.q5 = s0Var;
        u0 u0Var = new u0(locationDependencies);
        this.r5 = u0Var;
        r0 r0Var = new r0(locationDependencies);
        this.s5 = r0Var;
        SavedLocationInteractorImpl_Factory create68 = SavedLocationInteractorImpl_Factory.create(t0Var, s0Var, u0Var, this.n, r0Var);
        this.t5 = create68;
        this.u5 = SingleCheck.provider(create68);
        SerpPresenterImpl_Factory create69 = SerpPresenterImpl_Factory.create(this.f, this.R0, this.S0, this.u4, this.x4, this.z4, this.l, this.y, this.A, this.C4, this.q, this.t0, this.D4, this.q0, this.E4, this.K4, this.L4, this.M4, this.O4, this.P4, this.n, this.y1, this.T4, PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory.create(), this.V4, this.O2, this.P2, this.Q2, this.W4, this.a5, this.b5, this.I0, this.e5, this.f5, this.i5, this.R3, this.j5, this.k5, this.A0, this.v1, this.l5, this.n5, this.d3, this.g, this.o5, this.u5);
        this.v5 = create69;
        DelegateFactory.setDelegate(this.T0, DoubleCheck.provider(create69));
        SpanLookup_Factory create70 = SpanLookup_Factory.create(this.D4);
        this.w5 = create70;
        this.x5 = SingleCheck.provider(create70);
        this.y5 = DoubleCheck.provider(SerpModule_ProvideDestroyableViewHolderBuilder$serp_releaseFactory.create(this.t4));
        this.z5 = SingleCheck.provider(ConnectionQualityInteractorModule_ProvideConnectionQualityNetworkListenerFactory.create(connectionQualityInteractorModule, this.J4));
        SetFactory build2 = SetFactory.builder(1, 0).addProvider(this.z5).build();
        this.A5 = build2;
        this.B5 = SingleCheck.provider(ConnectionQualityInteractorModule_ProvideNetworkInfoBroadcastReceiver$connection_quality_releaseFactory.create(connectionQualityInteractorModule, build2));
        InlineFilterDialogFactoryImpl_Factory create71 = InlineFilterDialogFactoryImpl_Factory.create(this.I2, this.K3, this.n);
        this.C5 = create71;
        this.D5 = DoubleCheck.provider(create71);
        Factory create72 = InstanceFactory.create(fragment);
        this.E5 = create72;
        this.F5 = DoubleCheck.provider(create72);
        k kVar = new k(serpDependencies);
        this.G5 = kVar;
        CartFabRepositoryImpl_Factory create73 = CartFabRepositoryImpl_Factory.create(kVar, this.q);
        this.H5 = create73;
        this.I5 = SingleCheck.provider(create73);
        CartFabPreferencesImpl_Factory create74 = CartFabPreferencesImpl_Factory.create(this.A0);
        this.J5 = create74;
        this.K5 = SingleCheck.provider(create74);
        SerpModule_ProvideSearchContextWrapper$serp_releaseFactory create75 = SerpModule_ProvideSearchContextWrapper$serp_releaseFactory.create(this.g);
        this.L5 = create75;
        c cVar = new c(create75);
        this.M5 = cVar;
        CartFabViewModelFactory_Factory create76 = CartFabViewModelFactory_Factory.create(this.n, this.I5, this.K5, this.X, this.q, this.l, cVar);
        this.N5 = create76;
        this.O5 = SingleCheck.provider(CartFabModule_ProvideCartFabViewModelFactory.create(this.F5, create76));
        this.P5 = SingleCheck.provider(CartFabQuantityVisibilityHandler_Factory.create());
    }

    public static SerpComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.di.component.SerpComponent
    public void inject(SerpFragment serpFragment) {
        SerpFragment_MembersInjector.injectPresenter(serpFragment, this.T0.get());
        SerpFragment_MembersInjector.injectResourcesProvider(serpFragment, SerpInteractorModule_ProvideResourcesProvider$serp_core_releaseFactory.provideResourcesProvider$serp_core_release(this.a));
        SerpFragment_MembersInjector.injectInteractor(serpFragment, this.R0.get());
        SerpFragment_MembersInjector.injectSupplier(serpFragment, new FpsStateSupplier(new FpsMetricsSupplier.Impl((Observable) Preconditions.checkNotNullFromComponent(this.b.frameStream()), (FpsMetricsTracker) Preconditions.checkNotNullFromComponent(this.b.fpsMetricsTracker()), this.c, this.b.fpsTrackingThreshold(), (Features) Preconditions.checkNotNullFromComponent(this.d.features())), (BuildInfo) Preconditions.checkNotNullFromComponent(this.d.buildInfo())));
        SerpFragment_MembersInjector.injectAnalyticsInteractor(serpFragment, this.y.get());
        SerpFragment_MembersInjector.injectFloatingViewsPresenter(serpFragment, this.x4.get());
        SerpFragment_MembersInjector.injectIntentFactory(serpFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.d.activityIntentFactory()));
        SerpFragment_MembersInjector.injectDeepLinkIntentFactory(serpFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.d.deepLinkIntentFactory()));
        SerpFragment_MembersInjector.injectAdapterPresenter(serpFragment, this.u4.get());
        SerpFragment_MembersInjector.injectSpanSizeLookup(serpFragment, this.x5.get());
        SerpFragment_MembersInjector.injectImplicitIntentFactory(serpFragment, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.d.implicitIntentFactory()));
        SerpFragment_MembersInjector.injectGridPositionProvider(serpFragment, this.q0.get());
        SerpFragment_MembersInjector.injectDestroyableViewHolderBuilder(serpFragment, this.y5.get());
        SerpFragment_MembersInjector.injectNetworkInfoBroadcastReceiver(serpFragment, this.B5.get());
        SerpFragment_MembersInjector.injectFavoriteAdvertsPresenter(serpFragment, this.L4.get());
        SerpFragment_MembersInjector.injectViewedAdvertsPresenter(serpFragment, this.M4.get());
        SerpFragment_MembersInjector.injectClosedItemPresenter(serpFragment, this.O4.get());
        SerpFragment_MembersInjector.injectBuildInfo(serpFragment, (BuildInfo) Preconditions.checkNotNullFromComponent(this.d.buildInfo()));
        SerpFragment_MembersInjector.injectAnalytics(serpFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.d.analytics()));
        SerpFragment_MembersInjector.injectItemVisibilityTracker(serpFragment, this.e5.get());
        SerpFragment_MembersInjector.injectFeatures(serpFragment, (Features) Preconditions.checkNotNullFromComponent(this.d.features()));
        SerpFragment_MembersInjector.injectSerpInteractor(serpFragment, this.R0.get());
        SerpFragment_MembersInjector.injectSchedulers(serpFragment, (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.d.schedulersFactory3()));
        SerpFragment_MembersInjector.injectAdvertXlStateProvider(serpFragment, this.y1.get());
        SerpFragment_MembersInjector.injectRichSnippetStateProvider(serpFragment, this.T4.get());
        SerpFragment_MembersInjector.injectMobileAdsWrapper(serpFragment, (DfpMobileAdsWrapper) Preconditions.checkNotNullFromComponent(this.d.dfpMobileAdsWrapper()));
        SerpFragment_MembersInjector.injectWarningStateProvider(serpFragment, SerpInteractorModule_ProvideWarningStateProvider$serp_core_releaseFactory.provideWarningStateProvider$serp_core_release(SerpInteractorModule_ProviderWarningStateStorage$serp_core_releaseFactory.providerWarningStateStorage$serp_core_release(), SerpInteractorModule_ProviderPermanentWarningStateStorage$serp_core_releaseFactory.providerPermanentWarningStateStorage$serp_core_release((Preferences) Preconditions.checkNotNullFromComponent(this.d.preferences())), this.e));
        SerpFragment_MembersInjector.injectNotificationManagerProvider(serpFragment, (NotificationManagerProvider) Preconditions.checkNotNullFromComponent(this.d.notificationManagerProvider()));
        SerpFragment_MembersInjector.injectTracker(serpFragment, this.I0.get());
        SerpFragment_MembersInjector.injectInlineFiltersPresenter(serpFragment, this.a5.get());
        SerpFragment_MembersInjector.injectInlineFilterDialogFactory(serpFragment, this.D5.get());
        SerpFragment_MembersInjector.injectWitcherItemPresenter(serpFragment, this.A3.get());
        SerpFragment_MembersInjector.injectVerticalFilterPresenter(serpFragment, this.R3.get());
        SerpFragment_MembersInjector.injectSavedSearchPresenter(serpFragment, this.i5.get());
        SerpFragment_MembersInjector.injectAsyncPhonePresenter(serpFragment, this.v1.get());
        SerpFragment_MembersInjector.injectSerpSkeletonTestGroup(serpFragment, (SerpSkeletonTestGroup) Preconditions.checkNotNullFromComponent(this.d.serpSkeletonTestGroup()));
        SerpFragment_MembersInjector.injectOnboardingHandler(serpFragment, this.Y0.get());
        SerpFragment_MembersInjector.injectCartFabViewModel(serpFragment, this.O5.get());
        SerpFragment_MembersInjector.injectCartFabQuantityHandler(serpFragment, this.P5.get());
    }
}
