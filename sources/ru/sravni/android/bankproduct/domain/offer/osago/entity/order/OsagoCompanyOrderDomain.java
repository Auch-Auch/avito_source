package ru.sravni.android.bankproduct.domain.offer.osago.entity.order;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.model.VKApiUserFull;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0017\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b2\u00103J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\\\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\b2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0007J\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0004J\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\rR\u0019\u0010\u0012\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0007R\u0019\u0010\u0013\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\nR\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u0004R\u0019\u0010\u0015\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010$\u001a\u0004\b-\u0010\u0007R\u0019\u0010\u0016\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010$\u001a\u0004\b/\u0010\u0007R\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010*\u001a\u0004\b1\u0010\u0004¨\u00064"}, d2 = {"Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyOrderDomain;", "", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "", "component3", "()J", "", "component4", "()Ljava/util/List;", "component5", "component6", "component7", "backgroundColor", "pollingID", "pollingInterval", VKApiUserFull.QUOTES, "title", "iconText", "titleColor", "copy", "(ILjava/lang/String;JLjava/util/List;Ljava/lang/String;Ljava/lang/String;I)Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyOrderDomain;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "d", "Ljava/util/List;", "getQuotes", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getPollingID", "c", "J", "getPollingInterval", AuthSource.SEND_ABUSE, "I", "getBackgroundColor", "e", "getTitle", "f", "getIconText", g.a, "getTitleColor", "<init>", "(ILjava/lang/String;JLjava/util/List;Ljava/lang/String;Ljava/lang/String;I)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OsagoCompanyOrderDomain {
    public final int a;
    @NotNull
    public final String b;
    public final long c;
    @NotNull
    public final List<String> d;
    @NotNull
    public final String e;
    @NotNull
    public final String f;
    public final int g;

    public OsagoCompanyOrderDomain(int i, @NotNull String str, long j, @NotNull List<String> list, @NotNull String str2, @NotNull String str3, int i2) {
        Intrinsics.checkParameterIsNotNull(str, "pollingID");
        Intrinsics.checkParameterIsNotNull(list, VKApiUserFull.QUOTES);
        Intrinsics.checkParameterIsNotNull(str2, "title");
        Intrinsics.checkParameterIsNotNull(str3, "iconText");
        this.a = i;
        this.b = str;
        this.c = j;
        this.d = list;
        this.e = str2;
        this.f = str3;
        this.g = i2;
    }

    public static /* synthetic */ OsagoCompanyOrderDomain copy$default(OsagoCompanyOrderDomain osagoCompanyOrderDomain, int i, String str, long j, List list, String str2, String str3, int i2, int i3, Object obj) {
        return osagoCompanyOrderDomain.copy((i3 & 1) != 0 ? osagoCompanyOrderDomain.a : i, (i3 & 2) != 0 ? osagoCompanyOrderDomain.b : str, (i3 & 4) != 0 ? osagoCompanyOrderDomain.c : j, (i3 & 8) != 0 ? osagoCompanyOrderDomain.d : list, (i3 & 16) != 0 ? osagoCompanyOrderDomain.e : str2, (i3 & 32) != 0 ? osagoCompanyOrderDomain.f : str3, (i3 & 64) != 0 ? osagoCompanyOrderDomain.g : i2);
    }

    public final int component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    public final long component3() {
        return this.c;
    }

    @NotNull
    public final List<String> component4() {
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

    public final int component7() {
        return this.g;
    }

    @NotNull
    public final OsagoCompanyOrderDomain copy(int i, @NotNull String str, long j, @NotNull List<String> list, @NotNull String str2, @NotNull String str3, int i2) {
        Intrinsics.checkParameterIsNotNull(str, "pollingID");
        Intrinsics.checkParameterIsNotNull(list, VKApiUserFull.QUOTES);
        Intrinsics.checkParameterIsNotNull(str2, "title");
        Intrinsics.checkParameterIsNotNull(str3, "iconText");
        return new OsagoCompanyOrderDomain(i, str, j, list, str2, str3, i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OsagoCompanyOrderDomain)) {
            return false;
        }
        OsagoCompanyOrderDomain osagoCompanyOrderDomain = (OsagoCompanyOrderDomain) obj;
        return this.a == osagoCompanyOrderDomain.a && Intrinsics.areEqual(this.b, osagoCompanyOrderDomain.b) && this.c == osagoCompanyOrderDomain.c && Intrinsics.areEqual(this.d, osagoCompanyOrderDomain.d) && Intrinsics.areEqual(this.e, osagoCompanyOrderDomain.e) && Intrinsics.areEqual(this.f, osagoCompanyOrderDomain.f) && this.g == osagoCompanyOrderDomain.g;
    }

    public final int getBackgroundColor() {
        return this.a;
    }

    @NotNull
    public final String getIconText() {
        return this.f;
    }

    @NotNull
    public final String getPollingID() {
        return this.b;
    }

    public final long getPollingInterval() {
        return this.c;
    }

    @NotNull
    public final List<String> getQuotes() {
        return this.d;
    }

    @NotNull
    public final String getTitle() {
        return this.e;
    }

    public final int getTitleColor() {
        return this.g;
    }

    public int hashCode() {
        int i = this.a * 31;
        String str = this.b;
        int i2 = 0;
        int hashCode = (((i + (str != null ? str.hashCode() : 0)) * 31) + c.a(this.c)) * 31;
        List<String> list = this.d;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.e;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return ((hashCode3 + i2) * 31) + this.g;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OsagoCompanyOrderDomain(backgroundColor=");
        L.append(this.a);
        L.append(", pollingID=");
        L.append(this.b);
        L.append(", pollingInterval=");
        L.append(this.c);
        L.append(", quotes=");
        L.append(this.d);
        L.append(", title=");
        L.append(this.e);
        L.append(", iconText=");
        L.append(this.f);
        L.append(", titleColor=");
        return a.j(L, this.g, ")");
    }
}
