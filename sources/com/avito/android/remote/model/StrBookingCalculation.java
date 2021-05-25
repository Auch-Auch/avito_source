package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/avito/android/remote/model/StrBookingCalculation;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/text/AttributedText;", "title", "Lcom/avito/android/remote/model/text/AttributedText;", "getTitle", "()Lcom/avito/android/remote/model/text/AttributedText;", "description", "getDescription", "<init>", "(Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class StrBookingCalculation implements Parcelable {
    public static final Parcelable.Creator<StrBookingCalculation> CREATOR = new Creator();
    @SerializedName("description")
    @NotNull
    private final AttributedText description;
    @SerializedName("title")
    @NotNull
    private final AttributedText title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<StrBookingCalculation> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final StrBookingCalculation createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new StrBookingCalculation((AttributedText) parcel.readParcelable(StrBookingCalculation.class.getClassLoader()), (AttributedText) parcel.readParcelable(StrBookingCalculation.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final StrBookingCalculation[] newArray(int i) {
            return new StrBookingCalculation[i];
        }
    }

    public StrBookingCalculation(@NotNull AttributedText attributedText, @NotNull AttributedText attributedText2) {
        Intrinsics.checkNotNullParameter(attributedText, "title");
        Intrinsics.checkNotNullParameter(attributedText2, "description");
        this.title = attributedText;
        this.description = attributedText2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final AttributedText getDescription() {
        return this.description;
    }

    @NotNull
    public final AttributedText getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.title, i);
        parcel.writeParcelable(this.description, i);
    }
}
