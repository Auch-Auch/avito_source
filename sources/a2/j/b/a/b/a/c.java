package a2.j.b.a.b.a;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.a.zza;
import com.google.android.datatransport.cct.a.zzp;
public final class c extends zzp {
    public final zzp.zzb a;
    public final zza b;

    public static final class a extends zzp.zza {
        public zzp.zzb a;
        public zza b;

        @Override // com.google.android.datatransport.cct.a.zzp.zza
        public zzp.zza zza(@Nullable zzp.zzb zzb) {
            this.a = zzb;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zzp.zza
        public zzp.zza zza(@Nullable zza zza) {
            this.b = zza;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zzp.zza
        public zzp zza() {
            return new c(this.a, this.b);
        }
    }

    public /* synthetic */ c(zzp.zzb zzb, zza zza) {
        this.a = zzb;
        this.b = zza;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzp)) {
            return false;
        }
        zzp.zzb zzb = this.a;
        if (zzb != null ? zzb.equals(((c) obj).a) : ((c) obj).a == null) {
            zza zza = this.b;
            if (zza == null) {
                if (((c) obj).b == null) {
                    return true;
                }
            } else if (zza.equals(((c) obj).b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        zzp.zzb zzb = this.a;
        int i = 0;
        int hashCode = ((zzb == null ? 0 : zzb.hashCode()) ^ 1000003) * 1000003;
        zza zza = this.b;
        if (zza != null) {
            i = zza.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("ClientInfo{clientType=");
        L.append(this.a);
        L.append(", androidClientInfo=");
        L.append(this.b);
        L.append("}");
        return L.toString();
    }

    @Override // com.google.android.datatransport.cct.a.zzp
    @Nullable
    public zza zzb() {
        return this.b;
    }

    @Override // com.google.android.datatransport.cct.a.zzp
    @Nullable
    public zzp.zzb zzc() {
        return this.a;
    }
}
