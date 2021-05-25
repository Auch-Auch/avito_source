package ru.sravni.android.bankproduct.repository.offer.osago.entity.list;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoCompanyDetailDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoListCompanyDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OsagoCompanyDetailEnum;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001:\u0001+B-\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b)\u0010*J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000bJ>\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u000bJ\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0012\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u000eR\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\bR\u0019\u0010\u0013\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u000bR\u0019\u0010\u0011\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010%\u001a\u0004\b(\u0010\u000b¨\u0006,"}, d2 = {"Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoListCompanyRepo;", "", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoListCompanyDomain;", "toOfferOsagoListCompanyDomain", "()Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoListCompanyDomain;", "", "Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoListCompanyRepo$CompanyRepo;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/String;", "", "component3", "()J", "component4", "listCompany", "pollingID", "pollingInterval", "pollingStatus", "copy", "(Ljava/util/List;Ljava/lang/String;JLjava/lang/String;)Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoListCompanyRepo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "J", "getPollingInterval", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getListCompany", "d", "Ljava/lang/String;", "getPollingStatus", AuthSource.BOOKING_ORDER, "getPollingID", "<init>", "(Ljava/util/List;Ljava/lang/String;JLjava/lang/String;)V", "CompanyRepo", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferOsagoListCompanyRepo {
    @NotNull
    public final List<CompanyRepo> a;
    @NotNull
    public final String b;
    public final long c;
    @NotNull
    public final String d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u001a\b\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0011¢\u0006\u0004\b;\u0010<J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0007J\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0001\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0011HÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0007J\u0010\u0010 \u001a\u00020\bHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u0019\u0010\u0014\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0007R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\nR\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b-\u0010\u0007R%\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00118\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\u0013R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010'\u001a\u0004\b2\u0010\u0007R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010'\u001a\u0004\b4\u0010\u0007R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010'\u001a\u0004\b6\u0010\u0007R\u0019\u0010\u0019\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010'\u001a\u0004\b8\u0010\u0007R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010'\u001a\u0004\b:\u0010\u0007¨\u0006="}, d2 = {"Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoListCompanyRepo$CompanyRepo;", "", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoCompanyDetailDomain;", "toOfferOsagoCompanyDetailDomain", "()Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoCompanyDetailDomain;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Integer;", "component3", "component4", "component5", "component6", "component7", "component8", "", "component9", "()Ljava/util/Map;", "productID", "sum", "sumTitle", "sumValue", "linkText", "status", "statusDescription", "statusText", "requestParams", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoListCompanyRepo$CompanyRepo;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getProductID", AuthSource.BOOKING_ORDER, "Ljava/lang/Integer;", "getSum", "d", "getSumValue", "i", "Ljava/util/Map;", "getRequestParams", "h", "getStatusText", g.a, "getStatusDescription", "c", "getSumTitle", "f", "getStatus", "e", "getLinkText", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class CompanyRepo {
        @NotNull
        public final String a;
        @Nullable
        public final Integer b;
        @Nullable
        public final String c;
        @Nullable
        public final String d;
        @Nullable
        public final String e;
        @NotNull
        public final String f;
        @Nullable
        public final String g;
        @Nullable
        public final String h;
        @NotNull
        public final Map<String, String> i;

        public CompanyRepo(@NotNull String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull String str5, @Nullable String str6, @Nullable String str7, @NotNull Map<String, String> map) {
            Intrinsics.checkParameterIsNotNull(str, "productID");
            Intrinsics.checkParameterIsNotNull(str5, "status");
            Intrinsics.checkParameterIsNotNull(map, "requestParams");
            this.a = str;
            this.b = num;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
            this.g = str6;
            this.h = str7;
            this.i = map;
        }

        public static /* synthetic */ CompanyRepo copy$default(CompanyRepo companyRepo, String str, Integer num, String str2, String str3, String str4, String str5, String str6, String str7, Map map, int i2, Object obj) {
            return companyRepo.copy((i2 & 1) != 0 ? companyRepo.a : str, (i2 & 2) != 0 ? companyRepo.b : num, (i2 & 4) != 0 ? companyRepo.c : str2, (i2 & 8) != 0 ? companyRepo.d : str3, (i2 & 16) != 0 ? companyRepo.e : str4, (i2 & 32) != 0 ? companyRepo.f : str5, (i2 & 64) != 0 ? companyRepo.g : str6, (i2 & 128) != 0 ? companyRepo.h : str7, (i2 & 256) != 0 ? companyRepo.i : map);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @Nullable
        public final Integer component2() {
            return this.b;
        }

        @Nullable
        public final String component3() {
            return this.c;
        }

        @Nullable
        public final String component4() {
            return this.d;
        }

        @Nullable
        public final String component5() {
            return this.e;
        }

        @NotNull
        public final String component6() {
            return this.f;
        }

        @Nullable
        public final String component7() {
            return this.g;
        }

        @Nullable
        public final String component8() {
            return this.h;
        }

        @NotNull
        public final Map<String, String> component9() {
            return this.i;
        }

        @NotNull
        public final CompanyRepo copy(@NotNull String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull String str5, @Nullable String str6, @Nullable String str7, @NotNull Map<String, String> map) {
            Intrinsics.checkParameterIsNotNull(str, "productID");
            Intrinsics.checkParameterIsNotNull(str5, "status");
            Intrinsics.checkParameterIsNotNull(map, "requestParams");
            return new CompanyRepo(str, num, str2, str3, str4, str5, str6, str7, map);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CompanyRepo)) {
                return false;
            }
            CompanyRepo companyRepo = (CompanyRepo) obj;
            return Intrinsics.areEqual(this.a, companyRepo.a) && Intrinsics.areEqual(this.b, companyRepo.b) && Intrinsics.areEqual(this.c, companyRepo.c) && Intrinsics.areEqual(this.d, companyRepo.d) && Intrinsics.areEqual(this.e, companyRepo.e) && Intrinsics.areEqual(this.f, companyRepo.f) && Intrinsics.areEqual(this.g, companyRepo.g) && Intrinsics.areEqual(this.h, companyRepo.h) && Intrinsics.areEqual(this.i, companyRepo.i);
        }

        @Nullable
        public final String getLinkText() {
            return this.e;
        }

        @NotNull
        public final String getProductID() {
            return this.a;
        }

        @NotNull
        public final Map<String, String> getRequestParams() {
            return this.i;
        }

        @NotNull
        public final String getStatus() {
            return this.f;
        }

        @Nullable
        public final String getStatusDescription() {
            return this.g;
        }

        @Nullable
        public final String getStatusText() {
            return this.h;
        }

        @Nullable
        public final Integer getSum() {
            return this.b;
        }

        @Nullable
        public final String getSumTitle() {
            return this.c;
        }

        @Nullable
        public final String getSumValue() {
            return this.d;
        }

        public int hashCode() {
            String str = this.a;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Integer num = this.b;
            int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
            String str2 = this.c;
            int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.d;
            int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.e;
            int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.f;
            int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.g;
            int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
            String str7 = this.h;
            int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
            Map<String, String> map = this.i;
            if (map != null) {
                i2 = map.hashCode();
            }
            return hashCode8 + i2;
        }

        @NotNull
        public final OfferOsagoCompanyDetailDomain toOfferOsagoCompanyDetailDomain() {
            OsagoCompanyDetailEnum osagoCompanyDetailEnum;
            String str = this.a;
            Integer num = this.b;
            String str2 = this.d;
            String str3 = this.c;
            String str4 = this.e;
            String str5 = this.f;
            int hashCode = str5.hashCode();
            if (hashCode != -2146525273) {
                if (hashCode == 568196142 && str5.equals("declined")) {
                    osagoCompanyDetailEnum = OsagoCompanyDetailEnum.OSAGO_ERROR;
                    return new OfferOsagoCompanyDetailDomain(str, num, str3, str2, str4, osagoCompanyDetailEnum, this.g, this.h, this.i);
                }
            } else if (str5.equals("accepted")) {
                osagoCompanyDetailEnum = OsagoCompanyDetailEnum.OSAGO_SUCCESS;
                return new OfferOsagoCompanyDetailDomain(str, num, str3, str2, str4, osagoCompanyDetailEnum, this.g, this.h, this.i);
            }
            osagoCompanyDetailEnum = OsagoCompanyDetailEnum.OSAGO_ERROR;
            return new OfferOsagoCompanyDetailDomain(str, num, str3, str2, str4, osagoCompanyDetailEnum, this.g, this.h, this.i);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("CompanyRepo(productID=");
            L.append(this.a);
            L.append(", sum=");
            L.append(this.b);
            L.append(", sumTitle=");
            L.append(this.c);
            L.append(", sumValue=");
            L.append(this.d);
            L.append(", linkText=");
            L.append(this.e);
            L.append(", status=");
            L.append(this.f);
            L.append(", statusDescription=");
            L.append(this.g);
            L.append(", statusText=");
            L.append(this.h);
            L.append(", requestParams=");
            return a.x(L, this.i, ")");
        }
    }

    public OfferOsagoListCompanyRepo(@NotNull List<CompanyRepo> list, @NotNull String str, long j, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(list, "listCompany");
        Intrinsics.checkParameterIsNotNull(str, "pollingID");
        Intrinsics.checkParameterIsNotNull(str2, "pollingStatus");
        this.a = list;
        this.b = str;
        this.c = j;
        this.d = str2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: ru.sravni.android.bankproduct.repository.offer.osago.entity.list.OfferOsagoListCompanyRepo */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfferOsagoListCompanyRepo copy$default(OfferOsagoListCompanyRepo offerOsagoListCompanyRepo, List list, String str, long j, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = offerOsagoListCompanyRepo.a;
        }
        if ((i & 2) != 0) {
            str = offerOsagoListCompanyRepo.b;
        }
        if ((i & 4) != 0) {
            j = offerOsagoListCompanyRepo.c;
        }
        if ((i & 8) != 0) {
            str2 = offerOsagoListCompanyRepo.d;
        }
        return offerOsagoListCompanyRepo.copy(list, str, j, str2);
    }

    @NotNull
    public final List<CompanyRepo> component1() {
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
    public final OfferOsagoListCompanyRepo copy(@NotNull List<CompanyRepo> list, @NotNull String str, long j, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(list, "listCompany");
        Intrinsics.checkParameterIsNotNull(str, "pollingID");
        Intrinsics.checkParameterIsNotNull(str2, "pollingStatus");
        return new OfferOsagoListCompanyRepo(list, str, j, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferOsagoListCompanyRepo)) {
            return false;
        }
        OfferOsagoListCompanyRepo offerOsagoListCompanyRepo = (OfferOsagoListCompanyRepo) obj;
        return Intrinsics.areEqual(this.a, offerOsagoListCompanyRepo.a) && Intrinsics.areEqual(this.b, offerOsagoListCompanyRepo.b) && this.c == offerOsagoListCompanyRepo.c && Intrinsics.areEqual(this.d, offerOsagoListCompanyRepo.d);
    }

    @NotNull
    public final List<CompanyRepo> getListCompany() {
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
        List<CompanyRepo> list = this.a;
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
    public final OfferOsagoListCompanyDomain toOfferOsagoListCompanyDomain() {
        String str = this.b;
        long j = this.c;
        String str2 = this.d;
        List<CompanyRepo> list = this.a;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toOfferOsagoCompanyDetailDomain());
        }
        return new OfferOsagoListCompanyDomain(arrayList, str, j, str2);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferOsagoListCompanyRepo(listCompany=");
        L.append(this.a);
        L.append(", pollingID=");
        L.append(this.b);
        L.append(", pollingInterval=");
        L.append(this.c);
        L.append(", pollingStatus=");
        return a.t(L, this.d, ")");
    }
}
