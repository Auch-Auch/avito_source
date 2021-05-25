package com.avito.android.remote.model.ab_tests;

import a2.b.a.a.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0014\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/avito/android/remote/model/ab_tests/AnalyticsParams;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "abToken", "clientExposure", "copy", "(Ljava/lang/String;Z)Lcom/avito/android/remote/model/ab_tests/AnalyticsParams;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getClientExposure", "Ljava/lang/String;", "getAbToken", "<init>", "(Ljava/lang/String;Z)V", "config_release"}, k = 1, mv = {1, 4, 2})
public final class AnalyticsParams {
    @NotNull
    private final String abToken;
    private final boolean clientExposure;

    public AnalyticsParams(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "abToken");
        this.abToken = str;
        this.clientExposure = z;
    }

    public static /* synthetic */ AnalyticsParams copy$default(AnalyticsParams analyticsParams, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = analyticsParams.abToken;
        }
        if ((i & 2) != 0) {
            z = analyticsParams.clientExposure;
        }
        return analyticsParams.copy(str, z);
    }

    @NotNull
    public final String component1() {
        return this.abToken;
    }

    public final boolean component2() {
        return this.clientExposure;
    }

    @NotNull
    public final AnalyticsParams copy(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "abToken");
        return new AnalyticsParams(str, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnalyticsParams)) {
            return false;
        }
        AnalyticsParams analyticsParams = (AnalyticsParams) obj;
        return Intrinsics.areEqual(this.abToken, analyticsParams.abToken) && this.clientExposure == analyticsParams.clientExposure;
    }

    @NotNull
    public final String getAbToken() {
        return this.abToken;
    }

    public final boolean getClientExposure() {
        return this.clientExposure;
    }

    public int hashCode() {
        String str = this.abToken;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.clientExposure;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("AnalyticsParams(abToken=");
        L.append(this.abToken);
        L.append(", clientExposure=");
        return a.B(L, this.clientExposure, ")");
    }
}
