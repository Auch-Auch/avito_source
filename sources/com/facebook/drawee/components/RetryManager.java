package com.facebook.drawee.components;
public class RetryManager {
    public boolean a;
    public int b;
    public int c;

    public RetryManager() {
        init();
    }

    public static RetryManager newInstance() {
        return new RetryManager();
    }

    public void init() {
        this.a = false;
        this.b = 4;
        reset();
    }

    public boolean isTapToRetryEnabled() {
        return this.a;
    }

    public void notifyTapToRetry() {
        this.c++;
    }

    public void reset() {
        this.c = 0;
    }

    public void setMaxTapToRetryAttemps(int i) {
        this.b = i;
    }

    public void setTapToRetryEnabled(boolean z) {
        this.a = z;
    }

    public boolean shouldRetryOnTap() {
        return this.a && this.c < this.b;
    }
}
