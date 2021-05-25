package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/model/FailurePhoneResponse;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/PhoneResponse;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/DialogInfo;", "dialogInfo", "Lcom/avito/android/remote/model/DialogInfo;", "getDialogInfo", "()Lcom/avito/android/remote/model/DialogInfo;", "<init>", "(Lcom/avito/android/remote/model/DialogInfo;)V", "async-phone_release"}, k = 1, mv = {1, 4, 2})
public final class FailurePhoneResponse extends PhoneResponse implements Parcelable {
    public static final Parcelable.Creator<FailurePhoneResponse> CREATOR = new Creator();
    @SerializedName("dialog")
    @NotNull
    private final DialogInfo dialogInfo;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<FailurePhoneResponse> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FailurePhoneResponse createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new FailurePhoneResponse((DialogInfo) parcel.readParcelable(FailurePhoneResponse.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FailurePhoneResponse[] newArray(int i) {
            return new FailurePhoneResponse[i];
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FailurePhoneResponse(@NotNull DialogInfo dialogInfo2) {
        super(null);
        Intrinsics.checkNotNullParameter(dialogInfo2, "dialogInfo");
        this.dialogInfo = dialogInfo2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final DialogInfo getDialogInfo() {
        return this.dialogInfo;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.dialogInfo, i);
    }
}
