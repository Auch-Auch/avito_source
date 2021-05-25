package com.avito.android.auto_catalog.analytics;

import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractorKt;
import com.avito.android.auto_catalog.analytics.events.AutoCatalogShowEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"", "Lcom/avito/android/auto_catalog/analytics/events/AutoCatalogShowEvent$FromPage;", "toFromPage", "(Ljava/lang/String;)Lcom/avito/android/auto_catalog/analytics/events/AutoCatalogShowEvent$FromPage;", "auto-catalog_release"}, k = 2, mv = {1, 4, 2})
public final class AutoCatalogAnalyticsInteractorKt {
    @NotNull
    public static final AutoCatalogShowEvent.FromPage toFromPage(@Nullable String str) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 3242771) {
                if (hashCode == 1660783520 && str.equals(AdvertDetailsAnalyticsInteractorKt.PAGE_TYPE_AUTO_CARD)) {
                    return AutoCatalogShowEvent.FromPage.AUTO_CARD;
                }
            } else if (str.equals("item")) {
                return AutoCatalogShowEvent.FromPage.ITEM;
            }
        }
        return AutoCatalogShowEvent.FromPage.DIRECT;
    }
}
