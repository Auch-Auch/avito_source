package ru.sravni.android.bankproduct.mock.webclient;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004JB\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0019\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u0004R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010\u0004¨\u0006%"}, d2 = {"Lru/sravni/android/bankproduct/mock/webclient/ProfileWebClientStubInfo;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "legacyAccountPath", BaseAnalyticKt.ANALYTIC_MODULE_ACCOUNT, "accountDetail", "documentPrefix", "documentPostfix", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/mock/webclient/ProfileWebClientStubInfo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/String;", "getAccountDetail", "e", "getDocumentPostfix", AuthSource.BOOKING_ORDER, "getAccount", AuthSource.SEND_ABUSE, "getLegacyAccountPath", "d", "getDocumentPrefix", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ProfileWebClientStubInfo {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @NotNull
    public final String e;

    public ProfileWebClientStubInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public ProfileWebClientStubInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkParameterIsNotNull(str, "legacyAccountPath");
        Intrinsics.checkParameterIsNotNull(str2, BaseAnalyticKt.ANALYTIC_MODULE_ACCOUNT);
        Intrinsics.checkParameterIsNotNull(str3, "accountDetail");
        Intrinsics.checkParameterIsNotNull(str4, "documentPrefix");
        Intrinsics.checkParameterIsNotNull(str5, "documentPostfix");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
    }

    public static /* synthetic */ ProfileWebClientStubInfo copy$default(ProfileWebClientStubInfo profileWebClientStubInfo, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = profileWebClientStubInfo.a;
        }
        if ((i & 2) != 0) {
            str2 = profileWebClientStubInfo.b;
        }
        if ((i & 4) != 0) {
            str3 = profileWebClientStubInfo.c;
        }
        if ((i & 8) != 0) {
            str4 = profileWebClientStubInfo.d;
        }
        if ((i & 16) != 0) {
            str5 = profileWebClientStubInfo.e;
        }
        return profileWebClientStubInfo.copy(str, str2, str3, str4, str5);
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
    public final ProfileWebClientStubInfo copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkParameterIsNotNull(str, "legacyAccountPath");
        Intrinsics.checkParameterIsNotNull(str2, BaseAnalyticKt.ANALYTIC_MODULE_ACCOUNT);
        Intrinsics.checkParameterIsNotNull(str3, "accountDetail");
        Intrinsics.checkParameterIsNotNull(str4, "documentPrefix");
        Intrinsics.checkParameterIsNotNull(str5, "documentPostfix");
        return new ProfileWebClientStubInfo(str, str2, str3, str4, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileWebClientStubInfo)) {
            return false;
        }
        ProfileWebClientStubInfo profileWebClientStubInfo = (ProfileWebClientStubInfo) obj;
        return Intrinsics.areEqual(this.a, profileWebClientStubInfo.a) && Intrinsics.areEqual(this.b, profileWebClientStubInfo.b) && Intrinsics.areEqual(this.c, profileWebClientStubInfo.c) && Intrinsics.areEqual(this.d, profileWebClientStubInfo.d) && Intrinsics.areEqual(this.e, profileWebClientStubInfo.e);
    }

    @NotNull
    public final String getAccount() {
        return this.b;
    }

    @NotNull
    public final String getAccountDetail() {
        return this.c;
    }

    @NotNull
    public final String getDocumentPostfix() {
        return this.e;
    }

    @NotNull
    public final String getDocumentPrefix() {
        return this.d;
    }

    @NotNull
    public final String getLegacyAccountPath() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.e;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ProfileWebClientStubInfo(legacyAccountPath=");
        L.append(this.a);
        L.append(", account=");
        L.append(this.b);
        L.append(", accountDetail=");
        L.append(this.c);
        L.append(", documentPrefix=");
        L.append(this.d);
        L.append(", documentPostfix=");
        return a.t(L, this.e, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProfileWebClientStubInfo(String str, String str2, String str3, String str4, String str5, int i, j jVar) {
        this((i & 1) != 0 ? "mock/profile/legacy/Account.json" : str, (i & 2) != 0 ? "mock/profile/Account.json" : str2, (i & 4) != 0 ? "mock/profile/AccountDetail.json" : str3, (i & 8) != 0 ? "mock/profile/" : str4, (i & 16) != 0 ? ".json" : str5);
    }
}
