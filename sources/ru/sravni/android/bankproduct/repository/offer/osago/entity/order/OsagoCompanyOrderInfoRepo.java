package ru.sravni.android.bankproduct.repository.offer.osago.entity.order;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.order.OsagoCompanyOrderInfoDomain;
import ru.sravni.android.bankproduct.utils.UtilFunctionsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b \b\b\u0018\u00002\u00020\u0001:\u0001IBm\u0012\u0006\u0010\u001b\u001a\u00020\b\u0012\u0006\u0010\u001c\u001a\u00020\u000b\u0012\u0006\u0010\u001d\u001a\u00020\b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\b\u0012\b\u0010 \u001a\u0004\u0018\u00010\b\u0012\b\u0010!\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\"\u001a\u00020\u0013\u0012\u0006\u0010#\u001a\u00020\b\u0012\u0006\u0010$\u001a\u00020\b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00180\u0002¢\u0006\u0004\bG\u0010HJ\u001b\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\nJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\nJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u0010\u0010\nJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u0011\u0010\nJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u0012\u0010\nJ\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0016\u0010\nJ\u0010\u0010\u0017\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0017\u0010\nJ\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0001\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001d\u001a\u00020\b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\"\u001a\u00020\u00132\b\b\u0002\u0010#\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020\b2\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00180\u0002HÆ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b'\u0010\nJ\u0010\u0010(\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b(\u0010\u0015J\u001a\u0010+\u001a\u00020*2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b+\u0010,R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\nR\u0019\u0010\u001c\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\rR\u0019\u0010\"\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u0010\u0015R\u001b\u0010 \u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010.\u001a\u0004\b7\u0010\nR\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00180\u00028\u0006@\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010\u001aR\u0019\u0010\u001d\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010.\u001a\u0004\b<\u0010\nR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010.\u001a\u0004\b>\u0010\nR\u0019\u0010#\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010.\u001a\u0004\b@\u0010\nR\u0019\u0010$\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010.\u001a\u0004\bB\u0010\nR\u0019\u0010\u001b\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010.\u001a\u0004\bD\u0010\nR\u001b\u0010!\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010.\u001a\u0004\bF\u0010\n¨\u0006J"}, d2 = {"Lru/sravni/android/bankproduct/repository/offer/osago/entity/order/OsagoCompanyOrderInfoRepo;", "", "", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyOrderInfoDomain$CompanyDomain;", "listCompany", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyOrderInfoDomain;", "toOsagoOrderCompanyInfoDomain", "(Ljava/util/List;)Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyOrderInfoDomain;", "", "component1", "()Ljava/lang/String;", "", "component2", "()J", "component3", "component4", "component5", "component6", "component7", "", "component8", "()I", "component9", "component10", "Lru/sravni/android/bankproduct/repository/offer/osago/entity/order/OsagoCompanyOrderInfoRepo$CompanyRepo;", "component11", "()Ljava/util/List;", "pollingID", "pollingInterval", "pollingStatus", "textTitle", "comparisonText", "comparisonPrice", "text", "price", "priceValue", "url", "copy", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)Lru/sravni/android/bankproduct/repository/offer/osago/entity/order/OsagoCompanyOrderInfoRepo;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "e", "Ljava/lang/String;", "getComparisonText", AuthSource.BOOKING_ORDER, "J", "getPollingInterval", "h", "I", "getPrice", "f", "getComparisonPrice", "k", "Ljava/util/List;", "getListCompany", "c", "getPollingStatus", "d", "getTextTitle", "i", "getPriceValue", "j", "getUrl", AuthSource.SEND_ABUSE, "getPollingID", g.a, "getText", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "CompanyRepo", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OsagoCompanyOrderInfoRepo {
    @NotNull
    public final String a;
    public final long b;
    @NotNull
    public final String c;
    @Nullable
    public final String d;
    @Nullable
    public final String e;
    @Nullable
    public final String f;
    @Nullable
    public final String g;
    public final int h;
    @NotNull
    public final String i;
    @NotNull
    public final String j;
    @NotNull
    public final List<CompanyRepo> k;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0015\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\b¢\u0006\u0004\b/\u00100J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\f\u0010\nJ\u0010\u0010\r\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\r\u0010\nJ\u0010\u0010\u000e\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\nJ\u0010\u0010\u000f\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\nJV\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0019\u0010\nJ\u0010\u0010\u001a\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0007J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0016\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\nR\u0019\u0010\u0011\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010 \u001a\u0004\b#\u0010\nR\u0019\u0010\u0015\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\nR\u0019\u0010\u0013\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\nR\u0019\u0010\u0012\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010 \u001a\u0004\b)\u0010\nR\u0019\u0010\u0010\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u0007R\u0019\u0010\u0014\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010 \u001a\u0004\b.\u0010\n¨\u00061"}, d2 = {"Lru/sravni/android/bankproduct/repository/offer/osago/entity/order/OsagoCompanyOrderInfoRepo$CompanyRepo;", "", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyOrderInfoDomain$CompanyDomain;", "toCompanyDomain", "()Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyOrderInfoDomain$CompanyDomain;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "component6", "component7", "price", "priceValue", "productID", "companyID", "title", "titleColor", "backgroundColor", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/repository/offer/osago/entity/order/OsagoCompanyOrderInfoRepo$CompanyRepo;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", g.a, "Ljava/lang/String;", "getBackgroundColor", AuthSource.BOOKING_ORDER, "getPriceValue", "f", "getTitleColor", "d", "getCompanyID", "c", "getProductID", AuthSource.SEND_ABUSE, "I", "getPrice", "e", "getTitle", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class CompanyRepo {
        public final int a;
        @NotNull
        public final String b;
        @NotNull
        public final String c;
        @NotNull
        public final String d;
        @NotNull
        public final String e;
        @NotNull
        public final String f;
        @NotNull
        public final String g;

        public CompanyRepo(int i, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
            Intrinsics.checkParameterIsNotNull(str, "priceValue");
            Intrinsics.checkParameterIsNotNull(str2, "productID");
            Intrinsics.checkParameterIsNotNull(str3, "companyID");
            Intrinsics.checkParameterIsNotNull(str4, "title");
            Intrinsics.checkParameterIsNotNull(str5, "titleColor");
            Intrinsics.checkParameterIsNotNull(str6, "backgroundColor");
            this.a = i;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
            this.g = str6;
        }

        public static /* synthetic */ CompanyRepo copy$default(CompanyRepo companyRepo, int i, String str, String str2, String str3, String str4, String str5, String str6, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = companyRepo.a;
            }
            if ((i2 & 2) != 0) {
                str = companyRepo.b;
            }
            if ((i2 & 4) != 0) {
                str2 = companyRepo.c;
            }
            if ((i2 & 8) != 0) {
                str3 = companyRepo.d;
            }
            if ((i2 & 16) != 0) {
                str4 = companyRepo.e;
            }
            if ((i2 & 32) != 0) {
                str5 = companyRepo.f;
            }
            if ((i2 & 64) != 0) {
                str6 = companyRepo.g;
            }
            return companyRepo.copy(i, str, str2, str3, str4, str5, str6);
        }

        public final int component1() {
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
        public final String component6() {
            return this.f;
        }

        @NotNull
        public final String component7() {
            return this.g;
        }

        @NotNull
        public final CompanyRepo copy(int i, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
            Intrinsics.checkParameterIsNotNull(str, "priceValue");
            Intrinsics.checkParameterIsNotNull(str2, "productID");
            Intrinsics.checkParameterIsNotNull(str3, "companyID");
            Intrinsics.checkParameterIsNotNull(str4, "title");
            Intrinsics.checkParameterIsNotNull(str5, "titleColor");
            Intrinsics.checkParameterIsNotNull(str6, "backgroundColor");
            return new CompanyRepo(i, str, str2, str3, str4, str5, str6);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CompanyRepo)) {
                return false;
            }
            CompanyRepo companyRepo = (CompanyRepo) obj;
            return this.a == companyRepo.a && Intrinsics.areEqual(this.b, companyRepo.b) && Intrinsics.areEqual(this.c, companyRepo.c) && Intrinsics.areEqual(this.d, companyRepo.d) && Intrinsics.areEqual(this.e, companyRepo.e) && Intrinsics.areEqual(this.f, companyRepo.f) && Intrinsics.areEqual(this.g, companyRepo.g);
        }

        @NotNull
        public final String getBackgroundColor() {
            return this.g;
        }

        @NotNull
        public final String getCompanyID() {
            return this.d;
        }

        public final int getPrice() {
            return this.a;
        }

        @NotNull
        public final String getPriceValue() {
            return this.b;
        }

        @NotNull
        public final String getProductID() {
            return this.c;
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
            int i = this.a * 31;
            String str = this.b;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.c;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.d;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.e;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.f;
            int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.g;
            if (str6 != null) {
                i2 = str6.hashCode();
            }
            return hashCode5 + i2;
        }

        @NotNull
        public final OsagoCompanyOrderInfoDomain.CompanyDomain toCompanyDomain() {
            int i = this.a;
            String str = this.b;
            String str2 = this.c;
            String str3 = this.d;
            String str4 = this.e;
            return new OsagoCompanyOrderInfoDomain.CompanyDomain(i, str, str2, str3, str4, UtilFunctionsKt.getTitleColor(this.f), UtilFunctionsKt.firstSymbolOrEmptyString(str4), UtilFunctionsKt.getTitleColor(this.g));
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("CompanyRepo(price=");
            L.append(this.a);
            L.append(", priceValue=");
            L.append(this.b);
            L.append(", productID=");
            L.append(this.c);
            L.append(", companyID=");
            L.append(this.d);
            L.append(", title=");
            L.append(this.e);
            L.append(", titleColor=");
            L.append(this.f);
            L.append(", backgroundColor=");
            return a.t(L, this.g, ")");
        }
    }

    public OsagoCompanyOrderInfoRepo(@NotNull String str, long j2, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, int i2, @NotNull String str7, @NotNull String str8, @NotNull List<CompanyRepo> list) {
        Intrinsics.checkParameterIsNotNull(str, "pollingID");
        Intrinsics.checkParameterIsNotNull(str2, "pollingStatus");
        Intrinsics.checkParameterIsNotNull(str7, "priceValue");
        Intrinsics.checkParameterIsNotNull(str8, "url");
        Intrinsics.checkParameterIsNotNull(list, "listCompany");
        this.a = str;
        this.b = j2;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = i2;
        this.i = str7;
        this.j = str8;
        this.k = list;
    }

    public static /* synthetic */ OsagoCompanyOrderInfoRepo copy$default(OsagoCompanyOrderInfoRepo osagoCompanyOrderInfoRepo, String str, long j2, String str2, String str3, String str4, String str5, String str6, int i2, String str7, String str8, List list, int i3, Object obj) {
        return osagoCompanyOrderInfoRepo.copy((i3 & 1) != 0 ? osagoCompanyOrderInfoRepo.a : str, (i3 & 2) != 0 ? osagoCompanyOrderInfoRepo.b : j2, (i3 & 4) != 0 ? osagoCompanyOrderInfoRepo.c : str2, (i3 & 8) != 0 ? osagoCompanyOrderInfoRepo.d : str3, (i3 & 16) != 0 ? osagoCompanyOrderInfoRepo.e : str4, (i3 & 32) != 0 ? osagoCompanyOrderInfoRepo.f : str5, (i3 & 64) != 0 ? osagoCompanyOrderInfoRepo.g : str6, (i3 & 128) != 0 ? osagoCompanyOrderInfoRepo.h : i2, (i3 & 256) != 0 ? osagoCompanyOrderInfoRepo.i : str7, (i3 & 512) != 0 ? osagoCompanyOrderInfoRepo.j : str8, (i3 & 1024) != 0 ? osagoCompanyOrderInfoRepo.k : list);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component10() {
        return this.j;
    }

    @NotNull
    public final List<CompanyRepo> component11() {
        return this.k;
    }

    public final long component2() {
        return this.b;
    }

    @NotNull
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

    @Nullable
    public final String component6() {
        return this.f;
    }

    @Nullable
    public final String component7() {
        return this.g;
    }

    public final int component8() {
        return this.h;
    }

    @NotNull
    public final String component9() {
        return this.i;
    }

    @NotNull
    public final OsagoCompanyOrderInfoRepo copy(@NotNull String str, long j2, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, int i2, @NotNull String str7, @NotNull String str8, @NotNull List<CompanyRepo> list) {
        Intrinsics.checkParameterIsNotNull(str, "pollingID");
        Intrinsics.checkParameterIsNotNull(str2, "pollingStatus");
        Intrinsics.checkParameterIsNotNull(str7, "priceValue");
        Intrinsics.checkParameterIsNotNull(str8, "url");
        Intrinsics.checkParameterIsNotNull(list, "listCompany");
        return new OsagoCompanyOrderInfoRepo(str, j2, str2, str3, str4, str5, str6, i2, str7, str8, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OsagoCompanyOrderInfoRepo)) {
            return false;
        }
        OsagoCompanyOrderInfoRepo osagoCompanyOrderInfoRepo = (OsagoCompanyOrderInfoRepo) obj;
        return Intrinsics.areEqual(this.a, osagoCompanyOrderInfoRepo.a) && this.b == osagoCompanyOrderInfoRepo.b && Intrinsics.areEqual(this.c, osagoCompanyOrderInfoRepo.c) && Intrinsics.areEqual(this.d, osagoCompanyOrderInfoRepo.d) && Intrinsics.areEqual(this.e, osagoCompanyOrderInfoRepo.e) && Intrinsics.areEqual(this.f, osagoCompanyOrderInfoRepo.f) && Intrinsics.areEqual(this.g, osagoCompanyOrderInfoRepo.g) && this.h == osagoCompanyOrderInfoRepo.h && Intrinsics.areEqual(this.i, osagoCompanyOrderInfoRepo.i) && Intrinsics.areEqual(this.j, osagoCompanyOrderInfoRepo.j) && Intrinsics.areEqual(this.k, osagoCompanyOrderInfoRepo.k);
    }

    @Nullable
    public final String getComparisonPrice() {
        return this.f;
    }

    @Nullable
    public final String getComparisonText() {
        return this.e;
    }

    @NotNull
    public final List<CompanyRepo> getListCompany() {
        return this.k;
    }

    @NotNull
    public final String getPollingID() {
        return this.a;
    }

    public final long getPollingInterval() {
        return this.b;
    }

    @NotNull
    public final String getPollingStatus() {
        return this.c;
    }

    public final int getPrice() {
        return this.h;
    }

    @NotNull
    public final String getPriceValue() {
        return this.i;
    }

    @Nullable
    public final String getText() {
        return this.g;
    }

    @Nullable
    public final String getTextTitle() {
        return this.d;
    }

    @NotNull
    public final String getUrl() {
        return this.j;
    }

    public int hashCode() {
        String str = this.a;
        int i2 = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + c.a(this.b)) * 31;
        String str2 = this.c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.d;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.e;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.g;
        int hashCode6 = (((hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.h) * 31;
        String str7 = this.i;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.j;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        List<CompanyRepo> list = this.k;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode8 + i2;
    }

    @NotNull
    public final OsagoCompanyOrderInfoDomain toOsagoOrderCompanyInfoDomain(@NotNull List<OsagoCompanyOrderInfoDomain.CompanyDomain> list) {
        Intrinsics.checkParameterIsNotNull(list, "listCompany");
        return new OsagoCompanyOrderInfoDomain(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, list);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OsagoCompanyOrderInfoRepo(pollingID=");
        L.append(this.a);
        L.append(", pollingInterval=");
        L.append(this.b);
        L.append(", pollingStatus=");
        L.append(this.c);
        L.append(", textTitle=");
        L.append(this.d);
        L.append(", comparisonText=");
        L.append(this.e);
        L.append(", comparisonPrice=");
        L.append(this.f);
        L.append(", text=");
        L.append(this.g);
        L.append(", price=");
        L.append(this.h);
        L.append(", priceValue=");
        L.append(this.i);
        L.append(", url=");
        L.append(this.j);
        L.append(", listCompany=");
        return a.w(L, this.k, ")");
    }
}
