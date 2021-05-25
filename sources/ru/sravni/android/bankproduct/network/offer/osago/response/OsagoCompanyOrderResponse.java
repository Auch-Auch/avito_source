package ru.sravni.android.bankproduct.network.offer.osago.response;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.model.VKApiUserFull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.repository.offer.osago.entity.order.OsagoCompanyOrderRepo;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0017"}, d2 = {"Lru/sravni/android/bankproduct/network/offer/osago/response/OsagoCompanyOrderResponse;", "", "Lru/sravni/android/bankproduct/network/offer/osago/response/OsagoCompanyOrderResponse$Item;", "component1", "()Lru/sravni/android/bankproduct/network/offer/osago/response/OsagoCompanyOrderResponse$Item;", "item", "copy", "(Lru/sravni/android/bankproduct/network/offer/osago/response/OsagoCompanyOrderResponse$Item;)Lru/sravni/android/bankproduct/network/offer/osago/response/OsagoCompanyOrderResponse;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lru/sravni/android/bankproduct/network/offer/osago/response/OsagoCompanyOrderResponse$Item;", "getItem", "<init>", "(Lru/sravni/android/bankproduct/network/offer/osago/response/OsagoCompanyOrderResponse$Item;)V", "Item", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OsagoCompanyOrderResponse {
    @SerializedName("item")
    @NotNull
    private final Item item;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001:\u0001-B=\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005¢\u0006\u0004\b+\u0010,J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0007JR\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\t2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0007J\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u001c\u0010\u0017\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\"\u001a\u0004\b#\u0010\u0007R\u001c\u0010\u0016\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\"\u001a\u0004\b$\u0010\u0007R\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b&\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b'\u0010\u0007R\u001c\u0010\u0014\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b)\u0010\u000bR\u001c\u0010\u0012\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b*\u0010\u0007¨\u0006."}, d2 = {"Lru/sravni/android/bankproduct/network/offer/osago/response/OsagoCompanyOrderResponse$Item;", "", "Lru/sravni/android/bankproduct/repository/offer/osago/entity/order/OsagoCompanyOrderRepo;", "toOsagoCompanyOrderRepo", "()Lru/sravni/android/bankproduct/repository/offer/osago/entity/order/OsagoCompanyOrderRepo;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()J", "", "Lru/sravni/android/bankproduct/network/offer/osago/response/OsagoCompanyOrderResponse$Item$Quote;", "component4", "()Ljava/util/List;", "component5", "component6", "backgroundColor", "pollingId", "pollingInterval", VKApiUserFull.QUOTES, "title", "titleColor", "copy", "(Ljava/lang/String;Ljava/lang/String;JLjava/util/List;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/network/offer/osago/response/OsagoCompanyOrderResponse$Item;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitleColor", "getTitle", "Ljava/util/List;", "getQuotes", "getPollingId", "J", "getPollingInterval", "getBackgroundColor", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "Quote", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class Item {
        @SerializedName("backgroundColor")
        @NotNull
        private final String backgroundColor;
        @SerializedName("pollingId")
        @NotNull
        private final String pollingId;
        @SerializedName("pollingInterval")
        private final long pollingInterval;
        @SerializedName(VKApiUserFull.QUOTES)
        @NotNull
        private final List<Quote> quotes;
        @SerializedName("title")
        @NotNull
        private final String title;
        @SerializedName("titleColor")
        @NotNull
        private final String titleColor;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004¨\u0006\u0014"}, d2 = {"Lru/sravni/android/bankproduct/network/offer/osago/response/OsagoCompanyOrderResponse$Item$Quote;", "", "", "component1", "()Ljava/lang/String;", "text", "copy", "(Ljava/lang/String;)Lru/sravni/android/bankproduct/network/offer/osago/response/OsagoCompanyOrderResponse$Item$Quote;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getText", "<init>", "(Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
        public static final class Quote {
            @SerializedName("text")
            @NotNull
            private final String text;

            public Quote(@NotNull String str) {
                Intrinsics.checkParameterIsNotNull(str, "text");
                this.text = str;
            }

            public static /* synthetic */ Quote copy$default(Quote quote, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = quote.text;
                }
                return quote.copy(str);
            }

            @NotNull
            public final String component1() {
                return this.text;
            }

            @NotNull
            public final Quote copy(@NotNull String str) {
                Intrinsics.checkParameterIsNotNull(str, "text");
                return new Quote(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Quote) && Intrinsics.areEqual(this.text, ((Quote) obj).text);
                }
                return true;
            }

            @NotNull
            public final String getText() {
                return this.text;
            }

            public int hashCode() {
                String str = this.text;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                return a.t(a.L("Quote(text="), this.text, ")");
            }
        }

        public Item(@NotNull String str, @NotNull String str2, long j, @NotNull List<Quote> list, @NotNull String str3, @NotNull String str4) {
            Intrinsics.checkParameterIsNotNull(str, "backgroundColor");
            Intrinsics.checkParameterIsNotNull(str2, "pollingId");
            Intrinsics.checkParameterIsNotNull(list, VKApiUserFull.QUOTES);
            Intrinsics.checkParameterIsNotNull(str3, "title");
            Intrinsics.checkParameterIsNotNull(str4, "titleColor");
            this.backgroundColor = str;
            this.pollingId = str2;
            this.pollingInterval = j;
            this.quotes = list;
            this.title = str3;
            this.titleColor = str4;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: ru.sravni.android.bankproduct.network.offer.osago.response.OsagoCompanyOrderResponse$Item */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Item copy$default(Item item, String str, String str2, long j, List list, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = item.backgroundColor;
            }
            if ((i & 2) != 0) {
                str2 = item.pollingId;
            }
            if ((i & 4) != 0) {
                j = item.pollingInterval;
            }
            if ((i & 8) != 0) {
                list = item.quotes;
            }
            if ((i & 16) != 0) {
                str3 = item.title;
            }
            if ((i & 32) != 0) {
                str4 = item.titleColor;
            }
            return item.copy(str, str2, j, list, str3, str4);
        }

        @NotNull
        public final String component1() {
            return this.backgroundColor;
        }

        @NotNull
        public final String component2() {
            return this.pollingId;
        }

        public final long component3() {
            return this.pollingInterval;
        }

        @NotNull
        public final List<Quote> component4() {
            return this.quotes;
        }

        @NotNull
        public final String component5() {
            return this.title;
        }

        @NotNull
        public final String component6() {
            return this.titleColor;
        }

        @NotNull
        public final Item copy(@NotNull String str, @NotNull String str2, long j, @NotNull List<Quote> list, @NotNull String str3, @NotNull String str4) {
            Intrinsics.checkParameterIsNotNull(str, "backgroundColor");
            Intrinsics.checkParameterIsNotNull(str2, "pollingId");
            Intrinsics.checkParameterIsNotNull(list, VKApiUserFull.QUOTES);
            Intrinsics.checkParameterIsNotNull(str3, "title");
            Intrinsics.checkParameterIsNotNull(str4, "titleColor");
            return new Item(str, str2, j, list, str3, str4);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Item)) {
                return false;
            }
            Item item = (Item) obj;
            return Intrinsics.areEqual(this.backgroundColor, item.backgroundColor) && Intrinsics.areEqual(this.pollingId, item.pollingId) && this.pollingInterval == item.pollingInterval && Intrinsics.areEqual(this.quotes, item.quotes) && Intrinsics.areEqual(this.title, item.title) && Intrinsics.areEqual(this.titleColor, item.titleColor);
        }

        @NotNull
        public final String getBackgroundColor() {
            return this.backgroundColor;
        }

        @NotNull
        public final String getPollingId() {
            return this.pollingId;
        }

        public final long getPollingInterval() {
            return this.pollingInterval;
        }

        @NotNull
        public final List<Quote> getQuotes() {
            return this.quotes;
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
            String str2 = this.pollingId;
            int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + c.a(this.pollingInterval)) * 31;
            List<Quote> list = this.quotes;
            int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
            String str3 = this.title;
            int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.titleColor;
            if (str4 != null) {
                i = str4.hashCode();
            }
            return hashCode4 + i;
        }

        @NotNull
        public final OsagoCompanyOrderRepo toOsagoCompanyOrderRepo() {
            String str = this.pollingId;
            long j = this.pollingInterval;
            String str2 = this.backgroundColor;
            String str3 = this.titleColor;
            String str4 = this.title;
            List<Quote> list = this.quotes;
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getText());
            }
            return new OsagoCompanyOrderRepo(str2, str, j, arrayList, str4, str3);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Item(backgroundColor=");
            L.append(this.backgroundColor);
            L.append(", pollingId=");
            L.append(this.pollingId);
            L.append(", pollingInterval=");
            L.append(this.pollingInterval);
            L.append(", quotes=");
            L.append(this.quotes);
            L.append(", title=");
            L.append(this.title);
            L.append(", titleColor=");
            return a.t(L, this.titleColor, ")");
        }
    }

    public OsagoCompanyOrderResponse(@NotNull Item item2) {
        Intrinsics.checkParameterIsNotNull(item2, "item");
        this.item = item2;
    }

    public static /* synthetic */ OsagoCompanyOrderResponse copy$default(OsagoCompanyOrderResponse osagoCompanyOrderResponse, Item item2, int i, Object obj) {
        if ((i & 1) != 0) {
            item2 = osagoCompanyOrderResponse.item;
        }
        return osagoCompanyOrderResponse.copy(item2);
    }

    @NotNull
    public final Item component1() {
        return this.item;
    }

    @NotNull
    public final OsagoCompanyOrderResponse copy(@NotNull Item item2) {
        Intrinsics.checkParameterIsNotNull(item2, "item");
        return new OsagoCompanyOrderResponse(item2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof OsagoCompanyOrderResponse) && Intrinsics.areEqual(this.item, ((OsagoCompanyOrderResponse) obj).item);
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
        StringBuilder L = a.L("OsagoCompanyOrderResponse(item=");
        L.append(this.item);
        L.append(")");
        return L.toString();
    }
}
