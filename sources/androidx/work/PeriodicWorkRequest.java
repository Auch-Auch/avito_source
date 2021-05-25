package androidx.work;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkSpec;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
public final class PeriodicWorkRequest extends WorkRequest {
    @SuppressLint({"MinMaxConstant"})
    public static final long MIN_PERIODIC_FLEX_MILLIS = 300000;
    @SuppressLint({"MinMaxConstant"})
    public static final long MIN_PERIODIC_INTERVAL_MILLIS = 900000;

    public PeriodicWorkRequest(Builder builder) {
        super(builder.b, builder.c, builder.d);
    }

    public static final class Builder extends WorkRequest.Builder<Builder, PeriodicWorkRequest> {
        public Builder(@NonNull Class<? extends ListenableWorker> cls, long j, @NonNull TimeUnit timeUnit) {
            super(cls);
            this.c.setPeriodic(timeUnit.toMillis(j));
        }

        /* Return type fixed from 'androidx.work.WorkRequest' to match base method */
        @Override // androidx.work.WorkRequest.Builder
        @NonNull
        public PeriodicWorkRequest a() {
            if (!this.a || Build.VERSION.SDK_INT < 23 || !this.c.constraints.requiresDeviceIdle()) {
                WorkSpec workSpec = this.c;
                if (!workSpec.runInForeground || Build.VERSION.SDK_INT < 23 || !workSpec.constraints.requiresDeviceIdle()) {
                    return new PeriodicWorkRequest(this);
                }
                throw new IllegalArgumentException("Cannot run in foreground with an idle mode constraint");
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        }

        /* Return type fixed from 'androidx.work.WorkRequest$Builder' to match base method */
        @Override // androidx.work.WorkRequest.Builder
        @NonNull
        public Builder b() {
            return this;
        }

        @RequiresApi(26)
        public Builder(@NonNull Class<? extends ListenableWorker> cls, @NonNull Duration duration) {
            super(cls);
            this.c.setPeriodic(duration.toMillis());
        }

        public Builder(@NonNull Class<? extends ListenableWorker> cls, long j, @NonNull TimeUnit timeUnit, long j2, @NonNull TimeUnit timeUnit2) {
            super(cls);
            this.c.setPeriodic(timeUnit.toMillis(j), timeUnit2.toMillis(j2));
        }

        @RequiresApi(26)
        public Builder(@NonNull Class<? extends ListenableWorker> cls, @NonNull Duration duration, @NonNull Duration duration2) {
            super(cls);
            this.c.setPeriodic(duration.toMillis(), duration2.toMillis());
        }
    }
}
