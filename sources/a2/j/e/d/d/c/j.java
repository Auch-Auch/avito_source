package a2.j.e.d.d.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import java.util.Objects;
public final class j extends CrashlyticsReport.Session.Event.Application {
    public final CrashlyticsReport.Session.Event.Application.Execution a;
    public final ImmutableList<CrashlyticsReport.CustomAttribute> b;
    public final Boolean c;
    public final int d;

    public static final class b extends CrashlyticsReport.Session.Event.Application.Builder {
        public CrashlyticsReport.Session.Event.Application.Execution a;
        public ImmutableList<CrashlyticsReport.CustomAttribute> b;
        public Boolean c;
        public Integer d;

        public b() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder
        public CrashlyticsReport.Session.Event.Application build() {
            String str = this.a == null ? " execution" : "";
            if (this.d == null) {
                str = a2.b.a.a.a.c3(str, " uiOrientation");
            }
            if (str.isEmpty()) {
                return new j(this.a, this.b, this.c, this.d.intValue(), null);
            }
            throw new IllegalStateException(a2.b.a.a.a.c3("Missing required properties:", str));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder
        public CrashlyticsReport.Session.Event.Application.Builder setBackground(@Nullable Boolean bool) {
            this.c = bool;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder
        public CrashlyticsReport.Session.Event.Application.Builder setCustomAttributes(ImmutableList<CrashlyticsReport.CustomAttribute> immutableList) {
            this.b = immutableList;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder
        public CrashlyticsReport.Session.Event.Application.Builder setExecution(CrashlyticsReport.Session.Event.Application.Execution execution) {
            Objects.requireNonNull(execution, "Null execution");
            this.a = execution;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder
        public CrashlyticsReport.Session.Event.Application.Builder setUiOrientation(int i) {
            this.d = Integer.valueOf(i);
            return this;
        }

        public b(CrashlyticsReport.Session.Event.Application application, a aVar) {
            j jVar = (j) application;
            this.a = jVar.a;
            this.b = jVar.b;
            this.c = jVar.c;
            this.d = Integer.valueOf(jVar.d);
        }
    }

    public j(CrashlyticsReport.Session.Event.Application.Execution execution, ImmutableList immutableList, Boolean bool, int i, a aVar) {
        this.a = execution;
        this.b = immutableList;
        this.c = bool;
        this.d = i;
    }

    public boolean equals(Object obj) {
        ImmutableList<CrashlyticsReport.CustomAttribute> immutableList;
        Boolean bool;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application application = (CrashlyticsReport.Session.Event.Application) obj;
        if (!this.a.equals(application.getExecution()) || ((immutableList = this.b) != null ? !immutableList.equals(application.getCustomAttributes()) : application.getCustomAttributes() != null) || ((bool = this.c) != null ? !bool.equals(application.getBackground()) : application.getBackground() != null) || this.d != application.getUiOrientation()) {
            return false;
        }
        return true;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    @Nullable
    public Boolean getBackground() {
        return this.c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    @Nullable
    public ImmutableList<CrashlyticsReport.CustomAttribute> getCustomAttributes() {
        return this.b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    @NonNull
    public CrashlyticsReport.Session.Event.Application.Execution getExecution() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    public int getUiOrientation() {
        return this.d;
    }

    public int hashCode() {
        int hashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        ImmutableList<CrashlyticsReport.CustomAttribute> immutableList = this.b;
        int i = 0;
        int hashCode2 = (hashCode ^ (immutableList == null ? 0 : immutableList.hashCode())) * 1000003;
        Boolean bool = this.c;
        if (bool != null) {
            i = bool.hashCode();
        }
        return ((hashCode2 ^ i) * 1000003) ^ this.d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    public CrashlyticsReport.Session.Event.Application.Builder toBuilder() {
        return new b(this, null);
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("Application{execution=");
        L.append(this.a);
        L.append(", customAttributes=");
        L.append(this.b);
        L.append(", background=");
        L.append(this.c);
        L.append(", uiOrientation=");
        return a2.b.a.a.a.j(L, this.d, "}");
    }
}
