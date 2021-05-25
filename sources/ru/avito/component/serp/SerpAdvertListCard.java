package ru.avito.component.serp;

import android.net.Uri;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.expected.badge_bar.BadgeViewListener;
import com.avito.android.remote.model.RadiusInfo;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.badge.Badge;
import com.avito.android.remote.model.badge_bar.SerpBadge;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\r\u0010\u0006J\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000f\u0010\u0006J#\u0010\u0012\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0015\u0010\u0006J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u001b\u0010\u0006J!\u0010\u001c\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u001c\u0010\u0013J!\u0010\u001d\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u001d\u0010\u0013J#\u0010!\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b!\u0010\"J\u0019\u0010$\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b$\u0010\u0006J\u0017\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\bH&¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\bH&¢\u0006\u0004\b)\u0010'J\u0017\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\bH&¢\u0006\u0004\b+\u0010'J\u0017\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\bH&¢\u0006\u0004\b-\u0010'J\u0017\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\bH&¢\u0006\u0004\b/\u0010'J\u0017\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020\bH&¢\u0006\u0004\b1\u0010'J\u001f\u00104\u001a\u00020\u00042\u000e\u00103\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u000102H&¢\u0006\u0004\b4\u00105J\u001f\u00106\u001a\u00020\u00042\u000e\u00103\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u000102H&¢\u0006\u0004\b6\u00105J\u0017\u00107\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\bH&¢\u0006\u0004\b7\u0010'J\u0017\u0010:\u001a\u00020\u00042\u0006\u00109\u001a\u000208H&¢\u0006\u0004\b:\u0010;J\u0019\u0010=\u001a\u00020\u00042\b\u0010<\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b=\u0010\u0006J\u0017\u0010?\u001a\u00020>2\u0006\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\u0004H&¢\u0006\u0004\bA\u0010BJ\u0019\u0010D\u001a\u00020\u00042\b\u0010C\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\bD\u0010\u0006J\u001f\u0010E\u001a\u00020\u00042\u000e\u00103\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u000102H&¢\u0006\u0004\bE\u00105J\u0019\u0010F\u001a\u00020\u00042\b\u0010C\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\bF\u0010\u0006J\u0017\u0010I\u001a\u00020\u00042\u0006\u0010H\u001a\u00020GH&¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020\u0004H&¢\u0006\u0004\bK\u0010BJ)\u0010Q\u001a\u00020\u00042\u000e\u0010N\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010L2\b\u0010P\u001a\u0004\u0018\u00010OH&¢\u0006\u0004\bQ\u0010RJ\u0017\u0010T\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\bH&¢\u0006\u0004\bT\u0010'J\u0019\u0010V\u001a\u00020\u00042\b\u0010U\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\bV\u0010\u0006J#\u0010X\u001a\u00020\u00042\b\u0010U\u001a\u0004\u0018\u00010\u00022\b\u0010W\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\bX\u0010YJ\u0017\u0010[\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\bH&¢\u0006\u0004\b[\u0010'J\u0019\u0010]\u001a\u00020\u00042\b\u0010\\\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b]\u0010\u0006J\u0019\u0010^\u001a\u00020\u00042\b\u0010\\\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b^\u0010\u0006¨\u0006_"}, d2 = {"Lru/avito/component/serp/SerpAdvertListCard;", "", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "price", "", "isHighlighted", "setPrice", "(Ljava/lang/String;Z)V", "priceWithoutDiscount", "setPriceWithoutDiscount", "location", "setLocation", "Lcom/avito/android/remote/model/RadiusInfo;", "radiusInfo", "setLocationPostponed", "(Ljava/lang/String;Lcom/avito/android/remote/model/RadiusInfo;)V", Sort.DISTANCE, "setDistance", "", "time", "setDate", "(J)V", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "setAddress", "setRadiusLocation", "setRadiusAddress", "Lcom/avito/android/image_loader/Picture;", "picture", BookingInfoActivity.EXTRA_ITEM_ID, "setPicture", "(Lcom/avito/android/image_loader/Picture;Ljava/lang/String;)V", "shopName", "setShopName", "active", "setActive", "(Z)V", "viewed", "setViewed", "visible", "setFavoriteVisible", "favorite", "setFavorite", "enabled", "setFavoriteButtonEnabled", "isShowDelivery", "setDeliveryVisible", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnFavoriteButtonClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setClickListener", "setTitleRightMarginEnabled", "", "widthPx", "setWidth", "(I)V", "tag", "setShortTermRentTag", "Landroid/net/Uri;", "getPictureUri", "(Lcom/avito/android/image_loader/Picture;)Landroid/net/Uri;", "setFavoritesButtonImageResource", "()V", "text", "setAdditionalActionText", "setOnAdditionalActionClickListener", "setAdditionalName", "Lcom/avito/android/remote/model/badge/Badge;", "badge", "setBadge", "(Lcom/avito/android/remote/model/badge/Badge;)V", "hideBadge", "", "Lcom/avito/android/remote/model/badge_bar/SerpBadge;", "badges", "Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;", "badgeListener", "bindBadgeBar", "(Ljava/util/List;Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;)V", "enlarged", "setVideoIconEnlarged", "oldPrice", "setClassifiedDiscount", "discountPercentage", "setMarketplaceDiscount", "(Ljava/lang/String;Ljava/lang/String;)V", "hasVideo", "setHasVideo", "value", "setInStock", "setTrustFactor", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface SerpAdvertListCard {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void setPicture$default(SerpAdvertListCard serpAdvertListCard, Picture picture, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = null;
                }
                serpAdvertListCard.setPicture(picture, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setPicture");
        }
    }

    void bindBadgeBar(@Nullable List<SerpBadge> list, @Nullable BadgeViewListener badgeViewListener);

    @NotNull
    Uri getPictureUri(@NotNull Picture picture);

    void hideBadge();

    void setActive(boolean z);

    void setAdditionalActionText(@Nullable String str);

    void setAdditionalName(@Nullable String str);

    void setAddress(@Nullable String str);

    void setBadge(@NotNull Badge badge);

    void setClassifiedDiscount(@Nullable String str);

    void setClickListener(@Nullable Function0<Unit> function0);

    void setDate(long j);

    void setDeliveryVisible(boolean z);

    void setDistance(@Nullable String str);

    void setFavorite(boolean z);

    void setFavoriteButtonEnabled(boolean z);

    void setFavoriteVisible(boolean z);

    void setFavoritesButtonImageResource();

    void setHasVideo(boolean z);

    void setInStock(@Nullable String str);

    void setLocation(@Nullable String str);

    void setLocationPostponed(@Nullable String str, @Nullable RadiusInfo radiusInfo);

    void setMarketplaceDiscount(@Nullable String str, @Nullable String str2);

    void setOnAdditionalActionClickListener(@Nullable Function0<Unit> function0);

    void setOnFavoriteButtonClickListener(@Nullable Function0<Unit> function0);

    void setPicture(@NotNull Picture picture, @Nullable String str);

    void setPrice(@Nullable String str, boolean z);

    void setPriceWithoutDiscount(@Nullable String str);

    void setRadiusAddress(@Nullable String str, @NotNull RadiusInfo radiusInfo);

    void setRadiusLocation(@Nullable String str, @NotNull RadiusInfo radiusInfo);

    void setShopName(@Nullable String str);

    void setShortTermRentTag(@Nullable String str);

    void setTitle(@NotNull String str);

    void setTitleRightMarginEnabled(boolean z);

    void setTrustFactor(@Nullable String str);

    void setVideoIconEnlarged(boolean z);

    void setViewed(boolean z);

    void setWidth(int i);
}
