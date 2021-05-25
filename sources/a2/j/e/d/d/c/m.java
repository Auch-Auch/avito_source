package a2.j.e.d.d.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import java.util.Objects;
public final class m extends CrashlyticsReport.Session.Event.Application.Execution.Exception {
    public final String a;
    public final String b;
    public final ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> c;
    public final CrashlyticsReport.Session.Event.Application.Execution.Exception d;
    public final int e;

    public static final class b extends CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder {
        public String a;
        public String b;
        public ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> c;
        public CrashlyticsReport.Session.Event.Application.Execution.Exception d;
        public Integer e;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Exception build() {
            String str = this.a == null ? " type" : "";
            if (this.c == null) {
                str = a2.b.a.a.a.c3(str, " frames");
            }
            if (this.e == null) {
                str = a2.b.a.a.a.c3(str, " overflowCount");
            }
            if (str.isEmpty()) {
                return new m(this.a, this.b, this.c, this.d, this.e.intValue(), null);
            }
            throw new IllegalStateException(a2.b.a.a.a.c3("Missing required properties:", str));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder setCausedBy(CrashlyticsReport.Session.Event.Application.Execution.Exception exception) {
            this.d = exception;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder setFrames(ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> immutableList) {
            Objects.requireNonNull(immutableList, "Null frames");
            this.c = immutableList;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder setOverflowCount(int i) {
            this.e = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder setReason(String str) {
            this.b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder setType(String str) {
            Objects.requireNonNull(str, "Null type");
            this.a = str;
            return this;
        }
    }

    public m(String str, String str2, ImmutableList immutableList, CrashlyticsReport.Session.Event.Application.Execution.Exception exception, int i, a aVar) {
        this.a = str;
        this.b = str2;
        this.c = immutableList;
        this.d = exception;
        this.e = i;
    }

    public boolean equals(Object obj) {
        String str;
        CrashlyticsReport.Session.Event.Application.Execution.Exception exception;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.Exception)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.Exception exception2 = (CrashlyticsReport.Session.Event.Application.Execution.Exception) obj;
        if (!this.a.equals(exception2.getType()) || ((str = this.b) != null ? !str.equals(exception2.getReason()) : exception2.getReason() != null) || !this.c.equals(exception2.getFrames()) || ((exception = this.d) != null ? !exception.equals(exception2.getCausedBy()) : exception2.getCausedBy() != null) || this.e != exception2.getOverflowCount()) {
            return false;
        }
        return true;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception
    @Nullable
    public CrashlyticsReport.Session.Event.Application.Execution.Exception getCausedBy() {
        return this.d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception
    @NonNull
    public ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> getFrames() {
        return this.c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception
    public int getOverflowCount() {
        return this.e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception
    @Nullable
    public String getReason() {
        return this.b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception
    @NonNull
    public String getType() {
        return this.a;
    }

    public int hashCode() {
        int hashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        String str = this.b;
        int i = 0;
        int hashCode2 = (((hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.c.hashCode()) * 1000003;
        CrashlyticsReport.Session.Event.Application.Execution.Exception exception = this.d;
        if (exception != null) {
            i = exception.hashCode();
        }
        return ((hashCode2 ^ i) * 1000003) ^ this.e;
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("Exception{type=");
        L.append(this.a);
        L.append(", reason=");
        L.append(this.b);
        L.append(", frames=");
        L.append(this.c);
        L.append(", causedBy=");
        L.append(this.d);
        L.append(", overflowCount=");
        return a2.b.a.a.a.j(L, this.e, "}");
    }
}
