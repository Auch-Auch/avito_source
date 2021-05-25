package com.facebook.common.memory;
public enum MemoryTrimType {
    OnCloseToDalvikHeapLimit(0.5d),
    OnSystemMemoryCriticallyLowWhileAppInForeground(1.0d),
    OnSystemLowMemoryWhileAppInForeground(0.5d),
    OnSystemLowMemoryWhileAppInBackground(1.0d),
    OnAppBackgrounded(1.0d);
    
    public double a;

    /* access modifiers changed from: public */
    MemoryTrimType(double d) {
        this.a = d;
    }

    public double getSuggestedTrimRatio() {
        return this.a;
    }
}
