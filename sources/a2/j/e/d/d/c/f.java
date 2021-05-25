package a2.j.e.d.d.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Objects;
public final class f extends CrashlyticsReport.Session.Application {
    public final String a;
    public final String b;
    public final String c;
    public final CrashlyticsReport.Session.Application.Organization d;
    public final String e;

    public static final class b extends CrashlyticsReport.Session.Application.Builder {
        public String a;
        public String b;
        public String c;
        public CrashlyticsReport.Session.Application.Organization d;
        public String e;

        public b() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public CrashlyticsReport.Session.Application build() {
            String str = this.a == null ? " identifier" : "";
            if (this.b == null) {
                str = a2.b.a.a.a.c3(str, " version");
            }
            if (str.isEmpty()) {
                return new f(this.a, this.b, this.c, this.d, this.e, null);
            }
            throw new IllegalStateException(a2.b.a.a.a.c3("Missing required properties:", str));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public CrashlyticsReport.Session.Application.Builder setDisplayVersion(String str) {
            this.c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public CrashlyticsReport.Session.Application.Builder setIdentifier(String str) {
            Objects.requireNonNull(str, "Null identifier");
            this.a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public CrashlyticsReport.Session.Application.Builder setInstallationUuid(String str) {
            this.e = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public CrashlyticsReport.Session.Application.Builder setOrganization(CrashlyticsReport.Session.Application.Organization organization) {
            this.d = organization;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public CrashlyticsReport.Session.Application.Builder setVersion(String str) {
            Objects.requireNonNull(str, "Null version");
            this.b = str;
            return this;
        }

        public b(CrashlyticsReport.Session.Application application, a aVar) {
            f fVar = (f) application;
            this.a = fVar.a;
            this.b = fVar.b;
            this.c = fVar.c;
            this.d = fVar.d;
            this.e = fVar.e;
        }
    }

    public f(String str, String str2, String str3, CrashlyticsReport.Session.Application.Organization organization, String str4, a aVar) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = organization;
        this.e = str4;
    }

    public boolean equals(Object obj) {
        String str;
        CrashlyticsReport.Session.Application.Organization organization;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Application)) {
            return false;
        }
        CrashlyticsReport.Session.Application application = (CrashlyticsReport.Session.Application) obj;
        if (this.a.equals(application.getIdentifier()) && this.b.equals(application.getVersion()) && ((str = this.c) != null ? str.equals(application.getDisplayVersion()) : application.getDisplayVersion() == null) && ((organization = this.d) != null ? organization.equals(application.getOrganization()) : application.getOrganization() == null)) {
            String str2 = this.e;
            if (str2 == null) {
                if (application.getInstallationUuid() == null) {
                    return true;
                }
            } else if (str2.equals(application.getInstallationUuid())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    @Nullable
    public String getDisplayVersion() {
        return this.c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    @NonNull
    public String getIdentifier() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    @Nullable
    public String getInstallationUuid() {
        return this.e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    @Nullable
    public CrashlyticsReport.Session.Application.Organization getOrganization() {
        return this.d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    @NonNull
    public String getVersion() {
        return this.b;
    }

    public int hashCode() {
        int hashCode = (((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003;
        String str = this.c;
        int i = 0;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        CrashlyticsReport.Session.Application.Organization organization = this.d;
        int hashCode3 = (hashCode2 ^ (organization == null ? 0 : organization.hashCode())) * 1000003;
        String str2 = this.e;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode3 ^ i;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    public CrashlyticsReport.Session.Application.Builder toBuilder() {
        return new b(this, null);
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("Application{identifier=");
        L.append(this.a);
        L.append(", version=");
        L.append(this.b);
        L.append(", displayVersion=");
        L.append(this.c);
        L.append(", organization=");
        L.append(this.d);
        L.append(", installationUuid=");
        return a2.b.a.a.a.t(L, this.e, "}");
    }
}
