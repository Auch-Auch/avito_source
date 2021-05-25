package com.avito.android.advert_core.phone_request;

import com.avito.android.PhoneRequestDeepLinkAnalyticsData;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.advert_core.analytics.contactbar.ShowPhoneDialerEvent;
import com.avito.android.advert_core.analytics.contactbar.ShowPhoneDialogEvent;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.CallToSellerConfirmedEvent;
import com.avito.android.analytics.event.DevelopmentsCatalogShowPhoneEvent;
import com.avito.android.analytics.event.ShopContactCallEvent;
import com.avito.android.analytics.event.ShopContactsDisplayEvent;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/advert_core/phone_request/PhoneRequestDeepLinkAnalyticsInteractorImpl;", "Lcom/avito/android/advert_core/phone_request/PhoneRequestDeepLinkAnalyticsInteractor;", "", "trackPhoneShowed", "()V", "trackPhoneConfirmed", "trackSuccessOpenDialer", "trackFailedOpenDialer", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/PhoneRequestDeepLinkAnalyticsData;", AuthSource.SEND_ABUSE, "Lcom/avito/android/PhoneRequestDeepLinkAnalyticsData;", "analyticsData", "<init>", "(Lcom/avito/android/PhoneRequestDeepLinkAnalyticsData;Lcom/avito/android/analytics/Analytics;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneRequestDeepLinkAnalyticsInteractorImpl implements PhoneRequestDeepLinkAnalyticsInteractor {
    public final PhoneRequestDeepLinkAnalyticsData a;
    public final Analytics b;

    @Inject
    public PhoneRequestDeepLinkAnalyticsInteractorImpl(@Nullable PhoneRequestDeepLinkAnalyticsData phoneRequestDeepLinkAnalyticsData, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = phoneRequestDeepLinkAnalyticsData;
        this.b = analytics;
    }

    @Override // com.avito.android.advert_core.phone_request.PhoneRequestDeepLinkAnalyticsInteractor
    public void trackFailedOpenDialer() {
        PhoneRequestDeepLinkAnalyticsData phoneRequestDeepLinkAnalyticsData = this.a;
        if (phoneRequestDeepLinkAnalyticsData instanceof PhoneRequestDeepLinkAnalyticsData.Advert) {
            this.b.track(new ShowPhoneDialerEvent(((PhoneRequestDeepLinkAnalyticsData.Advert) phoneRequestDeepLinkAnalyticsData).getAdvertId(), "error", false, null, null, 24, null));
        }
    }

    @Override // com.avito.android.advert_core.phone_request.PhoneRequestDeepLinkAnalyticsInteractor
    public void trackPhoneConfirmed() {
        PhoneRequestDeepLinkAnalyticsData phoneRequestDeepLinkAnalyticsData = this.a;
        if (phoneRequestDeepLinkAnalyticsData instanceof PhoneRequestDeepLinkAnalyticsData.ShopDetails) {
            this.b.track(new ShopContactCallEvent(((PhoneRequestDeepLinkAnalyticsData.ShopDetails) phoneRequestDeepLinkAnalyticsData).getUserKey(), ((PhoneRequestDeepLinkAnalyticsData.ShopDetails) this.a).getSource()));
        } else if (phoneRequestDeepLinkAnalyticsData instanceof PhoneRequestDeepLinkAnalyticsData.Advert) {
            this.b.track(new CallToSellerConfirmedEvent(((PhoneRequestDeepLinkAnalyticsData.Advert) phoneRequestDeepLinkAnalyticsData).getAdvertId(), null));
        }
    }

    @Override // com.avito.android.advert_core.phone_request.PhoneRequestDeepLinkAnalyticsInteractor
    public void trackPhoneShowed() {
        PhoneRequestDeepLinkAnalyticsData phoneRequestDeepLinkAnalyticsData = this.a;
        if (phoneRequestDeepLinkAnalyticsData instanceof PhoneRequestDeepLinkAnalyticsData.ResidentialComplex) {
            this.b.track(new DevelopmentsCatalogShowPhoneEvent(((PhoneRequestDeepLinkAnalyticsData.ResidentialComplex) phoneRequestDeepLinkAnalyticsData).getDevelopmentId(), ((PhoneRequestDeepLinkAnalyticsData.ResidentialComplex) this.a).getMetroIds(), ((PhoneRequestDeepLinkAnalyticsData.ResidentialComplex) this.a).getSearchContext(), ((PhoneRequestDeepLinkAnalyticsData.ResidentialComplex) this.a).getLocationId()));
        } else if (phoneRequestDeepLinkAnalyticsData instanceof PhoneRequestDeepLinkAnalyticsData.ShopDetails) {
            this.b.track(new ShopContactsDisplayEvent(((PhoneRequestDeepLinkAnalyticsData.ShopDetails) phoneRequestDeepLinkAnalyticsData).getUserKey(), ((PhoneRequestDeepLinkAnalyticsData.ShopDetails) this.a).getSource()));
        } else if (phoneRequestDeepLinkAnalyticsData instanceof PhoneRequestDeepLinkAnalyticsData.Advert) {
            this.b.track(new ShowPhoneDialogEvent(((PhoneRequestDeepLinkAnalyticsData.Advert) phoneRequestDeepLinkAnalyticsData).getAdvertId(), PhonePageSourceKt.PHONE_SOURCE_BUTTON));
        }
    }

    @Override // com.avito.android.advert_core.phone_request.PhoneRequestDeepLinkAnalyticsInteractor
    public void trackSuccessOpenDialer() {
        PhoneRequestDeepLinkAnalyticsData phoneRequestDeepLinkAnalyticsData = this.a;
        if (phoneRequestDeepLinkAnalyticsData instanceof PhoneRequestDeepLinkAnalyticsData.Advert) {
            this.b.track(new ShowPhoneDialerEvent(((PhoneRequestDeepLinkAnalyticsData.Advert) phoneRequestDeepLinkAnalyticsData).getAdvertId(), PhonePageSourceKt.PHONE_SOURCE_BUTTON, true, null, null, 24, null));
        }
    }
}
