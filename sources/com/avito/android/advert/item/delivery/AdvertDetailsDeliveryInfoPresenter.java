package com.avito.android.advert.item.delivery;

import androidx.lifecycle.LifecycleOwner;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlockView;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryInfoPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryInfoView;", "Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryInfoItem;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "", "setFragmentDelegate", "(Landroidx/lifecycle/LifecycleOwner;)V", "Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setDeliveryBlockListener", "(Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockView$Listener;)V", "detachListener", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsDeliveryInfoPresenter extends ItemPresenter<AdvertDetailsDeliveryInfoView, AdvertDetailsDeliveryInfoItem> {
    void detachListener();

    void setDeliveryBlockListener(@NotNull AdvertDeliveryBlockView.Listener listener);

    void setFragmentDelegate(@NotNull LifecycleOwner lifecycleOwner);
}
