package com.avito.android.remote.model;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/model/ForegroundImage;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/text/AttributedText;", "title", "Lcom/avito/android/remote/model/text/AttributedText;", "getTitle", "()Lcom/avito/android/remote/model/text/AttributedText;", "Lcom/avito/android/remote/model/UniversalColor;", "dimColor", "Lcom/avito/android/remote/model/UniversalColor;", "getDimColor", "()Lcom/avito/android/remote/model/UniversalColor;", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "<init>", "(Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/Image;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ForegroundImage implements Parcelable {
    public static final Parcelable.Creator<ForegroundImage> CREATOR = new Creator();
    @SerializedName("dimColor")
    @NotNull
    private final UniversalColor dimColor;
    @SerializedName("image")
    @Nullable
    private final Image image;
    @SerializedName("title")
    @NotNull
    private final AttributedText title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ForegroundImage> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ForegroundImage createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ForegroundImage((AttributedText) parcel.readParcelable(ForegroundImage.class.getClassLoader()), UniversalColor.CREATOR.createFromParcel(parcel), (Image) parcel.readParcelable(ForegroundImage.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ForegroundImage[] newArray(int i) {
            return new ForegroundImage[i];
        }
    }

    public ForegroundImage(@NotNull AttributedText attributedText, @NotNull UniversalColor universalColor, @Nullable Image image2) {
        Intrinsics.checkNotNullParameter(attributedText, "title");
        Intrinsics.checkNotNullParameter(universalColor, "dimColor");
        this.title = attributedText;
        this.dimColor = universalColor;
        this.image = image2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final UniversalColor getDimColor() {
        return this.dimColor;
    }

    @Nullable
    public final Image getImage() {
        return this.image;
    }

    @NotNull
    public final AttributedText getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.title, i);
        this.dimColor.writeToParcel(parcel, 0);
        parcel.writeParcelable(this.image, i);
    }
}
