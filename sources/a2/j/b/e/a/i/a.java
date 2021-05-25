package a2.j.b.e.a.i;

import android.app.PendingIntent;
import android.content.Intent;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.model.SplitInstallErrorCode;
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus;
import java.util.List;
public final class a extends SplitInstallSessionState {
    public final int a;
    public final int b;
    public final int c;
    public final long d;
    public final long e;
    public final List<String> f;
    public final List<String> g;
    public final PendingIntent h;
    public final List<Intent> i;

    public a(int i2, int i3, int i4, long j, long j2, List<String> list, List<String> list2, PendingIntent pendingIntent, List<Intent> list3) {
        this.a = i2;
        this.b = i3;
        this.c = i4;
        this.d = j;
        this.e = j2;
        this.f = list;
        this.g = list2;
        this.h = pendingIntent;
        this.i = list3;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallSessionState
    public final List<String> b() {
        return this.f;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallSessionState
    public final long bytesDownloaded() {
        return this.d;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallSessionState
    public final List<String> c() {
        return this.g;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallSessionState
    public final List<Intent> d() {
        return this.i;
    }

    public final boolean equals(Object obj) {
        List<String> list;
        List<String> list2;
        PendingIntent pendingIntent;
        if (obj == this) {
            return true;
        }
        if (obj instanceof SplitInstallSessionState) {
            SplitInstallSessionState splitInstallSessionState = (SplitInstallSessionState) obj;
            if (this.a == splitInstallSessionState.sessionId() && this.b == splitInstallSessionState.status() && this.c == splitInstallSessionState.errorCode() && this.d == splitInstallSessionState.bytesDownloaded() && this.e == splitInstallSessionState.totalBytesToDownload() && ((list = this.f) == null ? splitInstallSessionState.b() == null : list.equals(splitInstallSessionState.b())) && ((list2 = this.g) == null ? splitInstallSessionState.c() == null : list2.equals(splitInstallSessionState.c())) && ((pendingIntent = this.h) == null ? splitInstallSessionState.resolutionIntent() == null : pendingIntent.equals(splitInstallSessionState.resolutionIntent()))) {
                List<Intent> list3 = this.i;
                List<Intent> d2 = splitInstallSessionState.d();
                if (list3 == null ? d2 == null : list3.equals(d2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallSessionState
    @SplitInstallErrorCode
    public final int errorCode() {
        return this.c;
    }

    public final int hashCode() {
        int i2 = this.a;
        int i3 = this.b;
        int i4 = this.c;
        long j = this.d;
        long j2 = this.e;
        int i5 = (((((((((i2 ^ 1000003) * 1000003) ^ i3) * 1000003) ^ i4) * 1000003) ^ ((int) ((j >>> 32) ^ j))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003;
        List<String> list = this.f;
        int i6 = 0;
        int hashCode = (i5 ^ (list != null ? list.hashCode() : 0)) * 1000003;
        List<String> list2 = this.g;
        int hashCode2 = (hashCode ^ (list2 != null ? list2.hashCode() : 0)) * 1000003;
        PendingIntent pendingIntent = this.h;
        int hashCode3 = (hashCode2 ^ (pendingIntent != null ? pendingIntent.hashCode() : 0)) * 1000003;
        List<Intent> list3 = this.i;
        if (list3 != null) {
            i6 = list3.hashCode();
        }
        return hashCode3 ^ i6;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallSessionState
    @Deprecated
    public final PendingIntent resolutionIntent() {
        return this.h;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallSessionState
    public final int sessionId() {
        return this.a;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallSessionState
    @SplitInstallSessionStatus
    public final int status() {
        return this.b;
    }

    public final String toString() {
        int i2 = this.a;
        int i3 = this.b;
        int i4 = this.c;
        long j = this.d;
        long j2 = this.e;
        String valueOf = String.valueOf(this.f);
        String valueOf2 = String.valueOf(this.g);
        String valueOf3 = String.valueOf(this.h);
        String valueOf4 = String.valueOf(this.i);
        int length = valueOf.length();
        int length2 = valueOf2.length();
        StringBuilder sb = new StringBuilder(length + 251 + length2 + valueOf3.length() + valueOf4.length());
        sb.append("SplitInstallSessionState{sessionId=");
        sb.append(i2);
        sb.append(", status=");
        sb.append(i3);
        sb.append(", errorCode=");
        sb.append(i4);
        sb.append(", bytesDownloaded=");
        sb.append(j);
        a2.b.a.a.a.l1(sb, ", totalBytesToDownload=", j2, ", moduleNamesNullable=");
        a2.b.a.a.a.n1(sb, valueOf, ", languagesNullable=", valueOf2, ", resolutionIntent=");
        return a2.b.a.a.a.v(sb, valueOf3, ", splitFileIntents=", valueOf4, "}");
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallSessionState
    public final long totalBytesToDownload() {
        return this.e;
    }
}
