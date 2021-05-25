package ru.sravni.android.bankproduct.domain;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b+\b\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\b¢\u0006\u0004\b1\u00102J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\f\u0010\nJ\u0010\u0010\r\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\r\u0010\nJ\u0010\u0010\u000e\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\nJ\u0010\u0010\u000f\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\nJ`\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001a\u0010\nJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0004J\u001a\u0010\u001d\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0004R\u0019\u0010\u0014\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\nR\u0019\u0010\u0012\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010#\u001a\u0004\b&\u0010\nR\u0019\u0010\u0016\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010#\u001a\u0004\b(\u0010\nR\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b\u0011\u0010\u0007R\u0019\u0010\u0013\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010#\u001a\u0004\b,\u0010\nR\u0019\u0010\u0017\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010#\u001a\u0004\b.\u0010\nR\u0019\u0010\u0015\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010#\u001a\u0004\b0\u0010\n¨\u00063"}, d2 = {"Lru/sravni/android/bankproduct/domain/AppBuildInfo;", "", "", "component1", "()I", "", "component2", "()Z", "", "component3", "()Ljava/lang/String;", "component4", "component5", "component6", "component7", "component8", "codeVersion", "isDebug", "appVersion", "buildType", "buildFlavour", "osVersion", "deviceModel", "authClientAgent", "copy", "(IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/domain/AppBuildInfo;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "I", "getCodeVersion", "e", "Ljava/lang/String;", "getBuildFlavour", "c", "getAppVersion", g.a, "getDeviceModel", AuthSource.BOOKING_ORDER, "Z", "d", "getBuildType", "h", "getAuthClientAgent", "f", "getOsVersion", "<init>", "(IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class AppBuildInfo {
    public final int a;
    public final boolean b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @NotNull
    public final String e;
    @NotNull
    public final String f;
    @NotNull
    public final String g;
    @NotNull
    public final String h;

    public AppBuildInfo(int i, boolean z, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkParameterIsNotNull(str, "appVersion");
        Intrinsics.checkParameterIsNotNull(str2, "buildType");
        Intrinsics.checkParameterIsNotNull(str3, "buildFlavour");
        Intrinsics.checkParameterIsNotNull(str4, "osVersion");
        Intrinsics.checkParameterIsNotNull(str5, "deviceModel");
        Intrinsics.checkParameterIsNotNull(str6, "authClientAgent");
        this.a = i;
        this.b = z;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.h = str6;
    }

    public static /* synthetic */ AppBuildInfo copy$default(AppBuildInfo appBuildInfo, int i, boolean z, String str, String str2, String str3, String str4, String str5, String str6, int i2, Object obj) {
        return appBuildInfo.copy((i2 & 1) != 0 ? appBuildInfo.a : i, (i2 & 2) != 0 ? appBuildInfo.b : z, (i2 & 4) != 0 ? appBuildInfo.c : str, (i2 & 8) != 0 ? appBuildInfo.d : str2, (i2 & 16) != 0 ? appBuildInfo.e : str3, (i2 & 32) != 0 ? appBuildInfo.f : str4, (i2 & 64) != 0 ? appBuildInfo.g : str5, (i2 & 128) != 0 ? appBuildInfo.h : str6);
    }

    public final int component1() {
        return this.a;
    }

    public final boolean component2() {
        return this.b;
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    @NotNull
    public final String component4() {
        return this.d;
    }

    @NotNull
    public final String component5() {
        return this.e;
    }

    @NotNull
    public final String component6() {
        return this.f;
    }

    @NotNull
    public final String component7() {
        return this.g;
    }

    @NotNull
    public final String component8() {
        return this.h;
    }

    @NotNull
    public final AppBuildInfo copy(int i, boolean z, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkParameterIsNotNull(str, "appVersion");
        Intrinsics.checkParameterIsNotNull(str2, "buildType");
        Intrinsics.checkParameterIsNotNull(str3, "buildFlavour");
        Intrinsics.checkParameterIsNotNull(str4, "osVersion");
        Intrinsics.checkParameterIsNotNull(str5, "deviceModel");
        Intrinsics.checkParameterIsNotNull(str6, "authClientAgent");
        return new AppBuildInfo(i, z, str, str2, str3, str4, str5, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppBuildInfo)) {
            return false;
        }
        AppBuildInfo appBuildInfo = (AppBuildInfo) obj;
        return this.a == appBuildInfo.a && this.b == appBuildInfo.b && Intrinsics.areEqual(this.c, appBuildInfo.c) && Intrinsics.areEqual(this.d, appBuildInfo.d) && Intrinsics.areEqual(this.e, appBuildInfo.e) && Intrinsics.areEqual(this.f, appBuildInfo.f) && Intrinsics.areEqual(this.g, appBuildInfo.g) && Intrinsics.areEqual(this.h, appBuildInfo.h);
    }

    @NotNull
    public final String getAppVersion() {
        return this.c;
    }

    @NotNull
    public final String getAuthClientAgent() {
        return this.h;
    }

    @NotNull
    public final String getBuildFlavour() {
        return this.e;
    }

    @NotNull
    public final String getBuildType() {
        return this.d;
    }

    public final int getCodeVersion() {
        return this.a;
    }

    @NotNull
    public final String getDeviceModel() {
        return this.g;
    }

    @NotNull
    public final String getOsVersion() {
        return this.f;
    }

    public int hashCode() {
        int i = this.a * 31;
        boolean z = this.b;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (i + i2) * 31;
        String str = this.c;
        int i6 = 0;
        int hashCode = (i5 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.d;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.e;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.g;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.h;
        if (str6 != null) {
            i6 = str6.hashCode();
        }
        return hashCode5 + i6;
    }

    public final boolean isDebug() {
        return this.b;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("AppBuildInfo(codeVersion=");
        L.append(this.a);
        L.append(", isDebug=");
        L.append(this.b);
        L.append(", appVersion=");
        L.append(this.c);
        L.append(", buildType=");
        L.append(this.d);
        L.append(", buildFlavour=");
        L.append(this.e);
        L.append(", osVersion=");
        L.append(this.f);
        L.append(", deviceModel=");
        L.append(this.g);
        L.append(", authClientAgent=");
        return a.t(L, this.h, ")");
    }
}
