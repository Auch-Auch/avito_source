package com.avito.android.basket.checkout.item.checkout;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.conveyor_item.ParcelableItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001a\b\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0019\u001a\u00020\n\u0012\u0006\u0010\u001a\u001a\u00020\r\u0012\u0006\u0010\u001b\u001a\u00020\r\u0012\u0006\u0010\u001c\u001a\u00020\r\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\bC\u0010DJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000fJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014Jp\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\r2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010\u0004J\u0010\u0010!\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b'\u0010\"J \u0010,\u001a\u00020+2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b,\u0010-R\u0019\u0010\u001a\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\u000fR\u0019\u0010\u001c\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010/\u001a\u0004\b\u001c\u0010\u000fR\u0019\u0010\u001b\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010/\u001a\u0004\b\u001b\u0010\u000fR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u0010\u0014R\u001c\u0010\u0015\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u0010\u0004R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b9\u00107\u001a\u0004\b:\u0010\u0004R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b;\u00107\u001a\u0004\b<\u0010\u0004R\u0019\u0010\u0019\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010\fR\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010\t¨\u0006E"}, d2 = {"Lcom/avito/android/basket/checkout/item/checkout/CheckoutItem;", "Lcom/avito/conveyor_item/ParcelableItem;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()Ljava/lang/CharSequence;", "Lcom/avito/android/remote/model/Image;", "component5", "()Lcom/avito/android/remote/model/Image;", "", "component6", "()Z", "component7", "component8", "", "component9", "()Ljava/lang/Integer;", "stringId", "title", "price", "oldPrice", "picture", "hasProlongation", "isCancellable", "isActive", "priceValue", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;Lcom/avito/android/remote/model/Image;ZZZLjava/lang/Integer;)Lcom/avito/android/basket/checkout/item/checkout/CheckoutItem;", "toString", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "f", "Z", "getHasProlongation", "h", g.a, "i", "Ljava/lang/Integer;", "getPriceValue", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "c", "getPrice", AuthSource.BOOKING_ORDER, "getTitle", "e", "Lcom/avito/android/remote/model/Image;", "getPicture", "d", "Ljava/lang/CharSequence;", "getOldPrice", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;Lcom/avito/android/remote/model/Image;ZZZLjava/lang/Integer;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class CheckoutItem implements ParcelableItem {
    public static final Parcelable.Creator<CheckoutItem> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public final String c;
    @Nullable
    public final CharSequence d;
    @NotNull
    public final Image e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    @Nullable
    public final Integer i;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CheckoutItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CheckoutItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new CheckoutItem(parcel.readString(), parcel.readString(), parcel.readString(), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), (Image) parcel.readParcelable(CheckoutItem.class.getClassLoader()), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CheckoutItem[] newArray(int i) {
            return new CheckoutItem[i];
        }
    }

    public CheckoutItem(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable CharSequence charSequence, @NotNull Image image, boolean z, boolean z2, boolean z3, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(image, "picture");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = charSequence;
        this.e = image;
        this.f = z;
        this.g = z2;
        this.h = z3;
        this.i = num;
    }

    public static /* synthetic */ CheckoutItem copy$default(CheckoutItem checkoutItem, String str, String str2, String str3, CharSequence charSequence, Image image, boolean z, boolean z2, boolean z3, Integer num, int i2, Object obj) {
        return checkoutItem.copy((i2 & 1) != 0 ? checkoutItem.getStringId() : str, (i2 & 2) != 0 ? checkoutItem.b : str2, (i2 & 4) != 0 ? checkoutItem.c : str3, (i2 & 8) != 0 ? checkoutItem.d : charSequence, (i2 & 16) != 0 ? checkoutItem.e : image, (i2 & 32) != 0 ? checkoutItem.f : z, (i2 & 64) != 0 ? checkoutItem.g : z2, (i2 & 128) != 0 ? checkoutItem.h : z3, (i2 & 256) != 0 ? checkoutItem.i : num);
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @Nullable
    public final String component3() {
        return this.c;
    }

    @Nullable
    public final CharSequence component4() {
        return this.d;
    }

    @NotNull
    public final Image component5() {
        return this.e;
    }

    public final boolean component6() {
        return this.f;
    }

    public final boolean component7() {
        return this.g;
    }

    public final boolean component8() {
        return this.h;
    }

    @Nullable
    public final Integer component9() {
        return this.i;
    }

    @NotNull
    public final CheckoutItem copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable CharSequence charSequence, @NotNull Image image, boolean z, boolean z2, boolean z3, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(image, "picture");
        return new CheckoutItem(str, str2, str3, charSequence, image, z, z2, z3, num);
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
        if (!(obj instanceof CheckoutItem)) {
            return false;
        }
        CheckoutItem checkoutItem = (CheckoutItem) obj;
        return Intrinsics.areEqual(getStringId(), checkoutItem.getStringId()) && Intrinsics.areEqual(this.b, checkoutItem.b) && Intrinsics.areEqual(this.c, checkoutItem.c) && Intrinsics.areEqual(this.d, checkoutItem.d) && Intrinsics.areEqual(this.e, checkoutItem.e) && this.f == checkoutItem.f && this.g == checkoutItem.g && this.h == checkoutItem.h && Intrinsics.areEqual(this.i, checkoutItem.i);
    }

    public final boolean getHasProlongation() {
        return this.f;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return ParcelableItem.DefaultImpls.getId(this);
    }

    @Nullable
    public final CharSequence getOldPrice() {
        return this.d;
    }

    @NotNull
    public final Image getPicture() {
        return this.e;
    }

    @Nullable
    public final String getPrice() {
        return this.c;
    }

    @Nullable
    public final Integer getPriceValue() {
        return this.i;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @NotNull
    public final String getTitle() {
        return this.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String stringId = getStringId();
        int i2 = 0;
        int hashCode = (stringId != null ? stringId.hashCode() : 0) * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.c;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.d;
        int hashCode4 = (hashCode3 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Image image = this.e;
        int hashCode5 = (hashCode4 + (image != null ? image.hashCode() : 0)) * 31;
        boolean z = this.f;
        int i3 = 1;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = (hashCode5 + i4) * 31;
        boolean z2 = this.g;
        if (z2) {
            z2 = true;
        }
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = z2 ? 1 : 0;
        int i11 = (i7 + i8) * 31;
        boolean z3 = this.h;
        if (!z3) {
            i3 = z3 ? 1 : 0;
        }
        int i12 = (i11 + i3) * 31;
        Integer num = this.i;
        if (num != null) {
            i2 = num.hashCode();
        }
        return i12 + i2;
    }

    public final boolean isActive() {
        return this.h;
    }

    public final boolean isCancellable() {
        return this.g;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("CheckoutItem(stringId=");
        L.append(getStringId());
        L.append(", title=");
        L.append(this.b);
        L.append(", price=");
        L.append(this.c);
        L.append(", oldPrice=");
        L.append(this.d);
        L.append(", picture=");
        L.append(this.e);
        L.append(", hasProlongation=");
        L.append(this.f);
        L.append(", isCancellable=");
        L.append(this.g);
        L.append(", isActive=");
        L.append(this.h);
        L.append(", priceValue=");
        return a.p(L, this.i, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        TextUtils.writeToParcel(this.d, parcel, 0);
        parcel.writeParcelable(this.e, i2);
        parcel.writeInt(this.f ? 1 : 0);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeInt(this.h ? 1 : 0);
        Integer num = this.i;
        if (num != null) {
            a.H0(parcel, 1, num);
        } else {
            parcel.writeInt(0);
        }
    }
}
