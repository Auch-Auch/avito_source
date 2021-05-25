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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/model/CloseReasonsResponse;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/CloseReason;", "closeReasons", "Ljava/util/List;", "getCloseReasons", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class CloseReasonsResponse implements Parcelable {
    public static final Parcelable.Creator<CloseReasonsResponse> CREATOR = new Creator();
    @SerializedName("closeReasons")
    @NotNull
    private final List<CloseReason> closeReasons;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CloseReasonsResponse> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CloseReasonsResponse createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(CloseReason.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new CloseReasonsResponse(arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CloseReasonsResponse[] newArray(int i) {
            return new CloseReasonsResponse[i];
        }
    }

    public CloseReasonsResponse(@NotNull List<CloseReason> list) {
        Intrinsics.checkNotNullParameter(list, "closeReasons");
        this.closeReasons = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<CloseReason> getCloseReasons() {
        return this.closeReasons;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Iterator n0 = a.n0(this.closeReasons, parcel);
        while (n0.hasNext()) {
            ((CloseReason) n0.next()).writeToParcel(parcel, 0);
        }
    }
}
