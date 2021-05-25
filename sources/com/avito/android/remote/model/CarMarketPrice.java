package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\u0007¨\u0006$"}, d2 = {"Lcom/avito/android/remote/model/CarMarketPrice;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/PriceDescription;", "component1", "()Lcom/avito/android/remote/model/PriceDescription;", "Lcom/avito/android/remote/model/PriceRanges;", "component2", "()Lcom/avito/android/remote/model/PriceRanges;", "priceDescription", "priceRanges", "copy", "(Lcom/avito/android/remote/model/PriceDescription;Lcom/avito/android/remote/model/PriceRanges;)Lcom/avito/android/remote/model/CarMarketPrice;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/PriceDescription;", "getPriceDescription", "Lcom/avito/android/remote/model/PriceRanges;", "getPriceRanges", "<init>", "(Lcom/avito/android/remote/model/PriceDescription;Lcom/avito/android/remote/model/PriceRanges;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class CarMarketPrice implements Parcelable {
    public static final Parcelable.Creator<CarMarketPrice> CREATOR = new Creator();
    @SerializedName("priceDescription")
    @NotNull
    private final PriceDescription priceDescription;
    @SerializedName("priceRanges")
    @NotNull
    private final PriceRanges priceRanges;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CarMarketPrice> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CarMarketPrice createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new CarMarketPrice(PriceDescription.CREATOR.createFromParcel(parcel), PriceRanges.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CarMarketPrice[] newArray(int i) {
            return new CarMarketPrice[i];
        }
    }

    public CarMarketPrice(@NotNull PriceDescription priceDescription2, @NotNull PriceRanges priceRanges2) {
        Intrinsics.checkNotNullParameter(priceDescription2, "priceDescription");
        Intrinsics.checkNotNullParameter(priceRanges2, "priceRanges");
        this.priceDescription = priceDescription2;
        this.priceRanges = priceRanges2;
    }

    public static /* synthetic */ CarMarketPrice copy$default(CarMarketPrice carMarketPrice, PriceDescription priceDescription2, PriceRanges priceRanges2, int i, Object obj) {
        if ((i & 1) != 0) {
            priceDescription2 = carMarketPrice.priceDescription;
        }
        if ((i & 2) != 0) {
            priceRanges2 = carMarketPrice.priceRanges;
        }
        return carMarketPrice.copy(priceDescription2, priceRanges2);
    }

    @NotNull
    public final PriceDescription component1() {
        return this.priceDescription;
    }

    @NotNull
    public final PriceRanges component2() {
        return this.priceRanges;
    }

    @NotNull
    public final CarMarketPrice copy(@NotNull PriceDescription priceDescription2, @NotNull PriceRanges priceRanges2) {
        Intrinsics.checkNotNullParameter(priceDescription2, "priceDescription");
        Intrinsics.checkNotNullParameter(priceRanges2, "priceRanges");
        return new CarMarketPrice(priceDescription2, priceRanges2);
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
        if (!(obj instanceof CarMarketPrice)) {
            return false;
        }
        CarMarketPrice carMarketPrice = (CarMarketPrice) obj;
        return Intrinsics.areEqual(this.priceDescription, carMarketPrice.priceDescription) && Intrinsics.areEqual(this.priceRanges, carMarketPrice.priceRanges);
    }

    @NotNull
    public final PriceDescription getPriceDescription() {
        return this.priceDescription;
    }

    @NotNull
    public final PriceRanges getPriceRanges() {
        return this.priceRanges;
    }

    @Override // java.lang.Object
    public int hashCode() {
        PriceDescription priceDescription2 = this.priceDescription;
        int i = 0;
        int hashCode = (priceDescription2 != null ? priceDescription2.hashCode() : 0) * 31;
        PriceRanges priceRanges2 = this.priceRanges;
        if (priceRanges2 != null) {
            i = priceRanges2.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("CarMarketPrice(priceDescription=");
        L.append(this.priceDescription);
        L.append(", priceRanges=");
        L.append(this.priceRanges);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.priceDescription.writeToParcel(parcel, 0);
        this.priceRanges.writeToParcel(parcel, 0);
    }
}
