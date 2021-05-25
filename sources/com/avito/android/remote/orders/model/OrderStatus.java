package com.avito.android.remote.orders.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.UniversalColor;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\u000b\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b!\u0010\u0007R\u001c\u0010\n\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b\"\u0010\u0007¨\u0006%"}, d2 = {"Lcom/avito/android/remote/orders/model/OrderStatus;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/UniversalColor;", "component2", "()Lcom/avito/android/remote/model/UniversalColor;", "component3", "text", "backgroundColor", "textColor", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/UniversalColor;)Lcom/avito/android/remote/orders/model/OrderStatus;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getText", "Lcom/avito/android/remote/model/UniversalColor;", "getTextColor", "getBackgroundColor", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/UniversalColor;)V", "orders_release"}, k = 1, mv = {1, 4, 2})
public final class OrderStatus implements Parcelable {
    public static final Parcelable.Creator<OrderStatus> CREATOR = new Creator();
    @SerializedName("backgroundColor")
    @NotNull
    private final UniversalColor backgroundColor;
    @SerializedName("text")
    @NotNull
    private final String text;
    @SerializedName("textColor")
    @NotNull
    private final UniversalColor textColor;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<OrderStatus> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrderStatus createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new OrderStatus(parcel.readString(), (UniversalColor) parcel.readParcelable(OrderStatus.class.getClassLoader()), (UniversalColor) parcel.readParcelable(OrderStatus.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrderStatus[] newArray(int i) {
            return new OrderStatus[i];
        }
    }

    public OrderStatus(@NotNull String str, @NotNull UniversalColor universalColor, @NotNull UniversalColor universalColor2) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(universalColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(universalColor2, "textColor");
        this.text = str;
        this.backgroundColor = universalColor;
        this.textColor = universalColor2;
    }

    public static /* synthetic */ OrderStatus copy$default(OrderStatus orderStatus, String str, UniversalColor universalColor, UniversalColor universalColor2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = orderStatus.text;
        }
        if ((i & 2) != 0) {
            universalColor = orderStatus.backgroundColor;
        }
        if ((i & 4) != 0) {
            universalColor2 = orderStatus.textColor;
        }
        return orderStatus.copy(str, universalColor, universalColor2);
    }

    @NotNull
    public final String component1() {
        return this.text;
    }

    @NotNull
    public final UniversalColor component2() {
        return this.backgroundColor;
    }

    @NotNull
    public final UniversalColor component3() {
        return this.textColor;
    }

    @NotNull
    public final OrderStatus copy(@NotNull String str, @NotNull UniversalColor universalColor, @NotNull UniversalColor universalColor2) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(universalColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(universalColor2, "textColor");
        return new OrderStatus(str, universalColor, universalColor2);
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
        if (!(obj instanceof OrderStatus)) {
            return false;
        }
        OrderStatus orderStatus = (OrderStatus) obj;
        return Intrinsics.areEqual(this.text, orderStatus.text) && Intrinsics.areEqual(this.backgroundColor, orderStatus.backgroundColor) && Intrinsics.areEqual(this.textColor, orderStatus.textColor);
    }

    @NotNull
    public final UniversalColor getBackgroundColor() {
        return this.backgroundColor;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @NotNull
    public final UniversalColor getTextColor() {
        return this.textColor;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.text;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        UniversalColor universalColor = this.backgroundColor;
        int hashCode2 = (hashCode + (universalColor != null ? universalColor.hashCode() : 0)) * 31;
        UniversalColor universalColor2 = this.textColor;
        if (universalColor2 != null) {
            i = universalColor2.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("OrderStatus(text=");
        L.append(this.text);
        L.append(", backgroundColor=");
        L.append(this.backgroundColor);
        L.append(", textColor=");
        L.append(this.textColor);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.text);
        parcel.writeParcelable(this.backgroundColor, i);
        parcel.writeParcelable(this.textColor, i);
    }
}
