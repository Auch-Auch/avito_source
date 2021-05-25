package com.avito.android.item_map.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Color;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b+\u0010,J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJJ\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0011\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0017J \u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b!\u0010\"R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010#\u001a\u0004\b$\u0010\bR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010#\u001a\u0004\b%\u0010\bR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010&\u001a\u0004\b'\u0010\u0004R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010&\u001a\u0004\b(\u0010\u0004R\u001c\u0010\u0011\u001a\u00020\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010)\u001a\u0004\b*\u0010\f¨\u0006-"}, d2 = {"Lcom/avito/android/item_map/remote/model/AmenityButton;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/remote/model/Color;", "component3", "()Lcom/avito/android/remote/model/Color;", "component4", "", "component5", "()Z", "title", "type", "bgPressedColor", "bgUnpressedColor", "show", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Color;Lcom/avito/android/remote/model/Color;Z)Lcom/avito/android/item_map/remote/model/AmenityButton;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Color;", "getBgPressedColor", "getBgUnpressedColor", "Ljava/lang/String;", "getType", "getTitle", "Z", "getShow", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Color;Lcom/avito/android/remote/model/Color;Z)V", "item-map_release"}, k = 1, mv = {1, 4, 2})
public final class AmenityButton implements Parcelable {
    public static final Parcelable.Creator<AmenityButton> CREATOR = new Creator();
    @SerializedName("bgPressedColor")
    @Nullable
    private final Color bgPressedColor;
    @SerializedName("bgUnpressedColor")
    @Nullable
    private final Color bgUnpressedColor;
    @SerializedName("show")
    private final boolean show;
    @SerializedName("title")
    @Nullable
    private final String title;
    @SerializedName("type")
    @Nullable
    private final String type;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AmenityButton> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AmenityButton createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AmenityButton(parcel.readString(), parcel.readString(), (Color) parcel.readParcelable(AmenityButton.class.getClassLoader()), (Color) parcel.readParcelable(AmenityButton.class.getClassLoader()), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AmenityButton[] newArray(int i) {
            return new AmenityButton[i];
        }
    }

    public AmenityButton() {
        this(null, null, null, null, false, 31, null);
    }

    public AmenityButton(@Nullable String str, @Nullable String str2, @Nullable Color color, @Nullable Color color2, boolean z) {
        this.title = str;
        this.type = str2;
        this.bgPressedColor = color;
        this.bgUnpressedColor = color2;
        this.show = z;
    }

    public static /* synthetic */ AmenityButton copy$default(AmenityButton amenityButton, String str, String str2, Color color, Color color2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = amenityButton.title;
        }
        if ((i & 2) != 0) {
            str2 = amenityButton.type;
        }
        if ((i & 4) != 0) {
            color = amenityButton.bgPressedColor;
        }
        if ((i & 8) != 0) {
            color2 = amenityButton.bgUnpressedColor;
        }
        if ((i & 16) != 0) {
            z = amenityButton.show;
        }
        return amenityButton.copy(str, str2, color, color2, z);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final String component2() {
        return this.type;
    }

    @Nullable
    public final Color component3() {
        return this.bgPressedColor;
    }

    @Nullable
    public final Color component4() {
        return this.bgUnpressedColor;
    }

    public final boolean component5() {
        return this.show;
    }

    @NotNull
    public final AmenityButton copy(@Nullable String str, @Nullable String str2, @Nullable Color color, @Nullable Color color2, boolean z) {
        return new AmenityButton(str, str2, color, color2, z);
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
        if (!(obj instanceof AmenityButton)) {
            return false;
        }
        AmenityButton amenityButton = (AmenityButton) obj;
        return Intrinsics.areEqual(this.title, amenityButton.title) && Intrinsics.areEqual(this.type, amenityButton.type) && Intrinsics.areEqual(this.bgPressedColor, amenityButton.bgPressedColor) && Intrinsics.areEqual(this.bgUnpressedColor, amenityButton.bgUnpressedColor) && this.show == amenityButton.show;
    }

    @Nullable
    public final Color getBgPressedColor() {
        return this.bgPressedColor;
    }

    @Nullable
    public final Color getBgUnpressedColor() {
        return this.bgUnpressedColor;
    }

    public final boolean getShow() {
        return this.show;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.type;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Color color = this.bgPressedColor;
        int hashCode3 = (hashCode2 + (color != null ? color.hashCode() : 0)) * 31;
        Color color2 = this.bgUnpressedColor;
        if (color2 != null) {
            i = color2.hashCode();
        }
        int i2 = (hashCode3 + i) * 31;
        boolean z = this.show;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return i2 + i3;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AmenityButton(title=");
        L.append(this.title);
        L.append(", type=");
        L.append(this.type);
        L.append(", bgPressedColor=");
        L.append(this.bgPressedColor);
        L.append(", bgUnpressedColor=");
        L.append(this.bgUnpressedColor);
        L.append(", show=");
        return a.B(L, this.show, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.type);
        parcel.writeParcelable(this.bgPressedColor, i);
        parcel.writeParcelable(this.bgUnpressedColor, i);
        parcel.writeInt(this.show ? 1 : 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AmenityButton(String str, String str2, Color color, Color color2, boolean z, int i, j jVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : color, (i & 8) == 0 ? color2 : null, (i & 16) != 0 ? false : z);
    }
}
