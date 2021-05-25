package a2.j.e.d.d.c;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import java.util.Objects;
public final class k extends CrashlyticsReport.Session.Event.Application.Execution {
    public final ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> a;
    public final CrashlyticsReport.Session.Event.Application.Execution.Exception b;
    public final CrashlyticsReport.Session.Event.Application.Execution.Signal c;
    public final ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> d;

    public static final class b extends CrashlyticsReport.Session.Event.Application.Execution.Builder {
        public ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> a;
        public CrashlyticsReport.Session.Event.Application.Execution.Exception b;
        public CrashlyticsReport.Session.Event.Application.Execution.Signal c;
        public ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> d;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public CrashlyticsReport.Session.Event.Application.Execution build() {
            String str = this.a == null ? " threads" : "";
            if (this.b == null) {
                str = a2.b.a.a.a.c3(str, " exception");
            }
            if (this.c == null) {
                str = a2.b.a.a.a.c3(str, " signal");
            }
            if (this.d == null) {
                str = a2.b.a.a.a.c3(str, " binaries");
            }
            if (str.isEmpty()) {
                return new k(this.a, this.b, this.c, this.d, null);
            }
            throw new IllegalStateException(a2.b.a.a.a.c3("Missing required properties:", str));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Builder setBinaries(ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> immutableList) {
            Objects.requireNonNull(immutableList, "Null binaries");
            this.d = immutableList;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Builder setException(CrashlyticsReport.Session.Event.Application.Execution.Exception exception) {
            Objects.requireNonNull(exception, "Null exception");
            this.b = exception;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Builder setSignal(CrashlyticsReport.Session.Event.Application.Execution.Signal signal) {
            Objects.requireNonNull(signal, "Null signal");
            this.c = signal;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Builder setThreads(ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> immutableList) {
            Objects.requireNonNull(immutableList, "Null threads");
            this.a = immutableList;
            return this;
        }
    }

    public k(ImmutableList immutableList, CrashlyticsReport.Session.Event.Application.Execution.Exception exception, CrashlyticsReport.Session.Event.Application.Execution.Signal signal, ImmutableList immutableList2, a aVar) {
        this.a = immutableList;
        this.b = exception;
        this.c = signal;
        this.d = immutableList2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution execution = (CrashlyticsReport.Session.Event.Application.Execution) obj;
        if (!this.a.equals(execution.getThreads()) || !this.b.equals(execution.getException()) || !this.c.equals(execution.getSignal()) || !this.d.equals(execution.getBinaries())) {
            return false;
        }
        return true;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
    @NonNull
    public ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> getBinaries() {
        return this.d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
    @NonNull
    public CrashlyticsReport.Session.Event.Application.Execution.Exception getException() {
        return this.b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
    @NonNull
    public CrashlyticsReport.Session.Event.Application.Execution.Signal getSignal() {
        return this.c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
    @NonNull
    public ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> getThreads() {
        return this.a;
    }

    public int hashCode() {
        return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("Execution{threads=");
        L.append(this.a);
        L.append(", exception=");
        L.append(this.b);
        L.append(", signal=");
        L.append(this.c);
        L.append(", binaries=");
        L.append(this.d);
        L.append("}");
        return L.toString();
    }
}
