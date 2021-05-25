package com.avito.android.advert.item.delivery;

import androidx.lifecycle.LifecycleOwner;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlockView;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlockViewModel;
import com.avito.android.remote.model.AdvertDeliveryC2C;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxrelay3.PublishRelay;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J?\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryInfoView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/remote/model/AdvertDeliveryC2C;", "deliveryData", "Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockViewModel;", "viewModel", "Lcom/jakewharton/rxrelay3/PublishRelay;", "advertDeliveryBlockDataObservable", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "showDeliveryBlock", "(Lcom/avito/android/remote/model/AdvertDeliveryC2C;Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockViewModel;Lcom/jakewharton/rxrelay3/PublishRelay;Landroidx/lifecycle/LifecycleOwner;Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockView$Listener;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsDeliveryInfoView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull AdvertDetailsDeliveryInfoView advertDetailsDeliveryInfoView) {
            ItemView.DefaultImpls.onUnbind(advertDetailsDeliveryInfoView);
        }
    }

    void showDeliveryBlock(@Nullable AdvertDeliveryC2C advertDeliveryC2C, @NotNull AdvertDeliveryBlockViewModel advertDeliveryBlockViewModel, @NotNull PublishRelay<AdvertDeliveryC2C> publishRelay, @NotNull LifecycleOwner lifecycleOwner, @NotNull AdvertDeliveryBlockView.Listener listener);
}
