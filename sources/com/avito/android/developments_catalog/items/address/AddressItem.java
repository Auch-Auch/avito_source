package com.avito.android.developments_catalog.items.address;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.developments_catalog.DevelopmentsCatalogItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.ParcelableItem;
import com.facebook.appevents.integrity.IntegrityManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/avito/android/developments_catalog/items/address/AddressItem;", "Lcom/avito/conveyor_item/ParcelableItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", AuthSource.SEND_ABUSE, "getAddress", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class AddressItem implements ParcelableItem {
    public static final Parcelable.Creator<AddressItem> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final String b;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AddressItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AddressItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AddressItem(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AddressItem[] newArray(int i) {
            return new AddressItem[i];
        }
    }

    public AddressItem(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        Intrinsics.checkNotNullParameter(str2, "stringId");
        this.a = str;
        this.b = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getAddress() {
        return this.a;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return ParcelableItem.DefaultImpls.getId(this);
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AddressItem(String str, String str2, int i, j jVar) {
        this(str, (i & 2) != 0 ? DevelopmentsCatalogItem.ITEM_ADDRESS.toString() : str2);
    }
}
