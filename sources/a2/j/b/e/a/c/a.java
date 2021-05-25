package a2.j.b.e.a.c;

import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.model.InstallErrorCode;
import com.google.android.play.core.install.model.InstallStatus;
import java.util.Objects;
public final class a extends InstallState {
    public final int a;
    public final long b;
    public final long c;
    public final int d;
    public final String e;

    public a(int i, long j, long j2, int i2, String str) {
        this.a = i;
        this.b = j;
        this.c = j2;
        this.d = i2;
        Objects.requireNonNull(str, "Null packageName");
        this.e = str;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final long bytesDownloaded() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InstallState) {
            InstallState installState = (InstallState) obj;
            if (this.a == installState.installStatus() && this.b == installState.bytesDownloaded() && this.c == installState.totalBytesToDownload() && this.d == installState.installErrorCode() && this.e.equals(installState.packageName())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.a;
        long j = this.b;
        long j2 = this.c;
        return ((((((((i ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.d) * 1000003) ^ this.e.hashCode();
    }

    @Override // com.google.android.play.core.install.InstallState
    @InstallErrorCode
    public final int installErrorCode() {
        return this.d;
    }

    @Override // com.google.android.play.core.install.InstallState
    @InstallStatus
    public final int installStatus() {
        return this.a;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final String packageName() {
        return this.e;
    }

    public final String toString() {
        int i = this.a;
        long j = this.b;
        long j2 = this.c;
        int i2 = this.d;
        String str = this.e;
        StringBuilder sb = new StringBuilder(str.length() + 164);
        sb.append("InstallState{installStatus=");
        sb.append(i);
        sb.append(", bytesDownloaded=");
        sb.append(j);
        a2.b.a.a.a.l1(sb, ", totalBytesToDownload=", j2, ", installErrorCode=");
        sb.append(i2);
        sb.append(", packageName=");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.play.core.install.InstallState
    public final long totalBytesToDownload() {
        return this.c;
    }
}
