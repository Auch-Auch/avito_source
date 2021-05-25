package ru.sravni.android.bankproduct.domain.offer.osago.entity.list;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B-\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b&\u0010'J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\f\u0010\bJ>\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0013\u0010\bJ\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u000f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u000bR\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0005R\u0019\u0010\u000e\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\bR\u0019\u0010\u0010\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\"\u001a\u0004\b%\u0010\b¨\u0006("}, d2 = {"Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoListCompanyDomain;", "", "", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoCompanyDetailDomain;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/String;", "", "component3", "()J", "component4", "listCompany", "pollingID", "pollingInterval", "pollingStatus", "copy", "(Ljava/util/List;Ljava/lang/String;JLjava/lang/String;)Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoListCompanyDomain;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "J", "getPollingInterval", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getListCompany", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getPollingID", "d", "getPollingStatus", "<init>", "(Ljava/util/List;Ljava/lang/String;JLjava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferOsagoListCompanyDomain {
    @NotNull
    public final List<OfferOsagoCompanyDetailDomain> a;
    @NotNull
    public final String b;
    public final long c;
    @NotNull
    public final String d;

    public OfferOsagoListCompanyDomain(@NotNull List<OfferOsagoCompanyDetailDomain> list, @NotNull String str, long j, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(list, "listCompany");
        Intrinsics.checkParameterIsNotNull(str, "pollingID");
        Intrinsics.checkParameterIsNotNull(str2, "pollingStatus");
        this.a = list;
        this.b = str;
        this.c = j;
        this.d = str2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoListCompanyDomain */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfferOsagoListCompanyDomain copy$default(OfferOsagoListCompanyDomain offerOsagoListCompanyDomain, List list, String str, long j, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = offerOsagoListCompanyDomain.a;
        }
        if ((i & 2) != 0) {
            str = offerOsagoListCompanyDomain.b;
        }
        if ((i & 4) != 0) {
            j = offerOsagoListCompanyDomain.c;
        }
        if ((i & 8) != 0) {
            str2 = offerOsagoListCompanyDomain.d;
        }
        return offerOsagoListCompanyDomain.copy(list, str, j, str2);
    }

    @NotNull
    public final List<OfferOsagoCompanyDetailDomain> component1() {
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
    public final String component4() {
        return this.d;
    }

    @NotNull
    public final OfferOsagoListCompanyDomain copy(@NotNull List<OfferOsagoCompanyDetailDomain> list, @NotNull String str, long j, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(list, "listCompany");
        Intrinsics.checkParameterIsNotNull(str, "pollingID");
        Intrinsics.checkParameterIsNotNull(str2, "pollingStatus");
        return new OfferOsagoListCompanyDomain(list, str, j, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferOsagoListCompanyDomain)) {
            return false;
        }
        OfferOsagoListCompanyDomain offerOsagoListCompanyDomain = (OfferOsagoListCompanyDomain) obj;
        return Intrinsics.areEqual(this.a, offerOsagoListCompanyDomain.a) && Intrinsics.areEqual(this.b, offerOsagoListCompanyDomain.b) && this.c == offerOsagoListCompanyDomain.c && Intrinsics.areEqual(this.d, offerOsagoListCompanyDomain.d);
    }

    @NotNull
    public final List<OfferOsagoCompanyDetailDomain> getListCompany() {
        return this.a;
    }

    @NotNull
    public final String getPollingID() {
        return this.b;
    }

    public final long getPollingInterval() {
        return this.c;
    }

    @NotNull
    public final String getPollingStatus() {
        return this.d;
    }

    public int hashCode() {
        List<OfferOsagoCompanyDetailDomain> list = this.a;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.b;
        int hashCode2 = (((hashCode + (str != null ? str.hashCode() : 0)) * 31) + c.a(this.c)) * 31;
        String str2 = this.d;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferOsagoListCompanyDomain(listCompany=");
        L.append(this.a);
        L.append(", pollingID=");
        L.append(this.b);
        L.append(", pollingInterval=");
        L.append(this.c);
        L.append(", pollingStatus=");
        return a.t(L, this.d, ")");
    }
}
