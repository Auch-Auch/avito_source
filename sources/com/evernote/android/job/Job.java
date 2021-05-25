package com.evernote.android.job;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.util.Device;
import com.evernote.android.job.util.JobCat;
import com.evernote.android.job.util.support.PersistableBundleCompat;
import java.lang.ref.WeakReference;
public abstract class Job {
    public static final JobCat i = new JobCat("Job");
    public Params a;
    public WeakReference<Context> b;
    public Context c;
    public volatile boolean d;
    public volatile boolean e;
    public volatile long f = -1;
    public Result g = Result.FAILURE;
    public final Object h = new Object();

    public static final class Params {
        public final JobRequest a;
        public PersistableBundleCompat b;
        public Bundle c;

        public Params(JobRequest jobRequest, Bundle bundle, a aVar) {
            this.a = jobRequest;
            this.c = bundle;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Params.class != obj.getClass()) {
                return false;
            }
            return this.a.equals(((Params) obj).a);
        }

        public long getBackoffMs() {
            return this.a.getBackoffMs();
        }

        public JobRequest.BackoffPolicy getBackoffPolicy() {
            return this.a.getBackoffPolicy();
        }

        public long getEndMs() {
            return this.a.getEndMs();
        }

        @NonNull
        public PersistableBundleCompat getExtras() {
            if (this.b == null) {
                PersistableBundleCompat extras = this.a.getExtras();
                this.b = extras;
                if (extras == null) {
                    this.b = new PersistableBundleCompat();
                }
            }
            return this.b;
        }

        public int getFailureCount() {
            return this.a.getFailureCount();
        }

        public long getFlexMs() {
            return this.a.getFlexMs();
        }

        public int getId() {
            return this.a.getJobId();
        }

        public long getIntervalMs() {
            return this.a.getIntervalMs();
        }

        public long getLastRun() {
            return this.a.getLastRun();
        }

        public long getScheduledAt() {
            return this.a.getScheduledAt();
        }

        public long getStartMs() {
            return this.a.getStartMs();
        }

        public String getTag() {
            return this.a.getTag();
        }

        @NonNull
        public Bundle getTransientExtras() {
            return this.c;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public boolean isExact() {
            return this.a.isExact();
        }

        public boolean isPeriodic() {
            return this.a.isPeriodic();
        }

        public boolean isTransient() {
            return this.a.isTransient();
        }

        public JobRequest.NetworkType requiredNetworkType() {
            return this.a.requiredNetworkType();
        }

        public boolean requirementsEnforced() {
            return this.a.requirementsEnforced();
        }

        public boolean requiresBatteryNotLow() {
            return this.a.requiresBatteryNotLow();
        }

        public boolean requiresCharging() {
            return this.a.requiresCharging();
        }

        public boolean requiresDeviceIdle() {
            return this.a.requiresDeviceIdle();
        }

        public boolean requiresStorageNotLow() {
            return this.a.requiresStorageNotLow();
        }
    }

    public enum Result {
        SUCCESS,
        FAILURE,
        RESCHEDULE
    }

    public final boolean a(boolean z) {
        synchronized (this.h) {
            if (isFinished()) {
                return false;
            }
            if (!this.d) {
                this.d = true;
                onCancel();
            }
            this.e = z | this.e;
            return true;
        }
    }

    public final boolean b() {
        boolean z;
        synchronized (this.h) {
            z = this.e;
        }
        return z;
    }

    public boolean c(boolean z) {
        if (z && !getParams().a.requirementsEnforced()) {
            return true;
        }
        if (!isRequirementChargingMet()) {
            i.w("Job requires charging, reschedule");
            return false;
        } else if (!isRequirementDeviceIdleMet()) {
            i.w("Job requires device to be idle, reschedule");
            return false;
        } else if (!isRequirementNetworkTypeMet()) {
            i.w("Job requires network to be %s, but was %s", getParams().a.requiredNetworkType(), Device.getNetworkType(getContext()));
            return false;
        } else if (!isRequirementBatteryNotLowMet()) {
            i.w("Job requires battery not be low, reschedule");
            return false;
        } else if (isRequirementStorageNotLowMet()) {
            return true;
        } else {
            i.w("Job requires storage not be low, reschedule");
            return false;
        }
    }

    public final void cancel() {
        a(false);
    }

    public final Result d() {
        try {
            if (!(this instanceof DailyJob)) {
                if (!c(true)) {
                    this.g = getParams().isPeriodic() ? Result.FAILURE : Result.RESCHEDULE;
                    return this.g;
                }
            }
            this.g = onRunJob(getParams());
            return this.g;
        } finally {
            this.f = System.currentTimeMillis();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.a.equals(((Job) obj).a);
    }

    @NonNull
    public final Context getContext() {
        Context context = this.b.get();
        return context == null ? this.c : context;
    }

    @NonNull
    public final Params getParams() {
        return this.a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public final boolean isCanceled() {
        boolean z;
        synchronized (this.h) {
            z = this.d;
        }
        return z;
    }

    public final boolean isFinished() {
        boolean z;
        synchronized (this.h) {
            z = this.f > 0;
        }
        return z;
    }

    public boolean isRequirementBatteryNotLowMet() {
        return !getParams().a.requiresBatteryNotLow() || !Device.getBatteryStatus(getContext()).isBatteryLow();
    }

    public boolean isRequirementChargingMet() {
        return !getParams().a.requiresCharging() || Device.getBatteryStatus(getContext()).isCharging();
    }

    public boolean isRequirementDeviceIdleMet() {
        return !getParams().a.requiresDeviceIdle() || Device.isIdle(getContext());
    }

    public boolean isRequirementNetworkTypeMet() {
        JobRequest.NetworkType requiredNetworkType = getParams().a.requiredNetworkType();
        JobRequest.NetworkType networkType = JobRequest.NetworkType.ANY;
        if (requiredNetworkType == networkType) {
            return true;
        }
        JobRequest.NetworkType networkType2 = Device.getNetworkType(getContext());
        int ordinal = requiredNetworkType.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        throw new IllegalStateException("not implemented");
                    } else if (networkType2 == JobRequest.NetworkType.CONNECTED || networkType2 == JobRequest.NetworkType.NOT_ROAMING) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (networkType2 == JobRequest.NetworkType.NOT_ROAMING || networkType2 == JobRequest.NetworkType.UNMETERED || networkType2 == JobRequest.NetworkType.METERED) {
                    return true;
                } else {
                    return false;
                }
            } else if (networkType2 == JobRequest.NetworkType.UNMETERED) {
                return true;
            } else {
                return false;
            }
        } else if (networkType2 != networkType) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isRequirementStorageNotLowMet() {
        return !getParams().a.requiresStorageNotLow() || !Device.isStorageLow();
    }

    public boolean meetsRequirements() {
        return c(false);
    }

    public void onCancel() {
    }

    @WorkerThread
    public void onReschedule(int i2) {
    }

    @NonNull
    @WorkerThread
    public abstract Result onRunJob(@NonNull Params params);

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("job{id=");
        L.append(this.a.getId());
        L.append(", finished=");
        L.append(isFinished());
        L.append(", result=");
        L.append(this.g);
        L.append(", canceled=");
        L.append(this.d);
        L.append(", periodic=");
        L.append(this.a.isPeriodic());
        L.append(", class=");
        L.append(getClass().getSimpleName());
        L.append(", tag=");
        L.append(this.a.getTag());
        L.append('}');
        return L.toString();
    }
}
