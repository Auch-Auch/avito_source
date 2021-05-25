package a2.j.b.a.b.a;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.a.zzq;
import com.google.android.datatransport.cct.a.zzt;
import java.util.Arrays;
public final class d extends zzq {
    public final long a;
    public final Integer b;
    public final long c;
    public final byte[] d;
    public final String e;
    public final long f;
    public final zzt g;

    public static final class a extends zzq.zza {
        public Long a;
        public Integer b;
        public Long c;
        public byte[] d;
        public String e;
        public Long f;
        public zzt g;

        @Override // com.google.android.datatransport.cct.a.zzq.zza
        public zzq.zza zza(long j) {
            this.a = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zzq.zza
        public zzq.zza zzb(long j) {
            this.c = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zzq.zza
        public zzq.zza zzc(long j) {
            this.f = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zzq.zza
        public zzq.zza zza(@Nullable Integer num) {
            this.b = num;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zzq.zza
        public zzq.zza zza(@Nullable zzt zzt) {
            this.g = zzt;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zzq.zza
        public zzq zza() {
            String str = this.a == null ? " eventTimeMs" : "";
            if (this.c == null) {
                str = a2.b.a.a.a.c3(str, " eventUptimeMs");
            }
            if (this.f == null) {
                str = a2.b.a.a.a.c3(str, " timezoneOffsetSeconds");
            }
            if (str.isEmpty()) {
                return new d(this.a.longValue(), this.b, this.c.longValue(), this.d, this.e, this.f.longValue(), this.g);
            }
            throw new IllegalStateException(a2.b.a.a.a.c3("Missing required properties:", str));
        }
    }

    public /* synthetic */ d(long j, Integer num, long j2, byte[] bArr, String str, long j3, zzt zzt) {
        this.a = j;
        this.b = num;
        this.c = j2;
        this.d = bArr;
        this.e = str;
        this.f = j3;
        this.g = zzt;
    }

    public boolean equals(Object obj) {
        Integer num;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzq)) {
            return false;
        }
        zzq zzq = (zzq) obj;
        if (this.a == zzq.zzb() && ((num = this.b) != null ? num.equals(((d) zzq).b) : ((d) zzq).b == null) && this.c == zzq.zzc()) {
            if (Arrays.equals(this.d, zzq instanceof d ? ((d) zzq).d : zzq.zze()) && ((str = this.e) != null ? str.equals(((d) zzq).e) : ((d) zzq).e == null) && this.f == zzq.zzg()) {
                zzt zzt = this.g;
                if (zzt == null) {
                    if (((d) zzq).g == null) {
                        return true;
                    }
                } else if (zzt.equals(((d) zzq).g)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.a;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.b;
        int i2 = 0;
        int hashCode = num == null ? 0 : num.hashCode();
        long j2 = this.c;
        int hashCode2 = (((((i ^ hashCode) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.d)) * 1000003;
        String str = this.e;
        int hashCode3 = str == null ? 0 : str.hashCode();
        long j3 = this.f;
        int i3 = (((hashCode2 ^ hashCode3) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003;
        zzt zzt = this.g;
        if (zzt != null) {
            i2 = zzt.hashCode();
        }
        return i3 ^ i2;
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("LogEvent{eventTimeMs=");
        L.append(this.a);
        L.append(", eventCode=");
        L.append(this.b);
        L.append(", eventUptimeMs=");
        L.append(this.c);
        L.append(", sourceExtension=");
        L.append(Arrays.toString(this.d));
        L.append(", sourceExtensionJsonProto3=");
        L.append(this.e);
        L.append(", timezoneOffsetSeconds=");
        L.append(this.f);
        L.append(", networkConnectionInfo=");
        L.append(this.g);
        L.append("}");
        return L.toString();
    }

    @Override // com.google.android.datatransport.cct.a.zzq
    @Nullable
    public Integer zza() {
        return this.b;
    }

    @Override // com.google.android.datatransport.cct.a.zzq
    public long zzb() {
        return this.a;
    }

    @Override // com.google.android.datatransport.cct.a.zzq
    public long zzc() {
        return this.c;
    }

    @Override // com.google.android.datatransport.cct.a.zzq
    @Nullable
    public zzt zzd() {
        return this.g;
    }

    @Override // com.google.android.datatransport.cct.a.zzq
    @Nullable
    public byte[] zze() {
        return this.d;
    }

    @Override // com.google.android.datatransport.cct.a.zzq
    @Nullable
    public String zzf() {
        return this.e;
    }

    @Override // com.google.android.datatransport.cct.a.zzq
    public long zzg() {
        return this.f;
    }
}
