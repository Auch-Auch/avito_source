package ru.avito.component.serp;

import android.net.Uri;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.image_loader.Picture;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J1\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0011\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u0005H&¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u0014\u0010\u000eJ#\u0010\u0017\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u001a\u0010\u000eJ\u0019\u0010\u001c\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u001c\u0010\u000eJ\u0017\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010\"\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\"\u0010\u000eJ\u0019\u0010$\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b$\u0010\u000eJ\u0017\u0010&\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0005H&¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u0005H&¢\u0006\u0004\b)\u0010'J\u0017\u0010+\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u0005H&¢\u0006\u0004\b+\u0010'J\u0017\u0010-\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u0005H&¢\u0006\u0004\b-\u0010'J\u0017\u0010/\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u0005H&¢\u0006\u0004\b/\u0010'J\u0017\u00101\u001a\u00020\t2\u0006\u00100\u001a\u00020\u0005H&¢\u0006\u0004\b1\u0010'J\u001d\u00104\u001a\u00020\t2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\t02H&¢\u0006\u0004\b4\u00105J\u001d\u00106\u001a\u00020\t2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\t02H&¢\u0006\u0004\b6\u00105J\u0017\u00109\u001a\u0002082\u0006\u00107\u001a\u00020\u0003H&¢\u0006\u0004\b9\u0010:J\u0019\u0010<\u001a\u00020\t2\b\u0010;\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b<\u0010\u000eJ\u0017\u0010?\u001a\u00020\t2\u0006\u0010>\u001a\u00020=H&¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\tH&¢\u0006\u0004\bA\u0010BJ\u001f\u0010E\u001a\u00020\t2\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010\u0002H&¢\u0006\u0004\bE\u0010FJ\u0019\u0010H\u001a\u00020\t2\b\u0010G\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\bH\u0010\u000eJ\u0019\u0010I\u001a\u00020\t2\b\u0010G\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\bI\u0010\u000e¨\u0006J"}, d2 = {"Lru/avito/component/serp/RdsSerpAdvertCard;", "", "", "Lcom/avito/android/image_loader/Picture;", "pictures", "", "cancelOnDetach", "", BookingInfoActivity.EXTRA_ITEM_ID, "", "setPictures", "(Ljava/util/List;ZLjava/lang/String;)V", "title", "setTitle", "(Ljava/lang/String;)V", "price", "isHighlighted", "setPrice", "(Ljava/lang/String;Z)V", "priceWithoutDiscount", "setPriceWithoutDiscount", "oldPrice", "discountPercentage", "setMarketplaceDiscount", "(Ljava/lang/String;Ljava/lang/String;)V", "location", "setLocation", Sort.DISTANCE, "setDistance", "", "time", "setDate", "(J)V", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "setAddress", "shopName", "setShopName", "active", "setActive", "(Z)V", "viewed", "setViewed", "visible", "setFavoriteVisible", "favorite", "setFavorite", "isSafeDeal", "setSafeDealVisible", "isShowDelivery", "setDeliveryVisible", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnFavoriteButtonClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setClickListener", "picture", "Landroid/net/Uri;", "getPictureUri", "(Lcom/avito/android/image_loader/Picture;)Landroid/net/Uri;", "text", "setAdditionalName", "Lcom/avito/android/remote/model/badge/Badge;", "badge", "setBadge", "(Lcom/avito/android/remote/model/badge/Badge;)V", "hideBadge", "()V", "Lcom/avito/android/remote/model/badge_bar/SerpBadge;", "badges", "bindBadges", "(Ljava/util/List;)V", "value", "setInStock", "setTrustFactor", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface RdsSerpAdvertCard {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void setPictures$default(RdsSerpAdvertCard rdsSerpAdvertCard, List list, boolean z, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str = null;
                }
                rdsSerpAdvertCard.setPictures(list, z, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setPictures");
        }
    }

    void bindBadges(@Nullable List<SerpBadge> list);

    @NotNull
    Uri getPictureUri(@NotNull Picture picture);

    void hideBadge();

    void setActive(boolean z);

    void setAdditionalName(@Nullable String str);

    void setAddress(@Nullable String str);

    void setBadge(@NotNull Badge badge);

    void setClickListener(@NotNull Function0<Unit> function0);

    void setDate(long j);

    void setDeliveryVisible(boolean z);

    void setDistance(@Nullable String str);

    void setFavorite(boolean z);

    void setFavoriteVisible(boolean z);

    void setInStock(@Nullable String str);

    void setLocation(@Nullable String str);

    void setMarketplaceDiscount(@Nullable String str, @Nullable String str2);

    void setOnFavoriteButtonClickListener(@NotNull Function0<Unit> function0);

    void setPictures(@NotNull List<? extends Picture> list, boolean z, @Nullable String str);

    void setPrice(@Nullable String str, boolean z);

    void setPriceWithoutDiscount(@Nullable String str);

    void setSafeDealVisible(boolean z);

    void setShopName(@Nullable String str);

    void setTitle(@NotNull String str);

    void setTrustFactor(@Nullable String str);

    void setViewed(boolean z);
}
