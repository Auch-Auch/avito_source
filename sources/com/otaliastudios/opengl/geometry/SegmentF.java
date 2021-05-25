package com.otaliastudios.opengl.geometry;

import android.graphics.PointF;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u001d\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u001fB!\b\u0016\u0012\n\u0010\"\u001a\u00060 j\u0002`!\u0012\n\u0010#\u001a\u00060 j\u0002`!¢\u0006\u0004\b\u001e\u0010$J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0010\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0013\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000fR\u001d\u0010\u001a\u001a\u00020\u00068F@\u0006X\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u000fR\u0019\u0010\u001d\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000f¨\u0006%"}, d2 = {"Lcom/otaliastudios/opengl/geometry/SegmentF;", "", "other", "", "intersects", "(Lcom/otaliastudios/opengl/geometry/SegmentF;)Z", "", "x", "y", "", "orientation", "(FF)I", "c", "F", "getIy", "()F", "iy", "e", "getJy", "jy", "d", "getJx", "jx", AuthSource.SEND_ABUSE, "Lkotlin/Lazy;", "getLength", "length", AuthSource.BOOKING_ORDER, "getIx", "ix", "<init>", "(FFFF)V", "Landroid/graphics/PointF;", "Lcom/otaliastudios/opengl/geometry/PointF;", "i", "j", "(Landroid/graphics/PointF;Landroid/graphics/PointF;)V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public class SegmentF {
    @NotNull
    public final Lazy a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;

    public static final class a extends Lambda implements Function0<Float> {
        public final /* synthetic */ SegmentF a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SegmentF segmentF) {
            super(0);
            this.a = segmentF;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Float invoke() {
            double d = (double) 2;
            return Float.valueOf((float) Math.sqrt((double) (((float) Math.pow((double) (this.a.getIx() - this.a.getJx()), d)) + ((float) Math.pow((double) (this.a.getIy() - this.a.getJy()), d)))));
        }
    }

    public SegmentF(float f, float f2, float f3, float f4) {
        this.b = f;
        this.c = f2;
        this.d = f3;
        this.e = f4;
        this.a = c.lazy(new a(this));
    }

    public final float getIx() {
        return this.b;
    }

    public final float getIy() {
        return this.c;
    }

    public final float getJx() {
        return this.d;
    }

    public final float getJy() {
        return this.e;
    }

    public final float getLength() {
        return ((Number) this.a.getValue()).floatValue();
    }

    public boolean intersects(@NotNull SegmentF segmentF) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(segmentF, "other");
        float min = Math.min(this.b, this.d);
        float max = Math.max(this.b, this.d);
        float min2 = Math.min(segmentF.b, segmentF.d);
        float max2 = Math.max(segmentF.b, segmentF.d);
        if (min > max2 || max < min2) {
            return false;
        }
        float min3 = Math.min(this.c, this.e);
        float max3 = Math.max(this.c, this.e);
        float min4 = Math.min(segmentF.c, segmentF.e);
        float max4 = Math.max(segmentF.c, segmentF.e);
        if (min3 > max4 || max3 < min4) {
            return false;
        }
        int orientation = orientation(segmentF.b, segmentF.c);
        int orientation2 = orientation(segmentF.d, segmentF.e);
        if (orientation > 0 && orientation2 > 0) {
            return false;
        }
        if (orientation < 0 && orientation2 < 0) {
            return false;
        }
        int orientation3 = segmentF.orientation(this.b, this.c);
        int orientation4 = segmentF.orientation(this.d, this.e);
        if (orientation3 > 0 && orientation4 > 0) {
            return false;
        }
        if (orientation3 < 0 && orientation4 < 0) {
            return false;
        }
        if (orientation == 0 && orientation2 == 0 && orientation3 == 0 && orientation4 == 0) {
            int i3 = (min > max2 ? 1 : (min == max2 ? 0 : -1));
            if (i3 == 0 && min3 == max4) {
                return false;
            }
            if (i3 == 0 && i2 == 0) {
                return false;
            }
            if (i == 0 && min3 == max4) {
                return false;
            }
            if (i == 0 && i2 == 0) {
                return false;
            }
            return true;
        }
        float f = this.b;
        float f2 = segmentF.b;
        if (f == f2 && this.c == segmentF.c) {
            return false;
        }
        float f3 = this.d;
        float f4 = segmentF.d;
        if (f3 == f4 && this.e == segmentF.e) {
            return false;
        }
        if (f == f4 && this.c == segmentF.e) {
            return false;
        }
        if (f3 == f2 && this.e == segmentF.c) {
            return false;
        }
        return true;
    }

    public final int orientation(float f, float f2) {
        float f3 = this.d;
        float f4 = this.e;
        return (int) Math.signum(((f2 - f4) * (f3 - this.b)) - ((f - f3) * (f4 - this.c)));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SegmentF(@NotNull PointF pointF, @NotNull PointF pointF2) {
        this(pointF.x, pointF.y, pointF2.x, pointF2.y);
        Intrinsics.checkNotNullParameter(pointF, "i");
        Intrinsics.checkNotNullParameter(pointF2, "j");
    }
}
