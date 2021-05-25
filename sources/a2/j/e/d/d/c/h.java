package a2.j.e.d.d.c;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Objects;
public final class h extends CrashlyticsReport.Session.Device {
    public final int a;
    public final String b;
    public final int c;
    public final long d;
    public final long e;
    public final boolean f;
    public final int g;
    public final String h;
    public final String i;

    public static final class b extends CrashlyticsReport.Session.Device.Builder {
        public Integer a;
        public String b;
        public Integer c;
        public Long d;
        public Long e;
        public Boolean f;
        public Integer g;
        public String h;
        public String i;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device build() {
            String str = this.a == null ? " arch" : "";
            if (this.b == null) {
                str = a2.b.a.a.a.c3(str, " model");
            }
            if (this.c == null) {
                str = a2.b.a.a.a.c3(str, " cores");
            }
            if (this.d == null) {
                str = a2.b.a.a.a.c3(str, " ram");
            }
            if (this.e == null) {
                str = a2.b.a.a.a.c3(str, " diskSpace");
            }
            if (this.f == null) {
                str = a2.b.a.a.a.c3(str, " simulator");
            }
            if (this.g == null) {
                str = a2.b.a.a.a.c3(str, " state");
            }
            if (this.h == null) {
                str = a2.b.a.a.a.c3(str, " manufacturer");
            }
            if (this.i == null) {
                str = a2.b.a.a.a.c3(str, " modelClass");
            }
            if (str.isEmpty()) {
                return new h(this.a.intValue(), this.b, this.c.intValue(), this.d.longValue(), this.e.longValue(), this.f.booleanValue(), this.g.intValue(), this.h, this.i, null);
            }
            throw new IllegalStateException(a2.b.a.a.a.c3("Missing required properties:", str));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder setArch(int i2) {
            this.a = Integer.valueOf(i2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder setCores(int i2) {
            this.c = Integer.valueOf(i2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder setDiskSpace(long j) {
            this.e = Long.valueOf(j);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder setManufacturer(String str) {
            Objects.requireNonNull(str, "Null manufacturer");
            this.h = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder setModel(String str) {
            Objects.requireNonNull(str, "Null model");
            this.b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder setModelClass(String str) {
            Objects.requireNonNull(str, "Null modelClass");
            this.i = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder setRam(long j) {
            this.d = Long.valueOf(j);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder setSimulator(boolean z) {
            this.f = Boolean.valueOf(z);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder setState(int i2) {
            this.g = Integer.valueOf(i2);
            return this;
        }
    }

    public h(int i2, String str, int i3, long j, long j2, boolean z, int i4, String str2, String str3, a aVar) {
        this.a = i2;
        this.b = str;
        this.c = i3;
        this.d = j;
        this.e = j2;
        this.f = z;
        this.g = i4;
        this.h = str2;
        this.i = str3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Device)) {
            return false;
        }
        CrashlyticsReport.Session.Device device = (CrashlyticsReport.Session.Device) obj;
        if (this.a == device.getArch() && this.b.equals(device.getModel()) && this.c == device.getCores() && this.d == device.getRam() && this.e == device.getDiskSpace() && this.f == device.isSimulator() && this.g == device.getState() && this.h.equals(device.getManufacturer()) && this.i.equals(device.getModelClass())) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    @NonNull
    public int getArch() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public int getCores() {
        return this.c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public long getDiskSpace() {
        return this.e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    @NonNull
    public String getManufacturer() {
        return this.h;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    @NonNull
    public String getModel() {
        return this.b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    @NonNull
    public String getModelClass() {
        return this.i;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public long getRam() {
        return this.d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public int getState() {
        return this.g;
    }

    public int hashCode() {
        long j = this.d;
        long j2 = this.e;
        return ((((((((((((((((this.a ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ (this.f ? 1231 : 1237)) * 1000003) ^ this.g) * 1000003) ^ this.h.hashCode()) * 1000003) ^ this.i.hashCode();
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public boolean isSimulator() {
        return this.f;
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("Device{arch=");
        L.append(this.a);
        L.append(", model=");
        L.append(this.b);
        L.append(", cores=");
        L.append(this.c);
        L.append(", ram=");
        L.append(this.d);
        L.append(", diskSpace=");
        L.append(this.e);
        L.append(", simulator=");
        L.append(this.f);
        L.append(", state=");
        L.append(this.g);
        L.append(", manufacturer=");
        L.append(this.h);
        L.append(", modelClass=");
        return a2.b.a.a.a.t(L, this.i, "}");
    }
}
