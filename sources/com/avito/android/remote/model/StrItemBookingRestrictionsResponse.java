package com.avito.android.remote.model;

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
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/model/StrItemBookingRestrictionsResponse;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/StrItemBookingRestriction;", "restrictions", "Ljava/util/List;", "getRestrictions", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class StrItemBookingRestrictionsResponse implements Parcelable {
    public static final Parcelable.Creator<StrItemBookingRestrictionsResponse> CREATOR = new Creator();
    @SerializedName("restrictions")
    @NotNull
    private final List<StrItemBookingRestriction> restrictions;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<StrItemBookingRestrictionsResponse> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final StrItemBookingRestrictionsResponse createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(StrItemBookingRestriction.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new StrItemBookingRestrictionsResponse(arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final StrItemBookingRestrictionsResponse[] newArray(int i) {
            return new StrItemBookingRestrictionsResponse[i];
        }
    }

    public StrItemBookingRestrictionsResponse(@NotNull List<StrItemBookingRestriction> list) {
        Intrinsics.checkNotNullParameter(list, "restrictions");
        this.restrictions = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<StrItemBookingRestriction> getRestrictions() {
        return this.restrictions;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Iterator n0 = a.n0(this.restrictions, parcel);
        while (n0.hasNext()) {
            ((StrItemBookingRestriction) n0.next()).writeToParcel(parcel, 0);
        }
    }
}
