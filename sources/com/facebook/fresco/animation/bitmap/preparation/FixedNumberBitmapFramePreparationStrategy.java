package com.facebook.fresco.animation.bitmap.preparation;

import com.facebook.common.logging.FLog;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
public class FixedNumberBitmapFramePreparationStrategy implements BitmapFramePreparationStrategy {
    public final int a;

    public FixedNumberBitmapFramePreparationStrategy() {
        this(3);
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy
    public void prepareFrames(BitmapFramePreparer bitmapFramePreparer, BitmapFrameCache bitmapFrameCache, AnimationBackend animationBackend, int i) {
        for (int i2 = 1; i2 <= this.a; i2++) {
            int frameCount = (i + i2) % animationBackend.getFrameCount();
            if (FLog.isLoggable(2)) {
                FLog.v(FixedNumberBitmapFramePreparationStrategy.class, "Preparing frame %d, last drawn: %d", Integer.valueOf(frameCount), Integer.valueOf(i));
            }
            if (!bitmapFramePreparer.prepareFrame(bitmapFrameCache, animationBackend, frameCount)) {
                return;
            }
        }
    }

    public FixedNumberBitmapFramePreparationStrategy(int i) {
        this.a = i;
    }
}
