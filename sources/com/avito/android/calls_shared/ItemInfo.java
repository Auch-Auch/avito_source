package com.avito.android.calls_shared;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b*\u0010+J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ>\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0013J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010!\u001a\u0004\b$\u0010\u0004R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\nR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010!\u001a\u0004\b)\u0010\u0004¨\u0006,"}, d2 = {"Lcom/avito/android/calls_shared/ItemInfo;", "Landroid/os/Parcelable;", "", "toString", "()Ljava/lang/String;", "component1", "component2", "component3", "Lcom/avito/android/remote/model/Image;", "component4", "()Lcom/avito/android/remote/model/Image;", "itemId", "title", "price", "image", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;)Lcom/avito/android/calls_shared/ItemInfo;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "c", "Ljava/lang/String;", "getPrice", AuthSource.SEND_ABUSE, "getItemId", "d", "Lcom/avito/android/remote/model/Image;", "getImage", AuthSource.BOOKING_ORDER, "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;)V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
public final class ItemInfo implements Parcelable {
    public static final Parcelable.Creator<ItemInfo> CREATOR = new Creator();
    @NotNull
    public final String a;
    @Nullable
    public final String b;
    @Nullable
    public final String c;
    @Nullable
    public final Image d;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ItemInfo> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ItemInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ItemInfo(parcel.readString(), parcel.readString(), parcel.readString(), (Image) parcel.readParcelable(ItemInfo.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ItemInfo[] newArray(int i) {
            return new ItemInfo[i];
        }
    }

    public ItemInfo(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable Image image) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = image;
    }

    public static /* synthetic */ ItemInfo copy$default(ItemInfo itemInfo, String str, String str2, String str3, Image image, int i, Object obj) {
        if ((i & 1) != 0) {
            str = itemInfo.a;
        }
        if ((i & 2) != 0) {
            str2 = itemInfo.b;
        }
        if ((i & 4) != 0) {
            str3 = itemInfo.c;
        }
        if ((i & 8) != 0) {
            image = itemInfo.d;
        }
        return itemInfo.copy(str, str2, str3, image);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @Nullable
    public final String component2() {
        return this.b;
    }

    @Nullable
    public final String component3() {
        return this.c;
    }

    @Nullable
    public final Image component4() {
        return this.d;
    }

    @NotNull
    public final ItemInfo copy(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable Image image) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        return new ItemInfo(str, str2, str3, image);
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
        if (!(obj instanceof ItemInfo)) {
            return false;
        }
        ItemInfo itemInfo = (ItemInfo) obj;
        return Intrinsics.areEqual(this.a, itemInfo.a) && Intrinsics.areEqual(this.b, itemInfo.b) && Intrinsics.areEqual(this.c, itemInfo.c) && Intrinsics.areEqual(this.d, itemInfo.d);
    }

    @Nullable
    public final Image getImage() {
        return this.d;
    }

    @NotNull
    public final String getItemId() {
        return this.a;
    }

    @Nullable
    public final String getPrice() {
        return this.c;
    }

    @Nullable
    public final String getTitle() {
        return this.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Image image = this.d;
        if (image != null) {
            i = image.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ItemInfo(itemId=");
        L.append(this.a);
        L.append(", title=");
        L.append(this.b);
        L.append(", price=");
        return a.s(L, this.c, ')');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeParcelable(this.d, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ItemInfo(String str, String str2, String str3, Image image, int i, j jVar) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : image);
    }
}
