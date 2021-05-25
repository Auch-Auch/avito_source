package a2.j.e.d.d.c;

import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
public final class q extends CrashlyticsReport.Session.Event.Device {
    public final Double a;
    public final int b;
    public final boolean c;
    public final int d;
    public final long e;
    public final long f;

    public static final class b extends CrashlyticsReport.Session.Event.Device.Builder {
        public Double a;
        public Integer b;
        public Boolean c;
        public Integer d;
        public Long e;
        public Long f;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device build() {
            String str = this.b == null ? " batteryVelocity" : "";
            if (this.c == null) {
                str = a2.b.a.a.a.c3(str, " proximityOn");
            }
            if (this.d == null) {
                str = a2.b.a.a.a.c3(str, " orientation");
            }
            if (this.e == null) {
                str = a2.b.a.a.a.c3(str, " ramUsed");
            }
            if (this.f == null) {
                str = a2.b.a.a.a.c3(str, " diskUsed");
            }
            if (str.isEmpty()) {
                return new q(this.a, this.b.intValue(), this.c.booleanValue(), this.d.intValue(), this.e.longValue(), this.f.longValue(), null);
            }
            throw new IllegalStateException(a2.b.a.a.a.c3("Missing required properties:", str));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device.Builder setBatteryLevel(Double d2) {
            this.a = d2;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device.Builder setBatteryVelocity(int i) {
            this.b = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device.Builder setDiskUsed(long j) {
            this.f = Long.valueOf(j);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device.Builder setOrientation(int i) {
            this.d = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device.Builder setProximityOn(boolean z) {
            this.c = Boolean.valueOf(z);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device.Builder setRamUsed(long j) {
            this.e = Long.valueOf(j);
            return this;
        }
    }

    public q(Double d2, int i, boolean z, int i2, long j, long j2, a aVar) {
        this.a = d2;
        this.b = i;
        this.c = z;
        this.d = i2;
        this.e = j;
        this.f = j2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Device)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Device device = (CrashlyticsReport.Session.Event.Device) obj;
        Double d2 = this.a;
        if (d2 != null ? d2.equals(device.getBatteryLevel()) : device.getBatteryLevel() == null) {
            if (this.b == device.getBatteryVelocity() && this.c == device.isProximityOn() && this.d == device.getOrientation() && this.e == device.getRamUsed() && this.f == device.getDiskUsed()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    @Nullable
    public Double getBatteryLevel() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public int getBatteryVelocity() {
        return this.b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public long getDiskUsed() {
        return this.f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public int getOrientation() {
        return this.d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public long getRamUsed() {
        return this.e;
    }

    public int hashCode() {
        Double d2 = this.a;
        int hashCode = ((((d2 == null ? 0 : d2.hashCode()) ^ 1000003) * 1000003) ^ this.b) * 1000003;
        int i = this.c ? 1231 : 1237;
        long j = this.e;
        long j2 = this.f;
        return ((((((hashCode ^ i) * 1000003) ^ this.d) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public boolean isProximityOn() {
        return this.c;
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("Device{batteryLevel=");
        L.append(this.a);
        L.append(", batteryVelocity=");
        L.append(this.b);
        L.append(", proximityOn=");
        L.append(this.c);
        L.append(", orientation=");
        L.append(this.d);
        L.append(", ramUsed=");
        L.append(this.e);
        L.append(", diskUsed=");
        return a2.b.a.a.a.l(L, this.f, "}");
    }
}
