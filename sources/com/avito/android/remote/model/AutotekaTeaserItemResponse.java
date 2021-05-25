package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/model/AutotekaTeaserItemResponse;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AutotekaTeaserItemResponse implements Parcelable {
    public static final Parcelable.Creator<AutotekaTeaserItemResponse> CREATOR = new Creator();

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AutotekaTeaserItemResponse> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AutotekaTeaserItemResponse createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            if (parcel.readInt() != 0) {
                return new AutotekaTeaserItemResponse();
            }
            return null;
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AutotekaTeaserItemResponse[] newArray(int i) {
            return new AutotekaTeaserItemResponse[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(1);
    }
}
