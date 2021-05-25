package a2.j.b.a.c.m.c;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import java.util.Objects;
import java.util.Set;
public final class c extends SchedulerConfig.ConfigValue {
    public final long a;
    public final long b;
    public final Set<SchedulerConfig.Flag> c;

    public static final class b extends SchedulerConfig.ConfigValue.Builder {
        public Long a;
        public Long b;
        public Set<SchedulerConfig.Flag> c;

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue.Builder
        public SchedulerConfig.ConfigValue build() {
            String str = this.a == null ? " delta" : "";
            if (this.b == null) {
                str = a2.b.a.a.a.c3(str, " maxAllowedDelay");
            }
            if (this.c == null) {
                str = a2.b.a.a.a.c3(str, " flags");
            }
            if (str.isEmpty()) {
                return new c(this.a.longValue(), this.b.longValue(), this.c, null);
            }
            throw new IllegalStateException(a2.b.a.a.a.c3("Missing required properties:", str));
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue.Builder
        public SchedulerConfig.ConfigValue.Builder setDelta(long j) {
            this.a = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue.Builder
        public SchedulerConfig.ConfigValue.Builder setFlags(Set<SchedulerConfig.Flag> set) {
            Objects.requireNonNull(set, "Null flags");
            this.c = set;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue.Builder
        public SchedulerConfig.ConfigValue.Builder setMaxAllowedDelay(long j) {
            this.b = Long.valueOf(j);
            return this;
        }
    }

    public c(long j, long j2, Set set, a aVar) {
        this.a = j;
        this.b = j2;
        this.c = set;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue
    public long a() {
        return this.a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue
    public Set<SchedulerConfig.Flag> b() {
        return this.c;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue
    public long c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig.ConfigValue)) {
            return false;
        }
        SchedulerConfig.ConfigValue configValue = (SchedulerConfig.ConfigValue) obj;
        if (this.a == configValue.a() && this.b == configValue.c() && this.c.equals(configValue.b())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.a;
        long j2 = this.b;
        return this.c.hashCode() ^ ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003);
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("ConfigValue{delta=");
        L.append(this.a);
        L.append(", maxAllowedDelay=");
        L.append(this.b);
        L.append(", flags=");
        L.append(this.c);
        L.append("}");
        return L.toString();
    }
}
