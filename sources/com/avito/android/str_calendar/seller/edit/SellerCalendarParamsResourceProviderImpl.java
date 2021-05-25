package com.avito.android.str_calendar.seller.edit;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.str_calendar.R;
import com.avito.android.str_calendar.di.qualifier.EndDate;
import com.avito.android.str_calendar.di.qualifier.StartDate;
import com.avito.android.str_calendar.utils.DateRange;
import com.avito.android.str_calendar.utils.StrDateUtilsKt;
import java.util.Date;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\b\u0007\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParamsResourceProviderImpl;", "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParamsResourceProvider;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getErrorOccurred", "()Ljava/lang/String;", "errorOccurred", AuthSource.BOOKING_ORDER, "getToolbarTitle", "toolbarTitle", "Ljava/util/Date;", "startDate", "endDate", "Landroid/content/res/Resources;", "resources", "<init>", "(Ljava/util/Date;Ljava/util/Date;Landroid/content/res/Resources;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class SellerCalendarParamsResourceProviderImpl implements SellerCalendarParamsResourceProvider {
    @NotNull
    public final String a;
    @NotNull
    public final String b;

    @Inject
    public SellerCalendarParamsResourceProviderImpl(@StartDate @Nullable Date date, @EndDate @Nullable Date date2, @NotNull Resources resources) {
        String str;
        Intrinsics.checkNotNullParameter(resources, "resources");
        String string = resources.getString(R.string.str_has_error_occurred);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…g.str_has_error_occurred)");
        this.a = string;
        if (date == null) {
            str = resources.getString(R.string.seller_calendar_params_toolbar_title);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.st…dar_params_toolbar_title)");
        } else if (date2 != null) {
            str = StrDateUtilsKt.getTitle(new DateRange(date, date2));
        } else {
            str = StrDateUtilsKt.convertStrDateToDMMMM(date);
        }
        this.b = str;
    }

    @Override // com.avito.android.str_calendar.seller.edit.SellerCalendarParamsResourceProvider
    @NotNull
    public String getErrorOccurred() {
        return this.a;
    }

    @Override // com.avito.android.str_calendar.seller.edit.SellerCalendarParamsResourceProvider
    @NotNull
    public String getToolbarTitle() {
        return this.b;
    }
}
