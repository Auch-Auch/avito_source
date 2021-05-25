package com.avito.android.advert.item.commercials;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/advert/item/commercials/AdvertCommercials;", "", "Lcom/avito/android/advert/item/commercials/AdvertSerpCommercialBanner;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert/item/commercials/AdvertSerpCommercialBanner;", "getBottomCommercial", "()Lcom/avito/android/advert/item/commercials/AdvertSerpCommercialBanner;", "bottomCommercial", AuthSource.SEND_ABUSE, "getTopCommercial", "topCommercial", "<init>", "(Lcom/avito/android/advert/item/commercials/AdvertSerpCommercialBanner;Lcom/avito/android/advert/item/commercials/AdvertSerpCommercialBanner;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertCommercials {
    @Nullable
    public final AdvertSerpCommercialBanner a;
    @Nullable
    public final AdvertSerpCommercialBanner b;

    public AdvertCommercials() {
        this(null, null, 3, null);
    }

    public AdvertCommercials(@Nullable AdvertSerpCommercialBanner advertSerpCommercialBanner, @Nullable AdvertSerpCommercialBanner advertSerpCommercialBanner2) {
        this.a = advertSerpCommercialBanner;
        this.b = advertSerpCommercialBanner2;
    }

    @Nullable
    public final AdvertSerpCommercialBanner getBottomCommercial() {
        return this.b;
    }

    @Nullable
    public final AdvertSerpCommercialBanner getTopCommercial() {
        return this.a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdvertCommercials(AdvertSerpCommercialBanner advertSerpCommercialBanner, AdvertSerpCommercialBanner advertSerpCommercialBanner2, int i, j jVar) {
        this((i & 1) != 0 ? null : advertSerpCommercialBanner, (i & 2) != 0 ? null : advertSerpCommercialBanner2);
    }
}
