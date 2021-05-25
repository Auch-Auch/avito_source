package a2.j.e.d.d.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Objects;
public final class a extends CrashlyticsReport {
    public final String b;
    public final String c;
    public final int d;
    public final String e;
    public final String f;
    public final String g;
    public final CrashlyticsReport.Session h;
    public final CrashlyticsReport.FilesPayload i;

    public static final class b extends CrashlyticsReport.Builder {
        public String a;
        public String b;
        public Integer c;
        public String d;
        public String e;
        public String f;
        public CrashlyticsReport.Session g;
        public CrashlyticsReport.FilesPayload h;

        public b() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport build() {
            String str = this.a == null ? " sdkVersion" : "";
            if (this.b == null) {
                str = a2.b.a.a.a.c3(str, " gmpAppId");
            }
            if (this.c == null) {
                str = a2.b.a.a.a.c3(str, " platform");
            }
            if (this.d == null) {
                str = a2.b.a.a.a.c3(str, " installationUuid");
            }
            if (this.e == null) {
                str = a2.b.a.a.a.c3(str, " buildVersion");
            }
            if (this.f == null) {
                str = a2.b.a.a.a.c3(str, " displayVersion");
            }
            if (str.isEmpty()) {
                return new a(this.a, this.b, this.c.intValue(), this.d, this.e, this.f, this.g, this.h, null);
            }
            throw new IllegalStateException(a2.b.a.a.a.c3("Missing required properties:", str));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder setBuildVersion(String str) {
            Objects.requireNonNull(str, "Null buildVersion");
            this.e = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder setDisplayVersion(String str) {
            Objects.requireNonNull(str, "Null displayVersion");
            this.f = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder setGmpAppId(String str) {
            Objects.requireNonNull(str, "Null gmpAppId");
            this.b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder setInstallationUuid(String str) {
            Objects.requireNonNull(str, "Null installationUuid");
            this.d = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder setNdkPayload(CrashlyticsReport.FilesPayload filesPayload) {
            this.h = filesPayload;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder setPlatform(int i) {
            this.c = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder setSdkVersion(String str) {
            Objects.requireNonNull(str, "Null sdkVersion");
            this.a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder setSession(CrashlyticsReport.Session session) {
            this.g = session;
            return this;
        }

        public b(CrashlyticsReport crashlyticsReport, C0078a aVar) {
            a aVar2 = (a) crashlyticsReport;
            this.a = aVar2.b;
            this.b = aVar2.c;
            this.c = Integer.valueOf(aVar2.d);
            this.d = aVar2.e;
            this.e = aVar2.f;
            this.f = aVar2.g;
            this.g = aVar2.h;
            this.h = aVar2.i;
        }
    }

    public a(String str, String str2, int i2, String str3, String str4, String str5, CrashlyticsReport.Session session, CrashlyticsReport.FilesPayload filesPayload, C0078a aVar) {
        this.b = str;
        this.c = str2;
        this.d = i2;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.h = session;
        this.i = filesPayload;
    }

    public boolean equals(Object obj) {
        CrashlyticsReport.Session session;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport)) {
            return false;
        }
        CrashlyticsReport crashlyticsReport = (CrashlyticsReport) obj;
        if (this.b.equals(crashlyticsReport.getSdkVersion()) && this.c.equals(crashlyticsReport.getGmpAppId()) && this.d == crashlyticsReport.getPlatform() && this.e.equals(crashlyticsReport.getInstallationUuid()) && this.f.equals(crashlyticsReport.getBuildVersion()) && this.g.equals(crashlyticsReport.getDisplayVersion()) && ((session = this.h) != null ? session.equals(crashlyticsReport.getSession()) : crashlyticsReport.getSession() == null)) {
            CrashlyticsReport.FilesPayload filesPayload = this.i;
            if (filesPayload == null) {
                if (crashlyticsReport.getNdkPayload() == null) {
                    return true;
                }
            } else if (filesPayload.equals(crashlyticsReport.getNdkPayload())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    @NonNull
    public String getBuildVersion() {
        return this.f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    @NonNull
    public String getDisplayVersion() {
        return this.g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    @NonNull
    public String getGmpAppId() {
        return this.c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    @NonNull
    public String getInstallationUuid() {
        return this.e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    @Nullable
    public CrashlyticsReport.FilesPayload getNdkPayload() {
        return this.i;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public int getPlatform() {
        return this.d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    @NonNull
    public String getSdkVersion() {
        return this.b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    @Nullable
    public CrashlyticsReport.Session getSession() {
        return this.h;
    }

    public int hashCode() {
        int hashCode = (((((((((((this.b.hashCode() ^ 1000003) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f.hashCode()) * 1000003) ^ this.g.hashCode()) * 1000003;
        CrashlyticsReport.Session session = this.h;
        int i2 = 0;
        int hashCode2 = (hashCode ^ (session == null ? 0 : session.hashCode())) * 1000003;
        CrashlyticsReport.FilesPayload filesPayload = this.i;
        if (filesPayload != null) {
            i2 = filesPayload.hashCode();
        }
        return hashCode2 ^ i2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public CrashlyticsReport.Builder toBuilder() {
        return new b(this, null);
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("CrashlyticsReport{sdkVersion=");
        L.append(this.b);
        L.append(", gmpAppId=");
        L.append(this.c);
        L.append(", platform=");
        L.append(this.d);
        L.append(", installationUuid=");
        L.append(this.e);
        L.append(", buildVersion=");
        L.append(this.f);
        L.append(", displayVersion=");
        L.append(this.g);
        L.append(", session=");
        L.append(this.h);
        L.append(", ndkPayload=");
        L.append(this.i);
        L.append("}");
        return L.toString();
    }
}
