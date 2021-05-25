package com.avito.android.orders.feature.list.model;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\bR\u001b\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/avito/android/orders/feature/list/model/OrdersPagination;", "", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/conveyor_item/Item;", "component2", "()Ljava/util/List;", "nextPage", "orderItems", "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/orders/feature/list/model/OrdersPagination;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getOrderItems", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getNextPage", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "orders_release"}, k = 1, mv = {1, 4, 2})
public final class OrdersPagination {
    @Nullable
    public final String a;
    @NotNull
    public final List<Item> b;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.conveyor_item.Item> */
    /* JADX WARN: Multi-variable type inference failed */
    public OrdersPagination(@Nullable String str, @NotNull List<? extends Item> list) {
        Intrinsics.checkNotNullParameter(list, "orderItems");
        this.a = str;
        this.b = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.orders.feature.list.model.OrdersPagination */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OrdersPagination copy$default(OrdersPagination ordersPagination, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ordersPagination.a;
        }
        if ((i & 2) != 0) {
            list = ordersPagination.b;
        }
        return ordersPagination.copy(str, list);
    }

    @Nullable
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final List<Item> component2() {
        return this.b;
    }

    @NotNull
    public final OrdersPagination copy(@Nullable String str, @NotNull List<? extends Item> list) {
        Intrinsics.checkNotNullParameter(list, "orderItems");
        return new OrdersPagination(str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrdersPagination)) {
            return false;
        }
        OrdersPagination ordersPagination = (OrdersPagination) obj;
        return Intrinsics.areEqual(this.a, ordersPagination.a) && Intrinsics.areEqual(this.b, ordersPagination.b);
    }

    @Nullable
    public final String getNextPage() {
        return this.a;
    }

    @NotNull
    public final List<Item> getOrderItems() {
        return this.b;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<Item> list = this.b;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OrdersPagination(nextPage=");
        L.append(this.a);
        L.append(", orderItems=");
        return a.w(L, this.b, ")");
    }
}
