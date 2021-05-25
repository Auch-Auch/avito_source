package com.bumptech.glide.load.engine.prefill;

import a2.b.a.a.a;
import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import com.bumptech.glide.util.Preconditions;
public final class PreFillType {
    public final int a;
    public final int b;
    public final Bitmap.Config c;
    public final int d;

    public static class Builder {
        public final int a;
        public final int b;
        public Bitmap.Config c;
        public int d;

        public Builder(int i) {
            this(i, i);
        }

        public Builder setConfig(@Nullable Bitmap.Config config) {
            this.c = config;
            return this;
        }

        public Builder setWeight(int i) {
            if (i > 0) {
                this.d = i;
                return this;
            }
            throw new IllegalArgumentException("Weight must be > 0");
        }

        public Builder(int i, int i2) {
            this.d = 1;
            if (i <= 0) {
                throw new IllegalArgumentException("Width must be > 0");
            } else if (i2 > 0) {
                this.a = i;
                this.b = i2;
            } else {
                throw new IllegalArgumentException("Height must be > 0");
            }
        }
    }

    static {
        Bitmap.Config config = Bitmap.Config.RGB_565;
    }

    public PreFillType(int i, int i2, Bitmap.Config config, int i3) {
        this.c = (Bitmap.Config) Preconditions.checkNotNull(config, "Config must not be null");
        this.a = i;
        this.b = i2;
        this.d = i3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PreFillType)) {
            return false;
        }
        PreFillType preFillType = (PreFillType) obj;
        if (this.b == preFillType.b && this.a == preFillType.a && this.d == preFillType.d && this.c == preFillType.c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.c.hashCode() + (((this.a * 31) + this.b) * 31)) * 31) + this.d;
    }

    public String toString() {
        StringBuilder L = a.L("PreFillSize{width=");
        L.append(this.a);
        L.append(", height=");
        L.append(this.b);
        L.append(", config=");
        L.append(this.c);
        L.append(", weight=");
        return a.i(L, this.d, '}');
    }
}
