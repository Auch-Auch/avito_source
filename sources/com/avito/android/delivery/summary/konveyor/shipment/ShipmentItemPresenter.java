package com.avito.android.delivery.summary.konveyor.shipment;

import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/delivery/summary/konveyor/shipment/ShipmentItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/delivery/summary/konveyor/shipment/ShipmentItemView;", "Lcom/avito/android/delivery/summary/konveyor/shipment/ShipmentItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/delivery/summary/konveyor/shipment/ShipmentItemView;Lcom/avito/android/delivery/summary/konveyor/shipment/ShipmentItem;I)V", "<init>", "()V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class ShipmentItemPresenter implements ItemPresenter<ShipmentItemView, ShipmentItem> {
    public void bindView(@NotNull ShipmentItemView shipmentItemView, @NotNull ShipmentItem shipmentItem, int i) {
        Intrinsics.checkNotNullParameter(shipmentItemView, "view");
        Intrinsics.checkNotNullParameter(shipmentItem, "item");
        shipmentItemView.setTitle(shipmentItem.getTitle());
        shipmentItemView.setSubtitle(shipmentItem.getSubtitle());
        shipmentItemView.setItems(shipmentItem.getItems());
    }
}
