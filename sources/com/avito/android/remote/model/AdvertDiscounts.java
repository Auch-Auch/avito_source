package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B?\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010 \u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b \u0010\r\u001a\u0004\b!\u0010\u000f¨\u0006$"}, d2 = {"Lcom/avito/android/remote/model/AdvertDiscounts;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/TotalDiscount;", "total", "Lcom/avito/android/remote/model/TotalDiscount;", "getTotal", "()Lcom/avito/android/remote/model/TotalDiscount;", "Lcom/avito/android/remote/model/MinPrice;", "minPrice", "Lcom/avito/android/remote/model/MinPrice;", "getMinPrice", "()Lcom/avito/android/remote/model/MinPrice;", "", "Lcom/avito/android/remote/model/Discount;", "discounts", "Ljava/util/List;", "getDiscounts", "()Ljava/util/List;", "information", "getInformation", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/TotalDiscount;Lcom/avito/android/remote/model/MinPrice;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDiscounts implements Parcelable {
    public static final Parcelable.Creator<AdvertDiscounts> CREATOR = new Creator();
    @SerializedName(ResidentialComplexModuleKt.VALUES)
    @Nullable
    private final List<Discount> discounts;
    @SerializedName("information")
    @Nullable
    private final String information;
    @SerializedName("minPrice")
    @Nullable
    private final MinPrice minPrice;
    @SerializedName("title")
    @Nullable
    private final String title;
    @SerializedName("total")
    @Nullable
    private final TotalDiscount total;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertDiscounts> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDiscounts createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(Discount.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new AdvertDiscounts(readString, arrayList, parcel.readInt() != 0 ? TotalDiscount.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? MinPrice.CREATOR.createFromParcel(parcel) : null, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDiscounts[] newArray(int i) {
            return new AdvertDiscounts[i];
        }
    }

    public AdvertDiscounts(@Nullable String str, @Nullable List<Discount> list, @Nullable TotalDiscount totalDiscount, @Nullable MinPrice minPrice2, @Nullable String str2) {
        this.title = str;
        this.discounts = list;
        this.total = totalDiscount;
        this.minPrice = minPrice2;
        this.information = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final List<Discount> getDiscounts() {
        return this.discounts;
    }

    @Nullable
    public final String getInformation() {
        return this.information;
    }

    @Nullable
    public final MinPrice getMinPrice() {
        return this.minPrice;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final TotalDiscount getTotal() {
        return this.total;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        List<Discount> list = this.discounts;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                ((Discount) l0.next()).writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        TotalDiscount totalDiscount = this.total;
        if (totalDiscount != null) {
            parcel.writeInt(1);
            totalDiscount.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        MinPrice minPrice2 = this.minPrice;
        if (minPrice2 != null) {
            parcel.writeInt(1);
            minPrice2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.information);
    }
}
