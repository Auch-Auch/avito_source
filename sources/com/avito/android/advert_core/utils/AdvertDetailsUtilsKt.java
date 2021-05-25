package com.avito.android.advert_core.utils;

import android.content.Context;
import com.avito.android.remote.model.AdjustParameters;
import com.avito.android.remote.model.AdvertDetails;
import com.avito.android.remote.model.AdvertPrice;
import com.avito.android.remote.model.AdvertSeller;
import com.avito.android.remote.model.AdvertisementVerticalAlias;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.VehicleType;
import com.avito.android.remote.model.advert_details.ContactBarData;
import com.avito.android.remote.model.advert_details.SellerOnlineStatus;
import com.avito.android.remote.model.advert_details.UserIconType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0007\u001a\u00020\u0006*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\f\u001a\u00020\t*\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/model/AdvertDetails;", "", "source", "Lcom/avito/android/remote/model/advert_details/ContactBarData;", "toContactBarData", "(Lcom/avito/android/remote/model/AdvertDetails;Ljava/lang/String;)Lcom/avito/android/remote/model/advert_details/ContactBarData;", "Lcom/avito/android/remote/model/advert_details/UserIconType;", "getIconType", "(Lcom/avito/android/remote/model/AdvertDetails;)Lcom/avito/android/remote/model/advert_details/UserIconType;", "", "Landroid/content/Context;", "context", "dimen", "(Ljava/lang/Integer;Landroid/content/Context;)I", "advert-core_release"}, k = 2, mv = {1, 4, 2})
public final class AdvertDetailsUtilsKt {
    public static final int dimen(@Nullable Integer num, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (num == null || num.intValue() == 0) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(num.intValue());
    }

    @NotNull
    public static final UserIconType getIconType(@NotNull AdvertDetails advertDetails) {
        Intrinsics.checkNotNullParameter(advertDetails, "$this$getIconType");
        if (advertDetails.isShopAdvert()) {
            return UserIconType.SHOP;
        }
        if (advertDetails.isFromCompany()) {
            return UserIconType.COMPANY;
        }
        return UserIconType.PRIVATE;
    }

    @Nullable
    public static final ContactBarData toContactBarData(@NotNull AdvertDetails advertDetails, @NotNull String str) {
        String name;
        AdvertisementVerticalAlias advertisementVerticalAlias;
        Intrinsics.checkNotNullParameter(advertDetails, "$this$toContactBarData");
        Intrinsics.checkNotNullParameter(str, "source");
        AdvertSeller seller = advertDetails.getSeller();
        String str2 = null;
        if (seller == null || (name = seller.getName()) == null) {
            return null;
        }
        UserIconType iconType = getIconType(advertDetails);
        SellerOnlineStatus mapSellerOnlineStatus = AdvertSellersKt.mapSellerOnlineStatus(advertDetails.getSeller());
        AdvertSeller seller2 = advertDetails.getSeller();
        Image image = seller2 != null ? seller2.getImage() : null;
        String id = advertDetails.getId();
        String title = advertDetails.getTitle();
        String description = advertDetails.getDescription();
        if (description == null) {
            description = "";
        }
        AdvertPrice price = advertDetails.getPrice();
        List<Image> images = advertDetails.getImages();
        Image image2 = images != null ? (Image) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) images) : null;
        String categoryId = advertDetails.getCategoryId();
        AdjustParameters adjustParameters = advertDetails.getAdjustParameters();
        String categoryId2 = adjustParameters != null ? adjustParameters.getCategoryId() : null;
        boolean isFromCompany = advertDetails.isFromCompany();
        String metroId = advertDetails.getMetroId();
        AdvertSeller seller3 = advertDetails.getSeller();
        String userHashId = seller3 != null ? seller3.getUserHashId() : null;
        String locationId = advertDetails.getLocationId();
        String shopId = advertDetails.getShopId();
        AdjustParameters adjustParameters2 = advertDetails.getAdjustParameters();
        if (adjustParameters2 == null || (advertisementVerticalAlias = adjustParameters2.getVerticalAlias()) == null) {
            advertisementVerticalAlias = AdvertisementVerticalAlias.NO_VALUE;
        }
        AdjustParameters adjustParameters3 = advertDetails.getAdjustParameters();
        if (adjustParameters3 != null) {
            str2 = adjustParameters3.getMicroCategoryId();
        }
        VehicleType vehicleType = advertDetails.getVehicleType();
        if (vehicleType == null) {
            vehicleType = VehicleType.NO_VALUE;
        }
        return new ContactBarData(name, mapSellerOnlineStatus, image, iconType, id, title, description, price, image2, categoryId, categoryId2, isFromCompany, metroId, userHashId, locationId, shopId, advertisementVerticalAlias, str2, vehicleType, str, false, advertDetails.getIcebreakers(), advertDetails.getCustomerValue(), advertDetails.getViewItemAndBuyerEventsParams(), advertDetails.getMarketplaceData() != null, 1048576, null);
    }

    public static /* synthetic */ ContactBarData toContactBarData$default(AdvertDetails advertDetails, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "item";
        }
        return toContactBarData(advertDetails, str);
    }
}
