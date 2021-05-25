package com.avito.android.user_adverts.tab_screens.advert_list.user_advert;

import a2.g.r.g;
import com.avito.android.component.user_advert.PriceTypeBadge;
import com.avito.android.component.user_advert.UserAdvertItem;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertStats;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.TimeToLive;
import com.avito.android.remote.model.UserAdvert;
import com.avito.android.remote.model.user_adverts.UserOrderStatus;
import com.avito.android.serp.adapter.DisplayTypeAwareItem;
import com.avito.android.serp.adapter.SerpItem;
import com.google.firebase.messaging.Constants;
import com.vk.sdk.api.VKApiConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BÍ\u0001\u0012\u0006\u0010c\u001a\u00020\n\u0012\u0006\u0010`\u001a\u00020\n\u0012\b\u0010]\u001a\u0004\u0018\u00010<\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019\u0012\u0014\u0010A\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020<\u0018\u00010;\u0012\b\u00107\u001a\u0004\u0018\u000102\u0012\b\u0010:\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010O\u001a\u00020J\u0012\u0006\u0010R\u001a\u00020\u001f\u0012\b\u0010G\u001a\u0004\u0018\u00010B\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010i\u001a\u00020d\u0012\u0006\u0010+\u001a\u00020$\u0012\b\u00101\u001a\u0004\u0018\u00010,\u0012\u0006\u0010I\u001a\u00020\u001f\u0012\n\b\u0002\u0010X\u001a\u0004\u0018\u00010S¢\u0006\u0004\bj\u0010kR\u001c\u0010\t\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000eR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\"\u001a\u00020\u001f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\"\u0010+\u001a\u00020$8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u00101\u001a\u0004\u0018\u00010,8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001e\u00107\u001a\u0004\u0018\u0001028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001e\u0010:\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b8\u0010\f\u001a\u0004\b9\u0010\u000eR*\u0010A\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020<\u0018\u00010;8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u001e\u0010G\u001a\u0004\u0018\u00010B8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u001c\u0010I\u001a\u00020\u001f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bH\u0010!\u001a\u0004\bI\u0010#R\u001c\u0010O\u001a\u00020J8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u001c\u0010R\u001a\u00020\u001f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bP\u0010!\u001a\u0004\bQ\u0010#R\u001e\u0010X\u001a\u0004\u0018\u00010S8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR\u001e\u0010]\u001a\u0004\u0018\u00010<8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R\u001c\u0010`\u001a\u00020\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b^\u0010\f\u001a\u0004\b_\u0010\u000eR\u001c\u0010c\u001a\u00020\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\ba\u0010\f\u001a\u0004\bb\u0010\u000eR\u001c\u0010i\u001a\u00020d8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010h¨\u0006l"}, d2 = {"Lcom/avito/android/user_adverts/tab_screens/advert_list/user_advert/SerpUserAdvertItem;", "Lcom/avito/android/serp/adapter/SerpItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/component/user_advert/UserAdvertItem;", "", "f", "J", "getTime", "()J", "time", "", "e", "Ljava/lang/String;", "getShortcut", "()Ljava/lang/String;", "shortcut", "Lcom/avito/android/remote/model/user_adverts/UserOrderStatus;", "o", "Lcom/avito/android/remote/model/user_adverts/UserOrderStatus;", "getOrderStatus", "()Lcom/avito/android/remote/model/user_adverts/UserOrderStatus;", "orderStatus", "d", "getPrice", "price", "Lcom/avito/android/remote/model/AdvertStats;", g.a, "Lcom/avito/android/remote/model/AdvertStats;", "getStats", "()Lcom/avito/android/remote/model/AdvertStats;", "stats", "", "k", "Z", "isModerated", "()Z", "Lcom/avito/android/remote/model/SerpDisplayType;", VKApiConst.Q, "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "displayType", "Lcom/avito/android/component/user_advert/PriceTypeBadge;", "r", "Lcom/avito/android/component/user_advert/PriceTypeBadge;", "getPriceTypeBadge", "()Lcom/avito/android/component/user_advert/PriceTypeBadge;", "priceTypeBadge", "Lcom/avito/android/remote/model/TimeToLive;", "i", "Lcom/avito/android/remote/model/TimeToLive;", "getTtl", "()Lcom/avito/android/remote/model/TimeToLive;", Constants.FirelogAnalytics.PARAM_TTL, "j", "getDeclineReason", "declineReason", "", "Lcom/avito/android/remote/model/Image;", "h", "Ljava/util/Map;", "getServicesIcons", "()Ljava/util/Map;", "servicesIcons", "Lcom/avito/android/remote/model/UserAdvert$Status;", "n", "Lcom/avito/android/remote/model/UserAdvert$Status;", "getStatus", "()Lcom/avito/android/remote/model/UserAdvert$Status;", "status", "s", "isAutoPublishOn", "Lcom/avito/android/deep_linking/links/DeepLink;", "l", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", AuthSource.OPEN_CHANNEL_LIST, "getHasDelivery", "hasDelivery", "Lcom/avito/android/remote/model/ForegroundImage;", "t", "Lcom/avito/android/remote/model/ForegroundImage;", "getForegroundImage", "()Lcom/avito/android/remote/model/ForegroundImage;", "foregroundImage", "c", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "image", AuthSource.BOOKING_ORDER, "getTitle", "title", AuthSource.SEND_ABUSE, "getStringId", "stringId", "", "p", "I", "getSpanCount", "()I", "spanCount", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;JLcom/avito/android/remote/model/AdvertStats;Ljava/util/Map;Lcom/avito/android/remote/model/TimeToLive;Ljava/lang/String;ZLcom/avito/android/deep_linking/links/DeepLink;ZLcom/avito/android/remote/model/UserAdvert$Status;Lcom/avito/android/remote/model/user_adverts/UserOrderStatus;ILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/component/user_advert/PriceTypeBadge;ZLcom/avito/android/remote/model/ForegroundImage;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class SerpUserAdvertItem implements SerpItem, DisplayTypeAwareItem, UserAdvertItem {
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
    public final int p;
    @NotNull
    public SerpDisplayType q;
    @Nullable
    public final PriceTypeBadge r;
    public final boolean s;
    @Nullable
    public final ForegroundImage t;

    public SerpUserAdvertItem(@NotNull String str, @NotNull String str2, @Nullable Image image, @Nullable String str3, @Nullable String str4, long j2, @Nullable AdvertStats advertStats, @Nullable Map<String, Image> map, @Nullable TimeToLive timeToLive, @Nullable String str5, boolean z, @NotNull DeepLink deepLink, boolean z2, @Nullable UserAdvert.Status status, @Nullable UserOrderStatus userOrderStatus, int i2, @NotNull SerpDisplayType serpDisplayType, @Nullable PriceTypeBadge priceTypeBadge, boolean z3, @Nullable ForegroundImage foregroundImage) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
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
        this.p = i2;
        this.q = serpDisplayType;
        this.r = priceTypeBadge;
        this.s = z3;
        this.t = foregroundImage;
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

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.q;
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItem
    @Nullable
    public ForegroundImage getForegroundImage() {
        return this.t;
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItem
    public boolean getHasDelivery() {
        return this.m;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return SerpItem.DefaultImpls.getId(this);
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
        return this.r;
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

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.p;
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
        return this.s;
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItem
    public boolean isModerated() {
        return this.k;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.q = serpDisplayType;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SerpUserAdvertItem(String str, String str2, Image image, String str3, String str4, long j2, AdvertStats advertStats, Map map, TimeToLive timeToLive, String str5, boolean z, DeepLink deepLink, boolean z2, UserAdvert.Status status, UserOrderStatus userOrderStatus, int i2, SerpDisplayType serpDisplayType, PriceTypeBadge priceTypeBadge, boolean z3, ForegroundImage foregroundImage, int i3, j jVar) {
        this(str, str2, image, str3, str4, j2, advertStats, map, timeToLive, str5, (i3 & 1024) != 0 ? false : z, deepLink, z2, status, userOrderStatus, i2, serpDisplayType, priceTypeBadge, z3, (i3 & 524288) != 0 ? null : foregroundImage);
    }
}
