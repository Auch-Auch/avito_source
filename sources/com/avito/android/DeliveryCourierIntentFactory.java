package com.avito.android;

import android.content.Intent;
import com.avito.android.advert_core.marketplace.MarketplacePresenterKt;
import com.avito.android.remote.model.ParametrizedEvent;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J-\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u000bJ=\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/DeliveryCourierIntentFactory;", "", "", "itemId", "source", "searchContext", "Landroid/content/Intent;", "deliveryCourierSummary", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "orderID", "deliveryCourierOrderUpdate", "(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "deliveryCourierDateRangeSelect", "", "isMarketplace", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/avito/android/remote/model/ParametrizedEvent;", MarketplacePresenterKt.KEY_CONTACT_EVENT, "deliveryTypeIntent", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/ParametrizedEvent;)Landroid/content/Intent;", "profileRdsDeliverySettingsIntent", "()Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface DeliveryCourierIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent deliveryCourierSummary$default(DeliveryCourierIntentFactory deliveryCourierIntentFactory, String str, String str2, String str3, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = null;
                }
                return deliveryCourierIntentFactory.deliveryCourierSummary(str, str2, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deliveryCourierSummary");
        }
    }

    @NotNull
    Intent deliveryCourierDateRangeSelect(@NotNull String str, @NotNull String str2);

    @NotNull
    Intent deliveryCourierOrderUpdate(@NotNull String str, @NotNull String str2);

    @NotNull
    Intent deliveryCourierSummary(@NotNull String str, @Nullable String str2, @Nullable String str3);

    @NotNull
    Intent deliveryTypeIntent(@NotNull String str, boolean z, @Nullable String str2, @Nullable String str3, @Nullable ParametrizedEvent parametrizedEvent);

    @NotNull
    Intent profileRdsDeliverySettingsIntent();
}
