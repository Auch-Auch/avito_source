package a2.j.e.d.d.c;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Objects;
public final class g extends CrashlyticsReport.Session.Application.Organization {
    public final String a;

    public static final class b extends CrashlyticsReport.Session.Application.Organization.Builder {
        public String a;

        public b() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Organization.Builder
        public CrashlyticsReport.Session.Application.Organization build() {
            String str = this.a == null ? " clsId" : "";
            if (str.isEmpty()) {
                return new g(this.a, null);
            }
            throw new IllegalStateException(a2.b.a.a.a.c3("Missing required properties:", str));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Organization.Builder
        public CrashlyticsReport.Session.Application.Organization.Builder setClsId(String str) {
            Objects.requireNonNull(str, "Null clsId");
            this.a = str;
            return this;
        }

        public b(CrashlyticsReport.Session.Application.Organization organization, a aVar) {
            this.a = ((g) organization).a;
        }
    }

    public g(String str, a aVar) {
        this.a = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.Application.Organization) {
            return this.a.equals(((CrashlyticsReport.Session.Application.Organization) obj).getClsId());
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Organization
    @NonNull
    public String getClsId() {
        return this.a;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Organization
    public CrashlyticsReport.Session.Application.Organization.Builder toBuilder() {
        return new b(this, null);
    }

    public String toString() {
        return a2.b.a.a.a.t(a2.b.a.a.a.L("Organization{clsId="), this.a, "}");
    }
}
