package com.my.target.common.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.ae;
public class StarsRatingView extends View {
    public static final Paint f;
    public int a;
    public float b;
    public float c;
    @Nullable
    public Bitmap d;
    public boolean e;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StarsRatingView starsRatingView = StarsRatingView.this;
            if (starsRatingView.a > 0) {
                int floor = (int) Math.floor((double) starsRatingView.c);
                int ceil = (int) Math.ceil((double) (5.0f - starsRatingView.c));
                float f = (float) floor;
                boolean z = starsRatingView.c - f >= 0.2f;
                try {
                    int i = starsRatingView.a;
                    starsRatingView.d = Bitmap.createBitmap((int) ((((float) i) + starsRatingView.b) * 5.0f), i, Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(starsRatingView.d);
                    int i2 = starsRatingView.a;
                    Paint paint = StarsRatingView.f;
                    paint.setColor(-552162);
                    canvas.drawPath(starsRatingView.a(0, (float) (i2 / 2), floor), paint);
                    int i3 = starsRatingView.a;
                    int i4 = (int) (((((float) i3) + starsRatingView.b) * f) + ((float) 0));
                    paint.setColor(-3355444);
                    canvas.drawPath(starsRatingView.a(i4, (float) (i3 / 2), ceil), paint);
                    if (z) {
                        int i5 = starsRatingView.a;
                        double d = (double) starsRatingView.c;
                        paint.setColor(-552162);
                        Path a3 = starsRatingView.a(0, (float) (i5 / 2), 1);
                        float floor2 = ((float) i5) * ((float) (d - Math.floor(d)));
                        Rect rect = new Rect(i4, 0, (int) (((float) i4) + floor2), i5);
                        Bitmap createBitmap = Bitmap.createBitmap((int) floor2, i5, Bitmap.Config.ARGB_8888);
                        new Canvas(createBitmap).drawPath(a3, paint);
                        canvas.drawBitmap(createBitmap, (Rect) null, rect, paint);
                    }
                    starsRatingView.invalidate();
                    starsRatingView.e = false;
                } catch (OutOfMemoryError unused) {
                    ae.a("Unable to create rating bitmap because of OOME");
                }
            }
        }
    }

    static {
        Paint paint = new Paint();
        f = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    public StarsRatingView(@NonNull Context context) {
        super(context);
    }

    @NonNull
    public final Path a(int i, float f2, int i2) {
        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        for (int i3 = 0; i3 < i2; i3++) {
            float f3 = (float) i3;
            float f4 = f3 * f2 * 2.0f;
            double d2 = (double) ((f3 * this.b) + f4 + ((float) i) + f2);
            double d3 = (double) f2;
            float f5 = 2.0f * f2;
            path.moveTo((float) a2.b.a.a.a.a(0.0d, d3, d2), f5 - ((float) ((Math.cos(0.0d) * d3) + d3)));
            double d4 = (double) (0.45f * f2);
            path.lineTo((float) a2.b.a.a.a.a(0.6283185307179586d, d4, d2), f5 - ((float) ((Math.cos(0.6283185307179586d) * d4) + d3)));
            for (int i4 = 1; i4 < 5; i4++) {
                double d5 = ((double) i4) * 1.2566370614359172d;
                path.lineTo((float) a2.b.a.a.a.a(d5, d3, d2), f5 - ((float) ((Math.cos(d5) * d3) + d3)));
                double d6 = d5 + 0.6283185307179586d;
                path.lineTo((float) a2.b.a.a.a.a(d6, d4, d2), f5 - ((float) ((Math.cos(d6) * d4) + d3)));
            }
        }
        path.close();
        return path;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.c > 0.0f) {
            Bitmap bitmap = this.d;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            } else if (this.a > 0 && !this.e) {
                this.e = true;
                post(new a());
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = this.a;
        if (i3 <= 0) {
            i3 = View.MeasureSpec.getSize(i2);
            this.a = i3;
        }
        setMeasuredDimension((int) ((this.b * 4.0f) + ((float) (i3 * 5))), i3);
    }

    public void setRating(float f2) {
        setContentDescription(Float.toString(f2));
        if (f2 > 5.0f || f2 < 0.0f) {
            ae.a("Rating is out of bounds: " + f2);
            this.c = 0.0f;
        } else {
            this.c = f2;
        }
        invalidate();
    }

    public void setStarSize(int i) {
        this.a = i;
    }

    public void setStarsPadding(float f2) {
        this.b = f2;
    }
}
