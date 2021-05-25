package com.bumptech.glide.load.engine.cache;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.util.Preconditions;
public final class MemorySizeCalculator {
    public final int a;
    public final int b;
    public final Context c;
    public final int d;

    public static final class Builder {
        public static final int i = (Build.VERSION.SDK_INT < 26 ? 4 : 1);
        public final Context a;
        public ActivityManager b;
        public b c;
        public float d = 2.0f;
        public float e = ((float) i);
        public float f = 0.4f;
        public float g = 0.33f;
        public int h = 4194304;

        public Builder(Context context) {
            this.a = context;
            this.b = (ActivityManager) context.getSystemService("activity");
            this.c = new a(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT >= 26 && this.b.isLowRamDevice()) {
                this.e = 0.0f;
            }
        }

        public MemorySizeCalculator build() {
            return new MemorySizeCalculator(this);
        }

        public Builder setArrayPoolSize(int i2) {
            this.h = i2;
            return this;
        }

        public Builder setBitmapPoolScreens(float f2) {
            Preconditions.checkArgument(f2 >= 0.0f, "Bitmap pool screens must be greater than or equal to 0");
            this.e = f2;
            return this;
        }

        public Builder setLowMemoryMaxSizeMultiplier(float f2) {
            Preconditions.checkArgument(f2 >= 0.0f && f2 <= 1.0f, "Low memory max size multiplier must be between 0 and 1");
            this.g = f2;
            return this;
        }

        public Builder setMaxSizeMultiplier(float f2) {
            Preconditions.checkArgument(f2 >= 0.0f && f2 <= 1.0f, "Size multiplier must be between 0 and 1");
            this.f = f2;
            return this;
        }

        public Builder setMemoryCacheScreens(float f2) {
            Preconditions.checkArgument(f2 >= 0.0f, "Memory cache screens must be greater than or equal to 0");
            this.d = f2;
            return this;
        }
    }

    public static final class a implements b {
        public final DisplayMetrics a;

        public a(DisplayMetrics displayMetrics) {
            this.a = displayMetrics;
        }
    }

    public interface b {
    }

    public MemorySizeCalculator(Builder builder) {
        int i;
        this.c = builder.a;
        if (builder.b.isLowRamDevice()) {
            i = builder.h / 2;
        } else {
            i = builder.h;
        }
        this.d = i;
        ActivityManager activityManager = builder.b;
        float f = builder.f;
        float f2 = builder.g;
        int round = Math.round(((float) (activityManager.getMemoryClass() * 1024 * 1024)) * (activityManager.isLowRamDevice() ? f2 : f));
        DisplayMetrics displayMetrics = ((a) builder.c).a;
        float f3 = (float) (displayMetrics.widthPixels * displayMetrics.heightPixels * 4);
        int round2 = Math.round(builder.e * f3);
        int round3 = Math.round(f3 * builder.d);
        int i2 = round - i;
        if (round3 + round2 <= i2) {
            this.b = round3;
            this.a = round2;
        } else {
            float f4 = (float) i2;
            float f5 = builder.e;
            float f6 = builder.d;
            float f7 = f4 / (f5 + f6);
            this.b = Math.round(f6 * f7);
            this.a = Math.round(f7 * builder.e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            a(this.b);
            a(this.a);
            a(i);
            a(round);
            builder.b.getMemoryClass();
            builder.b.isLowRamDevice();
        }
    }

    public final String a(int i) {
        return Formatter.formatFileSize(this.c, (long) i);
    }

    public int getArrayPoolSizeInBytes() {
        return this.d;
    }

    public int getBitmapPoolSize() {
        return this.a;
    }

    public int getMemoryCacheSize() {
        return this.b;
    }
}
