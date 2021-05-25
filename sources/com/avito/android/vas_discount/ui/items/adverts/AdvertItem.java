package com.avito.android.vas_discount.ui.items.adverts;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.component.user_advert.PriceTypeBadge;
import com.avito.android.component.user_advert.UserAdvertItem;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertStats;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.TimeToLive;
import com.avito.android.remote.model.UserAdvert;
import com.avito.android.remote.model.user_adverts.UserOrderStatus;
import com.google.firebase.messaging.Constants;
import com.vk.sdk.api.VKApiConst;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u00002\u00020\u0001B¿\u0001\u0012\u0006\u0010Y\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\b\u0010P\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u00100\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010V\u001a\u00020Q\u0012\b\u00109\u001a\u0004\u0018\u000104\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010K\u001a\u0004\u0018\u00010F\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010?\u001a\u00020:\u0012\u0006\u00103\u001a\u00020\u000f\u0012\b\u0010E\u001a\u0004\u0018\u00010@\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010(\u0012\u0006\u0010\u001b\u001a\u00020\u000f\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\bZ\u0010[R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R*\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\u00020\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001b\u001a\u00020\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013R\u001c\u0010\u001e\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006R\u001e\u0010$\u001a\u0004\u0018\u00010\u001f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001e\u0010'\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006R\u001e\u0010-\u001a\u0004\u0018\u00010(8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001e\u00100\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b.\u0010\u0004\u001a\u0004\b/\u0010\u0006R\u001c\u00103\u001a\u00020\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b1\u0010\u0011\u001a\u0004\b2\u0010\u0013R\u001e\u00109\u001a\u0004\u0018\u0001048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001c\u0010?\u001a\u00020:8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001e\u0010E\u001a\u0004\u0018\u00010@8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u001e\u0010K\u001a\u0004\u0018\u00010F8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u001e\u0010P\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u001c\u0010V\u001a\u00020Q8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\u001c\u0010Y\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bW\u0010\u0004\u001a\u0004\bX\u0010\u0006¨\u0006\\"}, d2 = {"Lcom/avito/android/vas_discount/ui/items/adverts/AdvertItem;", "Lcom/avito/android/component/user_advert/UserAdvertItem;", "", "d", "Ljava/lang/String;", "getPrice", "()Ljava/lang/String;", "price", "", "Lcom/avito/android/remote/model/Image;", "h", "Ljava/util/Map;", "getServicesIcons", "()Ljava/util/Map;", "servicesIcons", "", "k", "Z", "isModerated", "()Z", "Lcom/avito/android/remote/model/user_adverts/UserOrderStatus;", "o", "Lcom/avito/android/remote/model/user_adverts/UserOrderStatus;", "getOrderStatus", "()Lcom/avito/android/remote/model/user_adverts/UserOrderStatus;", "orderStatus", VKApiConst.Q, "isAutoPublishOn", AuthSource.BOOKING_ORDER, "getTitle", "title", "Lcom/avito/android/remote/model/ForegroundImage;", "r", "Lcom/avito/android/remote/model/ForegroundImage;", "getForegroundImage", "()Lcom/avito/android/remote/model/ForegroundImage;", "foregroundImage", "j", "getDeclineReason", "declineReason", "Lcom/avito/android/component/user_advert/PriceTypeBadge;", "p", "Lcom/avito/android/component/user_advert/PriceTypeBadge;", "getPriceTypeBadge", "()Lcom/avito/android/component/user_advert/PriceTypeBadge;", "priceTypeBadge", "e", "getShortcut", "shortcut", AuthSource.OPEN_CHANNEL_LIST, "getHasDelivery", "hasDelivery", "Lcom/avito/android/remote/model/AdvertStats;", g.a, "Lcom/avito/android/remote/model/AdvertStats;", "getStats", "()Lcom/avito/android/remote/model/AdvertStats;", "stats", "Lcom/avito/android/deep_linking/links/DeepLink;", "l", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/remote/model/UserAdvert$Status;", "n", "Lcom/avito/android/remote/model/UserAdvert$Status;", "getStatus", "()Lcom/avito/android/remote/model/UserAdvert$Status;", "status", "Lcom/avito/android/remote/model/TimeToLive;", "i", "Lcom/avito/android/remote/model/TimeToLive;", "getTtl", "()Lcom/avito/android/remote/model/TimeToLive;", Constants.FirelogAnalytics.PARAM_TTL, "c", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "image", "", "f", "J", "getTime", "()J", "time", AuthSource.SEND_ABUSE, "getStringId", "stringId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;JLcom/avito/android/remote/model/AdvertStats;Ljava/util/Map;Lcom/avito/android/remote/model/TimeToLive;Ljava/lang/String;ZLcom/avito/android/deep_linking/links/DeepLink;ZLcom/avito/android/remote/model/UserAdvert$Status;Lcom/avito/android/remote/model/user_adverts/UserOrderStatus;Lcom/avito/android/component/user_advert/PriceTypeBadge;ZLcom/avito/android/remote/model/ForegroundImage;)V", "vas-discount_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertItem implements UserAdvertItem {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public final Image c;
    @Nullable
    public final String d;
    @Nullable
    public final String e;
    public final long f;
    @Nullable
    public final AdvertStats g;
    @Nullable
    public final Map<String, Image> h;
    @Nullable
    public final TimeToLive i;
    @Nullable
    public final String j;
    public final boolean k;
    @NotNull
    public final DeepLink l;
    public final boolean m;
    @Nullable
    public final UserAdvert.Status n;
    @Nullable
    public final UserOrderStatus o;
    @Nullable
    public final PriceTypeBadge p;
    public final boolean q;
    @Nullable
    public final ForegroundImage r;

    public AdvertItem(@NotNull String str, @NotNull String str2, @Nullable Image image, @Nullable String str3, @Nullable String str4, long j2, @Nullable AdvertStats advertStats, @Nullable Map<String, Image> map, @Nullable TimeToLive timeToLive, @Nullable String str5, boolean z, @NotNull DeepLink deepLink, boolean z2, @Nullable UserAdvert.Status status, @Nullable UserOrderStatus userOrderStatus, @Nullable PriceTypeBadge priceTypeBadge, boolean z3, @Nullable ForegroundImage foregroundImage) {
        a.W0(str, "stringId", str2, "title", deepLink, "deepLink");
        this.a = str;
        this.b = str2;
        this.c = image;
        this.d = str3;
        this.e = str4;
        this.f = j2;
        this.g = advertStats;
        this.h = map;
        this.i = timeToLive;
        this.j = str5;
        this.k = z;
        this.l = deepLink;
        this.m = z2;
        this.n = status;
        this.o = userOrderStatus;
        this.p = priceTypeBadge;
        this.q = z3;
        this.r = foregroundImage;
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItem
    @Nullable
    public String getDeclineReason() {
        return this.j;
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItem
    @NotNull
    public DeepLink getDeepLink() {
        return this.l;
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItem
    @Nullable
    public ForegroundImage getForegroundImage() {
        return this.r;
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItem
    public boolean getHasDelivery() {
        return this.m;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return UserAdvertItem.DefaultImpls.getId(this);
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItem
    @Nullable
    public Image getImage() {
        return this.c;
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItem
    @Nullable
    public UserOrderStatus getOrderStatus() {
        return this.o;
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItem
    @Nullable
    public String getPrice() {
        return this.d;
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItem
    @Nullable
    public PriceTypeBadge getPriceTypeBadge() {
        return this.p;
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItem
    @Nullable
    public Map<String, Image> getServicesIcons() {
        return this.h;
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItem
    @Nullable
    public String getShortcut() {
        return this.e;
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItem
    @Nullable
    public AdvertStats getStats() {
        return this.g;
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItem
    @Nullable
    public UserAdvert.Status getStatus() {
        return this.n;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItem
    public long getTime() {
        return this.f;
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItem
    @NotNull
    public String getTitle() {
        return this.b;
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItem
    @Nullable
    public TimeToLive getTtl() {
        return this.i;
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItem
    public boolean isAutoPublishOn() {
        return this.q;
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItem
    public boolean isModerated() {
        return this.k;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdvertItem(String str, String str2, Image image, String str3, String str4, long j2, AdvertStats advertStats, Map map, TimeToLive timeToLive, String str5, boolean z, DeepLink deepLink, boolean z2, UserAdvert.Status status, UserOrderStatus userOrderStatus, PriceTypeBadge priceTypeBadge, boolean z3, ForegroundImage foregroundImage, int i2, j jVar) {
        this(str, str2, image, str3, str4, j2, advertStats, map, timeToLive, str5, (i2 & 1024) != 0 ? false : z, deepLink, z2, status, userOrderStatus, (32768 & i2) != 0 ? null : priceTypeBadge, z3, (i2 & 131072) != 0 ? null : foregroundImage);
    }
}
