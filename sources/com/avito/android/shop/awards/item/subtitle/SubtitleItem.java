package com.avito.android.shop.awards.item.subtitle;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/avito/android/shop/awards/item/subtitle/SubtitleItem;", "Lcom/avito/conveyor_item/Item;", "", "component1", "()Ljava/lang/String;", "component2", "stringId", MessengerShareContentUtility.SUBTITLE, "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/shop/awards/item/subtitle/SubtitleItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", AuthSource.BOOKING_ORDER, "getSubtitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class SubtitleItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final String b;

    public SubtitleItem(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, MessengerShareContentUtility.SUBTITLE);
        this.a = str;
        this.b = str2;
    }

    public static /* synthetic */ SubtitleItem copy$default(SubtitleItem subtitleItem, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subtitleItem.getStringId();
        }
        if ((i & 2) != 0) {
            str2 = subtitleItem.b;
        }
        return subtitleItem.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final SubtitleItem copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, MessengerShareContentUtility.SUBTITLE);
        return new SubtitleItem(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubtitleItem)) {
            return false;
        }
        SubtitleItem subtitleItem = (SubtitleItem) obj;
        return Intrinsics.areEqual(getStringId(), subtitleItem.getStringId()) && Intrinsics.areEqual(this.b, subtitleItem.b);
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @NotNull
    public final String getSubtitle() {
        return this.b;
    }

    public int hashCode() {
        String stringId = getStringId();
        int i = 0;
        int hashCode = (stringId != null ? stringId.hashCode() : 0) * 31;
        String str = this.b;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SubtitleItem(stringId=");
        L.append(getStringId());
        L.append(", subtitle=");
        return a.t(L, this.b, ")");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SubtitleItem(java.lang.String r1, java.lang.String r2, int r3, t6.r.a.j r4) {
        /*
            r0 = this;
            r4 = 1
            r3 = r3 & r4
            if (r3 == 0) goto L_0x000a
            com.avito.android.shop.awards.item.ShopAwardsItem r1 = com.avito.android.shop.awards.item.ShopAwardsItem.SUBTITLE
            java.lang.String r1 = java.lang.String.valueOf(r4)
        L_0x000a:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.shop.awards.item.subtitle.SubtitleItem.<init>(java.lang.String, java.lang.String, int, t6.r.a.j):void");
    }
}
