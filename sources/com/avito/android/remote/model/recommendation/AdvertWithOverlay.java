package com.avito.android.remote.model.recommendation;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.AdvertImage;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0017B\u001b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/remote/model/recommendation/AdvertWithOverlay;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/recommendation/AdvertWithOverlay$Overlay;", "overlay", "Lcom/avito/android/remote/model/recommendation/AdvertWithOverlay$Overlay;", "getOverlay", "()Lcom/avito/android/remote/model/recommendation/AdvertWithOverlay$Overlay;", "Lcom/avito/android/remote/model/AdvertImage;", "image", "Lcom/avito/android/remote/model/AdvertImage;", "getImage", "()Lcom/avito/android/remote/model/AdvertImage;", "<init>", "(Lcom/avito/android/remote/model/recommendation/AdvertWithOverlay$Overlay;Lcom/avito/android/remote/model/AdvertImage;)V", "Overlay", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertWithOverlay implements Parcelable {
    public static final Parcelable.Creator<AdvertWithOverlay> CREATOR = new Creator();
    @SerializedName("images")
    @Nullable
    private final AdvertImage image;
    @SerializedName("overlay")
    @Nullable
    private final Overlay overlay;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertWithOverlay> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertWithOverlay createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AdvertWithOverlay(parcel.readInt() != 0 ? Overlay.CREATOR.createFromParcel(parcel) : null, (AdvertImage) parcel.readParcelable(AdvertWithOverlay.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertWithOverlay[] newArray(int i) {
            return new AdvertWithOverlay[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/avito/android/remote/model/recommendation/AdvertWithOverlay$Overlay;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", MessengerShareContentUtility.SUBTITLE, "getSubtitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
    public static final class Overlay implements Parcelable {
        public static final Parcelable.Creator<Overlay> CREATOR = new Creator();
        @SerializedName(MessengerShareContentUtility.SUBTITLE)
        @Nullable
        private final String subtitle;
        @SerializedName("title")
        @Nullable
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Overlay> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Overlay createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Overlay(parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Overlay[] newArray(int i) {
                return new Overlay[i];
            }
        }

        public Overlay(@Nullable String str, @Nullable String str2) {
            this.title = str;
            this.subtitle = str2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final String getSubtitle() {
            return this.subtitle;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeString(this.subtitle);
        }
    }

    public AdvertWithOverlay(@Nullable Overlay overlay2, @Nullable AdvertImage advertImage) {
        this.overlay = overlay2;
        this.image = advertImage;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final AdvertImage getImage() {
        return this.image;
    }

    @Nullable
    public final Overlay getOverlay() {
        return this.overlay;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Overlay overlay2 = this.overlay;
        if (overlay2 != null) {
            parcel.writeInt(1);
            overlay2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.image, i);
    }
}
