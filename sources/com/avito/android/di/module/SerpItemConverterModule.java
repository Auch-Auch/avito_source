package com.avito.android.di.module;

import android.content.res.Resources;
import com.avito.android.Features;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.di.ViewedAdvertsModule;
import com.avito.android.favorite.FavoriteAdvertsInteractor;
import com.avito.android.favorite.di.FavoriteItemModule;
import com.avito.android.serp.SerpItemProcessor;
import com.avito.android.serp.SerpItemProcessorImpl;
import com.avito.android.serp.ad.AdResourceProvider;
import com.avito.android.serp.adapter.AdvertSpanCountProvider;
import com.avito.android.serp.adapter.FavoriteStatusResolver;
import com.avito.android.serp.adapter.FavoriteStatusResolverImpl;
import com.avito.android.serp.adapter.HeaderElementConverter;
import com.avito.android.serp.adapter.HeaderElementConverterImpl;
import com.avito.android.serp.adapter.LayoutTypeProvider;
import com.avito.android.serp.adapter.LayoutTypeProviderImpl;
import com.avito.android.serp.adapter.SellerElementConverter;
import com.avito.android.serp.adapter.SellerElementConverterImpl;
import com.avito.android.serp.adapter.SerpAdvertConverter;
import com.avito.android.serp.adapter.SerpAdvertConverterImpl;
import com.avito.android.serp.adapter.SerpCommercialBannerConverter;
import com.avito.android.serp.adapter.SerpCommercialBannerConverterImpl;
import com.avito.android.serp.adapter.SerpElementItemConverter;
import com.avito.android.serp.adapter.SerpElementItemConverterImpl;
import com.avito.android.serp.adapter.SerpItemSizeAdjuster;
import com.avito.android.serp.adapter.SerpItemSizeAdjusterImpl;
import com.avito.android.serp.adapter.ShortcutBannerConverter;
import com.avito.android.serp.adapter.ShortcutBannerConverterImpl;
import com.avito.android.serp.adapter.SimpleAdvertSpanCountProvider;
import com.avito.android.serp.adapter.ViewTypeColumnProvider;
import com.avito.android.serp.adapter.ViewTypeColumnProviderImpl;
import com.avito.android.serp.adapter.ViewedStatusResolver;
import com.avito.android.serp.adapter.advert_xl.SerpAdvertXlConverter;
import com.avito.android.serp.adapter.advert_xl.SerpAdvertXlConverterImpl;
import com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemConverter;
import com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemConverterImpl;
import com.avito.android.serp.adapter.empty_search.EmptySearchItemConverter;
import com.avito.android.serp.adapter.empty_search.EmptySearchItemConverterImpl;
import com.avito.android.serp.adapter.item_sorter.SerpItemSorter;
import com.avito.android.serp.adapter.item_sorter.SerpItemSorterImpl;
import com.avito.android.serp.adapter.location_notification.LocationNotificationItemConvertImpl;
import com.avito.android.serp.adapter.location_notification.LocationNotificationItemConverter;
import com.avito.android.serp.adapter.map_banner.MapBannerItemConverter;
import com.avito.android.serp.adapter.map_banner.MapBannerItemConverterImpl;
import com.avito.android.serp.adapter.promo_card.PromoCardConverter;
import com.avito.android.serp.adapter.promo_card.PromoCardConverterImpl;
import com.avito.android.serp.adapter.promo_card.ReportBannerConverter;
import com.avito.android.serp.adapter.promo_card.ReportBannerConverterImpl;
import com.avito.android.serp.adapter.snippet.SnippetConverter;
import com.avito.android.serp.adapter.title.GroupTitleItemConverter;
import com.avito.android.serp.adapter.title.GroupTitleItemConverterImpl;
import com.avito.android.serp.adapter.vertical_main.VerticalFilterItemConverter;
import com.avito.android.serp.adapter.vertical_main.VerticalFilterItemConverterImpl;
import com.avito.android.serp.adapter.warning.SerpWarningConverter;
import com.avito.android.serp.adapter.warning.SerpWarningConverterImpl;
import com.avito.android.serp.adapter.witcher.WitcherElementConverter;
import com.avito.android.serp.adapter.witcher.WitcherElementConverterImpl;
import com.avito.android.ui_components.R;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.GeoContract;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0012\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bx\u0010yJ?\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0001\u0010@\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u0002002\u0006\u00103\u001a\u0002022\u0006\u00105\u001a\u0002042\u0006\u00107\u001a\u0002062\u0006\u00109\u001a\u0002082\u0006\u0010;\u001a\u00020:2\u0006\u0010=\u001a\u00020<2\u0006\u0010?\u001a\u00020>H\u0007¢\u0006\u0004\b@\u0010AJ3\u0010I\u001a\u00020\u001e2\b\b\u0001\u0010C\u001a\u00020B2\b\b\u0001\u0010D\u001a\u00020B2\u0006\u0010F\u001a\u00020E2\u0006\u0010H\u001a\u00020GH\u0007¢\u0006\u0004\bI\u0010JJ\u001f\u0010K\u001a\u00020 2\u0006\u0010F\u001a\u00020E2\u0006\u0010H\u001a\u00020GH\u0007¢\u0006\u0004\bK\u0010LJ3\u0010Q\u001a\u00020\"2\b\b\u0001\u0010C\u001a\u00020B2\b\b\u0001\u0010D\u001a\u00020B2\u0006\u0010N\u001a\u00020M2\u0006\u0010P\u001a\u00020OH\u0007¢\u0006\u0004\bQ\u0010RJ\u001f\u0010U\u001a\u00020$2\u0006\u0010T\u001a\u00020S2\u0006\u0010F\u001a\u00020EH\u0007¢\u0006\u0004\bU\u0010VJ\u001f\u0010W\u001a\u0002082\u0006\u0010F\u001a\u00020E2\u0006\u0010H\u001a\u00020GH\u0007¢\u0006\u0004\bW\u0010XJ\u001f\u0010Y\u001a\u00020:2\u0006\u0010F\u001a\u00020E2\u0006\u0010H\u001a\u00020GH\u0007¢\u0006\u0004\bY\u0010ZJ\u000f\u0010[\u001a\u00020&H\u0007¢\u0006\u0004\b[\u0010\\J\u000f\u0010]\u001a\u00020,H\u0007¢\u0006\u0004\b]\u0010^J\u000f\u0010_\u001a\u00020.H\u0007¢\u0006\u0004\b_\u0010`J\u000f\u0010a\u001a\u00020(H\u0007¢\u0006\u0004\ba\u0010bJ\u0017\u0010c\u001a\u00020B2\u0006\u0010F\u001a\u00020EH\u0007¢\u0006\u0004\bc\u0010dJ\u0017\u0010e\u001a\u00020B2\u0006\u0010F\u001a\u00020EH\u0007¢\u0006\u0004\be\u0010dJ\u000f\u0010f\u001a\u00020*H\u0007¢\u0006\u0004\bf\u0010gJ\u0017\u0010j\u001a\u00020\u00172\u0006\u0010i\u001a\u00020hH\u0007¢\u0006\u0004\bj\u0010kJ\u000f\u0010l\u001a\u000200H\u0007¢\u0006\u0004\bl\u0010mJ\u000f\u0010n\u001a\u000206H\u0007¢\u0006\u0004\bn\u0010oJ'\u0010p\u001a\u0002022\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\bp\u0010qJ\u000f\u0010r\u001a\u000204H\u0007¢\u0006\u0004\br\u0010sJ\u000f\u0010t\u001a\u00020<H\u0007¢\u0006\u0004\bt\u0010uJ\u000f\u0010v\u001a\u00020>H\u0007¢\u0006\u0004\bv\u0010w¨\u0006z"}, d2 = {"Lcom/avito/android/di/module/SerpItemConverterModule;", "", "Lcom/avito/android/serp/adapter/SerpElementItemConverter;", "itemConverter", "Lcom/avito/android/serp/adapter/item_sorter/SerpItemSorter;", "itemSorter", "Lcom/avito/android/serp/adapter/SerpItemSizeAdjuster;", "sizeAdjuster", "Lcom/avito/android/serp/adapter/FavoriteStatusResolver;", "favoriteStatusResolver", "Lcom/avito/android/serp/adapter/ViewedStatusResolver;", "viewedStatusResolver", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/serp/SerpItemProcessor;", "provideSerpItemProcessor", "(Lcom/avito/android/serp/adapter/SerpElementItemConverter;Lcom/avito/android/serp/adapter/item_sorter/SerpItemSorter;Lcom/avito/android/serp/adapter/SerpItemSizeAdjuster;Lcom/avito/android/serp/adapter/FavoriteStatusResolver;Lcom/avito/android/serp/adapter/ViewedStatusResolver;Lcom/avito/android/util/SchedulersFactory3;)Lcom/avito/android/serp/SerpItemProcessor;", "Lcom/avito/android/favorite/FavoriteAdvertsInteractor;", "favoriteAdvertsInteractor", "provideFavoriteStatusResolver", "(Lcom/avito/android/favorite/FavoriteAdvertsInteractor;)Lcom/avito/android/serp/adapter/FavoriteStatusResolver;", "provideSerpItemSorter", "()Lcom/avito/android/serp/adapter/item_sorter/SerpItemSorter;", "Lcom/avito/android/serp/adapter/LayoutTypeProvider;", "layoutTypeProvider", "Lcom/avito/android/serp/adapter/ViewTypeColumnProvider;", "provideViewTypeColumnProvider", "(Lcom/avito/android/serp/adapter/LayoutTypeProvider;)Lcom/avito/android/serp/adapter/ViewTypeColumnProvider;", "provideItemSizeAdjuster", "()Lcom/avito/android/serp/adapter/SerpItemSizeAdjuster;", "Lcom/avito/android/serp/adapter/SerpAdvertConverter;", "serpAdvertConverter", "Lcom/avito/android/serp/adapter/advert_xl/SerpAdvertXlConverter;", "serpAdvertXlConverter", "Lcom/avito/android/serp/adapter/SerpCommercialBannerConverter;", "serpCommercialBannerConverter", "Lcom/avito/android/serp/adapter/ShortcutBannerConverter;", "shortcutBannerConverter", "Lcom/avito/android/serp/adapter/warning/SerpWarningConverter;", "serpWarningConverter", "Lcom/avito/android/serp/adapter/snippet/SnippetConverter;", "snippetConverter", "Lcom/avito/android/serp/adapter/empty_search/EmptySearchItemConverter;", "emptySearchItemConverter", "Lcom/avito/android/serp/adapter/title/GroupTitleItemConverter;", "groupTitleItemConverter", "Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemConverter;", "emptyPlaceholderItemConverter", "Lcom/avito/android/serp/adapter/HeaderElementConverter;", "headerElementConverter", "Lcom/avito/android/serp/adapter/witcher/WitcherElementConverter;", "witcherElementConverter", "Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItemConverter;", "locationNotificationConverter", "Lcom/avito/android/serp/adapter/SellerElementConverter;", "sellerElementConverter", "Lcom/avito/android/serp/adapter/promo_card/ReportBannerConverter;", "reportBannerConverter", "Lcom/avito/android/serp/adapter/promo_card/PromoCardConverter;", "promoCardConverter", "Lcom/avito/android/serp/adapter/map_banner/MapBannerItemConverter;", "mapBannerItemConverter", "Lcom/avito/android/serp/adapter/vertical_main/VerticalFilterItemConverter;", "verticalFilterItemConverter", "provideElementItemConverter", "(Lcom/avito/android/serp/adapter/SerpAdvertConverter;Lcom/avito/android/serp/adapter/advert_xl/SerpAdvertXlConverter;Lcom/avito/android/serp/adapter/SerpCommercialBannerConverter;Lcom/avito/android/serp/adapter/ShortcutBannerConverter;Lcom/avito/android/serp/adapter/warning/SerpWarningConverter;Lcom/avito/android/serp/adapter/snippet/SnippetConverter;Lcom/avito/android/serp/adapter/empty_search/EmptySearchItemConverter;Lcom/avito/android/serp/adapter/title/GroupTitleItemConverter;Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemConverter;Lcom/avito/android/serp/adapter/HeaderElementConverter;Lcom/avito/android/serp/adapter/witcher/WitcherElementConverter;Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItemConverter;Lcom/avito/android/serp/adapter/SellerElementConverter;Lcom/avito/android/serp/adapter/promo_card/ReportBannerConverter;Lcom/avito/android/serp/adapter/promo_card/PromoCardConverter;Lcom/avito/android/serp/adapter/map_banner/MapBannerItemConverter;Lcom/avito/android/serp/adapter/vertical_main/VerticalFilterItemConverter;)Lcom/avito/android/serp/adapter/SerpElementItemConverter;", "Lcom/avito/android/serp/adapter/AdvertSpanCountProvider;", "itemSpanCountProvider", "bigSpanCountProvider", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/Features;", "features", "provideAdvertConverter", "(Lcom/avito/android/serp/adapter/AdvertSpanCountProvider;Lcom/avito/android/serp/adapter/AdvertSpanCountProvider;Landroid/content/res/Resources;Lcom/avito/android/Features;)Lcom/avito/android/serp/adapter/SerpAdvertConverter;", "provideAdvertXlConverter", "(Landroid/content/res/Resources;Lcom/avito/android/Features;)Lcom/avito/android/serp/adapter/advert_xl/SerpAdvertXlConverter;", "Lcom/avito/android/serp/ad/AdResourceProvider;", "adResourceProvider", "Lcom/avito/android/util/RandomKeyProvider;", GeoContract.PROVIDER, "provideCommercialConverter", "(Lcom/avito/android/serp/adapter/AdvertSpanCountProvider;Lcom/avito/android/serp/adapter/AdvertSpanCountProvider;Lcom/avito/android/serp/ad/AdResourceProvider;Lcom/avito/android/util/RandomKeyProvider;)Lcom/avito/android/serp/adapter/SerpCommercialBannerConverter;", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "provideShortcutBannerConverter", "(Lcom/avito/android/deep_linking/DeepLinkFactory;Landroid/content/res/Resources;)Lcom/avito/android/serp/adapter/ShortcutBannerConverter;", "provideReportBannerConverter", "(Landroid/content/res/Resources;Lcom/avito/android/Features;)Lcom/avito/android/serp/adapter/promo_card/ReportBannerConverter;", "providePromoCardConverter", "(Landroid/content/res/Resources;Lcom/avito/android/Features;)Lcom/avito/android/serp/adapter/promo_card/PromoCardConverter;", "provideSerpWarningConverter", "()Lcom/avito/android/serp/adapter/warning/SerpWarningConverter;", "provideGroupTitleItemConverter", "()Lcom/avito/android/serp/adapter/title/GroupTitleItemConverter;", "provideEmptyPlaceholderItemConverter", "()Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemConverter;", "provideSnippetConverter", "()Lcom/avito/android/serp/adapter/snippet/SnippetConverter;", "provideBigAdvertSpanCountProvider", "(Landroid/content/res/Resources;)Lcom/avito/android/serp/adapter/AdvertSpanCountProvider;", "provideItemAdvertSpanCountProvider", "provideSerpEmptySearchConverter", "()Lcom/avito/android/serp/adapter/empty_search/EmptySearchItemConverter;", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "provideLayoutTypeProvider", "(Lcom/avito/android/util/DeviceMetrics;)Lcom/avito/android/serp/adapter/LayoutTypeProvider;", "provideHeaderElementConverter", "()Lcom/avito/android/serp/adapter/HeaderElementConverter;", "provideSellerElementConverter", "()Lcom/avito/android/serp/adapter/SellerElementConverter;", "provideWitcherElementConverter", "(Lcom/avito/android/serp/adapter/SerpAdvertConverter;Lcom/avito/android/serp/adapter/FavoriteStatusResolver;Lcom/avito/android/serp/adapter/ViewedStatusResolver;)Lcom/avito/android/serp/adapter/witcher/WitcherElementConverter;", "provideLocationNotificationConverter", "()Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItemConverter;", "provideMapBannerConverter", "()Lcom/avito/android/serp/adapter/map_banner/MapBannerItemConverter;", "provideVerticalFilterItemConverter", "()Lcom/avito/android/serp/adapter/vertical_main/VerticalFilterItemConverter;", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {ViewedAdvertsModule.class, FavoriteItemModule.class})
public final class SerpItemConverterModule {
    @NotNull
    public static final SerpItemConverterModule INSTANCE = new SerpItemConverterModule();

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final SerpAdvertConverter provideAdvertConverter(@ItemAdvertSpanCountProvider @NotNull AdvertSpanCountProvider advertSpanCountProvider, @BigAdvertSpanCountProvider @NotNull AdvertSpanCountProvider advertSpanCountProvider2, @NotNull Resources resources, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(advertSpanCountProvider, "itemSpanCountProvider");
        Intrinsics.checkNotNullParameter(advertSpanCountProvider2, "bigSpanCountProvider");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(features, "features");
        return new SerpAdvertConverterImpl(advertSpanCountProvider, advertSpanCountProvider2, resources.getBoolean(R.bool.is_tablet), features);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final SerpAdvertXlConverter provideAdvertXlConverter(@NotNull Resources resources, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(features, "features");
        return new SerpAdvertXlConverterImpl(resources.getInteger(com.avito.android.serp_core.R.integer.advert_xl_span_count), features);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    @BigAdvertSpanCountProvider
    public static final AdvertSpanCountProvider provideBigAdvertSpanCountProvider(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new SimpleAdvertSpanCountProvider(resources.getInteger(R.integer.serp_big_item_span_count));
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final SerpCommercialBannerConverter provideCommercialConverter(@ItemAdvertSpanCountProvider @NotNull AdvertSpanCountProvider advertSpanCountProvider, @BigAdvertSpanCountProvider @NotNull AdvertSpanCountProvider advertSpanCountProvider2, @NotNull AdResourceProvider adResourceProvider, @NotNull RandomKeyProvider randomKeyProvider) {
        Intrinsics.checkNotNullParameter(advertSpanCountProvider, "itemSpanCountProvider");
        Intrinsics.checkNotNullParameter(advertSpanCountProvider2, "bigSpanCountProvider");
        Intrinsics.checkNotNullParameter(adResourceProvider, "adResourceProvider");
        Intrinsics.checkNotNullParameter(randomKeyProvider, GeoContract.PROVIDER);
        return new SerpCommercialBannerConverterImpl(advertSpanCountProvider, advertSpanCountProvider2, adResourceProvider, randomKeyProvider);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final SerpElementItemConverter provideElementItemConverter(@NotNull SerpAdvertConverter serpAdvertConverter, @NotNull SerpAdvertXlConverter serpAdvertXlConverter, @NotNull SerpCommercialBannerConverter serpCommercialBannerConverter, @NotNull ShortcutBannerConverter shortcutBannerConverter, @NotNull SerpWarningConverter serpWarningConverter, @NotNull SnippetConverter snippetConverter, @NotNull EmptySearchItemConverter emptySearchItemConverter, @NotNull GroupTitleItemConverter groupTitleItemConverter, @NotNull EmptyPlaceholderItemConverter emptyPlaceholderItemConverter, @NotNull HeaderElementConverter headerElementConverter, @NotNull WitcherElementConverter witcherElementConverter, @NotNull LocationNotificationItemConverter locationNotificationItemConverter, @NotNull SellerElementConverter sellerElementConverter, @NotNull ReportBannerConverter reportBannerConverter, @NotNull PromoCardConverter promoCardConverter, @NotNull MapBannerItemConverter mapBannerItemConverter, @NotNull VerticalFilterItemConverter verticalFilterItemConverter) {
        Intrinsics.checkNotNullParameter(serpAdvertConverter, "serpAdvertConverter");
        Intrinsics.checkNotNullParameter(serpAdvertXlConverter, "serpAdvertXlConverter");
        Intrinsics.checkNotNullParameter(serpCommercialBannerConverter, "serpCommercialBannerConverter");
        Intrinsics.checkNotNullParameter(shortcutBannerConverter, "shortcutBannerConverter");
        Intrinsics.checkNotNullParameter(serpWarningConverter, "serpWarningConverter");
        Intrinsics.checkNotNullParameter(snippetConverter, "snippetConverter");
        Intrinsics.checkNotNullParameter(emptySearchItemConverter, "emptySearchItemConverter");
        Intrinsics.checkNotNullParameter(groupTitleItemConverter, "groupTitleItemConverter");
        Intrinsics.checkNotNullParameter(emptyPlaceholderItemConverter, "emptyPlaceholderItemConverter");
        Intrinsics.checkNotNullParameter(headerElementConverter, "headerElementConverter");
        Intrinsics.checkNotNullParameter(witcherElementConverter, "witcherElementConverter");
        Intrinsics.checkNotNullParameter(locationNotificationItemConverter, "locationNotificationConverter");
        Intrinsics.checkNotNullParameter(sellerElementConverter, "sellerElementConverter");
        Intrinsics.checkNotNullParameter(reportBannerConverter, "reportBannerConverter");
        Intrinsics.checkNotNullParameter(promoCardConverter, "promoCardConverter");
        Intrinsics.checkNotNullParameter(mapBannerItemConverter, "mapBannerItemConverter");
        Intrinsics.checkNotNullParameter(verticalFilterItemConverter, "verticalFilterItemConverter");
        return new SerpElementItemConverterImpl(serpAdvertConverter, serpAdvertXlConverter, serpCommercialBannerConverter, shortcutBannerConverter, serpWarningConverter, snippetConverter, emptySearchItemConverter, groupTitleItemConverter, emptyPlaceholderItemConverter, headerElementConverter, witcherElementConverter, locationNotificationItemConverter, sellerElementConverter, reportBannerConverter, promoCardConverter, mapBannerItemConverter, verticalFilterItemConverter);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final EmptyPlaceholderItemConverter provideEmptyPlaceholderItemConverter() {
        return new EmptyPlaceholderItemConverterImpl(6);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final FavoriteStatusResolver provideFavoriteStatusResolver(@NotNull FavoriteAdvertsInteractor favoriteAdvertsInteractor) {
        Intrinsics.checkNotNullParameter(favoriteAdvertsInteractor, "favoriteAdvertsInteractor");
        return new FavoriteStatusResolverImpl(favoriteAdvertsInteractor);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final GroupTitleItemConverter provideGroupTitleItemConverter() {
        return new GroupTitleItemConverterImpl(6);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final HeaderElementConverter provideHeaderElementConverter() {
        return new HeaderElementConverterImpl(6);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    @ItemAdvertSpanCountProvider
    public static final AdvertSpanCountProvider provideItemAdvertSpanCountProvider(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new SimpleAdvertSpanCountProvider(resources.getInteger(R.integer.serp_item_span_count));
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final SerpItemSizeAdjuster provideItemSizeAdjuster() {
        return new SerpItemSizeAdjusterImpl();
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final LayoutTypeProvider provideLayoutTypeProvider(@NotNull DeviceMetrics deviceMetrics) {
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        return new LayoutTypeProviderImpl(deviceMetrics);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final LocationNotificationItemConverter provideLocationNotificationConverter() {
        return new LocationNotificationItemConvertImpl(6);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final MapBannerItemConverter provideMapBannerConverter() {
        return new MapBannerItemConverterImpl(6);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final PromoCardConverter providePromoCardConverter(@NotNull Resources resources, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(features, "features");
        return new PromoCardConverterImpl(resources.getInteger(R.integer.serp_columns), features);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final ReportBannerConverter provideReportBannerConverter(@NotNull Resources resources, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(features, "features");
        return new ReportBannerConverterImpl(resources.getInteger(R.integer.serp_columns), features);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final SellerElementConverter provideSellerElementConverter() {
        return new SellerElementConverterImpl(6);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final EmptySearchItemConverter provideSerpEmptySearchConverter() {
        return new EmptySearchItemConverterImpl(6);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final SerpItemProcessor provideSerpItemProcessor(@NotNull SerpElementItemConverter serpElementItemConverter, @NotNull SerpItemSorter serpItemSorter, @NotNull SerpItemSizeAdjuster serpItemSizeAdjuster, @NotNull FavoriteStatusResolver favoriteStatusResolver, @NotNull ViewedStatusResolver viewedStatusResolver, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(serpElementItemConverter, "itemConverter");
        Intrinsics.checkNotNullParameter(serpItemSorter, "itemSorter");
        Intrinsics.checkNotNullParameter(serpItemSizeAdjuster, "sizeAdjuster");
        Intrinsics.checkNotNullParameter(favoriteStatusResolver, "favoriteStatusResolver");
        Intrinsics.checkNotNullParameter(viewedStatusResolver, "viewedStatusResolver");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        return new SerpItemProcessorImpl(serpElementItemConverter, serpItemSorter, serpItemSizeAdjuster, favoriteStatusResolver, viewedStatusResolver, schedulersFactory3);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final SerpItemSorter provideSerpItemSorter() {
        return new SerpItemSorterImpl();
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final SerpWarningConverter provideSerpWarningConverter() {
        return new SerpWarningConverterImpl(6);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final ShortcutBannerConverter provideShortcutBannerConverter(@NotNull DeepLinkFactory deepLinkFactory, @NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new ShortcutBannerConverterImpl(deepLinkFactory, resources.getInteger(R.integer.serp_columns));
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final SnippetConverter provideSnippetConverter() {
        return new SnippetConverter.Impl(6);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final VerticalFilterItemConverter provideVerticalFilterItemConverter() {
        return new VerticalFilterItemConverterImpl();
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final ViewTypeColumnProvider provideViewTypeColumnProvider(@NotNull LayoutTypeProvider layoutTypeProvider) {
        Intrinsics.checkNotNullParameter(layoutTypeProvider, "layoutTypeProvider");
        return new ViewTypeColumnProviderImpl(layoutTypeProvider);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final WitcherElementConverter provideWitcherElementConverter(@NotNull SerpAdvertConverter serpAdvertConverter, @NotNull FavoriteStatusResolver favoriteStatusResolver, @NotNull ViewedStatusResolver viewedStatusResolver) {
        Intrinsics.checkNotNullParameter(serpAdvertConverter, "serpAdvertConverter");
        Intrinsics.checkNotNullParameter(favoriteStatusResolver, "favoriteStatusResolver");
        Intrinsics.checkNotNullParameter(viewedStatusResolver, "viewedStatusResolver");
        return new WitcherElementConverterImpl(6, serpAdvertConverter, favoriteStatusResolver, viewedStatusResolver);
    }
}
