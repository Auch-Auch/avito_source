package com.avito.android.orders.feature.common.viewmodel;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ParametrizedEvent;
import com.avito.android.remote.orders.model.OrdersPlaceholder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b1\u00102J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJB\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0012\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0018J \u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b#\u0010$R\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\bR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\u000eR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\u000b¨\u00063"}, d2 = {"Lcom/avito/android/orders/feature/common/viewmodel/OrderPage;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/orders/feature/common/viewmodel/OrderItem;", "component2", "()Ljava/util/List;", "Lcom/avito/android/remote/orders/model/OrdersPlaceholder;", "component3", "()Lcom/avito/android/remote/orders/model/OrdersPlaceholder;", "Lcom/avito/android/remote/model/ParametrizedEvent;", "component4", "()Lcom/avito/android/remote/model/ParametrizedEvent;", "nextPage", "orderItems", InternalConstsKt.PLACEHOLDER, "clickEvent", "copy", "(Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/orders/model/OrdersPlaceholder;Lcom/avito/android/remote/model/ParametrizedEvent;)Lcom/avito/android/orders/feature/common/viewmodel/OrderPage;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getOrderItems", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getNextPage", "d", "Lcom/avito/android/remote/model/ParametrizedEvent;", "getClickEvent", "c", "Lcom/avito/android/remote/orders/model/OrdersPlaceholder;", "getPlaceholder", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/orders/model/OrdersPlaceholder;Lcom/avito/android/remote/model/ParametrizedEvent;)V", "orders_release"}, k = 1, mv = {1, 4, 2})
public final class OrderPage implements Parcelable {
    public static final Parcelable.Creator<OrderPage> CREATOR = new Creator();
    @Nullable
    public final String a;
    @NotNull
    public final List<OrderItem> b;
    @Nullable
    public final OrdersPlaceholder c;
    @NotNull
    public final ParametrizedEvent d;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<OrderPage> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrderPage createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(OrderItem.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new OrderPage(readString, arrayList, (OrdersPlaceholder) parcel.readParcelable(OrderPage.class.getClassLoader()), (ParametrizedEvent) parcel.readParcelable(OrderPage.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrderPage[] newArray(int i) {
            return new OrderPage[i];
        }
    }

    public OrderPage(@Nullable String str, @NotNull List<OrderItem> list, @Nullable OrdersPlaceholder ordersPlaceholder, @NotNull ParametrizedEvent parametrizedEvent) {
        Intrinsics.checkNotNullParameter(list, "orderItems");
        Intrinsics.checkNotNullParameter(parametrizedEvent, "clickEvent");
        this.a = str;
        this.b = list;
        this.c = ordersPlaceholder;
        this.d = parametrizedEvent;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.orders.feature.common.viewmodel.OrderPage */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OrderPage copy$default(OrderPage orderPage, String str, List list, OrdersPlaceholder ordersPlaceholder, ParametrizedEvent parametrizedEvent, int i, Object obj) {
        if ((i & 1) != 0) {
            str = orderPage.a;
        }
        if ((i & 2) != 0) {
            list = orderPage.b;
        }
        if ((i & 4) != 0) {
            ordersPlaceholder = orderPage.c;
        }
        if ((i & 8) != 0) {
            parametrizedEvent = orderPage.d;
        }
        return orderPage.copy(str, list, ordersPlaceholder, parametrizedEvent);
    }

    @Nullable
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final List<OrderItem> component2() {
        return this.b;
    }

    @Nullable
    public final OrdersPlaceholder component3() {
        return this.c;
    }

    @NotNull
    public final ParametrizedEvent component4() {
        return this.d;
    }

    @NotNull
    public final OrderPage copy(@Nullable String str, @NotNull List<OrderItem> list, @Nullable OrdersPlaceholder ordersPlaceholder, @NotNull ParametrizedEvent parametrizedEvent) {
        Intrinsics.checkNotNullParameter(list, "orderItems");
        Intrinsics.checkNotNullParameter(parametrizedEvent, "clickEvent");
        return new OrderPage(str, list, ordersPlaceholder, parametrizedEvent);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderPage)) {
            return false;
        }
        OrderPage orderPage = (OrderPage) obj;
        return Intrinsics.areEqual(this.a, orderPage.a) && Intrinsics.areEqual(this.b, orderPage.b) && Intrinsics.areEqual(this.c, orderPage.c) && Intrinsics.areEqual(this.d, orderPage.d);
    }

    @NotNull
    public final ParametrizedEvent getClickEvent() {
        return this.d;
    }

    @Nullable
    public final String getNextPage() {
        return this.a;
    }

    @NotNull
    public final List<OrderItem> getOrderItems() {
        return this.b;
    }

    @Nullable
    public final OrdersPlaceholder getPlaceholder() {
        return this.c;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<OrderItem> list = this.b;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        OrdersPlaceholder ordersPlaceholder = this.c;
        int hashCode3 = (hashCode2 + (ordersPlaceholder != null ? ordersPlaceholder.hashCode() : 0)) * 31;
        ParametrizedEvent parametrizedEvent = this.d;
        if (parametrizedEvent != null) {
            i = parametrizedEvent.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("OrderPage(nextPage=");
        L.append(this.a);
        L.append(", orderItems=");
        L.append(this.b);
        L.append(", placeholder=");
        L.append(this.c);
        L.append(", clickEvent=");
        L.append(this.d);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        Iterator n0 = a.n0(this.b, parcel);
        while (n0.hasNext()) {
            ((OrderItem) n0.next()).writeToParcel(parcel, 0);
        }
        parcel.writeParcelable(this.c, i);
        parcel.writeParcelable(this.d, i);
    }
}
