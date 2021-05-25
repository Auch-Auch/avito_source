package a2.j.b.a.c.m.c;

import a2.b.a.a.a;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.Map;
import java.util.Objects;
public final class b extends SchedulerConfig {
    public final Clock a;
    public final Map<Priority, SchedulerConfig.ConfigValue> b;

    public b(Clock clock, Map<Priority, SchedulerConfig.ConfigValue> map) {
        Objects.requireNonNull(clock, "Null clock");
        this.a = clock;
        Objects.requireNonNull(map, "Null values");
        this.b = map;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig
    public Clock a() {
        return this.a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig
    public Map<Priority, SchedulerConfig.ConfigValue> b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig)) {
            return false;
        }
        SchedulerConfig schedulerConfig = (SchedulerConfig) obj;
        if (!this.a.equals(schedulerConfig.a()) || !this.b.equals(schedulerConfig.b())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        StringBuilder L = a.L("SchedulerConfig{clock=");
        L.append(this.a);
        L.append(", values=");
        return a.x(L, this.b, "}");
    }
}
