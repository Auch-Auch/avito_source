package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0004J \u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/model/AdvertStatsContact;", "Landroid/os/Parcelable;", "", "getTotal", "()I", "getToday", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "today", "Ljava/lang/Integer;", "total", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertStatsContact implements Parcelable {
    public static final Parcelable.Creator<AdvertStatsContact> CREATOR = new Creator();
    private final Integer today;
    private final Integer total;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertStatsContact> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertStatsContact createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            Integer num = null;
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            if (parcel.readInt() != 0) {
                num = Integer.valueOf(parcel.readInt());
            }
            return new AdvertStatsContact(valueOf, num);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertStatsContact[] newArray(int i) {
            return new AdvertStatsContact[i];
        }
    }

    public AdvertStatsContact(@Nullable Integer num, @Nullable Integer num2) {
        this.total = num;
        this.today = num2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getToday() {
        Integer num = this.today;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final int getTotal() {
        Integer num = this.total;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Integer num = this.total;
        if (num != null) {
            a.H0(parcel, 1, num);
        } else {
            parcel.writeInt(0);
        }
        Integer num2 = this.today;
        if (num2 != null) {
            a.H0(parcel, 1, num2);
        } else {
            parcel.writeInt(0);
        }
    }
}
