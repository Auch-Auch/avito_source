package com.avito.android.notification_center.landing.recommends.item.advert;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Sort;
import com.avito.android.serp.adapter.FavorableItem;
import com.avito.android.serp.adapter.ViewedAdvertItem;
import com.facebook.appevents.integrity.IntegrityManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u00012\u00020\u0002Bm\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010*\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010&\u001a\u00020\u001e\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010!\u001a\u00020\u001e¢\u0006\u0004\b.\u0010/R\u0019\u0010\b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u0019\u0010\u0011\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0014\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u0007R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0007R\"\u0010!\u001a\u00020\u001e8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020\u001e8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\u0019\u0010*\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u0005\u001a\u0004\b)\u0010\u0007R\u001e\u0010-\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b+\u0010\u0005\u001a\u0004\b,\u0010\u0007¨\u00060"}, d2 = {"Lcom/avito/android/notification_center/landing/recommends/item/advert/NotificationCenterLandingRecommendsAdvertItem;", "Lcom/avito/android/serp/adapter/FavorableItem;", "Lcom/avito/android/serp/adapter/ViewedAdvertItem;", "", "d", "Ljava/lang/String;", "getPrice", "()Ljava/lang/String;", "price", g.a, "getDistance", Sort.DISTANCE, "Lcom/avito/android/remote/model/Image;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "image", AuthSource.SEND_ABUSE, "getStringId", "stringId", "h", "getAddress", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "f", "getLocation", "location", "e", "getPriceWithoutDiscount", "priceWithoutDiscount", "", "k", "Z", "isViewed", "()Z", "setViewed", "(Z)V", "i", "isFavorite", "setFavorite", "c", "getTitle", "title", "j", "getAnalyticsContext", "analyticsContext", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Z)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterLandingRecommendsAdvertItem implements FavorableItem, ViewedAdvertItem {
    @NotNull
    public final String a;
    @NotNull
    public final Image b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @Nullable
    public final String e;
    @Nullable
    public final String f;
    @Nullable
    public final String g;
    @Nullable
    public final String h;
    public boolean i;
    @Nullable
    public final String j;
    public boolean k;

    public NotificationCenterLandingRecommendsAdvertItem(@NotNull String str, @NotNull Image image, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, boolean z, @Nullable String str8, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "price");
        this.a = str;
        this.b = image;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = str7;
        this.i = z;
        this.j = str8;
        this.k = z2;
    }

    @Nullable
    public final String getAddress() {
        return this.h;
    }

    @Override // com.avito.android.serp.adapter.FavorableItem
    @Nullable
    public String getAnalyticsContext() {
        return this.j;
    }

    @Nullable
    public final String getDistance() {
        return this.g;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return FavorableItem.DefaultImpls.getId(this);
    }

    @NotNull
    public final Image getImage() {
        return this.b;
    }

    @Nullable
    public final String getLocation() {
        return this.f;
    }

    @NotNull
    public final String getPrice() {
        return this.d;
    }

    @Nullable
    public final String getPriceWithoutDiscount() {
        return this.e;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @NotNull
    public final String getTitle() {
        return this.c;
    }

    @Override // com.avito.android.serp.adapter.FavorableItem
    public boolean isFavorite() {
        return this.i;
    }

    @Override // com.avito.android.serp.adapter.ViewedAdvertItem
    public boolean isViewed() {
        return this.k;
    }

    @Override // com.avito.android.serp.adapter.FavorableItem
    public void setFavorite(boolean z) {
        this.i = z;
    }

    @Override // com.avito.android.serp.adapter.ViewedAdvertItem
    public void setViewed(boolean z) {
        this.k = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NotificationCenterLandingRecommendsAdvertItem(String str, Image image, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, String str8, boolean z2, int i2, j jVar) {
        this(str, image, str2, str3, (i2 & 16) != 0 ? null : str4, str5, str6, str7, z, str8, (i2 & 1024) != 0 ? false : z2);
    }
}
