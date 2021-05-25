package com.avito.android.safedeal.delivery_courier;

import android.app.Application;
import android.content.Intent;
import com.avito.android.DeliveryCourierIntentFactory;
import com.avito.android.advert_core.marketplace.MarketplacePresenterKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ParametrizedEvent;
import com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateActivityKt;
import com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryActivityKt;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectActivityKt;
import com.avito.android.safedeal.delivery_type.DeliveryTypeData;
import com.avito.android.safedeal.delivery_type.DeliveryTypeTransparentActivityKt;
import com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsActivityKt;
import com.facebook.internal.AnalyticsEvents;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u000bJ=\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/DeliveryCourierIntentFactoryImpl;", "Lcom/avito/android/DeliveryCourierIntentFactory;", "", "itemId", "source", "searchContext", "Landroid/content/Intent;", "deliveryCourierSummary", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "orderID", "deliveryCourierOrderUpdate", "(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "deliveryCourierDateRangeSelect", "", "isMarketplace", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/avito/android/remote/model/ParametrizedEvent;", MarketplacePresenterKt.KEY_CONTACT_EVENT, "deliveryTypeIntent", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/ParametrizedEvent;)Landroid/content/Intent;", "profileRdsDeliverySettingsIntent", "()Landroid/content/Intent;", "Landroid/app/Application;", AuthSource.SEND_ABUSE, "Landroid/app/Application;", "context", "<init>", "(Landroid/app/Application;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryCourierIntentFactoryImpl implements DeliveryCourierIntentFactory {
    public final Application a;

    @Inject
    public DeliveryCourierIntentFactoryImpl(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        this.a = application;
    }

    @Override // com.avito.android.DeliveryCourierIntentFactory
    @NotNull
    public Intent deliveryCourierDateRangeSelect(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "orderID");
        Intrinsics.checkNotNullParameter(str2, "source");
        return DeliveryCourierTimeIntervalSelectActivityKt.createDeliveryCourierDateRangeSelectIntent(this.a, str, str2);
    }

    @Override // com.avito.android.DeliveryCourierIntentFactory
    @NotNull
    public Intent deliveryCourierOrderUpdate(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "orderID");
        Intrinsics.checkNotNullParameter(str2, "source");
        return DeliveryCourierOrderUpdateActivityKt.createDeliveryCourierOrderUpdateIntent(this.a, str, str2);
    }

    @Override // com.avito.android.DeliveryCourierIntentFactory
    @NotNull
    public Intent deliveryCourierSummary(@NotNull String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        return DeliveryCourierSummaryActivityKt.createCourierDeliverySummaryIntent(this.a, str, str3);
    }

    @Override // com.avito.android.DeliveryCourierIntentFactory
    @NotNull
    public Intent deliveryTypeIntent(@NotNull String str, boolean z, @Nullable String str2, @Nullable String str3, @Nullable ParametrizedEvent parametrizedEvent) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        return DeliveryTypeTransparentActivityKt.createTransparentDeliveryTypeIntent(this.a, new DeliveryTypeData(str, z, str2, ScreenStyle.Companion.fromString(str3), parametrizedEvent));
    }

    @Override // com.avito.android.DeliveryCourierIntentFactory
    @NotNull
    public Intent profileRdsDeliverySettingsIntent() {
        return ProfileDeliverySettingsActivityKt.createProfileDeliverySettingsIntent(this.a);
    }
}
