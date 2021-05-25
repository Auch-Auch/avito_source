package com.avito.android.user_adverts.tab_screens.converters;

import com.avito.android.component.user_advert.PriceTypeBadge;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.remote.model.AdvertImage;
import com.avito.android.remote.model.AdvertStats;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.PriceBadge;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.Service;
import com.avito.android.remote.model.TimeToLive;
import com.avito.android.remote.model.UserAdvert;
import com.avito.android.remote.model.Video;
import com.avito.android.remote.model.user_adverts.UserOrderStatus;
import com.avito.android.user_adverts.tab_screens.advert_list.user_advert.SerpUserAdvertItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/user_adverts/tab_screens/converters/UserAdvertConverterImpl;", "Lcom/avito/android/user_adverts/tab_screens/converters/UserAdvertConverter;", "Lcom/avito/android/remote/model/UserAdvert;", "userAdvert", "Lcom/avito/android/user_adverts/tab_screens/advert_list/user_advert/SerpUserAdvertItem;", "convert", "(Lcom/avito/android/remote/model/UserAdvert;)Lcom/avito/android/user_adverts/tab_screens/advert_list/user_advert/SerpUserAdvertItem;", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class UserAdvertConverterImpl implements UserAdvertConverter {
    @Override // com.avito.android.user_adverts.tab_screens.converters.UserAdvertConverter
    @NotNull
    public SerpUserAdvertItem convert(@NotNull UserAdvert userAdvert) {
        Image image;
        Map map;
        DeepLink deepLink;
        boolean z;
        PriceTypeBadge priceTypeBadge;
        Intrinsics.checkNotNullParameter(userAdvert, "userAdvert");
        String id = userAdvert.getId();
        String title = userAdvert.getTitle();
        AdvertImage image2 = userAdvert.getImage();
        if (image2 == null || (image = image2.getImage()) == null) {
            Video video = userAdvert.getVideo();
            image = video != null ? video.getPreviewImage() : null;
        }
        String price = userAdvert.getPrice();
        String shortcut = userAdvert.getShortcut();
        long time = userAdvert.getTime();
        AdvertStats stats = userAdvert.getStats();
        List<Service> servicesIcons = userAdvert.getServicesIcons();
        if (servicesIcons != null) {
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(servicesIcons, 10));
            for (T t : servicesIcons) {
                arrayList.add(TuplesKt.to(t.getId(), t.getIcon()));
            }
            map = r.toMap(arrayList);
        } else {
            map = null;
        }
        TimeToLive ttl = userAdvert.getTtl();
        String declineReason = userAdvert.getDeclineReason();
        boolean isModerated = userAdvert.isModerated();
        DeepLink deepLink2 = userAdvert.getDeepLink();
        if (deepLink2 == null) {
            deepLink2 = new NoMatchLink();
        }
        Boolean hasDelivery = userAdvert.getHasDelivery();
        boolean booleanValue = hasDelivery != null ? hasDelivery.booleanValue() : false;
        UserAdvert.Status status = userAdvert.getStatus();
        UserOrderStatus orderStatus = userAdvert.getOrderStatus();
        SerpDisplayType serpDisplayType = SerpDisplayType.List;
        PriceBadge priceBadge = userAdvert.getPriceBadge();
        if (priceBadge == null) {
            priceTypeBadge = null;
            deepLink = deepLink2;
            z = booleanValue;
        } else {
            z = booleanValue;
            deepLink = deepLink2;
            priceTypeBadge = new PriceTypeBadge(priceBadge.getTitle(), priceBadge.getUniversalTitleColor(), priceBadge.getUniversalBackgroundColor());
        }
        Boolean isAutoPublishOn = userAdvert.isAutoPublishOn();
        return new SerpUserAdvertItem(id, title, image, price, shortcut, time, stats, map, ttl, declineReason, isModerated, deepLink, z, status, orderStatus, 1, serpDisplayType, priceTypeBadge, isAutoPublishOn != null ? isAutoPublishOn.booleanValue() : false, userAdvert.getForegroundImage());
    }
}
