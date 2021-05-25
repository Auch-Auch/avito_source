package com.avito.android.item_map.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.item.details.ParameterId;
import com.avito.android.remote.model.Color;
import com.avito.android.remote.model.Coordinates;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004JF\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0017J \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\"\u0010#R\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010$\u001a\u0004\b%\u0010\u0004R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b&\u0010\u0004R\u001c\u0010\u000f\u001a\u00020\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010'\u001a\u0004\b(\u0010\bR\u001c\u0010\u000e\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010$\u001a\u0004\b)\u0010\u0004R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010*\u001a\u0004\b+\u0010\u000b¨\u0006."}, d2 = {"Lcom/avito/android/item_map/remote/model/AmenityPin;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/remote/model/Coordinates;", "component3", "()Lcom/avito/android/remote/model/Coordinates;", "Lcom/avito/android/remote/model/Color;", "component4", "()Lcom/avito/android/remote/model/Color;", "component5", "id", "type", "coordinates", "color", "title", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Lcom/avito/android/remote/model/Color;Ljava/lang/String;)Lcom/avito/android/item_map/remote/model/AmenityPin;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getId", "getTitle", "Lcom/avito/android/remote/model/Coordinates;", "getCoordinates", "getType", "Lcom/avito/android/remote/model/Color;", "getColor", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Lcom/avito/android/remote/model/Color;Ljava/lang/String;)V", "item-map_release"}, k = 1, mv = {1, 4, 2})
public final class AmenityPin implements Parcelable {
    public static final Parcelable.Creator<AmenityPin> CREATOR = new Creator();
    @SerializedName("color")
    @Nullable
    private final Color color;
    @SerializedName(ParameterId.COORDS)
    @NotNull
    private final Coordinates coordinates;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("title")
    @Nullable
    private final String title;
    @SerializedName("type")
    @NotNull
    private final String type;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AmenityPin> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AmenityPin createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AmenityPin(parcel.readString(), parcel.readString(), (Coordinates) parcel.readParcelable(AmenityPin.class.getClassLoader()), (Color) parcel.readParcelable(AmenityPin.class.getClassLoader()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AmenityPin[] newArray(int i) {
            return new AmenityPin[i];
        }
    }

    public AmenityPin(@NotNull String str, @NotNull String str2, @NotNull Coordinates coordinates2, @Nullable Color color2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "type");
        Intrinsics.checkNotNullParameter(coordinates2, "coordinates");
        this.id = str;
        this.type = str2;
        this.coordinates = coordinates2;
        this.color = color2;
        this.title = str3;
    }

    public static /* synthetic */ AmenityPin copy$default(AmenityPin amenityPin, String str, String str2, Coordinates coordinates2, Color color2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = amenityPin.id;
        }
        if ((i & 2) != 0) {
            str2 = amenityPin.type;
        }
        if ((i & 4) != 0) {
            coordinates2 = amenityPin.coordinates;
        }
        if ((i & 8) != 0) {
            color2 = amenityPin.color;
        }
        if ((i & 16) != 0) {
            str3 = amenityPin.title;
        }
        return amenityPin.copy(str, str2, coordinates2, color2, str3);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.type;
    }

    @NotNull
    public final Coordinates component3() {
        return this.coordinates;
    }

    @Nullable
    public final Color component4() {
        return this.color;
    }

    @Nullable
    public final String component5() {
        return this.title;
    }

    @NotNull
    public final AmenityPin copy(@NotNull String str, @NotNull String str2, @NotNull Coordinates coordinates2, @Nullable Color color2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "type");
        Intrinsics.checkNotNullParameter(coordinates2, "coordinates");
        return new AmenityPin(str, str2, coordinates2, color2, str3);
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
        if (!(obj instanceof AmenityPin)) {
            return false;
        }
        AmenityPin amenityPin = (AmenityPin) obj;
        return Intrinsics.areEqual(this.id, amenityPin.id) && Intrinsics.areEqual(this.type, amenityPin.type) && Intrinsics.areEqual(this.coordinates, amenityPin.coordinates) && Intrinsics.areEqual(this.color, amenityPin.color) && Intrinsics.areEqual(this.title, amenityPin.title);
    }

    @Nullable
    public final Color getColor() {
        return this.color;
    }

    @NotNull
    public final Coordinates getCoordinates() {
        return this.coordinates;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.type;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Coordinates coordinates2 = this.coordinates;
        int hashCode3 = (hashCode2 + (coordinates2 != null ? coordinates2.hashCode() : 0)) * 31;
        Color color2 = this.color;
        int hashCode4 = (hashCode3 + (color2 != null ? color2.hashCode() : 0)) * 31;
        String str3 = this.title;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode4 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AmenityPin(id=");
        L.append(this.id);
        L.append(", type=");
        L.append(this.type);
        L.append(", coordinates=");
        L.append(this.coordinates);
        L.append(", color=");
        L.append(this.color);
        L.append(", title=");
        return a.t(L, this.title, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.type);
        parcel.writeParcelable(this.coordinates, i);
        parcel.writeParcelable(this.color, i);
        parcel.writeString(this.title);
    }
}
