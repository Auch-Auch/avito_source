package com.avito.android.serp;

import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.serp.ad.BannerInfo;
import com.avito.android.serp.analytics.BannerEvent;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJI\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\u0011JI\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0014\u0010\u0015JY\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u001b\u0010\bJ\u000f\u0010\u001c\u001a\u00020\u0006H&¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/avito/android/serp/CommercialBannersAnalyticsInteractor;", "", "Lcom/avito/android/serp/ad/BannerInfo;", "bannerInfo", "Lcom/avito/android/serp/analytics/BannerEvent$Type;", "bannerType", "", "sendBannerRequested", "(Lcom/avito/android/serp/ad/BannerInfo;Lcom/avito/android/serp/analytics/BannerEvent$Type;)V", "sendBannerPassback", "", VKApiConst.POSITION, "", "categoryId", "locationId", BookingInfoActivity.EXTRA_ITEM_ID, "sendBannerOpened", "(Lcom/avito/android/serp/ad/BannerInfo;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/serp/analytics/BannerEvent$Type;)V", "", "samplingEnabled", "sendBannerLoaded", "(Lcom/avito/android/serp/ad/BannerInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/avito/android/serp/analytics/BannerEvent$Type;)V", "", "throwable", CommonKt.TAG_ERROR_CODE, "sendBannerLoadingFailed", "(Lcom/avito/android/serp/ad/BannerInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/Integer;Lcom/avito/android/serp/analytics/BannerEvent$Type;)V", "sendBannerView", "returnToScreen", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface CommercialBannersAnalyticsInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void sendBannerLoaded$default(CommercialBannersAnalyticsInteractor commercialBannersAnalyticsInteractor, BannerInfo bannerInfo, String str, String str2, String str3, boolean z, BannerEvent.Type type, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    str3 = null;
                }
                if ((i & 32) != 0) {
                    type = BannerEvent.Type.DEFAULT;
                }
                commercialBannersAnalyticsInteractor.sendBannerLoaded(bannerInfo, str, str2, str3, z, type);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendBannerLoaded");
        }

        public static /* synthetic */ void sendBannerLoadingFailed$default(CommercialBannersAnalyticsInteractor commercialBannersAnalyticsInteractor, BannerInfo bannerInfo, String str, String str2, Throwable th, String str3, Integer num, BannerEvent.Type type, int i, Object obj) {
            if (obj == null) {
                commercialBannersAnalyticsInteractor.sendBannerLoadingFailed(bannerInfo, str, str2, (i & 8) != 0 ? null : th, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : num, (i & 64) != 0 ? BannerEvent.Type.DEFAULT : type);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendBannerLoadingFailed");
        }

        public static /* synthetic */ void sendBannerOpened$default(CommercialBannersAnalyticsInteractor commercialBannersAnalyticsInteractor, BannerInfo bannerInfo, int i, String str, String str2, String str3, BannerEvent.Type type, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 16) != 0) {
                    str3 = null;
                }
                if ((i2 & 32) != 0) {
                    type = BannerEvent.Type.DEFAULT;
                }
                commercialBannersAnalyticsInteractor.sendBannerOpened(bannerInfo, i, str, str2, str3, type);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendBannerOpened");
        }

        public static /* synthetic */ void sendBannerPassback$default(CommercialBannersAnalyticsInteractor commercialBannersAnalyticsInteractor, BannerInfo bannerInfo, BannerEvent.Type type, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    type = BannerEvent.Type.DEFAULT;
                }
                commercialBannersAnalyticsInteractor.sendBannerPassback(bannerInfo, type);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendBannerPassback");
        }

        public static /* synthetic */ void sendBannerRequested$default(CommercialBannersAnalyticsInteractor commercialBannersAnalyticsInteractor, BannerInfo bannerInfo, BannerEvent.Type type, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    type = BannerEvent.Type.DEFAULT;
                }
                commercialBannersAnalyticsInteractor.sendBannerRequested(bannerInfo, type);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendBannerRequested");
        }

        public static /* synthetic */ void sendBannerView$default(CommercialBannersAnalyticsInteractor commercialBannersAnalyticsInteractor, BannerInfo bannerInfo, BannerEvent.Type type, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    type = BannerEvent.Type.DEFAULT;
                }
                commercialBannersAnalyticsInteractor.sendBannerView(bannerInfo, type);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendBannerView");
        }
    }

    void returnToScreen();

    void sendBannerLoaded(@NotNull BannerInfo bannerInfo, @Nullable String str, @Nullable String str2, @Nullable String str3, boolean z, @NotNull BannerEvent.Type type);

    void sendBannerLoadingFailed(@NotNull BannerInfo bannerInfo, @Nullable String str, @Nullable String str2, @Nullable Throwable th, @Nullable String str3, @Nullable Integer num, @NotNull BannerEvent.Type type);

    void sendBannerOpened(@NotNull BannerInfo bannerInfo, int i, @Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull BannerEvent.Type type);

    void sendBannerPassback(@NotNull BannerInfo bannerInfo, @NotNull BannerEvent.Type type);

    void sendBannerRequested(@NotNull BannerInfo bannerInfo, @NotNull BannerEvent.Type type);

    void sendBannerView(@NotNull BannerInfo bannerInfo, @NotNull BannerEvent.Type type);
}
