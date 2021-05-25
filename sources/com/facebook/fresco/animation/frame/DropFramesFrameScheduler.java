package com.facebook.fresco.animation.frame;

import com.facebook.common.internal.VisibleForTesting;
import com.facebook.fresco.animation.backend.AnimationInformation;
public class DropFramesFrameScheduler implements FrameScheduler {
    public final AnimationInformation a;
    public long b = -1;

    public DropFramesFrameScheduler(AnimationInformation animationInformation) {
        this.a = animationInformation;
    }

    @VisibleForTesting
    public int a(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += (long) this.a.getFrameDurationMs(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public int getFrameNumberToRender(long j, long j2) {
        long loopDurationMs = getLoopDurationMs();
        if (loopDurationMs == 0) {
            return a(0);
        }
        if (isInfiniteAnimation() || j / loopDurationMs < ((long) this.a.getLoopCount())) {
            return a(j % loopDurationMs);
        }
        return -1;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public long getLoopDurationMs() {
        long j = this.b;
        if (j != -1) {
            return j;
        }
        this.b = 0;
        int frameCount = this.a.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.b += (long) this.a.getFrameDurationMs(i);
        }
        return this.b;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public long getTargetRenderTimeForNextFrameMs(long j) {
        long loopDurationMs = getLoopDurationMs();
        long j2 = 0;
        if (loopDurationMs == 0) {
            return -1;
        }
        if (!isInfiniteAnimation() && j / getLoopDurationMs() >= ((long) this.a.getLoopCount())) {
            return -1;
        }
        long j3 = j % loopDurationMs;
        int frameCount = this.a.getFrameCount();
        for (int i = 0; i < frameCount && j2 <= j3; i++) {
            j2 += (long) this.a.getFrameDurationMs(i);
        }
        return (j2 - j3) + j;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public long getTargetRenderTimeMs(int i) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j += (long) this.a.getFrameDurationMs(i);
        }
        return j;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public boolean isInfiniteAnimation() {
        return this.a.getLoopCount() == 0;
    }
}
