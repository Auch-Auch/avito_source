package com.avito.android.notification_center.landing.unified.advert;

import a2.g.r.g;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Sort;
import com.avito.android.serp.adapter.FavorableItem;
import com.avito.android.serp.adapter.ViewedAdvertItem;
import com.facebook.appevents.integrity.IntegrityManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0001\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010,\u001a\u00020\u0018\u0012\u0006\u00103\u001a\u00020.\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0014\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u000104\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010*\u001a\u00020\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010!\u001a\u00020\u0003¢\u0006\u0004\b:\u0010;R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u0019\u0010\u0011\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0014\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007R\"\u0010\u001b\u001a\u00020\u00188\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0019\u0010!\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0005\u001a\u0004\b \u0010\u0007R\u001b\u0010$\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u0005\u001a\u0004\b#\u0010\u0007R\u001b\u0010'\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u0005\u001a\u0004\b&\u0010\u0007R\u0019\u0010*\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u0005\u001a\u0004\b)\u0010\u0007R\"\u0010,\u001a\u00020\u00188\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b+\u0010\u001a\u001a\u0004\b,\u0010\u001c\"\u0004\b-\u0010\u001eR\u0019\u00103\u001a\u00020.8\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R'\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001048\u0006@\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108¨\u0006<"}, d2 = {"Lcom/avito/android/notification_center/landing/unified/advert/UnifiedAdvertItem;", "Lcom/avito/android/serp/adapter/FavorableItem;", "Lcom/avito/android/serp/adapter/ViewedAdvertItem;", "", "c", "Ljava/lang/String;", "getAnalyticsContext", "()Ljava/lang/String;", "analyticsContext", "h", "getAddress", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "Lcom/avito/android/remote/model/Image;", "f", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "image", AuthSource.SEND_ABUSE, "getStringId", "stringId", "l", "getPriceWithoutDiscount", "priceWithoutDiscount", "", AuthSource.BOOKING_ORDER, "Z", "isFavorite", "()Z", "setFavorite", "(Z)V", AuthSource.OPEN_CHANNEL_LIST, "getTitle", "title", "i", "getDistance", Sort.DISTANCE, "j", "getLocation", "location", "k", "getPrice", "price", "d", "isViewed", "setViewed", "Lcom/avito/android/deep_linking/links/DeepLink;", "e", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", g.a, "Ljava/util/Map;", "getAnalyticParams", "()Ljava/util/Map;", "analyticParams", "<init>", "(Ljava/lang/String;ZLjava/lang/String;ZLcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/remote/model/Image;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class UnifiedAdvertItem implements FavorableItem, ViewedAdvertItem {
    @NotNull
    public final String a;
    public boolean b;
    @Nullable
    public final String c;
    public boolean d;
    @NotNull
    public final DeepLink e;
    @NotNull
    public final Image f;
    @Nullable
    public final Map<String, String> g;
    @Nullable
    public final String h;
    @Nullable
    public final String i;
    @Nullable
    public final String j;
    @NotNull
    public final String k;
    @Nullable
    public final String l;
    @NotNull
    public final String m;

    public UnifiedAdvertItem(@NotNull String str, boolean z, @Nullable String str2, boolean z2, @NotNull DeepLink deepLink, @NotNull Image image, @Nullable Map<String, String> map, @Nullable String str3, @Nullable String str4, @Nullable String str5, @NotNull String str6, @Nullable String str7, @NotNull String str8) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(str6, "price");
        Intrinsics.checkNotNullParameter(str8, "title");
        this.a = str;
        this.b = z;
        this.c = str2;
        this.d = z2;
        this.e = deepLink;
        this.f = image;
        this.g = map;
        this.h = str3;
        this.i = str4;
        this.j = str5;
        this.k = str6;
        this.l = str7;
        this.m = str8;
    }

    @Nullable
    public final String getAddress() {
        return this.h;
    }

    @Nullable
    public final Map<String, String> getAnalyticParams() {
        return this.g;
    }

    @Override // com.avito.android.serp.adapter.FavorableItem
    @Nullable
    public String getAnalyticsContext() {
        return this.c;
    }

    @NotNull
    public final DeepLink getDeepLink() {
        return this.e;
    }

    @Nullable
    public final String getDistance() {
        return this.i;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return FavorableItem.DefaultImpls.getId(this);
    }

    @NotNull
    public final Image getImage() {
        return this.f;
    }

    @Nullable
    public final String getLocation() {
        return this.j;
    }

    @NotNull
    public final String getPrice() {
        return this.k;
    }

    @Nullable
    public final String getPriceWithoutDiscount() {
        return this.l;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @NotNull
    public final String getTitle() {
        return this.m;
    }

    @Override // com.avito.android.serp.adapter.FavorableItem
    public boolean isFavorite() {
        return this.b;
    }

    @Override // com.avito.android.serp.adapter.ViewedAdvertItem
    public boolean isViewed() {
        return this.d;
    }

    @Override // com.avito.android.serp.adapter.FavorableItem
    public void setFavorite(boolean z) {
        this.b = z;
    }

    @Override // com.avito.android.serp.adapter.ViewedAdvertItem
    public void setViewed(boolean z) {
        this.d = z;
    }
}
