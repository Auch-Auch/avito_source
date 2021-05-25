package com.avito.android.component.user_advert;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.AdvertStats;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.TimeToLive;
import com.avito.android.remote.model.UserAdvert;
import com.avito.android.remote.model.user_adverts.UserOrderStatus;
import com.avito.conveyor_item.Item;
import com.google.firebase.messaging.Constants;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\bR\u0018\u0010!\u001a\u0004\u0018\u00010\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\bR\u0016\u0010%\u001a\u00020\"8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020&8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\bR\u0018\u0010.\u001a\u0004\u0018\u00010+8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0016\u00104\u001a\u00020&8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b3\u0010(R$\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001a\u0018\u0001058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0016\u00109\u001a\u00020&8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b9\u0010(¨\u0006:"}, d2 = {"Lcom/avito/android/component/user_advert/UserAdvertItem;", "Lcom/avito/conveyor_item/Item;", "", "getTime", "()J", "time", "", "getShortcut", "()Ljava/lang/String;", "shortcut", "Lcom/avito/android/remote/model/UserAdvert$Status;", "getStatus", "()Lcom/avito/android/remote/model/UserAdvert$Status;", "status", "Lcom/avito/android/remote/model/user_adverts/UserOrderStatus;", "getOrderStatus", "()Lcom/avito/android/remote/model/user_adverts/UserOrderStatus;", "orderStatus", "Lcom/avito/android/component/user_advert/PriceTypeBadge;", "getPriceTypeBadge", "()Lcom/avito/android/component/user_advert/PriceTypeBadge;", "priceTypeBadge", "Lcom/avito/android/remote/model/ForegroundImage;", "getForegroundImage", "()Lcom/avito/android/remote/model/ForegroundImage;", "foregroundImage", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "image", "getTitle", "title", "getDeclineReason", "declineReason", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "isAutoPublishOn", "()Z", "getPrice", "price", "Lcom/avito/android/remote/model/AdvertStats;", "getStats", "()Lcom/avito/android/remote/model/AdvertStats;", "stats", "Lcom/avito/android/remote/model/TimeToLive;", "getTtl", "()Lcom/avito/android/remote/model/TimeToLive;", Constants.FirelogAnalytics.PARAM_TTL, "getHasDelivery", "hasDelivery", "", "getServicesIcons", "()Ljava/util/Map;", "servicesIcons", "isModerated", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface UserAdvertItem extends Item {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static long getId(@NotNull UserAdvertItem userAdvertItem) {
            return Item.DefaultImpls.getId(userAdvertItem);
        }
    }

    @Nullable
    String getDeclineReason();

    @NotNull
    DeepLink getDeepLink();

    @Nullable
    ForegroundImage getForegroundImage();

    boolean getHasDelivery();

    @Nullable
    Image getImage();

    @Nullable
    UserOrderStatus getOrderStatus();

    @Nullable
    String getPrice();

    @Nullable
    PriceTypeBadge getPriceTypeBadge();

    @Nullable
    Map<String, Image> getServicesIcons();

    @Nullable
    String getShortcut();

    @Nullable
    AdvertStats getStats();

    @Nullable
    UserAdvert.Status getStatus();

    long getTime();

    @NotNull
    String getTitle();

    @Nullable
    TimeToLive getTtl();

    boolean isAutoPublishOn();

    boolean isModerated();
}
