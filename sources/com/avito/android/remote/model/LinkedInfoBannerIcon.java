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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001:\u0001$B\u0019\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\t\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b!\u0010\u0004¨\u0006%"}, d2 = {"Lcom/avito/android/remote/model/LinkedInfoBannerIcon;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/LinkedInfoBannerIcon$Type;", "component1", "()Lcom/avito/android/remote/model/LinkedInfoBannerIcon$Type;", "Lcom/avito/android/remote/model/UniversalColor;", "component2", "()Lcom/avito/android/remote/model/UniversalColor;", "type", "color", "copy", "(Lcom/avito/android/remote/model/LinkedInfoBannerIcon$Type;Lcom/avito/android/remote/model/UniversalColor;)Lcom/avito/android/remote/model/LinkedInfoBannerIcon;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/UniversalColor;", "getColor", "Lcom/avito/android/remote/model/LinkedInfoBannerIcon$Type;", "getType", "<init>", "(Lcom/avito/android/remote/model/LinkedInfoBannerIcon$Type;Lcom/avito/android/remote/model/UniversalColor;)V", "Type", "models_release"}, k = 1, mv = {1, 4, 2})
public final class LinkedInfoBannerIcon implements Parcelable {
    public static final Parcelable.Creator<LinkedInfoBannerIcon> CREATOR = new Creator();
    @SerializedName("color")
    @NotNull
    private final UniversalColor color;
    @SerializedName("type")
    @Nullable
    private final Type type;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<LinkedInfoBannerIcon> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LinkedInfoBannerIcon createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new LinkedInfoBannerIcon(parcel.readInt() != 0 ? (Type) Enum.valueOf(Type.class, parcel.readString()) : null, UniversalColor.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LinkedInfoBannerIcon[] newArray(int i) {
            return new LinkedInfoBannerIcon[i];
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/LinkedInfoBannerIcon$Type;", "", "<init>", "(Ljava/lang/String;I)V", "ATTENTION", "ARROW_TOP_RIGHT", "ARROW_BOTTOM_RIGHT", "WALLET", "models_release"}, k = 1, mv = {1, 4, 2})
    public enum Type {
        ATTENTION,
        ARROW_TOP_RIGHT,
        ARROW_BOTTOM_RIGHT,
        WALLET
    }

    public LinkedInfoBannerIcon(@Nullable Type type2, @NotNull UniversalColor universalColor) {
        Intrinsics.checkNotNullParameter(universalColor, "color");
        this.type = type2;
        this.color = universalColor;
    }

    public static /* synthetic */ LinkedInfoBannerIcon copy$default(LinkedInfoBannerIcon linkedInfoBannerIcon, Type type2, UniversalColor universalColor, int i, Object obj) {
        if ((i & 1) != 0) {
            type2 = linkedInfoBannerIcon.type;
        }
        if ((i & 2) != 0) {
            universalColor = linkedInfoBannerIcon.color;
        }
        return linkedInfoBannerIcon.copy(type2, universalColor);
    }

    @Nullable
    public final Type component1() {
        return this.type;
    }

    @NotNull
    public final UniversalColor component2() {
        return this.color;
    }

    @NotNull
    public final LinkedInfoBannerIcon copy(@Nullable Type type2, @NotNull UniversalColor universalColor) {
        Intrinsics.checkNotNullParameter(universalColor, "color");
        return new LinkedInfoBannerIcon(type2, universalColor);
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
        if (!(obj instanceof LinkedInfoBannerIcon)) {
            return false;
        }
        LinkedInfoBannerIcon linkedInfoBannerIcon = (LinkedInfoBannerIcon) obj;
        return Intrinsics.areEqual(this.type, linkedInfoBannerIcon.type) && Intrinsics.areEqual(this.color, linkedInfoBannerIcon.color);
    }

    @NotNull
    public final UniversalColor getColor() {
        return this.color;
    }

    @Nullable
    public final Type getType() {
        return this.type;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Type type2 = this.type;
        int i = 0;
        int hashCode = (type2 != null ? type2.hashCode() : 0) * 31;
        UniversalColor universalColor = this.color;
        if (universalColor != null) {
            i = universalColor.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("LinkedInfoBannerIcon(type=");
        L.append(this.type);
        L.append(", color=");
        L.append(this.color);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Type type2 = this.type;
        if (type2 != null) {
            parcel.writeInt(1);
            parcel.writeString(type2.name());
        } else {
            parcel.writeInt(0);
        }
        this.color.writeToParcel(parcel, 0);
    }
}
