package a2.j.e.d.d.c;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Objects;
public final class n extends CrashlyticsReport.Session.Event.Application.Execution.Signal {
    public final String a;
    public final String b;
    public final long c;

    public static final class b extends CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder {
        public String a;
        public String b;
        public Long c;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Signal build() {
            String str = this.a == null ? " name" : "";
            if (this.b == null) {
                str = a2.b.a.a.a.c3(str, " code");
            }
            if (this.c == null) {
                str = a2.b.a.a.a.c3(str, " address");
            }
            if (str.isEmpty()) {
                return new n(this.a, this.b, this.c.longValue(), null);
            }
            throw new IllegalStateException(a2.b.a.a.a.c3("Missing required properties:", str));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder setAddress(long j) {
            this.c = Long.valueOf(j);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder setCode(String str) {
            Objects.requireNonNull(str, "Null code");
            this.b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder setName(String str) {
            Objects.requireNonNull(str, "Null name");
            this.a = str;
            return this;
        }
    }

    public n(String str, String str2, long j, a aVar) {
        this.a = str;
        this.b = str2;
        this.c = j;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.Signal)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.Signal signal = (CrashlyticsReport.Session.Event.Application.Execution.Signal) obj;
        if (!this.a.equals(signal.getName()) || !this.b.equals(signal.getCode()) || this.c != signal.getAddress()) {
            return false;
        }
        return true;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal
    @NonNull
    public long getAddress() {
        return this.c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal
    @NonNull
    public String getCode() {
        return this.b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal
    @NonNull
    public String getName() {
        return this.a;
    }

    public int hashCode() {
        long j = this.c;
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("Signal{name=");
        L.append(this.a);
        L.append(", code=");
        L.append(this.b);
        L.append(", address=");
        return a2.b.a.a.a.l(L, this.c, "}");
    }
}
