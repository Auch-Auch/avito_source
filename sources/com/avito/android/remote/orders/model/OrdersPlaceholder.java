package com.avito.android.remote.orders.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\n\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\u0004R\u001c\u0010\u000b\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b\"\u0010\u0007¨\u0006%"}, d2 = {"Lcom/avito/android/remote/orders/model/OrdersPlaceholder;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/orders/model/OrdersPlaceHolderButton;", "component1", "()Lcom/avito/android/remote/orders/model/OrdersPlaceHolderButton;", "", "component2", "()Ljava/lang/String;", "component3", PhonePageSourceKt.PHONE_SOURCE_BUTTON, MessengerShareContentUtility.SUBTITLE, "title", "copy", "(Lcom/avito/android/remote/orders/model/OrdersPlaceHolderButton;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/orders/model/OrdersPlaceholder;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getSubtitle", "Lcom/avito/android/remote/orders/model/OrdersPlaceHolderButton;", "getButton", "getTitle", "<init>", "(Lcom/avito/android/remote/orders/model/OrdersPlaceHolderButton;Ljava/lang/String;Ljava/lang/String;)V", "orders_release"}, k = 1, mv = {1, 4, 2})
public final class OrdersPlaceholder implements Parcelable {
    public static final Parcelable.Creator<OrdersPlaceholder> CREATOR = new Creator();
    @SerializedName(PhonePageSourceKt.PHONE_SOURCE_BUTTON)
    @NotNull
    private final OrdersPlaceHolderButton button;
    @SerializedName(MessengerShareContentUtility.SUBTITLE)
    @NotNull
    private final String subtitle;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<OrdersPlaceholder> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrdersPlaceholder createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new OrdersPlaceholder(OrdersPlaceHolderButton.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrdersPlaceholder[] newArray(int i) {
            return new OrdersPlaceholder[i];
        }
    }

    public OrdersPlaceholder(@NotNull OrdersPlaceHolderButton ordersPlaceHolderButton, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(ordersPlaceHolderButton, PhonePageSourceKt.PHONE_SOURCE_BUTTON);
        Intrinsics.checkNotNullParameter(str, MessengerShareContentUtility.SUBTITLE);
        Intrinsics.checkNotNullParameter(str2, "title");
        this.button = ordersPlaceHolderButton;
        this.subtitle = str;
        this.title = str2;
    }

    public static /* synthetic */ OrdersPlaceholder copy$default(OrdersPlaceholder ordersPlaceholder, OrdersPlaceHolderButton ordersPlaceHolderButton, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            ordersPlaceHolderButton = ordersPlaceholder.button;
        }
        if ((i & 2) != 0) {
            str = ordersPlaceholder.subtitle;
        }
        if ((i & 4) != 0) {
            str2 = ordersPlaceholder.title;
        }
        return ordersPlaceholder.copy(ordersPlaceHolderButton, str, str2);
    }

    @NotNull
    public final OrdersPlaceHolderButton component1() {
        return this.button;
    }

    @NotNull
    public final String component2() {
        return this.subtitle;
    }

    @NotNull
    public final String component3() {
        return this.title;
    }

    @NotNull
    public final OrdersPlaceholder copy(@NotNull OrdersPlaceHolderButton ordersPlaceHolderButton, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(ordersPlaceHolderButton, PhonePageSourceKt.PHONE_SOURCE_BUTTON);
        Intrinsics.checkNotNullParameter(str, MessengerShareContentUtility.SUBTITLE);
        Intrinsics.checkNotNullParameter(str2, "title");
        return new OrdersPlaceholder(ordersPlaceHolderButton, str, str2);
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
        if (!(obj instanceof OrdersPlaceholder)) {
            return false;
        }
        OrdersPlaceholder ordersPlaceholder = (OrdersPlaceholder) obj;
        return Intrinsics.areEqual(this.button, ordersPlaceholder.button) && Intrinsics.areEqual(this.subtitle, ordersPlaceholder.subtitle) && Intrinsics.areEqual(this.title, ordersPlaceholder.title);
    }

    @NotNull
    public final OrdersPlaceHolderButton getButton() {
        return this.button;
    }

    @NotNull
    public final String getSubtitle() {
        return this.subtitle;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        OrdersPlaceHolderButton ordersPlaceHolderButton = this.button;
        int i = 0;
        int hashCode = (ordersPlaceHolderButton != null ? ordersPlaceHolderButton.hashCode() : 0) * 31;
        String str = this.subtitle;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.title;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("OrdersPlaceholder(button=");
        L.append(this.button);
        L.append(", subtitle=");
        L.append(this.subtitle);
        L.append(", title=");
        return a.t(L, this.title, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.button.writeToParcel(parcel, 0);
        parcel.writeString(this.subtitle);
        parcel.writeString(this.title);
    }
}
