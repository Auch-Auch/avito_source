package com.facebook.imagepipeline.memory;
public class BitmapCounterConfig {
    public static final int DEFAULT_MAX_BITMAP_COUNT = 384;
    public int a = 384;

    public BitmapCounterConfig(Builder builder) {
        this.a = builder.getMaxBitmapCount();
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public int getMaxBitmapCount() {
        return this.a;
    }

    public void setMaxBitmapCount(int i) {
        this.a = i;
    }

    public static class Builder {
        public int a = 384;

        public Builder() {
        }

        public BitmapCounterConfig build() {
            return new BitmapCounterConfig(this);
        }

        public int getMaxBitmapCount() {
            return this.a;
        }

        public Builder setMaxBitmapCount(int i) {
            this.a = i;
            return this;
        }

        public Builder(a aVar) {
        }
    }
}
