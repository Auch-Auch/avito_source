package com.avito.android.remote.model.search.suggest;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/avito/android/remote/model/search/suggest/GapSuggestItem;", "Lcom/avito/android/remote/model/search/suggest/SuggestItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "size", "I", "getSize", "<init>", "(I)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class GapSuggestItem extends SuggestItem {
    public static final Parcelable.Creator<GapSuggestItem> CREATOR = new Creator();
    private final int size;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<GapSuggestItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GapSuggestItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new GapSuggestItem(parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GapSuggestItem[] newArray(int i) {
            return new GapSuggestItem[i];
        }
    }

    public GapSuggestItem(int i) {
        super(null);
        this.size = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getSize() {
        return this.size;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.size);
    }
}
