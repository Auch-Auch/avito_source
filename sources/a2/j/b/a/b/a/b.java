package a2.j.b.a.b.a;

import a2.b.a.a.a;
import androidx.annotation.NonNull;
import com.google.android.datatransport.cct.a.zzo;
import com.google.android.datatransport.cct.a.zzr;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;
import java.util.Objects;
public final class b extends zzo {
    public final List<zzr> a;

    public b(List<zzr> list) {
        Objects.requireNonNull(list, "Null logRequests");
        this.a = list;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzo) {
            return this.a.equals(((zzo) obj).zza());
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        return a.w(a.L("BatchedLogRequest{logRequests="), this.a, "}");
    }

    @Override // com.google.android.datatransport.cct.a.zzo
    @NonNull
    @Encodable.Field(name = "logRequest")
    public List<zzr> zza() {
        return this.a;
    }
}
