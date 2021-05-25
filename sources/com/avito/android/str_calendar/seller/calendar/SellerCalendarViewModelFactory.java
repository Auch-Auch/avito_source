package com.avito.android.str_calendar.seller.calendar;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataSourceProvider;
import com.avito.android.str_calendar.seller.calendar.model.SellerCalendarInfo;
import com.avito.android.util.SchedulersFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u001d\u0010\u001eJ)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;", "Lcom/avito/android/str_calendar/seller/calendar/model/SellerCalendarInfo;", "d", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;", "calendarDataSourceProvider", "", "c", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarResourceProvider;", "e", "Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarResourceProvider;", "resourceProvider", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarInteractor;", "interactor", "<init>", "(Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarInteractor;Lcom/avito/android/util/SchedulersFactory;Ljava/lang/String;Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarResourceProvider;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class SellerCalendarViewModelFactory implements ViewModelProvider.Factory {
    public final SellerCalendarInteractor a;
    public final SchedulersFactory b;
    public final String c;
    public final CalendarDataSourceProvider<SellerCalendarInfo> d;
    public final SellerCalendarResourceProvider e;

    public SellerCalendarViewModelFactory(@NotNull SellerCalendarInteractor sellerCalendarInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull String str, @NotNull CalendarDataSourceProvider<SellerCalendarInfo> calendarDataSourceProvider, @NotNull SellerCalendarResourceProvider sellerCalendarResourceProvider) {
        Intrinsics.checkNotNullParameter(sellerCalendarInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(calendarDataSourceProvider, "calendarDataSourceProvider");
        Intrinsics.checkNotNullParameter(sellerCalendarResourceProvider, "resourceProvider");
        this.a = sellerCalendarInteractor;
        this.b = schedulersFactory;
        this.c = str;
        this.d = calendarDataSourceProvider;
        this.e = sellerCalendarResourceProvider;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(SellerCalendarViewModelImpl.class)) {
            return new SellerCalendarViewModelImpl(this.a, this.b, this.c, this.d, this.e);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
