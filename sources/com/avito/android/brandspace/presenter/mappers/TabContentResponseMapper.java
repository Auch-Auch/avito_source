package com.avito.android.brandspace.presenter.mappers;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.brandspace.items.button.ButtonItem;
import com.avito.android.brandspace.items.carousel.CarouselItem;
import com.avito.android.brandspace.items.marketplace.snippet.MarketplaceSnippetItem;
import com.avito.android.brandspace.items.marketplace.tab.MarketplaceTabsItem;
import com.avito.android.brandspace.items.marketplace.tab.items.ContentsOfTabsItem;
import com.avito.android.brandspace.items.marketplace.tab.items.MarketplaceTabDetailDataItem;
import com.avito.android.brandspace.items.marketplace.tab.items.MarketplaceTabsDataItem;
import com.avito.android.brandspace.remote.model.ItemsShow;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b \u0010!J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/avito/android/brandspace/presenter/mappers/TabContentResponseMapper;", "Landroid/os/Parcelable;", "Lcom/avito/android/brandspace/presenter/mappers/Mapper;", "Lcom/avito/android/brandspace/items/marketplace/tab/items/ContentsOfTabsItem;", "Lcom/avito/android/brandspace/items/marketplace/tab/MarketplaceTabsItem;", "input", "invoke", "(Lcom/avito/android/brandspace/items/marketplace/tab/items/ContentsOfTabsItem;)Lcom/avito/android/brandspace/items/marketplace/tab/MarketplaceTabsItem;", "Lcom/avito/android/brandspace/items/marketplace/tab/items/MarketplaceTabsDataItem;", "tabsData", "copy", "(Lcom/avito/android/brandspace/items/marketplace/tab/items/MarketplaceTabsDataItem;)Lcom/avito/android/brandspace/presenter/mappers/TabContentResponseMapper;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/brandspace/items/marketplace/tab/items/MarketplaceTabsDataItem;", "<init>", "(Lcom/avito/android/brandspace/items/marketplace/tab/items/MarketplaceTabsDataItem;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class TabContentResponseMapper implements Parcelable, Mapper<ContentsOfTabsItem, MarketplaceTabsItem> {
    public static final Parcelable.Creator<TabContentResponseMapper> CREATOR = new Creator();
    public final MarketplaceTabsDataItem a;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<TabContentResponseMapper> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TabContentResponseMapper createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new TabContentResponseMapper(MarketplaceTabsDataItem.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TabContentResponseMapper[] newArray(int i) {
            return new TabContentResponseMapper[i];
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ItemsShow.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
        }
    }

    public TabContentResponseMapper(@NotNull MarketplaceTabsDataItem marketplaceTabsDataItem) {
        Intrinsics.checkNotNullParameter(marketplaceTabsDataItem, "tabsData");
        this.a = marketplaceTabsDataItem;
    }

    public static /* synthetic */ TabContentResponseMapper copy$default(TabContentResponseMapper tabContentResponseMapper, MarketplaceTabsDataItem marketplaceTabsDataItem, int i, Object obj) {
        if ((i & 1) != 0) {
            marketplaceTabsDataItem = tabContentResponseMapper.a;
        }
        return tabContentResponseMapper.copy(marketplaceTabsDataItem);
    }

    @NotNull
    public final TabContentResponseMapper copy(@NotNull MarketplaceTabsDataItem marketplaceTabsDataItem) {
        Intrinsics.checkNotNullParameter(marketplaceTabsDataItem, "tabsData");
        return new TabContentResponseMapper(marketplaceTabsDataItem);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof TabContentResponseMapper) && Intrinsics.areEqual(this.a, ((TabContentResponseMapper) obj).a);
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        MarketplaceTabsDataItem marketplaceTabsDataItem = this.a;
        if (marketplaceTabsDataItem != null) {
            return marketplaceTabsDataItem.hashCode();
        }
        return 0;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("TabContentResponseMapper(tabsData=");
        L.append(this.a);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.a.writeToParcel(parcel, 0);
    }

    @NotNull
    public MarketplaceTabsItem invoke(@NotNull ContentsOfTabsItem contentsOfTabsItem) {
        Iterator<T> it;
        Pair pair;
        Intrinsics.checkNotNullParameter(contentsOfTabsItem, "input");
        List<MarketplaceTabDetailDataItem> tabs = this.a.getTabs();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = tabs.iterator();
        while (it2.hasNext()) {
            T next = it2.next();
            List<MarketplaceSnippetItem> list = contentsOfTabsItem.getTabs().get(next.getTabName());
            if (list != null) {
                ArrayList arrayList2 = new ArrayList();
                int ordinal = this.a.getItemShow().ordinal();
                if (ordinal == 0) {
                    it = it2;
                    arrayList2.add(new CarouselItem(next.getId(), next.getType(), list, 0, false, 0, 56, null));
                } else if (ordinal == 1) {
                    arrayList2.addAll(list);
                    it = it2;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                ButtonItem action = next.getAction();
                if (action != null) {
                    arrayList2.add(action);
                }
                pair = TuplesKt.to(next.getTabName(), CollectionsKt___CollectionsKt.toList(arrayList2));
            } else {
                it = it2;
                pair = null;
            }
            if (pair != null) {
                arrayList.add(pair);
            }
            it2 = it;
        }
        Map mutableMap = r.toMutableMap(r.toMap(arrayList));
        return new MarketplaceTabsItem(this.a.getId(), mutableMap, (String) CollectionsKt___CollectionsKt.first(mutableMap.keySet()), null, false, 24, null);
    }
}
