package com.avito.android.cart.summary.konveyor;

import a2.b.a.a.a;
import com.avito.android.cart.summary.konveyor.divider.DividerItem;
import com.avito.android.cart.summary.konveyor.header.HeaderItem;
import com.avito.android.cart.summary.konveyor.header.store.StoreHeaderItem;
import com.avito.android.cart.summary.konveyor.price.PriceItem;
import com.avito.android.cart.summary.konveyor.product.ProductItem;
import com.avito.android.cart.summary.konveyor.text.TextItem;
import com.avito.android.remote.cart.model.CartSummary;
import com.avito.android.remote.cart.model.Price;
import com.avito.android.remote.cart.model.Store;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.conveyor_item.Item;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.spongycastle.i18n.ErrorBundle;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/cart/summary/konveyor/CartSummaryItemsConverterImpl;", "Lcom/avito/android/cart/summary/konveyor/CartSummaryItemsConverter;", "Lcom/avito/android/remote/cart/model/CartSummary;", ErrorBundle.SUMMARY_ENTRY, "", "Lcom/avito/conveyor_item/Item;", "convert", "(Lcom/avito/android/remote/cart/model/CartSummary;)Ljava/util/List;", "Lcom/avito/android/remote/cart/model/Price;", "prices", "Lcom/avito/android/cart/summary/konveyor/price/PriceItem;", "(Ljava/util/List;)Ljava/util/List;", "<init>", "()V", "cart_release"}, k = 1, mv = {1, 4, 2})
public final class CartSummaryItemsConverterImpl implements CartSummaryItemsConverter {
    @Override // com.avito.android.cart.summary.konveyor.CartSummaryItemsConverter
    @NotNull
    public List<Item> convert(@NotNull CartSummary cartSummary) {
        Intrinsics.checkNotNullParameter(cartSummary, ErrorBundle.SUMMARY_ENTRY);
        ArrayList arrayList = new ArrayList();
        CartSummary.FullCart fullCart = cartSummary.getFullCart();
        if (fullCart != null) {
            List<Store> stores = fullCart.getStores();
            if (stores != null) {
                for (T t : stores) {
                    arrayList.add(new StoreHeaderItem(t.getId(), t.getName(), t.getErrorMessage()));
                    List<Store.Item> items = t.getItems();
                    if (items != null) {
                        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(items, 10));
                        for (T t2 : items) {
                            arrayList2.add(new ProductItem(t2.getId(), t2.getImage(), t2.getTitle(), t2.getPrice(), t2.getItemsLeft(), t2.getStepper(), t2.getPricePerPiece()));
                        }
                        arrayList.addAll(arrayList2);
                    }
                }
            }
            CartSummary.FullCart.Totals totals = fullCart.getTotals();
            if (totals != null) {
                String title = totals.getTitle();
                if (title != null) {
                    arrayList.add(new HeaderItem(String.valueOf(arrayList.size()), title));
                }
                List<Price> prices = totals.getPrices();
                if (prices != null) {
                    arrayList.addAll(convert(prices));
                }
            }
            arrayList.add(new DividerItem(String.valueOf(arrayList.size())));
            AttributedText disclaimer = fullCart.getDisclaimer();
            if (disclaimer != null) {
                arrayList.add(new TextItem(String.valueOf(arrayList.size()), disclaimer));
            }
        }
        return arrayList;
    }

    @Override // com.avito.android.cart.summary.konveyor.CartSummaryItemsConverter
    @NotNull
    public List<PriceItem> convert(@NotNull List<Price> list) {
        Intrinsics.checkNotNullParameter(list, "prices");
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
