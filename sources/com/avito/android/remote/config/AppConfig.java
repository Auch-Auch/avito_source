package com.avito.android.remote.config;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010'\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0011\u0012\b\b\u0002\u0010 \u001a\u00020\u001d¢\u0006\u0004\b(\u0010)J\u001f\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\"\u0010 \u001a\u00020\u001d8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b$\u0010\u000b\u001a\u0004\b%\u0010\r\"\u0004\b&\u0010\u000f¨\u0006*"}, d2 = {"Lcom/avito/android/remote/config/AppConfig;", "", "", "currentVersionCode", "sdkVersion", "validateVersion", "(II)I", "", "toString", "()Ljava/lang/String;", AuthSource.SEND_ABUSE, "I", "getVersionMin", "()I", "setVersionMin", "(I)V", "versionMin", "", "d", "J", "getGeoReportTimeout", "()J", "setGeoReportTimeout", "(J)V", "geoReportTimeout", "c", "getPlatformVersion", "setPlatformVersion", "platformVersion", "", "e", "Z", "isYandexReportsEnabled", "()Z", "setYandexReportsEnabled", "(Z)V", AuthSource.BOOKING_ORDER, "getVersionMax", "setVersionMax", "versionMax", "<init>", "(IIIJZ)V", "config_release"}, k = 1, mv = {1, 4, 2})
public class AppConfig {
    public int a;
    public int b;
    public int c;
    public long d;
    public boolean e;

    public AppConfig() {
        this(0, 0, 0, 0, false, 31, null);
    }

    public AppConfig(int i, int i2, int i3, long j, boolean z) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = j;
        this.e = z;
    }

    public final long getGeoReportTimeout() {
        return this.d;
    }

    public final int getPlatformVersion() {
        return this.c;
    }

    public final int getVersionMax() {
        return this.b;
    }

    public final int getVersionMin() {
        return this.a;
    }

    public final boolean isYandexReportsEnabled() {
        return this.e;
    }

    public final void setGeoReportTimeout(long j) {
        this.d = j;
    }

    public final void setPlatformVersion(int i) {
        this.c = i;
    }

    public final void setVersionMax(int i) {
        this.b = i;
    }

    public final void setVersionMin(int i) {
        this.a = i;
    }

    public final void setYandexReportsEnabled(boolean z) {
        this.e = z;
    }

    @NotNull
    public String toString() {
        StringBuilder Q = a.Q("AppConfig(", "versionMin=");
        Q.append(this.a);
        Q.append(", ");
        Q.append("versionMax=");
        Q.append(this.b);
        Q.append(", ");
        Q.append("platformVersion=");
        Q.append(this.c);
        Q.append(", ");
        Q.append("geoReportTimeout=");
        Q.append(this.d);
        Q.append(", ");
        Q.append("isYandexReportsEnabled=");
        return a.A(Q, this.e, ')');
    }

    public int validateVersion(int i, int i2) {
        if (i >= this.b) {
            return 0;
        }
        int i3 = this.a;
        boolean z = i < i3;
        boolean z2 = i >= i3;
        if (i2 >= this.c) {
            if (z) {
                return 2;
            }
            if (z2) {
                return 1;
            }
        } else if (z) {
            return 4;
        } else {
            if (z2) {
                return 3;
            }
        }
        return 0;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AppConfig(int i, int i2, int i3, long j, boolean z, int i4, j jVar) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3, (i4 & 8) != 0 ? 0 : j, (i4 & 16) != 0 ? false : z);
    }
}
