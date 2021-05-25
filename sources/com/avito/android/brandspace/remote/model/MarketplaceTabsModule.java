package com.avito.android.brandspace.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0006\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\b0\u00101J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010JN\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\b\u0002\u0010\u0015\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0007J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0004J \u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b$\u0010%R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b'\u0010\tR\u0019\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b)\u0010\u0010R!\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010*\u001a\u0004\b+\u0010\rR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010,\u001a\u0004\b-\u0010\u0007R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010.\u001a\u0004\b/\u0010\u0004¨\u00062"}, d2 = {"Lcom/avito/android/brandspace/remote/model/MarketplaceTabsModule;", "Lcom/avito/android/brandspace/remote/model/BrandspaceElement;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "component3", "()Ljava/lang/Integer;", "", "Lcom/avito/android/brandspace/remote/model/MarketplaceTabElement;", "component4", "()Ljava/util/List;", "Lcom/avito/android/brandspace/remote/model/ItemsShow;", "component5", "()Lcom/avito/android/brandspace/remote/model/ItemsShow;", "version", "title", "limit", "tabs", "type", "copy", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/util/List;Lcom/avito/android/brandspace/remote/model/ItemsShow;)Lcom/avito/android/brandspace/remote/model/MarketplaceTabsModule;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Integer;", "getLimit", "Lcom/avito/android/brandspace/remote/model/ItemsShow;", "getType", "Ljava/util/List;", "getTabs", "Ljava/lang/String;", "getTitle", "I", "getVersion", "<init>", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/util/List;Lcom/avito/android/brandspace/remote/model/ItemsShow;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceTabsModule implements BrandspaceElement {
    public static final Parcelable.Creator<MarketplaceTabsModule> CREATOR = new Creator();
    @Nullable
    private final Integer limit;
    @Nullable
    private final List<MarketplaceTabElement> tabs;
    @Nullable
    private final String title;
    @NotNull
    private final ItemsShow type;
    private final int version;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<MarketplaceTabsModule> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MarketplaceTabsModule createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            ArrayList arrayList = null;
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                arrayList = new ArrayList(readInt2);
                while (readInt2 != 0) {
                    arrayList.add(MarketplaceTabElement.CREATOR.createFromParcel(parcel));
                    readInt2--;
                }
            }
            return new MarketplaceTabsModule(readInt, readString, valueOf, arrayList, (ItemsShow) Enum.valueOf(ItemsShow.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MarketplaceTabsModule[] newArray(int i) {
            return new MarketplaceTabsModule[i];
        }
    }

    public MarketplaceTabsModule(int i, @Nullable String str, @Nullable Integer num, @Nullable List<MarketplaceTabElement> list, @NotNull ItemsShow itemsShow) {
        Intrinsics.checkNotNullParameter(itemsShow, "type");
        this.version = i;
        this.title = str;
        this.limit = num;
        this.tabs = list;
        this.type = itemsShow;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.android.brandspace.remote.model.MarketplaceTabsModule */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MarketplaceTabsModule copy$default(MarketplaceTabsModule marketplaceTabsModule, int i, String str, Integer num, List list, ItemsShow itemsShow, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = marketplaceTabsModule.version;
        }
        if ((i2 & 2) != 0) {
            str = marketplaceTabsModule.title;
        }
        if ((i2 & 4) != 0) {
            num = marketplaceTabsModule.limit;
        }
        if ((i2 & 8) != 0) {
            list = marketplaceTabsModule.tabs;
        }
        if ((i2 & 16) != 0) {
            itemsShow = marketplaceTabsModule.type;
        }
        return marketplaceTabsModule.copy(i, str, num, list, itemsShow);
    }

    public final int component1() {
        return this.version;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final Integer component3() {
        return this.limit;
    }

    @Nullable
    public final List<MarketplaceTabElement> component4() {
        return this.tabs;
    }

    @NotNull
    public final ItemsShow component5() {
        return this.type;
    }

    @NotNull
    public final MarketplaceTabsModule copy(int i, @Nullable String str, @Nullable Integer num, @Nullable List<MarketplaceTabElement> list, @NotNull ItemsShow itemsShow) {
        Intrinsics.checkNotNullParameter(itemsShow, "type");
        return new MarketplaceTabsModule(i, str, num, list, itemsShow);
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
        if (!(obj instanceof MarketplaceTabsModule)) {
            return false;
        }
        MarketplaceTabsModule marketplaceTabsModule = (MarketplaceTabsModule) obj;
        return this.version == marketplaceTabsModule.version && Intrinsics.areEqual(this.title, marketplaceTabsModule.title) && Intrinsics.areEqual(this.limit, marketplaceTabsModule.limit) && Intrinsics.areEqual(this.tabs, marketplaceTabsModule.tabs) && Intrinsics.areEqual(this.type, marketplaceTabsModule.type);
    }

    @Nullable
    public final Integer getLimit() {
        return this.limit;
    }

    @Nullable
    public final List<MarketplaceTabElement> getTabs() {
        return this.tabs;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final ItemsShow getType() {
        return this.type;
    }

    public final int getVersion() {
        return this.version;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = this.version * 31;
        String str = this.title;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        Integer num = this.limit;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        List<MarketplaceTabElement> list = this.tabs;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        ItemsShow itemsShow = this.type;
        if (itemsShow != null) {
            i2 = itemsShow.hashCode();
        }
        return hashCode3 + i2;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("MarketplaceTabsModule(version=");
        L.append(this.version);
        L.append(", title=");
        L.append(this.title);
        L.append(", limit=");
        L.append(this.limit);
        L.append(", tabs=");
        L.append(this.tabs);
        L.append(", type=");
        L.append(this.type);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.version);
        parcel.writeString(this.title);
        Integer num = this.limit;
        if (num != null) {
            a.H0(parcel, 1, num);
        } else {
            parcel.writeInt(0);
        }
        List<MarketplaceTabElement> list = this.tabs;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                ((MarketplaceTabElement) l0.next()).writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.type.name());
    }
}
