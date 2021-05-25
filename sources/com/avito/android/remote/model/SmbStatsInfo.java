package com.avito.android.remote.model;

import a2.b.a.a.a;
import com.avito.android.deep_linking.links.DeepLink;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u000b\u001a\u00020\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\bR\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/avito/android/remote/model/SmbStatsInfo;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/deep_linking/links/DeepLink;", "component3", "()Lcom/avito/android/deep_linking/links/DeepLink;", "title", MessengerShareContentUtility.SUBTITLE, "deeplink", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/remote/model/SmbStatsInfo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", "Ljava/lang/String;", "getTitle", "getSubtitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class SmbStatsInfo {
    @SerializedName("deeplink")
    @NotNull
    private final DeepLink deeplink;
    @SerializedName(MessengerShareContentUtility.SUBTITLE)
    @NotNull
    private final String subtitle;
    @SerializedName("title")
    @NotNull
    private final String title;

    public SmbStatsInfo(@NotNull String str, @NotNull String str2, @NotNull DeepLink deepLink) {
        a.W0(str, "title", str2, MessengerShareContentUtility.SUBTITLE, deepLink, "deeplink");
        this.title = str;
        this.subtitle = str2;
        this.deeplink = deepLink;
    }

    public static /* synthetic */ SmbStatsInfo copy$default(SmbStatsInfo smbStatsInfo, String str, String str2, DeepLink deepLink, int i, Object obj) {
        if ((i & 1) != 0) {
            str = smbStatsInfo.title;
        }
        if ((i & 2) != 0) {
            str2 = smbStatsInfo.subtitle;
        }
        if ((i & 4) != 0) {
            deepLink = smbStatsInfo.deeplink;
        }
        return smbStatsInfo.copy(str, str2, deepLink);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.subtitle;
    }

    @NotNull
    public final DeepLink component3() {
        return this.deeplink;
    }

    @NotNull
    public final SmbStatsInfo copy(@NotNull String str, @NotNull String str2, @NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, MessengerShareContentUtility.SUBTITLE);
        Intrinsics.checkNotNullParameter(deepLink, "deeplink");
        return new SmbStatsInfo(str, str2, deepLink);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SmbStatsInfo)) {
            return false;
        }
        SmbStatsInfo smbStatsInfo = (SmbStatsInfo) obj;
        return Intrinsics.areEqual(this.title, smbStatsInfo.title) && Intrinsics.areEqual(this.subtitle, smbStatsInfo.subtitle) && Intrinsics.areEqual(this.deeplink, smbStatsInfo.deeplink);
    }

    @NotNull
    public final DeepLink getDeeplink() {
        return this.deeplink;
    }

    @NotNull
    public final String getSubtitle() {
        return this.subtitle;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.subtitle;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        DeepLink deepLink = this.deeplink;
        if (deepLink != null) {
            i = deepLink.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SmbStatsInfo(title=");
        L.append(this.title);
        L.append(", subtitle=");
        L.append(this.subtitle);
        L.append(", deeplink=");
        return a.m(L, this.deeplink, ")");
    }
}
