package com.avito.android.developments_catalog.items.metro;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.developments_catalog.DevelopmentsCatalogItem;
import com.avito.android.developments_catalog.remote.model.MetroParam;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.ParcelableItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0012¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0017\u001a\u00020\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/developments_catalog/items/metro/MetroItem;", "Lcom/avito/conveyor_item/ParcelableItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/developments_catalog/remote/model/MetroParam;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getMetro", "()Ljava/util/List;", "metro", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class MetroItem implements ParcelableItem {
    public static final Parcelable.Creator<MetroItem> CREATOR = new Creator();
    @NotNull
    public final List<MetroParam> a;
    @NotNull
    public final String b;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<MetroItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MetroItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((MetroParam) parcel.readParcelable(MetroItem.class.getClassLoader()));
                readInt--;
            }
            return new MetroItem(arrayList, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MetroItem[] newArray(int i) {
            return new MetroItem[i];
        }
    }

    public MetroItem(@NotNull List<MetroParam> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, "metro");
        Intrinsics.checkNotNullParameter(str, "stringId");
        this.a = list;
        this.b = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return ParcelableItem.DefaultImpls.getId(this);
    }

    @NotNull
    public final List<MetroParam> getMetro() {
        return this.a;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Iterator n0 = a.n0(this.a, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((MetroParam) n0.next(), i);
        }
        parcel.writeString(this.b);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MetroItem(List list, String str, int i, j jVar) {
        this(list, (i & 2) != 0 ? DevelopmentsCatalogItem.ITEM_METRO.toString() : str);
    }
}
