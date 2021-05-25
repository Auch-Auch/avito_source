package com.avito.android.remote.model.messenger.geo;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.preferences.GeoContract;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b1\u00102J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\n\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u000b\u0010\bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJZ\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0018\u0010\bJ\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b \u0010\u001bJ \u0010%\u001a\u00020$2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b%\u0010&R\u001c\u0010\u000f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010'\u001a\u0004\b(\u0010\u0004R\u001c\u0010\u0012\u001a\u00020\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010)\u001a\u0004\b*\u0010\bR\u001c\u0010\u0010\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010'\u001a\u0004\b+\u0010\u0004R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010)\u001a\u0004\b,\u0010\bR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010-\u001a\u0004\b.\u0010\u000eR\u001c\u0010\u0013\u001a\u00020\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010)\u001a\u0004\b/\u0010\bR\u001c\u0010\u0011\u001a\u00020\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010)\u001a\u0004\b0\u0010\b¨\u00063"}, d2 = {"Lcom/avito/android/remote/model/messenger/geo/GeoSearchSuggest;", "Landroid/os/Parcelable;", "", "component1", "()D", "component2", "", "component3", "()Ljava/lang/String;", "component4", "component5", "component6", "", "component7", "()Ljava/lang/Boolean;", GeoContract.LATITUDE, GeoContract.LONGITUDE, MessageBody.Location.KIND, "title", "name", "description", "fromItem", "copy", "(DDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/avito/android/remote/model/messenger/geo/GeoSearchSuggest;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "D", "getLatitude", "Ljava/lang/String;", "getTitle", "getLongitude", "getDescription", "Ljava/lang/Boolean;", "getFromItem", "getName", "getKind", "<init>", "(DDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class GeoSearchSuggest implements Parcelable {
    public static final Parcelable.Creator<GeoSearchSuggest> CREATOR = new Creator();
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("fromItem")
    @Nullable
    private final Boolean fromItem;
    @SerializedName(MessageBody.Location.KIND)
    @NotNull
    private final String kind;
    @SerializedName("lat")
    private final double latitude;
    @SerializedName(MessageBody.Location.LONGITUDE)
    private final double longitude;
    @SerializedName("name")
    @NotNull
    private final String name;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<GeoSearchSuggest> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GeoSearchSuggest createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(parcel, "in");
            double readDouble = parcel.readDouble();
            double readDouble2 = parcel.readDouble();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            return new GeoSearchSuggest(readDouble, readDouble2, readString, readString2, readString3, readString4, bool);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GeoSearchSuggest[] newArray(int i) {
            return new GeoSearchSuggest[i];
        }
    }

    public GeoSearchSuggest(double d, double d2, @NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable Boolean bool) {
        a.Z0(str, MessageBody.Location.KIND, str2, "title", str3, "name");
        this.latitude = d;
        this.longitude = d2;
        this.kind = str;
        this.title = str2;
        this.name = str3;
        this.description = str4;
        this.fromItem = bool;
    }

    public static /* synthetic */ GeoSearchSuggest copy$default(GeoSearchSuggest geoSearchSuggest, double d, double d2, String str, String str2, String str3, String str4, Boolean bool, int i, Object obj) {
        return geoSearchSuggest.copy((i & 1) != 0 ? geoSearchSuggest.latitude : d, (i & 2) != 0 ? geoSearchSuggest.longitude : d2, (i & 4) != 0 ? geoSearchSuggest.kind : str, (i & 8) != 0 ? geoSearchSuggest.title : str2, (i & 16) != 0 ? geoSearchSuggest.name : str3, (i & 32) != 0 ? geoSearchSuggest.description : str4, (i & 64) != 0 ? geoSearchSuggest.fromItem : bool);
    }

    public final double component1() {
        return this.latitude;
    }

    public final double component2() {
        return this.longitude;
    }

    @NotNull
    public final String component3() {
        return this.kind;
    }

    @NotNull
    public final String component4() {
        return this.title;
    }

    @NotNull
    public final String component5() {
        return this.name;
    }

    @Nullable
    public final String component6() {
        return this.description;
    }

    @Nullable
    public final Boolean component7() {
        return this.fromItem;
    }

    @NotNull
    public final GeoSearchSuggest copy(double d, double d2, @NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(str, MessageBody.Location.KIND);
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "name");
        return new GeoSearchSuggest(d, d2, str, str2, str3, str4, bool);
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
        if (!(obj instanceof GeoSearchSuggest)) {
            return false;
        }
        GeoSearchSuggest geoSearchSuggest = (GeoSearchSuggest) obj;
        return Double.compare(this.latitude, geoSearchSuggest.latitude) == 0 && Double.compare(this.longitude, geoSearchSuggest.longitude) == 0 && Intrinsics.areEqual(this.kind, geoSearchSuggest.kind) && Intrinsics.areEqual(this.title, geoSearchSuggest.title) && Intrinsics.areEqual(this.name, geoSearchSuggest.name) && Intrinsics.areEqual(this.description, geoSearchSuggest.description) && Intrinsics.areEqual(this.fromItem, geoSearchSuggest.fromItem);
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final Boolean getFromItem() {
        return this.fromItem;
    }

    @NotNull
    public final String getKind() {
        return this.kind;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int doubleToLongBits = ((Double.doubleToLongBits(this.latitude) * 31) + Double.doubleToLongBits(this.longitude)) * 31;
        String str = this.kind;
        int i = 0;
        int hashCode = (doubleToLongBits + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.name;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.description;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Boolean bool = this.fromItem;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode4 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("GeoSearchSuggest(latitude=");
        L.append(this.latitude);
        L.append(", longitude=");
        L.append(this.longitude);
        L.append(", kind=");
        L.append(this.kind);
        L.append(", title=");
        L.append(this.title);
        L.append(", name=");
        L.append(this.name);
        L.append(", description=");
        L.append(this.description);
        L.append(", fromItem=");
        return a.o(L, this.fromItem, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        boolean z;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
        parcel.writeString(this.kind);
        parcel.writeString(this.title);
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        Boolean bool = this.fromItem;
        if (bool != null) {
            parcel.writeInt(1);
            z = bool.booleanValue();
        } else {
            z = false;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        parcel.writeInt(i2);
    }
}
