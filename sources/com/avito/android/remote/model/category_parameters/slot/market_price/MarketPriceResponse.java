package com.avito.android.remote.model.category_parameters.slot.market_price;

import a2.b.a.a.a;
import com.avito.android.remote.model.PriceBadge;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.remote.model.badge.Badge;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.ErrorBundle;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0005\u0019\u001a\u001b\u001c\u001dB3\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u00020\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse;", "", "", "Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$PriceRange;", "priceRanges", "Ljava/util/List;", "getPriceRanges", "()Ljava/util/List;", "Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$PriceDescription;", "priceDescription", "Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$PriceDescription;", "getPriceDescription", "()Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$PriceDescription;", "Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$MarketPrice;", "marketPrice", "Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$MarketPrice;", "getMarketPrice", "()Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$MarketPrice;", "Lcom/avito/android/remote/model/text/AttributedText;", "text", "Lcom/avito/android/remote/model/text/AttributedText;", "getText", "()Lcom/avito/android/remote/model/text/AttributedText;", "<init>", "(Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$MarketPrice;Lcom/avito/android/remote/model/text/AttributedText;Ljava/util/List;Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$PriceDescription;)V", "MarketPrice", "MarketPriceBadge", "PriceDescription", "PriceRange", "PriceRangeV2", "models_release"}, k = 1, mv = {1, 4, 2})
public final class MarketPriceResponse {
    @SerializedName("marketPrice")
    @NotNull
    private final MarketPrice marketPrice;
    @SerializedName("priceDescription")
    @Nullable
    private final PriceDescription priceDescription;
    @SerializedName("priceRanges")
    @Nullable
    private final List<PriceRange> priceRanges;
    @SerializedName("text")
    @Nullable
    private final AttributedText text;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$MarketPrice;", "", "", "price", "J", "getPrice", "()J", "Lcom/avito/android/remote/model/text/AttributedText;", "formattedPrice", "Lcom/avito/android/remote/model/text/AttributedText;", "getFormattedPrice", "()Lcom/avito/android/remote/model/text/AttributedText;", "<init>", "(JLcom/avito/android/remote/model/text/AttributedText;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class MarketPrice {
        @SerializedName("formattedPrice")
        @NotNull
        private final AttributedText formattedPrice;
        @SerializedName("price")
        private final long price;

        public MarketPrice(long j, @NotNull AttributedText attributedText) {
            Intrinsics.checkNotNullParameter(attributedText, "formattedPrice");
            this.price = j;
            this.formattedPrice = attributedText;
        }

        @NotNull
        public final AttributedText getFormattedPrice() {
            return this.formattedPrice;
        }

        public final long getPrice() {
            return this.price;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\n\u001a\u00020\u00058\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0019\u0010\u0007R\u001c\u0010\t\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$MarketPriceBadge;", "Lcom/avito/android/remote/model/badge/Badge;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/UniversalColor;", "component2", "()Lcom/avito/android/remote/model/UniversalColor;", "component3", "title", "universalTitleColor", "universalBackgroundColor", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/UniversalColor;)Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$MarketPriceBadge;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/remote/model/UniversalColor;", "getUniversalTitleColor", "getUniversalBackgroundColor", "Ljava/lang/String;", "getTitle", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/UniversalColor;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class MarketPriceBadge implements Badge {
        @SerializedName("title")
        @NotNull
        private final String title;
        @SerializedName("backgroundColor")
        @Nullable
        private final UniversalColor universalBackgroundColor;
        @SerializedName("titleColor")
        @NotNull
        private final UniversalColor universalTitleColor;

        public MarketPriceBadge(@NotNull String str, @NotNull UniversalColor universalColor, @Nullable UniversalColor universalColor2) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(universalColor, "universalTitleColor");
            this.title = str;
            this.universalTitleColor = universalColor;
            this.universalBackgroundColor = universalColor2;
        }

        public static /* synthetic */ MarketPriceBadge copy$default(MarketPriceBadge marketPriceBadge, String str, UniversalColor universalColor, UniversalColor universalColor2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = marketPriceBadge.getTitle();
            }
            if ((i & 2) != 0) {
                universalColor = marketPriceBadge.getUniversalTitleColor();
            }
            if ((i & 4) != 0) {
                universalColor2 = marketPriceBadge.getUniversalBackgroundColor();
            }
            return marketPriceBadge.copy(str, universalColor, universalColor2);
        }

        @NotNull
        public final String component1() {
            return getTitle();
        }

        @NotNull
        public final UniversalColor component2() {
            return getUniversalTitleColor();
        }

        @Nullable
        public final UniversalColor component3() {
            return getUniversalBackgroundColor();
        }

        @NotNull
        public final MarketPriceBadge copy(@NotNull String str, @NotNull UniversalColor universalColor, @Nullable UniversalColor universalColor2) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(universalColor, "universalTitleColor");
            return new MarketPriceBadge(str, universalColor, universalColor2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MarketPriceBadge)) {
                return false;
            }
            MarketPriceBadge marketPriceBadge = (MarketPriceBadge) obj;
            return Intrinsics.areEqual(getTitle(), marketPriceBadge.getTitle()) && Intrinsics.areEqual(getUniversalTitleColor(), marketPriceBadge.getUniversalTitleColor()) && Intrinsics.areEqual(getUniversalBackgroundColor(), marketPriceBadge.getUniversalBackgroundColor());
        }

        @Override // com.avito.android.remote.model.badge.Badge
        @NotNull
        public String getTitle() {
            return this.title;
        }

        @Override // com.avito.android.remote.model.badge.Badge
        @Nullable
        public UniversalColor getUniversalBackgroundColor() {
            return this.universalBackgroundColor;
        }

        @Override // com.avito.android.remote.model.badge.Badge
        @NotNull
        public UniversalColor getUniversalTitleColor() {
            return this.universalTitleColor;
        }

        public int hashCode() {
            String title2 = getTitle();
            int i = 0;
            int hashCode = (title2 != null ? title2.hashCode() : 0) * 31;
            UniversalColor universalTitleColor2 = getUniversalTitleColor();
            int hashCode2 = (hashCode + (universalTitleColor2 != null ? universalTitleColor2.hashCode() : 0)) * 31;
            UniversalColor universalBackgroundColor2 = getUniversalBackgroundColor();
            if (universalBackgroundColor2 != null) {
                i = universalBackgroundColor2.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("MarketPriceBadge(title=");
            L.append(getTitle());
            L.append(", universalTitleColor=");
            L.append(getUniversalTitleColor());
            L.append(", universalBackgroundColor=");
            L.append(getUniversalBackgroundColor());
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJB\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0015\u0010\nJ\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b\u001e\u0010\u000eR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010\nR\u001c\u0010\u000f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b\"\u0010\u0004R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010#\u001a\u0004\b$\u0010\u0007¨\u0006'"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$PriceDescription;", "", "", "component1", "()J", "Lcom/avito/android/remote/model/text/AttributedText;", "component2", "()Lcom/avito/android/remote/model/text/AttributedText;", "", "component3", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$PriceRangeV2;", "component4", "()Ljava/util/List;", "priceHigh", ErrorBundle.DETAIL_ENTRY, "emptyDescription", "ranges", "copy", "(JLcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$PriceDescription;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getRanges", "Ljava/lang/String;", "getEmptyDescription", "J", "getPriceHigh", "Lcom/avito/android/remote/model/text/AttributedText;", "getDetails", "<init>", "(JLcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Ljava/util/List;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class PriceDescription {
        @SerializedName(ErrorBundle.DETAIL_ENTRY)
        @Nullable
        private final AttributedText details;
        @SerializedName("emptyDescription")
        @Nullable
        private final String emptyDescription;
        @SerializedName("priceHigh")
        private final long priceHigh;
        @SerializedName("priceRanges")
        @NotNull
        private final List<PriceRangeV2> ranges;

        public PriceDescription(long j, @Nullable AttributedText attributedText, @Nullable String str, @NotNull List<PriceRangeV2> list) {
            Intrinsics.checkNotNullParameter(list, "ranges");
            this.priceHigh = j;
            this.details = attributedText;
            this.emptyDescription = str;
            this.ranges = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.avito.android.remote.model.category_parameters.slot.market_price.MarketPriceResponse$PriceDescription */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PriceDescription copy$default(PriceDescription priceDescription, long j, AttributedText attributedText, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                j = priceDescription.priceHigh;
            }
            if ((i & 2) != 0) {
                attributedText = priceDescription.details;
            }
            if ((i & 4) != 0) {
                str = priceDescription.emptyDescription;
            }
            if ((i & 8) != 0) {
                list = priceDescription.ranges;
            }
            return priceDescription.copy(j, attributedText, str, list);
        }

        public final long component1() {
            return this.priceHigh;
        }

        @Nullable
        public final AttributedText component2() {
            return this.details;
        }

        @Nullable
        public final String component3() {
            return this.emptyDescription;
        }

        @NotNull
        public final List<PriceRangeV2> component4() {
            return this.ranges;
        }

        @NotNull
        public final PriceDescription copy(long j, @Nullable AttributedText attributedText, @Nullable String str, @NotNull List<PriceRangeV2> list) {
            Intrinsics.checkNotNullParameter(list, "ranges");
            return new PriceDescription(j, attributedText, str, list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PriceDescription)) {
                return false;
            }
            PriceDescription priceDescription = (PriceDescription) obj;
            return this.priceHigh == priceDescription.priceHigh && Intrinsics.areEqual(this.details, priceDescription.details) && Intrinsics.areEqual(this.emptyDescription, priceDescription.emptyDescription) && Intrinsics.areEqual(this.ranges, priceDescription.ranges);
        }

        @Nullable
        public final AttributedText getDetails() {
            return this.details;
        }

        @Nullable
        public final String getEmptyDescription() {
            return this.emptyDescription;
        }

        public final long getPriceHigh() {
            return this.priceHigh;
        }

        @NotNull
        public final List<PriceRangeV2> getRanges() {
            return this.ranges;
        }

        public int hashCode() {
            int a = c.a(this.priceHigh) * 31;
            AttributedText attributedText = this.details;
            int i = 0;
            int hashCode = (a + (attributedText != null ? attributedText.hashCode() : 0)) * 31;
            String str = this.emptyDescription;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            List<PriceRangeV2> list = this.ranges;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("PriceDescription(priceHigh=");
            L.append(this.priceHigh);
            L.append(", details=");
            L.append(this.details);
            L.append(", emptyDescription=");
            L.append(this.emptyDescription);
            L.append(", ranges=");
            return a.w(L, this.ranges, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJF\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0013\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0016\u0010\bJ\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0013\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b\u001f\u0010\u000eR\u001c\u0010\u000f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b!\u0010\u0004R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b#\u0010\u000bR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b%\u0010\bR\u001c\u0010\u0010\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b&\u0010\u0004¨\u0006)"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$PriceRange;", "", "", "component1", "()J", "component2", "", "component3", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/PriceBadge;", "component4", "()Lcom/avito/android/remote/model/PriceBadge;", "Lcom/avito/android/remote/model/text/AttributedText;", "component5", "()Lcom/avito/android/remote/model/text/AttributedText;", "min", "max", "priceType", "priceBadge", "disclaimer", "copy", "(JJLjava/lang/String;Lcom/avito/android/remote/model/PriceBadge;Lcom/avito/android/remote/model/text/AttributedText;)Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$PriceRange;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/remote/model/text/AttributedText;", "getDisclaimer", "J", "getMin", "Lcom/avito/android/remote/model/PriceBadge;", "getPriceBadge", "Ljava/lang/String;", "getPriceType", "getMax", "<init>", "(JJLjava/lang/String;Lcom/avito/android/remote/model/PriceBadge;Lcom/avito/android/remote/model/text/AttributedText;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class PriceRange {
        @SerializedName("disclaimer")
        @NotNull
        private final AttributedText disclaimer;
        @SerializedName("max")
        private final long max;
        @SerializedName("min")
        private final long min;
        @SerializedName("priceBadge")
        @Nullable
        private final PriceBadge priceBadge;
        @SerializedName("priceType")
        @Nullable
        private final String priceType;

        public PriceRange(long j, long j2, @Nullable String str, @Nullable PriceBadge priceBadge2, @NotNull AttributedText attributedText) {
            Intrinsics.checkNotNullParameter(attributedText, "disclaimer");
            this.min = j;
            this.max = j2;
            this.priceType = str;
            this.priceBadge = priceBadge2;
            this.disclaimer = attributedText;
        }

        public static /* synthetic */ PriceRange copy$default(PriceRange priceRange, long j, long j2, String str, PriceBadge priceBadge2, AttributedText attributedText, int i, Object obj) {
            return priceRange.copy((i & 1) != 0 ? priceRange.min : j, (i & 2) != 0 ? priceRange.max : j2, (i & 4) != 0 ? priceRange.priceType : str, (i & 8) != 0 ? priceRange.priceBadge : priceBadge2, (i & 16) != 0 ? priceRange.disclaimer : attributedText);
        }

        public final long component1() {
            return this.min;
        }

        public final long component2() {
            return this.max;
        }

        @Nullable
        public final String component3() {
            return this.priceType;
        }

        @Nullable
        public final PriceBadge component4() {
            return this.priceBadge;
        }

        @NotNull
        public final AttributedText component5() {
            return this.disclaimer;
        }

        @NotNull
        public final PriceRange copy(long j, long j2, @Nullable String str, @Nullable PriceBadge priceBadge2, @NotNull AttributedText attributedText) {
            Intrinsics.checkNotNullParameter(attributedText, "disclaimer");
            return new PriceRange(j, j2, str, priceBadge2, attributedText);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PriceRange)) {
                return false;
            }
            PriceRange priceRange = (PriceRange) obj;
            return this.min == priceRange.min && this.max == priceRange.max && Intrinsics.areEqual(this.priceType, priceRange.priceType) && Intrinsics.areEqual(this.priceBadge, priceRange.priceBadge) && Intrinsics.areEqual(this.disclaimer, priceRange.disclaimer);
        }

        @NotNull
        public final AttributedText getDisclaimer() {
            return this.disclaimer;
        }

        public final long getMax() {
            return this.max;
        }

        public final long getMin() {
            return this.min;
        }

        @Nullable
        public final PriceBadge getPriceBadge() {
            return this.priceBadge;
        }

        @Nullable
        public final String getPriceType() {
            return this.priceType;
        }

        public int hashCode() {
            int a = ((c.a(this.min) * 31) + c.a(this.max)) * 31;
            String str = this.priceType;
            int i = 0;
            int hashCode = (a + (str != null ? str.hashCode() : 0)) * 31;
            PriceBadge priceBadge2 = this.priceBadge;
            int hashCode2 = (hashCode + (priceBadge2 != null ? priceBadge2.hashCode() : 0)) * 31;
            AttributedText attributedText = this.disclaimer;
            if (attributedText != null) {
                i = attributedText.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("PriceRange(min=");
            L.append(this.min);
            L.append(", max=");
            L.append(this.max);
            L.append(", priceType=");
            L.append(this.priceType);
            L.append(", priceBadge=");
            L.append(this.priceBadge);
            L.append(", disclaimer=");
            L.append(this.disclaimer);
            L.append(")");
            return L.toString();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PriceRange(long j, long j2, String str, PriceBadge priceBadge2, AttributedText attributedText, int i, j jVar) {
            this(j, j2, (i & 4) != 0 ? null : str, priceBadge2, attributedText);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b6\u00107J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u000bJp\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0019\u001a\u00020\t2\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\tHÖ\u0001¢\u0006\u0004\b \u0010\u000bJ\u0010\u0010\"\u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b&\u0010'R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010(\u001a\u0004\b)\u0010\bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010*\u001a\u0004\b+\u0010\u0014R\u001c\u0010\u0017\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010,\u001a\u0004\b-\u0010\u0004R\u001c\u0010\u0019\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010.\u001a\u0004\b/\u0010\u000bR\u001c\u0010\u0016\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010,\u001a\u0004\b0\u0010\u0004R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010.\u001a\u0004\b1\u0010\u000bR$\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u00102\u001a\u0004\b3\u0010\u000eR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u000f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u00104\u001a\u0004\b5\u0010\u0011¨\u00068"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$PriceRangeV2;", "", "", "component1", "()J", "component2", "Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceNoticeType;", "component3", "()Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceNoticeType;", "", "component4", "()Ljava/lang/String;", "", "component5", "()Ljava/util/List;", "Lcom/avito/android/remote/model/UniversalColor;", "component6", "()Lcom/avito/android/remote/model/UniversalColor;", "Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$MarketPriceBadge;", "component7", "()Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$MarketPriceBadge;", "component8", "min", "max", "type", "description", "notices", "noticeColor", "priceBadge", "callout", "copy", "(JJLcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceNoticeType;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$MarketPriceBadge;Ljava/lang/String;)Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$PriceRangeV2;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceNoticeType;", "getType", "Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$MarketPriceBadge;", "getPriceBadge", "J", "getMax", "Ljava/lang/String;", "getDescription", "getMin", "getCallout", "Ljava/util/List;", "getNotices", "Lcom/avito/android/remote/model/UniversalColor;", "getNoticeColor", "<init>", "(JJLcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceNoticeType;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$MarketPriceBadge;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class PriceRangeV2 {
        @SerializedName("callout")
        @Nullable
        private final String callout;
        @SerializedName("description")
        @NotNull
        private final String description;
        @SerializedName("max")
        private final long max;
        @SerializedName("min")
        private final long min;
        @SerializedName("noticeColor")
        @Nullable
        private final UniversalColor noticeColor;
        @SerializedName("notices")
        @Nullable
        private final List<String> notices;
        @SerializedName("priceBadge")
        @Nullable
        private final MarketPriceBadge priceBadge;
        @SerializedName("type")
        @Nullable
        private final MarketPriceNoticeType type;

        public PriceRangeV2(long j, long j2, @Nullable MarketPriceNoticeType marketPriceNoticeType, @NotNull String str, @Nullable List<String> list, @Nullable UniversalColor universalColor, @Nullable MarketPriceBadge marketPriceBadge, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(str, "description");
            this.min = j;
            this.max = j2;
            this.type = marketPriceNoticeType;
            this.description = str;
            this.notices = list;
            this.noticeColor = universalColor;
            this.priceBadge = marketPriceBadge;
            this.callout = str2;
        }

        public static /* synthetic */ PriceRangeV2 copy$default(PriceRangeV2 priceRangeV2, long j, long j2, MarketPriceNoticeType marketPriceNoticeType, String str, List list, UniversalColor universalColor, MarketPriceBadge marketPriceBadge, String str2, int i, Object obj) {
            return priceRangeV2.copy((i & 1) != 0 ? priceRangeV2.min : j, (i & 2) != 0 ? priceRangeV2.max : j2, (i & 4) != 0 ? priceRangeV2.type : marketPriceNoticeType, (i & 8) != 0 ? priceRangeV2.description : str, (i & 16) != 0 ? priceRangeV2.notices : list, (i & 32) != 0 ? priceRangeV2.noticeColor : universalColor, (i & 64) != 0 ? priceRangeV2.priceBadge : marketPriceBadge, (i & 128) != 0 ? priceRangeV2.callout : str2);
        }

        public final long component1() {
            return this.min;
        }

        public final long component2() {
            return this.max;
        }

        @Nullable
        public final MarketPriceNoticeType component3() {
            return this.type;
        }

        @NotNull
        public final String component4() {
            return this.description;
        }

        @Nullable
        public final List<String> component5() {
            return this.notices;
        }

        @Nullable
        public final UniversalColor component6() {
            return this.noticeColor;
        }

        @Nullable
        public final MarketPriceBadge component7() {
            return this.priceBadge;
        }

        @Nullable
        public final String component8() {
            return this.callout;
        }

        @NotNull
        public final PriceRangeV2 copy(long j, long j2, @Nullable MarketPriceNoticeType marketPriceNoticeType, @NotNull String str, @Nullable List<String> list, @Nullable UniversalColor universalColor, @Nullable MarketPriceBadge marketPriceBadge, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(str, "description");
            return new PriceRangeV2(j, j2, marketPriceNoticeType, str, list, universalColor, marketPriceBadge, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PriceRangeV2)) {
                return false;
            }
            PriceRangeV2 priceRangeV2 = (PriceRangeV2) obj;
            return this.min == priceRangeV2.min && this.max == priceRangeV2.max && Intrinsics.areEqual(this.type, priceRangeV2.type) && Intrinsics.areEqual(this.description, priceRangeV2.description) && Intrinsics.areEqual(this.notices, priceRangeV2.notices) && Intrinsics.areEqual(this.noticeColor, priceRangeV2.noticeColor) && Intrinsics.areEqual(this.priceBadge, priceRangeV2.priceBadge) && Intrinsics.areEqual(this.callout, priceRangeV2.callout);
        }

        @Nullable
        public final String getCallout() {
            return this.callout;
        }

        @NotNull
        public final String getDescription() {
            return this.description;
        }

        public final long getMax() {
            return this.max;
        }

        public final long getMin() {
            return this.min;
        }

        @Nullable
        public final UniversalColor getNoticeColor() {
            return this.noticeColor;
        }

        @Nullable
        public final List<String> getNotices() {
            return this.notices;
        }

        @Nullable
        public final MarketPriceBadge getPriceBadge() {
            return this.priceBadge;
        }

        @Nullable
        public final MarketPriceNoticeType getType() {
            return this.type;
        }

        public int hashCode() {
            int a = ((c.a(this.min) * 31) + c.a(this.max)) * 31;
            MarketPriceNoticeType marketPriceNoticeType = this.type;
            int i = 0;
            int hashCode = (a + (marketPriceNoticeType != null ? marketPriceNoticeType.hashCode() : 0)) * 31;
            String str = this.description;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            List<String> list = this.notices;
            int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
            UniversalColor universalColor = this.noticeColor;
            int hashCode4 = (hashCode3 + (universalColor != null ? universalColor.hashCode() : 0)) * 31;
            MarketPriceBadge marketPriceBadge = this.priceBadge;
            int hashCode5 = (hashCode4 + (marketPriceBadge != null ? marketPriceBadge.hashCode() : 0)) * 31;
            String str2 = this.callout;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode5 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("PriceRangeV2(min=");
            L.append(this.min);
            L.append(", max=");
            L.append(this.max);
            L.append(", type=");
            L.append(this.type);
            L.append(", description=");
            L.append(this.description);
            L.append(", notices=");
            L.append(this.notices);
            L.append(", noticeColor=");
            L.append(this.noticeColor);
            L.append(", priceBadge=");
            L.append(this.priceBadge);
            L.append(", callout=");
            return a.t(L, this.callout, ")");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PriceRangeV2(long j, long j2, MarketPriceNoticeType marketPriceNoticeType, String str, List list, UniversalColor universalColor, MarketPriceBadge marketPriceBadge, String str2, int i, j jVar) {
            this(j, j2, (i & 4) != 0 ? null : marketPriceNoticeType, str, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : universalColor, (i & 64) != 0 ? null : marketPriceBadge, (i & 128) != 0 ? null : str2);
        }
    }

    public MarketPriceResponse(@NotNull MarketPrice marketPrice2, @Nullable AttributedText attributedText, @Nullable List<PriceRange> list, @Nullable PriceDescription priceDescription2) {
        Intrinsics.checkNotNullParameter(marketPrice2, "marketPrice");
        this.marketPrice = marketPrice2;
        this.text = attributedText;
        this.priceRanges = list;
        this.priceDescription = priceDescription2;
    }

    @NotNull
    public final MarketPrice getMarketPrice() {
        return this.marketPrice;
    }

    @Nullable
    public final PriceDescription getPriceDescription() {
        return this.priceDescription;
    }

    @Nullable
    public final List<PriceRange> getPriceRanges() {
        return this.priceRanges;
    }

    @Nullable
    public final AttributedText getText() {
        return this.text;
    }
}
