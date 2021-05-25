package com.avito.android.avito_map;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b#\u0010$J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ4\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\n¨\u0006%"}, d2 = {"Lcom/avito/android/avito_map/AvitoMapCameraUpdate;", "", "Lcom/avito/android/avito_map/AvitoMapCameraPosition;", "component1", "()Lcom/avito/android/avito_map/AvitoMapCameraPosition;", "Lcom/avito/android/avito_map/AvitoMapBounds;", "component2", "()Lcom/avito/android/avito_map/AvitoMapBounds;", "Lcom/avito/android/avito_map/PointsWithOffset;", "component3", "()Lcom/avito/android/avito_map/PointsWithOffset;", "cameraPosition", "bounds", "boundsByPoints", "copy", "(Lcom/avito/android/avito_map/AvitoMapCameraPosition;Lcom/avito/android/avito_map/AvitoMapBounds;Lcom/avito/android/avito_map/PointsWithOffset;)Lcom/avito/android/avito_map/AvitoMapCameraUpdate;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/avito_map/AvitoMapBounds;", "getBounds", AuthSource.SEND_ABUSE, "Lcom/avito/android/avito_map/AvitoMapCameraPosition;", "getCameraPosition", "c", "Lcom/avito/android/avito_map/PointsWithOffset;", "getBoundsByPoints", "<init>", "(Lcom/avito/android/avito_map/AvitoMapCameraPosition;Lcom/avito/android/avito_map/AvitoMapBounds;Lcom/avito/android/avito_map/PointsWithOffset;)V", "avito-map_release"}, k = 1, mv = {1, 4, 2})
public final class AvitoMapCameraUpdate {
    @Nullable
    public final AvitoMapCameraPosition a;
    @Nullable
    public final AvitoMapBounds b;
    @Nullable
    public final PointsWithOffset c;

    public AvitoMapCameraUpdate() {
        this(null, null, null, 7, null);
    }

    public AvitoMapCameraUpdate(@Nullable AvitoMapCameraPosition avitoMapCameraPosition, @Nullable AvitoMapBounds avitoMapBounds, @Nullable PointsWithOffset pointsWithOffset) {
        this.a = avitoMapCameraPosition;
        this.b = avitoMapBounds;
        this.c = pointsWithOffset;
    }

    public static /* synthetic */ AvitoMapCameraUpdate copy$default(AvitoMapCameraUpdate avitoMapCameraUpdate, AvitoMapCameraPosition avitoMapCameraPosition, AvitoMapBounds avitoMapBounds, PointsWithOffset pointsWithOffset, int i, Object obj) {
        if ((i & 1) != 0) {
            avitoMapCameraPosition = avitoMapCameraUpdate.a;
        }
        if ((i & 2) != 0) {
            avitoMapBounds = avitoMapCameraUpdate.b;
        }
        if ((i & 4) != 0) {
            pointsWithOffset = avitoMapCameraUpdate.c;
        }
        return avitoMapCameraUpdate.copy(avitoMapCameraPosition, avitoMapBounds, pointsWithOffset);
    }

    @Nullable
    public final AvitoMapCameraPosition component1() {
        return this.a;
    }

    @Nullable
    public final AvitoMapBounds component2() {
        return this.b;
    }

    @Nullable
    public final PointsWithOffset component3() {
        return this.c;
    }

    @NotNull
    public final AvitoMapCameraUpdate copy(@Nullable AvitoMapCameraPosition avitoMapCameraPosition, @Nullable AvitoMapBounds avitoMapBounds, @Nullable PointsWithOffset pointsWithOffset) {
        return new AvitoMapCameraUpdate(avitoMapCameraPosition, avitoMapBounds, pointsWithOffset);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AvitoMapCameraUpdate)) {
            return false;
        }
        AvitoMapCameraUpdate avitoMapCameraUpdate = (AvitoMapCameraUpdate) obj;
        return Intrinsics.areEqual(this.a, avitoMapCameraUpdate.a) && Intrinsics.areEqual(this.b, avitoMapCameraUpdate.b) && Intrinsics.areEqual(this.c, avitoMapCameraUpdate.c);
    }

    @Nullable
    public final AvitoMapBounds getBounds() {
        return this.b;
    }

    @Nullable
    public final PointsWithOffset getBoundsByPoints() {
        return this.c;
    }

    @Nullable
    public final AvitoMapCameraPosition getCameraPosition() {
        return this.a;
    }

    public int hashCode() {
        AvitoMapCameraPosition avitoMapCameraPosition = this.a;
        int i = 0;
        int hashCode = (avitoMapCameraPosition != null ? avitoMapCameraPosition.hashCode() : 0) * 31;
        AvitoMapBounds avitoMapBounds = this.b;
        int hashCode2 = (hashCode + (avitoMapBounds != null ? avitoMapBounds.hashCode() : 0)) * 31;
        PointsWithOffset pointsWithOffset = this.c;
        if (pointsWithOffset != null) {
            i = pointsWithOffset.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("AvitoMapCameraUpdate(cameraPosition=");
        L.append(this.a);
        L.append(", bounds=");
        L.append(this.b);
        L.append(", boundsByPoints=");
        L.append(this.c);
        L.append(")");
        return L.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AvitoMapCameraUpdate(AvitoMapCameraPosition avitoMapCameraPosition, AvitoMapBounds avitoMapBounds, PointsWithOffset pointsWithOffset, int i, j jVar) {
        this((i & 1) != 0 ? null : avitoMapCameraPosition, (i & 2) != 0 ? null : avitoMapBounds, (i & 4) != 0 ? null : pointsWithOffset);
    }
}
