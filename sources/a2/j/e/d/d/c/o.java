package a2.j.e.d.d.c;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import java.util.Objects;
public final class o extends CrashlyticsReport.Session.Event.Application.Execution.Thread {
    public final String a;
    public final int b;
    public final ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> c;

    public static final class b extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder {
        public String a;
        public Integer b;
        public ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> c;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Thread build() {
            String str = this.a == null ? " name" : "";
            if (this.b == null) {
                str = a2.b.a.a.a.c3(str, " importance");
            }
            if (this.c == null) {
                str = a2.b.a.a.a.c3(str, " frames");
            }
            if (str.isEmpty()) {
                return new o(this.a, this.b.intValue(), this.c, null);
            }
            throw new IllegalStateException(a2.b.a.a.a.c3("Missing required properties:", str));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder setFrames(ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> immutableList) {
            Objects.requireNonNull(immutableList, "Null frames");
            this.c = immutableList;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder setImportance(int i) {
            this.b = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder setName(String str) {
            Objects.requireNonNull(str, "Null name");
            this.a = str;
            return this;
        }
    }

    public o(String str, int i, ImmutableList immutableList, a aVar) {
        this.a = str;
        this.b = i;
        this.c = immutableList;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.Thread)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.Thread thread = (CrashlyticsReport.Session.Event.Application.Execution.Thread) obj;
        if (!this.a.equals(thread.getName()) || this.b != thread.getImportance() || !this.c.equals(thread.getFrames())) {
            return false;
        }
        return true;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread
    @NonNull
    public ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> getFrames() {
        return this.c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread
    public int getImportance() {
        return this.b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread
    @NonNull
    public String getName() {
        return this.a;
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c.hashCode();
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("Thread{name=");
        L.append(this.a);
        L.append(", importance=");
        L.append(this.b);
        L.append(", frames=");
        L.append(this.c);
        L.append("}");
        return L.toString();
    }
}
