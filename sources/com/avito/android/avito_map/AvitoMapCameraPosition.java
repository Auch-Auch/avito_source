package com.avito.android.avito_map;

import a2.b.a.a.a;
import com.avito.android.avito_map.google.AvitoGoogleMapKt;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.maps.model.LatLng;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\b\b\u0018\u0000 /2\u00020\u0001:\u0001/B9\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJF\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0004R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\nR\u0019\u0010\u0010\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010 \u001a\u0004\b)\u0010\u0007R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\r¨\u00060"}, d2 = {"Lcom/avito/android/avito_map/AvitoMapCameraPosition;", "", "Lcom/avito/android/avito_map/AvitoMapPoint;", "component1", "()Lcom/avito/android/avito_map/AvitoMapPoint;", "", "component2", "()F", "component3", "component4", "()Ljava/lang/Float;", "Lcom/avito/android/avito_map/AvitoMapBounds;", "component5", "()Lcom/avito/android/avito_map/AvitoMapBounds;", "mapPoint", "zoomLevel", "tilt", "azimuth", "viewportBounds", "copy", "(Lcom/avito/android/avito_map/AvitoMapPoint;FFLjava/lang/Float;Lcom/avito/android/avito_map/AvitoMapBounds;)Lcom/avito/android/avito_map/AvitoMapCameraPosition;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "F", "getZoomLevel", AuthSource.SEND_ABUSE, "Lcom/avito/android/avito_map/AvitoMapPoint;", "getMapPoint", "d", "Ljava/lang/Float;", "getAzimuth", "c", "getTilt", "e", "Lcom/avito/android/avito_map/AvitoMapBounds;", "getViewportBounds", "<init>", "(Lcom/avito/android/avito_map/AvitoMapPoint;FFLjava/lang/Float;Lcom/avito/android/avito_map/AvitoMapBounds;)V", "Companion", "avito-map_release"}, k = 1, mv = {1, 4, 2})
public final class AvitoMapCameraPosition {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final AvitoMapPoint a;
    public final float b;
    public final float c;
    @Nullable
    public final Float d;
    @Nullable
    public final AvitoMapBounds e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/avito_map/AvitoMapCameraPosition$Companion;", "", "Lcom/google/android/gms/maps/model/LatLng;", "latLng", "", "zoomLevel", "Lcom/avito/android/avito_map/AvitoMapCameraPosition;", "fromLatLngZoom", "(Lcom/google/android/gms/maps/model/LatLng;F)Lcom/avito/android/avito_map/AvitoMapCameraPosition;", "<init>", "()V", "avito-map_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final AvitoMapCameraPosition fromLatLngZoom(@NotNull LatLng latLng, float f) {
            Intrinsics.checkNotNullParameter(latLng, "latLng");
            return new AvitoMapCameraPosition(AvitoGoogleMapKt.toAvitoMapPoint(latLng), f, 0.0f, null, null, 24, null);
        }

        public Companion(j jVar) {
        }
    }

    public AvitoMapCameraPosition(@NotNull AvitoMapPoint avitoMapPoint, float f, float f2, @Nullable Float f3, @Nullable AvitoMapBounds avitoMapBounds) {
        Intrinsics.checkNotNullParameter(avitoMapPoint, "mapPoint");
        this.a = avitoMapPoint;
        this.b = f;
        this.c = f2;
        this.d = f3;
        this.e = avitoMapBounds;
    }

    public static /* synthetic */ AvitoMapCameraPosition copy$default(AvitoMapCameraPosition avitoMapCameraPosition, AvitoMapPoint avitoMapPoint, float f, float f2, Float f3, AvitoMapBounds avitoMapBounds, int i, Object obj) {
        if ((i & 1) != 0) {
            avitoMapPoint = avitoMapCameraPosition.a;
        }
        if ((i & 2) != 0) {
            f = avitoMapCameraPosition.b;
        }
        if ((i & 4) != 0) {
            f2 = avitoMapCameraPosition.c;
        }
        if ((i & 8) != 0) {
            f3 = avitoMapCameraPosition.d;
        }
        if ((i & 16) != 0) {
            avitoMapBounds = avitoMapCameraPosition.e;
        }
        return avitoMapCameraPosition.copy(avitoMapPoint, f, f2, f3, avitoMapBounds);
    }

    @NotNull
    public final AvitoMapPoint component1() {
        return this.a;
    }

    public final float component2() {
        return this.b;
    }

    public final float component3() {
        return this.c;
    }

    @Nullable
    public final Float component4() {
        return this.d;
    }

    @Nullable
    public final AvitoMapBounds component5() {
        return this.e;
    }

    @NotNull
    public final AvitoMapCameraPosition copy(@NotNull AvitoMapPoint avitoMapPoint, float f, float f2, @Nullable Float f3, @Nullable AvitoMapBounds avitoMapBounds) {
        Intrinsics.checkNotNullParameter(avitoMapPoint, "mapPoint");
        return new AvitoMapCameraPosition(avitoMapPoint, f, f2, f3, avitoMapBounds);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AvitoMapCameraPosition)) {
            return false;
        }
        AvitoMapCameraPosition avitoMapCameraPosition = (AvitoMapCameraPosition) obj;
        return Intrinsics.areEqual(this.a, avitoMapCameraPosition.a) && Float.compare(this.b, avitoMapCameraPosition.b) == 0 && Float.compare(this.c, avitoMapCameraPosition.c) == 0 && Intrinsics.areEqual(this.d, avitoMapCameraPosition.d) && Intrinsics.areEqual(this.e, avitoMapCameraPosition.e);
    }

    @Nullable
    public final Float getAzimuth() {
        return this.d;
    }

    @NotNull
    public final AvitoMapPoint getMapPoint() {
        return this.a;
    }

    public final float getTilt() {
        return this.c;
    }

    @Nullable
    public final AvitoMapBounds getViewportBounds() {
        return this.e;
    }

    public final float getZoomLevel() {
        return this.b;
    }

    public int hashCode() {
        AvitoMapPoint avitoMapPoint = this.a;
        int i = 0;
        int i1 = a.i1(this.c, a.i1(this.b, (avitoMapPoint != null ? avitoMapPoint.hashCode() : 0) * 31, 31), 31);
        Float f = this.d;
        int hashCode = (i1 + (f != null ? f.hashCode() : 0)) * 31;
        AvitoMapBounds avitoMapBounds = this.e;
        if (avitoMapBounds != null) {
            i = avitoMapBounds.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("AvitoMapCameraPosition(mapPoint=");
        L.append(this.a);
        L.append(", zoomLevel=");
        L.append(this.b);
        L.append(", tilt=");
        L.append(this.c);
        L.append(", azimuth=");
        L.append(this.d);
        L.append(", viewportBounds=");
        L.append(this.e);
        L.append(")");
        return L.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AvitoMapCameraPosition(AvitoMapPoint avitoMapPoint, float f, float f2, Float f3, AvitoMapBounds avitoMapBounds, int i, j jVar) {
        this(avitoMapPoint, f, (i & 4) != 0 ? 0.0f : f2, (i & 8) != 0 ? null : f3, (i & 16) != 0 ? null : avitoMapBounds);
    }
}
