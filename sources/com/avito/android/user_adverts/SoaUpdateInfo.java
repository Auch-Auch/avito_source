package com.avito.android.user_adverts;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J2\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u001a\u0010\u0007R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004¨\u0006 "}, d2 = {"Lcom/avito/android/user_adverts/SoaUpdateInfo;", "", "Lcom/avito/android/user_adverts/SoaProgressState;", "component1", "()Lcom/avito/android/user_adverts/SoaProgressState;", "", "component2", "()Ljava/lang/String;", "component3", "progressState", "updateText", "soaAdvertId", "copy", "(Lcom/avito/android/user_adverts/SoaProgressState;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/user_adverts/SoaUpdateInfo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getUpdateText", "c", "getSoaAdvertId", AuthSource.SEND_ABUSE, "Lcom/avito/android/user_adverts/SoaProgressState;", "getProgressState", "<init>", "(Lcom/avito/android/user_adverts/SoaProgressState;Ljava/lang/String;Ljava/lang/String;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class SoaUpdateInfo {
    @NotNull
    public final SoaProgressState a;
    @Nullable
    public final String b;
    @Nullable
    public final String c;

    public SoaUpdateInfo(@NotNull SoaProgressState soaProgressState, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(soaProgressState, "progressState");
        this.a = soaProgressState;
        this.b = str;
        this.c = str2;
    }

    public static /* synthetic */ SoaUpdateInfo copy$default(SoaUpdateInfo soaUpdateInfo, SoaProgressState soaProgressState, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            soaProgressState = soaUpdateInfo.a;
        }
        if ((i & 2) != 0) {
            str = soaUpdateInfo.b;
        }
        if ((i & 4) != 0) {
            str2 = soaUpdateInfo.c;
        }
        return soaUpdateInfo.copy(soaProgressState, str, str2);
    }

    @NotNull
    public final SoaProgressState component1() {
        return this.a;
    }

    @Nullable
    public final String component2() {
        return this.b;
    }

    @Nullable
    public final String component3() {
        return this.c;
    }

    @NotNull
    public final SoaUpdateInfo copy(@NotNull SoaProgressState soaProgressState, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(soaProgressState, "progressState");
        return new SoaUpdateInfo(soaProgressState, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SoaUpdateInfo)) {
            return false;
        }
        SoaUpdateInfo soaUpdateInfo = (SoaUpdateInfo) obj;
        return Intrinsics.areEqual(this.a, soaUpdateInfo.a) && Intrinsics.areEqual(this.b, soaUpdateInfo.b) && Intrinsics.areEqual(this.c, soaUpdateInfo.c);
    }

    @NotNull
    public final SoaProgressState getProgressState() {
        return this.a;
    }

    @Nullable
    public final String getSoaAdvertId() {
        return this.c;
    }

    @Nullable
    public final String getUpdateText() {
        return this.b;
    }

    public int hashCode() {
        SoaProgressState soaProgressState = this.a;
        int i = 0;
        int hashCode = (soaProgressState != null ? soaProgressState.hashCode() : 0) * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.c;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SoaUpdateInfo(progressState=");
        L.append(this.a);
        L.append(", updateText=");
        L.append(this.b);
        L.append(", soaAdvertId=");
        return a.t(L, this.c, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SoaUpdateInfo(SoaProgressState soaProgressState, String str, String str2, int i, j jVar) {
        this(soaProgressState, str, (i & 4) != 0 ? null : str2);
    }
}
