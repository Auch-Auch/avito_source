package com.avito.android.favorite;

import a2.g.r.g;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.facebook.appevents.integrity.IntegrityManager;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKAttachments;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001:\u0001UBÕ\u0001\u0012\u0006\u0010M\u001a\u00020\u000f\u0012\u0006\u0010G\u001a\u00020\u000f\u0012\b\u0010R\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\b\u00108\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\u0006\u0010;\u001a\u00020\b\u0012\b\u0010D\u001a\u0004\u0018\u00010?\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u000f\u0012\b\u00105\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010>\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010O\u001a\u00020\b\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\bS\u0010TR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u001a\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010 \u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010#\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u0011\u001a\u0004\b\"\u0010\u0013R\u001b\u0010&\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0011\u001a\u0004\b%\u0010\u0013R\u001b\u0010)\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u0011\u001a\u0004\b(\u0010\u0013R$\u0010.\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0011\u001a\u0004\b+\u0010\u0013\"\u0004\b,\u0010-R\u001b\u00101\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010\u0011\u001a\u0004\b0\u0010\u0013R$\u00105\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b2\u0010\u0011\u001a\u0004\b3\u0010\u0013\"\u0004\b4\u0010-R\u001b\u00108\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010\u0011\u001a\u0004\b7\u0010\u0013R\u0019\u0010;\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010\n\u001a\u0004\b:\u0010\fR\u001b\u0010>\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010\u0011\u001a\u0004\b=\u0010\u0013R\u001b\u0010D\u001a\u0004\u0018\u00010?8\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u0019\u0010G\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010\u0011\u001a\u0004\bF\u0010\u0013R\u001b\u0010J\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010\u0011\u001a\u0004\bI\u0010\u0013R\u0019\u0010M\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bK\u0010\u0011\u001a\u0004\bL\u0010\u0013R\u0019\u0010O\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\bN\u0010\n\u001a\u0004\bO\u0010\fR\u001b\u0010R\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bP\u0010\u0011\u001a\u0004\bQ\u0010\u0013¨\u0006V"}, d2 = {"Lcom/avito/android/favorite/FavoriteModel;", "", "Lcom/avito/android/favorite/FavoriteModel$Status;", "o", "Lcom/avito/android/favorite/FavoriteModel$Status;", "getStatus", "()Lcom/avito/android/favorite/FavoriteModel$Status;", "status", "", "n", "Z", "isViewed", "()Z", "setViewed", "(Z)V", "", "e", "Ljava/lang/String;", "getOldLocation", "()Ljava/lang/String;", "oldLocation", "", g.a, "J", "getTime", "()J", "time", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "p", "getPreviousPrice", "previousPrice", "r", "getLocation", "location", "t", "getStatusDescription", "statusDescription", "j", "getCategoryName", "setCategoryName", "(Ljava/lang/String;)V", "categoryName", VKApiConst.Q, "getAddress", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "k", "getNote", "setNote", VKAttachments.TYPE_NOTE, "f", "getSublocation", "sublocation", "h", "getActive", "active", "l", "getShopName", "shopName", "Lcom/avito/android/remote/model/Image;", "i", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "image", AuthSource.BOOKING_ORDER, "getTitle", "title", "d", "getPriceWithoutDiscount", "priceWithoutDiscount", AuthSource.SEND_ABUSE, "getAdvertId", BookingInfoActivity.EXTRA_ITEM_ID, "s", "isDeliverable", "c", "getPrice", "price", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZLcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;ZLcom/avito/android/favorite/FavoriteModel$Status;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "Status", "favorite_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteModel {
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
    public final long g;
    public final boolean h;
    @Nullable
    public final Image i;
    @Nullable
    public String j;
    @Nullable
    public String k;
    @Nullable
    public final String l;
    @Nullable
    public final DeepLink m;
    public boolean n;
    @Nullable
    public final Status o;
    @Nullable
    public final String p;
    @Nullable
    public final String q;
    @Nullable
    public final String r;
    public final boolean s;
    @Nullable
    public final String t;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/favorite/FavoriteModel$Status;", "", "<init>", "(Ljava/lang/String;I)V", "ACTIVE", "BLOCKED", "REJECTED", "REMOVED", "INACTIVE", "CLOSED", "EXPIRED", "DELETED", "favorite_release"}, k = 1, mv = {1, 4, 2})
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

    public FavoriteModel(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, long j2, boolean z, @Nullable Image image, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable DeepLink deepLink, boolean z2, @Nullable Status status, @Nullable String str10, @Nullable String str11, @Nullable String str12, boolean z3, @Nullable String str13) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "title");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = j2;
        this.h = z;
        this.i = image;
        this.j = str7;
        this.k = str8;
        this.l = str9;
        this.m = deepLink;
        this.n = z2;
        this.o = status;
        this.p = str10;
        this.q = str11;
        this.r = str12;
        this.s = z3;
        this.t = str13;
    }

    public final boolean getActive() {
        return this.h;
    }

    @Nullable
    public final String getAddress() {
        return this.q;
    }

    @NotNull
    public final String getAdvertId() {
        return this.a;
    }

    @Nullable
    public final String getCategoryName() {
        return this.j;
    }

    @Nullable
    public final DeepLink getDeepLink() {
        return this.m;
    }

    @Nullable
    public final Image getImage() {
        return this.i;
    }

    @Nullable
    public final String getLocation() {
        return this.r;
    }

    @Nullable
    public final String getNote() {
        return this.k;
    }

    @Nullable
    public final String getOldLocation() {
        return this.e;
    }

    @Nullable
    public final String getPreviousPrice() {
        return this.p;
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
        return this.l;
    }

    @Nullable
    public final Status getStatus() {
        return this.o;
    }

    @Nullable
    public final String getStatusDescription() {
        return this.t;
    }

    @Nullable
    public final String getSublocation() {
        return this.f;
    }

    public final long getTime() {
        return this.g;
    }

    @NotNull
    public final String getTitle() {
        return this.b;
    }

    public final boolean isDeliverable() {
        return this.s;
    }

    public final boolean isViewed() {
        return this.n;
    }

    public final void setCategoryName(@Nullable String str) {
        this.j = str;
    }

    public final void setNote(@Nullable String str) {
        this.k = str;
    }

    public final void setViewed(boolean z) {
        this.n = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FavoriteModel(String str, String str2, String str3, String str4, String str5, String str6, long j2, boolean z, Image image, String str7, String str8, String str9, DeepLink deepLink, boolean z2, Status status, String str10, String str11, String str12, boolean z3, String str13, int i2, j jVar) {
        this(str, str2, str3, (i2 & 8) != 0 ? null : str4, str5, str6, j2, z, image, (i2 & 512) != 0 ? null : str7, str8, str9, deepLink, (i2 & 8192) != 0 ? false : z2, (i2 & 16384) != 0 ? null : status, (32768 & i2) != 0 ? null : str10, (65536 & i2) != 0 ? null : str11, (131072 & i2) != 0 ? null : str12, (262144 & i2) != 0 ? false : z3, (i2 & 524288) != 0 ? null : str13);
    }
}
