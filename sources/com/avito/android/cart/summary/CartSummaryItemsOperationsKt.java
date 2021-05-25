package com.avito.android.cart.summary;

import androidx.collection.SimpleArrayMap;
import com.avito.android.cart.summary.konveyor.header.store.StoreHeaderItem;
import com.avito.android.cart.summary.konveyor.price.PriceItem;
import com.avito.android.cart.summary.konveyor.product.ProductItem;
import com.avito.android.remote.cart.model.CheckQuantityResponse;
import com.avito.android.remote.cart.model.DeleteItemResponse;
import com.avito.android.remote.cart.model.Store;
import com.avito.conveyor_item.Item;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.h;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000*\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a-\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000*\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0000H\u0000¢\u0006\u0004\b\b\u0010\u0005\u001a/\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000*\b\u0012\u0004\u0012\u00020\u00010\u00002\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\n\u0010\u0005¨\u0006\u000b"}, d2 = {"", "Lcom/avito/conveyor_item/Item;", "Lcom/avito/android/cart/summary/konveyor/price/PriceItem;", "totals", "replaceTotals", "(Ljava/util/List;Ljava/util/List;)Ljava/util/List;", "Lcom/avito/android/remote/cart/model/CheckQuantityResponse$Store;", "stores", "updateStores", "Lcom/avito/android/remote/cart/model/DeleteItemResponse$Store;", "updateStoresAfterDeletion", "cart_release"}, k = 2, mv = {1, 4, 2})
public final class CartSummaryItemsOperationsKt {
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.List<? extends com.avito.conveyor_item.Item> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final List<Item> replaceTotals(@NotNull List<? extends Item> list, @NotNull List<PriceItem> list2) {
        int i;
        Intrinsics.checkNotNullParameter(list, "$this$replaceTotals");
        Intrinsics.checkNotNullParameter(list2, "totals");
        Iterator it = list.iterator();
        int i2 = 0;
        while (true) {
            i = -1;
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (((Item) it.next()) instanceof PriceItem) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 == -1) {
            return list;
        }
        ListIterator listIterator = list.listIterator(list.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                if (((Item) listIterator.previous()) instanceof PriceItem) {
                    i = listIterator.nextIndex();
                    break;
                }
            } else {
                break;
            }
        }
        return CollectionsKt___CollectionsKt.plus((Collection) CollectionsKt___CollectionsKt.plus((Collection) list.subList(0, i2), (Iterable) list2), (Iterable) list.subList(i + 1, list.size()));
    }

    @NotNull
    public static final List<Item> updateStores(@NotNull List<? extends Item> list, @NotNull List<CheckQuantityResponse.Store> list2) {
        Intrinsics.checkNotNullParameter(list, "$this$updateStores");
        Intrinsics.checkNotNullParameter(list2, "stores");
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap(list2.size());
        for (CheckQuantityResponse.Store store : list2) {
            simpleArrayMap.put(store.getId(), store);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            List<CheckQuantityResponse.Store.Item> items = it.next().getItems();
            if (items == null) {
                items = CollectionsKt__CollectionsKt.emptyList();
            }
            h.addAll(arrayList, items);
        }
        SimpleArrayMap simpleArrayMap2 = new SimpleArrayMap(arrayList.size());
        for (Object obj : arrayList) {
            simpleArrayMap2.put(((CheckQuantityResponse.Store.Item) obj).getId(), obj);
        }
        ArrayList arrayList2 = new ArrayList(list.size());
        for (Item item : list) {
            if (item instanceof StoreHeaderItem) {
                CheckQuantityResponse.Store store2 = (CheckQuantityResponse.Store) simpleArrayMap.get(item.getStringId());
                if (store2 != null) {
                    Intrinsics.checkNotNullExpressionValue(store2, "storesMap[item.stringId] ?: continue");
                    item = StoreHeaderItem.copy$default((StoreHeaderItem) item, null, null, store2.getErrorMessage(), 3, null);
                }
            } else if (item instanceof ProductItem) {
                CheckQuantityResponse.Store.Item item2 = (CheckQuantityResponse.Store.Item) simpleArrayMap2.get(item.getStringId());
                if (item2 != null) {
                    ProductItem productItem = (ProductItem) item;
                    item = ProductItem.copy$default(productItem, null, null, null, item2.getPrice(), item2.getItemsLeft(), Store.Item.Stepper.copy$default(productItem.getStepper(), item2.getAvailableQuantity(), 0, 2, null), null, 71, null);
                    if (item != null) {
                    }
                }
            }
            arrayList2.add(item);
        }
        return arrayList2;
    }

    @NotNull
    public static final List<Item> updateStoresAfterDeletion(@NotNull List<? extends Item> list, @Nullable List<DeleteItemResponse.Store> list2) {
        Intrinsics.checkNotNullParameter(list, "$this$updateStoresAfterDeletion");
        if (list2 == null) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap(list2.size());
        for (DeleteItemResponse.Store store : list2) {
            simpleArrayMap.put(store.getId(), store);
        }
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (Item item : list) {
            if (item instanceof StoreHeaderItem) {
                DeleteItemResponse.Store store2 = (DeleteItemResponse.Store) simpleArrayMap.get(item.getStringId());
                boolean z2 = store2 == null;
                if (store2 != null) {
                    item = StoreHeaderItem.copy$default((StoreHeaderItem) item, null, null, store2.getErrorMessage(), 3, null);
                    z = z2;
                } else {
                    z = z2;
                }
            } else if ((item instanceof ProductItem) && z) {
            }
            arrayList.add(item);
        }
        return arrayList;
    }
}
