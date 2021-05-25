package com.avito.android.remote.model.delivery;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.delivery.DeliverySummaryRds;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliverySpecificQuantityState;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$Calculation;", "updatedPrice", "Ljava/util/List;", "getUpdatedPrice", "()Ljava/util/List;", "availableQuantity", "I", "getAvailableQuantity", "", "tooltipMessage", "Ljava/lang/String;", "getTooltipMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/util/List;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliverySpecificQuantityState implements Parcelable {
    public static final Parcelable.Creator<DeliverySpecificQuantityState> CREATOR = new Creator();
    @SerializedName("availableQuantity")
    private final int availableQuantity;
    @SerializedName("tooltip")
    @Nullable
    private final String tooltipMessage;
    @SerializedName("updatedPrice")
    @NotNull
    private final List<DeliverySummaryRds.Calculation> updatedPrice;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DeliverySpecificQuantityState> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliverySpecificQuantityState createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList.add(DeliverySummaryRds.Calculation.CREATOR.createFromParcel(parcel));
                readInt2--;
            }
            return new DeliverySpecificQuantityState(readString, readInt, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliverySpecificQuantityState[] newArray(int i) {
            return new DeliverySpecificQuantityState[i];
        }
    }

    public DeliverySpecificQuantityState(@Nullable String str, int i, @NotNull List<DeliverySummaryRds.Calculation> list) {
        Intrinsics.checkNotNullParameter(list, "updatedPrice");
        this.tooltipMessage = str;
        this.availableQuantity = i;
        this.updatedPrice = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getAvailableQuantity() {
        return this.availableQuantity;
    }

    @Nullable
    public final String getTooltipMessage() {
        return this.tooltipMessage;
    }

    @NotNull
    public final List<DeliverySummaryRds.Calculation> getUpdatedPrice() {
        return this.updatedPrice;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.tooltipMessage);
        parcel.writeInt(this.availableQuantity);
        Iterator n0 = a.n0(this.updatedPrice, parcel);
        while (n0.hasNext()) {
            ((DeliverySummaryRds.Calculation) n0.next()).writeToParcel(parcel, 0);
        }
    }
}
