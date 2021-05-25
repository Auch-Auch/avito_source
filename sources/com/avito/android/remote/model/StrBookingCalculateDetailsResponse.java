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
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/avito/android/remote/model/StrBookingCalculateDetailsResponse;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/StrBookingCalculation;", "calculations", "Ljava/util/List;", "getCalculations", "()Ljava/util/List;", "Lcom/avito/android/remote/model/StrBookingDisclaimer;", "disclaimer", "Lcom/avito/android/remote/model/StrBookingDisclaimer;", "getDisclaimer", "()Lcom/avito/android/remote/model/StrBookingDisclaimer;", "<init>", "(Ljava/util/List;Lcom/avito/android/remote/model/StrBookingDisclaimer;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class StrBookingCalculateDetailsResponse implements Parcelable {
    public static final Parcelable.Creator<StrBookingCalculateDetailsResponse> CREATOR = new Creator();
    @SerializedName("calculations")
    @NotNull
    private final List<StrBookingCalculation> calculations;
    @SerializedName("disclaimer")
    @Nullable
    private final StrBookingDisclaimer disclaimer;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<StrBookingCalculateDetailsResponse> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final StrBookingCalculateDetailsResponse createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(StrBookingCalculation.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new StrBookingCalculateDetailsResponse(arrayList, parcel.readInt() != 0 ? StrBookingDisclaimer.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final StrBookingCalculateDetailsResponse[] newArray(int i) {
            return new StrBookingCalculateDetailsResponse[i];
        }
    }

    public StrBookingCalculateDetailsResponse(@NotNull List<StrBookingCalculation> list, @Nullable StrBookingDisclaimer strBookingDisclaimer) {
        Intrinsics.checkNotNullParameter(list, "calculations");
        this.calculations = list;
        this.disclaimer = strBookingDisclaimer;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<StrBookingCalculation> getCalculations() {
        return this.calculations;
    }

    @Nullable
    public final StrBookingDisclaimer getDisclaimer() {
        return this.disclaimer;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Iterator n0 = a.n0(this.calculations, parcel);
        while (n0.hasNext()) {
            ((StrBookingCalculation) n0.next()).writeToParcel(parcel, 0);
        }
        StrBookingDisclaimer strBookingDisclaimer = this.disclaimer;
        if (strBookingDisclaimer != null) {
            parcel.writeInt(1);
            strBookingDisclaimer.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
