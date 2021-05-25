package com.avito.android.auto_catalog.analytics;

import com.avito.android.advert_core.analytics.sharing.ItemSharingEvent;
import com.avito.android.analytics.Analytics;
import com.avito.android.auto_catalog.AutoCatalogData;
import com.avito.android.auto_catalog.analytics.events.AutoCatalogShowEvent;
import com.avito.android.auto_catalog.di.AutoCatalogModule;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/avito/android/auto_catalog/analytics/AutoCatalogAnalyticsInteractorImpl;", "Lcom/avito/android/auto_catalog/analytics/AutoCatalogAnalyticsInteractor;", "Lcom/avito/android/auto_catalog/analytics/events/AutoCatalogShowEvent$FromPage;", "fromPage", "", "sendShowAutoCatalog", "(Lcom/avito/android/auto_catalog/analytics/events/AutoCatalogShowEvent$FromPage;)V", "sendShareEvent", "()V", AuthSource.SEND_ABUSE, "Lcom/avito/android/auto_catalog/analytics/events/AutoCatalogShowEvent$FromPage;", "defaultFromPage", "Lcom/avito/android/auto_catalog/AutoCatalogData;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/auto_catalog/AutoCatalogData;", "autoCatalogData", "", "c", "Ljava/lang/String;", "searchContext", "Lcom/avito/android/analytics/Analytics;", "d", "Lcom/avito/android/analytics/Analytics;", "analytics", "from", "<init>", "(Lcom/avito/android/auto_catalog/AutoCatalogData;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/analytics/Analytics;)V", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class AutoCatalogAnalyticsInteractorImpl implements AutoCatalogAnalyticsInteractor {
    public final AutoCatalogShowEvent.FromPage a;
    public final AutoCatalogData b;
    public final String c;
    public final Analytics d;

    @Inject
    public AutoCatalogAnalyticsInteractorImpl(@NotNull AutoCatalogData autoCatalogData, @AutoCatalogModule.SearchContext @Nullable String str, @AutoCatalogModule.FromScreen @Nullable String str2, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(autoCatalogData, "autoCatalogData");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.b = autoCatalogData;
        this.c = str;
        this.d = analytics;
        this.a = AutoCatalogAnalyticsInteractorKt.toFromPage(str2);
    }

    @Override // com.avito.android.auto_catalog.analytics.AutoCatalogAnalyticsInteractor
    public void sendShareEvent() {
        this.d.track(ItemSharingEvent.Companion.createForAutoCatalog());
    }

    @Override // com.avito.android.auto_catalog.analytics.AutoCatalogAnalyticsInteractor
    public void sendShowAutoCatalog(@Nullable AutoCatalogShowEvent.FromPage fromPage) {
        Analytics analytics = this.d;
        String advertId = this.b.getAdvertId();
        String advertMcid = this.b.getAdvertMcid();
        String str = this.c;
        if (fromPage == null) {
            fromPage = this.a;
        }
        analytics.track(new AutoCatalogShowEvent(advertId, advertMcid, str, fromPage));
    }
}
