package com.avito.android.items;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.slot.market_price.MarketPriceResponse;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJH\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0011\u001a\u00020\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\u000f\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\nR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\rR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010&\u001a\u0004\b)\u0010\rR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u0007¨\u0006/"}, d2 = {"Lcom/avito/android/items/MarketPriceV2Item;", "Lcom/avito/conveyor_item/Item;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/text/AttributedText;", "component2", "()Lcom/avito/android/remote/model/text/AttributedText;", "Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$PriceRangeV2;", "component3", "()Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$PriceRangeV2;", "", "component4", "()Ljava/lang/Long;", "component5", "stringId", "priceDetails", "priceRange", "marketPrice", "userPrice", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$PriceRangeV2;Ljava/lang/Long;Ljava/lang/Long;)Lcom/avito/android/items/MarketPriceV2Item;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "c", "Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$PriceRangeV2;", "getPriceRange", "e", "Ljava/lang/Long;", "getUserPrice", "d", "getMarketPrice", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/text/AttributedText;", "getPriceDetails", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/category_parameters/slot/market_price/MarketPriceResponse$PriceRangeV2;Ljava/lang/Long;Ljava/lang/Long;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class MarketPriceV2Item implements Item {
    @NotNull
    public final String a;
    @Nullable
    public final AttributedText b;
    @NotNull
    public final MarketPriceResponse.PriceRangeV2 c;
    @Nullable
    public final Long d;
    @Nullable
    public final Long e;

    public MarketPriceV2Item(@NotNull String str, @Nullable AttributedText attributedText, @NotNull MarketPriceResponse.PriceRangeV2 priceRangeV2, @Nullable Long l, @Nullable Long l2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(priceRangeV2, "priceRange");
        this.a = str;
        this.b = attributedText;
        this.c = priceRangeV2;
        this.d = l;
        this.e = l2;
    }

    public static /* synthetic */ MarketPriceV2Item copy$default(MarketPriceV2Item marketPriceV2Item, String str, AttributedText attributedText, MarketPriceResponse.PriceRangeV2 priceRangeV2, Long l, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = marketPriceV2Item.getStringId();
        }
        if ((i & 2) != 0) {
            attributedText = marketPriceV2Item.b;
        }
        if ((i & 4) != 0) {
            priceRangeV2 = marketPriceV2Item.c;
        }
        if ((i & 8) != 0) {
            l = marketPriceV2Item.d;
        }
        if ((i & 16) != 0) {
            l2 = marketPriceV2Item.e;
        }
        return marketPriceV2Item.copy(str, attributedText, priceRangeV2, l, l2);
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    @Nullable
    public final AttributedText component2() {
        return this.b;
    }

    @NotNull
    public final MarketPriceResponse.PriceRangeV2 component3() {
        return this.c;
    }

    @Nullable
    public final Long component4() {
        return this.d;
    }

    @Nullable
    public final Long component5() {
        return this.e;
    }

    @NotNull
    public final MarketPriceV2Item copy(@NotNull String str, @Nullable AttributedText attributedText, @NotNull MarketPriceResponse.PriceRangeV2 priceRangeV2, @Nullable Long l, @Nullable Long l2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(priceRangeV2, "priceRange");
        return new MarketPriceV2Item(str, attributedText, priceRangeV2, l, l2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MarketPriceV2Item)) {
            return false;
        }
        MarketPriceV2Item marketPriceV2Item = (MarketPriceV2Item) obj;
        return Intrinsics.areEqual(getStringId(), marketPriceV2Item.getStringId()) && Intrinsics.areEqual(this.b, marketPriceV2Item.b) && Intrinsics.areEqual(this.c, marketPriceV2Item.c) && Intrinsics.areEqual(this.d, marketPriceV2Item.d) && Intrinsics.areEqual(this.e, marketPriceV2Item.e);
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Nullable
    public final Long getMarketPrice() {
        return this.d;
    }

    @Nullable
    public final AttributedText getPriceDetails() {
        return this.b;
    }

    @NotNull
    public final MarketPriceResponse.PriceRangeV2 getPriceRange() {
        return this.c;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Nullable
    public final Long getUserPrice() {
        return this.e;
    }

    public int hashCode() {
        String stringId = getStringId();
        int i = 0;
        int hashCode = (stringId != null ? stringId.hashCode() : 0) * 31;
        AttributedText attributedText = this.b;
        int hashCode2 = (hashCode + (attributedText != null ? attributedText.hashCode() : 0)) * 31;
        MarketPriceResponse.PriceRangeV2 priceRangeV2 = this.c;
        int hashCode3 = (hashCode2 + (priceRangeV2 != null ? priceRangeV2.hashCode() : 0)) * 31;
        Long l = this.d;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.e;
        if (l2 != null) {
            i = l2.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("MarketPriceV2Item(stringId=");
        L.append(getStringId());
        L.append(", priceDetails=");
        L.append(this.b);
        L.append(", priceRange=");
        L.append(this.c);
        L.append(", marketPrice=");
        L.append(this.d);
        L.append(", userPrice=");
        L.append(this.e);
        L.append(")");
        return L.toString();
    }
}
