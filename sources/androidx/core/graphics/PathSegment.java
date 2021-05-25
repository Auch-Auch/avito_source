package androidx.core.graphics;

import a2.b.a.a.a;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
public final class PathSegment {
    public final PointF a;
    public final float b;
    public final PointF c;
    public final float d;

    public PathSegment(@NonNull PointF pointF, float f, @NonNull PointF pointF2, float f2) {
        this.a = (PointF) Preconditions.checkNotNull(pointF, "start == null");
        this.b = f;
        this.c = (PointF) Preconditions.checkNotNull(pointF2, "end == null");
        this.d = f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PathSegment)) {
            return false;
        }
        PathSegment pathSegment = (PathSegment) obj;
        if (Float.compare(this.b, pathSegment.b) != 0 || Float.compare(this.d, pathSegment.d) != 0 || !this.a.equals(pathSegment.a) || !this.c.equals(pathSegment.c)) {
            return false;
        }
        return true;
    }

    @NonNull
    public PointF getEnd() {
        return this.c;
    }

    public float getEndFraction() {
        return this.d;
    }

    @NonNull
    public PointF getStart() {
        return this.a;
    }

    public float getStartFraction() {
        return this.b;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        float f = this.b;
        int i = 0;
        int hashCode2 = (this.c.hashCode() + ((hashCode + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31)) * 31;
        float f2 = this.d;
        if (f2 != 0.0f) {
            i = Float.floatToIntBits(f2);
        }
        return hashCode2 + i;
    }

    public String toString() {
        StringBuilder L = a.L("PathSegment{start=");
        L.append(this.a);
        L.append(", startFraction=");
        L.append(this.b);
        L.append(", end=");
        L.append(this.c);
        L.append(", endFraction=");
        L.append(this.d);
        L.append('}');
        return L.toString();
    }
}
