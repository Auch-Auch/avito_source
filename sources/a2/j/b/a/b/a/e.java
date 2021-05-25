package a2.j.b.a.b.a;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.a.zzp;
import com.google.android.datatransport.cct.a.zzq;
import com.google.android.datatransport.cct.a.zzr;
import com.google.android.datatransport.cct.a.zzu;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;
public final class e extends zzr {
    public final long a;
    public final long b;
    public final zzp c;
    public final Integer d;
    public final String e;
    public final List<zzq> f;
    public final zzu g;

    public static final class a extends zzr.zza {
        public Long a;
        public Long b;
        public zzp c;
        public Integer d;
        public String e;
        public List<zzq> f;
        public zzu g;

        @Override // com.google.android.datatransport.cct.a.zzr.zza
        public zzr.zza a(@Nullable Integer num) {
            this.d = num;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zzr.zza
        public zzr.zza b(@Nullable String str) {
            this.e = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zzr.zza
        public zzr.zza zza(long j) {
            this.a = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zzr.zza
        public zzr.zza zzb(long j) {
            this.b = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zzr.zza
        public zzr.zza zza(@Nullable zzp zzp) {
            this.c = zzp;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zzr.zza
        public zzr.zza zza(@Nullable List<zzq> list) {
            this.f = list;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zzr.zza
        public zzr.zza zza(@Nullable zzu zzu) {
            this.g = zzu;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zzr.zza
        public zzr zza() {
            String str = this.a == null ? " requestTimeMs" : "";
            if (this.b == null) {
                str = a2.b.a.a.a.c3(str, " requestUptimeMs");
            }
            if (str.isEmpty()) {
                return new e(this.a.longValue(), this.b.longValue(), this.c, this.d, this.e, this.f, this.g);
            }
            throw new IllegalStateException(a2.b.a.a.a.c3("Missing required properties:", str));
        }
    }

    public /* synthetic */ e(long j, long j2, zzp zzp, Integer num, String str, List list, zzu zzu) {
        this.a = j;
        this.b = j2;
        this.c = zzp;
        this.d = num;
        this.e = str;
        this.f = list;
        this.g = zzu;
    }

    public boolean equals(Object obj) {
        zzp zzp;
        Integer num;
        String str;
        List<zzq> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzr)) {
            return false;
        }
        zzr zzr = (zzr) obj;
        if (this.a == zzr.zzg() && this.b == zzr.zzh() && ((zzp = this.c) != null ? zzp.equals(((e) zzr).c) : ((e) zzr).c == null) && ((num = this.d) != null ? num.equals(((e) zzr).d) : ((e) zzr).d == null) && ((str = this.e) != null ? str.equals(((e) zzr).e) : ((e) zzr).e == null) && ((list = this.f) != null ? list.equals(((e) zzr).f) : ((e) zzr).f == null)) {
            zzu zzu = this.g;
            if (zzu == null) {
                if (((e) zzr).g == null) {
                    return true;
                }
            } else if (zzu.equals(((e) zzr).g)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.a;
        long j2 = this.b;
        int i = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003;
        zzp zzp = this.c;
        int i2 = 0;
        int hashCode = (i ^ (zzp == null ? 0 : zzp.hashCode())) * 1000003;
        Integer num = this.d;
        int hashCode2 = (hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.e;
        int hashCode3 = (hashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<zzq> list = this.f;
        int hashCode4 = (hashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        zzu zzu = this.g;
        if (zzu != null) {
            i2 = zzu.hashCode();
        }
        return hashCode4 ^ i2;
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("LogRequest{requestTimeMs=");
        L.append(this.a);
        L.append(", requestUptimeMs=");
        L.append(this.b);
        L.append(", clientInfo=");
        L.append(this.c);
        L.append(", logSource=");
        L.append(this.d);
        L.append(", logSourceName=");
        L.append(this.e);
        L.append(", logEvents=");
        L.append(this.f);
        L.append(", qosTier=");
        L.append(this.g);
        L.append("}");
        return L.toString();
    }

    @Override // com.google.android.datatransport.cct.a.zzr
    @Nullable
    public zzp zzb() {
        return this.c;
    }

    @Override // com.google.android.datatransport.cct.a.zzr
    @Nullable
    @Encodable.Field(name = "logEvent")
    public List<zzq> zzc() {
        return this.f;
    }

    @Override // com.google.android.datatransport.cct.a.zzr
    @Nullable
    public Integer zzd() {
        return this.d;
    }

    @Override // com.google.android.datatransport.cct.a.zzr
    @Nullable
    public String zze() {
        return this.e;
    }

    @Override // com.google.android.datatransport.cct.a.zzr
    @Nullable
    public zzu zzf() {
        return this.g;
    }

    @Override // com.google.android.datatransport.cct.a.zzr
    public long zzg() {
        return this.a;
    }

    @Override // com.google.android.datatransport.cct.a.zzr
    public long zzh() {
        return this.b;
    }
}
