package com.avito.android.str_calendar.booking;

import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.ShortTermRentApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.StrBookingCalendar;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.str_calendar.booking.model.BookingCalendarItem;
import com.avito.android.str_calendar.booking.model.BookingCalendarItemKt;
import com.avito.android.str_calendar.booking.model.CalendarBookingRestriction;
import com.avito.android.str_calendar.calendar.utils.CalendarUtilsKt;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import com.yandex.mobile.ads.video.tracking.Tracker;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b\u001f\u0010 J=\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b0\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ1\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\t0\b0\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/str_calendar/booking/CalendarInteractorImpl;", "Lcom/avito/android/str_calendar/booking/CalendarInteractor;", "Ljava/util/Calendar;", Tracker.Events.CREATIVE_START, "end", "", "maxDurationDays", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "", "Lcom/avito/android/str_calendar/booking/model/CalendarBookingRestriction;", "getDefaultRestrictions", "(Ljava/util/Calendar;Ljava/util/Calendar;I)Lio/reactivex/Observable;", "", BookingInfoActivity.EXTRA_ITEM_ID, "startDate", "Lcom/avito/android/str_calendar/booking/model/BookingCalendarItem;", "getBookingCalendar", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/remote/ShortTermRentApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/ShortTermRentApi;", "api", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "c", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "<init>", "(Lcom/avito/android/remote/ShortTermRentApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class CalendarInteractorImpl implements CalendarInteractor {
    public final ShortTermRentApi a;
    public final SchedulersFactory b;
    public final TypedErrorThrowableConverter c;

    public static final class a<T, R> implements Function<TypedResult<StrBookingCalendar>, LoadingState<? super List<? extends BookingCalendarItem>>> {
        public final /* synthetic */ CalendarInteractorImpl a;

        public a(CalendarInteractorImpl calendarInteractorImpl) {
            this.a = calendarInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super List<? extends BookingCalendarItem>> apply(TypedResult<StrBookingCalendar> typedResult) {
            TypedResult<StrBookingCalendar> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "it");
            return CalendarInteractorImpl.access$calendarToBookingItems(this.a, typedResult2);
        }
    }

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super List<? extends BookingCalendarItem>>> {
        public final /* synthetic */ CalendarInteractorImpl a;

        public b(CalendarInteractorImpl calendarInteractorImpl) {
            this.a = calendarInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super List<? extends BookingCalendarItem>> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            return new LoadingState.Error(this.a.c.convert(th2));
        }
    }

    @Inject
    public CalendarInteractorImpl(@NotNull ShortTermRentApi shortTermRentApi, @NotNull SchedulersFactory schedulersFactory, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter) {
        Intrinsics.checkNotNullParameter(shortTermRentApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        this.a = shortTermRentApi;
        this.b = schedulersFactory;
        this.c = typedErrorThrowableConverter;
    }

    public static final LoadingState access$calendarToBookingItems(CalendarInteractorImpl calendarInteractorImpl, TypedResult typedResult) {
        Objects.requireNonNull(calendarInteractorImpl);
        if (typedResult instanceof TypedResult.OfResult) {
            return new LoadingState.Loaded(BookingCalendarItemKt.convert(((StrBookingCalendar) ((TypedResult.OfResult) typedResult).getResult()).getBookingCalendarData().getItems()));
        }
        if (typedResult instanceof TypedResult.OfError) {
            return new LoadingState.Error(((TypedResult.OfError) typedResult).getError());
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.avito.android.str_calendar.booking.CalendarInteractor
    @NotNull
    public Observable<LoadingState<List<BookingCalendarItem>>> getBookingCalendar(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "startDate");
        Observable<LoadingState<List<BookingCalendarItem>>> onErrorReturn = InteropKt.toV2(this.a.bookingCalendar(str, str2)).subscribeOn(this.b.io()).map(new a(this)).startWith((Observable) LoadingState.Loading.INSTANCE).onErrorReturn(new b(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api.bookingCalendar(adve…eConverter.convert(it)) }");
        return onErrorReturn;
    }

    @Override // com.avito.android.str_calendar.booking.CalendarInteractor
    @NotNull
    public Observable<LoadingState<List<CalendarBookingRestriction>>> getDefaultRestrictions(@Nullable Calendar calendar, @Nullable Calendar calendar2, int i) {
        if (calendar == null) {
            calendar = CalendarUtilsKt.getCalendar();
        }
        if (calendar2 == null) {
            calendar2 = CalendarUtilsKt.getCalendar();
            calendar2.add(2, 7);
        }
        ArrayList arrayList = new ArrayList();
        while (calendar.getTimeInMillis() < calendar2.getTimeInMillis()) {
            Date time = calendar.getTime();
            Intrinsics.checkNotNullExpressionValue(time, "calendar.time");
            arrayList.add(new CalendarBookingRestriction(time, true, 1, i));
            calendar.add(5, 1);
        }
        Unit unit = Unit.INSTANCE;
        Observable<LoadingState<List<CalendarBookingRestriction>>> just = Observable.just(new LoadingState.Loaded(CollectionsKt___CollectionsKt.toList(arrayList)));
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(\n       …)\n            )\n        )");
        return just;
    }
}
