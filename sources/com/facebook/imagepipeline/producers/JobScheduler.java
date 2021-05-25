package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.instrumentation.FrescoInstrumenter;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
public class JobScheduler {
    public final Executor a;
    public final JobRunnable b;
    public final Runnable c = new a();
    public final Runnable d = new b();
    public final int e;
    @VisibleForTesting
    @GuardedBy("this")
    public EncodedImage f = null;
    @VisibleForTesting
    @GuardedBy("this")
    public int g = 0;
    @VisibleForTesting
    @GuardedBy("this")
    public c h = c.IDLE;
    @VisibleForTesting
    @GuardedBy("this")
    public long i = 0;
    @VisibleForTesting
    @GuardedBy("this")
    public long j = 0;

    public interface JobRunnable {
        void run(EncodedImage encodedImage, int i);
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            EncodedImage encodedImage;
            int i;
            JobScheduler jobScheduler = JobScheduler.this;
            Objects.requireNonNull(jobScheduler);
            long uptimeMillis = SystemClock.uptimeMillis();
            synchronized (jobScheduler) {
                encodedImage = jobScheduler.f;
                i = jobScheduler.g;
                jobScheduler.f = null;
                jobScheduler.g = 0;
                jobScheduler.h = c.RUNNING;
                jobScheduler.j = uptimeMillis;
            }
            try {
                if (JobScheduler.c(encodedImage, i)) {
                    jobScheduler.b.run(encodedImage, i);
                }
            } finally {
                EncodedImage.closeSafely(encodedImage);
                jobScheduler.b();
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JobScheduler jobScheduler = JobScheduler.this;
            jobScheduler.a.execute(FrescoInstrumenter.decorateRunnable(jobScheduler.c, "JobScheduler_submitJob"));
        }
    }

    @VisibleForTesting
    public enum c {
        IDLE,
        QUEUED,
        RUNNING,
        RUNNING_AND_PENDING
    }

    public JobScheduler(Executor executor, JobRunnable jobRunnable, int i2) {
        this.a = executor;
        this.b = jobRunnable;
        this.e = i2;
    }

    public static boolean c(EncodedImage encodedImage, int i2) {
        return BaseConsumer.isLast(i2) || BaseConsumer.statusHasFlag(i2, 4) || EncodedImage.isValid(encodedImage);
    }

    public final void a(long j2) {
        Runnable decorateRunnable = FrescoInstrumenter.decorateRunnable(this.d, "JobScheduler_enqueueJob");
        if (j2 > 0) {
            if (AppCompatDelegateImpl.i.l == null) {
                AppCompatDelegateImpl.i.l = Executors.newSingleThreadScheduledExecutor();
            }
            AppCompatDelegateImpl.i.l.schedule(decorateRunnable, j2, TimeUnit.MILLISECONDS);
            return;
        }
        decorateRunnable.run();
    }

    public final void b() {
        boolean z;
        long j2;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            if (this.h == c.RUNNING_AND_PENDING) {
                j2 = Math.max(this.j + ((long) this.e), uptimeMillis);
                z = true;
                this.i = uptimeMillis;
                this.h = c.QUEUED;
            } else {
                this.h = c.IDLE;
                j2 = 0;
                z = false;
            }
        }
        if (z) {
            a(j2 - uptimeMillis);
        }
    }

    public void clearJob() {
        EncodedImage encodedImage;
        synchronized (this) {
            encodedImage = this.f;
            this.f = null;
            this.g = 0;
        }
        EncodedImage.closeSafely(encodedImage);
    }

    public synchronized long getQueuedTime() {
        return this.j - this.i;
    }

    public boolean scheduleJob() {
        boolean z;
        long j2;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            z = false;
            if (!c(this.f, this.g)) {
                return false;
            }
            int ordinal = this.h.ordinal();
            if (ordinal != 0) {
                if (ordinal == 2) {
                    this.h = c.RUNNING_AND_PENDING;
                }
                j2 = 0;
            } else {
                j2 = Math.max(this.j + ((long) this.e), uptimeMillis);
                this.i = uptimeMillis;
                this.h = c.QUEUED;
                z = true;
            }
        }
        if (z) {
            a(j2 - uptimeMillis);
        }
        return true;
    }

    public boolean updateJob(EncodedImage encodedImage, int i2) {
        EncodedImage encodedImage2;
        if (!c(encodedImage, i2)) {
            return false;
        }
        synchronized (this) {
            encodedImage2 = this.f;
            this.f = EncodedImage.cloneOrNull(encodedImage);
            this.g = i2;
        }
        EncodedImage.closeSafely(encodedImage2);
        return true;
    }
}
