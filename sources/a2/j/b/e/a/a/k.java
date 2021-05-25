package a2.j.b.e.a.a;

import a2.b.a.a.a;
import android.app.PendingIntent;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;
import java.util.Objects;
public final class k extends AppUpdateInfo {
    public final String a;
    public final int b;
    public final int c;
    public final int d;
    public final Integer e;
    public final int f;
    public final long g;
    public final long h;
    public final long i;
    public final long j;
    public final PendingIntent k;
    public final PendingIntent l;
    public final PendingIntent m;
    public final PendingIntent n;

    public k(String str, int i2, int i3, int i4, Integer num, int i5, long j2, long j3, long j4, long j5, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3, PendingIntent pendingIntent4) {
        Objects.requireNonNull(str, "Null packageName");
        this.a = str;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = num;
        this.f = i5;
        this.g = j2;
        this.h = j3;
        this.i = j4;
        this.j = j5;
        this.k = pendingIntent;
        this.l = pendingIntent2;
        this.m = pendingIntent3;
        this.n = pendingIntent4;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    public final long a() {
        return this.i;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    public final int availableVersionCode() {
        return this.b;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    public final long bytesDownloaded() {
        return this.g;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    public final long c() {
        return this.j;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    public final Integer clientVersionStalenessDays() {
        return this.e;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    public final PendingIntent e() {
        return this.k;
    }

    public final boolean equals(Object obj) {
        Integer num;
        PendingIntent pendingIntent;
        PendingIntent pendingIntent2;
        PendingIntent pendingIntent3;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AppUpdateInfo) {
            AppUpdateInfo appUpdateInfo = (AppUpdateInfo) obj;
            if (this.a.equals(appUpdateInfo.packageName()) && this.b == appUpdateInfo.availableVersionCode() && this.c == appUpdateInfo.updateAvailability() && this.d == appUpdateInfo.installStatus() && ((num = this.e) == null ? appUpdateInfo.clientVersionStalenessDays() == null : num.equals(appUpdateInfo.clientVersionStalenessDays())) && this.f == appUpdateInfo.updatePriority() && this.g == appUpdateInfo.bytesDownloaded() && this.h == appUpdateInfo.totalBytesToDownload() && this.i == appUpdateInfo.a() && this.j == appUpdateInfo.c() && ((pendingIntent = this.k) == null ? appUpdateInfo.e() == null : pendingIntent.equals(appUpdateInfo.e())) && ((pendingIntent2 = this.l) == null ? appUpdateInfo.f() == null : pendingIntent2.equals(appUpdateInfo.f())) && ((pendingIntent3 = this.m) == null ? appUpdateInfo.g() == null : pendingIntent3.equals(appUpdateInfo.g()))) {
                PendingIntent pendingIntent4 = this.n;
                PendingIntent h2 = appUpdateInfo.h();
                if (pendingIntent4 == null ? h2 == null : pendingIntent4.equals(h2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    public final PendingIntent f() {
        return this.l;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    public final PendingIntent g() {
        return this.m;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    public final PendingIntent h() {
        return this.n;
    }

    public final int hashCode() {
        int hashCode = (((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c) * 1000003) ^ this.d) * 1000003;
        Integer num = this.e;
        int i2 = 0;
        int hashCode2 = num != null ? num.hashCode() : 0;
        int i3 = this.f;
        long j2 = this.g;
        long j3 = this.h;
        long j4 = this.i;
        long j5 = this.j;
        int i4 = (((((((((((hashCode ^ hashCode2) * 1000003) ^ i3) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003) ^ ((int) ((j4 >>> 32) ^ j4))) * 1000003) ^ ((int) ((j5 >>> 32) ^ j5))) * 1000003;
        PendingIntent pendingIntent = this.k;
        int hashCode3 = (i4 ^ (pendingIntent != null ? pendingIntent.hashCode() : 0)) * 1000003;
        PendingIntent pendingIntent2 = this.l;
        int hashCode4 = (hashCode3 ^ (pendingIntent2 != null ? pendingIntent2.hashCode() : 0)) * 1000003;
        PendingIntent pendingIntent3 = this.m;
        int hashCode5 = (hashCode4 ^ (pendingIntent3 != null ? pendingIntent3.hashCode() : 0)) * 1000003;
        PendingIntent pendingIntent4 = this.n;
        if (pendingIntent4 != null) {
            i2 = pendingIntent4.hashCode();
        }
        return hashCode5 ^ i2;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    @InstallStatus
    public final int installStatus() {
        return this.d;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    public final String packageName() {
        return this.a;
    }

    public final String toString() {
        String str = this.a;
        int i2 = this.b;
        int i3 = this.c;
        int i4 = this.d;
        String valueOf = String.valueOf(this.e);
        int i5 = this.f;
        long j2 = this.g;
        long j3 = this.h;
        long j4 = this.i;
        long j5 = this.j;
        String valueOf2 = String.valueOf(this.k);
        String valueOf3 = String.valueOf(this.l);
        String valueOf4 = String.valueOf(this.m);
        String valueOf5 = String.valueOf(this.n);
        int length = str.length();
        int length2 = valueOf.length();
        int length3 = valueOf2.length();
        int length4 = valueOf3.length();
        StringBuilder sb = new StringBuilder(length + 463 + length2 + length3 + length4 + valueOf4.length() + valueOf5.length());
        sb.append("AppUpdateInfo{packageName=");
        sb.append(str);
        sb.append(", availableVersionCode=");
        sb.append(i2);
        sb.append(", updateAvailability=");
        sb.append(i3);
        sb.append(", installStatus=");
        sb.append(i4);
        sb.append(", clientVersionStalenessDays=");
        sb.append(valueOf);
        sb.append(", updatePriority=");
        sb.append(i5);
        a.l1(sb, ", bytesDownloaded=", j2, ", totalBytesToDownload=");
        sb.append(j3);
        a.l1(sb, ", additionalSpaceRequired=", j4, ", assetPackStorageSize=");
        sb.append(j5);
        sb.append(", immediateUpdateIntent=");
        sb.append(valueOf2);
        a.n1(sb, ", flexibleUpdateIntent=", valueOf3, ", immediateDestructiveUpdateIntent=", valueOf4);
        return a.u(sb, ", flexibleDestructiveUpdateIntent=", valueOf5, "}");
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    public final long totalBytesToDownload() {
        return this.h;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    @UpdateAvailability
    public final int updateAvailability() {
        return this.c;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    public final int updatePriority() {
        return this.f;
    }
}
