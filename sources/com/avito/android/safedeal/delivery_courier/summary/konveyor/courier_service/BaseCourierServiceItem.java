package com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service;

import com.avito.android.remote.model.delivery_courier.DeliveryCourierSummary;
import com.avito.conveyor_item.Item;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/BaseCourierServiceItem;", "Lcom/avito/conveyor_item/Item;", "", "getTitle", "()Ljava/lang/String;", "title", "getSubtitle", MessengerShareContentUtility.SUBTITLE, "", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$Cost;", "getCost", "()Ljava/util/List;", "cost", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public interface BaseCourierServiceItem extends Item {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static long getId(@NotNull BaseCourierServiceItem baseCourierServiceItem) {
            return Item.DefaultImpls.getId(baseCourierServiceItem);
        }
    }

    @NotNull
    List<DeliveryCourierSummary.Cost> getCost();

    @Nullable
    String getSubtitle();

    @NotNull
    String getTitle();
}
