package com.avito.android.favorites.adapter.advert;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.favorite.FavoriteModel;
import com.avito.android.favorites.adapter.FavoriteListItem;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.serp.adapter.FavorableItem;
import com.facebook.appevents.integrity.IntegrityManager;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKAttachments;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b:\b\b\u0018\u0000 2\u00020\u00012\u00020\u0002:\u0003\u0001BÕ\u0001\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010+\u001a\u00020\f\u0012\u0006\u0010,\u001a\u00020\u000f\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0003\u0012\b\u00100\u001a\u0004\u0018\u00010\u0003\u0012\b\u00101\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u001b\u0012\b\u00103\u001a\u0004\u0018\u00010\u0003\u0012\b\u00104\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u00105\u001a\u00020\u000f\u0012\b\u00106\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u00107\u001a\u00020\u000f\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b}\u0010~J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\b\u0010\u0005J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\t\u0010\u0005J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\n\u0010\u0005J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0005J\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0005J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0005J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0005J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0005J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0005J\u0010\u0010 \u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b \u0010\u0011J\u0012\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b!\u0010\u0005J\u0010\u0010\"\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\"\u0010\u0011J\u0012\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b#\u0010\u0005J\u0002\u00109\u001a\u00020\u00002\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010+\u001a\u00020\f2\b\b\u0002\u0010,\u001a\u00020\u000f2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u00105\u001a\u00020\u000f2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u00107\u001a\u00020\u000f2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0004\b9\u0010:J\u0010\u0010;\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b;\u0010\u0005J\u0010\u0010=\u001a\u00020<HÖ\u0001¢\u0006\u0004\b=\u0010>J\u001a\u0010A\u001a\u00020\u000f2\b\u0010@\u001a\u0004\u0018\u00010?HÖ\u0003¢\u0006\u0004\bA\u0010BJ\u0010\u0010C\u001a\u00020<HÖ\u0001¢\u0006\u0004\bC\u0010>J \u0010H\u001a\u00020G2\u0006\u0010E\u001a\u00020D2\u0006\u0010F\u001a\u00020<HÖ\u0001¢\u0006\u0004\bH\u0010IR\u001b\u00103\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010\u0005R\u001b\u0010-\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010\u0014R\u0019\u0010%\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\bP\u0010K\u001a\u0004\bQ\u0010\u0005R\u001b\u00104\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\bR\u0010K\u001a\u0004\bS\u0010\u0005R\u0019\u00105\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\b5\u0010\u0011R\u001b\u00106\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\bV\u0010K\u001a\u0004\bW\u0010\u0005R\u001b\u0010)\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\bX\u0010K\u001a\u0004\bY\u0010\u0005R$\u0010/\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bZ\u0010K\u001a\u0004\b[\u0010\u0005\"\u0004\b\\\u0010]R\u001b\u0010&\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b^\u0010K\u001a\u0004\b_\u0010\u0005R\u001b\u0010'\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b`\u0010K\u001a\u0004\ba\u0010\u0005R\u0019\u0010,\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bb\u0010U\u001a\u0004\bc\u0010\u0011R\u001b\u00102\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010\u001dR\"\u00107\u001a\u00020\u000f8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bg\u0010U\u001a\u0004\b7\u0010\u0011\"\u0004\bh\u0010iR\u001e\u00108\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bj\u0010K\u001a\u0004\bk\u0010\u0005R\u001b\u00101\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\bl\u0010m\u001a\u0004\bn\u0010\u001aR\u001b\u00100\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\bo\u0010K\u001a\u0004\bp\u0010\u0005R\u0019\u0010+\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\bq\u0010r\u001a\u0004\bs\u0010\u000eR$\u0010.\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bt\u0010K\u001a\u0004\bu\u0010\u0005\"\u0004\bv\u0010]R\u001b\u0010*\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\bw\u0010K\u001a\u0004\bx\u0010\u0005R\u001b\u0010(\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\by\u0010K\u001a\u0004\bz\u0010\u0005R\u001c\u0010$\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b{\u0010K\u001a\u0004\b|\u0010\u0005¨\u0006\u0001"}, d2 = {"Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItem;", "Lcom/avito/android/favorites/adapter/FavoriteListItem;", "Lcom/avito/android/serp/adapter/FavorableItem;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "", "component8", "()J", "", "component9", "()Z", "Lcom/avito/android/remote/model/Image;", "component10", "()Lcom/avito/android/remote/model/Image;", "component11", "component12", "component13", "Lcom/avito/android/deep_linking/links/DeepLink;", "component14", "()Lcom/avito/android/deep_linking/links/DeepLink;", "Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItem$Status;", "component15", "()Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItem$Status;", "component16", "component17", "component18", "component19", "component20", "component21", "stringId", "title", "price", "priceWithoutDiscount", "previousPrice", "oldLocation", "sublocation", "time", "active", "image", "categoryName", VKAttachments.TYPE_NOTE, "shopName", "deepLink", "status", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "location", "isDeliverable", "statusDescription", "isFavorite", "analyticsContext", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZLcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItem$Status;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;)Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItem;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "p", "Ljava/lang/String;", "getAddress", "j", "Lcom/avito/android/remote/model/Image;", "getImage", AuthSource.BOOKING_ORDER, "getTitle", VKApiConst.Q, "getLocation", "r", "Z", "s", "getStatusDescription", "f", "getOldLocation", "l", "getNote", "setNote", "(Ljava/lang/String;)V", "c", "getPrice", "d", "getPriceWithoutDiscount", "i", "getActive", "o", "Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItem$Status;", "getStatus", "t", "setFavorite", "(Z)V", "u", "getAnalyticsContext", "n", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", AuthSource.OPEN_CHANNEL_LIST, "getShopName", "h", "J", "getTime", "k", "getCategoryName", "setCategoryName", g.a, "getSublocation", "e", "getPreviousPrice", AuthSource.SEND_ABUSE, "getStringId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZLcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItem$Status;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;)V", "Companion", "Status", "favorites_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteAdvertItem implements FavoriteListItem, FavorableItem {
    public static final Parcelable.Creator<FavoriteAdvertItem> CREATOR = new Creator();
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public final String c;
    @Nullable
    public final String d;
    @Nullable
    public final String e;
    @Nullable
    public final String f;
    @Nullable
    public final String g;
    public final long h;
    public final boolean i;
    @Nullable
    public final Image j;
    @Nullable
    public String k;
    @Nullable
    public String l;
    @Nullable
    public final String m;
    @Nullable
    public final DeepLink n;
    @Nullable
    public final Status o;
    @Nullable
    public final String p;
    @Nullable
    public final String q;
    public final boolean r;
    @Nullable
    public final String s;
    public boolean t;
    @Nullable
    public final String u;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItem$Companion;", "", "Lcom/avito/android/favorite/FavoriteModel;", VerticalFilterCloseDialogEventKt.MODEL_DIALOG, "Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItem;", "fromFavoriteModel", "(Lcom/avito/android/favorite/FavoriteModel;)Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItem;", "<init>", "()V", "favorites_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final FavoriteAdvertItem fromFavoriteModel(@NotNull FavoriteModel favoriteModel) {
            Intrinsics.checkNotNullParameter(favoriteModel, VerticalFilterCloseDialogEventKt.MODEL_DIALOG);
            String advertId = favoriteModel.getAdvertId();
            String title = favoriteModel.getTitle();
            String price = favoriteModel.getPrice();
            String priceWithoutDiscount = favoriteModel.getPriceWithoutDiscount();
            String oldLocation = favoriteModel.getOldLocation();
            String sublocation = favoriteModel.getSublocation();
            long time = favoriteModel.getTime();
            boolean active = favoriteModel.getActive();
            Image image = favoriteModel.getImage();
            String categoryName = favoriteModel.getCategoryName();
            String note = favoriteModel.getNote();
            String shopName = favoriteModel.getShopName();
            DeepLink deepLink = favoriteModel.getDeepLink();
            FavoriteModel.Status status = favoriteModel.getStatus();
            return new FavoriteAdvertItem(advertId, title, price, priceWithoutDiscount, favoriteModel.getPreviousPrice(), oldLocation, sublocation, time, active, image, categoryName, note, shopName, deepLink, status != null ? Status.valueOf(status.toString()) : null, favoriteModel.getAddress(), favoriteModel.getLocation(), favoriteModel.isDeliverable(), favoriteModel.getStatusDescription(), false, null, 1572864, null);
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<FavoriteAdvertItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FavoriteAdvertItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new FavoriteAdvertItem(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readInt() != 0, (Image) parcel.readParcelable(FavoriteAdvertItem.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readString(), (DeepLink) parcel.readParcelable(FavoriteAdvertItem.class.getClassLoader()), parcel.readInt() != 0 ? (Status) Enum.valueOf(Status.class, parcel.readString()) : null, parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FavoriteAdvertItem[] newArray(int i) {
            return new FavoriteAdvertItem[i];
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItem$Status;", "", "<init>", "(Ljava/lang/String;I)V", "ACTIVE", "BLOCKED", "REJECTED", "REMOVED", "INACTIVE", "CLOSED", "EXPIRED", "DELETED", "favorites_release"}, k = 1, mv = {1, 4, 2})
    public enum Status {
        ACTIVE,
        BLOCKED,
        REJECTED,
        REMOVED,
        INACTIVE,
        CLOSED,
        EXPIRED,
        DELETED
    }

    public FavoriteAdvertItem(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, long j2, boolean z, @Nullable Image image, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable DeepLink deepLink, @Nullable Status status, @Nullable String str11, @Nullable String str12, boolean z2, @Nullable String str13, boolean z3, @Nullable String str14) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
        this.h = j2;
        this.i = z;
        this.j = image;
        this.k = str8;
        this.l = str9;
        this.m = str10;
        this.n = deepLink;
        this.o = status;
        this.p = str11;
        this.q = str12;
        this.r = z2;
        this.s = str13;
        this.t = z3;
        this.u = str14;
    }

    public static /* synthetic */ FavoriteAdvertItem copy$default(FavoriteAdvertItem favoriteAdvertItem, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, boolean z, Image image, String str8, String str9, String str10, DeepLink deepLink, Status status, String str11, String str12, boolean z2, String str13, boolean z3, String str14, int i2, Object obj) {
        return favoriteAdvertItem.copy((i2 & 1) != 0 ? favoriteAdvertItem.getStringId() : str, (i2 & 2) != 0 ? favoriteAdvertItem.b : str2, (i2 & 4) != 0 ? favoriteAdvertItem.c : str3, (i2 & 8) != 0 ? favoriteAdvertItem.d : str4, (i2 & 16) != 0 ? favoriteAdvertItem.e : str5, (i2 & 32) != 0 ? favoriteAdvertItem.f : str6, (i2 & 64) != 0 ? favoriteAdvertItem.g : str7, (i2 & 128) != 0 ? favoriteAdvertItem.h : j2, (i2 & 256) != 0 ? favoriteAdvertItem.i : z, (i2 & 512) != 0 ? favoriteAdvertItem.j : image, (i2 & 1024) != 0 ? favoriteAdvertItem.k : str8, (i2 & 2048) != 0 ? favoriteAdvertItem.l : str9, (i2 & 4096) != 0 ? favoriteAdvertItem.m : str10, (i2 & 8192) != 0 ? favoriteAdvertItem.n : deepLink, (i2 & 16384) != 0 ? favoriteAdvertItem.o : status, (i2 & 32768) != 0 ? favoriteAdvertItem.p : str11, (i2 & 65536) != 0 ? favoriteAdvertItem.q : str12, (i2 & 131072) != 0 ? favoriteAdvertItem.r : z2, (i2 & 262144) != 0 ? favoriteAdvertItem.s : str13, (i2 & 524288) != 0 ? favoriteAdvertItem.isFavorite() : z3, (i2 & 1048576) != 0 ? favoriteAdvertItem.getAnalyticsContext() : str14);
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    @Nullable
    public final Image component10() {
        return this.j;
    }

    @Nullable
    public final String component11() {
        return this.k;
    }

    @Nullable
    public final String component12() {
        return this.l;
    }

    @Nullable
    public final String component13() {
        return this.m;
    }

    @Nullable
    public final DeepLink component14() {
        return this.n;
    }

    @Nullable
    public final Status component15() {
        return this.o;
    }

    @Nullable
    public final String component16() {
        return this.p;
    }

    @Nullable
    public final String component17() {
        return this.q;
    }

    public final boolean component18() {
        return this.r;
    }

    @Nullable
    public final String component19() {
        return this.s;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    public final boolean component20() {
        return isFavorite();
    }

    @Nullable
    public final String component21() {
        return getAnalyticsContext();
    }

    @Nullable
    public final String component3() {
        return this.c;
    }

    @Nullable
    public final String component4() {
        return this.d;
    }

    @Nullable
    public final String component5() {
        return this.e;
    }

    @Nullable
    public final String component6() {
        return this.f;
    }

    @Nullable
    public final String component7() {
        return this.g;
    }

    public final long component8() {
        return this.h;
    }

    public final boolean component9() {
        return this.i;
    }

    @NotNull
    public final FavoriteAdvertItem copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, long j2, boolean z, @Nullable Image image, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable DeepLink deepLink, @Nullable Status status, @Nullable String str11, @Nullable String str12, boolean z2, @Nullable String str13, boolean z3, @Nullable String str14) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new FavoriteAdvertItem(str, str2, str3, str4, str5, str6, str7, j2, z, image, str8, str9, str10, deepLink, status, str11, str12, z2, str13, z3, str14);
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
        if (!(obj instanceof FavoriteAdvertItem)) {
            return false;
        }
        FavoriteAdvertItem favoriteAdvertItem = (FavoriteAdvertItem) obj;
        return Intrinsics.areEqual(getStringId(), favoriteAdvertItem.getStringId()) && Intrinsics.areEqual(this.b, favoriteAdvertItem.b) && Intrinsics.areEqual(this.c, favoriteAdvertItem.c) && Intrinsics.areEqual(this.d, favoriteAdvertItem.d) && Intrinsics.areEqual(this.e, favoriteAdvertItem.e) && Intrinsics.areEqual(this.f, favoriteAdvertItem.f) && Intrinsics.areEqual(this.g, favoriteAdvertItem.g) && this.h == favoriteAdvertItem.h && this.i == favoriteAdvertItem.i && Intrinsics.areEqual(this.j, favoriteAdvertItem.j) && Intrinsics.areEqual(this.k, favoriteAdvertItem.k) && Intrinsics.areEqual(this.l, favoriteAdvertItem.l) && Intrinsics.areEqual(this.m, favoriteAdvertItem.m) && Intrinsics.areEqual(this.n, favoriteAdvertItem.n) && Intrinsics.areEqual(this.o, favoriteAdvertItem.o) && Intrinsics.areEqual(this.p, favoriteAdvertItem.p) && Intrinsics.areEqual(this.q, favoriteAdvertItem.q) && this.r == favoriteAdvertItem.r && Intrinsics.areEqual(this.s, favoriteAdvertItem.s) && isFavorite() == favoriteAdvertItem.isFavorite() && Intrinsics.areEqual(getAnalyticsContext(), favoriteAdvertItem.getAnalyticsContext());
    }

    public final boolean getActive() {
        return this.i;
    }

    @Nullable
    public final String getAddress() {
        return this.p;
    }

    @Override // com.avito.android.serp.adapter.FavorableItem
    @Nullable
    public String getAnalyticsContext() {
        return this.u;
    }

    @Nullable
    public final String getCategoryName() {
        return this.k;
    }

    @Nullable
    public final DeepLink getDeepLink() {
        return this.n;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return FavoriteListItem.DefaultImpls.getId(this);
    }

    @Nullable
    public final Image getImage() {
        return this.j;
    }

    @Nullable
    public final String getLocation() {
        return this.q;
    }

    @Nullable
    public final String getNote() {
        return this.l;
    }

    @Nullable
    public final String getOldLocation() {
        return this.f;
    }

    @Nullable
    public final String getPreviousPrice() {
        return this.e;
    }

    @Nullable
    public final String getPrice() {
        return this.c;
    }

    @Nullable
    public final String getPriceWithoutDiscount() {
        return this.d;
    }

    @Nullable
    public final String getShopName() {
        return this.m;
    }

    @Nullable
    public final Status getStatus() {
        return this.o;
    }

    @Nullable
    public final String getStatusDescription() {
        return this.s;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Nullable
    public final String getSublocation() {
        return this.g;
    }

    public final long getTime() {
        return this.h;
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
        String str3 = this.d;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.e;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.g;
        int hashCode7 = (((hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31) + c.a(this.h)) * 31;
        boolean z = this.i;
        int i3 = 1;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = (hashCode7 + i4) * 31;
        Image image = this.j;
        int hashCode8 = (i7 + (image != null ? image.hashCode() : 0)) * 31;
        String str7 = this.k;
        int hashCode9 = (hashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.l;
        int hashCode10 = (hashCode9 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.m;
        int hashCode11 = (hashCode10 + (str9 != null ? str9.hashCode() : 0)) * 31;
        DeepLink deepLink = this.n;
        int hashCode12 = (hashCode11 + (deepLink != null ? deepLink.hashCode() : 0)) * 31;
        Status status = this.o;
        int hashCode13 = (hashCode12 + (status != null ? status.hashCode() : 0)) * 31;
        String str10 = this.p;
        int hashCode14 = (hashCode13 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.q;
        int hashCode15 = (hashCode14 + (str11 != null ? str11.hashCode() : 0)) * 31;
        boolean z2 = this.r;
        if (z2) {
            z2 = true;
        }
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = z2 ? 1 : 0;
        int i11 = (hashCode15 + i8) * 31;
        String str12 = this.s;
        int hashCode16 = (i11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        boolean isFavorite = isFavorite();
        if (!isFavorite) {
            i3 = isFavorite;
        }
        int i12 = (hashCode16 + i3) * 31;
        String analyticsContext = getAnalyticsContext();
        if (analyticsContext != null) {
            i2 = analyticsContext.hashCode();
        }
        return i12 + i2;
    }

    public final boolean isDeliverable() {
        return this.r;
    }

    @Override // com.avito.android.serp.adapter.FavorableItem
    public boolean isFavorite() {
        return this.t;
    }

    public final void setCategoryName(@Nullable String str) {
        this.k = str;
    }

    @Override // com.avito.android.serp.adapter.FavorableItem
    public void setFavorite(boolean z) {
        this.t = z;
    }

    public final void setNote(@Nullable String str) {
        this.l = str;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("FavoriteAdvertItem(stringId=");
        L.append(getStringId());
        L.append(", title=");
        L.append(this.b);
        L.append(", price=");
        L.append(this.c);
        L.append(", priceWithoutDiscount=");
        L.append(this.d);
        L.append(", previousPrice=");
        L.append(this.e);
        L.append(", oldLocation=");
        L.append(this.f);
        L.append(", sublocation=");
        L.append(this.g);
        L.append(", time=");
        L.append(this.h);
        L.append(", active=");
        L.append(this.i);
        L.append(", image=");
        L.append(this.j);
        L.append(", categoryName=");
        L.append(this.k);
        L.append(", note=");
        L.append(this.l);
        L.append(", shopName=");
        L.append(this.m);
        L.append(", deepLink=");
        L.append(this.n);
        L.append(", status=");
        L.append(this.o);
        L.append(", address=");
        L.append(this.p);
        L.append(", location=");
        L.append(this.q);
        L.append(", isDeliverable=");
        L.append(this.r);
        L.append(", statusDescription=");
        L.append(this.s);
        L.append(", isFavorite=");
        L.append(isFavorite());
        L.append(", analyticsContext=");
        L.append(getAnalyticsContext());
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeLong(this.h);
        parcel.writeInt(this.i ? 1 : 0);
        parcel.writeParcelable(this.j, i2);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeString(this.m);
        parcel.writeParcelable(this.n, i2);
        Status status = this.o;
        if (status != null) {
            parcel.writeInt(1);
            parcel.writeString(status.name());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeInt(this.r ? 1 : 0);
        parcel.writeString(this.s);
        parcel.writeInt(this.t ? 1 : 0);
        parcel.writeString(this.u);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FavoriteAdvertItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, boolean z, Image image, String str8, String str9, String str10, DeepLink deepLink, Status status, String str11, String str12, boolean z2, String str13, boolean z3, String str14, int i2, j jVar) {
        this(str, str2, str3, str4, str5, str6, str7, j2, z, image, (i2 & 1024) != 0 ? null : str8, str9, str10, deepLink, (i2 & 16384) != 0 ? null : status, str11, str12, z2, str13, (524288 & i2) != 0 ? false : z3, (i2 & 1048576) != 0 ? null : str14);
    }
}
