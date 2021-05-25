package ru.sravni.android.bankproduct.network.offer.osago.response;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.network.offer.entity.response.OfferFilterResponse;
import ru.sravni.android.bankproduct.repository.offer.osago.entity.list.OfferOsagoListRepo;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0017"}, d2 = {"Lru/sravni/android/bankproduct/network/offer/osago/response/OfferOsagoListResponse;", "", "Lru/sravni/android/bankproduct/network/offer/osago/response/OfferOsagoListResponse$Item;", "component1", "()Lru/sravni/android/bankproduct/network/offer/osago/response/OfferOsagoListResponse$Item;", "item", "copy", "(Lru/sravni/android/bankproduct/network/offer/osago/response/OfferOsagoListResponse$Item;)Lru/sravni/android/bankproduct/network/offer/osago/response/OfferOsagoListResponse;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lru/sravni/android/bankproduct/network/offer/osago/response/OfferOsagoListResponse$Item;", "getItem", "<init>", "(Lru/sravni/android/bankproduct/network/offer/osago/response/OfferOsagoListResponse$Item;)V", "Item", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferOsagoListResponse {
    @SerializedName("item")
    @NotNull
    private final Item item;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001:\u00014BS\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\n\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u000f¢\u0006\u0004\b2\u00103J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u000fHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0012Jl\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00052\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u000fHÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0007J\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b%\u0010&R\u001c\u0010\u0017\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010'\u001a\u0004\b(\u0010\u0007R\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010)\u001a\u0004\b*\u0010\u0012R\u001c\u0010\u0015\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010'\u001a\u0004\b+\u0010\u0007R\u001c\u0010\u0019\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010'\u001a\u0004\b,\u0010\u0007R\"\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u000f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010)\u001a\u0004\b-\u0010\u0012R\u001c\u0010\u0018\u001a\u00020\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010.\u001a\u0004\b/\u0010\fR\u001c\u0010\u0016\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010'\u001a\u0004\b0\u0010\u0007R\u001c\u0010\u001a\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010'\u001a\u0004\b1\u0010\u0007¨\u00065"}, d2 = {"Lru/sravni/android/bankproduct/network/offer/osago/response/OfferOsagoListResponse$Item;", "", "Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoListRepo;", "toOfferOsagoListRepo", "()Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoListRepo;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()J", "component5", "component6", "", "Lru/sravni/android/bankproduct/network/offer/osago/response/OfferOsagoListResponse$Item$OfferGroupResponse;", "component7", "()Ljava/util/List;", "Lru/sravni/android/bankproduct/network/offer/entity/response/OfferFilterResponse;", "component8", "mainTitle", "recommendedDate", "pollingID", "pollingInterval", "savedSearchID", "conversationID", "offerGroups", "filters", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Lru/sravni/android/bankproduct/network/offer/osago/response/OfferOsagoListResponse$Item;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getPollingID", "Ljava/util/List;", "getOfferGroups", "getMainTitle", "getSavedSearchID", "getFilters", "J", "getPollingInterval", "getRecommendedDate", "getConversationID", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "OfferGroupResponse", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class Item {
        @SerializedName(AnalyticFieldsName.conversationID)
        @NotNull
        private final String conversationID;
        @SerializedName("filters")
        @NotNull
        private final List<OfferFilterResponse> filters;
        @SerializedName("mainTitle")
        @NotNull
        private final String mainTitle;
        @SerializedName("offerGroups")
        @NotNull
        private final List<OfferGroupResponse> offerGroups;
        @SerializedName("pollingId")
        @NotNull
        private final String pollingID;
        @SerializedName("pollingInterval")
        private final long pollingInterval;
        @SerializedName("recommendedDate")
        @NotNull
        private final String recommendedDate;
        @SerializedName("savedSearchId")
        @NotNull
        private final String savedSearchID;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001:\u0001!B)\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001f\u0010 J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J8\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0007J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001c\u0010\u0007R\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u000b¨\u0006\""}, d2 = {"Lru/sravni/android/bankproduct/network/offer/osago/response/OfferOsagoListResponse$Item$OfferGroupResponse;", "", "Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoListRepo$OfferGroupRepo;", "toOfferOsagoListGroupRepo", "()Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoListRepo$OfferGroupRepo;", "", "component1", "()Ljava/lang/String;", "", "Lru/sravni/android/bankproduct/network/offer/osago/response/OfferOsagoListResponse$Item$OfferGroupResponse$OfferResponse;", "component2", "()Ljava/util/List;", "component3", "typeGroup", "offerList", "titleGroup", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lru/sravni/android/bankproduct/network/offer/osago/response/OfferOsagoListResponse$Item$OfferGroupResponse;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTypeGroup", "getTitleGroup", "Ljava/util/List;", "getOfferList", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "OfferResponse", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
        public static final class OfferGroupResponse {
            @SerializedName("offerList")
            @NotNull
            private final List<OfferResponse> offerList;
            @SerializedName("title")
            @Nullable
            private final String titleGroup;
            @SerializedName("blockType")
            @Nullable
            private final String typeGroup;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ.\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0011\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\r\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\nR\u001c\u0010\u000e\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001b\u0010\nR\u001c\u0010\f\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007¨\u0006 "}, d2 = {"Lru/sravni/android/bankproduct/network/offer/osago/response/OfferOsagoListResponse$Item$OfferGroupResponse$OfferResponse;", "", "Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoListRepo$OfferGroupRepo$OfferRepo;", "toOfferOsagoListOfferRepo", "()Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoListRepo$OfferGroupRepo$OfferRepo;", "Lru/sravni/android/bankproduct/network/offer/osago/response/OfferOsagoDisplaySettingsResponse;", "component1", "()Lru/sravni/android/bankproduct/network/offer/osago/response/OfferOsagoDisplaySettingsResponse;", "", "component2", "()Ljava/lang/String;", "component3", "displaySettings", "productID", "productType", "copy", "(Lru/sravni/android/bankproduct/network/offer/osago/response/OfferOsagoDisplaySettingsResponse;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/network/offer/osago/response/OfferOsagoListResponse$Item$OfferGroupResponse$OfferResponse;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getProductID", "getProductType", "Lru/sravni/android/bankproduct/network/offer/osago/response/OfferOsagoDisplaySettingsResponse;", "getDisplaySettings", "<init>", "(Lru/sravni/android/bankproduct/network/offer/osago/response/OfferOsagoDisplaySettingsResponse;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
            public static final class OfferResponse {
                @SerializedName("displaySettings")
                @NotNull
                private final OfferOsagoDisplaySettingsResponse displaySettings;
                @SerializedName("productId")
                @NotNull
                private final String productID;
                @SerializedName("productType")
                @NotNull
                private final String productType;

                public OfferResponse(@NotNull OfferOsagoDisplaySettingsResponse offerOsagoDisplaySettingsResponse, @NotNull String str, @NotNull String str2) {
                    Intrinsics.checkParameterIsNotNull(offerOsagoDisplaySettingsResponse, "displaySettings");
                    Intrinsics.checkParameterIsNotNull(str, "productID");
                    Intrinsics.checkParameterIsNotNull(str2, "productType");
                    this.displaySettings = offerOsagoDisplaySettingsResponse;
                    this.productID = str;
                    this.productType = str2;
                }

                public static /* synthetic */ OfferResponse copy$default(OfferResponse offerResponse, OfferOsagoDisplaySettingsResponse offerOsagoDisplaySettingsResponse, String str, String str2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        offerOsagoDisplaySettingsResponse = offerResponse.displaySettings;
                    }
                    if ((i & 2) != 0) {
                        str = offerResponse.productID;
                    }
                    if ((i & 4) != 0) {
                        str2 = offerResponse.productType;
                    }
                    return offerResponse.copy(offerOsagoDisplaySettingsResponse, str, str2);
                }

                @NotNull
                public final OfferOsagoDisplaySettingsResponse component1() {
                    return this.displaySettings;
                }

                @NotNull
                public final String component2() {
                    return this.productID;
                }

                @NotNull
                public final String component3() {
                    return this.productType;
                }

                @NotNull
                public final OfferResponse copy(@NotNull OfferOsagoDisplaySettingsResponse offerOsagoDisplaySettingsResponse, @NotNull String str, @NotNull String str2) {
                    Intrinsics.checkParameterIsNotNull(offerOsagoDisplaySettingsResponse, "displaySettings");
                    Intrinsics.checkParameterIsNotNull(str, "productID");
                    Intrinsics.checkParameterIsNotNull(str2, "productType");
                    return new OfferResponse(offerOsagoDisplaySettingsResponse, str, str2);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof OfferResponse)) {
                        return false;
                    }
                    OfferResponse offerResponse = (OfferResponse) obj;
                    return Intrinsics.areEqual(this.displaySettings, offerResponse.displaySettings) && Intrinsics.areEqual(this.productID, offerResponse.productID) && Intrinsics.areEqual(this.productType, offerResponse.productType);
                }

                @NotNull
                public final OfferOsagoDisplaySettingsResponse getDisplaySettings() {
                    return this.displaySettings;
                }

                @NotNull
                public final String getProductID() {
                    return this.productID;
                }

                @NotNull
                public final String getProductType() {
                    return this.productType;
                }

                public int hashCode() {
                    OfferOsagoDisplaySettingsResponse offerOsagoDisplaySettingsResponse = this.displaySettings;
                    int i = 0;
                    int hashCode = (offerOsagoDisplaySettingsResponse != null ? offerOsagoDisplaySettingsResponse.hashCode() : 0) * 31;
                    String str = this.productID;
                    int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
                    String str2 = this.productType;
                    if (str2 != null) {
                        i = str2.hashCode();
                    }
                    return hashCode2 + i;
                }

                @NotNull
                public final OfferOsagoListRepo.OfferGroupRepo.OfferRepo toOfferOsagoListOfferRepo() {
                    return new OfferOsagoListRepo.OfferGroupRepo.OfferRepo(this.displaySettings.toOfferOsagoDisplaySettingsRepo(), this.productID, this.productType);
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a.L("OfferResponse(displaySettings=");
                    L.append(this.displaySettings);
                    L.append(", productID=");
                    L.append(this.productID);
                    L.append(", productType=");
                    return a.t(L, this.productType, ")");
                }
            }

            public OfferGroupResponse(@Nullable String str, @NotNull List<OfferResponse> list, @Nullable String str2) {
                Intrinsics.checkParameterIsNotNull(list, "offerList");
                this.typeGroup = str;
                this.offerList = list;
                this.titleGroup = str2;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.network.offer.osago.response.OfferOsagoListResponse$Item$OfferGroupResponse */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ OfferGroupResponse copy$default(OfferGroupResponse offerGroupResponse, String str, List list, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = offerGroupResponse.typeGroup;
                }
                if ((i & 2) != 0) {
                    list = offerGroupResponse.offerList;
                }
                if ((i & 4) != 0) {
                    str2 = offerGroupResponse.titleGroup;
                }
                return offerGroupResponse.copy(str, list, str2);
            }

            @Nullable
            public final String component1() {
                return this.typeGroup;
            }

            @NotNull
            public final List<OfferResponse> component2() {
                return this.offerList;
            }

            @Nullable
            public final String component3() {
                return this.titleGroup;
            }

            @NotNull
            public final OfferGroupResponse copy(@Nullable String str, @NotNull List<OfferResponse> list, @Nullable String str2) {
                Intrinsics.checkParameterIsNotNull(list, "offerList");
                return new OfferGroupResponse(str, list, str2);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof OfferGroupResponse)) {
                    return false;
                }
                OfferGroupResponse offerGroupResponse = (OfferGroupResponse) obj;
                return Intrinsics.areEqual(this.typeGroup, offerGroupResponse.typeGroup) && Intrinsics.areEqual(this.offerList, offerGroupResponse.offerList) && Intrinsics.areEqual(this.titleGroup, offerGroupResponse.titleGroup);
            }

            @NotNull
            public final List<OfferResponse> getOfferList() {
                return this.offerList;
            }

            @Nullable
            public final String getTitleGroup() {
                return this.titleGroup;
            }

            @Nullable
            public final String getTypeGroup() {
                return this.typeGroup;
            }

            public int hashCode() {
                String str = this.typeGroup;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                List<OfferResponse> list = this.offerList;
                int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
                String str2 = this.titleGroup;
                if (str2 != null) {
                    i = str2.hashCode();
                }
                return hashCode2 + i;
            }

            @NotNull
            public final OfferOsagoListRepo.OfferGroupRepo toOfferOsagoListGroupRepo() {
                String str = this.titleGroup;
                String str2 = this.typeGroup;
                List<OfferResponse> list = this.offerList;
                ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().toOfferOsagoListOfferRepo());
                }
                return new OfferOsagoListRepo.OfferGroupRepo(str, str2, arrayList);
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("OfferGroupResponse(typeGroup=");
                L.append(this.typeGroup);
                L.append(", offerList=");
                L.append(this.offerList);
                L.append(", titleGroup=");
                return a.t(L, this.titleGroup, ")");
            }
        }

        public Item(@NotNull String str, @NotNull String str2, @NotNull String str3, long j, @NotNull String str4, @NotNull String str5, @NotNull List<OfferGroupResponse> list, @NotNull List<OfferFilterResponse> list2) {
            Intrinsics.checkParameterIsNotNull(str, "mainTitle");
            Intrinsics.checkParameterIsNotNull(str2, "recommendedDate");
            Intrinsics.checkParameterIsNotNull(str3, "pollingID");
            Intrinsics.checkParameterIsNotNull(str4, "savedSearchID");
            Intrinsics.checkParameterIsNotNull(str5, "conversationID");
            Intrinsics.checkParameterIsNotNull(list, "offerGroups");
            Intrinsics.checkParameterIsNotNull(list2, "filters");
            this.mainTitle = str;
            this.recommendedDate = str2;
            this.pollingID = str3;
            this.pollingInterval = j;
            this.savedSearchID = str4;
            this.conversationID = str5;
            this.offerGroups = list;
            this.filters = list2;
        }

        public static /* synthetic */ Item copy$default(Item item, String str, String str2, String str3, long j, String str4, String str5, List list, List list2, int i, Object obj) {
            return item.copy((i & 1) != 0 ? item.mainTitle : str, (i & 2) != 0 ? item.recommendedDate : str2, (i & 4) != 0 ? item.pollingID : str3, (i & 8) != 0 ? item.pollingInterval : j, (i & 16) != 0 ? item.savedSearchID : str4, (i & 32) != 0 ? item.conversationID : str5, (i & 64) != 0 ? item.offerGroups : list, (i & 128) != 0 ? item.filters : list2);
        }

        @NotNull
        public final String component1() {
            return this.mainTitle;
        }

        @NotNull
        public final String component2() {
            return this.recommendedDate;
        }

        @NotNull
        public final String component3() {
            return this.pollingID;
        }

        public final long component4() {
            return this.pollingInterval;
        }

        @NotNull
        public final String component5() {
            return this.savedSearchID;
        }

        @NotNull
        public final String component6() {
            return this.conversationID;
        }

        @NotNull
        public final List<OfferGroupResponse> component7() {
            return this.offerGroups;
        }

        @NotNull
        public final List<OfferFilterResponse> component8() {
            return this.filters;
        }

        @NotNull
        public final Item copy(@NotNull String str, @NotNull String str2, @NotNull String str3, long j, @NotNull String str4, @NotNull String str5, @NotNull List<OfferGroupResponse> list, @NotNull List<OfferFilterResponse> list2) {
            Intrinsics.checkParameterIsNotNull(str, "mainTitle");
            Intrinsics.checkParameterIsNotNull(str2, "recommendedDate");
            Intrinsics.checkParameterIsNotNull(str3, "pollingID");
            Intrinsics.checkParameterIsNotNull(str4, "savedSearchID");
            Intrinsics.checkParameterIsNotNull(str5, "conversationID");
            Intrinsics.checkParameterIsNotNull(list, "offerGroups");
            Intrinsics.checkParameterIsNotNull(list2, "filters");
            return new Item(str, str2, str3, j, str4, str5, list, list2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Item)) {
                return false;
            }
            Item item = (Item) obj;
            return Intrinsics.areEqual(this.mainTitle, item.mainTitle) && Intrinsics.areEqual(this.recommendedDate, item.recommendedDate) && Intrinsics.areEqual(this.pollingID, item.pollingID) && this.pollingInterval == item.pollingInterval && Intrinsics.areEqual(this.savedSearchID, item.savedSearchID) && Intrinsics.areEqual(this.conversationID, item.conversationID) && Intrinsics.areEqual(this.offerGroups, item.offerGroups) && Intrinsics.areEqual(this.filters, item.filters);
        }

        @NotNull
        public final String getConversationID() {
            return this.conversationID;
        }

        @NotNull
        public final List<OfferFilterResponse> getFilters() {
            return this.filters;
        }

        @NotNull
        public final String getMainTitle() {
            return this.mainTitle;
        }

        @NotNull
        public final List<OfferGroupResponse> getOfferGroups() {
            return this.offerGroups;
        }

        @NotNull
        public final String getPollingID() {
            return this.pollingID;
        }

        public final long getPollingInterval() {
            return this.pollingInterval;
        }

        @NotNull
        public final String getRecommendedDate() {
            return this.recommendedDate;
        }

        @NotNull
        public final String getSavedSearchID() {
            return this.savedSearchID;
        }

        public int hashCode() {
            String str = this.mainTitle;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.recommendedDate;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.pollingID;
            int hashCode3 = (((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + c.a(this.pollingInterval)) * 31;
            String str4 = this.savedSearchID;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.conversationID;
            int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            List<OfferGroupResponse> list = this.offerGroups;
            int hashCode6 = (hashCode5 + (list != null ? list.hashCode() : 0)) * 31;
            List<OfferFilterResponse> list2 = this.filters;
            if (list2 != null) {
                i = list2.hashCode();
            }
            return hashCode6 + i;
        }

        @NotNull
        public final OfferOsagoListRepo toOfferOsagoListRepo() {
            String str = this.mainTitle;
            String str2 = this.recommendedDate;
            String str3 = this.conversationID;
            String str4 = this.savedSearchID;
            String str5 = this.pollingID;
            long j = this.pollingInterval;
            List<OfferGroupResponse> list = this.offerGroups;
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toOfferOsagoListGroupRepo());
            }
            List<OfferFilterResponse> list2 = this.filters;
            ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(list2, 10));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(it2.next().toOfferFilterRepo());
            }
            return new OfferOsagoListRepo(str, str2, str4, str3, str5, j, arrayList, arrayList2);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Item(mainTitle=");
            L.append(this.mainTitle);
            L.append(", recommendedDate=");
            L.append(this.recommendedDate);
            L.append(", pollingID=");
            L.append(this.pollingID);
            L.append(", pollingInterval=");
            L.append(this.pollingInterval);
            L.append(", savedSearchID=");
            L.append(this.savedSearchID);
            L.append(", conversationID=");
            L.append(this.conversationID);
            L.append(", offerGroups=");
            L.append(this.offerGroups);
            L.append(", filters=");
            return a.w(L, this.filters, ")");
        }
    }

    public OfferOsagoListResponse(@NotNull Item item2) {
        Intrinsics.checkParameterIsNotNull(item2, "item");
        this.item = item2;
    }

    public static /* synthetic */ OfferOsagoListResponse copy$default(OfferOsagoListResponse offerOsagoListResponse, Item item2, int i, Object obj) {
        if ((i & 1) != 0) {
            item2 = offerOsagoListResponse.item;
        }
        return offerOsagoListResponse.copy(item2);
    }

    @NotNull
    public final Item component1() {
        return this.item;
    }

    @NotNull
    public final OfferOsagoListResponse copy(@NotNull Item item2) {
        Intrinsics.checkParameterIsNotNull(item2, "item");
        return new OfferOsagoListResponse(item2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof OfferOsagoListResponse) && Intrinsics.areEqual(this.item, ((OfferOsagoListResponse) obj).item);
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
        StringBuilder L = a.L("OfferOsagoListResponse(item=");
        L.append(this.item);
        L.append(")");
        return L.toString();
    }
}
