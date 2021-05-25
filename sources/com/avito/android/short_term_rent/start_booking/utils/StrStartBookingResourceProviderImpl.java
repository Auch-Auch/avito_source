package com.avito.android.short_term_rent.start_booking.utils;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.short_term_rent.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\r\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/avito/android/short_term_rent/start_booking/utils/StrStartBookingResourceProviderImpl;", "Lcom/avito/android/short_term_rent/start_booking/utils/StrStartBookingResourceProvider;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getErrorOccurred", "()Ljava/lang/String;", "errorOccurred", "c", "getFillParams", "fillParams", AuthSource.SEND_ABUSE, "getEnterDepartureHint", "enterDepartureHint", "d", "getChooseDatesErrorOccurred", "chooseDatesErrorOccurred", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class StrStartBookingResourceProviderImpl implements StrStartBookingResourceProvider {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;

    @Inject
    public StrStartBookingResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        String string = resources.getString(R.string.start_booking_enter_departure_hint);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…ing_enter_departure_hint)");
        this.a = string;
        String string2 = resources.getString(R.string.str_has_error_occurred);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…g.str_has_error_occurred)");
        this.b = string2;
        String string3 = resources.getString(R.string.fill_params);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.string.fill_params)");
        this.c = string3;
        String string4 = resources.getString(R.string.start_booking_choose_dates_error);
        Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.st…oking_choose_dates_error)");
        this.d = string4;
    }

    @Override // com.avito.android.short_term_rent.start_booking.utils.StrStartBookingResourceProvider
    @NotNull
    public String getChooseDatesErrorOccurred() {
        return this.d;
    }

    @Override // com.avito.android.short_term_rent.start_booking.utils.StrStartBookingResourceProvider
    @NotNull
    public String getEnterDepartureHint() {
        return this.a;
    }

    @Override // com.avito.android.short_term_rent.start_booking.utils.StrStartBookingResourceProvider
    @NotNull
    public String getErrorOccurred() {
        return this.b;
    }

    @Override // com.avito.android.short_term_rent.start_booking.utils.StrStartBookingResourceProvider
    @NotNull
    public String getFillParams() {
        return this.c;
    }
}
