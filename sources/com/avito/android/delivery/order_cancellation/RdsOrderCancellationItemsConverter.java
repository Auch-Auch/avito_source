package com.avito.android.delivery.order_cancellation;

import com.avito.android.remote.model.ReasonRds;
import com.avito.conveyor_item.Item;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationItemsConverter;", "", "", "Lcom/avito/android/remote/model/ReasonRds;", "reasons", "Lcom/avito/conveyor_item/Item;", "convert", "(Ljava/util/List;)Ljava/util/List;", "delivery_release"}, k = 1, mv = {1, 4, 2})
public interface RdsOrderCancellationItemsConverter {
    @NotNull
    List<Item> convert(@NotNull List<ReasonRds> list);
}
