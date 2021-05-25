package com.avito.android.delivery.order_cancellation.details;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.conveyor_shared_item.bottom_sheet.title.TitleItem;
import com.avito.android.items.SelectableItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Option;
import com.avito.android.remote.model.ReasonRds;
import com.avito.conveyor_item.Item;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR(\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsItemsConverterImpl;", "Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsItemsConverter;", "Lcom/avito/android/remote/model/ReasonRds;", "reasonDetails", "", "convert", "(Lcom/avito/android/remote/model/ReasonRds;)V", "Lcom/jakewharton/rxrelay2/Relay;", "", "Lcom/avito/conveyor_item/Item;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/Relay;", "itemsRelay", "Lio/reactivex/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/Observable;", "getItemsObservable", "()Lio/reactivex/Observable;", "itemsObservable", "<init>", "()V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class ReasonDetailsItemsConverterImpl implements ReasonDetailsItemsConverter {
    public final Relay<List<Item>> a;
    @NotNull
    public final Observable<List<Item>> b;

    @Inject
    public ReasonDetailsItemsConverterImpl() {
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.a = create;
        this.b = create;
    }

    @Override // com.avito.android.delivery.order_cancellation.details.ReasonDetailsItemsConverter
    public void convert(@NotNull ReasonRds reasonRds) {
        Intrinsics.checkNotNullParameter(reasonRds, "reasonDetails");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TitleItem(String.valueOf(arrayList.size()), reasonRds.getTitle()));
        List<Option> options = reasonRds.getOptions();
        if (options != null) {
            ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(options, 10));
            for (T t : options) {
                arrayList2.add(new SelectableItem(t.getId(), t.getTitle(), false, null, 8, null));
            }
            arrayList.add(new ParameterElement.Select.Flat(String.valueOf(arrayList.size()), "", null, null, null, arrayList2, ParameterElement.DisplayType.RadioGroup.INSTANCE, null, null, false, false, false, null, null, false, false, 63388, null));
        }
        arrayList.add(new ParameterElement.Input(String.valueOf(arrayList.size()), "", null, null, null, 1, 3, null, null, null, null, null, null, reasonRds.getPlaceholder(), null, null, null, false, null, 515996, null));
        this.a.accept(arrayList);
    }

    @Override // com.avito.android.delivery.order_cancellation.details.ReasonDetailsItemsConverter
    @NotNull
    public Observable<List<Item>> getItemsObservable() {
        return this.b;
    }
}
