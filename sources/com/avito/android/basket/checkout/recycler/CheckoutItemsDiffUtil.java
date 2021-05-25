package com.avito.android.basket.checkout.recycler;

import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.basket.checkout.item.checkout.CheckoutItem;
import com.avito.android.basket.checkout.item.price.PriceItem;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.Item;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0007R\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/basket/checkout/recycler/CheckoutItemsDiffUtil;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "", "oldItemPosition", "newItemPosition", "", "areItemsTheSame", "(II)Z", "getOldListSize", "()I", "getNewListSize", "areContentsTheSame", "", "Lcom/avito/konveyor/blueprint/Item;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "newList", AuthSource.SEND_ABUSE, "oldList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class CheckoutItemsDiffUtil extends DiffUtil.Callback {
    public final List<Item> a;
    public final List<Item> b;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.konveyor.blueprint.Item> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.konveyor.blueprint.Item> */
    /* JADX WARN: Multi-variable type inference failed */
    public CheckoutItemsDiffUtil(@NotNull List<? extends Item> list, @NotNull List<? extends Item> list2) {
        Intrinsics.checkNotNullParameter(list, "oldList");
        Intrinsics.checkNotNullParameter(list2, "newList");
        this.a = list;
        this.b = list2;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areContentsTheSame(int i, int i2) {
        Item item = this.a.get(i);
        Item item2 = this.b.get(i2);
        if ((item instanceof PaidServiceHeaderItem) && (item2 instanceof PaidServiceHeaderItem)) {
            return Intrinsics.areEqual(((PaidServiceHeaderItem) item).getTitle(), ((PaidServiceHeaderItem) item2).getTitle());
        }
        if ((item instanceof CheckoutItem) && (item2 instanceof CheckoutItem)) {
            CheckoutItem checkoutItem = (CheckoutItem) item;
            CheckoutItem checkoutItem2 = (CheckoutItem) item2;
            if (!Intrinsics.areEqual(checkoutItem.getTitle(), checkoutItem2.getTitle()) || checkoutItem.isActive() != checkoutItem2.isActive()) {
                return false;
            }
            return true;
        } else if (!(item instanceof PriceItem) || !(item2 instanceof PriceItem)) {
            return false;
        } else {
            return Intrinsics.areEqual(((PriceItem) item).getTotal(), ((PriceItem) item2).getTotal());
        }
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areItemsTheSame(int i, int i2) {
        return this.a.get(i).getId() == this.b.get(i2).getId();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getNewListSize() {
        return this.b.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getOldListSize() {
        return this.a.size();
    }
}
