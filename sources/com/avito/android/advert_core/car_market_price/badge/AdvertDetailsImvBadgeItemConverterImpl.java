package com.avito.android.advert_core.car_market_price.badge;

import android.net.Uri;
import com.avito.android.advert_core.advert.AdvertDetailsItem;
import com.avito.android.component.badge_bar.badge.BadgeItem;
import com.avito.android.deep_linking.links.ImvWebViewBottomSheepLink;
import com.avito.android.remote.model.PriceBadge;
import com.avito.android.remote.model.UniversalColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgeItemConverterImpl;", "Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgeItemConverter;", "Lcom/avito/android/remote/model/PriceBadge;", "priceBadge", "", "spanCount", "Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgeItem;", "convert", "(Lcom/avito/android/remote/model/PriceBadge;I)Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgeItem;", "<init>", "()V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsImvBadgeItemConverterImpl implements AdvertDetailsImvBadgeItemConverter {
    @Override // com.avito.android.advert_core.car_market_price.badge.AdvertDetailsImvBadgeItemConverter
    @Nullable
    public AdvertDetailsImvBadgeItem convert(@Nullable PriceBadge priceBadge, int i) {
        ImvWebViewBottomSheepLink imvWebViewBottomSheepLink;
        if (priceBadge == null) {
            return null;
        }
        AdvertDetailsItem advertDetailsItem = AdvertDetailsItem.ITEM_IMV_BADGE;
        String valueOf = String.valueOf(41);
        String title = priceBadge.getTitle();
        String subtitle = priceBadge.getSubtitle();
        if (subtitle == null) {
            subtitle = "";
        }
        String url = priceBadge.getUrl();
        if (url != null) {
            Uri parse = Uri.parse(url);
            Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(this)");
            if (parse != null) {
                imvWebViewBottomSheepLink = new ImvWebViewBottomSheepLink(parse);
                return new AdvertDetailsImvBadgeItem(0, null, new BadgeItem(valueOf, -1, title, subtitle, UniversalColorKt.universalColorOf$default("green50", 0, 2, null), UniversalColorKt.universalColorOf$default("green50", 0, 2, null), UniversalColorKt.universalColorOf$default("black", 0, 2, null), 1, 1, null, imvWebViewBottomSheepLink, 512, null), priceBadge.getPriceType(), i, null, null, 99, null);
            }
        }
        imvWebViewBottomSheepLink = null;
        return new AdvertDetailsImvBadgeItem(0, null, new BadgeItem(valueOf, -1, title, subtitle, UniversalColorKt.universalColorOf$default("green50", 0, 2, null), UniversalColorKt.universalColorOf$default("green50", 0, 2, null), UniversalColorKt.universalColorOf$default("black", 0, 2, null), 1, 1, null, imvWebViewBottomSheepLink, 512, null), priceBadge.getPriceType(), i, null, null, 99, null);
    }
}
