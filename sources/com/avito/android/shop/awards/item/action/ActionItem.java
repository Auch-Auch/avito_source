package com.avito.android.shop.awards.item.action;

import a2.b.a.a.a;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\bR\u001c\u0010\t\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u0004¨\u0006!"}, d2 = {"Lcom/avito/android/shop/awards/item/action/ActionItem;", "Lcom/avito/conveyor_item/Item;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/deep_linking/links/DeepLink;", "component3", "()Lcom/avito/android/deep_linking/links/DeepLink;", "stringId", "title", "deepLink", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/shop/awards/item/action/ActionItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "c", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", AuthSource.SEND_ABUSE, "getStringId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ActionItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final DeepLink c;

    public ActionItem(@NotNull String str, @NotNull String str2, @NotNull DeepLink deepLink) {
        a.W0(str, "stringId", str2, "title", deepLink, "deepLink");
        this.a = str;
        this.b = str2;
        this.c = deepLink;
    }

    public static /* synthetic */ ActionItem copy$default(ActionItem actionItem, String str, String str2, DeepLink deepLink, int i, Object obj) {
        if ((i & 1) != 0) {
            str = actionItem.getStringId();
        }
        if ((i & 2) != 0) {
            str2 = actionItem.b;
        }
        if ((i & 4) != 0) {
            deepLink = actionItem.c;
        }
        return actionItem.copy(str, str2, deepLink);
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
    public final DeepLink component3() {
        return this.c;
    }

    @NotNull
    public final ActionItem copy(@NotNull String str, @NotNull String str2, @NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        return new ActionItem(str, str2, deepLink);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActionItem)) {
            return false;
        }
        ActionItem actionItem = (ActionItem) obj;
        return Intrinsics.areEqual(getStringId(), actionItem.getStringId()) && Intrinsics.areEqual(this.b, actionItem.b) && Intrinsics.areEqual(this.c, actionItem.c);
    }

    @NotNull
    public final DeepLink getDeepLink() {
        return this.c;
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
    public final String getTitle() {
        return this.b;
    }

    public int hashCode() {
        String stringId = getStringId();
        int i = 0;
        int hashCode = (stringId != null ? stringId.hashCode() : 0) * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        DeepLink deepLink = this.c;
        if (deepLink != null) {
            i = deepLink.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ActionItem(stringId=");
        L.append(getStringId());
        L.append(", title=");
        L.append(this.b);
        L.append(", deepLink=");
        return a.m(L, this.c, ")");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ActionItem(java.lang.String r1, java.lang.String r2, com.avito.android.deep_linking.links.DeepLink r3, int r4, t6.r.a.j r5) {
        /*
            r0 = this;
            r4 = r4 & 1
            if (r4 == 0) goto L_0x000b
            com.avito.android.shop.awards.item.ShopAwardsItem r1 = com.avito.android.shop.awards.item.ShopAwardsItem.ACTION
            r1 = 3
            java.lang.String r1 = java.lang.String.valueOf(r1)
        L_0x000b:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.shop.awards.item.action.ActionItem.<init>(java.lang.String, java.lang.String, com.avito.android.deep_linking.links.DeepLink, int, t6.r.a.j):void");
    }
}
