package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b#\u0010$J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J4\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b \u0010\u0007R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b\"\u0010\u0004¨\u0006%"}, d2 = {"Lcom/avito/android/remote/model/UniversalColor;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Color;", "component2", "()Lcom/avito/android/remote/model/Color;", "component3", "colorKey", "colorDark", "color", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/Color;Lcom/avito/android/remote/model/Color;)Lcom/avito/android/remote/model/UniversalColor;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Color;", "getColorDark", "getColor", "Ljava/lang/String;", "getColorKey", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Color;Lcom/avito/android/remote/model/Color;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class UniversalColor implements Parcelable {
    public static final Parcelable.Creator<UniversalColor> CREATOR = new Creator();
    @SerializedName("value")
    @Nullable
    private final Color color;
    @SerializedName("valueDark")
    @Nullable
    private final Color colorDark;
    @SerializedName("valueName")
    @Nullable
    private final String colorKey;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<UniversalColor> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UniversalColor createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            Color color = null;
            Color createFromParcel = parcel.readInt() != 0 ? Color.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                color = Color.CREATOR.createFromParcel(parcel);
            }
            return new UniversalColor(readString, createFromParcel, color);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UniversalColor[] newArray(int i) {
            return new UniversalColor[i];
        }
    }

    public UniversalColor(@Nullable String str, @Nullable Color color2, @Nullable Color color3) {
        this.colorKey = str;
        this.colorDark = color2;
        this.color = color3;
    }

    public static /* synthetic */ UniversalColor copy$default(UniversalColor universalColor, String str, Color color2, Color color3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = universalColor.colorKey;
        }
        if ((i & 2) != 0) {
            color2 = universalColor.colorDark;
        }
        if ((i & 4) != 0) {
            color3 = universalColor.color;
        }
        return universalColor.copy(str, color2, color3);
    }

    @Nullable
    public final String component1() {
        return this.colorKey;
    }

    @Nullable
    public final Color component2() {
        return this.colorDark;
    }

    @Nullable
    public final Color component3() {
        return this.color;
    }

    @NotNull
    public final UniversalColor copy(@Nullable String str, @Nullable Color color2, @Nullable Color color3) {
        return new UniversalColor(str, color2, color3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UniversalColor)) {
            return false;
        }
        UniversalColor universalColor = (UniversalColor) obj;
        return Intrinsics.areEqual(this.colorKey, universalColor.colorKey) && Intrinsics.areEqual(this.colorDark, universalColor.colorDark) && Intrinsics.areEqual(this.color, universalColor.color);
    }

    @Nullable
    public final Color getColor() {
        return this.color;
    }

    @Nullable
    public final Color getColorDark() {
        return this.colorDark;
    }

    @Nullable
    public final String getColorKey() {
        return this.colorKey;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.colorKey;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Color color2 = this.colorDark;
        int hashCode2 = (hashCode + (color2 != null ? color2.hashCode() : 0)) * 31;
        Color color3 = this.color;
        if (color3 != null) {
            i = color3.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("UniversalColor(colorKey=");
        L.append(this.colorKey);
        L.append(", colorDark=");
        L.append(this.colorDark);
        L.append(", color=");
        L.append(this.color);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.colorKey);
        Color color2 = this.colorDark;
        if (color2 != null) {
            parcel.writeInt(1);
            color2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Color color3 = this.color;
        if (color3 != null) {
            parcel.writeInt(1);
            color3.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
