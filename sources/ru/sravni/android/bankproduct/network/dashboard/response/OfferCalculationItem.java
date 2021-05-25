package ru.sravni.android.bankproduct.network.dashboard.response;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0017\u001a\u00020\b\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\f\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\b\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b4\u00105J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0001\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010\u0004J\u0010\u0010!\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b!\u0010\nJ\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u001c\u0010\u0013\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b'\u0010\u0004R\u001c\u0010\u0015\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010&\u001a\u0004\b(\u0010\u0004R\u001c\u0010\u001a\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010&\u001a\u0004\b)\u0010\u0004R\u001c\u0010\u001c\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010&\u001a\u0004\b*\u0010\u0004R\u001c\u0010\u0018\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010&\u001a\u0004\b+\u0010\u0004R\u001c\u0010\u001d\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010&\u001a\u0004\b,\u0010\u0004R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b-\u0010\u0004R\u001c\u0010\u0017\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010.\u001a\u0004\b/\u0010\nR\u001c\u0010\u0019\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u00100\u001a\u0004\b1\u0010\u000eR\u001c\u0010\u001b\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010.\u001a\u0004\b2\u0010\nR\u001c\u0010\u0014\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010&\u001a\u0004\b3\u0010\u0004¨\u00066"}, d2 = {"Lru/sravni/android/bankproduct/network/dashboard/response/OfferCalculationItem;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "", "component5", "()I", "component6", "Lru/sravni/android/bankproduct/network/dashboard/response/Query;", "component7", "()Lru/sravni/android/bankproduct/network/dashboard/response/Query;", "component8", "component9", "component10", "component11", "conversation", "dateCreated", "name", AnalyticFieldsName.productName, AnalyticFieldsName.offersCount, "offersCountTitle", "query", "queryTitle", "requestsCounts", "requestsCountsTitle", "savedSearchID", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lru/sravni/android/bankproduct/network/dashboard/response/Query;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/network/dashboard/response/OfferCalculationItem;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getConversation", "getName", "getQueryTitle", "getRequestsCountsTitle", "getOffersCountTitle", "getSavedSearchID", "getProductName", "I", "getOffersCount", "Lru/sravni/android/bankproduct/network/dashboard/response/Query;", "getQuery", "getRequestsCounts", "getDateCreated", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lru/sravni/android/bankproduct/network/dashboard/response/Query;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferCalculationItem {
    @SerializedName("conversation")
    @NotNull
    private final String conversation;
    @SerializedName("dateCreated")
    @NotNull
    private final String dateCreated;
    @SerializedName("name")
    @NotNull
    private final String name;
    @SerializedName(AnalyticFieldsName.offersCount)
    private final int offersCount;
    @SerializedName("offersCountTitle")
    @NotNull
    private final String offersCountTitle;
    @SerializedName(AnalyticFieldsName.productName)
    @Nullable
    private final String productName;
    @SerializedName("query")
    @NotNull
    private final Query query;
    @SerializedName("queryTitle")
    @NotNull
    private final String queryTitle;
    @SerializedName("requestsCounts")
    private final int requestsCounts;
    @SerializedName("requestsCountsTitle")
    @NotNull
    private final String requestsCountsTitle;
    @SerializedName("_id")
    @NotNull
    private final String savedSearchID;

    public OfferCalculationItem(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, int i, @NotNull String str5, @NotNull Query query2, @NotNull String str6, int i2, @NotNull String str7, @NotNull String str8) {
        Intrinsics.checkParameterIsNotNull(str, "conversation");
        Intrinsics.checkParameterIsNotNull(str2, "dateCreated");
        Intrinsics.checkParameterIsNotNull(str3, "name");
        Intrinsics.checkParameterIsNotNull(str5, "offersCountTitle");
        Intrinsics.checkParameterIsNotNull(query2, "query");
        Intrinsics.checkParameterIsNotNull(str6, "queryTitle");
        Intrinsics.checkParameterIsNotNull(str7, "requestsCountsTitle");
        Intrinsics.checkParameterIsNotNull(str8, "savedSearchID");
        this.conversation = str;
        this.dateCreated = str2;
        this.name = str3;
        this.productName = str4;
        this.offersCount = i;
        this.offersCountTitle = str5;
        this.query = query2;
        this.queryTitle = str6;
        this.requestsCounts = i2;
        this.requestsCountsTitle = str7;
        this.savedSearchID = str8;
    }

    public static /* synthetic */ OfferCalculationItem copy$default(OfferCalculationItem offerCalculationItem, String str, String str2, String str3, String str4, int i, String str5, Query query2, String str6, int i2, String str7, String str8, int i3, Object obj) {
        return offerCalculationItem.copy((i3 & 1) != 0 ? offerCalculationItem.conversation : str, (i3 & 2) != 0 ? offerCalculationItem.dateCreated : str2, (i3 & 4) != 0 ? offerCalculationItem.name : str3, (i3 & 8) != 0 ? offerCalculationItem.productName : str4, (i3 & 16) != 0 ? offerCalculationItem.offersCount : i, (i3 & 32) != 0 ? offerCalculationItem.offersCountTitle : str5, (i3 & 64) != 0 ? offerCalculationItem.query : query2, (i3 & 128) != 0 ? offerCalculationItem.queryTitle : str6, (i3 & 256) != 0 ? offerCalculationItem.requestsCounts : i2, (i3 & 512) != 0 ? offerCalculationItem.requestsCountsTitle : str7, (i3 & 1024) != 0 ? offerCalculationItem.savedSearchID : str8);
    }

    @NotNull
    public final String component1() {
        return this.conversation;
    }

    @NotNull
    public final String component10() {
        return this.requestsCountsTitle;
    }

    @NotNull
    public final String component11() {
        return this.savedSearchID;
    }

    @NotNull
    public final String component2() {
        return this.dateCreated;
    }

    @NotNull
    public final String component3() {
        return this.name;
    }

    @Nullable
    public final String component4() {
        return this.productName;
    }

    public final int component5() {
        return this.offersCount;
    }

    @NotNull
    public final String component6() {
        return this.offersCountTitle;
    }

    @NotNull
    public final Query component7() {
        return this.query;
    }

    @NotNull
    public final String component8() {
        return this.queryTitle;
    }

    public final int component9() {
        return this.requestsCounts;
    }

    @NotNull
    public final OfferCalculationItem copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, int i, @NotNull String str5, @NotNull Query query2, @NotNull String str6, int i2, @NotNull String str7, @NotNull String str8) {
        Intrinsics.checkParameterIsNotNull(str, "conversation");
        Intrinsics.checkParameterIsNotNull(str2, "dateCreated");
        Intrinsics.checkParameterIsNotNull(str3, "name");
        Intrinsics.checkParameterIsNotNull(str5, "offersCountTitle");
        Intrinsics.checkParameterIsNotNull(query2, "query");
        Intrinsics.checkParameterIsNotNull(str6, "queryTitle");
        Intrinsics.checkParameterIsNotNull(str7, "requestsCountsTitle");
        Intrinsics.checkParameterIsNotNull(str8, "savedSearchID");
        return new OfferCalculationItem(str, str2, str3, str4, i, str5, query2, str6, i2, str7, str8);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferCalculationItem)) {
            return false;
        }
        OfferCalculationItem offerCalculationItem = (OfferCalculationItem) obj;
        return Intrinsics.areEqual(this.conversation, offerCalculationItem.conversation) && Intrinsics.areEqual(this.dateCreated, offerCalculationItem.dateCreated) && Intrinsics.areEqual(this.name, offerCalculationItem.name) && Intrinsics.areEqual(this.productName, offerCalculationItem.productName) && this.offersCount == offerCalculationItem.offersCount && Intrinsics.areEqual(this.offersCountTitle, offerCalculationItem.offersCountTitle) && Intrinsics.areEqual(this.query, offerCalculationItem.query) && Intrinsics.areEqual(this.queryTitle, offerCalculationItem.queryTitle) && this.requestsCounts == offerCalculationItem.requestsCounts && Intrinsics.areEqual(this.requestsCountsTitle, offerCalculationItem.requestsCountsTitle) && Intrinsics.areEqual(this.savedSearchID, offerCalculationItem.savedSearchID);
    }

    @NotNull
    public final String getConversation() {
        return this.conversation;
    }

    @NotNull
    public final String getDateCreated() {
        return this.dateCreated;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getOffersCount() {
        return this.offersCount;
    }

    @NotNull
    public final String getOffersCountTitle() {
        return this.offersCountTitle;
    }

    @Nullable
    public final String getProductName() {
        return this.productName;
    }

    @NotNull
    public final Query getQuery() {
        return this.query;
    }

    @NotNull
    public final String getQueryTitle() {
        return this.queryTitle;
    }

    public final int getRequestsCounts() {
        return this.requestsCounts;
    }

    @NotNull
    public final String getRequestsCountsTitle() {
        return this.requestsCountsTitle;
    }

    @NotNull
    public final String getSavedSearchID() {
        return this.savedSearchID;
    }

    public int hashCode() {
        String str = this.conversation;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.dateCreated;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.name;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.productName;
        int hashCode4 = (((hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.offersCount) * 31;
        String str5 = this.offersCountTitle;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Query query2 = this.query;
        int hashCode6 = (hashCode5 + (query2 != null ? query2.hashCode() : 0)) * 31;
        String str6 = this.queryTitle;
        int hashCode7 = (((hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.requestsCounts) * 31;
        String str7 = this.requestsCountsTitle;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.savedSearchID;
        if (str8 != null) {
            i = str8.hashCode();
        }
        return hashCode8 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferCalculationItem(conversation=");
        L.append(this.conversation);
        L.append(", dateCreated=");
        L.append(this.dateCreated);
        L.append(", name=");
        L.append(this.name);
        L.append(", productName=");
        L.append(this.productName);
        L.append(", offersCount=");
        L.append(this.offersCount);
        L.append(", offersCountTitle=");
        L.append(this.offersCountTitle);
        L.append(", query=");
        L.append(this.query);
        L.append(", queryTitle=");
        L.append(this.queryTitle);
        L.append(", requestsCounts=");
        L.append(this.requestsCounts);
        L.append(", requestsCountsTitle=");
        L.append(this.requestsCountsTitle);
        L.append(", savedSearchID=");
        return a.t(L, this.savedSearchID, ")");
    }
}
