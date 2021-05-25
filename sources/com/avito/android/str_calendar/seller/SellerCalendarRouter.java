package com.avito.android.str_calendar.seller;

import com.avito.android.booking.info.BookingInfoActivity;
import io.reactivex.Observable;
import java.util.Date;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/avito/android/str_calendar/seller/SellerCalendarRouter;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, "", "showSellerCalendar", "(Ljava/lang/String;)V", "Ljava/util/Date;", "startDate", "endDate", "showEditParametersScreen", "(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)V", "", "updateCalendar", "leaveEditParametersScreen", "(Z)V", "Lio/reactivex/Observable;", "getUpdateSellerCalendarObservable", "()Lio/reactivex/Observable;", "updateSellerCalendarObservable", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public interface SellerCalendarRouter {
    @NotNull
    Observable<Boolean> getUpdateSellerCalendarObservable();

    void leaveEditParametersScreen(boolean z);

    void showEditParametersScreen(@NotNull String str, @Nullable Date date, @Nullable Date date2);

    void showSellerCalendar(@NotNull String str);
}
