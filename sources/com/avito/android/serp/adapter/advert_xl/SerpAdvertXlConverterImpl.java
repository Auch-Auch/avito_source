package com.avito.android.serp.adapter.advert_xl;

import com.avito.android.Features;
import com.avito.android.component.user_advert.PriceTypeBadge;
import com.avito.android.deep_linking.links.AdvertDetailsLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.AdvertActions;
import com.avito.android.remote.model.AdvertSellerInfo;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.GeoReference;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.LegacySerpAdvertBadge;
import com.avito.android.remote.model.NameIdEntity;
import com.avito.android.remote.model.RadiusInfo;
import com.avito.android.remote.model.SerpAdvertXl;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.ServiceTypeKt;
import com.avito.android.remote.model.badge_bar.SerpBadgeBar;
import com.avito.android.serp.adapter.SerpElementUtilsKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/serp/adapter/advert_xl/SerpAdvertXlConverterImpl;", "Lcom/avito/android/serp/adapter/advert_xl/SerpAdvertXlConverter;", "Lcom/avito/android/remote/model/SerpAdvertXl;", "advert", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem;", "convert", "(Lcom/avito/android/remote/model/SerpAdvertXl;Lcom/avito/android/remote/model/SerpDisplayType;)Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem;", "Lcom/avito/android/Features;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/Features;", "features", "", AuthSource.SEND_ABUSE, "I", "xlSpanCount", "<init>", "(ILcom/avito/android/Features;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SerpAdvertXlConverterImpl implements SerpAdvertXlConverter {
    public final int a;
    public final Features b;

    public SerpAdvertXlConverterImpl(int i, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = i;
        this.b = features;
    }

    @Override // com.avito.android.serp.adapter.advert_xl.SerpAdvertXlConverter
    @NotNull
    public AdvertXlItem convert(@NotNull SerpAdvertXl serpAdvertXl, @NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpAdvertXl, "advert");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        LegacySerpAdvertBadge badge = serpAdvertXl.getBadge();
        PriceTypeBadge priceTypeBadge = badge != null ? new PriceTypeBadge(badge.getTitle(), badge.getUniversalTitleColor(), badge.getUniversalBackgroundColor()) : null;
        long uniqueId = SerpElementUtilsKt.getUniqueId(serpAdvertXl.getUniqueId(), serpAdvertXl.getId());
        String id = serpAdvertXl.getId();
        List<Image> imageList = serpAdvertXl.getImageList();
        boolean isFavorite = serpAdvertXl.isFavorite();
        DeepLink deepLink = serpAdvertXl.getDeepLink();
        if (!(deepLink instanceof AdvertDetailsLink)) {
            deepLink = null;
        }
        AdvertDetailsLink advertDetailsLink = (AdvertDetailsLink) deepLink;
        String context = advertDetailsLink != null ? advertDetailsLink.getContext() : null;
        int i = this.a;
        String title = serpAdvertXl.getTitle();
        String description = serpAdvertXl.getDescription();
        String replace$default = description != null ? m.replace$default(description, "\n", " ", false, 4, (Object) null) : null;
        boolean z = serpAdvertXl.getDelivery() != null;
        NameIdEntity shop = serpAdvertXl.getShop();
        String name = shop != null ? shop.getName() : null;
        String location = serpAdvertXl.getLocation();
        String distance = serpAdvertXl.getDistance();
        String address = serpAdvertXl.getAddress();
        Long time = serpAdvertXl.getTime();
        long longValue = time != null ? time.longValue() : 0;
        String price = serpAdvertXl.getPrice();
        String priceWithoutDiscount = this.b.getAdvertPriceWithDiscount().invoke().booleanValue() ? serpAdvertXl.getPriceWithoutDiscount() : null;
        String previousPrice = serpAdvertXl.getPreviousPrice();
        String discountPercentage = serpAdvertXl.getDiscountPercentage();
        DeepLink deepLink2 = serpAdvertXl.getDeepLink();
        if (deepLink2 == null) {
            deepLink2 = new NoMatchLink();
        }
        Map<String, String> analyticParams = serpAdvertXl.getAnalyticParams();
        Action callAction = serpAdvertXl.getCallAction();
        AdvertActions contacts = serpAdvertXl.getContacts();
        List<String> services = serpAdvertXl.getServices();
        boolean contains = services != null ? services.contains(ServiceTypeKt.SERVICE_HIGHLIGHT) : false;
        boolean areEqual = Intrinsics.areEqual(serpAdvertXl.isVerifiedSeller(), Boolean.TRUE);
        String additionalName = serpAdvertXl.getAdditionalName();
        boolean access$isActive = SerpAdvertXlConverterKt.access$isActive(serpAdvertXl);
        SerpBadgeBar badgeBar = this.b.getBadgeBarOnSerp().invoke().booleanValue() ? serpAdvertXl.getBadgeBar() : null;
        RadiusInfo radiusInfo = serpAdvertXl.getRadiusInfo();
        AdvertSellerInfo sellerInfo = serpAdvertXl.getSellerInfo();
        List<GeoReference> geoReferences = serpAdvertXl.getGeoReferences();
        Boolean hasVideo = serpAdvertXl.getHasVideo();
        boolean booleanValue = hasVideo != null ? hasVideo.booleanValue() : false;
        ForegroundImage infoImage = serpAdvertXl.getInfoImage();
        Boolean isMarketplace = serpAdvertXl.isMarketplace();
        return new AdvertXlItem(uniqueId, id, imageList, isFavorite, context, i, serpDisplayType, title, replace$default, z, name, location, address, longValue, price, priceWithoutDiscount, previousPrice, discountPercentage, deepLink2, analyticParams, callAction, contacts, contains, access$isActive, areEqual, additionalName, false, priceTypeBadge, badgeBar, radiusInfo, sellerInfo, geoReferences, distance, booleanValue, infoImage, isMarketplace != null ? isMarketplace.booleanValue() : false, 67108864, 0, null);
    }
}
