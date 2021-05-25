package com.avito.android.delivery.summary.konveyor;

import a2.b.a.a.a;
import com.avito.android.delivery.summary.konveyor.price.PriceItem;
import com.avito.android.remote.model.delivery.DeliverySummaryRds;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a\u001f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\"\u0016\u0010\u0006\u001a\u00020\u00058\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007\"\u0016\u0010\b\u001a\u00020\u00058\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\b\u0010\u0007\"\u0016\u0010\t\u001a\u00020\u00058\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\t\u0010\u0007\"\u0016\u0010\n\u001a\u00020\u00058\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$Calculation;", "Lcom/avito/android/delivery/summary/konveyor/price/PriceItem;", "toPriceItems", "(Ljava/util/List;)Ljava/util/List;", "", "HEADER_USER_INFO_ID", "Ljava/lang/String;", "HEADER_ADDRESS_ID", "LOADING_BUTTON_ID", "SUBMIT_BUTTON_ID", "delivery_release"}, k = 2, mv = {1, 4, 2})
public final class DeliveryRdsSummaryItemsConverterKt {
    @NotNull
    public static final String HEADER_ADDRESS_ID = "addressHeader";
    @NotNull
    public static final String HEADER_USER_INFO_ID = "userInfoHeader";
    @NotNull
    public static final String LOADING_BUTTON_ID = "loadingBtn";
    @NotNull
    public static final String SUBMIT_BUTTON_ID = "submitBtn";

    @NotNull
    public static final List<PriceItem> toPriceItems(@NotNull List<DeliverySummaryRds.Calculation> list) {
        Intrinsics.checkNotNullParameter(list, "$this$toPriceItems");
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(new PriceItem(a.M2("price", i), t));
            i = i2;
        }
        return arrayList;
    }
}
