package com.otaliastudios.cameraview.metering;

import a2.m.a.c.a;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.otaliastudios.cameraview.size.Size;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
public class MeteringRegions {
    @VisibleForTesting
    public final List<a> a;

    public MeteringRegions(@NonNull List<a> list) {
        this.a = list;
    }

    @NonNull
    public static RectF a(@NonNull PointF pointF, float f, float f2) {
        float f3 = pointF.x;
        float f4 = f / 2.0f;
        float f5 = pointF.y;
        float f6 = f2 / 2.0f;
        return new RectF(f3 - f4, f5 - f6, f3 + f4, f5 + f6);
    }

    @NonNull
    public static MeteringRegions fromArea(@NonNull Size size, @NonNull RectF rectF) {
        return fromArea(size, rectF, 1000);
    }

    @NonNull
    public static MeteringRegions fromPoint(@NonNull Size size, @NonNull PointF pointF) {
        return fromPoint(size, pointF, 1000);
    }

    @NonNull
    public <T> List<T> get(int i, @NonNull MeteringTransform<T> meteringTransform) {
        ArrayList arrayList = new ArrayList();
        Collections.sort(this.a);
        for (a aVar : this.a) {
            arrayList.add(meteringTransform.transformMeteringRegion(aVar.a, aVar.b));
        }
        return arrayList.subList(0, Math.min(i, arrayList.size()));
    }

    @NonNull
    public MeteringRegions transform(@NonNull MeteringTransform meteringTransform) {
        ArrayList arrayList = new ArrayList();
        for (a aVar : this.a) {
            Objects.requireNonNull(aVar);
            RectF rectF = new RectF(Float.MAX_VALUE, Float.MAX_VALUE, -3.4028235E38f, -3.4028235E38f);
            PointF pointF = new PointF();
            RectF rectF2 = aVar.a;
            pointF.set(rectF2.left, rectF2.top);
            PointF transformMeteringPoint = meteringTransform.transformMeteringPoint(pointF);
            aVar.a(rectF, transformMeteringPoint);
            RectF rectF3 = aVar.a;
            transformMeteringPoint.set(rectF3.right, rectF3.top);
            PointF transformMeteringPoint2 = meteringTransform.transformMeteringPoint(transformMeteringPoint);
            aVar.a(rectF, transformMeteringPoint2);
            RectF rectF4 = aVar.a;
            transformMeteringPoint2.set(rectF4.right, rectF4.bottom);
            PointF transformMeteringPoint3 = meteringTransform.transformMeteringPoint(transformMeteringPoint2);
            aVar.a(rectF, transformMeteringPoint3);
            RectF rectF5 = aVar.a;
            transformMeteringPoint3.set(rectF5.left, rectF5.bottom);
            aVar.a(rectF, meteringTransform.transformMeteringPoint(transformMeteringPoint3));
            arrayList.add(new a(rectF, aVar.b));
        }
        return new MeteringRegions(arrayList);
    }

    @NonNull
    public static MeteringRegions fromArea(@NonNull Size size, @NonNull RectF rectF, int i) {
        return fromArea(size, rectF, i, false);
    }

    @NonNull
    public static MeteringRegions fromPoint(@NonNull Size size, @NonNull PointF pointF, int i) {
        return fromArea(size, a(pointF, ((float) size.getWidth()) * 0.05f, ((float) size.getHeight()) * 0.05f), i, true);
    }

    @NonNull
    public static MeteringRegions fromArea(@NonNull Size size, @NonNull RectF rectF, int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        PointF pointF = new PointF(rectF.centerX(), rectF.centerY());
        float width = rectF.width();
        float height = rectF.height();
        arrayList.add(new a(rectF, i));
        if (z) {
            arrayList.add(new a(a(pointF, width * 1.5f, height * 1.5f), Math.round(((float) i) * 0.1f)));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            Objects.requireNonNull(aVar);
            RectF rectF2 = new RectF(0.0f, 0.0f, (float) size.getWidth(), (float) size.getHeight());
            RectF rectF3 = new RectF();
            rectF3.set(Math.max(rectF2.left, aVar.a.left), Math.max(rectF2.top, aVar.a.top), Math.min(rectF2.right, aVar.a.right), Math.min(rectF2.bottom, aVar.a.bottom));
            arrayList2.add(new a(rectF3, aVar.b));
        }
        return new MeteringRegions(arrayList2);
    }
}
