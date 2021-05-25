package com.sumsub.sns.core.common;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.messaging.Constants;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\n\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u000f¢\u0006\u0004\b6\u00107J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J`\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u000fHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0011J\u001a\u0010 \u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\"\u0010\u0011J \u0010'\u001a\u00020&2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b'\u0010(R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010)\u001a\u0004\b*\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010)\u001a\u0004\b+\u0010\u0004R\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010)\u001a\u0004\b,\u0010\u0004\"\u0004\b-\u0010.R\u0019\u0010\u0018\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010)\u001a\u0004\b/\u0010\u0004R\u0019\u0010\u0019\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u00100\u001a\u0004\b1\u0010\u0011R\u0019\u0010\u0015\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u00102\u001a\u0004\b3\u0010\tR\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010)\u001a\u0004\b4\u0010\u0004R\u0019\u0010\u0016\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u00105\u001a\u0004\b\u0016\u0010\f¨\u00068"}, d2 = {"Lcom/sumsub/sns/core/common/SNSSession;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "Ljava/util/Locale;", "component4", "()Ljava/util/Locale;", "", "component5", "()Z", "component6", "component7", "", "component8", "()I", "url", "flowName", SDKConstants.PARAM_ACCESS_TOKEN, "locale", "isDebug", Constants.FirelogAnalytics.PARAM_PACKAGE_NAME, "versionName", "versionCode", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Locale;ZLjava/lang/String;Ljava/lang/String;I)Lcom/sumsub/sns/core/common/SNSSession;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getFlowName", "getUrl", "getAccessToken", "setAccessToken", "(Ljava/lang/String;)V", "getVersionName", "I", "getVersionCode", "Ljava/util/Locale;", "getLocale", "getPackageName", "Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Locale;ZLjava/lang/String;Ljava/lang/String;I)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class SNSSession implements Parcelable {
    public static final Parcelable.Creator<SNSSession> CREATOR = new Creator();
    @NotNull
    private String accessToken;
    @NotNull
    private final String flowName;
    private final boolean isDebug;
    @NotNull
    private final Locale locale;
    @NotNull
    private final String packageName;
    @NotNull
    private final String url;
    private final int versionCode;
    @NotNull
    private final String versionName;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SNSSession> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SNSSession createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SNSSession(parcel.readString(), parcel.readString(), parcel.readString(), (Locale) parcel.readSerializable(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SNSSession[] newArray(int i) {
            return new SNSSession[i];
        }
    }

    public SNSSession(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Locale locale2, boolean z, @NotNull String str4, @NotNull String str5, int i) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "flowName");
        Intrinsics.checkNotNullParameter(str3, SDKConstants.PARAM_ACCESS_TOKEN);
        Intrinsics.checkNotNullParameter(locale2, "locale");
        Intrinsics.checkNotNullParameter(str4, Constants.FirelogAnalytics.PARAM_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(str5, "versionName");
        this.url = str;
        this.flowName = str2;
        this.accessToken = str3;
        this.locale = locale2;
        this.isDebug = z;
        this.packageName = str4;
        this.versionName = str5;
        this.versionCode = i;
    }

    public static /* synthetic */ SNSSession copy$default(SNSSession sNSSession, String str, String str2, String str3, Locale locale2, boolean z, String str4, String str5, int i, int i2, Object obj) {
        return sNSSession.copy((i2 & 1) != 0 ? sNSSession.url : str, (i2 & 2) != 0 ? sNSSession.flowName : str2, (i2 & 4) != 0 ? sNSSession.accessToken : str3, (i2 & 8) != 0 ? sNSSession.locale : locale2, (i2 & 16) != 0 ? sNSSession.isDebug : z, (i2 & 32) != 0 ? sNSSession.packageName : str4, (i2 & 64) != 0 ? sNSSession.versionName : str5, (i2 & 128) != 0 ? sNSSession.versionCode : i);
    }

    @NotNull
    public final String component1() {
        return this.url;
    }

    @NotNull
    public final String component2() {
        return this.flowName;
    }

    @NotNull
    public final String component3() {
        return this.accessToken;
    }

    @NotNull
    public final Locale component4() {
        return this.locale;
    }

    public final boolean component5() {
        return this.isDebug;
    }

    @NotNull
    public final String component6() {
        return this.packageName;
    }

    @NotNull
    public final String component7() {
        return this.versionName;
    }

    public final int component8() {
        return this.versionCode;
    }

    @NotNull
    public final SNSSession copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Locale locale2, boolean z, @NotNull String str4, @NotNull String str5, int i) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "flowName");
        Intrinsics.checkNotNullParameter(str3, SDKConstants.PARAM_ACCESS_TOKEN);
        Intrinsics.checkNotNullParameter(locale2, "locale");
        Intrinsics.checkNotNullParameter(str4, Constants.FirelogAnalytics.PARAM_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(str5, "versionName");
        return new SNSSession(str, str2, str3, locale2, z, str4, str5, i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SNSSession)) {
            return false;
        }
        SNSSession sNSSession = (SNSSession) obj;
        return Intrinsics.areEqual(this.url, sNSSession.url) && Intrinsics.areEqual(this.flowName, sNSSession.flowName) && Intrinsics.areEqual(this.accessToken, sNSSession.accessToken) && Intrinsics.areEqual(this.locale, sNSSession.locale) && this.isDebug == sNSSession.isDebug && Intrinsics.areEqual(this.packageName, sNSSession.packageName) && Intrinsics.areEqual(this.versionName, sNSSession.versionName) && this.versionCode == sNSSession.versionCode;
    }

    @NotNull
    public final String getAccessToken() {
        return this.accessToken;
    }

    @NotNull
    public final String getFlowName() {
        return this.flowName;
    }

    @NotNull
    public final Locale getLocale() {
        return this.locale;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    @NotNull
    public final String getVersionName() {
        return this.versionName;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.url;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.flowName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.accessToken;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Locale locale2 = this.locale;
        int hashCode4 = (hashCode3 + (locale2 != null ? locale2.hashCode() : 0)) * 31;
        boolean z = this.isDebug;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode4 + i2) * 31;
        String str4 = this.packageName;
        int hashCode5 = (i5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.versionName;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return ((hashCode5 + i) * 31) + this.versionCode;
    }

    public final boolean isDebug() {
        return this.isDebug;
    }

    public final void setAccessToken(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.accessToken = str;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("SNSSession(url=");
        L.append(this.url);
        L.append(", flowName=");
        L.append(this.flowName);
        L.append(", accessToken=");
        L.append(this.accessToken);
        L.append(", locale=");
        L.append(this.locale);
        L.append(", isDebug=");
        L.append(this.isDebug);
        L.append(", packageName=");
        L.append(this.packageName);
        L.append(", versionName=");
        L.append(this.versionName);
        L.append(", versionCode=");
        return a.j(L, this.versionCode, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.url);
        parcel.writeString(this.flowName);
        parcel.writeString(this.accessToken);
        parcel.writeSerializable(this.locale);
        parcel.writeInt(this.isDebug ? 1 : 0);
        parcel.writeString(this.packageName);
        parcel.writeString(this.versionName);
        parcel.writeInt(this.versionCode);
    }
}
