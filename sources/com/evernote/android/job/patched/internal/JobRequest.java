package com.evernote.android.job.patched.internal;

import a2.f.a.a.i.a.d;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.evernote.android.job.patched.internal.util.JobCat;
import com.evernote.android.job.patched.internal.util.JobPreconditions;
import com.evernote.android.job.patched.internal.util.support.PersistableBundleCompat;
import com.facebook.applinks.AppLinkData;
import com.facebook.internal.FacebookRequestErrorClassification;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
public final class JobRequest {
    public static final long DEFAULT_BACKOFF_MS = 30000;
    public static final BackoffPolicy DEFAULT_BACKOFF_POLICY = BackoffPolicy.EXPONENTIAL;
    public static final JobScheduledCallback DEFAULT_JOB_SCHEDULED_CALLBACK = new a();
    public static final NetworkType DEFAULT_NETWORK_TYPE = NetworkType.ANY;
    public static final long MIN_FLEX;
    public static final long MIN_INTERVAL;
    public static final JobCat g = new JobCat("JobRequest");
    public final Builder a;
    public int b;
    public long c;
    public boolean d;
    public boolean e;
    public long f;

    public enum BackoffPolicy {
        LINEAR,
        EXPONENTIAL
    }

    public interface JobScheduledCallback {
        public static final int JOB_ID_ERROR = -1;

        void onJobScheduled(int i, @NonNull String str, @Nullable Exception exc);
    }

    public enum NetworkType {
        ANY,
        CONNECTED,
        UNMETERED,
        NOT_ROAMING,
        METERED
    }

    public static class a implements JobScheduledCallback {
        @Override // com.evernote.android.job.patched.internal.JobRequest.JobScheduledCallback
        public void onJobScheduled(int i, @NonNull String str, @Nullable Exception exc) {
            if (exc != null) {
                JobRequest.g.e(exc, "The job with tag %s couldn't be scheduled", str);
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ JobScheduledCallback a;

        public b(JobScheduledCallback jobScheduledCallback) {
            this.a = jobScheduledCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.onJobScheduled(JobRequest.this.schedule(), JobRequest.this.getTag(), null);
            } catch (Exception e) {
                this.a.onJobScheduled(-1, JobRequest.this.getTag(), e);
            }
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        MIN_INTERVAL = timeUnit.toMillis(15);
        MIN_FLEX = timeUnit.toMillis(5);
    }

    public JobRequest(Builder builder, a aVar) {
        this.a = builder;
    }

    public static JobRequest a(Cursor cursor) {
        JobRequest build = new Builder(cursor, (a) null).build();
        build.b = cursor.getInt(cursor.getColumnIndex("numFailures"));
        build.c = cursor.getLong(cursor.getColumnIndex("scheduledAt"));
        boolean z = false;
        build.d = cursor.getInt(cursor.getColumnIndex("started")) > 0;
        if (cursor.getInt(cursor.getColumnIndex("flexSupport")) > 0) {
            z = true;
        }
        build.e = z;
        build.f = cursor.getLong(cursor.getColumnIndex("lastRun"));
        JobPreconditions.checkArgumentNonnegative(build.b, "failure count can't be negative");
        JobPreconditions.checkArgumentNonnegative(build.c, "scheduled at can't be negative");
        return build;
    }

    public long b() {
        long j = 0;
        if (isPeriodic()) {
            return 0;
        }
        int ordinal = getBackoffPolicy().ordinal();
        if (ordinal == 0) {
            j = getBackoffMs() * ((long) this.b);
        } else if (ordinal != 1) {
            throw new IllegalStateException("not implemented");
        } else if (this.b != 0) {
            j = (long) (Math.pow(2.0d, (double) (this.b - 1)) * ((double) getBackoffMs()));
        }
        return Math.min(j, TimeUnit.HOURS.toMillis(5));
    }

    public JobApi c() {
        if (this.a.n) {
            return JobApi.V_14;
        }
        return JobApi.getDefault(JobManager.instance().a);
    }

    public Builder cancelAndEdit() {
        long j = this.c;
        JobManager.instance().cancel(getJobId());
        Builder builder = new Builder(this.a, false);
        this.d = false;
        if (!isPeriodic()) {
            long currentTimeMillis = JobConfig.getClock().currentTimeMillis() - j;
            builder.setExecutionWindow(Math.max(1L, getStartMs() - currentTimeMillis), Math.max(1L, getEndMs() - currentTimeMillis));
        }
        return builder;
    }

    public JobRequest d(boolean z, boolean z2) {
        JobRequest build = new Builder(this.a, z2).build();
        if (z) {
            build.b = this.b + 1;
        }
        try {
            build.schedule();
        } catch (Exception e2) {
            g.e(e2);
        }
        return build;
    }

    public void e(boolean z) {
        this.d = z;
        ContentValues contentValues = new ContentValues();
        contentValues.put("started", Boolean.valueOf(this.d));
        JobManager.instance().c.i(this, contentValues);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || JobRequest.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((JobRequest) obj).a);
    }

    public void f(boolean z, boolean z2) {
        ContentValues contentValues = new ContentValues();
        if (z) {
            int i = this.b + 1;
            this.b = i;
            contentValues.put("numFailures", Integer.valueOf(i));
        }
        if (z2) {
            long currentTimeMillis = JobConfig.getClock().currentTimeMillis();
            this.f = currentTimeMillis;
            contentValues.put("lastRun", Long.valueOf(currentTimeMillis));
        }
        JobManager.instance().c.i(this, contentValues);
    }

    public long getBackoffMs() {
        return this.a.e;
    }

    public BackoffPolicy getBackoffPolicy() {
        return this.a.f;
    }

    public long getEndMs() {
        return this.a.d;
    }

    public PersistableBundleCompat getExtras() {
        Builder builder = this.a;
        if (builder.p == null && !TextUtils.isEmpty(builder.q)) {
            Builder builder2 = this.a;
            builder2.p = PersistableBundleCompat.fromXml(builder2.q);
        }
        return this.a.p;
    }

    public int getFailureCount() {
        return this.b;
    }

    public long getFlexMs() {
        return this.a.h;
    }

    public long getIntervalMs() {
        return this.a.g;
    }

    public int getJobId() {
        return this.a.a;
    }

    public long getLastRun() {
        return this.f;
    }

    public long getScheduledAt() {
        return this.c;
    }

    public long getStartMs() {
        return this.a.c;
    }

    @NonNull
    public String getTag() {
        return this.a.b;
    }

    @NonNull
    public Bundle getTransientExtras() {
        return this.a.t;
    }

    public boolean hasRequirements() {
        return requiresCharging() || requiresDeviceIdle() || requiresBatteryNotLow() || requiresStorageNotLow() || requiredNetworkType() != DEFAULT_NETWORK_TYPE;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public boolean isExact() {
        return this.a.n;
    }

    public boolean isPeriodic() {
        return getIntervalMs() > 0;
    }

    public boolean isTransient() {
        return this.a.s;
    }

    public boolean isUpdateCurrent() {
        return this.a.r;
    }

    public NetworkType requiredNetworkType() {
        return this.a.o;
    }

    public boolean requirementsEnforced() {
        return this.a.i;
    }

    public boolean requiresBatteryNotLow() {
        return this.a.l;
    }

    public boolean requiresCharging() {
        return this.a.j;
    }

    public boolean requiresDeviceIdle() {
        return this.a.k;
    }

    public boolean requiresStorageNotLow() {
        return this.a.m;
    }

    public int schedule() {
        JobManager.instance().schedule(this);
        return getJobId();
    }

    public void scheduleAsync() {
        scheduleAsync(DEFAULT_JOB_SCHEDULED_CALLBACK);
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("request{id=");
        L.append(getJobId());
        L.append(", tag=");
        L.append(getTag());
        L.append(", transient=");
        L.append(isTransient());
        L.append('}');
        return L.toString();
    }

    public void scheduleAsync(@NonNull JobScheduledCallback jobScheduledCallback) {
        JobPreconditions.checkNotNull(jobScheduledCallback);
        JobConfig.getExecutorService().execute(new b(jobScheduledCallback));
    }

    public static final class Builder {
        public int a;
        public final String b;
        public long c;
        public long d;
        public long e;
        public BackoffPolicy f;
        public long g;
        public long h;
        public boolean i;
        public boolean j;
        public boolean k;
        public boolean l;
        public boolean m;
        public boolean n;
        public NetworkType o;
        public PersistableBundleCompat p;
        public String q;
        public boolean r;
        public boolean s;
        public Bundle t = Bundle.EMPTY;

        public Builder(@NonNull String str) {
            this.b = (String) JobPreconditions.checkNotEmpty(str);
            this.a = -8765;
            this.c = -1;
            this.d = -1;
            this.e = 30000;
            this.f = JobRequest.DEFAULT_BACKOFF_POLICY;
            this.o = JobRequest.DEFAULT_NETWORK_TYPE;
        }

        public Builder addExtras(@NonNull PersistableBundleCompat persistableBundleCompat) {
            PersistableBundleCompat persistableBundleCompat2 = this.p;
            if (persistableBundleCompat2 == null) {
                this.p = persistableBundleCompat;
            } else {
                persistableBundleCompat2.putAll(persistableBundleCompat);
            }
            this.q = null;
            return this;
        }

        public JobRequest build() {
            int incrementAndGet;
            JobPreconditions.checkNotEmpty(this.b);
            JobPreconditions.checkArgumentPositive(this.e, "backoffMs must be > 0");
            JobPreconditions.checkNotNull(this.f);
            JobPreconditions.checkNotNull(this.o);
            long j2 = this.g;
            if (j2 > 0) {
                BackoffPolicy backoffPolicy = JobRequest.DEFAULT_BACKOFF_POLICY;
                JobPreconditions.checkArgumentInRange(j2, JobConfig.isAllowSmallerIntervalsForMarshmallow() ? TimeUnit.MINUTES.toMillis(1) : JobRequest.MIN_INTERVAL, Long.MAX_VALUE, "intervalMs");
                JobPreconditions.checkArgumentInRange(this.h, JobConfig.isAllowSmallerIntervalsForMarshmallow() ? TimeUnit.SECONDS.toMillis(30) : JobRequest.MIN_FLEX, this.g, "flexMs");
                long j3 = this.g;
                long j4 = JobRequest.MIN_INTERVAL;
                if (j3 < j4 || this.h < JobRequest.MIN_FLEX) {
                    JobRequest.g.w("AllowSmallerIntervals enabled, this will crash on Android N and later, interval %d (minimum is %d), flex %d (minimum is %d)", Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(this.h), Long.valueOf(JobRequest.MIN_FLEX));
                }
            }
            boolean z = this.n;
            if (z && this.g > 0) {
                throw new IllegalArgumentException("Can't call setExact() on a periodic job.");
            } else if (z && this.c != this.d) {
                throw new IllegalArgumentException("Can't call setExecutionWindow() for an exact job.");
            } else if (!z || (!this.i && !this.k && !this.j && JobRequest.DEFAULT_NETWORK_TYPE.equals(this.o) && !this.l && !this.m)) {
                int i2 = (this.g > 0 ? 1 : (this.g == 0 ? 0 : -1));
                if (i2 <= 0 && (this.c == -1 || this.d == -1)) {
                    throw new IllegalArgumentException("You're trying to build a job with no constraints, this is not allowed.");
                } else if (i2 > 0 && (this.c != -1 || this.d != -1)) {
                    throw new IllegalArgumentException("Can't call setExecutionWindow() on a periodic job.");
                } else if (i2 <= 0 || (this.e == 30000 && JobRequest.DEFAULT_BACKOFF_POLICY.equals(this.f))) {
                    if (this.g <= 0 && (this.c > 3074457345618258602L || this.d > 3074457345618258602L)) {
                        JobRequest.g.w("Attention: your execution window is too large. This could result in undesired behavior, see https://github.com/evernote/android-job/wiki/FAQ");
                    }
                    if (this.g <= 0 && this.c > TimeUnit.DAYS.toMillis(365)) {
                        JobRequest.g.w("Warning: job with tag %s scheduled over a year in the future", this.b);
                    }
                    int i3 = this.a;
                    if (i3 != -8765) {
                        JobPreconditions.checkArgumentNonnegative(i3, "id can't be negative");
                    }
                    Builder builder = new Builder(this, false);
                    if (this.a == -8765) {
                        d dVar = JobManager.instance().c;
                        synchronized (dVar) {
                            if (dVar.c == null) {
                                dVar.c = new AtomicInteger(dVar.d());
                            }
                            incrementAndGet = dVar.c.incrementAndGet();
                            int jobIdOffset = JobConfig.getJobIdOffset();
                            if (incrementAndGet < jobIdOffset || incrementAndGet >= 2147480000) {
                                dVar.c.set(jobIdOffset);
                                incrementAndGet = dVar.c.incrementAndGet();
                            }
                            dVar.a.edit().putInt("JOB_ID_COUNTER_v2", incrementAndGet).apply();
                        }
                        builder.a = incrementAndGet;
                        JobPreconditions.checkArgumentNonnegative(incrementAndGet, "id can't be negative");
                    }
                    return new JobRequest(builder, null);
                } else {
                    throw new IllegalArgumentException("A periodic job will not respect any back-off policy, so calling setBackoffCriteria() with setPeriodic() is an error.");
                }
            } else {
                throw new IllegalArgumentException("Can't require any condition for an exact job.");
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && Builder.class == obj.getClass() && this.a == ((Builder) obj).a) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.a;
        }

        public Builder setBackoffCriteria(long j2, @NonNull BackoffPolicy backoffPolicy) {
            this.e = JobPreconditions.checkArgumentPositive(j2, "backoffMs must be > 0");
            this.f = (BackoffPolicy) JobPreconditions.checkNotNull(backoffPolicy);
            return this;
        }

        public Builder setExact(long j2) {
            this.n = true;
            if (j2 > 6148914691236517204L) {
                JobCat jobCat = JobRequest.g;
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                jobCat.i("exactInMs clamped from %d days to %d days", Long.valueOf(timeUnit.toDays(j2)), Long.valueOf(timeUnit.toDays(6148914691236517204L)));
                j2 = 6148914691236517204L;
            }
            return setExecutionWindow(j2, j2);
        }

        public Builder setExecutionWindow(long j2, long j3) {
            this.c = JobPreconditions.checkArgumentPositive(j2, "startInMs must be greater than 0");
            this.d = JobPreconditions.checkArgumentInRange(j3, j2, Long.MAX_VALUE, "endInMs");
            long j4 = this.c;
            if (j4 > 6148914691236517204L) {
                JobCat jobCat = JobRequest.g;
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                jobCat.i("startInMs reduced from %d days to %d days", Long.valueOf(timeUnit.toDays(j4)), Long.valueOf(timeUnit.toDays(6148914691236517204L)));
                this.c = 6148914691236517204L;
            }
            long j5 = this.d;
            if (j5 > 6148914691236517204L) {
                JobCat jobCat2 = JobRequest.g;
                TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
                jobCat2.i("endInMs reduced from %d days to %d days", Long.valueOf(timeUnit2.toDays(j5)), Long.valueOf(timeUnit2.toDays(6148914691236517204L)));
                this.d = 6148914691236517204L;
            }
            return this;
        }

        public Builder setExtras(@Nullable PersistableBundleCompat persistableBundleCompat) {
            if (persistableBundleCompat == null) {
                this.p = null;
                this.q = null;
            } else {
                this.p = new PersistableBundleCompat(persistableBundleCompat);
            }
            return this;
        }

        public Builder setPeriodic(long j2, long j3) {
            BackoffPolicy backoffPolicy = JobRequest.DEFAULT_BACKOFF_POLICY;
            this.g = JobPreconditions.checkArgumentInRange(j2, JobConfig.isAllowSmallerIntervalsForMarshmallow() ? TimeUnit.MINUTES.toMillis(1) : JobRequest.MIN_INTERVAL, Long.MAX_VALUE, "intervalMs");
            this.h = JobPreconditions.checkArgumentInRange(j3, JobConfig.isAllowSmallerIntervalsForMarshmallow() ? TimeUnit.SECONDS.toMillis(30) : JobRequest.MIN_FLEX, this.g, "flexMs");
            return this;
        }

        public Builder setRequiredNetworkType(@Nullable NetworkType networkType) {
            this.o = networkType;
            return this;
        }

        public Builder setRequirementsEnforced(boolean z) {
            this.i = z;
            return this;
        }

        public Builder setRequiresBatteryNotLow(boolean z) {
            this.l = z;
            return this;
        }

        public Builder setRequiresCharging(boolean z) {
            this.j = z;
            return this;
        }

        public Builder setRequiresDeviceIdle(boolean z) {
            this.k = z;
            return this;
        }

        public Builder setRequiresStorageNotLow(boolean z) {
            this.m = z;
            return this;
        }

        public Builder setTransientExtras(@Nullable Bundle bundle) {
            boolean z = bundle != null && !bundle.isEmpty();
            this.s = z;
            this.t = z ? new Bundle(bundle) : Bundle.EMPTY;
            return this;
        }

        public Builder setUpdateCurrent(boolean z) {
            this.r = z;
            return this;
        }

        public Builder startNow() {
            return setExact(1);
        }

        public Builder setPeriodic(long j2) {
            return setPeriodic(j2, j2);
        }

        public Builder(Cursor cursor, a aVar) {
            this.a = cursor.getInt(cursor.getColumnIndex("_id"));
            this.b = cursor.getString(cursor.getColumnIndex("tag"));
            this.c = cursor.getLong(cursor.getColumnIndex("startMs"));
            this.d = cursor.getLong(cursor.getColumnIndex("endMs"));
            this.e = cursor.getLong(cursor.getColumnIndex("backoffMs"));
            try {
                this.f = BackoffPolicy.valueOf(cursor.getString(cursor.getColumnIndex("backoffPolicy")));
            } catch (Throwable th) {
                JobRequest.g.e(th);
                this.f = JobRequest.DEFAULT_BACKOFF_POLICY;
            }
            this.g = cursor.getLong(cursor.getColumnIndex("intervalMs"));
            this.h = cursor.getLong(cursor.getColumnIndex("flexMs"));
            boolean z = false;
            this.i = cursor.getInt(cursor.getColumnIndex("requirementsEnforced")) > 0;
            this.j = cursor.getInt(cursor.getColumnIndex("requiresCharging")) > 0;
            this.k = cursor.getInt(cursor.getColumnIndex("requiresDeviceIdle")) > 0;
            this.l = cursor.getInt(cursor.getColumnIndex("requiresBatteryNotLow")) > 0;
            this.m = cursor.getInt(cursor.getColumnIndex("requiresStorageNotLow")) > 0;
            this.n = cursor.getInt(cursor.getColumnIndex("exact")) > 0;
            try {
                this.o = NetworkType.valueOf(cursor.getString(cursor.getColumnIndex("networkType")));
            } catch (Throwable th2) {
                JobRequest.g.e(th2);
                this.o = JobRequest.DEFAULT_NETWORK_TYPE;
            }
            this.q = cursor.getString(cursor.getColumnIndex(AppLinkData.ARGUMENTS_EXTRAS_KEY));
            this.s = cursor.getInt(cursor.getColumnIndex(FacebookRequestErrorClassification.KEY_TRANSIENT)) > 0 ? true : z;
        }

        public Builder(@NonNull Builder builder, boolean z) {
            int i2;
            if (z) {
                i2 = -8765;
            } else {
                i2 = builder.a;
            }
            this.a = i2;
            this.b = builder.b;
            this.c = builder.c;
            this.d = builder.d;
            this.e = builder.e;
            this.f = builder.f;
            this.g = builder.g;
            this.h = builder.h;
            this.i = builder.i;
            this.j = builder.j;
            this.k = builder.k;
            this.l = builder.l;
            this.m = builder.m;
            this.n = builder.n;
            this.o = builder.o;
            this.p = builder.p;
            this.q = builder.q;
            this.r = builder.r;
            this.s = builder.s;
            this.t = builder.t;
        }
    }
}
