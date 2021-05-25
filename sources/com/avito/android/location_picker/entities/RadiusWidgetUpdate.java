package com.avito.android.location_picker.entities;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/avito/android/location_picker/entities/RadiusWidgetUpdate;", "", "", "component1", "()D", "", "component2", "()J", Sort.DISTANCE, "distanceInMeters", "copy", "(DJ)Lcom/avito/android/location_picker/entities/RadiusWidgetUpdate;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "D", "getDistance", AuthSource.BOOKING_ORDER, "J", "getDistanceInMeters", "<init>", "(DJ)V", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public final class RadiusWidgetUpdate {
    public final double a;
    public final long b;

    public RadiusWidgetUpdate(double d, long j) {
        this.a = d;
        this.b = j;
    }

    public static /* synthetic */ RadiusWidgetUpdate copy$default(RadiusWidgetUpdate radiusWidgetUpdate, double d, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            d = radiusWidgetUpdate.a;
        }
        if ((i & 2) != 0) {
            j = radiusWidgetUpdate.b;
        }
        return radiusWidgetUpdate.copy(d, j);
    }

    public final double component1() {
        return this.a;
    }

    public final long component2() {
        return this.b;
    }

    @NotNull
    public final RadiusWidgetUpdate copy(double d, long j) {
        return new RadiusWidgetUpdate(d, j);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RadiusWidgetUpdate)) {
            return false;
        }
        RadiusWidgetUpdate radiusWidgetUpdate = (RadiusWidgetUpdate) obj;
        return Double.compare(this.a, radiusWidgetUpdate.a) == 0 && this.b == radiusWidgetUpdate.b;
    }

    public final double getDistance() {
        return this.a;
    }

    public final long getDistanceInMeters() {
        return this.b;
    }

    public int hashCode() {
        return (Double.doubleToLongBits(this.a) * 31) + c.a(this.b);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("RadiusWidgetUpdate(distance=");
        L.append(this.a);
        L.append(", distanceInMeters=");
        return a.l(L, this.b, ")");
    }
}
