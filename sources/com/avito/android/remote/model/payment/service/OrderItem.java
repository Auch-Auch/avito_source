package com.avito.android.remote.model.payment.service;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001c\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/avito/android/remote/model/payment/service/OrderItem;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "serviceSlug", "externalId", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/payment/service/OrderItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getServiceSlug", "getExternalId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class OrderItem implements Parcelable {
    public static final Parcelable.Creator<OrderItem> CREATOR = new Creator();
    @NotNull
    private final String externalId;
    @NotNull
    private final String serviceSlug;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<OrderItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrderItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new OrderItem(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrderItem[] newArray(int i) {
            return new OrderItem[i];
        }
    }

    public OrderItem(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "serviceSlug");
        Intrinsics.checkNotNullParameter(str2, "externalId");
        this.serviceSlug = str;
        this.externalId = str2;
    }

    public static /* synthetic */ OrderItem copy$default(OrderItem orderItem, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = orderItem.serviceSlug;
        }
        if ((i & 2) != 0) {
            str2 = orderItem.externalId;
        }
        return orderItem.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.serviceSlug;
    }

    @NotNull
    public final String component2() {
        return this.externalId;
    }

    @NotNull
    public final OrderItem copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "serviceSlug");
        Intrinsics.checkNotNullParameter(str2, "externalId");
        return new OrderItem(str, str2);
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
        if (!(obj instanceof OrderItem)) {
            return false;
        }
        OrderItem orderItem = (OrderItem) obj;
        return Intrinsics.areEqual(this.serviceSlug, orderItem.serviceSlug) && Intrinsics.areEqual(this.externalId, orderItem.externalId);
    }

    @NotNull
    public final String getExternalId() {
        return this.externalId;
    }

    @NotNull
    public final String getServiceSlug() {
        return this.serviceSlug;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.serviceSlug;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.externalId;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("OrderItem(serviceSlug=");
        L.append(this.serviceSlug);
        L.append(", externalId=");
        return a.t(L, this.externalId, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.serviceSlug);
        parcel.writeString(this.externalId);
    }
}
