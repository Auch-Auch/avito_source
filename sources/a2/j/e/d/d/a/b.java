package a2.j.e.d.d.a;

import a2.b.a.a.a;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Objects;
public final class b extends CrashlyticsReportWithSessionId {
    public final CrashlyticsReport a;
    public final String b;

    public b(CrashlyticsReport crashlyticsReport, String str) {
        Objects.requireNonNull(crashlyticsReport, "Null report");
        this.a = crashlyticsReport;
        Objects.requireNonNull(str, "Null sessionId");
        this.b = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReportWithSessionId)) {
            return false;
        }
        CrashlyticsReportWithSessionId crashlyticsReportWithSessionId = (CrashlyticsReportWithSessionId) obj;
        if (!this.a.equals(crashlyticsReportWithSessionId.getReport()) || !this.b.equals(crashlyticsReportWithSessionId.getSessionId())) {
            return false;
        }
        return true;
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId
    public CrashlyticsReport getReport() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId
    public String getSessionId() {
        return this.b;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        StringBuilder L = a.L("CrashlyticsReportWithSessionId{report=");
        L.append(this.a);
        L.append(", sessionId=");
        return a.t(L, this.b, "}");
    }
}
