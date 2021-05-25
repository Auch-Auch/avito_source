package com.avito.android.favorite_sellers.adapter.advert_list;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.favorite_sellers.FavoriteSellersItem;
import com.avito.android.favorite_sellers.SubscribableItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.PersistableSerpItem;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.avito.conveyor_item.Item;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0016\u0018\u0000 12\u00020\u00012\u00020\u00022\u00020\u0003:\u00011BC\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010$\u001a\u00020\u0012\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0006\u0010(\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b/\u00100J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u000e\u001a\u00020\u000b8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0017\u001a\u00020\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010!\u001a\u00020\u000b8\u0016@\u0016XD¢\u0006\f\n\u0004\b\u001f\u0010\r\u001a\u0004\b \u0010\u000fR\u001c\u0010$\u001a\u00020\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010\u0016R\u001c\u0010&\u001a\u00020\u000b8\u0016@\u0016XD¢\u0006\f\n\u0004\b%\u0010\r\u001a\u0004\b&\u0010\u000fR\u0019\u0010(\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\r\u001a\u0004\b(\u0010\u000fR$\u0010+\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00062"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItem;", "Lcom/avito/android/favorite_sellers/FavoriteSellersItem;", "Lcom/avito/conveyor_item/Item;", "Lcom/avito/android/favorite_sellers/SubscribableItem;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", g.a, "Z", "isSubscribed", "()Z", "setSubscribed", "(Z)V", "", "c", "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "", "Lcom/avito/android/serp/adapter/PersistableSerpItem;", "e", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "items", AuthSource.BOOKING_ORDER, "getRemoveAfterUnsubscribe", "removeAfterUnsubscribe", "d", "getUserKey", "userKey", AuthSource.SEND_ABUSE, "isEditable", "f", "isDisabled", "h", "Ljava/lang/Boolean;", "isNotificationsActivated", "()Ljava/lang/Boolean;", "setNotificationsActivated", "(Ljava/lang/Boolean;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZZLjava/lang/Boolean;)V", "Companion", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
public class AdvertListItem implements FavoriteSellersItem, Item, SubscribableItem {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<AdvertListItem> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final boolean a;
    public final boolean b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @NotNull
    public final List<PersistableSerpItem> e;
    public final boolean f;
    public boolean g;
    @Nullable
    public Boolean h;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, AdvertListItem> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public AdvertListItem invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            String u2 = a2.b.a.a.a.u2(parcel2, "readString()!!");
            String u22 = a2.b.a.a.a.u2(parcel2, "readString()!!");
            List createParcelableList = ParcelsKt.createParcelableList(parcel2, PersistableSerpItem.class);
            if (createParcelableList == null) {
                createParcelableList = CollectionsKt__CollectionsKt.emptyList();
            }
            boolean readBool = ParcelsKt.readBool(parcel2);
            boolean readBool2 = ParcelsKt.readBool(parcel2);
            Object readValue = parcel2.readValue(Boolean.class.getClassLoader());
            if (!(readValue instanceof Boolean)) {
                readValue = null;
            }
            return new AdvertListItem(u2, u22, createParcelableList, readBool, readBool2, (Boolean) readValue);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: java.util.List<? extends com.avito.android.serp.adapter.PersistableSerpItem> */
    /* JADX WARN: Multi-variable type inference failed */
    public AdvertListItem(@NotNull String str, @NotNull String str2, @NotNull List<? extends PersistableSerpItem> list, boolean z, boolean z2, @Nullable Boolean bool) {
        a2.b.a.a.a.c1(str, "stringId", str2, "userKey", list, "items");
        this.c = str;
        this.d = str2;
        this.e = list;
        this.f = z;
        this.g = z2;
        this.h = bool;
        this.a = true;
        this.b = true;
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersItem, android.os.Parcelable
    public int describeContents() {
        return FavoriteSellersItem.DefaultImpls.describeContents(this);
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return FavoriteSellersItem.DefaultImpls.getId(this);
    }

    @NotNull
    public final List<PersistableSerpItem> getItems() {
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
        return this.f;
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersItem
    public boolean isEditable() {
        return this.a;
    }

    @Override // com.avito.android.favorite_sellers.SubscribableItem, com.avito.android.FavoriteSeller
    @Nullable
    public Boolean isNotificationsActivated() {
        return this.h;
    }

    @Override // com.avito.android.favorite_sellers.SubscribableItem, com.avito.android.FavoriteSeller
    public boolean isSubscribed() {
        return this.g;
    }

    @Override // com.avito.android.favorite_sellers.SubscribableItem
    public void setNotificationsActivated(@Nullable Boolean bool) {
        this.h = bool;
    }

    @Override // com.avito.android.favorite_sellers.SubscribableItem
    public void setNotificationsLoading(boolean z) {
        SubscribableItem.DefaultImpls.setNotificationsLoading(this, z);
    }

    @Override // com.avito.android.favorite_sellers.SubscribableItem
    public void setSubscribeLoading(boolean z) {
        SubscribableItem.DefaultImpls.setSubscribeLoading(this, z);
    }

    @Override // com.avito.android.favorite_sellers.SubscribableItem
    public void setSubscribed(boolean z) {
        this.g = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(getStringId());
        parcel.writeString(getUserKey());
        ParcelsKt.writeOptimizedParcelableList(parcel, this.e, i);
        ParcelsKt.writeBool(parcel, this.f);
        ParcelsKt.writeBool(parcel, isSubscribed());
        ParcelsKt.writeNullableValue(parcel, isNotificationsActivated());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdvertListItem(String str, String str2, List list, boolean z, boolean z2, Boolean bool, int i, j jVar) {
        this(str, str2, list, z, (i & 16) != 0 ? true : z2, (i & 32) != 0 ? null : bool);
    }
}
