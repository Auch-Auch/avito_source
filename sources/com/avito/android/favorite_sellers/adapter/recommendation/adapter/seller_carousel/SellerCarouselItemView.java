package com.avito.android.favorite_sellers.adapter.recommendation.adapter.seller_carousel;

import com.avito.android.image_loader.Picture;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H&¢\u0006\u0004\b\n\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H&¢\u0006\u0004\b\u000b\u0010\tJ\u0019\u0010\u000e\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0004\b\u0016\u0010\u0014J\u001d\u0010\u001a\u001a\u00020\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0003H&¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0003H&¢\u0006\u0004\b\"\u0010!¨\u0006#"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/recommendation/adapter/seller_carousel/SellerCarouselItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "Lio/reactivex/rxjava3/core/Observable;", "clicks", "()Lio/reactivex/rxjava3/core/Observable;", "subscribeClicks", "settingsClicks", "Lcom/avito/android/image_loader/Picture;", "avatar", "setUserAvatar", "(Lcom/avito/android/image_loader/Picture;)V", "setShopAvatar", "", "name", "setName", "(Ljava/lang/CharSequence;)V", "description", "setDescription", "", "Lcom/avito/android/favorite_sellers/adapter/recommendation/adapter/seller_carousel/AdvertWithOverlay;", "adverts", "setAdverts", "(Ljava/util/List;)V", "", "loading", "setSubscriptionButtonLoading", "(Z)V", "showSubscribeButton", "()V", "showSettingsButton", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
public interface SellerCarouselItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull SellerCarouselItemView sellerCarouselItemView) {
            ItemView.DefaultImpls.onUnbind(sellerCarouselItemView);
        }
    }

    @NotNull
    Observable<Unit> clicks();

    void setAdverts(@NotNull List<AdvertWithOverlay> list);

    void setDescription(@Nullable CharSequence charSequence);

    void setName(@NotNull CharSequence charSequence);

    void setShopAvatar(@Nullable Picture picture);

    void setSubscriptionButtonLoading(boolean z);

    void setUnbindListener(@Nullable Function0<Unit> function0);

    void setUserAvatar(@Nullable Picture picture);

    @NotNull
    Observable<Unit> settingsClicks();

    void showSettingsButton();

    void showSubscribeButton();

    @NotNull
    Observable<Unit> subscribeClicks();
}
