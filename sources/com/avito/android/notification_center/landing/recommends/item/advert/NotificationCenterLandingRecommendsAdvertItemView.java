package com.avito.android.notification_center.landing.recommends.item.advert;

import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Sort;
import com.avito.konveyor.blueprint.ItemView;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u000e\u0010\nJ\u0019\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u0010\u0010\nJ\u0019\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u0012\u0010\nJ\u0019\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u0014\u0010\nJ\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0015H&¢\u0006\u0004\b\u001a\u0010\u0018J\u001f\u0010\u001d\u001a\u00020\u00042\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001bH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001f\u001a\u00020\u00042\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001bH&¢\u0006\u0004\b\u001f\u0010\u001eJ\u001f\u0010 \u001a\u00020\u00042\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001bH&¢\u0006\u0004\b \u0010\u001e¨\u0006!"}, d2 = {"Lcom/avito/android/notification_center/landing/recommends/item/advert/NotificationCenterLandingRecommendsAdvertItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/remote/model/Image;", "image", "", "setAdvertImage", "(Lcom/avito/android/remote/model/Image;)V", "", "title", "setAdvertTitle", "(Ljava/lang/String;)V", "price", "setAdvertPrice", "priceWithoutDiscount", "setAdvertPriceWithoutDiscount", "location", "setAdvertLocation", Sort.DISTANCE, "setAdvertDistance", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "setAdvertAddress", "", "isFavorite", "setAdvertIsFavorite", "(Z)V", "isViewed", "setAdvertIsViewed", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setAdvertClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setAdvertFavoriteClickListener", "setAdvertUnbindListener", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public interface NotificationCenterLandingRecommendsAdvertItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull NotificationCenterLandingRecommendsAdvertItemView notificationCenterLandingRecommendsAdvertItemView) {
            ItemView.DefaultImpls.onUnbind(notificationCenterLandingRecommendsAdvertItemView);
        }
    }

    void setAdvertAddress(@Nullable String str);

    void setAdvertClickListener(@Nullable Function0<Unit> function0);

    void setAdvertDistance(@Nullable String str);

    void setAdvertFavoriteClickListener(@Nullable Function0<Unit> function0);

    void setAdvertImage(@NotNull Image image);

    void setAdvertIsFavorite(boolean z);

    void setAdvertIsViewed(boolean z);

    void setAdvertLocation(@Nullable String str);

    void setAdvertPrice(@NotNull String str);

    void setAdvertPriceWithoutDiscount(@Nullable String str);

    void setAdvertTitle(@NotNull String str);

    void setAdvertUnbindListener(@Nullable Function0<Unit> function0);
}
