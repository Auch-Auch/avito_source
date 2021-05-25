package com.avito.android.short_term_rent.start_booking;

import android.app.Application;
import android.content.Intent;
import com.avito.android.StrBookingIntentFactory;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.short_term_rent.hotels.HotelsActivity;
import com.avito.android.str_calendar.booking.CalendarActivityKt;
import com.avito.android.str_calendar.seller.SellerCalendarActivityKt;
import java.util.Date;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b\u001d\u0010\u001eJE\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0013\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/short_term_rent/start_booking/StrBookingIntentFactoryImpl;", "Lcom/avito/android/StrBookingIntentFactory;", "", "itemId", "source", "checkInDate", "checkOutDate", "", "showCalendar", "workflow", "Landroid/content/Intent;", "shortTermRentStartBookingIntent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Landroid/content/Intent;", BookingInfoActivity.EXTRA_ITEM_ID, "Ljava/util/Date;", "calendarBookingIntent", "(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)Landroid/content/Intent;", "startDate", "endDate", "calendarSelectDatesIntent", "(Ljava/util/Date;Ljava/util/Date;)Landroid/content/Intent;", "manageCalendarIntent", "(Ljava/lang/String;)Landroid/content/Intent;", "marker", "hotelsLandingIntent", "Landroid/app/Application;", AuthSource.SEND_ABUSE, "Landroid/app/Application;", "context", "<init>", "(Landroid/app/Application;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class StrBookingIntentFactoryImpl implements StrBookingIntentFactory {
    public final Application a;

    @Inject
    public StrBookingIntentFactoryImpl(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        this.a = application;
    }

    @Override // com.avito.android.StrBookingIntentFactory
    @NotNull
    public Intent calendarBookingIntent(@NotNull String str, @Nullable Date date, @Nullable Date date2) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        return CalendarActivityKt.createBookingCalendarIntent(this.a, str, date, date2);
    }

    @Override // com.avito.android.StrBookingIntentFactory
    @NotNull
    public Intent calendarSelectDatesIntent(@Nullable Date date, @Nullable Date date2) {
        return CalendarActivityKt.createSelectDatesCalendarIntent(this.a, date, date2);
    }

    @Override // com.avito.android.StrBookingIntentFactory
    @NotNull
    public Intent hotelsLandingIntent(@Nullable String str) {
        return new HotelsActivity.Factory().createIntent(this.a, str);
    }

    @Override // com.avito.android.StrBookingIntentFactory
    @NotNull
    public Intent manageCalendarIntent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        return SellerCalendarActivityKt.createManageCalendarIntent(this.a, str);
    }

    @Override // com.avito.android.StrBookingIntentFactory
    @NotNull
    public Intent shortTermRentStartBookingIntent(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, boolean z, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str2, "source");
        return StrStartBookingActivityKt.createStartBookingIntent(this.a, str, str2, str3, str4, z, str5);
    }
}
