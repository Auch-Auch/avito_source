package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import a2.j.b.a.c.m.c.b;
import a2.j.b.a.c.m.c.c;
import android.app.job.JobInfo;
import androidx.annotation.RequiresApi;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.auto.value.AutoValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
@AutoValue
public abstract class SchedulerConfig {

    public static class Builder {
        public Clock a;
        public Map<Priority, ConfigValue> b = new HashMap();

        public Builder addConfig(Priority priority, ConfigValue configValue) {
            this.b.put(priority, configValue);
            return this;
        }

        public SchedulerConfig build() {
            Objects.requireNonNull(this.a, "missing required property: clock");
            int size = this.b.keySet().size();
            Priority.values();
            if (size >= 3) {
                Map<Priority, ConfigValue> map = this.b;
                this.b = new HashMap();
                return new b(this.a, map);
            }
            throw new IllegalStateException("Not all priorities have been configured");
        }

        public Builder setClock(Clock clock) {
            this.a = clock;
            return this;
        }
    }

    @AutoValue
    public static abstract class ConfigValue {

        @AutoValue.Builder
        public static abstract class Builder {
            public abstract ConfigValue build();

            public abstract Builder setDelta(long j);

            public abstract Builder setFlags(Set<Flag> set);

            public abstract Builder setMaxAllowedDelay(long j);
        }

        public static Builder builder() {
            c.b bVar = new c.b();
            Set<Flag> emptySet = Collections.emptySet();
            Objects.requireNonNull(emptySet, "Null flags");
            bVar.c = emptySet;
            return bVar;
        }

        public abstract long a();

        public abstract Set<Flag> b();

        public abstract long c();
    }

    public enum Flag {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    public static Builder builder() {
        return new Builder();
    }

    public static SchedulerConfig getDefault(Clock clock) {
        return builder().addConfig(Priority.DEFAULT, ConfigValue.builder().setDelta(30000).setMaxAllowedDelay(86400000).build()).addConfig(Priority.HIGHEST, ConfigValue.builder().setDelta(1000).setMaxAllowedDelay(86400000).build()).addConfig(Priority.VERY_LOW, ConfigValue.builder().setDelta(86400000).setMaxAllowedDelay(86400000).setFlags(Collections.unmodifiableSet(new HashSet(Arrays.asList(Flag.NETWORK_UNMETERED, Flag.DEVICE_IDLE)))).build()).setClock(clock).build();
    }

    public abstract Clock a();

    public abstract Map<Priority, ConfigValue> b();

    @RequiresApi(api = 21)
    public JobInfo.Builder configureJob(JobInfo.Builder builder, Priority priority, long j, int i) {
        builder.setMinimumLatency(getScheduleDelay(priority, j, i));
        Set<Flag> b = b().get(priority).b();
        if (b.contains(Flag.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (b.contains(Flag.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (b.contains(Flag.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
        return builder;
    }

    public Set<Flag> getFlags(Priority priority) {
        return b().get(priority).b();
    }

    public long getScheduleDelay(Priority priority, long j, int i) {
        long time = j - a().getTime();
        ConfigValue configValue = b().get(priority);
        long a = configValue.a();
        int i2 = i - 1;
        return Math.min(Math.max((long) (Math.pow(3.0d, (double) i2) * ((double) a) * Math.max(1.0d, Math.log(10000.0d) / Math.log((double) ((a > 1 ? a : 2) * ((long) i2))))), time), configValue.c());
    }
}
