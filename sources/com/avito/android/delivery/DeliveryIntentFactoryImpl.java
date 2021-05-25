package com.avito.android.delivery;

import android.app.Application;
import android.content.Intent;
import com.avito.android.DeliveryIntentFactory;
import com.avito.android.SummaryState;
import com.avito.android.advert_core.marketplace.MarketplacePresenterKt;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingActivityKt;
import com.avito.android.delivery.order_cancellation.RdsOrderCancellationActivityKt;
import com.avito.android.delivery.profile_settings.DeliveryProfileSettingsActivityKt;
import com.avito.android.delivery.summary.DeliveryRdsSummaryActivityKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ParametrizedEvent;
import com.avito.android.util.preferences.GeoContract;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010&\u001a\u00020#¢\u0006\u0004\b'\u0010(J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J[\u0010\u0010\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J;\u0010\u0014\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0001\u0010 \u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u001d2\u0006\u0010\u001f\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\"\u0010\u0018R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/avito/android/delivery/DeliveryIntentFactoryImpl;", "Lcom/avito/android/DeliveryIntentFactory;", "Landroid/content/Intent;", "deliveryProfileSettingsIntent", "()Landroid/content/Intent;", "", BookingInfoActivity.EXTRA_ITEM_ID, "source", "searchContext", "", "isMarketplace", "isCart", "firstCartItemId", "cartItems", "Lcom/avito/android/remote/model/ParametrizedEvent;", MarketplacePresenterKt.KEY_CONTACT_EVENT, "deliveryRdsStartOrderingIntent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/ParametrizedEvent;)Landroid/content/Intent;", "Lcom/avito/android/SummaryState;", "summaryState", "deliveryRdsSummaryIntent", "(Ljava/lang/String;Lcom/avito/android/SummaryState;ZZLjava/lang/String;)Landroid/content/Intent;", AnalyticFieldsName.orderId, "deliveryRdsPayOrderIntent", "(Ljava/lang/String;)Landroid/content/Intent;", "", GeoContract.LATITUDE, GeoContract.LONGITUDE, "fiasGuid", "", "serviceIDs", "fromSummary", "deliveryRdsStartOrderingIntentWithPin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/util/List;ZLcom/avito/android/remote/model/ParametrizedEvent;)Landroid/content/Intent;", "deliveryRdsOrderCancellationIntent", "Landroid/app/Application;", AuthSource.SEND_ABUSE, "Landroid/app/Application;", "context", "<init>", "(Landroid/app/Application;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryIntentFactoryImpl implements DeliveryIntentFactory {
    public final Application a;

    @Inject
    public DeliveryIntentFactoryImpl(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        this.a = application;
    }

    @Override // com.avito.android.DeliveryIntentFactory
    @NotNull
    public Intent deliveryProfileSettingsIntent() {
        return DeliveryProfileSettingsActivityKt.createDeliveryProfileSettingsActivity(this.a);
    }

    @Override // com.avito.android.DeliveryIntentFactory
    @NotNull
    public Intent deliveryRdsOrderCancellationIntent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
        return RdsOrderCancellationActivityKt.createRdsOrderCancellationIntent(this.a, str);
    }

    @Override // com.avito.android.DeliveryIntentFactory
    @NotNull
    public Intent deliveryRdsPayOrderIntent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
        return DeliveryRdsSummaryActivityKt.createDeliveryRdsPayOrderIntent(this.a, str);
    }

    @Override // com.avito.android.DeliveryIntentFactory
    @NotNull
    public Intent deliveryRdsStartOrderingIntent(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z, boolean z2, @Nullable String str4, @Nullable String str5, @Nullable ParametrizedEvent parametrizedEvent) {
        return DeliveryRdsStartOrderingActivityKt.createDeliveryRdsStartOrderingIntent(this.a, str, str2, str3, z, z2, str4, str5, parametrizedEvent);
    }

    @Override // com.avito.android.DeliveryIntentFactory
    @NotNull
    public Intent deliveryRdsStartOrderingIntentWithPin(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z, boolean z2, @Nullable String str4, @Nullable String str5, @Nullable Double d, @Nullable Double d2, @NotNull String str6, @NotNull List<String> list, boolean z3, @Nullable ParametrizedEvent parametrizedEvent) {
        Intrinsics.checkNotNullParameter(str6, "fiasGuid");
        Intrinsics.checkNotNullParameter(list, "serviceIDs");
        return DeliveryRdsStartOrderingActivityKt.createDeliveryRdsStartOrderingIntentWithPin(this.a, str, str2, str3, z, z2, str4, str5, d, d2, str6, list, Boolean.valueOf(z3), parametrizedEvent);
    }

    @Override // com.avito.android.DeliveryIntentFactory
    @NotNull
    public Intent deliveryRdsSummaryIntent(@Nullable String str, @NotNull SummaryState summaryState, boolean z, boolean z2, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(summaryState, "summaryState");
        return DeliveryRdsSummaryActivityKt.createDeliveryRdsSummaryIntent(this.a, str, summaryState, z, z2, str2);
    }
}
