package com.avito.android.short_term_rent.hotels.dialogs.calendar;

import a2.a.a.v2.b.i.a.g;
import a2.a.a.v2.b.i.a.h;
import a2.a.a.v2.b.i.a.i;
import a2.a.a.v2.b.i.a.j;
import a2.a.a.v2.b.i.a.l;
import a2.a.a.v2.b.i.a.n;
import a2.a.a.v2.b.i.a.p;
import a2.a.a.v2.b.i.a.q;
import a2.a.a.v2.b.i.a.r;
import androidx.lifecycle.MutableLiveData;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import com.avito.android.short_term_rent.hotels.data.HotelsCalendarRestrictions;
import com.avito.android.short_term_rent.hotels.dialogs.calendar.HotelsFiltersCalendarViewModel;
import com.avito.android.str_calendar.booking.CalendarInteractor;
import com.avito.android.str_calendar.booking.CalendarResourceProvider;
import com.avito.android.str_calendar.booking.model.CalendarBookingRestriction;
import com.avito.android.str_calendar.calendar.base.BaseCalendarViewModelImpl;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataSource;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataSourceProvider;
import com.avito.android.str_calendar.utils.DateRange;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.rx3.InteropKt;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.functions.Consumer;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002BE\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010S\u001a\u00020P\u0012\u0006\u0010L\u001a\u00020I\u0012\u0012\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0D0C\u0012\b\u00104\u001a\u0004\u0018\u000101\u0012\u0006\u0010T\u001a\u00020?¢\u0006\u0004\bU\u0010VJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005R\u0016\u0010\u000b\u001a\u00020\b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\"\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030#8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\"\u0010,\u001a\b\u0012\u0004\u0012\u00020)0\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010\u001b\u001a\u0004\b+\u0010\u001dR\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\"\u00108\u001a\b\u0012\u0004\u0012\u0002050\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b6\u0010\u001b\u001a\u0004\b7\u0010\u001dR\"\u0010<\u001a\b\u0012\u0004\u0012\u0002090#8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b:\u0010%\u001a\u0004\b;\u0010'R\u001c\u0010>\u001a\b\u0012\u0004\u0012\u0002090\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010\u000eR\"\u0010B\u001a\b\u0012\u0004\u0012\u00020?0\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b@\u0010\u0015\u001a\u0004\bA\u0010\u0017R\"\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0D0C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\"\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00030#8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bM\u0010%\u001a\u0004\bN\u0010'R\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010R¨\u0006W"}, d2 = {"Lcom/avito/android/short_term_rent/hotels/dialogs/calendar/HotelsFiltersCalendarViewModelImpl;", "Lcom/avito/android/str_calendar/calendar/base/BaseCalendarViewModelImpl;", "Lcom/avito/android/short_term_rent/hotels/dialogs/calendar/HotelsFiltersCalendarViewModel;", "", "d", "()V", "c", "getData", "Lcom/avito/android/short_term_rent/hotels/dialogs/calendar/HotelsFiltersCalendarViewModel$Dates;", "getCurrentDates", "()Lcom/avito/android/short_term_rent/hotels/dialogs/calendar/HotelsFiltersCalendarViewModel$Dates;", "currentDates", "Lcom/jakewharton/rxrelay2/Relay;", "r", "Lcom/jakewharton/rxrelay2/Relay;", "clearClicksRelay", VKApiConst.Q, "chooseClicksRelay", "Landroidx/lifecycle/MutableLiveData;", "", "k", "Landroidx/lifecycle/MutableLiveData;", "getClearButtonEnableChanges", "()Landroidx/lifecycle/MutableLiveData;", "clearButtonEnableChanges", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "n", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getEmptyDatesSelected", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "emptyDatesSelected", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "o", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "subscriptions", "Lio/reactivex/functions/Consumer;", "t", "Lio/reactivex/functions/Consumer;", "getChooseClicksConsumer", "()Lio/reactivex/functions/Consumer;", "chooseClicksConsumer", "", AuthSource.OPEN_CHANNEL_LIST, "getScrollToChanges", "scrollToChanges", "Lcom/avito/android/str_calendar/booking/CalendarInteractor;", VKApiConst.VERSION, "Lcom/avito/android/str_calendar/booking/CalendarInteractor;", "interactor", "Lcom/avito/android/short_term_rent/hotels/data/HotelsCalendarRestrictions;", "z", "Lcom/avito/android/short_term_rent/hotels/data/HotelsCalendarRestrictions;", "restrictions", "Lcom/avito/android/str_calendar/utils/DateRange;", "j", "getDatesChosenChanges", "datesChosenChanges", "Ljava/util/Date;", "s", "getDayClicksConsumer", "dayClicksConsumer", "p", "dayClicksRelay", "", "l", "getToolbarTitleChanges", "toolbarTitleChanges", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;", "", "Lcom/avito/android/str_calendar/booking/model/CalendarBookingRestriction;", "y", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;", "restrictionsDataSourceProvider", "Lcom/avito/android/str_calendar/booking/CalendarResourceProvider;", "x", "Lcom/avito/android/str_calendar/booking/CalendarResourceProvider;", "resourceProvider", "u", "getClearClicksConsumer", "clearClicksConsumer", "Lcom/avito/android/util/SchedulersFactory3;", "w", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "title", "<init>", "(Lcom/avito/android/str_calendar/booking/CalendarInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/str_calendar/booking/CalendarResourceProvider;Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;Lcom/avito/android/short_term_rent/hotels/data/HotelsCalendarRestrictions;Ljava/lang/String;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class HotelsFiltersCalendarViewModelImpl extends BaseCalendarViewModelImpl implements HotelsFiltersCalendarViewModel {
    @NotNull
    public final SingleLiveEvent<DateRange> j = new SingleLiveEvent<>();
    @NotNull
    public final MutableLiveData<Boolean> k = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<String> l = new MutableLiveData<>();
    @NotNull
    public final SingleLiveEvent<Integer> m = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<Unit> n = new SingleLiveEvent<>();
    public final CompositeDisposable o;
    public final Relay<Date> p;
    public final Relay<Unit> q;
    public final Relay<Unit> r;
    @NotNull
    public final Consumer<Date> s;
    @NotNull
    public final Consumer<Unit> t;
    @NotNull
    public final Consumer<Unit> u;
    public final CalendarInteractor v;
    public final SchedulersFactory3 w;
    public final CalendarResourceProvider x;
    public final CalendarDataSourceProvider<List<CalendarBookingRestriction>> y;
    public final HotelsCalendarRestrictions z;

    public static final class a<T> implements io.reactivex.rxjava3.functions.Consumer<Unit> {
        public final /* synthetic */ HotelsFiltersCalendarViewModelImpl a;

        public a(HotelsFiltersCalendarViewModelImpl hotelsFiltersCalendarViewModelImpl) {
            this.a = hotelsFiltersCalendarViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.a.getCalendarDataSource().onClearSelection();
            HotelsFiltersCalendarViewModelImpl.access$enableClearButton(this.a, false);
        }
    }

    public static final class b<T> implements io.reactivex.rxjava3.functions.Consumer<Throwable> {
        public final /* synthetic */ HotelsFiltersCalendarViewModelImpl a;

        public b(HotelsFiltersCalendarViewModelImpl hotelsFiltersCalendarViewModelImpl) {
            this.a = hotelsFiltersCalendarViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.getErrorMessageChanges().postValue(this.a.x.getErrorOccurred());
            this.a.c();
        }
    }

    public static final class c<T> implements io.reactivex.rxjava3.functions.Consumer<Date> {
        public final /* synthetic */ HotelsFiltersCalendarViewModelImpl a;

        public c(HotelsFiltersCalendarViewModelImpl hotelsFiltersCalendarViewModelImpl) {
            this.a = hotelsFiltersCalendarViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Date date) {
            Date date2 = date;
            CalendarDataSource calendarDataSource = this.a.getCalendarDataSource();
            Intrinsics.checkNotNullExpressionValue(date2, Sort.DATE);
            if (calendarDataSource.onItemSelected(date2)) {
                HotelsFiltersCalendarViewModelImpl.access$enableClearButton(this.a, true);
            }
        }
    }

    public static final class d<T> implements io.reactivex.rxjava3.functions.Consumer<Throwable> {
        public final /* synthetic */ HotelsFiltersCalendarViewModelImpl a;

        public d(HotelsFiltersCalendarViewModelImpl hotelsFiltersCalendarViewModelImpl) {
            this.a = hotelsFiltersCalendarViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.getErrorMessageChanges().postValue(this.a.x.getErrorOccurred());
            this.a.d();
        }
    }

    public HotelsFiltersCalendarViewModelImpl(@NotNull CalendarInteractor calendarInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull CalendarResourceProvider calendarResourceProvider, @NotNull CalendarDataSourceProvider<List<CalendarBookingRestriction>> calendarDataSourceProvider, @Nullable HotelsCalendarRestrictions hotelsCalendarRestrictions, @NotNull String str) {
        Intrinsics.checkNotNullParameter(calendarInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(calendarResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(calendarDataSourceProvider, "restrictionsDataSourceProvider");
        Intrinsics.checkNotNullParameter(str, "title");
        this.v = calendarInteractor;
        this.w = schedulersFactory3;
        this.x = calendarResourceProvider;
        this.y = calendarDataSourceProvider;
        this.z = hotelsCalendarRestrictions;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.o = compositeDisposable;
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.p = create;
        PublishRelay create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.q = create2;
        PublishRelay create3 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create3, "PublishRelay.create()");
        this.r = create3;
        this.s = create;
        this.t = create2;
        this.u = create3;
        d();
        c();
        Disposable subscribe = InteropKt.toV3(create2).throttleFirst(300, TimeUnit.MILLISECONDS).observeOn(schedulersFactory3.mainThread()).subscribe(new q(this), new r(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "chooseClicksRelay.toV3()…          }\n            )");
        DisposableKt.addTo(subscribe, compositeDisposable);
        getClearButtonEnableChanges().setValue(Boolean.TRUE);
        getToolbarTitleChanges().setValue(str);
        getData();
    }

    public static final void access$enableClearButton(HotelsFiltersCalendarViewModelImpl hotelsFiltersCalendarViewModelImpl, boolean z2) {
        hotelsFiltersCalendarViewModelImpl.getClearButtonEnableChanges().setValue(Boolean.valueOf(z2));
    }

    public static final void access$onCalendarRestrictionsLoaded(HotelsFiltersCalendarViewModelImpl hotelsFiltersCalendarViewModelImpl, List list) {
        hotelsFiltersCalendarViewModelImpl.setCalendarDataSource(hotelsFiltersCalendarViewModelImpl.y.getDataSource(list));
        hotelsFiltersCalendarViewModelImpl.getErrorChanges().setValue(null);
        hotelsFiltersCalendarViewModelImpl.getProgressChanges().setValue(null);
        Disposable subscribe = InteropKt.toV3(hotelsFiltersCalendarViewModelImpl.getCalendarDataSource().getListItemsObservable()).subscribe(new j(hotelsFiltersCalendarViewModelImpl), new l(hotelsFiltersCalendarViewModelImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "calendarDataSource.listI…          }\n            )");
        DisposableKt.addTo(subscribe, hotelsFiltersCalendarViewModelImpl.o);
        DateRange selectedRange = hotelsFiltersCalendarViewModelImpl.getCalendarDataSource().getSelectedRange();
        if (selectedRange != null) {
            Disposable subscribe2 = Observable.fromCallable(new g(selectedRange, hotelsFiltersCalendarViewModelImpl)).subscribeOn(hotelsFiltersCalendarViewModelImpl.w.io()).observeOn(hotelsFiltersCalendarViewModelImpl.w.mainThread()).subscribe(new h(hotelsFiltersCalendarViewModelImpl), i.a);
            Intrinsics.checkNotNullExpressionValue(subscribe2, "Observable.fromCallable …      }\n                )");
            DisposableKt.addTo(subscribe2, hotelsFiltersCalendarViewModelImpl.o);
        }
    }

    public final void c() {
        Disposable subscribe = InteropKt.toV3(this.r).throttleFirst(300, TimeUnit.MILLISECONDS).observeOn(this.w.mainThread()).subscribe(new a(this), new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "clearClicksRelay.toV3()\n…          }\n            )");
        DisposableKt.addTo(subscribe, this.o);
    }

    public final void d() {
        Disposable subscribe = InteropKt.toV3(this.p).observeOn(this.w.mainThread()).subscribe(new c(this), new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "dayClicksRelay.toV3()\n  …          }\n            )");
        DisposableKt.addTo(subscribe, this.o);
    }

    @Override // com.avito.android.str_calendar.booking.CalendarViewModel
    @NotNull
    public Consumer<Unit> getChooseClicksConsumer() {
        return this.t;
    }

    @Override // com.avito.android.str_calendar.booking.CalendarViewModel
    @NotNull
    public Consumer<Unit> getClearClicksConsumer() {
        return this.u;
    }

    @Override // com.avito.android.short_term_rent.hotels.dialogs.calendar.HotelsFiltersCalendarViewModel
    @NotNull
    public HotelsFiltersCalendarViewModel.Dates getCurrentDates() {
        Date selectedDate = getCalendarDataSource().getSelectedDate();
        DateRange selectedRange = getCalendarDataSource().getSelectedRange();
        if (selectedRange != null) {
            return new HotelsFiltersCalendarViewModel.Dates(selectedRange.getStart(), selectedRange.getEndInclusive());
        }
        if (selectedDate != null) {
            return new HotelsFiltersCalendarViewModel.Dates(selectedDate, null);
        }
        return new HotelsFiltersCalendarViewModel.Dates(null, null);
    }

    @Override // com.avito.android.str_calendar.calendar.base.BaseCalendarViewModel
    public void getData() {
        Calendar calendar;
        HotelsCalendarRestrictions hotelsCalendarRestrictions = this.z;
        Calendar calendar2 = null;
        if (hotelsCalendarRestrictions != null) {
            calendar2 = Calendar.getInstance();
            calendar2.setTime(hotelsCalendarRestrictions.getDatesRestrictions().getStart());
            calendar = Calendar.getInstance();
            calendar.setTime(hotelsCalendarRestrictions.getDatesRestrictions().getEndInclusive());
        } else {
            calendar = null;
        }
        CalendarInteractor calendarInteractor = this.v;
        HotelsCalendarRestrictions hotelsCalendarRestrictions2 = this.z;
        Disposable subscribe = InteropKt.toV3(calendarInteractor.getDefaultRestrictions(calendar2, calendar, hotelsCalendarRestrictions2 != null ? hotelsCalendarRestrictions2.getMaxLengthRestriction() : Integer.MAX_VALUE)).observeOn(this.w.mainThread()).subscribe(new n(this), new p(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "observeOn(schedulers.mai…          }\n            )");
        DisposableKt.addTo(subscribe, this.o);
    }

    @Override // com.avito.android.str_calendar.booking.CalendarViewModel
    @NotNull
    public Consumer<Date> getDayClicksConsumer() {
        return this.s;
    }

    @Override // com.avito.android.str_calendar.booking.CalendarViewModel
    @NotNull
    public MutableLiveData<Boolean> getClearButtonEnableChanges() {
        return this.k;
    }

    @Override // com.avito.android.str_calendar.booking.CalendarViewModel
    @NotNull
    public SingleLiveEvent<DateRange> getDatesChosenChanges() {
        return this.j;
    }

    @Override // com.avito.android.short_term_rent.hotels.dialogs.calendar.HotelsFiltersCalendarViewModel
    @NotNull
    public SingleLiveEvent<Unit> getEmptyDatesSelected() {
        return this.n;
    }

    @Override // com.avito.android.str_calendar.booking.CalendarViewModel
    @NotNull
    public SingleLiveEvent<Integer> getScrollToChanges() {
        return this.m;
    }

    @Override // com.avito.android.str_calendar.booking.CalendarViewModel
    @NotNull
    public MutableLiveData<String> getToolbarTitleChanges() {
        return this.l;
    }
}
