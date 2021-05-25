package com.avito.android.short_term_rent.start_booking;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/short_term_rent/start_booking/StrStartBookingView;", "", "Lcom/avito/android/short_term_rent/start_booking/StrStartBookingViewModel;", "viewModel", "", "bindTo", "(Lcom/avito/android/short_term_rent/start_booking/StrStartBookingViewModel;)V", "Listener", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public interface StrStartBookingView {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/short_term_rent/start_booking/StrStartBookingView$Listener;", "", "", "onCloseClicked", "()V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener {
        void onCloseClicked();
    }

    void bindTo(@NotNull StrStartBookingViewModel strStartBookingViewModel);
}
