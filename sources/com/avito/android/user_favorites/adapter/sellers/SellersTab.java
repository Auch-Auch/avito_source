package com.avito.android.user_favorites.adapter.sellers;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.user_favorites.adapter.FavoritesTab;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ2\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\bR\u001c\u0010\t\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0004R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010 \u001a\u0004\b#\u0010\u0004¨\u0006&"}, d2 = {"Lcom/avito/android/user_favorites/adapter/sellers/SellersTab;", "Lcom/avito/android/user_favorites/adapter/FavoritesTab;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/lang/Integer;", "title", "label", "listBottomPaddingPx", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/avito/android/user_favorites/adapter/sellers/SellersTab;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "f", "Ljava/lang/Integer;", "getListBottomPaddingPx", "d", "Ljava/lang/String;", "getTitle", "e", "getLabel", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "user-favorites_release"}, k = 1, mv = {1, 4, 2})
public final class SellersTab extends FavoritesTab {
    public static final Parcelable.Creator<SellersTab> CREATOR = new Creator();
    @NotNull
    public final String d;
    @Nullable
    public final String e;
    @Nullable
    public final Integer f;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SellersTab> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SellersTab createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SellersTab(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SellersTab[] newArray(int i) {
            return new SellersTab[i];
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SellersTab(String str, String str2, Integer num, int i, j jVar) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num);
    }

    public static /* synthetic */ SellersTab copy$default(SellersTab sellersTab, String str, String str2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sellersTab.getTitle();
        }
        if ((i & 2) != 0) {
            str2 = sellersTab.getLabel();
        }
        if ((i & 4) != 0) {
            num = sellersTab.getListBottomPaddingPx();
        }
        return sellersTab.copy(str, str2, num);
    }

    @NotNull
    public final String component1() {
        return getTitle();
    }

    @Nullable
    public final String component2() {
        return getLabel();
    }

    @Nullable
    public final Integer component3() {
        return getListBottomPaddingPx();
    }

    @NotNull
    public final SellersTab copy(@NotNull String str, @Nullable String str2, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "title");
        return new SellersTab(str, str2, num);
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SellersTab)) {
            return false;
        }
        SellersTab sellersTab = (SellersTab) obj;
        return Intrinsics.areEqual(getTitle(), sellersTab.getTitle()) && Intrinsics.areEqual(getLabel(), sellersTab.getLabel()) && Intrinsics.areEqual(getListBottomPaddingPx(), sellersTab.getListBottomPaddingPx());
    }

    @Override // com.avito.android.user_favorites.adapter.FavoritesTab, com.avito.android.design.widget.tab.Tab
    @Nullable
    public String getLabel() {
        return this.e;
    }

    @Override // com.avito.android.user_favorites.adapter.FavoritesTab
    @Nullable
    public Integer getListBottomPaddingPx() {
        return this.f;
    }

    @Override // com.avito.android.user_favorites.adapter.FavoritesTab, com.avito.android.design.widget.tab.Tab
    @NotNull
    public String getTitle() {
        return this.d;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String title = getTitle();
        int i = 0;
        int hashCode = (title != null ? title.hashCode() : 0) * 31;
        String label = getLabel();
        int hashCode2 = (hashCode + (label != null ? label.hashCode() : 0)) * 31;
        Integer listBottomPaddingPx = getListBottomPaddingPx();
        if (listBottomPaddingPx != null) {
            i = listBottomPaddingPx.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("SellersTab(title=");
        L.append(getTitle());
        L.append(", label=");
        L.append(getLabel());
        L.append(", listBottomPaddingPx=");
        L.append(getListBottomPaddingPx());
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        Integer num = this.f;
        if (num != null) {
            parcel.writeInt(1);
            i2 = num.intValue();
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SellersTab(@NotNull String str, @Nullable String str2, @Nullable Integer num) {
        super(str, str2, num);
        Intrinsics.checkNotNullParameter(str, "title");
        this.d = str;
        this.e = str2;
        this.f = num;
    }
}
