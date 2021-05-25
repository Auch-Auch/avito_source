package com.avito.android.safedeal.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.AlertBannerModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\"\u0010#J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001e\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\u0007¨\u0006$"}, d2 = {"Lcom/avito/android/safedeal/remote/model/DeliveryTypeResponse;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/AlertBannerModel;", "component1", "()Lcom/avito/android/remote/model/AlertBannerModel;", "Lcom/avito/android/safedeal/remote/model/OrderTypesGroup;", "component2", "()Lcom/avito/android/safedeal/remote/model/OrderTypesGroup;", "banner", "orderTypesGroup", "copy", "(Lcom/avito/android/remote/model/AlertBannerModel;Lcom/avito/android/safedeal/remote/model/OrderTypesGroup;)Lcom/avito/android/safedeal/remote/model/DeliveryTypeResponse;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/AlertBannerModel;", "getBanner", "Lcom/avito/android/safedeal/remote/model/OrderTypesGroup;", "getOrderTypesGroup", "<init>", "(Lcom/avito/android/remote/model/AlertBannerModel;Lcom/avito/android/safedeal/remote/model/OrderTypesGroup;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryTypeResponse implements Parcelable {
    public static final Parcelable.Creator<DeliveryTypeResponse> CREATOR = new Creator();
    @SerializedName("banner")
    @Nullable
    private final AlertBannerModel banner;
    @SerializedName("orderTypesGroup")
    @Nullable
    private final OrderTypesGroup orderTypesGroup;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DeliveryTypeResponse> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliveryTypeResponse createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new DeliveryTypeResponse((AlertBannerModel) parcel.readParcelable(DeliveryTypeResponse.class.getClassLoader()), parcel.readInt() != 0 ? OrderTypesGroup.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliveryTypeResponse[] newArray(int i) {
            return new DeliveryTypeResponse[i];
        }
    }

    public DeliveryTypeResponse(@Nullable AlertBannerModel alertBannerModel, @Nullable OrderTypesGroup orderTypesGroup2) {
        this.banner = alertBannerModel;
        this.orderTypesGroup = orderTypesGroup2;
    }

    public static /* synthetic */ DeliveryTypeResponse copy$default(DeliveryTypeResponse deliveryTypeResponse, AlertBannerModel alertBannerModel, OrderTypesGroup orderTypesGroup2, int i, Object obj) {
        if ((i & 1) != 0) {
            alertBannerModel = deliveryTypeResponse.banner;
        }
        if ((i & 2) != 0) {
            orderTypesGroup2 = deliveryTypeResponse.orderTypesGroup;
        }
        return deliveryTypeResponse.copy(alertBannerModel, orderTypesGroup2);
    }

    @Nullable
    public final AlertBannerModel component1() {
        return this.banner;
    }

    @Nullable
    public final OrderTypesGroup component2() {
        return this.orderTypesGroup;
    }

    @NotNull
    public final DeliveryTypeResponse copy(@Nullable AlertBannerModel alertBannerModel, @Nullable OrderTypesGroup orderTypesGroup2) {
        return new DeliveryTypeResponse(alertBannerModel, orderTypesGroup2);
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
        if (!(obj instanceof DeliveryTypeResponse)) {
            return false;
        }
        DeliveryTypeResponse deliveryTypeResponse = (DeliveryTypeResponse) obj;
        return Intrinsics.areEqual(this.banner, deliveryTypeResponse.banner) && Intrinsics.areEqual(this.orderTypesGroup, deliveryTypeResponse.orderTypesGroup);
    }

    @Nullable
    public final AlertBannerModel getBanner() {
        return this.banner;
    }

    @Nullable
    public final OrderTypesGroup getOrderTypesGroup() {
        return this.orderTypesGroup;
    }

    @Override // java.lang.Object
    public int hashCode() {
        AlertBannerModel alertBannerModel = this.banner;
        int i = 0;
        int hashCode = (alertBannerModel != null ? alertBannerModel.hashCode() : 0) * 31;
        OrderTypesGroup orderTypesGroup2 = this.orderTypesGroup;
        if (orderTypesGroup2 != null) {
            i = orderTypesGroup2.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("DeliveryTypeResponse(banner=");
        L.append(this.banner);
        L.append(", orderTypesGroup=");
        L.append(this.orderTypesGroup);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.banner, i);
        OrderTypesGroup orderTypesGroup2 = this.orderTypesGroup;
        if (orderTypesGroup2 != null) {
            parcel.writeInt(1);
            orderTypesGroup2.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
