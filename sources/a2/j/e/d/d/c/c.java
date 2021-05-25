package a2.j.e.d.d.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import java.util.Objects;
public final class c extends CrashlyticsReport.FilesPayload {
    public final ImmutableList<CrashlyticsReport.FilesPayload.File> a;
    public final String b;

    public static final class b extends CrashlyticsReport.FilesPayload.Builder {
        public ImmutableList<CrashlyticsReport.FilesPayload.File> a;
        public String b;

        public b() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.Builder
        public CrashlyticsReport.FilesPayload build() {
            String str = this.a == null ? " files" : "";
            if (str.isEmpty()) {
                return new c(this.a, this.b, null);
            }
            throw new IllegalStateException(a2.b.a.a.a.c3("Missing required properties:", str));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.Builder
        public CrashlyticsReport.FilesPayload.Builder setFiles(ImmutableList<CrashlyticsReport.FilesPayload.File> immutableList) {
            Objects.requireNonNull(immutableList, "Null files");
            this.a = immutableList;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.Builder
        public CrashlyticsReport.FilesPayload.Builder setOrgId(String str) {
            this.b = str;
            return this;
        }

        public b(CrashlyticsReport.FilesPayload filesPayload, a aVar) {
            c cVar = (c) filesPayload;
            this.a = cVar.a;
            this.b = cVar.b;
        }
    }

    public c(ImmutableList immutableList, String str, a aVar) {
        this.a = immutableList;
        this.b = str;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload
    public CrashlyticsReport.FilesPayload.Builder a() {
        return new b(this, null);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.FilesPayload)) {
            return false;
        }
        CrashlyticsReport.FilesPayload filesPayload = (CrashlyticsReport.FilesPayload) obj;
        if (this.a.equals(filesPayload.getFiles())) {
            String str = this.b;
            if (str == null) {
                if (filesPayload.getOrgId() == null) {
                    return true;
                }
            } else if (str.equals(filesPayload.getOrgId())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload
    @NonNull
    public ImmutableList<CrashlyticsReport.FilesPayload.File> getFiles() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload
    @Nullable
    public String getOrgId() {
        return this.b;
    }

    public int hashCode() {
        int hashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        String str = this.b;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("FilesPayload{files=");
        L.append(this.a);
        L.append(", orgId=");
        return a2.b.a.a.a.t(L, this.b, "}");
    }
}
