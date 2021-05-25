package com.avito.android.remote.model.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/search/InlineFilters;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "status", "Ljava/lang/String;", "getStatus", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/search/Result;", "result", "Lcom/avito/android/remote/model/search/Result;", "getResult", "()Lcom/avito/android/remote/model/search/Result;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/search/Result;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class InlineFilters implements Parcelable {
    public static final Parcelable.Creator<InlineFilters> CREATOR = new Creator();
    @SerializedName("result")
    @Nullable
    private final Result result;
    @SerializedName("status")
    @Nullable
    private final String status;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<InlineFilters> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final InlineFilters createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new InlineFilters(parcel.readString(), parcel.readInt() != 0 ? Result.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final InlineFilters[] newArray(int i) {
            return new InlineFilters[i];
        }
    }

    public InlineFilters(@Nullable String str, @Nullable Result result2) {
        this.status = str;
        this.result = result2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Result getResult() {
        return this.result;
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.status);
        Result result2 = this.result;
        if (result2 != null) {
            parcel.writeInt(1);
            result2.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
