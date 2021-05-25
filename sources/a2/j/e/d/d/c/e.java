package a2.j.e.d.d.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.Objects;
public final class e extends CrashlyticsReport.Session {
    public final String a;
    public final String b;
    public final long c;
    public final Long d;
    public final boolean e;
    public final CrashlyticsReport.Session.Application f;
    public final CrashlyticsReport.Session.User g;
    public final CrashlyticsReport.Session.OperatingSystem h;
    public final CrashlyticsReport.Session.Device i;
    public final ImmutableList<CrashlyticsReport.Session.Event> j;
    public final int k;

    public static final class b extends CrashlyticsReport.Session.Builder {
        public String a;
        public String b;
        public Long c;
        public Long d;
        public Boolean e;
        public CrashlyticsReport.Session.Application f;
        public CrashlyticsReport.Session.User g;
        public CrashlyticsReport.Session.OperatingSystem h;
        public CrashlyticsReport.Session.Device i;
        public ImmutableList<CrashlyticsReport.Session.Event> j;
        public Integer k;

        public b() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session build() {
            String str = this.a == null ? " generator" : "";
            if (this.b == null) {
                str = a2.b.a.a.a.c3(str, " identifier");
            }
            if (this.c == null) {
                str = a2.b.a.a.a.c3(str, " startedAt");
            }
            if (this.e == null) {
                str = a2.b.a.a.a.c3(str, " crashed");
            }
            if (this.f == null) {
                str = a2.b.a.a.a.c3(str, " app");
            }
            if (this.k == null) {
                str = a2.b.a.a.a.c3(str, " generatorType");
            }
            if (str.isEmpty()) {
                return new e(this.a, this.b, this.c.longValue(), this.d, this.e.booleanValue(), this.f, this.g, this.h, this.i, this.j, this.k.intValue(), null);
            }
            throw new IllegalStateException(a2.b.a.a.a.c3("Missing required properties:", str));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setApp(CrashlyticsReport.Session.Application application) {
            Objects.requireNonNull(application, "Null app");
            this.f = application;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setCrashed(boolean z) {
            this.e = Boolean.valueOf(z);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setDevice(CrashlyticsReport.Session.Device device) {
            this.i = device;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setEndedAt(Long l) {
            this.d = l;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setEvents(ImmutableList<CrashlyticsReport.Session.Event> immutableList) {
            this.j = immutableList;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setGenerator(String str) {
            Objects.requireNonNull(str, "Null generator");
            this.a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setGeneratorType(int i2) {
            this.k = Integer.valueOf(i2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setIdentifier(String str) {
            Objects.requireNonNull(str, "Null identifier");
            this.b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setOs(CrashlyticsReport.Session.OperatingSystem operatingSystem) {
            this.h = operatingSystem;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setStartedAt(long j2) {
            this.c = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setUser(CrashlyticsReport.Session.User user) {
            this.g = user;
            return this;
        }

        public b(CrashlyticsReport.Session session, a aVar) {
            e eVar = (e) session;
            this.a = eVar.a;
            this.b = eVar.b;
            this.c = Long.valueOf(eVar.c);
            this.d = eVar.d;
            this.e = Boolean.valueOf(eVar.e);
            this.f = eVar.f;
            this.g = eVar.g;
            this.h = eVar.h;
            this.i = eVar.i;
            this.j = eVar.j;
            this.k = Integer.valueOf(eVar.k);
        }
    }

    public e(String str, String str2, long j2, Long l, boolean z, CrashlyticsReport.Session.Application application, CrashlyticsReport.Session.User user, CrashlyticsReport.Session.OperatingSystem operatingSystem, CrashlyticsReport.Session.Device device, ImmutableList immutableList, int i2, a aVar) {
        this.a = str;
        this.b = str2;
        this.c = j2;
        this.d = l;
        this.e = z;
        this.f = application;
        this.g = user;
        this.h = operatingSystem;
        this.i = device;
        this.j = immutableList;
        this.k = i2;
    }

    public boolean equals(Object obj) {
        Long l;
        CrashlyticsReport.Session.User user;
        CrashlyticsReport.Session.OperatingSystem operatingSystem;
        CrashlyticsReport.Session.Device device;
        ImmutableList<CrashlyticsReport.Session.Event> immutableList;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session)) {
            return false;
        }
        CrashlyticsReport.Session session = (CrashlyticsReport.Session) obj;
        if (!this.a.equals(session.getGenerator()) || !this.b.equals(session.getIdentifier()) || this.c != session.getStartedAt() || ((l = this.d) != null ? !l.equals(session.getEndedAt()) : session.getEndedAt() != null) || this.e != session.isCrashed() || !this.f.equals(session.getApp()) || ((user = this.g) != null ? !user.equals(session.getUser()) : session.getUser() != null) || ((operatingSystem = this.h) != null ? !operatingSystem.equals(session.getOs()) : session.getOs() != null) || ((device = this.i) != null ? !device.equals(session.getDevice()) : session.getDevice() != null) || ((immutableList = this.j) != null ? !immutableList.equals(session.getEvents()) : session.getEvents() != null) || this.k != session.getGeneratorType()) {
            return false;
        }
        return true;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    @NonNull
    public CrashlyticsReport.Session.Application getApp() {
        return this.f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    @Nullable
    public CrashlyticsReport.Session.Device getDevice() {
        return this.i;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    @Nullable
    public Long getEndedAt() {
        return this.d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    @Nullable
    public ImmutableList<CrashlyticsReport.Session.Event> getEvents() {
        return this.j;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    @NonNull
    public String getGenerator() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public int getGeneratorType() {
        return this.k;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    @NonNull
    @Encodable.Ignore
    public String getIdentifier() {
        return this.b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    @Nullable
    public CrashlyticsReport.Session.OperatingSystem getOs() {
        return this.h;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public long getStartedAt() {
        return this.c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    @Nullable
    public CrashlyticsReport.Session.User getUser() {
        return this.g;
    }

    public int hashCode() {
        long j2 = this.c;
        int hashCode = (((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        Long l = this.d;
        int i2 = 0;
        int hashCode2 = (((((hashCode ^ (l == null ? 0 : l.hashCode())) * 1000003) ^ (this.e ? 1231 : 1237)) * 1000003) ^ this.f.hashCode()) * 1000003;
        CrashlyticsReport.Session.User user = this.g;
        int hashCode3 = (hashCode2 ^ (user == null ? 0 : user.hashCode())) * 1000003;
        CrashlyticsReport.Session.OperatingSystem operatingSystem = this.h;
        int hashCode4 = (hashCode3 ^ (operatingSystem == null ? 0 : operatingSystem.hashCode())) * 1000003;
        CrashlyticsReport.Session.Device device = this.i;
        int hashCode5 = (hashCode4 ^ (device == null ? 0 : device.hashCode())) * 1000003;
        ImmutableList<CrashlyticsReport.Session.Event> immutableList = this.j;
        if (immutableList != null) {
            i2 = immutableList.hashCode();
        }
        return ((hashCode5 ^ i2) * 1000003) ^ this.k;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public boolean isCrashed() {
        return this.e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public CrashlyticsReport.Session.Builder toBuilder() {
        return new b(this, null);
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("Session{generator=");
        L.append(this.a);
        L.append(", identifier=");
        L.append(this.b);
        L.append(", startedAt=");
        L.append(this.c);
        L.append(", endedAt=");
        L.append(this.d);
        L.append(", crashed=");
        L.append(this.e);
        L.append(", app=");
        L.append(this.f);
        L.append(", user=");
        L.append(this.g);
        L.append(", os=");
        L.append(this.h);
        L.append(", device=");
        L.append(this.i);
        L.append(", events=");
        L.append(this.j);
        L.append(", generatorType=");
        return a2.b.a.a.a.j(L, this.k, "}");
    }
}
