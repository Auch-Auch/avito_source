package com.avito.android.remote;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/DomotekaTeaserResponse;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/DomotekaTeaser;", "result", "Lcom/avito/android/remote/DomotekaTeaser;", "getResult", "()Lcom/avito/android/remote/DomotekaTeaser;", "<init>", "(Lcom/avito/android/remote/DomotekaTeaser;)V", "domoteka_release"}, k = 1, mv = {1, 4, 2})
public final class DomotekaTeaserResponse implements Parcelable {
    public static final Parcelable.Creator<DomotekaTeaserResponse> CREATOR = new Creator();
    @SerializedName("result")
    @Nullable
    private final DomotekaTeaser result;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DomotekaTeaserResponse> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DomotekaTeaserResponse createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new DomotekaTeaserResponse(parcel.readInt() != 0 ? DomotekaTeaser.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DomotekaTeaserResponse[] newArray(int i) {
            return new DomotekaTeaserResponse[i];
        }
    }

    public DomotekaTeaserResponse(@Nullable DomotekaTeaser domotekaTeaser) {
        this.result = domotekaTeaser;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final DomotekaTeaser getResult() {
        return this.result;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        DomotekaTeaser domotekaTeaser = this.result;
        if (domotekaTeaser != null) {
            parcel.writeInt(1);
            domotekaTeaser.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
