package com.avito.android.advert.item.sellersubscription;

import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u000eJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/avito/android/advert/item/sellersubscription/AdvertDetailsSellerSubscriptionView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/advert/item/sellersubscription/AdvertDetailsSellerSubscriptionView$UnbindListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setUnbindListener", "(Lcom/avito/android/advert/item/sellersubscription/AdvertDetailsSellerSubscriptionView$UnbindListener;)V", "Lio/reactivex/rxjava3/core/Observable;", "subscribeClicks", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionState;", "state", "setSubscribeState", "(Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionState;)V", "UnbindListener", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsSellerSubscriptionView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull AdvertDetailsSellerSubscriptionView advertDetailsSellerSubscriptionView) {
            ItemView.DefaultImpls.onUnbind(advertDetailsSellerSubscriptionView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/advert/item/sellersubscription/AdvertDetailsSellerSubscriptionView$UnbindListener;", "", "", "onUnbind", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public interface UnbindListener {
        void onUnbind();
    }

    void setSubscribeState(@NotNull SellerSubscriptionState sellerSubscriptionState);

    void setUnbindListener(@Nullable UnbindListener unbindListener);

    @NotNull
    Observable<Unit> subscribeClicks();
}
