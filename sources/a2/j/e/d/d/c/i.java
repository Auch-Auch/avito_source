package a2.j.e.d.d.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Objects;
public final class i extends CrashlyticsReport.Session.Event {
    public final long a;
    public final String b;
    public final CrashlyticsReport.Session.Event.Application c;
    public final CrashlyticsReport.Session.Event.Device d;
    public final CrashlyticsReport.Session.Event.Log e;

    public static final class b extends CrashlyticsReport.Session.Event.Builder {
        public Long a;
        public String b;
        public CrashlyticsReport.Session.Event.Application c;
        public CrashlyticsReport.Session.Event.Device d;
        public CrashlyticsReport.Session.Event.Log e;

        public b() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public CrashlyticsReport.Session.Event build() {
            String str = this.a == null ? " timestamp" : "";
            if (this.b == null) {
                str = a2.b.a.a.a.c3(str, " type");
            }
            if (this.c == null) {
                str = a2.b.a.a.a.c3(str, " app");
            }
            if (this.d == null) {
                str = a2.b.a.a.a.c3(str, " device");
            }
            if (str.isEmpty()) {
                return new i(this.a.longValue(), this.b, this.c, this.d, this.e, null);
            }
            throw new IllegalStateException(a2.b.a.a.a.c3("Missing required properties:", str));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public CrashlyticsReport.Session.Event.Builder setApp(CrashlyticsReport.Session.Event.Application application) {
            Objects.requireNonNull(application, "Null app");
            this.c = application;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public CrashlyticsReport.Session.Event.Builder setDevice(CrashlyticsReport.Session.Event.Device device) {
            Objects.requireNonNull(device, "Null device");
            this.d = device;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public CrashlyticsReport.Session.Event.Builder setLog(CrashlyticsReport.Session.Event.Log log) {
            this.e = log;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public CrashlyticsReport.Session.Event.Builder setTimestamp(long j) {
            this.a = Long.valueOf(j);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public CrashlyticsReport.Session.Event.Builder setType(String str) {
            Objects.requireNonNull(str, "Null type");
            this.b = str;
            return this;
        }

        public b(CrashlyticsReport.Session.Event event, a aVar) {
            i iVar = (i) event;
            this.a = Long.valueOf(iVar.a);
            this.b = iVar.b;
            this.c = iVar.c;
            this.d = iVar.d;
            this.e = iVar.e;
        }
    }

    public i(long j, String str, CrashlyticsReport.Session.Event.Application application, CrashlyticsReport.Session.Event.Device device, CrashlyticsReport.Session.Event.Log log, a aVar) {
        this.a = j;
        this.b = str;
        this.c = application;
        this.d = device;
        this.e = log;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event)) {
            return false;
        }
        CrashlyticsReport.Session.Event event = (CrashlyticsReport.Session.Event) obj;
        if (this.a == event.getTimestamp() && this.b.equals(event.getType()) && this.c.equals(event.getApp()) && this.d.equals(event.getDevice())) {
            CrashlyticsReport.Session.Event.Log log = this.e;
            if (log == null) {
                if (event.getLog() == null) {
                    return true;
                }
            } else if (log.equals(event.getLog())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    @NonNull
    public CrashlyticsReport.Session.Event.Application getApp() {
        return this.c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    @NonNull
    public CrashlyticsReport.Session.Event.Device getDevice() {
        return this.d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    @Nullable
    public CrashlyticsReport.Session.Event.Log getLog() {
        return this.e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    public long getTimestamp() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    @NonNull
    public String getType() {
        return this.b;
    }

    public int hashCode() {
        long j = this.a;
        int hashCode = (((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003;
        CrashlyticsReport.Session.Event.Log log = this.e;
        return (log == null ? 0 : log.hashCode()) ^ hashCode;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    public CrashlyticsReport.Session.Event.Builder toBuilder() {
        return new b(this, null);
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("Event{timestamp=");
        L.append(this.a);
        L.append(", type=");
        L.append(this.b);
        L.append(", app=");
        L.append(this.c);
        L.append(", device=");
        L.append(this.d);
        L.append(", log=");
        L.append(this.e);
        L.append("}");
        return L.toString();
    }
}
