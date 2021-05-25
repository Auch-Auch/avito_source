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
public class fi {
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
        int i2 = (i / 32) + (i / 4);
        int i3 = i / 8;
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
        paint.setColor(-2013265920);
        float f = (float) i;
        canvas.drawOval(new RectF(0.0f, 0.0f, f, f), paint);
        Paint paint2 = new Paint();
        paint2.setColor(0);
        canvas.drawPaint(paint2);
        paint2.setStrokeWidth(4.0f);
        paint2.setColor(-16733198);
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        paint2.setAntiAlias(true);
        int i4 = i3 * 3;
        Point point = new Point(i4, i2);
        Point point2 = new Point(i4, i - i2);
        Point point3 = new Point(i - (i3 * 2), i / 2);
        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo((float) point.x, (float) point.y);
        path.lineTo((float) point2.x, (float) point2.y);
        path.lineTo((float) point3.x, (float) point3.y);
        path.lineTo((float) point.x, (float) point.y);
        path.close();
        canvas.drawPath(path, paint2);
        return bitmap;
    }

    @Nullable
    public static Bitmap R(@NonNull Context context) {
        byte[] decode = Base64.decode("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", 0);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = 320;
        options.inTargetDensity = context.getResources().getDisplayMetrics().densityDpi;
        return BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
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

    public static void a(float f, int i, @NonNull Paint paint, @NonNull Canvas canvas) {
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
        float f4 = (float) (i / 2);
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
    }
}
