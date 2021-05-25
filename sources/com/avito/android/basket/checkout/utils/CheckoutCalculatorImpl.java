package com.avito.android.basket.checkout.utils;

import a2.b.a.a.a;
import com.avito.android.basket.checkout.item.checkout.CheckoutItem;
import com.avito.konveyor.blueprint.Item;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/basket/checkout/utils/CheckoutCalculatorImpl;", "Lcom/avito/android/basket/checkout/utils/CheckoutCalculator;", "", "Lcom/avito/konveyor/blueprint/Item;", "items", "", "calculateTotal", "(Ljava/util/List;)I", "<init>", "()V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class CheckoutCalculatorImpl implements CheckoutCalculator {
    @Override // com.avito.android.basket.checkout.utils.CheckoutCalculator
    public int calculateTotal(@NotNull List<? extends Item> list) {
        ArrayList i0 = a.i0(list, "items");
        for (T t : list) {
            if (t instanceof CheckoutItem) {
                i0.add(t);
            }
        }
        ArrayList<CheckoutItem> arrayList = new ArrayList();
        for (Object obj : i0) {
            if (((CheckoutItem) obj).isActive()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
        for (CheckoutItem checkoutItem : arrayList) {
            Integer priceValue = checkoutItem.getPriceValue();
            arrayList2.add(Integer.valueOf(priceValue != null ? priceValue.intValue() : 0));
        }
        return CollectionsKt___CollectionsKt.sumOfInt(arrayList2);
    }
}
