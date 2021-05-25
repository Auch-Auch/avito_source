package com.avito.android.str_calendar.seller.calendar;

import a2.a.a.b3.c.a.p;
import a2.a.a.b3.c.a.q;
import a2.a.a.b3.c.a.r;
import a2.a.a.b3.c.a.t;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import com.avito.android.str_calendar.calendar.base.BaseCalendarViewModelImpl;
import com.avito.android.str_calendar.calendar.utils.CalendarUtilsKt;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataSource;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataSourceProvider;
import com.avito.android.str_calendar.seller.calendar.model.SellerCalendarInfo;
import com.avito.android.str_calendar.utils.DateRange;
import com.avito.android.str_calendar.utils.StrDateUtilsKt;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010E\u001a\u00020B\u0012\u0006\u00106\u001a\u000203\u0012\u0006\u0010U\u001a\u00020F\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c\u0012\u0006\u0010l\u001a\u00020i¢\u0006\u0004\bm\u0010nJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0010\u0010\u0005R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\"\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030%8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010\u0014R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00030\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010\u0014R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\"\u00109\u001a\b\u0012\u0004\u0012\u00020\t0\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b7\u0010\u0018\u001a\u0004\b8\u0010\u001aR\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00030\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010\u0014R\"\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00120<8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\"\u0010M\u001a\b\u0012\u0004\u0012\u00020J0\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bK\u0010\u0018\u001a\u0004\bL\u0010\u001aR\"\u0010P\u001a\b\u0012\u0004\u0012\u00020F0\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bN\u0010\u0018\u001a\u0004\bO\u0010\u001aR\"\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00030\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bQ\u0010\u0018\u001a\u0004\bR\u0010\u001aR\u0016\u0010U\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010HR\"\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00030<8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bV\u0010>\u001a\u0004\bW\u0010@R\"\u0010[\u001a\b\u0012\u0004\u0012\u00020\t0\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bY\u0010\u0018\u001a\u0004\bZ\u0010\u001aR\"\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00030<8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\\\u0010>\u001a\u0004\b]\u0010@R\"\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00030<8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b_\u0010>\u001a\u0004\b`\u0010@R\u0018\u0010d\u001a\u0004\u0018\u00010\u00128V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bb\u0010cR\u0016\u0010h\u001a\u00020e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010l\u001a\u00020i8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bj\u0010k¨\u0006o"}, d2 = {"Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarViewModelImpl;", "Lcom/avito/android/str_calendar/calendar/base/BaseCalendarViewModelImpl;", "Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarViewModel;", "", "e", "()V", "d", "f", a2.g.r.g.a, "", "show", "c", "(Z)V", "i", "h", "getData", "onCleared", "Lcom/jakewharton/rxrelay2/Relay;", "Ljava/util/Date;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/jakewharton/rxrelay2/Relay;", "dayClicksRelay", "Landroidx/lifecycle/MutableLiveData;", VKApiConst.Q, "Landroidx/lifecycle/MutableLiveData;", "getShowContentChanges", "()Landroidx/lifecycle/MutableLiveData;", "showContentChanges", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;", "Lcom/avito/android/str_calendar/seller/calendar/model/SellerCalendarInfo;", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;", "calendarDataSourceProvider", "Lcom/avito/android/str_calendar/utils/DateRange;", "getSelectedRange", "()Lcom/avito/android/str_calendar/utils/DateRange;", "selectedRange", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "w", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getOpenEditParametersScreen", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "openEditParametersScreen", "p", "refreshCalendarRelay", "o", "clearClicksRelay", "Lio/reactivex/disposables/Disposable;", "k", "Lio/reactivex/disposables/Disposable;", "calendarDataSourceDisposable", "Lcom/avito/android/util/SchedulersFactory;", "C", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", VKApiConst.VERSION, "getShowEditParamsButton", "showEditParamsButton", "n", "editClicksRelay", "Lio/reactivex/functions/Consumer;", "x", "Lio/reactivex/functions/Consumer;", "getDayClicksConsumer", "()Lio/reactivex/functions/Consumer;", "dayClicksConsumer", "Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarInteractor;", "B", "Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarInteractor;", "interactor", "", "l", "Ljava/lang/String;", "currentDate", "Ljava/lang/Runnable;", "s", "getErrorChanges", "errorChanges", "u", "getToolbarTitleChanges", "toolbarTitleChanges", "r", "getProgressChanges", "progressChanges", "D", BookingInfoActivity.EXTRA_ITEM_ID, "y", "getEditClicksConsumer", "editClicksConsumer", "t", "getShowClearButtonChanges", "showClearButtonChanges", "z", "getClearClicksConsumer", "clearClicksConsumer", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getRefreshCalendarConsumer", "refreshCalendarConsumer", "getSelectedDay", "()Ljava/util/Date;", "selectedDay", "Lio/reactivex/disposables/CompositeDisposable;", "j", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarResourceProvider;", "F", "Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarResourceProvider;", "resourceProvider", "<init>", "(Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarInteractor;Lcom/avito/android/util/SchedulersFactory;Ljava/lang/String;Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarResourceProvider;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class SellerCalendarViewModelImpl extends BaseCalendarViewModelImpl implements SellerCalendarViewModel {
    @NotNull
    public final Consumer<Unit> A;
    public final SellerCalendarInteractor B;
    public final SchedulersFactory C;
    public final String D;
    public final CalendarDataSourceProvider<SellerCalendarInfo> E;
    public final SellerCalendarResourceProvider F;
    public final CompositeDisposable j = new CompositeDisposable();
    public Disposable k;
    public final String l;
    public final Relay<Date> m;
    public final Relay<Unit> n;
    public final Relay<Unit> o;
    public final Relay<Unit> p;
    @NotNull
    public final MutableLiveData<Unit> q;
    @NotNull
    public final MutableLiveData<Unit> r;
    @NotNull
    public final MutableLiveData<Runnable> s;
    @NotNull
    public final MutableLiveData<Boolean> t;
    @NotNull
    public final MutableLiveData<String> u;
    @NotNull
    public final MutableLiveData<Boolean> v;
    @NotNull
    public final SingleLiveEvent<Unit> w;
    @NotNull
    public final Consumer<Date> x;
    @NotNull
    public final Consumer<Unit> y;
    @NotNull
    public final Consumer<Unit> z;

    public static final class a<T> implements Consumer<LoadingState<? super SellerCalendarInfo>> {
        public final /* synthetic */ SellerCalendarViewModelImpl a;

        public a(SellerCalendarViewModelImpl sellerCalendarViewModelImpl) {
            this.a = sellerCalendarViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super SellerCalendarInfo> loadingState) {
            LoadingState<? super SellerCalendarInfo> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                SellerCalendarViewModelImpl.access$onCalendarDataLoaded(this.a, (SellerCalendarInfo) ((LoadingState.Loaded) loadingState2).getData());
            } else if (loadingState2 instanceof LoadingState.Loading) {
                this.a.onCalendarDataLoading();
            } else if (loadingState2 instanceof LoadingState.Error) {
                this.a.onCalendarDataError(new p(this));
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ SellerCalendarViewModelImpl a;

        public b(SellerCalendarViewModelImpl sellerCalendarViewModelImpl) {
            this.a = sellerCalendarViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.onCalendarDataError(new q(this));
        }
    }

    public static final class c<T> implements Consumer<Unit> {
        public final /* synthetic */ SellerCalendarViewModelImpl a;

        public c(SellerCalendarViewModelImpl sellerCalendarViewModelImpl) {
            this.a = sellerCalendarViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            SellerCalendarViewModelImpl.access$clearSelection(this.a);
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ SellerCalendarViewModelImpl a;

        public d(SellerCalendarViewModelImpl sellerCalendarViewModelImpl) {
            this.a = sellerCalendarViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.getErrorMessageChanges().postValue(this.a.F.getErrorOccurred());
            this.a.d();
        }
    }

    public static final class e<T> implements Consumer<Date> {
        public final /* synthetic */ SellerCalendarViewModelImpl a;

        public e(SellerCalendarViewModelImpl sellerCalendarViewModelImpl) {
            this.a = sellerCalendarViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Date date) {
            Date date2 = date;
            CalendarDataSource calendarDataSource = this.a.getCalendarDataSource();
            Intrinsics.checkNotNullExpressionValue(date2, Sort.DATE);
            if (calendarDataSource.onItemSelected(date2)) {
                SellerCalendarViewModelImpl.access$showClearButton(this.a, true);
                this.a.i();
                this.a.h();
            }
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public final /* synthetic */ SellerCalendarViewModelImpl a;

        public f(SellerCalendarViewModelImpl sellerCalendarViewModelImpl) {
            this.a = sellerCalendarViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.getErrorMessageChanges().postValue(this.a.F.getErrorOccurred());
            this.a.e();
        }
    }

    public static final class g<T> implements Consumer<Unit> {
        public final /* synthetic */ SellerCalendarViewModelImpl a;

        public g(SellerCalendarViewModelImpl sellerCalendarViewModelImpl) {
            this.a = sellerCalendarViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            this.a.getOpenEditParametersScreen().postValue(Unit.INSTANCE);
        }
    }

    public static final class h<T> implements Consumer<Throwable> {
        public final /* synthetic */ SellerCalendarViewModelImpl a;

        public h(SellerCalendarViewModelImpl sellerCalendarViewModelImpl) {
            this.a = sellerCalendarViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.getErrorMessageChanges().postValue(this.a.F.getErrorOccurred());
            this.a.f();
        }
    }

    public static final class i<T> implements Consumer<Unit> {
        public final /* synthetic */ SellerCalendarViewModelImpl a;

        public i(SellerCalendarViewModelImpl sellerCalendarViewModelImpl) {
            this.a = sellerCalendarViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            SellerCalendarViewModelImpl.access$clearSelection(this.a);
            this.a.getData();
        }
    }

    public static final class j<T> implements Consumer<Throwable> {
        public final /* synthetic */ SellerCalendarViewModelImpl a;

        public j(SellerCalendarViewModelImpl sellerCalendarViewModelImpl) {
            this.a = sellerCalendarViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.getErrorMessageChanges().postValue(this.a.F.getErrorOccurred());
            this.a.g();
        }
    }

    public SellerCalendarViewModelImpl(@NotNull SellerCalendarInteractor sellerCalendarInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull String str, @NotNull CalendarDataSourceProvider<SellerCalendarInfo> calendarDataSourceProvider, @NotNull SellerCalendarResourceProvider sellerCalendarResourceProvider) {
        Intrinsics.checkNotNullParameter(sellerCalendarInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(calendarDataSourceProvider, "calendarDataSourceProvider");
        Intrinsics.checkNotNullParameter(sellerCalendarResourceProvider, "resourceProvider");
        this.B = sellerCalendarInteractor;
        this.C = schedulersFactory;
        this.D = str;
        this.E = calendarDataSourceProvider;
        this.F = sellerCalendarResourceProvider;
        Date time = CalendarUtilsKt.getCalendar().getTime();
        Intrinsics.checkNotNullExpressionValue(time, "getCalendar().time");
        this.l = StrDateUtilsKt.convertToStrDate(time);
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.m = create;
        PublishRelay create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.n = create2;
        PublishRelay create3 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create3, "PublishRelay.create()");
        this.o = create3;
        PublishRelay create4 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create4, "PublishRelay.create()");
        this.p = create4;
        this.q = new MutableLiveData<>();
        this.r = new MutableLiveData<>();
        this.s = new MutableLiveData<>();
        this.t = new MutableLiveData<>();
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue("");
        this.u = mutableLiveData;
        this.v = new MutableLiveData<>();
        this.w = new SingleLiveEvent<>();
        this.x = create;
        this.y = create2;
        this.z = create3;
        this.A = create4;
        e();
        f();
        d();
        g();
        c(false);
        getData();
    }

    public static final void access$clearSelection(SellerCalendarViewModelImpl sellerCalendarViewModelImpl) {
        sellerCalendarViewModelImpl.getCalendarDataSource().onClearSelection();
        sellerCalendarViewModelImpl.c(false);
        sellerCalendarViewModelImpl.i();
        sellerCalendarViewModelImpl.h();
    }

    public static final void access$onCalendarDataLoaded(SellerCalendarViewModelImpl sellerCalendarViewModelImpl, SellerCalendarInfo sellerCalendarInfo) {
        sellerCalendarViewModelImpl.getErrorChanges().setValue(null);
        sellerCalendarViewModelImpl.getProgressChanges().setValue(null);
        sellerCalendarViewModelImpl.setCalendarDataSource(sellerCalendarViewModelImpl.E.getDataSource(sellerCalendarInfo));
        sellerCalendarViewModelImpl.k = sellerCalendarViewModelImpl.getCalendarDataSource().getListItemsObservable().subscribe(new r(sellerCalendarViewModelImpl), new t(sellerCalendarViewModelImpl));
    }

    public static final void access$showClearButton(SellerCalendarViewModelImpl sellerCalendarViewModelImpl, boolean z2) {
        sellerCalendarViewModelImpl.getShowClearButtonChanges().setValue(Boolean.valueOf(z2));
    }

    public final void c(boolean z2) {
        getShowClearButtonChanges().setValue(Boolean.valueOf(z2));
    }

    public final void d() {
        Disposable subscribe = this.o.throttleFirst(300, TimeUnit.MILLISECONDS).observeOn(this.C.mainThread()).subscribe(new c(this), new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "clearClicksRelay\n       …          }\n            )");
        DisposableKt.addTo(subscribe, this.j);
    }

    public final void e() {
        Disposable subscribe = this.m.observeOn(this.C.mainThread()).subscribe(new e(this), new f(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "dayClicksRelay\n         …          }\n            )");
        DisposableKt.addTo(subscribe, this.j);
    }

    public final void f() {
        Disposable subscribe = this.n.throttleFirst(1, TimeUnit.SECONDS).subscribe(new g(this), new h(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "editClicksRelay\n        …          }\n            )");
        DisposableKt.addTo(subscribe, this.j);
    }

    public final void g() {
        Disposable subscribe = this.p.subscribe(new i(this), new j(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "refreshCalendarRelay\n   …          }\n            )");
        DisposableKt.addTo(subscribe, this.j);
    }

    @Override // com.avito.android.str_calendar.seller.calendar.SellerCalendarViewModel
    @NotNull
    public Consumer<Unit> getClearClicksConsumer() {
        return this.z;
    }

    @Override // com.avito.android.str_calendar.calendar.base.BaseCalendarViewModel
    public void getData() {
        Disposable subscribe = this.B.getSellerCalendar(this.D, this.l).observeOn(this.C.mainThread()).subscribe(new a(this), new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.getSellerCale…          }\n            )");
        DisposableKt.addTo(subscribe, this.j);
    }

    @Override // com.avito.android.str_calendar.seller.calendar.SellerCalendarViewModel
    @NotNull
    public Consumer<Date> getDayClicksConsumer() {
        return this.x;
    }

    @Override // com.avito.android.str_calendar.seller.calendar.SellerCalendarViewModel
    @NotNull
    public Consumer<Unit> getEditClicksConsumer() {
        return this.y;
    }

    @Override // com.avito.android.str_calendar.seller.calendar.SellerCalendarViewModel
    @NotNull
    public Consumer<Unit> getRefreshCalendarConsumer() {
        return this.A;
    }

    @Override // com.avito.android.str_calendar.seller.calendar.SellerCalendarViewModel
    @Nullable
    public Date getSelectedDay() {
        return getCalendarDataSource().getSelectedDate();
    }

    @Override // com.avito.android.str_calendar.seller.calendar.SellerCalendarViewModel
    @Nullable
    public DateRange getSelectedRange() {
        return getCalendarDataSource().getSelectedRange();
    }

    public final void h() {
        getShowEditParamsButton().setValue(Boolean.valueOf((getCalendarDataSource().getSelectedDate() == null && getCalendarDataSource().getSelectedRange() == null) ? false : true));
    }

    public final void i() {
        DateRange selectedRange = getCalendarDataSource().getSelectedRange();
        if (selectedRange != null) {
            getToolbarTitleChanges().setValue(StrDateUtilsKt.getTitle(selectedRange));
            return;
        }
        Date selectedDate = getCalendarDataSource().getSelectedDate();
        if (selectedDate != null) {
            getToolbarTitleChanges().setValue(StrDateUtilsKt.convertStrDateToDMMMM(selectedDate));
        } else {
            getToolbarTitleChanges().setValue("");
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.k;
        if (disposable != null) {
            disposable.dispose();
        }
        this.j.clear();
    }

    @Override // com.avito.android.str_calendar.calendar.base.BaseCalendarViewModelImpl, com.avito.android.str_calendar.calendar.base.BaseCalendarViewModel
    @NotNull
    public MutableLiveData<Runnable> getErrorChanges() {
        return this.s;
    }

    @Override // com.avito.android.str_calendar.seller.calendar.SellerCalendarViewModel
    @NotNull
    public SingleLiveEvent<Unit> getOpenEditParametersScreen() {
        return this.w;
    }

    @Override // com.avito.android.str_calendar.calendar.base.BaseCalendarViewModelImpl, com.avito.android.str_calendar.calendar.base.BaseCalendarViewModel
    @NotNull
    public MutableLiveData<Unit> getProgressChanges() {
        return this.r;
    }

    @Override // com.avito.android.str_calendar.seller.calendar.SellerCalendarViewModel
    @NotNull
    public MutableLiveData<Boolean> getShowClearButtonChanges() {
        return this.t;
    }

    @Override // com.avito.android.str_calendar.calendar.base.BaseCalendarViewModelImpl, com.avito.android.str_calendar.calendar.base.BaseCalendarViewModel
    @NotNull
    public MutableLiveData<Unit> getShowContentChanges() {
        return this.q;
    }

    @Override // com.avito.android.str_calendar.seller.calendar.SellerCalendarViewModel
    @NotNull
    public MutableLiveData<Boolean> getShowEditParamsButton() {
        return this.v;
    }

    @Override // com.avito.android.str_calendar.seller.calendar.SellerCalendarViewModel
    @NotNull
    public MutableLiveData<String> getToolbarTitleChanges() {
        return this.u;
    }
}
