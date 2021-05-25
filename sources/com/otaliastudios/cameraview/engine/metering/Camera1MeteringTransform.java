package com.otaliastudios.cameraview.engine.metering;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.offset.Angles;
import com.otaliastudios.cameraview.engine.offset.Axis;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.metering.MeteringTransform;
import com.otaliastudios.cameraview.size.Size;
public class Camera1MeteringTransform implements MeteringTransform<Camera.Area> {
    public static final CameraLogger LOG = CameraLogger.create(Camera1MeteringTransform.class.getSimpleName());
    public static final String TAG = "Camera1MeteringTransform";
    public final int a;
    public final Size b;

    public Camera1MeteringTransform(@NonNull Angles angles, @NonNull Size size) {
        this.a = -angles.offset(Reference.SENSOR, Reference.VIEW, Axis.ABSOLUTE);
        this.b = size;
    }

    @Override // com.otaliastudios.cameraview.metering.MeteringTransform
    @NonNull
    public PointF transformMeteringPoint(@NonNull PointF pointF) {
        PointF pointF2 = new PointF();
        pointF2.x = ((pointF.x / ((float) this.b.getWidth())) * 2000.0f) - 0.0040893555f;
        pointF2.y = ((pointF.y / ((float) this.b.getHeight())) * 2000.0f) - 0.0040893555f;
        PointF pointF3 = new PointF();
        double d = (((double) this.a) * 3.141592653589793d) / 180.0d;
        pointF3.x = (float) ((Math.cos(d) * ((double) pointF2.x)) - (Math.sin(d) * ((double) pointF2.y)));
        pointF3.y = (float) ((Math.cos(d) * ((double) pointF2.y)) + (Math.sin(d) * ((double) pointF2.x)));
        LOG.i("scaled:", pointF2, "rotated:", pointF3);
        return pointF3;
    }

    @Override // com.otaliastudios.cameraview.metering.MeteringTransform
    @NonNull
    public Camera.Area transformMeteringRegion(@NonNull RectF rectF, int i) {
        Rect rect = new Rect();
        rectF.round(rect);
        return new Camera.Area(rect, i);
    }
}
