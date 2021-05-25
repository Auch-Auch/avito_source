package com.avito.android.remote.model.hotels;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u00020\u00198\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\u00020\u001e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/avito/android/remote/model/hotels/HotelsFiltersResult;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/hotels/Information;", "information", "Ljava/util/List;", "getInformation", "()Ljava/util/List;", "Lcom/avito/android/remote/model/hotels/HotelsLocation;", "defaultLocations", "getDefaultLocations", "Lcom/avito/android/remote/model/hotels/DiscountBanner;", "discountBanner", "Lcom/avito/android/remote/model/hotels/DiscountBanner;", "getDiscountBanner", "()Lcom/avito/android/remote/model/hotels/DiscountBanner;", "Lcom/avito/android/remote/model/hotels/HotelsFilters;", "filters", "Lcom/avito/android/remote/model/hotels/HotelsFilters;", "getFilters", "()Lcom/avito/android/remote/model/hotels/HotelsFilters;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/hotels/HotelsFilters;Ljava/util/List;Ljava/util/List;Lcom/avito/android/remote/model/hotels/DiscountBanner;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class HotelsFiltersResult implements Parcelable {
    public static final Parcelable.Creator<HotelsFiltersResult> CREATOR = new Creator();
    @SerializedName("defaultLocations")
    @NotNull
    private final List<HotelsLocation> defaultLocations;
    @SerializedName("discountBanner")
    @Nullable
    private final DiscountBanner discountBanner;
    @SerializedName("filters")
    @NotNull
    private final HotelsFilters filters;
    @SerializedName("information")
    @NotNull
    private final List<Information> information;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<HotelsFiltersResult> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final HotelsFiltersResult createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            HotelsFilters createFromParcel = HotelsFilters.CREATOR.createFromParcel(parcel);
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(HotelsLocation.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            int readInt2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList2.add(Information.CREATOR.createFromParcel(parcel));
                readInt2--;
            }
            return new HotelsFiltersResult(readString, createFromParcel, arrayList, arrayList2, parcel.readInt() != 0 ? DiscountBanner.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final HotelsFiltersResult[] newArray(int i) {
            return new HotelsFiltersResult[i];
        }
    }

    public HotelsFiltersResult(@NotNull String str, @NotNull HotelsFilters hotelsFilters, @NotNull List<HotelsLocation> list, @NotNull List<Information> list2, @Nullable DiscountBanner discountBanner2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(hotelsFilters, "filters");
        Intrinsics.checkNotNullParameter(list, "defaultLocations");
        Intrinsics.checkNotNullParameter(list2, "information");
        this.title = str;
        this.filters = hotelsFilters;
        this.defaultLocations = list;
        this.information = list2;
        this.discountBanner = discountBanner2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<HotelsLocation> getDefaultLocations() {
        return this.defaultLocations;
    }

    @Nullable
    public final DiscountBanner getDiscountBanner() {
        return this.discountBanner;
    }

    @NotNull
    public final HotelsFilters getFilters() {
        return this.filters;
    }

    @NotNull
    public final List<Information> getInformation() {
        return this.information;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        this.filters.writeToParcel(parcel, 0);
        Iterator n0 = a.n0(this.defaultLocations, parcel);
        while (n0.hasNext()) {
            ((HotelsLocation) n0.next()).writeToParcel(parcel, 0);
        }
        Iterator n02 = a.n0(this.information, parcel);
        while (n02.hasNext()) {
            ((Information) n02.next()).writeToParcel(parcel, 0);
        }
        DiscountBanner discountBanner2 = this.discountBanner;
        if (discountBanner2 != null) {
            parcel.writeInt(1);
            discountBanner2.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
