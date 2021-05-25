package a2.j.e.d.d.c;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Arrays;
import java.util.Objects;
public final class d extends CrashlyticsReport.FilesPayload.File {
    public final String a;
    public final byte[] b;

    public static final class b extends CrashlyticsReport.FilesPayload.File.Builder {
        public String a;
        public byte[] b;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File.Builder
        public CrashlyticsReport.FilesPayload.File build() {
            String str = this.a == null ? " filename" : "";
            if (this.b == null) {
                str = a2.b.a.a.a.c3(str, " contents");
            }
            if (str.isEmpty()) {
                return new d(this.a, this.b, null);
            }
            throw new IllegalStateException(a2.b.a.a.a.c3("Missing required properties:", str));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File.Builder
        public CrashlyticsReport.FilesPayload.File.Builder setContents(byte[] bArr) {
            Objects.requireNonNull(bArr, "Null contents");
            this.b = bArr;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File.Builder
        public CrashlyticsReport.FilesPayload.File.Builder setFilename(String str) {
            Objects.requireNonNull(str, "Null filename");
            this.a = str;
            return this;
        }
    }

    public d(String str, byte[] bArr, a aVar) {
        this.a = str;
        this.b = bArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.FilesPayload.File)) {
            return false;
        }
        CrashlyticsReport.FilesPayload.File file = (CrashlyticsReport.FilesPayload.File) obj;
        if (this.a.equals(file.getFilename())) {
            if (Arrays.equals(this.b, file instanceof d ? ((d) file).b : file.getContents())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File
    @NonNull
    public byte[] getContents() {
        return this.b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File
    @NonNull
    public String getFilename() {
        return this.a;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.b);
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("File{filename=");
        L.append(this.a);
        L.append(", contents=");
        L.append(Arrays.toString(this.b));
        L.append("}");
        return L.toString();
    }
}
