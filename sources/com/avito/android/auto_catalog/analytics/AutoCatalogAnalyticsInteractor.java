package com.avito.android.auto_catalog.analytics;

import com.avito.android.auto_catalog.analytics.events.AutoCatalogShowEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/auto_catalog/analytics/AutoCatalogAnalyticsInteractor;", "", "Lcom/avito/android/auto_catalog/analytics/events/AutoCatalogShowEvent$FromPage;", "fromPage", "", "sendShowAutoCatalog", "(Lcom/avito/android/auto_catalog/analytics/events/AutoCatalogShowEvent$FromPage;)V", "sendShareEvent", "()V", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
public interface AutoCatalogAnalyticsInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void sendShowAutoCatalog$default(AutoCatalogAnalyticsInteractor autoCatalogAnalyticsInteractor, AutoCatalogShowEvent.FromPage fromPage, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    fromPage = null;
                }
                autoCatalogAnalyticsInteractor.sendShowAutoCatalog(fromPage);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendShowAutoCatalog");
        }
    }

    void sendShareEvent();

    void sendShowAutoCatalog(@Nullable AutoCatalogShowEvent.FromPage fromPage);
}
