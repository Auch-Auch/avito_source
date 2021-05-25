package com.my.target;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class fj {
    @Nullable
    public static Bitmap A(int i) {
        Bitmap bitmap;
        try {
            bitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError unused) {
            ae.a("cannot build icon: OOME");
            bitmap = null;
        }
        if (bitmap == null) {
            return null;
        }
        float f = ((float) i) / 100.0f;
        Paint paint = new Paint();
        paint.setColor(0);
        paint.setStyle(Paint.Style.STROKE);
        Canvas canvas = new Canvas(bitmap);
        a(f, i, paint, canvas);
        canvas.drawArc(new RectF(57.0f * f, 45.0f * f, 67.0f * f, 55.0f * f), 90.0f, -180.0f, false, paint);
        canvas.drawArc(new RectF(52.0f * f, 40.0f * f, 72.0f * f, f * 60.0f), 90.0f, -180.0f, false, paint);
        return bitmap;
    }

    @Nullable
    public static Bitmap B(int i) {
        Bitmap bitmap;
        try {
            bitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError unused) {
            ae.a("cannot build icon: OOME");
            bitmap = null;
        }
        if (bitmap == null) {
            return null;
        }
        float f = ((float) i) / 100.0f;
        Paint paint = new Paint();
        paint.setColor(0);
        paint.setStyle(Paint.Style.STROKE);
        Canvas canvas = new Canvas(bitmap);
        a(f, i, paint, canvas);
        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        float f2 = 62.0f * f;
        float f3 = 40.0f * f;
        path.moveTo(f2, f3);
        float f4 = 82.0f * f;
        float f5 = f * 60.0f;
        path.lineTo(f4, f5);
        path.moveTo(f2, f5);
        path.lineTo(f4, f3);
        canvas.drawPath(path, paint);
        return bitmap;
    }

    @Nullable
    public static Bitmap C(int i) {
        Bitmap bitmap;
        try {
            bitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError unused) {
            ae.a("cannot build play icon: OOME");
            bitmap = null;
        }
        if (bitmap == null) {
            return null;
        }
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-1157627904);
        float f = (float) i;
        canvas.drawOval(new RectF(0.0f, 0.0f, f, f), paint);
        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setColor(-1);
        paint2.setAntiAlias(true);
        paint2.setStrokeWidth((float) 8);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        float f2 = (float) 4;
        float f3 = (float) (i - 4);
        canvas.drawOval(new RectF(f2, f2, f3, f3), paint2);
        Paint paint3 = new Paint();
        paint3.setColor(0);
        canvas.drawPaint(paint3);
        paint3.setStrokeWidth(4.0f);
        paint3.setColor(-1);
        paint3.setStyle(Paint.Style.FILL_AND_STROKE);
        paint3.setAntiAlias(true);
        float f4 = f / 160.0f;
        int i2 = (int) (60.0f * f4);
        Point point = new Point(i2, (int) (50.0f * f4));
        Point point2 = new Point(i2, (int) (110.0f * f4));
        Point point3 = new Point((int) (112.0f * f4), (int) (f4 * 80.0f));
        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo((float) point.x, (float) point.y);
        path.lineTo((float) point2.x, (float) point2.y);
        path.lineTo((float) point3.x, (float) point3.y);
        path.lineTo((float) point.x, (float) point.y);
        path.close();
        canvas.drawPath(path, paint3);
        return bitmap;
    }

    @Nullable
    public static Bitmap S(@NonNull Context context) {
        byte[] decode = Base64.decode("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAB3RJTUUH4AMXCjM59gfMOgAAA59JREFUeNrtmkloFEEUhl/N6KgxriiJOHEXF4gENYlgRFA8uyAoCNGggl68CCJ6EQx6cCFqUFzABQQRMYh4EfSi4IJbiFERQVxRgxuRMWri5yE1UBY9yWh6Znq6+z+96a6ZV/8/tbz3qkRChAgRwiMAFgJngWgQyVcDHXTiFKCCRH4Df6MFKAkK+W0W+VfAxCAQV8A+i/wTIB4E8lHgpEX+LjA8COQHAM8t8o3ATKC338kXA59IjXbgEVAPLAb6+k2AHRbhVrrGV+AwMNVPIpx3INncjRi/gTPAWL+IcMIieBGIAXFgGXAU+OggRALY7ItIEdhvkTsNRIz3MWCp3h1sXAGK/RAHnLKIHUzRdgnwwmr7Epjsh3jggkWsNkXbQuC4Q8g8Ld9F6ANctYht7KL9GiNpAnib94ujDo5uaUIdwMo00uafhghNQL98F2EYcA9YlGb75daoOeqHnSHyj+23WyLMC1oRJQpct7LJXkETYSrwyxBhlQQNwAFrFKigCTDK2hXmBnEUnDMEOBZEARYaArwLogAF1jRIq4YQ8YsASqmEiNw2HpUHSgCNB4Y9KYgCPDXs8UEU4LNhF6bzhW7DRmCEiFTqjx+VUtc8LECrYfd3RQA9lxq03SgiZR4WIGbYv9yaAt8Me5DHp8DAFP3ukQDvDTvu8WxrnGG/dUUApdQrEUkYU2a8hwWYnGJH6PEu0GzYczwaCSoRqTIeNbkpwFXDnu/Rf79URJKnyz9E5Kab6i4wYuxvQKEHR8BO8+DE7R+PAu8MB6s9Rj4GvDH6tzYTTvZaVZeIhwSoMfr2HRiUCSd21aXGI+T7WRcu6jLp7Ijh6AMw1AMCmKXxtozeLgOKgC+Gw4ZcFiCB2fpWSRLbsuF0nXUYsSlH5EfqE+IknmblSo0+1m6wRKjOMvnB+jzQHPpl2ezAEOCx0YEOYH2WfMct8rlZkIES4LXVkXqgTwZ9Vjn43JrLFXgC8Mzq0H2g0mU/BTrSa7d8bfHCPlwE3HC41XWyp9fbdIS3Tt8fxprzq7wUivYGdmnithCXgRXpxgw67K4A9ljhdxKPgVK3+q5cFqJcRA6JyAyn1zpFfaBz9RZdtYnpStNonc/PEpEhDt9vE5FaEdmtlPrh2YoEEAEWpbje9j9o1aNrhOQbgOlAncNC2R0SwCVgZaZTb5VFMUpEpEJEpojIGBEZLJ21+zbpLGe3iMgTEXkoIneUUj8lRIgQIUKECJFJ/AEepzU1TSID5QAAAABJRU5ErkJggg==", 0);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = 420;
        options.inTargetDensity = context.getResources().getDisplayMetrics().densityDpi;
        return BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
    }

    @Nullable
    public static Bitmap T(@NonNull Context context) {
        byte[] decode = Base64.decode("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAB3RJTUUH4AMXCy8fw79+rQAAAhVJREFUeNrt2y9IXlEYx3H3ooIiiCAIC4JgMRgsCyaLwWaxLK0srZhWVtYWVtYWlpYMNsvK0sKKRTANBivDIIggIiLiZ+URDncHFgzbznN+8d77nvPwvec99zz/xsa6uv4oPMWjzADgK55kBnCvj3icGQBc4hWmsgK41w/sZAPwswLiC9ayAJjGa1wNrt/hAxaaBlBcW8ReZTVc4CUmmwZQ3FvHYQXEd2w3DyDuj/AMJxUQn7HaNIDiuRm8wfUAwi3eY75pAMXzS9ivrIZz7GKiaQDF7zZwVAHxDVvNAyj2h+c4rYD4hJWmARRjzOItbir7wzvMNQ2gGGsZB5XVcIYXGG8aQDHmJo4rII6x2TyAGHc83vpZBcQBlpsGUIw/F/vA7QDCTewbs00DKOZZiS/DUKfxJRk1DaCYbyvOCkMdYaN5ADHnRJwazysg9rHUNIBi7vnwI4b7w3X4HTNNAyhsWA3PcqiT8ERHTQMobNmOWMNQh1hvHkDYMxlRp4sKiD0sNg2gsGsh4pB3AwhXEbecbhpAYd9aRKZVItgPT+v96wAKO3ciVzHUw9J6/wuAsHUqslaXFRC/pfVGY139L9A3wf4Z7AehfhTuzlB3h3tApIfE/jqAtEHRtGHx1ImRtKmxtMnRtOnx1AUSaUtk0hZJpS2TS10ombZUNm2xdPpy+d4w0VtmetNU2ra51I2TuVtnuxrWL/YiKQ6CN9uRAAAAAElFTkSuQmCC", 0);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = 420;
        options.inTargetDensity = context.getResources().getDisplayMetrics().densityDpi;
        return BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
    }

    @Nullable
    public static Bitmap U(@NonNull Context context) {
        byte[] decode = Base64.decode("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAB3RJTUUH4AMXCjITNKc0rQAAAJFJREFUeNrt2tENgCAMQEEwLuD+QzpC3cBURWLsvV+JNRfhi9YkSSpbP3sYETF0WO89s27m3KX6H1AeYL2wdrs5Y3/4ja/OTZ8B2f074h0z5zoDAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA/lr6rvDoK+xfmWsLNEmSVLUD47EiX/OuE8UAAAAASUVORK5CYII=", 0);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = 420;
        options.inTargetDensity = context.getResources().getDisplayMetrics().densityDpi;
        return BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
    }

    @NonNull
    public static Canvas a(float f, int i, @NonNull Paint paint, @NonNull Canvas canvas) {
        float f2 = 3.0f * f;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setColor(-2013265920);
        float f3 = (float) i;
        canvas.drawOval(new RectF(0.0f, 0.0f, f3, f3), paint2);
        Paint paint3 = new Paint();
        paint3.setAntiAlias(true);
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(f2);
        paint3.setColor(-1);
        float f4 = f3 / 2.0f;
        canvas.drawCircle(f4, f4, f4 - (f2 / 2.0f), paint3);
        paint.setStrokeWidth(f2);
        paint.setColor(-1);
        paint.setAntiAlias(true);
        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        float f5 = 23.0f * f;
        float f6 = 38.0f * f;
        path.moveTo(f5, f6);
        float f7 = 60.0f * f;
        path.lineTo(f5, f7);
        path.lineTo(f6, f7);
        path.lineTo(f6, f6);
        float f8 = 56.0f * f;
        path.lineTo(f8, 27.0f * f);
        path.lineTo(f8, f * 71.0f);
        path.lineTo(f6, f7);
        path.moveTo(f6, f6);
        path.lineTo(f5, f6);
        path.close();
        canvas.drawPath(path, paint);
        return canvas;
    }
}
