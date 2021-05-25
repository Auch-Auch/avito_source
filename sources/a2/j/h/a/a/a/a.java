package a2.j.h.a.a.a;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.internal.model.ModelUtils;
import java.util.Objects;
public final class a extends ModelUtils.ModelLoggingInfo {
    public final long a;
    public final String b;

    public a(long j, String str) {
        this.a = j;
        Objects.requireNonNull(str, "Null hash");
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ModelUtils.ModelLoggingInfo) {
            ModelUtils.ModelLoggingInfo modelLoggingInfo = (ModelUtils.ModelLoggingInfo) obj;
            if (this.a == modelLoggingInfo.getSize() && this.b.equals(modelLoggingInfo.getHash())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.mlkit.common.internal.model.ModelUtils.ModelLoggingInfo
    @KeepForSdk
    public final String getHash() {
        return this.b;
    }

    @Override // com.google.mlkit.common.internal.model.ModelUtils.ModelLoggingInfo
    @KeepForSdk
    public final long getSize() {
        return this.a;
    }

    public final int hashCode() {
        long j = this.a;
        return this.b.hashCode() ^ ((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003);
    }

    public final String toString() {
        long j = this.a;
        String str = this.b;
        StringBuilder sb = new StringBuilder(a2.b.a.a.a.q0(str, 50));
        sb.append("ModelLoggingInfo{size=");
        sb.append(j);
        sb.append(", hash=");
        return a2.b.a.a.a.t(sb, str, "}");
    }
}
