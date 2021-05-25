package com.avito.android.remote.model;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\b\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/avito/android/remote/model/ProfileItemsConfig;", "", "", "component1", "()Z", "Lcom/avito/android/remote/model/SmbStatsInfo;", "component2", "()Lcom/avito/android/remote/model/SmbStatsInfo;", "isSearchAvailable", "smbStats", "copy", "(ZLcom/avito/android/remote/model/SmbStatsInfo;)Lcom/avito/android/remote/model/ProfileItemsConfig;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/remote/model/SmbStatsInfo;", "getSmbStats", "Z", "<init>", "(ZLcom/avito/android/remote/model/SmbStatsInfo;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileItemsConfig {
    @SerializedName("isSearchAvailable")
    private final boolean isSearchAvailable;
    @SerializedName("smbStats")
    @Nullable
    private final SmbStatsInfo smbStats;

    public ProfileItemsConfig(boolean z, @Nullable SmbStatsInfo smbStatsInfo) {
        this.isSearchAvailable = z;
        this.smbStats = smbStatsInfo;
    }

    public static /* synthetic */ ProfileItemsConfig copy$default(ProfileItemsConfig profileItemsConfig, boolean z, SmbStatsInfo smbStatsInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            z = profileItemsConfig.isSearchAvailable;
        }
        if ((i & 2) != 0) {
            smbStatsInfo = profileItemsConfig.smbStats;
        }
        return profileItemsConfig.copy(z, smbStatsInfo);
    }

    public final boolean component1() {
        return this.isSearchAvailable;
    }

    @Nullable
    public final SmbStatsInfo component2() {
        return this.smbStats;
    }

    @NotNull
    public final ProfileItemsConfig copy(boolean z, @Nullable SmbStatsInfo smbStatsInfo) {
        return new ProfileItemsConfig(z, smbStatsInfo);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileItemsConfig)) {
            return false;
        }
        ProfileItemsConfig profileItemsConfig = (ProfileItemsConfig) obj;
        return this.isSearchAvailable == profileItemsConfig.isSearchAvailable && Intrinsics.areEqual(this.smbStats, profileItemsConfig.smbStats);
    }

    @Nullable
    public final SmbStatsInfo getSmbStats() {
        return this.smbStats;
    }

    public int hashCode() {
        boolean z = this.isSearchAvailable;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = i * 31;
        SmbStatsInfo smbStatsInfo = this.smbStats;
        return i4 + (smbStatsInfo != null ? smbStatsInfo.hashCode() : 0);
    }

    public final boolean isSearchAvailable() {
        return this.isSearchAvailable;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ProfileItemsConfig(isSearchAvailable=");
        L.append(this.isSearchAvailable);
        L.append(", smbStats=");
        L.append(this.smbStats);
        L.append(")");
        return L.toString();
    }
}
