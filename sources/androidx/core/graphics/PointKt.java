package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.PointF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0011\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0006*\u00020\u0005H\n¢\u0006\u0004\b\u0002\u0010\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0006*\u00020\u0005H\n¢\u0006\u0004\b\u0004\u0010\u0007\u001a\u001c\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\n¢\u0006\u0004\b\t\u0010\n\u001a\u001c\u0010\t\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\n¢\u0006\u0004\b\t\u0010\u000b\u001a\u001c\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\f\u001a\u00020\u0001H\n¢\u0006\u0004\b\t\u0010\r\u001a\u001c\u0010\t\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\f\u001a\u00020\u0006H\n¢\u0006\u0004\b\t\u0010\u000e\u001a\u001c\u0010\u000f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\n¢\u0006\u0004\b\u000f\u0010\n\u001a\u001c\u0010\u000f\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\n¢\u0006\u0004\b\u000f\u0010\u000b\u001a\u001c\u0010\u000f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\f\u001a\u00020\u0001H\n¢\u0006\u0004\b\u000f\u0010\r\u001a\u001c\u0010\u000f\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\f\u001a\u00020\u0006H\n¢\u0006\u0004\b\u000f\u0010\u000e\u001a\u0014\u0010\u0010\u001a\u00020\u0000*\u00020\u0000H\n¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0014\u0010\u0010\u001a\u00020\u0005*\u00020\u0005H\n¢\u0006\u0004\b\u0010\u0010\u0012\u001a\u0014\u0010\u0013\u001a\u00020\u0005*\u00020\u0000H\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0014\u0010\u0015\u001a\u00020\u0000*\u00020\u0005H\b¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroid/graphics/Point;", "", "component1", "(Landroid/graphics/Point;)I", "component2", "Landroid/graphics/PointF;", "", "(Landroid/graphics/PointF;)F", "p", "plus", "(Landroid/graphics/Point;Landroid/graphics/Point;)Landroid/graphics/Point;", "(Landroid/graphics/PointF;Landroid/graphics/PointF;)Landroid/graphics/PointF;", "xy", "(Landroid/graphics/Point;I)Landroid/graphics/Point;", "(Landroid/graphics/PointF;F)Landroid/graphics/PointF;", "minus", "unaryMinus", "(Landroid/graphics/Point;)Landroid/graphics/Point;", "(Landroid/graphics/PointF;)Landroid/graphics/PointF;", "toPointF", "(Landroid/graphics/Point;)Landroid/graphics/PointF;", "toPoint", "(Landroid/graphics/PointF;)Landroid/graphics/Point;", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class PointKt {
    public static final int component1(@NotNull Point point) {
        Intrinsics.checkParameterIsNotNull(point, "$this$component1");
        return point.x;
    }

    public static final int component2(@NotNull Point point) {
        Intrinsics.checkParameterIsNotNull(point, "$this$component2");
        return point.y;
    }

    @NotNull
    public static final Point minus(@NotNull Point point, @NotNull Point point2) {
        Intrinsics.checkParameterIsNotNull(point, "$this$minus");
        Intrinsics.checkParameterIsNotNull(point2, "p");
        Point point3 = new Point(point.x, point.y);
        point3.offset(-point2.x, -point2.y);
        return point3;
    }

    @NotNull
    public static final Point plus(@NotNull Point point, @NotNull Point point2) {
        Intrinsics.checkParameterIsNotNull(point, "$this$plus");
        Intrinsics.checkParameterIsNotNull(point2, "p");
        Point point3 = new Point(point.x, point.y);
        point3.offset(point2.x, point2.y);
        return point3;
    }

    @NotNull
    public static final Point toPoint(@NotNull PointF pointF) {
        Intrinsics.checkParameterIsNotNull(pointF, "$this$toPoint");
        return new Point((int) pointF.x, (int) pointF.y);
    }

    @NotNull
    public static final PointF toPointF(@NotNull Point point) {
        Intrinsics.checkParameterIsNotNull(point, "$this$toPointF");
        return new PointF(point);
    }

    @NotNull
    public static final Point unaryMinus(@NotNull Point point) {
        Intrinsics.checkParameterIsNotNull(point, "$this$unaryMinus");
        return new Point(-point.x, -point.y);
    }

    public static final float component1(@NotNull PointF pointF) {
        Intrinsics.checkParameterIsNotNull(pointF, "$this$component1");
        return pointF.x;
    }

    public static final float component2(@NotNull PointF pointF) {
        Intrinsics.checkParameterIsNotNull(pointF, "$this$component2");
        return pointF.y;
    }

    @NotNull
    public static final PointF unaryMinus(@NotNull PointF pointF) {
        Intrinsics.checkParameterIsNotNull(pointF, "$this$unaryMinus");
        return new PointF(-pointF.x, -pointF.y);
    }

    @NotNull
    public static final PointF minus(@NotNull PointF pointF, @NotNull PointF pointF2) {
        Intrinsics.checkParameterIsNotNull(pointF, "$this$minus");
        Intrinsics.checkParameterIsNotNull(pointF2, "p");
        PointF pointF3 = new PointF(pointF.x, pointF.y);
        pointF3.offset(-pointF2.x, -pointF2.y);
        return pointF3;
    }

    @NotNull
    public static final PointF plus(@NotNull PointF pointF, @NotNull PointF pointF2) {
        Intrinsics.checkParameterIsNotNull(pointF, "$this$plus");
        Intrinsics.checkParameterIsNotNull(pointF2, "p");
        PointF pointF3 = new PointF(pointF.x, pointF.y);
        pointF3.offset(pointF2.x, pointF2.y);
        return pointF3;
    }

    @NotNull
    public static final Point minus(@NotNull Point point, int i) {
        Intrinsics.checkParameterIsNotNull(point, "$this$minus");
        Point point2 = new Point(point.x, point.y);
        int i2 = -i;
        point2.offset(i2, i2);
        return point2;
    }

    @NotNull
    public static final Point plus(@NotNull Point point, int i) {
        Intrinsics.checkParameterIsNotNull(point, "$this$plus");
        Point point2 = new Point(point.x, point.y);
        point2.offset(i, i);
        return point2;
    }

    @NotNull
    public static final PointF minus(@NotNull PointF pointF, float f) {
        Intrinsics.checkParameterIsNotNull(pointF, "$this$minus");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        float f2 = -f;
        pointF2.offset(f2, f2);
        return pointF2;
    }

    @NotNull
    public static final PointF plus(@NotNull PointF pointF, float f) {
        Intrinsics.checkParameterIsNotNull(pointF, "$this$plus");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        pointF2.offset(f, f);
        return pointF2;
    }
}
