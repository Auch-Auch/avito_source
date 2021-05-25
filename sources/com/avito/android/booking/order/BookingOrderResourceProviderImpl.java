package com.avito.android.booking.order;

import android.content.res.Resources;
import androidx.core.content.res.ResourcesCompat;
import com.avito.android.lib.design.avito.R;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/booking/order/BookingOrderResourceProviderImpl;", "Lcom/avito/android/booking/order/BookingOrderResourceProvider;", "", "unknownErrorMessage", "()Ljava/lang/String;", "", "inputDescriptionNormalTextColor", "()I", "inputDescriptionErrorTextColor", "paymentErrorMessage", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "booking_release"}, k = 1, mv = {1, 4, 2})
public final class BookingOrderResourceProviderImpl implements BookingOrderResourceProvider {
    public final Resources a;

    @Inject
    public BookingOrderResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.booking.order.BookingOrderResourceProvider
    public int inputDescriptionErrorTextColor() {
        return ResourcesCompat.getColor(this.a, R.color.avito_red_600, null);
    }

    @Override // com.avito.android.booking.order.BookingOrderResourceProvider
    public int inputDescriptionNormalTextColor() {
        return ResourcesCompat.getColor(this.a, R.color.avito_gray_48, null);
    }

    @Override // com.avito.android.booking.order.BookingOrderResourceProvider
    @NotNull
    public String paymentErrorMessage() {
        String string = this.a.getString(com.avito.android.ui_components.R.string.payment_error_title);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(ui_c…ring.payment_error_title)");
        return string;
    }

    @Override // com.avito.android.booking.order.BookingOrderResourceProvider
    @NotNull
    public String unknownErrorMessage() {
        String string = this.a.getString(com.avito.android.booking.R.string.booking_order_unknown_error_message);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…er_unknown_error_message)");
        return string;
    }
}
