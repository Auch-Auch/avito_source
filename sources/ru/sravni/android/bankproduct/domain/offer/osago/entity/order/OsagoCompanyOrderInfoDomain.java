package ru.sravni.android.bankproduct.domain.offer.osago.entity.order;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b \b\b\u0018\u00002\u00020\u0001:\u0001EBm\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001d\u001a\u00020\r\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\bC\u0010DJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0001\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u00022\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130\u0012HÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b#\u0010\u0004J\u0010\u0010$\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b$\u0010\u000fJ\u001a\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b'\u0010(R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u0004R\u0019\u0010\u0018\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010*\u001a\u0004\b-\u0010\u0004R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010*\u001a\u0004\b/\u0010\u0004R\u0019\u0010\u001f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010*\u001a\u0004\b1\u0010\u0004R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010*\u001a\u0004\b3\u0010\u0004R\u0019\u0010\u001d\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u0010\u000fR\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010*\u001a\u0004\b8\u0010\u0004R\u001f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010\u0015R\u0019\u0010\u0017\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010\u0007R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010*\u001a\u0004\b@\u0010\u0004R\u0019\u0010\u001e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010*\u001a\u0004\bB\u0010\u0004¨\u0006F"}, d2 = {"Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyOrderInfoDomain;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()J", "component3", "component4", "component5", "component6", "component7", "", "component8", "()I", "component9", "component10", "", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyOrderInfoDomain$CompanyDomain;", "component11", "()Ljava/util/List;", "pollingID", "pollingInterval", "pollingStatus", "textTitle", "comparisonText", "comparisonPrice", "text", "price", "priceValue", "url", "listCompany", "copy", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyOrderInfoDomain;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getPollingID", "c", "getPollingStatus", "f", "getComparisonPrice", "j", "getUrl", "d", "getTextTitle", "h", "I", "getPrice", "e", "getComparisonText", "k", "Ljava/util/List;", "getListCompany", AuthSource.BOOKING_ORDER, "J", "getPollingInterval", g.a, "getText", "i", "getPriceValue", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "CompanyDomain", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OsagoCompanyOrderInfoDomain {
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
    public final List<CompanyDomain> k;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0017\b\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b0\u00101J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J`\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0007J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0007R\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u001f\u001a\u0004\b\"\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u001f\u001a\u0004\b'\u0010\u0007R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010$\u001a\u0004\b)\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u001f\u001a\u0004\b+\u0010\u0007R\u0019\u0010\u0014\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u001f\u001a\u0004\b-\u0010\u0007R\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010$\u001a\u0004\b/\u0010\u0004¨\u00062"}, d2 = {"Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyOrderInfoDomain$CompanyDomain;", "", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "component6", "component7", "component8", "price", "priceValue", "productID", "companyID", "title", "titleColor", "iconText", "backgroundColor", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;I)Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyOrderInfoDomain$CompanyDomain;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getPriceValue", "d", "getCompanyID", AuthSource.SEND_ABUSE, "I", "getPrice", "e", "getTitle", "f", "getTitleColor", "c", "getProductID", g.a, "getIconText", "h", "getBackgroundColor", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;I)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class CompanyDomain {
        public final int a;
        @NotNull
        public final String b;
        @NotNull
        public final String c;
        @NotNull
        public final String d;
        @NotNull
        public final String e;
        public final int f;
        @NotNull
        public final String g;
        public final int h;

        public CompanyDomain(int i, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i2, @NotNull String str5, int i3) {
            Intrinsics.checkParameterIsNotNull(str, "priceValue");
            Intrinsics.checkParameterIsNotNull(str2, "productID");
            Intrinsics.checkParameterIsNotNull(str3, "companyID");
            Intrinsics.checkParameterIsNotNull(str4, "title");
            Intrinsics.checkParameterIsNotNull(str5, "iconText");
            this.a = i;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = i2;
            this.g = str5;
            this.h = i3;
        }

        public static /* synthetic */ CompanyDomain copy$default(CompanyDomain companyDomain, int i, String str, String str2, String str3, String str4, int i2, String str5, int i3, int i4, Object obj) {
            return companyDomain.copy((i4 & 1) != 0 ? companyDomain.a : i, (i4 & 2) != 0 ? companyDomain.b : str, (i4 & 4) != 0 ? companyDomain.c : str2, (i4 & 8) != 0 ? companyDomain.d : str3, (i4 & 16) != 0 ? companyDomain.e : str4, (i4 & 32) != 0 ? companyDomain.f : i2, (i4 & 64) != 0 ? companyDomain.g : str5, (i4 & 128) != 0 ? companyDomain.h : i3);
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

        public final int component6() {
            return this.f;
        }

        @NotNull
        public final String component7() {
            return this.g;
        }

        public final int component8() {
            return this.h;
        }

        @NotNull
        public final CompanyDomain copy(int i, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i2, @NotNull String str5, int i3) {
            Intrinsics.checkParameterIsNotNull(str, "priceValue");
            Intrinsics.checkParameterIsNotNull(str2, "productID");
            Intrinsics.checkParameterIsNotNull(str3, "companyID");
            Intrinsics.checkParameterIsNotNull(str4, "title");
            Intrinsics.checkParameterIsNotNull(str5, "iconText");
            return new CompanyDomain(i, str, str2, str3, str4, i2, str5, i3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CompanyDomain)) {
                return false;
            }
            CompanyDomain companyDomain = (CompanyDomain) obj;
            return this.a == companyDomain.a && Intrinsics.areEqual(this.b, companyDomain.b) && Intrinsics.areEqual(this.c, companyDomain.c) && Intrinsics.areEqual(this.d, companyDomain.d) && Intrinsics.areEqual(this.e, companyDomain.e) && this.f == companyDomain.f && Intrinsics.areEqual(this.g, companyDomain.g) && this.h == companyDomain.h;
        }

        public final int getBackgroundColor() {
            return this.h;
        }

        @NotNull
        public final String getCompanyID() {
            return this.d;
        }

        @NotNull
        public final String getIconText() {
            return this.g;
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

        public final int getTitleColor() {
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
            int hashCode4 = (((hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.f) * 31;
            String str5 = this.g;
            if (str5 != null) {
                i2 = str5.hashCode();
            }
            return ((hashCode4 + i2) * 31) + this.h;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("CompanyDomain(price=");
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
            L.append(", iconText=");
            L.append(this.g);
            L.append(", backgroundColor=");
            return a.j(L, this.h, ")");
        }
    }

    public OsagoCompanyOrderInfoDomain(@NotNull String str, long j2, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, int i2, @NotNull String str7, @NotNull String str8, @NotNull List<CompanyDomain> list) {
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

    public static /* synthetic */ OsagoCompanyOrderInfoDomain copy$default(OsagoCompanyOrderInfoDomain osagoCompanyOrderInfoDomain, String str, long j2, String str2, String str3, String str4, String str5, String str6, int i2, String str7, String str8, List list, int i3, Object obj) {
        return osagoCompanyOrderInfoDomain.copy((i3 & 1) != 0 ? osagoCompanyOrderInfoDomain.a : str, (i3 & 2) != 0 ? osagoCompanyOrderInfoDomain.b : j2, (i3 & 4) != 0 ? osagoCompanyOrderInfoDomain.c : str2, (i3 & 8) != 0 ? osagoCompanyOrderInfoDomain.d : str3, (i3 & 16) != 0 ? osagoCompanyOrderInfoDomain.e : str4, (i3 & 32) != 0 ? osagoCompanyOrderInfoDomain.f : str5, (i3 & 64) != 0 ? osagoCompanyOrderInfoDomain.g : str6, (i3 & 128) != 0 ? osagoCompanyOrderInfoDomain.h : i2, (i3 & 256) != 0 ? osagoCompanyOrderInfoDomain.i : str7, (i3 & 512) != 0 ? osagoCompanyOrderInfoDomain.j : str8, (i3 & 1024) != 0 ? osagoCompanyOrderInfoDomain.k : list);
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
    public final List<CompanyDomain> component11() {
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
    public final OsagoCompanyOrderInfoDomain copy(@NotNull String str, long j2, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, int i2, @NotNull String str7, @NotNull String str8, @NotNull List<CompanyDomain> list) {
        Intrinsics.checkParameterIsNotNull(str, "pollingID");
        Intrinsics.checkParameterIsNotNull(str2, "pollingStatus");
        Intrinsics.checkParameterIsNotNull(str7, "priceValue");
        Intrinsics.checkParameterIsNotNull(str8, "url");
        Intrinsics.checkParameterIsNotNull(list, "listCompany");
        return new OsagoCompanyOrderInfoDomain(str, j2, str2, str3, str4, str5, str6, i2, str7, str8, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OsagoCompanyOrderInfoDomain)) {
            return false;
        }
        OsagoCompanyOrderInfoDomain osagoCompanyOrderInfoDomain = (OsagoCompanyOrderInfoDomain) obj;
        return Intrinsics.areEqual(this.a, osagoCompanyOrderInfoDomain.a) && this.b == osagoCompanyOrderInfoDomain.b && Intrinsics.areEqual(this.c, osagoCompanyOrderInfoDomain.c) && Intrinsics.areEqual(this.d, osagoCompanyOrderInfoDomain.d) && Intrinsics.areEqual(this.e, osagoCompanyOrderInfoDomain.e) && Intrinsics.areEqual(this.f, osagoCompanyOrderInfoDomain.f) && Intrinsics.areEqual(this.g, osagoCompanyOrderInfoDomain.g) && this.h == osagoCompanyOrderInfoDomain.h && Intrinsics.areEqual(this.i, osagoCompanyOrderInfoDomain.i) && Intrinsics.areEqual(this.j, osagoCompanyOrderInfoDomain.j) && Intrinsics.areEqual(this.k, osagoCompanyOrderInfoDomain.k);
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
    public final List<CompanyDomain> getListCompany() {
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
        List<CompanyDomain> list = this.k;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode8 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OsagoCompanyOrderInfoDomain(pollingID=");
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
