package com.avito.android.developments_catalog.analytics;

import a2.b.a.a.a;
import com.avito.android.advert_core.analytics.consultation_form.ConsultationItemButtonClickEvent;
import com.avito.android.advert_core.analytics.sharing.ItemSharingEvent;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.CallToSellerClickStreamEvent;
import com.avito.android.analytics.event.DevelopmentsCatalogShowPhoneEvent;
import com.avito.android.developments_catalog.analytics.events.DevelopmentsCatalogAvitoOfferEvent;
import com.avito.android.developments_catalog.analytics.events.DevelopmentsCatalogShowEvent;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bJA\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ9\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/developments_catalog/analytics/DevelopmentsCatalogAnalyticsInteractorImpl;", "Lcom/avito/android/developments_catalog/analytics/DevelopmentsCatalogAnalyticsInteractor;", "", "developmentId", "", "", "metroIds", "searchContext", "locationId", "fromPage", "", "sendShowDevelopments", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sendShareEvent", "(Ljava/lang/String;Ljava/lang/String;)V", "sendCallEvent", "sendShowPhone", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "sendAvitoOfferEvent", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "sendClickToConsultationItemButton", "(Ljava/lang/String;)V", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class DevelopmentsCatalogAnalyticsInteractorImpl implements DevelopmentsCatalogAnalyticsInteractor {
    public final Analytics a;

    @Inject
    public DevelopmentsCatalogAnalyticsInteractorImpl(@NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = analytics;
    }

    @Override // com.avito.android.developments_catalog.analytics.DevelopmentsCatalogAnalyticsInteractor
    public void sendAvitoOfferEvent(@NotNull String str, @NotNull List<Integer> list, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "developmentId");
        Intrinsics.checkNotNullParameter(list, "metroIds");
        this.a.track(new DevelopmentsCatalogAvitoOfferEvent(str, list, str2));
    }

    @Override // com.avito.android.developments_catalog.analytics.DevelopmentsCatalogAnalyticsInteractor
    public void sendCallEvent(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "developmentId");
        this.a.track(CallToSellerClickStreamEvent.Companion.createForDevelopmentsCatalog(str, str2));
    }

    @Override // com.avito.android.developments_catalog.analytics.DevelopmentsCatalogAnalyticsInteractor
    public void sendClickToConsultationItemButton(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "developmentId");
        this.a.track(new ConsultationItemButtonClickEvent(null, str, 1, null));
    }

    @Override // com.avito.android.developments_catalog.analytics.DevelopmentsCatalogAnalyticsInteractor
    public void sendShareEvent(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "developmentId");
        this.a.track(ItemSharingEvent.Companion.createForDevelopmentsCatalog(str, str2));
    }

    @Override // com.avito.android.developments_catalog.analytics.DevelopmentsCatalogAnalyticsInteractor
    public void sendShowDevelopments(@NotNull String str, @NotNull List<Integer> list, @Nullable String str2, @Nullable String str3, @NotNull String str4) {
        a.d1(str, "developmentId", list, "metroIds", str4, "fromPage");
        this.a.track(new DevelopmentsCatalogShowEvent(str, list, str2, str3, str4));
    }

    @Override // com.avito.android.developments_catalog.analytics.DevelopmentsCatalogAnalyticsInteractor
    public void sendShowPhone(@NotNull String str, @NotNull List<Integer> list, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "developmentId");
        Intrinsics.checkNotNullParameter(list, "metroIds");
        this.a.track(new DevelopmentsCatalogShowPhoneEvent(str, list, str2, str3));
    }
}
