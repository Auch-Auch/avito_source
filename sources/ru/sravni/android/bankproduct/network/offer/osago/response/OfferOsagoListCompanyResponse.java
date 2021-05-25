package ru.sravni.android.bankproduct.network.offer.osago.response;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.repository.offer.osago.entity.list.OfferOsagoListCompanyRepo;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001:\u0001'B/\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b%\u0010&J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000bJ@\u0010\u0014\u001a\u00020\u00002\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u000bJ\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0011\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\u000bR\u001c\u0010\u0013\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b \u0010\u000bR\u001c\u0010\u0012\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010\u000eR$\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010#\u001a\u0004\b$\u0010\b¨\u0006("}, d2 = {"Lru/sravni/android/bankproduct/network/offer/osago/response/OfferOsagoListCompanyResponse;", "", "Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoListCompanyRepo;", "toOfferOsagoListCompanyRepo", "()Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoListCompanyRepo;", "", "Lru/sravni/android/bankproduct/network/offer/osago/response/OfferOsagoListCompanyResponse$CompanyResponse;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/String;", "", "component3", "()J", "component4", "listCompany", "pollingID", "pollingInterval", "pollingStatus", "copy", "(Ljava/util/List;Ljava/lang/String;JLjava/lang/String;)Lru/sravni/android/bankproduct/network/offer/osago/response/OfferOsagoListCompanyResponse;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getPollingID", "getPollingStatus", "J", "getPollingInterval", "Ljava/util/List;", "getListCompany", "<init>", "(Ljava/util/List;Ljava/lang/String;JLjava/lang/String;)V", "CompanyResponse", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferOsagoListCompanyResponse {
    @SerializedName("items")
    @Nullable
    private final List<CompanyResponse> listCompany;
    @SerializedName("pollingId")
    @NotNull
    private final String pollingID;
    @SerializedName("pollingInterval")
    private final long pollingInterval;
    @SerializedName("pollingStatus")
    @NotNull
    private final String pollingStatus;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001Bg\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u001b\u001a\u00020\u0005\u0012\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0011¢\u0006\u0004\b2\u00103J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0007J\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0001\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00052\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0011HÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0007J\u0010\u0010 \u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b'\u0010\u0007R\u001c\u0010\u001b\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010&\u001a\u0004\b(\u0010\u0007R(\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010)\u001a\u0004\b*\u0010\u0013R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b+\u0010\u0007R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010&\u001a\u0004\b,\u0010\u0007R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010&\u001a\u0004\b-\u0010\u0007R\u001c\u0010\u0015\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010&\u001a\u0004\b.\u0010\u0007R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010/\u001a\u0004\b0\u0010\rR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010&\u001a\u0004\b1\u0010\u0007¨\u00064"}, d2 = {"Lru/sravni/android/bankproduct/network/offer/osago/response/OfferOsagoListCompanyResponse$CompanyResponse;", "", "Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoListCompanyRepo$CompanyRepo;", "toCompanyRepo", "()Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoListCompanyRepo$CompanyRepo;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "", "component5", "()Ljava/lang/Integer;", "component6", "component7", "component8", "", "component9", "()Ljava/util/Map;", "linkText", "productID", "statusDescription", "statusText", "sum", "sumTitle", "sumValue", "status", "requestParams", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lru/sravni/android/bankproduct/network/offer/osago/response/OfferOsagoListCompanyResponse$CompanyResponse;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getStatusText", "getStatus", "Ljava/util/Map;", "getRequestParams", "getStatusDescription", "getLinkText", "getSumValue", "getProductID", "Ljava/lang/Integer;", "getSum", "getSumTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class CompanyResponse {
        @SerializedName("linkText")
        @Nullable
        private final String linkText;
        @SerializedName("productId")
        @NotNull
        private final String productID;
        @SerializedName("requestParams")
        @NotNull
        private final Map<String, String> requestParams;
        @SerializedName("status")
        @NotNull
        private final String status;
        @SerializedName("statusDescription")
        @Nullable
        private final String statusDescription;
        @SerializedName("statusText")
        @Nullable
        private final String statusText;
        @SerializedName("summ")
        @Nullable
        private final Integer sum;
        @SerializedName("summTitle")
        @Nullable
        private final String sumTitle;
        @SerializedName("summValue")
        @Nullable
        private final String sumValue;

        public CompanyResponse(@Nullable String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num, @Nullable String str5, @Nullable String str6, @NotNull String str7, @NotNull Map<String, String> map) {
            Intrinsics.checkParameterIsNotNull(str2, "productID");
            Intrinsics.checkParameterIsNotNull(str7, "status");
            Intrinsics.checkParameterIsNotNull(map, "requestParams");
            this.linkText = str;
            this.productID = str2;
            this.statusDescription = str3;
            this.statusText = str4;
            this.sum = num;
            this.sumTitle = str5;
            this.sumValue = str6;
            this.status = str7;
            this.requestParams = map;
        }

        public static /* synthetic */ CompanyResponse copy$default(CompanyResponse companyResponse, String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, Map map, int i, Object obj) {
            return companyResponse.copy((i & 1) != 0 ? companyResponse.linkText : str, (i & 2) != 0 ? companyResponse.productID : str2, (i & 4) != 0 ? companyResponse.statusDescription : str3, (i & 8) != 0 ? companyResponse.statusText : str4, (i & 16) != 0 ? companyResponse.sum : num, (i & 32) != 0 ? companyResponse.sumTitle : str5, (i & 64) != 0 ? companyResponse.sumValue : str6, (i & 128) != 0 ? companyResponse.status : str7, (i & 256) != 0 ? companyResponse.requestParams : map);
        }

        @Nullable
        public final String component1() {
            return this.linkText;
        }

        @NotNull
        public final String component2() {
            return this.productID;
        }

        @Nullable
        public final String component3() {
            return this.statusDescription;
        }

        @Nullable
        public final String component4() {
            return this.statusText;
        }

        @Nullable
        public final Integer component5() {
            return this.sum;
        }

        @Nullable
        public final String component6() {
            return this.sumTitle;
        }

        @Nullable
        public final String component7() {
            return this.sumValue;
        }

        @NotNull
        public final String component8() {
            return this.status;
        }

        @NotNull
        public final Map<String, String> component9() {
            return this.requestParams;
        }

        @NotNull
        public final CompanyResponse copy(@Nullable String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num, @Nullable String str5, @Nullable String str6, @NotNull String str7, @NotNull Map<String, String> map) {
            Intrinsics.checkParameterIsNotNull(str2, "productID");
            Intrinsics.checkParameterIsNotNull(str7, "status");
            Intrinsics.checkParameterIsNotNull(map, "requestParams");
            return new CompanyResponse(str, str2, str3, str4, num, str5, str6, str7, map);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CompanyResponse)) {
                return false;
            }
            CompanyResponse companyResponse = (CompanyResponse) obj;
            return Intrinsics.areEqual(this.linkText, companyResponse.linkText) && Intrinsics.areEqual(this.productID, companyResponse.productID) && Intrinsics.areEqual(this.statusDescription, companyResponse.statusDescription) && Intrinsics.areEqual(this.statusText, companyResponse.statusText) && Intrinsics.areEqual(this.sum, companyResponse.sum) && Intrinsics.areEqual(this.sumTitle, companyResponse.sumTitle) && Intrinsics.areEqual(this.sumValue, companyResponse.sumValue) && Intrinsics.areEqual(this.status, companyResponse.status) && Intrinsics.areEqual(this.requestParams, companyResponse.requestParams);
        }

        @Nullable
        public final String getLinkText() {
            return this.linkText;
        }

        @NotNull
        public final String getProductID() {
            return this.productID;
        }

        @NotNull
        public final Map<String, String> getRequestParams() {
            return this.requestParams;
        }

        @NotNull
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        public final String getStatusDescription() {
            return this.statusDescription;
        }

        @Nullable
        public final String getStatusText() {
            return this.statusText;
        }

        @Nullable
        public final Integer getSum() {
            return this.sum;
        }

        @Nullable
        public final String getSumTitle() {
            return this.sumTitle;
        }

        @Nullable
        public final String getSumValue() {
            return this.sumValue;
        }

        public int hashCode() {
            String str = this.linkText;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.productID;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.statusDescription;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.statusText;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            Integer num = this.sum;
            int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 31;
            String str5 = this.sumTitle;
            int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.sumValue;
            int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
            String str7 = this.status;
            int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
            Map<String, String> map = this.requestParams;
            if (map != null) {
                i = map.hashCode();
            }
            return hashCode8 + i;
        }

        @NotNull
        public final OfferOsagoListCompanyRepo.CompanyRepo toCompanyRepo() {
            String str = this.productID;
            Integer num = this.sum;
            String str2 = this.sumTitle;
            String str3 = this.sumValue;
            String str4 = this.status;
            String str5 = this.statusText;
            return new OfferOsagoListCompanyRepo.CompanyRepo(str, num, str2, str3, this.linkText, str4, this.statusDescription, str5, this.requestParams);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("CompanyResponse(linkText=");
            L.append(this.linkText);
            L.append(", productID=");
            L.append(this.productID);
            L.append(", statusDescription=");
            L.append(this.statusDescription);
            L.append(", statusText=");
            L.append(this.statusText);
            L.append(", sum=");
            L.append(this.sum);
            L.append(", sumTitle=");
            L.append(this.sumTitle);
            L.append(", sumValue=");
            L.append(this.sumValue);
            L.append(", status=");
            L.append(this.status);
            L.append(", requestParams=");
            return a.x(L, this.requestParams, ")");
        }
    }

    public OfferOsagoListCompanyResponse(@Nullable List<CompanyResponse> list, @NotNull String str, long j, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "pollingID");
        Intrinsics.checkParameterIsNotNull(str2, "pollingStatus");
        this.listCompany = list;
        this.pollingID = str;
        this.pollingInterval = j;
        this.pollingStatus = str2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: ru.sravni.android.bankproduct.network.offer.osago.response.OfferOsagoListCompanyResponse */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfferOsagoListCompanyResponse copy$default(OfferOsagoListCompanyResponse offerOsagoListCompanyResponse, List list, String str, long j, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = offerOsagoListCompanyResponse.listCompany;
        }
        if ((i & 2) != 0) {
            str = offerOsagoListCompanyResponse.pollingID;
        }
        if ((i & 4) != 0) {
            j = offerOsagoListCompanyResponse.pollingInterval;
        }
        if ((i & 8) != 0) {
            str2 = offerOsagoListCompanyResponse.pollingStatus;
        }
        return offerOsagoListCompanyResponse.copy(list, str, j, str2);
    }

    @Nullable
    public final List<CompanyResponse> component1() {
        return this.listCompany;
    }

    @NotNull
    public final String component2() {
        return this.pollingID;
    }

    public final long component3() {
        return this.pollingInterval;
    }

    @NotNull
    public final String component4() {
        return this.pollingStatus;
    }

    @NotNull
    public final OfferOsagoListCompanyResponse copy(@Nullable List<CompanyResponse> list, @NotNull String str, long j, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "pollingID");
        Intrinsics.checkParameterIsNotNull(str2, "pollingStatus");
        return new OfferOsagoListCompanyResponse(list, str, j, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferOsagoListCompanyResponse)) {
            return false;
        }
        OfferOsagoListCompanyResponse offerOsagoListCompanyResponse = (OfferOsagoListCompanyResponse) obj;
        return Intrinsics.areEqual(this.listCompany, offerOsagoListCompanyResponse.listCompany) && Intrinsics.areEqual(this.pollingID, offerOsagoListCompanyResponse.pollingID) && this.pollingInterval == offerOsagoListCompanyResponse.pollingInterval && Intrinsics.areEqual(this.pollingStatus, offerOsagoListCompanyResponse.pollingStatus);
    }

    @Nullable
    public final List<CompanyResponse> getListCompany() {
        return this.listCompany;
    }

    @NotNull
    public final String getPollingID() {
        return this.pollingID;
    }

    public final long getPollingInterval() {
        return this.pollingInterval;
    }

    @NotNull
    public final String getPollingStatus() {
        return this.pollingStatus;
    }

    public int hashCode() {
        List<CompanyResponse> list = this.listCompany;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.pollingID;
        int hashCode2 = (((hashCode + (str != null ? str.hashCode() : 0)) * 31) + c.a(this.pollingInterval)) * 31;
        String str2 = this.pollingStatus;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public final OfferOsagoListCompanyRepo toOfferOsagoListCompanyRepo() {
        String str = this.pollingID;
        long j = this.pollingInterval;
        String str2 = this.pollingStatus;
        List<CompanyResponse> list = this.listCompany;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toCompanyRepo());
        }
        return new OfferOsagoListCompanyRepo(arrayList, str, j, str2);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferOsagoListCompanyResponse(listCompany=");
        L.append(this.listCompany);
        L.append(", pollingID=");
        L.append(this.pollingID);
        L.append(", pollingInterval=");
        L.append(this.pollingInterval);
        L.append(", pollingStatus=");
        return a.t(L, this.pollingStatus, ")");
    }
}
