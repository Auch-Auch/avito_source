package com.avito.android.cart.summary.konveyor;

import com.avito.android.cart.summary.konveyor.price.PriceItem;
import com.avito.android.remote.cart.model.CartSummary;
import com.avito.android.remote.cart.model.Price;
import com.avito.conveyor_item.Item;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.spongycastle.i18n.ErrorBundle;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H&¢\u0006\u0004\b\u0006\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/cart/summary/konveyor/CartSummaryItemsConverter;", "", "Lcom/avito/android/remote/cart/model/CartSummary;", ErrorBundle.SUMMARY_ENTRY, "", "Lcom/avito/conveyor_item/Item;", "convert", "(Lcom/avito/android/remote/cart/model/CartSummary;)Ljava/util/List;", "Lcom/avito/android/remote/cart/model/Price;", "prices", "Lcom/avito/android/cart/summary/konveyor/price/PriceItem;", "(Ljava/util/List;)Ljava/util/List;", "cart_release"}, k = 1, mv = {1, 4, 2})
public interface CartSummaryItemsConverter {
    @NotNull
    List<Item> convert(@NotNull CartSummary cartSummary);

    @NotNull
    List<PriceItem> convert(@NotNull List<Price> list);
}
