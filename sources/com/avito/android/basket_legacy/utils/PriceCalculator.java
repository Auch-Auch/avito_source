package com.avito.android.basket_legacy.utils;

import com.avito.conveyor_item.Item;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/basket_legacy/utils/PriceCalculator;", "", "", "Lcom/avito/conveyor_item/Item;", "items", "getPriceItem", "(Ljava/util/List;)Lcom/avito/conveyor_item/Item;", "basket_release"}, k = 1, mv = {1, 4, 2})
public interface PriceCalculator {
    @Nullable
    Item getPriceItem(@NotNull List<? extends Item> list);
}
