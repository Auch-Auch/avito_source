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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u0005¨\u0006\u001f"}, d2 = {"Lcom/avito/android/brandspace/remote/model/MarketplaceTabsContentModule;", "Lcom/avito/android/brandspace/remote/model/BrandspaceElement;", "", "Lcom/avito/android/brandspace/remote/model/MarketplaceTabContentElement;", "component1", "()Ljava/util/List;", "tabs", "copy", "(Ljava/util/List;)Lcom/avito/android/brandspace/remote/model/MarketplaceTabsContentModule;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getTabs", "<init>", "(Ljava/util/List;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceTabsContentModule implements BrandspaceElement {
    public static final Parcelable.Creator<MarketplaceTabsContentModule> CREATOR = new Creator();
    @NotNull
    private final List<MarketplaceTabContentElement> tabs;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<MarketplaceTabsContentModule> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MarketplaceTabsContentModule createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(MarketplaceTabContentElement.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new MarketplaceTabsContentModule(arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MarketplaceTabsContentModule[] newArray(int i) {
            return new MarketplaceTabsContentModule[i];
        }
    }

    public MarketplaceTabsContentModule(@NotNull List<MarketplaceTabContentElement> list) {
        Intrinsics.checkNotNullParameter(list, "tabs");
        this.tabs = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.brandspace.remote.model.MarketplaceTabsContentModule */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MarketplaceTabsContentModule copy$default(MarketplaceTabsContentModule marketplaceTabsContentModule, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = marketplaceTabsContentModule.tabs;
        }
        return marketplaceTabsContentModule.copy(list);
    }

    @NotNull
    public final List<MarketplaceTabContentElement> component1() {
        return this.tabs;
    }

    @NotNull
    public final MarketplaceTabsContentModule copy(@NotNull List<MarketplaceTabContentElement> list) {
        Intrinsics.checkNotNullParameter(list, "tabs");
        return new MarketplaceTabsContentModule(list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof MarketplaceTabsContentModule) && Intrinsics.areEqual(this.tabs, ((MarketplaceTabsContentModule) obj).tabs);
        }
        return true;
    }

    @NotNull
    public final List<MarketplaceTabContentElement> getTabs() {
        return this.tabs;
    }

    @Override // java.lang.Object
    public int hashCode() {
        List<MarketplaceTabContentElement> list = this.tabs;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return a.w(a.L("MarketplaceTabsContentModule(tabs="), this.tabs, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Iterator n0 = a.n0(this.tabs, parcel);
        while (n0.hasNext()) {
            ((MarketplaceTabContentElement) n0.next()).writeToParcel(parcel, 0);
        }
    }
}
