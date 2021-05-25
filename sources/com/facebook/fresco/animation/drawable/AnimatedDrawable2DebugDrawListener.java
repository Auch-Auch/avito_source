package com.facebook.fresco.animation.drawable;

import com.facebook.common.logging.FLog;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.frame.FrameScheduler;
public class AnimatedDrawable2DebugDrawListener implements AnimatedDrawable2.DrawListener {
    public int a = -1;
    public int b;
    public int c;
    public int d;

    @Override // com.facebook.fresco.animation.drawable.AnimatedDrawable2.DrawListener
    public void onDraw(AnimatedDrawable2 animatedDrawable2, FrameScheduler frameScheduler, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        if (animatedDrawable2.getAnimationBackend() != null) {
            int frameCount = animatedDrawable2.getAnimationBackend().getFrameCount();
            long j8 = j2 - j3;
            this.d++;
            int i2 = this.a;
            int i3 = (i2 + 1) % frameCount;
            if (i3 != i) {
                if (i2 == i) {
                    this.c++;
                } else {
                    int i4 = (i - i3) % frameCount;
                    if (i4 < 0) {
                        i4 += frameCount;
                    }
                    this.b += i4;
                }
            }
            this.a = i;
            FLog.d((Class<?>) AnimatedDrawable2DebugDrawListener.class, "draw: frame: %2d, drawn: %b, delay: %3d ms, rendering: %3d ms, prev: %3d ms ago, duplicates: %3d, skipped: %3d, draw calls: %4d, anim time: %6d ms, next start: %6d ms, next scheduled: %6d ms", Integer.valueOf(i), Boolean.valueOf(z), Long.valueOf((j2 % frameScheduler.getLoopDurationMs()) - frameScheduler.getTargetRenderTimeMs(i)), Long.valueOf(j5 - j4), Long.valueOf(j8), Integer.valueOf(this.c), Integer.valueOf(this.b), Integer.valueOf(this.d), Long.valueOf(j2), Long.valueOf(j6), Long.valueOf(j7));
        }
    }
}
