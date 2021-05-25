package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/model/ExtendedProfileAdvertsNextPageResult;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/ExtendedProfileCategoryAdverts;", "items", "Lcom/avito/android/remote/model/ExtendedProfileCategoryAdverts;", "getItems", "()Lcom/avito/android/remote/model/ExtendedProfileCategoryAdverts;", "<init>", "(Lcom/avito/android/remote/model/ExtendedProfileCategoryAdverts;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ExtendedProfileAdvertsNextPageResult implements Parcelable {
    public static final Parcelable.Creator<ExtendedProfileAdvertsNextPageResult> CREATOR = new Creator();
    @SerializedName("items")
    @NotNull
    private final ExtendedProfileCategoryAdverts items;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ExtendedProfileAdvertsNextPageResult> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ExtendedProfileAdvertsNextPageResult createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ExtendedProfileAdvertsNextPageResult(ExtendedProfileCategoryAdverts.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ExtendedProfileAdvertsNextPageResult[] newArray(int i) {
            return new ExtendedProfileAdvertsNextPageResult[i];
        }
    }

    public ExtendedProfileAdvertsNextPageResult(@NotNull ExtendedProfileCategoryAdverts extendedProfileCategoryAdverts) {
        Intrinsics.checkNotNullParameter(extendedProfileCategoryAdverts, "items");
        this.items = extendedProfileCategoryAdverts;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final ExtendedProfileCategoryAdverts getItems() {
        return this.items;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.items.writeToParcel(parcel, 0);
    }
}
