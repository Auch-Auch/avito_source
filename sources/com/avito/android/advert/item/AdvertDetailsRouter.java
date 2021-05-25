package com.avito.android.advert.item;

import android.content.Intent;
import com.avito.android.advert.AdvertDetailsToolbarRouter;
import com.avito.android.advert.item.autoteka.AdvertDetailsAutotekaPresenter;
import com.avito.android.advert.item.autoteka.teaser.AdvertDetailsAutotekaTeaserPresenter;
import com.avito.android.advert.item.booking.AdvertBookingPresenter;
import com.avito.android.advert.item.cre_geo_report.AdvertDetailsGeoReportTeaserPresenter;
import com.avito.android.advert.item.delivery.AdvertDeliveryPresenter;
import com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen.CreditPartnerRouter;
import com.avito.android.advert.item.domoteka.conveyor.AdvertDetailsDomotekaTeaserPresenter;
import com.avito.android.advert.item.guide.AdvertDetailsGuidePresenter;
import com.avito.android.advert.item.note.AdvertDetailsNotePresenter;
import com.avito.android.advert.item.rating_publish.AdvertDetailsRatingPublishPresenter;
import com.avito.android.advert.item.safedeal.AdvertSafeDealPresenter;
import com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenter;
import com.avito.android.advert.item.shorttermrent.AdvertDetailsShortTermRentPresenter;
import com.avito.android.advert.item.spare_parts.SparePartsPresenter;
import com.avito.android.advert_core.advert.AdvertCoreRouter;
import com.avito.android.advert_core.advert_badge_bar.AdvertBadgeBarPresenter;
import com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartPresenter;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.links.DetailsSheetLinkBody;
import com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenter;
import com.avito.android.remote.model.AdvertActions;
import com.avito.android.remote.model.AdvertDetails;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.GeoReference;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Video;
import com.avito.android.remote.model.advert_details.ContactBarData;
import com.avito.android.remote.model.autoteka.AutotekaTeaserGalleryModel;
import com.avito.android.serp.adapter.promo_card.PromoCardItemPresenter;
import com.facebook.appevents.integrity.IntegrityManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.ErrorBundle;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e2\u00020\u000f2\u00020\u00102\u00020\u00112\u00020\u00122\u00020\u00132\u00020\u00142\u00020\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0019\u0010\u001aJ/\u0010!\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001b2\u0016\u0010 \u001a\u0012\u0012\b\u0012\u00060\u001ej\u0002`\u001f\u0012\u0004\u0012\u00020\u00180\u001dH&¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00182\u0006\u0010$\u001a\u00020#H&¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u0016H&¢\u0006\u0004\b(\u0010\u001aJC\u00101\u001a\u00020\u00182\b\u0010)\u001a\u0004\u0018\u00010\u00162\u0006\u0010*\u001a\u00020\u00162\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u00162\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010.H&¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u0016H&¢\u0006\u0004\b3\u0010\u001aJ\u0017\u00104\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u0016H&¢\u0006\u0004\b4\u0010\u001aJ\u0001\u0010I\u001a\u00020\u00182\u0006\u00106\u001a\u0002052\b\u00108\u001a\u0004\u0018\u0001072\u000e\u0010:\u001a\n\u0012\u0004\u0012\u000209\u0018\u00010.2\u0006\u0010<\u001a\u00020;2\b\u0010=\u001a\u0004\u0018\u00010\u00162\b\u0010?\u001a\u0004\u0018\u00010>2\b\u0010A\u001a\u0004\u0018\u00010@2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010B2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010F\u001a\u0004\u0018\u00010E2\b\u0010H\u001a\u0004\u0018\u00010GH&¢\u0006\u0004\bI\u0010JJW\u0010Q\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00162\b\u0010K\u001a\u0004\u0018\u00010\u00162\u0006\u0010-\u001a\u00020\u00162\b\u0010L\u001a\u0004\u0018\u00010\u00162\b\u0010M\u001a\u0004\u0018\u00010\u00162\b\u0010N\u001a\u0004\u0018\u0001092\u0006\u0010P\u001a\u00020O2\u0006\u0010<\u001a\u00020;H&¢\u0006\u0004\bQ\u0010RJ#\u0010T\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u00162\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u0016H&¢\u0006\u0004\bT\u0010UJ#\u0010W\u001a\u00020\u00182\b\u0010V\u001a\u0004\u0018\u00010\u00162\b\u0010=\u001a\u0004\u0018\u00010\u0016H&¢\u0006\u0004\bW\u0010UJ\u0017\u0010Y\u001a\u00020\u00182\u0006\u0010X\u001a\u00020\u0016H&¢\u0006\u0004\bY\u0010\u001aJ#\u0010[\u001a\u00020\u00182\b\u0010=\u001a\u0004\u0018\u00010\u00162\b\u0010Z\u001a\u0004\u0018\u00010\u0016H&¢\u0006\u0004\b[\u0010UJ\u001f\u0010`\u001a\u00020\u00182\u0006\u0010]\u001a\u00020\\2\u0006\u0010_\u001a\u00020^H&¢\u0006\u0004\b`\u0010a¨\u0006b"}, d2 = {"Lcom/avito/android/advert/item/AdvertDetailsRouter;", "Lcom/avito/android/advert_core/advert/AdvertCoreRouter;", "Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentPresenter$Router;", "Lcom/avito/android/advert/item/note/AdvertDetailsNotePresenter$Router;", "Lcom/avito/android/advert/AdvertDetailsToolbarRouter;", "Lcom/avito/android/advert/item/delivery/AdvertDeliveryPresenter$Router;", "Lcom/avito/android/advert/item/safedeal/AdvertSafeDealPresenter$Router;", "Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaPresenter$Router;", "Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserPresenter$Router;", "Lcom/avito/android/advert/item/AdvertDeeplinkRouter;", "Lcom/avito/android/advert/item/domoteka/conveyor/AdvertDetailsDomotekaTeaserPresenter$Router;", "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenter$Router;", "Lcom/avito/android/advert/item/rating_publish/AdvertDetailsRatingPublishPresenter$Router;", "Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemPresenter$Router;", "Lcom/avito/android/advert/item/guide/AdvertDetailsGuidePresenter$Router;", "Lcom/avito/android/advert/item/booking/AdvertBookingPresenter$Router;", "Lcom/avito/android/advert_core/advert_badge_bar/AdvertBadgeBarPresenter$Router;", "Lcom/avito/android/serp/adapter/promo_card/PromoCardItemPresenter$Router;", "Lcom/avito/android/advert/item/cre_geo_report/AdvertDetailsGeoReportTeaserPresenter$Router;", "Lcom/avito/android/advert/item/spare_parts/SparePartsPresenter$Router;", "Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/CreditPartnerRouter;", "Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartPresenter$Router;", "", "actionUri", "", "openAutoDeal", "(Ljava/lang/String;)V", "Landroid/content/Intent;", "intent", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorHandler", "openActivitySafely", "(Landroid/content/Intent;Lkotlin/jvm/functions/Function1;)V", "Lcom/avito/android/remote/model/AdvertDetails;", "advert", "openEditNote", "(Lcom/avito/android/remote/model/AdvertDetails;)V", "itemId", "showInactiveItem", BookingInfoActivity.EXTRA_ITEM_ID, IntegrityManager.INTEGRITY_TYPE_ADDRESS, "Lcom/avito/android/remote/model/Coordinates;", "coordinates", "title", "", "Lcom/avito/android/remote/model/GeoReference;", "geoReferences", "showAddressOnMap", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Ljava/lang/String;Ljava/util/List;)V", "showConsultationForm", "showAbuseCategoryScreen", "", "currentPosition", "Lcom/avito/android/remote/model/Video;", "advertVideo", "Lcom/avito/android/remote/model/Image;", "advertImages", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "categoryId", "Lcom/avito/android/remote/model/AdvertActions;", "actions", "Lcom/avito/android/remote/model/advert_details/ContactBarData;", "data", "", "stateId", "searchContext", "Lcom/avito/android/remote/model/ForegroundImage;", "foregroundImage", "Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;", "autotekaTeaser", "showGalleryFullscreen", "(ILcom/avito/android/remote/model/Video;Ljava/util/List;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Ljava/lang/String;Lcom/avito/android/remote/model/AdvertActions;Lcom/avito/android/remote/model/advert_details/ContactBarData;Ljava/lang/Long;Ljava/lang/String;Lcom/avito/android/remote/model/ForegroundImage;Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;)V", "context", "price", "oldPrice", "image", "", "isMarketplace", "openAdvertDetails", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;ZLcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)V", "message", "openMessengerWithMessage", "(Ljava/lang/String;Ljava/lang/String;)V", "selectedLocationId", "openSuggestLocation", "url", "openHelpCenterScreen", "microCategoryId", "setAnalyticsParams", "Lcom/avito/android/deep_linking/links/DetailsSheetLinkBody;", ErrorBundle.DETAIL_ENTRY, "Lcom/avito/android/analytics/provider/clickstream/ParametrizedClickStreamEvent;", "clickEvent", "openBottomSheet", "(Lcom/avito/android/deep_linking/links/DetailsSheetLinkBody;Lcom/avito/android/analytics/provider/clickstream/ParametrizedClickStreamEvent;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsRouter extends AdvertCoreRouter, AdvertDetailsShortTermRentPresenter.Router, AdvertDetailsNotePresenter.Router, AdvertDetailsToolbarRouter, AdvertDeliveryPresenter.Router, AdvertSafeDealPresenter.Router, AdvertDetailsAutotekaPresenter.Router, AdvertDetailsAutotekaTeaserPresenter.Router, AdvertDeeplinkRouter, AdvertDetailsDomotekaTeaserPresenter.Router, SellerSubscriptionPresenter.Router, AdvertDetailsRatingPublishPresenter.Router, RecommendationItemPresenter.Router, AdvertDetailsGuidePresenter.Router, AdvertBookingPresenter.Router, AdvertBadgeBarPresenter.Router, PromoCardItemPresenter.Router, AdvertDetailsGeoReportTeaserPresenter.Router, SparePartsPresenter.Router, CreditPartnerRouter, CarMarketPriceChartPresenter.Router {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void openMessengerWithMessage$default(AdvertDetailsRouter advertDetailsRouter, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = null;
                }
                advertDetailsRouter.openMessengerWithMessage(str, str2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openMessengerWithMessage");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.avito.android.advert.item.AdvertDetailsRouter */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void showAddressOnMap$default(AdvertDetailsRouter advertDetailsRouter, String str, String str2, Coordinates coordinates, String str3, List list, int i, Object obj) {
            if (obj == null) {
                if ((i & 16) != 0) {
                    list = null;
                }
                advertDetailsRouter.showAddressOnMap(str, str2, coordinates, str3, list);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showAddressOnMap");
        }

        public static /* synthetic */ void showGalleryFullscreen$default(AdvertDetailsRouter advertDetailsRouter, int i, Video video, List list, TreeClickStreamParent treeClickStreamParent, String str, AdvertActions advertActions, ContactBarData contactBarData, Long l, String str2, ForegroundImage foregroundImage, AutotekaTeaserGalleryModel autotekaTeaserGalleryModel, int i2, Object obj) {
            if (obj == null) {
                advertDetailsRouter.showGalleryFullscreen(i, video, list, treeClickStreamParent, str, advertActions, contactBarData, (i2 & 128) != 0 ? null : l, (i2 & 256) != 0 ? null : str2, (i2 & 512) != 0 ? null : foregroundImage, autotekaTeaserGalleryModel);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showGalleryFullscreen");
        }
    }

    void openActivitySafely(@NotNull Intent intent, @NotNull Function1<? super Exception, Unit> function1);

    void openAdvertDetails(@NotNull String str, @Nullable String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable Image image, boolean z, @NotNull TreeClickStreamParent treeClickStreamParent);

    void openAutoDeal(@NotNull String str);

    void openBottomSheet(@NotNull DetailsSheetLinkBody detailsSheetLinkBody, @NotNull ParametrizedClickStreamEvent parametrizedClickStreamEvent);

    void openEditNote(@NotNull AdvertDetails advertDetails);

    void openHelpCenterScreen(@NotNull String str);

    void openMessengerWithMessage(@NotNull String str, @Nullable String str2);

    void openSuggestLocation(@Nullable String str, @Nullable String str2);

    void setAnalyticsParams(@Nullable String str, @Nullable String str2);

    void showAbuseCategoryScreen(@NotNull String str);

    void showAddressOnMap(@Nullable String str, @NotNull String str2, @NotNull Coordinates coordinates, @NotNull String str3, @Nullable List<GeoReference> list);

    void showConsultationForm(@NotNull String str);

    void showGalleryFullscreen(int i, @Nullable Video video, @Nullable List<Image> list, @NotNull TreeClickStreamParent treeClickStreamParent, @Nullable String str, @Nullable AdvertActions advertActions, @Nullable ContactBarData contactBarData, @Nullable Long l, @Nullable String str2, @Nullable ForegroundImage foregroundImage, @Nullable AutotekaTeaserGalleryModel autotekaTeaserGalleryModel);

    void showInactiveItem(@NotNull String str);
}
