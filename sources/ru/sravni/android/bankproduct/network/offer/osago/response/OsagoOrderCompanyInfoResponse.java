package ru.sravni.android.bankproduct.network.offer.osago.response;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.repository.offer.osago.entity.order.OsagoCompanyOrderInfoRepo;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0017"}, d2 = {"Lru/sravni/android/bankproduct/network/offer/osago/response/OsagoOrderCompanyInfoResponse;", "", "Lru/sravni/android/bankproduct/network/offer/osago/response/OsagoOrderCompanyInfoResponse$Item;", "component1", "()Lru/sravni/android/bankproduct/network/offer/osago/response/OsagoOrderCompanyInfoResponse$Item;", "item", "copy", "(Lru/sravni/android/bankproduct/network/offer/osago/response/OsagoOrderCompanyInfoResponse$Item;)Lru/sravni/android/bankproduct/network/offer/osago/response/OsagoOrderCompanyInfoResponse;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lru/sravni/android/bankproduct/network/offer/osago/response/OsagoOrderCompanyInfoResponse$Item;", "getItem", "<init>", "(Lru/sravni/android/bankproduct/network/offer/osago/response/OsagoOrderCompanyInfoResponse$Item;)V", "Item", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OsagoOrderCompanyInfoResponse {
    @SerializedName("item")
    @NotNull
    private final Item item;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0015\b\b\u0018\u00002\u00020\u0001:\u0001=Bs\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\b\u0012\u0006\u0010\u001b\u001a\u00020\u000b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u001d\u001a\u00020\u0005\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015¢\u0006\u0004\b;\u0010<J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0007J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0007J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0007J\u0018\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0001\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015HÆ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b&\u0010\u0007J\u0010\u0010'\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b'\u0010\rJ\u001a\u0010*\u001a\u00020)2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b*\u0010+R\u001e\u0010\"\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\"\u0010,\u001a\u0004\b-\u0010\u0007R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010,\u001a\u0004\b.\u0010\u0007R\u001c\u0010\u001b\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010/\u001a\u0004\b0\u0010\rR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010,\u001a\u0004\b1\u0010\u0007R\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u0010,\u001a\u0004\b2\u0010\u0007R\u001e\u0010 \u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b \u0010,\u001a\u0004\b3\u0010\u0007R\u001c\u0010\u001a\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u00104\u001a\u0004\b5\u0010\nR$\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b#\u00106\u001a\u0004\b7\u0010\u0018R\u001c\u0010\u0019\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010,\u001a\u0004\b8\u0010\u0007R\u001c\u0010\u001d\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010,\u001a\u0004\b9\u0010\u0007R\u001e\u0010!\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b!\u0010,\u001a\u0004\b:\u0010\u0007¨\u0006>"}, d2 = {"Lru/sravni/android/bankproduct/network/offer/osago/response/OsagoOrderCompanyInfoResponse$Item;", "", "Lru/sravni/android/bankproduct/repository/offer/osago/entity/order/OsagoCompanyOrderInfoRepo;", "toOsagoOrderCompanyInfoRepo", "()Lru/sravni/android/bankproduct/repository/offer/osago/entity/order/OsagoCompanyOrderInfoRepo;", "", "component1", "()Ljava/lang/String;", "", "component2", "()J", "", "component3", "()I", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "", "Lru/sravni/android/bankproduct/network/offer/osago/response/OsagoOrderCompanyInfoResponse$Item$CompanyResponse;", "component11", "()Ljava/util/List;", "pollingId", "pollingInterval", "price", "priceValue", "status", "textTitle", "comparisonText", "comparisonPrice", "text", "url", "variants", "copy", "(Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lru/sravni/android/bankproduct/network/offer/osago/response/OsagoOrderCompanyInfoResponse$Item;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUrl", "getPriceValue", "I", "getPrice", "getTextTitle", "getComparisonText", "getComparisonPrice", "J", "getPollingInterval", "Ljava/util/List;", "getVariants", "getPollingId", "getStatus", "getText", "<init>", "(Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "CompanyResponse", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class Item {
        @SerializedName("comparisonPrice")
        @Nullable
        private final String comparisonPrice;
        @SerializedName("comparisonText")
        @Nullable
        private final String comparisonText;
        @SerializedName("pollingId")
        @NotNull
        private final String pollingId;
        @SerializedName("pollingInterval")
        private final long pollingInterval;
        @SerializedName("price")
        private final int price;
        @SerializedName("priceValue")
        @Nullable
        private final String priceValue;
        @SerializedName("status")
        @NotNull
        private final String status;
        @SerializedName("text")
        @Nullable
        private final String text;
        @SerializedName("textTitle")
        @Nullable
        private final String textTitle;
        @SerializedName("url")
        @Nullable
        private final String url;
        @SerializedName("variants")
        @Nullable
        private final List<CompanyResponse> variants;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b(\u0010)J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\r\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007JV\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0007J\u0010\u0010\u001a\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u000bJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0012\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b \u0010\u000bR\u001c\u0010\u0010\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010\u0007R\u001c\u0010\u0014\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b#\u0010\u0007R\u001c\u0010\u0013\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b$\u0010\u0007R\u001c\u0010\u0015\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010!\u001a\u0004\b%\u0010\u0007R\u001c\u0010\u0016\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010!\u001a\u0004\b&\u0010\u0007R\u001c\u0010\u0011\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b'\u0010\u0007¨\u0006*"}, d2 = {"Lru/sravni/android/bankproduct/network/offer/osago/response/OsagoOrderCompanyInfoResponse$Item$CompanyResponse;", "", "Lru/sravni/android/bankproduct/repository/offer/osago/entity/order/OsagoCompanyOrderInfoRepo$CompanyRepo;", "toCompanyRepo", "()Lru/sravni/android/bankproduct/repository/offer/osago/entity/order/OsagoCompanyOrderInfoRepo$CompanyRepo;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()I", "component4", "component5", "component6", "component7", "backgroundColor", "companyId", "price", "priceValue", "productId", "title", "titleColor", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/network/offer/osago/response/OsagoOrderCompanyInfoResponse$Item$CompanyResponse;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getPrice", "Ljava/lang/String;", "getBackgroundColor", "getProductId", "getPriceValue", "getTitle", "getTitleColor", "getCompanyId", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
        public static final class CompanyResponse {
            @SerializedName("backgroundColor")
            @NotNull
            private final String backgroundColor;
            @SerializedName("companyId")
            @NotNull
            private final String companyId;
            @SerializedName("price")
            private final int price;
            @SerializedName("priceValue")
            @NotNull
            private final String priceValue;
            @SerializedName("productId")
            @NotNull
            private final String productId;
            @SerializedName("title")
            @NotNull
            private final String title;
            @SerializedName("titleColor")
            @NotNull
            private final String titleColor;

            public CompanyResponse(@NotNull String str, @NotNull String str2, int i, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
                Intrinsics.checkParameterIsNotNull(str, "backgroundColor");
                Intrinsics.checkParameterIsNotNull(str2, "companyId");
                Intrinsics.checkParameterIsNotNull(str3, "priceValue");
                Intrinsics.checkParameterIsNotNull(str4, "productId");
                Intrinsics.checkParameterIsNotNull(str5, "title");
                Intrinsics.checkParameterIsNotNull(str6, "titleColor");
                this.backgroundColor = str;
                this.companyId = str2;
                this.price = i;
                this.priceValue = str3;
                this.productId = str4;
                this.title = str5;
                this.titleColor = str6;
            }

            public static /* synthetic */ CompanyResponse copy$default(CompanyResponse companyResponse, String str, String str2, int i, String str3, String str4, String str5, String str6, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = companyResponse.backgroundColor;
                }
                if ((i2 & 2) != 0) {
                    str2 = companyResponse.companyId;
                }
                if ((i2 & 4) != 0) {
                    i = companyResponse.price;
                }
                if ((i2 & 8) != 0) {
                    str3 = companyResponse.priceValue;
                }
                if ((i2 & 16) != 0) {
                    str4 = companyResponse.productId;
                }
                if ((i2 & 32) != 0) {
                    str5 = companyResponse.title;
                }
                if ((i2 & 64) != 0) {
                    str6 = companyResponse.titleColor;
                }
                return companyResponse.copy(str, str2, i, str3, str4, str5, str6);
            }

            @NotNull
            public final String component1() {
                return this.backgroundColor;
            }

            @NotNull
            public final String component2() {
                return this.companyId;
            }

            public final int component3() {
                return this.price;
            }

            @NotNull
            public final String component4() {
                return this.priceValue;
            }

            @NotNull
            public final String component5() {
                return this.productId;
            }

            @NotNull
            public final String component6() {
                return this.title;
            }

            @NotNull
            public final String component7() {
                return this.titleColor;
            }

            @NotNull
            public final CompanyResponse copy(@NotNull String str, @NotNull String str2, int i, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
                Intrinsics.checkParameterIsNotNull(str, "backgroundColor");
                Intrinsics.checkParameterIsNotNull(str2, "companyId");
                Intrinsics.checkParameterIsNotNull(str3, "priceValue");
                Intrinsics.checkParameterIsNotNull(str4, "productId");
                Intrinsics.checkParameterIsNotNull(str5, "title");
                Intrinsics.checkParameterIsNotNull(str6, "titleColor");
                return new CompanyResponse(str, str2, i, str3, str4, str5, str6);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof CompanyResponse)) {
                    return false;
                }
                CompanyResponse companyResponse = (CompanyResponse) obj;
                return Intrinsics.areEqual(this.backgroundColor, companyResponse.backgroundColor) && Intrinsics.areEqual(this.companyId, companyResponse.companyId) && this.price == companyResponse.price && Intrinsics.areEqual(this.priceValue, companyResponse.priceValue) && Intrinsics.areEqual(this.productId, companyResponse.productId) && Intrinsics.areEqual(this.title, companyResponse.title) && Intrinsics.areEqual(this.titleColor, companyResponse.titleColor);
            }

            @NotNull
            public final String getBackgroundColor() {
                return this.backgroundColor;
            }

            @NotNull
            public final String getCompanyId() {
                return this.companyId;
            }

            public final int getPrice() {
                return this.price;
            }

            @NotNull
            public final String getPriceValue() {
                return this.priceValue;
            }

            @NotNull
            public final String getProductId() {
                return this.productId;
            }

            @NotNull
            public final String getTitle() {
                return this.title;
            }

            @NotNull
            public final String getTitleColor() {
                return this.titleColor;
            }

            public int hashCode() {
                String str = this.backgroundColor;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.companyId;
                int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.price) * 31;
                String str3 = this.priceValue;
                int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
                String str4 = this.productId;
                int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
                String str5 = this.title;
                int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
                String str6 = this.titleColor;
                if (str6 != null) {
                    i = str6.hashCode();
                }
                return hashCode5 + i;
            }

            @NotNull
            public final OsagoCompanyOrderInfoRepo.CompanyRepo toCompanyRepo() {
                return new OsagoCompanyOrderInfoRepo.CompanyRepo(this.price, this.priceValue, this.productId, this.companyId, this.title, this.titleColor, this.backgroundColor);
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("CompanyResponse(backgroundColor=");
                L.append(this.backgroundColor);
                L.append(", companyId=");
                L.append(this.companyId);
                L.append(", price=");
                L.append(this.price);
                L.append(", priceValue=");
                L.append(this.priceValue);
                L.append(", productId=");
                L.append(this.productId);
                L.append(", title=");
                L.append(this.title);
                L.append(", titleColor=");
                return a.t(L, this.titleColor, ")");
            }
        }

        public Item(@NotNull String str, long j, int i, @Nullable String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable List<CompanyResponse> list) {
            Intrinsics.checkParameterIsNotNull(str, "pollingId");
            Intrinsics.checkParameterIsNotNull(str3, "status");
            this.pollingId = str;
            this.pollingInterval = j;
            this.price = i;
            this.priceValue = str2;
            this.status = str3;
            this.textTitle = str4;
            this.comparisonText = str5;
            this.comparisonPrice = str6;
            this.text = str7;
            this.url = str8;
            this.variants = list;
        }

        public static /* synthetic */ Item copy$default(Item item, String str, long j, int i, String str2, String str3, String str4, String str5, String str6, String str7, String str8, List list, int i2, Object obj) {
            return item.copy((i2 & 1) != 0 ? item.pollingId : str, (i2 & 2) != 0 ? item.pollingInterval : j, (i2 & 4) != 0 ? item.price : i, (i2 & 8) != 0 ? item.priceValue : str2, (i2 & 16) != 0 ? item.status : str3, (i2 & 32) != 0 ? item.textTitle : str4, (i2 & 64) != 0 ? item.comparisonText : str5, (i2 & 128) != 0 ? item.comparisonPrice : str6, (i2 & 256) != 0 ? item.text : str7, (i2 & 512) != 0 ? item.url : str8, (i2 & 1024) != 0 ? item.variants : list);
        }

        @NotNull
        public final String component1() {
            return this.pollingId;
        }

        @Nullable
        public final String component10() {
            return this.url;
        }

        @Nullable
        public final List<CompanyResponse> component11() {
            return this.variants;
        }

        public final long component2() {
            return this.pollingInterval;
        }

        public final int component3() {
            return this.price;
        }

        @Nullable
        public final String component4() {
            return this.priceValue;
        }

        @NotNull
        public final String component5() {
            return this.status;
        }

        @Nullable
        public final String component6() {
            return this.textTitle;
        }

        @Nullable
        public final String component7() {
            return this.comparisonText;
        }

        @Nullable
        public final String component8() {
            return this.comparisonPrice;
        }

        @Nullable
        public final String component9() {
            return this.text;
        }

        @NotNull
        public final Item copy(@NotNull String str, long j, int i, @Nullable String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable List<CompanyResponse> list) {
            Intrinsics.checkParameterIsNotNull(str, "pollingId");
            Intrinsics.checkParameterIsNotNull(str3, "status");
            return new Item(str, j, i, str2, str3, str4, str5, str6, str7, str8, list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Item)) {
                return false;
            }
            Item item = (Item) obj;
            return Intrinsics.areEqual(this.pollingId, item.pollingId) && this.pollingInterval == item.pollingInterval && this.price == item.price && Intrinsics.areEqual(this.priceValue, item.priceValue) && Intrinsics.areEqual(this.status, item.status) && Intrinsics.areEqual(this.textTitle, item.textTitle) && Intrinsics.areEqual(this.comparisonText, item.comparisonText) && Intrinsics.areEqual(this.comparisonPrice, item.comparisonPrice) && Intrinsics.areEqual(this.text, item.text) && Intrinsics.areEqual(this.url, item.url) && Intrinsics.areEqual(this.variants, item.variants);
        }

        @Nullable
        public final String getComparisonPrice() {
            return this.comparisonPrice;
        }

        @Nullable
        public final String getComparisonText() {
            return this.comparisonText;
        }

        @NotNull
        public final String getPollingId() {
            return this.pollingId;
        }

        public final long getPollingInterval() {
            return this.pollingInterval;
        }

        public final int getPrice() {
            return this.price;
        }

        @Nullable
        public final String getPriceValue() {
            return this.priceValue;
        }

        @NotNull
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        public final String getText() {
            return this.text;
        }

        @Nullable
        public final String getTextTitle() {
            return this.textTitle;
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        public final List<CompanyResponse> getVariants() {
            return this.variants;
        }

        public int hashCode() {
            String str = this.pollingId;
            int i = 0;
            int hashCode = (((((str != null ? str.hashCode() : 0) * 31) + c.a(this.pollingInterval)) * 31) + this.price) * 31;
            String str2 = this.priceValue;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.status;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.textTitle;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.comparisonText;
            int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.comparisonPrice;
            int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
            String str7 = this.text;
            int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
            String str8 = this.url;
            int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
            List<CompanyResponse> list = this.variants;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode8 + i;
        }

        @NotNull
        public final OsagoCompanyOrderInfoRepo toOsagoOrderCompanyInfoRepo() {
            String str;
            ArrayList arrayList;
            String str2 = this.pollingId;
            long j = this.pollingInterval;
            String str3 = this.status;
            int i = this.price;
            String str4 = this.priceValue;
            String str5 = str4 != null ? str4 : "";
            String str6 = this.textTitle;
            String str7 = this.comparisonText;
            String str8 = this.comparisonPrice;
            String str9 = this.text;
            String str10 = this.url;
            if (str10 != null) {
                str = str10;
            } else {
                str = "";
            }
            List<CompanyResponse> list = this.variants;
            if (list != null) {
                ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList2.add(it.next().toCompanyRepo());
                }
                arrayList = arrayList2;
            } else {
                arrayList = CollectionsKt__CollectionsKt.emptyList();
            }
            return new OsagoCompanyOrderInfoRepo(str2, j, str3, str6, str7, str8, str9, i, str5, str, arrayList);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Item(pollingId=");
            L.append(this.pollingId);
            L.append(", pollingInterval=");
            L.append(this.pollingInterval);
            L.append(", price=");
            L.append(this.price);
            L.append(", priceValue=");
            L.append(this.priceValue);
            L.append(", status=");
            L.append(this.status);
            L.append(", textTitle=");
            L.append(this.textTitle);
            L.append(", comparisonText=");
            L.append(this.comparisonText);
            L.append(", comparisonPrice=");
            L.append(this.comparisonPrice);
            L.append(", text=");
            L.append(this.text);
            L.append(", url=");
            L.append(this.url);
            L.append(", variants=");
            return a.w(L, this.variants, ")");
        }
    }

    public OsagoOrderCompanyInfoResponse(@NotNull Item item2) {
        Intrinsics.checkParameterIsNotNull(item2, "item");
        this.item = item2;
    }

    public static /* synthetic */ OsagoOrderCompanyInfoResponse copy$default(OsagoOrderCompanyInfoResponse osagoOrderCompanyInfoResponse, Item item2, int i, Object obj) {
        if ((i & 1) != 0) {
            item2 = osagoOrderCompanyInfoResponse.item;
        }
        return osagoOrderCompanyInfoResponse.copy(item2);
    }

    @NotNull
    public final Item component1() {
        return this.item;
    }

    @NotNull
    public final OsagoOrderCompanyInfoResponse copy(@NotNull Item item2) {
        Intrinsics.checkParameterIsNotNull(item2, "item");
        return new OsagoOrderCompanyInfoResponse(item2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof OsagoOrderCompanyInfoResponse) && Intrinsics.areEqual(this.item, ((OsagoOrderCompanyInfoResponse) obj).item);
        }
        return true;
    }

    @NotNull
    public final Item getItem() {
        return this.item;
    }

    public int hashCode() {
        Item item2 = this.item;
        if (item2 != null) {
            return item2.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OsagoOrderCompanyInfoResponse(item=");
        L.append(this.item);
        L.append(")");
        return L.toString();
    }
}
