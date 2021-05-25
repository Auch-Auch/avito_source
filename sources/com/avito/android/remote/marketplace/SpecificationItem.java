package com.avito.android.remote.marketplace;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/avito/android/remote/marketplace/SpecificationItem;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/text/AttributedText;", "attributedText", "Lcom/avito/android/remote/model/text/AttributedText;", "getAttributedText", "()Lcom/avito/android/remote/model/text/AttributedText;", "name", "getName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class SpecificationItem implements Parcelable {
    public static final Parcelable.Creator<SpecificationItem> CREATOR = new Creator();
    @SerializedName("specificationAttributed")
    @Nullable
    private final AttributedText attributedText;
    @SerializedName("name")
    @Nullable
    private final String name;
    @SerializedName("value")
    @Nullable
    private final String value;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SpecificationItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SpecificationItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SpecificationItem(parcel.readString(), parcel.readString(), (AttributedText) parcel.readParcelable(SpecificationItem.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SpecificationItem[] newArray(int i) {
            return new SpecificationItem[i];
        }
    }

    public SpecificationItem(@Nullable String str, @Nullable String str2, @Nullable AttributedText attributedText2) {
        this.name = str;
        this.value = str2;
        this.attributedText = attributedText2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final AttributedText getAttributedText() {
        return this.attributedText;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getValue() {
        return this.value;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.name);
        parcel.writeString(this.value);
        parcel.writeParcelable(this.attributedText, i);
    }
}
