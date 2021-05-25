package com.avito.android.advert_core.advert;

import android.net.Uri;
import android.os.Parcelable;
import com.avito.android.authorization.AuthParamsKt;
import com.avito.android.autoteka_details.core.analytics.event.FromBlock;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.links.CvPackagesLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.in_app_calls.data.CallActivityRequest;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000f\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u000bH&¢\u0006\u0004\b \u0010!J\u001f\u0010%\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#H&¢\u0006\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/avito/android/advert_core/advert/AdvertCoreRouter;", "", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", "followUri", "(Landroid/net/Uri;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "", "source", "Landroid/os/Parcelable;", AuthParamsKt.KEY_SUCCESS_AUTH_RESULT_DATA, "onAuthRequired", "(Ljava/lang/String;Landroid/os/Parcelable;)V", "Lcom/avito/android/deep_linking/links/CvPackagesLink;", "link", "buyAdvertContacts", "(Lcom/avito/android/deep_linking/links/CvPackagesLink;)V", "Lcom/avito/android/in_app_calls/data/CallActivityRequest$Dial;", "dialRequest", "makeInAppCall", "(Lcom/avito/android/in_app_calls/data/CallActivityRequest$Dial;)V", "Lcom/avito/android/deep_linking/links/PhoneLink;", "phoneLink", "", "showError", "dialPhone", "(Lcom/avito/android/deep_linking/links/PhoneLink;Ljava/lang/String;Z)Z", BookingInfoActivity.EXTRA_ITEM_ID, "showContactAccessPackage", "(Ljava/lang/String;)V", "url", "Lcom/avito/android/autoteka_details/core/analytics/event/FromBlock;", BookingInfoActivity.EXTRA_FROM_BLOCK, "openAutotekaTeaser", "(Landroid/net/Uri;Lcom/avito/android/autoteka_details/core/analytics/event/FromBlock;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertCoreRouter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void onAuthRequired$default(AdvertCoreRouter advertCoreRouter, String str, Parcelable parcelable, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    parcelable = null;
                }
                advertCoreRouter.onAuthRequired(str, parcelable);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onAuthRequired");
        }
    }

    void buyAdvertContacts(@NotNull CvPackagesLink cvPackagesLink);

    boolean dialPhone(@NotNull PhoneLink phoneLink, @NotNull String str, boolean z);

    @Override // com.avito.android.advert.item.booking.AdvertBookingPresenter.Router, com.avito.android.advert_core.advert_badge_bar.AdvertBadgeBarPresenter.Router, com.avito.android.advert.item.cre_geo_report.AdvertDetailsGeoReportTeaserPresenter.Router, com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartPresenter.Router
    void followDeepLink(@NotNull DeepLink deepLink);

    void followUri(@NotNull Uri uri);

    void makeInAppCall(@NotNull CallActivityRequest.Dial dial);

    void onAuthRequired(@Nullable String str, @Nullable Parcelable parcelable);

    void openAutotekaTeaser(@NotNull Uri uri, @NotNull FromBlock fromBlock);

    void showContactAccessPackage(@NotNull String str);
}
