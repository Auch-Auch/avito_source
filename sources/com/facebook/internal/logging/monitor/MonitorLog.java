package com.facebook.internal.logging.monitor;

import a2.b.a.a.a;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.facebook.internal.logging.ExternalLog;
import com.facebook.internal.logging.LogCategory;
import com.facebook.internal.logging.LogEvent;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MonitorLog implements ExternalLog {
    public static Set<String> e = new HashSet();
    private static final long serialVersionUID = 1;
    public LogEvent a;
    public long b;
    public int c;
    public int d;

    public static class LogBuilder {
        public LogEvent a;
        public long b;
        public int c;

        public LogBuilder(LogEvent logEvent) {
            this.a = logEvent;
            if (logEvent.getLogCategory() == LogCategory.PERFORMANCE) {
                logEvent.upperCaseEventName();
            }
        }

        public MonitorLog build() {
            MonitorLog monitorLog = new MonitorLog(this);
            if (this.c < 0) {
                monitorLog.c = -1;
            }
            if (this.b < 0) {
                monitorLog.b = -1;
            }
            if (this.a.getLogCategory() != LogCategory.PERFORMANCE || MonitorLog.e.contains(this.a.getEventName())) {
                return monitorLog;
            }
            StringBuilder L = a.L("Invalid event name: ");
            L.append(this.a.getEventName());
            L.append("\nIt should be one of ");
            L.append(MonitorLog.e);
            L.append(".");
            throw new IllegalArgumentException(L.toString());
        }

        public LogBuilder timeSpent(int i) {
            this.c = i;
            return this;
        }

        public LogBuilder timeStart(long j) {
            this.b = j;
            return this;
        }
    }

    static {
        PerformanceEventName[] values = PerformanceEventName.values();
        for (int i = 0; i < 3; i++) {
            e.add(values[i].toString());
        }
    }

    public MonitorLog(LogBuilder logBuilder) {
        this.a = logBuilder.a;
        this.b = logBuilder.b;
        this.c = logBuilder.c;
    }

    @Override // com.facebook.internal.logging.ExternalLog
    public JSONObject convertToJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event_name", this.a.getEventName());
            jSONObject.put("category", this.a.getLogCategory());
            long j = this.b;
            if (j != 0) {
                jSONObject.put(MonitorLogServerProtocol.PARAM_TIME_START, j);
            }
            int i = this.c;
            if (i != 0) {
                jSONObject.put(MonitorLogServerProtocol.PARAM_TIME_SPENT, i);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MonitorLog monitorLog = (MonitorLog) obj;
        if (!this.a.getEventName().equals(monitorLog.a.getEventName()) || !this.a.getLogCategory().equals(monitorLog.a.getLogCategory()) || this.b != monitorLog.b || this.c != monitorLog.c) {
            return false;
        }
        return true;
    }

    @Override // com.facebook.internal.logging.ExternalLog
    public String getEventName() {
        return this.a.getEventName();
    }

    @Override // com.facebook.internal.logging.ExternalLog
    public LogCategory getLogCategory() {
        return this.a.getLogCategory();
    }

    public int getTimeSpent() {
        return this.c;
    }

    public long getTimeStart() {
        return this.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        if (this.d == 0) {
            long j = this.b;
            int i = this.c;
            this.d = ((((this.a.hashCode() + 527) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + (i ^ (i >>> 32));
        }
        return this.d;
    }

    public boolean isValid() {
        return this.b >= 0 && this.c >= 0;
    }

    @Override // java.lang.Object
    public String toString() {
        return String.format("event_name: %s, category: %s, time_start: %s, time_spent: %s", this.a.getEventName(), this.a.getLogCategory(), Long.valueOf(this.b), Integer.valueOf(this.c));
    }
}
