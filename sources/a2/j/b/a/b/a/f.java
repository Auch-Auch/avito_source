package a2.j.b.a.b.a;

import a2.b.a.a.a;
import com.google.android.datatransport.cct.a.zzs;
public final class f extends zzs {
    public final long a;

    public f(long j) {
        this.a = j;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzs) || this.a != ((zzs) obj).zza()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.a;
        return 1000003 ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return a.l(a.L("LogResponse{nextRequestWaitMillis="), this.a, "}");
    }

    @Override // com.google.android.datatransport.cct.a.zzs
    public long zza() {
        return this.a;
    }
}
