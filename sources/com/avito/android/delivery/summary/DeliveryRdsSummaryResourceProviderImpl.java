package com.avito.android.delivery.summary;

import android.content.res.Resources;
import com.avito.android.delivery.R;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/avito/android/delivery/summary/DeliveryRdsSummaryResourceProviderImpl;", "Lcom/avito/android/delivery/summary/DeliveryRdsSummaryResourceProvider;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getErrorOccurred", "()Ljava/lang/String;", "errorOccurred", AuthSource.BOOKING_ORDER, "getPaymentError", "paymentError", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryRdsSummaryResourceProviderImpl implements DeliveryRdsSummaryResourceProvider {
    @NotNull
    public final String a;
    @NotNull
    public final String b;

    @Inject
    public DeliveryRdsSummaryResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        String string = resources.getString(R.string.has_error_occurred);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.has_error_occurred)");
        this.a = string;
        String string2 = resources.getString(com.avito.android.ui_components.R.string.payment_error_title);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(ui_R…ring.payment_error_title)");
        this.b = string2;
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryResourceProvider
    @NotNull
    public String getErrorOccurred() {
        return this.a;
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryResourceProvider
    @NotNull
    public String getPaymentError() {
        return this.b;
    }
}
