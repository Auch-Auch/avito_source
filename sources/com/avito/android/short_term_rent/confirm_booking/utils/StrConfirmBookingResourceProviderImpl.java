package com.avito.android.short_term_rent.confirm_booking.utils;

import android.content.res.Resources;
import com.avito.android.deep_linking.links.StrStartBookingDeepLinkKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.short_term_rent.R;
import com.avito.android.short_term_rent.di.qualifier.Workflow;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\r\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/avito/android/short_term_rent/confirm_booking/utils/StrConfirmBookingResourceProviderImpl;", "Lcom/avito/android/short_term_rent/confirm_booking/utils/StrConfirmBookingResourceProvider;", "", "c", "Ljava/lang/String;", "getErrorOccurred", "()Ljava/lang/String;", "errorOccurred", AuthSource.SEND_ABUSE, "getButtonTitle", "buttonTitle", AuthSource.BOOKING_ORDER, "getUnexpectedPaymentError", "unexpectedPaymentError", "Landroid/content/res/Resources;", "resources", "workflow", "<init>", "(Landroid/content/res/Resources;Ljava/lang/String;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class StrConfirmBookingResourceProviderImpl implements StrConfirmBookingResourceProvider {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;

    @Inject
    public StrConfirmBookingResourceProviderImpl(@NotNull Resources resources, @Workflow @Nullable String str) {
        String str2;
        Intrinsics.checkNotNullParameter(resources, "resources");
        if (Intrinsics.areEqual(str, StrStartBookingDeepLinkKt.WORKFLOW_POST_PAID)) {
            str2 = resources.getString(R.string.confirm_booking_post_paid_pay_button_text);
            Intrinsics.checkNotNullExpressionValue(str2, "resources.getString(R.st…ost_paid_pay_button_text)");
        } else {
            str2 = resources.getString(R.string.confirm_booking_pay_button_text);
            Intrinsics.checkNotNullExpressionValue(str2, "resources.getString(R.st…_booking_pay_button_text)");
        }
        this.a = str2;
        String string = resources.getString(com.avito.android.ui_components.R.string.payment_error_title);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(ui_R…ring.payment_error_title)");
        this.b = string;
        String string2 = resources.getString(R.string.str_has_error_occurred);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…g.str_has_error_occurred)");
        this.c = string2;
    }

    @Override // com.avito.android.short_term_rent.confirm_booking.utils.StrConfirmBookingResourceProvider
    @NotNull
    public String getButtonTitle() {
        return this.a;
    }

    @Override // com.avito.android.short_term_rent.confirm_booking.utils.StrConfirmBookingResourceProvider
    @NotNull
    public String getErrorOccurred() {
        return this.c;
    }

    @Override // com.avito.android.short_term_rent.confirm_booking.utils.StrConfirmBookingResourceProvider
    @NotNull
    public String getUnexpectedPaymentError() {
        return this.b;
    }
}
