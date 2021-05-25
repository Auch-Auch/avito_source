package com.evernote.android.job.patched.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.evernote.android.job.patched.internal.JobRequest;
import com.evernote.android.job.patched.internal.util.Device;
import com.evernote.android.job.patched.internal.util.JobCat;
import com.evernote.android.job.patched.internal.util.support.PersistableBundleCompat;
import java.lang.ref.WeakReference;
public abstract class Job {
    private static final JobCat CAT = new JobCat("Job");
    private Context mApplicationContext;
    private volatile boolean mCanceled;
    private WeakReference<Context> mContextReference;
    private volatile boolean mDeleted;
    private volatile long mFinishedTimeStamp = -1;
    private final Object mMonitor = new Object();
    private Params mParams;
    private Result mResult = Result.FAILURE;

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

    public final void cancel() {
        cancel(false);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.mParams.equals(((Job) obj).mParams);
    }

    @NonNull
    public final Context getContext() {
        Context context = this.mContextReference.get();
        return context == null ? this.mApplicationContext : context;
    }

    public final long getFinishedTimeStamp() {
        long j;
        synchronized (this.mMonitor) {
            j = this.mFinishedTimeStamp;
        }
        return j;
    }

    @NonNull
    public final Params getParams() {
        return this.mParams;
    }

    public final Result getResult() {
        return this.mResult;
    }

    public int hashCode() {
        return this.mParams.hashCode();
    }

    public final boolean isCanceled() {
        boolean z;
        synchronized (this.mMonitor) {
            z = this.mCanceled;
        }
        return z;
    }

    public final boolean isDeleted() {
        boolean z;
        synchronized (this.mMonitor) {
            z = this.mDeleted;
        }
        return z;
    }

    public final boolean isFinished() {
        boolean z;
        synchronized (this.mMonitor) {
            z = this.mFinishedTimeStamp > 0;
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
        return meetsRequirements(false);
    }

    public void onCancel() {
    }

    @WorkerThread
    public void onReschedule(int i) {
    }

    @NonNull
    @WorkerThread
    public abstract Result onRunJob(@NonNull Params params);

    public final Result runJob() {
        try {
            if (!(this instanceof DailyJob)) {
                if (!meetsRequirements(true)) {
                    this.mResult = getParams().isPeriodic() ? Result.FAILURE : Result.RESCHEDULE;
                    return this.mResult;
                }
            }
            this.mResult = onRunJob(getParams());
            return this.mResult;
        } finally {
            this.mFinishedTimeStamp = System.currentTimeMillis();
        }
    }

    public final Job setContext(Context context) {
        this.mContextReference = new WeakReference<>(context);
        this.mApplicationContext = context.getApplicationContext();
        return this;
    }

    public final Job setRequest(JobRequest jobRequest, @NonNull Bundle bundle) {
        this.mParams = new Params(jobRequest, bundle, null);
        return this;
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("job{id=");
        L.append(this.mParams.getId());
        L.append(", finished=");
        L.append(isFinished());
        L.append(", result=");
        L.append(this.mResult);
        L.append(", canceled=");
        L.append(this.mCanceled);
        L.append(", periodic=");
        L.append(this.mParams.isPeriodic());
        L.append(", class=");
        L.append(getClass().getSimpleName());
        L.append(", tag=");
        L.append(this.mParams.getTag());
        L.append('}');
        return L.toString();
    }

    public final boolean cancel(boolean z) {
        synchronized (this.mMonitor) {
            if (isFinished()) {
                return false;
            }
            if (!this.mCanceled) {
                this.mCanceled = true;
                onCancel();
            }
            this.mDeleted = z | this.mDeleted;
            return true;
        }
    }

    public boolean meetsRequirements(boolean z) {
        if (z && !getParams().a.requirementsEnforced()) {
            return true;
        }
        if (!isRequirementChargingMet()) {
            CAT.w("Job requires charging, reschedule");
            return false;
        } else if (!isRequirementDeviceIdleMet()) {
            CAT.w("Job requires device to be idle, reschedule");
            return false;
        } else if (!isRequirementNetworkTypeMet()) {
            CAT.w("Job requires network to be %s, but was %s", getParams().a.requiredNetworkType(), Device.getNetworkType(getContext()));
            return false;
        } else if (!isRequirementBatteryNotLowMet()) {
            CAT.w("Job requires battery not be low, reschedule");
            return false;
        } else if (isRequirementStorageNotLowMet()) {
            return true;
        } else {
            CAT.w("Job requires storage not be low, reschedule");
            return false;
        }
    }
}
