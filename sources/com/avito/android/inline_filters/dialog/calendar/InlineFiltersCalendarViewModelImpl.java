package com.avito.android.inline_filters.dialog.calendar;

import a2.a.a.g1.e.b.g;
import a2.a.a.g1.e.b.h;
import a2.a.a.g1.e.b.i;
import a2.a.a.g1.e.b.j;
import a2.a.a.g1.e.b.l;
import a2.a.a.g1.e.b.n;
import a2.a.a.g1.e.b.p;
import a2.a.a.g1.e.b.q;
import a2.a.a.g1.e.b.r;
import androidx.lifecycle.MutableLiveData;
import com.avito.android.inline_filters.dialog.calendar.InlineFiltersCalendarViewModel;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilterValue;
import com.avito.android.str_calendar.booking.CalendarInteractor;
import com.avito.android.str_calendar.booking.CalendarResourceProvider;
import com.avito.android.str_calendar.booking.model.CalendarBookingRestriction;
import com.avito.android.str_calendar.calendar.base.BaseCalendarViewModelImpl;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataSource;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataSourceProvider;
import com.avito.android.str_calendar.utils.DateRange;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002BO\u0012\u0006\u0010E\u001a\u00020B\u0012\u0006\u0010Q\u001a\u00020N\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0012\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0I0H\u0012\b\u0010X\u001a\u0004\u0018\u00010W\u0012\b\u0010Z\u001a\u0004\u0018\u00010Y\u0012\u0006\u0010[\u001a\u00020:¢\u0006\u0004\b\\\u0010]J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\f\u0010\u0005R\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\"\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b'\u0010\u0014\u001a\u0004\b(\u0010\u0016R\u0016\u0010,\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\"\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030\u00188\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b-\u0010\u001b\u001a\u0004\b.\u0010\u001dR\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\"\u00109\u001a\b\u0012\u0004\u0012\u00020\u0007048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\"\u0010=\u001a\b\u0012\u0004\u0012\u00020:048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b;\u00106\u001a\u0004\b<\u00108R\"\u0010A\u001a\b\u0012\u0004\u0012\u00020>0\u00188\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b?\u0010\u001b\u001a\u0004\b@\u0010\u001dR\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u001c\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00030\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010\u0010R\"\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0I0H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\"\u0010T\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bR\u0010\u0014\u001a\u0004\bS\u0010\u0016R\u001c\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00030\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010\u0010¨\u0006^"}, d2 = {"Lcom/avito/android/inline_filters/dialog/calendar/InlineFiltersCalendarViewModelImpl;", "Lcom/avito/android/str_calendar/calendar/base/BaseCalendarViewModelImpl;", "Lcom/avito/android/inline_filters/dialog/calendar/InlineFiltersCalendarViewModel;", "", "e", "()V", "d", "", "enable", "c", "(Z)V", "getData", "onCleared", "Lcom/jakewharton/rxrelay2/Relay;", "Ljava/util/Date;", "p", "Lcom/jakewharton/rxrelay2/Relay;", "dayClicksRelay", "Lio/reactivex/functions/Consumer;", "t", "Lio/reactivex/functions/Consumer;", "getChooseClicksConsumer", "()Lio/reactivex/functions/Consumer;", "chooseClicksConsumer", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/str_calendar/utils/DateRange;", "j", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getDatesChosenChanges", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "datesChosenChanges", "Lcom/avito/android/str_calendar/booking/CalendarResourceProvider;", "y", "Lcom/avito/android/str_calendar/booking/CalendarResourceProvider;", "resourceProvider", "Lcom/avito/android/inline_filters/dialog/calendar/InlineFiltersCalendarViewModel$Dates;", "getCurrentDates", "()Lcom/avito/android/inline_filters/dialog/calendar/InlineFiltersCalendarViewModel$Dates;", "currentDates", "u", "getClearClicksConsumer", "clearClicksConsumer", VKApiConst.VERSION, "Z", "canClear", "n", "getEmptyDatesSelected", "emptyDatesSelected", "Lio/reactivex/disposables/CompositeDisposable;", "o", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Landroidx/lifecycle/MutableLiveData;", "k", "Landroidx/lifecycle/MutableLiveData;", "getClearButtonEnableChanges", "()Landroidx/lifecycle/MutableLiveData;", "clearButtonEnableChanges", "", "l", "getToolbarTitleChanges", "toolbarTitleChanges", "", AuthSource.OPEN_CHANNEL_LIST, "getScrollToChanges", "scrollToChanges", "Lcom/avito/android/str_calendar/booking/CalendarInteractor;", "w", "Lcom/avito/android/str_calendar/booking/CalendarInteractor;", "interactor", VKApiConst.Q, "chooseClicksRelay", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;", "", "Lcom/avito/android/str_calendar/booking/model/CalendarBookingRestriction;", "z", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;", "restrictionsDataSourceProvider", "Lcom/avito/android/util/SchedulersFactory;", "x", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "s", "getDayClicksConsumer", "dayClicksConsumer", "r", "clearClicksRelay", "Lcom/avito/android/remote/model/search/Filter$Widget;", "widget", "Lcom/avito/android/remote/model/search/InlineFilterValue$InlineFilterDateRangeValue;", "value", "title", "<init>", "(Lcom/avito/android/str_calendar/booking/CalendarInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/str_calendar/booking/CalendarResourceProvider;Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;Lcom/avito/android/remote/model/search/Filter$Widget;Lcom/avito/android/remote/model/search/InlineFilterValue$InlineFilterDateRangeValue;Ljava/lang/String;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class InlineFiltersCalendarViewModelImpl extends BaseCalendarViewModelImpl implements InlineFiltersCalendarViewModel {
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
    public boolean v;
    public final CalendarInteractor w;
    public final SchedulersFactory x;
    public final CalendarResourceProvider y;
    public final CalendarDataSourceProvider<List<CalendarBookingRestriction>> z;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ InlineFiltersCalendarViewModelImpl a;

        public a(InlineFiltersCalendarViewModelImpl inlineFiltersCalendarViewModelImpl) {
            this.a = inlineFiltersCalendarViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            this.a.getCalendarDataSource().onClearSelection();
            this.a.c(false);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ InlineFiltersCalendarViewModelImpl a;

        public b(InlineFiltersCalendarViewModelImpl inlineFiltersCalendarViewModelImpl) {
            this.a = inlineFiltersCalendarViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.getErrorMessageChanges().postValue(this.a.y.getErrorOccurred());
            this.a.d();
        }
    }

    public static final class c<T> implements Consumer<Date> {
        public final /* synthetic */ InlineFiltersCalendarViewModelImpl a;

        public c(InlineFiltersCalendarViewModelImpl inlineFiltersCalendarViewModelImpl) {
            this.a = inlineFiltersCalendarViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Date date) {
            Date date2 = date;
            CalendarDataSource calendarDataSource = this.a.getCalendarDataSource();
            Intrinsics.checkNotNullExpressionValue(date2, Sort.DATE);
            if (calendarDataSource.onItemSelected(date2)) {
                this.a.c(true);
            }
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ InlineFiltersCalendarViewModelImpl a;

        public d(InlineFiltersCalendarViewModelImpl inlineFiltersCalendarViewModelImpl) {
            this.a = inlineFiltersCalendarViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.getErrorMessageChanges().postValue(this.a.y.getErrorOccurred());
            this.a.e();
        }
    }

    public InlineFiltersCalendarViewModelImpl(@NotNull CalendarInteractor calendarInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull CalendarResourceProvider calendarResourceProvider, @NotNull CalendarDataSourceProvider<List<CalendarBookingRestriction>> calendarDataSourceProvider, @Nullable Filter.Widget widget, @Nullable InlineFilterValue.InlineFilterDateRangeValue inlineFilterDateRangeValue, @NotNull String str) {
        Intrinsics.checkNotNullParameter(calendarInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(calendarResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(calendarDataSourceProvider, "restrictionsDataSourceProvider");
        Intrinsics.checkNotNullParameter(str, "title");
        this.w = calendarInteractor;
        this.x = schedulersFactory;
        this.y = calendarResourceProvider;
        this.z = calendarDataSourceProvider;
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
        boolean z2 = true;
        this.v = true;
        Date date = null;
        this.v = !Intrinsics.areEqual(widget != null ? widget.getResetDisabled() : null, Boolean.TRUE);
        z2 = ((inlineFilterDateRangeValue != null ? inlineFilterDateRangeValue.getFrom() : date) == null || inlineFilterDateRangeValue.getTo() == null) ? false : z2;
        e();
        d();
        Disposable subscribe = create2.throttleFirst(300, TimeUnit.MILLISECONDS).observeOn(schedulersFactory.mainThread()).subscribe(new q(this), new r(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "chooseClicksRelay\n      …          }\n            )");
        DisposableKt.addTo(subscribe, compositeDisposable);
        c(z2);
        getToolbarTitleChanges().setValue(str);
        getData();
    }

    public static final void access$onCalendarRestrictionsLoaded(InlineFiltersCalendarViewModelImpl inlineFiltersCalendarViewModelImpl, List list) {
        inlineFiltersCalendarViewModelImpl.setCalendarDataSource(inlineFiltersCalendarViewModelImpl.z.getDataSource(list));
        inlineFiltersCalendarViewModelImpl.getErrorChanges().setValue(null);
        inlineFiltersCalendarViewModelImpl.getProgressChanges().setValue(null);
        Disposable subscribe = inlineFiltersCalendarViewModelImpl.getCalendarDataSource().getListItemsObservable().subscribe(new j(inlineFiltersCalendarViewModelImpl), new l(inlineFiltersCalendarViewModelImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "calendarDataSource.listI…          }\n            )");
        DisposableKt.addTo(subscribe, inlineFiltersCalendarViewModelImpl.o);
        DateRange selectedRange = inlineFiltersCalendarViewModelImpl.getCalendarDataSource().getSelectedRange();
        if (selectedRange != null) {
            Disposable subscribe2 = Observable.fromCallable(new g(selectedRange, inlineFiltersCalendarViewModelImpl)).subscribeOn(inlineFiltersCalendarViewModelImpl.x.io()).observeOn(inlineFiltersCalendarViewModelImpl.x.mainThread()).subscribe(new h(inlineFiltersCalendarViewModelImpl), i.a);
            Intrinsics.checkNotNullExpressionValue(subscribe2, "Observable.fromCallable …      }\n                )");
            DisposableKt.addTo(subscribe2, inlineFiltersCalendarViewModelImpl.o);
        }
    }

    public final void c(boolean z2) {
        getClearButtonEnableChanges().setValue(Boolean.valueOf(this.v && z2));
    }

    public final void d() {
        Disposable subscribe = this.r.throttleFirst(300, TimeUnit.MILLISECONDS).observeOn(this.x.mainThread()).subscribe(new a(this), new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "clearClicksRelay\n       …          }\n            )");
        DisposableKt.addTo(subscribe, this.o);
    }

    public final void e() {
        Disposable subscribe = this.p.observeOn(this.x.mainThread()).subscribe(new c(this), new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "dayClicksRelay\n         …          }\n            )");
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

    @Override // com.avito.android.inline_filters.dialog.calendar.InlineFiltersCalendarViewModel
    @NotNull
    public InlineFiltersCalendarViewModel.Dates getCurrentDates() {
        Date selectedDate = getCalendarDataSource().getSelectedDate();
        DateRange selectedRange = getCalendarDataSource().getSelectedRange();
        if (selectedRange != null) {
            return new InlineFiltersCalendarViewModel.Dates(selectedRange.getStart(), selectedRange.getEndInclusive());
        }
        if (selectedDate != null) {
            return new InlineFiltersCalendarViewModel.Dates(selectedDate, null);
        }
        return new InlineFiltersCalendarViewModel.Dates(null, null);
    }

    @Override // com.avito.android.str_calendar.calendar.base.BaseCalendarViewModel
    public void getData() {
        Disposable subscribe = CalendarInteractor.DefaultImpls.getDefaultRestrictions$default(this.w, null, null, 0, 7, null).observeOn(this.x.mainThread()).subscribe(new n(this), new p(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "observeOn(schedulers.mai…          }\n            )");
        DisposableKt.addTo(subscribe, this.o);
    }

    @Override // com.avito.android.str_calendar.booking.CalendarViewModel
    @NotNull
    public Consumer<Date> getDayClicksConsumer() {
        return this.s;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.o.clear();
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

    @Override // com.avito.android.inline_filters.dialog.calendar.InlineFiltersCalendarViewModel
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
