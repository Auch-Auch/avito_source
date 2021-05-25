package com.avito.android.shop.detailed.di;

import a2.b.a.a.a;
import android.content.Context;
import android.content.res.Resources;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.FavoriteSellersRepository;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.advert.viewed.ViewedAdvertsPresenterImpl;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.favorite.SubscriptionSource;
import com.avito.android.cart_fab.CartFabModule;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.di.PerFragment;
import com.avito.android.di.ViewedAdvertsModule;
import com.avito.android.di.module.AdvertItemPresenterModule;
import com.avito.android.di.module.FavoriteAdvertsPresenterModule;
import com.avito.android.di.module.InlineFiltersInteractorModule;
import com.avito.android.di.module.SerpItemConverterModule;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.error_helper.di.ErrorHelperModule;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsPresenterImpl;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.notification_manager_provider.NotificationManagerModule;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.permissions.FragmentPermissionHelper;
import com.avito.android.permissions.PermissionHelper;
import com.avito.android.public_profile.ui.SubscribeInteractor;
import com.avito.android.public_profile.ui.SubscriptionsPresenter;
import com.avito.android.public_profile.ui.SubscriptionsPresenterImpl;
import com.avito.android.public_profile.ui.SubscriptionsResourceProvider;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.base.DestroyableViewHolderBuilderImpl;
import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistry;
import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistryImpl;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenterImpl;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.SearchParamsConverterImpl;
import com.avito.android.section.di.SectionAdvertItemsModule;
import com.avito.android.section.item.SectionAdvertItemBlueprint;
import com.avito.android.section.item.SectionAdvertItemDoubleBlueprint;
import com.avito.android.serp.ad.AdResourceProvider;
import com.avito.android.serp.ad.AdResourceProviderImpl;
import com.avito.android.serp.adapter.AdvertGridItemView;
import com.avito.android.serp.adapter.AdvertItemDoubleBlueprint;
import com.avito.android.serp.adapter.AdvertItemGridBlueprint;
import com.avito.android.serp.adapter.AdvertItemListBlueprint;
import com.avito.android.serp.adapter.AdvertItemListener;
import com.avito.android.serp.adapter.AdvertListItemView;
import com.avito.android.serp.adapter.GridPositionProviderImpl;
import com.avito.android.serp.adapter.SerpItemAbViewConfig;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SerpSpanProviderImpl;
import com.avito.android.serp.adapter.SpanLookup;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.server_time.TimeSource;
import com.avito.android.shop.detailed.AwardsClickListener;
import com.avito.android.shop.detailed.NoItemsFoundHeightProvider;
import com.avito.android.shop.detailed.NoItemsFoundHeightProviderImpl;
import com.avito.android.shop.detailed.ShopAdvertsResourceProvider;
import com.avito.android.shop.detailed.ShopAdvertsResourceProviderImpl;
import com.avito.android.shop.detailed.ShopAndSubscribeInteractor;
import com.avito.android.shop.detailed.ShopDetailedImageHeightProvider;
import com.avito.android.shop.detailed.ShopDetailedImageHeightProviderImpl;
import com.avito.android.shop.detailed.ShopDetailedInteractor;
import com.avito.android.shop.detailed.ShopDetailedInteractorImpl;
import com.avito.android.shop.detailed.ShopDetailedItemsConverter;
import com.avito.android.shop.detailed.ShopDetailedItemsConverterImpl;
import com.avito.android.shop.detailed.ShopDetailedPresenter;
import com.avito.android.shop.detailed.ShopDetailedPresenterImpl;
import com.avito.android.shop.detailed.ShopHeaderListener;
import com.avito.android.shop.detailed.ShopItemVisibilityProvider;
import com.avito.android.shop.detailed.ShopItemVisibilityRecorder;
import com.avito.android.shop.detailed.ShopItemVisibilityTracker;
import com.avito.android.shop.detailed.ShopItemVisibilityTrackerImpl;
import com.avito.android.shop.detailed.item.AdvertsCountCaptionBlueprint;
import com.avito.android.shop.detailed.item.AdvertsCountCaptionItemPresenter;
import com.avito.android.shop.detailed.item.NoItemsFoundBlueprint;
import com.avito.android.shop.detailed.item.NoItemsFoundItemPresenter;
import com.avito.android.shop.detailed.item.NoItemsFoundItemPresenterImpl;
import com.avito.android.shop.detailed.item.ShopAdvertGridItemPresenter;
import com.avito.android.shop.detailed.item.ShopAdvertListItemPresenter;
import com.avito.android.shop.detailed.item.ShopGoldBlueprint;
import com.avito.android.shop.detailed.item.ShopGoldHeaderBlueprint;
import com.avito.android.shop.detailed.item.ShopGoldHeaderItemPresenter;
import com.avito.android.shop.detailed.item.ShopGoldHeaderItemPresenterImpl;
import com.avito.android.shop.detailed.item.ShopGoldItemPresenter;
import com.avito.android.shop.detailed.item.ShopGoldItemPresenterImpl;
import com.avito.android.shop.detailed.item.ShopGoldResourceProvider;
import com.avito.android.shop.detailed.item.ShopGoldResourceProviderImpl;
import com.avito.android.shop.detailed.item.ShopItemRatingPresenter;
import com.avito.android.shop.detailed.item.ShopItemRatingPresenterImpl;
import com.avito.android.shop.detailed.item.ShopRegularBlueprint;
import com.avito.android.shop.detailed.item.ShopRegularItemPresenter;
import com.avito.android.shop.detailed.item.ShopRegularItemPresenterImpl;
import com.avito.android.shop.detailed.item.ShopRegularResourceProvider;
import com.avito.android.shop.detailed.item.ShopRegularResourceProviderImpl;
import com.avito.android.shop.detailed.item.ShopSubscriptionsResourceProvider;
import com.avito.android.shop.detailed.item.ShowcaseBlueprint;
import com.avito.android.shop.detailed.item.ShowcaseItemPresenter;
import com.avito.android.shop.detailed.item.ShowcaseItemPresenterImpl;
import com.avito.android.shop.detailed.item.ShowcaseItemView;
import com.avito.android.ui_components.R;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.Formatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.PhoneNumberFormatterModule;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.SearchContextWrapper;
import com.avito.android.util.UrlParams;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000È\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b \b\u0007\u0018\u00002\u00020\u0001:$¤\u0001¥\u0001¦\u0001§\u0001¨\u0001©\u0001ª\u0001«\u0001¬\u0001­\u0001®\u0001¯\u0001°\u0001±\u0001²\u0001³\u0001´\u0001µ\u0001B5\u0012\t\u0010\u0001\u001a\u0004\u0018\u00010\u001e\u0012\t\u0010\u0001\u001a\u0004\u0018\u00010\u001e\u0012\t\u0010\u0001\u001a\u0004\u0018\u00010\u001e\u0012\t\u0010¡\u0001\u001a\u0004\u0018\u00010\u001e¢\u0006\u0006\b¢\u0001\u0010£\u0001J\u001b\u0010\u0007\u001a\u00020\u00042\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010!\u001a\u0004\u0018\u00010\u001eH\u0001¢\u0006\u0004\b\u001f\u0010 J\u0011\u0010#\u001a\u0004\u0018\u00010\u001eH\u0001¢\u0006\u0004\b\"\u0010 J\u0011\u0010%\u001a\u0004\u0018\u00010\u001eH\u0001¢\u0006\u0004\b$\u0010 JW\u0010:\u001a\u00020\u00182\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u0002002\u0006\u00103\u001a\u0002022\u0006\u00105\u001a\u0002042\u0006\u00107\u001a\u000206H\u0001¢\u0006\u0004\b8\u00109J\u001f\u0010@\u001a\u00020\u00182\u0006\u0010<\u001a\u00020;2\u0006\u0010)\u001a\u00020=H\u0001¢\u0006\u0004\b>\u0010?J\u001d\u0010G\u001a\u00020D2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020B0AH\u0001¢\u0006\u0004\bE\u0010FJ\u0017\u0010L\u001a\u0002042\u0006\u0010I\u001a\u00020HH\u0001¢\u0006\u0004\bJ\u0010KJ\u0017\u0010P\u001a\u0002062\u0006\u0010I\u001a\u00020MH\u0001¢\u0006\u0004\bN\u0010OJ\u0017\u0010T\u001a\u00020Q2\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\bR\u0010SJ\u0019\u0010V\u001a\u00020Q2\b\b\u0001\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\bU\u0010SJ\u0017\u0010\\\u001a\u00020Y2\u0006\u0010X\u001a\u00020WH\u0001¢\u0006\u0004\bZ\u0010[J#\u0010b\u001a\u00020_2\b\b\u0001\u0010]\u001a\u00020Q2\b\b\u0001\u0010^\u001a\u00020YH\u0001¢\u0006\u0004\b`\u0010aJ!\u0010d\u001a\u00020_2\u0006\u0010]\u001a\u00020Q2\b\b\u0001\u0010^\u001a\u00020YH\u0001¢\u0006\u0004\bc\u0010aJ\u001f\u0010k\u001a\u00020Y2\u0006\u0010f\u001a\u00020e2\u0006\u0010h\u001a\u00020gH\u0001¢\u0006\u0004\bi\u0010jJ7\u0010v\u001a\u00020(2\u0006\u0010h\u001a\u00020g2\u0006\u0010m\u001a\u00020l2\u0006\u0010o\u001a\u00020n2\u0006\u0010q\u001a\u00020p2\u0006\u0010s\u001a\u00020rH\u0001¢\u0006\u0004\bt\u0010uJ7\u0010y\u001a\u00020&2\u0006\u0010h\u001a\u00020g2\u0006\u0010m\u001a\u00020l2\u0006\u0010o\u001a\u00020n2\u0006\u0010q\u001a\u00020p2\u0006\u0010s\u001a\u00020rH\u0001¢\u0006\u0004\bw\u0010xJ7\u0010|\u001a\u00020*2\u0006\u0010f\u001a\u00020e2\u0006\u0010m\u001a\u00020l2\u0006\u0010o\u001a\u00020n2\u0006\u0010q\u001a\u00020p2\u0006\u0010s\u001a\u00020rH\u0001¢\u0006\u0004\bz\u0010{J\u0001\u0010\u0001\u001a\u00030\u00012\f\u0010}\u001a\b\u0012\u0004\u0012\u00020B0A2\u0006\u0010\u001a\u00020~2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0007¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0003\u001a\u00030\u0001H\u0007¢\u0006\u0006\b\u0001\u0010\u0001R\u001b\u0010\u0001\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001b\u0010\u0001\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001b\u0010\u0001\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001b\u0010¡\u0001\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b \u0001\u0010\u0001¨\u0006¶\u0001"}, d2 = {"Lcom/avito/android/shop/detailed/di/ShopDetailedModule;", "", "", "context", "Lcom/avito/android/util/SearchContextWrapper;", "provideSearchContextWrapper$shop_release", "(Ljava/lang/String;)Lcom/avito/android/util/SearchContextWrapper;", "provideSearchContextWrapper", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "provideGridPositionProvider$shop_release", "(Landroid/content/res/Resources;)Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "provideGridPositionProvider", "gridPositionProvider", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "provideSpanProvider$shop_release", "(Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;Landroid/content/res/Resources;)Lcom/avito/android/serp/adapter/SerpSpanProvider;", "provideSpanProvider", GeoContract.PROVIDER, "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "provideSpanLookup$shop_release", "(Lcom/avito/android/serp/adapter/SerpSpanProvider;)Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "provideSpanLookup", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "provideDestroyableViewHolderBuilder$shop_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "provideDestroyableViewHolderBuilder", "Lcom/avito/android/util/Kundle;", "provideShopRegularItemPresenterState$shop_release", "()Lcom/avito/android/util/Kundle;", "provideShopRegularItemPresenterState", "provideShopGoldItemPresenterState$shop_release", "provideShopGoldItemPresenterState", "provideShowcasePresenterState$shop_release", "provideShowcasePresenterState", "Lcom/avito/android/serp/adapter/AdvertItemGridBlueprint;", "advertItemGridBlueprint", "Lcom/avito/android/serp/adapter/AdvertItemDoubleBlueprint;", "advertItemDoubleBlueprint", "Lcom/avito/android/serp/adapter/AdvertItemListBlueprint;", "advertItemListBlueprint", "Lcom/avito/android/shop/detailed/item/ShowcaseBlueprint;", "showcaseBlueprint", "Lcom/avito/android/shop/detailed/item/ShopGoldBlueprint;", "shopGoldBlueprint", "Lcom/avito/android/shop/detailed/item/ShopGoldHeaderBlueprint;", "shopGoldHeaderBlueprint", "Lcom/avito/android/shop/detailed/item/ShopRegularBlueprint;", "shopRegularBlueprint", "Lcom/avito/android/shop/detailed/item/AdvertsCountCaptionBlueprint;", "captionBlueprint", "Lcom/avito/android/shop/detailed/item/NoItemsFoundBlueprint;", "noItemsFoundBlueprint", "provideItemBinder$shop_release", "(Lcom/avito/android/serp/adapter/AdvertItemGridBlueprint;Lcom/avito/android/serp/adapter/AdvertItemDoubleBlueprint;Lcom/avito/android/serp/adapter/AdvertItemListBlueprint;Lcom/avito/android/shop/detailed/item/ShowcaseBlueprint;Lcom/avito/android/shop/detailed/item/ShopGoldBlueprint;Lcom/avito/android/shop/detailed/item/ShopGoldHeaderBlueprint;Lcom/avito/android/shop/detailed/item/ShopRegularBlueprint;Lcom/avito/android/shop/detailed/item/AdvertsCountCaptionBlueprint;Lcom/avito/android/shop/detailed/item/NoItemsFoundBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "Lcom/avito/android/section/item/SectionAdvertItemBlueprint;", "sectionAdvertItemBlueprint", "Lcom/avito/android/section/item/SectionAdvertItemDoubleBlueprint;", "provideShowcaseItemBinder$shop_release", "(Lcom/avito/android/section/item/SectionAdvertItemBlueprint;Lcom/avito/android/section/item/SectionAdvertItemDoubleBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideShowcaseItemBinder", "Ldagger/Lazy;", "Lcom/avito/android/shop/detailed/ShopDetailedPresenter;", "presenter", "Lcom/avito/android/shop/detailed/item/ShopItemRatingPresenter;", "provideShopItemRatingPresenter$shop_release", "(Ldagger/Lazy;)Lcom/avito/android/shop/detailed/item/ShopItemRatingPresenter;", "provideShopItemRatingPresenter", "Lcom/avito/android/shop/detailed/item/AdvertsCountCaptionItemPresenter;", "itemPresenter", "provideAdvertsCountCaptionBlueprint$shop_release", "(Lcom/avito/android/shop/detailed/item/AdvertsCountCaptionItemPresenter;)Lcom/avito/android/shop/detailed/item/AdvertsCountCaptionBlueprint;", "provideAdvertsCountCaptionBlueprint", "Lcom/avito/android/shop/detailed/item/NoItemsFoundItemPresenter;", "provideNoItemsFoundBlueprint$shop_release", "(Lcom/avito/android/shop/detailed/item/NoItemsFoundItemPresenter;)Lcom/avito/android/shop/detailed/item/NoItemsFoundBlueprint;", "provideNoItemsFoundBlueprint", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter$shop_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "provideShowcaseAdapterPresenter$shop_release", "provideShowcaseAdapterPresenter", "Lcom/avito/android/shop/detailed/item/ShowcaseItemPresenter;", "showcaseItemPresenter", "Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;", "provideShowcaseCallableResponsiveItemPresenterRegistry$shop_release", "(Lcom/avito/android/shop/detailed/item/ShowcaseItemPresenter;)Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;", "provideShowcaseCallableResponsiveItemPresenterRegistry", "adapterPresenter", "registry", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "provideShowcaseResponsiveAdapterPresenter$shop_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;)Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "provideShowcaseResponsiveAdapterPresenter", "provideItemResponsiveAdapterPresenter$shop_release", "provideItemResponsiveAdapterPresenter", "Lcom/avito/android/shop/detailed/item/ShopAdvertListItemPresenter;", "advertListItemPresenter", "Lcom/avito/android/shop/detailed/item/ShopAdvertGridItemPresenter;", "advertGridItemPresenter", "provideItemCallableResponsiveItemPresenterRegistry$shop_release", "(Lcom/avito/android/shop/detailed/item/ShopAdvertListItemPresenter;Lcom/avito/android/shop/detailed/item/ShopAdvertGridItemPresenter;)Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;", "provideItemCallableResponsiveItemPresenterRegistry", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Ljava/util/Locale;", "locale", "Lcom/avito/android/serp/adapter/SerpItemAbViewConfig;", "viewAbConfig", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "provideAdvertItemDoubleBlueprint$shop_release", "(Lcom/avito/android/shop/detailed/item/ShopAdvertGridItemPresenter;Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;Lcom/avito/android/serp/adapter/SerpItemAbViewConfig;Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;)Lcom/avito/android/serp/adapter/AdvertItemDoubleBlueprint;", "provideAdvertItemDoubleBlueprint", "provideAdvertItemGridBlueprint$shop_release", "(Lcom/avito/android/shop/detailed/item/ShopAdvertGridItemPresenter;Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;Lcom/avito/android/serp/adapter/SerpItemAbViewConfig;Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;)Lcom/avito/android/serp/adapter/AdvertItemGridBlueprint;", "provideAdvertItemGridBlueprint", "provideAdvertItemListBlueprint$shop_release", "(Lcom/avito/android/shop/detailed/item/ShopAdvertListItemPresenter;Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;Lcom/avito/android/serp/adapter/SerpItemAbViewConfig;Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;)Lcom/avito/android/serp/adapter/AdvertItemListBlueprint;", "provideAdvertItemListBlueprint", "detailedPresenter", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationsManagerProvider", "Lcom/avito/android/FavoriteSellersRepository;", "favoriteSellersRepository", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/public_profile/ui/SubscriptionsResourceProvider;", "resourceProvider", "Lcom/avito/android/public_profile/ui/SubscribeInteractor;", "interactor", "Lcom/avito/android/error_helper/ErrorHelper;", "errorHelper", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "snackbarPresenter", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/public_profile/ui/SubscriptionsPresenter;", "provideSubscriptionsPresenterImpl", "(Ldagger/Lazy;Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;Lcom/avito/android/FavoriteSellersRepository;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/public_profile/ui/SubscriptionsResourceProvider;Lcom/avito/android/public_profile/ui/SubscribeInteractor;Lcom/avito/android/error_helper/ErrorHelper;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;Lcom/avito/android/Features;)Lcom/avito/android/public_profile/ui/SubscriptionsPresenter;", "Landroid/content/Context;", "Landroidx/core/app/NotificationManagerCompat;", "provideNotificationManager", "(Landroid/content/Context;)Landroidx/core/app/NotificationManagerCompat;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/Kundle;", "shopGoldItemPresenterState", AuthSource.SEND_ABUSE, "shopRegularItemPresenterState", "c", "showcasePresenterState", "d", "subscriptionsPresenterState", "<init>", "(Lcom/avito/android/util/Kundle;Lcom/avito/android/util/Kundle;Lcom/avito/android/util/Kundle;Lcom/avito/android/util/Kundle;)V", "Declarations", "InteractorState", "ItemCallableRegistry", "ItemResponsiveAdapter", "ItemShowcaseItemBinder", "PageFrom", "PresenterState", "SearchParams", "ShopContext", "ShopGoldItemPresenterState", "ShopId", "ShopRegularItemPresenterState", "ShowcaseAdapterPresenter", "ShowcaseCallableRegistry", "ShowcaseFavoritePresenter", "ShowcasePresenterState", "ShowcaseResponsiveAdapter", "ShowcaseViewedPresenter", "shop_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {InlineFiltersInteractorModule.class, PhoneNumberFormatterModule.class, AdvertItemPresenterModule.class, SectionAdvertItemsModule.class, SerpItemConverterModule.class, FavoriteAdvertsPresenterModule.class, ViewedAdvertsModule.class, ErrorHelperModule.class, NotificationManagerModule.class, CartFabModule.class, Declarations.class})
public final class ShopDetailedModule {
    public final Kundle a;
    public final Kundle b;
    public final Kundle c;
    public final Kundle d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ü\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H'¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH'¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0017H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u001bH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u001fH'¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020$2\u0006\u0010\u0013\u001a\u00020#H'¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020(2\u0006\u0010\u0013\u001a\u00020'H'¢\u0006\u0004\b)\u0010*J\u0017\u0010.\u001a\u00020-2\u0006\u0010,\u001a\u00020+H'¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u0002002\u0006\u0010,\u001a\u00020-H'¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u0002032\u0006\u0010,\u001a\u00020-H'¢\u0006\u0004\b4\u00105J\u0017\u00108\u001a\u0002072\u0006\u0010\u0013\u001a\u000206H'¢\u0006\u0004\b8\u00109J\u0017\u0010=\u001a\u00020<2\u0006\u0010;\u001a\u00020:H'¢\u0006\u0004\b=\u0010>J\u0017\u0010A\u001a\u00020@2\u0006\u0010;\u001a\u00020?H'¢\u0006\u0004\bA\u0010BJ\u0017\u0010E\u001a\u00020D2\u0006\u0010;\u001a\u00020CH'¢\u0006\u0004\bE\u0010FJ\u0017\u0010I\u001a\u00020H2\u0006\u0010;\u001a\u00020GH'¢\u0006\u0004\bI\u0010JJ\u0017\u0010M\u001a\u00020L2\u0006\u0010;\u001a\u00020KH'¢\u0006\u0004\bM\u0010NJ\u0017\u0010Q\u001a\u00020P2\u0006\u0010;\u001a\u00020OH'¢\u0006\u0004\bQ\u0010RJ\u001d\u0010W\u001a\b\u0012\u0004\u0012\u00020V0U2\u0006\u0010T\u001a\u00020SH'¢\u0006\u0004\bW\u0010XJ\u0017\u0010[\u001a\u00020Z2\u0006\u0010;\u001a\u00020YH'¢\u0006\u0004\b[\u0010\\J\u0017\u0010`\u001a\u00020_2\u0006\u0010^\u001a\u00020]H'¢\u0006\u0004\b`\u0010aJ\u0017\u0010d\u001a\u00020c2\u0006\u0010\u0013\u001a\u00020bH'¢\u0006\u0004\bd\u0010eJ\u0017\u0010h\u001a\u00020g2\u0006\u0010\u000e\u001a\u00020fH'¢\u0006\u0004\bh\u0010iJ\u0017\u0010l\u001a\u00020k2\u0006\u0010j\u001a\u000207H'¢\u0006\u0004\bl\u0010mJ\u0017\u0010o\u001a\u00020n2\u0006\u0010j\u001a\u000207H'¢\u0006\u0004\bo\u0010pJ\u0017\u0010r\u001a\u00020q2\u0006\u0010j\u001a\u000207H'¢\u0006\u0004\br\u0010sJ\u0017\u0010w\u001a\u00020v2\u0006\u0010u\u001a\u00020tH'¢\u0006\u0004\bw\u0010x¨\u0006y"}, d2 = {"Lcom/avito/android/shop/detailed/di/ShopDetailedModule$Declarations;", "", "Lcom/avito/android/shop/detailed/ShopItemVisibilityTrackerImpl;", "tracker", "Lcom/avito/android/shop/detailed/ShopItemVisibilityTracker;", "bindShopItemVisibilityTracker", "(Lcom/avito/android/shop/detailed/ShopItemVisibilityTrackerImpl;)Lcom/avito/android/shop/detailed/ShopItemVisibilityTracker;", "Lcom/avito/android/shop/detailed/ShopItemVisibilityProvider;", "bindShopItemVisibilityProvider", "(Lcom/avito/android/shop/detailed/ShopItemVisibilityTracker;)Lcom/avito/android/shop/detailed/ShopItemVisibilityProvider;", "Lcom/avito/android/shop/detailed/ShopItemVisibilityRecorder;", "bindShopItemVisibilityRecorder", "(Lcom/avito/android/shop/detailed/ShopItemVisibilityTracker;)Lcom/avito/android/shop/detailed/ShopItemVisibilityRecorder;", "Lcom/avito/android/shop/detailed/ShopDetailedItemsConverterImpl;", "converter", "Lcom/avito/android/shop/detailed/ShopDetailedItemsConverter;", "bindShopItemsConverter", "(Lcom/avito/android/shop/detailed/ShopDetailedItemsConverterImpl;)Lcom/avito/android/shop/detailed/ShopDetailedItemsConverter;", "Lcom/avito/android/shop/detailed/item/ShowcaseItemPresenterImpl;", "presenter", "Lcom/avito/android/shop/detailed/item/ShowcaseItemPresenter;", "bindShowcaseItemPresenter", "(Lcom/avito/android/shop/detailed/item/ShowcaseItemPresenterImpl;)Lcom/avito/android/shop/detailed/item/ShowcaseItemPresenter;", "Lcom/avito/android/shop/detailed/item/NoItemsFoundItemPresenterImpl;", "Lcom/avito/android/shop/detailed/item/NoItemsFoundItemPresenter;", "bindNoItemsFoundPresenter", "(Lcom/avito/android/shop/detailed/item/NoItemsFoundItemPresenterImpl;)Lcom/avito/android/shop/detailed/item/NoItemsFoundItemPresenter;", "Lcom/avito/android/favorite/FavoriteAdvertsPresenterImpl;", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "bindFavoriteShowcaseAdvertsPresenter", "(Lcom/avito/android/favorite/FavoriteAdvertsPresenterImpl;)Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenterImpl;", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "bindViewedShowcaseAdvertsPresenter", "(Lcom/avito/android/advert/viewed/ViewedAdvertsPresenterImpl;)Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "Lcom/avito/android/shop/detailed/item/ShopRegularItemPresenterImpl;", "Lcom/avito/android/shop/detailed/item/ShopRegularItemPresenter;", "bindShopRegularItemPresenter", "(Lcom/avito/android/shop/detailed/item/ShopRegularItemPresenterImpl;)Lcom/avito/android/shop/detailed/item/ShopRegularItemPresenter;", "Lcom/avito/android/shop/detailed/item/ShopGoldItemPresenterImpl;", "Lcom/avito/android/shop/detailed/item/ShopGoldItemPresenter;", "bindShopGoldItemPresenter", "(Lcom/avito/android/shop/detailed/item/ShopGoldItemPresenterImpl;)Lcom/avito/android/shop/detailed/item/ShopGoldItemPresenter;", "Lcom/avito/android/shop/detailed/ShopDetailedInteractorImpl;", "interactor", "Lcom/avito/android/shop/detailed/ShopAndSubscribeInteractor;", "bindInteractor", "(Lcom/avito/android/shop/detailed/ShopDetailedInteractorImpl;)Lcom/avito/android/shop/detailed/ShopAndSubscribeInteractor;", "Lcom/avito/android/shop/detailed/ShopDetailedInteractor;", "bindShopInteractor", "(Lcom/avito/android/shop/detailed/ShopAndSubscribeInteractor;)Lcom/avito/android/shop/detailed/ShopDetailedInteractor;", "Lcom/avito/android/public_profile/ui/SubscribeInteractor;", "bindSubscribeInteractor", "(Lcom/avito/android/shop/detailed/ShopAndSubscribeInteractor;)Lcom/avito/android/public_profile/ui/SubscribeInteractor;", "Lcom/avito/android/shop/detailed/ShopDetailedPresenterImpl;", "Lcom/avito/android/shop/detailed/ShopDetailedPresenter;", "bindShopDetailedPresenter", "(Lcom/avito/android/shop/detailed/ShopDetailedPresenterImpl;)Lcom/avito/android/shop/detailed/ShopDetailedPresenter;", "Lcom/avito/android/shop/detailed/ShopAdvertsResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/shop/detailed/ShopAdvertsResourceProvider;", "bindShopAdvertsResourceProvider", "(Lcom/avito/android/shop/detailed/ShopAdvertsResourceProviderImpl;)Lcom/avito/android/shop/detailed/ShopAdvertsResourceProvider;", "Lcom/avito/android/shop/detailed/item/ShopRegularResourceProviderImpl;", "Lcom/avito/android/shop/detailed/item/ShopRegularResourceProvider;", "bindShopRegularResourceProvider", "(Lcom/avito/android/shop/detailed/item/ShopRegularResourceProviderImpl;)Lcom/avito/android/shop/detailed/item/ShopRegularResourceProvider;", "Lcom/avito/android/shop/detailed/item/ShopGoldResourceProviderImpl;", "Lcom/avito/android/shop/detailed/item/ShopGoldResourceProvider;", "bindShopGoldResourceProvider", "(Lcom/avito/android/shop/detailed/item/ShopGoldResourceProviderImpl;)Lcom/avito/android/shop/detailed/item/ShopGoldResourceProvider;", "Lcom/avito/android/shop/detailed/ShopDetailedImageHeightProviderImpl;", "Lcom/avito/android/shop/detailed/ShopDetailedImageHeightProvider;", "bindShopDetailedImageHeightProvider", "(Lcom/avito/android/shop/detailed/ShopDetailedImageHeightProviderImpl;)Lcom/avito/android/shop/detailed/ShopDetailedImageHeightProvider;", "Lcom/avito/android/shop/detailed/item/ShopSubscriptionsResourceProvider;", "Lcom/avito/android/public_profile/ui/SubscriptionsResourceProvider;", "bindShopSubscriptionsResourceProvider", "(Lcom/avito/android/shop/detailed/item/ShopSubscriptionsResourceProvider;)Lcom/avito/android/public_profile/ui/SubscriptionsResourceProvider;", "Lcom/avito/android/shop/detailed/NoItemsFoundHeightProviderImpl;", "Lcom/avito/android/shop/detailed/NoItemsFoundHeightProvider;", "bindNoItemsFoundHeightProvider", "(Lcom/avito/android/shop/detailed/NoItemsFoundHeightProviderImpl;)Lcom/avito/android/shop/detailed/NoItemsFoundHeightProvider;", "Lcom/avito/android/util/ErrorFormatterImpl;", "formatter", "Lcom/avito/android/util/Formatter;", "", "bindErrorFormatter", "(Lcom/avito/android/util/ErrorFormatterImpl;)Lcom/avito/android/util/Formatter;", "Lcom/avito/android/serp/ad/AdResourceProviderImpl;", "Lcom/avito/android/serp/ad/AdResourceProvider;", "bindAdResourceProvider", "(Lcom/avito/android/serp/ad/AdResourceProviderImpl;)Lcom/avito/android/serp/ad/AdResourceProvider;", "Lcom/avito/android/permissions/FragmentPermissionHelper;", "helper", "Lcom/avito/android/permissions/PermissionHelper;", "bindPermissionHelper", "(Lcom/avito/android/permissions/FragmentPermissionHelper;)Lcom/avito/android/permissions/PermissionHelper;", "Lcom/avito/android/shop/detailed/item/ShopGoldHeaderItemPresenterImpl;", "Lcom/avito/android/shop/detailed/item/ShopGoldHeaderItemPresenter;", "bindShopGoldHeaderItemPresenter", "(Lcom/avito/android/shop/detailed/item/ShopGoldHeaderItemPresenterImpl;)Lcom/avito/android/shop/detailed/item/ShopGoldHeaderItemPresenter;", "Lcom/avito/android/remote/model/SearchParamsConverterImpl;", "Lcom/avito/android/remote/model/SearchParamsConverter;", "bindSearchParamsConverter", "(Lcom/avito/android/remote/model/SearchParamsConverterImpl;)Lcom/avito/android/remote/model/SearchParamsConverter;", "impl", "Lcom/avito/android/serp/adapter/AdvertItemListener;", "bindAdvertItemListener", "(Lcom/avito/android/shop/detailed/ShopDetailedPresenter;)Lcom/avito/android/serp/adapter/AdvertItemListener;", "Lcom/avito/android/shop/detailed/AwardsClickListener;", "provideAwardsClickListener", "(Lcom/avito/android/shop/detailed/ShopDetailedPresenter;)Lcom/avito/android/shop/detailed/AwardsClickListener;", "Lcom/avito/android/shop/detailed/ShopHeaderListener;", "provideShopHeaderListener", "(Lcom/avito/android/shop/detailed/ShopDetailedPresenter;)Lcom/avito/android/shop/detailed/ShopHeaderListener;", "Landroidx/fragment/app/Fragment;", UrlParams.OWNER, "Landroidx/lifecycle/ViewModelStoreOwner;", "bindViewModelStoreOwner", "(Landroidx/fragment/app/Fragment;)Landroidx/lifecycle/ViewModelStoreOwner;", "shop_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        AdResourceProvider bindAdResourceProvider(@NotNull AdResourceProviderImpl adResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        AdvertItemListener bindAdvertItemListener(@NotNull ShopDetailedPresenter shopDetailedPresenter);

        @Binds
        @NotNull
        @PerFragment
        Formatter<Throwable> bindErrorFormatter(@NotNull ErrorFormatterImpl errorFormatterImpl);

        @ShowcaseFavoritePresenter
        @Binds
        @NotNull
        FavoriteAdvertsPresenter bindFavoriteShowcaseAdvertsPresenter(@NotNull FavoriteAdvertsPresenterImpl favoriteAdvertsPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        ShopAndSubscribeInteractor bindInteractor(@NotNull ShopDetailedInteractorImpl shopDetailedInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        NoItemsFoundHeightProvider bindNoItemsFoundHeightProvider(@NotNull NoItemsFoundHeightProviderImpl noItemsFoundHeightProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        NoItemsFoundItemPresenter bindNoItemsFoundPresenter(@NotNull NoItemsFoundItemPresenterImpl noItemsFoundItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        PermissionHelper bindPermissionHelper(@NotNull FragmentPermissionHelper fragmentPermissionHelper);

        @PerFragment
        @Binds
        @NotNull
        SearchParamsConverter bindSearchParamsConverter(@NotNull SearchParamsConverterImpl searchParamsConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        ShopAdvertsResourceProvider bindShopAdvertsResourceProvider(@NotNull ShopAdvertsResourceProviderImpl shopAdvertsResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        ShopDetailedImageHeightProvider bindShopDetailedImageHeightProvider(@NotNull ShopDetailedImageHeightProviderImpl shopDetailedImageHeightProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        ShopDetailedPresenter bindShopDetailedPresenter(@NotNull ShopDetailedPresenterImpl shopDetailedPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        ShopGoldHeaderItemPresenter bindShopGoldHeaderItemPresenter(@NotNull ShopGoldHeaderItemPresenterImpl shopGoldHeaderItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        ShopGoldItemPresenter bindShopGoldItemPresenter(@NotNull ShopGoldItemPresenterImpl shopGoldItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        ShopGoldResourceProvider bindShopGoldResourceProvider(@NotNull ShopGoldResourceProviderImpl shopGoldResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        ShopDetailedInteractor bindShopInteractor(@NotNull ShopAndSubscribeInteractor shopAndSubscribeInteractor);

        @PerFragment
        @Binds
        @NotNull
        ShopItemVisibilityProvider bindShopItemVisibilityProvider(@NotNull ShopItemVisibilityTracker shopItemVisibilityTracker);

        @PerFragment
        @Binds
        @NotNull
        ShopItemVisibilityRecorder bindShopItemVisibilityRecorder(@NotNull ShopItemVisibilityTracker shopItemVisibilityTracker);

        @PerFragment
        @Binds
        @NotNull
        ShopItemVisibilityTracker bindShopItemVisibilityTracker(@NotNull ShopItemVisibilityTrackerImpl shopItemVisibilityTrackerImpl);

        @PerFragment
        @Binds
        @NotNull
        ShopDetailedItemsConverter bindShopItemsConverter(@NotNull ShopDetailedItemsConverterImpl shopDetailedItemsConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        ShopRegularItemPresenter bindShopRegularItemPresenter(@NotNull ShopRegularItemPresenterImpl shopRegularItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        ShopRegularResourceProvider bindShopRegularResourceProvider(@NotNull ShopRegularResourceProviderImpl shopRegularResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        SubscriptionsResourceProvider bindShopSubscriptionsResourceProvider(@NotNull ShopSubscriptionsResourceProvider shopSubscriptionsResourceProvider);

        @PerFragment
        @Binds
        @NotNull
        ShowcaseItemPresenter bindShowcaseItemPresenter(@NotNull ShowcaseItemPresenterImpl showcaseItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        SubscribeInteractor bindSubscribeInteractor(@NotNull ShopAndSubscribeInteractor shopAndSubscribeInteractor);

        @PerFragment
        @Binds
        @NotNull
        ViewModelStoreOwner bindViewModelStoreOwner(@NotNull Fragment fragment);

        @ShowcaseViewedPresenter
        @Binds
        @NotNull
        ViewedAdvertsPresenter bindViewedShowcaseAdvertsPresenter(@NotNull ViewedAdvertsPresenterImpl viewedAdvertsPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        AwardsClickListener provideAwardsClickListener(@NotNull ShopDetailedPresenter shopDetailedPresenter);

        @PerFragment
        @Binds
        @NotNull
        ShopHeaderListener provideShopHeaderListener(@NotNull ShopDetailedPresenter shopDetailedPresenter);
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/shop/detailed/di/ShopDetailedModule$InteractorState;", "", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface InteractorState {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/shop/detailed/di/ShopDetailedModule$ItemCallableRegistry;", "", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface ItemCallableRegistry {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/shop/detailed/di/ShopDetailedModule$ItemResponsiveAdapter;", "", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface ItemResponsiveAdapter {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/shop/detailed/di/ShopDetailedModule$ItemShowcaseItemBinder;", "", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface ItemShowcaseItemBinder {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/shop/detailed/di/ShopDetailedModule$PageFrom;", "", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface PageFrom {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/shop/detailed/di/ShopDetailedModule$PresenterState;", "", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface PresenterState {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/shop/detailed/di/ShopDetailedModule$SearchParams;", "", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface SearchParams {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/shop/detailed/di/ShopDetailedModule$ShopContext;", "", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface ShopContext {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/shop/detailed/di/ShopDetailedModule$ShopGoldItemPresenterState;", "", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface ShopGoldItemPresenterState {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/shop/detailed/di/ShopDetailedModule$ShopId;", "", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface ShopId {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/shop/detailed/di/ShopDetailedModule$ShopRegularItemPresenterState;", "", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface ShopRegularItemPresenterState {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/shop/detailed/di/ShopDetailedModule$ShowcaseAdapterPresenter;", "", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface ShowcaseAdapterPresenter {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/shop/detailed/di/ShopDetailedModule$ShowcaseCallableRegistry;", "", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface ShowcaseCallableRegistry {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/shop/detailed/di/ShopDetailedModule$ShowcaseFavoritePresenter;", "", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface ShowcaseFavoritePresenter {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/shop/detailed/di/ShopDetailedModule$ShowcasePresenterState;", "", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface ShowcasePresenterState {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/shop/detailed/di/ShopDetailedModule$ShowcaseResponsiveAdapter;", "", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface ShowcaseResponsiveAdapter {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/shop/detailed/di/ShopDetailedModule$ShowcaseViewedPresenter;", "", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface ShowcaseViewedPresenter {
    }

    public ShopDetailedModule(@Nullable Kundle kundle, @Nullable Kundle kundle2, @Nullable Kundle kundle3, @Nullable Kundle kundle4) {
        this.a = kundle;
        this.b = kundle2;
        this.c = kundle3;
        this.d = kundle4;
    }

    @Provides
    @PerFragment
    @NotNull
    public final AdapterPresenter provideAdapterPresenter$shop_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @PerFragment
    @NotNull
    public final AdvertItemDoubleBlueprint provideAdvertItemDoubleBlueprint$shop_release(@NotNull ShopAdvertGridItemPresenter shopAdvertGridItemPresenter, @NotNull TimeSource timeSource, @NotNull Locale locale, @NotNull SerpItemAbViewConfig serpItemAbViewConfig, @NotNull ConnectivityProvider connectivityProvider) {
        Intrinsics.checkNotNullParameter(shopAdvertGridItemPresenter, "advertGridItemPresenter");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(serpItemAbViewConfig, "viewAbConfig");
        Intrinsics.checkNotNullParameter(connectivityProvider, "connectivityProvider");
        return new AdvertItemDoubleBlueprint(shopAdvertGridItemPresenter, timeSource, locale, serpItemAbViewConfig, connectivityProvider);
    }

    @Provides
    @PerFragment
    @NotNull
    public final AdvertItemGridBlueprint provideAdvertItemGridBlueprint$shop_release(@NotNull ShopAdvertGridItemPresenter shopAdvertGridItemPresenter, @NotNull TimeSource timeSource, @NotNull Locale locale, @NotNull SerpItemAbViewConfig serpItemAbViewConfig, @NotNull ConnectivityProvider connectivityProvider) {
        Intrinsics.checkNotNullParameter(shopAdvertGridItemPresenter, "advertGridItemPresenter");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(serpItemAbViewConfig, "viewAbConfig");
        Intrinsics.checkNotNullParameter(connectivityProvider, "connectivityProvider");
        return new AdvertItemGridBlueprint(shopAdvertGridItemPresenter, timeSource, locale, serpItemAbViewConfig, connectivityProvider);
    }

    @Provides
    @PerFragment
    @NotNull
    public final AdvertItemListBlueprint provideAdvertItemListBlueprint$shop_release(@NotNull ShopAdvertListItemPresenter shopAdvertListItemPresenter, @NotNull TimeSource timeSource, @NotNull Locale locale, @NotNull SerpItemAbViewConfig serpItemAbViewConfig, @NotNull ConnectivityProvider connectivityProvider) {
        Intrinsics.checkNotNullParameter(shopAdvertListItemPresenter, "advertListItemPresenter");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(serpItemAbViewConfig, "viewAbConfig");
        Intrinsics.checkNotNullParameter(connectivityProvider, "connectivityProvider");
        return new AdvertItemListBlueprint(shopAdvertListItemPresenter, timeSource, locale, serpItemAbViewConfig, connectivityProvider);
    }

    @Provides
    @PerFragment
    @NotNull
    public final AdvertsCountCaptionBlueprint provideAdvertsCountCaptionBlueprint$shop_release(@NotNull AdvertsCountCaptionItemPresenter advertsCountCaptionItemPresenter) {
        Intrinsics.checkNotNullParameter(advertsCountCaptionItemPresenter, "itemPresenter");
        return new AdvertsCountCaptionBlueprint(advertsCountCaptionItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final DestroyableViewHolderBuilder provideDestroyableViewHolderBuilder$shop_release(@NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        return new DestroyableViewHolderBuilderImpl(itemBinder);
    }

    @Provides
    @PerFragment
    @NotNull
    public final SpannedGridPositionProvider provideGridPositionProvider$shop_release(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new GridPositionProviderImpl(resources.getInteger(R.integer.serp_columns));
    }

    @Provides
    @PerFragment
    @NotNull
    public final ItemBinder provideItemBinder$shop_release(@NotNull AdvertItemGridBlueprint advertItemGridBlueprint, @NotNull AdvertItemDoubleBlueprint advertItemDoubleBlueprint, @NotNull AdvertItemListBlueprint advertItemListBlueprint, @NotNull ShowcaseBlueprint showcaseBlueprint, @NotNull ShopGoldBlueprint shopGoldBlueprint, @NotNull ShopGoldHeaderBlueprint shopGoldHeaderBlueprint, @NotNull ShopRegularBlueprint shopRegularBlueprint, @NotNull AdvertsCountCaptionBlueprint advertsCountCaptionBlueprint, @NotNull NoItemsFoundBlueprint noItemsFoundBlueprint) {
        Intrinsics.checkNotNullParameter(advertItemGridBlueprint, "advertItemGridBlueprint");
        Intrinsics.checkNotNullParameter(advertItemDoubleBlueprint, "advertItemDoubleBlueprint");
        Intrinsics.checkNotNullParameter(advertItemListBlueprint, "advertItemListBlueprint");
        Intrinsics.checkNotNullParameter(showcaseBlueprint, "showcaseBlueprint");
        Intrinsics.checkNotNullParameter(shopGoldBlueprint, "shopGoldBlueprint");
        Intrinsics.checkNotNullParameter(shopGoldHeaderBlueprint, "shopGoldHeaderBlueprint");
        Intrinsics.checkNotNullParameter(shopRegularBlueprint, "shopRegularBlueprint");
        Intrinsics.checkNotNullParameter(advertsCountCaptionBlueprint, "captionBlueprint");
        Intrinsics.checkNotNullParameter(noItemsFoundBlueprint, "noItemsFoundBlueprint");
        return new ItemBinder.Builder().registerItem(advertItemGridBlueprint).registerItem(advertItemDoubleBlueprint).registerItem(advertItemListBlueprint).registerItem(showcaseBlueprint).registerItem(shopGoldBlueprint).registerItem(shopGoldHeaderBlueprint).registerItem(shopRegularBlueprint).registerItem(noItemsFoundBlueprint).registerItem(advertsCountCaptionBlueprint).build();
    }

    @Provides
    @NotNull
    @ItemCallableRegistry
    @PerFragment
    public final CallableResponsiveItemPresenterRegistry provideItemCallableResponsiveItemPresenterRegistry$shop_release(@NotNull ShopAdvertListItemPresenter shopAdvertListItemPresenter, @NotNull ShopAdvertGridItemPresenter shopAdvertGridItemPresenter) {
        Intrinsics.checkNotNullParameter(shopAdvertListItemPresenter, "advertListItemPresenter");
        Intrinsics.checkNotNullParameter(shopAdvertGridItemPresenter, "advertGridItemPresenter");
        CallableResponsiveItemPresenterRegistryImpl callableResponsiveItemPresenterRegistryImpl = new CallableResponsiveItemPresenterRegistryImpl();
        callableResponsiveItemPresenterRegistryImpl.register(AdvertListItemView.class, shopAdvertListItemPresenter);
        callableResponsiveItemPresenterRegistryImpl.register(AdvertGridItemView.class, shopAdvertGridItemPresenter);
        return callableResponsiveItemPresenterRegistryImpl;
    }

    @Provides
    @ItemResponsiveAdapter
    @NotNull
    @PerFragment
    public final ResponsiveAdapterPresenter provideItemResponsiveAdapterPresenter$shop_release(@NotNull AdapterPresenter adapterPresenter, @ItemCallableRegistry @NotNull CallableResponsiveItemPresenterRegistry callableResponsiveItemPresenterRegistry) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(callableResponsiveItemPresenterRegistry, "registry");
        return new ResponsiveAdapterPresenterImpl(adapterPresenter, callableResponsiveItemPresenterRegistry);
    }

    @Provides
    @PerFragment
    @NotNull
    public final NoItemsFoundBlueprint provideNoItemsFoundBlueprint$shop_release(@NotNull NoItemsFoundItemPresenter noItemsFoundItemPresenter) {
        Intrinsics.checkNotNullParameter(noItemsFoundItemPresenter, "itemPresenter");
        return new NoItemsFoundBlueprint(noItemsFoundItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final NotificationManagerCompat provideNotificationManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        NotificationManagerCompat from = NotificationManagerCompat.from(context);
        Intrinsics.checkNotNullExpressionValue(from, "NotificationManagerCompat.from(context)");
        return from;
    }

    @Provides
    @NotNull
    public final SearchContextWrapper provideSearchContextWrapper$shop_release(@ShopContext @Nullable String str) {
        return new SearchContextWrapper(str);
    }

    @Provides
    @Nullable
    @ShopGoldItemPresenterState
    @PerFragment
    public final Kundle provideShopGoldItemPresenterState$shop_release() {
        return this.b;
    }

    @Provides
    @NotNull
    @PerFragment
    public final ShopItemRatingPresenter provideShopItemRatingPresenter$shop_release(@NotNull Lazy<ShopDetailedPresenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "presenter");
        return new ShopItemRatingPresenterImpl(lazy);
    }

    @ShopRegularItemPresenterState
    @Provides
    @Nullable
    @PerFragment
    public final Kundle provideShopRegularItemPresenterState$shop_release() {
        return this.a;
    }

    @Provides
    @NotNull
    @PerFragment
    @ShowcaseAdapterPresenter
    public final AdapterPresenter provideShowcaseAdapterPresenter$shop_release(@ItemShowcaseItemBinder @NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @ShowcaseCallableRegistry
    @NotNull
    @PerFragment
    public final CallableResponsiveItemPresenterRegistry provideShowcaseCallableResponsiveItemPresenterRegistry$shop_release(@NotNull ShowcaseItemPresenter showcaseItemPresenter) {
        Intrinsics.checkNotNullParameter(showcaseItemPresenter, "showcaseItemPresenter");
        CallableResponsiveItemPresenterRegistryImpl callableResponsiveItemPresenterRegistryImpl = new CallableResponsiveItemPresenterRegistryImpl();
        callableResponsiveItemPresenterRegistryImpl.register(ShowcaseItemView.class, showcaseItemPresenter);
        return callableResponsiveItemPresenterRegistryImpl;
    }

    @Provides
    @ItemShowcaseItemBinder
    @NotNull
    @PerFragment
    public final ItemBinder provideShowcaseItemBinder$shop_release(@NotNull SectionAdvertItemBlueprint sectionAdvertItemBlueprint, @NotNull SectionAdvertItemDoubleBlueprint sectionAdvertItemDoubleBlueprint) {
        Intrinsics.checkNotNullParameter(sectionAdvertItemBlueprint, "sectionAdvertItemBlueprint");
        Intrinsics.checkNotNullParameter(sectionAdvertItemDoubleBlueprint, "advertItemDoubleBlueprint");
        return new ItemBinder.Builder().registerItem(sectionAdvertItemBlueprint).registerItem(sectionAdvertItemDoubleBlueprint).build();
    }

    @Provides
    @Nullable
    @PerFragment
    @ShowcasePresenterState
    public final Kundle provideShowcasePresenterState$shop_release() {
        return this.c;
    }

    @Provides
    @ShowcaseResponsiveAdapter
    @NotNull
    @PerFragment
    public final ResponsiveAdapterPresenter provideShowcaseResponsiveAdapterPresenter$shop_release(@ShowcaseAdapterPresenter @NotNull AdapterPresenter adapterPresenter, @ShowcaseCallableRegistry @NotNull CallableResponsiveItemPresenterRegistry callableResponsiveItemPresenterRegistry) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(callableResponsiveItemPresenterRegistry, "registry");
        return new ResponsiveAdapterPresenterImpl(adapterPresenter, callableResponsiveItemPresenterRegistry);
    }

    @Provides
    @PerFragment
    @NotNull
    public final GridLayoutManager.SpanSizeLookup provideSpanLookup$shop_release(@NotNull SerpSpanProvider serpSpanProvider) {
        Intrinsics.checkNotNullParameter(serpSpanProvider, GeoContract.PROVIDER);
        return new SpanLookup(serpSpanProvider);
    }

    @Provides
    @PerFragment
    @NotNull
    public final SerpSpanProvider provideSpanProvider$shop_release(@NotNull SpannedGridPositionProvider spannedGridPositionProvider, @NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "gridPositionProvider");
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new SerpSpanProviderImpl(resources.getInteger(R.integer.serp_columns), spannedGridPositionProvider);
    }

    @Provides
    @NotNull
    @PerFragment
    public final SubscriptionsPresenter provideSubscriptionsPresenterImpl(@NotNull Lazy<ShopDetailedPresenter> lazy, @NotNull NotificationManagerProvider notificationManagerProvider, @NotNull FavoriteSellersRepository favoriteSellersRepository, @NotNull AccountStateProvider accountStateProvider, @NotNull SubscriptionsResourceProvider subscriptionsResourceProvider, @NotNull SubscribeInteractor subscribeInteractor, @NotNull ErrorHelper errorHelper, @NotNull Analytics analytics, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull CompositeSnackbarPresenter compositeSnackbarPresenter, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(lazy, "detailedPresenter");
        Intrinsics.checkNotNullParameter(notificationManagerProvider, "notificationsManagerProvider");
        Intrinsics.checkNotNullParameter(favoriteSellersRepository, "favoriteSellersRepository");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(subscriptionsResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(subscribeInteractor, "interactor");
        Intrinsics.checkNotNullParameter(errorHelper, "errorHelper");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(compositeSnackbarPresenter, "snackbarPresenter");
        Intrinsics.checkNotNullParameter(features, "features");
        return new SubscriptionsPresenterImpl(notificationManagerProvider, favoriteSellersRepository, accountStateProvider, subscriptionsResourceProvider, subscribeInteractor, errorHelper, lazy, schedulersFactory3, analytics, this.d, SubscriptionSource.SHOP_PAGE, compositeSnackbarPresenter, features);
    }
}
