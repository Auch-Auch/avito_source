package com.avito.android.remote.orders.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007¨\u0006\""}, d2 = {"Lcom/avito/android/remote/orders/model/OrdersPlaceHolderButton;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component2", "()Lcom/avito/android/deep_linking/links/DeepLink;", "title", "deepLink", "copy", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/remote/orders/model/OrdersPlaceHolderButton;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "orders_release"}, k = 1, mv = {1, 4, 2})
public final class OrdersPlaceHolderButton implements Parcelable {
    public static final Parcelable.Creator<OrdersPlaceHolderButton> CREATOR = new Creator();
    @SerializedName("deepLink")
    @NotNull
    private final DeepLink deepLink;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<OrdersPlaceHolderButton> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrdersPlaceHolderButton createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new OrdersPlaceHolderButton(parcel.readString(), (DeepLink) parcel.readParcelable(OrdersPlaceHolderButton.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrdersPlaceHolderButton[] newArray(int i) {
            return new OrdersPlaceHolderButton[i];
        }
    }

    public OrdersPlaceHolderButton(@NotNull String str, @NotNull DeepLink deepLink2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(deepLink2, "deepLink");
        this.title = str;
        this.deepLink = deepLink2;
    }

    public static /* synthetic */ OrdersPlaceHolderButton copy$default(OrdersPlaceHolderButton ordersPlaceHolderButton, String str, DeepLink deepLink2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ordersPlaceHolderButton.title;
        }
        if ((i & 2) != 0) {
            deepLink2 = ordersPlaceHolderButton.deepLink;
        }
        return ordersPlaceHolderButton.copy(str, deepLink2);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final DeepLink component2() {
        return this.deepLink;
    }

    @NotNull
    public final OrdersPlaceHolderButton copy(@NotNull String str, @NotNull DeepLink deepLink2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(deepLink2, "deepLink");
        return new OrdersPlaceHolderButton(str, deepLink2);
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
        if (!(obj instanceof OrdersPlaceHolderButton)) {
            return false;
        }
        OrdersPlaceHolderButton ordersPlaceHolderButton = (OrdersPlaceHolderButton) obj;
        return Intrinsics.areEqual(this.title, ordersPlaceHolderButton.title) && Intrinsics.areEqual(this.deepLink, ordersPlaceHolderButton.deepLink);
    }

    @NotNull
    public final DeepLink getDeepLink() {
        return this.deepLink;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        DeepLink deepLink2 = this.deepLink;
        if (deepLink2 != null) {
            i = deepLink2.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("OrdersPlaceHolderButton(title=");
        L.append(this.title);
        L.append(", deepLink=");
        return a.m(L, this.deepLink, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeParcelable(this.deepLink, i);
    }
}
