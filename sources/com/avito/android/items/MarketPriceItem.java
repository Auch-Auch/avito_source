package com.avito.android.items;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\b\u0018\u00002\u00020\u0001:\u0002/0B;\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJN\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\u000f\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0004R!\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u000eR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\nR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u0007R\u0019\u0010\u0010\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010)\u001a\u0004\b,\u0010\u0007¨\u00061"}, d2 = {"Lcom/avito/android/items/MarketPriceItem;", "Lcom/avito/conveyor_item/Item;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/CharSequence;", "Lcom/avito/android/items/MarketPriceItem$DealTypeBlock;", "component3", "()Lcom/avito/android/items/MarketPriceItem$DealTypeBlock;", "component4", "", "component5", "()Ljava/util/List;", "stringId", "marketPrice", "dealTypeBlock", "message", "emptyDealType", "copy", "(Ljava/lang/String;Ljava/lang/CharSequence;Lcom/avito/android/items/MarketPriceItem$DealTypeBlock;Ljava/lang/CharSequence;Ljava/util/List;)Lcom/avito/android/items/MarketPriceItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "e", "Ljava/util/List;", "getEmptyDealType", "c", "Lcom/avito/android/items/MarketPriceItem$DealTypeBlock;", "getDealTypeBlock", "d", "Ljava/lang/CharSequence;", "getMessage", AuthSource.BOOKING_ORDER, "getMarketPrice", "<init>", "(Ljava/lang/String;Ljava/lang/CharSequence;Lcom/avito/android/items/MarketPriceItem$DealTypeBlock;Ljava/lang/CharSequence;Ljava/util/List;)V", "DealTypeBlock", "DealTypeImageName", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class MarketPriceItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final CharSequence b;
    @Nullable
    public final DealTypeBlock c;
    @Nullable
    public final CharSequence d;
    @Nullable
    public final List<String> e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ<\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0007J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u000bR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001c\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0007¨\u0006%"}, d2 = {"Lcom/avito/android/items/MarketPriceItem$DealTypeBlock;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "component3", "Lcom/avito/android/items/MarketPriceItem$DealTypeImageName;", "component4", "()Lcom/avito/android/items/MarketPriceItem$DealTypeImageName;", "title", "color", MessengerShareContentUtility.SUBTITLE, "image", "copy", "(Ljava/lang/String;ILjava/lang/String;Lcom/avito/android/items/MarketPriceItem$DealTypeImageName;)Lcom/avito/android/items/MarketPriceItem$DealTypeBlock;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "d", "Lcom/avito/android/items/MarketPriceItem$DealTypeImageName;", "getImage", "c", "Ljava/lang/String;", "getSubtitle", AuthSource.SEND_ABUSE, "getTitle", AuthSource.BOOKING_ORDER, "I", "getColor", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lcom/avito/android/items/MarketPriceItem$DealTypeImageName;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public static final class DealTypeBlock {
        @NotNull
        public final String a;
        public final int b;
        @Nullable
        public final String c;
        @Nullable
        public final DealTypeImageName d;

        public DealTypeBlock(@NotNull String str, int i, @Nullable String str2, @Nullable DealTypeImageName dealTypeImageName) {
            Intrinsics.checkNotNullParameter(str, "title");
            this.a = str;
            this.b = i;
            this.c = str2;
            this.d = dealTypeImageName;
        }

        public static /* synthetic */ DealTypeBlock copy$default(DealTypeBlock dealTypeBlock, String str, int i, String str2, DealTypeImageName dealTypeImageName, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = dealTypeBlock.a;
            }
            if ((i2 & 2) != 0) {
                i = dealTypeBlock.b;
            }
            if ((i2 & 4) != 0) {
                str2 = dealTypeBlock.c;
            }
            if ((i2 & 8) != 0) {
                dealTypeImageName = dealTypeBlock.d;
            }
            return dealTypeBlock.copy(str, i, str2, dealTypeImageName);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        public final int component2() {
            return this.b;
        }

        @Nullable
        public final String component3() {
            return this.c;
        }

        @Nullable
        public final DealTypeImageName component4() {
            return this.d;
        }

        @NotNull
        public final DealTypeBlock copy(@NotNull String str, int i, @Nullable String str2, @Nullable DealTypeImageName dealTypeImageName) {
            Intrinsics.checkNotNullParameter(str, "title");
            return new DealTypeBlock(str, i, str2, dealTypeImageName);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DealTypeBlock)) {
                return false;
            }
            DealTypeBlock dealTypeBlock = (DealTypeBlock) obj;
            return Intrinsics.areEqual(this.a, dealTypeBlock.a) && this.b == dealTypeBlock.b && Intrinsics.areEqual(this.c, dealTypeBlock.c) && Intrinsics.areEqual(this.d, dealTypeBlock.d);
        }

        public final int getColor() {
            return this.b;
        }

        @Nullable
        public final DealTypeImageName getImage() {
            return this.d;
        }

        @Nullable
        public final String getSubtitle() {
            return this.c;
        }

        @NotNull
        public final String getTitle() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.b) * 31;
            String str2 = this.c;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            DealTypeImageName dealTypeImageName = this.d;
            if (dealTypeImageName != null) {
                i = dealTypeImageName.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("DealTypeBlock(title=");
            L.append(this.a);
            L.append(", color=");
            L.append(this.b);
            L.append(", subtitle=");
            L.append(this.c);
            L.append(", image=");
            L.append(this.d);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/avito/android/items/MarketPriceItem$DealTypeImageName;", "", "<init>", "(Ljava/lang/String;I)V", "PERFECT", "VERY_GOOD", "GOOD", "BAD", "VERY_BAD", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public enum DealTypeImageName {
        PERFECT,
        VERY_GOOD,
        GOOD,
        BAD,
        VERY_BAD
    }

    public MarketPriceItem(@NotNull String str, @NotNull CharSequence charSequence, @Nullable DealTypeBlock dealTypeBlock, @Nullable CharSequence charSequence2, @Nullable List<String> list) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(charSequence, "marketPrice");
        this.a = str;
        this.b = charSequence;
        this.c = dealTypeBlock;
        this.d = charSequence2;
        this.e = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.android.items.MarketPriceItem */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MarketPriceItem copy$default(MarketPriceItem marketPriceItem, String str, CharSequence charSequence, DealTypeBlock dealTypeBlock, CharSequence charSequence2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = marketPriceItem.getStringId();
        }
        if ((i & 2) != 0) {
            charSequence = marketPriceItem.b;
        }
        if ((i & 4) != 0) {
            dealTypeBlock = marketPriceItem.c;
        }
        if ((i & 8) != 0) {
            charSequence2 = marketPriceItem.d;
        }
        if ((i & 16) != 0) {
            list = marketPriceItem.e;
        }
        return marketPriceItem.copy(str, charSequence, dealTypeBlock, charSequence2, list);
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    @NotNull
    public final CharSequence component2() {
        return this.b;
    }

    @Nullable
    public final DealTypeBlock component3() {
        return this.c;
    }

    @Nullable
    public final CharSequence component4() {
        return this.d;
    }

    @Nullable
    public final List<String> component5() {
        return this.e;
    }

    @NotNull
    public final MarketPriceItem copy(@NotNull String str, @NotNull CharSequence charSequence, @Nullable DealTypeBlock dealTypeBlock, @Nullable CharSequence charSequence2, @Nullable List<String> list) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(charSequence, "marketPrice");
        return new MarketPriceItem(str, charSequence, dealTypeBlock, charSequence2, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MarketPriceItem)) {
            return false;
        }
        MarketPriceItem marketPriceItem = (MarketPriceItem) obj;
        return Intrinsics.areEqual(getStringId(), marketPriceItem.getStringId()) && Intrinsics.areEqual(this.b, marketPriceItem.b) && Intrinsics.areEqual(this.c, marketPriceItem.c) && Intrinsics.areEqual(this.d, marketPriceItem.d) && Intrinsics.areEqual(this.e, marketPriceItem.e);
    }

    @Nullable
    public final DealTypeBlock getDealTypeBlock() {
        return this.c;
    }

    @Nullable
    public final List<String> getEmptyDealType() {
        return this.e;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @NotNull
    public final CharSequence getMarketPrice() {
        return this.b;
    }

    @Nullable
    public final CharSequence getMessage() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    public int hashCode() {
        String stringId = getStringId();
        int i = 0;
        int hashCode = (stringId != null ? stringId.hashCode() : 0) * 31;
        CharSequence charSequence = this.b;
        int hashCode2 = (hashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        DealTypeBlock dealTypeBlock = this.c;
        int hashCode3 = (hashCode2 + (dealTypeBlock != null ? dealTypeBlock.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.d;
        int hashCode4 = (hashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        List<String> list = this.e;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("MarketPriceItem(stringId=");
        L.append(getStringId());
        L.append(", marketPrice=");
        L.append(this.b);
        L.append(", dealTypeBlock=");
        L.append(this.c);
        L.append(", message=");
        L.append(this.d);
        L.append(", emptyDealType=");
        return a.w(L, this.e, ")");
    }
}
