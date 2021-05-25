package com.avito.android.remote.model.search.suggest;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/search/suggest/TitleSuggestItem;", "Lcom/avito/android/remote/model/search/suggest/SuggestItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/search/suggest/Padding;", "padding", "Lcom/avito/android/remote/model/search/suggest/Padding;", "getPadding", "()Lcom/avito/android/remote/model/search/suggest/Padding;", "<init>", "(Lcom/avito/android/remote/model/search/suggest/Padding;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class TitleSuggestItem extends SuggestItem {
    public static final Parcelable.Creator<TitleSuggestItem> CREATOR = new Creator();
    @SerializedName("padding")
    @Nullable
    private final Padding padding;
    @SerializedName("text")
    @NotNull
    private final String text;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<TitleSuggestItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TitleSuggestItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new TitleSuggestItem(parcel.readInt() != 0 ? Padding.CREATOR.createFromParcel(parcel) : null, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TitleSuggestItem[] newArray(int i) {
            return new TitleSuggestItem[i];
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TitleSuggestItem(@Nullable Padding padding2, @NotNull String str) {
        super(null);
        Intrinsics.checkNotNullParameter(str, "text");
        this.padding = padding2;
        this.text = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Padding getPadding() {
        return this.padding;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Padding padding2 = this.padding;
        if (padding2 != null) {
            parcel.writeInt(1);
            padding2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.text);
    }
}
