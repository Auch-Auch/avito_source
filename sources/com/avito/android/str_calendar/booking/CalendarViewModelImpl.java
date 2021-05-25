package com.avito.android.str_calendar.booking;

import a2.a.a.b3.a.a0;
import a2.a.a.b3.a.b0;
import a2.a.a.b3.a.p;
import a2.a.a.b3.a.r;
import a2.a.a.b3.a.s;
import a2.a.a.b3.a.t;
import a2.a.a.b3.a.u;
import a2.a.a.b3.a.v;
import a2.a.a.b3.a.x;
import a2.a.a.b3.a.z;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.category_parameters.FormattedDateDisplayingType;
import com.avito.android.server_time.TimeSource;
import com.avito.android.str_calendar.analytics.StrAnalyticsTracker;
import com.avito.android.str_calendar.booking.CalendarInteractor;
import com.avito.android.str_calendar.booking.model.BookingCalendarItem;
import com.avito.android.str_calendar.booking.model.CalendarBookingRestriction;
import com.avito.android.str_calendar.calendar.base.BaseCalendarViewModelImpl;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataSource;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataSourceProvider;
import com.avito.android.str_calendar.utils.DateRange;
import com.avito.android.str_calendar.utils.StrDateUtilsKt;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.data_source.ListDataSource;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002Bi\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u0010F\u001a\u00020C\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010.\u001a\u00020+\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\b\u0010R\u001a\u0004\u0018\u00010H\u0012\u0012\u0010U\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020S0\u001a0\u0019\u0012\u0012\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0019\u0012\u0006\u0010Z\u001a\u00020V¢\u0006\u0004\b[\u0010\\J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\n\u0010\u0005R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\"\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010\u0015\u001a\u0004\b%\u0010\u0017R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\"\u00101\u001a\b\u0012\u0004\u0012\u00020\u00030\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b/\u0010\u0015\u001a\u0004\b0\u0010\u0017R\"\u00108\u001a\b\u0012\u0004\u0012\u000203028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\"\u0010<\u001a\b\u0012\u0004\u0012\u000209028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b:\u00105\u001a\u0004\b;\u00107R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020#0\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010!R\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\"\u0010M\u001a\b\u0012\u0004\u0012\u00020H0G8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u001c\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010!R\u0018\u0010R\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\"\u0010U\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020S0\u001a0\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010\u001dR\"\u0010Y\u001a\b\u0012\u0004\u0012\u00020V0G8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bW\u0010J\u001a\u0004\bX\u0010L¨\u0006]"}, d2 = {"Lcom/avito/android/str_calendar/booking/CalendarViewModelImpl;", "Lcom/avito/android/str_calendar/calendar/base/BaseCalendarViewModelImpl;", "Lcom/avito/android/str_calendar/booking/CalendarViewModel;", "", "c", "()V", "e", "d", "f", "getData", "onCleared", "Lcom/avito/android/util/SchedulersFactory;", "w", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/str_calendar/analytics/StrAnalyticsTracker;", "y", "Lcom/avito/android/str_calendar/analytics/StrAnalyticsTracker;", "strAnalyticsTracker", "Lio/reactivex/functions/Consumer;", "t", "Lio/reactivex/functions/Consumer;", "getClearClicksConsumer", "()Lio/reactivex/functions/Consumer;", "clearClicksConsumer", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;", "", "Lcom/avito/android/str_calendar/booking/model/BookingCalendarItem;", "B", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;", "calendarItemDataSourceProvider", "Lcom/jakewharton/rxrelay2/Relay;", "p", "Lcom/jakewharton/rxrelay2/Relay;", "chooseClicksRelay", "Ljava/util/Date;", "r", "getDayClicksConsumer", "dayClicksConsumer", "Lcom/avito/android/str_calendar/booking/CalendarInteractor;", "u", "Lcom/avito/android/str_calendar/booking/CalendarInteractor;", "interactor", "Lcom/avito/android/str_calendar/booking/CalendarResourceProvider;", "x", "Lcom/avito/android/str_calendar/booking/CalendarResourceProvider;", "resourceProvider", "s", "getChooseClicksConsumer", "chooseClicksConsumer", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getScrollToChanges", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "scrollToChanges", "Lcom/avito/android/str_calendar/utils/DateRange;", "j", "getDatesChosenChanges", "datesChosenChanges", "Lio/reactivex/disposables/CompositeDisposable;", "n", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "o", "dayClicksRelay", "Lcom/avito/android/server_time/TimeSource;", VKApiConst.VERSION, "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Landroidx/lifecycle/MutableLiveData;", "", "l", "Landroidx/lifecycle/MutableLiveData;", "getToolbarTitleChanges", "()Landroidx/lifecycle/MutableLiveData;", "toolbarTitleChanges", VKApiConst.Q, "clearClicksRelay", "z", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/str_calendar/booking/model/CalendarBookingRestriction;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "restrictionsDataSourceProvider", "", "k", "getClearButtonEnableChanges", "clearButtonEnableChanges", "enableClearButton", "<init>", "(Lcom/avito/android/str_calendar/booking/CalendarInteractor;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/str_calendar/booking/CalendarResourceProvider;Lcom/avito/android/str_calendar/analytics/StrAnalyticsTracker;Ljava/lang/String;Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;Z)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class CalendarViewModelImpl extends BaseCalendarViewModelImpl implements CalendarViewModel {
    public final CalendarDataSourceProvider<List<CalendarBookingRestriction>> A;
    public final CalendarDataSourceProvider<List<BookingCalendarItem>> B;
    @NotNull
    public final SingleLiveEvent<DateRange> j = new SingleLiveEvent<>();
    @NotNull
    public final MutableLiveData<Boolean> k = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<String> l = new MutableLiveData<>();
    @NotNull
    public final SingleLiveEvent<Integer> m = new SingleLiveEvent<>();
    public final CompositeDisposable n;
    public final Relay<Date> o;
    public final Relay<Unit> p;
    public final Relay<Unit> q;
    @NotNull
    public final Consumer<Date> r;
    @NotNull
    public final Consumer<Unit> s;
    @NotNull
    public final Consumer<Unit> t;
    public final CalendarInteractor u;
    public final TimeSource v;
    public final SchedulersFactory w;
    public final CalendarResourceProvider x;
    public final StrAnalyticsTracker y;
    public final String z;

    public static final class a<T> implements Consumer<List<? extends Item>> {
        public final /* synthetic */ CalendarViewModelImpl a;

        public a(CalendarViewModelImpl calendarViewModelImpl) {
            this.a = calendarViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(List<? extends Item> list) {
            List<? extends Item> list2 = list;
            AdapterPresenter adapterPresenter = this.a.getAdapterPresenter();
            if (adapterPresenter != null) {
                Intrinsics.checkNotNullExpressionValue(list2, "newItems");
                adapterPresenter.onDataSourceChanged(new ListDataSource(list2));
            }
            this.a.getShowContentChanges().setValue(Unit.INSTANCE);
            MutableLiveData<DiffUtil.DiffResult> updateViewChanges = this.a.getUpdateViewChanges();
            CalendarViewModelImpl calendarViewModelImpl = this.a;
            List<? extends Item> listItems = calendarViewModelImpl.getListItems();
            Intrinsics.checkNotNullExpressionValue(list2, "newItems");
            updateViewChanges.setValue(calendarViewModelImpl.calculateDiff(listItems, list2));
            this.a.setListItems(CollectionsKt___CollectionsKt.toList(list2));
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ CalendarViewModelImpl a;

        public b(CalendarViewModelImpl calendarViewModelImpl) {
            this.a = calendarViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.getErrorChanges().setValue(new v(this));
        }
    }

    public static final class c<T> implements Consumer<Unit> {
        public final /* synthetic */ CalendarViewModelImpl a;

        public c(CalendarViewModelImpl calendarViewModelImpl) {
            this.a = calendarViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            this.a.getCalendarDataSource().onClearSelection();
            CalendarViewModelImpl.access$enableClearButton(this.a, false);
            this.a.f();
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ CalendarViewModelImpl a;

        public d(CalendarViewModelImpl calendarViewModelImpl) {
            this.a = calendarViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.getErrorMessageChanges().postValue(this.a.x.getErrorOccurred());
            this.a.d();
        }
    }

    public static final class e<T> implements Consumer<Date> {
        public final /* synthetic */ CalendarViewModelImpl a;

        public e(CalendarViewModelImpl calendarViewModelImpl) {
            this.a = calendarViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Date date) {
            Date date2 = date;
            CalendarDataSource calendarDataSource = this.a.getCalendarDataSource();
            Intrinsics.checkNotNullExpressionValue(date2, Sort.DATE);
            if (calendarDataSource.onItemSelected(date2)) {
                CalendarViewModelImpl.access$enableClearButton(this.a, true);
                this.a.f();
            }
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public final /* synthetic */ CalendarViewModelImpl a;

        public f(CalendarViewModelImpl calendarViewModelImpl) {
            this.a = calendarViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.getErrorMessageChanges().postValue(this.a.x.getErrorOccurred());
            this.a.e();
        }
    }

    public CalendarViewModelImpl(@NotNull CalendarInteractor calendarInteractor, @NotNull TimeSource timeSource, @NotNull SchedulersFactory schedulersFactory, @NotNull CalendarResourceProvider calendarResourceProvider, @NotNull StrAnalyticsTracker strAnalyticsTracker, @Nullable String str, @NotNull CalendarDataSourceProvider<List<CalendarBookingRestriction>> calendarDataSourceProvider, @NotNull CalendarDataSourceProvider<List<BookingCalendarItem>> calendarDataSourceProvider2, boolean z2) {
        Intrinsics.checkNotNullParameter(calendarInteractor, "interactor");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(calendarResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(strAnalyticsTracker, "strAnalyticsTracker");
        Intrinsics.checkNotNullParameter(calendarDataSourceProvider, "restrictionsDataSourceProvider");
        Intrinsics.checkNotNullParameter(calendarDataSourceProvider2, "calendarItemDataSourceProvider");
        this.u = calendarInteractor;
        this.v = timeSource;
        this.w = schedulersFactory;
        this.x = calendarResourceProvider;
        this.y = strAnalyticsTracker;
        this.z = str;
        this.A = calendarDataSourceProvider;
        this.B = calendarDataSourceProvider2;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.n = compositeDisposable;
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.o = create;
        PublishRelay create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.p = create2;
        PublishRelay create3 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create3, "PublishRelay.create()");
        this.q = create3;
        this.r = create;
        this.s = create2;
        this.t = create3;
        e();
        d();
        Disposable subscribe = create2.throttleFirst(300, TimeUnit.MILLISECONDS).observeOn(schedulersFactory.mainThread()).subscribe(new a0(this), new b0(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "chooseClicksRelay\n      …          }\n            )");
        DisposableKt.addTo(subscribe, compositeDisposable);
        getClearButtonEnableChanges().setValue(Boolean.valueOf(z2));
        getToolbarTitleChanges().setValue("");
        getData();
    }

    public static final void access$enableClearButton(CalendarViewModelImpl calendarViewModelImpl, boolean z2) {
        calendarViewModelImpl.getClearButtonEnableChanges().setValue(Boolean.valueOf(z2));
    }

    public static final void access$onBookingCalendarItemsLoaded(CalendarViewModelImpl calendarViewModelImpl, List list) {
        calendarViewModelImpl.setCalendarDataSource(calendarViewModelImpl.B.getDataSource(list));
        calendarViewModelImpl.c();
    }

    public static final void access$onCalendarRestrictionsLoaded(CalendarViewModelImpl calendarViewModelImpl, List list) {
        calendarViewModelImpl.setCalendarDataSource(calendarViewModelImpl.A.getDataSource(list));
        calendarViewModelImpl.c();
    }

    public final void c() {
        getErrorChanges().setValue(null);
        getProgressChanges().setValue(null);
        Disposable subscribe = getCalendarDataSource().getListItemsObservable().subscribe(new a(this), new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "calendarDataSource.listI…          }\n            )");
        DisposableKt.addTo(subscribe, this.n);
        f();
        DateRange selectedRange = getCalendarDataSource().getSelectedRange();
        if (selectedRange != null) {
            Disposable subscribe2 = Observable.fromCallable(new s(selectedRange, this)).subscribeOn(this.w.io()).observeOn(this.w.mainThread()).subscribe(new t(this), u.a);
            Intrinsics.checkNotNullExpressionValue(subscribe2, "Observable.fromCallable …      }\n                )");
            DisposableKt.addTo(subscribe2, this.n);
        }
    }

    public final void d() {
        Disposable subscribe = this.q.throttleFirst(300, TimeUnit.MILLISECONDS).observeOn(this.w.mainThread()).subscribe(new c(this), new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "clearClicksRelay\n       …          }\n            )");
        DisposableKt.addTo(subscribe, this.n);
    }

    public final void e() {
        Disposable subscribe = this.o.observeOn(this.w.mainThread()).subscribe(new e(this), new f(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "dayClicksRelay\n         …          }\n            )");
        DisposableKt.addTo(subscribe, this.n);
    }

    public final void f() {
        DateRange selectedRange = getCalendarDataSource().getSelectedRange();
        if (selectedRange != null) {
            MutableLiveData<String> toolbarTitleChanges = getToolbarTitleChanges();
            toolbarTitleChanges.setValue(StrDateUtilsKt.convertStrDateToDMMM(selectedRange.getStart()) + " – " + StrDateUtilsKt.convertStrDateToDMMM(selectedRange.getEndInclusive()));
            return;
        }
        Date selectedDate = getCalendarDataSource().getSelectedDate();
        if (selectedDate != null) {
            getToolbarTitleChanges().setValue(StrDateUtilsKt.convertStrDateToDMMMM(selectedDate));
        } else {
            getToolbarTitleChanges().setValue("");
        }
    }

    @Override // com.avito.android.str_calendar.booking.CalendarViewModel
    @NotNull
    public Consumer<Unit> getChooseClicksConsumer() {
        return this.s;
    }

    @Override // com.avito.android.str_calendar.booking.CalendarViewModel
    @NotNull
    public Consumer<Unit> getClearClicksConsumer() {
        return this.t;
    }

    @Override // com.avito.android.str_calendar.calendar.base.BaseCalendarViewModel
    public void getData() {
        String str = this.z;
        if (str != null) {
            Calendar instance = Calendar.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, FormattedDateDisplayingType.TYPE_CALENDAR);
            instance.setTimeInMillis(this.v.now());
            Date time = instance.getTime();
            Intrinsics.checkNotNullExpressionValue(time, "calendar.time");
            Disposable subscribe = this.u.getBookingCalendar(str, StrDateUtilsKt.convertToStrDate(time)).observeOn(this.w.mainThread()).subscribe(new p(this), new r(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.getBookingCal…          }\n            )");
            DisposableKt.addTo(subscribe, this.n);
            return;
        }
        Disposable subscribe2 = CalendarInteractor.DefaultImpls.getDefaultRestrictions$default(this.u, null, null, 0, 7, null).observeOn(this.w.mainThread()).subscribe(new x(this), new z(this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "observeOn(schedulers.mai…          }\n            )");
        DisposableKt.addTo(subscribe2, this.n);
    }

    @Override // com.avito.android.str_calendar.booking.CalendarViewModel
    @NotNull
    public Consumer<Date> getDayClicksConsumer() {
        return this.r;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.n.clear();
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
