package com.avito.android.remote.orders.model;

import a2.b.a.a.a;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.model.ParametrizedEvent;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0018\u001a\u00020\u000f¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011Jb\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0018\u001a\u00020\u000fHÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u001c\u0010\u0012\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b$\u0010\u0004R\u001c\u0010\u0013\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b%\u0010\u0004R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b&\u0010\u0004R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010'\u001a\u0004\b(\u0010\u000eR\u001c\u0010\u0018\u001a\u00020\u000f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010)\u001a\u0004\b*\u0010\u0011R\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010+\u001a\u0004\b,\u0010\u000bR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010#\u001a\u0004\b-\u0010\u0004¨\u00060"}, d2 = {"Lcom/avito/android/remote/orders/model/OrdersTab;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "", "Lcom/avito/android/remote/orders/model/OrderData;", "component5", "()Ljava/util/List;", "Lcom/avito/android/remote/orders/model/OrdersPlaceholder;", "component6", "()Lcom/avito/android/remote/orders/model/OrdersPlaceholder;", "Lcom/avito/android/remote/model/ParametrizedEvent;", "component7", "()Lcom/avito/android/remote/model/ParametrizedEvent;", "id", "title", "counter", "nextPage", "orderDataList", InternalConstsKt.PLACEHOLDER, "clickEvent", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/orders/model/OrdersPlaceholder;Lcom/avito/android/remote/model/ParametrizedEvent;)Lcom/avito/android/remote/orders/model/OrdersTab;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "getTitle", "getCounter", "Lcom/avito/android/remote/orders/model/OrdersPlaceholder;", "getPlaceholder", "Lcom/avito/android/remote/model/ParametrizedEvent;", "getClickEvent", "Ljava/util/List;", "getOrderDataList", "getNextPage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/orders/model/OrdersPlaceholder;Lcom/avito/android/remote/model/ParametrizedEvent;)V", "orders_release"}, k = 1, mv = {1, 4, 2})
public final class OrdersTab {
    @SerializedName("onSelectEvent")
    @NotNull
    private final ParametrizedEvent clickEvent;
    @SerializedName("counter")
    @Nullable
    private final String counter;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("nextPageUrl")
    @Nullable
    private final String nextPage;
    @SerializedName("orderDataList")
    @NotNull
    private final List<OrderData> orderDataList;
    @SerializedName(InternalConstsKt.PLACEHOLDER)
    @Nullable
    private final OrdersPlaceholder placeholder;
    @SerializedName("title")
    @NotNull
    private final String title;

    public OrdersTab(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @NotNull List<OrderData> list, @Nullable OrdersPlaceholder ordersPlaceholder, @NotNull ParametrizedEvent parametrizedEvent) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(list, "orderDataList");
        Intrinsics.checkNotNullParameter(parametrizedEvent, "clickEvent");
        this.id = str;
        this.title = str2;
        this.counter = str3;
        this.nextPage = str4;
        this.orderDataList = list;
        this.placeholder = ordersPlaceholder;
        this.clickEvent = parametrizedEvent;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.avito.android.remote.orders.model.OrdersTab */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OrdersTab copy$default(OrdersTab ordersTab, String str, String str2, String str3, String str4, List list, OrdersPlaceholder ordersPlaceholder, ParametrizedEvent parametrizedEvent, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ordersTab.id;
        }
        if ((i & 2) != 0) {
            str2 = ordersTab.title;
        }
        if ((i & 4) != 0) {
            str3 = ordersTab.counter;
        }
        if ((i & 8) != 0) {
            str4 = ordersTab.nextPage;
        }
        if ((i & 16) != 0) {
            list = ordersTab.orderDataList;
        }
        if ((i & 32) != 0) {
            ordersPlaceholder = ordersTab.placeholder;
        }
        if ((i & 64) != 0) {
            parametrizedEvent = ordersTab.clickEvent;
        }
        return ordersTab.copy(str, str2, str3, str4, list, ordersPlaceholder, parametrizedEvent);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final String component3() {
        return this.counter;
    }

    @Nullable
    public final String component4() {
        return this.nextPage;
    }

    @NotNull
    public final List<OrderData> component5() {
        return this.orderDataList;
    }

    @Nullable
    public final OrdersPlaceholder component6() {
        return this.placeholder;
    }

    @NotNull
    public final ParametrizedEvent component7() {
        return this.clickEvent;
    }

    @NotNull
    public final OrdersTab copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @NotNull List<OrderData> list, @Nullable OrdersPlaceholder ordersPlaceholder, @NotNull ParametrizedEvent parametrizedEvent) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(list, "orderDataList");
        Intrinsics.checkNotNullParameter(parametrizedEvent, "clickEvent");
        return new OrdersTab(str, str2, str3, str4, list, ordersPlaceholder, parametrizedEvent);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrdersTab)) {
            return false;
        }
        OrdersTab ordersTab = (OrdersTab) obj;
        return Intrinsics.areEqual(this.id, ordersTab.id) && Intrinsics.areEqual(this.title, ordersTab.title) && Intrinsics.areEqual(this.counter, ordersTab.counter) && Intrinsics.areEqual(this.nextPage, ordersTab.nextPage) && Intrinsics.areEqual(this.orderDataList, ordersTab.orderDataList) && Intrinsics.areEqual(this.placeholder, ordersTab.placeholder) && Intrinsics.areEqual(this.clickEvent, ordersTab.clickEvent);
    }

    @NotNull
    public final ParametrizedEvent getClickEvent() {
        return this.clickEvent;
    }

    @Nullable
    public final String getCounter() {
        return this.counter;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getNextPage() {
        return this.nextPage;
    }

    @NotNull
    public final List<OrderData> getOrderDataList() {
        return this.orderDataList;
    }

    @Nullable
    public final OrdersPlaceholder getPlaceholder() {
        return this.placeholder;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.counter;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.nextPage;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        List<OrderData> list = this.orderDataList;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        OrdersPlaceholder ordersPlaceholder = this.placeholder;
        int hashCode6 = (hashCode5 + (ordersPlaceholder != null ? ordersPlaceholder.hashCode() : 0)) * 31;
        ParametrizedEvent parametrizedEvent = this.clickEvent;
        if (parametrizedEvent != null) {
            i = parametrizedEvent.hashCode();
        }
        return hashCode6 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OrdersTab(id=");
        L.append(this.id);
        L.append(", title=");
        L.append(this.title);
        L.append(", counter=");
        L.append(this.counter);
        L.append(", nextPage=");
        L.append(this.nextPage);
        L.append(", orderDataList=");
        L.append(this.orderDataList);
        L.append(", placeholder=");
        L.append(this.placeholder);
        L.append(", clickEvent=");
        L.append(this.clickEvent);
        L.append(")");
        return L.toString();
    }
}
