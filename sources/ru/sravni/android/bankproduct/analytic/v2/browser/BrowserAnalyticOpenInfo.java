package ru.sravni.android.bankproduct.analytic.v2.browser;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJJ\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\tR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001d\u001a\u0004\b \u0010\u0004R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u0004R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u001a\u001a\u0004\b$\u0010\t¨\u0006'"}, d2 = {"Lru/sravni/android/bankproduct/analytic/v2/browser/BrowserAnalyticOpenInfo;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()Ljava/lang/Boolean;", "component5", AnalyticFieldsName.productName, AnalyticFieldsName.organizationName, AnalyticFieldsName.orderId, AnalyticFieldsName.route, "push", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lru/sravni/android/bankproduct/analytic/v2/browser/BrowserAnalyticOpenInfo;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "d", "Ljava/lang/Boolean;", "getRoute", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getProductName", "c", "getOrderId", AuthSource.BOOKING_ORDER, "getOrganizationName", "e", "getPush", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class BrowserAnalyticOpenInfo {
    @NotNull
    public final String a;
    @Nullable
    public final String b;
    @Nullable
    public final String c;
    @Nullable
    public final Boolean d;
    @Nullable
    public final Boolean e;

    public BrowserAnalyticOpenInfo(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable Boolean bool, @Nullable Boolean bool2) {
        Intrinsics.checkParameterIsNotNull(str, AnalyticFieldsName.productName);
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = bool;
        this.e = bool2;
    }

    public static /* synthetic */ BrowserAnalyticOpenInfo copy$default(BrowserAnalyticOpenInfo browserAnalyticOpenInfo, String str, String str2, String str3, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = browserAnalyticOpenInfo.a;
        }
        if ((i & 2) != 0) {
            str2 = browserAnalyticOpenInfo.b;
        }
        if ((i & 4) != 0) {
            str3 = browserAnalyticOpenInfo.c;
        }
        if ((i & 8) != 0) {
            bool = browserAnalyticOpenInfo.d;
        }
        if ((i & 16) != 0) {
            bool2 = browserAnalyticOpenInfo.e;
        }
        return browserAnalyticOpenInfo.copy(str, str2, str3, bool, bool2);
    }

    @NotNull
    public final String component1() {
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

    @Nullable
    public final Boolean component4() {
        return this.d;
    }

    @Nullable
    public final Boolean component5() {
        return this.e;
    }

    @NotNull
    public final BrowserAnalyticOpenInfo copy(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable Boolean bool, @Nullable Boolean bool2) {
        Intrinsics.checkParameterIsNotNull(str, AnalyticFieldsName.productName);
        return new BrowserAnalyticOpenInfo(str, str2, str3, bool, bool2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BrowserAnalyticOpenInfo)) {
            return false;
        }
        BrowserAnalyticOpenInfo browserAnalyticOpenInfo = (BrowserAnalyticOpenInfo) obj;
        return Intrinsics.areEqual(this.a, browserAnalyticOpenInfo.a) && Intrinsics.areEqual(this.b, browserAnalyticOpenInfo.b) && Intrinsics.areEqual(this.c, browserAnalyticOpenInfo.c) && Intrinsics.areEqual(this.d, browserAnalyticOpenInfo.d) && Intrinsics.areEqual(this.e, browserAnalyticOpenInfo.e);
    }

    @Nullable
    public final String getOrderId() {
        return this.c;
    }

    @Nullable
    public final String getOrganizationName() {
        return this.b;
    }

    @NotNull
    public final String getProductName() {
        return this.a;
    }

    @Nullable
    public final Boolean getPush() {
        return this.e;
    }

    @Nullable
    public final Boolean getRoute() {
        return this.d;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Boolean bool = this.d;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.e;
        if (bool2 != null) {
            i = bool2.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("BrowserAnalyticOpenInfo(productName=");
        L.append(this.a);
        L.append(", organizationName=");
        L.append(this.b);
        L.append(", orderId=");
        L.append(this.c);
        L.append(", route=");
        L.append(this.d);
        L.append(", push=");
        return a.o(L, this.e, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BrowserAnalyticOpenInfo(String str, String str2, String str3, Boolean bool, Boolean bool2, int i, j jVar) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : bool2);
    }
}
