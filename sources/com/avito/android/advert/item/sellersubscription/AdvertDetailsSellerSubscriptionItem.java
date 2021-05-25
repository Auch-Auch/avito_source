package com.avito.android.advert.item.sellersubscription;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.advert.AdvertDetailsItem;
import com.avito.android.advert_core.advert.BlockItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.serp.adapter.DisplayTypeAwareItem;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 C2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001CB)\u0012\u0006\u0010-\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u001d\u001a\u00020\u0016\u0012\b\u0010@\u001a\u0004\u0018\u000109¢\u0006\u0004\bA\u0010BJ\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0015\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010#\u001a\u00020\u001e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010)\u001a\u00020$8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001c\u0010-\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u000fR\u001c\u00100\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b.\u0010\u0012\u001a\u0004\b/\u0010\u0014R\"\u00108\u001a\u0002018\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u0010@\u001a\u0004\u0018\u0001098\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006D"}, d2 = {"Lcom/avito/android/advert/item/sellersubscription/AdvertDetailsSellerSubscriptionItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "f", "Ljava/lang/String;", "getSellerKey", "()Ljava/lang/String;", "sellerKey", "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionState;", g.a, "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionState;", "getSubscriptionState", "()Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionState;", "setSubscriptionState", "(Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionState;)V", "subscriptionState", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "Lcom/avito/android/serp/adapter/SerpViewType;", "d", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "e", "I", "getSpanCount", "spanCount", AuthSource.BOOKING_ORDER, "getStringId", "stringId", "Lcom/avito/android/remote/model/SerpDisplayType;", "c", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "displayType", "Lcom/avito/android/advert/item/sellersubscription/SellerNotificationsState;", "h", "Lcom/avito/android/advert/item/sellersubscription/SellerNotificationsState;", "getNotificationsState", "()Lcom/avito/android/advert/item/sellersubscription/SellerNotificationsState;", "setNotificationsState", "(Lcom/avito/android/advert/item/sellersubscription/SellerNotificationsState;)V", "notificationsState", "<init>", "(ILjava/lang/String;Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionState;Lcom/avito/android/advert/item/sellersubscription/SellerNotificationsState;)V", "Companion", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsSellerSubscriptionItem implements BlockItem, DisplayTypeAwareItem, ViewTypeSerpItem {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<AdvertDetailsSellerSubscriptionItem> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final long a = ((long) 36);
    @NotNull
    public final String b = String.valueOf(getId());
    @NotNull
    public SerpDisplayType c = SerpDisplayType.Grid;
    @NotNull
    public final SerpViewType d = SerpViewType.SINGLE;
    public final int e;
    @NotNull
    public final String f;
    @NotNull
    public SellerSubscriptionState g;
    @Nullable
    public SellerNotificationsState h;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/advert/item/sellersubscription/AdvertDetailsSellerSubscriptionItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/advert/item/sellersubscription/AdvertDetailsSellerSubscriptionItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, AdvertDetailsSellerSubscriptionItem> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public AdvertDetailsSellerSubscriptionItem invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            int readInt = parcel2.readInt();
            String readString = parcel2.readString();
            if (readString == null) {
                readString = "";
            }
            return new AdvertDetailsSellerSubscriptionItem(readInt, readString, (SellerSubscriptionState) ParcelsKt.readEnum(parcel2, SellerSubscriptionState.values()), (SellerNotificationsState) ParcelsKt.readOptEnum(parcel2, SellerNotificationsState.values()));
        }
    }

    public AdvertDetailsSellerSubscriptionItem(int i, @NotNull String str, @NotNull SellerSubscriptionState sellerSubscriptionState, @Nullable SellerNotificationsState sellerNotificationsState) {
        Intrinsics.checkNotNullParameter(str, "sellerKey");
        Intrinsics.checkNotNullParameter(sellerSubscriptionState, "subscriptionState");
        this.e = i;
        this.f = str;
        this.g = sellerSubscriptionState;
        this.h = sellerNotificationsState;
        AdvertDetailsItem advertDetailsItem = AdvertDetailsItem.ITEM_SELLER_SUBSCRIPTION;
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public BlockItem copyWithSpanCount(int i) {
        return new AdvertDetailsSellerSubscriptionItem(i, this.f, this.g, this.h);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.c;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @Nullable
    public final SellerNotificationsState getNotificationsState() {
        return this.h;
    }

    @NotNull
    public final String getSellerKey() {
        return this.f;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.e;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.b;
    }

    @NotNull
    public final SellerSubscriptionState getSubscriptionState() {
        return this.g;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.d;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.c = serpDisplayType;
    }

    public final void setNotificationsState(@Nullable SellerNotificationsState sellerNotificationsState) {
        this.h = sellerNotificationsState;
    }

    public final void setSubscriptionState(@NotNull SellerSubscriptionState sellerSubscriptionState) {
        Intrinsics.checkNotNullParameter(sellerSubscriptionState, "<set-?>");
        this.g = sellerSubscriptionState;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeInt(getSpanCount());
        parcel.writeString(this.f);
        ParcelsKt.writeEnum(parcel, this.g);
        ParcelsKt.writeOptEnum(parcel, this.h);
    }
}
