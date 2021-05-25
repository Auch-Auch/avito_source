package com.avito.android.search.map.di;

import a2.b.a.a.a;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.advert.viewed.ViewedAdvertsPresenterImpl;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.interactor.SnippetScrollDepthAnalyticsInteractor;
import com.avito.android.analytics.interactor.SnippetScrollDepthAnalyticsInteractorImpl;
import com.avito.android.di.PerFragment;
import com.avito.android.di.module.AdsItemModule;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsPresenterImpl;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.item_visibility_tracker.ItemVisibilityTrackerImpl;
import com.avito.android.item_visibility_tracker.filters.BannerViewFilter;
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
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.base.DestroyableViewHolderBuilderImpl;
import com.avito.android.recycler.base.SafeRecyclerAdapter;
import com.avito.android.scroll_tracker.SnippetScrollDepthTracker;
import com.avito.android.scroll_tracker.SnippetScrollDepthTrackerImpl;
import com.avito.android.search.map.view.SerpListResourcesProvider;
import com.avito.android.search.map.view.SerpListResourcesProviderImpl;
import com.avito.android.search.map.view.SerpListViewBinder;
import com.avito.android.search.map.view.SerpListViewBinderImpl;
import com.avito.android.search.map.view.adapter.AppendingRetryListener;
import com.avito.android.search.map.view.adapter.AppendingRetryListenerImpl;
import com.avito.android.serp.CommercialBannersInteractor;
import com.avito.android.serp.SerpItemProcessor;
import com.avito.android.serp.adapter.AdvertItemDoubleBlueprint;
import com.avito.android.serp.adapter.AdvertItemGridBlueprint;
import com.avito.android.serp.adapter.AdvertItemListBlueprint;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.adstub.EmptyAdStubItemBlueprint;
import com.avito.android.serp.adapter.adstub.NotLoadAdRichStubBlueprint;
import com.avito.android.serp.adapter.adstub.NotLoadAdStubGridBlueprint;
import com.avito.android.serp.adapter.adstub.NotLoadAdStubListBlueprint;
import com.avito.android.serp.adapter.advert_xl.AdvertXlItemBlueprint;
import com.avito.android.serp.adapter.closable.di.ClosedItemModule;
import com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemBlueprint;
import com.avito.android.serp.adapter.map_banner.MapBannerItemBlueprint;
import com.avito.android.serp.adapter.promo_card.PromoCardBlueprint;
import com.avito.android.serp.adapter.rich_snippets.YandexAppInstallRichBlueprint;
import com.avito.android.serp.adapter.rich_snippets.YandexContentRichBlueprint;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichItemBlueprint;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertVipRichItemBlueprint;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertXlRichItemBlueprint;
import com.avito.android.serp.adapter.snippet.SnippetBlueprint;
import com.avito.android.serp.adapter.title.GroupTitleItemBlueprint;
import com.avito.android.serp.adapter.warning.SerpWarningItemBlueprint;
import com.avito.android.serp.adapter.witcher.WitcherItemBlueprint;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000È\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001uB\t\b\u0002¢\u0006\u0004\bs\u0010tJ#\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJç\u0002\u0010a\u001a\u00020`2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u0002002\u0006\u00103\u001a\u0002022\u0006\u00105\u001a\u0002042\u0006\u00107\u001a\u0002062\u0006\u00109\u001a\u0002082\u0006\u0010;\u001a\u00020:2\u0006\u0010=\u001a\u00020<2\u0006\u0010?\u001a\u00020>2\u0006\u0010A\u001a\u00020@2\u0006\u0010C\u001a\u00020B2\u0006\u0010E\u001a\u00020D2\u0006\u0010G\u001a\u00020F2\u0006\u0010I\u001a\u00020H2\u0006\u0010K\u001a\u00020J2\u0006\u0010M\u001a\u00020L2\u0006\u0010O\u001a\u00020N2\u0006\u0010Q\u001a\u00020P2\u0006\u0010S\u001a\u00020R2\u0006\u0010U\u001a\u00020T2\u0006\u0010W\u001a\u00020V2\u0006\u0010Y\u001a\u00020X2\u0006\u0010[\u001a\u00020Z2\u0006\u0010]\u001a\u00020\\2\u0006\u0010_\u001a\u00020^H\u0007¢\u0006\u0004\ba\u0010bJ\u0019\u0010e\u001a\u00020d2\b\b\u0001\u0010c\u001a\u00020`H\u0007¢\u0006\u0004\be\u0010fJ3\u0010o\u001a\u00020n2\b\b\u0001\u0010g\u001a\u00020d2\b\b\u0001\u0010i\u001a\u00020h2\u0006\u0010k\u001a\u00020j2\u0006\u0010m\u001a\u00020lH\u0007¢\u0006\u0004\bo\u0010pJ\u0019\u0010q\u001a\u00020h2\b\b\u0001\u0010c\u001a\u00020`H\u0007¢\u0006\u0004\bq\u0010r¨\u0006v"}, d2 = {"Lcom/avito/android/search/map/di/SerpListModule;", "", "Lcom/avito/android/item_visibility_tracker/filters/BannerViewFilter;", "bannerViewFilter", "Landroid/os/Bundle;", "state", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "provideItemVisibilityTracker$map_release", "(Lcom/avito/android/item_visibility_tracker/filters/BannerViewFilter;Landroid/os/Bundle;)Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "provideItemVisibilityTracker", "Lcom/avito/android/serp/adapter/AdvertItemGridBlueprint;", "advertItemGridBlueprint", "Lcom/avito/android/serp/adapter/AdvertItemListBlueprint;", "advertItemListBlueprint", "Lcom/avito/android/serp/adapter/AdvertItemDoubleBlueprint;", "advertItemDoubleBlueprint", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItemBlueprint;", "advertXlItemBlueprint", "Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertVipRichItemBlueprint;", "advertVipRichItemBlueprint", "Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertXlRichItemBlueprint;", "advertXlRichItemBlueprint", "Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertRichItemBlueprint;", "advertRichItemBlueprint", "Lcom/avito/android/module/serp/adapter/ad/yandex/content/YandexContentSingleGridBlueprint;", "yandexContentSingleGridBlueprint", "Lcom/avito/android/module/serp/adapter/ad/yandex/content/YandexContentDoubleGridBlueprint;", "yandexContentDoubleGridBlueprint", "Lcom/avito/android/serp/adapter/rich_snippets/YandexContentRichBlueprint;", "yandexContentRichBlueprint", "Lcom/avito/android/module/serp/adapter/ad/yandex/app_install/YandexAppInstallSingleItemBlueprint;", "yandexAppInstallSingleItemBlueprint", "Lcom/avito/android/module/serp/adapter/ad/yandex/app_install/YandexAppInstallDoubleItemBlueprint;", "yandexAppInstallDoubleItemBlueprint", "Lcom/avito/android/serp/adapter/rich_snippets/YandexAppInstallRichBlueprint;", "yandexAppInstallRichBlueprint", "Lcom/avito/android/module/serp/adapter/ad/adfox/AdfoxSingleGridBlueprint;", "adfoxSingleGridBlueprint", "Lcom/avito/android/module/serp/adapter/ad/adfox/AdfoxSingleListBlueprint;", "adfoxSingleListBlueprint", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpUnifiedDoubleBlueprint;", "dfpUnifiedDoubleBlueprint", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpAppInstallDoubleBlueprint;", "dfpAppInstallDoubleBlueprint", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpAppInstallSingleBlueprint;", "dfpAppInstallSingleBlueprint", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpUnifiedSingleGridBlueprint;", "dfpUnifiedSingleBlueprint", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpContentSingleGridBlueprint;", "dfpContentSingleGridBlueprint", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpContentDoubleGridBlueprint;", "dfpContentDoubleGridBlueprint", "Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetContentBlueprint;", "myTargetContentBlueprint", "Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetAppInstallSingleBlueprint;", "myTargetAppInstallSingleBlueprint", "Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetAppInstallBlueprint;", "myTargetAppInstallBlueprint", "Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetContentSingleBlueprint;", "myTargetContentSingleBlueprint", "Lcom/avito/android/serp/adapter/adstub/NotLoadAdStubGridBlueprint;", "notLoadAdStubGridBlueprint", "Lcom/avito/android/serp/adapter/adstub/EmptyAdStubItemBlueprint;", "emptyAdStubItemBlueprint", "Lcom/avito/android/serp/adapter/warning/SerpWarningItemBlueprint;", "serpWarningItemBlueprint", "Lcom/avito/android/serp/adapter/snippet/SnippetBlueprint;", "snippetBlueprint", "Lcom/avito/android/serp/adapter/title/GroupTitleItemBlueprint;", "groupTitleItemBlueprint", "Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemBlueprint;", "emptyPlaceholderItemBlueprint", "Lcom/avito/android/module/serp/adapter/ad/yandex/content/YandexContentListBlueprint;", "yandexContentListBlueprint", "Lcom/avito/android/module/serp/adapter/ad/yandex/app_install/YandexAppInstallListItemBlueprint;", "yandexAppInstallListItemBlueprint", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpUnifiedListBlueprint;", "dfpUnifiedListBlueprint", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpContentListBlueprint;", "dfpContentListBlueprint", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpAppInstallListBlueprint;", "dfpAppInstallListBlueprint", "Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetContentListBlueprint;", "myTargetContentListBlueprint", "Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetAppInstallListBlueprint;", "myTargetAppInstallListBlueprint", "Lcom/avito/android/serp/adapter/adstub/NotLoadAdStubListBlueprint;", "notLoadAdStubListBlueprint", "Lcom/avito/android/serp/adapter/adstub/NotLoadAdRichStubBlueprint;", "notLoadAdStubRichBlueprint", "Lcom/avito/android/serp/adapter/witcher/WitcherItemBlueprint;", "witcherItemBlueprint", "Lcom/avito/android/serp/adapter/promo_card/PromoCardBlueprint;", "promoCardBlueprint", "Lcom/avito/android/serp/adapter/map_banner/MapBannerItemBlueprint;", "mapBannerItemBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideSerpListItemBinder", "(Lcom/avito/android/serp/adapter/AdvertItemGridBlueprint;Lcom/avito/android/serp/adapter/AdvertItemListBlueprint;Lcom/avito/android/serp/adapter/AdvertItemDoubleBlueprint;Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItemBlueprint;Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertVipRichItemBlueprint;Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertXlRichItemBlueprint;Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertRichItemBlueprint;Lcom/avito/android/module/serp/adapter/ad/yandex/content/YandexContentSingleGridBlueprint;Lcom/avito/android/module/serp/adapter/ad/yandex/content/YandexContentDoubleGridBlueprint;Lcom/avito/android/serp/adapter/rich_snippets/YandexContentRichBlueprint;Lcom/avito/android/module/serp/adapter/ad/yandex/app_install/YandexAppInstallSingleItemBlueprint;Lcom/avito/android/module/serp/adapter/ad/yandex/app_install/YandexAppInstallDoubleItemBlueprint;Lcom/avito/android/serp/adapter/rich_snippets/YandexAppInstallRichBlueprint;Lcom/avito/android/module/serp/adapter/ad/adfox/AdfoxSingleGridBlueprint;Lcom/avito/android/module/serp/adapter/ad/adfox/AdfoxSingleListBlueprint;Lcom/avito/android/module/serp/adapter/ad/dfp/DfpUnifiedDoubleBlueprint;Lcom/avito/android/module/serp/adapter/ad/dfp/DfpAppInstallDoubleBlueprint;Lcom/avito/android/module/serp/adapter/ad/dfp/DfpAppInstallSingleBlueprint;Lcom/avito/android/module/serp/adapter/ad/dfp/DfpUnifiedSingleGridBlueprint;Lcom/avito/android/module/serp/adapter/ad/dfp/DfpContentSingleGridBlueprint;Lcom/avito/android/module/serp/adapter/ad/dfp/DfpContentDoubleGridBlueprint;Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetContentBlueprint;Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetAppInstallSingleBlueprint;Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetAppInstallBlueprint;Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetContentSingleBlueprint;Lcom/avito/android/serp/adapter/adstub/NotLoadAdStubGridBlueprint;Lcom/avito/android/serp/adapter/adstub/EmptyAdStubItemBlueprint;Lcom/avito/android/serp/adapter/warning/SerpWarningItemBlueprint;Lcom/avito/android/serp/adapter/snippet/SnippetBlueprint;Lcom/avito/android/serp/adapter/title/GroupTitleItemBlueprint;Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemBlueprint;Lcom/avito/android/module/serp/adapter/ad/yandex/content/YandexContentListBlueprint;Lcom/avito/android/module/serp/adapter/ad/yandex/app_install/YandexAppInstallListItemBlueprint;Lcom/avito/android/module/serp/adapter/ad/dfp/DfpUnifiedListBlueprint;Lcom/avito/android/module/serp/adapter/ad/dfp/DfpContentListBlueprint;Lcom/avito/android/module/serp/adapter/ad/dfp/DfpAppInstallListBlueprint;Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetContentListBlueprint;Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetAppInstallListBlueprint;Lcom/avito/android/serp/adapter/adstub/NotLoadAdStubListBlueprint;Lcom/avito/android/serp/adapter/adstub/NotLoadAdRichStubBlueprint;Lcom/avito/android/serp/adapter/witcher/WitcherItemBlueprint;Lcom/avito/android/serp/adapter/promo_card/PromoCardBlueprint;Lcom/avito/android/serp/adapter/map_banner/MapBannerItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideSerpListAdapterPresenter", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "viewHolderBuilder", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideSerpListAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;Lcom/avito/android/util/BuildInfo;Lcom/avito/android/analytics/Analytics;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideDestroyableViewHolderBuilder", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "<init>", "()V", "Declarations", "map_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdsItemModule.class, ClosedItemModule.class, Declarations.class})
public final class SerpListModule {
    @NotNull
    public static final SerpListModule INSTANCE = new SerpListModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0015H'¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u0019H'¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH'¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u0011\u001a\u00020 H'¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020#2\u0006\u0010$\u001a\u00020#H'¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020'2\u0006\u0010(\u001a\u00020'H'¢\u0006\u0004\b)\u0010*J\u0017\u0010.\u001a\u00020-2\u0006\u0010,\u001a\u00020+H'¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u0002012\u0006\u0010$\u001a\u000200H'¢\u0006\u0004\b2\u00103¨\u00064"}, d2 = {"Lcom/avito/android/search/map/di/SerpListModule$Declarations;", "", "Lcom/avito/android/favorite/FavoriteAdvertsPresenterImpl;", "presenter", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "binFavoriteAdvertsPresenter", "(Lcom/avito/android/favorite/FavoriteAdvertsPresenterImpl;)Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenterImpl;", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "binViewedAdvertsPresenter", "(Lcom/avito/android/advert/viewed/ViewedAdvertsPresenterImpl;)Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "Lcom/avito/android/search/map/view/SerpListViewBinderImpl;", "binder", "Lcom/avito/android/search/map/view/SerpListViewBinder;", "binSerpListViewBinder", "(Lcom/avito/android/search/map/view/SerpListViewBinderImpl;)Lcom/avito/android/search/map/view/SerpListViewBinder;", "Lcom/avito/android/search/map/view/SerpListResourcesProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/search/map/view/SerpListResourcesProvider;", "binSerpListResourcesProvider", "(Lcom/avito/android/search/map/view/SerpListResourcesProviderImpl;)Lcom/avito/android/search/map/view/SerpListResourcesProvider;", "Lcom/avito/android/search/map/view/adapter/AppendingRetryListenerImpl;", "Lcom/avito/android/search/map/view/adapter/AppendingRetryListener;", "binAppendingRetryListener", "(Lcom/avito/android/search/map/view/adapter/AppendingRetryListenerImpl;)Lcom/avito/android/search/map/view/adapter/AppendingRetryListener;", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "binSpannedGridPositionProvider", "(Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;)Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "lookup", "bindSpanSizeLookup", "(Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;)Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "bindSerpSpanProvider", "(Lcom/avito/android/serp/adapter/SerpSpanProvider;)Lcom/avito/android/serp/adapter/SerpSpanProvider;", "Lcom/avito/android/serp/CommercialBannersInteractor;", "interactor", "bindSerpBannersInteractor", "(Lcom/avito/android/serp/CommercialBannersInteractor;)Lcom/avito/android/serp/CommercialBannersInteractor;", "Lcom/avito/android/serp/SerpItemProcessor;", "processor", "bindSerpItemProcessor", "(Lcom/avito/android/serp/SerpItemProcessor;)Lcom/avito/android/serp/SerpItemProcessor;", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthTrackerImpl;", "userScrollTracker", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker;", "bindUserScrollTracker", "(Lcom/avito/android/scroll_tracker/SnippetScrollDepthTrackerImpl;)Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker;", "Lcom/avito/android/analytics/interactor/SnippetScrollDepthAnalyticsInteractorImpl;", "Lcom/avito/android/analytics/interactor/SnippetScrollDepthAnalyticsInteractor;", "bindsSnippetScrollDepthAnalyticsInteractor", "(Lcom/avito/android/analytics/interactor/SnippetScrollDepthAnalyticsInteractorImpl;)Lcom/avito/android/analytics/interactor/SnippetScrollDepthAnalyticsInteractor;", "map_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @SerpList
        @Binds
        @NotNull
        @PerFragment
        AppendingRetryListener binAppendingRetryListener(@NotNull AppendingRetryListenerImpl appendingRetryListenerImpl);

        @SerpList
        @Binds
        @NotNull
        @PerFragment
        FavoriteAdvertsPresenter binFavoriteAdvertsPresenter(@NotNull FavoriteAdvertsPresenterImpl favoriteAdvertsPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        SerpListResourcesProvider binSerpListResourcesProvider(@NotNull SerpListResourcesProviderImpl serpListResourcesProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        SerpListViewBinder binSerpListViewBinder(@NotNull SerpListViewBinderImpl serpListViewBinderImpl);

        @SerpList
        @Binds
        @NotNull
        @PerFragment
        SpannedGridPositionProvider binSpannedGridPositionProvider(@NotNull SpannedGridPositionProvider spannedGridPositionProvider);

        @SerpList
        @Binds
        @NotNull
        @PerFragment
        ViewedAdvertsPresenter binViewedAdvertsPresenter(@NotNull ViewedAdvertsPresenterImpl viewedAdvertsPresenterImpl);

        @SerpList
        @Binds
        @NotNull
        @PerFragment
        CommercialBannersInteractor bindSerpBannersInteractor(@NotNull CommercialBannersInteractor commercialBannersInteractor);

        @SerpList
        @Binds
        @NotNull
        @PerFragment
        SerpItemProcessor bindSerpItemProcessor(@NotNull SerpItemProcessor serpItemProcessor);

        @SerpList
        @Binds
        @NotNull
        @PerFragment
        SerpSpanProvider bindSerpSpanProvider(@NotNull SerpSpanProvider serpSpanProvider);

        @SerpList
        @Binds
        @NotNull
        @PerFragment
        GridLayoutManager.SpanSizeLookup bindSpanSizeLookup(@NotNull GridLayoutManager.SpanSizeLookup spanSizeLookup);

        @PerFragment
        @Binds
        @NotNull
        SnippetScrollDepthTracker bindUserScrollTracker(@NotNull SnippetScrollDepthTrackerImpl snippetScrollDepthTrackerImpl);

        @PerFragment
        @Binds
        @NotNull
        SnippetScrollDepthAnalyticsInteractor bindsSnippetScrollDepthAnalyticsInteractor(@NotNull SnippetScrollDepthAnalyticsInteractorImpl snippetScrollDepthAnalyticsInteractorImpl);
    }

    @Provides
    @JvmStatic
    @SerpList
    @NotNull
    @PerFragment
    public static final DestroyableViewHolderBuilder provideDestroyableViewHolderBuilder(@SerpList @NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        return new DestroyableViewHolderBuilderImpl(itemBinder);
    }

    @Provides
    @JvmStatic
    @SerpList
    @NotNull
    @PerFragment
    public static final ItemVisibilityTracker provideItemVisibilityTracker$map_release(@NotNull BannerViewFilter bannerViewFilter, @SerpListItemVisibilityTrackerState @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(bannerViewFilter, "bannerViewFilter");
        return new ItemVisibilityTrackerImpl.Builder(false, bundle).addFilter(bannerViewFilter).build();
    }

    @Provides
    @JvmStatic
    @SerpList
    @NotNull
    @PerFragment
    public static final SimpleRecyclerAdapter provideSerpListAdapter(@SerpList @NotNull AdapterPresenter adapterPresenter, @SerpList @NotNull DestroyableViewHolderBuilder destroyableViewHolderBuilder, @NotNull BuildInfo buildInfo, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(destroyableViewHolderBuilder, "viewHolderBuilder");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        return new SafeRecyclerAdapter(adapterPresenter, destroyableViewHolderBuilder, buildInfo, analytics);
    }

    @Provides
    @JvmStatic
    @SerpList
    @NotNull
    @PerFragment
    public static final AdapterPresenter provideSerpListAdapterPresenter(@SerpList @NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @SerpList
    @NotNull
    @PerFragment
    public static final ItemBinder provideSerpListItemBinder(@NotNull AdvertItemGridBlueprint advertItemGridBlueprint, @NotNull AdvertItemListBlueprint advertItemListBlueprint, @NotNull AdvertItemDoubleBlueprint advertItemDoubleBlueprint, @NotNull AdvertXlItemBlueprint advertXlItemBlueprint, @NotNull AdvertVipRichItemBlueprint advertVipRichItemBlueprint, @NotNull AdvertXlRichItemBlueprint advertXlRichItemBlueprint, @NotNull AdvertRichItemBlueprint advertRichItemBlueprint, @NotNull YandexContentSingleGridBlueprint yandexContentSingleGridBlueprint, @NotNull YandexContentDoubleGridBlueprint yandexContentDoubleGridBlueprint, @NotNull YandexContentRichBlueprint yandexContentRichBlueprint, @NotNull YandexAppInstallSingleItemBlueprint yandexAppInstallSingleItemBlueprint, @NotNull YandexAppInstallDoubleItemBlueprint yandexAppInstallDoubleItemBlueprint, @NotNull YandexAppInstallRichBlueprint yandexAppInstallRichBlueprint, @NotNull AdfoxSingleGridBlueprint adfoxSingleGridBlueprint, @NotNull AdfoxSingleListBlueprint adfoxSingleListBlueprint, @NotNull DfpUnifiedDoubleBlueprint dfpUnifiedDoubleBlueprint, @NotNull DfpAppInstallDoubleBlueprint dfpAppInstallDoubleBlueprint, @NotNull DfpAppInstallSingleBlueprint dfpAppInstallSingleBlueprint, @NotNull DfpUnifiedSingleGridBlueprint dfpUnifiedSingleGridBlueprint, @NotNull DfpContentSingleGridBlueprint dfpContentSingleGridBlueprint, @NotNull DfpContentDoubleGridBlueprint dfpContentDoubleGridBlueprint, @NotNull MyTargetContentBlueprint myTargetContentBlueprint, @NotNull MyTargetAppInstallSingleBlueprint myTargetAppInstallSingleBlueprint, @NotNull MyTargetAppInstallBlueprint myTargetAppInstallBlueprint, @NotNull MyTargetContentSingleBlueprint myTargetContentSingleBlueprint, @NotNull NotLoadAdStubGridBlueprint notLoadAdStubGridBlueprint, @NotNull EmptyAdStubItemBlueprint emptyAdStubItemBlueprint, @NotNull SerpWarningItemBlueprint serpWarningItemBlueprint, @NotNull SnippetBlueprint snippetBlueprint, @NotNull GroupTitleItemBlueprint groupTitleItemBlueprint, @NotNull EmptyPlaceholderItemBlueprint emptyPlaceholderItemBlueprint, @NotNull YandexContentListBlueprint yandexContentListBlueprint, @NotNull YandexAppInstallListItemBlueprint yandexAppInstallListItemBlueprint, @NotNull DfpUnifiedListBlueprint dfpUnifiedListBlueprint, @NotNull DfpContentListBlueprint dfpContentListBlueprint, @NotNull DfpAppInstallListBlueprint dfpAppInstallListBlueprint, @NotNull MyTargetContentListBlueprint myTargetContentListBlueprint, @NotNull MyTargetAppInstallListBlueprint myTargetAppInstallListBlueprint, @NotNull NotLoadAdStubListBlueprint notLoadAdStubListBlueprint, @NotNull NotLoadAdRichStubBlueprint notLoadAdRichStubBlueprint, @NotNull WitcherItemBlueprint witcherItemBlueprint, @NotNull PromoCardBlueprint promoCardBlueprint, @NotNull MapBannerItemBlueprint mapBannerItemBlueprint) {
        Intrinsics.checkNotNullParameter(advertItemGridBlueprint, "advertItemGridBlueprint");
        Intrinsics.checkNotNullParameter(advertItemListBlueprint, "advertItemListBlueprint");
        Intrinsics.checkNotNullParameter(advertItemDoubleBlueprint, "advertItemDoubleBlueprint");
        Intrinsics.checkNotNullParameter(advertXlItemBlueprint, "advertXlItemBlueprint");
        Intrinsics.checkNotNullParameter(advertVipRichItemBlueprint, "advertVipRichItemBlueprint");
        Intrinsics.checkNotNullParameter(advertXlRichItemBlueprint, "advertXlRichItemBlueprint");
        Intrinsics.checkNotNullParameter(advertRichItemBlueprint, "advertRichItemBlueprint");
        Intrinsics.checkNotNullParameter(yandexContentSingleGridBlueprint, "yandexContentSingleGridBlueprint");
        Intrinsics.checkNotNullParameter(yandexContentDoubleGridBlueprint, "yandexContentDoubleGridBlueprint");
        Intrinsics.checkNotNullParameter(yandexContentRichBlueprint, "yandexContentRichBlueprint");
        Intrinsics.checkNotNullParameter(yandexAppInstallSingleItemBlueprint, "yandexAppInstallSingleItemBlueprint");
        Intrinsics.checkNotNullParameter(yandexAppInstallDoubleItemBlueprint, "yandexAppInstallDoubleItemBlueprint");
        Intrinsics.checkNotNullParameter(yandexAppInstallRichBlueprint, "yandexAppInstallRichBlueprint");
        Intrinsics.checkNotNullParameter(adfoxSingleGridBlueprint, "adfoxSingleGridBlueprint");
        Intrinsics.checkNotNullParameter(adfoxSingleListBlueprint, "adfoxSingleListBlueprint");
        Intrinsics.checkNotNullParameter(dfpUnifiedDoubleBlueprint, "dfpUnifiedDoubleBlueprint");
        Intrinsics.checkNotNullParameter(dfpAppInstallDoubleBlueprint, "dfpAppInstallDoubleBlueprint");
        Intrinsics.checkNotNullParameter(dfpAppInstallSingleBlueprint, "dfpAppInstallSingleBlueprint");
        Intrinsics.checkNotNullParameter(dfpUnifiedSingleGridBlueprint, "dfpUnifiedSingleBlueprint");
        Intrinsics.checkNotNullParameter(dfpContentSingleGridBlueprint, "dfpContentSingleGridBlueprint");
        Intrinsics.checkNotNullParameter(dfpContentDoubleGridBlueprint, "dfpContentDoubleGridBlueprint");
        Intrinsics.checkNotNullParameter(myTargetContentBlueprint, "myTargetContentBlueprint");
        Intrinsics.checkNotNullParameter(myTargetAppInstallSingleBlueprint, "myTargetAppInstallSingleBlueprint");
        Intrinsics.checkNotNullParameter(myTargetAppInstallBlueprint, "myTargetAppInstallBlueprint");
        Intrinsics.checkNotNullParameter(myTargetContentSingleBlueprint, "myTargetContentSingleBlueprint");
        Intrinsics.checkNotNullParameter(notLoadAdStubGridBlueprint, "notLoadAdStubGridBlueprint");
        Intrinsics.checkNotNullParameter(emptyAdStubItemBlueprint, "emptyAdStubItemBlueprint");
        Intrinsics.checkNotNullParameter(serpWarningItemBlueprint, "serpWarningItemBlueprint");
        Intrinsics.checkNotNullParameter(snippetBlueprint, "snippetBlueprint");
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
        Intrinsics.checkNotNullParameter(promoCardBlueprint, "promoCardBlueprint");
        Intrinsics.checkNotNullParameter(mapBannerItemBlueprint, "mapBannerItemBlueprint");
        return new ItemBinder.Builder().registerItem(serpWarningItemBlueprint).registerItem(groupTitleItemBlueprint).registerItem(emptyPlaceholderItemBlueprint).registerItem(snippetBlueprint).registerItem(advertItemListBlueprint).registerItem(advertItemGridBlueprint).registerItem(advertItemDoubleBlueprint).registerItem(advertXlItemBlueprint).registerItem(advertVipRichItemBlueprint).registerItem(advertXlRichItemBlueprint).registerItem(advertRichItemBlueprint).registerItem(witcherItemBlueprint).registerItem(promoCardBlueprint).registerItem(mapBannerItemBlueprint).registerItem(yandexContentSingleGridBlueprint).registerItem(yandexContentDoubleGridBlueprint).registerItem(yandexContentRichBlueprint).registerItem(yandexAppInstallSingleItemBlueprint).registerItem(yandexAppInstallDoubleItemBlueprint).registerItem(yandexAppInstallRichBlueprint).registerItem(yandexContentListBlueprint).registerItem(yandexAppInstallListItemBlueprint).registerItem(adfoxSingleGridBlueprint).registerItem(adfoxSingleListBlueprint).registerItem(dfpUnifiedSingleGridBlueprint).registerItem(dfpContentSingleGridBlueprint).registerItem(dfpContentDoubleGridBlueprint).registerItem(dfpUnifiedDoubleBlueprint).registerItem(dfpAppInstallDoubleBlueprint).registerItem(dfpAppInstallSingleBlueprint).registerItem(dfpUnifiedListBlueprint).registerItem(dfpContentListBlueprint).registerItem(dfpAppInstallListBlueprint).registerItem(myTargetAppInstallSingleBlueprint).registerItem(myTargetAppInstallBlueprint).registerItem(myTargetContentSingleBlueprint).registerItem(myTargetContentBlueprint).registerItem(myTargetContentListBlueprint).registerItem(myTargetAppInstallListBlueprint).registerItem(notLoadAdStubGridBlueprint).registerItem(notLoadAdStubListBlueprint).registerItem(notLoadAdRichStubBlueprint).registerItem(emptyAdStubItemBlueprint).build();
    }
}
