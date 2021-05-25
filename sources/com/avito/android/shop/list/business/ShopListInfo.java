package com.avito.android.shop.list.business;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.LinkAction;
import com.avito.android.remote.model.ShopsListResult;
import com.avito.android.remote.model.Shortcuts;
import com.avito.android.util.ParcelUtils;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u0000 32\u00020\u0001:\u00013BA\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b\u0012\u0006\u0010\u001a\u001a\u00020\u0011\u0012\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014¢\u0006\u0004\b1\u00102J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000bHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000eJ\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017JR\u0010\u001c\u001a\u00020\u00002\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u00112\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b \u0010\nJ\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b$\u0010%R'\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0017R\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u000eR\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010*\u001a\u0004\b-\u0010\u000eR\u0019\u0010\u001a\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\u0013¨\u00064"}, d2 = {"Lcom/avito/android/shop/list/business/ShopListInfo;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "Lcom/avito/android/remote/model/ShopsListResult$Shop;", "component1", "()Ljava/util/List;", "Lcom/avito/android/remote/model/LinkAction;", "component2", "Lcom/avito/android/remote/model/Shortcuts;", "component3", "()Lcom/avito/android/remote/model/Shortcuts;", "", "", "component4", "()Ljava/util/Map;", "shopList", "shopActions", ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS, "firebaseParams", "copy", "(Ljava/util/List;Ljava/util/List;Lcom/avito/android/remote/model/Shortcuts;Ljava/util/Map;)Lcom/avito/android/shop/list/business/ShopListInfo;", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "d", "Ljava/util/Map;", "getFirebaseParams", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getShopActions", AuthSource.SEND_ABUSE, "getShopList", "c", "Lcom/avito/android/remote/model/Shortcuts;", "getShortcuts", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/avito/android/remote/model/Shortcuts;Ljava/util/Map;)V", "Companion", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopListInfo implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ShopListInfo> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final List<ShopsListResult.Shop> a;
    @NotNull
    public final List<LinkAction> b;
    @NotNull
    public final Shortcuts c;
    @Nullable
    public final Map<String, String> d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/shop/list/business/ShopListInfo$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/shop/list/business/ShopListInfo;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, ShopListInfo> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ShopListInfo invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            List createParcelableList = ParcelsKt.createParcelableList(parcel2, ShopsListResult.Shop.class);
            if (createParcelableList == null) {
                createParcelableList = CollectionsKt__CollectionsKt.emptyList();
            }
            List createParcelableList2 = ParcelsKt.createParcelableList(parcel2, LinkAction.class);
            if (createParcelableList2 == null) {
                createParcelableList2 = CollectionsKt__CollectionsKt.emptyList();
            }
            return new ShopListInfo(createParcelableList, createParcelableList2, (Shortcuts) a2.b.a.a.a.z1(Shortcuts.class, parcel2), ParcelUtils.createValueMap(parcel2, String.class, String.class));
        }
    }

    public ShopListInfo(@NotNull List<ShopsListResult.Shop> list, @NotNull List<LinkAction> list2, @NotNull Shortcuts shortcuts, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(list, "shopList");
        Intrinsics.checkNotNullParameter(list2, "shopActions");
        Intrinsics.checkNotNullParameter(shortcuts, ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS);
        this.a = list;
        this.b = list2;
        this.c = shortcuts;
        this.d = map;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.shop.list.business.ShopListInfo */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShopListInfo copy$default(ShopListInfo shopListInfo, List list, List list2, Shortcuts shortcuts, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            list = shopListInfo.a;
        }
        if ((i & 2) != 0) {
            list2 = shopListInfo.b;
        }
        if ((i & 4) != 0) {
            shortcuts = shopListInfo.c;
        }
        if ((i & 8) != 0) {
            map = shopListInfo.d;
        }
        return shopListInfo.copy(list, list2, shortcuts, map);
    }

    @NotNull
    public final List<ShopsListResult.Shop> component1() {
        return this.a;
    }

    @NotNull
    public final List<LinkAction> component2() {
        return this.b;
    }

    @NotNull
    public final Shortcuts component3() {
        return this.c;
    }

    @Nullable
    public final Map<String, String> component4() {
        return this.d;
    }

    @NotNull
    public final ShopListInfo copy(@NotNull List<ShopsListResult.Shop> list, @NotNull List<LinkAction> list2, @NotNull Shortcuts shortcuts, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(list, "shopList");
        Intrinsics.checkNotNullParameter(list2, "shopActions");
        Intrinsics.checkNotNullParameter(shortcuts, ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS);
        return new ShopListInfo(list, list2, shortcuts, map);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopListInfo)) {
            return false;
        }
        ShopListInfo shopListInfo = (ShopListInfo) obj;
        return Intrinsics.areEqual(this.a, shopListInfo.a) && Intrinsics.areEqual(this.b, shopListInfo.b) && Intrinsics.areEqual(this.c, shopListInfo.c) && Intrinsics.areEqual(this.d, shopListInfo.d);
    }

    @Nullable
    public final Map<String, String> getFirebaseParams() {
        return this.d;
    }

    @NotNull
    public final List<LinkAction> getShopActions() {
        return this.b;
    }

    @NotNull
    public final List<ShopsListResult.Shop> getShopList() {
        return this.a;
    }

    @NotNull
    public final Shortcuts getShortcuts() {
        return this.c;
    }

    @Override // java.lang.Object
    public int hashCode() {
        List<ShopsListResult.Shop> list = this.a;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<LinkAction> list2 = this.b;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        Shortcuts shortcuts = this.c;
        int hashCode3 = (hashCode2 + (shortcuts != null ? shortcuts.hashCode() : 0)) * 31;
        Map<String, String> map = this.d;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("ShopListInfo(shopList=");
        L.append(this.a);
        L.append(", shopActions=");
        L.append(this.b);
        L.append(", shortcuts=");
        L.append(this.c);
        L.append(", firebaseParams=");
        return a2.b.a.a.a.x(L, this.d, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        ParcelsKt.writeOptimizedParcelableList$default(parcel, this.a, 0, 2, null);
        ParcelsKt.writeOptimizedParcelableList$default(parcel, this.b, 0, 2, null);
        parcel.writeParcelable(this.c, i);
        ParcelsKt.writeValueMap(parcel, this.d);
    }
}
