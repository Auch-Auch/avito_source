package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u0004R\u001c\u0010\u000f\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u00020\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/avito/android/remote/model/StrItemBookingRestriction;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "minimalDuration", "I", "getMinimalDuration", "", "available", "Z", "getAvailable", "()Z", "", Sort.DATE, "Ljava/lang/String;", "getDate", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ZI)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class StrItemBookingRestriction implements Parcelable {
    public static final Parcelable.Creator<StrItemBookingRestriction> CREATOR = new Creator();
    @SerializedName("available")
    private final boolean available;
    @SerializedName(Sort.DATE)
    @NotNull
    private final String date;
    @SerializedName("minimalDuration")
    private final int minimalDuration;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<StrItemBookingRestriction> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final StrItemBookingRestriction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new StrItemBookingRestriction(parcel.readString(), parcel.readInt() != 0, parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final StrItemBookingRestriction[] newArray(int i) {
            return new StrItemBookingRestriction[i];
        }
    }

    public StrItemBookingRestriction(@NotNull String str, boolean z, int i) {
        Intrinsics.checkNotNullParameter(str, Sort.DATE);
        this.date = str;
        this.available = z;
        this.minimalDuration = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final boolean getAvailable() {
        return this.available;
    }

    @NotNull
    public final String getDate() {
        return this.date;
    }

    public final int getMinimalDuration() {
        return this.minimalDuration;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.date);
        parcel.writeInt(this.available ? 1 : 0);
        parcel.writeInt(this.minimalDuration);
    }
}
