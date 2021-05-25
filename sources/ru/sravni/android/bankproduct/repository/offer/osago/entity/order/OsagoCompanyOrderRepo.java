package ru.sravni.android.bankproduct.repository.offer.osago.entity.order;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.model.VKApiUserFull;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.order.OsagoCompanyOrderDomain;
import ru.sravni.android.bankproduct.utils.UtilFunctionsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\f\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b0\u00101J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0007JR\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\t2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0007J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0019\u0010\u0013\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u000bR\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\f8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u000eR\u0019\u0010\u0012\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u0007R\u0019\u0010\u0015\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010(\u001a\u0004\b+\u0010\u0007R\u0019\u0010\u0016\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010(\u001a\u0004\b-\u0010\u0007R\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010(\u001a\u0004\b/\u0010\u0007¨\u00062"}, d2 = {"Lru/sravni/android/bankproduct/repository/offer/osago/entity/order/OsagoCompanyOrderRepo;", "", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyOrderDomain;", "toOsagoCompanyOrderDomain", "()Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyOrderDomain;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()J", "", "component4", "()Ljava/util/List;", "component5", "component6", "backgroundColor", "pollingID", "pollingInterval", VKApiUserFull.QUOTES, "title", "titleColor", "copy", "(Ljava/lang/String;Ljava/lang/String;JLjava/util/List;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/repository/offer/osago/entity/order/OsagoCompanyOrderRepo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "J", "getPollingInterval", "d", "Ljava/util/List;", "getQuotes", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getPollingID", "e", "getTitle", "f", "getTitleColor", AuthSource.SEND_ABUSE, "getBackgroundColor", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OsagoCompanyOrderRepo {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    public final long c;
    @NotNull
    public final List<String> d;
    @NotNull
    public final String e;
    @NotNull
    public final String f;

    public OsagoCompanyOrderRepo(@NotNull String str, @NotNull String str2, long j, @NotNull List<String> list, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, "backgroundColor");
        Intrinsics.checkParameterIsNotNull(str2, "pollingID");
        Intrinsics.checkParameterIsNotNull(list, VKApiUserFull.QUOTES);
        Intrinsics.checkParameterIsNotNull(str3, "title");
        Intrinsics.checkParameterIsNotNull(str4, "titleColor");
        this.a = str;
        this.b = str2;
        this.c = j;
        this.d = list;
        this.e = str3;
        this.f = str4;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: ru.sravni.android.bankproduct.repository.offer.osago.entity.order.OsagoCompanyOrderRepo */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OsagoCompanyOrderRepo copy$default(OsagoCompanyOrderRepo osagoCompanyOrderRepo, String str, String str2, long j, List list, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = osagoCompanyOrderRepo.a;
        }
        if ((i & 2) != 0) {
            str2 = osagoCompanyOrderRepo.b;
        }
        if ((i & 4) != 0) {
            j = osagoCompanyOrderRepo.c;
        }
        if ((i & 8) != 0) {
            list = osagoCompanyOrderRepo.d;
        }
        if ((i & 16) != 0) {
            str3 = osagoCompanyOrderRepo.e;
        }
        if ((i & 32) != 0) {
            str4 = osagoCompanyOrderRepo.f;
        }
        return osagoCompanyOrderRepo.copy(str, str2, j, list, str3, str4);
    }

    @NotNull
    public final String component1() {
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

    @NotNull
    public final OsagoCompanyOrderRepo copy(@NotNull String str, @NotNull String str2, long j, @NotNull List<String> list, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, "backgroundColor");
        Intrinsics.checkParameterIsNotNull(str2, "pollingID");
        Intrinsics.checkParameterIsNotNull(list, VKApiUserFull.QUOTES);
        Intrinsics.checkParameterIsNotNull(str3, "title");
        Intrinsics.checkParameterIsNotNull(str4, "titleColor");
        return new OsagoCompanyOrderRepo(str, str2, j, list, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OsagoCompanyOrderRepo)) {
            return false;
        }
        OsagoCompanyOrderRepo osagoCompanyOrderRepo = (OsagoCompanyOrderRepo) obj;
        return Intrinsics.areEqual(this.a, osagoCompanyOrderRepo.a) && Intrinsics.areEqual(this.b, osagoCompanyOrderRepo.b) && this.c == osagoCompanyOrderRepo.c && Intrinsics.areEqual(this.d, osagoCompanyOrderRepo.d) && Intrinsics.areEqual(this.e, osagoCompanyOrderRepo.e) && Intrinsics.areEqual(this.f, osagoCompanyOrderRepo.f);
    }

    @NotNull
    public final String getBackgroundColor() {
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
    public final List<String> getQuotes() {
        return this.d;
    }

    @NotNull
    public final String getTitle() {
        return this.e;
    }

    @NotNull
    public final String getTitleColor() {
        return this.f;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + c.a(this.c)) * 31;
        List<String> list = this.d;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        String str3 = this.e;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public final OsagoCompanyOrderDomain toOsagoCompanyOrderDomain() {
        String str = this.b;
        long j = this.c;
        int titleColor = UtilFunctionsKt.getTitleColor(this.f);
        int titleColor2 = UtilFunctionsKt.getTitleColor(this.a);
        List<String> list = this.d;
        String str2 = this.e;
        return new OsagoCompanyOrderDomain(titleColor2, str, j, list, str2, UtilFunctionsKt.firstSymbolOrEmptyString(str2), titleColor);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OsagoCompanyOrderRepo(backgroundColor=");
        L.append(this.a);
        L.append(", pollingID=");
        L.append(this.b);
        L.append(", pollingInterval=");
        L.append(this.c);
        L.append(", quotes=");
        L.append(this.d);
        L.append(", title=");
        L.append(this.e);
        L.append(", titleColor=");
        return a.t(L, this.f, ")");
    }
}
