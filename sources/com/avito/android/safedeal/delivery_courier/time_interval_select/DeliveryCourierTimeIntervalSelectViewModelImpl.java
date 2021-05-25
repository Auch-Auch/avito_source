package com.avito.android.safedeal.delivery_courier.time_interval_select;

import a2.a.a.i2.a.c.e;
import a2.a.a.i2.a.c.f;
import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.delivery_courier.DeliveryCourierTimeIntervals;
import com.avito.android.remote.model.delivery_courier.TimeInterval;
import com.avito.android.safedeal.delivery_courier.time_interval_select.konveyor.time_interval.TimeIntervalItem;
import com.avito.android.safedeal.delivery_courier.time_interval_select.model.DialogData;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010>\u001a\u00020*\u0012\b\u0010A\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010M\u001a\u00020J\u0012\u0006\u0010E\u001a\u00020B\u0012\u0006\u0010I\u001a\u00020F\u0012\u0006\u0010)\u001a\u00020&¢\u0006\u0004\bN\u0010OJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000e\u001a\u00020\r*\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0014\u0010\u0005R\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR(\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u001d0\u001c8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\"\u00102\u001a\b\u0012\u0004\u0012\u00020\u00030.8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010/\u001a\u0004\b0\u00101R\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u0016038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\"\u00108\u001a\b\u0012\u0004\u0012\u00020\u000b0.8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010/\u001a\u0004\b7\u00101R\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020\u0007098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010,R\u0018\u0010A\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010L¨\u0006P"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectViewModel;", "", "e", "()V", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierTimeIntervals$ScreenData;", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/model/DialogData;", "c", "(Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierTimeIntervals$ScreenData;)Lcom/avito/android/safedeal/delivery_courier/time_interval_select/model/DialogData;", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierTimeIntervals$Item;", "Lcom/avito/android/remote/model/delivery_courier/TimeInterval;", "selected", "", "d", "(Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierTimeIntervals$Item;Lcom/avito/android/remote/model/delivery_courier/TimeInterval;)Z", "", FirebaseAnalytics.Param.INDEX, "onDialogDismissed", "(I)V", "onCleared", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/konveyor/time_interval/TimeIntervalItem;", g.a, "Lio/reactivex/functions/Consumer;", "getSelectedItemConsumer", "()Lio/reactivex/functions/Consumer;", "selectedItemConsumer", "Landroidx/lifecycle/MutableLiveData;", "", "Landroidx/lifecycle/MutableLiveData;", "getShowDialogChanges", "()Landroidx/lifecycle/MutableLiveData;", "showDialogChanges", "Lio/reactivex/disposables/CompositeDisposable;", "i", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectAnalyticsTracker;", "p", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectAnalyticsTracker;", "tracker", "", "j", "Ljava/lang/String;", "orderID", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getTimeIntervalSelectErrorChanges", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "timeIntervalSelectErrorChanges", "Lcom/jakewharton/rxrelay2/Relay;", "f", "Lcom/jakewharton/rxrelay2/Relay;", "selectedItemRelay", "getTimeIntervalSelectedChanges", "timeIntervalSelectedChanges", "", "h", "Ljava/util/List;", "shownDialogs", "k", "source", "l", "Lcom/avito/android/remote/model/delivery_courier/TimeInterval;", "selectedTimeInterval", "Lcom/avito/android/util/SchedulersFactory;", "n", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectResourceProvider;", "o", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectResourceProvider;", "resourceProvider", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectInteractor;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectInteractor;", "interactor", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/delivery_courier/TimeInterval;Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectResourceProvider;Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectAnalyticsTracker;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryCourierTimeIntervalSelectViewModelImpl extends ViewModel implements DeliveryCourierTimeIntervalSelectViewModel {
    @NotNull
    public final SingleLiveEvent<TimeInterval> c = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<Unit> d = new SingleLiveEvent<>();
    @NotNull
    public final MutableLiveData<List<DialogData>> e = new MutableLiveData<>();
    public final Relay<TimeIntervalItem> f;
    @NotNull
    public final Consumer<TimeIntervalItem> g;
    public final List<DialogData> h;
    public final CompositeDisposable i;
    public final String j;
    public final String k;
    public TimeInterval l;
    public final DeliveryCourierTimeIntervalSelectInteractor m;
    public final SchedulersFactory n;
    public final DeliveryCourierTimeIntervalSelectResourceProvider o;
    public final DeliveryCourierTimeIntervalSelectAnalyticsTracker p;

    public static final class a<T> implements Consumer<TimeIntervalItem> {
        public final /* synthetic */ DeliveryCourierTimeIntervalSelectViewModelImpl a;

        public a(DeliveryCourierTimeIntervalSelectViewModelImpl deliveryCourierTimeIntervalSelectViewModelImpl) {
            this.a = deliveryCourierTimeIntervalSelectViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(TimeIntervalItem timeIntervalItem) {
            TimeIntervalItem timeIntervalItem2 = timeIntervalItem;
            if (timeIntervalItem2 != null) {
                DeliveryCourierTimeIntervals.ScreenData nestedScreenData = timeIntervalItem2.getNestedScreenData();
                if (nestedScreenData == null) {
                    DeliveryCourierTimeIntervals.Data data = timeIntervalItem2.getData();
                    String str = null;
                    String title = data != null ? data.getTitle() : null;
                    DeliveryCourierTimeIntervals.Data data2 = timeIntervalItem2.getData();
                    String startDate = data2 != null ? data2.getStartDate() : null;
                    DeliveryCourierTimeIntervals.Data data3 = timeIntervalItem2.getData();
                    if (data3 != null) {
                        str = data3.getEndDate();
                    }
                    if (title == null || startDate == null || str == null) {
                        DeliveryCourierTimeIntervalSelectViewModelImpl.access$onTimeIntervalSelectBadData(this.a);
                    } else {
                        DeliveryCourierTimeIntervalSelectViewModelImpl.access$onTimeIntervalSelected(this.a, title, startDate, str);
                    }
                } else {
                    DeliveryCourierTimeIntervalSelectViewModelImpl.access$showNestedData(this.a, nestedScreenData);
                }
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ DeliveryCourierTimeIntervalSelectViewModelImpl a;

        public b(DeliveryCourierTimeIntervalSelectViewModelImpl deliveryCourierTimeIntervalSelectViewModelImpl) {
            this.a = deliveryCourierTimeIntervalSelectViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.h.add(new DialogData.Error(this.a.o.getUnknownError()));
            this.a.getShowDialogChanges().postValue(this.a.h);
            this.a.p.trackTimeIntervalSelectFailed();
            this.a.e();
        }
    }

    public DeliveryCourierTimeIntervalSelectViewModelImpl(@NotNull String str, @NotNull String str2, @Nullable TimeInterval timeInterval, @NotNull DeliveryCourierTimeIntervalSelectInteractor deliveryCourierTimeIntervalSelectInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull DeliveryCourierTimeIntervalSelectResourceProvider deliveryCourierTimeIntervalSelectResourceProvider, @NotNull DeliveryCourierTimeIntervalSelectAnalyticsTracker deliveryCourierTimeIntervalSelectAnalyticsTracker) {
        Intrinsics.checkNotNullParameter(str, "orderID");
        Intrinsics.checkNotNullParameter(str2, "source");
        Intrinsics.checkNotNullParameter(deliveryCourierTimeIntervalSelectInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(deliveryCourierTimeIntervalSelectResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(deliveryCourierTimeIntervalSelectAnalyticsTracker, "tracker");
        this.j = str;
        this.k = str2;
        this.l = timeInterval;
        this.m = deliveryCourierTimeIntervalSelectInteractor;
        this.n = schedulersFactory;
        this.o = deliveryCourierTimeIntervalSelectResourceProvider;
        this.p = deliveryCourierTimeIntervalSelectAnalyticsTracker;
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.f = create;
        this.g = create;
        this.h = new ArrayList();
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.i = compositeDisposable;
        e();
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "Calendar.getInstance()");
        TimeZone timeZone = instance.getTimeZone();
        Intrinsics.checkNotNullExpressionValue(timeZone, "Calendar.getInstance().timeZone");
        String id = timeZone.getID();
        Intrinsics.checkNotNullExpressionValue(id, "Calendar.getInstance().timeZone.id");
        Disposable subscribe = deliveryCourierTimeIntervalSelectInteractor.getTimeIntervals(str, str2, id).subscribe(new e(this), new f(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.getTimeInterv…          }\n            )");
        DisposableKt.addTo(subscribe, compositeDisposable);
    }

    public static final void access$onTimeIntervalSelectBadData(DeliveryCourierTimeIntervalSelectViewModelImpl deliveryCourierTimeIntervalSelectViewModelImpl) {
        deliveryCourierTimeIntervalSelectViewModelImpl.getTimeIntervalSelectErrorChanges().postValue(Unit.INSTANCE);
        deliveryCourierTimeIntervalSelectViewModelImpl.p.trackTimeIntervalSelectBadData();
    }

    public static final void access$onTimeIntervalSelected(DeliveryCourierTimeIntervalSelectViewModelImpl deliveryCourierTimeIntervalSelectViewModelImpl, String str, String str2, String str3) {
        deliveryCourierTimeIntervalSelectViewModelImpl.getTimeIntervalSelectedChanges().postValue(new TimeInterval(str, str2, str3));
    }

    public static final void access$onTimeIntervalsError(DeliveryCourierTimeIntervalSelectViewModelImpl deliveryCourierTimeIntervalSelectViewModelImpl, TypedError typedError) {
        deliveryCourierTimeIntervalSelectViewModelImpl.h.clear();
        deliveryCourierTimeIntervalSelectViewModelImpl.h.add(new DialogData.Error(typedError instanceof ErrorWithMessage ? ((ErrorWithMessage) typedError).getMessage() : deliveryCourierTimeIntervalSelectViewModelImpl.o.getNetworkError()));
        deliveryCourierTimeIntervalSelectViewModelImpl.getShowDialogChanges().postValue(deliveryCourierTimeIntervalSelectViewModelImpl.h);
    }

    public static final void access$onTimeIntervalsLoaded(DeliveryCourierTimeIntervalSelectViewModelImpl deliveryCourierTimeIntervalSelectViewModelImpl, DeliveryCourierTimeIntervals deliveryCourierTimeIntervals) {
        deliveryCourierTimeIntervalSelectViewModelImpl.h.clear();
        DeliveryCourierTimeIntervals.ScreenData screenData = deliveryCourierTimeIntervals.getScreenData();
        if (screenData != null) {
            deliveryCourierTimeIntervalSelectViewModelImpl.h.add(deliveryCourierTimeIntervalSelectViewModelImpl.c(screenData));
        } else {
            deliveryCourierTimeIntervalSelectViewModelImpl.h.add(new DialogData.Error(deliveryCourierTimeIntervalSelectViewModelImpl.o.getNetworkError()));
        }
        deliveryCourierTimeIntervalSelectViewModelImpl.getShowDialogChanges().postValue(deliveryCourierTimeIntervalSelectViewModelImpl.h);
    }

    public static final void access$onTimeIntervalsLoading(DeliveryCourierTimeIntervalSelectViewModelImpl deliveryCourierTimeIntervalSelectViewModelImpl) {
        deliveryCourierTimeIntervalSelectViewModelImpl.h.clear();
        deliveryCourierTimeIntervalSelectViewModelImpl.h.add(DialogData.Loading.INSTANCE);
        deliveryCourierTimeIntervalSelectViewModelImpl.getShowDialogChanges().postValue(deliveryCourierTimeIntervalSelectViewModelImpl.h);
    }

    public static final void access$showNestedData(DeliveryCourierTimeIntervalSelectViewModelImpl deliveryCourierTimeIntervalSelectViewModelImpl, DeliveryCourierTimeIntervals.ScreenData screenData) {
        deliveryCourierTimeIntervalSelectViewModelImpl.h.add(deliveryCourierTimeIntervalSelectViewModelImpl.c(screenData));
        deliveryCourierTimeIntervalSelectViewModelImpl.getShowDialogChanges().postValue(deliveryCourierTimeIntervalSelectViewModelImpl.h);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x004e */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.ArrayList] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.avito.android.safedeal.delivery_courier.time_interval_select.model.DialogData c(com.avito.android.remote.model.delivery_courier.DeliveryCourierTimeIntervals.ScreenData r13) {
        /*
            r12 = this;
            com.avito.android.safedeal.delivery_courier.time_interval_select.model.DialogData$Normal r0 = new com.avito.android.safedeal.delivery_courier.time_interval_select.model.DialogData$Normal
            java.lang.String r1 = r13.getTitle()
            if (r1 == 0) goto L_0x0009
            goto L_0x000b
        L_0x0009:
            java.lang.String r1 = ""
        L_0x000b:
            java.util.List r13 = r13.getItems()
            r2 = 0
            if (r13 == 0) goto L_0x004a
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r13 = r13.iterator()
        L_0x001b:
            boolean r4 = r13.hasNext()
            if (r4 == 0) goto L_0x004e
            java.lang.Object r4 = r13.next()
            com.avito.android.remote.model.delivery_courier.DeliveryCourierTimeIntervals$Item r4 = (com.avito.android.remote.model.delivery_courier.DeliveryCourierTimeIntervals.Item) r4
            java.lang.String r7 = r4.getTitle()
            if (r7 == 0) goto L_0x0043
            com.avito.android.safedeal.delivery_courier.time_interval_select.konveyor.time_interval.TimeIntervalItem r11 = new com.avito.android.safedeal.delivery_courier.time_interval_select.konveyor.time_interval.TimeIntervalItem
            com.avito.android.remote.model.delivery_courier.DeliveryCourierTimeIntervals$ScreenData r8 = r4.getNestedScreenData()
            com.avito.android.remote.model.delivery_courier.DeliveryCourierTimeIntervals$Data r9 = r4.getData()
            com.avito.android.remote.model.delivery_courier.TimeInterval r5 = r12.l
            boolean r10 = r12.d(r4, r5)
            r5 = r11
            r6 = r7
            r5.<init>(r6, r7, r8, r9, r10)
            goto L_0x0044
        L_0x0043:
            r11 = r2
        L_0x0044:
            if (r11 == 0) goto L_0x001b
            r3.add(r11)
            goto L_0x001b
        L_0x004a:
            java.util.List r3 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x004e:
            java.util.List<com.avito.android.safedeal.delivery_courier.time_interval_select.model.DialogData> r13 = r12.h
            int r13 = r13.size()
            if (r13 <= 0) goto L_0x005c
            int r13 = com.avito.android.ui_components.R.drawable.ic_back_bottom_sheet_ripple
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
        L_0x005c:
            r0.<init>(r1, r3, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectViewModelImpl.c(com.avito.android.remote.model.delivery_courier.DeliveryCourierTimeIntervals$ScreenData):com.avito.android.safedeal.delivery_courier.time_interval_select.model.DialogData");
    }

    public final boolean d(DeliveryCourierTimeIntervals.Item item, TimeInterval timeInterval) {
        if (timeInterval == null) {
            return false;
        }
        DeliveryCourierTimeIntervals.ScreenData nestedScreenData = item.getNestedScreenData();
        Object obj = null;
        if (nestedScreenData != null) {
            List<DeliveryCourierTimeIntervals.Item> items = nestedScreenData.getItems();
            if (items != null) {
                Iterator<T> it = items.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    T next = it.next();
                    if (d(next, timeInterval)) {
                        obj = next;
                        break;
                    }
                }
                obj = (DeliveryCourierTimeIntervals.Item) obj;
            }
            if (obj != null) {
                return true;
            }
            return false;
        }
        DeliveryCourierTimeIntervals.Data data = item.getData();
        if (!Intrinsics.areEqual(data != null ? data.getTitle() : null, timeInterval.getTitle())) {
            return false;
        }
        DeliveryCourierTimeIntervals.Data data2 = item.getData();
        if (!Intrinsics.areEqual(data2 != null ? data2.getStartDate() : null, timeInterval.getStartDate())) {
            return false;
        }
        DeliveryCourierTimeIntervals.Data data3 = item.getData();
        if (data3 != null) {
            obj = data3.getEndDate();
        }
        if (Intrinsics.areEqual(obj, timeInterval.getEndDate())) {
            return true;
        }
        return false;
    }

    public final void e() {
        Disposable subscribe = this.f.observeOn(this.n.mainThread()).throttleFirst(500, TimeUnit.MILLISECONDS).subscribe(new a(this), new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "selectedItemRelay\n      …          }\n            )");
        DisposableKt.addTo(subscribe, this.i);
    }

    @Override // com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectViewModel
    @NotNull
    public Consumer<TimeIntervalItem> getSelectedItemConsumer() {
        return this.g;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.i.dispose();
    }

    @Override // com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectViewModel
    public void onDialogDismissed(int i2) {
        this.h.remove(i2);
    }

    @Override // com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectViewModel
    @NotNull
    public MutableLiveData<List<DialogData>> getShowDialogChanges() {
        return this.e;
    }

    @Override // com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectViewModel
    @NotNull
    public SingleLiveEvent<Unit> getTimeIntervalSelectErrorChanges() {
        return this.d;
    }

    @Override // com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectViewModel
    @NotNull
    public SingleLiveEvent<TimeInterval> getTimeIntervalSelectedChanges() {
        return this.c;
    }
}
