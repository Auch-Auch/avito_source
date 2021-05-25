package com.avito.android.brandspace.presenter.virtualitems.extraloading;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.brandspace.presenter.virtualitems.AddableItemsWithLoadingBrandspaceItem;
import com.avito.android.brandspace.presenter.virtualitems.extraloading.AdvertSource;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\b\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00017B)\b\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b5\u00106J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J6\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00152\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\"\u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010&\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010$HÖ\u0003¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020!HÖ\u0001¢\u0006\u0004\b(\u0010#J \u0010,\u001a\u00020\f2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020!HÖ\u0001¢\u0006\u0004\b,\u0010-R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001c\u0010\u0018\u001a\u00020\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104¨\u00068"}, d2 = {"Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/ExtraLoadingListItemsImpl;", "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/ExtraLoadingListItems;", "Landroid/os/Parcelable;", "", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "getResult", "()Ljava/util/List;", "", "isLoaded", "()Z", "", "items", "", "addItems", "(Ljava/util/List;)V", "errorLoading", "()V", "oldItem", "newItem", "replaceItem", "(Lcom/avito/android/brandspace/presenter/BrandspaceItem;Lcom/avito/android/brandspace/presenter/BrandspaceItem;)V", "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource;", "component1", "()Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource;", "advertSource", "initialList", "Lcom/avito/android/brandspace/presenter/virtualitems/AddableItemsWithLoadingBrandspaceItem;", "replaceableItem", "copy", "(Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource;Ljava/util/List;Lcom/avito/android/brandspace/presenter/virtualitems/AddableItemsWithLoadingBrandspaceItem;)Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/ExtraLoadingListItemsImpl;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "Ljava/util/List;", AuthSource.SEND_ABUSE, "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource;", "getAdvertSource", "c", "Lcom/avito/android/brandspace/presenter/virtualitems/AddableItemsWithLoadingBrandspaceItem;", "<init>", "(Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource;Ljava/util/List;Lcom/avito/android/brandspace/presenter/virtualitems/AddableItemsWithLoadingBrandspaceItem;)V", "Companion", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class ExtraLoadingListItemsImpl implements ExtraLoadingListItems, Parcelable {
    public static final Parcelable.Creator<ExtraLoadingListItemsImpl> CREATOR = new Creator();
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final AdvertSource a;
    public final List<BrandspaceItem> b;
    public AddableItemsWithLoadingBrandspaceItem c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\t\u001a\u00020\b2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\t\u0010\nJ#\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\t\u0010\fJ#\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\t\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/ExtraLoadingListItemsImpl$Companion;", "", "", "", "extraLoadingParameters", "", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "items", "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/ExtraLoadingListItemsImpl;", "create", "(Ljava/util/Map;Ljava/util/List;)Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/ExtraLoadingListItemsImpl;", "link", "(Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/ExtraLoadingListItemsImpl;", "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource;", "source", "(Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource;Ljava/util/List;)Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/ExtraLoadingListItemsImpl;", "<init>", "()V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final ExtraLoadingListItemsImpl create(@NotNull Map<String, String> map, @NotNull List<? extends BrandspaceItem> list) {
            Intrinsics.checkNotNullParameter(map, "extraLoadingParameters");
            Intrinsics.checkNotNullParameter(list, "items");
            return create(new AdvertSource.ParametersSource(map), list);
        }

        public Companion(j jVar) {
        }

        @NotNull
        public final ExtraLoadingListItemsImpl create(@NotNull String str, @NotNull List<? extends BrandspaceItem> list) {
            Intrinsics.checkNotNullParameter(str, "link");
            Intrinsics.checkNotNullParameter(list, "items");
            return create(new AdvertSource.LinkSource(str), list);
        }

        @NotNull
        public final ExtraLoadingListItemsImpl create(@NotNull AdvertSource advertSource, @NotNull List<? extends BrandspaceItem> list) {
            Intrinsics.checkNotNullParameter(advertSource, "source");
            Intrinsics.checkNotNullParameter(list, "items");
            ArrayList arrayList = new ArrayList();
            for (T t : list) {
                if (t instanceof AddableItemsWithLoadingBrandspaceItem) {
                    arrayList.add(t);
                }
            }
            if (arrayList.size() == 1) {
                return new ExtraLoadingListItemsImpl(advertSource, CollectionsKt___CollectionsKt.toMutableList((Collection) list), (AddableItemsWithLoadingBrandspaceItem) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList), null);
            }
            throw new IllegalArgumentException("items must have one(and only one) Loadable item");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ExtraLoadingListItemsImpl> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ExtraLoadingListItemsImpl createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            AdvertSource advertSource = (AdvertSource) parcel.readParcelable(ExtraLoadingListItemsImpl.class.getClassLoader());
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((BrandspaceItem) parcel.readParcelable(ExtraLoadingListItemsImpl.class.getClassLoader()));
                readInt--;
            }
            return new ExtraLoadingListItemsImpl(advertSource, arrayList, (AddableItemsWithLoadingBrandspaceItem) parcel.readParcelable(ExtraLoadingListItemsImpl.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ExtraLoadingListItemsImpl[] newArray(int i) {
            return new ExtraLoadingListItemsImpl[i];
        }
    }

    public ExtraLoadingListItemsImpl(AdvertSource advertSource, List<BrandspaceItem> list, AddableItemsWithLoadingBrandspaceItem addableItemsWithLoadingBrandspaceItem) {
        this.a = advertSource;
        this.b = list;
        this.c = addableItemsWithLoadingBrandspaceItem;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.brandspace.presenter.virtualitems.extraloading.ExtraLoadingListItemsImpl */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExtraLoadingListItemsImpl copy$default(ExtraLoadingListItemsImpl extraLoadingListItemsImpl, AdvertSource advertSource, List list, AddableItemsWithLoadingBrandspaceItem addableItemsWithLoadingBrandspaceItem, int i, Object obj) {
        if ((i & 1) != 0) {
            advertSource = extraLoadingListItemsImpl.getAdvertSource();
        }
        if ((i & 2) != 0) {
            list = extraLoadingListItemsImpl.b;
        }
        if ((i & 4) != 0) {
            addableItemsWithLoadingBrandspaceItem = extraLoadingListItemsImpl.c;
        }
        return extraLoadingListItemsImpl.copy(advertSource, list, addableItemsWithLoadingBrandspaceItem);
    }

    @Override // com.avito.android.brandspace.presenter.virtualitems.extraloading.ExtraLoadingListItems
    public void addItems(@NotNull List<? extends BrandspaceItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        AddableItemsWithLoadingBrandspaceItem addableItemsWithLoadingBrandspaceItem = this.c;
        if (addableItemsWithLoadingBrandspaceItem != null) {
            Integer valueOf = Integer.valueOf(this.b.indexOf(addableItemsWithLoadingBrandspaceItem));
            if (!(valueOf.intValue() >= 0)) {
                valueOf = null;
            }
            if (valueOf != null) {
                int intValue = valueOf.intValue();
                this.b.remove(intValue);
                this.b.addAll(intValue, addableItemsWithLoadingBrandspaceItem.replace(list));
                this.c = null;
                return;
            }
            throw new IllegalStateException("ReplaceableItem not found");
        }
        throw new IllegalStateException("Items already loaded");
    }

    @NotNull
    public final AdvertSource component1() {
        return getAdvertSource();
    }

    @NotNull
    public final ExtraLoadingListItemsImpl copy(@NotNull AdvertSource advertSource, @NotNull List<BrandspaceItem> list, @Nullable AddableItemsWithLoadingBrandspaceItem addableItemsWithLoadingBrandspaceItem) {
        Intrinsics.checkNotNullParameter(advertSource, "advertSource");
        Intrinsics.checkNotNullParameter(list, "initialList");
        return new ExtraLoadingListItemsImpl(advertSource, list, addableItemsWithLoadingBrandspaceItem);
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
        if (!(obj instanceof ExtraLoadingListItemsImpl)) {
            return false;
        }
        ExtraLoadingListItemsImpl extraLoadingListItemsImpl = (ExtraLoadingListItemsImpl) obj;
        return Intrinsics.areEqual(getAdvertSource(), extraLoadingListItemsImpl.getAdvertSource()) && Intrinsics.areEqual(this.b, extraLoadingListItemsImpl.b) && Intrinsics.areEqual(this.c, extraLoadingListItemsImpl.c);
    }

    @Override // com.avito.android.brandspace.presenter.virtualitems.extraloading.ExtraLoadingListItems
    public void errorLoading() {
        this.b.clear();
        this.c = null;
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
        AddableItemsWithLoadingBrandspaceItem addableItemsWithLoadingBrandspaceItem = this.c;
        if (addableItemsWithLoadingBrandspaceItem != null) {
            i = addableItemsWithLoadingBrandspaceItem.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // com.avito.android.brandspace.presenter.virtualitems.extraloading.ExtraLoadingListItems
    public boolean isLoaded() {
        return this.c == null;
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
        StringBuilder L = a.L("ExtraLoadingListItemsImpl(advertSource=");
        L.append(getAdvertSource());
        L.append(", initialList=");
        L.append(this.b);
        L.append(", replaceableItem=");
        L.append(this.c);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.a, i);
        Iterator n0 = a.n0(this.b, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((BrandspaceItem) n0.next(), i);
        }
        parcel.writeParcelable(this.c, i);
    }

    public ExtraLoadingListItemsImpl(AdvertSource advertSource, List list, AddableItemsWithLoadingBrandspaceItem addableItemsWithLoadingBrandspaceItem, j jVar) {
        this.a = advertSource;
        this.b = list;
        this.c = addableItemsWithLoadingBrandspaceItem;
    }
}
