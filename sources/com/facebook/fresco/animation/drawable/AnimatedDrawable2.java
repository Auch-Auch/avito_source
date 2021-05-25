package com.facebook.fresco.animation.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.logging.FLog;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.drawee.drawable.DrawableProperties;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.frame.DropFramesFrameScheduler;
import com.facebook.fresco.animation.frame.FrameScheduler;
import javax.annotation.Nullable;
public class AnimatedDrawable2 extends Drawable implements Animatable, DrawableWithCaches {
    public static final Class<?> r = AnimatedDrawable2.class;
    public static final AnimationListener s = new BaseAnimationListener();
    @Nullable
    public AnimationBackend a;
    @Nullable
    public FrameScheduler b;
    public volatile boolean c;
    public long d;
    public long e;
    public long f;
    public int g;
    public long h;
    public long i;
    public int j;
    public long k;
    public long l;
    public int m;
    public volatile AnimationListener n;
    @Nullable
    public volatile DrawListener o;
    @Nullable
    public DrawableProperties p;
    public final Runnable q;

    public interface DrawListener {
        void onDraw(AnimatedDrawable2 animatedDrawable2, FrameScheduler frameScheduler, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AnimatedDrawable2 animatedDrawable2 = AnimatedDrawable2.this;
            animatedDrawable2.unscheduleSelf(animatedDrawable2.q);
            AnimatedDrawable2.this.invalidateSelf();
        }
    }

    public AnimatedDrawable2() {
        this(null);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        long j2;
        long j3;
        long j4;
        long j5;
        AnimatedDrawable2 animatedDrawable2;
        if (this.a != null && this.b != null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (this.c) {
                j2 = (uptimeMillis - this.d) + this.l;
            } else {
                j2 = Math.max(this.e, 0L);
            }
            int frameNumberToRender = this.b.getFrameNumberToRender(j2, this.e);
            if (frameNumberToRender == -1) {
                frameNumberToRender = this.a.getFrameCount() - 1;
                this.n.onAnimationStop(this);
                this.c = false;
            } else if (frameNumberToRender == 0 && this.g != -1 && uptimeMillis >= this.f) {
                this.n.onAnimationRepeat(this);
            }
            boolean drawFrame = this.a.drawFrame(this, canvas, frameNumberToRender);
            if (drawFrame) {
                this.n.onAnimationFrame(this, frameNumberToRender);
                this.g = frameNumberToRender;
            }
            if (!drawFrame) {
                this.m++;
                if (FLog.isLoggable(2)) {
                    FLog.v(r, "Dropped a frame. Count: %s", Integer.valueOf(this.m));
                }
            }
            long uptimeMillis2 = SystemClock.uptimeMillis();
            if (this.c) {
                long targetRenderTimeForNextFrameMs = this.b.getTargetRenderTimeForNextFrameMs(uptimeMillis2 - this.d);
                if (targetRenderTimeForNextFrameMs != -1) {
                    long j6 = this.k + targetRenderTimeForNextFrameMs;
                    long j7 = this.d + j6;
                    this.f = j7;
                    scheduleSelf(this.q, j7);
                    j3 = j6;
                } else {
                    this.n.onAnimationStop(this);
                    this.c = false;
                    j3 = -1;
                }
                j4 = targetRenderTimeForNextFrameMs;
            } else {
                j4 = -1;
                j3 = -1;
            }
            DrawListener drawListener = this.o;
            if (drawListener != null) {
                drawListener.onDraw(this, this.b, frameNumberToRender, drawFrame, this.c, this.d, j2, this.e, uptimeMillis, uptimeMillis2, j4, j3);
                animatedDrawable2 = this;
                j5 = j2;
            } else {
                animatedDrawable2 = this;
                j5 = j2;
            }
            animatedDrawable2.e = j5;
        }
    }

    @Override // com.facebook.drawable.base.DrawableWithCaches
    public void dropCaches() {
        AnimationBackend animationBackend = this.a;
        if (animationBackend != null) {
            animationBackend.clear();
        }
    }

    @Nullable
    public AnimationBackend getAnimationBackend() {
        return this.a;
    }

    public long getDroppedFrames() {
        return (long) this.m;
    }

    public int getFrameCount() {
        AnimationBackend animationBackend = this.a;
        if (animationBackend == null) {
            return 0;
        }
        return animationBackend.getFrameCount();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        AnimationBackend animationBackend = this.a;
        if (animationBackend == null) {
            return super.getIntrinsicHeight();
        }
        return animationBackend.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        AnimationBackend animationBackend = this.a;
        if (animationBackend == null) {
            return super.getIntrinsicWidth();
        }
        return animationBackend.getIntrinsicWidth();
    }

    public int getLoopCount() {
        AnimationBackend animationBackend = this.a;
        if (animationBackend == null) {
            return 0;
        }
        return animationBackend.getLoopCount();
    }

    public long getLoopDurationMs() {
        if (this.a == null) {
            return 0;
        }
        FrameScheduler frameScheduler = this.b;
        if (frameScheduler != null) {
            return frameScheduler.getLoopDurationMs();
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.a.getFrameCount(); i3++) {
            i2 += this.a.getFrameDurationMs(i3);
        }
        return (long) i2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public long getStartTimeMs() {
        return this.d;
    }

    public boolean isInfiniteAnimation() {
        FrameScheduler frameScheduler = this.b;
        return frameScheduler != null && frameScheduler.isInfiniteAnimation();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.c;
    }

    public void jumpToFrame(int i2) {
        FrameScheduler frameScheduler;
        if (this.a != null && (frameScheduler = this.b) != null) {
            this.e = frameScheduler.getTargetRenderTimeMs(i2);
            long uptimeMillis = SystemClock.uptimeMillis() - this.e;
            this.d = uptimeMillis;
            this.f = uptimeMillis;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        AnimationBackend animationBackend = this.a;
        if (animationBackend != null) {
            animationBackend.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i2) {
        if (this.c) {
            return false;
        }
        long j2 = (long) i2;
        if (this.e == j2) {
            return false;
        }
        this.e = j2;
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (this.p == null) {
            this.p = new DrawableProperties();
        }
        this.p.setAlpha(i2);
        AnimationBackend animationBackend = this.a;
        if (animationBackend != null) {
            animationBackend.setAlpha(i2);
        }
    }

    public void setAnimationBackend(@Nullable AnimationBackend animationBackend) {
        DropFramesFrameScheduler dropFramesFrameScheduler;
        this.a = animationBackend;
        if (animationBackend != null) {
            this.b = new DropFramesFrameScheduler(animationBackend);
            this.a.setBounds(getBounds());
            DrawableProperties drawableProperties = this.p;
            if (drawableProperties != null) {
                drawableProperties.applyTo(this);
            }
        }
        AnimationBackend animationBackend2 = this.a;
        if (animationBackend2 == null) {
            dropFramesFrameScheduler = null;
        } else {
            dropFramesFrameScheduler = new DropFramesFrameScheduler(animationBackend2);
        }
        this.b = dropFramesFrameScheduler;
        stop();
    }

    public void setAnimationListener(@Nullable AnimationListener animationListener) {
        if (animationListener == null) {
            animationListener = s;
        }
        this.n = animationListener;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.p == null) {
            this.p = new DrawableProperties();
        }
        this.p.setColorFilter(colorFilter);
        AnimationBackend animationBackend = this.a;
        if (animationBackend != null) {
            animationBackend.setColorFilter(colorFilter);
        }
    }

    public void setDrawListener(@Nullable DrawListener drawListener) {
        this.o = drawListener;
    }

    public void setFrameSchedulingDelayMs(long j2) {
        this.k = j2;
    }

    public void setFrameSchedulingOffsetMs(long j2) {
        this.l = j2;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        AnimationBackend animationBackend;
        if (!this.c && (animationBackend = this.a) != null && animationBackend.getFrameCount() > 1) {
            this.c = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            long j2 = uptimeMillis - this.h;
            this.d = j2;
            this.f = j2;
            this.e = uptimeMillis - this.i;
            this.g = this.j;
            invalidateSelf();
            this.n.onAnimationStart(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.c) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.h = uptimeMillis - this.d;
            this.i = uptimeMillis - this.e;
            this.j = this.g;
            this.c = false;
            this.d = 0;
            this.f = 0;
            this.e = -1;
            this.g = -1;
            unscheduleSelf(this.q);
            this.n.onAnimationStop(this);
        }
    }

    public AnimatedDrawable2(@Nullable AnimationBackend animationBackend) {
        this.k = 8;
        this.l = 0;
        this.n = s;
        DropFramesFrameScheduler dropFramesFrameScheduler = null;
        this.o = null;
        this.q = new a();
        this.a = animationBackend;
        this.b = animationBackend != null ? new DropFramesFrameScheduler(animationBackend) : dropFramesFrameScheduler;
    }
}
