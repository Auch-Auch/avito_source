package com.avito.android.remote.model.hotels;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u00020\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/model/hotels/HotelsFilters;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/hotels/Children;", "children", "Lcom/avito/android/remote/model/hotels/Children;", "getChildren", "()Lcom/avito/android/remote/model/hotels/Children;", "Lcom/avito/android/remote/model/hotels/Dates;", "dates", "Lcom/avito/android/remote/model/hotels/Dates;", "getDates", "()Lcom/avito/android/remote/model/hotels/Dates;", "Lcom/avito/android/remote/model/hotels/Adults;", "adults", "Lcom/avito/android/remote/model/hotels/Adults;", "getAdults", "()Lcom/avito/android/remote/model/hotels/Adults;", "<init>", "(Lcom/avito/android/remote/model/hotels/Adults;Lcom/avito/android/remote/model/hotels/Children;Lcom/avito/android/remote/model/hotels/Dates;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class HotelsFilters implements Parcelable {
    public static final Parcelable.Creator<HotelsFilters> CREATOR = new Creator();
    @SerializedName("adults")
    @NotNull
    private final Adults adults;
    @SerializedName("children")
    @NotNull
    private final Children children;
    @SerializedName("dates")
    @NotNull
    private final Dates dates;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<HotelsFilters> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final HotelsFilters createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new HotelsFilters(Adults.CREATOR.createFromParcel(parcel), Children.CREATOR.createFromParcel(parcel), Dates.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final HotelsFilters[] newArray(int i) {
            return new HotelsFilters[i];
        }
    }

    public HotelsFilters(@NotNull Adults adults2, @NotNull Children children2, @NotNull Dates dates2) {
        Intrinsics.checkNotNullParameter(adults2, "adults");
        Intrinsics.checkNotNullParameter(children2, "children");
        Intrinsics.checkNotNullParameter(dates2, "dates");
        this.adults = adults2;
        this.children = children2;
        this.dates = dates2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final Adults getAdults() {
        return this.adults;
    }

    @NotNull
    public final Children getChildren() {
        return this.children;
    }

    @NotNull
    public final Dates getDates() {
        return this.dates;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.adults.writeToParcel(parcel, 0);
        this.children.writeToParcel(parcel, 0);
        this.dates.writeToParcel(parcel, 0);
    }
}
