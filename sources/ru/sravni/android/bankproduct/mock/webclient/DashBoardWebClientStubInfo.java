package ru.sravni.android.bankproduct.mock.webclient;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u0019"}, d2 = {"Lru/sravni/android/bankproduct/mock/webclient/DashBoardWebClientStubInfo;", "", "", "component1", "()Ljava/lang/String;", "component2", "progressPath", "calculationListPath", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/mock/webclient/DashBoardWebClientStubInfo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getCalculationListPath", AuthSource.SEND_ABUSE, "getProgressPath", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class DashBoardWebClientStubInfo {
    @NotNull
    public final String a;
    @NotNull
    public final String b;

    public DashBoardWebClientStubInfo() {
        this(null, null, 3, null);
    }

    public DashBoardWebClientStubInfo(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "progressPath");
        Intrinsics.checkParameterIsNotNull(str2, "calculationListPath");
        this.a = str;
        this.b = str2;
    }

    public static /* synthetic */ DashBoardWebClientStubInfo copy$default(DashBoardWebClientStubInfo dashBoardWebClientStubInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dashBoardWebClientStubInfo.a;
        }
        if ((i & 2) != 0) {
            str2 = dashBoardWebClientStubInfo.b;
        }
        return dashBoardWebClientStubInfo.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final DashBoardWebClientStubInfo copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "progressPath");
        Intrinsics.checkParameterIsNotNull(str2, "calculationListPath");
        return new DashBoardWebClientStubInfo(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DashBoardWebClientStubInfo)) {
            return false;
        }
        DashBoardWebClientStubInfo dashBoardWebClientStubInfo = (DashBoardWebClientStubInfo) obj;
        return Intrinsics.areEqual(this.a, dashBoardWebClientStubInfo.a) && Intrinsics.areEqual(this.b, dashBoardWebClientStubInfo.b);
    }

    @NotNull
    public final String getCalculationListPath() {
        return this.b;
    }

    @NotNull
    public final String getProgressPath() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("DashBoardWebClientStubInfo(progressPath=");
        L.append(this.a);
        L.append(", calculationListPath=");
        return a.t(L, this.b, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DashBoardWebClientStubInfo(String str, String str2, int i, j jVar) {
        this((i & 1) != 0 ? "mock/dashboard/Progress.json" : str, (i & 2) != 0 ? "mock/dashboard/CalculationList.json" : str2);
    }
}
