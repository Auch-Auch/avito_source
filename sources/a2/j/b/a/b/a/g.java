package a2.j.b.a.b.a;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.a.zzt;
public final class g extends zzt {
    public final zzt.zzc a;
    public final zzt.zzb b;

    public static final class a extends zzt.zza {
        public zzt.zzc a;
        public zzt.zzb b;

        @Override // com.google.android.datatransport.cct.a.zzt.zza
        public zzt.zza zza(@Nullable zzt.zzc zzc) {
            this.a = zzc;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zzt.zza
        public zzt.zza zza(@Nullable zzt.zzb zzb) {
            this.b = zzb;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zzt.zza
        public zzt zza() {
            return new g(this.a, this.b);
        }
    }

    public /* synthetic */ g(zzt.zzc zzc, zzt.zzb zzb) {
        this.a = zzc;
        this.b = zzb;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzt)) {
            return false;
        }
        zzt.zzc zzc = this.a;
        if (zzc != null ? zzc.equals(((g) obj).a) : ((g) obj).a == null) {
            zzt.zzb zzb = this.b;
            if (zzb == null) {
                if (((g) obj).b == null) {
                    return true;
                }
            } else if (zzb.equals(((g) obj).b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        zzt.zzc zzc = this.a;
        int i = 0;
        int hashCode = ((zzc == null ? 0 : zzc.hashCode()) ^ 1000003) * 1000003;
        zzt.zzb zzb = this.b;
        if (zzb != null) {
            i = zzb.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("NetworkConnectionInfo{networkType=");
        L.append(this.a);
        L.append(", mobileSubtype=");
        L.append(this.b);
        L.append("}");
        return L.toString();
    }

    @Override // com.google.android.datatransport.cct.a.zzt
    @Nullable
    public zzt.zzb zzb() {
        return this.b;
    }

    @Override // com.google.android.datatransport.cct.a.zzt
    @Nullable
    public zzt.zzc zzc() {
        return this.a;
    }
}
