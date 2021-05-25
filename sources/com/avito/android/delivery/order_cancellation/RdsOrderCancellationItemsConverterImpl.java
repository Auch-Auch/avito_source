package com.avito.android.delivery.order_cancellation;

import com.avito.android.delivery.order_cancellation.konveyor.ReasonItem;
import com.avito.android.remote.model.ReasonRds;
import com.avito.conveyor_item.Item;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationItemsConverterImpl;", "Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationItemsConverter;", "", "Lcom/avito/android/remote/model/ReasonRds;", "reasons", "Lcom/avito/conveyor_item/Item;", "convert", "(Ljava/util/List;)Ljava/util/List;", "<init>", "()V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class RdsOrderCancellationItemsConverterImpl implements RdsOrderCancellationItemsConverter {
    @Override // com.avito.android.delivery.order_cancellation.RdsOrderCancellationItemsConverter
    @NotNull
    public List<Item> convert(@NotNull List<ReasonRds> list) {
        Intrinsics.checkNotNullParameter(list, "reasons");
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            arrayList.add(new ReasonItem(t.getId(), t.getTitle()));
        }
        return arrayList;
    }
}
