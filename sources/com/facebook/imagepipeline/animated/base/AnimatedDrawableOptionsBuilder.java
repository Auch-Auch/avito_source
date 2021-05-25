package com.facebook.imagepipeline.animated.base;
public class AnimatedDrawableOptionsBuilder {
    public boolean a;
    public boolean b = true;
    public int c = -1;
    public boolean d;

    public AnimatedDrawableOptions build() {
        return new AnimatedDrawableOptions(this);
    }

    public boolean getAllowPrefetching() {
        return this.b;
    }

    public boolean getEnableDebugging() {
        return this.d;
    }

    public boolean getForceKeepAllFramesInMemory() {
        return this.a;
    }

    public int getMaximumBytes() {
        return this.c;
    }

    public AnimatedDrawableOptionsBuilder setAllowPrefetching(boolean z) {
        this.b = z;
        return this;
    }

    public AnimatedDrawableOptionsBuilder setEnableDebugging(boolean z) {
        this.d = z;
        return this;
    }

    public AnimatedDrawableOptionsBuilder setForceKeepAllFramesInMemory(boolean z) {
        this.a = z;
        return this;
    }

    public AnimatedDrawableOptionsBuilder setMaximumBytes(int i) {
        this.c = i;
        return this;
    }
}
