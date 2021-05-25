package com.avito.android.developments_catalog.items.infoParams;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.developments_catalog.DevelopmentsCatalogItem;
import com.avito.android.developments_catalog.remote.model.KeyValue;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000b¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001a\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/avito/android/developments_catalog/items/infoParams/InfoParamsItem;", "Lcom/avito/conveyor_item/ParcelableItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getDeveloperName", "()Ljava/lang/String;", "developerName", "", "Lcom/avito/android/developments_catalog/remote/model/KeyValue;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getInfoParams", "()Ljava/util/List;", "infoParams", "c", "getStringId", "stringId", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class InfoParamsItem implements ParcelableItem {
    public static final Parcelable.Creator<InfoParamsItem> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final List<KeyValue> b;
    @NotNull
    public final String c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<InfoParamsItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final InfoParamsItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((KeyValue) parcel.readParcelable(InfoParamsItem.class.getClassLoader()));
                readInt--;
            }
            return new InfoParamsItem(readString, arrayList, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final InfoParamsItem[] newArray(int i) {
            return new InfoParamsItem[i];
        }
    }

    public InfoParamsItem(@NotNull String str, @NotNull List<KeyValue> list, @NotNull String str2) {
        a.d1(str, "developerName", list, "infoParams", str2, "stringId");
        this.a = str;
        this.b = list;
        this.c = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getDeveloperName() {
        return this.a;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return ParcelableItem.DefaultImpls.getId(this);
    }

    @NotNull
    public final List<KeyValue> getInfoParams() {
        return this.b;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        Iterator n0 = a.n0(this.b, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((KeyValue) n0.next(), i);
        }
        parcel.writeString(this.c);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InfoParamsItem(String str, List list, String str2, int i, j jVar) {
        this(str, list, (i & 4) != 0 ? DevelopmentsCatalogItem.ITEM_INFO_PARAMS.toString() : str2);
    }
}
