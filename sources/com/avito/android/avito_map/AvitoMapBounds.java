package com.avito.android.avito_map;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.maps.model.LatLngBounds;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\r\b\b\u0018\u0000 '2\u00020\u0001:\u0001'B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u000b¢\u0006\u0004\b$\u0010%B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b$\u0010&J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011J$\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001a\u0010\nJ\u001a\u0010\u001d\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0011R\u0019\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010 \u001a\u0004\b#\u0010\u0011¨\u0006("}, d2 = {"Lcom/avito/android/avito_map/AvitoMapBounds;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Lcom/avito/android/avito_map/AvitoMapPoint;", "point", "", "contains", "(Lcom/avito/android/avito_map/AvitoMapPoint;)Z", "component1", "()Lcom/avito/android/avito_map/AvitoMapPoint;", "component2", "topLeft", "bottomRight", "copy", "(Lcom/avito/android/avito_map/AvitoMapPoint;Lcom/avito/android/avito_map/AvitoMapPoint;)Lcom/avito/android/avito_map/AvitoMapBounds;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/avito_map/AvitoMapPoint;", "getTopLeft", AuthSource.BOOKING_ORDER, "getBottomRight", "<init>", "(Lcom/avito/android/avito_map/AvitoMapPoint;Lcom/avito/android/avito_map/AvitoMapPoint;)V", "(Landroid/os/Parcel;)V", "CREATOR", "avito-map_release"}, k = 1, mv = {1, 4, 2})
public final class AvitoMapBounds implements Parcelable {
    @NotNull
    public static final CREATOR CREATOR = new CREATOR(null);
    @NotNull
    public final AvitoMapPoint a;
    @NotNull
    public final AvitoMapPoint b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/avito_map/AvitoMapBounds$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/avito_map/AvitoMapBounds;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/avito_map/AvitoMapBounds;", "", "size", "", "newArray", "(I)[Lcom/avito/android/avito_map/AvitoMapBounds;", "Lcom/google/android/gms/maps/model/LatLngBounds;", "latLngBounds", "fromLatLngBounds", "(Lcom/google/android/gms/maps/model/LatLngBounds;)Lcom/avito/android/avito_map/AvitoMapBounds;", "<init>", "()V", "avito-map_release"}, k = 1, mv = {1, 4, 2})
    public static final class CREATOR implements Parcelable.Creator<AvitoMapBounds> {
        public CREATOR() {
        }

        @NotNull
        public final AvitoMapBounds fromLatLngBounds(@NotNull LatLngBounds latLngBounds) {
            Intrinsics.checkNotNullParameter(latLngBounds, "latLngBounds");
            return new AvitoMapBounds(new AvitoMapPoint(latLngBounds.northeast.latitude, latLngBounds.southwest.longitude), new AvitoMapPoint(latLngBounds.southwest.latitude, latLngBounds.northeast.longitude));
        }

        public CREATOR(j jVar) {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public AvitoMapBounds createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AvitoMapBounds(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public AvitoMapBounds[] newArray(int i) {
            return new AvitoMapBounds[i];
        }
    }

    public AvitoMapBounds(@NotNull AvitoMapPoint avitoMapPoint, @NotNull AvitoMapPoint avitoMapPoint2) {
        Intrinsics.checkNotNullParameter(avitoMapPoint, "topLeft");
        Intrinsics.checkNotNullParameter(avitoMapPoint2, "bottomRight");
        this.a = avitoMapPoint;
        this.b = avitoMapPoint2;
    }

    public static /* synthetic */ AvitoMapBounds copy$default(AvitoMapBounds avitoMapBounds, AvitoMapPoint avitoMapPoint, AvitoMapPoint avitoMapPoint2, int i, Object obj) {
        if ((i & 1) != 0) {
            avitoMapPoint = avitoMapBounds.a;
        }
        if ((i & 2) != 0) {
            avitoMapPoint2 = avitoMapBounds.b;
        }
        return avitoMapBounds.copy(avitoMapPoint, avitoMapPoint2);
    }

    @NotNull
    public final AvitoMapPoint component1() {
        return this.a;
    }

    @NotNull
    public final AvitoMapPoint component2() {
        return this.b;
    }

    public final boolean contains(@NotNull AvitoMapPoint avitoMapPoint) {
        Intrinsics.checkNotNullParameter(avitoMapPoint, "point");
        return avitoMapPoint.getLatitude() <= this.a.getLatitude() && avitoMapPoint.getLatitude() >= this.b.getLatitude() && avitoMapPoint.getLongitude() <= this.b.getLongitude() && avitoMapPoint.getLongitude() >= this.a.getLongitude();
    }

    @NotNull
    public final AvitoMapBounds copy(@NotNull AvitoMapPoint avitoMapPoint, @NotNull AvitoMapPoint avitoMapPoint2) {
        Intrinsics.checkNotNullParameter(avitoMapPoint, "topLeft");
        Intrinsics.checkNotNullParameter(avitoMapPoint2, "bottomRight");
        return new AvitoMapBounds(avitoMapPoint, avitoMapPoint2);
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
        if (!(obj instanceof AvitoMapBounds)) {
            return false;
        }
        AvitoMapBounds avitoMapBounds = (AvitoMapBounds) obj;
        return Intrinsics.areEqual(this.a, avitoMapBounds.a) && Intrinsics.areEqual(this.b, avitoMapBounds.b);
    }

    @NotNull
    public final AvitoMapPoint getBottomRight() {
        return this.b;
    }

    @NotNull
    public final AvitoMapPoint getTopLeft() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        AvitoMapPoint avitoMapPoint = this.a;
        int i = 0;
        int hashCode = (avitoMapPoint != null ? avitoMapPoint.hashCode() : 0) * 31;
        AvitoMapPoint avitoMapPoint2 = this.b;
        if (avitoMapPoint2 != null) {
            i = avitoMapPoint2.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AvitoMapBounds(topLeft=");
        L.append(this.a);
        L.append(", bottomRight=");
        L.append(this.b);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.a, i);
        parcel.writeParcelable(this.b, i);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AvitoMapBounds(@org.jetbrains.annotations.NotNull android.os.Parcel r3) {
        /*
            r2 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.Class<com.avito.android.avito_map.AvitoMapPoint> r0 = com.avito.android.avito_map.AvitoMapPoint.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            android.os.Parcelable r0 = r3.readParcelable(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            com.avito.android.avito_map.AvitoMapPoint r0 = (com.avito.android.avito_map.AvitoMapPoint) r0
            java.lang.Class<com.avito.android.avito_map.AvitoMapPoint> r1 = com.avito.android.avito_map.AvitoMapPoint.class
            android.os.Parcelable r3 = a2.b.a.a.a.z1(r1, r3)
            com.avito.android.avito_map.AvitoMapPoint r3 = (com.avito.android.avito_map.AvitoMapPoint) r3
            r2.<init>(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.avito_map.AvitoMapBounds.<init>(android.os.Parcel):void");
    }
}
