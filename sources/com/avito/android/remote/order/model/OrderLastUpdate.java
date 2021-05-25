package com.avito.android.remote.order.model;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/order/model/OrderLastUpdate;", "", "", "component1", "()I", "component2", "lastUpdate", "pollingIntervalSec", "copy", "(II)Lcom/avito/android/remote/order/model/OrderLastUpdate;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getLastUpdate", "getPollingIntervalSec", "<init>", "(II)V", "order_release"}, k = 1, mv = {1, 4, 2})
public final class OrderLastUpdate {
    @SerializedName("lastUpdate")
    private final int lastUpdate;
    @SerializedName("pollingInterval")
    private final int pollingIntervalSec;

    public OrderLastUpdate(int i, int i2) {
        this.lastUpdate = i;
        this.pollingIntervalSec = i2;
    }

    public static /* synthetic */ OrderLastUpdate copy$default(OrderLastUpdate orderLastUpdate, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = orderLastUpdate.lastUpdate;
        }
        if ((i3 & 2) != 0) {
            i2 = orderLastUpdate.pollingIntervalSec;
        }
        return orderLastUpdate.copy(i, i2);
    }

    public final int component1() {
        return this.lastUpdate;
    }

    public final int component2() {
        return this.pollingIntervalSec;
    }

    @NotNull
    public final OrderLastUpdate copy(int i, int i2) {
        return new OrderLastUpdate(i, i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderLastUpdate)) {
            return false;
        }
        OrderLastUpdate orderLastUpdate = (OrderLastUpdate) obj;
        return this.lastUpdate == orderLastUpdate.lastUpdate && this.pollingIntervalSec == orderLastUpdate.pollingIntervalSec;
    }

    public final int getLastUpdate() {
        return this.lastUpdate;
    }

    public final int getPollingIntervalSec() {
        return this.pollingIntervalSec;
    }

    public int hashCode() {
        return (this.lastUpdate * 31) + this.pollingIntervalSec;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OrderLastUpdate(lastUpdate=");
        L.append(this.lastUpdate);
        L.append(", pollingIntervalSec=");
        return a.j(L, this.pollingIntervalSec, ")");
    }
}
