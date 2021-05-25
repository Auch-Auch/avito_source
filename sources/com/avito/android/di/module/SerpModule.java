package com.avito.android.di.module;

import a2.b.a.a.a;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelStoreOwner;
import com.avito.android.Features;
import com.avito.android.ab_tests.groups.ViewedItemsTabTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.advert_core.messenger.AdvertMessengerInteractor;
import com.avito.android.advert_core.messenger.AdvertMessengerInteractorImpl;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.interactor.SnippetScrollDepthAnalyticsInteractor;
import com.avito.android.analytics.interactor.SnippetScrollDepthAnalyticsInteractorImpl;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.async_phone.AsyncPhoneAuthRouter;
import com.avito.android.cart_fab.CartFabModule;
import com.avito.android.connection_quality.di.ConnectionQualityInteractorModule;
import com.avito.android.conveyor_shared_item.single_text.SingleTextItem;
import com.avito.android.conveyor_shared_item.single_text.SingleTextPresenter;
import com.avito.android.conveyor_shared_item.single_text.SingleTextPresenterImpl;
import com.avito.android.conveyor_shared_item.single_text.SingleTextView;
import com.avito.android.deep_linking.ClickStreamLinkHandler;
import com.avito.android.deep_linking.SimpleClickStreamLinkHandler;
import com.avito.android.di.PerFragment;
import com.avito.android.di.ViewedAdvertsModule;
import com.avito.android.favorite.di.FavoriteItemModule;
import com.avito.android.floating_views.FloatingViewsPresenterImpl;
import com.avito.android.floating_views.PersistableFloatingViewsPresenter;
import com.avito.android.home.HomeSerpHeaderBluePrint;
import com.avito.android.home.appending_item.di.AppendingRetryModule;
import com.avito.android.home.appending_item.loader.AppendingLoaderItemBlueprint;
import com.avito.android.home.appending_item.retry.AppendingRetryItemBlueprint;
import com.avito.android.inline_filters.di.InlineFiltersModule;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.item_visibility_tracker.ItemVisibilityTrackerImpl;
import com.avito.android.item_visibility_tracker.filters.BannerViewFilter;
import com.avito.android.location.di.SavedLocationInteractorModule;
import com.avito.android.module.serp.adapter.ad.adfox.AdfoxSingleGridBlueprint;
import com.avito.android.module.serp.adapter.ad.adfox.AdfoxSingleListBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.DfpAppInstallDoubleBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.DfpAppInstallListBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.DfpAppInstallSingleBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.DfpContentDoubleGridBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.DfpContentListBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.DfpContentSingleGridBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.DfpUnifiedDoubleBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.DfpUnifiedListBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.DfpUnifiedSingleGridBlueprint;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetAppInstallBlueprint;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetAppInstallListBlueprint;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetAppInstallSingleBlueprint;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetContentBlueprint;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetContentListBlueprint;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetContentSingleBlueprint;
import com.avito.android.module.serp.adapter.ad.yandex.app_install.YandexAppInstallDoubleItemBlueprint;
import com.avito.android.module.serp.adapter.ad.yandex.app_install.YandexAppInstallListItemBlueprint;
import com.avito.android.module.serp.adapter.ad.yandex.app_install.YandexAppInstallSingleItemBlueprint;
import com.avito.android.module.serp.adapter.ad.yandex.content.YandexContentDoubleGridBlueprint;
import com.avito.android.module.serp.adapter.ad.yandex.content.YandexContentListBlueprint;
import com.avito.android.module.serp.adapter.ad.yandex.content.YandexContentSingleGridBlueprint;
import com.avito.android.push.UpdateInstanceIdModule;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.base.DestroyableViewHolderBuilderImpl;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.SearchParamsConverterImpl;
import com.avito.android.saved_searches.di.SavedSearchesModule;
import com.avito.android.scroll_tracker.SnippetScrollDepthTracker;
import com.avito.android.scroll_tracker.SnippetScrollDepthTrackerImpl;
import com.avito.android.serp.SerpArguments;
import com.avito.android.serp.SerpInteractor;
import com.avito.android.serp.SerpInteractorImpl;
import com.avito.android.serp.SerpPresenter;
import com.avito.android.serp.SerpPresenterImpl;
import com.avito.android.serp.ad.AdResourceProvider;
import com.avito.android.serp.ad.AdResourceProviderImpl;
import com.avito.android.serp.adapter.AdBannerEventListener;
import com.avito.android.serp.adapter.AdvertItemDoubleBlueprint;
import com.avito.android.serp.adapter.AdvertItemGridBlueprint;
import com.avito.android.serp.adapter.AdvertItemListBlueprint;
import com.avito.android.serp.adapter.AdvertItemListener;
import com.avito.android.serp.adapter.OnCloseItemListener;
import com.avito.android.serp.adapter.SerpAdapterListener;
import com.avito.android.serp.adapter.ShortcutBannerBlueprint;
import com.avito.android.serp.adapter.ShortcutBannerItemListener;
import com.avito.android.serp.adapter.adstub.EmptyAdStubItemBlueprint;
import com.avito.android.serp.adapter.adstub.NotLoadAdRichStubBlueprint;
import com.avito.android.serp.adapter.adstub.NotLoadAdStubGridBlueprint;
import com.avito.android.serp.adapter.adstub.NotLoadAdStubListBlueprint;
import com.avito.android.serp.adapter.advert_xl.AdvertXlItemBlueprint;
import com.avito.android.serp.adapter.advert_xl.AdvertXlItemListener;
import com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemBlueprint;
import com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemListener;
import com.avito.android.serp.adapter.empty_search.EmptySearchItem;
import com.avito.android.serp.adapter.empty_search.EmptySearchItemBlueprint;
import com.avito.android.serp.adapter.empty_search.EmptySearchItemPresenter;
import com.avito.android.serp.adapter.empty_search.EmptySearchItemPresenterImpl;
import com.avito.android.serp.adapter.empty_search.EmptySearchItemView;
import com.avito.android.serp.adapter.map_banner.MapBannerItemBlueprint;
import com.avito.android.serp.adapter.map_banner.MapBannerItemListener;
import com.avito.android.serp.adapter.onboarding.di.SerpOnboardingModule;
import com.avito.android.serp.adapter.promo_card.PromoCardBlueprint;
import com.avito.android.serp.adapter.promo_card.PromoCardItemPresenter;
import com.avito.android.serp.adapter.rich_snippets.AdvertRichItemListener;
import com.avito.android.serp.adapter.rich_snippets.YandexAppInstallRichBlueprint;
import com.avito.android.serp.adapter.rich_snippets.YandexContentRichBlueprint;
import com.avito.android.serp.adapter.rich_snippets.job.AdvertRichJobItemBlueprint;
import com.avito.android.serp.adapter.rich_snippets.job.AdvertVipRichJobItemBlueprint;
import com.avito.android.serp.adapter.rich_snippets.job.AdvertXlRichJobItemBlueprint;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichItemBlueprint;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertVipRichItemBlueprint;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertXlRichItemBlueprint;
import com.avito.android.serp.adapter.skeleton.di.SerpSkeletonModule;
import com.avito.android.serp.adapter.snippet.SnippetBlueprint;
import com.avito.android.serp.adapter.title.GroupTitleItemBlueprint;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterPresenter;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterPresenterImpl;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.item.VerticalFilterItemBlueprint;
import com.avito.android.serp.adapter.warning.SerpWarningItemBlueprint;
import com.avito.android.serp.adapter.warning.SerpWarningItemListener;
import com.avito.android.serp.adapter.witcher.WitcherItemBlueprint;
import com.avito.android.serp.adapter.witcher.WitcherItemListener;
import com.avito.android.serp.analytics.SerpAnalyticsInteractor;
import com.avito.android.serp.analytics.SerpAnalyticsInteractorImpl;
import com.avito.android.serp.analytics.SerpTracker;
import com.avito.android.serp.analytics.SerpTrackerImpl;
import com.avito.android.serp.diff_calculator.DiffCalculator;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.Formatter;
import com.avito.android.util.PhoneNumberFormatterModule;
import com.avito.android.util.SearchContextWrapper;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¾\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002¢\u0001B\u000b\b\u0002¢\u0006\u0006\b \u0001\u0010¡\u0001J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u000f\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0001¢\u0006\u0004\b\r\u0010\u000eJÊ\u0003\u0010\u001a\u00020|2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u0002002\u0006\u00103\u001a\u0002022\u0006\u00105\u001a\u0002042\u0006\u00107\u001a\u0002062\u0006\u00109\u001a\u0002082\u0006\u0010;\u001a\u00020:2\u0006\u0010=\u001a\u00020<2\u0006\u0010?\u001a\u00020>2\u0006\u0010A\u001a\u00020@2\u0006\u0010C\u001a\u00020B2\u0006\u0010E\u001a\u00020D2\u0006\u0010G\u001a\u00020F2\u0006\u0010I\u001a\u00020H2\u0006\u0010K\u001a\u00020J2\u0006\u0010M\u001a\u00020L2\u0006\u0010O\u001a\u00020N2\u0006\u0010Q\u001a\u00020P2\u0006\u0010S\u001a\u00020R2\u0006\u0010U\u001a\u00020T2\u0006\u0010W\u001a\u00020V2\u0006\u0010Y\u001a\u00020X2\u0006\u0010[\u001a\u00020Z2\u0006\u0010]\u001a\u00020\\2\u0006\u0010_\u001a\u00020^2\u0006\u0010a\u001a\u00020`2\u0006\u0010c\u001a\u00020b2\u0006\u0010e\u001a\u00020d2\u0006\u0010g\u001a\u00020f2\u0006\u0010i\u001a\u00020h2\u0006\u0010k\u001a\u00020j2\u0006\u0010m\u001a\u00020l2\u0006\u0010o\u001a\u00020n2\u0006\u0010q\u001a\u00020p2\u0006\u0010s\u001a\u00020r2\u0006\u0010u\u001a\u00020t2\u0006\u0010w\u001a\u00020v2\u0019\u0010{\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030y¢\u0006\u0002\bz0xH\u0001¢\u0006\u0004\b}\u0010~J\u001e\u0010\u0001\u001a\u00030\u00012\t\b\u0001\u0010\u0001\u001a\u00020|H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00030\u00012\t\b\u0001\u0010\u0001\u001a\u00020|H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J9\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001d\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\f\u0012\u0005\u0012\u00030\u0001\u0018\u00010\u0001H\u0007¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00030\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0006\b\u0001\u0010\u0001¨\u0006£\u0001"}, d2 = {"Lcom/avito/android/di/module/SerpModule;", "", "Lcom/avito/android/serp/SerpArguments;", "serpArguments", "", "providesInitialQuery$serp_release", "(Lcom/avito/android/serp/SerpArguments;)Ljava/lang/String;", "providesInitialQuery", "Lcom/avito/android/item_visibility_tracker/filters/BannerViewFilter;", "bannerViewFilter", "Landroid/os/Bundle;", "state", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "provideItemVisibilityTracker$serp_release", "(Lcom/avito/android/item_visibility_tracker/filters/BannerViewFilter;Landroid/os/Bundle;)Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "provideItemVisibilityTracker", "Lcom/avito/android/serp/adapter/AdvertItemGridBlueprint;", "advertItemGridBlueprint", "Lcom/avito/android/serp/adapter/AdvertItemListBlueprint;", "advertItemListBlueprint", "Lcom/avito/android/serp/adapter/AdvertItemDoubleBlueprint;", "advertItemDoubleBlueprint", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItemBlueprint;", "advertXlItemBlueprint", "Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertVipRichItemBlueprint;", "advertVipRichItemBlueprint", "Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertXlRichItemBlueprint;", "advertXlRichItemBlueprint", "Lcom/avito/android/serp/adapter/rich_snippets/job/AdvertRichJobItemBlueprint;", "advertRichJobItemBlueprint", "Lcom/avito/android/serp/adapter/rich_snippets/job/AdvertVipRichJobItemBlueprint;", "advertVipRichJobItemBlueprint", "Lcom/avito/android/serp/adapter/rich_snippets/job/AdvertXlRichJobItemBlueprint;", "advertXlRichJobItemBlueprint", "Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertRichItemBlueprint;", "advertRichItemBlueprint", "Lcom/avito/android/module/serp/adapter/ad/yandex/content/YandexContentSingleGridBlueprint;", "yandexContentSingleGridBlueprint", "Lcom/avito/android/serp/adapter/rich_snippets/YandexContentRichBlueprint;", "yandexContentRichBlueprint", "Lcom/avito/android/serp/adapter/rich_snippets/YandexAppInstallRichBlueprint;", "yandexAppInstallRichBlueprint", "Lcom/avito/android/module/serp/adapter/ad/yandex/content/YandexContentDoubleGridBlueprint;", "yandexContentDoubleGridBlueprint", "Lcom/avito/android/module/serp/adapter/ad/yandex/app_install/YandexAppInstallSingleItemBlueprint;", "yandexAppInstallSingleItemBlueprint", "Lcom/avito/android/module/serp/adapter/ad/yandex/app_install/YandexAppInstallDoubleItemBlueprint;", "yandexAppInstallDoubleItemBlueprint", "Lcom/avito/android/module/serp/adapter/ad/adfox/AdfoxSingleGridBlueprint;", "adfoxSingleGridBlueprint", "Lcom/avito/android/module/serp/adapter/ad/adfox/AdfoxSingleListBlueprint;", "adfoxSingleListBlueprint", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpUnifiedDoubleBlueprint;", "dfpUnifiedDoubleBlueprint", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpUnifiedSingleGridBlueprint;", "dfpUnifiedSingleGridBlueprint", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpAppInstallDoubleBlueprint;", "dfpAppInstallDoubleBlueprint", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpAppInstallSingleBlueprint;", "dfpAppInstallSingleBlueprint", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpContentSingleGridBlueprint;", "dfpContentSingleGridBlueprint", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpContentDoubleGridBlueprint;", "dfpContentDoubleGridBlueprint", "Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetContentSingleBlueprint;", "myTargetContentSingleBlueprint", "Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetContentBlueprint;", "myTargetContentBlueprint", "Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetAppInstallSingleBlueprint;", "myTargetAppInstallSingleBlueprint", "Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetAppInstallBlueprint;", "myTargetAppInstallBlueprint", "Lcom/avito/android/serp/adapter/ShortcutBannerBlueprint;", "shortcutBannerBlueprint", "Lcom/avito/android/serp/adapter/warning/SerpWarningItemBlueprint;", "serpWarningItemBlueprint", "Lcom/avito/android/serp/adapter/snippet/SnippetBlueprint;", "snippetBlueprint", "Lcom/avito/android/serp/adapter/adstub/EmptyAdStubItemBlueprint;", "emptyAdStubItemBlueprint", "Lcom/avito/android/serp/adapter/empty_search/EmptySearchItemBlueprint;", "emptySearchItemBlueprint", "Lcom/avito/android/home/HomeSerpHeaderBluePrint;", "homeSerpHeaderBluePrint", "Lcom/avito/android/serp/adapter/adstub/NotLoadAdStubGridBlueprint;", "notLoadAdStubGridBlueprint", "Lcom/avito/android/home/appending_item/loader/AppendingLoaderItemBlueprint;", "appendingLoaderItemBlueprint", "Lcom/avito/android/home/appending_item/retry/AppendingRetryItemBlueprint;", "appendingRetryItemBlueprint", "Lcom/avito/android/serp/adapter/title/GroupTitleItemBlueprint;", "groupTitleItemBlueprint", "Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemBlueprint;", "emptyPlaceholderItemBlueprint", "Lcom/avito/android/module/serp/adapter/ad/yandex/content/YandexContentListBlueprint;", "yandexContentListBlueprint", "Lcom/avito/android/module/serp/adapter/ad/yandex/app_install/YandexAppInstallListItemBlueprint;", "yandexAppInstallListItemBlueprint", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpUnifiedListBlueprint;", "dfpUnifiedListBlueprint", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpContentListBlueprint;", "dfpContentListBlueprint", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpAppInstallListBlueprint;", "dfpAppInstallListBlueprint", "Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetContentListBlueprint;", "myTargetContentListBlueprint", "Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetAppInstallListBlueprint;", "myTargetAppInstallListBlueprint", "Lcom/avito/android/serp/adapter/adstub/NotLoadAdStubListBlueprint;", "notLoadAdStubListBlueprint", "Lcom/avito/android/serp/adapter/adstub/NotLoadAdRichStubBlueprint;", "notLoadAdStubRichBlueprint", "Lcom/avito/android/serp/adapter/witcher/WitcherItemBlueprint;", "witcherItemBlueprint", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/item/VerticalFilterItemBlueprint;", "verticalFilterItemBlueprint", "Lcom/avito/android/serp/adapter/promo_card/PromoCardBlueprint;", "promoCardBlueprint", "Lcom/avito/android/serp/adapter/map_banner/MapBannerItemBlueprint;", "mapBannerItemBlueprint", "", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lkotlin/jvm/JvmSuppressWildcards;", "blueprints", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder$serp_release", "(Lcom/avito/android/serp/adapter/AdvertItemGridBlueprint;Lcom/avito/android/serp/adapter/AdvertItemListBlueprint;Lcom/avito/android/serp/adapter/AdvertItemDoubleBlueprint;Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItemBlueprint;Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertVipRichItemBlueprint;Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertXlRichItemBlueprint;Lcom/avito/android/serp/adapter/rich_snippets/job/AdvertRichJobItemBlueprint;Lcom/avito/android/serp/adapter/rich_snippets/job/AdvertVipRichJobItemBlueprint;Lcom/avito/android/serp/adapter/rich_snippets/job/AdvertXlRichJobItemBlueprint;Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertRichItemBlueprint;Lcom/avito/android/module/serp/adapter/ad/yandex/content/YandexContentSingleGridBlueprint;Lcom/avito/android/serp/adapter/rich_snippets/YandexContentRichBlueprint;Lcom/avito/android/serp/adapter/rich_snippets/YandexAppInstallRichBlueprint;Lcom/avito/android/module/serp/adapter/ad/yandex/content/YandexContentDoubleGridBlueprint;Lcom/avito/android/module/serp/adapter/ad/yandex/app_install/YandexAppInstallSingleItemBlueprint;Lcom/avito/android/module/serp/adapter/ad/yandex/app_install/YandexAppInstallDoubleItemBlueprint;Lcom/avito/android/module/serp/adapter/ad/adfox/AdfoxSingleGridBlueprint;Lcom/avito/android/module/serp/adapter/ad/adfox/AdfoxSingleListBlueprint;Lcom/avito/android/module/serp/adapter/ad/dfp/DfpUnifiedDoubleBlueprint;Lcom/avito/android/module/serp/adapter/ad/dfp/DfpUnifiedSingleGridBlueprint;Lcom/avito/android/module/serp/adapter/ad/dfp/DfpAppInstallDoubleBlueprint;Lcom/avito/android/module/serp/adapter/ad/dfp/DfpAppInstallSingleBlueprint;Lcom/avito/android/module/serp/adapter/ad/dfp/DfpContentSingleGridBlueprint;Lcom/avito/android/module/serp/adapter/ad/dfp/DfpContentDoubleGridBlueprint;Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetContentSingleBlueprint;Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetContentBlueprint;Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetAppInstallSingleBlueprint;Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetAppInstallBlueprint;Lcom/avito/android/serp/adapter/ShortcutBannerBlueprint;Lcom/avito/android/serp/adapter/warning/SerpWarningItemBlueprint;Lcom/avito/android/serp/adapter/snippet/SnippetBlueprint;Lcom/avito/android/serp/adapter/adstub/EmptyAdStubItemBlueprint;Lcom/avito/android/serp/adapter/empty_search/EmptySearchItemBlueprint;Lcom/avito/android/home/HomeSerpHeaderBluePrint;Lcom/avito/android/serp/adapter/adstub/NotLoadAdStubGridBlueprint;Lcom/avito/android/home/appending_item/loader/AppendingLoaderItemBlueprint;Lcom/avito/android/home/appending_item/retry/AppendingRetryItemBlueprint;Lcom/avito/android/serp/adapter/title/GroupTitleItemBlueprint;Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemBlueprint;Lcom/avito/android/module/serp/adapter/ad/yandex/content/YandexContentListBlueprint;Lcom/avito/android/module/serp/adapter/ad/yandex/app_install/YandexAppInstallListItemBlueprint;Lcom/avito/android/module/serp/adapter/ad/dfp/DfpUnifiedListBlueprint;Lcom/avito/android/module/serp/adapter/ad/dfp/DfpContentListBlueprint;Lcom/avito/android/module/serp/adapter/ad/dfp/DfpAppInstallListBlueprint;Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetContentListBlueprint;Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetAppInstallListBlueprint;Lcom/avito/android/serp/adapter/adstub/NotLoadAdStubListBlueprint;Lcom/avito/android/serp/adapter/adstub/NotLoadAdRichStubBlueprint;Lcom/avito/android/serp/adapter/witcher/WitcherItemBlueprint;Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/item/VerticalFilterItemBlueprint;Lcom/avito/android/serp/adapter/promo_card/PromoCardBlueprint;Lcom/avito/android/serp/adapter/map_banner/MapBannerItemBlueprint;Ljava/util/Set;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "itemBinder", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "provideDestroyableViewHolderBuilder$serp_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "provideDestroyableViewHolderBuilder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter$serp_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "treeStateIdGenerator", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/serp/analytics/SerpAnalyticsInteractor;", "provideSerpAnalyticsInteractor$serp_release", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/provider/TreeStateIdGenerator;Lcom/avito/android/serp/SerpArguments;Lcom/avito/android/Features;)Lcom/avito/android/serp/analytics/SerpAnalyticsInteractor;", "provideSerpAnalyticsInteractor", "serpAnalyticsInteractor", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "provideSerpTreeParent$serp_release", "(Lcom/avito/android/serp/analytics/SerpAnalyticsInteractor;)Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "provideSerpTreeParent", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/ViewedItemsTabTestGroup;", "provideViewedItemsTabTestGroup", "()Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/util/SearchContextWrapper;", "provideSearchContextWrapper$serp_release", "(Lcom/avito/android/serp/SerpArguments;)Lcom/avito/android/util/SearchContextWrapper;", "provideSearchContextWrapper", "<init>", "()V", "Dependencies", "serp_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {SavedLocationInteractorModule.class, AppendingLoaderModule.class, ConnectionQualityInteractorModule.class, UpdateInstanceIdModule.class, FavoriteAdvertsPresenterModule.class, FavoriteItemModule.class, InlineFiltersModule.class, PhoneNumberFormatterModule.class, RichSnippetsModule.class, WitcherModule.class, SavedSearchesModule.class, SerpAdapterModule.class, SerpInteractorModule.class, SerpItemConverterModule.class, SpanAdapterModule.class, ViewedAdvertsModule.class, SerpSkeletonModule.class, AppendingRetryModule.class, SerpOnboardingModule.class, CartFabModule.class, Dependencies.class})
public final class SerpModule {
    @NotNull
    public static final SerpModule INSTANCE = new SerpModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u000e2\u0006\u0010\r\u001a\u00020\u0017H'¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH'¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\"2\u0006\u0010\b\u001a\u00020!H'¢\u0006\u0004\b#\u0010$J\u0017\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020%H'¢\u0006\u0004\b(\u0010)J\u0017\u0010-\u001a\u00020,2\u0006\u0010+\u001a\u00020*H'¢\u0006\u0004\b-\u0010.J\u0017\u00102\u001a\u0002012\u0006\u00100\u001a\u00020/H'¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u0002042\u0006\u00100\u001a\u00020/H'¢\u0006\u0004\b5\u00106J\u0017\u00109\u001a\u0002082\u0006\u00107\u001a\u000201H'¢\u0006\u0004\b9\u0010:J\u0017\u0010<\u001a\u00020;2\u0006\u00107\u001a\u000201H'¢\u0006\u0004\b<\u0010=J\u0017\u0010?\u001a\u00020>2\u0006\u00107\u001a\u000201H'¢\u0006\u0004\b?\u0010@J\u0017\u0010B\u001a\u00020A2\u0006\u00107\u001a\u000201H'¢\u0006\u0004\bB\u0010CJ\u0017\u0010E\u001a\u00020D2\u0006\u00107\u001a\u000201H'¢\u0006\u0004\bE\u0010FJ\u0017\u0010H\u001a\u00020G2\u0006\u00107\u001a\u000201H'¢\u0006\u0004\bH\u0010IJ\u0017\u0010K\u001a\u00020J2\u0006\u00107\u001a\u000201H'¢\u0006\u0004\bK\u0010LJ\u0017\u0010N\u001a\u00020M2\u0006\u00107\u001a\u000201H'¢\u0006\u0004\bN\u0010OJ\u0017\u0010Q\u001a\u00020P2\u0006\u00107\u001a\u000201H'¢\u0006\u0004\bQ\u0010RJ\u0017\u0010T\u001a\u00020S2\u0006\u00107\u001a\u000201H'¢\u0006\u0004\bT\u0010UJ\u0017\u0010X\u001a\u00020W2\u0006\u0010\u001d\u001a\u00020VH'¢\u0006\u0004\bX\u0010YJ\u0017\u0010[\u001a\u00020/2\u0006\u0010\b\u001a\u00020ZH'¢\u0006\u0004\b[\u0010\\J\u0017\u0010`\u001a\u00020_2\u0006\u0010^\u001a\u00020]H'¢\u0006\u0004\b`\u0010aJ\u001d\u0010d\u001a\b\u0012\u0004\u0012\u00020c0b2\u0006\u0010&\u001a\u00020'H'¢\u0006\u0004\bd\u0010eJ\u0017\u0010i\u001a\u00020h2\u0006\u0010g\u001a\u00020fH'¢\u0006\u0004\bi\u0010jJ\u0017\u0010n\u001a\u00020m2\u0006\u0010l\u001a\u00020kH'¢\u0006\u0004\bn\u0010oJ\u0017\u0010r\u001a\u00020q2\u0006\u0010+\u001a\u00020pH'¢\u0006\u0004\br\u0010sJ\u0017\u0010u\u001a\u00020t2\u0006\u00100\u001a\u00020/H'¢\u0006\u0004\bu\u0010vJ\u0017\u0010z\u001a\u00020y2\u0006\u0010x\u001a\u00020wH'¢\u0006\u0004\bz\u0010{J\u0018\u0010\u001a\u00020~2\u0006\u0010}\u001a\u00020|H'¢\u0006\u0005\b\u0010\u0001J\u001d\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H'¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u001d\u001a\u00030\u0001H'¢\u0006\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/di/module/SerpModule$Dependencies;", "", "Lcom/avito/android/deep_linking/SimpleClickStreamLinkHandler;", "handler", "Lcom/avito/android/deep_linking/ClickStreamLinkHandler;", "bindClickStreamLinkHandler", "(Lcom/avito/android/deep_linking/SimpleClickStreamLinkHandler;)Lcom/avito/android/deep_linking/ClickStreamLinkHandler;", "Lcom/avito/android/serp/adapter/empty_search/EmptySearchItemPresenterImpl;", "presenter", "Lcom/avito/android/serp/adapter/empty_search/EmptySearchItemPresenter;", "bindEmptySearchItemPresenter", "(Lcom/avito/android/serp/adapter/empty_search/EmptySearchItemPresenterImpl;)Lcom/avito/android/serp/adapter/empty_search/EmptySearchItemPresenter;", "Lcom/avito/android/serp/adapter/empty_search/EmptySearchItemBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/serp/adapter/empty_search/EmptySearchItemView;", "Lcom/avito/android/serp/adapter/empty_search/EmptySearchItem;", "bindEmptySearchItemBlueprint", "(Lcom/avito/android/serp/adapter/empty_search/EmptySearchItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/conveyor_shared_item/single_text/SingleTextPresenterImpl;", "Lcom/avito/android/conveyor_shared_item/single_text/SingleTextPresenter;", "bindSingleTextPresenter", "(Lcom/avito/android/conveyor_shared_item/single_text/SingleTextPresenterImpl;)Lcom/avito/android/conveyor_shared_item/single_text/SingleTextPresenter;", "Lcom/avito/android/home/HomeSerpHeaderBluePrint;", "Lcom/avito/android/conveyor_shared_item/single_text/SingleTextView;", "Lcom/avito/android/conveyor_shared_item/single_text/SingleTextItem;", "bindHomeSerpHeaderBluePrint", "(Lcom/avito/android/home/HomeSerpHeaderBluePrint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/advert_core/messenger/AdvertMessengerInteractorImpl;", "interactor", "Lcom/avito/android/advert_core/messenger/AdvertMessengerInteractor;", "bindAdvertMessengerInteractor", "(Lcom/avito/android/advert_core/messenger/AdvertMessengerInteractorImpl;)Lcom/avito/android/advert_core/messenger/AdvertMessengerInteractor;", "Lcom/avito/android/floating_views/FloatingViewsPresenterImpl;", "Lcom/avito/android/floating_views/PersistableFloatingViewsPresenter;", "bindPersistableFloatingViewsPresenter", "(Lcom/avito/android/floating_views/FloatingViewsPresenterImpl;)Lcom/avito/android/floating_views/PersistableFloatingViewsPresenter;", "Lcom/avito/android/util/ErrorFormatterImpl;", "formatter", "Lcom/avito/android/util/ErrorFormatter;", "bindErrorFormatter", "(Lcom/avito/android/util/ErrorFormatterImpl;)Lcom/avito/android/util/ErrorFormatter;", "Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationItemConverterImpl;", "converter", "Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationItemConverter;", "bindActionItemConverter", "(Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationItemConverterImpl;)Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationItemConverter;", "Lcom/avito/android/serp/SerpPresenter;", "serpPresenter", "Lcom/avito/android/serp/adapter/SerpAdapterListener;", "bindsSerpAdapterListener", "(Lcom/avito/android/serp/SerpPresenter;)Lcom/avito/android/serp/adapter/SerpAdapterListener;", "Lcom/avito/android/serp/adapter/ShortcutBannerItemListener;", "bindsShortcutsItemCLickListener", "(Lcom/avito/android/serp/SerpPresenter;)Lcom/avito/android/serp/adapter/ShortcutBannerItemListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/serp/adapter/AdvertItemListener;", "bindsAdvertItemClickListener", "(Lcom/avito/android/serp/adapter/SerpAdapterListener;)Lcom/avito/android/serp/adapter/AdvertItemListener;", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItemListener;", "bindsAdvertXlItemClickListener", "(Lcom/avito/android/serp/adapter/SerpAdapterListener;)Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItemListener;", "Lcom/avito/android/serp/adapter/warning/SerpWarningItemListener;", "bindsSerpWarningItemListener", "(Lcom/avito/android/serp/adapter/SerpAdapterListener;)Lcom/avito/android/serp/adapter/warning/SerpWarningItemListener;", "Lcom/avito/android/serp/adapter/OnCloseItemListener;", "bindsOnCloseItemListener", "(Lcom/avito/android/serp/adapter/SerpAdapterListener;)Lcom/avito/android/serp/adapter/OnCloseItemListener;", "Lcom/avito/android/serp/adapter/promo_card/PromoCardItemPresenter$Router;", "bindsPromoCardListener", "(Lcom/avito/android/serp/adapter/SerpAdapterListener;)Lcom/avito/android/serp/adapter/promo_card/PromoCardItemPresenter$Router;", "Lcom/avito/android/serp/adapter/AdBannerEventListener;", "bindsOnAdBannerOpenedListener", "(Lcom/avito/android/serp/adapter/SerpAdapterListener;)Lcom/avito/android/serp/adapter/AdBannerEventListener;", "Lcom/avito/android/serp/adapter/rich_snippets/AdvertRichItemListener;", "bindsAdvertRichItemListener", "(Lcom/avito/android/serp/adapter/SerpAdapterListener;)Lcom/avito/android/serp/adapter/rich_snippets/AdvertRichItemListener;", "Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemListener;", "bindsEmptyPlaceholderItemListener", "(Lcom/avito/android/serp/adapter/SerpAdapterListener;)Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemListener;", "Lcom/avito/android/serp/adapter/witcher/WitcherItemListener;", "bindWitcherItemListener", "(Lcom/avito/android/serp/adapter/SerpAdapterListener;)Lcom/avito/android/serp/adapter/witcher/WitcherItemListener;", "Lcom/avito/android/serp/adapter/map_banner/MapBannerItemListener;", "bindMapBannerItemListener", "(Lcom/avito/android/serp/adapter/SerpAdapterListener;)Lcom/avito/android/serp/adapter/map_banner/MapBannerItemListener;", "Lcom/avito/android/serp/SerpInteractorImpl;", "Lcom/avito/android/serp/SerpInteractor;", "bindsSerpInteractor", "(Lcom/avito/android/serp/SerpInteractorImpl;)Lcom/avito/android/serp/SerpInteractor;", "Lcom/avito/android/serp/SerpPresenterImpl;", "bindsSerpPresenter", "(Lcom/avito/android/serp/SerpPresenterImpl;)Lcom/avito/android/serp/SerpPresenter;", "Lcom/avito/android/serp/diff_calculator/DiffCalculator$Impl;", "calculator", "Lcom/avito/android/serp/diff_calculator/DiffCalculator;", "bindsDiffCalculator", "(Lcom/avito/android/serp/diff_calculator/DiffCalculator$Impl;)Lcom/avito/android/serp/diff_calculator/DiffCalculator;", "Lcom/avito/android/util/Formatter;", "", "bindsErrorFormatter", "(Lcom/avito/android/util/ErrorFormatter;)Lcom/avito/android/util/Formatter;", "Lcom/avito/android/serp/analytics/SerpTrackerImpl;", "tracker", "Lcom/avito/android/serp/analytics/SerpTracker;", "bindsSerpTracker", "(Lcom/avito/android/serp/analytics/SerpTrackerImpl;)Lcom/avito/android/serp/analytics/SerpTracker;", "Lcom/avito/android/serp/ad/AdResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/serp/ad/AdResourceProvider;", "bindAdResourceProvider", "(Lcom/avito/android/serp/ad/AdResourceProviderImpl;)Lcom/avito/android/serp/ad/AdResourceProvider;", "Lcom/avito/android/remote/model/SearchParamsConverterImpl;", "Lcom/avito/android/remote/model/SearchParamsConverter;", "bindSearchParamsConverter", "(Lcom/avito/android/remote/model/SearchParamsConverterImpl;)Lcom/avito/android/remote/model/SearchParamsConverter;", "Lcom/avito/android/async_phone/AsyncPhoneAuthRouter;", "bindAsyncPhoneAuthRouter", "(Lcom/avito/android/serp/SerpPresenter;)Lcom/avito/android/async_phone/AsyncPhoneAuthRouter;", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterPresenterImpl;", "verticalFilterPresenter", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterPresenter;", "bindVerticalFilterPresenter", "(Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterPresenterImpl;)Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterPresenter;", "Landroidx/fragment/app/Fragment;", UrlParams.OWNER, "Landroidx/lifecycle/ViewModelStoreOwner;", "bindViewModelStoreOwner", "(Landroidx/fragment/app/Fragment;)Landroidx/lifecycle/ViewModelStoreOwner;", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthTrackerImpl;", "userScrollTracker", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker;", "bindUserScrollTracker", "(Lcom/avito/android/scroll_tracker/SnippetScrollDepthTrackerImpl;)Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker;", "Lcom/avito/android/analytics/interactor/SnippetScrollDepthAnalyticsInteractorImpl;", "Lcom/avito/android/analytics/interactor/SnippetScrollDepthAnalyticsInteractor;", "bindsSnippetScrollDepthAnalyticsInteractor", "(Lcom/avito/android/analytics/interactor/SnippetScrollDepthAnalyticsInteractorImpl;)Lcom/avito/android/analytics/interactor/SnippetScrollDepthAnalyticsInteractor;", "serp_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerFragment
        @Binds
        @NotNull
        ShortcutNavigationItemConverter bindActionItemConverter(@NotNull ShortcutNavigationItemConverterImpl shortcutNavigationItemConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        AdResourceProvider bindAdResourceProvider(@NotNull AdResourceProviderImpl adResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        AdvertMessengerInteractor bindAdvertMessengerInteractor(@NotNull AdvertMessengerInteractorImpl advertMessengerInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        AsyncPhoneAuthRouter bindAsyncPhoneAuthRouter(@NotNull SerpPresenter serpPresenter);

        @PerFragment
        @Binds
        @NotNull
        ClickStreamLinkHandler bindClickStreamLinkHandler(@NotNull SimpleClickStreamLinkHandler simpleClickStreamLinkHandler);

        @Binds
        @NotNull
        @PerFragment
        ItemBlueprint<EmptySearchItemView, EmptySearchItem> bindEmptySearchItemBlueprint(@NotNull EmptySearchItemBlueprint emptySearchItemBlueprint);

        @PerFragment
        @Binds
        @NotNull
        EmptySearchItemPresenter bindEmptySearchItemPresenter(@NotNull EmptySearchItemPresenterImpl emptySearchItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        ErrorFormatter bindErrorFormatter(@NotNull ErrorFormatterImpl errorFormatterImpl);

        @Binds
        @NotNull
        @PerFragment
        ItemBlueprint<SingleTextView, SingleTextItem> bindHomeSerpHeaderBluePrint(@NotNull HomeSerpHeaderBluePrint homeSerpHeaderBluePrint);

        @PerFragment
        @Binds
        @NotNull
        MapBannerItemListener bindMapBannerItemListener(@NotNull SerpAdapterListener serpAdapterListener);

        @PerFragment
        @Binds
        @NotNull
        PersistableFloatingViewsPresenter bindPersistableFloatingViewsPresenter(@NotNull FloatingViewsPresenterImpl floatingViewsPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        SearchParamsConverter bindSearchParamsConverter(@NotNull SearchParamsConverterImpl searchParamsConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        SingleTextPresenter bindSingleTextPresenter(@NotNull SingleTextPresenterImpl singleTextPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        SnippetScrollDepthTracker bindUserScrollTracker(@NotNull SnippetScrollDepthTrackerImpl snippetScrollDepthTrackerImpl);

        @PerFragment
        @Binds
        @NotNull
        VerticalFilterPresenter bindVerticalFilterPresenter(@NotNull VerticalFilterPresenterImpl verticalFilterPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        ViewModelStoreOwner bindViewModelStoreOwner(@NotNull Fragment fragment);

        @PerFragment
        @Binds
        @NotNull
        WitcherItemListener bindWitcherItemListener(@NotNull SerpAdapterListener serpAdapterListener);

        @PerFragment
        @Binds
        @NotNull
        AdvertItemListener bindsAdvertItemClickListener(@NotNull SerpAdapterListener serpAdapterListener);

        @PerFragment
        @Binds
        @NotNull
        AdvertRichItemListener bindsAdvertRichItemListener(@NotNull SerpAdapterListener serpAdapterListener);

        @PerFragment
        @Binds
        @NotNull
        AdvertXlItemListener bindsAdvertXlItemClickListener(@NotNull SerpAdapterListener serpAdapterListener);

        @PerFragment
        @Binds
        @NotNull
        DiffCalculator bindsDiffCalculator(@NotNull DiffCalculator.Impl impl);

        @PerFragment
        @Binds
        @NotNull
        EmptyPlaceholderItemListener bindsEmptyPlaceholderItemListener(@NotNull SerpAdapterListener serpAdapterListener);

        @Binds
        @NotNull
        @PerFragment
        Formatter<Throwable> bindsErrorFormatter(@NotNull ErrorFormatter errorFormatter);

        @PerFragment
        @Binds
        @NotNull
        AdBannerEventListener bindsOnAdBannerOpenedListener(@NotNull SerpAdapterListener serpAdapterListener);

        @PerFragment
        @Binds
        @NotNull
        OnCloseItemListener bindsOnCloseItemListener(@NotNull SerpAdapterListener serpAdapterListener);

        @PerFragment
        @Binds
        @NotNull
        PromoCardItemPresenter.Router bindsPromoCardListener(@NotNull SerpAdapterListener serpAdapterListener);

        @PerFragment
        @Binds
        @NotNull
        SerpAdapterListener bindsSerpAdapterListener(@NotNull SerpPresenter serpPresenter);

        @PerFragment
        @Binds
        @NotNull
        SerpInteractor bindsSerpInteractor(@NotNull SerpInteractorImpl serpInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        SerpPresenter bindsSerpPresenter(@NotNull SerpPresenterImpl serpPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        SerpTracker bindsSerpTracker(@NotNull SerpTrackerImpl serpTrackerImpl);

        @PerFragment
        @Binds
        @NotNull
        SerpWarningItemListener bindsSerpWarningItemListener(@NotNull SerpAdapterListener serpAdapterListener);

        @PerFragment
        @Binds
        @NotNull
        ShortcutBannerItemListener bindsShortcutsItemCLickListener(@NotNull SerpPresenter serpPresenter);

        @PerFragment
        @Binds
        @NotNull
        SnippetScrollDepthAnalyticsInteractor bindsSnippetScrollDepthAnalyticsInteractor(@NotNull SnippetScrollDepthAnalyticsInteractorImpl snippetScrollDepthAnalyticsInteractorImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final AdapterPresenter provideAdapterPresenter$serp_release(@SerpItemBinder @NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DestroyableViewHolderBuilder provideDestroyableViewHolderBuilder$serp_release(@SerpItemBinder @NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        return new DestroyableViewHolderBuilderImpl(itemBinder);
    }

    @Provides
    @JvmStatic
    @SerpItemBinder
    @NotNull
    @PerFragment
    public static final ItemBinder provideItemBinder$serp_release(@NotNull AdvertItemGridBlueprint advertItemGridBlueprint, @NotNull AdvertItemListBlueprint advertItemListBlueprint, @NotNull AdvertItemDoubleBlueprint advertItemDoubleBlueprint, @NotNull AdvertXlItemBlueprint advertXlItemBlueprint, @NotNull AdvertVipRichItemBlueprint advertVipRichItemBlueprint, @NotNull AdvertXlRichItemBlueprint advertXlRichItemBlueprint, @NotNull AdvertRichJobItemBlueprint advertRichJobItemBlueprint, @NotNull AdvertVipRichJobItemBlueprint advertVipRichJobItemBlueprint, @NotNull AdvertXlRichJobItemBlueprint advertXlRichJobItemBlueprint, @NotNull AdvertRichItemBlueprint advertRichItemBlueprint, @NotNull YandexContentSingleGridBlueprint yandexContentSingleGridBlueprint, @NotNull YandexContentRichBlueprint yandexContentRichBlueprint, @NotNull YandexAppInstallRichBlueprint yandexAppInstallRichBlueprint, @NotNull YandexContentDoubleGridBlueprint yandexContentDoubleGridBlueprint, @NotNull YandexAppInstallSingleItemBlueprint yandexAppInstallSingleItemBlueprint, @NotNull YandexAppInstallDoubleItemBlueprint yandexAppInstallDoubleItemBlueprint, @NotNull AdfoxSingleGridBlueprint adfoxSingleGridBlueprint, @NotNull AdfoxSingleListBlueprint adfoxSingleListBlueprint, @NotNull DfpUnifiedDoubleBlueprint dfpUnifiedDoubleBlueprint, @NotNull DfpUnifiedSingleGridBlueprint dfpUnifiedSingleGridBlueprint, @NotNull DfpAppInstallDoubleBlueprint dfpAppInstallDoubleBlueprint, @NotNull DfpAppInstallSingleBlueprint dfpAppInstallSingleBlueprint, @NotNull DfpContentSingleGridBlueprint dfpContentSingleGridBlueprint, @NotNull DfpContentDoubleGridBlueprint dfpContentDoubleGridBlueprint, @NotNull MyTargetContentSingleBlueprint myTargetContentSingleBlueprint, @NotNull MyTargetContentBlueprint myTargetContentBlueprint, @NotNull MyTargetAppInstallSingleBlueprint myTargetAppInstallSingleBlueprint, @NotNull MyTargetAppInstallBlueprint myTargetAppInstallBlueprint, @NotNull ShortcutBannerBlueprint shortcutBannerBlueprint, @NotNull SerpWarningItemBlueprint serpWarningItemBlueprint, @NotNull SnippetBlueprint snippetBlueprint, @NotNull EmptyAdStubItemBlueprint emptyAdStubItemBlueprint, @NotNull EmptySearchItemBlueprint emptySearchItemBlueprint, @NotNull HomeSerpHeaderBluePrint homeSerpHeaderBluePrint, @NotNull NotLoadAdStubGridBlueprint notLoadAdStubGridBlueprint, @NotNull AppendingLoaderItemBlueprint appendingLoaderItemBlueprint, @NotNull AppendingRetryItemBlueprint appendingRetryItemBlueprint, @NotNull GroupTitleItemBlueprint groupTitleItemBlueprint, @NotNull EmptyPlaceholderItemBlueprint emptyPlaceholderItemBlueprint, @NotNull YandexContentListBlueprint yandexContentListBlueprint, @NotNull YandexAppInstallListItemBlueprint yandexAppInstallListItemBlueprint, @NotNull DfpUnifiedListBlueprint dfpUnifiedListBlueprint, @NotNull DfpContentListBlueprint dfpContentListBlueprint, @NotNull DfpAppInstallListBlueprint dfpAppInstallListBlueprint, @NotNull MyTargetContentListBlueprint myTargetContentListBlueprint, @NotNull MyTargetAppInstallListBlueprint myTargetAppInstallListBlueprint, @NotNull NotLoadAdStubListBlueprint notLoadAdStubListBlueprint, @NotNull NotLoadAdRichStubBlueprint notLoadAdRichStubBlueprint, @NotNull WitcherItemBlueprint witcherItemBlueprint, @NotNull VerticalFilterItemBlueprint verticalFilterItemBlueprint, @NotNull PromoCardBlueprint promoCardBlueprint, @NotNull MapBannerItemBlueprint mapBannerItemBlueprint, @NotNull Set<ItemBlueprint<?, ?>> set) {
        Intrinsics.checkNotNullParameter(advertItemGridBlueprint, "advertItemGridBlueprint");
        Intrinsics.checkNotNullParameter(advertItemListBlueprint, "advertItemListBlueprint");
        Intrinsics.checkNotNullParameter(advertItemDoubleBlueprint, "advertItemDoubleBlueprint");
        Intrinsics.checkNotNullParameter(advertXlItemBlueprint, "advertXlItemBlueprint");
        Intrinsics.checkNotNullParameter(advertVipRichItemBlueprint, "advertVipRichItemBlueprint");
        Intrinsics.checkNotNullParameter(advertXlRichItemBlueprint, "advertXlRichItemBlueprint");
        Intrinsics.checkNotNullParameter(advertRichJobItemBlueprint, "advertRichJobItemBlueprint");
        Intrinsics.checkNotNullParameter(advertVipRichJobItemBlueprint, "advertVipRichJobItemBlueprint");
        Intrinsics.checkNotNullParameter(advertXlRichJobItemBlueprint, "advertXlRichJobItemBlueprint");
        Intrinsics.checkNotNullParameter(advertRichItemBlueprint, "advertRichItemBlueprint");
        Intrinsics.checkNotNullParameter(yandexContentSingleGridBlueprint, "yandexContentSingleGridBlueprint");
        Intrinsics.checkNotNullParameter(yandexContentRichBlueprint, "yandexContentRichBlueprint");
        Intrinsics.checkNotNullParameter(yandexAppInstallRichBlueprint, "yandexAppInstallRichBlueprint");
        Intrinsics.checkNotNullParameter(yandexContentDoubleGridBlueprint, "yandexContentDoubleGridBlueprint");
        Intrinsics.checkNotNullParameter(yandexAppInstallSingleItemBlueprint, "yandexAppInstallSingleItemBlueprint");
        Intrinsics.checkNotNullParameter(yandexAppInstallDoubleItemBlueprint, "yandexAppInstallDoubleItemBlueprint");
        Intrinsics.checkNotNullParameter(adfoxSingleGridBlueprint, "adfoxSingleGridBlueprint");
        Intrinsics.checkNotNullParameter(adfoxSingleListBlueprint, "adfoxSingleListBlueprint");
        Intrinsics.checkNotNullParameter(dfpUnifiedDoubleBlueprint, "dfpUnifiedDoubleBlueprint");
        Intrinsics.checkNotNullParameter(dfpUnifiedSingleGridBlueprint, "dfpUnifiedSingleGridBlueprint");
        Intrinsics.checkNotNullParameter(dfpAppInstallDoubleBlueprint, "dfpAppInstallDoubleBlueprint");
        Intrinsics.checkNotNullParameter(dfpAppInstallSingleBlueprint, "dfpAppInstallSingleBlueprint");
        Intrinsics.checkNotNullParameter(dfpContentSingleGridBlueprint, "dfpContentSingleGridBlueprint");
        Intrinsics.checkNotNullParameter(dfpContentDoubleGridBlueprint, "dfpContentDoubleGridBlueprint");
        Intrinsics.checkNotNullParameter(myTargetContentSingleBlueprint, "myTargetContentSingleBlueprint");
        Intrinsics.checkNotNullParameter(myTargetContentBlueprint, "myTargetContentBlueprint");
        Intrinsics.checkNotNullParameter(myTargetAppInstallSingleBlueprint, "myTargetAppInstallSingleBlueprint");
        Intrinsics.checkNotNullParameter(myTargetAppInstallBlueprint, "myTargetAppInstallBlueprint");
        Intrinsics.checkNotNullParameter(shortcutBannerBlueprint, "shortcutBannerBlueprint");
        Intrinsics.checkNotNullParameter(serpWarningItemBlueprint, "serpWarningItemBlueprint");
        Intrinsics.checkNotNullParameter(snippetBlueprint, "snippetBlueprint");
        Intrinsics.checkNotNullParameter(emptyAdStubItemBlueprint, "emptyAdStubItemBlueprint");
        Intrinsics.checkNotNullParameter(emptySearchItemBlueprint, "emptySearchItemBlueprint");
        Intrinsics.checkNotNullParameter(homeSerpHeaderBluePrint, "homeSerpHeaderBluePrint");
        Intrinsics.checkNotNullParameter(notLoadAdStubGridBlueprint, "notLoadAdStubGridBlueprint");
        Intrinsics.checkNotNullParameter(appendingLoaderItemBlueprint, "appendingLoaderItemBlueprint");
        Intrinsics.checkNotNullParameter(appendingRetryItemBlueprint, "appendingRetryItemBlueprint");
        Intrinsics.checkNotNullParameter(groupTitleItemBlueprint, "groupTitleItemBlueprint");
        Intrinsics.checkNotNullParameter(emptyPlaceholderItemBlueprint, "emptyPlaceholderItemBlueprint");
        Intrinsics.checkNotNullParameter(yandexContentListBlueprint, "yandexContentListBlueprint");
        Intrinsics.checkNotNullParameter(yandexAppInstallListItemBlueprint, "yandexAppInstallListItemBlueprint");
        Intrinsics.checkNotNullParameter(dfpUnifiedListBlueprint, "dfpUnifiedListBlueprint");
        Intrinsics.checkNotNullParameter(dfpContentListBlueprint, "dfpContentListBlueprint");
        Intrinsics.checkNotNullParameter(dfpAppInstallListBlueprint, "dfpAppInstallListBlueprint");
        Intrinsics.checkNotNullParameter(myTargetContentListBlueprint, "myTargetContentListBlueprint");
        Intrinsics.checkNotNullParameter(myTargetAppInstallListBlueprint, "myTargetAppInstallListBlueprint");
        Intrinsics.checkNotNullParameter(notLoadAdStubListBlueprint, "notLoadAdStubListBlueprint");
        Intrinsics.checkNotNullParameter(notLoadAdRichStubBlueprint, "notLoadAdStubRichBlueprint");
        Intrinsics.checkNotNullParameter(witcherItemBlueprint, "witcherItemBlueprint");
        Intrinsics.checkNotNullParameter(verticalFilterItemBlueprint, "verticalFilterItemBlueprint");
        Intrinsics.checkNotNullParameter(promoCardBlueprint, "promoCardBlueprint");
        Intrinsics.checkNotNullParameter(mapBannerItemBlueprint, "mapBannerItemBlueprint");
        Intrinsics.checkNotNullParameter(set, "blueprints");
        ItemBinder.Builder registerItem = new ItemBinder.Builder().registerItem(advertItemListBlueprint).registerItem(advertItemGridBlueprint).registerItem(advertItemDoubleBlueprint).registerItem(advertVipRichItemBlueprint).registerItem(advertXlRichItemBlueprint).registerItem(advertRichItemBlueprint).registerItem(advertXlItemBlueprint).registerItem(advertRichJobItemBlueprint).registerItem(advertVipRichJobItemBlueprint).registerItem(advertXlRichJobItemBlueprint).registerItem(shortcutBannerBlueprint).registerItem(serpWarningItemBlueprint).registerItem(snippetBlueprint).registerItem(emptySearchItemBlueprint).registerItem(homeSerpHeaderBluePrint).registerItem(appendingLoaderItemBlueprint).registerItem(appendingRetryItemBlueprint).registerItem(groupTitleItemBlueprint).registerItem(emptyPlaceholderItemBlueprint).registerItem(witcherItemBlueprint).registerItem(verticalFilterItemBlueprint).registerItem(promoCardBlueprint).registerItem(yandexContentSingleGridBlueprint).registerItem(yandexContentDoubleGridBlueprint).registerItem(yandexContentRichBlueprint).registerItem(yandexAppInstallRichBlueprint).registerItem(yandexAppInstallSingleItemBlueprint).registerItem(yandexAppInstallDoubleItemBlueprint).registerItem(yandexContentListBlueprint).registerItem(yandexAppInstallListItemBlueprint).registerItem(adfoxSingleGridBlueprint).registerItem(adfoxSingleListBlueprint).registerItem(dfpUnifiedSingleGridBlueprint).registerItem(dfpUnifiedDoubleBlueprint).registerItem(dfpContentSingleGridBlueprint).registerItem(dfpContentDoubleGridBlueprint).registerItem(dfpAppInstallDoubleBlueprint).registerItem(dfpAppInstallSingleBlueprint).registerItem(dfpUnifiedListBlueprint).registerItem(dfpContentListBlueprint).registerItem(dfpAppInstallListBlueprint).registerItem(myTargetAppInstallSingleBlueprint).registerItem(myTargetAppInstallBlueprint).registerItem(myTargetContentSingleBlueprint).registerItem(myTargetContentBlueprint).registerItem(myTargetContentListBlueprint).registerItem(myTargetAppInstallListBlueprint).registerItem(notLoadAdStubGridBlueprint).registerItem(notLoadAdStubListBlueprint).registerItem(notLoadAdRichStubBlueprint).registerItem(emptyAdStubItemBlueprint);
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            registerItem.registerItem(it.next());
        }
        return registerItem.registerItem(mapBannerItemBlueprint).build();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemVisibilityTracker provideItemVisibilityTracker$serp_release(@NotNull BannerViewFilter bannerViewFilter, @SerpItemVisibilityTrackerState @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(bannerViewFilter, "bannerViewFilter");
        return new ItemVisibilityTrackerImpl.Builder(true, bundle).addFilter(bannerViewFilter).build();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SerpAnalyticsInteractor provideSerpAnalyticsInteractor$serp_release(@NotNull Analytics analytics, @NotNull TreeStateIdGenerator treeStateIdGenerator, @NotNull SerpArguments serpArguments, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(treeStateIdGenerator, "treeStateIdGenerator");
        Intrinsics.checkNotNullParameter(serpArguments, "serpArguments");
        Intrinsics.checkNotNullParameter(features, "features");
        return new SerpAnalyticsInteractorImpl(analytics, treeStateIdGenerator, serpArguments.getTreeParent(), serpArguments.getFromPage(), features);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final TreeClickStreamParent provideSerpTreeParent$serp_release(@NotNull SerpAnalyticsInteractor serpAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(serpAnalyticsInteractor, "serpAnalyticsInteractor");
        return serpAnalyticsInteractor.getParent();
    }

    @Provides
    @JvmStatic
    @Nullable
    @PerFragment
    public static final SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup> provideViewedItemsTabTestGroup() {
        return null;
    }

    @Provides
    @JvmStatic
    @InitialQuery
    @Nullable
    public static final String providesInitialQuery$serp_release(@NotNull SerpArguments serpArguments) {
        Intrinsics.checkNotNullParameter(serpArguments, "serpArguments");
        SearchParams searchParams = serpArguments.getSearchParams();
        if (searchParams != null) {
            return searchParams.getQuery();
        }
        return null;
    }

    @Provides
    @NotNull
    public final SearchContextWrapper provideSearchContextWrapper$serp_release(@NotNull SerpArguments serpArguments) {
        Intrinsics.checkNotNullParameter(serpArguments, "serpArguments");
        return new SearchContextWrapper(serpArguments.getContext());
    }
}
