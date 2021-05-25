package com.avito.android.basket_legacy.utils;

import a2.b.a.a.a;
import com.avito.android.basket_legacy.item.BasketItem;
import com.avito.android.basket_legacy.item.total.TotalItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0005\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/basket_legacy/utils/PriceCalculatorImpl;", "Lcom/avito/android/basket_legacy/utils/PriceCalculator;", "", "Lcom/avito/conveyor_item/Item;", "items", "getPriceItem", "(Ljava/util/List;)Lcom/avito/conveyor_item/Item;", "Lcom/avito/android/basket_legacy/utils/PriceFormatter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/basket_legacy/utils/PriceFormatter;", "formatter", "Lcom/avito/android/basket_legacy/utils/StringProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/basket_legacy/utils/StringProvider;", "stringProvider", "<init>", "(Lcom/avito/android/basket_legacy/utils/StringProvider;Lcom/avito/android/basket_legacy/utils/PriceFormatter;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class PriceCalculatorImpl implements PriceCalculator {
    public final StringProvider a;
    public final PriceFormatter b;

    @Inject
    public PriceCalculatorImpl(@NotNull StringProvider stringProvider, @NotNull PriceFormatter priceFormatter) {
        Intrinsics.checkNotNullParameter(stringProvider, "stringProvider");
        Intrinsics.checkNotNullParameter(priceFormatter, "formatter");
        this.a = stringProvider;
        this.b = priceFormatter;
    }

    @Override // com.avito.android.basket_legacy.utils.PriceCalculator
    @Nullable
    public Item getPriceItem(@NotNull List<? extends Item> list) {
        ArrayList<Item> i0 = a.i0(list, "items");
        for (T t : list) {
            if (t instanceof BasketItem) {
                i0.add(t);
            }
        }
        ArrayList<BasketItem> arrayList = new ArrayList(e.collectionSizeOrDefault(i0, 10));
        for (Item item : i0) {
            Objects.requireNonNull(item, "null cannot be cast to non-null type com.avito.android.basket_legacy.item.BasketItem");
            arrayList.add((BasketItem) item);
        }
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
        for (BasketItem basketItem : arrayList) {
            arrayList2.add(Long.valueOf(basketItem.getPriceValue()));
        }
        long sumOfLong = CollectionsKt___CollectionsKt.sumOfLong(arrayList2);
        if (sumOfLong <= 0) {
            return null;
        }
        return new TotalItem("totalId", a.H(new Object[]{this.b.format(sumOfLong)}, 1, this.a.getTotalTemplate(), "java.lang.String.format(this, *args)"));
    }
}
