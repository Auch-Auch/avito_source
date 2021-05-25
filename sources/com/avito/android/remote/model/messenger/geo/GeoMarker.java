package com.avito.android.remote.model.messenger.geo;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.preferences.GeoContract;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJB\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0013\u0010\bJ\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0016J \u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b!\u0010\"R$\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010#\u001a\u0004\b$\u0010\fR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010%\u001a\u0004\b&\u0010\bR\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010'\u001a\u0004\b(\u0010\u0004R\u001c\u0010\u000e\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010'\u001a\u0004\b)\u0010\u0004¨\u0006,"}, d2 = {"Lcom/avito/android/remote/model/messenger/geo/GeoMarker;", "Landroid/os/Parcelable;", "", "component1", "()D", "component2", "", "component3", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/text/AttributedText;", "component4", "()Ljava/util/List;", GeoContract.LATITUDE, GeoContract.LONGITUDE, "title", "description", "copy", "(DDLjava/lang/String;Ljava/util/List;)Lcom/avito/android/remote/model/messenger/geo/GeoMarker;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getDescription", "Ljava/lang/String;", "getTitle", "D", "getLatitude", "getLongitude", "<init>", "(DDLjava/lang/String;Ljava/util/List;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class GeoMarker implements Parcelable {
    public static final Parcelable.Creator<GeoMarker> CREATOR = new Creator();
    @SerializedName("description")
    @Nullable
    private final List<AttributedText> description;
    @SerializedName("lat")
    private final double latitude;
    @SerializedName(MessageBody.Location.LONGITUDE)
    private final double longitude;
    @SerializedName("title")
    @Nullable
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<GeoMarker> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GeoMarker createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            double readDouble = parcel.readDouble();
            double readDouble2 = parcel.readDouble();
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((AttributedText) parcel.readParcelable(GeoMarker.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new GeoMarker(readDouble, readDouble2, readString, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GeoMarker[] newArray(int i) {
            return new GeoMarker[i];
        }
    }

    public GeoMarker(double d, double d2, @Nullable String str, @Nullable List<AttributedText> list) {
        this.latitude = d;
        this.longitude = d2;
        this.title = str;
        this.description = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.avito.android.remote.model.messenger.geo.GeoMarker */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GeoMarker copy$default(GeoMarker geoMarker, double d, double d2, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            d = geoMarker.latitude;
        }
        if ((i & 2) != 0) {
            d2 = geoMarker.longitude;
        }
        if ((i & 4) != 0) {
            str = geoMarker.title;
        }
        if ((i & 8) != 0) {
            list = geoMarker.description;
        }
        return geoMarker.copy(d, d2, str, list);
    }

    public final double component1() {
        return this.latitude;
    }

    public final double component2() {
        return this.longitude;
    }

    @Nullable
    public final String component3() {
        return this.title;
    }

    @Nullable
    public final List<AttributedText> component4() {
        return this.description;
    }

    @NotNull
    public final GeoMarker copy(double d, double d2, @Nullable String str, @Nullable List<AttributedText> list) {
        return new GeoMarker(d, d2, str, list);
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
        if (!(obj instanceof GeoMarker)) {
            return false;
        }
        GeoMarker geoMarker = (GeoMarker) obj;
        return Double.compare(this.latitude, geoMarker.latitude) == 0 && Double.compare(this.longitude, geoMarker.longitude) == 0 && Intrinsics.areEqual(this.title, geoMarker.title) && Intrinsics.areEqual(this.description, geoMarker.description);
    }

    @Nullable
    public final List<AttributedText> getDescription() {
        return this.description;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int a = ((b.a(this.latitude) * 31) + b.a(this.longitude)) * 31;
        String str = this.title;
        int i = 0;
        int hashCode = (a + (str != null ? str.hashCode() : 0)) * 31;
        List<AttributedText> list = this.description;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("GeoMarker(latitude=");
        L.append(this.latitude);
        L.append(", longitude=");
        L.append(this.longitude);
        L.append(", title=");
        L.append(this.title);
        L.append(", description=");
        return a.w(L, this.description, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
        parcel.writeString(this.title);
        List<AttributedText> list = this.description;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                parcel.writeParcelable((AttributedText) l0.next(), i);
            }
            return;
        }
        parcel.writeInt(0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GeoMarker(double d, double d2, String str, List list, int i, j jVar) {
        this(d, d2, str, (i & 8) != 0 ? null : list);
    }
}
