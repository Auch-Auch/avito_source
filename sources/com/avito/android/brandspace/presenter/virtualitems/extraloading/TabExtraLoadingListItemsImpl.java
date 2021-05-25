package com.avito.android.brandspace.presenter.virtualitems.extraloading;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.brandspace.items.marketplace.tab.items.ContentsOfTabsItem;
import com.avito.android.brandspace.items.marketplace.tab.items.MarketplaceTabsDataItem;
import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.brandspace.presenter.mappers.TabContentResponseMapper;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\b\b\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00019B1\b\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b7\u00108J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J>\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00152\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\"\u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010&\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010$HÖ\u0003¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020!HÖ\u0001¢\u0006\u0004\b(\u0010#J \u0010,\u001a\u00020\f2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020!HÖ\u0001¢\u0006\u0004\b,\u0010-R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u001c\u0010\u0018\u001a\u00020\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106¨\u0006:"}, d2 = {"Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/TabExtraLoadingListItemsImpl;", "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/ExtraLoadingListItems;", "Landroid/os/Parcelable;", "", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "getResult", "()Ljava/util/List;", "", "isLoaded", "()Z", "", "items", "", "addItems", "(Ljava/util/List;)V", "errorLoading", "()V", "oldItem", "newItem", "replaceItem", "(Lcom/avito/android/brandspace/presenter/BrandspaceItem;Lcom/avito/android/brandspace/presenter/BrandspaceItem;)V", "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource;", "component1", "()Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource;", "advertSource", "initialList", "Lcom/avito/android/brandspace/presenter/mappers/TabContentResponseMapper;", "tabContentResponseMapper", "copy", "(Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource;Ljava/util/List;Lcom/avito/android/brandspace/presenter/mappers/TabContentResponseMapper;Z)Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/TabExtraLoadingListItemsImpl;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "d", "Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource;", "getAdvertSource", "c", "Lcom/avito/android/brandspace/presenter/mappers/TabContentResponseMapper;", "<init>", "(Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource;Ljava/util/List;Lcom/avito/android/brandspace/presenter/mappers/TabContentResponseMapper;Z)V", "Companion", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class TabExtraLoadingListItemsImpl implements ExtraLoadingListItems, Parcelable {
    public static final Parcelable.Creator<TabExtraLoadingListItemsImpl> CREATOR = new Creator();
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final AdvertSource a;
    public final List<BrandspaceItem> b;
    public final TabContentResponseMapper c;
    public boolean d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ+\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/TabExtraLoadingListItemsImpl$Companion;", "", "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource;", "source", "", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "replacebleItems", "Lcom/avito/android/brandspace/items/marketplace/tab/items/MarketplaceTabsDataItem;", "marketplaceTabsDataItem", "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/TabExtraLoadingListItemsImpl;", "create", "(Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource;Ljava/util/List;Lcom/avito/android/brandspace/items/marketplace/tab/items/MarketplaceTabsDataItem;)Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/TabExtraLoadingListItemsImpl;", "<init>", "()V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final TabExtraLoadingListItemsImpl create(@NotNull AdvertSource advertSource, @NotNull List<? extends BrandspaceItem> list, @NotNull MarketplaceTabsDataItem marketplaceTabsDataItem) {
            Intrinsics.checkNotNullParameter(advertSource, "source");
            Intrinsics.checkNotNullParameter(list, "replacebleItems");
            Intrinsics.checkNotNullParameter(marketplaceTabsDataItem, "marketplaceTabsDataItem");
            return new TabExtraLoadingListItemsImpl(advertSource, CollectionsKt___CollectionsKt.toMutableList((Collection) list), new TabContentResponseMapper(marketplaceTabsDataItem), false, 8);
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<TabExtraLoadingListItemsImpl> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TabExtraLoadingListItemsImpl createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            AdvertSource advertSource = (AdvertSource) parcel.readParcelable(TabExtraLoadingListItemsImpl.class.getClassLoader());
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((BrandspaceItem) parcel.readParcelable(TabExtraLoadingListItemsImpl.class.getClassLoader()));
                readInt--;
            }
            return new TabExtraLoadingListItemsImpl(advertSource, arrayList, TabContentResponseMapper.CREATOR.createFromParcel(parcel), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TabExtraLoadingListItemsImpl[] newArray(int i) {
            return new TabExtraLoadingListItemsImpl[i];
        }
    }

    public TabExtraLoadingListItemsImpl(AdvertSource advertSource, List<BrandspaceItem> list, TabContentResponseMapper tabContentResponseMapper, boolean z) {
        this.a = advertSource;
        this.b = list;
        this.c = tabContentResponseMapper;
        this.d = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.brandspace.presenter.virtualitems.extraloading.TabExtraLoadingListItemsImpl */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TabExtraLoadingListItemsImpl copy$default(TabExtraLoadingListItemsImpl tabExtraLoadingListItemsImpl, AdvertSource advertSource, List list, TabContentResponseMapper tabContentResponseMapper, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            advertSource = tabExtraLoadingListItemsImpl.getAdvertSource();
        }
        if ((i & 2) != 0) {
            list = tabExtraLoadingListItemsImpl.b;
        }
        if ((i & 4) != 0) {
            tabContentResponseMapper = tabExtraLoadingListItemsImpl.c;
        }
        if ((i & 8) != 0) {
            z = tabExtraLoadingListItemsImpl.d;
        }
        return tabExtraLoadingListItemsImpl.copy(advertSource, list, tabContentResponseMapper, z);
    }

    @Override // com.avito.android.brandspace.presenter.virtualitems.extraloading.ExtraLoadingListItems
    public void addItems(@NotNull List<? extends BrandspaceItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        Object first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
        if (!(first instanceof ContentsOfTabsItem)) {
            first = null;
        }
        ContentsOfTabsItem contentsOfTabsItem = (ContentsOfTabsItem) first;
        if (contentsOfTabsItem != null) {
            this.b.clear();
            this.b.add(this.c.invoke(contentsOfTabsItem));
            this.d = true;
        }
    }

    @NotNull
    public final AdvertSource component1() {
        return getAdvertSource();
    }

    @NotNull
    public final TabExtraLoadingListItemsImpl copy(@NotNull AdvertSource advertSource, @NotNull List<BrandspaceItem> list, @NotNull TabContentResponseMapper tabContentResponseMapper, boolean z) {
        Intrinsics.checkNotNullParameter(advertSource, "advertSource");
        Intrinsics.checkNotNullParameter(list, "initialList");
        Intrinsics.checkNotNullParameter(tabContentResponseMapper, "tabContentResponseMapper");
        return new TabExtraLoadingListItemsImpl(advertSource, list, tabContentResponseMapper, z);
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
        if (!(obj instanceof TabExtraLoadingListItemsImpl)) {
            return false;
        }
        TabExtraLoadingListItemsImpl tabExtraLoadingListItemsImpl = (TabExtraLoadingListItemsImpl) obj;
        return Intrinsics.areEqual(getAdvertSource(), tabExtraLoadingListItemsImpl.getAdvertSource()) && Intrinsics.areEqual(this.b, tabExtraLoadingListItemsImpl.b) && Intrinsics.areEqual(this.c, tabExtraLoadingListItemsImpl.c) && this.d == tabExtraLoadingListItemsImpl.d;
    }

    @Override // com.avito.android.brandspace.presenter.virtualitems.extraloading.ExtraLoadingListItems
    public void errorLoading() {
        this.b.clear();
    }

    @Override // com.avito.android.brandspace.presenter.virtualitems.extraloading.ExtraLoadingListItems
    @NotNull
    public AdvertSource getAdvertSource() {
        return this.a;
    }

    @Override // com.avito.android.brandspace.presenter.virtualitems.extraloading.ExtraLoadingListItems
    @NotNull
    public List<BrandspaceItem> getResult() {
        return this.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        AdvertSource advertSource = getAdvertSource();
        int i = 0;
        int hashCode = (advertSource != null ? advertSource.hashCode() : 0) * 31;
        List<BrandspaceItem> list = this.b;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        TabContentResponseMapper tabContentResponseMapper = this.c;
        if (tabContentResponseMapper != null) {
            i = tabContentResponseMapper.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z = this.d;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return i2 + i3;
    }

    @Override // com.avito.android.brandspace.presenter.virtualitems.extraloading.ExtraLoadingListItems
    public boolean isLoaded() {
        return this.d;
    }

    @Override // com.avito.android.brandspace.presenter.virtualitems.extraloading.ExtraLoadingListItems
    public void replaceItem(@NotNull BrandspaceItem brandspaceItem, @NotNull BrandspaceItem brandspaceItem2) {
        Intrinsics.checkNotNullParameter(brandspaceItem, "oldItem");
        Intrinsics.checkNotNullParameter(brandspaceItem2, "newItem");
        Integer valueOf = Integer.valueOf(this.b.indexOf(brandspaceItem));
        if (!(valueOf.intValue() >= 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            int intValue = valueOf.intValue();
            this.b.remove(intValue);
            this.b.add(intValue, brandspaceItem2);
        }
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("TabExtraLoadingListItemsImpl(advertSource=");
        L.append(getAdvertSource());
        L.append(", initialList=");
        L.append(this.b);
        L.append(", tabContentResponseMapper=");
        L.append(this.c);
        L.append(", isLoaded=");
        return a.B(L, this.d, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.a, i);
        Iterator n0 = a.n0(this.b, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((BrandspaceItem) n0.next(), i);
        }
        this.c.writeToParcel(parcel, 0);
        parcel.writeInt(this.d ? 1 : 0);
    }

    public TabExtraLoadingListItemsImpl(AdvertSource advertSource, List list, TabContentResponseMapper tabContentResponseMapper, boolean z, int i) {
        z = (i & 8) != 0 ? false : z;
        this.a = advertSource;
        this.b = list;
        this.c = tabContentResponseMapper;
        this.d = z;
    }
}
