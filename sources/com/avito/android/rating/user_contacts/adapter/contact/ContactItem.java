package com.avito.android.rating.user_contacts.adapter.contact;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u001a\u001a\u00020\t\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\b\u0010#\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010'\u001a\u00020$\u0012\b\u0010.\u001a\u0004\u0018\u00010)¢\u0006\u0004\b/\u00100J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u001c\u0010\u0017\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\rR\u0019\u0010\u001a\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\rR\u001b\u0010 \u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010#\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u000b\u001a\u0004\b\"\u0010\rR\u0019\u0010'\u001a\u00020$8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010.\u001a\u0004\u0018\u00010)8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-¨\u00061"}, d2 = {"Lcom/avito/android/rating/user_contacts/adapter/contact/ContactItem;", "Lcom/avito/android/rating/details/adapter/RatingDetailsItem;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getUserKey", "()Ljava/lang/String;", "userKey", "c", "getUserName", "userName", "f", "getItemTitle", "itemTitle", AuthSource.SEND_ABUSE, "getStringId", "stringId", "d", "getItemId", "itemId", "Lcom/avito/android/remote/model/Image;", "e", "Lcom/avito/android/remote/model/Image;", "getItemImage", "()Lcom/avito/android/remote/model/Image;", "itemImage", g.a, "getItemPrice", "itemPrice", "", "h", "Z", "isAutoItem", "()Z", "Lcom/avito/android/deep_linking/links/DeepLink;", "i", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;ZLcom/avito/android/deep_linking/links/DeepLink;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class ContactItem extends RatingDetailsItem {
    public static final Parcelable.Creator<ContactItem> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public final String c;
    @NotNull
    public final String d;
    @Nullable
    public final Image e;
    @Nullable
    public final String f;
    @Nullable
    public final String g;
    public final boolean h;
    @Nullable
    public final DeepLink i;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ContactItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ContactItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ContactItem(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (Image) parcel.readParcelable(ContactItem.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readInt() != 0, (DeepLink) parcel.readParcelable(ContactItem.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ContactItem[] newArray(int i) {
            return new ContactItem[i];
        }
    }

    public ContactItem(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull String str4, @Nullable Image image, @Nullable String str5, @Nullable String str6, boolean z, @Nullable DeepLink deepLink) {
        a.Z0(str, "stringId", str2, "userKey", str4, "itemId");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = image;
        this.f = str5;
        this.g = str6;
        this.h = z;
        this.i = deepLink;
    }

    @Nullable
    public final DeepLink getDeepLink() {
        return this.i;
    }

    @NotNull
    public final String getItemId() {
        return this.d;
    }

    @Nullable
    public final Image getItemImage() {
        return this.e;
    }

    @Nullable
    public final String getItemPrice() {
        return this.g;
    }

    @Nullable
    public final String getItemTitle() {
        return this.f;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @NotNull
    public final String getUserKey() {
        return this.b;
    }

    @Nullable
    public final String getUserName() {
        return this.c;
    }

    public final boolean isAutoItem() {
        return this.h;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeParcelable(this.e, i2);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeParcelable(this.i, i2);
    }
}
