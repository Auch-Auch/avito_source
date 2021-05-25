package com.yandex.mapkit.render.internal;

import a2.b.a.a.a;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.SparseArray;
import androidx.core.view.ViewCompat;
import com.yandex.runtime.device.internal.DeviceInfo;
import com.yandex.runtime.image.ImageProvider;
public class TextualImageProvider extends ImageProvider {
    private static final float DELTA = 1.5f;
    private static final float FONT_SCALE = 1.0f;
    private static final SparseArray<Paint> map = new SparseArray<>();
    private final Bitmap bitmap;
    private final String id;

    public TextualImageProvider(String str, int i, boolean z) {
        StringBuilder S = a.S("text:", str, " fontSize:", i, " isOutlined:");
        S.append(z);
        this.id = S.toString();
        Paint paint = getPaint(i);
        float measureText = paint.measureText(str);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        Bitmap createBitmap = Bitmap.createBitmap((int) (measureText + 0.5f), (int) (Math.abs(fontMetrics.top) + Math.abs(fontMetrics.bottom) + 0.5f), Bitmap.Config.ARGB_8888);
        this.bitmap = createBitmap;
        Canvas canvas = new Canvas(createBitmap);
        float abs = Math.abs(fontMetrics.ascent);
        synchronized (map) {
            if (z) {
                paint.setColor(ViewCompat.MEASURED_STATE_MASK);
                float f = abs - DELTA;
                canvas.drawText(str, -1.5f, f, paint);
                canvas.drawText(str, DELTA, f, paint);
                float f2 = abs + DELTA;
                canvas.drawText(str, DELTA, f2, paint);
                canvas.drawText(str, -1.5f, f2, paint);
            }
            paint.setColor(-1);
            canvas.drawText(str, 0.0f, abs, paint);
        }
    }

    private static Paint getPaint(int i) {
        Paint paint;
        SparseArray<Paint> sparseArray = map;
        synchronized (sparseArray) {
            paint = sparseArray.get(i);
            if (paint == null) {
                paint = new Paint();
                paint.setTextSize(((float) i) * 1.0f * DeviceInfo.pixelsPerPoint());
                paint.setTextAlign(Paint.Align.LEFT);
                paint.setStyle(Paint.Style.FILL);
                paint.setAntiAlias(true);
                sparseArray.put(i, paint);
            }
        }
        return paint;
    }

    public static Size measureText(String str, int i) {
        Paint paint = getPaint(i);
        float measureText = paint.measureText(str);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return new Size((int) (measureText + 0.5f), (int) (Math.abs(fontMetrics.top) + Math.abs(fontMetrics.bottom) + 0.5f));
    }

    @Override // com.yandex.runtime.image.ImageProvider
    public String getId() {
        return this.id;
    }

    @Override // com.yandex.runtime.image.ImageProvider
    public Bitmap getImage() {
        return this.bitmap;
    }
}
