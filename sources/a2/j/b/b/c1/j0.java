package a2.j.b.b.c1;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
public final class j0 {
    public int A;
    public int B;
    public int C;
    public int D;
    public StaticLayout E;
    public StaticLayout F;
    public int G;
    public int H;
    public int I;
    public Rect J;
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final TextPaint f;
    public final Paint g;
    public final Paint h;
    @Nullable
    public CharSequence i;
    @Nullable
    public Layout.Alignment j;
    @Nullable
    public Bitmap k;
    public float l;
    public int m;
    public int n;
    public float o;
    public int p;
    public float q;
    public float r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public float x;
    public float y;
    public float z;

    public j0(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{16843287, 16843288}, 0, 0);
        this.e = (float) obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.d = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        float round = (float) Math.round((((float) context.getResources().getDisplayMetrics().densityDpi) * 2.0f) / 160.0f);
        this.a = round;
        this.b = round;
        this.c = round;
        TextPaint textPaint = new TextPaint();
        this.f = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.g = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.h = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    public final void a(Canvas canvas, boolean z2) {
        int i2;
        if (z2) {
            StaticLayout staticLayout = this.E;
            StaticLayout staticLayout2 = this.F;
            if (staticLayout != null && staticLayout2 != null) {
                int save = canvas.save();
                canvas.translate((float) this.G, (float) this.H);
                if (Color.alpha(this.u) > 0) {
                    this.g.setColor(this.u);
                    canvas.drawRect((float) (-this.I), 0.0f, (float) (staticLayout.getWidth() + this.I), (float) staticLayout.getHeight(), this.g);
                }
                int i3 = this.w;
                boolean z3 = true;
                if (i3 == 1) {
                    this.f.setStrokeJoin(Paint.Join.ROUND);
                    this.f.setStrokeWidth(this.a);
                    this.f.setColor(this.v);
                    this.f.setStyle(Paint.Style.FILL_AND_STROKE);
                    staticLayout2.draw(canvas);
                } else if (i3 == 2) {
                    TextPaint textPaint = this.f;
                    float f2 = this.b;
                    float f3 = this.c;
                    textPaint.setShadowLayer(f2, f3, f3, this.v);
                } else if (i3 == 3 || i3 == 4) {
                    if (i3 != 3) {
                        z3 = false;
                    }
                    int i4 = -1;
                    if (z3) {
                        i2 = -1;
                    } else {
                        i2 = this.v;
                    }
                    if (z3) {
                        i4 = this.v;
                    }
                    float f4 = this.b / 2.0f;
                    this.f.setColor(this.s);
                    this.f.setStyle(Paint.Style.FILL);
                    float f5 = -f4;
                    this.f.setShadowLayer(this.b, f5, f5, i2);
                    staticLayout2.draw(canvas);
                    this.f.setShadowLayer(this.b, f4, f4, i4);
                }
                this.f.setColor(this.s);
                this.f.setStyle(Paint.Style.FILL);
                staticLayout.draw(canvas);
                this.f.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                canvas.restoreToCount(save);
                return;
            }
            return;
        }
        Assertions.checkNotNull(this.J);
        Assertions.checkNotNull(this.k);
        canvas.drawBitmap(this.k, (Rect) null, this.J, this.h);
    }
}
