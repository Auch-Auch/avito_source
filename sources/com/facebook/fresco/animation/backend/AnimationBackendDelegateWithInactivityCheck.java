package com.facebook.fresco.animation.backend;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.common.time.MonotonicClock;
import com.facebook.fresco.animation.backend.AnimationBackend;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
public class AnimationBackendDelegateWithInactivityCheck<T extends AnimationBackend> extends AnimationBackendDelegate<T> {
    public final MonotonicClock e;
    public final ScheduledExecutorService f;
    public boolean g = false;
    public long h;
    public long i = 2000;
    public long j = 1000;
    @Nullable
    public InactivityListener k;
    public final Runnable l = new a();

    public interface InactivityListener {
        void onInactive();
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (AnimationBackendDelegateWithInactivityCheck.this) {
                AnimationBackendDelegateWithInactivityCheck animationBackendDelegateWithInactivityCheck = AnimationBackendDelegateWithInactivityCheck.this;
                boolean z = false;
                animationBackendDelegateWithInactivityCheck.g = false;
                if (animationBackendDelegateWithInactivityCheck.e.now() - animationBackendDelegateWithInactivityCheck.h > animationBackendDelegateWithInactivityCheck.i) {
                    z = true;
                }
                if (z) {
                    InactivityListener inactivityListener = AnimationBackendDelegateWithInactivityCheck.this.k;
                    if (inactivityListener != null) {
                        inactivityListener.onInactive();
                    }
                } else {
                    AnimationBackendDelegateWithInactivityCheck.this.a();
                }
            }
        }
    }

    public AnimationBackendDelegateWithInactivityCheck(@Nullable T t, @Nullable InactivityListener inactivityListener, MonotonicClock monotonicClock, ScheduledExecutorService scheduledExecutorService) {
        super(t);
        this.k = inactivityListener;
        this.e = monotonicClock;
        this.f = scheduledExecutorService;
    }

    public static <T extends AnimationBackend & InactivityListener> AnimationBackendDelegate<T> createForBackend(T t, MonotonicClock monotonicClock, ScheduledExecutorService scheduledExecutorService) {
        return createForBackend(t, (InactivityListener) t, monotonicClock, scheduledExecutorService);
    }

    public final synchronized void a() {
        if (!this.g) {
            this.g = true;
            this.f.schedule(this.l, this.j, TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackendDelegate, com.facebook.fresco.animation.backend.AnimationBackend
    public boolean drawFrame(Drawable drawable, Canvas canvas, int i2) {
        this.h = this.e.now();
        boolean drawFrame = super.drawFrame(drawable, canvas, i2);
        a();
        return drawFrame;
    }

    public long getInactivityCheckPollingTimeMs() {
        return this.j;
    }

    public long getInactivityThresholdMs() {
        return this.i;
    }

    public void setInactivityCheckPollingTimeMs(long j2) {
        this.j = j2;
    }

    public void setInactivityListener(@Nullable InactivityListener inactivityListener) {
        this.k = inactivityListener;
    }

    public void setInactivityThresholdMs(long j2) {
        this.i = j2;
    }

    public static <T extends AnimationBackend> AnimationBackendDelegate<T> createForBackend(T t, InactivityListener inactivityListener, MonotonicClock monotonicClock, ScheduledExecutorService scheduledExecutorService) {
        return new AnimationBackendDelegateWithInactivityCheck(t, inactivityListener, monotonicClock, scheduledExecutorService);
    }
}
