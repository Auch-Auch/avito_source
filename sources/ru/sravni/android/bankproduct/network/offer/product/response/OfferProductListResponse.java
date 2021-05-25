package ru.sravni.android.bankproduct.network.offer.product.response;

import a2.b.a.a.a;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
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
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.network.offer.entity.response.OfferFilterResponse;
import ru.sravni.android.bankproduct.repository.offer.product.entity.OfferProductDisplaySettingsRepo;
import ru.sravni.android.bankproduct.repository.offer.product.entity.OfferProductListRepo;
import t6.n.e;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0017"}, d2 = {"Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductListResponse;", "", "Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductListResponse$ItemResponse;", "component1", "()Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductListResponse$ItemResponse;", "item", "copy", "(Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductListResponse$ItemResponse;)Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductListResponse;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductListResponse$ItemResponse;", "getItem", "<init>", "(Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductListResponse$ItemResponse;)V", "ItemResponse", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductListResponse {
    @SerializedName("item")
    @NotNull
    private final ItemResponse item;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001:\u0001(B=\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005¢\u0006\u0004\b&\u0010'J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\r\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\r\u0010\u000bJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\bJP\u0010\u0015\u001a\u00020\u00002\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\t2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u000bJ\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0012\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b \u0010\u000bR\u001c\u0010\u0013\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b!\u0010\u000bR\u001c\u0010\u0011\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b\"\u0010\u000bR$\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010#\u001a\u0004\b$\u0010\bR\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b%\u0010\b¨\u0006)"}, d2 = {"Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductListResponse$ItemResponse;", "", "Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo;", "toOfferProductListRepo", "()Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo;", "", "Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductListResponse$ItemResponse$OfferGroupResponse;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/String;", "component3", "component4", "Lru/sravni/android/bankproduct/network/offer/entity/response/OfferFilterResponse;", "component5", "offerGroups", "mainTitle", "savedSearchID", "conversationID", "filters", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductListResponse$ItemResponse;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSavedSearchID", "getConversationID", "getMainTitle", "Ljava/util/List;", "getOfferGroups", "getFilters", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "OfferGroupResponse", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class ItemResponse {
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
        @Nullable
        private final List<OfferGroupResponse> offerGroups;
        @SerializedName("savedSearchId")
        @NotNull
        private final String savedSearchID;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001:\u0001!B'\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u001f\u0010 J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ6\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0007J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\r\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R$\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\fR\u001c\u0010\u000e\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001e\u0010\u0007¨\u0006\""}, d2 = {"Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductListResponse$ItemResponse$OfferGroupResponse;", "", "Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo$OfferGroupRepo;", "toOfferProductListGroupRepo", "()Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo$OfferGroupRepo;", "", "component1", "()Ljava/lang/String;", "component2", "", "Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductListResponse$ItemResponse$OfferGroupResponse$OfferResponse;", "component3", "()Ljava/util/List;", "titleGroup", "description", "offerList", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductListResponse$ItemResponse$OfferGroupResponse;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitleGroup", "Ljava/util/List;", "getOfferList", "getDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "OfferResponse", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
        public static final class OfferGroupResponse {
            @SerializedName("description")
            @NotNull
            private final String description;
            @SerializedName("offerList")
            @Nullable
            private final List<OfferResponse> offerList;
            @SerializedName("title")
            @NotNull
            private final String titleGroup;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b3\b\b\u0018\u00002\u00020\u0001:\u0002PQB¯\u0001\u0012\u0006\u0010\"\u001a\u00020\u0005\u0012\u0006\u0010#\u001a\u00020\b\u0012\b\u0010$\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010&\u001a\u00020\u0005\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u001c\u0012\u0016\b\u0002\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001f¢\u0006\u0004\bN\u0010OJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0007J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0007J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0007J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0007J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0019J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u001e\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001fHÆ\u0003¢\u0006\u0004\b \u0010!JÒ\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010&\u001a\u00020\u00052\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u000e\b\u0002\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00162\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u001c2\u0016\b\u0002\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001fHÆ\u0001¢\u0006\u0004\b1\u00102J\u0010\u00103\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b3\u0010\u0007J\u0010\u00104\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b4\u00105J\u001a\u00107\u001a\u00020\u001c2\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b7\u00108R\u001e\u0010,\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b,\u00109\u001a\u0004\b:\u0010\u0007R\"\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b-\u0010;\u001a\u0004\b<\u0010\u0019R\u001e\u0010'\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b'\u00109\u001a\u0004\b=\u0010\u0007R\u001e\u0010*\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b*\u00109\u001a\u0004\b>\u0010\u0007R\u001e\u0010)\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b)\u00109\u001a\u0004\b?\u0010\u0007R\"\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00168\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b.\u0010;\u001a\u0004\b@\u0010\u0019R\u001c\u0010#\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b#\u0010A\u001a\u0004\bB\u0010\nR\u001c\u0010&\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b&\u00109\u001a\u0004\bC\u0010\u0007R\u001e\u0010(\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b(\u00109\u001a\u0004\bD\u0010\u0007R\u001c\u0010\"\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\"\u00109\u001a\u0004\bE\u0010\u0007R\u001e\u0010$\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b$\u0010F\u001a\u0004\bG\u0010\rR*\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b0\u0010H\u001a\u0004\bI\u0010!R\u001e\u0010%\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b%\u00109\u001a\u0004\bJ\u0010\u0007R\u001e\u0010/\u001a\u0004\u0018\u00010\u001c8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b/\u0010K\u001a\u0004\bL\u0010\u001eR\u001e\u0010+\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b+\u00109\u001a\u0004\bM\u0010\u0007¨\u0006R"}, d2 = {"Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductListResponse$ItemResponse$OfferGroupResponse$OfferResponse;", "", "Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo$OfferGroupRepo$OfferRepo;", "toOfferProductListOfferRepo", "()Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo$OfferGroupRepo$OfferRepo;", "", "component1", "()Ljava/lang/String;", "Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductDisplaySettingsResponse;", "component2", "()Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductDisplaySettingsResponse;", "", "component3", "()Ljava/lang/Integer;", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "", "Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductListResponse$ItemResponse$OfferGroupResponse$OfferResponse$MainParamResponse;", "component12", "()Ljava/util/List;", "Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductListResponse$ItemResponse$OfferGroupResponse$OfferResponse$DetailParamResponse;", "component13", "", "component14", "()Ljava/lang/Boolean;", "", "component15", "()Ljava/util/Map;", "productType", "displaySettings", "profitability", "profitabilityText", "status", "statusText", "bankId", "orderID", "productId", "url", "urlText", "mainParams", "detailParams", "extraInfoRequest", "requestParams", "copy", "(Ljava/lang/String;Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductDisplaySettingsResponse;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/Map;)Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductListResponse$ItemResponse$OfferGroupResponse$OfferResponse;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUrlText", "Ljava/util/List;", "getMainParams", "getStatusText", "getProductId", "getOrderID", "getDetailParams", "Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductDisplaySettingsResponse;", "getDisplaySettings", "getStatus", "getBankId", "getProductType", "Ljava/lang/Integer;", "getProfitability", "Ljava/util/Map;", "getRequestParams", "getProfitabilityText", "Ljava/lang/Boolean;", "getExtraInfoRequest", "getUrl", "<init>", "(Ljava/lang/String;Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductDisplaySettingsResponse;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/Map;)V", "DetailParamResponse", "MainParamResponse", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
            public static final class OfferResponse {
                @SerializedName("bankId")
                @Nullable
                private final String bankId;
                @SerializedName("detailParams")
                @NotNull
                private final List<DetailParamResponse> detailParams;
                @SerializedName("displaySettings")
                @NotNull
                private final OfferProductDisplaySettingsResponse displaySettings;
                @SerializedName("extraInfoRequest")
                @Nullable
                private final Boolean extraInfoRequest;
                @SerializedName("mainParams")
                @NotNull
                private final List<MainParamResponse> mainParams;
                @SerializedName(AnalyticFieldsName.orderId)
                @Nullable
                private final String orderID;
                @SerializedName("productId")
                @Nullable
                private final String productId;
                @SerializedName("productType")
                @NotNull
                private final String productType;
                @SerializedName("profitability")
                @Nullable
                private final Integer profitability;
                @SerializedName("profitabilityText")
                @Nullable
                private final String profitabilityText;
                @SerializedName("requestParams")
                @Nullable
                private final Map<String, String> requestParams;
                @SerializedName("status")
                @NotNull
                private final String status;
                @SerializedName("statusText")
                @Nullable
                private final String statusText;
                @SerializedName("url")
                @Nullable
                private final String url;
                @SerializedName("urlText")
                @Nullable
                private final String urlText;

                @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u001f\u0010 J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ6\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0007J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\fR\u001c\u0010\u000e\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001e\u0010\u0007¨\u0006!"}, d2 = {"Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductListResponse$ItemResponse$OfferGroupResponse$OfferResponse$DetailParamResponse;", "", "Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo$OfferGroupRepo$DetailParamRepo;", "toOfferProductListDetailParamRepo", "()Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo$OfferGroupRepo$DetailParamRepo;", "", "component1", "()Ljava/lang/String;", "component2", "", "Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductListResponse$ItemResponse$OfferGroupResponse$OfferResponse$MainParamResponse;", "component3", "()Ljava/util/List;", "detailTitle", "detailType", ResidentialComplexModuleKt.VALUES, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductListResponse$ItemResponse$OfferGroupResponse$OfferResponse$DetailParamResponse;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDetailTitle", "Ljava/util/List;", "getValues", "getDetailType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
                public static final class DetailParamResponse {
                    @SerializedName("blockTitle")
                    @Nullable
                    private final String detailTitle;
                    @SerializedName("blockType")
                    @NotNull
                    private final String detailType;
                    @SerializedName(ResidentialComplexModuleKt.VALUES)
                    @NotNull
                    private final List<MainParamResponse> values;

                    public DetailParamResponse(@Nullable String str, @NotNull String str2, @NotNull List<MainParamResponse> list) {
                        Intrinsics.checkParameterIsNotNull(str2, "detailType");
                        Intrinsics.checkParameterIsNotNull(list, ResidentialComplexModuleKt.VALUES);
                        this.detailTitle = str;
                        this.detailType = str2;
                        this.values = list;
                    }

                    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.network.offer.product.response.OfferProductListResponse$ItemResponse$OfferGroupResponse$OfferResponse$DetailParamResponse */
                    /* JADX WARN: Multi-variable type inference failed */
                    public static /* synthetic */ DetailParamResponse copy$default(DetailParamResponse detailParamResponse, String str, String str2, List list, int i, Object obj) {
                        if ((i & 1) != 0) {
                            str = detailParamResponse.detailTitle;
                        }
                        if ((i & 2) != 0) {
                            str2 = detailParamResponse.detailType;
                        }
                        if ((i & 4) != 0) {
                            list = detailParamResponse.values;
                        }
                        return detailParamResponse.copy(str, str2, list);
                    }

                    @Nullable
                    public final String component1() {
                        return this.detailTitle;
                    }

                    @NotNull
                    public final String component2() {
                        return this.detailType;
                    }

                    @NotNull
                    public final List<MainParamResponse> component3() {
                        return this.values;
                    }

                    @NotNull
                    public final DetailParamResponse copy(@Nullable String str, @NotNull String str2, @NotNull List<MainParamResponse> list) {
                        Intrinsics.checkParameterIsNotNull(str2, "detailType");
                        Intrinsics.checkParameterIsNotNull(list, ResidentialComplexModuleKt.VALUES);
                        return new DetailParamResponse(str, str2, list);
                    }

                    public boolean equals(@Nullable Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof DetailParamResponse)) {
                            return false;
                        }
                        DetailParamResponse detailParamResponse = (DetailParamResponse) obj;
                        return Intrinsics.areEqual(this.detailTitle, detailParamResponse.detailTitle) && Intrinsics.areEqual(this.detailType, detailParamResponse.detailType) && Intrinsics.areEqual(this.values, detailParamResponse.values);
                    }

                    @Nullable
                    public final String getDetailTitle() {
                        return this.detailTitle;
                    }

                    @NotNull
                    public final String getDetailType() {
                        return this.detailType;
                    }

                    @NotNull
                    public final List<MainParamResponse> getValues() {
                        return this.values;
                    }

                    public int hashCode() {
                        String str = this.detailTitle;
                        int i = 0;
                        int hashCode = (str != null ? str.hashCode() : 0) * 31;
                        String str2 = this.detailType;
                        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                        List<MainParamResponse> list = this.values;
                        if (list != null) {
                            i = list.hashCode();
                        }
                        return hashCode2 + i;
                    }

                    @NotNull
                    public final OfferProductListRepo.OfferGroupRepo.DetailParamRepo toOfferProductListDetailParamRepo() {
                        String str = this.detailTitle;
                        String str2 = this.detailType;
                        List<MainParamResponse> list = this.values;
                        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.add(it.next().toOfferProductListMainParamRepo());
                        }
                        return new OfferProductListRepo.OfferGroupRepo.DetailParamRepo(str, str2, arrayList);
                    }

                    @NotNull
                    public String toString() {
                        StringBuilder L = a.L("DetailParamResponse(detailTitle=");
                        L.append(this.detailTitle);
                        L.append(", detailType=");
                        L.append(this.detailType);
                        L.append(", values=");
                        return a.w(L, this.values, ")");
                    }
                }

                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J.\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u000b\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u001c\u0010\f\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0019\u0010\u0007R\u001c\u0010\n\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u001a\u0010\u0007¨\u0006\u001d"}, d2 = {"Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductListResponse$ItemResponse$OfferGroupResponse$OfferResponse$MainParamResponse;", "", "Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo$OfferGroupRepo$MainParamRepo;", "toOfferProductListMainParamRepo", "()Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo$OfferGroupRepo$MainParamRepo;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "fontType", "name", "value", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductListResponse$ItemResponse$OfferGroupResponse$OfferResponse$MainParamResponse;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "getValue", "getFontType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
                public static final class MainParamResponse {
                    @SerializedName("fontType")
                    @NotNull
                    private final String fontType;
                    @SerializedName("name")
                    @NotNull
                    private final String name;
                    @SerializedName("value")
                    @NotNull
                    private final String value;

                    public MainParamResponse(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                        a.a1(str, "fontType", str2, "name", str3, "value");
                        this.fontType = str;
                        this.name = str2;
                        this.value = str3;
                    }

                    public static /* synthetic */ MainParamResponse copy$default(MainParamResponse mainParamResponse, String str, String str2, String str3, int i, Object obj) {
                        if ((i & 1) != 0) {
                            str = mainParamResponse.fontType;
                        }
                        if ((i & 2) != 0) {
                            str2 = mainParamResponse.name;
                        }
                        if ((i & 4) != 0) {
                            str3 = mainParamResponse.value;
                        }
                        return mainParamResponse.copy(str, str2, str3);
                    }

                    @NotNull
                    public final String component1() {
                        return this.fontType;
                    }

                    @NotNull
                    public final String component2() {
                        return this.name;
                    }

                    @NotNull
                    public final String component3() {
                        return this.value;
                    }

                    @NotNull
                    public final MainParamResponse copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                        Intrinsics.checkParameterIsNotNull(str, "fontType");
                        Intrinsics.checkParameterIsNotNull(str2, "name");
                        Intrinsics.checkParameterIsNotNull(str3, "value");
                        return new MainParamResponse(str, str2, str3);
                    }

                    public boolean equals(@Nullable Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof MainParamResponse)) {
                            return false;
                        }
                        MainParamResponse mainParamResponse = (MainParamResponse) obj;
                        return Intrinsics.areEqual(this.fontType, mainParamResponse.fontType) && Intrinsics.areEqual(this.name, mainParamResponse.name) && Intrinsics.areEqual(this.value, mainParamResponse.value);
                    }

                    @NotNull
                    public final String getFontType() {
                        return this.fontType;
                    }

                    @NotNull
                    public final String getName() {
                        return this.name;
                    }

                    @NotNull
                    public final String getValue() {
                        return this.value;
                    }

                    public int hashCode() {
                        String str = this.fontType;
                        int i = 0;
                        int hashCode = (str != null ? str.hashCode() : 0) * 31;
                        String str2 = this.name;
                        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                        String str3 = this.value;
                        if (str3 != null) {
                            i = str3.hashCode();
                        }
                        return hashCode2 + i;
                    }

                    @NotNull
                    public final OfferProductListRepo.OfferGroupRepo.MainParamRepo toOfferProductListMainParamRepo() {
                        return new OfferProductListRepo.OfferGroupRepo.MainParamRepo(this.fontType, this.name, this.value);
                    }

                    @NotNull
                    public String toString() {
                        StringBuilder L = a.L("MainParamResponse(fontType=");
                        L.append(this.fontType);
                        L.append(", name=");
                        L.append(this.name);
                        L.append(", value=");
                        return a.t(L, this.value, ")");
                    }
                }

                public OfferResponse(@NotNull String str, @NotNull OfferProductDisplaySettingsResponse offerProductDisplaySettingsResponse, @Nullable Integer num, @Nullable String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @NotNull List<MainParamResponse> list, @NotNull List<DetailParamResponse> list2, @Nullable Boolean bool, @Nullable Map<String, String> map) {
                    Intrinsics.checkParameterIsNotNull(str, "productType");
                    Intrinsics.checkParameterIsNotNull(offerProductDisplaySettingsResponse, "displaySettings");
                    Intrinsics.checkParameterIsNotNull(str3, "status");
                    Intrinsics.checkParameterIsNotNull(list, "mainParams");
                    Intrinsics.checkParameterIsNotNull(list2, "detailParams");
                    this.productType = str;
                    this.displaySettings = offerProductDisplaySettingsResponse;
                    this.profitability = num;
                    this.profitabilityText = str2;
                    this.status = str3;
                    this.statusText = str4;
                    this.bankId = str5;
                    this.orderID = str6;
                    this.productId = str7;
                    this.url = str8;
                    this.urlText = str9;
                    this.mainParams = list;
                    this.detailParams = list2;
                    this.extraInfoRequest = bool;
                    this.requestParams = map;
                }

                public static /* synthetic */ OfferResponse copy$default(OfferResponse offerResponse, String str, OfferProductDisplaySettingsResponse offerProductDisplaySettingsResponse, Integer num, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List list, List list2, Boolean bool, Map map, int i, Object obj) {
                    return offerResponse.copy((i & 1) != 0 ? offerResponse.productType : str, (i & 2) != 0 ? offerResponse.displaySettings : offerProductDisplaySettingsResponse, (i & 4) != 0 ? offerResponse.profitability : num, (i & 8) != 0 ? offerResponse.profitabilityText : str2, (i & 16) != 0 ? offerResponse.status : str3, (i & 32) != 0 ? offerResponse.statusText : str4, (i & 64) != 0 ? offerResponse.bankId : str5, (i & 128) != 0 ? offerResponse.orderID : str6, (i & 256) != 0 ? offerResponse.productId : str7, (i & 512) != 0 ? offerResponse.url : str8, (i & 1024) != 0 ? offerResponse.urlText : str9, (i & 2048) != 0 ? offerResponse.mainParams : list, (i & 4096) != 0 ? offerResponse.detailParams : list2, (i & 8192) != 0 ? offerResponse.extraInfoRequest : bool, (i & 16384) != 0 ? offerResponse.requestParams : map);
                }

                @NotNull
                public final String component1() {
                    return this.productType;
                }

                @Nullable
                public final String component10() {
                    return this.url;
                }

                @Nullable
                public final String component11() {
                    return this.urlText;
                }

                @NotNull
                public final List<MainParamResponse> component12() {
                    return this.mainParams;
                }

                @NotNull
                public final List<DetailParamResponse> component13() {
                    return this.detailParams;
                }

                @Nullable
                public final Boolean component14() {
                    return this.extraInfoRequest;
                }

                @Nullable
                public final Map<String, String> component15() {
                    return this.requestParams;
                }

                @NotNull
                public final OfferProductDisplaySettingsResponse component2() {
                    return this.displaySettings;
                }

                @Nullable
                public final Integer component3() {
                    return this.profitability;
                }

                @Nullable
                public final String component4() {
                    return this.profitabilityText;
                }

                @NotNull
                public final String component5() {
                    return this.status;
                }

                @Nullable
                public final String component6() {
                    return this.statusText;
                }

                @Nullable
                public final String component7() {
                    return this.bankId;
                }

                @Nullable
                public final String component8() {
                    return this.orderID;
                }

                @Nullable
                public final String component9() {
                    return this.productId;
                }

                @NotNull
                public final OfferResponse copy(@NotNull String str, @NotNull OfferProductDisplaySettingsResponse offerProductDisplaySettingsResponse, @Nullable Integer num, @Nullable String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @NotNull List<MainParamResponse> list, @NotNull List<DetailParamResponse> list2, @Nullable Boolean bool, @Nullable Map<String, String> map) {
                    Intrinsics.checkParameterIsNotNull(str, "productType");
                    Intrinsics.checkParameterIsNotNull(offerProductDisplaySettingsResponse, "displaySettings");
                    Intrinsics.checkParameterIsNotNull(str3, "status");
                    Intrinsics.checkParameterIsNotNull(list, "mainParams");
                    Intrinsics.checkParameterIsNotNull(list2, "detailParams");
                    return new OfferResponse(str, offerProductDisplaySettingsResponse, num, str2, str3, str4, str5, str6, str7, str8, str9, list, list2, bool, map);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof OfferResponse)) {
                        return false;
                    }
                    OfferResponse offerResponse = (OfferResponse) obj;
                    return Intrinsics.areEqual(this.productType, offerResponse.productType) && Intrinsics.areEqual(this.displaySettings, offerResponse.displaySettings) && Intrinsics.areEqual(this.profitability, offerResponse.profitability) && Intrinsics.areEqual(this.profitabilityText, offerResponse.profitabilityText) && Intrinsics.areEqual(this.status, offerResponse.status) && Intrinsics.areEqual(this.statusText, offerResponse.statusText) && Intrinsics.areEqual(this.bankId, offerResponse.bankId) && Intrinsics.areEqual(this.orderID, offerResponse.orderID) && Intrinsics.areEqual(this.productId, offerResponse.productId) && Intrinsics.areEqual(this.url, offerResponse.url) && Intrinsics.areEqual(this.urlText, offerResponse.urlText) && Intrinsics.areEqual(this.mainParams, offerResponse.mainParams) && Intrinsics.areEqual(this.detailParams, offerResponse.detailParams) && Intrinsics.areEqual(this.extraInfoRequest, offerResponse.extraInfoRequest) && Intrinsics.areEqual(this.requestParams, offerResponse.requestParams);
                }

                @Nullable
                public final String getBankId() {
                    return this.bankId;
                }

                @NotNull
                public final List<DetailParamResponse> getDetailParams() {
                    return this.detailParams;
                }

                @NotNull
                public final OfferProductDisplaySettingsResponse getDisplaySettings() {
                    return this.displaySettings;
                }

                @Nullable
                public final Boolean getExtraInfoRequest() {
                    return this.extraInfoRequest;
                }

                @NotNull
                public final List<MainParamResponse> getMainParams() {
                    return this.mainParams;
                }

                @Nullable
                public final String getOrderID() {
                    return this.orderID;
                }

                @Nullable
                public final String getProductId() {
                    return this.productId;
                }

                @NotNull
                public final String getProductType() {
                    return this.productType;
                }

                @Nullable
                public final Integer getProfitability() {
                    return this.profitability;
                }

                @Nullable
                public final String getProfitabilityText() {
                    return this.profitabilityText;
                }

                @Nullable
                public final Map<String, String> getRequestParams() {
                    return this.requestParams;
                }

                @NotNull
                public final String getStatus() {
                    return this.status;
                }

                @Nullable
                public final String getStatusText() {
                    return this.statusText;
                }

                @Nullable
                public final String getUrl() {
                    return this.url;
                }

                @Nullable
                public final String getUrlText() {
                    return this.urlText;
                }

                public int hashCode() {
                    String str = this.productType;
                    int i = 0;
                    int hashCode = (str != null ? str.hashCode() : 0) * 31;
                    OfferProductDisplaySettingsResponse offerProductDisplaySettingsResponse = this.displaySettings;
                    int hashCode2 = (hashCode + (offerProductDisplaySettingsResponse != null ? offerProductDisplaySettingsResponse.hashCode() : 0)) * 31;
                    Integer num = this.profitability;
                    int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 31;
                    String str2 = this.profitabilityText;
                    int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
                    String str3 = this.status;
                    int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
                    String str4 = this.statusText;
                    int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
                    String str5 = this.bankId;
                    int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
                    String str6 = this.orderID;
                    int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
                    String str7 = this.productId;
                    int hashCode9 = (hashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
                    String str8 = this.url;
                    int hashCode10 = (hashCode9 + (str8 != null ? str8.hashCode() : 0)) * 31;
                    String str9 = this.urlText;
                    int hashCode11 = (hashCode10 + (str9 != null ? str9.hashCode() : 0)) * 31;
                    List<MainParamResponse> list = this.mainParams;
                    int hashCode12 = (hashCode11 + (list != null ? list.hashCode() : 0)) * 31;
                    List<DetailParamResponse> list2 = this.detailParams;
                    int hashCode13 = (hashCode12 + (list2 != null ? list2.hashCode() : 0)) * 31;
                    Boolean bool = this.extraInfoRequest;
                    int hashCode14 = (hashCode13 + (bool != null ? bool.hashCode() : 0)) * 31;
                    Map<String, String> map = this.requestParams;
                    if (map != null) {
                        i = map.hashCode();
                    }
                    return hashCode14 + i;
                }

                @NotNull
                public final OfferProductListRepo.OfferGroupRepo.OfferRepo toOfferProductListOfferRepo() {
                    String str = this.bankId;
                    String str2 = this.orderID;
                    String str3 = this.productId;
                    String str4 = this.productType;
                    Integer num = this.profitability;
                    String str5 = this.profitabilityText;
                    String str6 = this.status;
                    String str7 = this.statusText;
                    String str8 = this.url;
                    String str9 = this.urlText;
                    List<MainParamResponse> list = this.mainParams;
                    ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().toOfferProductListMainParamRepo());
                    }
                    OfferProductDisplaySettingsRepo offerProductDisplaySettingsRepo = this.displaySettings.toOfferProductDisplaySettingsRepo();
                    List<DetailParamResponse> list2 = this.detailParams;
                    ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(list2, 10));
                    Iterator<T> it2 = list2.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(it2.next().toOfferProductListDetailParamRepo());
                    }
                    Map<String, String> map = this.requestParams;
                    if (map == null) {
                        map = r.emptyMap();
                    }
                    Boolean bool = this.extraInfoRequest;
                    return new OfferProductListRepo.OfferGroupRepo.OfferRepo(str, str2, arrayList2, offerProductDisplaySettingsRepo, arrayList, str3, str4, num, str5, str6, str7, str8, str9, "", map, bool != null ? bool.booleanValue() : false);
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a.L("OfferResponse(productType=");
                    L.append(this.productType);
                    L.append(", displaySettings=");
                    L.append(this.displaySettings);
                    L.append(", profitability=");
                    L.append(this.profitability);
                    L.append(", profitabilityText=");
                    L.append(this.profitabilityText);
                    L.append(", status=");
                    L.append(this.status);
                    L.append(", statusText=");
                    L.append(this.statusText);
                    L.append(", bankId=");
                    L.append(this.bankId);
                    L.append(", orderID=");
                    L.append(this.orderID);
                    L.append(", productId=");
                    L.append(this.productId);
                    L.append(", url=");
                    L.append(this.url);
                    L.append(", urlText=");
                    L.append(this.urlText);
                    L.append(", mainParams=");
                    L.append(this.mainParams);
                    L.append(", detailParams=");
                    L.append(this.detailParams);
                    L.append(", extraInfoRequest=");
                    L.append(this.extraInfoRequest);
                    L.append(", requestParams=");
                    return a.x(L, this.requestParams, ")");
                }

                /* JADX INFO: this call moved to the top of the method (can break code semantics) */
                public /* synthetic */ OfferResponse(String str, OfferProductDisplaySettingsResponse offerProductDisplaySettingsResponse, Integer num, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List list, List list2, Boolean bool, Map map, int i, j jVar) {
                    this(str, offerProductDisplaySettingsResponse, num, str2, str3, str4, str5, str6, str7, str8, str9, list, list2, (i & 8192) != 0 ? null : bool, (i & 16384) != 0 ? null : map);
                }
            }

            public OfferGroupResponse(@NotNull String str, @NotNull String str2, @Nullable List<OfferResponse> list) {
                Intrinsics.checkParameterIsNotNull(str, "titleGroup");
                Intrinsics.checkParameterIsNotNull(str2, "description");
                this.titleGroup = str;
                this.description = str2;
                this.offerList = list;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.network.offer.product.response.OfferProductListResponse$ItemResponse$OfferGroupResponse */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ OfferGroupResponse copy$default(OfferGroupResponse offerGroupResponse, String str, String str2, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = offerGroupResponse.titleGroup;
                }
                if ((i & 2) != 0) {
                    str2 = offerGroupResponse.description;
                }
                if ((i & 4) != 0) {
                    list = offerGroupResponse.offerList;
                }
                return offerGroupResponse.copy(str, str2, list);
            }

            @NotNull
            public final String component1() {
                return this.titleGroup;
            }

            @NotNull
            public final String component2() {
                return this.description;
            }

            @Nullable
            public final List<OfferResponse> component3() {
                return this.offerList;
            }

            @NotNull
            public final OfferGroupResponse copy(@NotNull String str, @NotNull String str2, @Nullable List<OfferResponse> list) {
                Intrinsics.checkParameterIsNotNull(str, "titleGroup");
                Intrinsics.checkParameterIsNotNull(str2, "description");
                return new OfferGroupResponse(str, str2, list);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof OfferGroupResponse)) {
                    return false;
                }
                OfferGroupResponse offerGroupResponse = (OfferGroupResponse) obj;
                return Intrinsics.areEqual(this.titleGroup, offerGroupResponse.titleGroup) && Intrinsics.areEqual(this.description, offerGroupResponse.description) && Intrinsics.areEqual(this.offerList, offerGroupResponse.offerList);
            }

            @NotNull
            public final String getDescription() {
                return this.description;
            }

            @Nullable
            public final List<OfferResponse> getOfferList() {
                return this.offerList;
            }

            @NotNull
            public final String getTitleGroup() {
                return this.titleGroup;
            }

            public int hashCode() {
                String str = this.titleGroup;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.description;
                int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                List<OfferResponse> list = this.offerList;
                if (list != null) {
                    i = list.hashCode();
                }
                return hashCode2 + i;
            }

            @NotNull
            public final OfferProductListRepo.OfferGroupRepo toOfferProductListGroupRepo() {
                List list;
                String str = this.titleGroup;
                String str2 = this.description;
                List<OfferResponse> list2 = this.offerList;
                if (list2 != null) {
                    list = new ArrayList(e.collectionSizeOrDefault(list2, 10));
                    Iterator<T> it = list2.iterator();
                    while (it.hasNext()) {
                        list.add(it.next().toOfferProductListOfferRepo());
                    }
                } else {
                    list = CollectionsKt__CollectionsKt.emptyList();
                }
                return new OfferProductListRepo.OfferGroupRepo(str, str2, list);
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("OfferGroupResponse(titleGroup=");
                L.append(this.titleGroup);
                L.append(", description=");
                L.append(this.description);
                L.append(", offerList=");
                return a.w(L, this.offerList, ")");
            }
        }

        public ItemResponse(@Nullable List<OfferGroupResponse> list, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull List<OfferFilterResponse> list2) {
            Intrinsics.checkParameterIsNotNull(str, "mainTitle");
            Intrinsics.checkParameterIsNotNull(str2, "savedSearchID");
            Intrinsics.checkParameterIsNotNull(str3, "conversationID");
            Intrinsics.checkParameterIsNotNull(list2, "filters");
            this.offerGroups = list;
            this.mainTitle = str;
            this.savedSearchID = str2;
            this.conversationID = str3;
            this.filters = list2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: ru.sravni.android.bankproduct.network.offer.product.response.OfferProductListResponse$ItemResponse */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ItemResponse copy$default(ItemResponse itemResponse, List list, String str, String str2, String str3, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = itemResponse.offerGroups;
            }
            if ((i & 2) != 0) {
                str = itemResponse.mainTitle;
            }
            if ((i & 4) != 0) {
                str2 = itemResponse.savedSearchID;
            }
            if ((i & 8) != 0) {
                str3 = itemResponse.conversationID;
            }
            if ((i & 16) != 0) {
                list2 = itemResponse.filters;
            }
            return itemResponse.copy(list, str, str2, str3, list2);
        }

        @Nullable
        public final List<OfferGroupResponse> component1() {
            return this.offerGroups;
        }

        @NotNull
        public final String component2() {
            return this.mainTitle;
        }

        @NotNull
        public final String component3() {
            return this.savedSearchID;
        }

        @NotNull
        public final String component4() {
            return this.conversationID;
        }

        @NotNull
        public final List<OfferFilterResponse> component5() {
            return this.filters;
        }

        @NotNull
        public final ItemResponse copy(@Nullable List<OfferGroupResponse> list, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull List<OfferFilterResponse> list2) {
            Intrinsics.checkParameterIsNotNull(str, "mainTitle");
            Intrinsics.checkParameterIsNotNull(str2, "savedSearchID");
            Intrinsics.checkParameterIsNotNull(str3, "conversationID");
            Intrinsics.checkParameterIsNotNull(list2, "filters");
            return new ItemResponse(list, str, str2, str3, list2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ItemResponse)) {
                return false;
            }
            ItemResponse itemResponse = (ItemResponse) obj;
            return Intrinsics.areEqual(this.offerGroups, itemResponse.offerGroups) && Intrinsics.areEqual(this.mainTitle, itemResponse.mainTitle) && Intrinsics.areEqual(this.savedSearchID, itemResponse.savedSearchID) && Intrinsics.areEqual(this.conversationID, itemResponse.conversationID) && Intrinsics.areEqual(this.filters, itemResponse.filters);
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

        @Nullable
        public final List<OfferGroupResponse> getOfferGroups() {
            return this.offerGroups;
        }

        @NotNull
        public final String getSavedSearchID() {
            return this.savedSearchID;
        }

        public int hashCode() {
            List<OfferGroupResponse> list = this.offerGroups;
            int i = 0;
            int hashCode = (list != null ? list.hashCode() : 0) * 31;
            String str = this.mainTitle;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.savedSearchID;
            int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.conversationID;
            int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
            List<OfferFilterResponse> list2 = this.filters;
            if (list2 != null) {
                i = list2.hashCode();
            }
            return hashCode4 + i;
        }

        @NotNull
        public final OfferProductListRepo toOfferProductListRepo() {
            ArrayList arrayList;
            String str = this.mainTitle;
            String str2 = this.conversationID;
            String str3 = this.savedSearchID;
            List<OfferFilterResponse> list = this.filters;
            ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().toOfferFilterRepo());
            }
            List<OfferGroupResponse> list2 = this.offerGroups;
            if (list2 != null) {
                ArrayList arrayList3 = new ArrayList(e.collectionSizeOrDefault(list2, 10));
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(it2.next().toOfferProductListGroupRepo());
                }
                arrayList = arrayList3;
            } else {
                arrayList = CollectionsKt__CollectionsKt.emptyList();
            }
            return new OfferProductListRepo(str, str2, str3, arrayList2, arrayList);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("ItemResponse(offerGroups=");
            L.append(this.offerGroups);
            L.append(", mainTitle=");
            L.append(this.mainTitle);
            L.append(", savedSearchID=");
            L.append(this.savedSearchID);
            L.append(", conversationID=");
            L.append(this.conversationID);
            L.append(", filters=");
            return a.w(L, this.filters, ")");
        }
    }

    public OfferProductListResponse(@NotNull ItemResponse itemResponse) {
        Intrinsics.checkParameterIsNotNull(itemResponse, "item");
        this.item = itemResponse;
    }

    public static /* synthetic */ OfferProductListResponse copy$default(OfferProductListResponse offerProductListResponse, ItemResponse itemResponse, int i, Object obj) {
        if ((i & 1) != 0) {
            itemResponse = offerProductListResponse.item;
        }
        return offerProductListResponse.copy(itemResponse);
    }

    @NotNull
    public final ItemResponse component1() {
        return this.item;
    }

    @NotNull
    public final OfferProductListResponse copy(@NotNull ItemResponse itemResponse) {
        Intrinsics.checkParameterIsNotNull(itemResponse, "item");
        return new OfferProductListResponse(itemResponse);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof OfferProductListResponse) && Intrinsics.areEqual(this.item, ((OfferProductListResponse) obj).item);
        }
        return true;
    }

    @NotNull
    public final ItemResponse getItem() {
        return this.item;
    }

    public int hashCode() {
        ItemResponse itemResponse = this.item;
        if (itemResponse != null) {
            return itemResponse.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferProductListResponse(item=");
        L.append(this.item);
        L.append(")");
        return L.toString();
    }
}
