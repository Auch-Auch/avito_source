package com.avito.android.krop.util;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ$\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0018\u001a\u0004\b\u001b\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/avito/android/krop/util/KPoint;", "", "", "dx", "dy", "moveBy", "(FF)Lcom/avito/android/krop/util/KPoint;", "component1", "()F", "component2", "x", "y", "copy", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "F", "getX", AuthSource.BOOKING_ORDER, "getY", "<init>", "(FF)V", "krop_release"}, k = 1, mv = {1, 4, 0})
public final class KPoint {
    public final float a;
    public final float b;

    public KPoint(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    public static /* synthetic */ KPoint copy$default(KPoint kPoint, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = kPoint.a;
        }
        if ((i & 2) != 0) {
            f2 = kPoint.b;
        }
        return kPoint.copy(f, f2);
    }

    public final float component1() {
        return this.a;
    }

    public final float component2() {
        return this.b;
    }

    @NotNull
    public final KPoint copy(float f, float f2) {
        return new KPoint(f, f2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KPoint)) {
            return false;
        }
        KPoint kPoint = (KPoint) obj;
        return Float.compare(this.a, kPoint.a) == 0 && Float.compare(this.b, kPoint.b) == 0;
    }

    public final float getX() {
        return this.a;
    }

    public final float getY() {
        return this.b;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.b) + (Float.floatToIntBits(this.a) * 31);
    }

    @NotNull
    public final KPoint moveBy(float f, float f2) {
        return new KPoint(this.a + f, this.b + f2);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("KPoint(x=");
        L.append(this.a);
        L.append(", y=");
        L.append(this.b);
        L.append(")");
        return L.toString();
    }
}
