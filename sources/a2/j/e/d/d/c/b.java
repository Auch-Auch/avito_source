package a2.j.e.d.d.c;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Objects;
public final class b extends CrashlyticsReport.CustomAttribute {
    public final String a;
    public final String b;

    /* renamed from: a2.j.e.d.d.c.b$b  reason: collision with other inner class name */
    public static final class C0079b extends CrashlyticsReport.CustomAttribute.Builder {
        public String a;
        public String b;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute.Builder
        public CrashlyticsReport.CustomAttribute build() {
            String str = this.a == null ? " key" : "";
            if (this.b == null) {
                str = a2.b.a.a.a.c3(str, " value");
            }
            if (str.isEmpty()) {
                return new b(this.a, this.b, null);
            }
            throw new IllegalStateException(a2.b.a.a.a.c3("Missing required properties:", str));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute.Builder
        public CrashlyticsReport.CustomAttribute.Builder setKey(String str) {
            Objects.requireNonNull(str, "Null key");
            this.a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute.Builder
        public CrashlyticsReport.CustomAttribute.Builder setValue(String str) {
            Objects.requireNonNull(str, "Null value");
            this.b = str;
            return this;
        }
    }

    public b(String str, String str2, a aVar) {
        this.a = str;
        this.b = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.CustomAttribute)) {
            return false;
        }
        CrashlyticsReport.CustomAttribute customAttribute = (CrashlyticsReport.CustomAttribute) obj;
        if (!this.a.equals(customAttribute.getKey()) || !this.b.equals(customAttribute.getValue())) {
            return false;
        }
        return true;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute
    @NonNull
    public String getKey() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute
    @NonNull
    public String getValue() {
        return this.b;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("CustomAttribute{key=");
        L.append(this.a);
        L.append(", value=");
        return a2.b.a.a.a.t(L, this.b, "}");
    }
}
