package a2.j.e.d.d.c;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Objects;
public final class s extends CrashlyticsReport.Session.OperatingSystem {
    public final int a;
    public final String b;
    public final String c;
    public final boolean d;

    public static final class b extends CrashlyticsReport.Session.OperatingSystem.Builder {
        public Integer a;
        public String b;
        public String c;
        public Boolean d;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public CrashlyticsReport.Session.OperatingSystem build() {
            String str = this.a == null ? " platform" : "";
            if (this.b == null) {
                str = a2.b.a.a.a.c3(str, " version");
            }
            if (this.c == null) {
                str = a2.b.a.a.a.c3(str, " buildVersion");
            }
            if (this.d == null) {
                str = a2.b.a.a.a.c3(str, " jailbroken");
            }
            if (str.isEmpty()) {
                return new s(this.a.intValue(), this.b, this.c, this.d.booleanValue(), null);
            }
            throw new IllegalStateException(a2.b.a.a.a.c3("Missing required properties:", str));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public CrashlyticsReport.Session.OperatingSystem.Builder setBuildVersion(String str) {
            Objects.requireNonNull(str, "Null buildVersion");
            this.c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public CrashlyticsReport.Session.OperatingSystem.Builder setJailbroken(boolean z) {
            this.d = Boolean.valueOf(z);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public CrashlyticsReport.Session.OperatingSystem.Builder setPlatform(int i) {
            this.a = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public CrashlyticsReport.Session.OperatingSystem.Builder setVersion(String str) {
            Objects.requireNonNull(str, "Null version");
            this.b = str;
            return this;
        }
    }

    public s(int i, String str, String str2, boolean z, a aVar) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = z;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.OperatingSystem)) {
            return false;
        }
        CrashlyticsReport.Session.OperatingSystem operatingSystem = (CrashlyticsReport.Session.OperatingSystem) obj;
        if (this.a != operatingSystem.getPlatform() || !this.b.equals(operatingSystem.getVersion()) || !this.c.equals(operatingSystem.getBuildVersion()) || this.d != operatingSystem.isJailbroken()) {
            return false;
        }
        return true;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem
    @NonNull
    public String getBuildVersion() {
        return this.c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem
    public int getPlatform() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem
    @NonNull
    public String getVersion() {
        return this.b;
    }

    public int hashCode() {
        return ((((((this.a ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ (this.d ? 1231 : 1237);
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem
    public boolean isJailbroken() {
        return this.d;
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("OperatingSystem{platform=");
        L.append(this.a);
        L.append(", version=");
        L.append(this.b);
        L.append(", buildVersion=");
        L.append(this.c);
        L.append(", jailbroken=");
        return a2.b.a.a.a.B(L, this.d, "}");
    }
}
