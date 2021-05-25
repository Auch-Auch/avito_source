package pl.droidsonroids.gif.transforms;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
public class CornerRadiusTransform implements Transform {
    public float a;
    public Shader b;
    public final RectF c = new RectF();

    public CornerRadiusTransform(@FloatRange(from = 0.0d) float f) {
        float max = Math.max(0.0f, f);
        if (max != this.a) {
            this.a = max;
            this.b = null;
        }
    }

    @NonNull
    public RectF getBounds() {
        return this.c;
    }

    @FloatRange(from = 0.0d)
    public float getCornerRadius() {
        return this.a;
    }

    @Override // pl.droidsonroids.gif.transforms.Transform
    public void onBoundsChange(Rect rect) {
        this.c.set(rect);
        this.b = null;
    }

    @Override // pl.droidsonroids.gif.transforms.Transform
    public void onDraw(Canvas canvas, Paint paint, Bitmap bitmap) {
        if (this.a == 0.0f) {
            canvas.drawBitmap(bitmap, (Rect) null, this.c, paint);
            return;
        }
        if (this.b == null) {
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.b = new BitmapShader(bitmap, tileMode, tileMode);
            Matrix matrix = new Matrix();
            RectF rectF = this.c;
            matrix.setTranslate(rectF.left, rectF.top);
            matrix.preScale(this.c.width() / ((float) bitmap.getWidth()), this.c.height() / ((float) bitmap.getHeight()));
            this.b.setLocalMatrix(matrix);
        }
        paint.setShader(this.b);
        RectF rectF2 = this.c;
        float f = this.a;
        canvas.drawRoundRect(rectF2, f, f, paint);
    }

    public void setCornerRadius(@FloatRange(from = 0.0d) float f) {
        float max = Math.max(0.0f, f);
        if (max != this.a) {
            this.a = max;
            this.b = null;
        }
    }
}
