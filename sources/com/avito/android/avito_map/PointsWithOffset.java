package com.avito.android.avito_map;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0010\u0010\bJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\bR\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005¨\u0006\u001d"}, d2 = {"Lcom/avito/android/avito_map/PointsWithOffset;", "", "", "Lcom/avito/android/avito_map/AvitoMapPoint;", "component1", "()Ljava/util/List;", "", "component2", "()I", "points", "offset", "copy", "(Ljava/util/List;I)Lcom/avito/android/avito_map/PointsWithOffset;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "I", "getOffset", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getPoints", "<init>", "(Ljava/util/List;I)V", "avito-map_release"}, k = 1, mv = {1, 4, 2})
public final class PointsWithOffset {
    @NotNull
    public final List<AvitoMapPoint> a;
    public final int b;

    public PointsWithOffset(@NotNull List<AvitoMapPoint> list, int i) {
        Intrinsics.checkNotNullParameter(list, "points");
        this.a = list;
        this.b = i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.avito_map.PointsWithOffset */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PointsWithOffset copy$default(PointsWithOffset pointsWithOffset, List list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = pointsWithOffset.a;
        }
        if ((i2 & 2) != 0) {
            i = pointsWithOffset.b;
        }
        return pointsWithOffset.copy(list, i);
    }

    @NotNull
    public final List<AvitoMapPoint> component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    @NotNull
    public final PointsWithOffset copy(@NotNull List<AvitoMapPoint> list, int i) {
        Intrinsics.checkNotNullParameter(list, "points");
        return new PointsWithOffset(list, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PointsWithOffset)) {
            return false;
        }
        PointsWithOffset pointsWithOffset = (PointsWithOffset) obj;
        return Intrinsics.areEqual(this.a, pointsWithOffset.a) && this.b == pointsWithOffset.b;
    }

    public final int getOffset() {
        return this.b;
    }

    @NotNull
    public final List<AvitoMapPoint> getPoints() {
        return this.a;
    }

    public int hashCode() {
        List<AvitoMapPoint> list = this.a;
        return ((list != null ? list.hashCode() : 0) * 31) + this.b;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("PointsWithOffset(points=");
        L.append(this.a);
        L.append(", offset=");
        return a.j(L, this.b, ")");
    }
}
