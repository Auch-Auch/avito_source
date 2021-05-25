package com.avito.android.avito_map;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.GeoContract;
import com.google.android.gms.maps.model.LatLng;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u0000 '2\u00020\u0001:\u0001'B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b$\u0010%B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b$\u0010&J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J$\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0019\u0010\nJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0012\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0010R\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010 \u001a\u0004\b#\u0010\u0010¨\u0006("}, d2 = {"Lcom/avito/android/avito_map/AvitoMapPoint;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Lcom/google/android/gms/maps/model/LatLng;", "toLatLng", "()Lcom/google/android/gms/maps/model/LatLng;", "", "component1", "()D", "component2", GeoContract.LATITUDE, GeoContract.LONGITUDE, "copy", "(DD)Lcom/avito/android/avito_map/AvitoMapPoint;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "D", "getLatitude", AuthSource.BOOKING_ORDER, "getLongitude", "<init>", "(DD)V", "(Landroid/os/Parcel;)V", "CREATOR", "avito-map_release"}, k = 1, mv = {1, 4, 2})
public final class AvitoMapPoint implements Parcelable {
    @NotNull
    public static final CREATOR CREATOR = new CREATOR(null);
    public final double a;
    public final double b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/avito_map/AvitoMapPoint$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/avito_map/AvitoMapPoint;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/avito_map/AvitoMapPoint;", "", "size", "", "newArray", "(I)[Lcom/avito/android/avito_map/AvitoMapPoint;", "<init>", "()V", "avito-map_release"}, k = 1, mv = {1, 4, 2})
    public static final class CREATOR implements Parcelable.Creator<AvitoMapPoint> {
        public CREATOR() {
        }

        public CREATOR(j jVar) {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public AvitoMapPoint createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AvitoMapPoint(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public AvitoMapPoint[] newArray(int i) {
            return new AvitoMapPoint[i];
        }
    }

    public AvitoMapPoint(double d, double d2) {
        this.a = d;
        this.b = d2;
    }

    public static /* synthetic */ AvitoMapPoint copy$default(AvitoMapPoint avitoMapPoint, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = avitoMapPoint.a;
        }
        if ((i & 2) != 0) {
            d2 = avitoMapPoint.b;
        }
        return avitoMapPoint.copy(d, d2);
    }

    public final double component1() {
        return this.a;
    }

    public final double component2() {
        return this.b;
    }

    @NotNull
    public final AvitoMapPoint copy(double d, double d2) {
        return new AvitoMapPoint(d, d2);
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
        if (!(obj instanceof AvitoMapPoint)) {
            return false;
        }
        AvitoMapPoint avitoMapPoint = (AvitoMapPoint) obj;
        return Double.compare(this.a, avitoMapPoint.a) == 0 && Double.compare(this.b, avitoMapPoint.b) == 0;
    }

    public final double getLatitude() {
        return this.a;
    }

    public final double getLongitude() {
        return this.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (b.a(this.a) * 31) + b.a(this.b);
    }

    @NotNull
    public final LatLng toLatLng() {
        return new LatLng(this.a, this.b);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AvitoMapPoint(latitude=");
        L.append(this.a);
        L.append(", longitude=");
        L.append(this.b);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeDouble(this.a);
        parcel.writeDouble(this.b);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AvitoMapPoint(@NotNull Parcel parcel) {
        this(parcel.readDouble(), parcel.readDouble());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }
}
