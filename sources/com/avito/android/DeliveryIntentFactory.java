package com.avito.android;

import android.content.Intent;
import com.avito.android.advert_core.marketplace.MarketplacePresenterKt;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.model.ParametrizedEvent;
import com.avito.android.util.preferences.GeoContract;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J;\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ[\u0010\u0012\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0002H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\nH&¢\u0006\u0004\b\u0017\u0010\u0018J\u0001\u0010 \u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u00022\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0002H&¢\u0006\u0004\b\"\u0010\u0016¨\u0006#"}, d2 = {"Lcom/avito/android/DeliveryIntentFactory;", "", "", "searchContext", "Lcom/avito/android/SummaryState;", "summaryState", "", "isCart", "isMarketplace", "source", "Landroid/content/Intent;", "deliveryRdsSummaryIntent", "(Ljava/lang/String;Lcom/avito/android/SummaryState;ZZLjava/lang/String;)Landroid/content/Intent;", BookingInfoActivity.EXTRA_ITEM_ID, "firstCartItemId", "cartItems", "Lcom/avito/android/remote/model/ParametrizedEvent;", MarketplacePresenterKt.KEY_CONTACT_EVENT, "deliveryRdsStartOrderingIntent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/ParametrizedEvent;)Landroid/content/Intent;", AnalyticFieldsName.orderId, "deliveryRdsPayOrderIntent", "(Ljava/lang/String;)Landroid/content/Intent;", "deliveryProfileSettingsIntent", "()Landroid/content/Intent;", "", GeoContract.LATITUDE, GeoContract.LONGITUDE, "fiasGuid", "", "serviceIDs", "fromSummary", "deliveryRdsStartOrderingIntentWithPin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/util/List;ZLcom/avito/android/remote/model/ParametrizedEvent;)Landroid/content/Intent;", "deliveryRdsOrderCancellationIntent", "core_release"}, k = 1, mv = {1, 4, 2})
public interface DeliveryIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent deliveryRdsStartOrderingIntentWithPin$default(DeliveryIntentFactory deliveryIntentFactory, String str, String str2, String str3, boolean z, boolean z2, String str4, String str5, Double d, Double d2, String str6, List list, boolean z3, ParametrizedEvent parametrizedEvent, int i, Object obj) {
            if (obj == null) {
                return deliveryIntentFactory.deliveryRdsStartOrderingIntentWithPin(str, str2, str3, z, z2, str4, str5, d, d2, str6, list, (i & 2048) != 0 ? false : z3, parametrizedEvent);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deliveryRdsStartOrderingIntentWithPin");
        }
    }

    @NotNull
    Intent deliveryProfileSettingsIntent();

    @NotNull
    Intent deliveryRdsOrderCancellationIntent(@NotNull String str);

    @NotNull
    Intent deliveryRdsPayOrderIntent(@NotNull String str);

    @NotNull
    Intent deliveryRdsStartOrderingIntent(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z, boolean z2, @Nullable String str4, @Nullable String str5, @Nullable ParametrizedEvent parametrizedEvent);

    @NotNull
    Intent deliveryRdsStartOrderingIntentWithPin(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z, boolean z2, @Nullable String str4, @Nullable String str5, @Nullable Double d, @Nullable Double d2, @NotNull String str6, @NotNull List<String> list, boolean z3, @Nullable ParametrizedEvent parametrizedEvent);

    @NotNull
    Intent deliveryRdsSummaryIntent(@Nullable String str, @NotNull SummaryState summaryState, boolean z, boolean z2, @Nullable String str2);
}
