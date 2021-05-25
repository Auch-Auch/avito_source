package com.avito.android.delivery.order_cancellation.details;

import com.avito.android.remote.model.ReasonRds;
import com.avito.conveyor_item.Item;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsItemsConverter;", "", "Lcom/avito/android/remote/model/ReasonRds;", "reasonDetails", "", "convert", "(Lcom/avito/android/remote/model/ReasonRds;)V", "Lio/reactivex/Observable;", "", "Lcom/avito/conveyor_item/Item;", "getItemsObservable", "()Lio/reactivex/Observable;", "itemsObservable", "delivery_release"}, k = 1, mv = {1, 4, 2})
public interface ReasonDetailsItemsConverter {
    void convert(@NotNull ReasonRds reasonRds);

    @NotNull
    Observable<List<Item>> getItemsObservable();
}
