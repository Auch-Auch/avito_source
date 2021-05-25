package com.otaliastudios.cameraview.engine.metering;

import a2.b.a.a.a;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.offset.Angles;
import com.otaliastudios.cameraview.engine.offset.Axis;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.metering.MeteringTransform;
import com.otaliastudios.cameraview.size.AspectRatio;
import com.otaliastudios.cameraview.size.Size;
@RequiresApi(21)
public class Camera2MeteringTransform implements MeteringTransform<MeteringRectangle> {
    public static final CameraLogger LOG = CameraLogger.create(Camera2MeteringTransform.class.getSimpleName());
    public static final String TAG = "Camera2MeteringTransform";
    public final Angles a;
    public final Size b;
    public final Size c;
    public final boolean d;
    public final CameraCharacteristics e;
    public final CaptureRequest.Builder f;

    public Camera2MeteringTransform(@NonNull Angles angles, @NonNull Size size, @NonNull Size size2, boolean z, @NonNull CameraCharacteristics cameraCharacteristics, @NonNull CaptureRequest.Builder builder) {
        this.a = angles;
        this.b = size;
        this.c = size2;
        this.d = z;
        this.e = cameraCharacteristics;
        this.f = builder;
    }

    @Override // com.otaliastudios.cameraview.metering.MeteringTransform
    @NonNull
    public PointF transformMeteringPoint(@NonNull PointF pointF) {
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        Size size = this.b;
        Size size2 = this.c;
        int width = size.getWidth();
        int height = size.getHeight();
        AspectRatio of = AspectRatio.of(size2);
        AspectRatio of2 = AspectRatio.of(size);
        if (this.d) {
            if (of.toFloat() > of2.toFloat()) {
                float f2 = of.toFloat() / of2.toFloat();
                pointF2.x = (((f2 - 1.0f) * ((float) size.getWidth())) / 2.0f) + pointF2.x;
                width = Math.round(((float) size.getWidth()) * f2);
            } else {
                float f3 = of2.toFloat() / of.toFloat();
                pointF2.y = (((f3 - 1.0f) * ((float) size.getHeight())) / 2.0f) + pointF2.y;
                height = Math.round(((float) size.getHeight()) * f3);
            }
        }
        Size size3 = new Size(width, height);
        Size size4 = this.c;
        pointF2.x = (((float) size4.getWidth()) / ((float) size3.getWidth())) * pointF2.x;
        pointF2.y = (((float) size4.getHeight()) / ((float) size3.getHeight())) * pointF2.y;
        int offset = this.a.offset(Reference.SENSOR, Reference.VIEW, Axis.ABSOLUTE);
        boolean z = offset % 180 != 0;
        float f4 = pointF2.x;
        float f5 = pointF2.y;
        if (offset == 0) {
            pointF2.x = f4;
            pointF2.y = f5;
        } else if (offset == 90) {
            pointF2.x = f5;
            pointF2.y = ((float) size4.getWidth()) - f4;
        } else if (offset == 180) {
            pointF2.x = ((float) size4.getWidth()) - f4;
            pointF2.y = ((float) size4.getHeight()) - f5;
        } else if (offset == 270) {
            pointF2.x = ((float) size4.getHeight()) - f5;
            pointF2.y = f4;
        } else {
            throw new IllegalStateException(a.M2("Unexpected angle ", offset));
        }
        if (z) {
            size4 = size4.flip();
        }
        Rect rect = (Rect) this.f.get(CaptureRequest.SCALER_CROP_REGION);
        int width2 = rect == null ? size4.getWidth() : rect.width();
        int height2 = rect == null ? size4.getHeight() : rect.height();
        pointF2.x = (((float) (width2 - size4.getWidth())) / 2.0f) + pointF2.x;
        pointF2.y = (((float) (height2 - size4.getHeight())) / 2.0f) + pointF2.y;
        Size size5 = new Size(width2, height2);
        Rect rect2 = (Rect) this.f.get(CaptureRequest.SCALER_CROP_REGION);
        pointF2.x += rect2 == null ? 0.0f : (float) rect2.left;
        pointF2.y += rect2 == null ? 0.0f : (float) rect2.top;
        Rect rect3 = (Rect) this.e.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        if (rect3 == null) {
            rect3 = new Rect(0, 0, size5.getWidth(), size5.getHeight());
        }
        Size size6 = new Size(rect3.width(), rect3.height());
        CameraLogger cameraLogger = LOG;
        cameraLogger.i("input:", pointF, "output (before clipping):", pointF2);
        if (pointF2.x < 0.0f) {
            pointF2.x = 0.0f;
        }
        if (pointF2.y < 0.0f) {
            pointF2.y = 0.0f;
        }
        if (pointF2.x > ((float) size6.getWidth())) {
            pointF2.x = (float) size6.getWidth();
        }
        if (pointF2.y > ((float) size6.getHeight())) {
            pointF2.y = (float) size6.getHeight();
        }
        cameraLogger.i("input:", pointF, "output (after clipping):", pointF2);
        return pointF2;
    }

    @Override // com.otaliastudios.cameraview.metering.MeteringTransform
    @NonNull
    public MeteringRectangle transformMeteringRegion(@NonNull RectF rectF, int i) {
        Rect rect = new Rect();
        rectF.round(rect);
        return new MeteringRectangle(rect, i);
    }
}
