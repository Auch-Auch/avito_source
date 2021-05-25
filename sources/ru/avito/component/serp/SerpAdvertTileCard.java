package ru.avito.component.serp;

import android.net.Uri;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.expected.badge_bar.BadgeViewListener;
import com.avito.android.remote.model.RadiusInfo;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.badge.Badge;
import com.avito.android.remote.model.badge_bar.SerpBadge;
import com.avito.android.search.map.view.PanelStateKt;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\r\u0010\u0006J\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000f\u0010\u0006J!\u0010\u0012\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0015\u0010\u0013J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u001a\u0010\u0006J#\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010!\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b!\u0010\u0006J\u0017\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\bH&¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\bH&¢\u0006\u0004\b&\u0010$J\u0017\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\bH&¢\u0006\u0004\b(\u0010$J\u001f\u0010,\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\b2\u0006\u0010+\u001a\u00020*H&¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\bH&¢\u0006\u0004\b/\u0010$J\u001d\u00102\u001a\u00020\u00042\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000400H&¢\u0006\u0004\b2\u00103J\u001d\u00104\u001a\u00020\u00042\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000400H&¢\u0006\u0004\b4\u00103J\u0017\u00106\u001a\u0002052\u0006\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u00020\u00042\u0006\u00108\u001a\u00020\bH&¢\u0006\u0004\b9\u0010$J\u0019\u0010;\u001a\u00020\u00042\b\u0010:\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b;\u0010\u0006J\u0017\u0010>\u001a\u00020\u00042\u0006\u0010=\u001a\u00020<H&¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\u0004H&¢\u0006\u0004\b@\u0010AJ)\u0010G\u001a\u00020\u00042\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010B2\b\u0010F\u001a\u0004\u0018\u00010EH&¢\u0006\u0004\bG\u0010HJ\u0017\u0010J\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\bH&¢\u0006\u0004\bJ\u0010$J'\u0010L\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\b2\u000e\b\u0002\u0010K\u001a\b\u0012\u0004\u0012\u00020\u000400H&¢\u0006\u0004\bL\u0010MJ\u001f\u0010P\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\b2\u0006\u0010O\u001a\u00020\bH&¢\u0006\u0004\bP\u0010QJ\u0019\u0010S\u001a\u00020\u00042\b\u0010R\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\bS\u0010\u0006J#\u0010V\u001a\u00020\u00042\b\u0010T\u001a\u0004\u0018\u00010\u00022\b\u0010U\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\bV\u0010WJ\u0019\u0010X\u001a\u00020\u00042\b\u0010:\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\bX\u0010\u0006J\u001f\u0010Y\u001a\u00020\u00042\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u000100H&¢\u0006\u0004\bY\u00103J\u0017\u0010[\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\bH&¢\u0006\u0004\b[\u0010$J\u0019\u0010]\u001a\u00020\u00042\b\u0010\\\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b]\u0010\u0006J\u0019\u0010^\u001a\u00020\u00042\b\u0010\\\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b^\u0010\u0006¨\u0006_"}, d2 = {"Lru/avito/component/serp/SerpAdvertTileCard;", "", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "price", "", "isHighlighted", "setPrice", "(Ljava/lang/String;Z)V", "priceWithoutDiscount", "setPriceWithoutDiscount", "location", "setLocation", "Lcom/avito/android/remote/model/RadiusInfo;", "radiusInfo", "setRadiusLocation", "(Ljava/lang/String;Lcom/avito/android/remote/model/RadiusInfo;)V", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "setRadiusAddress", "", "time", "setDate", "(J)V", "setAddress", "Lcom/avito/android/image_loader/Picture;", "picture", BookingInfoActivity.EXTRA_ITEM_ID, "setPicture", "(Lcom/avito/android/image_loader/Picture;Ljava/lang/String;)V", "shopName", "setShopName", "active", "setActive", "(Z)V", "viewed", "setViewed", "visible", "setFavoriteVisible", "favorite", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "setFavorite", "(ZLcom/avito/android/remote/model/SerpDisplayType;)V", "isShowDelivery", "setDeliveryVisible", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnFavoriteButtonClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setClickListener", "Landroid/net/Uri;", "getPictureUri", "(Lcom/avito/android/image_loader/Picture;)Landroid/net/Uri;", "isDoubleItem", "setIsDoubleItem", "text", "setAdditionalName", "Lcom/avito/android/remote/model/badge/Badge;", "badge", "setBadge", "(Lcom/avito/android/remote/model/badge/Badge;)V", "hideBadge", "()V", "", "Lcom/avito/android/remote/model/badge_bar/SerpBadge;", "badges", "Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;", "badgeListener", "bindBadges", "(Ljava/util/List;Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;)V", "enlarged", "setVideoIconEnlarged", "callback", "setMoreActions", "(ZLkotlin/jvm/functions/Function0;)V", PanelStateKt.PANEL_HIDDEN, "animated", "showHiddenStub", "(ZZ)V", "newPrice", "setClassifiedDiscount", "oldPrice", "discountPercentage", "setMarketplaceDiscount", "(Ljava/lang/String;Ljava/lang/String;)V", "setAdditionalActionText", "setOnAdditionalActionClickListener", "hasVideo", "setHasVideo", "value", "setInStock", "setTrustFactor", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface SerpAdvertTileCard {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {

        public static final class a extends Lambda implements Function0<Unit> {
            public static final a a = new a();

            public a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                return Unit.INSTANCE;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.avito.component.serp.SerpAdvertTileCard */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void setMoreActions$default(SerpAdvertTileCard serpAdvertTileCard, boolean z, Function0 function0, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    function0 = a.a;
                }
                serpAdvertTileCard.setMoreActions(z, function0);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMoreActions");
        }

        public static /* synthetic */ void setPicture$default(SerpAdvertTileCard serpAdvertTileCard, Picture picture, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = null;
                }
                serpAdvertTileCard.setPicture(picture, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setPicture");
        }
    }

    void bindBadges(@Nullable List<SerpBadge> list, @Nullable BadgeViewListener badgeViewListener);

    @NotNull
    Uri getPictureUri(@NotNull Picture picture);

    void hideBadge();

    void setActive(boolean z);

    void setAdditionalActionText(@Nullable String str);

    void setAdditionalName(@Nullable String str);

    void setAddress(@Nullable String str);

    void setBadge(@NotNull Badge badge);

    void setClassifiedDiscount(@Nullable String str);

    void setClickListener(@NotNull Function0<Unit> function0);

    void setDate(long j);

    void setDeliveryVisible(boolean z);

    void setFavorite(boolean z, @NotNull SerpDisplayType serpDisplayType);

    void setFavoriteVisible(boolean z);

    void setHasVideo(boolean z);

    void setInStock(@Nullable String str);

    void setIsDoubleItem(boolean z);

    void setLocation(@Nullable String str);

    void setMarketplaceDiscount(@Nullable String str, @Nullable String str2);

    void setMoreActions(boolean z, @NotNull Function0<Unit> function0);

    void setOnAdditionalActionClickListener(@Nullable Function0<Unit> function0);

    void setOnFavoriteButtonClickListener(@NotNull Function0<Unit> function0);

    void setPicture(@NotNull Picture picture, @Nullable String str);

    void setPrice(@Nullable String str, boolean z);

    void setPriceWithoutDiscount(@Nullable String str);

    void setRadiusAddress(@Nullable String str, @NotNull RadiusInfo radiusInfo);

    void setRadiusLocation(@Nullable String str, @NotNull RadiusInfo radiusInfo);

    void setShopName(@Nullable String str);

    void setTitle(@NotNull String str);

    void setTrustFactor(@Nullable String str);

    void setVideoIconEnlarged(boolean z);

    void setViewed(boolean z);

    void showHiddenStub(boolean z, boolean z2);
}
