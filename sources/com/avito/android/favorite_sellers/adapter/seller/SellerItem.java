package com.avito.android.favorite_sellers.adapter.seller;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.favorite_sellers.FavoriteSellersItem;
import com.avito.android.favorite_sellers.SubscribableItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0016\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0001EB\u0001\u0012\u0006\u0010'\u001a\u00020\u000f\u0012\u0006\u0010B\u001a\u00020\u000f\u0012\b\u0010=\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010-\u001a\u0004\u0018\u00010(\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010?\u001a\u00020\u0003\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u00104\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010:\u001a\u00020\u0003\u0012\b\u00102\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\bC\u0010DJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u001f\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0017\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\"\u001a\u00020\u00038\u0016@\u0016XD¢\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0018R\u001c\u0010$\u001a\u00020\u00038\u0016@\u0016XD¢\u0006\f\n\u0004\b#\u0010\u0016\u001a\u0004\b$\u0010\u0018R\u001c\u0010'\u001a\u00020\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010\u0011\u001a\u0004\b&\u0010\u0013R\u001b\u0010-\u001a\u0004\u0018\u00010(8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001b\u00102\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\"\u00104\u001a\u00020\u00038\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b3\u0010\u0016\u001a\u0004\b4\u0010\u0018\"\u0004\b5\u0010\u0007R$\u00107\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b6\u0010/\u001a\u0004\b7\u00101\"\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b:\u0010\u0016R\u001b\u0010=\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010\u0011\u001a\u0004\b<\u0010\u0013R\u0019\u0010?\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010\u0016\u001a\u0004\b?\u0010\u0018R\u001c\u0010B\u001a\u00020\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b@\u0010\u0011\u001a\u0004\bA\u0010\u0013¨\u0006F"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/seller/SellerItem;", "Lcom/avito/android/favorite_sellers/FavoriteSellersItem;", "Lcom/avito/android/favorite_sellers/SubscribableItem;", "", "isLoading", "", "setSubscribeLoading", "(Z)V", "setNotificationsLoading", "Landroid/os/Parcel;", "dest", "", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "f", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "description", "h", "Z", "isShop", "()Z", "isSubscribeInProgress", "Lcom/avito/android/deep_linking/links/DeepLink;", "j", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", AuthSource.BOOKING_ORDER, "getRemoveAfterUnsubscribe", "removeAfterUnsubscribe", AuthSource.SEND_ABUSE, "isEditable", "c", "getStringId", "stringId", "Lcom/avito/android/remote/model/Image;", g.a, "Lcom/avito/android/remote/model/Image;", "getAvatar", "()Lcom/avito/android/remote/model/Image;", "avatar", AuthSource.OPEN_CHANNEL_LIST, "Ljava/lang/Boolean;", "getHasNewItems", "()Ljava/lang/Boolean;", "hasNewItems", "k", "isSubscribed", "setSubscribed", "l", "isNotificationsActivated", "setNotificationsActivated", "(Ljava/lang/Boolean;)V", "isNotificationsInProgress", "e", "getName", "name", "i", "isDisabled", "d", "getUserKey", "userKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;ZZLcom/avito/android/deep_linking/links/DeepLink;ZZLjava/lang/Boolean;ZLjava/lang/Boolean;)V", "Companion", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
public class SellerItem implements FavoriteSellersItem, SubscribableItem {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SellerItem> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final boolean a;
    public final boolean b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @Nullable
    public final String e;
    @Nullable
    public final String f;
    @Nullable
    public final Image g;
    public final boolean h;
    public final boolean i;
    @JvmField
    public boolean isNotificationsInProgress;
    @JvmField
    public boolean isSubscribeInProgress;
    @Nullable
    public final DeepLink j;
    public boolean k;
    @Nullable
    public Boolean l;
    @Nullable
    public final Boolean m;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/seller/SellerItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/favorite_sellers/adapter/seller/SellerItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, SellerItem> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public SellerItem invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            String u2 = a2.b.a.a.a.u2(parcel2, "readString()!!");
            String u22 = a2.b.a.a.a.u2(parcel2, "readString()!!");
            String readString = parcel2.readString();
            String readString2 = parcel2.readString();
            Image image = (Image) parcel2.readParcelable(Image.class.getClassLoader());
            boolean readBool = ParcelsKt.readBool(parcel2);
            boolean readBool2 = ParcelsKt.readBool(parcel2);
            DeepLink deepLink = (DeepLink) parcel2.readParcelable(DeepLink.class.getClassLoader());
            boolean readBool3 = ParcelsKt.readBool(parcel2);
            boolean readBool4 = ParcelsKt.readBool(parcel2);
            Object readValue = parcel2.readValue(Boolean.class.getClassLoader());
            Boolean bool = null;
            if (!(readValue instanceof Boolean)) {
                readValue = null;
            }
            Boolean bool2 = (Boolean) readValue;
            boolean readBool5 = ParcelsKt.readBool(parcel2);
            Object readValue2 = parcel2.readValue(Boolean.class.getClassLoader());
            if (readValue2 instanceof Boolean) {
                bool = readValue2;
            }
            return new SellerItem(u2, u22, readString, readString2, image, readBool, readBool2, deepLink, readBool3, readBool4, bool2, readBool5, bool);
        }
    }

    public SellerItem(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable Image image, boolean z, boolean z2, @Nullable DeepLink deepLink, boolean z3, boolean z4, @Nullable Boolean bool, boolean z5, @Nullable Boolean bool2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "userKey");
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = image;
        this.h = z;
        this.i = z2;
        this.j = deepLink;
        this.k = z3;
        this.isSubscribeInProgress = z4;
        this.l = bool;
        this.isNotificationsInProgress = z5;
        this.m = bool2;
        this.a = true;
        this.b = true;
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersItem, android.os.Parcelable
    public int describeContents() {
        return FavoriteSellersItem.DefaultImpls.describeContents(this);
    }

    @Nullable
    public final Image getAvatar() {
        return this.g;
    }

    @Nullable
    public final DeepLink getDeepLink() {
        return this.j;
    }

    @Nullable
    public final String getDescription() {
        return this.f;
    }

    @Nullable
    public final Boolean getHasNewItems() {
        return this.m;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return FavoriteSellersItem.DefaultImpls.getId(this);
    }

    @Nullable
    public final String getName() {
        return this.e;
    }

    @Override // com.avito.android.favorite_sellers.SubscribableItem
    public boolean getRemoveAfterUnsubscribe() {
        return this.b;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.c;
    }

    @Override // com.avito.android.FavoriteSeller
    @NotNull
    public String getUserKey() {
        return this.d;
    }

    public final boolean isDisabled() {
        return this.i;
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersItem
    public boolean isEditable() {
        return this.a;
    }

    @Override // com.avito.android.favorite_sellers.SubscribableItem, com.avito.android.FavoriteSeller
    @Nullable
    public Boolean isNotificationsActivated() {
        return this.l;
    }

    public final boolean isShop() {
        return this.h;
    }

    @Override // com.avito.android.favorite_sellers.SubscribableItem, com.avito.android.FavoriteSeller
    public boolean isSubscribed() {
        return this.k;
    }

    @Override // com.avito.android.favorite_sellers.SubscribableItem
    public void setNotificationsActivated(@Nullable Boolean bool) {
        this.l = bool;
    }

    @Override // com.avito.android.favorite_sellers.SubscribableItem
    public void setNotificationsLoading(boolean z) {
        this.isNotificationsInProgress = z;
    }

    @Override // com.avito.android.favorite_sellers.SubscribableItem
    public void setSubscribeLoading(boolean z) {
        this.isSubscribeInProgress = z;
    }

    @Override // com.avito.android.favorite_sellers.SubscribableItem
    public void setSubscribed(boolean z) {
        this.k = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(getStringId());
        parcel.writeString(getUserKey());
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeParcelable(this.g, i2);
        ParcelsKt.writeBool(parcel, this.h);
        ParcelsKt.writeBool(parcel, this.i);
        parcel.writeParcelable(this.j, i2);
        ParcelsKt.writeBool(parcel, isSubscribed());
        ParcelsKt.writeBool(parcel, this.isSubscribeInProgress);
        ParcelsKt.writeNullableValue(parcel, isNotificationsActivated());
        ParcelsKt.writeBool(parcel, this.isNotificationsInProgress);
        ParcelsKt.writeNullableValue(parcel, this.m);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SellerItem(String str, String str2, String str3, String str4, Image image, boolean z, boolean z2, DeepLink deepLink, boolean z3, boolean z4, Boolean bool, boolean z5, Boolean bool2, int i2, j jVar) {
        this(str, str2, str3, str4, image, z, z2, deepLink, (i2 & 256) != 0 ? true : z3, (i2 & 512) != 0 ? false : z4, (i2 & 1024) != 0 ? Boolean.TRUE : bool, (i2 & 2048) != 0 ? false : z5, bool2);
    }
}
