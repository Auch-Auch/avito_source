package com.avito.android.service_subscription.remote;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Color;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/service_subscription/remote/Background;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Color;", "color", "Lcom/avito/android/remote/model/Color;", "getColor", "()Lcom/avito/android/remote/model/Color;", "", "colorKey", "Ljava/lang/String;", "getColorKey", "()Ljava/lang/String;", "<init>", "(Lcom/avito/android/remote/model/Color;Ljava/lang/String;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class Background implements Parcelable {
    public static final Parcelable.Creator<Background> CREATOR = new Creator();
    @SerializedName("color")
    @NotNull
    private final Color color;
    @SerializedName("colorName")
    @Nullable
    private final String colorKey;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<Background> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Background createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new Background((Color) parcel.readParcelable(Background.class.getClassLoader()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Background[] newArray(int i) {
            return new Background[i];
        }
    }

    public Background(@NotNull Color color2, @Nullable String str) {
        Intrinsics.checkNotNullParameter(color2, "color");
        this.color = color2;
        this.colorKey = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final Color getColor() {
        return this.color;
    }

    @Nullable
    public final String getColorKey() {
        return this.colorKey;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.color, i);
        parcel.writeString(this.colorKey);
    }
}
