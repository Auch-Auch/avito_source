package com.avito.android.di.module;

import a2.b.a.a.a;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelStoreOwner;
import com.avito.android.analytics.interactor.SnippetScrollDepthAnalyticsInteractor;
import com.avito.android.analytics.interactor.SnippetScrollDepthAnalyticsInteractorImpl;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.cart_fab.CartFabModule;
import com.avito.android.connection_quality.di.ConnectionQualityInteractorModule;
import com.avito.android.conveyor_shared_item.single_text.SingleTextItem;
import com.avito.android.conveyor_shared_item.single_text.SingleTextPresenter;
import com.avito.android.conveyor_shared_item.single_text.SingleTextPresenterImpl;
import com.avito.android.conveyor_shared_item.single_text.SingleTextView;
import com.avito.android.di.AdvertItemActionsModule;
import com.avito.android.di.CommercialBannersInteractorModule;
import com.avito.android.di.PerFragment;
import com.avito.android.di.component.HomeItemVisibilityTrackerState;
import com.avito.android.favorite.di.FavoriteItemModule;
import com.avito.android.floating_views.FloatingViewsPresenterImpl;
import com.avito.android.floating_views.PersistableFloatingViewsPresenter;
import com.avito.android.home.HomeAdapterListener;
import com.avito.android.home.HomeInteractor;
import com.avito.android.home.HomeInteractorImpl;
import com.avito.android.home.HomePresenter;
import com.avito.android.home.HomePresenterImpl;
import com.avito.android.home.HomePresenterResourcesProvider;
import com.avito.android.home.HomePresenterResourcesProviderImpl;
import com.avito.android.home.HomeSerpHeaderBluePrint;
import com.avito.android.home.analytics.HomeAnalyticsInteractor;
import com.avito.android.home.analytics.HomeAnalyticsInteractorImpl;
import com.avito.android.home.analytics.HomeTracker;
import com.avito.android.home.analytics.HomeTrackerImpl;
import com.avito.android.home.appending_item.di.AppendingEmptyModule;
import com.avito.android.home.appending_item.di.AppendingRetryModule;
import com.avito.android.home.appending_item.empty.AppendingEmptyItemBlueprint;
import com.avito.android.home.appending_item.loader.AppendingLargeLoaderItemBlueprint;
import com.avito.android.home.appending_item.loader.AppendingLoaderItemBlueprint;
import com.avito.android.home.appending_item.retry.AppendingLargeRetryItemBlueprint;
import com.avito.android.home.appending_item.retry.AppendingRetryItemBlueprint;
import com.avito.android.home.default_search_location.DefaultSearchLocationPermissionProvider;
import com.avito.android.home.default_search_location.DefaultSearchLocationPresenter;
import com.avito.android.home.tabs_item.SectionTabsItemBlueprint;
import com.avito.android.home.tabs_item.di.SectionTabsItemModule;
import com.avito.android.home.tabs_item.skeleton.SkeletonSectionTabsItemBlueprint;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.item_visibility_tracker.ItemVisibilityTrackerImpl;
import com.avito.android.item_visibility_tracker.filters.BannerViewFilter;
import com.avito.android.location.di.SavedLocationInteractorModule;
import com.avito.android.module.serp.adapter.ad.adfox.AdfoxSingleGridBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.DfpAppInstallSingleBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.DfpContentSingleGridBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.DfpUnifiedSingleGridBlueprint;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetAppInstallSingleBlueprint;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetContentSingleBlueprint;
import com.avito.android.module.serp.adapter.ad.yandex.app_install.YandexAppInstallSingleItemBlueprint;
import com.avito.android.module.serp.adapter.ad.yandex.content.YandexContentSingleGridBlueprint;
import com.avito.android.push.UpdateInstanceIdModule;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.base.DestroyableViewHolderBuilderImpl;
import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistry;
import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistryImpl;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenterImpl;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.SearchParamsConverterImpl;
import com.avito.android.remote.model.SuggestParamsConverter;
import com.avito.android.remote.model.SuggestParamsConverterImpl;
import com.avito.android.scroll_tracker.SnippetScrollDepthTracker;
import com.avito.android.scroll_tracker.SnippetScrollDepthTrackerImpl;
import com.avito.android.search.SearchDeepLinkInteractor;
import com.avito.android.search.SearchDeepLinkInteractorImpl;
import com.avito.android.section.di.SectionAdvertItemsModule;
import com.avito.android.serp.ad.AdResourceProvider;
import com.avito.android.serp.ad.HomeAdResourceProviderImpl;
import com.avito.android.serp.adapter.AdBannerEventListener;
import com.avito.android.serp.adapter.AdvertItemDoubleBlueprint;
import com.avito.android.serp.adapter.AdvertItemGridBlueprint;
import com.avito.android.serp.adapter.AdvertItemListener;
import com.avito.android.serp.adapter.ShortcutBannerBlueprint;
import com.avito.android.serp.adapter.ShortcutBannerItem;
import com.avito.android.serp.adapter.ShortcutBannerItemView;
import com.avito.android.serp.adapter.adstub.EmptyAdStubItemBlueprint;
import com.avito.android.serp.adapter.adstub.NotLoadAdStubGridBlueprint;
import com.avito.android.serp.adapter.location_notification.LocationNotificationItemBlueprint;
import com.avito.android.serp.adapter.location_notification.LocationNotificationItemPresenter;
import com.avito.android.serp.adapter.location_notification.LocationNotificationItemPresenterImpl;
import com.avito.android.serp.adapter.skeleton.di.SerpSkeletonModule;
import com.avito.android.serp.adapter.snippet.SnippetBlueprint;
import com.avito.android.serp.adapter.snippet.SnippetPresenter;
import com.avito.android.serp.adapter.witcher.WitcherItemBlueprint;
import com.avito.android.serp.adapter.witcher.WitcherItemListener;
import com.avito.android.stories.adapter.StoriesItemBlueprint;
import com.avito.android.stories.adapter.StoriesItemListener;
import com.avito.android.stories.di.StoriesModule;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.UrlParams;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.shortcut_navigation_bar.ShortcutNavigationItemConverter;
import ru.avito.component.shortcut_navigation_bar.ShortcutNavigationItemConverterImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001SB\t\b\u0002¢\u0006\u0004\bQ\u0010RJ\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00122\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0001¢\u0006\u0004\b\u0017\u0010\u0018Jê\u0001\u0010P\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u0002002\u0006\u00103\u001a\u0002022\u0006\u00105\u001a\u0002042\u0006\u00107\u001a\u0002062\u0006\u00109\u001a\u0002082\u0006\u0010;\u001a\u00020:2\u0006\u0010=\u001a\u00020<2\u0006\u0010?\u001a\u00020>2\u0006\u0010A\u001a\u00020@2\u0006\u0010C\u001a\u00020B2\u0006\u0010E\u001a\u00020D2\u0006\u0010G\u001a\u00020F2\u0006\u0010I\u001a\u00020H2\u0019\u0010M\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030K¢\u0006\u0002\bL0JH\u0001¢\u0006\u0004\bN\u0010O¨\u0006T"}, d2 = {"Lcom/avito/android/di/module/HomeModule;", "", "Lcom/avito/android/home/analytics/HomeAnalyticsInteractor;", "homeAnalyticsInteractor", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "provideSerpTreeParent$serp_release", "(Lcom/avito/android/home/analytics/HomeAnalyticsInteractor;)Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "provideSerpTreeParent", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "provideDestroyableViewHolderBuilder$serp_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "provideDestroyableViewHolderBuilder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter$serp_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "Lcom/avito/android/item_visibility_tracker/filters/BannerViewFilter;", "bannerViewFilter", "Landroid/os/Bundle;", "state", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "provideItemVisibilityTracker$serp_release", "(Lcom/avito/android/item_visibility_tracker/filters/BannerViewFilter;Landroid/os/Bundle;)Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "provideItemVisibilityTracker", "Lcom/avito/android/serp/adapter/AdvertItemGridBlueprint;", "advertItemGridBlueprint", "Lcom/avito/android/serp/adapter/AdvertItemDoubleBlueprint;", "advertItemDoubleBlueprint", "Lcom/avito/android/home/HomeSerpHeaderBluePrint;", "homeSerpHeaderBluePrint", "Lcom/avito/android/module/serp/adapter/ad/yandex/content/YandexContentSingleGridBlueprint;", "yandexContentSingleGridBlueprint", "Lcom/avito/android/module/serp/adapter/ad/yandex/app_install/YandexAppInstallSingleItemBlueprint;", "yandexAppInstallSingleItemBlueprint", "Lcom/avito/android/module/serp/adapter/ad/adfox/AdfoxSingleGridBlueprint;", "adfoxSingleGridBlueprint", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpUnifiedSingleGridBlueprint;", "dfpUnifiedSingleGridBlueprint", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpContentSingleGridBlueprint;", "dfpContentSingleGridBlueprint", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpAppInstallSingleBlueprint;", "dfpAppInstallSingleBlueprint", "Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetContentSingleBlueprint;", "myTargetContentSingleBlueprint", "Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetAppInstallSingleBlueprint;", "myTargetAppInstallSingleBlueprint", "Lcom/avito/android/serp/adapter/adstub/NotLoadAdStubGridBlueprint;", "notLoadAdStubGridBlueprint", "Lcom/avito/android/serp/adapter/adstub/EmptyAdStubItemBlueprint;", "emptyAdStubItemBlueprint", "Lcom/avito/android/home/appending_item/loader/AppendingLoaderItemBlueprint;", "appendingLoaderItemBlueprint", "Lcom/avito/android/home/appending_item/loader/AppendingLargeLoaderItemBlueprint;", "appendingLargeLoaderItemBlueprint", "Lcom/avito/android/home/appending_item/retry/AppendingRetryItemBlueprint;", "appendingRetryItemBlueprint", "Lcom/avito/android/home/appending_item/retry/AppendingLargeRetryItemBlueprint;", "appendingLargeRetryItemBlueprint", "Lcom/avito/android/home/appending_item/empty/AppendingEmptyItemBlueprint;", "appendingEmptyItemBlueprint", "Lcom/avito/android/home/tabs_item/SectionTabsItemBlueprint;", "sectionTabsItemBlueprint", "Lcom/avito/android/home/tabs_item/skeleton/SkeletonSectionTabsItemBlueprint;", "skeletonSectionTabsItemBlueprint", "Lcom/avito/android/serp/adapter/snippet/SnippetBlueprint;", "snippetBlueprint", "Lcom/avito/android/stories/adapter/StoriesItemBlueprint;", "storiesBlueprint", "Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItemBlueprint;", "locationNotificationBlueprint", "Lcom/avito/android/serp/adapter/witcher/WitcherItemBlueprint;", "witcherItemBlueprint", "", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lkotlin/jvm/JvmSuppressWildcards;", "blueprints", "provideItemBinder$serp_release", "(Lcom/avito/android/serp/adapter/AdvertItemGridBlueprint;Lcom/avito/android/serp/adapter/AdvertItemDoubleBlueprint;Lcom/avito/android/home/HomeSerpHeaderBluePrint;Lcom/avito/android/module/serp/adapter/ad/yandex/content/YandexContentSingleGridBlueprint;Lcom/avito/android/module/serp/adapter/ad/yandex/app_install/YandexAppInstallSingleItemBlueprint;Lcom/avito/android/module/serp/adapter/ad/adfox/AdfoxSingleGridBlueprint;Lcom/avito/android/module/serp/adapter/ad/dfp/DfpUnifiedSingleGridBlueprint;Lcom/avito/android/module/serp/adapter/ad/dfp/DfpContentSingleGridBlueprint;Lcom/avito/android/module/serp/adapter/ad/dfp/DfpAppInstallSingleBlueprint;Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetContentSingleBlueprint;Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetAppInstallSingleBlueprint;Lcom/avito/android/serp/adapter/adstub/NotLoadAdStubGridBlueprint;Lcom/avito/android/serp/adapter/adstub/EmptyAdStubItemBlueprint;Lcom/avito/android/home/appending_item/loader/AppendingLoaderItemBlueprint;Lcom/avito/android/home/appending_item/loader/AppendingLargeLoaderItemBlueprint;Lcom/avito/android/home/appending_item/retry/AppendingRetryItemBlueprint;Lcom/avito/android/home/appending_item/retry/AppendingLargeRetryItemBlueprint;Lcom/avito/android/home/appending_item/empty/AppendingEmptyItemBlueprint;Lcom/avito/android/home/tabs_item/SectionTabsItemBlueprint;Lcom/avito/android/home/tabs_item/skeleton/SkeletonSectionTabsItemBlueprint;Lcom/avito/android/serp/adapter/snippet/SnippetBlueprint;Lcom/avito/android/stories/adapter/StoriesItemBlueprint;Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItemBlueprint;Lcom/avito/android/serp/adapter/witcher/WitcherItemBlueprint;Ljava/util/Set;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "<init>", "()V", "Dependencies", "serp_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdsItemModule.class, AdvertItemActionsModule.class, AdvertItemModule.class, AppendingEmptyModule.class, AppendingLoaderModule.class, AppendingRetryModule.class, ConnectionQualityInteractorModule.class, UpdateInstanceIdModule.class, DefaultSearchLocationModule.class, FavoriteAdvertsPresenterModule.class, FavoriteItemModule.class, SavedLocationInteractorModule.class, SectionAdvertItemsModule.class, SectionTabsItemModule.class, SavedLocationInteractorModule.class, CommercialBannersInteractorModule.class, SerpSkeletonModule.class, SerpItemConverterModule.class, SpanAdapterModule.class, StoriesModule.class, WitcherModule.class, Dependencies.class, CartFabModule.class})
public final class HomeModule {
    @NotNull
    public static final HomeModule INSTANCE = new HomeModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000ä\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0010H'¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H'¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H'¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u001eH'¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020#2\u0006\u0010\u0015\u001a\u00020\"H'¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020'2\u0006\u0010\u0015\u001a\u00020&H'¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020*2\u0006\u0010\u0003\u001a\u00020\u0004H'¢\u0006\u0004\b+\u0010,J\u0017\u0010/\u001a\u00020.2\u0006\u0010-\u001a\u00020\u0004H'¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u0002012\u0006\u0010\u0003\u001a\u00020\u0004H'¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u0002042\u0006\u0010\u0003\u001a\u00020\u0004H'¢\u0006\u0004\b5\u00106J\u0017\u00108\u001a\u0002072\u0006\u0010\u0003\u001a\u00020\u0004H'¢\u0006\u0004\b8\u00109J\u0017\u0010<\u001a\u00020;2\u0006\u0010\u0003\u001a\u00020:H'¢\u0006\u0004\b<\u0010=J\u0017\u0010@\u001a\u00020?2\u0006\u0010\u0003\u001a\u00020>H'¢\u0006\u0004\b@\u0010AJ#\u0010G\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020F0D2\u0006\u0010C\u001a\u00020BH'¢\u0006\u0004\bG\u0010HJ#\u0010L\u001a\u000e\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020K0D2\u0006\u0010C\u001a\u00020IH'¢\u0006\u0004\bL\u0010MJ\u0017\u0010Q\u001a\u00020P2\u0006\u0010O\u001a\u00020NH'¢\u0006\u0004\bQ\u0010RJ\u0017\u0010U\u001a\u00020T2\u0006\u0010\b\u001a\u00020SH'¢\u0006\u0004\bU\u0010VJ\u0017\u0010Y\u001a\u00020X2\u0006\u0010\b\u001a\u00020WH'¢\u0006\u0004\bY\u0010ZJ\u0017\u0010^\u001a\u00020]2\u0006\u0010\\\u001a\u00020[H'¢\u0006\u0004\b^\u0010_J\u0017\u0010c\u001a\u00020b2\u0006\u0010a\u001a\u00020`H'¢\u0006\u0004\bc\u0010dJ\u0017\u0010g\u001a\u00020f2\u0006\u0010a\u001a\u00020eH'¢\u0006\u0004\bg\u0010hJ\u0017\u0010k\u001a\u00020j2\u0006\u0010\u0003\u001a\u00020iH'¢\u0006\u0004\bk\u0010lJ\u0017\u0010o\u001a\u00020n2\u0006\u0010\u0003\u001a\u00020mH'¢\u0006\u0004\bo\u0010pJ\u0017\u0010t\u001a\u00020s2\u0006\u0010r\u001a\u00020qH'¢\u0006\u0004\bt\u0010uJ\u0017\u0010y\u001a\u00020x2\u0006\u0010w\u001a\u00020vH'¢\u0006\u0004\by\u0010z¨\u0006{"}, d2 = {"Lcom/avito/android/di/module/HomeModule$Dependencies;", "", "Lcom/avito/android/home/HomePresenterImpl;", "presenter", "Lcom/avito/android/home/HomePresenter;", "bindHomePresenter", "(Lcom/avito/android/home/HomePresenterImpl;)Lcom/avito/android/home/HomePresenter;", "Lcom/avito/android/search/SearchDeepLinkInteractorImpl;", "interactor", "Lcom/avito/android/search/SearchDeepLinkInteractor;", "bindsSearchDeepLinkInteractor", "(Lcom/avito/android/search/SearchDeepLinkInteractorImpl;)Lcom/avito/android/search/SearchDeepLinkInteractor;", "Lcom/avito/android/home/default_search_location/DefaultSearchLocationPresenter;", "Lcom/avito/android/home/default_search_location/DefaultSearchLocationPermissionProvider;", "bindDefaultSearchLocationNotificationItemProvider", "(Lcom/avito/android/home/default_search_location/DefaultSearchLocationPresenter;)Lcom/avito/android/home/default_search_location/DefaultSearchLocationPermissionProvider;", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenterImpl;", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "bindResponsiveAdapterPresenter", "(Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenterImpl;)Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationItemConverterImpl;", "converter", "Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationItemConverter;", "bindActionItemConverter", "(Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationItemConverterImpl;)Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationItemConverter;", "Lcom/avito/android/util/ErrorFormatterImpl;", "formatter", "Lcom/avito/android/util/ErrorFormatter;", "bindErrorFormatter", "(Lcom/avito/android/util/ErrorFormatterImpl;)Lcom/avito/android/util/ErrorFormatter;", "Lcom/avito/android/floating_views/FloatingViewsPresenterImpl;", "Lcom/avito/android/floating_views/PersistableFloatingViewsPresenter;", "bindPersistableFloatingViewsPresenter", "(Lcom/avito/android/floating_views/FloatingViewsPresenterImpl;)Lcom/avito/android/floating_views/PersistableFloatingViewsPresenter;", "Lcom/avito/android/remote/model/SearchParamsConverterImpl;", "Lcom/avito/android/remote/model/SearchParamsConverter;", "bindSearchParamsConverter", "(Lcom/avito/android/remote/model/SearchParamsConverterImpl;)Lcom/avito/android/remote/model/SearchParamsConverter;", "Lcom/avito/android/remote/model/SuggestParamsConverterImpl;", "Lcom/avito/android/remote/model/SuggestParamsConverter;", "bindSuggestParamsConverter", "(Lcom/avito/android/remote/model/SuggestParamsConverterImpl;)Lcom/avito/android/remote/model/SuggestParamsConverter;", "Lcom/avito/android/home/HomeAdapterListener;", "bindHomeAdapterListener", "(Lcom/avito/android/home/HomePresenter;)Lcom/avito/android/home/HomeAdapterListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/serp/adapter/witcher/WitcherItemListener;", "bindWitcherItemListener", "(Lcom/avito/android/home/HomePresenter;)Lcom/avito/android/serp/adapter/witcher/WitcherItemListener;", "Lcom/avito/android/serp/adapter/AdvertItemListener;", "bindAdvertItemListener", "(Lcom/avito/android/home/HomePresenter;)Lcom/avito/android/serp/adapter/AdvertItemListener;", "Lcom/avito/android/serp/adapter/AdBannerEventListener;", "bindAdBannerEventListener", "(Lcom/avito/android/home/HomePresenter;)Lcom/avito/android/serp/adapter/AdBannerEventListener;", "Lcom/avito/android/stories/adapter/StoriesItemListener;", "bindStoriesListener", "(Lcom/avito/android/home/HomePresenter;)Lcom/avito/android/stories/adapter/StoriesItemListener;", "Lcom/avito/android/home/HomePresenterResourcesProviderImpl;", "Lcom/avito/android/home/HomePresenterResourcesProvider;", "bindHomePresenterResourcesProvider", "(Lcom/avito/android/home/HomePresenterResourcesProviderImpl;)Lcom/avito/android/home/HomePresenterResourcesProvider;", "Lcom/avito/android/conveyor_shared_item/single_text/SingleTextPresenterImpl;", "Lcom/avito/android/conveyor_shared_item/single_text/SingleTextPresenter;", "bindSingleTextPresenter", "(Lcom/avito/android/conveyor_shared_item/single_text/SingleTextPresenterImpl;)Lcom/avito/android/conveyor_shared_item/single_text/SingleTextPresenter;", "Lcom/avito/android/home/HomeSerpHeaderBluePrint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/conveyor_shared_item/single_text/SingleTextView;", "Lcom/avito/android/conveyor_shared_item/single_text/SingleTextItem;", "bindHomeSerpHeaderBluePrint", "(Lcom/avito/android/home/HomeSerpHeaderBluePrint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/serp/adapter/ShortcutBannerBlueprint;", "Lcom/avito/android/serp/adapter/ShortcutBannerItemView;", "Lcom/avito/android/serp/adapter/ShortcutBannerItem;", "bindShortcutBannerBlueprint", "(Lcom/avito/android/serp/adapter/ShortcutBannerBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistryImpl;", "registry", "Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;", "bindsCallableResponsiveItemPresenterRegistry", "(Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistryImpl;)Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;", "Lcom/avito/android/home/analytics/HomeAnalyticsInteractorImpl;", "Lcom/avito/android/home/analytics/HomeAnalyticsInteractor;", "bindsHomeAnalyticsInteractor", "(Lcom/avito/android/home/analytics/HomeAnalyticsInteractorImpl;)Lcom/avito/android/home/analytics/HomeAnalyticsInteractor;", "Lcom/avito/android/analytics/interactor/SnippetScrollDepthAnalyticsInteractorImpl;", "Lcom/avito/android/analytics/interactor/SnippetScrollDepthAnalyticsInteractor;", "bindsSnippetScrollDepthAnalyticsInteractor", "(Lcom/avito/android/analytics/interactor/SnippetScrollDepthAnalyticsInteractorImpl;)Lcom/avito/android/analytics/interactor/SnippetScrollDepthAnalyticsInteractor;", "Lcom/avito/android/home/analytics/HomeTrackerImpl;", "tracker", "Lcom/avito/android/home/analytics/HomeTracker;", "bindsSerpTracker", "(Lcom/avito/android/home/analytics/HomeTrackerImpl;)Lcom/avito/android/home/analytics/HomeTracker;", "Lcom/avito/android/serp/ad/HomeAdResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/serp/ad/AdResourceProvider;", "bindAdResourceProvider", "(Lcom/avito/android/serp/ad/HomeAdResourceProviderImpl;)Lcom/avito/android/serp/ad/AdResourceProvider;", "Lcom/avito/android/home/HomeInteractorImpl;", "Lcom/avito/android/home/HomeInteractor;", "bindHomeInteractor", "(Lcom/avito/android/home/HomeInteractorImpl;)Lcom/avito/android/home/HomeInteractor;", "Lcom/avito/android/serp/adapter/snippet/SnippetPresenter$Impl;", "Lcom/avito/android/serp/adapter/snippet/SnippetPresenter;", "bindSnippetPresenter", "(Lcom/avito/android/serp/adapter/snippet/SnippetPresenter$Impl;)Lcom/avito/android/serp/adapter/snippet/SnippetPresenter;", "Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItemPresenterImpl;", "Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItemPresenter;", "bindLocationNotificationPresenter", "(Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItemPresenterImpl;)Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItemPresenter;", "Landroidx/fragment/app/Fragment;", UrlParams.OWNER, "Landroidx/lifecycle/ViewModelStoreOwner;", "bindViewModelStoreOwner", "(Landroidx/fragment/app/Fragment;)Landroidx/lifecycle/ViewModelStoreOwner;", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthTrackerImpl;", "userScrollTracker", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker;", "bindUserScrollTracker", "(Lcom/avito/android/scroll_tracker/SnippetScrollDepthTrackerImpl;)Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker;", "serp_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerFragment
        @Binds
        @NotNull
        ShortcutNavigationItemConverter bindActionItemConverter(@NotNull ShortcutNavigationItemConverterImpl shortcutNavigationItemConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        AdBannerEventListener bindAdBannerEventListener(@NotNull HomePresenter homePresenter);

        @PerFragment
        @Binds
        @NotNull
        AdResourceProvider bindAdResourceProvider(@NotNull HomeAdResourceProviderImpl homeAdResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        AdvertItemListener bindAdvertItemListener(@NotNull HomePresenter homePresenter);

        @PerFragment
        @Binds
        @NotNull
        DefaultSearchLocationPermissionProvider bindDefaultSearchLocationNotificationItemProvider(@NotNull DefaultSearchLocationPresenter defaultSearchLocationPresenter);

        @PerFragment
        @Binds
        @NotNull
        ErrorFormatter bindErrorFormatter(@NotNull ErrorFormatterImpl errorFormatterImpl);

        @PerFragment
        @Binds
        @NotNull
        HomeAdapterListener bindHomeAdapterListener(@NotNull HomePresenter homePresenter);

        @PerFragment
        @Binds
        @NotNull
        HomeInteractor bindHomeInteractor(@NotNull HomeInteractorImpl homeInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        HomePresenter bindHomePresenter(@NotNull HomePresenterImpl homePresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        HomePresenterResourcesProvider bindHomePresenterResourcesProvider(@NotNull HomePresenterResourcesProviderImpl homePresenterResourcesProviderImpl);

        @Binds
        @NotNull
        @PerFragment
        ItemBlueprint<SingleTextView, SingleTextItem> bindHomeSerpHeaderBluePrint(@NotNull HomeSerpHeaderBluePrint homeSerpHeaderBluePrint);

        @PerFragment
        @Binds
        @NotNull
        LocationNotificationItemPresenter bindLocationNotificationPresenter(@NotNull LocationNotificationItemPresenterImpl locationNotificationItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        PersistableFloatingViewsPresenter bindPersistableFloatingViewsPresenter(@NotNull FloatingViewsPresenterImpl floatingViewsPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        ResponsiveAdapterPresenter bindResponsiveAdapterPresenter(@NotNull ResponsiveAdapterPresenterImpl responsiveAdapterPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        SearchParamsConverter bindSearchParamsConverter(@NotNull SearchParamsConverterImpl searchParamsConverterImpl);

        @Binds
        @NotNull
        @PerFragment
        ItemBlueprint<ShortcutBannerItemView, ShortcutBannerItem> bindShortcutBannerBlueprint(@NotNull ShortcutBannerBlueprint shortcutBannerBlueprint);

        @PerFragment
        @Binds
        @NotNull
        SingleTextPresenter bindSingleTextPresenter(@NotNull SingleTextPresenterImpl singleTextPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        SnippetPresenter bindSnippetPresenter(@NotNull SnippetPresenter.Impl impl);

        @PerFragment
        @Binds
        @NotNull
        StoriesItemListener bindStoriesListener(@NotNull HomePresenter homePresenter);

        @PerFragment
        @Binds
        @NotNull
        SuggestParamsConverter bindSuggestParamsConverter(@NotNull SuggestParamsConverterImpl suggestParamsConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        SnippetScrollDepthTracker bindUserScrollTracker(@NotNull SnippetScrollDepthTrackerImpl snippetScrollDepthTrackerImpl);

        @PerFragment
        @Binds
        @NotNull
        ViewModelStoreOwner bindViewModelStoreOwner(@NotNull Fragment fragment);

        @PerFragment
        @Binds
        @NotNull
        WitcherItemListener bindWitcherItemListener(@NotNull HomePresenter homePresenter);

        @PerFragment
        @Binds
        @NotNull
        CallableResponsiveItemPresenterRegistry bindsCallableResponsiveItemPresenterRegistry(@NotNull CallableResponsiveItemPresenterRegistryImpl callableResponsiveItemPresenterRegistryImpl);

        @PerFragment
        @Binds
        @NotNull
        HomeAnalyticsInteractor bindsHomeAnalyticsInteractor(@NotNull HomeAnalyticsInteractorImpl homeAnalyticsInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        SearchDeepLinkInteractor bindsSearchDeepLinkInteractor(@NotNull SearchDeepLinkInteractorImpl searchDeepLinkInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        HomeTracker bindsSerpTracker(@NotNull HomeTrackerImpl homeTrackerImpl);

        @PerFragment
        @Binds
        @NotNull
        SnippetScrollDepthAnalyticsInteractor bindsSnippetScrollDepthAnalyticsInteractor(@NotNull SnippetScrollDepthAnalyticsInteractorImpl snippetScrollDepthAnalyticsInteractorImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final AdapterPresenter provideAdapterPresenter$serp_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DestroyableViewHolderBuilder provideDestroyableViewHolderBuilder$serp_release(@NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        return new DestroyableViewHolderBuilderImpl(itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemBinder provideItemBinder$serp_release(@NotNull AdvertItemGridBlueprint advertItemGridBlueprint, @NotNull AdvertItemDoubleBlueprint advertItemDoubleBlueprint, @NotNull HomeSerpHeaderBluePrint homeSerpHeaderBluePrint, @NotNull YandexContentSingleGridBlueprint yandexContentSingleGridBlueprint, @NotNull YandexAppInstallSingleItemBlueprint yandexAppInstallSingleItemBlueprint, @NotNull AdfoxSingleGridBlueprint adfoxSingleGridBlueprint, @NotNull DfpUnifiedSingleGridBlueprint dfpUnifiedSingleGridBlueprint, @NotNull DfpContentSingleGridBlueprint dfpContentSingleGridBlueprint, @NotNull DfpAppInstallSingleBlueprint dfpAppInstallSingleBlueprint, @NotNull MyTargetContentSingleBlueprint myTargetContentSingleBlueprint, @NotNull MyTargetAppInstallSingleBlueprint myTargetAppInstallSingleBlueprint, @NotNull NotLoadAdStubGridBlueprint notLoadAdStubGridBlueprint, @NotNull EmptyAdStubItemBlueprint emptyAdStubItemBlueprint, @NotNull AppendingLoaderItemBlueprint appendingLoaderItemBlueprint, @NotNull AppendingLargeLoaderItemBlueprint appendingLargeLoaderItemBlueprint, @NotNull AppendingRetryItemBlueprint appendingRetryItemBlueprint, @NotNull AppendingLargeRetryItemBlueprint appendingLargeRetryItemBlueprint, @NotNull AppendingEmptyItemBlueprint appendingEmptyItemBlueprint, @NotNull SectionTabsItemBlueprint sectionTabsItemBlueprint, @NotNull SkeletonSectionTabsItemBlueprint skeletonSectionTabsItemBlueprint, @NotNull SnippetBlueprint snippetBlueprint, @NotNull StoriesItemBlueprint storiesItemBlueprint, @NotNull LocationNotificationItemBlueprint locationNotificationItemBlueprint, @NotNull WitcherItemBlueprint witcherItemBlueprint, @NotNull Set<ItemBlueprint<?, ?>> set) {
        Intrinsics.checkNotNullParameter(advertItemGridBlueprint, "advertItemGridBlueprint");
        Intrinsics.checkNotNullParameter(advertItemDoubleBlueprint, "advertItemDoubleBlueprint");
        Intrinsics.checkNotNullParameter(homeSerpHeaderBluePrint, "homeSerpHeaderBluePrint");
        Intrinsics.checkNotNullParameter(yandexContentSingleGridBlueprint, "yandexContentSingleGridBlueprint");
        Intrinsics.checkNotNullParameter(yandexAppInstallSingleItemBlueprint, "yandexAppInstallSingleItemBlueprint");
        Intrinsics.checkNotNullParameter(adfoxSingleGridBlueprint, "adfoxSingleGridBlueprint");
        Intrinsics.checkNotNullParameter(dfpUnifiedSingleGridBlueprint, "dfpUnifiedSingleGridBlueprint");
        Intrinsics.checkNotNullParameter(dfpContentSingleGridBlueprint, "dfpContentSingleGridBlueprint");
        Intrinsics.checkNotNullParameter(dfpAppInstallSingleBlueprint, "dfpAppInstallSingleBlueprint");
        Intrinsics.checkNotNullParameter(myTargetContentSingleBlueprint, "myTargetContentSingleBlueprint");
        Intrinsics.checkNotNullParameter(myTargetAppInstallSingleBlueprint, "myTargetAppInstallSingleBlueprint");
        Intrinsics.checkNotNullParameter(notLoadAdStubGridBlueprint, "notLoadAdStubGridBlueprint");
        Intrinsics.checkNotNullParameter(emptyAdStubItemBlueprint, "emptyAdStubItemBlueprint");
        Intrinsics.checkNotNullParameter(appendingLoaderItemBlueprint, "appendingLoaderItemBlueprint");
        Intrinsics.checkNotNullParameter(appendingLargeLoaderItemBlueprint, "appendingLargeLoaderItemBlueprint");
        Intrinsics.checkNotNullParameter(appendingRetryItemBlueprint, "appendingRetryItemBlueprint");
        Intrinsics.checkNotNullParameter(appendingLargeRetryItemBlueprint, "appendingLargeRetryItemBlueprint");
        Intrinsics.checkNotNullParameter(appendingEmptyItemBlueprint, "appendingEmptyItemBlueprint");
        Intrinsics.checkNotNullParameter(sectionTabsItemBlueprint, "sectionTabsItemBlueprint");
        Intrinsics.checkNotNullParameter(skeletonSectionTabsItemBlueprint, "skeletonSectionTabsItemBlueprint");
        Intrinsics.checkNotNullParameter(snippetBlueprint, "snippetBlueprint");
        Intrinsics.checkNotNullParameter(storiesItemBlueprint, "storiesBlueprint");
        Intrinsics.checkNotNullParameter(locationNotificationItemBlueprint, "locationNotificationBlueprint");
        Intrinsics.checkNotNullParameter(witcherItemBlueprint, "witcherItemBlueprint");
        Intrinsics.checkNotNullParameter(set, "blueprints");
        ItemBinder.Builder registerItem = new ItemBinder.Builder().registerItem(advertItemGridBlueprint).registerItem(advertItemDoubleBlueprint).registerItem(homeSerpHeaderBluePrint).registerItem(yandexContentSingleGridBlueprint).registerItem(yandexAppInstallSingleItemBlueprint).registerItem(adfoxSingleGridBlueprint).registerItem(dfpUnifiedSingleGridBlueprint).registerItem(dfpContentSingleGridBlueprint).registerItem(dfpAppInstallSingleBlueprint).registerItem(myTargetContentSingleBlueprint).registerItem(myTargetAppInstallSingleBlueprint).registerItem(notLoadAdStubGridBlueprint).registerItem(emptyAdStubItemBlueprint).registerItem(appendingLoaderItemBlueprint).registerItem(appendingLargeLoaderItemBlueprint).registerItem(appendingRetryItemBlueprint).registerItem(appendingLargeRetryItemBlueprint).registerItem(appendingEmptyItemBlueprint).registerItem(sectionTabsItemBlueprint).registerItem(skeletonSectionTabsItemBlueprint).registerItem(snippetBlueprint).registerItem(storiesItemBlueprint).registerItem(witcherItemBlueprint).registerItem(locationNotificationItemBlueprint);
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            registerItem.registerItem(it.next());
        }
        return registerItem.build();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemVisibilityTracker provideItemVisibilityTracker$serp_release(@NotNull BannerViewFilter bannerViewFilter, @HomeItemVisibilityTrackerState @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(bannerViewFilter, "bannerViewFilter");
        return new ItemVisibilityTrackerImpl.Builder(true, bundle).addFilter(bannerViewFilter).build();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final TreeClickStreamParent provideSerpTreeParent$serp_release(@NotNull HomeAnalyticsInteractor homeAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(homeAnalyticsInteractor, "homeAnalyticsInteractor");
        return homeAnalyticsInteractor.getParent();
    }
}
