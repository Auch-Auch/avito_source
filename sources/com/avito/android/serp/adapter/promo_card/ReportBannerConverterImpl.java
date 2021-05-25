package com.avito.android.serp.adapter.promo_card;

import a2.b.a.a.a;
import com.avito.android.Features;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.remote.model.feature_teaser.CreReportTeaser;
import com.avito.android.serp.adapter.SerpViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/serp/adapter/promo_card/ReportBannerConverterImpl;", "Lcom/avito/android/serp/adapter/promo_card/ReportBannerConverter;", "Lcom/avito/android/remote/model/feature_teaser/CreReportTeaser;", "teaser", "Lcom/avito/android/serp/adapter/promo_card/PromoCardItem;", "convert", "(Lcom/avito/android/remote/model/feature_teaser/CreReportTeaser;)Lcom/avito/android/serp/adapter/promo_card/PromoCardItem;", "Lcom/avito/android/Features;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/Features;", "features", "", AuthSource.SEND_ABUSE, "I", "serpColumns", "<init>", "(ILcom/avito/android/Features;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class ReportBannerConverterImpl implements ReportBannerConverter {
    public final int a;
    public final Features b;

    public ReportBannerConverterImpl(int i, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = i;
        this.b = features;
    }

    @Override // com.avito.android.serp.adapter.promo_card.ReportBannerConverter
    @Nullable
    public PromoCardItem convert(@NotNull CreReportTeaser creReportTeaser) {
        UniversalColor backgroundColor;
        UniversalColor highlightedBackgroundColor;
        String serpTitle;
        Intrinsics.checkNotNullParameter(creReportTeaser, "teaser");
        if (!this.b.getFindOfficeOffer().invoke().booleanValue() || (backgroundColor = creReportTeaser.getBackgroundColor()) == null || (highlightedBackgroundColor = creReportTeaser.getHighlightedBackgroundColor()) == null || (serpTitle = creReportTeaser.getSerpTitle()) == null) {
            return null;
        }
        return new PromoCardItem(false, SerpViewType.SINGLE, this.a, a.I2("UUID.randomUUID().toString()"), backgroundColor, highlightedBackgroundColor, serpTitle, creReportTeaser.getImage(), CreReportTeaser.toConsultationFormDeepLink$default(creReportTeaser, null, 1, null), null, null, null, false, 5632, null);
    }
}
